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
    private TextView cBT;
    private WriteData cBS = null;
    private TextView cAA = null;
    private ProgressBar cBU = null;
    private ProgressBar cBV = null;
    private DialogInterface.OnCancelListener bSJ = null;
    private PostThreadTask cBW = null;
    private ChangeVcodeTask cBX = null;
    private BaseWebView mWebView = null;
    private String cBY = null;
    private String cBZ = null;
    private String cCa = null;
    private boolean cCb = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cCc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cCd = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.atc();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.new_vcode_activity);
        initUI();
        initData(bundle);
        if (py()) {
            this.cBU.setVisibility(0);
            ata();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cBS = (WriteData) bundle.getSerializable("model");
        } else {
            this.cBS = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.ate();
                        return;
                    case 1:
                        NewVcodeActivity.this.atd();
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
    private boolean py() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.q.new_vcode_webview);
                com.baidu.tbadk.core.util.ay.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.cBU.setVisibility(8);
                        if (!NewVcodeActivity.this.cCb) {
                            NewVcodeActivity.this.cBT.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cBT.setVisibility(8);
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
    public void asZ() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atb() {
        if (this.mWebView != null && this.cBY != null && this.cBY.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cBY + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atc() {
        if (this.mWebView != null && this.cCb && this.cBZ != null && this.cBZ.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cBZ + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cBW != null) {
            this.cBW.cancel();
        }
        if (this.cBX != null) {
            this.cBX.cancel();
        }
        if (this.cBU != null) {
            this.cBU.setVisibility(8);
        }
        if (this.cBV != null) {
            this.cBV.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cBS);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cBS != null && this.cBS.getType() == 3) {
            if (this.cBW != null) {
                this.cBW.cancel();
            }
            if (this.cBX != null) {
                this.cBX.cancel();
            }
            if (this.cBU != null) {
                this.cBU.setVisibility(8);
            }
            if (this.cBV != null) {
                this.cBV.setVisibility(8);
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
        com.baidu.tbadk.core.util.ay.g(this.cAA, i);
        com.baidu.tbadk.core.util.ay.e((View) this.cBT, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ay.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cBU = (ProgressBar) findViewById(com.baidu.tieba.q.load_webview_progress);
        this.cBV = (ProgressBar) findViewById(com.baidu.tieba.q.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cCc);
        this.cAA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.send), this.cCd);
        this.cBT = (TextView) findViewById(com.baidu.tieba.q.webview_fail_view);
        this.cBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cCb) {
                    NewVcodeActivity.this.cBU.setVisibility(0);
                    NewVcodeActivity.this.asZ();
                    NewVcodeActivity.this.ata();
                }
            }
        });
        this.bSJ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cBW != null) {
                    NewVcodeActivity.this.cBW.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atd() {
        if (this.cBX != null) {
            this.cBX.cancel();
        }
        this.cBV.setVisibility(0);
        this.cBX = new ChangeVcodeTask(this, null);
        this.cBX.setPriority(3);
        this.cBX.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ate() {
        if (this.cCa != null && this.cCa.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.t.sending), true, true, this.bSJ);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cBW != null) {
                this.cBW.cancel();
            }
            this.cBW = new PostThreadTask(this.cBS);
            this.cBW.setPriority(3);
            this.cBW.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.g> {
        private com.baidu.tbadk.core.util.aa aaG = null;
        private String ayS = null;
        private WriteData cup;

        public PostThreadTask(WriteData writeData) {
            this.cup = null;
            this.cup = writeData;
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
            if (this.cup == null) {
                return null;
            }
            this.aaG = new com.baidu.tbadk.core.util.aa();
            String imagesCodeForPost = this.cup.getImagesCodeForPost();
            if (this.cup.getType() == 3) {
                this.aaG.o("newVcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cup.getContent()) + imagesCodeForPost);
                this.aaG.o("vcodeMd5", this.cup.getVcodeMD5());
                this.aaG.o("vcode", NewVcodeActivity.this.cCa);
                this.aaG.o("tag", "11");
                this.aaG.sX().tS().mIsNeedTbs = true;
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cup.getContent()) + imagesCodeForPost);
                this.aaG.setUrl(com.baidu.tieba.tbadkCore.d.a.csA);
                this.aaG.o(ImageViewerConfig.FORUM_NAME, this.cup.getForumName());
                this.aaG.o("title", this.cup.getTitle());
                this.aaG.o("apiKey", this.cup.getShareApiKey());
                this.aaG.o("appName", this.cup.getShareAppName());
                this.aaG.o("signKey", this.cup.getShareSignKey());
                this.aaG.o("summary_title", this.cup.getShareSummaryTitle());
                this.aaG.o("summary_content", this.cup.getShareSummaryContent());
                this.aaG.o("summary_img", this.cup.getShareSummaryImg());
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cup.getShareSummaryImgWidth()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cup.getShareSummaryImgHeight()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cup.getShareSummaryImgType());
                this.aaG.o("referUrl", this.cup.getShareReferUrl());
            } else {
                this.aaG.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.aaG.o(ImageViewerConfig.FORUM_ID, this.cup.getForumId());
                this.aaG.o("kw", this.cup.getForumName());
                this.aaG.o("new_vcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cup.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.aaG, this.cup);
                if (this.cup.getIsBaobaoImageUploaded()) {
                    this.aaG.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.csD));
                    this.aaG.o("tail_content", this.cup.getBaobaoContent());
                    this.cup.setBabaoPosted(true);
                } else {
                    this.cup.setBabaoPosted(false);
                }
                this.aaG.o("vcode_md5", this.cup.getVcodeMD5());
                this.aaG.o("vcode", NewVcodeActivity.this.cCa);
                this.aaG.o("vcode_tag", "11");
                if (this.cup.getVoice() != null) {
                    this.aaG.o("voice_md5", this.cup.getVoice());
                    this.aaG.o("during_time", String.valueOf(this.cup.getVoiceDuringTime()));
                }
                this.aaG.sX().tS().mIsNeedTbs = true;
                if (this.cup.getType() == 0) {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aaG.o("title", this.cup.getTitle());
                    this.aaG.o("is_ntitle", this.cup.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cup.getLiveCardData() != null) {
                        this.aaG.o("group_id", String.valueOf(this.cup.getLiveCardData().getGroupId()));
                        this.aaG.o("start_time", String.valueOf(this.cup.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gK().z(false)) != null) {
                        this.aaG.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.aaG.o("tid", this.cup.getThreadId());
                    this.aaG.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cup.getType() == 2) {
                        this.aaG.o("quote_id", String.valueOf(this.cup.getFloor()));
                        this.aaG.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cup.getFloorNum()));
                        this.aaG.o(WriteActivityConfig.IS_ADDITION, this.cup.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cup.getRepostId() != null) {
                            this.aaG.o("repostid", this.cup.getRepostId());
                        }
                    }
                }
            }
            this.ayS = this.aaG.sw();
            if (this.aaG.sX().tT().qa()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.ayS);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.m.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.send_success);
                } else if ((this.cup.isHasImages() || this.cup.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cup.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.g gVar2 = new com.baidu.tieba.tbadkCore.writeModel.g(errorData.getError_code(), error_msg, null);
                if (!gVar2.hasError()) {
                    this.cup.deleteUploadedTempImages();
                    if (this.cup.getType() == 1 && !this.cup.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.cup.getThreadId(), (WriteData) null);
                        gVar = gVar2;
                    }
                }
                gVar = gVar2;
            } else if (this.cup.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cup.getContent()) + imagesCodeForPost)) {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.aaG.tb(), TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error), null);
            } else {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.aaG.tb(), this.aaG.getErrorString(), null);
            }
            if (!gVar.hasError()) {
                String str3 = "";
                try {
                    str = new JSONObject(this.ayS).optString(AddFriendActivityConfig.MSG);
                    try {
                        str2 = new JSONObject(this.ayS).optString("tid");
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
                    str3 = new JSONObject(this.ayS).optString(Info.kBaiduPIDKey);
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
                    str = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.send_success);
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
            NewVcodeActivity.this.cBW = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.aaG != null) {
                this.aaG.gS();
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
            NewVcodeActivity.this.cBW = null;
            if (gVar != null && this.aaG != null) {
                if (this.aaG.sX().tT().qa()) {
                    if (this.cup.getType() != 3) {
                        if (gVar.hasError()) {
                            NewVcodeActivity.this.showToast(gVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.h.d(NewVcodeActivity.this.getPageContext().getPageActivity(), gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                        }
                    }
                    if (this.cup.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cup.getForumName(), "post live's thread")));
                    }
                    if (this.cup != null && this.cup.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.amZ();
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
                if (gVar.apL()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.ayS);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cBS.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.cBS.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.vv().equals("4")) {
                            NewVcodeActivity.this.atb();
                        } else {
                            if (this.cup.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.t.change_vcode_type));
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
        volatile com.baidu.tbadk.core.util.aa OE;
        com.baidu.tbadk.coreExtra.data.l cCf;

        private ChangeVcodeTask() {
            this.OE = null;
            this.cCf = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.OE.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cBS.getForumId());
            this.OE.o("kw", NewVcodeActivity.this.cBS.getForumName());
            this.OE.o("new_vcode", "1");
            this.OE.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cBS.getContent());
            if (!NewVcodeActivity.this.cBS.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cBS.setBabaoPosted(false);
            } else {
                this.OE.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.csD));
                this.OE.o("tail_content", NewVcodeActivity.this.cBS.getBaobaoContent());
                NewVcodeActivity.this.cBS.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cBS.getVoice() != null) {
                this.OE.o("voice_md5", NewVcodeActivity.this.cBS.getVoice());
                this.OE.o("during_time", String.valueOf(NewVcodeActivity.this.cBS.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cBS.getType() == 0 || NewVcodeActivity.this.cBS.getType() == 3) {
                this.OE.o("title", NewVcodeActivity.this.cBS.getTitle());
                this.OE.o("pub_type", "1");
            } else {
                this.OE.o("pub_type", "2");
                this.OE.o("tid", NewVcodeActivity.this.cBS.getThreadId());
            }
            this.OE.o("vcode_tag", "11");
            String sw = this.OE.sw();
            if (this.OE.sX().tT().qa()) {
                this.cCf = new com.baidu.tbadk.coreExtra.data.l();
                this.cCf.parserJson(sw);
                return this.cCf;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.cBX = null;
            if (lVar != null) {
                NewVcodeActivity.this.cBS.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.cBS.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.vv().equals("4")) {
                    if (NewVcodeActivity.this.cBS.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.t.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.atb();
                }
            } else {
                NewVcodeActivity.this.showToast(this.OE.getErrorString());
            }
            NewVcodeActivity.this.cBV.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cBX = null;
            if (this.OE != null) {
                this.OE.gS();
            }
            NewVcodeActivity.this.cBV.setVisibility(8);
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
            return NewVcodeActivity.this.cBS.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cCb = z;
            NewVcodeActivity.this.cBZ = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.t.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cCa = str;
                NewVcodeActivity.this.cBY = str2;
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
                NewVcodeActivity.this.cBY = str;
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
