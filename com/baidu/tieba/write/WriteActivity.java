package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.location.BDLocation;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ChunkUploadData;
import com.baidu.tieba.data.ChunkUploadResult;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.ChunkUploadHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.FaceHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.MyBitmapDrawable;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity {
    private static final String FEED_BACK = "feed_back";
    private static final String FLOOR_ID = "floor_id";
    private static final String FLOOR_NUM = "floor_num";
    private static final String FORUM_ID = "forum_id";
    private static final String FORUM_NAME = "forum_name";
    private static final String IS_AD = "is_ad";
    private static final String REPLY_SUB_PB = "reply_sub_pb";
    private static final String THREAD_ID = "thread_id";
    private static final String TYPE = "type";
    private WriteModel mModel = null;
    private boolean isFeedBack = false;
    private boolean hasChanged = false;
    private InputMethodManager mInputManager = null;
    private EditText mPostTitle = null;
    private EditText mPostContent = null;
    private Button mBack = null;
    private Button mPost = null;
    private ImageView mFace = null;
    private ImageView mselectAt = null;
    private ImageView mSelectImage = null;
    private RelativeLayout mTools = null;
    private ProgressBar mImageProgressBar = null;
    private ImageView mImage = null;
    private TextView mName = null;
    private GridView mGridView = null;
    private AlertDialog mSelectImageDialog = null;
    private FaceAdapter mFaceAdapter = null;
    private GetImageTask mImageTask = null;
    private PostThreadTask mPostThreadTask = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private AlertDialog mDraftDialog = null;
    private Bitmap mBitmap = null;
    private Handler mHandler = new Handler();
    private ImageResizedReceiver receiver = null;
    private boolean mIsLoadingImage = false;
    private boolean mIsReplySubPb = false;
    private Runnable mKeyBoradRun = new Runnable() { // from class: com.baidu.tieba.write.WriteActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.mPostTitle.getVisibility() == 0) {
                WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostTitle);
            } else {
                WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostContent);
            }
        }
    };
    private Runnable mLoadImageRun = new Runnable() { // from class: com.baidu.tieba.write.WriteActivity.2
        @Override // java.lang.Runnable
        public void run() {
            WriteActivity.this.stopLoadImage(null);
        }
    };
    private Runnable mShowFaceRun = new Runnable() { // from class: com.baidu.tieba.write.WriteActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.mGridView.getVisibility() != 0) {
                WriteActivity.this.mGridView.setVisibility(0);
            }
        }
    };
    private View.OnClickListener mEditOnClicked = new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (WriteActivity.this.mGridView.getVisibility() == 0) {
                WriteActivity.this.mGridView.setVisibility(8);
            }
        }
    };
    private View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.WriteActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View v, boolean hasFocus) {
            if ((v == WriteActivity.this.mPostTitle || v == WriteActivity.this.mBack || v == WriteActivity.this.mPost) && hasFocus) {
                WriteActivity.this.mGridView.setVisibility(8);
                WriteActivity.this.mTools.setVisibility(8);
            }
            if (v == WriteActivity.this.mPostContent) {
                if (!hasFocus) {
                    if (WriteActivity.this.mModel.getType() == WriteModel.NEW) {
                        WriteActivity.this.mPostContent.setHint(R.string.content);
                        return;
                    }
                    return;
                }
                WriteActivity.this.mTools.setVisibility(0);
                if (WriteActivity.this.mModel.getType() == WriteModel.NEW) {
                    WriteActivity.this.mPostContent.setHint((CharSequence) null);
                }
            }
        }
    };

    public static void startAcitivityForResult(Activity context, String forumId, String forumName, AntiData anti) {
        startAcitivityForResult(context, WriteModel.NEW, forumId, forumName, null, null, 0, anti, RequestResponseCode.REQUEST_WRITE_NEW, false, false, false);
    }

    public static void startAcitivity(Activity context, String forumId, String forumName, AntiData anti) {
        startAcitivityForResult(context, WriteModel.NEW, forumId, forumName, null, null, 0, anti, RequestResponseCode.REQUEST_WRITE_NEW, false, false, false);
    }

    public static void startActivityFeedBack(Activity context, String forumId, String forumName, AntiData anti) {
        startAcitivityForResult(context, WriteModel.NEW, forumId, forumName, null, null, 0, anti, RequestResponseCode.REQUEST_WRITE_NEW, true, false, false);
    }

    public static void startAcitivity(Activity context, String forumId, String forumName, String threadId, String floorId, int floorNum, boolean isAd, AntiData anti) {
        if (floorId != null) {
            startAcitivityForResult(context, WriteModel.REPLY_FLOOR, forumId, forumName, threadId, floorId, floorNum, anti, RequestResponseCode.REQUEST_WRITE_REPLY_FLOOR, false, false, isAd);
        } else {
            startAcitivityForResult(context, WriteModel.REPLY, forumId, forumName, threadId, floorId, floorNum, anti, RequestResponseCode.REQUEST_WRITE_REPLY, false, false, isAd);
        }
    }

    public static void startAcitivity(Activity context, String forumId, String forumName, String threadId, String floorId, int floorNum, AntiData anti, boolean isReplySubPb) {
        if (floorId != null) {
            startAcitivityForResult(context, WriteModel.REPLY_FLOOR, forumId, forumName, threadId, floorId, floorNum, anti, RequestResponseCode.REQUEST_WRITE_REPLY_FLOOR, false, isReplySubPb, false);
        } else {
            startAcitivityForResult(context, WriteModel.REPLY, forumId, forumName, threadId, floorId, floorNum, anti, RequestResponseCode.REQUEST_WRITE_REPLY, false, isReplySubPb, false);
        }
    }

    private static void startAcitivityForResult(Activity context, int type, String forumId, String forumName, String threadId, String floorId, int floorNum, AntiData anti, int requestCode, boolean feedBack, boolean isReplySubPb, boolean isAd) {
        if (anti != null && anti.getIfpost() == 0) {
            UtilHelper.showToast(context, anti.getForbid_info());
            return;
        }
        Intent intent = new Intent(context, WriteActivity.class);
        intent.putExtra("type", type);
        intent.putExtra(FORUM_ID, forumId);
        intent.putExtra(FORUM_NAME, forumName);
        intent.putExtra(REPLY_SUB_PB, isReplySubPb);
        intent.putExtra(IS_AD, isAd);
        if (feedBack) {
            intent.putExtra(FEED_BACK, true);
        }
        if (threadId != null) {
            intent.putExtra(THREAD_ID, threadId);
        }
        if (floorId != null) {
            intent.putExtra(FLOOR_ID, floorId);
        }
        if (floorNum > 0) {
            intent.putExtra(FLOOR_NUM, floorNum);
        }
        context.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(savedInstanceState);
        initUI();
        regReceiver();
        TiebaApplication.app.startLocationServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageResizedReceiver extends BroadcastReceiver {
        private ImageResizedReceiver() {
        }

        /* synthetic */ ImageResizedReceiver(WriteActivity writeActivity, ImageResizedReceiver imageResizedReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (WriteActivity.this.mImageTask != null) {
                WriteActivity.this.mImageTask.cancel();
                WriteActivity.this.mImageTask = null;
            }
            WriteActivity.this.mHandler.removeCallbacks(WriteActivity.this.mLoadImageRun);
            if (intent.getBooleanExtra("result", false)) {
                WriteActivity.this.mImageTask = new GetImageTask(WriteActivity.this, null);
                WriteActivity.this.mImageTask.execute(new Object[0]);
                return;
            }
            WriteActivity.this.stopLoadImage(null);
            WriteActivity.this.showToast(intent.getStringExtra("error"));
        }
    }

    private void regReceiver() {
        this.receiver = new ImageResizedReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_IMAGE_RESIZED);
        registerReceiver(this.receiver, filter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        if (this.mImageTask != null) {
            this.mImageTask.cancel();
            this.mImageTask = null;
        }
        if (this.mPostThreadTask != null) {
            this.mPostThreadTask.cancel();
            this.mPostThreadTask = null;
        }
        if (this.mImageProgressBar != null) {
            this.mImageProgressBar.setVisibility(8);
        }
        closeDialog();
        this.mImage.setImageBitmap(null);
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        unregisterReceiver(this.receiver);
        this.mHandler.removeCallbacks(this.mLoadImageRun);
        TiebaApplication.app.stopLocationServer();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupSaveDraft() {
        if (this.mModel != null && this.mModel.getType() == WriteModel.REPLY_FLOOR && this.mIsReplySubPb) {
            finish();
        } else if (this.mDraftDialog != null && (this.mPostTitle.getText().toString().length() > 0 || this.mPostContent.getText().toString().length() > 0)) {
            if (this.hasChanged) {
                this.mDraftDialog.show();
                Button neutral = this.mDraftDialog.getButton(-3);
                if (neutral != null) {
                    ViewGroup.LayoutParams params = neutral.getLayoutParams();
                    params.width = -2;
                    neutral.setLayoutParams(params);
                }
                Button negatview = this.mDraftDialog.getButton(-2);
                if (negatview != null) {
                    ViewGroup.LayoutParams params2 = negatview.getLayoutParams();
                    params2.width = -2;
                    negatview.setLayoutParams(params2);
                }
                Button positive = this.mDraftDialog.getButton(-1);
                if (positive != null) {
                    ViewGroup.LayoutParams params3 = positive.getLayoutParams();
                    params3.width = -2;
                    positive.setLayoutParams(params3);
                    return;
                }
                return;
            }
            finish();
        } else {
            if (this.mModel.getHaveDraft()) {
                DatabaseService.deleteDraftBox(this.mModel);
            }
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            popupSaveDraft();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initUI() {
        setContentView(R.layout.write_activity);
        String[] items = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    WriteUtil.takePhoto(WriteActivity.this);
                    WriteActivity.this.mModel.setPicType(2);
                } else if (which == 1) {
                    WriteUtil.getAlbumImage(WriteActivity.this);
                    WriteActivity.this.mModel.setPicType(1);
                }
            }
        });
        if (this.mSelectImageDialog == null) {
            this.mSelectImageDialog = builder.create();
            this.mSelectImageDialog.setCanceledOnTouchOutside(true);
        }
        this.mPost = (Button) findViewById(R.id.post);
        this.mPost.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.startActivityForResult(WriteActivity.this, WriteActivity.this.mBitmap);
            }
        });
        this.mPostTitle = (EditText) findViewById(R.id.post_title);
        this.mPostTitle.setOnClickListener(this.mEditOnClicked);
        this.mPostTitle.setOnFocusChangeListener(this.mFocusChangeListener);
        if (this.mModel.getType() == WriteModel.NEW) {
            if (this.mModel.getTitle() != null) {
                this.mPostTitle.setText(this.mModel.getTitle());
            } else if (this.isFeedBack) {
                this.mPostTitle.setText(getResources().getString(R.string.android_feedback));
            }
        } else if (this.mModel.getType() != WriteModel.REPLY) {
            this.mModel.getType();
            int i = WriteModel.REPLY_FLOOR;
        }
        this.mPostTitle.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.WriteActivity.8
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable arg0) {
                WriteActivity.this.refreshPostButton();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                WriteActivity.this.hasChanged = true;
            }
        });
        this.mHandler.postDelayed(this.mKeyBoradRun, 200L);
        this.mFaceAdapter = new FaceAdapter(this);
        this.mGridView = (GridView) findViewById(R.id.face_view);
        this.mGridView.setAdapter((ListAdapter) this.mFaceAdapter);
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.WriteActivity.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ImageSpan[] all = (ImageSpan[]) WriteActivity.this.mPostContent.getText().getSpans(0, WriteActivity.this.mPostContent.getText().length(), ImageSpan.class);
                if (all.length < 10) {
                    String name = WriteActivity.this.mFaceAdapter.getName(arg2);
                    if (name != null) {
                        int pos = WriteActivity.this.mPostContent.getSelectionStart();
                        SpannableStringBuilder spanName = new SpannableStringBuilder(name);
                        Bitmap bm = (Bitmap) WriteActivity.this.mFaceAdapter.getItem(arg2);
                        if (bm != null) {
                            MyBitmapDrawable dr = new MyBitmapDrawable(bm);
                            dr.setBounds(0, 0, bm.getWidth() + 1, bm.getHeight());
                            dr.setGravity(3);
                            ImageSpan span = new ImageSpan(dr, 0);
                            spanName.setSpan(span, 0, spanName.length(), 33);
                            WriteActivity.this.mPostContent.getText().insert(pos, spanName);
                            return;
                        }
                        return;
                    }
                    return;
                }
                WriteActivity.this.showToast(WriteActivity.this.getString(R.string.too_many_face));
            }
        });
        this.mTools = (RelativeLayout) findViewById(R.id.tools);
        this.mPostContent = (EditText) findViewById(R.id.post_content);
        this.mPostContent.setOnClickListener(this.mEditOnClicked);
        this.mSelectImage = (ImageView) findViewById(R.id.select_image);
        this.mSelectImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteActivity.this.mSelectImageDialog.show();
            }
        });
        if (this.mModel.getContent() != null && this.mModel.getContent().length() > 0) {
            SpannableString spanstr = FaceHelper.parserFace(this, this.mModel.getContent());
            this.mPostContent.setText(spanstr);
        } else if (this.mModel.getType() == WriteModel.REPLY_FLOOR) {
            if (this.mIsReplySubPb) {
                this.mSelectImage.setVisibility(8);
            } else if (this.mModel.getFloorNum() > 0) {
                String text = String.format(getString(R.string.reply_x_floor), Integer.valueOf(this.mModel.getFloorNum()));
                this.mPostContent.setText(text);
                this.mPostContent.setSelection(text.length());
            }
        } else if (this.mModel.getType() == WriteModel.NEW && this.isFeedBack) {
            StringBuffer text2 = new StringBuffer(30);
            text2.append(getResources().getString(R.string.tieba_client));
            text2.append(Config.VERSION);
            text2.append(", ");
            text2.append(Build.VERSION.RELEASE);
            text2.append(":");
            this.mPostContent.setText(text2);
        }
        this.mPostContent.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mPostContent.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1) {
                    WriteActivity.this.mGridView.setVisibility(8);
                    return false;
                }
                return false;
            }
        });
        this.mPostContent.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.WriteActivity.12
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable arg0) {
                WriteActivity.this.refreshPostButton();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                WriteActivity.this.hasChanged = true;
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnFocusChangeListener(this.mFocusChangeListener);
        this.mName = (TextView) findViewById(R.id.name);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteActivity.this.popupSaveDraft();
            }
        });
        this.mselectAt = (ImageView) findViewById(R.id.select_at);
        this.mselectAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (WriteActivity.this.mGridView.getVisibility() == 0) {
                    WriteActivity.this.mGridView.setVisibility(8);
                }
                AtListActivity.startActivityForResult(WriteActivity.this, (int) RequestResponseCode.REQUEST_AT_SELECT);
            }
        });
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostTitle);
                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostContent);
                if (WriteActivity.this.mGridView.getVisibility() == 0) {
                    WriteActivity.this.mGridView.setVisibility(8);
                }
                WriteActivity.this.PostNewMessage();
            }
        });
        this.mFace = (ImageView) findViewById(R.id.select_face);
        this.mFace.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteActivity.this.mGridView.getVisibility() != 0) {
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostTitle);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostContent);
                    WriteActivity.this.mHandler.postDelayed(WriteActivity.this.mShowFaceRun, 200L);
                    return;
                }
                WriteActivity.this.mPostContent.requestFocus();
                WriteActivity.this.mGridView.setVisibility(8);
                WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mPostContent);
            }
        });
        if (this.mModel.getType() == WriteModel.NEW) {
            if (this.isFeedBack) {
                this.mName.setText(R.string.feedback);
            } else {
                this.mName.setText(R.string.post_new_thread);
            }
            this.mPostTitle.setVisibility(0);
        } else {
            this.mName.setText(R.string.send_reply);
            this.mPostTitle.setVisibility(8);
        }
        AlertDialog.Builder draft_builder = new AlertDialog.Builder(this);
        draft_builder.setMessage(getString(R.string.is_save_draft)).setCancelable(false).setPositiveButton(getString(R.string.save), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                WriteActivity.this.mModel.setTitle(WriteActivity.this.mPostTitle.getText().toString());
                WriteActivity.this.mModel.setContent(WriteActivity.this.mPostContent.getText().toString());
                DatabaseService.saveDraftBox(WriteActivity.this.mModel);
                WriteActivity.this.finish();
            }
        }).setNeutralButton(getString(R.string.not_save), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.18
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DatabaseService.deleteDraftBox(WriteActivity.this.mModel);
                WriteActivity.this.finish();
            }
        }).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.write.WriteActivity.19
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        this.mDraftDialog = draft_builder.create();
        refreshPostButton();
    }

    private void closeDialog() {
        try {
            if (this.mDraftDialog != null && this.mDraftDialog.isShowing()) {
                this.mDraftDialog.dismiss();
            }
            if (this.mSelectImageDialog != null && this.mSelectImageDialog.isShowing()) {
                this.mSelectImageDialog.dismiss();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "closeDialog", ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPostButton() {
        String check;
        if (this.mModel.getType() == WriteModel.NEW) {
            check = this.mPostTitle.getText().toString().trim();
        } else if (this.mBitmap != null) {
            check = NetWorkCore.NET_TYPE_NET;
        } else {
            check = this.mPostContent.getText().toString().trim();
        }
        if (this.mIsLoadingImage || check == null || check.length() <= 0 || this.mImageTask != null) {
            this.mPost.setEnabled(false);
            this.mPost.setTextColor(-7688462);
            return;
        }
        this.mPost.setEnabled(true);
        this.mPost.setTextColor(-1);
    }

    private void initData(Bundle savedInstanceState) {
        int floorNum;
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.WriteActivity.20
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                WriteActivity.this.DeinitWaitingDialog();
                if (WriteActivity.this.mPostThreadTask != null) {
                    WriteActivity.this.mPostThreadTask.cancel();
                }
            }
        };
        this.mModel = new WriteModel();
        if (savedInstanceState != null) {
            this.mModel.setType(savedInstanceState.getInt("type", WriteModel.NEW));
            this.mModel.setForumId(savedInstanceState.getString(FORUM_ID));
            this.mModel.setForumName(savedInstanceState.getString(FORUM_NAME));
            this.mModel.setThreadId(savedInstanceState.getString(THREAD_ID));
            this.mModel.setFloor(savedInstanceState.getString(FLOOR_ID));
            floorNum = savedInstanceState.getInt(FLOOR_NUM, 0);
            this.mModel.setFloorNum(floorNum);
            this.isFeedBack = savedInstanceState.getBoolean(FEED_BACK, false);
            this.mIsReplySubPb = savedInstanceState.getBoolean(REPLY_SUB_PB, false);
        } else {
            Intent intent = getIntent();
            this.mModel.setType(intent.getIntExtra("type", WriteModel.NEW));
            this.mModel.setForumId(intent.getStringExtra(FORUM_ID));
            this.mModel.setForumName(intent.getStringExtra(FORUM_NAME));
            this.mModel.setThreadId(intent.getStringExtra(THREAD_ID));
            this.mModel.setFloor(intent.getStringExtra(FLOOR_ID));
            floorNum = intent.getIntExtra(FLOOR_NUM, 0);
            this.mModel.setFloorNum(floorNum);
            this.isFeedBack = intent.getBooleanExtra(FEED_BACK, false);
            this.mIsReplySubPb = intent.getBooleanExtra(REPLY_SUB_PB, false);
        }
        WriteModel tmp = DatabaseService.getDraftBox(this.mModel.getType(), this.mModel.getForumId(), this.mModel.getThreadId(), this.mModel.getFloor());
        if (tmp != null) {
            this.mModel = tmp;
            this.mModel.setFloorNum(floorNum);
            this.mModel.setHaveDraft(true);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("type", this.mModel.getType());
        outState.putString(FORUM_ID, this.mModel.getForumId());
        outState.putString(FORUM_NAME, this.mModel.getForumName());
        outState.putString(THREAD_ID, this.mModel.getThreadId());
        outState.putString(FLOOR_ID, this.mModel.getFloor());
        outState.putInt(FLOOR_NUM, this.mModel.getFloorNum());
        outState.putBoolean(REPLY_SUB_PB, this.mIsReplySubPb);
        if (this.isFeedBack) {
            outState.putBoolean(FEED_BACK, true);
        }
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String content = this.mPostContent.getEditableText().toString();
        if (content != null) {
            this.mPostContent.setText(FaceHelper.parserFace(this, content));
        }
    }

    public void PostNewMessage() {
        this.mModel.setTitle(this.mPostTitle.getText().toString());
        this.mModel.setContent(this.mPostContent.getText().toString());
        showLoadingDialog(getString(R.string.sending), this.mDialogCancelListener);
        if (this.mPostThreadTask != null) {
            this.mPostThreadTask.cancel();
        }
        this.mModel.setVcode(null);
        this.mPostThreadTask = new PostThreadTask(this.mModel);
        this.mPostThreadTask.execute(0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == 1200003) {
                boolean del = data.getBooleanExtra(WriteImageActivity.DELET_FLAG, false);
                if (del) {
                    this.mBitmap = null;
                    this.mImage.setVisibility(8);
                }
                refreshPostButton();
            } else if (requestCode == 1200004) {
                String name = AtListActivity.getName(data);
                if (name != null) {
                    String str = "@" + name + " ";
                    int pos = this.mPostContent.getSelectionStart();
                    this.mPostContent.getText().insert(pos, str);
                }
            } else if (requestCode == 1200005) {
                DatabaseService.deleteDraftBox(this.mModel);
                setResult(-1);
                finish();
            } else {
                if (this.mImageTask != null) {
                    this.mImageTask.cancel();
                }
                this.mImageTask = null;
                startLoadImage();
                if (requestCode == 1200002 && data != null) {
                    TiebaPrepareImageService.StartService(requestCode, data.getData(), TiebaApplication.app.getPostImageSize());
                } else {
                    TiebaPrepareImageService.StartService(requestCode, null, TiebaApplication.app.getPostImageSize());
                }
                this.mHandler.removeCallbacks(this.mLoadImageRun);
                this.mHandler.postDelayed(this.mLoadImageRun, 10000L);
            }
        }
    }

    private void startLoadImage() {
        this.mIsLoadingImage = true;
        this.mImage.setVisibility(8);
        this.mImage.setImageBitmap(null);
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
        this.mModel.setBitmapId(null);
        this.mImageProgressBar.setVisibility(0);
        refreshPostButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoadImage(Bitmap bitmap) {
        this.mIsLoadingImage = false;
        this.mImageProgressBar.setVisibility(8);
        if (bitmap != null) {
            this.mBitmap = bitmap;
            this.mModel.setBitmapId(null);
            this.mImage.setImageBitmap(this.mBitmap);
            this.mImage.setVisibility(0);
        } else {
            this.mImage.setVisibility(8);
            showToast(getString(R.string.pic_parser_error));
        }
        refreshPostButton();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.mPostTitle);
        HidenSoftKeyPad(this.mInputManager, this.mPostContent);
        if (this.mGridView.getVisibility() == 0) {
            this.mGridView.setVisibility(8);
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends AsyncTask<Integer, Integer, String> {
        private WriteModel mDate;
        private NetWork mNetwork = null;
        private String mRetData = null;
        private ChunkUploadResult mChunkUploadResult = null;
        private ChunkUploadHelper mChunkUploadHelper = null;
        private volatile boolean mCanceled = false;

        public PostThreadTask(WriteModel data) {
            this.mDate = null;
            this.mDate = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01b7 A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01cc  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String doInBackground(Integer... arg0) {
            String ret;
            if (WriteActivity.this.mBitmap != null && this.mDate.getBitmapId() == null) {
                TiebaLog.d("PostThreadTask", "doInBackground", "start upload image");
                try {
                    File image = FileHelper.GetFile(Config.IMAGE_RESIZED_FILE);
                    this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/img/upload");
                    if (image.length() <= 102400 || (Config.IMG_CHUNK_UPLOAD_ENABLE == 0 && this.mNetwork.getNetType() != null && !this.mNetwork.getNetType().equals(NetWorkCore.NET_TYPE_WAP))) {
                        TiebaLog.d("PostThreadTask", "doInBackground", "image size is less than 100K");
                        this.mNetwork.addPostData(Config.PIC_TYPE, String.valueOf(WriteActivity.this.mModel.getPicType()));
                        ret = this.mNetwork.uploadImage(Config.IMAGE_RESIZED_FILE);
                        if (!this.mNetwork.isRequestSuccess()) {
                            return null;
                        }
                    } else {
                        TiebaLog.d("PostThreadTask", "doInBackground", "image size is more than 100K");
                        String md5 = StringHelper.ToMd5(FileHelper.GetStreamFromFile(image));
                        ChunkUploadData uploadData = DatabaseService.getChunkUploadDataByMd5(md5);
                        if (uploadData == null) {
                            TiebaLog.d("PostThreadTask", "doInBackground", "upload data is null");
                            uploadData = new ChunkUploadData();
                            uploadData.setMd5(md5);
                            uploadData.setChunkNo(0);
                            uploadData.setTotalLength(image.length());
                        }
                        this.mChunkUploadHelper = new ChunkUploadHelper(Config.IMAGE_RESIZED_FILE, uploadData, "http://c.tieba.baidu.com/c/c/img/chunkupload");
                        this.mChunkUploadResult = this.mChunkUploadHelper.uploadChunkFile();
                        if (this.mChunkUploadResult.isSuccess()) {
                            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/img/finupload");
                            this.mNetwork.addPostData("md5", uploadData.getMd5());
                            this.mNetwork.addPostData(Config.PIC_TYPE, String.valueOf(WriteActivity.this.mModel.getPicType()));
                            ret = this.mNetwork.postNetData();
                            if (ret == null || !this.mNetwork.isRequestSuccess()) {
                                long totalLength = uploadData.getTotalLength();
                                long chunkNo = totalLength % 102400 == 0 ? totalLength / 102400 : (totalLength / 102400) + 1;
                                uploadData.setChunkNo((int) chunkNo);
                                DatabaseService.saveChunkUploadData(uploadData);
                                return null;
                            }
                            DatabaseService.delChunkUploadData(md5);
                        } else {
                            return null;
                        }
                    }
                    JSONObject json = new JSONObject(ret);
                    InfoData info = new InfoData();
                    try {
                        info.parserJson(json.optJSONObject(LoginActivity.INFO));
                        this.mDate.setBitmapId(info);
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        return null;
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (!this.mCanceled) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (JSONException e4) {
                    e = e4;
                }
            }
            if (!this.mCanceled) {
                return null;
            }
            this.mNetwork = new NetWork();
            this.mNetwork.addPostData("anonymous", "0");
            this.mNetwork.addPostData("fid", this.mDate.getForumId());
            this.mNetwork.addPostData("kw", this.mDate.getForumName());
            String pic_str = "";
            if (this.mDate.getBitmapId() != null && this.mDate.getBitmapId().getPic_id() != null && this.mDate.getBitmapId().getPic_id().length() > 0) {
                pic_str = String.format("#(pic,%s,%d,%d)", this.mDate.getBitmapId().getPic_id(), Integer.valueOf(this.mDate.getBitmapId().getWidth()), Integer.valueOf(this.mDate.getBitmapId().getHeight()));
            }
            this.mNetwork.addPostData(PushConstants.EXTRA_CONTENT, String.valueOf(this.mDate.getContent()) + pic_str);
            if (this.mDate.getVcode() != null && this.mDate.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", this.mDate.getVcode());
            }
            this.mNetwork.setIsNeedTbs(true);
            if (this.mDate.getType() == WriteModel.NEW) {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/thread/add");
                this.mNetwork.addPostData("title", this.mDate.getTitle());
                BDLocation mLocation = TiebaApplication.app.getLocation();
                if (mLocation != null) {
                    this.mNetwork.addPostData("lbs", String.valueOf(String.valueOf(mLocation.getLatitude())) + "," + String.valueOf(mLocation.getLongitude()));
                }
            } else {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/post/add");
                this.mNetwork.addPostData("tid", this.mDate.getThreadId());
                this.mNetwork.addPostData(WriteActivity.IS_AD, WriteActivity.this.getIntent().getBooleanExtra(WriteActivity.IS_AD, false) ? NetWorkCore.NET_TYPE_NET : "0");
                if (this.mDate.getType() == WriteModel.REPLY_FLOOR) {
                    this.mNetwork.addPostData("quote_id", String.valueOf(this.mDate.getFloor()));
                    this.mNetwork.addPostData(WriteActivity.FLOOR_NUM, String.valueOf(this.mDate.getFloorNum()));
                }
            }
            this.mRetData = this.mNetwork.postNetData();
            return null;
        }

        public void cancel() {
            WriteActivity.this.mPostThreadTask = null;
            WriteActivity.this.closeLoadingDialog();
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            if (this.mChunkUploadHelper != null) {
                this.mChunkUploadHelper.cancel();
            }
            super.cancel(true);
        }

        private void handleRequestFail(int errorCode, String errorString) {
            if (errorCode == 5 || errorCode == 6) {
                VcodeInfoData info = new VcodeInfoData();
                info.parserJson(this.mRetData);
                if (info.getVcode_pic_url() != null) {
                    WriteActivity.this.mModel.setVcodeMD5(info.getVcode_md5());
                    WriteActivity.this.mModel.setVcodeUrl(info.getVcode_pic_url());
                    VcodeActivity.startActivityForResult(WriteActivity.this, WriteActivity.this.mModel, (int) RequestResponseCode.REQUEST_VCODE);
                    return;
                }
                WriteActivity.this.showToast(errorString);
                return;
            }
            WriteActivity.this.showToast(errorString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.mPostThreadTask = null;
            if (this.mChunkUploadResult != null && !this.mChunkUploadResult.isSuccess()) {
                handleRequestFail(this.mChunkUploadResult.getErrorCode(), this.mChunkUploadResult.getErrorString());
            } else if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    DatabaseService.deleteDraftBox(WriteActivity.this.mModel);
                    WriteActivity.this.showToast(TiebaApplication.app.getString(R.string.send_success));
                    WriteActivity.this.setResult(-1);
                    WriteActivity.this.finish();
                } else {
                    handleRequestFail(this.mNetwork.getErrorCode(), this.mNetwork.getErrorString());
                }
            }
            super.onPostExecute((PostThreadTask) result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<Object, Integer, Bitmap> {
        private GetImageTask() {
        }

        /* synthetic */ GetImageTask(WriteActivity writeActivity, GetImageTask getImageTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            Bitmap bitmap = FileHelper.getImage(null, Config.IMAGE_RESIZED_FILE_DISPLAY);
            return bitmap;
        }

        public void cancel() {
            WriteActivity.this.mImageTask = null;
            WriteActivity.this.mImageProgressBar.setVisibility(8);
            WriteActivity.this.mImage.setVisibility(8);
            WriteActivity.this.refreshPostButton();
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
            WriteActivity.this.mImageTask = null;
            WriteActivity.this.stopLoadImage(result);
        }
    }
}
