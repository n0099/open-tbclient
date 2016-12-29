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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData fAm = null;
    private TextView eWK = null;
    private ImageView aUt = null;
    private EditText erW = null;
    private ProgressBar mProgressBar = null;
    private b fAn = null;
    private a fAo = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener esg = null;
    private RelativeLayout cFi = null;
    private TextView bub = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener fAp = new com.baidu.tieba.write.vcode.oldVcode.a(this);
    private final View.OnClickListener fAq = new com.baidu.tieba.write.vcode.oldVcode.b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.h.vcode_activity);
        initUI();
        initData(bundle);
        rj(this.fAm.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.esg = new c(this);
        if (bundle != null) {
            this.fAm = (WriteData) bundle.getSerializable("model");
        } else {
            this.fAm = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fAm != null && this.fAm.getType() == 3) {
            if (this.fAn != null) {
                this.fAn.cancel();
            }
            if (this.fAo != null) {
                this.fAo.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.d.b.c(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fAn != null) {
            this.fAn.cancel();
        }
        if (this.fAo != null) {
            this.fAo.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fAm);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        ar.g(this.cFi, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ar.k(this.eWK, r.f.s_navbar_button_bg);
        ar.j((View) this.eWK, r.d.cp_cont_g);
        if (i == 1) {
            i2 = ar.cN(i);
        } else {
            i2 = -12895429;
        }
        this.bub.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gl() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(r.j.sending), true, false, this.esg);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    private void initUI() {
        this.cFi = (RelativeLayout) findViewById(r.g.parent);
        this.mNavigationBar = (NavigationBar) findViewById(r.g.view_navigation_bar);
        this.bub = (TextView) findViewById(r.g.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fAp);
        this.eWK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(r.j.send), this.fAq);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eWK.getLayoutParams();
        layoutParams.rightMargin = k.e(getPageContext().getPageActivity(), r.e.ds16);
        this.eWK.setLayoutParams(layoutParams);
        this.erW = (EditText) findViewById(r.g.input);
        this.aUt = (ImageView) findViewById(r.g.vcode_image);
        this.aUt.setImageDrawable(null);
        this.aUt.setOnClickListener(new d(this));
        this.mProgressBar = (ProgressBar) findViewById(r.g.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj(String str) {
        if (this.fAo != null) {
            this.fAo.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aUt.setImageDrawable(null);
        this.fAo = new a(this, null);
        this.fAo.setPriority(3);
        this.fAo.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, q> {
        private WriteData fAt;
        private z aiN = null;
        private String fjQ = null;

        public b(WriteData writeData) {
            this.fAt = null;
            this.fAt = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public q doInBackground(Integer... numArr) {
            String str;
            Address B;
            if (this.fAt != null) {
                this.aiN = new z();
                String editable = VcodeActivity.this.erW.getText().toString();
                String imagesCodeForPost = this.fAt.getImagesCodeForPost();
                if (this.fAt.getType() == 3) {
                    this.aiN.n("newVcode", "1");
                    this.aiN.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fAt.getContent()) + imagesCodeForPost);
                    this.aiN.n(PayVcodeActivityConfig.VCODE_MD5, this.fAt.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiN.n("vcode", editable);
                    }
                    this.aiN.n("tag", "11");
                    this.aiN.uI().vB().mIsNeedTbs = true;
                    this.aiN.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.fAt.getContent()) + imagesCodeForPost);
                    this.aiN.setUrl(com.baidu.tieba.tbadkCore.c.a.fhi);
                    this.aiN.n(ImageViewerConfig.FORUM_NAME, this.fAt.getForumName());
                    this.aiN.n(VrPlayerActivityConfig.TITLE, this.fAt.getTitle());
                    this.aiN.n("apiKey", this.fAt.getShareApiKey());
                    this.aiN.n("appName", this.fAt.getShareAppName());
                    this.aiN.n("signKey", this.fAt.getShareSignKey());
                    this.aiN.n("summary_title", this.fAt.getShareSummaryTitle());
                    this.aiN.n("summary_content", this.fAt.getShareSummaryContent());
                    this.aiN.n("summary_img", this.fAt.getShareSummaryImg());
                    this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.fAt.getShareSummaryImgWidth()));
                    this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.fAt.getShareSummaryImgHeight()));
                    this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.fAt.getShareSummaryImgType());
                    this.aiN.n("referUrl", this.fAt.getShareReferUrl());
                } else {
                    this.aiN.n("anonymous", "0");
                    this.aiN.n("fid", this.fAt.getForumId());
                    this.aiN.n("kw", this.fAt.getForumName());
                    this.aiN.n("new_vcode", "1");
                    VideoInfo videoInfo = this.fAt.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.fAt.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.fAt.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (!StringUtils.isNull(this.fAt.getGraffitiWriteCode())) {
                        str = String.valueOf(str) + this.fAt.getGraffitiWriteCode();
                    }
                    if (this.fAt.getType() == 6 && this.fAt.getVoteInfo() != null) {
                        if (this.fAt.getWriteImagesInfo() != null) {
                            this.fAt.getVoteInfo().setServerImageCode(this.fAt.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.fAt.getVoteInfo().buildWriteContent();
                    }
                    this.aiN.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    f.a(this.aiN, this.fAt);
                    this.aiN.n(GraffitiVcodeActivityConfig.VCODE_MD5, this.fAt.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.aiN.n("vcode", editable);
                    }
                    this.aiN.uI().vB().mIsNeedTbs = true;
                    if (this.fAt.getVoice() != null) {
                        this.aiN.n("voice_md5", this.fAt.getVoice());
                        this.aiN.n("during_time", String.valueOf(this.fAt.getVoiceDuringTime()));
                    }
                    if (this.fAt.getType() == 0) {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiN.n(VrPlayerActivityConfig.TITLE, this.fAt.getTitle());
                        this.aiN.n("is_ntitle", this.fAt.isNoTitle() ? "1" : "0");
                        if (this.fAt.getCategoryFrom() >= 0) {
                            this.aiN.n("fromCategoryId", String.valueOf(this.fAt.getCategoryFrom()));
                        }
                        if (this.fAt.getCategoryTo() >= 0) {
                            this.aiN.n("toCategoryId", String.valueOf(this.fAt.getCategoryTo()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m9getInst().getIsLocationOn() && (B = com.baidu.adp.lib.e.a.dU().B(false)) != null) {
                            this.aiN.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                        }
                    } else if (this.fAt.getType() == 6) {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiN.n(VrPlayerActivityConfig.TITLE, this.fAt.getTitle());
                        this.aiN.n("is_ntitle", this.fAt.isNoTitle() ? "1" : "0");
                        this.aiN.n("thread_type", String.valueOf(36));
                    } else if (this.fAt.getType() == 4) {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.aiN.n(VrPlayerActivityConfig.TITLE, this.fAt.getTitle());
                        this.aiN.n("is_ntitle", "0");
                        this.aiN.n("thread_type", String.valueOf(33));
                        this.aiN.n("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.aiN.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.aiN.n("tid", this.fAt.getThreadId());
                        this.aiN.n("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.fAt.getType() == 2) {
                            this.aiN.n("quote_id", String.valueOf(this.fAt.getFloor()));
                            this.aiN.n("floor_num", String.valueOf(this.fAt.getFloorNum()));
                            this.aiN.n(WriteActivityConfig.IS_ADDITION, this.fAt.isAddition() ? "1" : "0");
                            if (this.fAt.getRepostId() != null) {
                                this.aiN.n("repostid", this.fAt.getRepostId());
                            }
                        } else if (this.fAt.getType() == 5) {
                            this.aiN.n("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.fAt.getType() == 1) {
                            this.aiN.n("is_barrage", this.fAt.isBarrage() ? "1" : "0");
                            this.aiN.n("barrage_time", String.valueOf(this.fAt.getBarrageTime()));
                            if (com.baidu.tbadk.editortools.e.b.CY().getStatus() == 1) {
                                this.aiN.n("ptype", "4");
                            }
                        }
                    }
                }
                this.fjQ = this.aiN.uk();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fAn = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.aiN != null) {
                this.aiN.eg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00c0 A[Catch: JSONException -> 0x014c, TRY_LEAVE, TryCatch #3 {JSONException -> 0x014c, blocks: (B:24:0x0097, B:26:0x00c0), top: B:78:0x0097 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
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
            VcodeActivity.this.fAn = null;
            if (this.aiN != null) {
                if (this.aiN.uI().vC().oH()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.fjQ);
                    if (errorData.error_code == 0) {
                        com.baidu.tieba.graffiti.d.b(VcodeActivity.this.fAm);
                        try {
                            JSONObject jSONObject = new JSONObject(this.fjQ);
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
                                        if (this.fAt.getType() != 3) {
                                        }
                                        this.fAt.deleteUploadedTempImages();
                                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                                        str = "";
                                        str2 = "";
                                        str = new JSONObject(this.fjQ).optString("tid");
                                        str2 = new JSONObject(this.fjQ).optString(Info.kBaiduPIDKey);
                                        JSONObject optJSONObject2 = new JSONObject(this.fjQ).optJSONObject("twzhibo_info");
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
                            str5 = TbadkCoreApplication.m9getInst().getString(r.j.send_success);
                        }
                        if (this.fAt.getType() != 3) {
                            f.c(VcodeActivity.this.getActivity(), str5, str6, str7);
                        }
                        this.fAt.deleteUploadedTempImages();
                    } else if (this.fAt.isHasImages() && j.isEmpty(String.valueOf(this.fAt.getContent()) + this.fAt.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                    } else if (this.fAt.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData2 = new PostWriteCallBackData(0, null, null, null);
                    str = "";
                    str2 = "";
                    try {
                        str = new JSONObject(this.fjQ).optString("tid");
                        str2 = new JSONObject(this.fjQ).optString(Info.kBaiduPIDKey);
                        JSONObject optJSONObject22 = new JSONObject(this.fjQ).optJSONObject("twzhibo_info");
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
                } else if (this.fAt.isHasImages() && j.isEmpty(String.valueOf(this.fAt.getContent()) + this.fAt.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m9getInst().getString(r.j.img_upload_error));
                } else {
                    if (this.aiN.uM() == 5 || this.aiN.uM() == 6) {
                        q qVar2 = new q();
                        qVar2.parserJson(this.fjQ);
                        if (qVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.fAm.setVcodeMD5(qVar2.getVcode_md5());
                            VcodeActivity.this.fAm.setVcodeUrl(qVar2.getVcode_pic_url());
                            VcodeActivity.this.rj(VcodeActivity.this.fAm.getVcodeUrl());
                        }
                        VcodeActivity.this.erW.setText((CharSequence) null);
                    } else if (this.fAt != null && this.aiN.uM() == 227001) {
                        AccessState accessState = new AccessState();
                        accessState.parserJson(this.fjQ);
                        PostWriteCallBackData postWriteCallBackData3 = new PostWriteCallBackData(this.aiN.uM(), this.aiN.getErrorString(), null, null);
                        postWriteCallBackData3.setAccessState(accessState);
                        VcodeActivity.this.getActivity().setVisible(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(VcodeActivity.this.getActivity(), 12006, this.fAt, postWriteCallBackData3.getAccessState())));
                    }
                    if (this.aiN.uM() != 227001) {
                        VcodeActivity.this.showToast(this.aiN.getErrorString());
                    }
                }
            }
            super.onPostExecute(qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile z NX;
        private volatile boolean btw;
        q fAs;

        private a() {
            this.NX = null;
            this.fAs = null;
            this.btw = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.fAo = null;
            if (this.NX != null) {
                this.NX.eg();
            }
            this.btw = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: x */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.NX = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.NX.n("fid", VcodeActivity.this.fAm.getForumId());
                this.NX.n("kw", VcodeActivity.this.fAm.getForumName());
                this.NX.n("new_vcode", "1");
                this.NX.n(VrPlayerActivityConfig.TITLE, VcodeActivity.this.fAm.getTitle());
                this.NX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.fAm.getContent());
                if (VcodeActivity.this.fAm.getType() == 0) {
                    this.NX.n("pub_type", "1");
                    if (VcodeActivity.this.fAm.getCategoryFrom() >= 0) {
                        this.NX.n("fromCategoryId", String.valueOf(VcodeActivity.this.fAm.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.fAm.getCategoryTo() >= 0) {
                        this.NX.n("toCategoryId", String.valueOf(VcodeActivity.this.fAm.getCategoryTo()));
                    }
                } else {
                    this.NX.n("pub_type", "2");
                    this.NX.n("tid", VcodeActivity.this.fAm.getThreadId());
                }
                String uk = this.NX.uk();
                if (!this.NX.uI().vC().oH()) {
                    return null;
                }
                this.fAs = new q();
                this.fAs.parserJson(uk);
                str = this.fAs.getVcode_pic_url();
            }
            if (this.btw) {
                return null;
            }
            this.NX = new z(str);
            return BitmapHelper.Bytes2Bitmap(this.NX.ul());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.fAo = null;
            if (bitmap != null) {
                VcodeActivity.this.aUt.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.fAs != null) {
                VcodeActivity.this.fAm.setVcodeMD5(this.fAs.getVcode_md5());
                VcodeActivity.this.fAm.setVcodeUrl(this.fAs.getVcode_pic_url());
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
