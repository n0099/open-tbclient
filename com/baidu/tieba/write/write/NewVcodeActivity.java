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
import com.baidu.tbadk.core.atomData.TailEditActivityConfig;
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
    private TextView cTI;
    private WriteData cTH = null;
    private TextView cSp = null;
    private ProgressBar cTJ = null;
    private ProgressBar cTK = null;
    private DialogInterface.OnCancelListener cjo = null;
    private PostThreadTask cTL = null;
    private ChangeVcodeTask cTM = null;
    private BaseWebView mWebView = null;
    private String cTN = null;
    private String cTO = null;
    private String cTP = null;
    private boolean cTQ = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cTR = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cTS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.auT();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qz()) {
            this.cTJ.setVisibility(0);
            auR();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cTH = (WriteData) bundle.getSerializable("model");
        } else {
            this.cTH = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.auV();
                        return;
                    case 1:
                        NewVcodeActivity.this.auU();
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
    private boolean qz() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(i.f.new_vcode_webview);
                com.baidu.tbadk.core.util.al.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.cTJ.setVisibility(8);
                        if (!NewVcodeActivity.this.cTQ) {
                            NewVcodeActivity.this.cTI.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cTI.setVisibility(8);
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
    public void auQ() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auR() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auS() {
        if (this.mWebView != null && this.cTN != null && this.cTN.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cTN + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auT() {
        if (this.mWebView != null && this.cTQ && this.cTO != null && this.cTO.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cTO + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cTL != null) {
            this.cTL.cancel();
        }
        if (this.cTM != null) {
            this.cTM.cancel();
        }
        if (this.cTJ != null) {
            this.cTJ.setVisibility(8);
        }
        if (this.cTK != null) {
            this.cTK.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cTH);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cTH != null && this.cTH.getType() == 3) {
            if (this.cTL != null) {
                this.cTL.cancel();
            }
            if (this.cTM != null) {
                this.cTM.cancel();
            }
            if (this.cTJ != null) {
                this.cTJ.setVisibility(8);
            }
            if (this.cTK != null) {
                this.cTK.setVisibility(8);
            }
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.removeMessages(2);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.al.g(this.cSp, i);
        com.baidu.tbadk.core.util.al.e((View) this.cTI, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.al.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cTJ = (ProgressBar) findViewById(i.f.load_webview_progress);
        this.cTK = (ProgressBar) findViewById(i.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cTR);
        this.cSp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.C0057i.send), this.cTS);
        this.cTI = (TextView) findViewById(i.f.webview_fail_view);
        this.cTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cTQ) {
                    NewVcodeActivity.this.cTJ.setVisibility(0);
                    NewVcodeActivity.this.auQ();
                    NewVcodeActivity.this.auR();
                }
            }
        });
        this.cjo = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cTL != null) {
                    NewVcodeActivity.this.cTL.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auU() {
        if (this.cTM != null) {
            this.cTM.cancel();
        }
        this.cTK.setVisibility(0);
        this.cTM = new ChangeVcodeTask(this, null);
        this.cTM.setPriority(3);
        this.cTM.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auV() {
        if (this.cTP != null && this.cTP.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(i.C0057i.sending), true, true, this.cjo);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cTL != null) {
                this.cTL.cancel();
            }
            this.cTL = new PostThreadTask(this.cTH);
            this.cTL.setPriority(3);
            this.cTL.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private WriteData cKS;
        private com.baidu.tbadk.core.util.v afJ = null;
        private String aGk = null;

        public PostThreadTask(WriteData writeData) {
            this.cKS = null;
            this.cKS = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01d9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.b doInBackground(Integer... numArr) {
            VideoInfo videoInfo;
            String str;
            Address y;
            com.baidu.tieba.tbadkCore.writeModel.b bVar;
            String str2;
            String str3;
            JSONException e;
            if (this.cKS == null) {
                return null;
            }
            this.afJ = new com.baidu.tbadk.core.util.v();
            String imagesCodeForPost = this.cKS.getImagesCodeForPost();
            if (this.cKS.getType() == 3) {
                this.afJ.o("newVcode", "1");
                this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cKS.getContent()) + imagesCodeForPost);
                this.afJ.o("vcodeMd5", this.cKS.getVcodeMD5());
                this.afJ.o("vcode", NewVcodeActivity.this.cTP);
                this.afJ.o("tag", "11");
                this.afJ.ue().uV().mIsNeedTbs = true;
                this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cKS.getContent()) + imagesCodeForPost);
                this.afJ.setUrl(com.baidu.tieba.tbadkCore.d.a.cJc);
                this.afJ.o(ImageViewerConfig.FORUM_NAME, this.cKS.getForumName());
                this.afJ.o("title", this.cKS.getTitle());
                this.afJ.o("apiKey", this.cKS.getShareApiKey());
                this.afJ.o("appName", this.cKS.getShareAppName());
                this.afJ.o("signKey", this.cKS.getShareSignKey());
                this.afJ.o("summary_title", this.cKS.getShareSummaryTitle());
                this.afJ.o("summary_content", this.cKS.getShareSummaryContent());
                this.afJ.o("summary_img", this.cKS.getShareSummaryImg());
                this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cKS.getShareSummaryImgWidth()));
                this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cKS.getShareSummaryImgHeight()));
                this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cKS.getShareSummaryImgType());
                this.afJ.o("referUrl", this.cKS.getShareReferUrl());
            } else {
                this.afJ.o("anonymous", "0");
                this.afJ.o(ImageViewerConfig.FORUM_ID, this.cKS.getForumId());
                this.afJ.o("kw", this.cKS.getForumName());
                this.afJ.o("new_vcode", "1");
                if (this.cKS.getVideoInfo() == null) {
                    str = String.valueOf(this.cKS.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.cKS.getContent()) + videoInfo.buildWriteContent(this.cKS.getForumName()) + imagesCodeForPost;
                }
                this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, this.cKS);
                if (this.cKS.getIsBaobaoImageUploaded()) {
                    this.afJ.o("tail_type", String.valueOf(a.C0070a.cJf));
                    this.afJ.o(TailEditActivityConfig.TAIL_CONTENT, this.cKS.getBaobaoContent());
                    this.cKS.setBabaoPosted(true);
                } else {
                    this.cKS.setBabaoPosted(false);
                }
                this.afJ.o("vcode_md5", this.cKS.getVcodeMD5());
                this.afJ.o("vcode", NewVcodeActivity.this.cTP);
                this.afJ.o("vcode_tag", "11");
                if (this.cKS.getVoice() != null) {
                    this.afJ.o("voice_md5", this.cKS.getVoice());
                    this.afJ.o("during_time", String.valueOf(this.cKS.getVoiceDuringTime()));
                }
                this.afJ.ue().uV().mIsNeedTbs = true;
                if (this.cKS.getType() == 0) {
                    this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afJ.o("title", this.cKS.getTitle());
                    this.afJ.o("is_ntitle", this.cKS.isNoTitle() ? "1" : "0");
                    if (this.cKS.getLiveCardData() != null) {
                        this.afJ.o("group_id", String.valueOf(this.cKS.getLiveCardData().getGroupId()));
                        this.afJ.o("start_time", String.valueOf(this.cKS.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gF().y(false)) != null) {
                        this.afJ.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else {
                    this.afJ.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.afJ.o("tid", this.cKS.getThreadId());
                    this.afJ.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.cKS.getType() == 2) {
                        this.afJ.o("quote_id", String.valueOf(this.cKS.getFloor()));
                        this.afJ.o("floor_num", String.valueOf(this.cKS.getFloorNum()));
                        this.afJ.o(WriteActivityConfig.IS_ADDITION, this.cKS.isAddition() ? "1" : "0");
                        if (this.cKS.getRepostId() != null) {
                            this.afJ.o("repostid", this.cKS.getRepostId());
                        }
                    }
                }
            }
            this.aGk = this.afJ.tD();
            if (this.afJ.ue().uW().rb()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.aGk);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.C0057i.send_success);
                } else if ((this.cKS.isHasImages() || this.cKS.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cKS.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.C0057i.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, null);
                if (!bVar2.hasError()) {
                    this.cKS.deleteUploadedTempImages();
                    if (this.cKS.getType() == 1 && !this.cKS.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ac.c(this.cKS.getThreadId(), (WriteData) null);
                        bVar = bVar2;
                    }
                }
                bVar = bVar2;
            } else if (this.cKS.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cKS.getContent()) + imagesCodeForPost)) {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(this.afJ.ui(), TbadkCoreApplication.m411getInst().getString(i.C0057i.img_upload_error), null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(this.afJ.ui(), this.afJ.getErrorString(), null);
            }
            if (!bVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.aGk).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.aGk).optString("tid");
                    } catch (JSONException e2) {
                        str3 = "";
                        e = e2;
                    }
                    try {
                        str4 = new JSONObject(this.aGk).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (StringUtils.isNull(str2)) {
                        }
                        bVar.setErrorString(str2);
                        bVar.setThreadId(str3);
                        bVar.setPostId(str4);
                        return bVar;
                    }
                } catch (JSONException e4) {
                    str2 = null;
                    str3 = "";
                    e = e4;
                }
                if (StringUtils.isNull(str2)) {
                    str2 = TbadkCoreApplication.m411getInst().getString(i.C0057i.send_success);
                }
                bVar.setErrorString(str2);
                bVar.setThreadId(str3);
                bVar.setPostId(str4);
                return bVar;
            }
            return bVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cTL = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.afJ != null) {
                this.afJ.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.b bVar) {
            super.onPostExecute(bVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.cTL = null;
            if (bVar != null && this.afJ != null) {
                if (this.afJ.ue().uW().rb()) {
                    if (this.cKS.getType() != 3) {
                        if (bVar.hasError()) {
                            NewVcodeActivity.this.showToast(bVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.c.d(NewVcodeActivity.this.getPageContext().getPageActivity(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                        }
                    }
                    if (this.cKS.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cKS.getForumName(), "post live's thread")));
                    }
                    if (this.cKS != null && this.cKS.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.apy();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                    postWriteCallBackData.setThreadId(bVar.getThreadId());
                    postWriteCallBackData.setPostId(bVar.getPostId());
                    if (this.cKS != null && this.cKS.getVideoInfo() != null && postWriteCallBackData != null) {
                        XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), this.cKS.getForumId(), this.cKS.getVideoInfo().getVideoUrl(), this.cKS.getForumName());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (bVar.arh()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.aGk);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cTH.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.cTH.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.wC().equals("4")) {
                            NewVcodeActivity.this.auS();
                        } else {
                            if (this.cKS.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.C0057i.change_vcode_type));
                            }
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(bVar.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.l> {
        volatile com.baidu.tbadk.core.util.v Tu;
        com.baidu.tbadk.coreExtra.data.l cTU;

        private ChangeVcodeTask() {
            this.Tu = null;
            this.cTU = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Tu.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cTH.getForumId());
            this.Tu.o("kw", NewVcodeActivity.this.cTH.getForumName());
            this.Tu.o("new_vcode", "1");
            this.Tu.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cTH.getContent());
            if (!NewVcodeActivity.this.cTH.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cTH.setBabaoPosted(false);
            } else {
                this.Tu.o("tail_type", String.valueOf(a.C0070a.cJf));
                this.Tu.o(TailEditActivityConfig.TAIL_CONTENT, NewVcodeActivity.this.cTH.getBaobaoContent());
                NewVcodeActivity.this.cTH.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cTH.getVoice() != null) {
                this.Tu.o("voice_md5", NewVcodeActivity.this.cTH.getVoice());
                this.Tu.o("during_time", String.valueOf(NewVcodeActivity.this.cTH.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cTH.getType() == 0 || NewVcodeActivity.this.cTH.getType() == 3) {
                this.Tu.o("title", NewVcodeActivity.this.cTH.getTitle());
                this.Tu.o("pub_type", "1");
            } else {
                this.Tu.o("pub_type", "2");
                this.Tu.o("tid", NewVcodeActivity.this.cTH.getThreadId());
            }
            this.Tu.o("vcode_tag", "11");
            String tD = this.Tu.tD();
            if (this.Tu.ue().uW().rb()) {
                this.cTU = new com.baidu.tbadk.coreExtra.data.l();
                this.cTU.parserJson(tD);
                return this.cTU;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.cTM = null;
            if (lVar != null) {
                NewVcodeActivity.this.cTH.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.cTH.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.wC().equals("4")) {
                    if (NewVcodeActivity.this.cTH.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.C0057i.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.auS();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Tu.getErrorString());
            }
            NewVcodeActivity.this.cTK.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cTM = null;
            if (this.Tu != null) {
                this.Tu.gM();
            }
            NewVcodeActivity.this.cTK.setVisibility(8);
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
            return NewVcodeActivity.this.cTH.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cTQ = z;
            NewVcodeActivity.this.cTO = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(i.C0057i.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cTP = str;
                NewVcodeActivity.this.cTN = str2;
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
                NewVcodeActivity.this.cTN = str;
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
