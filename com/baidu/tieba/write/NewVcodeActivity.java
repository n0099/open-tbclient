package com.baidu.tieba.write;

import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity {
    private TextView bTc;
    private WriteData bTb = null;
    private TextView bJw = null;
    private ProgressBar bTd = null;
    private ProgressBar bTe = null;
    private DialogInterface.OnCancelListener bCh = null;
    private PostThreadTask bTf = null;
    private ChangeVcodeTask bTg = null;
    private BaseWebView mWebView = null;
    private String bTh = null;
    private String bTi = null;
    private String bTj = null;
    private boolean bTk = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener bTl = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener bTm = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.afn();
        }
    };

    static {
        TbadkApplication.m251getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_vcode_activity);
        initUI();
        d(bundle);
        if (afj()) {
            this.bTd.setVisibility(0);
            afl();
            return;
        }
        finish();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.bTb = (WriteData) bundle.getSerializable("model");
        } else {
            this.bTb = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.afp();
                        return;
                    case 1:
                        NewVcodeActivity.this.afo();
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
    private boolean afj() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.v.new_vcode_webview);
                com.baidu.tbadk.core.util.aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
                this.mWebView.setHorizontalScrollBarEnabled(false);
                this.mWebView.setHorizontalScrollbarOverlay(false);
                this.mWebView.setScrollBarStyle(33554432);
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.bTd.setVisibility(8);
                        if (!NewVcodeActivity.this.bTk) {
                            NewVcodeActivity.this.bTc.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.bTc.setVisibility(8);
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
                com.baidu.tieba.aj.wk().dD(com.baidu.tieba.aj.wk().wG() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(com.baidu.tieba.util.q.aP(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afm() {
        if (this.mWebView != null && this.bTh != null && this.bTh.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.bTh + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        if (this.mWebView != null && this.bTk && this.bTi != null && this.bTi.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.bTi + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bTf != null) {
            this.bTf.cancel();
        }
        if (this.bTg != null) {
            this.bTg.cancel();
        }
        if (this.bTd != null) {
            this.bTd.setVisibility(8);
        }
        if (this.bTe != null) {
            this.bTe.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.bTb);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.f(this.bJw, i);
        com.baidu.tbadk.core.util.aw.d((View) this.bTc, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
        }
    }

    private void initUI() {
        this.bTd = (ProgressBar) findViewById(com.baidu.tieba.v.load_webview_progress);
        this.bTe = (ProgressBar) findViewById(com.baidu.tieba.v.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bTl);
        this.bJw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.bTm);
        this.bTc = (TextView) findViewById(com.baidu.tieba.v.webview_fail_view);
        this.bTc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.bTk) {
                    NewVcodeActivity.this.bTd.setVisibility(0);
                    NewVcodeActivity.this.afk();
                    NewVcodeActivity.this.afl();
                }
            }
        });
        this.bCh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.bTf != null) {
                    NewVcodeActivity.this.bTf.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (this.bTg != null) {
            this.bTg.cancel();
        }
        this.bTe.setVisibility(0);
        this.bTg = new ChangeVcodeTask(this, null);
        this.bTg.setPriority(3);
        this.bTg.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        if (this.bTj != null && this.bTj.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(this, "", getString(com.baidu.tieba.y.sending), true, true, this.bCh);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.bTf != null) {
                this.bTf.cancel();
            }
            this.bTf = new PostThreadTask(this.bTb);
            this.bTf.setPriority(3);
            this.bTf.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ao> {
        private WriteData bpv;
        private com.baidu.tbadk.core.util.ac yV = null;
        private String KX = null;

        public PostThreadTask(WriteData writeData) {
            this.bpv = null;
            this.bpv = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public com.baidu.tieba.data.ao doInBackground(Integer... numArr) {
            Address address;
            com.baidu.tieba.data.ao aoVar;
            String str;
            if (this.bpv == null) {
                return null;
            }
            this.yV = new com.baidu.tbadk.core.util.ac();
            String imagesCodeForPost = this.bpv.getImagesCodeForPost();
            if (this.bpv.getType() == 3) {
                this.yV.k("newVcode", "1");
                this.yV.k("content", String.valueOf(this.bpv.getContent()) + imagesCodeForPost);
                this.yV.k("vcodeMd5", this.bpv.getVcodeMD5());
                this.yV.k("vcode", NewVcodeActivity.this.bTj);
                this.yV.k("tag", "11");
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.k("content", String.valueOf(this.bpv.getContent()) + imagesCodeForPost);
                this.yV.setUrl(com.baidu.tieba.a.c.amJ);
                this.yV.k(ImageViewerConfig.FORUM_NAME, this.bpv.getForumName());
                this.yV.k("title", this.bpv.getTitle());
                this.yV.k("apiKey", this.bpv.getShareApiKey());
                this.yV.k("appName", this.bpv.getShareAppName());
                this.yV.k("signKey", this.bpv.getShareSignKey());
                this.yV.k("summary_title", this.bpv.getShareSummaryTitle());
                this.yV.k("summary_content", this.bpv.getShareSummaryContent());
                this.yV.k("summary_img", this.bpv.getShareSummaryImg());
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bpv.getShareSummaryImgWidth()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bpv.getShareSummaryImgHeight()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bpv.getShareSummaryImgType());
                this.yV.k("referUrl", this.bpv.getShareReferUrl());
            } else {
                this.yV.k("anonymous", "0");
                this.yV.k(ImageViewerConfig.FORUM_ID, this.bpv.getForumId());
                this.yV.k("kw", this.bpv.getForumName());
                this.yV.k("new_vcode", "1");
                this.yV.k("content", String.valueOf(this.bpv.getContent()) + imagesCodeForPost);
                ck.a(this.yV, this.bpv);
                if (this.bpv.getIsBaobaoImageUploaded()) {
                    this.yV.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amM));
                    this.yV.k("tail_content", this.bpv.getBaobaoContent());
                    this.bpv.setBabaoPosted(true);
                } else {
                    this.bpv.setBabaoPosted(false);
                }
                this.yV.k("vcode_md5", this.bpv.getVcodeMD5());
                this.yV.k("vcode", NewVcodeActivity.this.bTj);
                this.yV.k("vcode_tag", "11");
                if (this.bpv.getVoice() != null) {
                    this.yV.k("voice_md5", this.bpv.getVoice());
                    this.yV.k("during_time", String.valueOf(this.bpv.getVoiceDuringTime()));
                }
                this.yV.mc().na().mIsNeedTbs = true;
                if (this.bpv.getType() == 0) {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
                    this.yV.k("title", this.bpv.getTitle());
                    this.yV.k("is_ntitle", this.bpv.isNoTitle() ? "1" : "0");
                    if (this.bpv.getLiveCardData() != null) {
                        this.yV.k("group_id", String.valueOf(this.bpv.getLiveCardData().getGroupId()));
                        this.yV.k("start_time", String.valueOf(this.bpv.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.aj.wk().wu() && (address = com.baidu.adp.lib.d.a.dE().getAddress(false)) != null) {
                        this.yV.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
                    }
                } else {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
                    this.yV.k("tid", this.bpv.getThreadId());
                    this.yV.k("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bpv.getType() == 2) {
                        this.yV.k("quote_id", String.valueOf(this.bpv.getFloor()));
                        this.yV.k(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bpv.getFloorNum()));
                        this.yV.k(WriteActivityConfig.IS_ADDITION, this.bpv.isAddition() ? "1" : "0");
                        if (this.bpv.getRepostId() != null) {
                            this.yV.k("repostid", this.bpv.getRepostId());
                        }
                    }
                }
            }
            this.KX = this.yV.lA();
            if (this.yV.mc().nb().jq()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.KX);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.l.aA(error_msg)) {
                    error_msg = com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.send_success);
                } else if ((this.bpv.isHasImages() || this.bpv.getIsBaobao()) && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bpv.getContent()) + imagesCodeForPost)) {
                    error_msg = com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.img_upload_error);
                }
                com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao(errorData.getError_code(), error_msg, null);
                if (!aoVar2.hasError()) {
                    this.bpv.deleteUploadedTempImages();
                    if (this.bpv.getType() == 1 && !this.bpv.isSubFloor()) {
                        com.baidu.tieba.util.l.b(this.bpv.getThreadId(), (WriteData) null);
                        aoVar = aoVar2;
                    }
                }
                aoVar = aoVar2;
            } else if (this.bpv.isHasImages() && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bpv.getContent()) + imagesCodeForPost)) {
                aoVar = new com.baidu.tieba.data.ao(this.yV.mg(), com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.img_upload_error), null);
            } else {
                aoVar = new com.baidu.tieba.data.ao(this.yV.mg(), this.yV.getErrorString(), null);
            }
            if (!aoVar.hasError()) {
                try {
                    str = new JSONObject(this.KX).optString(AddFriendActivityConfig.MSG);
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = null;
                }
                if (StringUtils.isNull(str)) {
                    str = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.send_success);
                }
                aoVar.setErrorString(str);
            }
            return aoVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.bTf = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.yV != null) {
                this.yV.dM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.data.ao aoVar) {
            super.onPostExecute(aoVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.bTf = null;
            if (aoVar != null && this.yV != null) {
                if (this.yV.mc().nb().jq()) {
                    if (aoVar.hasError()) {
                        NewVcodeActivity.this.showToast(aoVar.getErrorString());
                    } else {
                        ck.J(NewVcodeActivity.this, aoVar.getErrorString());
                    }
                    if (this.bpv.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this).createRefreshCfgShowContent(this.bpv.getForumName(), "post live's thread")));
                    }
                    if (this.bpv != null && this.bpv.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adI();
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (aoVar.Am()) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.parserJson(this.KX);
                    if (fVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.bTb.setVcodeMD5(fVar.getVcode_md5());
                        NewVcodeActivity.this.bTb.setVcodeUrl(fVar.getVcode_pic_url());
                        if (fVar.oA().equals("4")) {
                            NewVcodeActivity.this.afm();
                        } else {
                            NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.y.change_vcode_type));
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(aoVar.getErrorString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        com.baidu.tbadk.coreExtra.data.f bTo;
        volatile com.baidu.tbadk.core.util.ac mNetWork;

        private ChangeVcodeTask() {
            this.mNetWork = null;
            this.bTo = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.mNetWork.k(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.bTb.getForumId());
            this.mNetWork.k("kw", NewVcodeActivity.this.bTb.getForumName());
            this.mNetWork.k("new_vcode", "1");
            this.mNetWork.k("content", NewVcodeActivity.this.bTb.getContent());
            if (!NewVcodeActivity.this.bTb.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.bTb.setBabaoPosted(false);
            } else {
                this.mNetWork.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amM));
                this.mNetWork.k("tail_content", NewVcodeActivity.this.bTb.getBaobaoContent());
                NewVcodeActivity.this.bTb.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.bTb.getVoice() != null) {
                this.mNetWork.k("voice_md5", NewVcodeActivity.this.bTb.getVoice());
                this.mNetWork.k("during_time", String.valueOf(NewVcodeActivity.this.bTb.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.bTb.getType() == 0) {
                this.mNetWork.k("title", NewVcodeActivity.this.bTb.getTitle());
                this.mNetWork.k("pub_type", "1");
            } else {
                this.mNetWork.k("pub_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                this.mNetWork.k("tid", NewVcodeActivity.this.bTb.getThreadId());
            }
            this.mNetWork.k("vcode_tag", "11");
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mc().nb().jq()) {
                this.bTo = new com.baidu.tbadk.coreExtra.data.f();
                this.bTo.parserJson(lA);
                return this.bTo;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            NewVcodeActivity.this.bTg = null;
            if (fVar != null) {
                NewVcodeActivity.this.bTb.setVcodeMD5(fVar.getVcode_md5());
                NewVcodeActivity.this.bTb.setVcodeUrl(fVar.getVcode_pic_url());
                if (fVar.oA().equals("4")) {
                    NewVcodeActivity.this.afm();
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.y.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.mNetWork.getErrorString());
            }
            NewVcodeActivity.this.bTe.setVisibility(8);
            super.onPostExecute(fVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.bTg = null;
            if (this.mNetWork != null) {
                this.mNetWork.dM();
            }
            NewVcodeActivity.this.bTe.setVisibility(8);
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
            return NewVcodeActivity.this.bTb.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.bTk = z;
            NewVcodeActivity.this.bTi = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getString(com.baidu.tieba.y.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.bTj = str;
                NewVcodeActivity.this.bTh = str2;
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
                NewVcodeActivity.this.bTh = str;
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(1);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(1));
                }
            }
        }

        @JavascriptInterface
        public String jsGetSkinType() {
            return String.valueOf(TbadkApplication.m251getInst().getSkinType());
        }
    }
}
