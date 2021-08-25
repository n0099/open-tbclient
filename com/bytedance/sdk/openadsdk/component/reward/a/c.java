package com.bytedance.sdk.openadsdk.component.reward.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.component.reward.b.e;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.f;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.bytedance.sdk.openadsdk.component.reward.a.a implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public static final e.a G;
    public transient /* synthetic */ FieldHolder $fh;
    public f A;
    public String B;
    public boolean C;
    public com.bytedance.sdk.openadsdk.i.d D;
    public e.b E;
    public final a F;
    public int t;
    public int u;
    public long v;
    public int w;
    public final AtomicBoolean x;
    public final AtomicBoolean y;
    public final w z;

    /* loaded from: classes9.dex */
    public interface a {
        void a(WebView webView, int i2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1679089409, "Lcom/bytedance/sdk/openadsdk/component/reward/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1679089409, "Lcom/bytedance/sdk/openadsdk/component/reward/a/c;");
                return;
            }
        }
        G = new e.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.l.e.a
            public void a(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                    k.b(str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.l.e.a
            public void a(String str, String str2, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, th) == null) {
                    k.c(str, str2, th);
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Activity activity, m mVar, String str, int i2, int i3, int i4, float f2, boolean z, String str2) {
        super(activity, mVar, str, i2, i3, i4, f2, z, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {activity, mVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Float) objArr2[6]).floatValue(), ((Boolean) objArr2[7]).booleanValue(), (String) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = 0;
        this.u = 0;
        this.v = 0L;
        this.w = 0;
        this.x = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        this.z = new w(Looper.getMainLooper(), this);
        this.F = new a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65567a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i7 = newInitContext2.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f65567a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.a.c.a
            public void a(WebView webView, String str3) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str3) == null) || this.f65567a.x.getAndSet(true)) {
                    return;
                }
                if (this.f65567a.E != null) {
                    this.f65567a.E.a();
                }
                if (this.f65567a.D != null) {
                    this.f65567a.D.b();
                }
                c cVar = this.f65567a;
                com.bytedance.sdk.openadsdk.e.d.d(cVar.f65551a, cVar.f65552b, cVar.f65553c, "py_loading_success", (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.a.c.a
            public void a(WebView webView, String str3, Bitmap bitmap) {
                HashMap hashMap;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str3, bitmap) == null) && o.j(this.f65567a.f65552b) && !this.f65567a.y.getAndSet(true)) {
                    int d2 = q.d(this.f65567a.f65552b.ao());
                    this.f65567a.t = com.bytedance.sdk.openadsdk.core.o.h().n(String.valueOf(d2));
                    this.f65567a.u = com.bytedance.sdk.openadsdk.core.o.h().a(String.valueOf(d2), this.f65567a.f65554d);
                    if (this.f65567a.E != null) {
                        this.f65567a.E.a(this.f65567a.t * 1000);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 10;
                    c cVar = this.f65567a;
                    obtain.arg1 = cVar.t;
                    cVar.z.sendMessage(obtain);
                    this.f65567a.v = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.f65567a.f65555e)) {
                        hashMap = null;
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("rit_scene", this.f65567a.f65555e);
                    }
                    c cVar2 = this.f65567a;
                    com.bytedance.sdk.openadsdk.e.d.a(cVar2.f65551a, cVar2.f65552b, cVar2.f65553c, hashMap);
                    k.e("AdEvent", "pangolin ad show " + q.a(this.f65567a.f65552b, (View) null));
                    if (this.f65567a.E != null) {
                        this.f65567a.E.b();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.a.c.a
            public void a(WebView webView, int i7) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i7) == null) || this.f65567a.D == null) {
                    return;
                }
                this.f65567a.D.a(i7);
            }
        };
        Activity activity2 = this.f65551a;
        this.f65556f = (SSWebView) activity2.findViewById(t.e(activity2, "tt_reward_browser_webview_playable"));
        a();
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.B = o.e(this.f65552b);
            float aJ = this.f65552b.aJ();
            if (TextUtils.isEmpty(this.B)) {
                return;
            }
            if (this.n == 1) {
                if (this.B.contains("?")) {
                    this.B += "&orientation=portrait";
                } else {
                    this.B += "?orientation=portrait";
                }
            }
            if (this.B.contains("?")) {
                this.B += "&height=" + this.p + "&width=" + this.o + "&aspect_ratio=" + aJ;
                return;
            }
            this.B += "?height=" + this.p + "&width=" + this.o + "&aspect_ratio=" + aJ;
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.z.removeMessages(10);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.w <= 0) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.arg1 = this.w;
        this.z.sendMessageDelayed(obtain, 1000L);
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65557g.f() : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.C = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.j();
            f fVar = this.A;
            if (fVar != null) {
                fVar.q();
                if (s.d((View) this.f65556f)) {
                    this.A.b(true);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.k();
            f fVar = this.A;
            if (fVar != null) {
                fVar.p();
                this.A.b(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.m();
            f fVar = this.A;
            if (fVar != null) {
                fVar.r();
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.x.get() : invokeV.booleanValue;
    }

    public void v() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (sSWebView = this.f65556f) == null) {
            return;
        }
        sSWebView.loadUrl(this.B);
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            a(true);
            this.A.b(true);
            c(true);
            a(false, true);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            try {
                if (this.C && !TextUtils.isEmpty(this.B) && this.f65560j != 0) {
                    com.bytedance.sdk.openadsdk.j.a.a().a(this.B, this.f65560j, this.k);
                }
            } catch (Throwable unused) {
            }
            try {
                if (!this.C || TextUtils.isEmpty(this.B)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.j.a.a().b(this.B);
            } catch (Throwable unused2) {
            }
        }
    }

    public void y() {
        m mVar;
        Bitmap b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (mVar = this.f65552b) == null || this.f65556f == null || !o.a(mVar) || (b2 = s.b((WebView) this.f65556f)) == null) {
            return;
        }
        s.a(com.bytedance.sdk.openadsdk.core.o.a(), this.f65552b, this.f65553c, "playable_show_status", b2, false, 1);
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? System.currentTimeMillis() - this.v : invokeV.longValue;
    }

    public void a(boolean z, Map<String, Object> map, View view, com.bytedance.sdk.openadsdk.i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), map, view, eVar}) == null) {
            this.f65558h = new com.bytedance.sdk.openadsdk.e.q(3, this.f65553c, this.f65552b);
            j b2 = new j(this.f65551a, this.f65552b, this.f65556f).b(true);
            this.f65559i = b2;
            b2.a(true);
            this.f65559i.a(z ? "reward_endcard" : "fullscreen_endcard");
            com.bytedance.sdk.openadsdk.core.w wVar = new com.bytedance.sdk.openadsdk.core.w(this.f65551a);
            this.f65557g = wVar;
            wVar.b(this.f65556f).a(this.f65552b).b(this.f65552b.ak()).c(this.f65552b.ao()).a(z ? 7 : 5).a(this.r).d(q.i(this.f65552b)).a(this.f65556f).a(this.f65558h).a(this.f65553c).a(map).a(this.s).a(this.C).a(view).a(eVar);
            this.f65557g.a(new com.bytedance.sdk.openadsdk.i.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65568a;

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
                    this.f65568a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.i.b
                public void a(boolean z2, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), str}) == null) {
                        k.b("end card load finish: ", "code=" + i2 + " msg=" + str + " isRenderSuc=" + z2);
                        if (z2) {
                            this.f65568a.l = true;
                        }
                    }
                }
            });
            D();
            a(eVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.A.a(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.a.a
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.d(z);
            if (this.D.c()) {
                return;
            }
            w();
        }
    }

    public void a(DownloadListener downloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadListener) == null) {
            this.f65556f.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.f65551a, this.f65557g, this.f65552b.ak(), this.f65559i) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65569a;

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
                            super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.w) objArr2[1], (String) objArr2[2], (j) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65569a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        com.bytedance.sdk.openadsdk.e.q qVar = this.f65569a.f65558h;
                        if (qVar != null) {
                            qVar.k();
                        }
                        f fVar = this.f65569a.A;
                        if (fVar != null) {
                            fVar.h(str);
                        }
                        super.onPageFinished(webView, str);
                        this.f65569a.F.a(webView, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        com.bytedance.sdk.openadsdk.e.q qVar = this.f65569a.f65558h;
                        if (qVar != null) {
                            qVar.j();
                        }
                        f fVar = this.f65569a.A;
                        if (fVar != null) {
                            fVar.g(str);
                        }
                        super.onPageStarted(webView, str, bitmap);
                        this.f65569a.F.a(webView, str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        this.f65569a.m.set(false);
                        c cVar = this.f65569a;
                        cVar.f65560j = i2;
                        cVar.k = str;
                        f fVar = cVar.A;
                        if (fVar != null) {
                            fVar.a(i2, str, str2);
                        }
                        if (this.f65569a.f65558h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    jSONObject.put("code", i2);
                                    jSONObject.put("msg", str);
                                }
                                this.f65569a.f65558h.a(jSONObject);
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
                        f fVar = this.f65569a.A;
                        if (fVar != null) {
                            try {
                                fVar.a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                            } catch (Throwable unused) {
                            }
                        }
                        if (this.f65569a.f65558h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 21) {
                                    jSONObject.put("code", webResourceResponse.getStatusCode());
                                    jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                                }
                                this.f65569a.f65558h.a(jSONObject);
                            } catch (JSONException unused2) {
                            }
                        }
                        if (this.f65569a.B.equals(String.valueOf(webResourceRequest.getUrl()))) {
                            this.f65569a.m.set(false);
                            if (webResourceResponse != null) {
                                this.f65569a.f65560j = webResourceResponse.getStatusCode();
                                this.f65569a.k = "onReceivedHttpError";
                            }
                        }
                        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048582, this, webView, str)) == null) {
                        if (o.a(this.f65569a.f65552b)) {
                            long currentTimeMillis = System.currentTimeMillis();
                            WebResourceResponse a2 = com.bytedance.sdk.openadsdk.core.h.a.a().a(this.f65569a.f65552b.V().k(), this.f65569a.f65552b.V().j(), str);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (this.f65569a.f65558h != null) {
                                e.a a3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
                                int i2 = a2 != null ? 1 : 2;
                                if (a3 == e.a.f67265a) {
                                    this.f65569a.f65558h.a(str, currentTimeMillis, currentTimeMillis2, i2);
                                } else if (a3 == e.a.f67267c) {
                                    this.f65569a.f65558h.b(str, currentTimeMillis, currentTimeMillis2, i2);
                                }
                            }
                            return a2;
                        }
                        return super.shouldInterceptRequest(webView, str);
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
                @TargetApi(23)
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
                        this.f65569a.m.set(false);
                        if (this.f65569a.f65558h != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (Build.VERSION.SDK_INT >= 23) {
                                    jSONObject.put("code", webResourceError.getErrorCode());
                                    jSONObject.put("msg", webResourceError.getDescription());
                                }
                                this.f65569a.f65558h.a(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        this.f65569a.f65560j = webResourceError.getErrorCode();
                        this.f65569a.k = String.valueOf(webResourceError.getDescription());
                        super.onReceivedError(webView, webResourceRequest, webResourceError);
                    }
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
                            k.c("PlayableEndCard", "shouldInterceptRequest error1", th);
                            return super.shouldInterceptRequest(webView, webResourceRequest);
                        }
                    }
                    return (WebResourceResponse) invokeLL.objValue;
                }
            });
            a(this.f65556f);
            this.f65556f.setBackgroundColor(-16777216);
            this.f65556f.getSettings().setDisplayZoomControls(false);
            this.f65556f.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.d(this, this.f65557g, this.f65559i) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65570a;

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
                            super((com.bytedance.sdk.openadsdk.core.w) objArr2[0], (j) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65570a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                        super.onProgressChanged(webView, i2);
                        this.f65570a.F.a(webView, i2);
                    }
                }
            });
            this.f65556f.setDownloadListener(downloadListener);
            E();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.D = dVar;
            this.f65557g.a(dVar);
        }
    }

    public void a(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.E = bVar;
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (1.0f - (((float) this.w) / ((float) this.t))) * 100.0f >= ((float) i2) : invokeI.booleanValue;
    }

    public void a(com.bytedance.sdk.openadsdk.i.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            if (h.d().x()) {
                com.bytedance.sdk.openadsdk.l.e.a(G);
            }
            com.bytedance.sdk.openadsdk.l.a aVar = new com.bytedance.sdk.openadsdk.l.a(this, eVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.i.e f65571a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f65572b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65572b = this;
                    this.f65571a = eVar;
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public com.bytedance.sdk.openadsdk.l.c a() {
                    InterceptResult invokeV;
                    char c2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        String f2 = com.bytedance.sdk.openadsdk.c.a.f();
                        int hashCode = f2.hashCode();
                        if (hashCode == 1653) {
                            if (f2.equals("2g")) {
                                c2 = 0;
                            }
                            c2 = 65535;
                        } else if (hashCode == 1684) {
                            if (f2.equals("3g")) {
                                c2 = 1;
                            }
                            c2 = 65535;
                        } else if (hashCode == 1715) {
                            if (f2.equals("4g")) {
                                c2 = 2;
                            }
                            c2 = 65535;
                        } else if (hashCode != 1746) {
                            if (hashCode == 3649301 && f2.equals("wifi")) {
                                c2 = 4;
                            }
                            c2 = 65535;
                        } else {
                            if (f2.equals("5g")) {
                                c2 = 3;
                            }
                            c2 = 65535;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                        if (c2 != 4) {
                                            return com.bytedance.sdk.openadsdk.l.c.f67806f;
                                        }
                                        return com.bytedance.sdk.openadsdk.l.c.f67805e;
                                    }
                                    return com.bytedance.sdk.openadsdk.l.c.f67804d;
                                }
                                return com.bytedance.sdk.openadsdk.l.c.f67803c;
                            }
                            return com.bytedance.sdk.openadsdk.l.c.f67802b;
                        }
                        return com.bytedance.sdk.openadsdk.l.c.f67801a;
                    }
                    return (com.bytedance.sdk.openadsdk.l.c) invokeV.objValue;
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public void a(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f65572b.f65557g.d(true);
                        com.bytedance.sdk.openadsdk.i.e eVar2 = this.f65571a;
                        if (eVar2 != null) {
                            eVar2.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public void b(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, jSONObject) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public void c(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, jSONObject) == null) {
                        Context a2 = com.bytedance.sdk.openadsdk.core.o.a();
                        c cVar = this.f65572b;
                        com.bytedance.sdk.openadsdk.e.d.b(a2, cVar.f65552b, cVar.f65553c, "playable_track", jSONObject);
                    }
                }
            };
            com.bytedance.sdk.openadsdk.l.b bVar = new com.bytedance.sdk.openadsdk.l.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f65573a;

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
                    this.f65573a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.b
                public void a(String str, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) {
                        this.f65573a.f65557g.a(str, jSONObject);
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAdRequestParam.CELL_ID, this.f65552b.ak());
                jSONObject.put("log_extra", this.f65552b.ao());
            } catch (Throwable unused) {
            }
            this.A = f.a(com.bytedance.sdk.openadsdk.core.o.a(), this.f65556f, bVar, aVar).f(this.B).e(com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.core.o.a())).a(com.bytedance.sdk.openadsdk.c.a.a()).a(jSONObject).a("sdkEdition", com.bytedance.sdk.openadsdk.c.a.c()).b(com.bytedance.sdk.openadsdk.c.a.e()).d(com.bytedance.sdk.openadsdk.c.a.d()).c(false).a(false);
            if (!TextUtils.isEmpty(o.c(this.f65552b))) {
                this.A.c(o.c(this.f65552b));
            }
            Set<String> j2 = this.A.j();
            WeakReference weakReference = new WeakReference(this.A);
            for (String str : j2) {
                if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                    this.f65557g.b().a(str, (com.bytedance.sdk.component.a.e<?, ?>) new com.bytedance.sdk.component.a.e<JSONObject, JSONObject>(this, weakReference) { // from class: com.bytedance.sdk.openadsdk.component.reward.a.c.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ WeakReference f65574a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f65575b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, weakReference};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f65575b = this;
                            this.f65574a = weakReference;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.component.a.e
                        public JSONObject a(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject2, fVar)) == null) {
                                try {
                                    f fVar2 = (f) this.f65574a.get();
                                    if (fVar2 == null) {
                                        return null;
                                    }
                                    return fVar2.c(a(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                            return (JSONObject) invokeLL.objValue;
                        }
                    });
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && message.what == 10) {
            com.bytedance.sdk.openadsdk.component.reward.b.c e2 = this.E.e();
            if (o.j(this.f65552b)) {
                int i2 = message.arg1;
                if (i2 > 0) {
                    e2.d(true);
                    int i3 = this.u - (this.t - i2);
                    if (i3 == i2) {
                        e2.a(String.valueOf(i2), null);
                    } else if (i3 > 0) {
                        String valueOf = String.valueOf(i2);
                        e2.a(valueOf, "可在(" + i3 + "s)后跳过");
                    } else {
                        e2.a(String.valueOf(i2), "跳过");
                        e2.f(true);
                    }
                    this.w = i2 - 1;
                    Message obtain = Message.obtain();
                    obtain.what = 10;
                    obtain.arg1 = this.w;
                    this.z.sendMessageDelayed(obtain, 1000L);
                } else {
                    e2.d(false);
                    e.b bVar = this.E;
                    if (bVar != null) {
                        bVar.a(0);
                        this.E.d();
                    }
                }
                e.b bVar2 = this.E;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        }
    }
}
