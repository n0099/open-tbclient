package com.baidu.tieba.write.vcode.oldVcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.e;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData fNf = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b fNg = null;
    private a fNh = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private RelativeLayout mParent = null;
    private TextView mInfo = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener onBackListener = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener onPostListener = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.vcode_activity);
        initUI();
        initData(bundle);
        qK(this.fNf.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.fNf = (WriteData) bundle.getSerializable("model");
        } else {
            this.fNf = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fNf != null && this.fNf.getType() == 3) {
            if (this.fNg != null) {
                this.fNg.cancel();
            }
            if (this.fNh != null) {
                this.fNh.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.e.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fNg != null) {
            this.fNg.cancel();
        }
        if (this.fNh != null) {
            this.fNh.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fNf);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        aq.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        aq.j(this.mPost, w.g.s_navbar_button_bg);
        aq.i((View) this.mPost, w.e.cp_cont_g);
        if (i == 1) {
            i2 = aq.cI(i);
        } else {
            i2 = -12895429;
        }
        this.mInfo.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(w.l.sending), true, false, this.mDialogCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(w.h.parent);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.mInfo = (TextView) findViewById(w.h.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(w.l.send), this.onPostListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = k.g(getPageContext().getPageActivity(), w.f.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(w.h.input);
        this.mImage = (ImageView) findViewById(w.h.vcode_image);
        this.mImage.setImageDrawable(null);
        this.mImage.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(w.h.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(String str) {
        if (this.fNh != null) {
            this.fNh.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.fNh = new a(this, null);
        this.fNh.setPriority(3);
        this.fNh.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fNj;
        private z mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.fNj = null;
            this.fNj = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.fNj != null) {
                this.mNetwork = new z();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.fNj.getImagesCodeForPost();
                if (this.fNj.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fNj.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.fNj.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.uZ().vS().mIsNeedTbs = true;
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fNj.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fuV);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.fNj.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fNj.getTitle());
                    this.mNetwork.n("apiKey", this.fNj.getShareApiKey());
                    this.mNetwork.n("appName", this.fNj.getShareAppName());
                    this.mNetwork.n("signKey", this.fNj.getShareSignKey());
                    this.mNetwork.n("summary_title", this.fNj.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.fNj.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.fNj.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fNj.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fNj.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fNj.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.fNj.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.fNj.getForumId());
                    this.mNetwork.n("kw", this.fNj.getForumName());
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fNj.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fNj.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fNj.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fNj.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fNj.getGraffitiWriteCode();
                    }
                    if (this.fNj.getType() == 6 && this.fNj.getVoteInfo() != null) {
                        if (this.fNj.getWriteImagesInfo() != null) {
                            this.fNj.getVoteInfo().setServerImageCode(this.fNj.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fNj.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    e.a(this.mNetwork, this.fNj);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fNj.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.uZ().vS().mIsNeedTbs = true;
                    if (this.fNj.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.fNj.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.fNj.getVoiceDuringTime()));
                    }
                    if (this.fNj.getType() == 0 || this.fNj.getType() == 7) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fNj.getTitle());
                        this.mNetwork.n("is_ntitle", this.fNj.isNoTitle() ? "1" : "0");
                        if (this.fNj.getType() == 7) {
                            this.mNetwork.n("is_bottle", String.valueOf(1));
                        }
                        if (this.fNj.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.fNj.getCategoryFrom()));
                        }
                        if (this.fNj.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.fNj.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.fa().C(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(C.getLatitude())) + "," + String.valueOf(C.getLongitude()));
                        }
                    } else if (this.fNj.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fNj.getTitle());
                        this.mNetwork.n("is_ntitle", this.fNj.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.fNj.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fNj.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.fNj.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fNj.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.fNj.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.fNj.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.fNj.isAddition() ? "1" : "0");
                            if (this.fNj.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.fNj.getRepostId());
                            }
                        } else if (this.fNj.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fNj.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.fNj.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.fNj.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.Dm().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                        }
                    }
                }
                this.mRetData = this.mNetwork.uB();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fNg = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cb A[Catch: JSONException -> 0x0157, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0157, blocks: (B:26:0x00a0, B:28:0x00cb), top: B:76:0x00a0 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x026c  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(q qVar) {
            String str;
            String str2;
            int i;
            JSONException jSONException;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.fNg = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.uZ().vT().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.fNf);
                        try {
                            JSONObject jSONObject = new JSONObject(this.mRetData);
                            str5 = jSONObject.optString(AddFriendActivityConfig.MSG);
                            try {
                                JSONObject optJSONObject = jSONObject.optJSONObject("exp");
                                if (optJSONObject != null) {
                                    str6 = optJSONObject.optString("pre_msg");
                                    if (StringUtils.isNull(str6)) {
                                        str6 = null;
                                    }
                                    try {
                                        str7 = optJSONObject.optString("color_msg");
                                        if (StringUtils.isNull(str7)) {
                                            str7 = null;
                                        }
                                    } catch (JSONException e) {
                                        str4 = str6;
                                        str3 = str5;
                                        jSONException = e;
                                        jSONException.printStackTrace();
                                        str5 = str3;
                                        str6 = str4;
                                        str7 = null;
                                        if (StringUtils.isNull(str5)) {
                                        }
                                        if (this.fNj.getType() != 3) {
                                            e.b(VcodeActivity.this.getActivity(), str5, str6, str7);
                                        }
                                        this.fNj.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str = new JSONObject(this.mRetData).optString("tid");
                                        str2 = new JSONObject(this.mRetData).optString(Info.kBaiduPIDKey);
                                        JSONObject optJSONObject2 = new JSONObject(this.mRetData).optJSONObject("twzhibo_info");
                                        if (optJSONObject2 == null) {
                                        }
                                        postWriteCallBackData.setThreadId(str);
                                        postWriteCallBackData.setPostId(str2);
                                        postWriteCallBackData.setIsCopyTWZhibo(i);
                                        Intent intent = new Intent();
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                                        intent.putExtras(bundle);
                                        VcodeActivity.this.setResult(-1, intent);
                                        VcodeActivity.this.finish();
                                        super.onPostExecute(qVar);
                                    }
                                } else {
                                    str7 = null;
                                    str6 = null;
                                }
                            } catch (JSONException e2) {
                                str3 = str5;
                                jSONException = e2;
                                str4 = null;
                            }
                        } catch (JSONException e3) {
                            jSONException = e3;
                            str3 = null;
                            str4 = null;
                        }
                        if (StringUtils.isNull(str5)) {
                            str5 = TbadkCoreApplication.m9getInst().getString(w.l.send_success);
                        }
                        if (this.fNj.getType() != 3 && this.fNj.getType() != 7) {
                            e.b(VcodeActivity.this.getActivity(), str5, str6, str7);
                        }
                        this.fNj.deleteUploadedTempImages();
                    } else if (this.fNj.isHasImages() && j.isEmpty(String.valueOf(this.fNj.getContent()) + this.fNj.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                    } else if (this.fNj.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    try {
                        str = new JSONObject(this.mRetData).optString("tid");
                        str2 = new JSONObject(this.mRetData).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject22 = new JSONObject(this.mRetData).optJSONObject("twzhibo_info");
                        i = optJSONObject22 == null ? optJSONObject22.optInt("is_copytwzhibo", 0) : 0;
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        str = str;
                        str2 = str2;
                        i = 0;
                    }
                    postWriteCallBackData2.setThreadId(str);
                    postWriteCallBackData2.setPostId(str2);
                    postWriteCallBackData2.setIsCopyTWZhibo(i);
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData2);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    VcodeActivity.this.finish();
                } else if (this.fNj.isHasImages() && j.isEmpty(String.valueOf(this.fNj.getContent()) + this.fNj.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                } else {
                    if (this.mNetwork.vd() == 5 || this.mNetwork.vd() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fNf.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fNf.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.qK(VcodeActivity.this.fNf.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.fNj != null && this.mNetwork.vd() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.vd(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fNj, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.vd() != 227001) {
                        VcodeActivity.this.showToast(this.mNetwork.getErrorString());
                    }
                }
            }
            super.onPostExecute(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        private volatile boolean mCanceled;
        q mInfoData;
        volatile z mNetWork;

        private a() {
            this.mNetWork = null;
            this.mInfoData = null;
            this.mCanceled = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fNh = null;
            if (this.mNetWork != null) {
                this.mNetWork.fm();
            }
            this.mCanceled = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.mNetWork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.fNf.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.fNf.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fNf.getTitle());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fNf.getContent());
                if (VcodeActivity.this.fNf.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.fNf.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.fNf.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fNf.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.fNf.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.fNf.getThreadId());
                }
                String uB = this.mNetWork.uB();
                if (!this.mNetWork.uZ().vT().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(uB);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.uC());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fNh = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null) {
                VcodeActivity.this.fNf.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.fNf.setVcodeUrl(this.mInfoData.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12006:
                    setResult(-1, intent);
                    break;
            }
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }
}
