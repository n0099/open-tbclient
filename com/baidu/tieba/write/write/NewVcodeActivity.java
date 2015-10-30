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
    private TextView doX;
    private WriteData doW = null;
    private TextView dmE = null;
    private ProgressBar doY = null;
    private ProgressBar doZ = null;
    private DialogInterface.OnCancelListener cpX = null;
    private PostThreadTask dpa = null;
    private ChangeVcodeTask dpb = null;
    private BaseWebView mWebView = null;
    private String dpc = null;
    private String dpd = null;
    private String dpe = null;
    private boolean dpf = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dpg = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener dph = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.aed();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qp()) {
            this.doY.setVisibility(0);
            aeb();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.doW = (WriteData) bundle.getSerializable("model");
        } else {
            this.doW = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aDb();
                        return;
                    case 1:
                        NewVcodeActivity.this.aee();
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
    private boolean qp() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(i.f.new_vcode_webview);
                com.baidu.tbadk.core.util.an.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.doY.setVisibility(8);
                        if (!NewVcodeActivity.this.dpf) {
                            NewVcodeActivity.this.doX.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.doX.setVisibility(8);
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
    public void aDa() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeb() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aec() {
        if (this.mWebView != null && this.dpc != null && this.dpc.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dpc + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aed() {
        if (this.mWebView != null && this.dpf && this.dpd != null && this.dpd.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dpd + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dpa != null) {
            this.dpa.cancel();
        }
        if (this.dpb != null) {
            this.dpb.cancel();
        }
        if (this.doY != null) {
            this.doY.setVisibility(8);
        }
        if (this.doZ != null) {
            this.doZ.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.doW);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.doW != null && this.doW.getType() == 3) {
            if (this.dpa != null) {
                this.dpa.cancel();
            }
            if (this.dpb != null) {
                this.dpb.cancel();
            }
            if (this.doY != null) {
                this.doY.setVisibility(8);
            }
            if (this.doZ != null) {
                this.doZ.setVisibility(8);
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
        com.baidu.tbadk.core.util.an.e((View) this.doX, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.an.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.an.i((View) this.dmE, i.e.s_navbar_button_bg);
    }

    private void initUI() {
        this.doY = (ProgressBar) findViewById(i.f.load_webview_progress);
        this.doZ = (ProgressBar) findViewById(i.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dpg);
        this.dmE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dph);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmE.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dmE.setLayoutParams(layoutParams);
        this.doX = (TextView) findViewById(i.f.webview_fail_view);
        this.doX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.dpf) {
                    NewVcodeActivity.this.doY.setVisibility(0);
                    NewVcodeActivity.this.aDa();
                    NewVcodeActivity.this.aeb();
                }
            }
        });
        this.cpX = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.dpa != null) {
                    NewVcodeActivity.this.dpa.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aee() {
        if (this.dpb != null) {
            this.dpb.cancel();
        }
        this.doZ.setVisibility(0);
        this.dpb = new ChangeVcodeTask(this, null);
        this.dpb.setPriority(3);
        this.dpb.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDb() {
        if (this.dpe != null && this.dpe.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(i.h.sending), true, true, this.cpX);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.dpa != null) {
                this.dpa.cancel();
            }
            this.dpa = new PostThreadTask(this.doW);
            this.dpa.setPriority(3);
            this.dpa.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private com.baidu.tbadk.core.util.w afh = null;
        private String dbJ = null;
        private WriteData dbx;

        public PostThreadTask(WriteData writeData) {
            this.dbx = null;
            this.dbx = writeData;
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
            if (this.dbx == null) {
                return null;
            }
            this.afh = new com.baidu.tbadk.core.util.w();
            String imagesCodeForPost = this.dbx.getImagesCodeForPost();
            if (this.dbx.getType() == 3) {
                this.afh.o("newVcode", "1");
                this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dbx.getContent()) + imagesCodeForPost);
                this.afh.o(PayVcodeActivityConfig.VCODE_MD5, this.dbx.getVcodeMD5());
                this.afh.o("vcode", NewVcodeActivity.this.dpe);
                this.afh.o("tag", "11");
                this.afh.ue().uV().mIsNeedTbs = true;
                this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dbx.getContent()) + imagesCodeForPost);
                this.afh.setUrl(com.baidu.tieba.tbadkCore.d.a.cZG);
                this.afh.o(ImageViewerConfig.FORUM_NAME, this.dbx.getForumName());
                this.afh.o("title", this.dbx.getTitle());
                this.afh.o("apiKey", this.dbx.getShareApiKey());
                this.afh.o("appName", this.dbx.getShareAppName());
                this.afh.o("signKey", this.dbx.getShareSignKey());
                this.afh.o("summary_title", this.dbx.getShareSummaryTitle());
                this.afh.o("summary_content", this.dbx.getShareSummaryContent());
                this.afh.o("summary_img", this.dbx.getShareSummaryImg());
                this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dbx.getShareSummaryImgWidth()));
                this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dbx.getShareSummaryImgHeight()));
                this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dbx.getShareSummaryImgType());
                this.afh.o("referUrl", this.dbx.getShareReferUrl());
            } else {
                this.afh.o("anonymous", "0");
                this.afh.o(ImageViewerConfig.FORUM_ID, this.dbx.getForumId());
                this.afh.o("kw", this.dbx.getForumName());
                this.afh.o("new_vcode", "1");
                if (this.dbx.getVideoInfo() == null) {
                    str = String.valueOf(this.dbx.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.dbx.getContent()) + videoInfo.buildWriteContent(this.dbx.getForumName()) + imagesCodeForPost;
                }
                if (this.dbx.getType() == 6 && this.dbx.getVoteInfo() != null) {
                    if (this.dbx.getWriteImagesInfo() != null) {
                        this.dbx.getVoteInfo().setServerImageCode(this.dbx.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.dbx.getVoteInfo().buildWriteContent();
                }
                this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.afh, this.dbx);
                if (this.dbx.getIsBaobaoImageUploaded()) {
                    this.afh.o("tail_type", String.valueOf(a.C0075a.cZJ));
                    this.afh.o("tail_content", this.dbx.getBaobaoContent());
                    this.dbx.setBabaoPosted(true);
                } else {
                    this.dbx.setBabaoPosted(false);
                }
                this.afh.o("vcode_md5", this.dbx.getVcodeMD5());
                this.afh.o("vcode", NewVcodeActivity.this.dpe);
                this.afh.o("vcode_tag", "11");
                if (this.dbx.getVoice() != null) {
                    this.afh.o("voice_md5", this.dbx.getVoice());
                    this.afh.o("during_time", String.valueOf(this.dbx.getVoiceDuringTime()));
                }
                this.afh.ue().uV().mIsNeedTbs = true;
                if (this.dbx.getType() == 0) {
                    this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afh.o("title", this.dbx.getTitle());
                    this.afh.o("is_ntitle", this.dbx.isNoTitle() ? "1" : "0");
                    if (this.dbx.getLiveCardData() != null) {
                        this.afh.o("group_id", String.valueOf(this.dbx.getLiveCardData().getGroupId()));
                        this.afh.o("start_time", String.valueOf(this.dbx.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                        this.afh.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.dbx.getType() == 6) {
                    this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afh.o("title", this.dbx.getTitle());
                    this.afh.o("is_ntitle", this.dbx.isNoTitle() ? "1" : "0");
                    this.afh.o("thread_type", String.valueOf(36));
                } else if (this.dbx.getType() == 4) {
                    this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afh.o("title", this.dbx.getTitle());
                    this.afh.o("is_ntitle", "0");
                    this.afh.o("thread_type", String.valueOf(33));
                    this.afh.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.afh.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.afh.o("tid", this.dbx.getThreadId());
                    this.afh.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.dbx.getType() == 2) {
                        this.afh.o("quote_id", String.valueOf(this.dbx.getFloor()));
                        this.afh.o("floor_num", String.valueOf(this.dbx.getFloorNum()));
                        this.afh.o(WriteActivityConfig.IS_ADDITION, this.dbx.isAddition() ? "1" : "0");
                        if (this.dbx.getRepostId() != null) {
                            this.afh.o("repostid", this.dbx.getRepostId());
                        } else if (this.dbx.getType() == 5) {
                            this.afh.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
            }
            this.dbJ = this.afh.tD();
            if (this.afh.ue().uW().qS()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.dbJ);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                } else if ((this.dbx.isHasImages() || this.dbx.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dbx.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.dbx.deleteUploadedTempImages();
                    if (this.dbx.getType() == 1 && !this.dbx.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ad.c(this.dbx.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.dbx.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dbx.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afh.ui(), TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afh.ui(), this.afh.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.dbJ).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.dbJ).optString("tid");
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
                    str4 = new JSONObject(this.dbJ).optString(Info.kBaiduPIDKey);
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
            NewVcodeActivity.this.dpa = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.afh != null) {
                this.afh.gJ();
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
            NewVcodeActivity.this.dpa = null;
            if (dVar != null && this.afh != null) {
                if (this.afh.ue().uW().qS()) {
                    if (this.dbx.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.dbx.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dbx.getForumName(), "post live's thread")));
                    }
                    if (this.dbx != null && this.dbx.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awf();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    if (this.dbx != null && this.dbx.getVideoInfo() != null && postWriteCallBackData != null) {
                        XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), this.dbx.getForumId(), this.dbx.getVideoInfo().getVideoUrl(), this.dbx.getForumName());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (dVar.axP()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.dbJ);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.doW.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.doW.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.wp().equals("4")) {
                            NewVcodeActivity.this.aec();
                        } else {
                            if (this.dbx.getType() != 3) {
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
        volatile com.baidu.tbadk.core.util.w Ti;
        com.baidu.tbadk.coreExtra.data.l dpk;

        private ChangeVcodeTask() {
            this.Ti = null;
            this.dpk = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Ti = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Ti.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.doW.getForumId());
            this.Ti.o("kw", NewVcodeActivity.this.doW.getForumName());
            this.Ti.o("new_vcode", "1");
            this.Ti.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.doW.getContent());
            if (!NewVcodeActivity.this.doW.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.doW.setBabaoPosted(false);
            } else {
                this.Ti.o("tail_type", String.valueOf(a.C0075a.cZJ));
                this.Ti.o("tail_content", NewVcodeActivity.this.doW.getBaobaoContent());
                NewVcodeActivity.this.doW.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.doW.getVoice() != null) {
                this.Ti.o("voice_md5", NewVcodeActivity.this.doW.getVoice());
                this.Ti.o("during_time", String.valueOf(NewVcodeActivity.this.doW.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.doW.getType() == 0 || NewVcodeActivity.this.doW.getType() == 3) {
                this.Ti.o("title", NewVcodeActivity.this.doW.getTitle());
                this.Ti.o("pub_type", "1");
            } else {
                this.Ti.o("pub_type", "2");
                this.Ti.o("tid", NewVcodeActivity.this.doW.getThreadId());
            }
            this.Ti.o("vcode_tag", "11");
            String tD = this.Ti.tD();
            if (this.Ti.ue().uW().qS()) {
                this.dpk = new com.baidu.tbadk.coreExtra.data.l();
                this.dpk.parserJson(tD);
                return this.dpk;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.dpb = null;
            if (lVar != null) {
                NewVcodeActivity.this.doW.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.doW.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.wp().equals("4")) {
                    if (NewVcodeActivity.this.doW.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.aec();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Ti.getErrorString());
            }
            NewVcodeActivity.this.doZ.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dpb = null;
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            NewVcodeActivity.this.doZ.setVisibility(8);
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
            return NewVcodeActivity.this.doW.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.dpf = z;
            NewVcodeActivity.this.dpd = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(i.h.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.dpe = str;
                NewVcodeActivity.this.dpc = str2;
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
                NewVcodeActivity.this.dpc = str;
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
