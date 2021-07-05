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
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SSWebView f30713a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30714b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30715c;

    /* renamed from: d  reason: collision with root package name */
    public String f30716d;

    /* renamed from: e  reason: collision with root package name */
    public a f30717e;

    /* renamed from: f  reason: collision with root package name */
    public String f30718f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Dialog dialog);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String str) {
        super(context, r.g(context, "tt_dialog_full"));
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
        this.f30714b = context;
        this.f30718f = str;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (TextUtils.isEmpty(this.f30718f)) {
                this.f30716d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                return;
            }
            try {
                com.bytedance.sdk.openadsdk.core.e.c b2 = com.bytedance.sdk.openadsdk.core.b.b(new JSONObject(this.f30718f));
                if (b2 != null) {
                    String d2 = b2.d();
                    this.f30716d = d2;
                    if (TextUtils.isEmpty(d2)) {
                        this.f30716d = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f30717e) == null) {
            return;
        }
        aVar.a(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(r.f(this.f30714b, "tt_app_privacy_dialog"));
            b();
            a();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f30713a = (SSWebView) findViewById(r.e(this.f30714b, "tt_privacy_webview"));
            TextView textView = (TextView) findViewById(r.e(this.f30714b, "tt_app_privacy_back_tv"));
            this.f30715c = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f30719a;

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
                    this.f30719a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f30719a.f30717e == null) {
                        return;
                    }
                    this.f30719a.f30717e.a(this.f30719a);
                }
            });
            this.f30713a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this, this.f30714b, null, null) { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f30720a;

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
                    this.f30720a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
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
            this.f30713a.getSettings().setJavaScriptEnabled(true);
            this.f30713a.getSettings().setDisplayZoomControls(false);
            this.f30713a.getSettings().setCacheMode(2);
            this.f30713a.loadUrl(this.f30716d);
        }
    }

    public c a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            this.f30717e = aVar;
            return this;
        }
        return (c) invokeL.objValue;
    }
}
