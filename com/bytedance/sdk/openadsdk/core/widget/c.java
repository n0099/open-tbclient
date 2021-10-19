package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SSWebView f67664a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67665b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67666c;

    /* renamed from: d  reason: collision with root package name */
    public String f67667d;

    /* renamed from: e  reason: collision with root package name */
    public a f67668e;

    /* renamed from: f  reason: collision with root package name */
    public String f67669f;

    /* loaded from: classes9.dex */
    public interface a {
        void a(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String str) {
        super(context, t.g(context, "tt_dialog_full"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67665b = context;
        this.f67669f = str;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (TextUtils.isEmpty(this.f67669f)) {
                this.f67667d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.core.e.c b2 = com.bytedance.sdk.openadsdk.core.b.b(new JSONObject(this.f67669f));
                if (b2 != null) {
                    String d2 = b2.d();
                    this.f67667d = d2;
                    if (TextUtils.isEmpty(d2)) {
                        this.f67667d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f67668e) == null) {
            return;
        }
        aVar.a(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(this.f67665b, "tt_app_privacy_dialog"));
            b();
            a();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f67664a = (SSWebView) findViewById(t.e(this.f67665b, "tt_privacy_webview"));
            TextView textView = (TextView) findViewById(t.e(this.f67665b, "tt_app_privacy_back_tv"));
            this.f67666c = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f67670a;

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
                    this.f67670a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67670a.f67668e == null) {
                        return;
                    }
                    this.f67670a.f67668e.a(this.f67670a);
                }
            });
            this.f67664a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.f67665b, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f67671a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r10, r11, r12);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r10, r11, r12};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67671a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, str)) == null) {
                        if (webView != null) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    return true;
                                }
                                String scheme = Uri.parse(str).getScheme();
                                if (TextUtils.isEmpty(scheme)) {
                                    return true;
                                }
                                String lowerCase = scheme.toLowerCase();
                                if (lowerCase.contains("http") || lowerCase.contains("https")) {
                                    webView.loadUrl(str);
                                    return true;
                                }
                                return true;
                            } catch (Exception unused) {
                                return true;
                            }
                        }
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.f67664a.getSettings().setJavaScriptEnabled(true);
            this.f67664a.getSettings().setDisplayZoomControls(false);
            this.f67664a.getSettings().setCacheMode(2);
            this.f67664a.loadUrl(this.f67667d);
        }
    }

    public c a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.f67668e = aVar;
            return this;
        }
        return (c) invokeL.objValue;
    }
}
