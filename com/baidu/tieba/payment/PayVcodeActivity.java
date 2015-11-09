package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
/* loaded from: classes.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    private a cef;
    private b ceg;
    private String ceh;
    private String cei;
    private String cej;
    private String cek;
    private String cel;
    private boolean cem;
    private Handler mHandler;
    private String mUrl;
    private String mVcodeUrl;
    private boolean bna = false;
    private HttpMessageListener cen = new HttpMessageListener(CmdConfigHttp.CMD_PAY_NEW_VCODE) { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayVcodeActivity.this.ceg.dc(false);
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
                if (!responsePayNewVcodeInfoMessage.hasError()) {
                    PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                    if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                        PayVcodeActivity.this.ceh = payNewVcodeInfoData.getCaptcha_vcode_str();
                        PayVcodeActivity.this.mVcodeUrl = payNewVcodeInfoData.getVcode_pic_url();
                        PayVcodeActivity.this.cei = payNewVcodeInfoData.getCaptcha_code_type();
                        PayVcodeActivity.this.aex();
                        return;
                    }
                    String errorString = responsePayNewVcodeInfoMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = PayVcodeActivity.this.getResources().getString(i.h.payment_vcode_get_error);
                    }
                    PayVcodeActivity.this.showToast(errorString);
                    return;
                }
                PayVcodeActivity.this.showToast(i.h.neterror);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        initData(bundle);
        initUI();
        AM();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bna) {
            QE();
        }
    }

    private void initData(Bundle bundle) {
        this.mUrl = UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion());
        this.ceh = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
        this.mVcodeUrl = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
        this.cef = new a(getPageContext());
        this.mHandler = new Handler() { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        PayVcodeActivity.this.aez();
                        return;
                    case 2:
                        PayVcodeActivity.this.showToast(i.h.payment_vcode_error);
                        return;
                    case 3:
                        PayVcodeActivity.this.doNext();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void AM() {
        this.cef.aeB();
        registerListener(this.cen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aew() {
        this.ceg.dc(true);
        this.ceg.getWebView().loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aex() {
        if (!StringUtils.isNull(this.cek)) {
            this.ceg.getWebView().loadUrl("javascript:" + this.cek + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aey() {
        if (!StringUtils.isNull(this.cel) && this.cem) {
            this.ceg.getWebView().loadUrl("javascript:" + this.cel + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ceg.onChangeSkinType(i);
    }

    private void initUI() {
        this.ceg = new b(this);
        this.ceg.aeC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.aey();
            }
        });
        this.ceg.aeD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PayVcodeActivity.this.cem) {
                    PayVcodeActivity.this.ceg.dc(true);
                    PayVcodeActivity.this.ceg.getWebView().stopLoading();
                    PayVcodeActivity.this.ceg.getWebView().loadUrl(PayVcodeActivity.this.mUrl);
                }
            }
        });
        this.ceg.getWebView().addJavascriptInterface(new VcodeJsInterface(this, null), "VcodeJsInterface");
        this.ceg.getWebView().setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PayVcodeActivity.this.ceg.dc(false);
                PayVcodeActivity.this.ceg.ei(PayVcodeActivity.this.cem ? false : true);
            }
        });
        this.ceg.aeE().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.eh(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aez() {
        this.ceg.dc(true);
        this.cef.aeA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNext() {
        eh(true);
    }

    public void QE() {
        this.ceg.aeE().setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.ceg.aeE().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PayVcodeActivity.this.aew();
            }
        });
        this.ceg.aeF().startAnimation(loadAnimation);
        this.bna = true;
    }

    public void eh(final boolean z) {
        this.ceg.aeE().setBackgroundColor(an.getColor(i.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.ceg.aeE().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), i.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z && !StringUtils.isNull(PayVcodeActivity.this.cej)) {
                    Intent intent = new Intent();
                    intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, PayVcodeActivity.this.cej);
                    intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, PayVcodeActivity.this.ceh);
                    PayVcodeActivity.this.setResult(-1, intent);
                }
                PayVcodeActivity.this.closeActivity();
            }
        });
        this.ceg.aeF().startAnimation(loadAnimation);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            eh(false);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class VcodeJsInterface {
        private VcodeJsInterface() {
        }

        /* synthetic */ VcodeJsInterface(PayVcodeActivity payVcodeActivity, VcodeJsInterface vcodeJsInterface) {
            this();
        }

        public String jsGetVcodeImageUrl() {
            return PayVcodeActivity.this.mVcodeUrl;
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            PayVcodeActivity.this.cem = z;
            PayVcodeActivity.this.cel = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                PayVcodeActivity.this.mHandler.removeMessages(2);
                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(2));
            } else if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                PayVcodeActivity.this.cej = str;
                PayVcodeActivity.this.cek = str2;
                PayVcodeActivity.this.mHandler.removeMessages(3);
                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(3));
            }
        }

        @JavascriptInterface
        public void jsCancelVcode() {
            PayVcodeActivity.this.closeActivity();
        }

        @JavascriptInterface
        public void jsChangeVcode(String str) {
            if (!StringUtils.isNull(str)) {
                PayVcodeActivity.this.cek = str;
                PayVcodeActivity.this.mHandler.removeMessages(1);
                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(1));
            }
        }

        @JavascriptInterface
        public String jsGetSkinType() {
            return String.valueOf(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }
}
