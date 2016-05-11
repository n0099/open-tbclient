package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity<NewVcodeActivity> {
    private com.baidu.tieba.tbadkCore.writeModel.a aru;
    private BaseWebView mWebView = null;
    private View aAs = null;
    private View aAt = null;
    private TextView aAu = null;
    private com.baidu.tbadk.core.view.b aAv = null;
    private com.baidu.tbadk.core.view.h aAw = null;
    private com.baidu.tbadk.core.view.h aAx = null;
    private WriteData fcO = null;
    private String aAy = null;
    private String aAz = null;
    private boolean aAA = true;
    private boolean aAG = false;
    private Runnable aAH = new Runnable() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeActivity.this.mWebView == null) {
                return;
            }
            NewVcodeActivity.this.FL();
            NewVcodeActivity.this.mWebView.setVisibility(0);
        }
    };
    private final a.d arK = new a.d() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
            NewVcodeActivity.this.aAt.setVisibility(8);
            if (z) {
                if (writeData != null && writeData.getVideoReviewType() == 1) {
                    NewVcodeActivity.this.aAw.c(NewVcodeActivity.this.getResources().getString(t.j.video_send_success_under_review));
                } else if (writeData == null || writeData.getVideoReviewType() != 2) {
                    NewVcodeActivity.this.aAw.c(NewVcodeActivity.this.getResources().getString(t.j.send_success));
                } else {
                    NewVcodeActivity.this.aAw.c(NewVcodeActivity.this.getResources().getString(t.j.video_send_success));
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                NewVcodeActivity.this.setResult(-1, intent);
                NewVcodeActivity.this.finish();
                return;
            }
            if (postWriteCallBackData == null || StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                NewVcodeActivity.this.aAx.d(NewVcodeActivity.this.getResources().getString(t.j.input_vcode_error));
            } else {
                NewVcodeActivity.this.aAx.d(postWriteCallBackData.getErrorString());
            }
            NewVcodeActivity.this.FJ();
        }
    };

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aAH);
        bdu();
        FH();
        if (this.fcO.getType() == 3) {
            com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 200, false);
        }
        if (this.aAx != null) {
            this.aAx.uS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bdu();
        FH();
        if (this.fcO.getType() == 3) {
            com.baidu.tbadk.core.e.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.fcO);
        bundle.putBoolean("need_feed_back_button", this.aAA);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nq();
        initData(bundle);
        if (nt()) {
            FI();
        } else {
            finish();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.fcO = (WriteData) bundle.getSerializable("model");
            this.aAA = bundle.getBoolean("need_feed_back_button");
        } else {
            Intent intent = getIntent();
            this.fcO = (WriteData) intent.getSerializableExtra("model");
            this.aAA = intent.getBooleanExtra("need_feed_back_button", true);
        }
        if (this.fcO == null) {
            finish();
            return;
        }
        this.aru = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aru.b(this.arK);
        this.aru.d(this.fcO);
        if (this.fcO.getWriteImagesInfo() != null) {
            this.aru.jC(this.fcO.getWriteImagesInfo().size() > 0);
        }
    }

    @JavascriptInterface
    private boolean nt() {
        if (this.mWebView == null) {
            try {
                this.mWebView = (BaseWebView) findViewById(t.g.new_vcode_webview);
                UtilHelper.setSupportHeight(getPageContext().getPageActivity(), this.mWebView, 1.2631578f);
                this.mWebView.setBackgroundColor(getResources().getColor(17170443));
                this.mWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return motionEvent.getAction() == 2;
                    }
                });
                this.mWebView.getSettings().setJavaScriptEnabled(true);
                this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        if (!StringUtils.isNull(str)) {
                            if (!NewVcodeActivity.this.aAG) {
                                NewVcodeActivity.this.aAG = true;
                                com.baidu.adp.lib.h.h.dL().postDelayed(NewVcodeActivity.this.aAH, 500L);
                            }
                            if (str.equals("objc:jumpToFeedback()")) {
                                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
                                writeActivityConfig.setIsVcodeFeedBack();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                                return true;
                            } else if (str.contains("objc:jsChangeVcode")) {
                                NewVcodeActivity.this.aAy = NewVcodeActivity.this.gr(str);
                                if (NewVcodeActivity.this.aAy == null || NewVcodeActivity.this.fcO == null) {
                                    return false;
                                }
                                NewVcodeActivity.this.at(NewVcodeActivity.this.aAy, NewVcodeActivity.this.fcO.getVcodeUrl());
                                return true;
                            } else if (!str.contains("objc:jsSubmit")) {
                                return false;
                            } else {
                                return NewVcodeActivity.this.gs(NewVcodeActivity.this.gr(str));
                            }
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeActivity.this.aAG = true;
                        NewVcodeActivity.this.FL();
                        NewVcodeActivity.this.mWebView.setVisibility(0);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeActivity.this.FL();
                        NewVcodeActivity.this.showToast(t.j.neterror);
                        NewVcodeActivity.this.finish();
                    }
                });
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TbadkCoreApplication.m11getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.m11getInst().getNewVcodeWebviewCrashCount() + 1);
                return false;
            }
        }
        return true;
    }

    private void FH() {
        if (this.mWebView != null) {
            FL();
            this.mWebView.stopLoading();
        }
    }

    private void FI() {
        if (this.mWebView != null) {
            FK();
            String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
            if (this.aAA) {
                str = String.valueOf(str) + "?feedback=1";
            }
            this.mWebView.loadUrl(str);
        }
    }

    private void nq() {
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        setContentView(t.h.new_vcode_activity);
        this.aAs = findViewById(t.g.new_vcode_black_layout);
        this.aAs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.finish();
            }
        });
        this.aAt = findViewById(t.g.post_thread_loading_view);
        this.aAu = (TextView) this.aAt.findViewById(t.g.custom_loading_text);
        this.aAu.setText(getResources().getString(t.j.sending));
        this.aAw = new com.baidu.tbadk.core.view.h();
        this.aAx = new com.baidu.tbadk.core.view.h();
        this.aAw.aaO = 1000L;
        this.aAx.aaO = 1000L;
    }

    private void bdu() {
        this.aAt.setVisibility(8);
        FJ();
        if (this.aru != null) {
            this.aru.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gr(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        int indexOf = str.indexOf("(");
        int indexOf2 = str.indexOf(")");
        if (indexOf == -1 || indexOf2 == -1 || indexOf + 1 >= indexOf2) {
            return null;
        }
        return str.substring(indexOf + 1, indexOf2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gs(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.aAz = split[0];
        po(split[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        at(this.aAz, this.fcO.getVcodeUrl());
    }

    private void po(String str) {
        if (!com.baidu.adp.lib.util.k.fH()) {
            showToast(t.j.neterror);
            finish();
        } else if (!StringUtils.isNull(str)) {
            this.aAt.setVisibility(0);
            this.fcO.setVcode(str);
            this.aru.aVb();
        }
    }

    private void FK() {
        if (this.aAv == null) {
            this.aAv = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aAv.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeActivity.this.finish();
                }
            });
        }
        this.aAv.aD(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL() {
        if (this.aAv != null) {
            this.aAv.aD(false);
        }
    }
}
