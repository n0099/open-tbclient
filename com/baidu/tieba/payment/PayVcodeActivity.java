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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
import d.b.i0.c2.b;
import d.b.i0.d3.l0.a;
import d.b.i0.d3.l0.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    public static final String JS_CANCEL_VCODE = "jsCancelVcode";
    public static final String JS_CHANGE_VCODE = "jsChangeVcode";
    public static final String JS_GET_SKIN_TYPE = "jsGetSkinType";
    public static final String JS_GET_VCODE_IMAGEURL = "jsGetVcodeImageUrl";
    public static final String JS_SET_LOAD_VCODE_FINISHED = "jsSetLoadVcodeFinished";
    public static final String JS_SET_VCODE_INPUT_RESULT = "jsSetVcodeInputResult";
    public static final int MSG_ERROR = 2;
    public static final int MSG_SUCCESS = 3;
    public static final int MSG_VCODE_CHANGE = 1;
    public static final String VCODE_JS_INTERFACE = "VcodeJsInterface";
    public a jsBridge;
    public c jsCallback;
    public Handler mHandler;
    public PayVcodeModel mModel;
    public String mUrl;
    public String mVcodeChangeCallBack;
    public String mVcodeInputCallback;
    public boolean mVcodeLoadSuccess;
    public String mVcodeMd5;
    public String mVcodeResult;
    public String mVcodeType;
    public String mVcodeUrl;
    public d.b.i0.c2.a mView;
    public boolean mHasShowAnim = false;
    public HttpMessageListener mNewVcodeInfoListener = new HttpMessageListener(CmdConfigHttp.CMD_PAY_NEW_VCODE) { // from class: com.baidu.tieba.payment.PayVcodeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayVcodeActivity.this.mView.m(false);
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                return;
            }
            ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
            if (!responsePayNewVcodeInfoMessage.hasError()) {
                PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                    PayVcodeActivity.this.mVcodeMd5 = payNewVcodeInfoData.getCaptcha_vcode_str();
                    PayVcodeActivity.this.mVcodeUrl = payNewVcodeInfoData.getVcode_pic_url();
                    PayVcodeActivity.this.mVcodeType = payNewVcodeInfoData.getCaptcha_code_type();
                    PayVcodeActivity.this.changeWebViewVcode();
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
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVcode() {
        this.mView.m(true);
        this.mModel.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeWebViewVcode() {
        if (StringUtils.isNull(this.mVcodeChangeCallBack)) {
            return;
        }
        BaseWebView i = this.mView.i();
        i.loadUrl("javascript:" + this.mVcodeChangeCallBack + "()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNext() {
        hideAnimation(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInputVcode() {
        if (StringUtils.isNull(this.mVcodeInputCallback) || !this.mVcodeLoadSuccess) {
            return;
        }
        BaseWebView i = this.mView.i();
        i.loadUrl("javascript:" + this.mVcodeInputCallback + "()");
    }

    private void initData(Bundle bundle) {
        this.mUrl = UtilHelper.appendCuidParam(TbConfig.SERVER_ADDRESS + "mo/q/captcha?version=" + TbConfig.getVersion());
        this.mVcodeMd5 = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
        this.mVcodeUrl = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
        this.mModel = new PayVcodeModel(getPageContext());
        this.mHandler = new Handler() { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    PayVcodeActivity.this.changeVcode();
                } else if (i == 2) {
                    PayVcodeActivity.this.showToast(R.string.payment_vcode_error);
                } else if (i != 3) {
                } else {
                    PayVcodeActivity.this.doNext();
                }
            }
        };
    }

    private void initUI() {
        d.b.i0.c2.a aVar = new d.b.i0.c2.a(this);
        this.mView = aVar;
        aVar.f().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.getInputVcode();
            }
        });
        this.mView.e().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PayVcodeActivity.this.mVcodeLoadSuccess) {
                    return;
                }
                PayVcodeActivity.this.mView.m(true);
                PayVcodeActivity.this.mView.i().stopLoading();
                PayVcodeActivity.this.mView.i().loadUrl(PayVcodeActivity.this.mUrl);
            }
        });
        b bVar = new b(this);
        bVar.a(this.jsCallback);
        this.mView.i().setWebChromeClient(bVar);
        this.mView.i().setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                PayVcodeActivity.this.mView.m(false);
                PayVcodeActivity.this.mView.l(!PayVcodeActivity.this.mVcodeLoadSuccess);
            }
        });
        this.mView.d().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayVcodeActivity.this.hideAnimation(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWebView() {
        this.mView.m(true);
        this.mView.i().loadUrl(this.mUrl);
    }

    private void register() {
        this.mModel.s();
        registerListener(this.mNewVcodeInfoListener);
    }

    public void addJsPromptInterface(d.b.i0.d3.l0.b bVar) {
        if (bVar != null) {
            this.jsBridge.a(bVar);
        }
    }

    public void hideAnimation(final boolean z) {
        this.mView.d().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.mView.d().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z && !StringUtils.isNull(PayVcodeActivity.this.mVcodeResult)) {
                    Intent intent = new Intent();
                    intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, PayVcodeActivity.this.mVcodeResult);
                    intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, PayVcodeActivity.this.mVcodeMd5);
                    PayVcodeActivity.this.setResult(-1, intent);
                }
                PayVcodeActivity.this.closeActivity();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.mView.h().startAnimation(loadAnimation);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mView.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        a aVar = new a();
        this.jsBridge = aVar;
        aVar.a(new d.b.i0.d3.l0.b() { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
            @Override // d.b.i0.d3.l0.b
            public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (PayVcodeActivity.VCODE_JS_INTERFACE.equalsIgnoreCase(str)) {
                    if (PayVcodeActivity.JS_CANCEL_VCODE.equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm();
                        PayVcodeActivity.this.closeActivity();
                        return true;
                    } else if (PayVcodeActivity.JS_CHANGE_VCODE.equalsIgnoreCase(str2)) {
                        try {
                            String string = new JSONObject(str3).getString("callback");
                            if (!StringUtils.isNull(string)) {
                                PayVcodeActivity.this.mVcodeChangeCallBack = string;
                                PayVcodeActivity.this.mHandler.removeMessages(1);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(1));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else if (PayVcodeActivity.JS_GET_SKIN_TYPE.equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(String.valueOf(TbadkCoreApplication.getInst().getSkinType()));
                        return true;
                    } else if (PayVcodeActivity.JS_GET_VCODE_IMAGEURL.equalsIgnoreCase(str2)) {
                        jsPromptResult.confirm(PayVcodeActivity.this.mVcodeUrl);
                        return true;
                    } else if (PayVcodeActivity.JS_SET_LOAD_VCODE_FINISHED.equalsIgnoreCase(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            PayVcodeActivity.this.mVcodeLoadSuccess = jSONObject.optBoolean("canpost");
                            PayVcodeActivity.this.mVcodeInputCallback = jSONObject.optString("callback");
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    } else if (PayVcodeActivity.JS_SET_VCODE_INPUT_RESULT.equalsIgnoreCase(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            boolean optBoolean = jSONObject2.optBoolean("canpost");
                            String optString = jSONObject2.optString("val");
                            String optString2 = jSONObject2.optString("callback");
                            if (!optBoolean) {
                                PayVcodeActivity.this.mHandler.removeMessages(2);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(2));
                            } else if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                                PayVcodeActivity.this.mVcodeResult = optString;
                                PayVcodeActivity.this.mVcodeChangeCallBack = optString2;
                                PayVcodeActivity.this.mHandler.removeMessages(3);
                                PayVcodeActivity.this.mHandler.sendMessage(PayVcodeActivity.this.mHandler.obtainMessage(3));
                            }
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        jsPromptResult.confirm();
                        return true;
                    }
                }
                return false;
            }
        });
        this.jsCallback = new c() { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
            @Override // d.b.i0.d3.l0.c
            public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                if (PayVcodeActivity.this.jsBridge != null) {
                    return PayVcodeActivity.this.jsBridge.b(PayVcodeActivity.this.mView.i(), str, jsPromptResult);
                }
                return false;
            }
        };
        initData(bundle);
        initUI();
        register();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        a aVar = this.jsBridge;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            hideAnimation(false);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.mHasShowAnim) {
            return;
        }
        showAnimation();
    }

    public void removePromptInterface(d.b.i0.d3.l0.b bVar) {
        if (bVar != null) {
            this.jsBridge.g(bVar);
        }
    }

    public void showAnimation() {
        this.mView.d().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.mView.d().startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.payment.PayVcodeActivity.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PayVcodeActivity.this.loadWebView();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.mView.h().startAnimation(loadAnimation);
        this.mHasShowAnim = true;
    }
}
