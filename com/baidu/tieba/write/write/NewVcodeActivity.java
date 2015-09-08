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
    private TextView dcF;
    private WriteData dcE = null;
    private TextView dbc = null;
    private ProgressBar dcG = null;
    private ProgressBar dcH = null;
    private DialogInterface.OnCancelListener ckj = null;
    private PostThreadTask dcI = null;
    private ChangeVcodeTask dcJ = null;
    private BaseWebView mWebView = null;
    private String dcK = null;
    private String dcL = null;
    private String dcM = null;
    private boolean dcN = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dcO = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener dcP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.azr();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qw()) {
            this.dcG.setVisibility(0);
            azp();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dcE = (WriteData) bundle.getSerializable("model");
        } else {
            this.dcE = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.azt();
                        return;
                    case 1:
                        NewVcodeActivity.this.azs();
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
    private boolean qw() {
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
                        NewVcodeActivity.this.dcG.setVisibility(8);
                        if (!NewVcodeActivity.this.dcN) {
                            NewVcodeActivity.this.dcF.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.dcF.setVisibility(8);
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
    public void azo() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azp() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azq() {
        if (this.mWebView != null && this.dcK != null && this.dcK.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dcK + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azr() {
        if (this.mWebView != null && this.dcN && this.dcL != null && this.dcL.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dcL + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dcI != null) {
            this.dcI.cancel();
        }
        if (this.dcJ != null) {
            this.dcJ.cancel();
        }
        if (this.dcG != null) {
            this.dcG.setVisibility(8);
        }
        if (this.dcH != null) {
            this.dcH.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dcE);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dcE != null && this.dcE.getType() == 3) {
            if (this.dcI != null) {
                this.dcI.cancel();
            }
            if (this.dcJ != null) {
                this.dcJ.cancel();
            }
            if (this.dcG != null) {
                this.dcG.setVisibility(8);
            }
            if (this.dcH != null) {
                this.dcH.setVisibility(8);
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
        com.baidu.tbadk.core.util.al.g(this.dbc, i);
        com.baidu.tbadk.core.util.al.e((View) this.dcF, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.al.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void initUI() {
        this.dcG = (ProgressBar) findViewById(i.f.load_webview_progress);
        this.dcH = (ProgressBar) findViewById(i.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dcO);
        this.dbc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dcP);
        this.dcF = (TextView) findViewById(i.f.webview_fail_view);
        this.dcF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.dcN) {
                    NewVcodeActivity.this.dcG.setVisibility(0);
                    NewVcodeActivity.this.azo();
                    NewVcodeActivity.this.azp();
                }
            }
        });
        this.ckj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.dcI != null) {
                    NewVcodeActivity.this.dcI.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azs() {
        if (this.dcJ != null) {
            this.dcJ.cancel();
        }
        this.dcH.setVisibility(0);
        this.dcJ = new ChangeVcodeTask(this, null);
        this.dcJ.setPriority(3);
        this.dcJ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azt() {
        if (this.dcM != null && this.dcM.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(i.h.sending), true, true, this.ckj);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.dcI != null) {
                this.dcI.cancel();
            }
            this.dcI = new PostThreadTask(this.dcE);
            this.dcI.setPriority(3);
            this.dcI.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.b> {
        private com.baidu.tbadk.core.util.v afT = null;
        private String cTD = null;
        private WriteData cTs;

        public PostThreadTask(WriteData writeData) {
            this.cTs = null;
            this.cTs = writeData;
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
            if (this.cTs == null) {
                return null;
            }
            this.afT = new com.baidu.tbadk.core.util.v();
            String imagesCodeForPost = this.cTs.getImagesCodeForPost();
            if (this.cTs.getType() == 3) {
                this.afT.o("newVcode", "1");
                this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cTs.getContent()) + imagesCodeForPost);
                this.afT.o("vcodeMd5", this.cTs.getVcodeMD5());
                this.afT.o("vcode", NewVcodeActivity.this.dcM);
                this.afT.o("tag", "11");
                this.afT.uj().uZ().mIsNeedTbs = true;
                this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cTs.getContent()) + imagesCodeForPost);
                this.afT.setUrl(com.baidu.tieba.tbadkCore.d.a.cRC);
                this.afT.o(ImageViewerConfig.FORUM_NAME, this.cTs.getForumName());
                this.afT.o("title", this.cTs.getTitle());
                this.afT.o("apiKey", this.cTs.getShareApiKey());
                this.afT.o("appName", this.cTs.getShareAppName());
                this.afT.o("signKey", this.cTs.getShareSignKey());
                this.afT.o("summary_title", this.cTs.getShareSummaryTitle());
                this.afT.o("summary_content", this.cTs.getShareSummaryContent());
                this.afT.o("summary_img", this.cTs.getShareSummaryImg());
                this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cTs.getShareSummaryImgWidth()));
                this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cTs.getShareSummaryImgHeight()));
                this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cTs.getShareSummaryImgType());
                this.afT.o("referUrl", this.cTs.getShareReferUrl());
            } else {
                this.afT.o("anonymous", "0");
                this.afT.o(ImageViewerConfig.FORUM_ID, this.cTs.getForumId());
                this.afT.o("kw", this.cTs.getForumName());
                this.afT.o("new_vcode", "1");
                if (this.cTs.getVideoInfo() == null) {
                    str = String.valueOf(this.cTs.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.cTs.getContent()) + videoInfo.buildWriteContent(this.cTs.getForumName()) + imagesCodeForPost;
                }
                this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, this.cTs);
                if (this.cTs.getIsBaobaoImageUploaded()) {
                    this.afT.o("tail_type", String.valueOf(a.C0072a.cRF));
                    this.afT.o(TailEditActivityConfig.TAIL_CONTENT, this.cTs.getBaobaoContent());
                    this.cTs.setBabaoPosted(true);
                } else {
                    this.cTs.setBabaoPosted(false);
                }
                this.afT.o("vcode_md5", this.cTs.getVcodeMD5());
                this.afT.o("vcode", NewVcodeActivity.this.dcM);
                this.afT.o("vcode_tag", "11");
                if (this.cTs.getVoice() != null) {
                    this.afT.o("voice_md5", this.cTs.getVoice());
                    this.afT.o("during_time", String.valueOf(this.cTs.getVoiceDuringTime()));
                }
                this.afT.uj().uZ().mIsNeedTbs = true;
                if (this.cTs.getType() == 0) {
                    this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afT.o("title", this.cTs.getTitle());
                    this.afT.o("is_ntitle", this.cTs.isNoTitle() ? "1" : "0");
                    if (this.cTs.getLiveCardData() != null) {
                        this.afT.o("group_id", String.valueOf(this.cTs.getLiveCardData().getGroupId()));
                        this.afT.o("start_time", String.valueOf(this.cTs.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                        this.afT.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.cTs.getType() == 4) {
                    this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afT.o("title", this.cTs.getTitle());
                    this.afT.o("is_ntitle", "0");
                    this.afT.o("thread_type", String.valueOf(33));
                    this.afT.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.afT.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.afT.o("tid", this.cTs.getThreadId());
                    this.afT.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.cTs.getType() == 2) {
                        this.afT.o("quote_id", String.valueOf(this.cTs.getFloor()));
                        this.afT.o("floor_num", String.valueOf(this.cTs.getFloorNum()));
                        this.afT.o(WriteActivityConfig.IS_ADDITION, this.cTs.isAddition() ? "1" : "0");
                        if (this.cTs.getRepostId() != null) {
                            this.afT.o("repostid", this.cTs.getRepostId());
                        } else if (this.cTs.getType() == 5) {
                            this.afT.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    }
                }
            }
            this.cTD = this.afT.tI();
            if (this.afT.uj().va().qZ()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.cTD);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                } else if ((this.cTs.isHasImages() || this.cTs.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cTs.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.b bVar2 = new com.baidu.tieba.tbadkCore.writeModel.b(errorData.getError_code(), error_msg, null);
                if (!bVar2.hasError()) {
                    this.cTs.deleteUploadedTempImages();
                    if (this.cTs.getType() == 1 && !this.cTs.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ad.c(this.cTs.getThreadId(), (WriteData) null);
                        bVar = bVar2;
                    }
                }
                bVar = bVar2;
            } else if (this.cTs.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.cTs.getContent()) + imagesCodeForPost)) {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(this.afT.un(), TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error), null);
            } else {
                bVar = new com.baidu.tieba.tbadkCore.writeModel.b(this.afT.un(), this.afT.getErrorString(), null);
            }
            if (!bVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.cTD).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.cTD).optString("tid");
                    } catch (JSONException e2) {
                        str3 = "";
                        e = e2;
                    }
                    try {
                        str4 = new JSONObject(this.cTD).optString(Info.kBaiduPIDKey);
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
                    str2 = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
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
            NewVcodeActivity.this.dcI = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.afT != null) {
                this.afT.gJ();
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
            NewVcodeActivity.this.dcI = null;
            if (bVar != null && this.afT != null) {
                if (this.afT.uj().va().qZ()) {
                    if (this.cTs.getType() != 3) {
                        if (bVar.hasError()) {
                            NewVcodeActivity.this.showToast(bVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.c.d(NewVcodeActivity.this.getPageContext().getPageActivity(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                        }
                    }
                    if (this.cTs.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cTs.getForumName(), "post live's thread")));
                    }
                    if (this.cTs != null && this.cTs.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.atL();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(bVar.getErrorCode(), bVar.getErrorString(), bVar.getPreMsg(), bVar.getColorMsg());
                    postWriteCallBackData.setThreadId(bVar.getThreadId());
                    postWriteCallBackData.setPostId(bVar.getPostId());
                    if (this.cTs != null && this.cTs.getVideoInfo() != null && postWriteCallBackData != null) {
                        XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), this.cTs.getForumId(), this.cTs.getVideoInfo().getVideoUrl(), this.cTs.getForumName());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (bVar.avv()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.cTD);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.dcE.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.dcE.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.wI().equals("4")) {
                            NewVcodeActivity.this.azq();
                        } else {
                            if (this.cTs.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
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
        volatile com.baidu.tbadk.core.util.v Tv;
        com.baidu.tbadk.coreExtra.data.l dcR;

        private ChangeVcodeTask() {
            this.Tv = null;
            this.dcR = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Tv = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Tv.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.dcE.getForumId());
            this.Tv.o("kw", NewVcodeActivity.this.dcE.getForumName());
            this.Tv.o("new_vcode", "1");
            this.Tv.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.dcE.getContent());
            if (!NewVcodeActivity.this.dcE.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.dcE.setBabaoPosted(false);
            } else {
                this.Tv.o("tail_type", String.valueOf(a.C0072a.cRF));
                this.Tv.o(TailEditActivityConfig.TAIL_CONTENT, NewVcodeActivity.this.dcE.getBaobaoContent());
                NewVcodeActivity.this.dcE.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.dcE.getVoice() != null) {
                this.Tv.o("voice_md5", NewVcodeActivity.this.dcE.getVoice());
                this.Tv.o("during_time", String.valueOf(NewVcodeActivity.this.dcE.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.dcE.getType() == 0 || NewVcodeActivity.this.dcE.getType() == 3) {
                this.Tv.o("title", NewVcodeActivity.this.dcE.getTitle());
                this.Tv.o("pub_type", "1");
            } else {
                this.Tv.o("pub_type", "2");
                this.Tv.o("tid", NewVcodeActivity.this.dcE.getThreadId());
            }
            this.Tv.o("vcode_tag", "11");
            String tI = this.Tv.tI();
            if (this.Tv.uj().va().qZ()) {
                this.dcR = new com.baidu.tbadk.coreExtra.data.l();
                this.dcR.parserJson(tI);
                return this.dcR;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.dcJ = null;
            if (lVar != null) {
                NewVcodeActivity.this.dcE.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.dcE.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.wI().equals("4")) {
                    if (NewVcodeActivity.this.dcE.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.azq();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Tv.getErrorString());
            }
            NewVcodeActivity.this.dcH.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dcJ = null;
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            NewVcodeActivity.this.dcH.setVisibility(8);
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
            return NewVcodeActivity.this.dcE.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.dcN = z;
            NewVcodeActivity.this.dcL = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(i.h.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.dcM = str;
                NewVcodeActivity.this.dcK = str2;
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
                NewVcodeActivity.this.dcK = str;
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
