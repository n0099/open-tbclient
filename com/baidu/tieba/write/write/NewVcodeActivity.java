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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private TextView cxA;
    private WriteData cxz = null;
    private TextView cwj = null;
    private ProgressBar cxB = null;
    private ProgressBar cxC = null;
    private DialogInterface.OnCancelListener ccP = null;
    private PostThreadTask cxD = null;
    private ChangeVcodeTask cxE = null;
    private BaseWebView mWebView = null;
    private String cxF = null;
    private String cxG = null;
    private String cxH = null;
    private boolean cxI = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cxJ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cxK = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.arl();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_vcode_activity);
        initUI();
        initData(bundle);
        if (oU()) {
            this.cxB.setVisibility(0);
            arj();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cxz = (WriteData) bundle.getSerializable("model");
        } else {
            this.cxz = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.arn();
                        return;
                    case 1:
                        NewVcodeActivity.this.arm();
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
    private boolean oU() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.v.new_vcode_webview);
                com.baidu.tbadk.core.util.ba.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.cxB.setVisibility(8);
                        if (!NewVcodeActivity.this.cxI) {
                            NewVcodeActivity.this.cxA.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cxA.setVisibility(8);
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
    public void ari() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arj() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ark() {
        if (this.mWebView != null && this.cxF != null && this.cxF.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cxF + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arl() {
        if (this.mWebView != null && this.cxI && this.cxG != null && this.cxG.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cxG + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cxD != null) {
            this.cxD.cancel();
        }
        if (this.cxE != null) {
            this.cxE.cancel();
        }
        if (this.cxB != null) {
            this.cxB.setVisibility(8);
        }
        if (this.cxC != null) {
            this.cxC.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cxz);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxz != null && this.cxz.getType() == 3) {
            if (this.cxD != null) {
                this.cxD.cancel();
            }
            if (this.cxE != null) {
                this.cxE.cancel();
            }
            if (this.cxB != null) {
                this.cxB.setVisibility(8);
            }
            if (this.cxC != null) {
                this.cxC.setVisibility(8);
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
        com.baidu.tbadk.core.util.ba.g(this.cwj, i);
        com.baidu.tbadk.core.util.ba.e((View) this.cxA, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ba.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cxB = (ProgressBar) findViewById(com.baidu.tieba.v.load_webview_progress);
        this.cxC = (ProgressBar) findViewById(com.baidu.tieba.v.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxJ);
        this.cwj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.cxK);
        this.cxA = (TextView) findViewById(com.baidu.tieba.v.webview_fail_view);
        this.cxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cxI) {
                    NewVcodeActivity.this.cxB.setVisibility(0);
                    NewVcodeActivity.this.ari();
                    NewVcodeActivity.this.arj();
                }
            }
        });
        this.ccP = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cxD != null) {
                    NewVcodeActivity.this.cxD.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arm() {
        if (this.cxE != null) {
            this.cxE.cancel();
        }
        this.cxC.setVisibility(0);
        this.cxE = new ChangeVcodeTask(this, null);
        this.cxE.setPriority(3);
        this.cxE.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arn() {
        if (this.cxH != null && this.cxH.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.y.sending), true, true, this.ccP);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cxD != null) {
                this.cxD.cancel();
            }
            this.cxD = new PostThreadTask(this.cxz);
            this.cxD.setPriority(3);
            this.cxD.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.g> {
        private com.baidu.tbadk.core.util.aa ZF = null;
        private String axk = null;
        private WriteData cqk;

        public PostThreadTask(WriteData writeData) {
            this.cqk = null;
            this.cqk = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01d9  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.baidu.tieba.tbadkCore.writeModel.g doInBackground(Integer... numArr) {
            Address z;
            com.baidu.tieba.tbadkCore.writeModel.g gVar;
            String str;
            String str2;
            JSONException e;
            if (this.cqk == null) {
                return null;
            }
            this.ZF = new com.baidu.tbadk.core.util.aa();
            String imagesCodeForPost = this.cqk.getImagesCodeForPost();
            if (this.cqk.getType() == 3) {
                this.ZF.o("newVcode", "1");
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cqk.getContent()) + imagesCodeForPost);
                this.ZF.o("vcodeMd5", this.cqk.getVcodeMD5());
                this.ZF.o("vcode", NewVcodeActivity.this.cxH);
                this.ZF.o("tag", "11");
                this.ZF.sp().tp().mIsNeedTbs = true;
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cqk.getContent()) + imagesCodeForPost);
                this.ZF.setUrl(com.baidu.tieba.tbadkCore.d.a.coy);
                this.ZF.o(ImageViewerConfig.FORUM_NAME, this.cqk.getForumName());
                this.ZF.o("title", this.cqk.getTitle());
                this.ZF.o("apiKey", this.cqk.getShareApiKey());
                this.ZF.o("appName", this.cqk.getShareAppName());
                this.ZF.o("signKey", this.cqk.getShareSignKey());
                this.ZF.o("summary_title", this.cqk.getShareSummaryTitle());
                this.ZF.o("summary_content", this.cqk.getShareSummaryContent());
                this.ZF.o("summary_img", this.cqk.getShareSummaryImg());
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cqk.getShareSummaryImgWidth()));
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cqk.getShareSummaryImgHeight()));
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cqk.getShareSummaryImgType());
                this.ZF.o("referUrl", this.cqk.getShareReferUrl());
            } else {
                this.ZF.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.ZF.o(ImageViewerConfig.FORUM_ID, this.cqk.getForumId());
                this.ZF.o("kw", this.cqk.getForumName());
                this.ZF.o("new_vcode", "1");
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cqk.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZF, this.cqk);
                if (this.cqk.getIsBaobaoImageUploaded()) {
                    this.ZF.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.coB));
                    this.ZF.o("tail_content", this.cqk.getBaobaoContent());
                    this.cqk.setBabaoPosted(true);
                } else {
                    this.cqk.setBabaoPosted(false);
                }
                this.ZF.o("vcode_md5", this.cqk.getVcodeMD5());
                this.ZF.o("vcode", NewVcodeActivity.this.cxH);
                this.ZF.o("vcode_tag", "11");
                if (this.cqk.getVoice() != null) {
                    this.ZF.o("voice_md5", this.cqk.getVoice());
                    this.ZF.o("during_time", String.valueOf(this.cqk.getVoiceDuringTime()));
                }
                this.ZF.sp().tp().mIsNeedTbs = true;
                if (this.cqk.getType() == 0) {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ZF.o("title", this.cqk.getTitle());
                    this.ZF.o("is_ntitle", this.cqk.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cqk.getLiveCardData() != null) {
                        this.ZF.o("group_id", String.valueOf(this.cqk.getLiveCardData().getGroupId()));
                        this.ZF.o("start_time", String.valueOf(this.cqk.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gZ().z(false)) != null) {
                        this.ZF.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.ZF.o("tid", this.cqk.getThreadId());
                    this.ZF.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cqk.getType() == 2) {
                        this.ZF.o("quote_id", String.valueOf(this.cqk.getFloor()));
                        this.ZF.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cqk.getFloorNum()));
                        this.ZF.o(WriteActivityConfig.IS_ADDITION, this.cqk.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cqk.getRepostId() != null) {
                            this.ZF.o("repostid", this.cqk.getRepostId());
                        }
                    }
                }
            }
            this.axk = this.ZF.rO();
            if (this.ZF.sp().tq().pv()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.axk);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.m.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.send_success);
                } else if ((this.cqk.isHasImages() || this.cqk.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cqk.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.g gVar2 = new com.baidu.tieba.tbadkCore.writeModel.g(errorData.getError_code(), error_msg, null);
                if (!gVar2.hasError()) {
                    this.cqk.deleteUploadedTempImages();
                    if (this.cqk.getType() == 1 && !this.cqk.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.cqk.getThreadId(), (WriteData) null);
                        gVar = gVar2;
                    }
                }
                gVar = gVar2;
            } else if (this.cqk.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cqk.getContent()) + imagesCodeForPost)) {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.ZF.st(), TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error), null);
            } else {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.ZF.st(), this.ZF.getErrorString(), null);
            }
            if (!gVar.hasError()) {
                String str3 = "";
                try {
                    str = new JSONObject(this.axk).optString(AddFriendActivityConfig.MSG);
                    try {
                        str2 = new JSONObject(this.axk).optString("tid");
                    } catch (JSONException e2) {
                        str2 = "";
                        e = e2;
                    }
                } catch (JSONException e3) {
                    str = null;
                    str2 = "";
                    e = e3;
                }
                try {
                    str3 = new JSONObject(this.axk).optString("pid");
                } catch (JSONException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (StringUtils.isNull(str)) {
                    }
                    gVar.setErrorString(str);
                    gVar.setThreadId(str2);
                    gVar.setPostId(str3);
                    return gVar;
                }
                if (StringUtils.isNull(str)) {
                    str = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.send_success);
                }
                gVar.setErrorString(str);
                gVar.setThreadId(str2);
                gVar.setPostId(str3);
                return gVar;
            }
            return gVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cxD = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.ZF != null) {
                this.ZF.hh();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.tbadkCore.writeModel.g gVar) {
            super.onPostExecute(gVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.cxD = null;
            if (gVar != null && this.ZF != null) {
                if (this.ZF.sp().tq().pv()) {
                    if (this.cqk.getType() != 3) {
                        if (gVar.hasError()) {
                            NewVcodeActivity.this.showToast(gVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.h.d(NewVcodeActivity.this.getPageContext().getPageActivity(), gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                        }
                    }
                    if (this.cqk.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cqk.getForumName(), "post live's thread")));
                    }
                    if (this.cqk != null && this.cqk.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aln();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                    postWriteCallBackData.setThreadId(gVar.getThreadId());
                    postWriteCallBackData.setPostId(gVar.getPostId());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (gVar.anS()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.axk);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cxz.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.cxz.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.uL().equals("4")) {
                            NewVcodeActivity.this.ark();
                        } else {
                            if (this.cqk.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.y.change_vcode_type));
                            }
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(gVar.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.l> {
        volatile com.baidu.tbadk.core.util.aa Ok;
        com.baidu.tbadk.coreExtra.data.l cxM;

        private ChangeVcodeTask() {
            this.Ok = null;
            this.cxM = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Ok.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cxz.getForumId());
            this.Ok.o("kw", NewVcodeActivity.this.cxz.getForumName());
            this.Ok.o("new_vcode", "1");
            this.Ok.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cxz.getContent());
            if (!NewVcodeActivity.this.cxz.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cxz.setBabaoPosted(false);
            } else {
                this.Ok.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.coB));
                this.Ok.o("tail_content", NewVcodeActivity.this.cxz.getBaobaoContent());
                NewVcodeActivity.this.cxz.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cxz.getVoice() != null) {
                this.Ok.o("voice_md5", NewVcodeActivity.this.cxz.getVoice());
                this.Ok.o("during_time", String.valueOf(NewVcodeActivity.this.cxz.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cxz.getType() == 0 || NewVcodeActivity.this.cxz.getType() == 3) {
                this.Ok.o("title", NewVcodeActivity.this.cxz.getTitle());
                this.Ok.o("pub_type", "1");
            } else {
                this.Ok.o("pub_type", "2");
                this.Ok.o("tid", NewVcodeActivity.this.cxz.getThreadId());
            }
            this.Ok.o("vcode_tag", "11");
            String rO = this.Ok.rO();
            if (this.Ok.sp().tq().pv()) {
                this.cxM = new com.baidu.tbadk.coreExtra.data.l();
                this.cxM.parserJson(rO);
                return this.cxM;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.cxE = null;
            if (lVar != null) {
                NewVcodeActivity.this.cxz.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.cxz.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.uL().equals("4")) {
                    if (NewVcodeActivity.this.cxz.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.y.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.ark();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Ok.getErrorString());
            }
            NewVcodeActivity.this.cxC.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cxE = null;
            if (this.Ok != null) {
                this.Ok.hh();
            }
            NewVcodeActivity.this.cxC.setVisibility(8);
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
            return NewVcodeActivity.this.cxz.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cxI = z;
            NewVcodeActivity.this.cxG = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.y.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cxH = str;
                NewVcodeActivity.this.cxF = str2;
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
                NewVcodeActivity.this.cxF = str;
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
