package com.baidu.tieba.write.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private TextView esh;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private WriteData esg = null;
    private TextView epw = null;
    private ProgressBar esi = null;
    private ProgressBar esj = null;
    private DialogInterface.OnCancelListener cYA = null;
    private PostThreadTask esk = null;
    private ChangeVcodeTask esl = null;
    private BaseWebView mWebView = null;
    private String esm = null;
    private String esn = null;
    private String eso = null;
    private boolean esp = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    com.baidu.tieba.tbadkCore.e.b esq = new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!TextUtils.equals("VcodeJsInterface", str) || jsPromptResult == null) {
                return false;
            }
            if (TextUtils.equals("jsGetVcodeImageUrl", str2)) {
                jsPromptResult.confirm(NewVcodeActivity.this.esg.getVcodeUrl());
                return true;
            } else if (TextUtils.equals("jsSetLoadVcodeFinished", str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    NewVcodeActivity.this.q(jSONObject.optBoolean("canpost"), jSONObject.optString("callback"));
                } catch (JSONException e) {
                }
                jsPromptResult.confirm();
                return true;
            } else if (TextUtils.equals("jsSetVcodeInputResult", str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    NewVcodeActivity.this.b(jSONObject2.optBoolean("canpost"), jSONObject2.optString("val"), jSONObject2.optString("callback"));
                } catch (JSONException e2) {
                }
                jsPromptResult.confirm();
                return true;
            } else if (TextUtils.equals("jsChangeVcode", str2)) {
                try {
                    NewVcodeActivity.this.nL(new JSONObject(str3).optString("callback"));
                } catch (JSONException e3) {
                }
                jsPromptResult.confirm();
                return true;
            } else {
                return false;
            }
        }
    };
    private final View.OnClickListener esr = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener ess = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.anU();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.new_vcode_activity);
        qD();
        initData(bundle);
        if (qG()) {
            this.esi.setVisibility(0);
            anS();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.esq);
        if (bundle != null) {
            this.esg = (WriteData) bundle.getSerializable("model");
        } else {
            this.esg = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aUG();
                        return;
                    case 1:
                        NewVcodeActivity.this.anV();
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
    private boolean qG() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(t.g.new_vcode_webview);
                com.baidu.tbadk.core.util.ar.g(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
                    @Override // android.webkit.WebChromeClient
                    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                        if (NewVcodeActivity.this.jsBridge.a(str2, jsPromptResult)) {
                            return true;
                        }
                        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
                    }
                });
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.esi.setVisibility(8);
                        if (!NewVcodeActivity.this.esp) {
                            NewVcodeActivity.this.esh.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.esh.setVisibility(8);
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
                TbadkCoreApplication.m411getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUF() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anS() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        if (this.mWebView != null && this.esm != null && this.esm.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.esm + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anU() {
        if (this.mWebView != null && this.esp && this.esn != null && this.esn.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.esn + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esk != null) {
            this.esk.cancel();
        }
        if (this.esl != null) {
            this.esl.cancel();
        }
        if (this.esi != null) {
            this.esi.setVisibility(8);
        }
        if (this.esj != null) {
            this.esj.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.esg);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.esg != null && this.esg.getType() == 3) {
            if (this.esk != null) {
                this.esk.cancel();
            }
            if (this.esl != null) {
                this.esl.cancel();
            }
            if (this.esi != null) {
                this.esi.setVisibility(8);
            }
            if (this.esj != null) {
                this.esj.setVisibility(8);
            }
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.removeMessages(2);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ar.g((View) this.esh, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ar.g(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.ar.k(this.epw, t.f.s_navbar_button_bg);
    }

    private void qD() {
        this.esi = (ProgressBar) findViewById(t.g.load_webview_progress);
        this.esj = (ProgressBar) findViewById(t.g.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.esr);
        this.epw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(t.j.send), this.ess);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epw.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16);
        this.epw.setLayoutParams(layoutParams);
        this.esh = (TextView) findViewById(t.g.webview_fail_view);
        this.esh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.esp) {
                    NewVcodeActivity.this.esi.setVisibility(0);
                    NewVcodeActivity.this.aUF();
                    NewVcodeActivity.this.anS();
                }
            }
        });
        this.cYA = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.esk != null) {
                    NewVcodeActivity.this.esk.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anV() {
        if (this.esl != null) {
            this.esl.cancel();
        }
        this.esj.setVisibility(0);
        this.esl = new ChangeVcodeTask(this, null);
        this.esl.setPriority(3);
        this.esl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUG() {
        if (this.eso != null && this.eso.length() > 0) {
            Gp();
            if (this.esk != null) {
                this.esk.cancel();
            }
            this.esk = new PostThreadTask(this.esg);
            this.esk.setPriority(3);
            this.esk.execute(0);
        }
    }

    private void Gp() {
        this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(t.j.sending), true, true, this.cYA);
        this.mWaitingDialog.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private WriteData dZC;
        private com.baidu.tbadk.core.util.aa aiG = null;
        private String dZO = null;

        public PostThreadTask(WriteData writeData) {
            this.dZC = null;
            this.dZC = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01fb  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.d doInBackground(Integer... numArr) {
            String str;
            Address y;
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            JSONException jSONException;
            String str2;
            String str3;
            String str4;
            String str5;
            int i;
            if (this.dZC == null) {
                return null;
            }
            this.aiG = new com.baidu.tbadk.core.util.aa();
            String imagesCodeForPost = this.dZC.getImagesCodeForPost();
            if (this.dZC.getType() == 3) {
                this.aiG.p("newVcode", "1");
                this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dZC.getContent()) + imagesCodeForPost);
                this.aiG.p(PayVcodeActivityConfig.VCODE_MD5, this.dZC.getVcodeMD5());
                this.aiG.p("vcode", NewVcodeActivity.this.eso);
                this.aiG.p("tag", "11");
                this.aiG.vB().wv().mIsNeedTbs = true;
                this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dZC.getContent()) + imagesCodeForPost);
                this.aiG.setUrl(com.baidu.tieba.tbadkCore.c.a.dXF);
                this.aiG.p(ImageViewerConfig.FORUM_NAME, this.dZC.getForumName());
                this.aiG.p("title", this.dZC.getTitle());
                this.aiG.p("apiKey", this.dZC.getShareApiKey());
                this.aiG.p("appName", this.dZC.getShareAppName());
                this.aiG.p("signKey", this.dZC.getShareSignKey());
                this.aiG.p("summary_title", this.dZC.getShareSummaryTitle());
                this.aiG.p("summary_content", this.dZC.getShareSummaryContent());
                this.aiG.p("summary_img", this.dZC.getShareSummaryImg());
                this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dZC.getShareSummaryImgWidth()));
                this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dZC.getShareSummaryImgHeight()));
                this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dZC.getShareSummaryImgType());
                this.aiG.p("referUrl", this.dZC.getShareReferUrl());
            } else {
                this.aiG.p("anonymous", "0");
                this.aiG.p(ImageViewerConfig.FORUM_ID, this.dZC.getForumId());
                this.aiG.p("kw", this.dZC.getForumName());
                this.aiG.p("new_vcode", "1");
                VideoInfo videoInfo = this.dZC.getVideoInfo();
                if (videoInfo == null || !videoInfo.hasUpload()) {
                    str = String.valueOf(this.dZC.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.dZC.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                }
                if (this.dZC.getType() == 6 && this.dZC.getVoteInfo() != null) {
                    if (this.dZC.getWriteImagesInfo() != null) {
                        this.dZC.getVoteInfo().setServerImageCode(this.dZC.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.dZC.getVoteInfo().buildWriteContent();
                }
                this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.aiG, this.dZC);
                if (this.dZC.getIsBaobaoImageUploaded()) {
                    this.aiG.p("tail_type", String.valueOf(a.b.dXM));
                    this.aiG.p("tail_content", this.dZC.getBaobaoContent());
                    this.dZC.setBabaoPosted(true);
                } else {
                    this.dZC.setBabaoPosted(false);
                }
                this.aiG.p("vcode_md5", this.dZC.getVcodeMD5());
                this.aiG.p("vcode", NewVcodeActivity.this.eso);
                this.aiG.p("vcode_tag", "11");
                if (this.dZC.getVoice() != null) {
                    this.aiG.p("voice_md5", this.dZC.getVoice());
                    this.aiG.p("during_time", String.valueOf(this.dZC.getVoiceDuringTime()));
                }
                this.aiG.vB().wv().mIsNeedTbs = true;
                if (this.dZC.getType() == 0) {
                    this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aiG.p("title", this.dZC.getTitle());
                    this.aiG.p("is_ntitle", this.dZC.isNoTitle() ? "1" : "0");
                    if (NewVcodeActivity.this.esg.getCategoryFrom() >= 0) {
                        this.aiG.p("fromCategoryId", String.valueOf(NewVcodeActivity.this.esg.getCategoryFrom()));
                    }
                    if (NewVcodeActivity.this.esg.getCategoryTo() >= 0) {
                        this.aiG.p("toCategoryId", String.valueOf(NewVcodeActivity.this.esg.getCategoryTo()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gL().y(false)) != null) {
                        this.aiG.p("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.dZC.getType() == 6) {
                    this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aiG.p("title", this.dZC.getTitle());
                    this.aiG.p("is_ntitle", this.dZC.isNoTitle() ? "1" : "0");
                    this.aiG.p("thread_type", String.valueOf(36));
                } else if (this.dZC.getType() == 4) {
                    this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aiG.p("title", this.dZC.getTitle());
                    this.aiG.p("is_ntitle", "0");
                    this.aiG.p("thread_type", String.valueOf(33));
                    this.aiG.p("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.aiG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.aiG.p("tid", this.dZC.getThreadId());
                    this.aiG.p("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.dZC.getType() == 2) {
                        this.aiG.p("quote_id", String.valueOf(this.dZC.getFloor()));
                        this.aiG.p("floor_num", String.valueOf(this.dZC.getFloorNum()));
                        this.aiG.p(WriteActivityConfig.IS_ADDITION, this.dZC.isAddition() ? "1" : "0");
                        if (this.dZC.getRepostId() != null) {
                            this.aiG.p("repostid", this.dZC.getRepostId());
                        } else if (this.dZC.getType() == 5) {
                            this.aiG.p("is_twzhibo_thread", String.valueOf(1));
                        }
                    } else if (this.dZC.getType() == 1 && com.baidu.tbadk.editortools.d.b.Da().getStatus() == 1) {
                        this.aiG.p("ptype", "4");
                    }
                }
            }
            this.dZO = this.aiG.uZ();
            if (this.aiG.vB().ww().rl()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.dZO);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(t.j.send_success);
                } else if ((this.dZC.isHasImages() || this.dZC.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dZC.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.dZC.deleteUploadedTempImages();
                    if (this.dZC.getType() == 1 && !this.dZC.isSubFloor() && !this.dZC.getIsInterviewLive()) {
                        com.baidu.tieba.tbadkCore.ad.c(this.dZC.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.dZC.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dZC.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.aiG.vF(), TbadkCoreApplication.m411getInst().getString(t.j.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.aiG.vF(), this.aiG.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str6 = "";
                try {
                    String optString = new JSONObject(this.dZO).optString(AddFriendActivityConfig.MSG);
                    try {
                        str6 = new JSONObject(this.dZO).optString("tid");
                        String optString2 = new JSONObject(this.dZO).optString(Info.kBaiduPIDKey);
                        try {
                            JSONObject optJSONObject = new JSONObject(this.dZO).optJSONObject("twzhibo_info");
                            if (optJSONObject != null) {
                                i = optJSONObject.optInt("is_copytwzhibo", 0);
                                str5 = optString2;
                                str4 = str6;
                                str3 = optString;
                            } else {
                                i = 0;
                                str5 = optString2;
                                str4 = str6;
                                str3 = optString;
                            }
                        } catch (JSONException e) {
                            str2 = optString2;
                            str4 = str6;
                            str3 = optString;
                            jSONException = e;
                            jSONException.printStackTrace();
                            str5 = str2;
                            i = 0;
                            if (StringUtils.isNull(str3)) {
                            }
                            dVar.setErrorString(str3);
                            dVar.setThreadId(str4);
                            dVar.setPostId(str5);
                            dVar.setIsCopyTWZhibo(i);
                            return dVar;
                        }
                    } catch (JSONException e2) {
                        str4 = str6;
                        str3 = optString;
                        jSONException = e2;
                        str2 = "";
                    }
                } catch (JSONException e3) {
                    jSONException = e3;
                    str2 = "";
                    str3 = null;
                    str4 = "";
                }
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.m411getInst().getString(t.j.send_success);
                }
                dVar.setErrorString(str3);
                dVar.setThreadId(str4);
                dVar.setPostId(str5);
                dVar.setIsCopyTWZhibo(i);
                return dVar;
            }
            return dVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.esk = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.aiG != null) {
                this.aiG.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.d dVar) {
            super.onPostExecute(dVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.esk = null;
            if (dVar != null && this.aiG != null) {
                if (this.aiG.vB().ww().rl()) {
                    if (this.dZC.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.dZC != null && this.dZC.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aLM();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    postWriteCallBackData.setIsCopyTWZhibo(dVar.getIsCopyTWZhibo());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (dVar.aNI()) {
                    com.baidu.tbadk.coreExtra.data.n nVar = new com.baidu.tbadk.coreExtra.data.n();
                    nVar.parserJson(this.dZO);
                    if (nVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.esg.setVcodeMD5(nVar.getVcode_md5());
                        NewVcodeActivity.this.esg.setVcodeUrl(nVar.getVcode_pic_url());
                        if (nVar.yl().equals("4")) {
                            NewVcodeActivity.this.anT();
                        } else {
                            if (this.dZC.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(t.j.change_vcode_type));
                            }
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(dVar.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.n> {
        volatile com.baidu.tbadk.core.util.aa Ty;
        com.baidu.tbadk.coreExtra.data.n esu;

        private ChangeVcodeTask() {
            this.Ty = null;
            this.esu = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(String... strArr) {
            this.Ty = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Ty.p(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.esg.getForumId());
            this.Ty.p("kw", NewVcodeActivity.this.esg.getForumName());
            this.Ty.p("new_vcode", "1");
            this.Ty.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.esg.getContent());
            if (!NewVcodeActivity.this.esg.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.esg.setBabaoPosted(false);
            } else {
                this.Ty.p("tail_type", String.valueOf(a.b.dXM));
                this.Ty.p("tail_content", NewVcodeActivity.this.esg.getBaobaoContent());
                NewVcodeActivity.this.esg.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.esg.getVoice() != null) {
                this.Ty.p("voice_md5", NewVcodeActivity.this.esg.getVoice());
                this.Ty.p("during_time", String.valueOf(NewVcodeActivity.this.esg.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.esg.getType() == 0 || NewVcodeActivity.this.esg.getType() == 3) {
                this.Ty.p("title", NewVcodeActivity.this.esg.getTitle());
                this.Ty.p("pub_type", "1");
            } else {
                this.Ty.p("pub_type", "2");
                this.Ty.p("tid", NewVcodeActivity.this.esg.getThreadId());
            }
            this.Ty.p("vcode_tag", "11");
            if (NewVcodeActivity.this.esg.getCategoryFrom() >= 0) {
                this.Ty.p("fromCategoryId", String.valueOf(NewVcodeActivity.this.esg.getCategoryFrom()));
            }
            if (NewVcodeActivity.this.esg.getCategoryTo() >= 0) {
                this.Ty.p("toCategoryId", String.valueOf(NewVcodeActivity.this.esg.getCategoryTo()));
            }
            String uZ = this.Ty.uZ();
            if (this.Ty.vB().ww().rl()) {
                this.esu = new com.baidu.tbadk.coreExtra.data.n();
                this.esu.parserJson(uZ);
                return this.esu;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            NewVcodeActivity.this.esl = null;
            if (nVar != null) {
                NewVcodeActivity.this.esg.setVcodeMD5(nVar.getVcode_md5());
                NewVcodeActivity.this.esg.setVcodeUrl(nVar.getVcode_pic_url());
                if (!nVar.yl().equals("4")) {
                    if (NewVcodeActivity.this.esg.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(t.j.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.anT();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Ty.getErrorString());
            }
            NewVcodeActivity.this.esj.setVisibility(8);
            super.onPostExecute(nVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.esl = null;
            if (this.Ty != null) {
                this.Ty.gT();
            }
            NewVcodeActivity.this.esj.setVisibility(8);
            super.cancel(true);
        }
    }

    public void q(boolean z, String str) {
        this.esp = z;
        this.esn = str;
    }

    public void b(boolean z, String str, String str2) {
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, getPageContext().getString(t.j.finish_input_vcode)));
            }
        } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            this.eso = str;
            this.esm = str2;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
            }
        }
    }

    public void nL(String str) {
        if (str != null && str.length() > 0) {
            this.esm = str;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        }
    }
}
