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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private TextView dPQ;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private WriteData dPP = null;
    private TextView dNs = null;
    private ProgressBar dPR = null;
    private ProgressBar dPS = null;
    private DialogInterface.OnCancelListener cKN = null;
    private PostThreadTask dPT = null;
    private ChangeVcodeTask dPU = null;
    private BaseWebView mWebView = null;
    private String dPV = null;
    private String dPW = null;
    private String dPX = null;
    private boolean dPY = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    com.baidu.tieba.tbadkCore.e.b dPZ = new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!TextUtils.equals("VcodeJsInterface", str) || jsPromptResult == null) {
                return false;
            }
            if (TextUtils.equals("jsGetVcodeImageUrl", str2)) {
                jsPromptResult.confirm(NewVcodeActivity.this.dPP.getVcodeUrl());
                return true;
            } else if (TextUtils.equals("jsSetLoadVcodeFinished", str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    NewVcodeActivity.this.p(jSONObject.optBoolean("canpost"), jSONObject.optString("callback"));
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
                    NewVcodeActivity.this.nv(new JSONObject(str3).optString("callback"));
                } catch (JSONException e3) {
                }
                jsPromptResult.confirm();
                return true;
            } else {
                return false;
            }
        }
    };
    private final View.OnClickListener dQa = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener dQb = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.aiR();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qC()) {
            this.dPR.setVisibility(0);
            aiP();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.dPZ);
        if (bundle != null) {
            this.dPP = (WriteData) bundle.getSerializable("model");
        } else {
            this.dPP = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aJq();
                        return;
                    case 1:
                        NewVcodeActivity.this.aiS();
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
    private boolean qC() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(n.f.new_vcode_webview);
                com.baidu.tbadk.core.util.as.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
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
                        NewVcodeActivity.this.dPR.setVisibility(8);
                        if (!NewVcodeActivity.this.dPY) {
                            NewVcodeActivity.this.dPQ.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.dPQ.setVisibility(8);
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
    public void aJp() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiP() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiQ() {
        if (this.mWebView != null && this.dPV != null && this.dPV.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dPV + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        if (this.mWebView != null && this.dPY && this.dPW != null && this.dPW.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dPW + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPT != null) {
            this.dPT.cancel();
        }
        if (this.dPU != null) {
            this.dPU.cancel();
        }
        if (this.dPR != null) {
            this.dPR.setVisibility(8);
        }
        if (this.dPS != null) {
            this.dPS.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dPP);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dPP != null && this.dPP.getType() == 3) {
            if (this.dPT != null) {
                this.dPT.cancel();
            }
            if (this.dPU != null) {
                this.dPU.cancel();
            }
            if (this.dPR != null) {
                this.dPR.setVisibility(8);
            }
            if (this.dPS != null) {
                this.dPS.setVisibility(8);
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
        com.baidu.tbadk.core.util.as.e((View) this.dPQ, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.as.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.as.i((View) this.dNs, n.e.s_navbar_button_bg);
    }

    private void initUI() {
        this.dPR = (ProgressBar) findViewById(n.f.load_webview_progress);
        this.dPS = (ProgressBar) findViewById(n.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dQa);
        this.dNs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.i.send), this.dQb);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dNs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.dNs.setLayoutParams(layoutParams);
        this.dPQ = (TextView) findViewById(n.f.webview_fail_view);
        this.dPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.dPY) {
                    NewVcodeActivity.this.dPR.setVisibility(0);
                    NewVcodeActivity.this.aJp();
                    NewVcodeActivity.this.aiP();
                }
            }
        });
        this.cKN = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.dPT != null) {
                    NewVcodeActivity.this.dPT.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiS() {
        if (this.dPU != null) {
            this.dPU.cancel();
        }
        this.dPS.setVisibility(0);
        this.dPU = new ChangeVcodeTask(this, null);
        this.dPU.setPriority(3);
        this.dPU.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJq() {
        if (this.dPX != null && this.dPX.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(n.i.sending), true, true, this.cKN);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.dPT != null) {
                this.dPT.cancel();
            }
            this.dPT = new PostThreadTask(this.dPP);
            this.dPT.setPriority(3);
            this.dPT.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private WriteData dBW;
        private com.baidu.tbadk.core.util.ab agS = null;
        private String dCh = null;

        public PostThreadTask(WriteData writeData) {
            this.dBW = null;
            this.dBW = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01da  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.d doInBackground(Integer... numArr) {
            String str;
            Address y;
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            String str2;
            String str3;
            JSONException e;
            if (this.dBW == null) {
                return null;
            }
            this.agS = new com.baidu.tbadk.core.util.ab();
            String imagesCodeForPost = this.dBW.getImagesCodeForPost();
            if (this.dBW.getType() == 3) {
                this.agS.o("newVcode", "1");
                this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dBW.getContent()) + imagesCodeForPost);
                this.agS.o(PayVcodeActivityConfig.VCODE_MD5, this.dBW.getVcodeMD5());
                this.agS.o("vcode", NewVcodeActivity.this.dPX);
                this.agS.o("tag", "11");
                this.agS.uM().vF().mIsNeedTbs = true;
                this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dBW.getContent()) + imagesCodeForPost);
                this.agS.setUrl(com.baidu.tieba.tbadkCore.c.a.dAd);
                this.agS.o(ImageViewerConfig.FORUM_NAME, this.dBW.getForumName());
                this.agS.o("title", this.dBW.getTitle());
                this.agS.o("apiKey", this.dBW.getShareApiKey());
                this.agS.o("appName", this.dBW.getShareAppName());
                this.agS.o("signKey", this.dBW.getShareSignKey());
                this.agS.o("summary_title", this.dBW.getShareSummaryTitle());
                this.agS.o("summary_content", this.dBW.getShareSummaryContent());
                this.agS.o("summary_img", this.dBW.getShareSummaryImg());
                this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dBW.getShareSummaryImgWidth()));
                this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dBW.getShareSummaryImgHeight()));
                this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dBW.getShareSummaryImgType());
                this.agS.o("referUrl", this.dBW.getShareReferUrl());
            } else {
                this.agS.o("anonymous", "0");
                this.agS.o(ImageViewerConfig.FORUM_ID, this.dBW.getForumId());
                this.agS.o("kw", this.dBW.getForumName());
                this.agS.o("new_vcode", "1");
                VideoInfo videoInfo = this.dBW.getVideoInfo();
                if (videoInfo == null || !videoInfo.hasUpload()) {
                    str = String.valueOf(this.dBW.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.dBW.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                }
                if (this.dBW.getType() == 6 && this.dBW.getVoteInfo() != null) {
                    if (this.dBW.getWriteImagesInfo() != null) {
                        this.dBW.getVoteInfo().setServerImageCode(this.dBW.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.dBW.getVoteInfo().buildWriteContent();
                }
                this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.agS, this.dBW);
                if (this.dBW.getIsBaobaoImageUploaded()) {
                    this.agS.o("tail_type", String.valueOf(a.C0085a.dAh));
                    this.agS.o("tail_content", this.dBW.getBaobaoContent());
                    this.dBW.setBabaoPosted(true);
                } else {
                    this.dBW.setBabaoPosted(false);
                }
                this.agS.o("vcode_md5", this.dBW.getVcodeMD5());
                this.agS.o("vcode", NewVcodeActivity.this.dPX);
                this.agS.o("vcode_tag", "11");
                if (this.dBW.getVoice() != null) {
                    this.agS.o("voice_md5", this.dBW.getVoice());
                    this.agS.o("during_time", String.valueOf(this.dBW.getVoiceDuringTime()));
                }
                this.agS.uM().vF().mIsNeedTbs = true;
                if (this.dBW.getType() == 0) {
                    this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.agS.o("title", this.dBW.getTitle());
                    this.agS.o("is_ntitle", this.dBW.isNoTitle() ? "1" : "0");
                    if (NewVcodeActivity.this.dPP.getCategoryFrom() >= 0) {
                        this.agS.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dPP.getCategoryFrom()));
                    }
                    if (NewVcodeActivity.this.dPP.getCategoryTo() >= 0) {
                        this.agS.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dPP.getCategoryTo()));
                    }
                    if (this.dBW.getLiveCardData() != null) {
                        this.agS.o("group_id", String.valueOf(this.dBW.getLiveCardData().getGroupId()));
                        this.agS.o("start_time", String.valueOf(this.dBW.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gD().y(false)) != null) {
                        this.agS.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.dBW.getType() == 6) {
                    this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.agS.o("title", this.dBW.getTitle());
                    this.agS.o("is_ntitle", this.dBW.isNoTitle() ? "1" : "0");
                    this.agS.o("thread_type", String.valueOf(36));
                } else if (this.dBW.getType() == 4) {
                    this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.agS.o("title", this.dBW.getTitle());
                    this.agS.o("is_ntitle", "0");
                    this.agS.o("thread_type", String.valueOf(33));
                    this.agS.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.agS.o("tid", this.dBW.getThreadId());
                    this.agS.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.dBW.getType() == 2) {
                        this.agS.o("quote_id", String.valueOf(this.dBW.getFloor()));
                        this.agS.o("floor_num", String.valueOf(this.dBW.getFloorNum()));
                        this.agS.o(WriteActivityConfig.IS_ADDITION, this.dBW.isAddition() ? "1" : "0");
                        if (this.dBW.getRepostId() != null) {
                            this.agS.o("repostid", this.dBW.getRepostId());
                        } else if (this.dBW.getType() == 5) {
                            this.agS.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    } else if (this.dBW.getType() == 1 && com.baidu.tbadk.editortools.d.b.BV().getStatus() == 1) {
                        this.agS.o("ptype", "4");
                    }
                }
            }
            this.dCh = this.agS.ul();
            if (this.agS.uM().vG().rf()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.dCh);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(n.i.send_success);
                } else if ((this.dBW.isHasImages() || this.dBW.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dBW.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(n.i.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.dBW.deleteUploadedTempImages();
                    if (this.dBW.getType() == 1 && !this.dBW.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ae.c(this.dBW.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.dBW.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dBW.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.agS.uQ(), TbadkCoreApplication.m411getInst().getString(n.i.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.agS.uQ(), this.agS.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.dCh).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.dCh).optString("tid");
                    } catch (JSONException e2) {
                        str3 = "";
                        e = e2;
                    }
                    try {
                        str4 = new JSONObject(this.dCh).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (StringUtils.isNull(str2)) {
                        }
                        dVar.setErrorString(str2);
                        dVar.setThreadId(str3);
                        dVar.setPostId(str4);
                        return dVar;
                    }
                } catch (JSONException e4) {
                    str2 = null;
                    str3 = "";
                    e = e4;
                }
                if (StringUtils.isNull(str2)) {
                    str2 = TbadkCoreApplication.m411getInst().getString(n.i.send_success);
                }
                dVar.setErrorString(str2);
                dVar.setThreadId(str3);
                dVar.setPostId(str4);
                return dVar;
            }
            return dVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dPT = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.agS != null) {
                this.agS.gL();
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
            NewVcodeActivity.this.dPT = null;
            if (dVar != null && this.agS != null) {
                if (this.agS.uM().vG().rf()) {
                    if (this.dBW.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.dBW.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dBW.getForumName(), "post live's thread")));
                    }
                    if (this.dBW != null && this.dBW.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aCz();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (dVar.aEq()) {
                    com.baidu.tbadk.coreExtra.data.n nVar = new com.baidu.tbadk.coreExtra.data.n();
                    nVar.parserJson(this.dCh);
                    if (nVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.dPP.setVcodeMD5(nVar.getVcode_md5());
                        NewVcodeActivity.this.dPP.setVcodeUrl(nVar.getVcode_pic_url());
                        if (nVar.xp().equals("4")) {
                            NewVcodeActivity.this.aiQ();
                        } else {
                            if (this.dBW.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(n.i.change_vcode_type));
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
        volatile com.baidu.tbadk.core.util.ab Ty;
        com.baidu.tbadk.coreExtra.data.n dQd;

        private ChangeVcodeTask() {
            this.Ty = null;
            this.dQd = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(String... strArr) {
            this.Ty = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Ty.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.dPP.getForumId());
            this.Ty.o("kw", NewVcodeActivity.this.dPP.getForumName());
            this.Ty.o("new_vcode", "1");
            this.Ty.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.dPP.getContent());
            if (!NewVcodeActivity.this.dPP.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.dPP.setBabaoPosted(false);
            } else {
                this.Ty.o("tail_type", String.valueOf(a.C0085a.dAh));
                this.Ty.o("tail_content", NewVcodeActivity.this.dPP.getBaobaoContent());
                NewVcodeActivity.this.dPP.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.dPP.getVoice() != null) {
                this.Ty.o("voice_md5", NewVcodeActivity.this.dPP.getVoice());
                this.Ty.o("during_time", String.valueOf(NewVcodeActivity.this.dPP.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.dPP.getType() == 0 || NewVcodeActivity.this.dPP.getType() == 3) {
                this.Ty.o("title", NewVcodeActivity.this.dPP.getTitle());
                this.Ty.o("pub_type", "1");
            } else {
                this.Ty.o("pub_type", "2");
                this.Ty.o("tid", NewVcodeActivity.this.dPP.getThreadId());
            }
            this.Ty.o("vcode_tag", "11");
            if (NewVcodeActivity.this.dPP.getCategoryFrom() >= 0) {
                this.Ty.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dPP.getCategoryFrom()));
            }
            if (NewVcodeActivity.this.dPP.getCategoryTo() >= 0) {
                this.Ty.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dPP.getCategoryTo()));
            }
            String ul = this.Ty.ul();
            if (this.Ty.uM().vG().rf()) {
                this.dQd = new com.baidu.tbadk.coreExtra.data.n();
                this.dQd.parserJson(ul);
                return this.dQd;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            NewVcodeActivity.this.dPU = null;
            if (nVar != null) {
                NewVcodeActivity.this.dPP.setVcodeMD5(nVar.getVcode_md5());
                NewVcodeActivity.this.dPP.setVcodeUrl(nVar.getVcode_pic_url());
                if (!nVar.xp().equals("4")) {
                    if (NewVcodeActivity.this.dPP.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(n.i.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.aiQ();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Ty.getErrorString());
            }
            NewVcodeActivity.this.dPS.setVisibility(8);
            super.onPostExecute(nVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dPU = null;
            if (this.Ty != null) {
                this.Ty.gL();
            }
            NewVcodeActivity.this.dPS.setVisibility(8);
            super.cancel(true);
        }
    }

    public void p(boolean z, String str) {
        this.dPY = z;
        this.dPW = str;
    }

    public void b(boolean z, String str, String str2) {
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, getPageContext().getString(n.i.finish_input_vcode)));
            }
        } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            this.dPX = str;
            this.dPV = str2;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
            }
        }
    }

    public void nv(String str) {
        if (str != null && str.length() > 0) {
            this.dPV = str;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        }
    }
}
