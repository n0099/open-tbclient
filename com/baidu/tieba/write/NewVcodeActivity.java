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
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
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
    private TextView bTr;
    private WriteData bTq = null;
    private TextView bJL = null;
    private ProgressBar bTs = null;
    private ProgressBar bTt = null;
    private DialogInterface.OnCancelListener bCv = null;
    private PostThreadTask bTu = null;
    private ChangeVcodeTask bTv = null;
    private BaseWebView mWebView = null;
    private String bTw = null;
    private String bTx = null;
    private String bTy = null;
    private boolean bTz = false;
    private Handler mHandler = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener bTA = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener bTB = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.afq();
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
        if (afm()) {
            this.bTs.setVisibility(0);
            afo();
            return;
        }
        finish();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.bTq = (WriteData) bundle.getSerializable("model");
        } else {
            this.bTq = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mHandler = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.afs();
                        return;
                    case 1:
                        NewVcodeActivity.this.afr();
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
    private boolean afm() {
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
                        NewVcodeActivity.this.bTs.setVisibility(8);
                        if (!NewVcodeActivity.this.bTz) {
                            NewVcodeActivity.this.bTr.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.bTr.setVisibility(8);
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
                com.baidu.tieba.aj.wm().dD(com.baidu.tieba.aj.wm().wI() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        if (this.mWebView != null) {
            this.mWebView.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        if (this.mWebView != null) {
            this.mWebView.loadUrl(com.baidu.tieba.util.q.aP(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afp() {
        if (this.mWebView != null && this.bTw != null && this.bTw.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.bTw + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afq() {
        if (this.mWebView != null && this.bTz && this.bTx != null && this.bTx.length() > 0) {
            this.mWebView.loadUrl("javascript:" + this.bTx + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bTu != null) {
            this.bTu.cancel();
        }
        if (this.bTv != null) {
            this.bTv.cancel();
        }
        if (this.bTs != null) {
            this.bTs.setVisibility(8);
        }
        if (this.bTt != null) {
            this.bTt.setVisibility(8);
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.bTq);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bTq != null && this.bTq.getType() == 3) {
            if (this.bTu != null) {
                this.bTu.cancel();
            }
            if (this.bTv != null) {
                this.bTv.cancel();
            }
            if (this.bTs != null) {
                this.bTs.setVisibility(8);
            }
            if (this.bTt != null) {
                this.bTt.setVisibility(8);
            }
            if (this.mHandler != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.removeMessages(2);
            }
            com.baidu.tbadk.core.b.b.a(this, Constants.MEDIA_INFO, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.f(this.bJL, i);
        com.baidu.tbadk.core.util.aw.d((View) this.bTr, i);
        if (this.mWebView != null) {
            com.baidu.tbadk.core.util.aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
        }
    }

    private void initUI() {
        this.bTs = (ProgressBar) findViewById(com.baidu.tieba.v.load_webview_progress);
        this.bTt = (ProgressBar) findViewById(com.baidu.tieba.v.change_vcode_progress);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bTA);
        this.bJL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.send), this.bTB);
        this.bTr = (TextView) findViewById(com.baidu.tieba.v.webview_fail_view);
        this.bTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.bTz) {
                    NewVcodeActivity.this.bTs.setVisibility(0);
                    NewVcodeActivity.this.afn();
                    NewVcodeActivity.this.afo();
                }
            }
        });
        this.bCv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.destroyWaitingDialog();
                if (NewVcodeActivity.this.bTu != null) {
                    NewVcodeActivity.this.bTu.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afr() {
        if (this.bTv != null) {
            this.bTv.cancel();
        }
        this.bTt.setVisibility(0);
        this.bTv = new ChangeVcodeTask(this, null);
        this.bTv.setPriority(3);
        this.bTv.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afs() {
        if (this.bTy != null && this.bTy.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(this, "", getString(com.baidu.tieba.y.sending), true, true, this.bCv);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.bTu != null) {
                this.bTu.cancel();
            }
            this.bTu = new PostThreadTask(this.bTq);
            this.bTu.setPriority(3);
            this.bTu.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ao> {
        private WriteData bpJ;
        private com.baidu.tbadk.core.util.ac yV = null;
        private String KY = null;

        public PostThreadTask(WriteData writeData) {
            this.bpJ = null;
            this.bpJ = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public com.baidu.tieba.data.ao doInBackground(Integer... numArr) {
            Address address;
            com.baidu.tieba.data.ao aoVar;
            String str;
            if (this.bpJ == null) {
                return null;
            }
            this.yV = new com.baidu.tbadk.core.util.ac();
            String imagesCodeForPost = this.bpJ.getImagesCodeForPost();
            if (this.bpJ.getType() == 3) {
                this.yV.k("newVcode", "1");
                this.yV.k("content", String.valueOf(this.bpJ.getContent()) + imagesCodeForPost);
                this.yV.k("vcodeMd5", this.bpJ.getVcodeMD5());
                this.yV.k("vcode", NewVcodeActivity.this.bTy);
                this.yV.k("tag", "11");
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.k("content", String.valueOf(this.bpJ.getContent()) + imagesCodeForPost);
                this.yV.setUrl(com.baidu.tieba.a.c.amS);
                this.yV.k(ImageViewerConfig.FORUM_NAME, this.bpJ.getForumName());
                this.yV.k("title", this.bpJ.getTitle());
                this.yV.k("apiKey", this.bpJ.getShareApiKey());
                this.yV.k("appName", this.bpJ.getShareAppName());
                this.yV.k("signKey", this.bpJ.getShareSignKey());
                this.yV.k("summary_title", this.bpJ.getShareSummaryTitle());
                this.yV.k("summary_content", this.bpJ.getShareSummaryContent());
                this.yV.k("summary_img", this.bpJ.getShareSummaryImg());
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bpJ.getShareSummaryImgWidth()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bpJ.getShareSummaryImgHeight()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bpJ.getShareSummaryImgType());
                this.yV.k("referUrl", this.bpJ.getShareReferUrl());
            } else {
                this.yV.k("anonymous", "0");
                this.yV.k(ImageViewerConfig.FORUM_ID, this.bpJ.getForumId());
                this.yV.k("kw", this.bpJ.getForumName());
                this.yV.k("new_vcode", "1");
                this.yV.k("content", String.valueOf(this.bpJ.getContent()) + imagesCodeForPost);
                ck.a(this.yV, this.bpJ);
                if (this.bpJ.getIsBaobaoImageUploaded()) {
                    this.yV.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amV));
                    this.yV.k("tail_content", this.bpJ.getBaobaoContent());
                    this.bpJ.setBabaoPosted(true);
                } else {
                    this.bpJ.setBabaoPosted(false);
                }
                this.yV.k("vcode_md5", this.bpJ.getVcodeMD5());
                this.yV.k("vcode", NewVcodeActivity.this.bTy);
                this.yV.k("vcode_tag", "11");
                if (this.bpJ.getVoice() != null) {
                    this.yV.k("voice_md5", this.bpJ.getVoice());
                    this.yV.k("during_time", String.valueOf(this.bpJ.getVoiceDuringTime()));
                }
                this.yV.mc().na().mIsNeedTbs = true;
                if (this.bpJ.getType() == 0) {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
                    this.yV.k("title", this.bpJ.getTitle());
                    this.yV.k("is_ntitle", this.bpJ.isNoTitle() ? "1" : "0");
                    if (this.bpJ.getLiveCardData() != null) {
                        this.yV.k("group_id", String.valueOf(this.bpJ.getLiveCardData().getGroupId()));
                        this.yV.k("start_time", String.valueOf(this.bpJ.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.aj.wm().ww() && (address = com.baidu.adp.lib.d.a.dE().getAddress(false)) != null) {
                        this.yV.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
                    }
                } else {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
                    this.yV.k("tid", this.bpJ.getThreadId());
                    this.yV.k("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bpJ.getType() == 2) {
                        this.yV.k("quote_id", String.valueOf(this.bpJ.getFloor()));
                        this.yV.k(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bpJ.getFloorNum()));
                        this.yV.k(WriteActivityConfig.IS_ADDITION, this.bpJ.isAddition() ? "1" : "0");
                        if (this.bpJ.getRepostId() != null) {
                            this.yV.k("repostid", this.bpJ.getRepostId());
                        }
                    }
                }
            }
            this.KY = this.yV.lA();
            if (this.yV.mc().nb().jq()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.KY);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.l.aA(error_msg)) {
                    error_msg = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.send_success);
                } else if ((this.bpJ.isHasImages() || this.bpJ.getIsBaobao()) && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bpJ.getContent()) + imagesCodeForPost)) {
                    error_msg = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.img_upload_error);
                }
                com.baidu.tieba.data.ao aoVar2 = new com.baidu.tieba.data.ao(errorData.getError_code(), error_msg, null);
                if (!aoVar2.hasError()) {
                    this.bpJ.deleteUploadedTempImages();
                    if (this.bpJ.getType() == 1 && !this.bpJ.isSubFloor()) {
                        com.baidu.tieba.util.l.b(this.bpJ.getThreadId(), (WriteData) null);
                        aoVar = aoVar2;
                    }
                }
                aoVar = aoVar2;
            } else if (this.bpJ.isHasImages() && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bpJ.getContent()) + imagesCodeForPost)) {
                aoVar = new com.baidu.tieba.data.ao(this.yV.mg(), com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.img_upload_error), null);
            } else {
                aoVar = new com.baidu.tieba.data.ao(this.yV.mg(), this.yV.getErrorString(), null);
            }
            if (!aoVar.hasError()) {
                try {
                    str = new JSONObject(this.KY).optString(AddFriendActivityConfig.MSG);
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
            NewVcodeActivity.this.bTu = null;
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
            NewVcodeActivity.this.bTu = null;
            if (aoVar != null && this.yV != null) {
                if (this.yV.mc().nb().jq()) {
                    if (this.bpJ.getType() != 3) {
                        if (aoVar.hasError()) {
                            NewVcodeActivity.this.showToast(aoVar.getErrorString());
                        } else {
                            ck.J(NewVcodeActivity.this, aoVar.getErrorString());
                        }
                    }
                    if (this.bpJ.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(NewVcodeActivity.this).createRefreshCfgShowContent(this.bpJ.getForumName(), "post live's thread")));
                    }
                    if (this.bpJ != null && this.bpJ.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adL();
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (aoVar.Ao()) {
                    com.baidu.tbadk.coreExtra.data.g gVar = new com.baidu.tbadk.coreExtra.data.g();
                    gVar.parserJson(this.KY);
                    if (gVar.getVcode_pic_url() != null) {
                        NewVcodeActivity.this.bTq.setVcodeMD5(gVar.getVcode_md5());
                        NewVcodeActivity.this.bTq.setVcodeUrl(gVar.getVcode_pic_url());
                        if (gVar.oC().equals("4")) {
                            NewVcodeActivity.this.afp();
                        } else {
                            if (this.bpJ.getType() != 3) {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.y.change_vcode_type));
                            }
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
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.g> {
        com.baidu.tbadk.coreExtra.data.g bTD;
        volatile com.baidu.tbadk.core.util.ac mNetWork;

        private ChangeVcodeTask() {
            this.mNetWork = null;
            this.bTD = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public com.baidu.tbadk.coreExtra.data.g doInBackground(String... strArr) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.mNetWork.k(ImageViewerConfig.FORUM_ID, NewVcodeActivity.this.bTq.getForumId());
            this.mNetWork.k("kw", NewVcodeActivity.this.bTq.getForumName());
            this.mNetWork.k("new_vcode", "1");
            this.mNetWork.k("content", NewVcodeActivity.this.bTq.getContent());
            if (!NewVcodeActivity.this.bTq.getIsBaobaoImageUploaded()) {
                NewVcodeActivity.this.bTq.setBabaoPosted(false);
            } else {
                this.mNetWork.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amV));
                this.mNetWork.k("tail_content", NewVcodeActivity.this.bTq.getBaobaoContent());
                NewVcodeActivity.this.bTq.setBabaoPosted(true);
            }
            if (NewVcodeActivity.this.bTq.getVoice() != null) {
                this.mNetWork.k("voice_md5", NewVcodeActivity.this.bTq.getVoice());
                this.mNetWork.k("during_time", String.valueOf(NewVcodeActivity.this.bTq.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.bTq.getType() == 0 || NewVcodeActivity.this.bTq.getType() == 3) {
                this.mNetWork.k("title", NewVcodeActivity.this.bTq.getTitle());
                this.mNetWork.k("pub_type", "1");
            } else {
                this.mNetWork.k("pub_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                this.mNetWork.k("tid", NewVcodeActivity.this.bTq.getThreadId());
            }
            this.mNetWork.k("vcode_tag", "11");
            String lA = this.mNetWork.lA();
            if (this.mNetWork.mc().nb().jq()) {
                this.bTD = new com.baidu.tbadk.coreExtra.data.g();
                this.bTD.parserJson(lA);
                return this.bTD;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
            NewVcodeActivity.this.bTv = null;
            if (gVar != null) {
                NewVcodeActivity.this.bTq.setVcodeMD5(gVar.getVcode_md5());
                NewVcodeActivity.this.bTq.setVcodeUrl(gVar.getVcode_pic_url());
                if (!gVar.oC().equals("4")) {
                    if (NewVcodeActivity.this.bTq.getType() != 3) {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.y.change_vcode_type));
                    }
                    NewVcodeActivity.this.finish();
                } else {
                    NewVcodeActivity.this.afp();
                }
            } else {
                NewVcodeActivity.this.showToast(this.mNetWork.getErrorString());
            }
            NewVcodeActivity.this.bTt.setVisibility(8);
            super.onPostExecute(gVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.bTv = null;
            if (this.mNetWork != null) {
                this.mNetWork.dM();
            }
            NewVcodeActivity.this.bTt.setVisibility(8);
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
            return NewVcodeActivity.this.bTq.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.bTz = z;
            NewVcodeActivity.this.bTx = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.mHandler != null) {
                    NewVcodeActivity.this.mHandler.removeMessages(2);
                    NewVcodeActivity.this.mHandler.sendMessage(NewVcodeActivity.this.mHandler.obtainMessage(2, NewVcodeActivity.this.getString(com.baidu.tieba.y.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.bTy = str;
                NewVcodeActivity.this.bTw = str2;
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
                NewVcodeActivity.this.bTw = str;
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
