package com.bytedance.sdk.openadsdk.component.reward.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.e.q;
import com.bytedance.sdk.openadsdk.i.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        super(activity, mVar, str, i2, i3, i4, f2, z, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {activity, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Float) objArr2[6]).floatValue(), ((Boolean) objArr2[7]).booleanValue(), (String) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Activity activity2 = this.f66077a;
        this.f66082f = (SSWebView) activity2.findViewById(t.e(activity2, "tt_reward_browser_webview"));
        a();
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.t = this.f66078b.V() != null ? this.f66078b.V().j() : null;
            float aJ = this.f66078b.aJ();
            if (TextUtils.isEmpty(this.t)) {
                return;
            }
            if (this.n == 1) {
                if (this.t.contains("?")) {
                    this.t += "&orientation=portrait";
                } else {
                    this.t += "?orientation=portrait";
                }
            }
            if (this.t.contains("?")) {
                this.t += "&height=" + this.p + "&width=" + this.o + "&aspect_ratio=" + aJ;
                return;
            }
            this.t += "?height=" + this.p + "&width=" + this.o + "&aspect_ratio=" + aJ;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.d(z);
            a(true);
            c(true);
            a(false, true);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.t;
            if (str == null) {
                return false;
            }
            try {
                return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void v() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (sSWebView = this.f66082f) == null) {
            return;
        }
        sSWebView.loadUrl(this.t);
    }

    public void a(boolean z, Map<String, Object> map, View view, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), map, view, eVar}) == null) {
            this.f66084h = new q(2, this.f66079c, this.f66078b);
            j b2 = new j(this.f66077a, this.f66078b, this.f66082f).b(true);
            this.f66085i = b2;
            b2.a(u() ? "landingpage_endcard" : z ? "reward_endcard" : "fullscreen_endcard");
            this.f66085i.a(true);
            w wVar = new w(this.f66077a);
            this.f66083g = wVar;
            wVar.b(this.f66082f).a(this.f66078b).b(this.f66078b.ak()).c(this.f66078b.ao()).a(z ? 7 : 5).a(this.r).d(com.bytedance.sdk.openadsdk.q.q.i(this.f66078b)).a(this.f66082f).a(this.f66084h).a(this.f66079c).a(map).a(this.s).a(view).a(eVar);
            this.f66083g.a(new com.bytedance.sdk.openadsdk.i.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66090a;

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
                    this.f66090a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.i.b
                public void a(boolean z2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str}) == null) {
                        k.b("end card load finish: ", "code=" + i2 + " msg=" + str + " isRenderSuc=" + z2);
                        if (z2) {
                            this.f66090a.l = true;
                        }
                        if (m.d(this.f66090a.f66078b)) {
                            k.b("CommonEndCard", "TimeTrackLog report from js " + z2);
                            this.f66090a.a(z2, i2, str);
                        }
                    }
                }
            });
            w();
        }
    }

    public void a(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadListener) == null) {
            this.f66082f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.f66077a, this.f66083g, this.f66078b.ak(), this.f66085i) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66091a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r11, r12, r13, r14};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (w) objArr2[1], (String) objArr2[2], (j) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66091a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        q qVar = this.f66091a.f66084h;
                        if (qVar != null) {
                            qVar.k();
                        }
                        super.onPageFinished(webView, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        q qVar = this.f66091a.f66084h;
                        if (qVar != null) {
                            qVar.j();
                        }
                        super.onPageStarted(webView, str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        this.f66091a.m.set(false);
                        b bVar = this.f66091a;
                        bVar.f66086j = i2;
                        bVar.k = str;
                        if (bVar.f66084h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    jSONObject.put("code", i2);
                                    jSONObject.put("msg", str);
                                }
                                this.f66091a.f66084h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        super.onReceivedError(webView, i2, str, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                @TargetApi(21)
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048580, this, webView, webResourceRequest, webResourceResponse) == null) {
                        if (this.f66091a.f66084h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 21) {
                                    jSONObject.put("code", webResourceResponse.getStatusCode());
                                    jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                                }
                                this.f66091a.f66084h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        if (this.f66091a.t.equals(String.valueOf(webResourceRequest.getUrl()))) {
                            this.f66091a.m.set(false);
                            if (webResourceResponse != null) {
                                this.f66091a.f66086j = webResourceResponse.getStatusCode();
                                this.f66091a.k = "onReceivedHttpError";
                            }
                        }
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048582, this, webView, str)) == null) ? super.shouldInterceptRequest(webView, str) : (WebResourceResponse) invokeLL.objValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                @TargetApi(21)
                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, webResourceRequest)) == null) {
                        try {
                            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                        } catch (Throwable th) {
                            k.c("CommonEndCard", "shouldInterceptRequest error1", th);
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                @TargetApi(23)
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
                        this.f66091a.m.set(false);
                        if (this.f66091a.f66084h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    jSONObject.put("code", webResourceError.getErrorCode());
                                    jSONObject.put("msg", webResourceError.getDescription());
                                }
                                this.f66091a.f66084h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        this.f66091a.f66086j = webResourceError.getErrorCode();
                        this.f66091a.k = String.valueOf(webResourceError.getDescription());
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                    }
                }
            });
            a(this.f66082f);
            this.f66082f.setBackgroundColor(-1);
            this.f66082f.getSettings().setDisplayZoomControls(false);
            this.f66082f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.d(this, this.f66083g, this.f66085i) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f66092a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((w) objArr2[0], (j) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66092a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                        super.onProgressChanged(webView, i2);
                    }
                }
            });
            this.f66082f.setDownloadListener(downloadListener);
        }
    }
}
