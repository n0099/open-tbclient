package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private TextView cfW;
    private WriteData cfV = null;
    private TextView bPK = null;
    private ProgressBar cfX = null;
    private ProgressBar cfY = null;
    private DialogInterface.OnCancelListener bHF = null;
    private PostThreadTask cfZ = null;
    private ChangeVcodeTask cga = null;
    private BaseWebView mWebView = null;
    private String cgb = null;
    private String cgc = null;
    private String cgd = null;
    private boolean cge = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cgf = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cgg = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.akm();
        }
    };

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.new_vcode_activity);
        initUI();
        initData(bundle);
        if (aki()) {
            this.cfX.setVisibility(0);
            akk();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cfV = (WriteData) bundle.getSerializable("model");
        } else {
            this.cfV = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.ako();
                        return;
                    case 1:
                        NewVcodeActivity.this.akn();
                        return;
                    case 2:
                        if (message.obj != null) {
                            NewVcodeActivity.this.showToast((String) message.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @JavascriptInterface
    private boolean aki() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.w.new_vcode_webview);
                com.baidu.tbadk.core.util.bc.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.cfX.setVisibility(8);
                        if (!NewVcodeActivity.this.cge) {
                            NewVcodeActivity.this.cfW.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cfW.setVisibility(8);
                        }
                        super.onPageFinished(webView, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                    }
                });
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m255getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (this.mWebView != null && this.cgb != null && this.cgb.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cgb + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akm() {
        if (this.mWebView != null && this.cge && this.cgc != null && this.cgc.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cgc + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cfZ != null) {
            this.cfZ.cancel();
        }
        if (this.cga != null) {
            this.cga.cancel();
        }
        if (this.cfX != null) {
            this.cfX.setVisibility(8);
        }
        if (this.cfY != null) {
            this.cfY.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cfV);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cfV != null && this.cfV.getType() == 3) {
            if (this.cfZ != null) {
                this.cfZ.cancel();
            }
            if (this.cga != null) {
                this.cga.cancel();
            }
            if (this.cfX != null) {
                this.cfX.setVisibility(8);
            }
            if (this.cfY != null) {
                this.cfY.setVisibility(8);
            }
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.removeMessages(2);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.bc.g(this.bPK, i);
        com.baidu.tbadk.core.util.bc.e((View) this.cfW, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.bc.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cfX = (ProgressBar) findViewById(com.baidu.tieba.w.load_webview_progress);
        this.cfY = (ProgressBar) findViewById(com.baidu.tieba.w.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cgf);
        this.bPK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.send), this.cgg);
        this.cfW = (TextView) findViewById(com.baidu.tieba.w.webview_fail_view);
        this.cfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cge) {
                    NewVcodeActivity.this.cfX.setVisibility(0);
                    NewVcodeActivity.this.akj();
                    NewVcodeActivity.this.akk();
                }
            }
        });
        this.bHF = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cfZ != null) {
                    NewVcodeActivity.this.cfZ.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akn() {
        if (this.cga != null) {
            this.cga.cancel();
        }
        this.cfY.setVisibility(0);
        this.cga = new ChangeVcodeTask(this, null);
        this.cga.setPriority(3);
        this.cga.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ako() {
        if (this.cgd != null && this.cgd.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.z.sending), true, true, this.bHF);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cfZ != null) {
                this.cfZ.cancel();
            }
            this.cfZ = new PostThreadTask(this.cfV);
            this.cfZ.setPriority(3);
            this.cfZ.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.f.e> {
        private com.baidu.tbadk.core.util.ad CU = null;
        private String QH = null;
        private WriteData bPo;

        public PostThreadTask(WriteData writeData) {
            this.bPo = null;
            this.bPo = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public com.baidu.tieba.tbadkCore.f.e doInBackground(Integer... numArr) {
            Address z;
            com.baidu.tieba.tbadkCore.f.e eVar;
            String str;
            if (this.bPo == null) {
                return null;
            }
            this.CU = new com.baidu.tbadk.core.util.ad();
            String imagesCodeForPost = this.bPo.getImagesCodeForPost();
            if (this.bPo.getType() == 3) {
                this.CU.o("newVcode", "1");
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPo.getContent()) + imagesCodeForPost);
                this.CU.o("vcodeMd5", this.bPo.getVcodeMD5());
                this.CU.o("vcode", NewVcodeActivity.this.cgd);
                this.CU.o("tag", "11");
                this.CU.oS().pZ().mIsNeedTbs = true;
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPo.getContent()) + imagesCodeForPost);
                this.CU.setUrl(com.baidu.tieba.tbadkCore.c.a.bZe);
                this.CU.o(ImageViewerConfig.FORUM_NAME, this.bPo.getForumName());
                this.CU.o("title", this.bPo.getTitle());
                this.CU.o("apiKey", this.bPo.getShareApiKey());
                this.CU.o("appName", this.bPo.getShareAppName());
                this.CU.o("signKey", this.bPo.getShareSignKey());
                this.CU.o("summary_title", this.bPo.getShareSummaryTitle());
                this.CU.o("summary_content", this.bPo.getShareSummaryContent());
                this.CU.o("summary_img", this.bPo.getShareSummaryImg());
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bPo.getShareSummaryImgWidth()));
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bPo.getShareSummaryImgHeight()));
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bPo.getShareSummaryImgType());
                this.CU.o("referUrl", this.bPo.getShareReferUrl());
            } else {
                this.CU.o("anonymous", "0");
                this.CU.o(ImageViewerConfig.FORUM_ID, this.bPo.getForumId());
                this.CU.o("kw", this.bPo.getForumName());
                this.CU.o("new_vcode", "1");
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPo.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.f.g.a(this.CU, this.bPo);
                if (this.bPo.getIsBaobaoImageUploaded()) {
                    this.CU.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZh));
                    this.CU.o("tail_content", this.bPo.getBaobaoContent());
                    this.bPo.setBabaoPosted(true);
                } else {
                    this.bPo.setBabaoPosted(false);
                }
                this.CU.o("vcode_md5", this.bPo.getVcodeMD5());
                this.CU.o("vcode", NewVcodeActivity.this.cgd);
                this.CU.o("vcode_tag", "11");
                if (this.bPo.getVoice() != null) {
                    this.CU.o("voice_md5", this.bPo.getVoice());
                    this.CU.o("during_time", String.valueOf(this.bPo.getVoiceDuringTime()));
                }
                this.CU.oS().pZ().mIsNeedTbs = true;
                if (this.bPo.getType() == 0) {
                    this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CU.o("title", this.bPo.getTitle());
                    this.CU.o("is_ntitle", this.bPo.isNoTitle() ? "1" : "0");
                    if (this.bPo.getLiveCardData() != null) {
                        this.CU.o("group_id", String.valueOf(this.bPo.getLiveCardData().getGroupId()));
                        this.CU.o("start_time", String.valueOf(this.bPo.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dB().z(false)) != null) {
                        this.CU.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CU.o("tid", this.bPo.getThreadId());
                    this.CU.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bPo.getType() == 2) {
                        this.CU.o("quote_id", String.valueOf(this.bPo.getFloor()));
                        this.CU.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bPo.getFloorNum()));
                        this.CU.o(WriteActivityConfig.IS_ADDITION, this.bPo.isAddition() ? "1" : "0");
                        if (this.bPo.getRepostId() != null) {
                            this.CU.o("repostid", this.bPo.getRepostId());
                        }
                    }
                }
            }
            this.QH = this.CU.or();
            if (this.CU.oS().qa().lT()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.QH);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                } else if ((this.bPo.isHasImages() || this.bPo.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bPo.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.f.e eVar2 = new com.baidu.tieba.tbadkCore.f.e(errorData.getError_code(), error_msg, null);
                if (!eVar2.hasError()) {
                    this.bPo.deleteUploadedTempImages();
                    if (this.bPo.getType() == 1 && !this.bPo.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.al.b(this.bPo.getThreadId(), (WriteData) null);
                        eVar = eVar2;
                    }
                }
                eVar = eVar2;
            } else if (this.bPo.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bPo.getContent()) + imagesCodeForPost)) {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CU.oW(), TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CU.oW(), this.CU.getErrorString(), null);
            }
            if (!eVar.hasError()) {
                try {
                    str = new JSONObject(this.QH).optString(AddFriendActivityConfig.MSG);
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = null;
                }
                if (StringUtils.isNull(str)) {
                    str = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                }
                eVar.setErrorString(str);
            }
            return eVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cfZ = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.CU != null) {
                this.CU.dJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.f.e eVar) {
            super.onPostExecute(eVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.cfZ = null;
            if (eVar != null && this.CU != null) {
                if (this.CU.oS().qa().lT()) {
                    if (this.bPo.getType() != 3) {
                        if (eVar.hasError()) {
                            NewVcodeActivity.this.showToast(eVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.f.g.d(NewVcodeActivity.this.getPageContext().getPageActivity(), eVar.getErrorString(), eVar.aiD(), eVar.aiE());
                        }
                    }
                    if (this.bPo.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.bPo.getForumName(), "post live's thread")));
                    }
                    if (this.bPo != null && this.bPo.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afj();
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (eVar.aiC()) {
                    com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                    jVar.parserJson(this.QH);
                    if (jVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cfV.setVcodeMD5(jVar.getVcode_md5());
                        NewVcodeActivity.this.cfV.setVcodeUrl(jVar.getVcode_pic_url());
                        if (jVar.rK().equals("4")) {
                            NewVcodeActivity.this.akl();
                        } else {
                            if (this.bPo.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.change_vcode_type));
                            }
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(eVar.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.j> {
        volatile com.baidu.tbadk.core.util.ad AO;
        com.baidu.tbadk.coreExtra.data.j cgi;

        private ChangeVcodeTask() {
            this.AO = null;
            this.cgi = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.j doInBackground(String... strArr) {
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.AO.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cfV.getForumId());
            this.AO.o("kw", NewVcodeActivity.this.cfV.getForumName());
            this.AO.o("new_vcode", "1");
            this.AO.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cfV.getContent());
            if (!NewVcodeActivity.this.cfV.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cfV.setBabaoPosted(false);
            } else {
                this.AO.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZh));
                this.AO.o("tail_content", NewVcodeActivity.this.cfV.getBaobaoContent());
                NewVcodeActivity.this.cfV.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cfV.getVoice() != null) {
                this.AO.o("voice_md5", NewVcodeActivity.this.cfV.getVoice());
                this.AO.o("during_time", String.valueOf(NewVcodeActivity.this.cfV.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cfV.getType() == 0 || NewVcodeActivity.this.cfV.getType() == 3) {
                this.AO.o("title", NewVcodeActivity.this.cfV.getTitle());
                this.AO.o("pub_type", "1");
            } else {
                this.AO.o("pub_type", "2");
                this.AO.o("tid", NewVcodeActivity.this.cfV.getThreadId());
            }
            this.AO.o("vcode_tag", "11");
            String or = this.AO.or();
            if (this.AO.oS().qa().lT()) {
                this.cgi = new com.baidu.tbadk.coreExtra.data.j();
                this.cgi.parserJson(or);
                return this.cgi;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.j jVar) {
            NewVcodeActivity.this.cga = null;
            if (jVar != null) {
                NewVcodeActivity.this.cfV.setVcodeMD5(jVar.getVcode_md5());
                NewVcodeActivity.this.cfV.setVcodeUrl(jVar.getVcode_pic_url());
                if (!jVar.rK().equals("4")) {
                    if (NewVcodeActivity.this.cfV.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.akl();
                }
            } else {
                NewVcodeActivity.this.showToast(this.AO.getErrorString());
            }
            NewVcodeActivity.this.cfY.setVisibility(8);
            super.onPostExecute(jVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cga = null;
            if (this.AO != null) {
                this.AO.dJ();
            }
            NewVcodeActivity.this.cfY.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class VcodeJsInterface {
        VcodeJsInterface() {
        }

        @JavascriptInterface
        public String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.cfV.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cge = z;
            NewVcodeActivity.this.cgc = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cgd = str;
                NewVcodeActivity.this.cgb = str2;
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(0);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(0));
                }
            }
        }

        @JavascriptInterface
        public void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        @JavascriptInterface
        public void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.cgb = str;
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(1);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(1));
                }
            }
        }

        @JavascriptInterface
        public String jsGetSkinType() {
            return String.valueOf(TbadkCoreApplication.m255getInst().getSkinType());
        }
    }
}
