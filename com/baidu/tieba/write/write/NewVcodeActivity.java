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
    private TextView cxh;
    private WriteData cxg = null;
    private TextView cvT = null;
    private ProgressBar cxi = null;
    private ProgressBar cxj = null;
    private DialogInterface.OnCancelListener ccA = null;
    private PostThreadTask cxk = null;
    private ChangeVcodeTask cxl = null;
    private BaseWebView mWebView = null;
    private String cxm = null;
    private String cxn = null;
    private String cxo = null;
    private boolean cxp = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener cxq = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener cxr = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.aqW();
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
            this.cxi.setVisibility(0);
            aqU();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cxg = (WriteData) bundle.getSerializable("model");
        } else {
            this.cxg = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aqY();
                        return;
                    case 1:
                        NewVcodeActivity.this.aqX();
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
                        NewVcodeActivity.this.cxi.setVisibility(8);
                        if (!NewVcodeActivity.this.cxp) {
                            NewVcodeActivity.this.cxh.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.cxh.setVisibility(8);
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
    public void aqT() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqU() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqV() {
        if (this.mWebView != null && this.cxm != null && this.cxm.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cxm + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.mWebView != null && this.cxp && this.cxn != null && this.cxn.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.cxn + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cxk != null) {
            this.cxk.cancel();
        }
        if (this.cxl != null) {
            this.cxl.cancel();
        }
        if (this.cxi != null) {
            this.cxi.setVisibility(8);
        }
        if (this.cxj != null) {
            this.cxj.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.cxg);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cxg != null && this.cxg.getType() == 3) {
            if (this.cxk != null) {
                this.cxk.cancel();
            }
            if (this.cxl != null) {
                this.cxl.cancel();
            }
            if (this.cxi != null) {
                this.cxi.setVisibility(8);
            }
            if (this.cxj != null) {
                this.cxj.setVisibility(8);
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
        com.baidu.tbadk.core.util.ba.g(this.cvT, i);
        com.baidu.tbadk.core.util.ba.e((View) this.cxh, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.ba.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.cxi = (ProgressBar) findViewById(com.baidu.tieba.v.load_webview_progress);
        this.cxj = (ProgressBar) findViewById(com.baidu.tieba.v.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cxq);
        this.cvT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.cxr);
        this.cxh = (TextView) findViewById(com.baidu.tieba.v.webview_fail_view);
        this.cxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.cxp) {
                    NewVcodeActivity.this.cxi.setVisibility(0);
                    NewVcodeActivity.this.aqT();
                    NewVcodeActivity.this.aqU();
                }
            }
        });
        this.ccA = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.cxk != null) {
                    NewVcodeActivity.this.cxk.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqX() {
        if (this.cxl != null) {
            this.cxl.cancel();
        }
        this.cxj.setVisibility(0);
        this.cxl = new ChangeVcodeTask(this, null);
        this.cxl.setPriority(3);
        this.cxl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqY() {
        if (this.cxo != null && this.cxo.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(com.baidu.tieba.y.sending), true, true, this.ccA);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.cxk != null) {
                this.cxk.cancel();
            }
            this.cxk = new PostThreadTask(this.cxg);
            this.cxk.setPriority(3);
            this.cxk.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.g> {
        private com.baidu.tbadk.core.util.aa ZD = null;
        private String axc = null;
        private WriteData cpU;

        public PostThreadTask(WriteData writeData) {
            this.cpU = null;
            this.cpU = writeData;
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
            if (this.cpU == null) {
                return null;
            }
            this.ZD = new com.baidu.tbadk.core.util.aa();
            String imagesCodeForPost = this.cpU.getImagesCodeForPost();
            if (this.cpU.getType() == 3) {
                this.ZD.o("newVcode", "1");
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cpU.getContent()) + imagesCodeForPost);
                this.ZD.o("vcodeMd5", this.cpU.getVcodeMD5());
                this.ZD.o("vcode", NewVcodeActivity.this.cxo);
                this.ZD.o("tag", "11");
                this.ZD.sp().tp().mIsNeedTbs = true;
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cpU.getContent()) + imagesCodeForPost);
                this.ZD.setUrl(com.baidu.tieba.tbadkCore.d.a.coi);
                this.ZD.o(ImageViewerConfig.FORUM_NAME, this.cpU.getForumName());
                this.ZD.o("title", this.cpU.getTitle());
                this.ZD.o("apiKey", this.cpU.getShareApiKey());
                this.ZD.o("appName", this.cpU.getShareAppName());
                this.ZD.o("signKey", this.cpU.getShareSignKey());
                this.ZD.o("summary_title", this.cpU.getShareSummaryTitle());
                this.ZD.o("summary_content", this.cpU.getShareSummaryContent());
                this.ZD.o("summary_img", this.cpU.getShareSummaryImg());
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cpU.getShareSummaryImgWidth()));
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cpU.getShareSummaryImgHeight()));
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cpU.getShareSummaryImgType());
                this.ZD.o("referUrl", this.cpU.getShareReferUrl());
            } else {
                this.ZD.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.ZD.o(ImageViewerConfig.FORUM_ID, this.cpU.getForumId());
                this.ZD.o("kw", this.cpU.getForumName());
                this.ZD.o("new_vcode", "1");
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cpU.getContent()) + imagesCodeForPost);
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZD, this.cpU);
                if (this.cpU.getIsBaobaoImageUploaded()) {
                    this.ZD.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.col));
                    this.ZD.o("tail_content", this.cpU.getBaobaoContent());
                    this.cpU.setBabaoPosted(true);
                } else {
                    this.cpU.setBabaoPosted(false);
                }
                this.ZD.o("vcode_md5", this.cpU.getVcodeMD5());
                this.ZD.o("vcode", NewVcodeActivity.this.cxo);
                this.ZD.o("vcode_tag", "11");
                if (this.cpU.getVoice() != null) {
                    this.ZD.o("voice_md5", this.cpU.getVoice());
                    this.ZD.o("during_time", String.valueOf(this.cpU.getVoiceDuringTime()));
                }
                this.ZD.sp().tp().mIsNeedTbs = true;
                if (this.cpU.getType() == 0) {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ZD.o("title", this.cpU.getTitle());
                    this.ZD.o("is_ntitle", this.cpU.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cpU.getLiveCardData() != null) {
                        this.ZD.o("group_id", String.valueOf(this.cpU.getLiveCardData().getGroupId()));
                        this.ZD.o("start_time", String.valueOf(this.cpU.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gZ().z(false)) != null) {
                        this.ZD.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.ZD.o("tid", this.cpU.getThreadId());
                    this.ZD.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cpU.getType() == 2) {
                        this.ZD.o("quote_id", String.valueOf(this.cpU.getFloor()));
                        this.ZD.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cpU.getFloorNum()));
                        this.ZD.o(WriteActivityConfig.IS_ADDITION, this.cpU.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cpU.getRepostId() != null) {
                            this.ZD.o("repostid", this.cpU.getRepostId());
                        }
                    }
                }
            }
            this.axc = this.ZD.rO();
            if (this.ZD.sp().tq().pv()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.axc);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.m.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.send_success);
                } else if ((this.cpU.isHasImages() || this.cpU.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cpU.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.g gVar2 = new com.baidu.tieba.tbadkCore.writeModel.g(errorData.getError_code(), error_msg, null);
                if (!gVar2.hasError()) {
                    this.cpU.deleteUploadedTempImages();
                    if (this.cpU.getType() == 1 && !this.cpU.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ao.b(this.cpU.getThreadId(), (WriteData) null);
                        gVar = gVar2;
                    }
                }
                gVar = gVar2;
            } else if (this.cpU.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cpU.getContent()) + imagesCodeForPost)) {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.ZD.st(), TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error), null);
            } else {
                gVar = new com.baidu.tieba.tbadkCore.writeModel.g(this.ZD.st(), this.ZD.getErrorString(), null);
            }
            if (!gVar.hasError()) {
                String str3 = "";
                try {
                    str = new JSONObject(this.axc).optString(AddFriendActivityConfig.MSG);
                    try {
                        str2 = new JSONObject(this.axc).optString("tid");
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
                    str3 = new JSONObject(this.axc).optString("pid");
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
            NewVcodeActivity.this.cxk = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.ZD != null) {
                this.ZD.hh();
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
            NewVcodeActivity.this.cxk = null;
            if (gVar != null && this.ZD != null) {
                if (this.ZD.sp().tq().pv()) {
                    if (this.cpU.getType() != 3) {
                        if (gVar.hasError()) {
                            NewVcodeActivity.this.showToast(gVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.h.d(NewVcodeActivity.this.getPageContext().getPageActivity(), gVar.getErrorString(), gVar.getPreMsg(), gVar.getColorMsg());
                        }
                    }
                    if (this.cpU.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cpU.getForumName(), "post live's thread")));
                    }
                    if (this.cpU != null && this.cpU.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.akY();
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
                if (gVar.anD()) {
                    com.baidu.tbadk.coreExtra.data.k kVar = new com.baidu.tbadk.coreExtra.data.k();
                    kVar.parserJson(this.axc);
                    if (kVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.cxg.setVcodeMD5(kVar.getVcode_md5());
                        NewVcodeActivity.this.cxg.setVcodeUrl(kVar.getVcode_pic_url());
                        if (kVar.uI().equals("4")) {
                            NewVcodeActivity.this.aqV();
                        } else {
                            if (this.cpU.getType() != 3) {
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
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.k> {
        volatile com.baidu.tbadk.core.util.aa Oi;
        com.baidu.tbadk.coreExtra.data.k cxt;

        private ChangeVcodeTask() {
            this.Oi = null;
            this.cxt = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public com.baidu.tbadk.coreExtra.data.k doInBackground(String... strArr) {
            this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Oi.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.cxg.getForumId());
            this.Oi.o("kw", NewVcodeActivity.this.cxg.getForumName());
            this.Oi.o("new_vcode", "1");
            this.Oi.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.cxg.getContent());
            if (!NewVcodeActivity.this.cxg.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.cxg.setBabaoPosted(false);
            } else {
                this.Oi.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.col));
                this.Oi.o("tail_content", NewVcodeActivity.this.cxg.getBaobaoContent());
                NewVcodeActivity.this.cxg.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.cxg.getVoice() != null) {
                this.Oi.o("voice_md5", NewVcodeActivity.this.cxg.getVoice());
                this.Oi.o("during_time", String.valueOf(NewVcodeActivity.this.cxg.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.cxg.getType() == 0 || NewVcodeActivity.this.cxg.getType() == 3) {
                this.Oi.o("title", NewVcodeActivity.this.cxg.getTitle());
                this.Oi.o("pub_type", "1");
            } else {
                this.Oi.o("pub_type", "2");
                this.Oi.o("tid", NewVcodeActivity.this.cxg.getThreadId());
            }
            this.Oi.o("vcode_tag", "11");
            String rO = this.Oi.rO();
            if (this.Oi.sp().tq().pv()) {
                this.cxt = new com.baidu.tbadk.coreExtra.data.k();
                this.cxt.parserJson(rO);
                return this.cxt;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.k kVar) {
            NewVcodeActivity.this.cxl = null;
            if (kVar != null) {
                NewVcodeActivity.this.cxg.setVcodeMD5(kVar.getVcode_md5());
                NewVcodeActivity.this.cxg.setVcodeUrl(kVar.getVcode_pic_url());
                if (!kVar.uI().equals("4")) {
                    if (NewVcodeActivity.this.cxg.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.y.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.aqV();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Oi.getErrorString());
            }
            NewVcodeActivity.this.cxj.setVisibility(8);
            super.onPostExecute(kVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.cxl = null;
            if (this.Oi != null) {
                this.Oi.hh();
            }
            NewVcodeActivity.this.cxj.setVisibility(8);
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
            return NewVcodeActivity.this.cxg.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.cxp = z;
            NewVcodeActivity.this.cxn = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(com.baidu.tieba.y.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.cxo = str;
                NewVcodeActivity.this.cxm = str2;
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
                NewVcodeActivity.this.cxm = str;
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
