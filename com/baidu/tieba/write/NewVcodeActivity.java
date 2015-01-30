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
    private TextView cfX;
    private WriteData cfW = null;
    private TextView bPL = null;
    private ProgressBar cfY = null;
    private ProgressBar cfZ = null;
    private DialogInterface.OnCancelListener bHG = null;
    private PostThreadTask cga = null;
    private ChangeVcodeTask cgb = null;
    private BaseWebView mWebView = null;
    private String cgc = null;
    private String cgd = null;
    private String cge = null;
    private boolean cgf = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cgg = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cgh = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.akr();
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
        if (akn()) {
            this.cfY.setVisibility(0);
            akp();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cfW = (WriteData) bundle.getSerializable("model");
        } else {
            this.cfW = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.akt();
                        return;
                    case 1:
                        NewVcodeActivity.this.aks();
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
    private boolean akn() {
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
                        NewVcodeActivity.this.cfY.setVisibility(8);
                        if (!NewVcodeActivity.this.cgf) {
                            NewVcodeActivity.this.cfX.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cfX.setVisibility(8);
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
    public void ako() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akq() {
        if (this.mWebView != null && this.cgc != null && this.cgc.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cgc + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        if (this.mWebView != null && this.cgf && this.cgd != null && this.cgd.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cgd + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cga != null) {
            this.cga.cancel();
        }
        if (this.cgb != null) {
            this.cgb.cancel();
        }
        if (this.cfY != null) {
            this.cfY.setVisibility(8);
        }
        if (this.cfZ != null) {
            this.cfZ.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cfW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cfW != null && this.cfW.getType() == 3) {
            if (this.cga != null) {
                this.cga.cancel();
            }
            if (this.cgb != null) {
                this.cgb.cancel();
            }
            if (this.cfY != null) {
                this.cfY.setVisibility(8);
            }
            if (this.cfZ != null) {
                this.cfZ.setVisibility(8);
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
        com.baidu.tbadk.core.util.bc.g(this.bPL, i);
        com.baidu.tbadk.core.util.bc.e((View) this.cfX, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.bc.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cfY = (ProgressBar) findViewById(com.baidu.tieba.w.load_webview_progress);
        this.cfZ = (ProgressBar) findViewById(com.baidu.tieba.w.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cgg);
        this.bPL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.send), this.cgh);
        this.cfX = (TextView) findViewById(com.baidu.tieba.w.webview_fail_view);
        this.cfX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cgf) {
                    NewVcodeActivity.this.cfY.setVisibility(0);
                    NewVcodeActivity.this.ako();
                    NewVcodeActivity.this.akp();
                }
            }
        });
        this.bHG = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cga != null) {
                    NewVcodeActivity.this.cga.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.cgb != null) {
            this.cgb.cancel();
        }
        this.cfZ.setVisibility(0);
        this.cgb = new ChangeVcodeTask(this, null);
        this.cgb.setPriority(3);
        this.cgb.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akt() {
        if (this.cge != null && this.cge.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.z.sending), true, true, this.bHG);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cga != null) {
                this.cga.cancel();
            }
            this.cga = new PostThreadTask(this.cfW);
            this.cga.setPriority(3);
            this.cga.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.f.e> {
        private com.baidu.tbadk.core.util.ad CX = null;
        private String QK = null;
        private WriteData bPp;

        public PostThreadTask(WriteData writeData) {
            this.bPp = null;
            this.bPp = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public com.baidu.tieba.tbadkCore.f.e doInBackground(Integer... numArr) {
            Address z;
            com.baidu.tieba.tbadkCore.f.e eVar;
            String str;
            if (this.bPp == null) {
                return null;
            }
            this.CX = new com.baidu.tbadk.core.util.ad();
            String imagesCodeForPost = this.bPp.getImagesCodeForPost();
            if (this.bPp.getType() == 3) {
                this.CX.o("newVcode", "1");
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPp.getContent()) + imagesCodeForPost);
                this.CX.o("vcodeMd5", this.bPp.getVcodeMD5());
                this.CX.o("vcode", NewVcodeActivity.this.cge);
                this.CX.o("tag", "11");
                this.CX.oZ().qg().mIsNeedTbs = true;
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPp.getContent()) + imagesCodeForPost);
                this.CX.setUrl(com.baidu.tieba.tbadkCore.c.a.bZf);
                this.CX.o(ImageViewerConfig.FORUM_NAME, this.bPp.getForumName());
                this.CX.o("title", this.bPp.getTitle());
                this.CX.o("apiKey", this.bPp.getShareApiKey());
                this.CX.o("appName", this.bPp.getShareAppName());
                this.CX.o("signKey", this.bPp.getShareSignKey());
                this.CX.o("summary_title", this.bPp.getShareSummaryTitle());
                this.CX.o("summary_content", this.bPp.getShareSummaryContent());
                this.CX.o("summary_img", this.bPp.getShareSummaryImg());
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bPp.getShareSummaryImgWidth()));
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bPp.getShareSummaryImgHeight()));
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bPp.getShareSummaryImgType());
                this.CX.o("referUrl", this.bPp.getShareReferUrl());
            } else {
                this.CX.o("anonymous", "0");
                this.CX.o(ImageViewerConfig.FORUM_ID, this.bPp.getForumId());
                this.CX.o("kw", this.bPp.getForumName());
                this.CX.o("new_vcode", "1");
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bPp.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.f.g.a(this.CX, this.bPp);
                if (this.bPp.getIsBaobaoImageUploaded()) {
                    this.CX.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZi));
                    this.CX.o("tail_content", this.bPp.getBaobaoContent());
                    this.bPp.setBabaoPosted(true);
                } else {
                    this.bPp.setBabaoPosted(false);
                }
                this.CX.o("vcode_md5", this.bPp.getVcodeMD5());
                this.CX.o("vcode", NewVcodeActivity.this.cge);
                this.CX.o("vcode_tag", "11");
                if (this.bPp.getVoice() != null) {
                    this.CX.o("voice_md5", this.bPp.getVoice());
                    this.CX.o("during_time", String.valueOf(this.bPp.getVoiceDuringTime()));
                }
                this.CX.oZ().qg().mIsNeedTbs = true;
                if (this.bPp.getType() == 0) {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CX.o("title", this.bPp.getTitle());
                    this.CX.o("is_ntitle", this.bPp.isNoTitle() ? "1" : "0");
                    if (this.bPp.getLiveCardData() != null) {
                        this.CX.o("group_id", String.valueOf(this.bPp.getLiveCardData().getGroupId()));
                        this.CX.o("start_time", String.valueOf(this.bPp.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dB().z(false)) != null) {
                        this.CX.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CX.o("tid", this.bPp.getThreadId());
                    this.CX.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bPp.getType() == 2) {
                        this.CX.o("quote_id", String.valueOf(this.bPp.getFloor()));
                        this.CX.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bPp.getFloorNum()));
                        this.CX.o(WriteActivityConfig.IS_ADDITION, this.bPp.isAddition() ? "1" : "0");
                        if (this.bPp.getRepostId() != null) {
                            this.CX.o("repostid", this.bPp.getRepostId());
                        }
                    }
                }
            }
            this.QK = this.CX.oy();
            if (this.CX.oZ().qh().ma()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.QK);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                } else if ((this.bPp.isHasImages() || this.bPp.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bPp.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.f.e eVar2 = new com.baidu.tieba.tbadkCore.f.e(errorData.getError_code(), error_msg, null);
                if (!eVar2.hasError()) {
                    this.bPp.deleteUploadedTempImages();
                    if (this.bPp.getType() == 1 && !this.bPp.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.al.b(this.bPp.getThreadId(), (WriteData) null);
                        eVar = eVar2;
                    }
                }
                eVar = eVar2;
            } else if (this.bPp.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bPp.getContent()) + imagesCodeForPost)) {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CX.pd(), TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CX.pd(), this.CX.getErrorString(), null);
            }
            if (!eVar.hasError()) {
                try {
                    str = new JSONObject(this.QK).optString(AddFriendActivityConfig.MSG);
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
            NewVcodeActivity.this.cga = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.CX != null) {
                this.CX.dJ();
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
            NewVcodeActivity.this.cga = null;
            if (eVar != null && this.CX != null) {
                if (this.CX.oZ().qh().ma()) {
                    if (this.bPp.getType() != 3) {
                        if (eVar.hasError()) {
                            NewVcodeActivity.this.showToast(eVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.f.g.d(NewVcodeActivity.this.getPageContext().getPageActivity(), eVar.getErrorString(), eVar.aiI(), eVar.aiJ());
                        }
                    }
                    if (this.bPp.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.bPp.getForumName(), "post live's thread")));
                    }
                    if (this.bPp != null && this.bPp.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afo();
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (eVar.aiH()) {
                    com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                    jVar.parserJson(this.QK);
                    if (jVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cfW.setVcodeMD5(jVar.getVcode_md5());
                        NewVcodeActivity.this.cfW.setVcodeUrl(jVar.getVcode_pic_url());
                        if (jVar.rQ().equals("4")) {
                            NewVcodeActivity.this.akq();
                        } else {
                            if (this.bPp.getType() != 3) {
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
        volatile com.baidu.tbadk.core.util.ad AR;
        com.baidu.tbadk.coreExtra.data.j cgj;

        private ChangeVcodeTask() {
            this.AR = null;
            this.cgj = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.j doInBackground(String... strArr) {
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.AR.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cfW.getForumId());
            this.AR.o("kw", NewVcodeActivity.this.cfW.getForumName());
            this.AR.o("new_vcode", "1");
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cfW.getContent());
            if (!NewVcodeActivity.this.cfW.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cfW.setBabaoPosted(false);
            } else {
                this.AR.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZi));
                this.AR.o("tail_content", NewVcodeActivity.this.cfW.getBaobaoContent());
                NewVcodeActivity.this.cfW.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cfW.getVoice() != null) {
                this.AR.o("voice_md5", NewVcodeActivity.this.cfW.getVoice());
                this.AR.o("during_time", String.valueOf(NewVcodeActivity.this.cfW.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cfW.getType() == 0 || NewVcodeActivity.this.cfW.getType() == 3) {
                this.AR.o("title", NewVcodeActivity.this.cfW.getTitle());
                this.AR.o("pub_type", "1");
            } else {
                this.AR.o("pub_type", "2");
                this.AR.o("tid", NewVcodeActivity.this.cfW.getThreadId());
            }
            this.AR.o("vcode_tag", "11");
            String oy = this.AR.oy();
            if (this.AR.oZ().qh().ma()) {
                this.cgj = new com.baidu.tbadk.coreExtra.data.j();
                this.cgj.parserJson(oy);
                return this.cgj;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.j jVar) {
            NewVcodeActivity.this.cgb = null;
            if (jVar != null) {
                NewVcodeActivity.this.cfW.setVcodeMD5(jVar.getVcode_md5());
                NewVcodeActivity.this.cfW.setVcodeUrl(jVar.getVcode_pic_url());
                if (!jVar.rQ().equals("4")) {
                    if (NewVcodeActivity.this.cfW.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.akq();
                }
            } else {
                NewVcodeActivity.this.showToast(this.AR.getErrorString());
            }
            NewVcodeActivity.this.cfZ.setVisibility(8);
            super.onPostExecute(jVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cgb = null;
            if (this.AR != null) {
                this.AR.dJ();
            }
            NewVcodeActivity.this.cfZ.setVisibility(8);
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
            return NewVcodeActivity.this.cfW.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cgf = z;
            NewVcodeActivity.this.cgd = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cge = str;
                NewVcodeActivity.this.cgc = str2;
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
                NewVcodeActivity.this.cgc = str;
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
