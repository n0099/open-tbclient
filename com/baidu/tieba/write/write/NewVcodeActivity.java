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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    private TextView dXo;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private WriteData dXn = null;
    private TextView dUR = null;
    private ProgressBar dXp = null;
    private ProgressBar dXq = null;
    private DialogInterface.OnCancelListener cPd = null;
    private PostThreadTask dXr = null;
    private ChangeVcodeTask dXs = null;
    private BaseWebView mWebView = null;
    private String dXt = null;
    private String dXu = null;
    private String dXv = null;
    private boolean dXw = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    com.baidu.tieba.tbadkCore.e.b dXx = new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!TextUtils.equals("VcodeJsInterface", str) || jsPromptResult == null) {
                return false;
            }
            if (TextUtils.equals("jsGetVcodeImageUrl", str2)) {
                jsPromptResult.confirm(NewVcodeActivity.this.dXn.getVcodeUrl());
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
                    NewVcodeActivity.this.nt(new JSONObject(str3).optString("callback"));
                } catch (JSONException e3) {
                }
                jsPromptResult.confirm();
                return true;
            } else {
                return false;
            }
        }
    };
    private final View.OnClickListener dXy = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener dXz = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.ajX();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.new_vcode_activity);
        initUI();
        initData(bundle);
        if (ql()) {
            this.dXp.setVisibility(0);
            ajV();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(this.dXx);
        if (bundle != null) {
            this.dXn = (WriteData) bundle.getSerializable("model");
        } else {
            this.dXn = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aLL();
                        return;
                    case 1:
                        NewVcodeActivity.this.ajY();
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
    private boolean ql() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(n.g.new_vcode_webview);
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
                        NewVcodeActivity.this.dXp.setVisibility(8);
                        if (!NewVcodeActivity.this.dXw) {
                            NewVcodeActivity.this.dXo.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.dXo.setVisibility(8);
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
    public void aLK() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajV() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        if (this.mWebView != null && this.dXt != null && this.dXt.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dXt + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajX() {
        if (this.mWebView != null && this.dXw && this.dXu != null && this.dXu.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dXu + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dXr != null) {
            this.dXr.cancel();
        }
        if (this.dXs != null) {
            this.dXs.cancel();
        }
        if (this.dXp != null) {
            this.dXp.setVisibility(8);
        }
        if (this.dXq != null) {
            this.dXq.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dXn);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dXn != null && this.dXn.getType() == 3) {
            if (this.dXr != null) {
                this.dXr.cancel();
            }
            if (this.dXs != null) {
                this.dXs.cancel();
            }
            if (this.dXp != null) {
                this.dXp.setVisibility(8);
            }
            if (this.dXq != null) {
                this.dXq.setVisibility(8);
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
        com.baidu.tbadk.core.util.as.e((View) this.dXo, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.as.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.as.i((View) this.dUR, n.f.s_navbar_button_bg);
    }

    private void initUI() {
        this.dXp = (ProgressBar) findViewById(n.g.load_webview_progress);
        this.dXq = (ProgressBar) findViewById(n.g.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dXy);
        this.dUR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.j.send), this.dXz);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.e.ds16);
        this.dUR.setLayoutParams(layoutParams);
        this.dXo = (TextView) findViewById(n.g.webview_fail_view);
        this.dXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.dXw) {
                    NewVcodeActivity.this.dXp.setVisibility(0);
                    NewVcodeActivity.this.aLK();
                    NewVcodeActivity.this.ajV();
                }
            }
        });
        this.cPd = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.dXr != null) {
                    NewVcodeActivity.this.dXr.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajY() {
        if (this.dXs != null) {
            this.dXs.cancel();
        }
        this.dXq.setVisibility(0);
        this.dXs = new ChangeVcodeTask(this, null);
        this.dXs.setPriority(3);
        this.dXs.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLL() {
        if (this.dXv != null && this.dXv.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(n.j.sending), true, true, this.cPd);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.dXr != null) {
                this.dXr.cancel();
            }
            this.dXr = new PostThreadTask(this.dXn);
            this.dXr.setPriority(3);
            this.dXr.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tbadk.core.util.ab ahV = null;
        private String dJJ = null;
        private WriteData dJy;

        public PostThreadTask(WriteData writeData) {
            this.dJy = null;
            this.dJy = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01f3  */
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
            String optString;
            String optString2;
            if (this.dJy == null) {
                return null;
            }
            this.ahV = new com.baidu.tbadk.core.util.ab();
            String imagesCodeForPost = this.dJy.getImagesCodeForPost();
            if (this.dJy.getType() == 3) {
                this.ahV.o("newVcode", "1");
                this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dJy.getContent()) + imagesCodeForPost);
                this.ahV.o(PayVcodeActivityConfig.VCODE_MD5, this.dJy.getVcodeMD5());
                this.ahV.o("vcode", NewVcodeActivity.this.dXv);
                this.ahV.o("tag", "11");
                this.ahV.uw().vp().mIsNeedTbs = true;
                this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dJy.getContent()) + imagesCodeForPost);
                this.ahV.setUrl(com.baidu.tieba.tbadkCore.c.a.dHI);
                this.ahV.o(ImageViewerConfig.FORUM_NAME, this.dJy.getForumName());
                this.ahV.o("title", this.dJy.getTitle());
                this.ahV.o("apiKey", this.dJy.getShareApiKey());
                this.ahV.o("appName", this.dJy.getShareAppName());
                this.ahV.o("signKey", this.dJy.getShareSignKey());
                this.ahV.o("summary_title", this.dJy.getShareSummaryTitle());
                this.ahV.o("summary_content", this.dJy.getShareSummaryContent());
                this.ahV.o("summary_img", this.dJy.getShareSummaryImg());
                this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dJy.getShareSummaryImgWidth()));
                this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dJy.getShareSummaryImgHeight()));
                this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dJy.getShareSummaryImgType());
                this.ahV.o("referUrl", this.dJy.getShareReferUrl());
            } else {
                this.ahV.o("anonymous", "0");
                this.ahV.o(ImageViewerConfig.FORUM_ID, this.dJy.getForumId());
                this.ahV.o("kw", this.dJy.getForumName());
                this.ahV.o("new_vcode", "1");
                VideoInfo videoInfo = this.dJy.getVideoInfo();
                if (videoInfo == null || !videoInfo.hasUpload()) {
                    str = String.valueOf(this.dJy.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.dJy.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                }
                if (this.dJy.getType() == 6 && this.dJy.getVoteInfo() != null) {
                    if (this.dJy.getWriteImagesInfo() != null) {
                        this.dJy.getVoteInfo().setServerImageCode(this.dJy.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.dJy.getVoteInfo().buildWriteContent();
                }
                this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.ahV, this.dJy);
                if (this.dJy.getIsBaobaoImageUploaded()) {
                    this.ahV.o("tail_type", String.valueOf(a.C0081a.dHM));
                    this.ahV.o("tail_content", this.dJy.getBaobaoContent());
                    this.dJy.setBabaoPosted(true);
                } else {
                    this.dJy.setBabaoPosted(false);
                }
                this.ahV.o("vcode_md5", this.dJy.getVcodeMD5());
                this.ahV.o("vcode", NewVcodeActivity.this.dXv);
                this.ahV.o("vcode_tag", "11");
                if (this.dJy.getVoice() != null) {
                    this.ahV.o("voice_md5", this.dJy.getVoice());
                    this.ahV.o("during_time", String.valueOf(this.dJy.getVoiceDuringTime()));
                }
                this.ahV.uw().vp().mIsNeedTbs = true;
                if (this.dJy.getType() == 0) {
                    this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ahV.o("title", this.dJy.getTitle());
                    this.ahV.o("is_ntitle", this.dJy.isNoTitle() ? "1" : "0");
                    if (NewVcodeActivity.this.dXn.getCategoryFrom() >= 0) {
                        this.ahV.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dXn.getCategoryFrom()));
                    }
                    if (NewVcodeActivity.this.dXn.getCategoryTo() >= 0) {
                        this.ahV.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dXn.getCategoryTo()));
                    }
                    if (this.dJy.getLiveCardData() != null) {
                        this.ahV.o("group_id", String.valueOf(this.dJy.getLiveCardData().getGroupId()));
                        this.ahV.o("start_time", String.valueOf(this.dJy.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gD().y(false)) != null) {
                        this.ahV.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.dJy.getType() == 6) {
                    this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ahV.o("title", this.dJy.getTitle());
                    this.ahV.o("is_ntitle", this.dJy.isNoTitle() ? "1" : "0");
                    this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, String.valueOf(36));
                } else if (this.dJy.getType() == 4) {
                    this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ahV.o("title", this.dJy.getTitle());
                    this.ahV.o("is_ntitle", "0");
                    this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, String.valueOf(33));
                    this.ahV.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.ahV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.ahV.o("tid", this.dJy.getThreadId());
                    this.ahV.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.dJy.getType() == 2) {
                        this.ahV.o("quote_id", String.valueOf(this.dJy.getFloor()));
                        this.ahV.o("floor_num", String.valueOf(this.dJy.getFloorNum()));
                        this.ahV.o(WriteActivityConfig.IS_ADDITION, this.dJy.isAddition() ? "1" : "0");
                        if (this.dJy.getRepostId() != null) {
                            this.ahV.o("repostid", this.dJy.getRepostId());
                        } else if (this.dJy.getType() == 5) {
                            this.ahV.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    } else if (this.dJy.getType() == 1 && com.baidu.tbadk.editortools.d.b.BK().getStatus() == 1) {
                        this.ahV.o("ptype", "4");
                    }
                }
            }
            this.dJJ = this.ahV.tV();
            if (this.ahV.uw().vq().qO()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.dJJ);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(n.j.send_success);
                } else if ((this.dJy.isHasImages() || this.dJy.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dJy.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(n.j.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.dJy.deleteUploadedTempImages();
                    if (this.dJy.getType() == 1 && !this.dJy.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ae.c(this.dJy.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.dJy.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dJy.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.ahV.uA(), TbadkCoreApplication.m411getInst().getString(n.j.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.ahV.uA(), this.ahV.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str6 = "";
                try {
                    optString = new JSONObject(this.dJJ).optString(AddFriendActivityConfig.MSG);
                    try {
                        str6 = new JSONObject(this.dJJ).optString("tid");
                        optString2 = new JSONObject(this.dJJ).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e) {
                        str4 = str6;
                        str3 = optString;
                        jSONException = e;
                        str2 = "";
                    }
                } catch (JSONException e2) {
                    jSONException = e2;
                    str2 = "";
                    str3 = null;
                    str4 = "";
                }
                try {
                    JSONObject optJSONObject = new JSONObject(this.dJJ).optJSONObject("twzhibo_info");
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
                } catch (JSONException e3) {
                    str2 = optString2;
                    str4 = str6;
                    str3 = optString;
                    jSONException = e3;
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
                if (StringUtils.isNull(str3)) {
                    str3 = TbadkCoreApplication.m411getInst().getString(n.j.send_success);
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
            NewVcodeActivity.this.dXr = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.ahV != null) {
                this.ahV.gL();
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
            NewVcodeActivity.this.dXr = null;
            if (dVar != null && this.ahV != null) {
                if (this.ahV.uw().vq().qO()) {
                    if (this.dJy.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.dJy.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dJy.getForumName(), "post live's thread")));
                    }
                    if (this.dJy != null && this.dJy.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aEG();
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
                if (dVar.aGE()) {
                    com.baidu.tbadk.coreExtra.data.n nVar = new com.baidu.tbadk.coreExtra.data.n();
                    nVar.parserJson(this.dJJ);
                    if (nVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.dXn.setVcodeMD5(nVar.getVcode_md5());
                        NewVcodeActivity.this.dXn.setVcodeUrl(nVar.getVcode_pic_url());
                        if (nVar.wY().equals("4")) {
                            NewVcodeActivity.this.ajW();
                        } else {
                            if (this.dJy.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(n.j.change_vcode_type));
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
        volatile com.baidu.tbadk.core.util.ab Ua;
        com.baidu.tbadk.coreExtra.data.n dXB;

        private ChangeVcodeTask() {
            this.Ua = null;
            this.dXB = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(String... strArr) {
            this.Ua = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Ua.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.dXn.getForumId());
            this.Ua.o("kw", NewVcodeActivity.this.dXn.getForumName());
            this.Ua.o("new_vcode", "1");
            this.Ua.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.dXn.getContent());
            if (!NewVcodeActivity.this.dXn.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.dXn.setBabaoPosted(false);
            } else {
                this.Ua.o("tail_type", String.valueOf(a.C0081a.dHM));
                this.Ua.o("tail_content", NewVcodeActivity.this.dXn.getBaobaoContent());
                NewVcodeActivity.this.dXn.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.dXn.getVoice() != null) {
                this.Ua.o("voice_md5", NewVcodeActivity.this.dXn.getVoice());
                this.Ua.o("during_time", String.valueOf(NewVcodeActivity.this.dXn.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.dXn.getType() == 0 || NewVcodeActivity.this.dXn.getType() == 3) {
                this.Ua.o("title", NewVcodeActivity.this.dXn.getTitle());
                this.Ua.o("pub_type", "1");
            } else {
                this.Ua.o("pub_type", "2");
                this.Ua.o("tid", NewVcodeActivity.this.dXn.getThreadId());
            }
            this.Ua.o("vcode_tag", "11");
            if (NewVcodeActivity.this.dXn.getCategoryFrom() >= 0) {
                this.Ua.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dXn.getCategoryFrom()));
            }
            if (NewVcodeActivity.this.dXn.getCategoryTo() >= 0) {
                this.Ua.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dXn.getCategoryTo()));
            }
            String tV = this.Ua.tV();
            if (this.Ua.uw().vq().qO()) {
                this.dXB = new com.baidu.tbadk.coreExtra.data.n();
                this.dXB.parserJson(tV);
                return this.dXB;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            NewVcodeActivity.this.dXs = null;
            if (nVar != null) {
                NewVcodeActivity.this.dXn.setVcodeMD5(nVar.getVcode_md5());
                NewVcodeActivity.this.dXn.setVcodeUrl(nVar.getVcode_pic_url());
                if (!nVar.wY().equals("4")) {
                    if (NewVcodeActivity.this.dXn.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(n.j.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.ajW();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Ua.getErrorString());
            }
            NewVcodeActivity.this.dXq.setVisibility(8);
            super.onPostExecute(nVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dXs = null;
            if (this.Ua != null) {
                this.Ua.gL();
            }
            NewVcodeActivity.this.dXq.setVisibility(8);
            super.cancel(true);
        }
    }

    public void p(boolean z, String str) {
        this.dXw = z;
        this.dXu = str;
    }

    public void b(boolean z, String str, String str2) {
        if (!z) {
            if (this.mHandler != null) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(2, getPageContext().getString(n.j.finish_input_vcode)));
            }
        } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            this.dXv = str;
            this.dXt = str2;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(0);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
            }
        }
    }

    public void nt(String str) {
        if (str != null && str.length() > 0) {
            this.dXt = str;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            }
        }
    }
}
