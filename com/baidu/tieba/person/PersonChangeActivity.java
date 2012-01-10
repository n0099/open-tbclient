package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.PersonChangeModel;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.write.WriteUtil;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity {
    public static final String TAG_DATA = "data";
    private AlertDialog mSelectImageDialog = null;
    private ImageView mImageView = null;
    private Button mBack = null;
    private Button mSave = null;
    private TextView mName = null;
    private LinearLayout mIntroClick = null;
    private TextView mIntro = null;
    private EditText mEdit = null;
    private RadioGroup mSexgrop = null;
    private RadioButton mMale = null;
    private RadioButton mFemale = null;
    private InputMethodManager mInputManager = null;
    private boolean mClickOnEditor = false;
    private PersonChangeModel mModel = null;
    private Bitmap mPhoto = null;
    private GetImageTask mImageTask = null;
    private ProfileModifyTask mModifyTask = null;
    private ProgressBar mImageProgressBar = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private AsyncImageLoader mImageLoader = null;

    public static void startActivityForResult(Activity activity, int requestCode, PersonChangeModel data) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", data);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_change_activity);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        InitData(savedInstanceState);
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mImageTask != null) {
            this.mImageTask.cancel();
        }
        if (this.mModifyTask != null) {
            this.mModifyTask.cancel();
        }
        if (this.mImageProgressBar != null) {
            this.mImageProgressBar.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.mClickOnEditor = false;
        boolean ret = super.dispatchTouchEvent(ev);
        if (ev.getAction() == 1 && !this.mClickOnEditor) {
            hideEditor();
        }
        return ret;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideEditor() {
        if (this.mEdit.getVisibility() == 0) {
            this.mEdit.setVisibility(8);
            if (this.mEdit.getText().length() > 0) {
                this.mIntro.setText(this.mEdit.getText());
            } else {
                this.mIntro.setText(getString(R.string.add_intro));
            }
            this.mModel.setIntro(this.mEdit.getText().toString());
            this.mIntro.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditor() {
        if (this.mEdit.getVisibility() != 0) {
            this.mIntro.setVisibility(8);
            this.mEdit.setText(this.mModel.getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void InitData(Bundle savedInstanceState) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                PersonChangeActivity.this.DeinitWaitingDialog();
                if (PersonChangeActivity.this.mModifyTask != null) {
                    PersonChangeActivity.this.mModifyTask.cancel();
                }
            }
        };
        if (savedInstanceState != null) {
            this.mModel = (PersonChangeModel) savedInstanceState.getSerializable("data");
        } else {
            Intent intent = getIntent();
            this.mModel = (PersonChangeModel) intent.getSerializableExtra("data");
        }
        if (this.mModel == null) {
            this.mModel = new PersonChangeModel();
        }
        this.mImageLoader = new AsyncImageLoader(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data", this.mModel);
    }

    private void InitUI() {
        String[] items = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    WriteUtil.takePhoto(PersonChangeActivity.this);
                } else if (which == 1) {
                    WriteUtil.getAlbumImage(PersonChangeActivity.this);
                }
            }
        });
        if (this.mSelectImageDialog == null) {
            this.mSelectImageDialog = builder.create();
        }
        this.mImageView = (ImageView) findViewById(R.id.photo);
        this.mPhoto = this.mImageLoader.getPhoto(this.mModel.getPortrait());
        if (this.mPhoto != null) {
            this.mImageView.setImageBitmap(this.mPhoto);
        } else {
            this.mImageLoader.loadFriendPhotoByNet(this.mModel.getPortrait(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.person.PersonChangeActivity.3
                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                    PersonChangeActivity.this.mImageView.setImageBitmap(bitmap);
                }
            });
        }
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PersonChangeActivity.this.finish();
            }
        });
        this.mSave = (Button) findViewById(R.id.save);
        this.mSave.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PersonChangeActivity.this.hideEditor();
                PersonChangeActivity.this.mModel.setIntro(PersonChangeActivity.this.mEdit.getText().toString());
                if (PersonChangeActivity.this.mSexgrop.getCheckedRadioButtonId() == R.id.man) {
                    PersonChangeActivity.this.mModel.setSex(1);
                } else if (PersonChangeActivity.this.mSexgrop.getCheckedRadioButtonId() == R.id.woman) {
                    PersonChangeActivity.this.mModel.setSex(2);
                }
                if (PersonChangeActivity.this.mModifyTask == null) {
                    PersonChangeActivity.this.mModifyTask = new ProfileModifyTask(PersonChangeActivity.this.mModel);
                    PersonChangeActivity.this.mModifyTask.execute(new String[0]);
                }
            }
        });
        this.mIntroClick = (LinearLayout) findViewById(R.id.intro_click);
        this.mIntroClick.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PersonChangeActivity.this.showEditor();
            }
        });
        this.mIntroClick.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent event) {
                if (event.getAction() == 1) {
                    PersonChangeActivity.this.mClickOnEditor = true;
                    return false;
                }
                return false;
            }
        });
        this.mIntro = (TextView) findViewById(R.id.intro);
        if (this.mModel.getIntro() != null && this.mModel.getIntro().length() > 0) {
            this.mIntro.setText(this.mModel.getIntro());
        } else {
            this.mIntro.setText(getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.mModel.getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    PersonChangeActivity.this.hideEditor();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.person.PersonChangeActivity.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1) {
                    PersonChangeActivity.this.mClickOnEditor = true;
                    return false;
                }
                return false;
            }
        });
        this.mSexgrop = (RadioGroup) findViewById(R.id.sexgroup);
        this.mMale = (RadioButton) findViewById(R.id.man);
        this.mFemale = (RadioButton) findViewById(R.id.woman);
        if (this.mModel.getSex() == 1) {
            this.mMale.setChecked(true);
        } else if (this.mModel.getSex() == 2) {
            this.mFemale.setChecked(true);
        }
        this.mName = (TextView) findViewById(R.id.name);
        this.mName.setText(this.mModel.getName());
        this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == WriteUtil.REQUEST_ALBUM_IMAGE || requestCode == WriteUtil.REQUEST_CAMERA) {
                if (this.mImageTask != null) {
                    this.mImageTask.cancel();
                }
                this.mPhoto = null;
                this.mImageTask = new GetImageTask(this, requestCode, data);
                this.mImageTask.execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    private class GetImageTask extends AsyncTask<Object, Integer, Bitmap> {
        private Context mContext;
        private Intent mIntent;
        private int mRequestCode;

        public GetImageTask(Context context, int requestCode, Intent intent) {
            this.mContext = null;
            this.mRequestCode = 0;
            this.mIntent = null;
            this.mContext = context;
            this.mRequestCode = requestCode;
            this.mIntent = intent;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            PersonChangeActivity.this.mImageProgressBar.setVisibility(0);
            PersonChangeActivity.this.mSave.setEnabled(false);
            PersonChangeActivity.this.mImageView.setImageBitmap(null);
            PersonChangeActivity.this.mPhoto = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            if (this.mRequestCode == WriteUtil.REQUEST_ALBUM_IMAGE && this.mIntent != null) {
                Bitmap bitmap = WriteUtil.ImageResult(this.mRequestCode, this.mContext, this.mIntent.getData(), TiebaApplication.app.getPostImageSize());
                return bitmap;
            }
            Bitmap bitmap2 = WriteUtil.ImageResult(this.mRequestCode, this.mContext, null, TiebaApplication.app.getPostImageSize());
            return bitmap2;
        }

        public void cancel() {
            PersonChangeActivity.this.mImageTask = null;
            PersonChangeActivity.this.mImageProgressBar.setVisibility(8);
            PersonChangeActivity.this.mSave.setEnabled(true);
            super.cancel(true);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            super.onPostExecute((GetImageTask) result);
            PersonChangeActivity.this.mImageTask = null;
            PersonChangeActivity.this.mSave.setEnabled(true);
            PersonChangeActivity.this.mImageProgressBar.setVisibility(8);
            if (result != null) {
                PersonChangeActivity.this.mPhoto = result;
                PersonChangeActivity.this.mImageView.setImageBitmap(PersonChangeActivity.this.mPhoto);
                PersonChangeActivity.this.mModel.setPhotoChanged(true);
            }
        }
    }

    /* loaded from: classes.dex */
    private class ProfileModifyTask extends AsyncTask<String, Integer, String> {
        private PersonChangeModel mModel;
        private NetWork mNetWork = null;

        public ProfileModifyTask(PersonChangeModel model) {
            this.mModel = null;
            this.mModel = model;
        }

        public void cancel() {
            PersonChangeActivity.this.mModifyTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            PersonChangeActivity.this.mModifyTask = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getString(R.string.success));
                    Intent intent = new Intent();
                    intent.putExtra("data", this.mModel);
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((ProfileModifyTask) result);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getString(R.string.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            if (this.mModel == null) {
                return null;
            }
            this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/c/profile/modify");
            this.mNetWork.addPostData("sex", String.valueOf(this.mModel.getSex()));
            this.mNetWork.addPostData("intro", this.mModel.getIntro());
            if (this.mModel.getPhotoChanged() && PersonChangeActivity.this.mPhoto != null) {
                this.mNetWork.addPostData("head_pic", BitmapHelper.Bitmap2Bytes(PersonChangeActivity.this.mPhoto, 80));
            }
            this.mNetWork.postMultiNetData();
            if (this.mNetWork.isRequestSuccess()) {
                DatabaseService.delPersonData();
            }
            return null;
        }
    }
}
