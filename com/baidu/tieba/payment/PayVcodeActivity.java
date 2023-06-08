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
import com.baidu.tieba.h29;
import com.baidu.tieba.i29;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.message.ResponsePayNewVcodeInfoMessage;
import com.baidu.tieba.wy9;
import com.baidu.tieba.xy9;
import com.baidu.tieba.yy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PayVcodeActivity extends BaseActivity<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeModel a;
    public h29 b;
    public String c;
    public String d;
    public String e;
    public String f;
    public Handler g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public boolean l;
    public wy9 m;
    public yy9 n;
    public HttpMessageListener o;

    public PayVcodeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.o = new HttpMessageListener(this, CmdConfigHttp.CMD_PAY_NEW_VCODE) { // from class: com.baidu.tieba.payment.PayVcodeActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PayVcodeActivity a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) {
                    this.a.b.D(false);
                    if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePayNewVcodeInfoMessage)) {
                        ResponsePayNewVcodeInfoMessage responsePayNewVcodeInfoMessage = (ResponsePayNewVcodeInfoMessage) httpResponsedMessage;
                        if (!responsePayNewVcodeInfoMessage.hasError()) {
                            PayVcodeInfoData payNewVcodeInfoData = responsePayNewVcodeInfoMessage.getPayNewVcodeInfoData();
                            if (responsePayNewVcodeInfoMessage.getError() == 0 && payNewVcodeInfoData != null) {
                                this.a.d = payNewVcodeInfoData.getCaptcha_vcode_str();
                                this.a.e = payNewVcodeInfoData.getVcode_pic_url();
                                this.a.f = payNewVcodeInfoData.getCaptcha_code_type();
                                this.a.W1();
                                return;
                            }
                            String errorString = responsePayNewVcodeInfoMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f70);
                            }
                            this.a.showToast(errorString);
                            return;
                        }
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0def);
                    }
                }
            }
        };
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.D(true);
            this.a.V();
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Z1(true);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.D(true);
            this.b.A().loadUrl(this.c);
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.U();
            registerListener(this.o);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.g.removeMessages(1);
            this.g.removeMessages(2);
            this.g.removeMessages(3);
            wy9 wy9Var = this.m;
            if (wy9Var != null) {
                wy9Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            if (i == 4) {
                Z1(false);
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z && !this.i) {
                e2();
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !StringUtils.isNull(this.j)) {
            BaseWebView A = this.b.A();
            A.loadUrl("javascript:" + this.j + "()");
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !StringUtils.isNull(this.k) && this.l) {
            BaseWebView A = this.b.A();
            A.loadUrl("javascript:" + this.k + "()");
        }
    }

    public void Z1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b.u().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.b.u().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this, z) { // from class: com.baidu.tieba.payment.PayVcodeActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ PayVcodeActivity b;

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

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = z;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        if (this.a && !StringUtils.isNull(this.b.h)) {
                            Intent intent = new Intent();
                            intent.putExtra(PayVcodeActivityConfig.VCODE_RESULT, this.b.h);
                            intent.putExtra(PayVcodeActivityConfig.VCODE_MD5, this.b.d);
                            this.b.setResult(-1, intent);
                        }
                        this.b.closeActivity();
                    }
                }
            });
            this.b.z().startAnimation(loadAnimation);
        }
    }

    public final void a2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            this.c = UtilHelper.appendCuidParam(TbConfig.SERVER_ADDRESS + "mo/q/captcha?version=" + TbConfig.getVersion());
            this.d = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_MD5);
            this.e = getIntent().getStringExtra(PayVcodeActivityConfig.VCODE_URL);
            this.a = new PayVcodeModel(getPageContext());
            this.g = new Handler(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        int i = message.what;
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return;
                                }
                                this.a.X1();
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0f6f);
                            return;
                        }
                        this.a.V1();
                    }
                }
            };
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h29 h29Var = new h29(this);
            this.b = h29Var;
            h29Var.y().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.a.Y1();
                }
            });
            this.b.x().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && !this.a.l) {
                        this.a.b.D(true);
                        this.a.b.A().stopLoading();
                        this.a.b.A().loadUrl(this.a.c);
                    }
                }
            });
            i29 i29Var = new i29(this);
            i29Var.a(this.n);
            this.b.A().setWebChromeClient(i29Var);
            this.b.A().setWebViewClient(new WebViewClient(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        this.a.b.D(false);
                        this.a.b.C(!this.a.l);
                    }
                }
            });
            this.b.u().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.Z1(false);
                    }
                }
            });
        }
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.u().setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.b.u().startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

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

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, animation) != null) {
                        return;
                    }
                    this.a.c2();
                }
            });
            this.b.z().startAnimation(loadAnimation);
            this.i = true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            wy9 wy9Var = new wy9();
            this.m = wy9Var;
            wy9Var.a(new xy9(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.2
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.xy9
                public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
                        if ("VcodeJsInterface".equalsIgnoreCase(str)) {
                            if ("jsCancelVcode".equalsIgnoreCase(str2)) {
                                jsPromptResult.confirm();
                                this.this$0.closeActivity();
                                return true;
                            } else if ("jsChangeVcode".equalsIgnoreCase(str2)) {
                                try {
                                    String string = new JSONObject(str3).getString(WebChromeClient.KEY_ARG_CALLBACK);
                                    if (!StringUtils.isNull(string)) {
                                        this.this$0.j = string;
                                        this.this$0.g.removeMessages(1);
                                        this.this$0.g.sendMessage(this.this$0.g.obtainMessage(1));
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
                                jsPromptResult.confirm(this.this$0.e);
                                return true;
                            } else if ("jsSetLoadVcodeFinished".equalsIgnoreCase(str2)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str3);
                                    this.this$0.l = jSONObject.optBoolean("canpost");
                                    this.this$0.k = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
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
                                    String optString2 = jSONObject2.optString(WebChromeClient.KEY_ARG_CALLBACK);
                                    if (!optBoolean) {
                                        this.this$0.g.removeMessages(2);
                                        this.this$0.g.sendMessage(this.this$0.g.obtainMessage(2));
                                    } else if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2)) {
                                        this.this$0.h = optString;
                                        this.this$0.j = optString2;
                                        this.this$0.g.removeMessages(3);
                                        this.this$0.g.sendMessage(this.this$0.g.obtainMessage(3));
                                    }
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
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
            this.n = new yy9(this) { // from class: com.baidu.tieba.payment.PayVcodeActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayVcodeActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.tieba.yy9
                public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, jsPromptResult)) == null) {
                        if (this.a.m != null) {
                            return this.a.m.c(this.a.b.A(), str, jsPromptResult);
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            };
            a2(bundle);
            b2();
            d2();
        }
    }
}
