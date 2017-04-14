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
    private WriteData fOO = null;
    private TextView mPost = null;
    private ImageView mImage = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b fOP = null;
    private a fOQ = null;
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
        re(this.fOO.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.mDialogCancelListener = new c(this);
        if (bundle != null) {
            this.fOO = (WriteData) bundle.getSerializable("model");
        } else {
            this.fOO = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fOO != null && this.fOO.getType() == 3) {
            if (this.fOP != null) {
                this.fOP.cancel();
            }
            if (this.fOQ != null) {
                this.fOQ.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.f.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fOP != null) {
            this.fOP.cancel();
        }
        if (this.fOQ != null) {
            this.fOQ.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fOO);
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
        aq.i(this.mPost, w.e.cp_cont_g);
        if (i == 1) {
            i2 = aq.cL(i);
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
    public void re(String str) {
        if (this.fOQ != null) {
            this.fOQ.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.mImage.setImageDrawable(null);
        this.fOQ = new a(this, null);
        this.fOQ.setPriority(3);
        this.fOQ.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fOS;
        private z mNetwork = null;
        private String mRetData = null;

        public b(WriteData writeData) {
            this.fOS = null;
            this.fOS = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public q doInBackground(Integer... numArr) {
            String str;
            Address C;
            if (this.fOS != null) {
                this.mNetwork = new z();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.fOS.getImagesCodeForPost();
                if (this.fOS.getType() == 3) {
                    this.mNetwork.n("newVcode", "1");
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fOS.getContent()) + imagesCodeForPost);
                    this.mNetwork.n(PayVcodeActivityConfig.VCODE_MD5, this.fOS.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.n("tag", "11");
                    this.mNetwork.vw().wp().mIsNeedTbs = true;
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fOS.getContent()) + imagesCodeForPost);
                    this.mNetwork.setUrl(com.baidu.tieba.tbadkCore.c.a.fwE);
                    this.mNetwork.n(ImageViewerConfig.FORUM_NAME, this.fOS.getForumName());
                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fOS.getTitle());
                    this.mNetwork.n("apiKey", this.fOS.getShareApiKey());
                    this.mNetwork.n("appName", this.fOS.getShareAppName());
                    this.mNetwork.n("signKey", this.fOS.getShareSignKey());
                    this.mNetwork.n("summary_title", this.fOS.getShareSummaryTitle());
                    this.mNetwork.n("summary_content", this.fOS.getShareSummaryContent());
                    this.mNetwork.n("summary_img", this.fOS.getShareSummaryImg());
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fOS.getShareSummaryImgWidth()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fOS.getShareSummaryImgHeight()));
                    this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fOS.getShareSummaryImgType());
                    this.mNetwork.n("referUrl", this.fOS.getShareReferUrl());
                } else {
                    this.mNetwork.n("anonymous", "0");
                    this.mNetwork.n("fid", this.fOS.getForumId());
                    this.mNetwork.n("kw", this.fOS.getForumName());
                    this.mNetwork.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fOS.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fOS.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fOS.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fOS.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fOS.getGraffitiWriteCode();
                    }
                    if (this.fOS.getType() == 6 && this.fOS.getVoteInfo() != null) {
                        if (this.fOS.getWriteImagesInfo() != null) {
                            this.fOS.getVoteInfo().setServerImageCode(this.fOS.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fOS.getVoteInfo().buildWriteContent();
                    }
                    this.mNetwork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    e.a(this.mNetwork, this.fOS);
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fOS.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.mNetwork.n("vcode", editable);
                    }
                    this.mNetwork.vw().wp().mIsNeedTbs = true;
                    if (this.fOS.getVoice() != null) {
                        this.mNetwork.n("voice_md5", this.fOS.getVoice());
                        this.mNetwork.n("during_time", String.valueOf(this.fOS.getVoiceDuringTime()));
                    }
                    if (this.fOS.getType() == 0 || this.fOS.getType() == 7) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fOS.getTitle());
                        this.mNetwork.n("is_ntitle", this.fOS.isNoTitle() ? "1" : "0");
                        if (this.fOS.getType() == 7) {
                            this.mNetwork.n("is_bottle", String.valueOf(1));
                        }
                        if (this.fOS.getCategoryFrom() >= 0) {
                            this.mNetwork.n("fromCategoryId", String.valueOf(this.fOS.getCategoryFrom()));
                        }
                        if (this.fOS.getCategoryTo() >= 0) {
                            this.mNetwork.n("toCategoryId", String.valueOf(this.fOS.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (C = com.baidu.adp.lib.d.a.ff().C(false)) != null) {
                            this.mNetwork.n("lbs", String.valueOf(String.valueOf(C.getLatitude())) + "," + String.valueOf(C.getLongitude()));
                        }
                    } else if (this.fOS.getType() == 6) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fOS.getTitle());
                        this.mNetwork.n("is_ntitle", this.fOS.isNoTitle() ? "1" : "0");
                        this.mNetwork.n("thread_type", String.valueOf(36));
                    } else if (this.fOS.getType() == 4) {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, this.fOS.getTitle());
                        this.mNetwork.n("is_ntitle", "0");
                        this.mNetwork.n("thread_type", String.valueOf(33));
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.mNetwork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.mNetwork.n("tid", this.fOS.getThreadId());
                        this.mNetwork.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fOS.getType() == 2) {
                            this.mNetwork.n("quote_id", String.valueOf(this.fOS.getFloor()));
                            this.mNetwork.n("floor_num", String.valueOf(this.fOS.getFloorNum()));
                            this.mNetwork.n(WriteActivityConfig.IS_ADDITION, this.fOS.isAddition() ? "1" : "0");
                            if (this.fOS.getRepostId() != null) {
                                this.mNetwork.n("repostid", this.fOS.getRepostId());
                            }
                        } else if (this.fOS.getType() == 5) {
                            this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fOS.getType() == 1) {
                            this.mNetwork.n("is_barrage", this.fOS.isBarrage() ? "1" : "0");
                            this.mNetwork.n("barrage_time", String.valueOf(this.fOS.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.pb.a.DK().getStatus() == 1) {
                                this.mNetwork.n("ptype", "4");
                            }
                        }
                    }
                }
                this.mRetData = this.mNetwork.uY();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fOP = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.mNetwork != null) {
                this.mNetwork.fr();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ca A[Catch: JSONException -> 0x0156, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0156, blocks: (B:26:0x00a0, B:28:0x00ca), top: B:76:0x00a0 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x026b  */
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
            VcodeActivity.this.fOP = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.vw().wq().isRequestSuccess()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.mRetData);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.c.b(VcodeActivity.this.fOO);
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
                                        if (this.fOS.getType() != 3) {
                                            e.c(VcodeActivity.this.getActivity(), str5, str6, str7);
                                        }
                                        this.fOS.deleteUploadedTempImages();
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
                        if (this.fOS.getType() != 3 && this.fOS.getType() != 7) {
                            e.c(VcodeActivity.this.getActivity(), str5, str6, str7);
                        }
                        this.fOS.deleteUploadedTempImages();
                    } else if (this.fOS.isHasImages() && j.isEmpty(String.valueOf(this.fOS.getContent()) + this.fOS.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                    } else if (this.fOS.getType() != 3) {
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
                } else if (this.fOS.isHasImages() && j.isEmpty(String.valueOf(this.fOS.getContent()) + this.fOS.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(w.l.img_upload_error));
                } else {
                    if (this.mNetwork.vA() == 5 || this.mNetwork.vA() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.mRetData);
                        if (qVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fOO.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fOO.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.re(VcodeActivity.this.fOO.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    } else if (this.fOS != null && this.mNetwork.vA() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.mRetData);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.mNetwork.vA(), this.mNetwork.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fOS, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.mNetwork.vA() != 227001) {
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
            VcodeActivity.this.fOQ = null;
            if (this.mNetWork != null) {
                this.mNetWork.fr();
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
                this.mNetWork.n("fid", VcodeActivity.this.fOO.getForumId());
                this.mNetWork.n("kw", VcodeActivity.this.fOO.getForumName());
                this.mNetWork.n("new_vcode", "1");
                this.mNetWork.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fOO.getTitle());
                this.mNetWork.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fOO.getContent());
                if (VcodeActivity.this.fOO.getType() == 0) {
                    this.mNetWork.n("pub_type", "1");
                    if (VcodeActivity.this.fOO.getCategoryFrom() >= 0) {
                        this.mNetWork.n("fromCategoryId", String.valueOf(VcodeActivity.this.fOO.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fOO.getCategoryTo() >= 0) {
                        this.mNetWork.n("toCategoryId", String.valueOf(VcodeActivity.this.fOO.getCategoryTo()));
                    }
                } else {
                    this.mNetWork.n("pub_type", "2");
                    this.mNetWork.n("tid", VcodeActivity.this.fOO.getThreadId());
                }
                String uY = this.mNetWork.uY();
                if (!this.mNetWork.vw().wq().isRequestSuccess()) {
                    return null;
                }
                this.mInfoData = new q();
                this.mInfoData.parserJson(uY);
                str = this.mInfoData.getVcode_pic_url();
            }
            if (this.mCanceled) {
                return null;
            }
            this.mNetWork = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.mNetWork.uZ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fOQ = null;
            if (bitmap != null) {
                VcodeActivity.this.mImage.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.mInfoData != null) {
                VcodeActivity.this.fOO.setVcodeMD5(this.mInfoData.getVcode_md5());
                VcodeActivity.this.fOO.setVcodeUrl(this.mInfoData.getVcode_pic_url());
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
