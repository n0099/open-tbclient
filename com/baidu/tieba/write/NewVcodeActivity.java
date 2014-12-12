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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
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
    private TextView cey;
    private WriteData cex = null;
    private TextView bOb = null;
    private ProgressBar cez = null;
    private ProgressBar ceA = null;
    private DialogInterface.OnCancelListener bFV = null;
    private PostThreadTask ceB = null;
    private ChangeVcodeTask ceC = null;
    private BaseWebView mWebView = null;
    private String ceD = null;
    private String ceE = null;
    private String ceF = null;
    private boolean ceG = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener ceH = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener ceI = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.ajU();
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
        if (ajQ()) {
            this.cez.setVisibility(0);
            ajS();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cex = (WriteData) bundle.getSerializable("model");
        } else {
            this.cex = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.ajW();
                        return;
                    case 1:
                        NewVcodeActivity.this.ajV();
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
    private boolean ajQ() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.w.new_vcode_webview);
                com.baidu.tbadk.core.util.ax.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.cez.setVisibility(8);
                        if (!NewVcodeActivity.this.ceG) {
                            NewVcodeActivity.this.cey.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cey.setVisibility(8);
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
    public void ajR() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajS() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajT() {
        if (this.mWebView != null && this.ceD != null && this.ceD.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.ceD + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajU() {
        if (this.mWebView != null && this.ceG && this.ceE != null && this.ceE.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.ceE + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ceB != null) {
            this.ceB.cancel();
        }
        if (this.ceC != null) {
            this.ceC.cancel();
        }
        if (this.cez != null) {
            this.cez.setVisibility(8);
        }
        if (this.ceA != null) {
            this.ceA.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cex);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cex != null && this.cex.getType() == 3) {
            if (this.ceB != null) {
                this.ceB.cancel();
            }
            if (this.ceC != null) {
                this.ceC.cancel();
            }
            if (this.cez != null) {
                this.cez.setVisibility(8);
            }
            if (this.ceA != null) {
                this.ceA.setVisibility(8);
            }
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.removeMessages(2);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), Constants.MEDIA_INFO, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ax.g(this.bOb, i);
        com.baidu.tbadk.core.util.ax.e((View) this.cey, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ax.e(this.mWebView, TbadkCoreApplication.m255getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cez = (ProgressBar) findViewById(com.baidu.tieba.w.load_webview_progress);
        this.ceA = (ProgressBar) findViewById(com.baidu.tieba.w.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ceH);
        this.bOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.send), this.ceI);
        this.cey = (TextView) findViewById(com.baidu.tieba.w.webview_fail_view);
        this.cey.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.ceG) {
                    NewVcodeActivity.this.cez.setVisibility(0);
                    NewVcodeActivity.this.ajR();
                    NewVcodeActivity.this.ajS();
                }
            }
        });
        this.bFV = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.ceB != null) {
                    NewVcodeActivity.this.ceB.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajV() {
        if (this.ceC != null) {
            this.ceC.cancel();
        }
        this.ceA.setVisibility(0);
        this.ceC = new ChangeVcodeTask(this, null);
        this.ceC.setPriority(3);
        this.ceC.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        if (this.ceF != null && this.ceF.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.z.sending), true, true, this.bFV);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.ceB != null) {
                this.ceB.cancel();
            }
            this.ceB = new PostThreadTask(this.cex);
            this.ceB.setPriority(3);
            this.ceB.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.f.e> {
        private com.baidu.tbadk.core.util.ad CV = null;
        private String Qj = null;
        private WriteData bNF;

        public PostThreadTask(WriteData writeData) {
            this.bNF = null;
            this.bNF = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public com.baidu.tieba.tbadkCore.f.e doInBackground(Integer... numArr) {
            Address z;
            com.baidu.tieba.tbadkCore.f.e eVar;
            String str;
            if (this.bNF == null) {
                return null;
            }
            this.CV = new com.baidu.tbadk.core.util.ad();
            String imagesCodeForPost = this.bNF.getImagesCodeForPost();
            if (this.bNF.getType() == 3) {
                this.CV.o("newVcode", "1");
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bNF.getContent()) + imagesCodeForPost);
                this.CV.o("vcodeMd5", this.bNF.getVcodeMD5());
                this.CV.o("vcode", NewVcodeActivity.this.ceF);
                this.CV.o("tag", "11");
                this.CV.oW().pV().mIsNeedTbs = true;
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bNF.getContent()) + imagesCodeForPost);
                this.CV.setUrl(com.baidu.tieba.tbadkCore.c.a.bXm);
                this.CV.o(ImageViewerConfig.FORUM_NAME, this.bNF.getForumName());
                this.CV.o("title", this.bNF.getTitle());
                this.CV.o("apiKey", this.bNF.getShareApiKey());
                this.CV.o("appName", this.bNF.getShareAppName());
                this.CV.o("signKey", this.bNF.getShareSignKey());
                this.CV.o("summary_title", this.bNF.getShareSummaryTitle());
                this.CV.o("summary_content", this.bNF.getShareSummaryContent());
                this.CV.o("summary_img", this.bNF.getShareSummaryImg());
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bNF.getShareSummaryImgWidth()));
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bNF.getShareSummaryImgHeight()));
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bNF.getShareSummaryImgType());
                this.CV.o("referUrl", this.bNF.getShareReferUrl());
            } else {
                this.CV.o("anonymous", "0");
                this.CV.o(ImageViewerConfig.FORUM_ID, this.bNF.getForumId());
                this.CV.o("kw", this.bNF.getForumName());
                this.CV.o("new_vcode", "1");
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.bNF.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.f.g.a(this.CV, this.bNF);
                if (this.bNF.getIsBaobaoImageUploaded()) {
                    this.CV.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bXp));
                    this.CV.o("tail_content", this.bNF.getBaobaoContent());
                    this.bNF.setBabaoPosted(true);
                } else {
                    this.bNF.setBabaoPosted(false);
                }
                this.CV.o("vcode_md5", this.bNF.getVcodeMD5());
                this.CV.o("vcode", NewVcodeActivity.this.ceF);
                this.CV.o("vcode_tag", "11");
                if (this.bNF.getVoice() != null) {
                    this.CV.o("voice_md5", this.bNF.getVoice());
                    this.CV.o("during_time", String.valueOf(this.bNF.getVoiceDuringTime()));
                }
                this.CV.oW().pV().mIsNeedTbs = true;
                if (this.bNF.getType() == 0) {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CV.o("title", this.bNF.getTitle());
                    this.CV.o("is_ntitle", this.bNF.isNoTitle() ? "1" : "0");
                    if (this.bNF.getLiveCardData() != null) {
                        this.CV.o("group_id", String.valueOf(this.bNF.getLiveCardData().getGroupId()));
                        this.CV.o("start_time", String.valueOf(this.bNF.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dD().z(false)) != null) {
                        this.CV.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CV.o("tid", this.bNF.getThreadId());
                    this.CV.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bNF.getType() == 2) {
                        this.CV.o("quote_id", String.valueOf(this.bNF.getFloor()));
                        this.CV.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bNF.getFloorNum()));
                        this.CV.o(WriteActivityConfig.IS_ADDITION, this.bNF.isAddition() ? "1" : "0");
                        if (this.bNF.getRepostId() != null) {
                            this.CV.o("repostid", this.bNF.getRepostId());
                        }
                    }
                }
            }
            this.Qj = this.CV.ov();
            if (this.CV.oW().pW().ma()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.Qj);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.k.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                } else if ((this.bNF.isHasImages() || this.bNF.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bNF.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.f.e eVar2 = new com.baidu.tieba.tbadkCore.f.e(errorData.getError_code(), error_msg, null);
                if (!eVar2.hasError()) {
                    this.bNF.deleteUploadedTempImages();
                    if (this.bNF.getType() == 1 && !this.bNF.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.al.b(this.bNF.getThreadId(), (WriteData) null);
                        eVar = eVar2;
                    }
                }
                eVar = eVar2;
            } else if (this.bNF.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.bNF.getContent()) + imagesCodeForPost)) {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CV.pa(), TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error), null);
            } else {
                eVar = new com.baidu.tieba.tbadkCore.f.e(this.CV.pa(), this.CV.getErrorString(), null);
            }
            if (!eVar.hasError()) {
                try {
                    str = new JSONObject(this.Qj).optString(AddFriendActivityConfig.MSG);
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
            NewVcodeActivity.this.ceB = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.CV != null) {
                this.CV.dL();
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
            NewVcodeActivity.this.ceB = null;
            if (eVar != null && this.CV != null) {
                if (this.CV.oW().pW().ma()) {
                    if (this.bNF.getType() != 3) {
                        if (eVar.hasError()) {
                            NewVcodeActivity.this.showToast(eVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.f.g.d(NewVcodeActivity.this.getPageContext().getPageActivity(), eVar.getErrorString(), eVar.aie(), eVar.aif());
                        }
                    }
                    if (this.bNF.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.bNF.getForumName(), "post live's thread")));
                    }
                    if (this.bNF != null && this.bNF.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aeK();
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (eVar.aid()) {
                    com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                    jVar.parserJson(this.Qj);
                    if (jVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cex.setVcodeMD5(jVar.getVcode_md5());
                        NewVcodeActivity.this.cex.setVcodeUrl(jVar.getVcode_pic_url());
                        if (jVar.rD().equals("4")) {
                            NewVcodeActivity.this.ajT();
                        } else {
                            if (this.bNF.getType() != 3) {
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
        com.baidu.tbadk.coreExtra.data.j ceK;

        private ChangeVcodeTask() {
            this.AR = null;
            this.ceK = null;
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
            this.AR.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cex.getForumId());
            this.AR.o("kw", NewVcodeActivity.this.cex.getForumName());
            this.AR.o("new_vcode", "1");
            this.AR.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cex.getContent());
            if (!NewVcodeActivity.this.cex.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cex.setBabaoPosted(false);
            } else {
                this.AR.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bXp));
                this.AR.o("tail_content", NewVcodeActivity.this.cex.getBaobaoContent());
                NewVcodeActivity.this.cex.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cex.getVoice() != null) {
                this.AR.o("voice_md5", NewVcodeActivity.this.cex.getVoice());
                this.AR.o("during_time", String.valueOf(NewVcodeActivity.this.cex.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cex.getType() == 0 || NewVcodeActivity.this.cex.getType() == 3) {
                this.AR.o("title", NewVcodeActivity.this.cex.getTitle());
                this.AR.o("pub_type", "1");
            } else {
                this.AR.o("pub_type", "2");
                this.AR.o("tid", NewVcodeActivity.this.cex.getThreadId());
            }
            this.AR.o("vcode_tag", "11");
            String ov = this.AR.ov();
            if (this.AR.oW().pW().ma()) {
                this.ceK = new com.baidu.tbadk.coreExtra.data.j();
                this.ceK.parserJson(ov);
                return this.ceK;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.j jVar) {
            NewVcodeActivity.this.ceC = null;
            if (jVar != null) {
                NewVcodeActivity.this.cex.setVcodeMD5(jVar.getVcode_md5());
                NewVcodeActivity.this.cex.setVcodeUrl(jVar.getVcode_pic_url());
                if (!jVar.rD().equals("4")) {
                    if (NewVcodeActivity.this.cex.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.ajT();
                }
            } else {
                NewVcodeActivity.this.showToast(this.AR.getErrorString());
            }
            NewVcodeActivity.this.ceA.setVisibility(8);
            super.onPostExecute(jVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.ceC = null;
            if (this.AR != null) {
                this.AR.dL();
            }
            NewVcodeActivity.this.ceA.setVisibility(8);
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
            return NewVcodeActivity.this.cex.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.ceG = z;
            NewVcodeActivity.this.ceE = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.z.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.ceF = str;
                NewVcodeActivity.this.ceD = str2;
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
                NewVcodeActivity.this.ceD = str;
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
