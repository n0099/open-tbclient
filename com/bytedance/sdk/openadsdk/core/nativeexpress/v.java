package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.theme.ThemeStatusBroadcastReceiver;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class v implements com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<SSWebView>, o, com.bytedance.sdk.openadsdk.theme.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67233a;

    /* renamed from: b  reason: collision with root package name */
    public String f67234b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f67235c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67236d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.e.q f67237e;

    /* renamed from: f  reason: collision with root package name */
    public String f67238f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.e.j f67239g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.a> f67240h;

    /* renamed from: i  reason: collision with root package name */
    public w f67241i;

    /* renamed from: j  reason: collision with root package name */
    public m f67242j;
    public boolean k;
    public boolean l;
    public com.bytedance.sdk.openadsdk.core.e.v m;
    public m.a n;
    public n o;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.g p;
    public SSWebView q;
    public boolean r;
    public int s;

    public v(Context context, com.bytedance.sdk.openadsdk.core.nativeexpress.a.g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar, themeStatusBroadcastReceiver, qVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67240h = Collections.synchronizedMap(new HashMap());
        this.k = false;
        this.s = 8;
        this.f67233a = context;
        this.p = gVar;
        this.f67234b = gVar.c();
        this.f67235c = gVar.a();
        this.f67237e = qVar;
        this.f67236d = gVar.b();
        this.f67238f = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.e();
        themeStatusBroadcastReceiver.a(this);
        j();
        SSWebView b2 = com.bytedance.sdk.openadsdk.core.widget.webview.f.a().b();
        this.q = b2;
        if (b2 == null) {
            this.q = new SSWebView(com.bytedance.sdk.openadsdk.core.o.a());
        } else {
            this.k = true;
        }
        i();
        k();
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            w wVar = new w(this.f67233a);
            this.f67241i = wVar;
            wVar.b(this.q).a(this.f67235c).b(this.f67235c.ak()).c(this.f67235c.ao()).a(this.f67234b).a(com.bytedance.sdk.openadsdk.q.q.a(this.f67234b)).d(com.bytedance.sdk.openadsdk.q.q.i(this.f67235c)).a(this).a(this.f67236d).a(this.q).a(this.f67237e);
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if ("feed_video_middle_page".equals(this.f67234b)) {
                this.m = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.d(this.f67235c);
                com.bytedance.sdk.openadsdk.core.e.m mVar = this.f67235c;
                if (mVar != null) {
                    this.n = mVar.Q();
                    return;
                }
                return;
            }
            this.m = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c(this.f67235c);
            com.bytedance.sdk.openadsdk.core.e.m mVar2 = this.f67235c;
            if (mVar2 != null) {
                this.n = mVar2.P();
            }
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.q.setBackgroundColor(0);
            this.q.setBackgroundResource(17170445);
            a(this.q);
            com.bytedance.sdk.openadsdk.e.j b2 = new com.bytedance.sdk.openadsdk.e.j(this.f67233a, this.f67235c, a()).b(false);
            this.f67239g = b2;
            b2.a(this.f67237e);
            this.q.setWebViewClient(new f(this.f67233a, this.f67241i, this.f67235c, this.f67239g, l()));
            this.q.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.d(this.f67241i, this.f67239g));
            this.q.setDownloadListener(new DownloadListener(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ v f67243a;

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
                    this.f67243a = this;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        if (this.f67243a.f67240h.containsKey(str)) {
                            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = (com.bytedance.sdk.openadsdk.downloadnew.core.a) this.f67243a.f67240h.get(str);
                            if (aVar != null) {
                                aVar.e();
                                return;
                            }
                            return;
                        }
                        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f67243a.f67233a, str, this.f67243a.f67235c, this.f67243a.f67234b);
                        this.f67243a.f67240h.put(str, a2);
                        a2.e();
                    }
                }
            });
            if (Build.VERSION.SDK_INT >= 17) {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().a(this.q, this.f67241i);
            }
        }
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? !TextUtils.isEmpty(this.f67234b) && this.f67234b.equals("splash_ad") : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.q.getParent() != null) {
                ((ViewGroup) this.q.getParent()).removeView(this.q);
            }
            this.f67241i.a();
            if (this.l) {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().a(this.q);
            } else {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
            }
            this.f67240h.clear();
            this.f67241i = null;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || a() == null) {
            return;
        }
        try {
            a().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f67241i == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.f67241i.a("expressShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public w h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f67241i : (w) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 == this.s) {
            return;
        }
        this.s = i2;
        b(i2 == 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a.b
    /* renamed from: c */
    public SSWebView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? a() : (SSWebView) invokeV.objValue;
    }

    private void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.c.a(this.f67233a).a(false).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(com.bytedance.sdk.openadsdk.q.i.a(sSWebView, 3703));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.k.f("WebViewRender", e2.toString());
        }
    }

    private void c(int i2) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, this, i2) == null) || (mVar = this.f67242j) == null) {
            return;
        }
        mVar.a(i2);
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, this, z) == null) || this.f67241i == null || this.q == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.f67241i.a("expressAdShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public SSWebView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (SSWebView) invokeV.objValue;
    }

    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) {
            this.o = nVar;
        }
    }

    public void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
            this.f67242j = mVar;
            if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f()) {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
                this.f67242j.a(102);
            } else if (TextUtils.isEmpty(this.f67238f)) {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
                this.f67242j.a(102);
            } else if (this.m == null && !com.bytedance.sdk.openadsdk.core.nativeexpress.b.a.a(this.n)) {
                com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
                this.f67242j.a(103);
            } else {
                this.p.d().b();
                if (this.k) {
                    try {
                        this.q.clearView();
                        com.bytedance.sdk.component.utils.j.a(this.q, "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
                        return;
                    } catch (Exception unused) {
                        com.bytedance.sdk.component.utils.k.b("WebViewRender", "webview 复用加载失败");
                        com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
                        this.f67242j.a(102);
                        return;
                    }
                }
                SSWebView a2 = a();
                a2.clearView();
                a2.loadUrl(com.bytedance.sdk.openadsdk.q.p.b(this.f67238f));
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            if (pVar == null) {
                this.f67242j.a(105);
                return;
            }
            boolean b2 = pVar.b();
            float c2 = (float) pVar.c();
            float d2 = (float) pVar.d();
            if (c2 > 0.0f && d2 > 0.0f) {
                this.l = b2;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    a(pVar, c2, d2);
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, pVar, c2, d2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.v.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.p f67244a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ float f67245b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ float f67246c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ v f67247d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, pVar, Float.valueOf(c2), Float.valueOf(d2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f67247d = this;
                            this.f67244a = pVar;
                            this.f67245b = c2;
                            this.f67246c = d2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f67247d.a(this.f67244a, this.f67245b, this.f67246c);
                            }
                        }
                    });
                    return;
                }
            }
            this.f67242j.a(105);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.e.p pVar, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{pVar, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (this.l && !this.r) {
                a(f2, f3);
                b(this.s);
                m mVar = this.f67242j;
                if (mVar != null) {
                    mVar.a(a(), pVar);
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.webview.f.a().c(this.q);
            c(pVar.i());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, kVar) == null) || (nVar = this.o) == null) {
            return;
        }
        nVar.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.o
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || (nVar = this.o) == null) {
            return;
        }
        nVar.a(i2, kVar, z);
    }

    @UiThread
    private void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.p.d().c();
            int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f67233a, f2);
            int b3 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f67233a, f3);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(b2, b3);
            }
            layoutParams.width = b2;
            layoutParams.height = b3;
            a().setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.theme.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f67241i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f67241i.a("themeChange", jSONObject);
    }
}
