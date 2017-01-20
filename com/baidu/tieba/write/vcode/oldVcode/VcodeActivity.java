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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData fIL = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b fIM = null;
    private a fIN = null;
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
        setContentView(r.j.vcode_activity);
        initUI();
        initData(bundle);
        rC(this.fIL.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.fIL = (WriteData) bundle.getSerializable("model");
        } else {
            this.fIL = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fIL != null && this.fIL.getType() == 3) {
            if (this.fIM != null) {
                this.fIM.cancel();
            }
            if (this.fIN != null) {
                this.fIN.cancel();
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
        if (this.fIM != null) {
            this.fIM.cancel();
        }
        if (this.fIN != null) {
            this.fIN.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fIL);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        ap.f(this.mParent, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.j((View) this.mPost, r.g.s_navbar_button_bg);
        ap.i((View) this.mPost, r.e.cp_cont_g);
        if (i == 1) {
            i2 = ap.cM(i);
        } else {
            i2 = -12895429;
        }
        this.mInfo.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(r.l.sending), true, false, this.mDialogCancelListener);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(r.h.parent);
        this.mNavigationBar = (NavigationBar) findViewById(r.h.view_navigation_bar);
        this.mInfo = (TextView) findViewById(r.h.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onBackListener);
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.l.send), this.onPostListener);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.f.ds16);
        this.mPost.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(r.h.input);
        this.mImage = (ImageView) findViewById(r.h.vcode_image);
        this.mImage.setImageDrawable(null);
        this.mImage.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(r.h.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC(String str) {
        if (this.fIN != null) {
            this.fIN.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.fIN = new a(this, null);
        this.fIN.setPriority(3);
        this.fIN.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fIP;
        private y mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.fIP = null;
            this.fIP = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public q doInBackground(Integer... numArr) {
            String str;
            Address B;
            if (this.fIP != null) {
                this.mNetwork = new y();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.fIP.getImagesCodeForPost();
                if (this.fIP.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fIP.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.fIP.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.uC().vv().mIsNeedTbs = true;
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fIP.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fqx);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.fIP.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fIP.getTitle());
                    this.mNetwork.n("apiKey", this.fIP.getShareApiKey());
                    this.mNetwork.n("appName", this.fIP.getShareAppName());
                    this.mNetwork.n("signKey", this.fIP.getShareSignKey());
                    this.mNetwork.n("summary_title", this.fIP.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.fIP.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.fIP.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fIP.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fIP.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fIP.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.fIP.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.fIP.getForumId());
                    this.mNetwork.n("kw", this.fIP.getForumName());
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fIP.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fIP.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fIP.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fIP.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fIP.getGraffitiWriteCode();
                    }
                    if (this.fIP.getType() == 6 && this.fIP.getVoteInfo() != null) {
                        if (this.fIP.getWriteImagesInfo() != null) {
                            this.fIP.getVoteInfo().setServerImageCode(this.fIP.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fIP.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    e.a(this.mNetwork, this.fIP);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fIP.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.uC().vv().mIsNeedTbs = true;
                    if (this.fIP.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.fIP.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.fIP.getVoiceDuringTime()));
                    }
                    if (this.fIP.getType() == 0) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fIP.getTitle());
                        this.mNetwork.n("is_ntitle", this.fIP.isNoTitle() ? "1" : "0");
                        if (this.fIP.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.fIP.getCategoryFrom()));
                        }
                        if (this.fIP.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.fIP.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (B = com.baidu.adp.lib.d.a.dS().B(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                        }
                    } else if (this.fIP.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fIP.getTitle());
                        this.mNetwork.n("is_ntitle", this.fIP.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.fIP.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fIP.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.fIP.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fIP.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.fIP.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.fIP.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.fIP.isAddition() ? "1" : "0");
                            if (this.fIP.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.fIP.getRepostId());
                            }
                        } else if (this.fIP.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fIP.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.fIP.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.fIP.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.CT().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                        }
                    }
                }
                this.mRetData = this.mNetwork.ud();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fIM = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.ee();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00c1 A[Catch: JSONException -> 0x014d, TRY_LEAVE, TryCatch #3 {JSONException -> 0x014d, blocks: (B:24:0x0097, B:26:0x00c1), top: B:78:0x0097 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0262  */
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
            VcodeActivity.this.fIM = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.uC().vw().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.fIL);
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
                                        if (this.fIP.getType() != 3) {
                                        }
                                        this.fIP.deleteUploadedTempImages();
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
                            str5 = TbadkCoreApplication.m9getInst().getString(r.l.send_success);
                        }
                        if (this.fIP.getType() != 3) {
                            e.c(VcodeActivity.this.getActivity(), str5, str6, str7);
                        }
                        this.fIP.deleteUploadedTempImages();
                    } else if (this.fIP.isHasImages() && j.isEmpty(String.valueOf(this.fIP.getContent()) + this.fIP.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.l.img_upload_error));
                    } else if (this.fIP.getType() != 3) {
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
                } else if (this.fIP.isHasImages() && j.isEmpty(String.valueOf(this.fIP.getContent()) + this.fIP.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.l.img_upload_error));
                } else {
                    if (this.mNetwork.uG() == 5 || this.mNetwork.uG() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fIL.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fIL.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.rC(VcodeActivity.this.fIL.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.fIP != null && this.mNetwork.uG() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.uG(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fIP, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.uG() != 227001) {
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
        volatile y mNetWork;

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
            VcodeActivity.this.fIN = null;
            if (this.mNetWork != null) {
                this.mNetWork.ee();
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
                this.mNetWork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.mNetWork.n("fid", VcodeActivity.this.fIL.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.fIL.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fIL.getTitle());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fIL.getContent());
                if (VcodeActivity.this.fIL.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.fIL.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.fIL.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fIL.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.fIL.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.fIL.getThreadId());
                }
                String ud = this.mNetWork.ud();
                if (!this.mNetWork.uC().vw().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(ud);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new y(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.ue());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fIN = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null) {
                VcodeActivity.this.fIL.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.fIL.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
