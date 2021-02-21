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
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private com.baidu.tieba.tbadkCore.e.c jsCallback;
    private PayVcodeModel lHs;
    private a lHt;
    private String lHu;
    private String lHv;
    private String lHw;
    private String lHx;
    private boolean lHy;
    private Handler mHandler;
    private String mUrl;
    private String mVcodeType;
    private String mVcodeUrl;
    private boolean jUP = false;
    private HttpMessageListener lHz = new HttpMessageListener(1001539) { // from class: com.baidu.tieba.payment.PayVcodeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayVcodeActivity.this.lHt.tL(false);
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
                if (!responsePayNewVcodeInfoMessage.hasError()) {
                    PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                    if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                        PayVcodeActivity.this.lHu = payNewVcodeInfoData.getCaptcha_vcode_str();
                        PayVcodeActivity.this.mVcodeUrl = payNewVcodeInfoData.getVcode_pic_url();
                        PayVcodeActivity.this.mVcodeType = payNewVcodeInfoData.getCaptcha_code_type();
                        PayVcodeActivity.this.dkv();
                        return;
                    }
                    String errorString = responsePayNewVcodeInfoMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = PayVcodeActivity.this.getResources().getString(R.string.payment_vcode_get_error);
                    }
                    PayVcodeActivity.this.showToast(errorString);
                    return;
                }
                PayVcodeActivity.this.showToast(R.string.neterror);
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
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
            @Override // com.baidu.tieba.tbadkCore.e.b
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if ("VcodeJsInterface".equalsIgnoreCase(str)) {
                    if ("jsCancelVcode".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm();
                        PayVcodeActivity.this.closeActivity();
                        return true;
                    } else if ("jsChangeVcode".equalsIgnoreCase(str2)) {
                        try {
                            String string = new JSONObject(str3).getString(BuyTBeanActivityConfig.CALLBACK);
                            if (!StringUtils.isNull(string)) {
                                PayVcodeActivity.this.lHw = string;
                                PayVcodeActivity.this.mHandler.removeMessages(1);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(1));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else if ("jsGetSkinType".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(String.valueOf(TbadkCoreApplication.getInst().getSkinType()));
                        return true;
                    } else if ("jsGetVcodeImageUrl".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(PayVcodeActivity.this.mVcodeUrl);
                        return true;
                    } else if ("jsSetLoadVcodeFinished".equalsIgnoreCase(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            PayVcodeActivity.this.lHy = jSONObject.optBoolean("canpost");
                            PayVcodeActivity.this.lHx = jSONObject.optString(BuyTBeanActivityConfig.CALLBACK);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else if ("jsSetVcodeInputResult".equalsIgnoreCase(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            boolean optBoolean = jSONObject2.optBoolean("canpost");
                            String optString = jSONObject2.optString("val");
                            String optString2 = jSONObject2.optString(BuyTBeanActivityConfig.CALLBACK);
                            if (!optBoolean) {
                                PayVcodeActivity.this.mHandler.removeMessages(2);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(2));
                            } else if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                                PayVcodeActivity.this.lHv = optString;
                                PayVcodeActivity.this.lHw = optString2;
                                PayVcodeActivity.this.mHandler.removeMessages(3);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(3));
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
        this.jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (PayVcodeActivity.this.jsBridge != null) {
                    return PayVcodeActivity.this.jsBridge.a(PayVcodeActivity.this.lHt.getWebView(), str, jsPromptResult);
                }
                return false;
            }
        };
        initData(bundle);
        initUI();
        register();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.jUP) {
            aCu();
        }
    }

    private void initData(Bundle bundle) {
        this.mUrl = UtilHelper.appendCuidParam(TbConfig.SERVER_ADDRESS + Config.NEW_VCODE_WEBVIEW_ADDRESS + "?version=" + TbConfig.getVersion());
        this.lHu = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
        this.mVcodeUrl = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
        this.lHs = new PayVcodeModel(getPageContext());
        this.mHandler = new Handler() { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        PayVcodeActivity.this.dkx();
                        return;
                    case 2:
                        PayVcodeActivity.this.showToast(R.string.payment_vcode_error);
                        return;
                    case 3:
                        PayVcodeActivity.this.dky();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void register() {
        this.lHs.dkA();
        registerListener(this.lHz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dku() {
        this.lHt.tL(true);
        this.lHt.getWebView().loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkv() {
        if (!StringUtils.isNull(this.lHw)) {
            this.lHt.getWebView().loadUrl("javascript:" + this.lHw + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkw() {
        if (!StringUtils.isNull(this.lHx) && this.lHy) {
            this.lHt.getWebView().loadUrl("javascript:" + this.lHx + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        if (this.jsBridge != null) {
            this.jsBridge.dOh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lHt.onChangeSkinType(i);
    }

    private void initUI() {
        this.lHt = new a(this);
        this.lHt.dkB().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.dkw();
            }
        });
        this.lHt.dkC().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PayVcodeActivity.this.lHy) {
                    PayVcodeActivity.this.lHt.tL(true);
                    PayVcodeActivity.this.lHt.getWebView().stopLoading();
                    PayVcodeActivity.this.lHt.getWebView().loadUrl(PayVcodeActivity.this.mUrl);
                }
            }
        });
        b bVar = new b(this);
        bVar.setOnJsPromptCallback(this.jsCallback);
        this.lHt.getWebView().setWebChromeClient(bVar);
        this.lHt.getWebView().setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PayVcodeActivity.this.lHt.tL(false);
                PayVcodeActivity.this.lHt.uz(PayVcodeActivity.this.lHy ? false : true);
            }
        });
        this.lHt.dkD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.uy(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkx() {
        this.lHt.tL(true);
        this.lHs.dkz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dky() {
        uy(true);
    }

    public void aCu() {
        this.lHt.dkD().setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.lHt.dkD().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
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
                PayVcodeActivity.this.dku();
            }
        });
        this.lHt.dkE().startAnimation(loadAnimation);
        this.jUP = true;
    }

    public void uy(final boolean z) {
        this.lHt.dkD().setBackgroundColor(ap.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.lHt.dkD().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z && !StringUtils.isNull(PayVcodeActivity.this.lHv)) {
                    Intent intent = new Intent();
                    intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, PayVcodeActivity.this.lHv);
                    intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, PayVcodeActivity.this.lHu);
                    PayVcodeActivity.this.setResult(-1, intent);
                }
                PayVcodeActivity.this.closeActivity();
            }
        });
        this.lHt.dkE().startAnimation(loadAnimation);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            uy(false);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
