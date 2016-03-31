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
    private com.baidu.tieba.tbadkCore.writeModel.a avv;
    private BaseWebView mWebView = null;
    private View aEi = null;
    private View aEj = null;
    private TextView aEk = null;
    private com.baidu.tbadk.core.view.b aEl = null;
    private com.baidu.tbadk.core.view.h aEm = null;
    private com.baidu.tbadk.core.view.h aEn = null;
    private WriteData eMa = null;
    private String aEo = null;
    private String aEp = null;
    private boolean aEq = true;
    private boolean aEw = false;
    private Runnable aEx = new Runnable() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (NewVcodeActivity.this.mWebView == null) {
                return;
            }
            NewVcodeActivity.this.HJ();
            NewVcodeActivity.this.mWebView.setVisibility(0);
        }
    };
    private final a.d avL = new a.d() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.2
        @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
            NewVcodeActivity.this.aEj.setVisibility(8);
            if (!z) {
                NewVcodeActivity.this.aEn.d(NewVcodeActivity.this.getResources().getString(t.j.input_vcode_error));
                NewVcodeActivity.this.HH();
                return;
            }
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                NewVcodeActivity.this.aEm.c(NewVcodeActivity.this.getResources().getString(t.j.video_send_success_under_review));
            } else if (writeData == null || writeData.getVideoReviewType() != 2) {
                NewVcodeActivity.this.aEm.c(NewVcodeActivity.this.getResources().getString(t.j.send_success));
            } else {
                NewVcodeActivity.this.aEm.c(NewVcodeActivity.this.getResources().getString(t.j.video_send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            NewVcodeActivity.this.setResult(-1, intent);
            NewVcodeActivity.this.finish();
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
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aEx);
        bbh();
        HF();
        if (this.eMa.getType() == 3) {
            com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 200, false);
        }
        if (this.aEn != null) {
            this.aEn.xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        bbh();
        HF();
        if (this.eMa.getType() == 3) {
            com.baidu.tbadk.core.d.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.eMa);
        bundle.putBoolean("need_feed_back_button", this.aEq);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pU();
        initData(bundle);
        if (pX()) {
            HG();
        } else {
            finish();
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.eMa = (WriteData) bundle.getSerializable("model");
            this.aEq = bundle.getBoolean("need_feed_back_button");
        } else {
            Intent intent = getIntent();
            this.eMa = (WriteData) intent.getSerializableExtra("model");
            this.aEq = intent.getBooleanExtra("need_feed_back_button", true);
        }
        if (this.eMa == null) {
            finish();
            return;
        }
        this.avv = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.avv.b(this.avL);
        this.avv.d(this.eMa);
        if (this.eMa.getWriteImagesInfo() != null) {
            this.avv.iN(this.eMa.getWriteImagesInfo().size() > 0);
        }
    }

    @JavascriptInterface
    private boolean pX() {
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
                            if (!NewVcodeActivity.this.aEw) {
                                NewVcodeActivity.this.aEw = true;
                                com.baidu.adp.lib.h.h.hx().postDelayed(NewVcodeActivity.this.aEx, 500L);
                            }
                            if (str.equals("objc:jumpToFeedback()")) {
                                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(NewVcodeActivity.this.getPageContext().getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
                                writeActivityConfig.setIsVcodeFeedBack();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                                return true;
                            } else if (str.contains("objc:jsChangeVcode")) {
                                NewVcodeActivity.this.aEo = NewVcodeActivity.this.gq(str);
                                if (NewVcodeActivity.this.aEo == null || NewVcodeActivity.this.eMa == null) {
                                    return false;
                                }
                                NewVcodeActivity.this.as(NewVcodeActivity.this.aEo, NewVcodeActivity.this.eMa.getVcodeUrl());
                                return true;
                            } else if (!str.contains("objc:jsSubmit")) {
                                return false;
                            } else {
                                return NewVcodeActivity.this.gr(NewVcodeActivity.this.gq(str));
                            }
                        }
                        return false;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        super.onPageFinished(webView, str);
                        NewVcodeActivity.this.aEw = true;
                        NewVcodeActivity.this.HJ();
                        NewVcodeActivity.this.mWebView.setVisibility(0);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                        NewVcodeActivity.this.HJ();
                        NewVcodeActivity.this.showToast(t.j.neterror);
                        NewVcodeActivity.this.finish();
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

    private void HF() {
        if (this.mWebView != null) {
            HJ();
            this.mWebView.stopLoading();
        }
    }

    private void HG() {
        if (this.mWebView != null) {
            HI();
            String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
            if (this.aEq) {
                str = String.valueOf(str) + "?feedback=1";
            }
            this.mWebView.loadUrl(str);
        }
    }

    private void pU() {
        setActivityBgTransparent();
        setSwipeBackEnabled(false);
        setContentView(t.h.new_vcode_activity);
        this.aEi = findViewById(t.g.new_vcode_black_layout);
        this.aEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.finish();
            }
        });
        this.aEj = findViewById(t.g.post_thread_loading_view);
        this.aEk = (TextView) this.aEj.findViewById(t.g.custom_loading_text);
        this.aEk.setText(getResources().getString(t.j.sending));
        this.aEm = new com.baidu.tbadk.core.view.h();
        this.aEn = new com.baidu.tbadk.core.view.h();
        this.aEm.afp = 1000L;
        this.aEn.afp = 1000L;
    }

    private void bbh() {
        this.aEj.setVisibility(8);
        HH();
        if (this.avv != null) {
            this.avv.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2) {
        if (this.mWebView != null) {
            this.mWebView.loadUrl("javascript:window." + str + "('" + str2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gq(String str) {
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
    public boolean gr(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.aEp = split[0];
        pa(split[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        as(this.aEp, this.eMa.getVcodeUrl());
    }

    private void pa(String str) {
        if (!com.baidu.adp.lib.util.k.jw()) {
            showToast(t.j.neterror);
            finish();
        } else if (!StringUtils.isNull(str)) {
            this.aEj.setVisibility(0);
            this.eMa.setVcode(str);
            this.avv.aUG();
        }
    }

    private void HI() {
        if (this.aEl == null) {
            this.aEl = new com.baidu.tbadk.core.view.b(getPageContext());
            this.aEl.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.NewVcodeActivity.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    NewVcodeActivity.this.finish();
                }
            });
        }
        this.aEl.ay(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ() {
        if (this.aEl != null) {
            this.aEl.ay(false);
        }
    }
}
