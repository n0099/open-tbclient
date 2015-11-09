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
    private TextView dqM;
    private WriteData dqL = null;
    private TextView dom = null;
    private ProgressBar dqN = null;
    private ProgressBar dqO = null;
    private DialogInterface.OnCancelListener crt = null;
    private PostThreadTask dqP = null;
    private ChangeVcodeTask dqQ = null;
    private BaseWebView mWebView = null;
    private String dqR = null;
    private String dqS = null;
    private String dqT = null;
    private boolean dqU = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dqV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener dqW = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.aey();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.new_vcode_activity);
        initUI();
        initData(bundle);
        if (qq()) {
            this.dqN.setVisibility(0);
            aew();
            return;
        }
        finish();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dqL = (WriteData) bundle.getSerializable("model");
        } else {
            this.dqL = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.aDT();
                        return;
                    case 1:
                        NewVcodeActivity.this.aez();
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
    private boolean qq() {
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
                        NewVcodeActivity.this.dqN.setVisibility(8);
                        if (!NewVcodeActivity.this.dqU) {
                            NewVcodeActivity.this.dqM.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.dqM.setVisibility(8);
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
    public void aDS() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aew() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aex() {
        if (this.mWebView != null && this.dqR != null && this.dqR.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dqR + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aey() {
        if (this.mWebView != null && this.dqU && this.dqS != null && this.dqS.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.dqS + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dqP != null) {
            this.dqP.cancel();
        }
        if (this.dqQ != null) {
            this.dqQ.cancel();
        }
        if (this.dqN != null) {
            this.dqN.setVisibility(8);
        }
        if (this.dqO != null) {
            this.dqO.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dqL);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dqL != null && this.dqL.getType() == 3) {
            if (this.dqP != null) {
                this.dqP.cancel();
            }
            if (this.dqQ != null) {
                this.dqQ.cancel();
            }
            if (this.dqN != null) {
                this.dqN.setVisibility(8);
            }
            if (this.dqO != null) {
                this.dqO.setVisibility(8);
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
        com.baidu.tbadk.core.util.an.e((View) this.dqM, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.an.e(this.mWebView, TbadkCoreApplication.m411getInst().getSkinType());
        }
        com.baidu.tbadk.core.util.an.i((View) this.dom, i.e.s_navbar_button_bg);
    }

    private void initUI() {
        this.dqN = (ProgressBar) findViewById(i.f.load_webview_progress);
        this.dqO = (ProgressBar) findViewById(i.f.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dqV);
        this.dom = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.send), this.dqW);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dom.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16);
        this.dom.setLayoutParams(layoutParams);
        this.dqM = (TextView) findViewById(i.f.webview_fail_view);
        this.dqM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.dqU) {
                    NewVcodeActivity.this.dqN.setVisibility(0);
                    NewVcodeActivity.this.aDS();
                    NewVcodeActivity.this.aew();
                }
            }
        });
        this.crt = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.dqP != null) {
                    NewVcodeActivity.this.dqP.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aez() {
        if (this.dqQ != null) {
            this.dqQ.cancel();
        }
        this.dqO.setVisibility(0);
        this.dqQ = new ChangeVcodeTask(this, null);
        this.dqQ.setPriority(3);
        this.dqQ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        if (this.dqT != null && this.dqT.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(getPageContext().getPageActivity(), "", getPageContext().getString(i.h.sending), true, true, this.crt);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.dqP != null) {
                this.dqP.cancel();
            }
            this.dqP = new PostThreadTask(this.dqL);
            this.dqP.setPriority(3);
            this.dqP.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.tbadkCore.writeModel.d> {
        private WriteData ddI;
        private com.baidu.tbadk.core.util.w afm = null;
        private String ddT = null;

        public PostThreadTask(WriteData writeData) {
            this.ddI = null;
            this.ddI = writeData;
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
            if (this.ddI == null) {
                return null;
            }
            this.afm = new com.baidu.tbadk.core.util.w();
            String imagesCodeForPost = this.ddI.getImagesCodeForPost();
            if (this.ddI.getType() == 3) {
                this.afm.o("newVcode", "1");
                this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.ddI.getContent()) + imagesCodeForPost);
                this.afm.o(PayVcodeActivityConfig.VCODE_MD5, this.ddI.getVcodeMD5());
                this.afm.o("vcode", NewVcodeActivity.this.dqT);
                this.afm.o("tag", "11");
                this.afm.uh().uZ().mIsNeedTbs = true;
                this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.ddI.getContent()) + imagesCodeForPost);
                this.afm.setUrl(com.baidu.tieba.tbadkCore.d.a.dbq);
                this.afm.o(ImageViewerConfig.FORUM_NAME, this.ddI.getForumName());
                this.afm.o("title", this.ddI.getTitle());
                this.afm.o("apiKey", this.ddI.getShareApiKey());
                this.afm.o("appName", this.ddI.getShareAppName());
                this.afm.o("signKey", this.ddI.getShareSignKey());
                this.afm.o("summary_title", this.ddI.getShareSummaryTitle());
                this.afm.o("summary_content", this.ddI.getShareSummaryContent());
                this.afm.o("summary_img", this.ddI.getShareSummaryImg());
                this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.ddI.getShareSummaryImgWidth()));
                this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.ddI.getShareSummaryImgHeight()));
                this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ddI.getShareSummaryImgType());
                this.afm.o("referUrl", this.ddI.getShareReferUrl());
            } else {
                this.afm.o("anonymous", "0");
                this.afm.o(ImageViewerConfig.FORUM_ID, this.ddI.getForumId());
                this.afm.o("kw", this.ddI.getForumName());
                this.afm.o("new_vcode", "1");
                if (this.ddI.getVideoInfo() == null) {
                    str = String.valueOf(this.ddI.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(this.ddI.getContent()) + videoInfo.buildWriteContent(this.ddI.getForumName()) + imagesCodeForPost;
                }
                if (this.ddI.getType() == 6 && this.ddI.getVoteInfo() != null) {
                    if (this.ddI.getWriteImagesInfo() != null) {
                        this.ddI.getVoteInfo().setServerImageCode(this.ddI.getWriteImagesInfo().getChosedFiles());
                    }
                    str = this.ddI.getVoteInfo().buildWriteContent();
                }
                this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                com.baidu.tieba.tbadkCore.writeModel.e.a(this.afm, this.ddI);
                if (this.ddI.getIsBaobaoImageUploaded()) {
                    this.afm.o("tail_type", String.valueOf(a.C0076a.dbt));
                    this.afm.o("tail_content", this.ddI.getBaobaoContent());
                    this.ddI.setBabaoPosted(true);
                } else {
                    this.ddI.setBabaoPosted(false);
                }
                this.afm.o("vcode_md5", this.ddI.getVcodeMD5());
                this.afm.o("vcode", NewVcodeActivity.this.dqT);
                this.afm.o("vcode_tag", "11");
                if (this.ddI.getVoice() != null) {
                    this.afm.o("voice_md5", this.ddI.getVoice());
                    this.afm.o("during_time", String.valueOf(this.ddI.getVoiceDuringTime()));
                }
                this.afm.uh().uZ().mIsNeedTbs = true;
                if (this.ddI.getType() == 0) {
                    this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afm.o("title", this.ddI.getTitle());
                    this.afm.o("is_ntitle", this.ddI.isNoTitle() ? "1" : "0");
                    if (NewVcodeActivity.this.dqL.getCategoryFrom() >= 0) {
                        this.afm.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dqL.getCategoryFrom()));
                    }
                    if (NewVcodeActivity.this.dqL.getCategoryTo() >= 0) {
                        this.afm.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dqL.getCategoryTo()));
                    }
                    if (this.ddI.getLiveCardData() != null) {
                        this.afm.o("group_id", String.valueOf(this.ddI.getLiveCardData().getGroupId()));
                        this.afm.o("start_time", String.valueOf(this.ddI.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.d.a.gC().y(false)) != null) {
                        this.afm.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                } else if (this.ddI.getType() == 6) {
                    this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afm.o("title", this.ddI.getTitle());
                    this.afm.o("is_ntitle", this.ddI.isNoTitle() ? "1" : "0");
                    this.afm.o("thread_type", String.valueOf(36));
                } else if (this.ddI.getType() == 4) {
                    this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.afm.o("title", this.ddI.getTitle());
                    this.afm.o("is_ntitle", "0");
                    this.afm.o("thread_type", String.valueOf(33));
                    this.afm.o("is_twzhibo_thread", String.valueOf(1));
                } else {
                    this.afm.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.afm.o("tid", this.ddI.getThreadId());
                    this.afm.o("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.ddI.getType() == 2) {
                        this.afm.o("quote_id", String.valueOf(this.ddI.getFloor()));
                        this.afm.o("floor_num", String.valueOf(this.ddI.getFloorNum()));
                        this.afm.o(WriteActivityConfig.IS_ADDITION, this.ddI.isAddition() ? "1" : "0");
                        if (this.ddI.getRepostId() != null) {
                            this.afm.o("repostid", this.ddI.getRepostId());
                        } else if (this.ddI.getType() == 5) {
                            this.afm.o("is_twzhibo_thread", String.valueOf(1));
                        }
                    } else if (this.ddI.getType() == 1 && com.baidu.tbadk.editortools.c.b.AW().getStatus() == 1) {
                        this.afm.o("ptype", "4");
                    }
                }
            }
            this.ddT = this.afm.tG();
            if (this.afm.uh().va().qT()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.ddT);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.j.isEmpty(error_msg)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.send_success);
                } else if ((this.ddI.isHasImages() || this.ddI.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.ddI.getContent()) + imagesCodeForPost)) {
                    error_msg = TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error);
                }
                com.baidu.tieba.tbadkCore.writeModel.d dVar2 = new com.baidu.tieba.tbadkCore.writeModel.d(errorData.getError_code(), error_msg, null);
                if (!dVar2.hasError()) {
                    this.ddI.deleteUploadedTempImages();
                    if (this.ddI.getType() == 1 && !this.ddI.isSubFloor()) {
                        com.baidu.tieba.tbadkCore.ad.c(this.ddI.getThreadId(), (WriteData) null);
                        dVar = dVar2;
                    }
                }
                dVar = dVar2;
            } else if (this.ddI.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.ddI.getContent()) + imagesCodeForPost)) {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afm.ul(), TbadkCoreApplication.m411getInst().getString(i.h.img_upload_error), null);
            } else {
                dVar = new com.baidu.tieba.tbadkCore.writeModel.d(this.afm.ul(), this.afm.getErrorString(), null);
            }
            if (!dVar.hasError()) {
                String str4 = "";
                try {
                    str2 = new JSONObject(this.ddT).optString(AddFriendActivityConfig.MSG);
                    try {
                        str3 = new JSONObject(this.ddT).optString("tid");
                    } catch (JSONException e2) {
                        str3 = "";
                        e = e2;
                    }
                    try {
                        str4 = new JSONObject(this.ddT).optString(Info.kBaiduPIDKey);
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
            NewVcodeActivity.this.dqP = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.afm != null) {
                this.afm.gJ();
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
            NewVcodeActivity.this.dqP = null;
            if (dVar != null && this.afm != null) {
                if (this.afm.uh().va().qT()) {
                    if (this.ddI.getType() != 3) {
                        if (dVar.hasError()) {
                            NewVcodeActivity.this.showToast(dVar.getErrorString());
                        } else {
                            com.baidu.tieba.tbadkCore.writeModel.e.d(NewVcodeActivity.this.getPageContext().getPageActivity(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                        }
                    }
                    if (this.ddI.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.ddI.getForumName(), "post live's thread")));
                    }
                    if (this.ddI != null && this.ddI.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.awN();
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(dVar.getErrorCode(), dVar.getErrorString(), dVar.getPreMsg(), dVar.getColorMsg());
                    postWriteCallBackData.setThreadId(dVar.getThreadId());
                    postWriteCallBackData.setPostId(dVar.getPostId());
                    if (this.ddI != null && this.ddI.getVideoInfo() != null && postWriteCallBackData != null) {
                        XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), this.ddI.getForumId(), this.ddI.getVideoInfo().getVideoUrl(), this.ddI.getForumName());
                    }
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent.putExtras(bundle);
                    NewVcodeActivity.this.setResult(-1, intent);
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (dVar.ayY()) {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.ddT);
                    if (lVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.dqL.setVcodeMD5(lVar.getVcode_md5());
                        NewVcodeActivity.this.dqL.setVcodeUrl(lVar.getVcode_pic_url());
                        if (lVar.wu().equals("4")) {
                            NewVcodeActivity.this.aex();
                        } else {
                            if (this.ddI.getType() != 3) {
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
        volatile com.baidu.tbadk.core.util.w Tj;
        com.baidu.tbadk.coreExtra.data.l dqY;

        private ChangeVcodeTask() {
            this.Tj = null;
            this.dqY = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public com.baidu.tbadk.coreExtra.data.l doInBackground(String... strArr) {
            this.Tj = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.Tj.o(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.dqL.getForumId());
            this.Tj.o("kw", NewVcodeActivity.this.dqL.getForumName());
            this.Tj.o("new_vcode", "1");
            this.Tj.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, NewVcodeActivity.this.dqL.getContent());
            if (!NewVcodeActivity.this.dqL.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.dqL.setBabaoPosted(false);
            } else {
                this.Tj.o("tail_type", String.valueOf(a.C0076a.dbt));
                this.Tj.o("tail_content", NewVcodeActivity.this.dqL.getBaobaoContent());
                NewVcodeActivity.this.dqL.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.dqL.getVoice() != null) {
                this.Tj.o("voice_md5", NewVcodeActivity.this.dqL.getVoice());
                this.Tj.o("during_time", String.valueOf(NewVcodeActivity.this.dqL.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.dqL.getType() == 0 || NewVcodeActivity.this.dqL.getType() == 3) {
                this.Tj.o("title", NewVcodeActivity.this.dqL.getTitle());
                this.Tj.o("pub_type", "1");
            } else {
                this.Tj.o("pub_type", "2");
                this.Tj.o("tid", NewVcodeActivity.this.dqL.getThreadId());
            }
            this.Tj.o("vcode_tag", "11");
            if (NewVcodeActivity.this.dqL.getCategoryFrom() >= 0) {
                this.Tj.o("fromCategoryId", String.valueOf(NewVcodeActivity.this.dqL.getCategoryFrom()));
            }
            if (NewVcodeActivity.this.dqL.getCategoryTo() >= 0) {
                this.Tj.o("toCategoryId", String.valueOf(NewVcodeActivity.this.dqL.getCategoryTo()));
            }
            String tG = this.Tj.tG();
            if (this.Tj.uh().va().qT()) {
                this.dqY = new com.baidu.tbadk.coreExtra.data.l();
                this.dqY.parserJson(tG);
                return this.dqY;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
            NewVcodeActivity.this.dqQ = null;
            if (lVar != null) {
                NewVcodeActivity.this.dqL.setVcodeMD5(lVar.getVcode_md5());
                NewVcodeActivity.this.dqL.setVcodeUrl(lVar.getVcode_pic_url());
                if (!lVar.wu().equals("4")) {
                    if (NewVcodeActivity.this.dqL.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getPageContext().getString(i.h.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.aex();
                }
            } else {
                NewVcodeActivity.this.showToast(this.Tj.getErrorString());
            }
            NewVcodeActivity.this.dqO.setVisibility(8);
            super.onPostExecute(lVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.dqQ = null;
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            NewVcodeActivity.this.dqO.setVisibility(8);
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
            return NewVcodeActivity.this.dqL.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.dqU = z;
            NewVcodeActivity.this.dqS = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getPageContext().getString(i.h.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.dqT = str;
                NewVcodeActivity.this.dqR = str2;
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
                NewVcodeActivity.this.dqR = str;
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
