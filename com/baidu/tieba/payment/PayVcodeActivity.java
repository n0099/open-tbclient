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
import androidx.core.view.InputDeviceCompat;
import b.a.r0.j2.b;
import b.a.r0.m3.n0.a;
import b.a.r0.m3.n0.c;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public a jsBridge;
    public c jsCallback;
    public Handler mHandler;
    public boolean mHasShowAnim;
    public PayVcodeModel mModel;
    public HttpMessageListener mNewVcodeInfoListener;
    public String mUrl;
    public String mVcodeChangeCallBack;
    public String mVcodeInputCallback;
    public boolean mVcodeLoadSuccess;
    public String mVcodeMd5;
    public String mVcodeResult;
    public String mVcodeType;
    public String mVcodeUrl;
    public b.a.r0.j2.a mView;

    public PayVcodeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHasShowAnim = false;
        this.mNewVcodeInfoListener = new HttpMessageListener(this, CmdConfigHttp.CMD_PAY_NEW_VCODE) { // from class: com.baidu.tieba.payment.PayVcodeActivity.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PayVcodeActivity f52974a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f52974a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) {
                    this.f52974a.mView.j(false);
                    if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                        return;
                    }
                    ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
                    if (!responsePayNewVcodeInfoMessage.hasError()) {
                        PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                        if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                            this.f52974a.mVcodeMd5 = payNewVcodeInfoData.getCaptcha_vcode_str();
                            this.f52974a.mVcodeUrl = payNewVcodeInfoData.getVcode_pic_url();
                            this.f52974a.mVcodeType = payNewVcodeInfoData.getCaptcha_code_type();
                            this.f52974a.changeWebViewVcode();
                            return;
                        }
                        String errorString = responsePayNewVcodeInfoMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = this.f52974a.getResources().getString(R.string.payment_vcode_get_error);
                        }
                        this.f52974a.showToast(errorString);
                        return;
                    }
                    this.f52974a.showToast(R.string.neterror);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeVcode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.mView.j(true);
            this.mModel.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeWebViewVcode() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || StringUtils.isNull(this.mVcodeChangeCallBack)) {
            return;
        }
        BaseWebView g2 = this.mView.g();
        g2.loadUrl("javascript:" + this.mVcodeChangeCallBack + "()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            hideAnimation(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInputVcode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && !StringUtils.isNull(this.mVcodeInputCallback) && this.mVcodeLoadSuccess) {
            BaseWebView g2 = this.mView.g();
            g2.loadUrl("javascript:" + this.mVcodeInputCallback + "()");
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, bundle) == null) {
            this.mUrl = UtilHelper.appendCuidParam(TbConfig.SERVER_ADDRESS + "mo/q/captcha?version=" + TbConfig.getVersion());
            this.mVcodeMd5 = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
            this.mVcodeUrl = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
            this.mModel = new PayVcodeModel(getPageContext());
            this.mHandler = new Handler(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52976a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52976a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        int i2 = message.what;
                        if (i2 == 1) {
                            this.f52976a.changeVcode();
                        } else if (i2 == 2) {
                            this.f52976a.showToast(R.string.payment_vcode_error);
                        } else if (i2 != 3) {
                        } else {
                            this.f52976a.doNext();
                        }
                    }
                }
            };
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            b.a.r0.j2.a aVar = new b.a.r0.j2.a(this);
            this.mView = aVar;
            aVar.e().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52977e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52977e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f52977e.getInputVcode();
                    }
                }
            });
            this.mView.d().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52978e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52978e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f52978e.mVcodeLoadSuccess) {
                        return;
                    }
                    this.f52978e.mView.j(true);
                    this.f52978e.mView.g().stopLoading();
                    this.f52978e.mView.g().loadUrl(this.f52978e.mUrl);
                }
            });
            b bVar = new b(this);
            bVar.a(this.jsCallback);
            this.mView.g().setWebChromeClient(bVar);
            this.mView.g().setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52979a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52979a = this;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        this.f52979a.mView.j(false);
                        this.f52979a.mView.i(!this.f52979a.mVcodeLoadSuccess);
                    }
                }
            });
            this.mView.c().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52980e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52980e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f52980e.hideAnimation(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            this.mView.j(true);
            this.mView.g().loadUrl(this.mUrl);
        }
    }

    private void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mModel.w();
            registerListener(this.mNewVcodeInfoListener);
        }
    }

    public void addJsPromptInterface(b.a.r0.m3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.jsBridge.a(bVar);
    }

    public void hideAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mView.c().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.mView.c().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this, z) { // from class: com.baidu.tieba.payment.PayVcodeActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f52982a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52983b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52983b = this;
                    this.f52982a = z;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        if (this.f52982a && !StringUtils.isNull(this.f52983b.mVcodeResult)) {
                            Intent intent = new Intent();
                            intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, this.f52983b.mVcodeResult);
                            intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, this.f52983b.mVcodeMd5);
                            this.f52983b.setResult(-1, intent);
                        }
                        this.f52983b.closeActivity();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
            this.mView.f().startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            a aVar = new a();
            this.jsBridge = aVar;
            aVar.a(new b.a.r0.m3.n0.b(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // b.a.r0.m3.n0.b
                public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                        if (PayVcodeActivity.VCODE_JS_INTERFACE.equalsIgnoreCase(str)) {
                            if (PayVcodeActivity.JS_CANCEL_VCODE.equalsIgnoreCase(str2)) {
                                jsPromptResult.confirm();
                                this.this$0.closeActivity();
                                return true;
                            } else if (PayVcodeActivity.JS_CHANGE_VCODE.equalsIgnoreCase(str2)) {
                                try {
                                    String string = new JSONObject(str3).getString("callback");
                                    if (!StringUtils.isNull(string)) {
                                        this.this$0.mVcodeChangeCallBack = string;
                                        this.this$0.mHandler.removeMessages(1);
                                        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(1));
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
                                jsPromptResult.confirm(this.this$0.mVcodeUrl);
                                return true;
                            } else if (PayVcodeActivity.JS_SET_LOAD_VCODE_FINISHED.equalsIgnoreCase(str2)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str3);
                                    this.this$0.mVcodeLoadSuccess = jSONObject.optBoolean("canpost");
                                    this.this$0.mVcodeInputCallback = jSONObject.optString("callback");
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
                                        this.this$0.mHandler.removeMessages(2);
                                        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(2));
                                    } else if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                                        this.this$0.mVcodeResult = optString;
                                        this.this$0.mVcodeChangeCallBack = optString2;
                                        this.this$0.mHandler.removeMessages(3);
                                        this.this$0.mHandler.sendMessage(this.this$0.mHandler.obtainMessage(3));
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
                    return invokeLLLL.booleanValue;
                }
            });
            this.jsCallback = new c(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52975a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52975a = this;
                }

                @Override // b.a.r0.m3.n0.c
                public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                        if (this.f52975a.jsBridge != null) {
                            return this.f52975a.jsBridge.b(this.f52975a.mView.g(), str, jsPromptResult);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            };
            initData(bundle);
            initUI();
            register();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            a aVar = this.jsBridge;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                hideAnimation(false);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.mHasShowAnim) {
                return;
            }
            showAnimation();
        }
    }

    public void removePromptInterface(b.a.r0.m3.n0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null) {
            return;
        }
        this.jsBridge.g(bVar);
    }

    public void showAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mView.c().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.mView.c().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayVcodeActivity f52981a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52981a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f52981a.loadWebView();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
            this.mView.f().startAnimation(loadAnimation);
            this.mHasShowAnim = true;
        }
    }
}
