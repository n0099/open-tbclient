package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.NetWork;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity {
    private static final String SAVE_KEY = "model";
    private WriteModel mModel = null;
    private Button mBack = null;
    private Button mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private PostThreadTask mPostThreadTask = null;
    private GetImageTask mGetImageTask = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;

    public static void startActivityForResult(Activity activity, WriteModel model, int requestCode) {
        if (model != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra(SAVE_KEY, model);
            activity.startActivityForResult(intent, requestCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcode_activity);
        initData(savedInstanceState);
        initUI();
        refreshImage(this.mModel.getVcodeUrl());
    }

    private void initData(Bundle savedInstanceState) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.VcodeActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                VcodeActivity.this.DeinitWaitingDialog();
                VcodeActivity.this.mPostThreadTask.cancel();
            }
        };
        if (savedInstanceState != null) {
            this.mModel = (WriteModel) savedInstanceState.getSerializable(SAVE_KEY);
        } else {
            Intent intent = getIntent();
            this.mModel = (WriteModel) intent.getSerializableExtra(SAVE_KEY);
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mPostThreadTask != null) {
            this.mPostThreadTask.cancel();
        }
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(SAVE_KEY, this.mModel);
        super.onSaveInstanceState(outState);
    }

    private void initUI() {
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.VcodeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VcodeActivity.this.finish();
            }
        });
        this.mPost = (Button) findViewById(R.id.post);
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.VcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VcodeActivity.this.HidenSoftKeyPad(VcodeActivity.this.mInputManager, VcodeActivity.this.mEdit);
                VcodeActivity.this.showLoadingDialog(VcodeActivity.this.getString(R.string.sending), VcodeActivity.this.mDialogCancelListener);
                if (VcodeActivity.this.mPostThreadTask != null) {
                    VcodeActivity.this.mPostThreadTask.cancel();
                }
                VcodeActivity.this.mPostThreadTask = new PostThreadTask(VcodeActivity.this.mModel);
                VcodeActivity.this.mPostThreadTask.execute(0);
            }
        });
        this.mEdit = (EditText) findViewById(R.id.input);
        this.mImage = (ImageView) findViewById(R.id.vcode_image);
        this.mImage.setImageBitmap(null);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.VcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                VcodeActivity.this.refreshImage(null);
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshImage(String str) {
        if (this.mGetImageTask != null) {
            this.mGetImageTask.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageBitmap(null);
        this.mGetImageTask = new GetImageTask();
        this.mGetImageTask.execute(str);
    }

    /* loaded from: classes.dex */
    private class PostThreadTask extends AsyncTask<Integer, Integer, VcodeInfoData> {
        private WriteModel mDate;
        private NetWork mNetwork = null;
        private String mRetData = null;

        public PostThreadTask(WriteModel data) {
            this.mDate = null;
            this.mDate = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public VcodeInfoData doInBackground(Integer... arg0) {
            this.mNetwork = new NetWork();
            this.mNetwork.addPostData("anonymous", "0");
            this.mNetwork.addPostData("fid", this.mDate.getForumId());
            this.mNetwork.addPostData("kw", this.mDate.getForumName());
            String pic_str = "";
            if (this.mDate.getBitmapId() != null && this.mDate.getBitmapId().getPic_id() != null && this.mDate.getBitmapId().getPic_id().length() > 0) {
                pic_str = String.format("\n#(pic,%s,%d,%d)", this.mDate.getBitmapId().getPic_id(), Integer.valueOf(this.mDate.getBitmapId().getWidth()), Integer.valueOf(this.mDate.getBitmapId().getHeight()));
            }
            this.mNetwork.addPostData("content", this.mDate.getContent() + pic_str);
            this.mNetwork.addPostData("vcode_md5", this.mDate.getVcodeMD5());
            String vcode = VcodeActivity.this.mEdit.getText().toString();
            if (vcode.length() > 0) {
                this.mNetwork.addPostData("vcode", vcode);
            }
            this.mNetwork.addPostData("tbs", TiebaApplication.app.getTbs());
            if (this.mDate.getType() == WriteModel.NEW) {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/thread/add");
                this.mNetwork.addPostData("title", this.mDate.getTitle());
            } else {
                this.mNetwork.setUrl("http://c.tieba.baidu.com/c/c/post/add");
                this.mNetwork.addPostData("tid", this.mDate.getThreadId());
                if (this.mDate.getType() == WriteModel.REPLY_FLOOR) {
                    this.mNetwork.addPostData("quote_id", String.valueOf(this.mDate.getFloor()));
                    this.mNetwork.addPostData("floor_num", String.valueOf(this.mDate.getFloorNum()));
                }
            }
            this.mRetData = this.mNetwork.postNetData();
            return null;
        }

        public void cancel() {
            VcodeActivity.this.mPostThreadTask = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(VcodeInfoData result) {
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.mPostThreadTask = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    VcodeActivity.this.showToast(TiebaApplication.app.getString(R.string.send_success));
                    VcodeActivity.this.setResult(-1, null);
                    VcodeActivity.this.finish();
                } else {
                    if (this.mNetwork.getErrorCode() == 5 || this.mNetwork.getErrorCode() == 6) {
                        VcodeInfoData info = new VcodeInfoData();
                        info.parserJson(this.mRetData);
                        if (info.getVcode_pic_url() != null) {
                            VcodeActivity.this.mModel.setVcodeMD5(info.getVcode_md5());
                            VcodeActivity.this.mModel.setVcodeUrl(info.getVcode_pic_url());
                            VcodeActivity.this.refreshImage(VcodeActivity.this.mModel.getVcodeUrl());
                        }
                    }
                    VcodeActivity.this.showToast(this.mNetwork.getErrorString());
                }
            }
            super.onPostExecute((PostThreadTask) result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        VcodeInfoData mInfoData;
        NetWork mNetWork;

        private GetImageTask() {
            this.mNetWork = null;
            this.mInfoData = null;
            this.mCanceled = false;
        }

        public void cancel() {
            VcodeActivity.this.mGetImageTask = null;
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
                this.mNetWork = null;
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            String url = params[0];
            if (url == null || url.length() <= 0) {
                this.mNetWork = new NetWork("http://c.tieba.baidu.com/c/f/anti/vcode");
                this.mNetWork.addPostData("fid", VcodeActivity.this.mModel.getForumId());
                this.mNetWork.addPostData("kw", VcodeActivity.this.mModel.getForumName());
                if (VcodeActivity.this.mModel.getType() == WriteModel.NEW) {
                    this.mNetWork.addPostData("pub_type", "1");
                } else {
                    this.mNetWork.addPostData("pub_type", "2");
                }
                String ret = this.mNetWork.postNetData();
                if (!this.mNetWork.isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new VcodeInfoData();
                this.mInfoData.parserJson(ret);
                url = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new NetWork(url);
            byte[] data = this.mNetWork.getNetData();
            Bitmap bm = BitmapHelper.Bytes2Bitmap(data);
            return bm;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            VcodeActivity.this.mGetImageTask = null;
            if (result != null) {
                VcodeActivity.this.mImage.setImageBitmap(result);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null) {
                VcodeActivity.this.mModel.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.mModel.setVcodeUrl(this.mInfoData.getVcode_pic_url());
            }
            super.onPostExecute((GetImageTask) result);
        }
    }
}
