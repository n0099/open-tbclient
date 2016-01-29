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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
import com.baidu.tieba.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    private a cGN;
    private b cGO;
    private String cGP;
    private String cGQ;
    private String cGR;
    private String cGS;
    private String cGT;
    private boolean cGU;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private com.baidu.tieba.tbadkCore.e.c jsCallback;
    private Handler mHandler;
    private String mUrl;
    private String mVcodeUrl;
    private boolean bBF = false;
    private HttpMessageListener cGV = new HttpMessageListener(CmdConfigHttp.CMD_PAY_NEW_VCODE) { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayVcodeActivity.this.cGO.dB(false);
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
                if (!responsePayNewVcodeInfoMessage.hasError()) {
                    PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                    if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                        PayVcodeActivity.this.cGP = payNewVcodeInfoData.getCaptcha_vcode_str();
                        PayVcodeActivity.this.mVcodeUrl = payNewVcodeInfoData.getVcode_pic_url();
                        PayVcodeActivity.this.cGQ = payNewVcodeInfoData.getCaptcha_code_type();
                        PayVcodeActivity.this.anT();
                        return;
                    }
                    String errorString = responsePayNewVcodeInfoMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = PayVcodeActivity.this.getResources().getString(t.j.payment_vcode_get_error);
                    }
                    PayVcodeActivity.this.showToast(errorString);
                    return;
                }
                PayVcodeActivity.this.showToast(t.j.neterror);
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
        this.jsBridge.a(new com.baidu.tieba.tbadkCore.e.b() { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
            @Override // com.baidu.tieba.tbadkCore.e.b
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if ("VcodeJsInterface".equalsIgnoreCase(str)) {
                    if ("jsCancelVcode".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm();
                        PayVcodeActivity.this.closeActivity();
                        return true;
                    } else if ("jsChangeVcode".equalsIgnoreCase(str2)) {
                        try {
                            String string = new JSONObject(str3).getString("callback");
                            if (!StringUtils.isNull(string)) {
                                PayVcodeActivity.this.cGS = string;
                                PayVcodeActivity.this.mHandler.removeMessages(1);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(1));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else if ("jsGetSkinType".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(String.valueOf(TbadkCoreApplication.m411getInst().getSkinType()));
                        return true;
                    } else if ("jsGetVcodeImageUrl".equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(PayVcodeActivity.this.mVcodeUrl);
                        return true;
                    } else if ("jsSetLoadVcodeFinished".equalsIgnoreCase(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            PayVcodeActivity.this.cGU = jSONObject.optBoolean("canpost");
                            PayVcodeActivity.this.cGT = jSONObject.optString("callback");
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
                            String optString2 = jSONObject2.optString("callback");
                            if (!optBoolean) {
                                PayVcodeActivity.this.mHandler.removeMessages(2);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(2));
                            } else if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                                PayVcodeActivity.this.cGR = optString;
                                PayVcodeActivity.this.cGS = optString2;
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
        this.jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
            @Override // com.baidu.tieba.tbadkCore.e.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (PayVcodeActivity.this.jsBridge != null) {
                    return PayVcodeActivity.this.jsBridge.a(str, jsPromptResult);
                }
                return false;
            }
        };
        initData(bundle);
        qD();
        CQ();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.bBF) {
            Vv();
        }
    }

    private void initData(Bundle bundle) {
        this.mUrl = UtilHelper.appendCuidParam(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion());
        this.cGP = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
        this.mVcodeUrl = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
        this.cGN = new a(getPageContext());
        this.mHandler = new Handler() { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        PayVcodeActivity.this.anV();
                        return;
                    case 2:
                        PayVcodeActivity.this.showToast(t.j.payment_vcode_error);
                        return;
                    case 3:
                        PayVcodeActivity.this.anW();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void CQ() {
        this.cGN.anY();
        registerListener(this.cGV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anS() {
        this.cGO.dB(true);
        this.cGO.getWebView().loadUrl(this.mUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        if (!StringUtils.isNull(this.cGS)) {
            this.cGO.getWebView().loadUrl("javascript:" + this.cGS + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anU() {
        if (!StringUtils.isNull(this.cGT) && this.cGU) {
            this.cGO.getWebView().loadUrl("javascript:" + this.cGT + "()");
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
            this.jsBridge.JG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cGO.onChangeSkinType(i);
    }

    private void qD() {
        this.cGO = new b(this);
        this.cGO.anZ().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.anU();
            }
        });
        this.cGO.aoa().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PayVcodeActivity.this.cGU) {
                    PayVcodeActivity.this.cGO.dB(true);
                    PayVcodeActivity.this.cGO.getWebView().stopLoading();
                    PayVcodeActivity.this.cGO.getWebView().loadUrl(PayVcodeActivity.this.mUrl);
                }
            }
        });
        c cVar = new c(this);
        cVar.setOnJsPromptCallback(this.jsCallback);
        this.cGO.getWebView().setWebChromeClient(cVar);
        this.cGO.getWebView().setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PayVcodeActivity.this.cGO.dB(false);
                PayVcodeActivity.this.cGO.eX(PayVcodeActivity.this.cGU ? false : true);
            }
        });
        this.cGO.aob().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.eW(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anV() {
        this.cGO.dB(true);
        this.cGN.anX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        eW(true);
    }

    public void Vv() {
        this.cGO.aob().setBackgroundColor(ar.getColor(t.d.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.cGO.aob().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.bottom_fold_up);
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
                PayVcodeActivity.this.anS();
            }
        });
        this.cGO.aoc().startAnimation(loadAnimation);
        this.bBF = true;
    }

    public void eW(final boolean z) {
        this.cGO.aob().setBackgroundColor(ar.getColor(t.d.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.cGO.aob().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), t.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.10
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z && !StringUtils.isNull(PayVcodeActivity.this.cGR)) {
                    Intent intent = new Intent();
                    intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, PayVcodeActivity.this.cGR);
                    intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, PayVcodeActivity.this.cGP);
                    PayVcodeActivity.this.setResult(-1, intent);
                }
                PayVcodeActivity.this.closeActivity();
            }
        });
        this.cGO.aoc().startAnimation(loadAnimation);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            eW(false);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
