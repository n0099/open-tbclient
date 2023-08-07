package com.baidu.validation.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.tieba.R;
import com.baidu.tieba.abb;
import com.baidu.tieba.bbb;
import com.baidu.tieba.cbb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.validation.js.BaseInterpreter;
import com.baidu.validation.utils.ValidationLog;
import com.baidu.validation.view.ValidationLoadingView;
import com.baidu.validation.view.ValidationTimeoutView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ExternalWebviewActivity extends Activity implements abb, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView a;
    public ValidationLoadingView b;
    public ValidationTimeoutView c;
    public TextView d;
    public ImageView e;
    public String f;
    public String g;
    public ValueCallback<Uri> h;
    public ValueCallback<Uri[]> i;

    /* loaded from: classes9.dex */
    public class a extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExternalWebviewActivity a;

        public a(ExternalWebviewActivity externalWebviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {externalWebviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = externalWebviewActivity;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) {
                Toast.makeText(this.a, str2, 1).show();
                return super.onJsAlert(webView, str, str2, jsResult);
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
                ValidationLog.e(ValidationLog.TAG, str2);
                cbb a = cbb.a(str2);
                if (a == null) {
                    jsPromptResult.cancel();
                    return true;
                }
                BaseInterpreter a2 = bbb.b().a(a.b());
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

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, valueCallback, fileChooserParams)) == null) {
                this.a.c(valueCallback);
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExternalWebviewActivity a;

        public b(ExternalWebviewActivity externalWebviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {externalWebviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = externalWebviewActivity;
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
    public class c extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExternalWebviewActivity a;

        public c(ExternalWebviewActivity externalWebviewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {externalWebviewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = externalWebviewActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                if (this.a.a != null) {
                    this.a.a.getSettings().setBlockNetworkLoads(false);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, sslErrorHandler, sslError) == null) {
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    webView.loadUrl(str);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public ExternalWebviewActivity() {
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

    @Override // com.baidu.tieba.abb
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            finish();
        }
    }

    public final void c(ValueCallback<Uri[]> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, valueCallback) == null) {
            this.i = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INTENT", intent);
            intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
            startActivityForResult(intent2, 1011);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setWebChromeClient(new a(this));
            this.a.setWebViewClient(new b(this));
            this.a.setWebViewClient(new c(this));
            this.a.loadUrl(this.g);
            this.a.setFocusable(true);
            this.a.setDrawingCacheEnabled(true);
            WebSettings settings = this.a.getSettings();
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT < 19) {
                this.a.removeJavascriptInterface("searchBoxJavaBridge_");
                this.a.removeJavascriptInterface("accessibility");
                this.a.removeJavascriptInterface("accessibilityTraversal");
            }
            settings.setDomStorageEnabled(true);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1010) {
                if (this.h == null) {
                    return;
                }
                this.h.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.h = null;
            } else if (i == 1011 && this.i != null) {
                Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data != null) {
                    this.i.onReceiveValue(new Uri[]{data});
                } else {
                    this.i.onReceiveValue(new Uri[0]);
                }
                this.i = null;
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f092565) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.layout_activity_external_webview);
            this.f = getIntent().getStringExtra("id");
            this.g = getIntent().getStringExtra("url");
            this.a = (WebView) findViewById(R.id.validation_webview);
            this.b = (ValidationLoadingView) findViewById(R.id.validation_loading_view);
            this.c = (ValidationTimeoutView) findViewById(R.id.validation_timeout_view);
            this.d = (TextView) findViewById(R.id.tv_title);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f092565);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f092581);
            h();
            this.d.setText(com.baidu.validation.a.a.a(this.f));
            this.e.setOnClickListener(this);
            f();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
        }
    }
}
