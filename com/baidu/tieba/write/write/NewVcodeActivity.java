package com.baidu.tieba.write.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
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
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private TextView dox;
    private WriteData dow = null;
    private TextView dme = null;
    private ProgressBar doy = null;
    private ProgressBar doz = null;
    private DialogInterface.OnCancelListener cpM = null;
    private PostThreadTask doA = null;
    private ChangeVcodeTask doB = null;
    private BaseWebView mWebView = null;
    private String doC = null;
    private String doD = null;
    private String doE = null;
    private boolean doF = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener doG = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener doH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.aeh();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qs()) {
            this.doy.setVisibility(0);
            aef();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dow = (WriteData) bundle.getSerializable("model");
        } else {
            this.dow = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aCV();
                        return;
                    case 1:
                        NewVcodeActivity.this.aei();
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
    private boolean qs() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(i.f.new_vcode_webview);
                com.baidu.tbadk.core.util.am.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.doy.setVisibility(8);
                        if (!NewVcodeActivity.this.doF) {
                            NewVcodeActivity.this.dox.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.dox.setVisibility(8);
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
    public void aCU() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aef() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeg() {
        if (this.mWebView != null && this.doC != null && this.doC.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.doC + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeh() {
        if (this.mWebView != null && this.doF && this.doD != null && this.doD.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.doD + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.doA != null) {
            this.doA.cancel();
        }
        if (this.doB != null) {
            this.doB.cancel();
        }
        if (this.doy != null) {
            this.doy.setVisibility(8);
        }
        if (this.doz != null) {
            this.doz.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dow);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dow != null && this.dow.getType() == 3) {
            if (this.doA != null) {
                this.doA.cancel();
            }
            if (this.doB != null) {
                this.doB.cancel();
            }
            if (this.doy != null) {
                this.doy.setVisibility(8);
            }
            if (this.doz != null) {
                this.doz.setVisibility(8);
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
        com.baidu.tbadk.core.util.am.e((View) this.dox, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.am.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.am.i((View) this.dme, i.e.s_navbar_button_bg);
    }

    private void initUI() {
        this.doy = (ProgressBar) findViewById(i.f.load_webview_progress);
        this.doz = (ProgressBar) findViewById(i.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.doG);
        this.dme = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.doH);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dme.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dme.setLayoutParams(layoutParams);
        this.dox = (TextView) findViewById(i.f.webview_fail_view);
        this.dox.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.doF) {
                    NewVcodeActivity.this.doy.setVisibility(0);
                    NewVcodeActivity.this.aCU();
                    NewVcodeActivity.this.aef();
                }
            }
        });
        this.cpM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.doA != null) {
                    NewVcodeActivity.this.doA.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aei() {
        if (this.doB != null) {
            this.doB.cancel();
        }
        this.doz.setVisibility(0);
        this.doB = new ChangeVcodeTask(this, null);
        this.doB.setPriority(3);
        this.doB.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCV() {
        if (this.doE != null && this.doE.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(i.h.sending), true, true, this.cpM);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.doA != null) {
                this.doA.cancel();
            }
            this.doA = new PostThreadTask(this.dow);
            this.doA.setPriority(3);
            this.doA.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private WriteData daX;
        private com.baidu.tbadk.core.util.w afg = null;
        private String dbj = null;

        public PostThreadTask(WriteData writeData) {
            this.daX = null;
            this.daX = writeData;
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
            VideoInfo videoInfo;
            String str;
            Address y;
            com.baidu.tieba.tbadkCore.writeModel.d dVar;
            String str2;
            String str3;
            JSONException e;
            if (this.daX == null) {
                return null;
            }
            this.afg = new com.baidu.tbadk.core.util.w();
            String imagesCodeForPost = this.daX.getImagesCodeForPost();
            if (this.daX.getType() == 3) {
                this.afg.o("newVcode", "1");
                this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.daX.getContent()) + imagesCodeForPost);
                this.afg.o(PayVcodeActivityConfig.VCODE_MD5, this.daX.getVcodeMD5());
                this.afg.o("vcode", NewVcodeActivity.this.doE);
                this.afg.o("tag", "11");
                this.afg.uh().uX().mIsNeedTbs = true;
                this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.daX.getContent()) + imagesCodeForPost);
                this.afg.setUrl(com.baidu.tieba.tbadkCore.d.a.cZg);
                this.afg.o(ImageViewerConfig.FORUM_NAME, this.daX.getForumName());
                this.afg.o("title", this.daX.getTitle());
                this.afg.o("apiKey", this.daX.getShareApiKey());
                this.afg.o("appName", this.daX.getShareAppName());
                this.afg.o("signKey", this.daX.getShareSignKey());
                this.afg.o("summary_title", this.daX.getShareSummaryTitle());
                this.afg.o("summary_content", this.daX.getShareSummaryContent());
                this.afg.o("summary_img", this.daX.getShareSummaryImg());
                this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.daX.getShareSummaryImgWidth()));
                this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.daX.getShareSummaryImgHeight()));
                this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.daX.getShareSummaryImgType());
                this.afg.o("referUrl", this.daX.getShareReferUrl());
            } else {
                this.afg.o("anonymous", "0");
                this.afg.o(ImageViewerConfig.FORUM_ID, this.daX.getForumId());
                this.afg.o("kw", this.daX.getForumName());
                this.afg.o("new_vcode", "1");
                if (this.daX.getVideoInfo() == null) {
                    str = String.valueOf(this.daX.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.daX.getContent()) + videoInfo.buildWriteContent(this.daX.getForumName()) + imagesCodeForPost;
                }
                if (this.daX.getType() == 6 && this.daX.getVoteInfo() != null) {
                    if (this.daX.getWriteImagesInfo() != null) {
                        this.daX.getVoteInfo().setServerImageCode(this.daX.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.daX.getVoteInfo().buildWriteContent();
                }
                this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.afg, this.daX);
                if (this.daX.getIsBaobaoImageUploaded()) {
                    this.afg.o("tail_type", String.valueOf(a.C0075a.cZj));
                    this.afg.o("tail_content", this.daX.getBaobaoContent());
                    this.daX.setBabaoPosted(true);
                } else {
                    this.daX.setBabaoPosted(false);
                }
                this.afg.o("vcode_md5", this.daX.getVcodeMD5());
                this.afg.o("vcode", NewVcodeActivity.this.doE);
                this.afg.o("vcode_tag", "11");
                if (this.daX.getVoice() != null) {
                    this.afg.o("voice_md5", this.daX.getVoice());
                    this.afg.o("during_time", String.valueOf(this.daX.getVoiceDuringTime()));
                }
                this.afg.uh().uX().mIsNeedTbs = true;
                if (this.daX.getType() == 0) {
                    this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afg.o("title", this.daX.getTitle());
                    this.afg.o("is_ntitle", this.daX.isNoTitle() ? "1" : "0");
                    if (this.daX.getLiveCardData() != null) {
                        this.afg.o("group_id", String.valueOf(this.daX.getLiveCardData().getGroupId()));
                        this.afg.o("start_time", String.valueOf(this.daX.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                        this.afg.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.daX.getType() == 6) {
                    this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afg.o("title", this.daX.getTitle());
                    this.afg.o("is_ntitle", this.daX.isNoTitle() ? "1" : "0");
                    this.afg.o("thread_type", String.valueOf(36));
                } else if (this.daX.getType() == 4) {
                    this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afg.o("title", this.daX.getTitle());
                    this.afg.o("is_ntitle", "0");
                    this.afg.o("thread_type", String.valueOf(33));
                    this.afg.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.afg.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.afg.o("tid", this.daX.getThreadId());
                    this.afg.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.daX.getType() == 2) {
                        this.afg.o("quote_id", String.valueOf(this.daX.getFloor()));
                        this.afg.o("floor_num", String.valueOf(this.daX.getFloorNum()));
                        this.afg.o(WriteActivityConfig.IS_ADDITION, this.daX.isAddition() ? "1" : "0");
                        if (this.daX.getRepostId() != null) {
                            this.afg.o("repostid", this.daX.getRepostId());
                        } else if (this.daX.getType() == 5) {
                            this.afg.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
            }
            this.dbj = this.afg.tG();
            if (this.afg.uh().uY().qV()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.dbj);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                } else if ((this.daX.isHasImages() || this.daX.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.daX.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.daX.deleteUploadedTempImages();
                    if (this.daX.getType() == 1 && !this.daX.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ad.c(this.daX.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.daX.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.daX.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afg.ul(), TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afg.ul(), this.afg.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.dbj).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.dbj).optString("tid");
                    } catch (JSONException e2) {
                        str3 = "";
                        e = e2;
                    }
                } catch (JSONException e3) {
                    str2 = null;
                    str3 = "";
                    e = e3;
                }
                try {
                    str4 = new JSONObject(this.dbj).optString(Info.kBaiduPIDKey);
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (StringUtils.isNull(str2)) {
                    }
                    dVar.setErrorString(str2);
                    dVar.setThreadId(str3);
                    dVar.setPostId(str4);
                    return dVar;
                }
                if (StringUtils.isNull(str2)) {
                    str2 = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
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
            NewVcodeActivity.this.doA = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.afg != null) {
                this.afg.gJ();
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
            NewVcodeActivity.this.doA = null;
            if (dVar != null && this.afg != null) {
                if (this.afg.uh().uY().qV()) {
                    if (this.daX.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.daX.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.daX.getForumName(), "post live's thread")));
                    }
                    if (this.daX != null && this.daX.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awb();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    if (this.daX != null && this.daX.getVideoInfo() != null && postWriteCallBackData != null) {
                        XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), this.daX.getForumId(), this.daX.getVideoInfo().getVideoUrl(), this.daX.getForumName());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (dVar.axJ()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.dbj);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.dow.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.dow.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.ws().equals("4")) {
                            NewVcodeActivity.this.aeg();
                        } else {
                            if (this.daX.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
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
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.l> {
        volatile com.baidu.tbadk.core.util.w Th;
        com.baidu.tbadk.coreExtra.data.l doJ;

        private ChangeVcodeTask() {
            this.Th = null;
            this.doJ = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Th = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Th.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.dow.getForumId());
            this.Th.o("kw", NewVcodeActivity.this.dow.getForumName());
            this.Th.o("new_vcode", "1");
            this.Th.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.dow.getContent());
            if (!NewVcodeActivity.this.dow.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.dow.setBabaoPosted(false);
            } else {
                this.Th.o("tail_type", String.valueOf(a.C0075a.cZj));
                this.Th.o("tail_content", NewVcodeActivity.this.dow.getBaobaoContent());
                NewVcodeActivity.this.dow.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.dow.getVoice() != null) {
                this.Th.o("voice_md5", NewVcodeActivity.this.dow.getVoice());
                this.Th.o("during_time", String.valueOf(NewVcodeActivity.this.dow.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.dow.getType() == 0 || NewVcodeActivity.this.dow.getType() == 3) {
                this.Th.o("title", NewVcodeActivity.this.dow.getTitle());
                this.Th.o("pub_type", "1");
            } else {
                this.Th.o("pub_type", "2");
                this.Th.o("tid", NewVcodeActivity.this.dow.getThreadId());
            }
            this.Th.o("vcode_tag", "11");
            String tG = this.Th.tG();
            if (this.Th.uh().uY().qV()) {
                this.doJ = new com.baidu.tbadk.coreExtra.data.l();
                this.doJ.parserJson(tG);
                return this.doJ;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.doB = null;
            if (lVar != null) {
                NewVcodeActivity.this.dow.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.dow.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.ws().equals("4")) {
                    if (NewVcodeActivity.this.dow.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.aeg();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Th.getErrorString());
            }
            NewVcodeActivity.this.doz.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.doB = null;
            if (this.Th != null) {
                this.Th.gJ();
            }
            NewVcodeActivity.this.doz.setVisibility(8);
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
            return NewVcodeActivity.this.dow.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.doF = z;
            NewVcodeActivity.this.doD = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(i.h.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.doE = str;
                NewVcodeActivity.this.doC = str2;
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
                NewVcodeActivity.this.doC = str;
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(1);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(1));
                }
            }
        }

        @JavascriptInterface
        public String jsGetSkinType() {
            return String.valueOf(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
