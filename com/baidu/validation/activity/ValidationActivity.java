package com.baidu.validation.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.akb;
import com.baidu.tieba.bkb;
import com.baidu.tieba.ckb;
import com.baidu.tieba.dkb;
import com.baidu.tieba.fkb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.ValidationManager;
import com.baidu.validation.js.BaseInterpreter;
import com.baidu.validation.result.LoadExternalWebViewResult;
import com.baidu.validation.result.ValidationResult;
import com.baidu.validation.result.ValidationViewSettingResult;
import com.baidu.validation.utils.ValidationLog;
import com.baidu.validation.view.ValidationLoadingView;
import com.baidu.validation.view.ValidationTimeoutView;
import com.baidu.validation.view.ValidationWebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ValidationActivity extends Activity implements View.OnClickListener, akb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValidationWebView a;
    public ValidationLoadingView b;
    public ValidationTimeoutView c;
    public FrameLayout d;
    public FrameLayout e;
    public ImageView f;
    public boolean g;
    public ValidationManager h;
    public HashMap<String, String> i;
    public ValueAnimator j;

    /* loaded from: classes9.dex */
    public class a implements ValidationTimeoutView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValidationActivity a;

        public a(ValidationActivity validationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = validationActivity;
        }

        @Override // com.baidu.validation.view.ValidationTimeoutView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.reload();
                if (this.a.c != null) {
                    this.a.c.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValidationActivity a;

        public b(ValidationActivity validationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = validationActivity;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) ? super.onJsAlert(webView, str, str2, jsResult) : invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
                ValidationLog.e(ValidationLog.TAG, str2);
                ckb a = ckb.a(str2);
                if (a == null) {
                    jsPromptResult.cancel();
                    return true;
                }
                BaseInterpreter a2 = bkb.b().a(a.b());
                if (a2 == null) {
                    jsPromptResult.cancel();
                    return true;
                }
                a2.setInterpreterCallback(this.a);
                String str4 = null;
                try {
                    str4 = a2.interpret(a);
                } catch (Throwable unused) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("msg", "native function error");
                        jSONObject.toString();
                    } catch (JSONException unused2) {
                    }
                }
                jsPromptResult.confirm(str4);
                return true;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, webView, i) == null) || this.a.b == null || this.a.a == null) {
                return;
            }
            if (i != 100) {
                if (this.a.b.getVisibility() != 0) {
                    this.a.b.setVisibility(0);
                }
                if (this.a.a.getVisibility() != 8) {
                    this.a.a.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.a.b.getVisibility() != 8) {
                this.a.b.setVisibility(8);
            }
            if (this.a.a.getVisibility() != 0) {
                this.a.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValidationActivity a;

        public c(ValidationActivity validationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = validationActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                if (this.a.c == null || this.a.a == null) {
                    return;
                }
                if (i == -8 || i == -6 || i == -2 || i == -5) {
                    if (this.a.c.getVisibility() != 0) {
                        this.a.c.setVisibility(0);
                    }
                    if (this.a.a.getVisibility() != 8) {
                        this.a.a.setVisibility(8);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ValidationActivity validationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, sslErrorHandler, sslError) == null) {
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    webView.loadUrl(str);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValidationActivity a;

        public e(ValidationActivity validationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = validationActivity;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.e.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.e.requestLayout();
            }
        }
    }

    public ValidationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.akb
    public void a(String str, Object obj) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -815617613) {
                if (str.equals("action_validation_view_setting")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != -672062347) {
                if (hashCode == 1445148890 && str.equals("action_validation_result")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("action_load_external_webview")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                ValidationManager.getInstance().mValidationCallback.onFinish((ValidationResult) obj);
                b();
            } else if (c2 != 1) {
                if (c2 != 2) {
                    return;
                }
                c(((ValidationViewSettingResult) obj).height);
            } else {
                LoadExternalWebViewResult loadExternalWebViewResult = (LoadExternalWebViewResult) obj;
                if (ValidationManager.getInstance().mValidationCallback.openFeedBack()) {
                    return;
                }
                Intent intent = new Intent(this, ExternalWebviewActivity.class);
                intent.putExtra("id", loadExternalWebViewResult.id);
                intent.putExtra("url", loadExternalWebViewResult.url);
                startActivity(intent);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            ValidationManager validationManager = this.h;
            validationManager.mValidationCallback = null;
            validationManager.mValidationDTO = null;
            finish();
            overridePendingTransition(R.anim.anim_open_validation_activity, R.anim.anim_back_validation_activity);
        }
    }

    public final void c(int i) {
        int height;
        int a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (height = this.e.getHeight()) == (a2 = dkb.a(this, i))) {
            return;
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.j.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(height, a2);
        this.j = ofInt;
        ofInt.addUpdateListener(new e(this));
        this.j.setDuration(100L);
        this.j.setInterpolator(new AccelerateInterpolator());
        this.j.start();
    }

    public final void e() {
        ValidationManager validationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (validationManager = this.h) == null || validationManager.mValidationCallback == null) {
            return;
        }
        ValidationResult validationResult = new ValidationResult();
        validationResult.errno = -204;
        validationResult.msg = ValidationResult.MSG_USER_CANCEL;
        this.h.mValidationCallback.onFinish(validationResult);
    }

    public final void g() {
        ValidationManager validationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (validationManager = this.h) == null || validationManager.mValidationDTO == null) {
            return;
        }
        this.i = new HashMap<>();
        if (!TextUtils.isEmpty(this.h.mValidationDTO.ak)) {
            this.i.put("ak", this.h.mValidationDTO.ak);
        }
        if (!TextUtils.isEmpty(this.h.mValidationDTO.type)) {
            this.i.put("type", this.h.mValidationDTO.type);
        }
        if (!TextUtils.isEmpty(this.h.mValidationDTO.scene)) {
            this.i.put("scene", this.h.mValidationDTO.scene);
        }
        HashMap<String, String> hashMap = this.h.mValidationDTO.extraParams;
        if (hashMap != null && hashMap.size() != 0) {
            this.i.putAll(this.h.mValidationDTO.extraParams);
        }
        this.i.put("timestamp", String.valueOf(System.currentTimeMillis()));
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.a(getResources().getDimension(R.dimen.validate_webview_radius), getResources().getDimension(R.dimen.validate_webview_radius), getResources().getDimension(R.dimen.validate_webview_radius), getResources().getDimension(R.dimen.validate_webview_radius));
            this.a.setLayerType(1, null);
            this.a.setWebChromeClient(new b(this));
            this.a.setWebViewClient(new c(this));
            this.a.setWebViewClient(new d(this));
            this.a.loadUrl(fkb.b(fkb.a("https://wappass.baidu.com/static/activity/pass-machine.html"), this.i));
        }
    }

    public final void j() {
        FrameLayout frameLayout;
        Resources resources;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.g) {
                frameLayout = this.e;
                resources = getResources();
                i = R.drawable.drawable_validation_bg_dark;
            } else {
                frameLayout = this.e;
                resources = getResources();
                i = R.drawable.drawable_validation_bg;
            }
            frameLayout.setBackgroundDrawable(resources.getDrawable(i));
            this.c.setDarkMode(this.g);
            this.b.setDarkMode(this.g);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e();
            b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2.getId() == R.id.validation_iv_close) {
            e();
            b();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.layout_activity_validation);
            overridePendingTransition(R.anim.anim_open_validation_activity, R.anim.anim_back_validation_activity);
            this.h = ValidationManager.getInstance();
            g();
            this.d = (FrameLayout) findViewById(R.id.validation_root_view);
            this.e = (FrameLayout) findViewById(R.id.validation_fl_content);
            this.a = (ValidationWebView) findViewById(R.id.validation_webview);
            this.b = (ValidationLoadingView) findViewById(R.id.validation_loading_view);
            this.c = (ValidationTimeoutView) findViewById(R.id.validation_timeout_view);
            this.f = (ImageView) findViewById(R.id.validation_iv_close);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            j();
            this.c.setOnRetryClickListener(new a(this));
            i();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
        }
    }
}
