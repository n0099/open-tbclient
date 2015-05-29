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
    private TextView cBS;
    private WriteData cBR = null;
    private TextView cAz = null;
    private ProgressBar cBT = null;
    private ProgressBar cBU = null;
    private DialogInterface.OnCancelListener bSI = null;
    private PostThreadTask cBV = null;
    private ChangeVcodeTask cBW = null;
    private BaseWebView mWebView = null;
    private String cBX = null;
    private String cBY = null;
    private String cBZ = null;
    private boolean cCa = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cCb = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cCc = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.atb();
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
            this.cBT.setVisibility(0);
            asZ();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cBR = (WriteData) bundle.getSerializable("model");
        } else {
            this.cBR = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.atd();
                        return;
                    case 1:
                        NewVcodeActivity.this.atc();
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
                        NewVcodeActivity.this.cBT.setVisibility(8);
                        if (!NewVcodeActivity.this.cCa) {
                            NewVcodeActivity.this.cBS.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cBS.setVisibility(8);
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
    public void asY() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        if (this.mWebView != null && this.cBX != null && this.cBX.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cBX + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atb() {
        if (this.mWebView != null && this.cCa && this.cBY != null && this.cBY.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cBY + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cBV != null) {
            this.cBV.cancel();
        }
        if (this.cBW != null) {
            this.cBW.cancel();
        }
        if (this.cBT != null) {
            this.cBT.setVisibility(8);
        }
        if (this.cBU != null) {
            this.cBU.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cBR);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cBR != null && this.cBR.getType() == 3) {
            if (this.cBV != null) {
                this.cBV.cancel();
            }
            if (this.cBW != null) {
                this.cBW.cancel();
            }
            if (this.cBT != null) {
                this.cBT.setVisibility(8);
            }
            if (this.cBU != null) {
                this.cBU.setVisibility(8);
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
        com.baidu.tbadk.core.util.ay.g(this.cAz, i);
        com.baidu.tbadk.core.util.ay.e((View) this.cBS, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ay.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cBT = (ProgressBar) findViewById(com.baidu.tieba.q.load_webview_progress);
        this.cBU = (ProgressBar) findViewById(com.baidu.tieba.q.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cCb);
        this.cAz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.send), this.cCc);
        this.cBS = (TextView) findViewById(com.baidu.tieba.q.webview_fail_view);
        this.cBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cCa) {
                    NewVcodeActivity.this.cBT.setVisibility(0);
                    NewVcodeActivity.this.asY();
                    NewVcodeActivity.this.asZ();
                }
            }
        });
        this.bSI = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cBV != null) {
                    NewVcodeActivity.this.cBV.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atc() {
        if (this.cBW != null) {
            this.cBW.cancel();
        }
        this.cBU.setVisibility(0);
        this.cBW = new ChangeVcodeTask(this, null);
        this.cBW.setPriority(3);
        this.cBW.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atd() {
        if (this.cBZ != null && this.cBZ.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.t.sending), true, true, this.bSI);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cBV != null) {
                this.cBV.cancel();
            }
            this.cBV = new PostThreadTask(this.cBR);
            this.cBV.setPriority(3);
            this.cBV.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.g> {
        private com.baidu.tbadk.core.util.aa aaG = null;
        private String ayR = null;
        private WriteData cuo;

        public PostThreadTask(WriteData writeData) {
            this.cuo = null;
            this.cuo = writeData;
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
            if (this.cuo == null) {
                return null;
            }
            this.aaG = new com.baidu.tbadk.core.util.aa();
            String imagesCodeForPost = this.cuo.getImagesCodeForPost();
            if (this.cuo.getType() == 3) {
                this.aaG.o("newVcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cuo.getContent()) + imagesCodeForPost);
                this.aaG.o("vcodeMd5", this.cuo.getVcodeMD5());
                this.aaG.o("vcode", NewVcodeActivity.this.cBZ);
                this.aaG.o("tag", "11");
                this.aaG.sX().tS().mIsNeedTbs = true;
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cuo.getContent()) + imagesCodeForPost);
                this.aaG.setUrl(com.baidu.tieba.tbadkCore.d.a.csz);
                this.aaG.o(ImageViewerConfig.FORUM_NAME, this.cuo.getForumName());
                this.aaG.o("title", this.cuo.getTitle());
                this.aaG.o("apiKey", this.cuo.getShareApiKey());
                this.aaG.o("appName", this.cuo.getShareAppName());
                this.aaG.o("signKey", this.cuo.getShareSignKey());
                this.aaG.o("summary_title", this.cuo.getShareSummaryTitle());
                this.aaG.o("summary_content", this.cuo.getShareSummaryContent());
                this.aaG.o("summary_img", this.cuo.getShareSummaryImg());
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cuo.getShareSummaryImgWidth()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cuo.getShareSummaryImgHeight()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cuo.getShareSummaryImgType());
                this.aaG.o("referUrl", this.cuo.getShareReferUrl());
            } else {
                this.aaG.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.aaG.o(ImageViewerConfig.FORUM_ID, this.cuo.getForumId());
                this.aaG.o("kw", this.cuo.getForumName());
                this.aaG.o("new_vcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cuo.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.aaG, this.cuo);
                if (this.cuo.getIsBaobaoImageUploaded()) {
                    this.aaG.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.csC));
                    this.aaG.o("tail_content", this.cuo.getBaobaoContent());
                    this.cuo.setBabaoPosted(true);
                } else {
                    this.cuo.setBabaoPosted(false);
                }
                this.aaG.o("vcode_md5", this.cuo.getVcodeMD5());
                this.aaG.o("vcode", NewVcodeActivity.this.cBZ);
                this.aaG.o("vcode_tag", "11");
                if (this.cuo.getVoice() != null) {
                    this.aaG.o("voice_md5", this.cuo.getVoice());
                    this.aaG.o("during_time", String.valueOf(this.cuo.getVoiceDuringTime()));
                }
                this.aaG.sX().tS().mIsNeedTbs = true;
                if (this.cuo.getType() == 0) {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aaG.o("title", this.cuo.getTitle());
                    this.aaG.o("is_ntitle", this.cuo.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cuo.getLiveCardData() != null) {
                        this.aaG.o("group_id", String.valueOf(this.cuo.getLiveCardData().getGroupId()));
                        this.aaG.o("start_time", String.valueOf(this.cuo.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gK().z(false)) != null) {
                        this.aaG.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.aaG.o("tid", this.cuo.getThreadId());
                    this.aaG.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cuo.getType() == 2) {
                        this.aaG.o("quote_id", String.valueOf(this.cuo.getFloor()));
                        this.aaG.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cuo.getFloorNum()));
                        this.aaG.o(WriteActivityConfig.IS_ADDITION, this.cuo.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cuo.getRepostId() != null) {
                            this.aaG.o("repostid", this.cuo.getRepostId());
                        }
                    }
                }
            }
            this.ayR = this.aaG.sw();
            if (this.aaG.sX().tT().qa()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.ayR);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.m.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.send_success);
                } else if ((this.cuo.isHasImages() || this.cuo.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cuo.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.g gVar2 = new com.baidu.tieba.tbadkCore.writeModel.g(errorData.getError_code(), error_msg, null);
                if (!gVar2.hasError()) {
                    this.cuo.deleteUploadedTempImages();
                    if (this.cuo.getType() == 1 && !this.cuo.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.cuo.getThreadId(), (WriteData) null);
                        gVar = gVar2;
                    }
                }
                gVar = gVar2;
            } else if (this.cuo.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cuo.getContent()) + imagesCodeForPost)) {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.aaG.tb(), TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error), null);
            } else {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.aaG.tb(), this.aaG.getErrorString(), null);
            }
            if (!gVar.hasError()) {
                String str3 = "";
                try {
                    str = new JSONObject(this.ayR).optString(AddFriendActivityConfig.MSG);
                    try {
                        str2 = new JSONObject(this.ayR).optString("tid");
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
                    str3 = new JSONObject(this.ayR).optString(Info.kBaiduPIDKey);
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
            NewVcodeActivity.this.cBV = null;
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
            NewVcodeActivity.this.cBV = null;
            if (gVar != null && this.aaG != null) {
                if (this.aaG.sX().tT().qa()) {
                    if (this.cuo.getType() != 3) {
                        if (gVar.hasError()) {
                            NewVcodeActivity.this.showToast(gVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.h.d(NewVcodeActivity.this.getPageContext().getPageActivity(), gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                        }
                    }
                    if (this.cuo.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cuo.getForumName(), "post live's thread")));
                    }
                    if (this.cuo != null && this.cuo.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.amY();
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
                if (gVar.apK()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.ayR);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cBR.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.cBR.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.vv().equals("4")) {
                            NewVcodeActivity.this.ata();
                        } else {
                            if (this.cuo.getType() != 3) {
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
        com.baidu.tbadk.coreExtra.data.l cCe;

        private ChangeVcodeTask() {
            this.OE = null;
            this.cCe = null;
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
            this.OE.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cBR.getForumId());
            this.OE.o("kw", NewVcodeActivity.this.cBR.getForumName());
            this.OE.o("new_vcode", "1");
            this.OE.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cBR.getContent());
            if (!NewVcodeActivity.this.cBR.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cBR.setBabaoPosted(false);
            } else {
                this.OE.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.csC));
                this.OE.o("tail_content", NewVcodeActivity.this.cBR.getBaobaoContent());
                NewVcodeActivity.this.cBR.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cBR.getVoice() != null) {
                this.OE.o("voice_md5", NewVcodeActivity.this.cBR.getVoice());
                this.OE.o("during_time", String.valueOf(NewVcodeActivity.this.cBR.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cBR.getType() == 0 || NewVcodeActivity.this.cBR.getType() == 3) {
                this.OE.o("title", NewVcodeActivity.this.cBR.getTitle());
                this.OE.o("pub_type", "1");
            } else {
                this.OE.o("pub_type", "2");
                this.OE.o("tid", NewVcodeActivity.this.cBR.getThreadId());
            }
            this.OE.o("vcode_tag", "11");
            String sw = this.OE.sw();
            if (this.OE.sX().tT().qa()) {
                this.cCe = new com.baidu.tbadk.coreExtra.data.l();
                this.cCe.parserJson(sw);
                return this.cCe;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.cBW = null;
            if (lVar != null) {
                NewVcodeActivity.this.cBR.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.cBR.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.vv().equals("4")) {
                    if (NewVcodeActivity.this.cBR.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.t.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.ata();
                }
            } else {
                NewVcodeActivity.this.showToast(this.OE.getErrorString());
            }
            NewVcodeActivity.this.cBU.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cBW = null;
            if (this.OE != null) {
                this.OE.gS();
            }
            NewVcodeActivity.this.cBU.setVisibility(8);
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
            return NewVcodeActivity.this.cBR.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cCa = z;
            NewVcodeActivity.this.cBY = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.t.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cBZ = str;
                NewVcodeActivity.this.cBX = str2;
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
                NewVcodeActivity.this.cBX = str;
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
