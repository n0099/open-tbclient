package com.bytedance.sdk.openadsdk.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.b.d;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.j;
import com.bytedance.sdk.openadsdk.e.q;
import com.bytedance.sdk.openadsdk.i.f;
import com.bytedance.sdk.openadsdk.i.g;
import com.bytedance.sdk.openadsdk.l.b;
import com.bytedance.sdk.openadsdk.l.c;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.q.i;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTPlayableWebPageActivity extends Activity implements w.a, d, f {
    public static /* synthetic */ Interceptable $ic;
    public static final e.a K;
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public AtomicBoolean B;
    public String C;
    public int D;
    public int E;
    public com.bytedance.sdk.openadsdk.preload.falconx.a.a F;
    public com.bytedance.sdk.openadsdk.l.f G;
    public boolean H;
    public q I;
    public j J;

    /* renamed from: a  reason: collision with root package name */
    public TTAdDislike f29264a;

    /* renamed from: b  reason: collision with root package name */
    public g f29265b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.i.d f29266c;

    /* renamed from: d  reason: collision with root package name */
    public SSWebView f29267d;

    /* renamed from: e  reason: collision with root package name */
    public SSWebView f29268e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29269f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29270g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f29271h;

    /* renamed from: i  reason: collision with root package name */
    public View f29272i;
    public ImageView j;
    public Context k;
    public int l;
    public ProgressBar m;
    public PlayableLoadingView n;
    public String o;
    public String p;
    public com.bytedance.sdk.openadsdk.core.w q;
    public com.bytedance.sdk.openadsdk.core.w r;
    public int s;
    public String t;
    public String u;
    public final String v;
    public m w;
    public w x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(986796330, "Lcom/bytedance/sdk/openadsdk/activity/base/TTPlayableWebPageActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(986796330, "Lcom/bytedance/sdk/openadsdk/activity/base/TTPlayableWebPageActivity;");
                return;
            }
        }
        K = new e.a() { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.1
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

    public TTPlayableWebPageActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29269f = true;
        this.f29270g = true;
        this.v = "embeded_ad";
        this.x = new w(Looper.getMainLooper(), this);
        this.B = new AtomicBoolean(false);
        this.D = 0;
        this.E = 0;
        this.H = false;
        this.f29266c = new com.bytedance.sdk.openadsdk.i.d(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTPlayableWebPageActivity f29279a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f29279a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.i.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && !this.f29279a.isFinishing() && o.f(this.f29279a.w) && o.h(this.f29279a.w)) {
                    this.f29279a.x.removeMessages(2);
                    this.f29279a.x.sendMessage(this.f29279a.b(1));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && o.f(this.f29279a.w) && o.g(this.f29279a.w)) {
                    this.f29279a.x.sendMessageDelayed(this.f29279a.b(0), 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.d
            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? this.f29279a.n != null && this.f29279a.n.getVisibility() == 0 : invokeV.booleanValue;
            }

            @Override // com.bytedance.sdk.openadsdk.i.d
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4) == null) && o.f(this.f29279a.w) && this.f29279a.n != null) {
                    this.f29279a.n.setProgress(i4);
                }
            }
        };
    }

    public static /* synthetic */ int k(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i2 = tTPlayableWebPageActivity.D;
        tTPlayableWebPageActivity.D = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int n(TTPlayableWebPageActivity tTPlayableWebPageActivity) {
        int i2 = tTPlayableWebPageActivity.E;
        tTPlayableWebPageActivity.E = i2 + 1;
        return i2;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onBackPressed();
            q qVar = this.I;
            if (qVar != null) {
                qVar.n();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                requestWindowFeature(1);
                getWindow().addFlags(1024);
                getWindow().addFlags(16777216);
                com.bytedance.sdk.openadsdk.core.o.a(this);
            } catch (Throwable unused) {
            }
            a(bundle);
            m mVar = this.w;
            if (mVar == null) {
                return;
            }
            int i2 = o.i(mVar);
            if (i2 != 0) {
                if (i2 == 1) {
                    setRequestedOrientation(1);
                } else if (i2 == 2) {
                    setRequestedOrientation(0);
                }
            } else if (Build.VERSION.SDK_INT >= 18) {
                setRequestedOrientation(14);
            } else {
                setRequestedOrientation(1);
            }
            this.k = this;
            setContentView(t.f(this, "tt_activity_ttlandingpage_playable"));
            h();
            e();
            a();
            m();
            f();
            g();
            q qVar = this.I;
            if (qVar != null) {
                qVar.m();
            }
            this.F = com.bytedance.sdk.openadsdk.f.a.a().b();
            com.bytedance.sdk.openadsdk.e.d.a(this.w, this);
            g gVar = new g(getApplicationContext());
            this.f29265b = gVar;
            gVar.a(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            q qVar = this.I;
            if (qVar != null) {
                qVar.a(true);
                this.I.t();
            }
            w wVar = this.x;
            if (wVar != null) {
                wVar.removeCallbacksAndMessages(null);
            }
            try {
                if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                    viewGroup.removeAllViews();
                }
            } catch (Throwable unused) {
            }
            if (!TextUtils.isEmpty(this.C)) {
                d.a.a(this.E, this.D, this.w);
            }
            com.bytedance.sdk.openadsdk.f.a.a().a(this.F);
            aa.a(this.k, this.f29267d);
            aa.a(this.f29267d);
            SSWebView sSWebView = this.f29267d;
            if (sSWebView != null) {
                sSWebView.destroy();
            }
            this.f29267d = null;
            com.bytedance.sdk.openadsdk.core.w wVar2 = this.q;
            if (wVar2 != null) {
                wVar2.s();
            }
            com.bytedance.sdk.openadsdk.core.w wVar3 = this.r;
            if (wVar3 != null) {
                wVar3.s();
            }
            l();
            com.bytedance.sdk.openadsdk.l.f fVar = this.G;
            if (fVar != null) {
                fVar.r();
            }
            j jVar = this.J;
            if (jVar != null) {
                jVar.e();
            }
            this.f29265b = null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            com.bytedance.sdk.openadsdk.core.t.a().b(true);
            com.bytedance.sdk.openadsdk.core.w wVar = this.q;
            if (wVar != null) {
                wVar.r();
                this.q.b(false);
            }
            com.bytedance.sdk.openadsdk.core.w wVar2 = this.r;
            if (wVar2 != null) {
                wVar2.r();
            }
            com.bytedance.sdk.openadsdk.l.f fVar = this.G;
            if (fVar != null) {
                fVar.a(true);
                this.G.p();
                this.G.b(false);
            }
            g gVar = this.f29265b;
            if (gVar != null) {
                gVar.c();
                this.f29265b.a((f) null);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            com.bytedance.sdk.openadsdk.core.w wVar = this.q;
            if (wVar != null) {
                wVar.q();
                SSWebView sSWebView = this.f29267d;
                if (sSWebView != null) {
                    this.q.b(sSWebView.getVisibility() == 0);
                }
            }
            com.bytedance.sdk.openadsdk.core.w wVar2 = this.r;
            if (wVar2 != null) {
                wVar2.q();
            }
            com.bytedance.sdk.openadsdk.l.f fVar = this.G;
            if (fVar != null) {
                fVar.q();
                this.G.b(true);
            }
            j jVar = this.J;
            if (jVar != null) {
                jVar.c();
            }
            g gVar = this.f29265b;
            if (gVar != null) {
                gVar.a(this);
                this.f29265b.b();
                if (this.f29265b.d() == 0) {
                    this.H = true;
                }
                b(this.H);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putString("material_meta", this.w != null ? this.w.aP().toString() : null);
                bundle.putInt(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, this.l);
                bundle.putString(XAdRemoteAPKDownloadExtraInfo.ADID, this.o);
                bundle.putString("log_extra", this.p);
                bundle.putInt("source", this.s);
                bundle.putBoolean("ad_pending_download", this.y);
                bundle.putString("url", this.t);
                bundle.putString("web_title", this.u);
                bundle.putString("event_tag", "embeded_ad");
            } catch (Throwable unused) {
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            q qVar = this.I;
            if (qVar != null) {
                qVar.p();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            q qVar = this.I;
            if (qVar != null) {
                qVar.o();
            }
            j jVar = this.J;
            if (jVar != null) {
                jVar.d();
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            int i2 = com.bytedance.sdk.openadsdk.core.o.h().q(String.valueOf(com.bytedance.sdk.openadsdk.q.q.d(this.w.ao()))).r;
            if (i2 >= 0) {
                this.x.sendEmptyMessageDelayed(1, i2 * 1000);
            } else {
                s.a((View) this.f29271h, 0);
            }
        }
    }

    private void g() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (sSWebView = this.f29267d) == null) {
            return;
        }
        j b2 = new j(this, this.w, sSWebView).b(true);
        this.J = b2;
        b2.a("embeded_ad");
        this.J.a(this.I);
        this.f29267d.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.k, this.q, this.o, this.J) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTPlayableWebPageActivity f29284a;

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
                this.f29284a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    super.onPageFinished(webView, str);
                    if (this.f29284a.isFinishing()) {
                        return;
                    }
                    if (this.f29284a.G != null) {
                        this.f29284a.G.h(str);
                    }
                    try {
                        this.f29284a.f29266c.b();
                    } catch (Throwable unused) {
                    }
                    try {
                        if (this.f29284a.m != null) {
                            this.f29284a.m.setVisibility(8);
                        }
                        if (this.f29284a.f29269f) {
                            this.f29284a.i();
                            this.f29284a.a("py_loading_success");
                            if (this.f31148b != null) {
                                this.f31148b.b(true);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                    super.onPageStarted(webView, str, bitmap);
                    if (this.f29284a.G != null) {
                        this.f29284a.G.g(str);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    this.f29284a.f29269f = false;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048580, this, webView, webResourceRequest, webResourceResponse) == null) {
                    if (this.f29284a.t != null && webResourceRequest != null && webResourceRequest.getUrl() != null && this.f29284a.t.equals(webResourceRequest.getUrl().toString())) {
                        this.f29284a.f29269f = false;
                    }
                    if (this.f29284a.G != null) {
                        try {
                            this.f29284a.G.a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                        } catch (Throwable unused) {
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, str)) == null) {
                    try {
                        if (this.f29284a.G != null) {
                            this.f29284a.G.i(str);
                        }
                        if (!TextUtils.isEmpty(this.f29284a.C)) {
                            TTPlayableWebPageActivity.k(this.f29284a);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        WebResourceResponse a2 = com.bytedance.sdk.openadsdk.f.a.a().a(this.f29284a.F, this.f29284a.C, str);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (this.f29284a.I != null) {
                            e.a a3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
                            int i2 = a2 != null ? 1 : 2;
                            if (a3 == e.a.f31127a) {
                                this.f29284a.I.a(str, currentTimeMillis, currentTimeMillis2, i2);
                            } else if (a3 == e.a.f31129c) {
                                this.f29284a.I.b(str, currentTimeMillis, currentTimeMillis2, i2);
                            }
                        }
                        if (a2 != null) {
                            TTPlayableWebPageActivity.n(this.f29284a);
                            if (this.f29284a.G != null) {
                                this.f29284a.G.j(str);
                            }
                            return a2;
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable unused) {
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
                return (WebResourceResponse) invokeLL.objValue;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                    super.onReceivedError(webView, i2, str, str2);
                    this.f29284a.f29269f = false;
                    if (this.f29284a.G != null) {
                        this.f29284a.G.a(i2, str, str2);
                    }
                }
            }
        });
        a(this.f29267d);
        a(this.f29268e);
        j();
        this.f29267d.loadUrl(this.t);
        this.f29267d.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.d(this, this.q, this.J) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTPlayableWebPageActivity f29273a;

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
                this.f29273a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.d, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, webView, i2) == null) {
                    super.onProgressChanged(webView, i2);
                    if (this.f29273a.isFinishing()) {
                        return;
                    }
                    try {
                        this.f29273a.f29266c.a(i2);
                    } catch (Throwable unused) {
                    }
                    if (this.f29273a.m != null) {
                        if (i2 != 100 || !this.f29273a.m.isShown()) {
                            this.f29273a.m.setProgress(i2);
                            return;
                        }
                        this.f29273a.m.setVisibility(8);
                        this.f29273a.i();
                    }
                }
            }
        });
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.n = (PlayableLoadingView) findViewById(t.e(this, "tt_playable_loading"));
            this.f29267d = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
            this.f29268e = (SSWebView) findViewById(t.e(this, "tt_browser_webview_loading"));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(t.e(this, "tt_playable_ad_close_layout"));
            this.f29271h = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTPlayableWebPageActivity f29274a;

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
                        this.f29274a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f29274a.I != null) {
                                this.f29274a.I.n();
                            }
                            this.f29274a.a("playable_close");
                            this.f29274a.n();
                            this.f29274a.finish();
                        }
                    }
                });
            }
            this.m = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
            View findViewById = findViewById(t.e(this, "tt_playable_ad_dislike"));
            this.f29272i = findViewById;
            findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPlayableWebPageActivity f29275a;

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
                    this.f29275a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f29275a.b();
                    }
                }
            });
            ImageView imageView = (ImageView) findViewById(t.e(this, "tt_playable_ad_mute"));
            this.j = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPlayableWebPageActivity f29276a;

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
                    this.f29276a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TTPlayableWebPageActivity tTPlayableWebPageActivity = this.f29276a;
                        tTPlayableWebPageActivity.H = !tTPlayableWebPageActivity.H;
                        TTPlayableWebPageActivity tTPlayableWebPageActivity2 = this.f29276a;
                        tTPlayableWebPageActivity2.b(tTPlayableWebPageActivity2.H);
                        if (this.f29276a.G != null) {
                            this.f29276a.G.a(this.f29276a.H);
                        }
                    }
                }
            });
            this.f29267d.setBackgroundColor(-16777216);
            this.f29268e.setBackgroundColor(-16777216);
            s.a((View) this.f29267d, 4);
            s.a((View) this.f29268e, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        SSWebView sSWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || this.B.getAndSet(true) || (sSWebView = this.f29267d) == null || this.f29268e == null) {
            return;
        }
        s.a((View) sSWebView, 0);
        s.a((View) this.f29268e, 8);
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.f29268e == null) {
            return;
        }
        String k = k();
        if (TextUtils.isEmpty(k)) {
            return;
        }
        this.f29268e.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.e(this, this.k, this.r, this.o, null) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTPlayableWebPageActivity f29278a;

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
                this.f29278a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    super.onPageFinished(webView, str);
                    if (this.f29278a.f29270g) {
                        this.f29278a.a("loading_h5_success");
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    this.f29278a.f29270g = false;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceResponse) == null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    this.f29278a.f29270g = false;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.e, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                    super.onReceivedError(webView, i2, str, str2);
                    this.f29278a.f29270g = false;
                }
            }
        });
        this.f29268e.loadUrl(k);
    }

    private String k() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            String o = com.bytedance.sdk.openadsdk.core.o.h().o();
            if (TextUtils.isEmpty(o) || (mVar = this.w) == null || mVar.al() == null) {
                return o;
            }
            String c2 = this.w.al().c();
            int e2 = this.w.al().e();
            int f2 = this.w.al().f();
            String a2 = this.w.Y().a();
            String ak = this.w.ak();
            String d2 = this.w.al().d();
            String b2 = this.w.al().b();
            String c3 = this.w.al().c();
            StringBuffer stringBuffer = new StringBuffer(o);
            stringBuffer.append("?appname=");
            stringBuffer.append(c2);
            stringBuffer.append("&stars=");
            stringBuffer.append(e2);
            stringBuffer.append("&comments=");
            stringBuffer.append(f2);
            stringBuffer.append("&icon=");
            stringBuffer.append(a2);
            stringBuffer.append("&downloading=");
            stringBuffer.append(false);
            stringBuffer.append("&id=");
            stringBuffer.append(ak);
            stringBuffer.append("&pkg_name=");
            stringBuffer.append(d2);
            stringBuffer.append("&download_url=");
            stringBuffer.append(b2);
            stringBuffer.append("&name=");
            stringBuffer.append(c3);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    private void l() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || this.z || !this.y || (aVar = this.A) == null) {
            return;
        }
        aVar.g();
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.w);
            this.I = new q(3, "embeded_ad", this.w);
            com.bytedance.sdk.openadsdk.core.w wVar = new com.bytedance.sdk.openadsdk.core.w(this);
            this.q = wVar;
            wVar.b(this.f29267d).a(this.w).a(arrayList).b(this.o).c(this.p).a(this.s).a(this).a(this.I).a(this.f29266c).a(this.f29267d).d(com.bytedance.sdk.openadsdk.q.q.i(this.w));
            com.bytedance.sdk.openadsdk.core.w wVar2 = new com.bytedance.sdk.openadsdk.core.w(this);
            this.r = wVar2;
            wVar2.b(this.f29268e).a(this.w).b(this.o).c(this.p).a(this).a(this.s).c(false).a(this.I).a(this.f29268e).d(com.bytedance.sdk.openadsdk.q.q.i(this.w));
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        m mVar;
        Bitmap b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || (mVar = this.w) == null || this.f29267d == null || !o.a(mVar) || (b2 = s.b((WebView) this.f29267d)) == null) {
            return;
        }
        s.a(com.bytedance.sdk.openadsdk.core.o.a(), this.w, "embeded_ad", "playable_show_status", b2, false, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = i2;
            return obtain;
        }
        return (Message) invokeI.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && this.G == null) {
            if (h.d().x()) {
                com.bytedance.sdk.openadsdk.l.e.a(K);
            }
            com.bytedance.sdk.openadsdk.l.a aVar = new com.bytedance.sdk.openadsdk.l.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPlayableWebPageActivity f29280a;

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
                    this.f29280a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.a
                public c a() {
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
                                            return c.f31662f;
                                        }
                                        return c.f31661e;
                                    }
                                    return c.f31660d;
                                }
                                return c.f31659c;
                            }
                            return c.f31658b;
                        }
                        return c.f31657a;
                    }
                    return (c) invokeV.objValue;
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
                        com.bytedance.sdk.openadsdk.e.d.b(this.f29280a.getApplicationContext(), this.f29280a.w, "embeded_ad", "playable_track", jSONObject);
                    }
                }
            };
            b bVar = new b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPlayableWebPageActivity f29281a;

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
                    this.f29281a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.b
                public void a(String str, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) {
                        this.f29281a.q.a(str, jSONObject);
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAdRequestParam.CELL_ID, this.o);
                jSONObject.put("log_extra", this.p);
            } catch (Throwable unused) {
            }
            this.G = com.bytedance.sdk.openadsdk.l.f.a(getApplicationContext(), this.f29267d, bVar, aVar).f(this.t).e(com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.core.o.a())).a(com.bytedance.sdk.openadsdk.c.a.a()).a(jSONObject).b(com.bytedance.sdk.openadsdk.c.a.e()).a("sdkEdition", com.bytedance.sdk.openadsdk.c.a.c()).d(com.bytedance.sdk.openadsdk.c.a.d()).c(false).a(this.H).b(true);
            if (!TextUtils.isEmpty(o.c(this.w))) {
                this.G.c(o.c(this.w));
            }
            Set<String> j = this.G.j();
            WeakReference weakReference = new WeakReference(this.G);
            for (String str : j) {
                if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                    this.q.b().a(str, (com.bytedance.sdk.component.a.e<?, ?>) new com.bytedance.sdk.component.a.e<JSONObject, JSONObject>(this, weakReference) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ WeakReference f29282a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ TTPlayableWebPageActivity f29283b;

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
                            this.f29283b = this;
                            this.f29282a = weakReference;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.bytedance.sdk.component.a.e
                        public JSONObject a(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.a.f fVar) throws Exception {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject2, fVar)) == null) {
                                try {
                                    com.bytedance.sdk.openadsdk.l.f fVar2 = (com.bytedance.sdk.openadsdk.l.f) this.f29282a.get();
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

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && this.w.X() == 4) {
            a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.k, this.w, "embeded_ad");
            this.A = a2;
            if (a2 == null || !(a2 instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) a2).f(true);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29264a = new com.bytedance.sdk.openadsdk.dislike.ui.a(this, this.w.aG(), "embeded_ad", true);
        }
    }

    private void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.l = intent.getIntExtra(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 1);
                this.o = intent.getStringExtra(XAdRemoteAPKDownloadExtraInfo.ADID);
                this.p = intent.getStringExtra("log_extra");
                this.s = intent.getIntExtra("source", -1);
                this.y = intent.getBooleanExtra("ad_pending_download", false);
                this.t = intent.getStringExtra("url");
                this.C = intent.getStringExtra("gecko_id");
                this.u = intent.getStringExtra("web_title");
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.w = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        k.c("TTPWPActivity", "TTPlayableWebPageActivity - onCreate MultiGlobalInfo : ", e2);
                    }
                }
            } else {
                this.w = com.bytedance.sdk.openadsdk.core.t.a().c();
                com.bytedance.sdk.openadsdk.core.t.a().g();
            }
            if (bundle != null) {
                try {
                    this.l = bundle.getInt(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 1);
                    this.o = bundle.getString(XAdRemoteAPKDownloadExtraInfo.ADID);
                    this.p = bundle.getString("log_extra");
                    this.s = bundle.getInt("source", -1);
                    this.y = bundle.getBoolean("ad_pending_download", false);
                    this.t = bundle.getString("url");
                    this.u = bundle.getString("web_title");
                    String string = bundle.getString("material_meta", null);
                    if (!TextUtils.isEmpty(string)) {
                        this.w = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
                    }
                } catch (Throwable unused) {
                }
            }
            if (this.w == null) {
                k.f("TTPWPActivity", "material is null, no data to display");
                finish();
            }
            try {
                this.H = com.bytedance.sdk.openadsdk.core.o.h().c(Integer.parseInt(this.w.m().getCodeId()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.w == null || isFinishing()) {
            return;
        }
        if (this.f29264a == null) {
            c();
        }
        this.f29264a.showDislikeDialog();
    }

    public void b(boolean z) {
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            try {
                this.H = z;
                if (z) {
                    d2 = t.d(this.k, "tt_mute");
                } else {
                    d2 = t.d(this.k, "tt_unmute");
                }
                this.j.setImageResource(d2);
                this.G.a(z);
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.n == null) {
            return;
        }
        m mVar = this.w;
        if (mVar != null && !o.f(mVar)) {
            this.n.a();
            return;
        }
        this.n.b();
        if (this.n.getPlayView() != null) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = new com.bytedance.sdk.openadsdk.core.b.a(this, this, this.w, "embeded_ad", this.s) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTPlayableWebPageActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPlayableWebPageActivity f29277a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this, r12, r13, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, this, r12, r13, Integer.valueOf(r14)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (m) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29277a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.a, com.bytedance.sdk.openadsdk.core.b.b, com.bytedance.sdk.openadsdk.core.b.c
                public void a(View view, int i2, int i3, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        super.a(view, i2, i3, i4, i5);
                        this.f29277a.y = true;
                        this.f29277a.z = true;
                        HashMap hashMap = new HashMap();
                        hashMap.put("playable_url", this.f29277a.t);
                        TTPlayableWebPageActivity tTPlayableWebPageActivity = this.f29277a;
                        com.bytedance.sdk.openadsdk.e.d.j(tTPlayableWebPageActivity, tTPlayableWebPageActivity.w, this.f29940d, "click_playable_download_button_loading", hashMap);
                    }
                }
            };
            aVar.a(this.A);
            this.n.getPlayView().setOnClickListener(aVar);
            this.n.getPlayView().setOnTouchListener(aVar);
        }
        if (o.h(this.w)) {
            this.x.sendMessageDelayed(b(2), 10000L);
        }
    }

    private void a(SSWebView sSWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, sSWebView) == null) || sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.c.a(this.k).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(i.a(sSWebView, this.l));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            com.bytedance.sdk.openadsdk.e.d.d(this, this.w, "embeded_ad", str, (JSONObject) null);
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                s.a((View) this.f29271h, 0);
            } else if (i2 != 2) {
            } else {
                k.a("playable hidden loading , type:" + message.arg1);
                HashMap hashMap = new HashMap();
                hashMap.put("remove_loading_page_type", Integer.valueOf(message.arg1));
                hashMap.put("playable_url", this.t);
                com.bytedance.sdk.openadsdk.e.d.j(this, this.w, "embeded_ad", "remove_loading_page", hashMap);
                this.x.removeMessages(2);
                PlayableLoadingView playableLoadingView = this.n;
                if (playableLoadingView != null) {
                    playableLoadingView.a();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.d
    public void a(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.y = true;
            this.z = z;
            if (!z) {
                Toast.makeText(this.k, "稍后开始下载", 0).show();
            }
            if (!this.z || (aVar = this.A) == null) {
                return;
            }
            aVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.f
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            b(i2 <= 0);
        }
    }
}
