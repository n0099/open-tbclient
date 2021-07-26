package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
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
import com.bytedance.sdk.component.net.NetResponse;
import com.bytedance.sdk.component.net.callback.NetCallback;
import com.bytedance.sdk.component.net.executor.DownloadExecutor;
import com.bytedance.sdk.component.net.executor.NetExecutor;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.component.splash.a;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.e.q;
import com.bytedance.sdk.openadsdk.core.e.t;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.q.g;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements w.a {
    public static /* synthetic */ Interceptable $ic;
    public static Set<b> k;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public m B;
    public int C;
    public com.bytedance.sdk.openadsdk.k.a.b D;
    public int E;
    public AtomicBoolean F;
    public AtomicBoolean G;
    public a H;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f29773a;

    /* renamed from: b  reason: collision with root package name */
    public n f29774b;

    /* renamed from: c  reason: collision with root package name */
    public TTAdNative.SplashAdListener f29775c;

    /* renamed from: d  reason: collision with root package name */
    public final p f29776d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29777e;

    /* renamed from: f  reason: collision with root package name */
    public final w f29778f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f29779g;

    /* renamed from: h  reason: collision with root package name */
    public e f29780h;

    /* renamed from: i  reason: collision with root package name */
    public e f29781i;
    public e j;
    public com.bytedance.sdk.openadsdk.component.splash.a l;
    public AtomicBoolean m;
    public AtomicBoolean n;
    public AtomicBoolean o;
    public boolean p;
    public long q;
    public long r;
    public long s;
    public final AtomicBoolean t;
    public final AtomicBoolean u;
    public com.bytedance.sdk.openadsdk.core.e.a v;
    public com.bytedance.sdk.openadsdk.core.e.a w;
    public com.bytedance.sdk.openadsdk.j.a.c x;
    public int y;
    public t z;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29827a;

        /* renamed from: b  reason: collision with root package name */
        public int f29828b;

        /* renamed from: c  reason: collision with root package name */
        public String f29829c;

        /* renamed from: d  reason: collision with root package name */
        public TTSplashAd f29830d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.j.a.c f29831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f29832f;

        public a(b bVar, int i2, int i3, String str, TTSplashAd tTSplashAd, com.bytedance.sdk.openadsdk.j.a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3), str, tTSplashAd, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29832f = bVar;
            this.f29827a = i2;
            this.f29828b = i3;
            this.f29829c = str;
            this.f29830d = tTSplashAd;
            this.f29831e = cVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1669049222, "Lcom/bytedance/sdk/openadsdk/component/splash/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1669049222, "Lcom/bytedance/sdk/openadsdk/component/splash/b;");
                return;
            }
        }
        k = Collections.synchronizedSet(new HashSet());
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29775c = null;
        this.f29779g = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.s = 0L;
        this.t = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.y = 0;
        this.A = false;
        this.E = 4;
        this.F = new AtomicBoolean(false);
        this.G = new AtomicBoolean(false);
        if (context != null) {
            this.f29777e = context.getApplicationContext();
        }
        this.f29776d = o.f();
        this.f29778f = new w(Looper.getMainLooper(), this);
        Context context2 = this.f29777e;
        this.l = com.bytedance.sdk.openadsdk.component.splash.a.a(context2 == null ? o.a() : context2);
        this.p = o.h().t();
        k.add(this);
        f();
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, this)) == null) {
            k.f("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
            com.bytedance.sdk.openadsdk.j.a.c a2 = a(15001, (q) null);
            if (!this.l.b(this.f29773a.getCodeId()) && !this.l.a(this.f29773a.getCodeId())) {
                k.f("splashLoadAd", "没有缓存数据..........");
                if (this.t.get() || this.u.get()) {
                    a(15001, new a(this, 2, -12, g.a(-12), null, a2), (q) null, (e) null, (String) null);
                }
                this.y = 0;
                return false;
            } else if (this.l.a(this.f29773a, true)) {
                k.b("splashLoadAd", "======== 缓存过期 ========");
                if (this.t.get() || this.u.get()) {
                    a(15001, new a(this, 2, -11, g.a(-11), null, a2), (q) null, (e) null, (String) null);
                }
                this.y = 2;
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) {
            int f2 = o.h().f(this.C);
            return (2 == f2 || 3 == f2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, this) == null) {
            t tVar = new t();
            this.z = tVar;
            tVar.k(System.currentTimeMillis());
            if (l.f30446f.get()) {
                this.z.b(0);
                l.f30446f.set(false);
                return;
            }
            this.z.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65597, this) == null) || this.z == null) {
            return;
        }
        this.z.a(System.currentTimeMillis() - this.z.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65600, this) == null) || this.f29777e == null || this.B == null || this.z == null || !o.h().v()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(OkHttpNetworkFetcher.IMAGE_SIZE, this.z.i());
            jSONObject.put("image_resolution", this.z.j());
            jSONObject.put("image_response_header", this.z.k());
            jSONObject.put("download_client_start_time", this.z.p());
            jSONObject.put("download_net_time", this.z.q());
            jSONObject.put("download_write_time", this.z.r());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.f29777e, this.B, "splash_ad", "download_image_duration", this.z.f(), jSONObject);
    }

    private void i() {
        com.bytedance.sdk.openadsdk.component.splash.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65601, this) == null) || (aVar = this.l) == null) {
            return;
        }
        aVar.a(this.f29773a, this.f29774b);
    }

    private void j() {
        com.bytedance.sdk.openadsdk.core.e.a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65603, this) == null) || (aVar = this.v) == null || this.x == null || aVar.c() == null || this.v.c().size() == 0 || (mVar = this.v.c().get(0)) == null || mVar.u() != 3) {
            return;
        }
        q qVar = new q(this.v, mVar, null);
        if (mVar.V() == null) {
            return;
        }
        String i2 = mVar.V().i();
        if (TextUtils.isEmpty(i2)) {
            return;
        }
        e a2 = a(qVar, i2);
        a(15003, new a(this, 1, 0, null, a2, this.x), qVar, a2, i2);
    }

    private n k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            n nVar = new n();
            nVar.f30205f = currentTimeMillis;
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) {
            if (d()) {
                a(15001, this.f29773a.getCodeId());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65586, this, mVar) == null) && mVar != null && mVar.V() == null) {
            int f2 = o.h().f(this.C);
            this.A = f2 == 0 || f2 == 2;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || this.f29775c == null) {
            return;
        }
        int f2 = o.h().f(this.C);
        this.z.a(f2);
        if (f2 == 0) {
            this.t.set(false);
            this.u.set(false);
            k.b("splashLoadAd", "splash_type_real_time=====只走实时");
            a(this.f29773a);
        } else if (f2 == 1) {
            this.t.set(false);
            this.u.set(false);
            k.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
            if (!c()) {
                k.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                a(this.f29773a);
                return;
            }
            k.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
        } else if (f2 == 2) {
            k.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
            this.t.set(true);
            this.u.set(false);
            a(this.f29773a);
            c();
        } else if (f2 != 3) {
        } else {
            this.t.set(false);
            this.u.set(true);
            k.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
            a(this.f29773a);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, this, cVar) == null) {
            k.f("splashLoadAd", "reportMarkAtRespFail outer_call_no_rsp");
            if (cVar == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (d()) {
                i2 = 1;
            } else {
                i2 = this.y;
                if (i2 == 2) {
                    c.a(this.f29777e, this.f29773a);
                }
            }
            k.f("splashLoadAd", "reportMarkAtRespFail cacheStatus " + i2);
            try {
                jSONObject.put("if_have_cache", i2);
                jSONObject.put("if_have_rt_ads", this.E);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.j.a.a().d(cVar.b(jSONObject.toString()));
        }
    }

    private void d(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65590, this, mVar) == null) || this.f29777e == null || mVar == null || this.z == null || !o.h().v()) {
            return;
        }
        boolean L = o.h().L();
        boolean w = this.z.w();
        long currentTimeMillis = System.currentTimeMillis();
        if (w) {
            this.z.b(currentTimeMillis - this.z.t());
        } else {
            t tVar = this.z;
            tVar.i(currentTimeMillis - tVar.y());
            this.z.m(currentTimeMillis - this.z.t());
        }
        JSONObject jSONObject = new JSONObject();
        if (L) {
            try {
                jSONObject.put("pre_connect_status", l.f30444d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("if_pre_connect", L ? 1 : 0);
        jSONObject.put("splash_load_type", this.z.a());
        jSONObject.put("splash_final_type", this.z.b());
        jSONObject.put("active_type", this.z.c());
        jSONObject.put("splash_creative_type", this.z.d());
        jSONObject.put("splash_load_type", this.z.a());
        if (this.A) {
            jSONObject.put("load_duration", this.z.e());
            jSONObject.put("download_image_duration", this.z.x());
            jSONObject.put("cache_image_duration", this.z.g());
            jSONObject.put("image_cachetype", this.z.h());
            jSONObject.put(OkHttpNetworkFetcher.IMAGE_SIZE, this.z.i());
            jSONObject.put("image_resolution", this.z.j());
            jSONObject.put("image_response_header", this.z.k());
            jSONObject.put("client_start_time", this.z.l());
            jSONObject.put("network_time", this.z.m());
            jSONObject.put("sever_time", this.z.n());
            jSONObject.put("client_end_time", this.z.o());
            jSONObject.put("download_client_start_time", this.z.p());
            jSONObject.put("download_net_time", this.z.q());
            jSONObject.put("download_write_time", this.z.r());
            jSONObject.put("download_client_end_time", this.z.s());
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.f29777e, mVar, "splash_ad", "splash_ad_loadtime", currentTimeMillis - this.z.u(), jSONObject);
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    public void a(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, splashAdListener, i2) == null) {
            this.f29774b = k();
            this.f29773a = adSlot;
            this.f29775c = splashAdListener;
            this.f29779g.set(false);
            this.f29780h = null;
            this.f29781i = null;
            this.j = null;
            k.b("splashLoadAd", "开发者传入的超时时长 timeOut " + i2);
            this.C = com.bytedance.sdk.openadsdk.q.q.a(adSlot);
            long j = (long) i2;
            int c2 = o.h().c(adSlot.getCodeId());
            k.b("splashLoadAd", "云控的超时时长 cloudTimeOut " + c2);
            if (c2 > 0) {
                k.b("splashLoadAd", "云控控制的超时时长大于0比较 较服务端下发的超时时长和开发者配置的超时时长 ");
                if (c2 >= i2) {
                    i2 = c2;
                }
            } else if (i2 < 500) {
                i2 = 500;
            }
            k.f("splashLoadAd", "getSplashAd 实际 timeOut " + i2);
            long j2 = (long) i2;
            this.f29778f.sendEmptyMessageDelayed(2, j2);
            int i3 = i2 + (-300);
            if (i3 > 0) {
                this.f29778f.sendEmptyMessageDelayed(5, i3);
            }
            a(i2);
            n nVar = this.f29774b;
            nVar.f30206g = j;
            nVar.f30207h = c2;
            nVar.f30208i = j2;
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "getSplashAd", j) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f29782a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29783b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29783b = this;
                    this.f29782a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("publisher_timeout_control", this.f29782a);
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.j.a.a().b(com.bytedance.sdk.openadsdk.j.a.c.b().a(3).c(this.f29783b.f29773a.getCodeId()).f(this.f29783b.f29774b.f30200a).b(jSONObject.toString()));
                    }
                }
            });
            b();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.openadsdk.core.e.a aVar, Context context, com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65581, this, aVar, context, cVar) == null) {
            k.f("splashLoadAd", " SplashUtils preLoadVideo");
            if (!c.b(aVar) || context == null) {
                return;
            }
            m mVar = aVar.c().get(0);
            int d2 = com.bytedance.sdk.openadsdk.q.q.d(mVar.ao());
            x V = mVar.V();
            c.a(mVar, V != null ? 2 : 0);
            if (V != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String i2 = V.i();
                k.f("splashLoadAd", "SplashUtils preLoadVideo videoUrl " + i2);
                if (i2 == null) {
                    a(aVar, context, cVar);
                    return;
                }
                this.v = aVar;
                this.x = cVar;
                c.a(mVar, 1);
                String l = V.l();
                if (TextUtils.isEmpty(l)) {
                    l = com.bytedance.sdk.component.utils.e.a(i2);
                }
                boolean aN = mVar.aN();
                File a2 = c.a(l, d2, aN);
                if (o.h().e(String.valueOf(d2)) && !com.bytedance.sdk.component.utils.n.d(o.a())) {
                    if (l != null && a2.exists()) {
                        k.b("splashLoadAd", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                        com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).b(new q(aVar, mVar, null));
                        a(15000, d2 + "");
                        return;
                    }
                    k.b("splashLoadAd", "非wifi环境");
                    return;
                }
                DownloadExecutor downloadExecutor = com.bytedance.sdk.openadsdk.k.d.b().c().getDownloadExecutor();
                downloadExecutor.setUrl(i2);
                downloadExecutor.setFileInfo(a2.getParent(), a2.getName());
                downloadExecutor.enqueue(new NetCallback(this, aN, a2, aVar, mVar, d2, elapsedRealtime, cVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f29784a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ File f29785b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f29786c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ m f29787d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ int f29788e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ long f29789f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29790g;

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ b f29791h;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(aN), a2, aVar, mVar, Integer.valueOf(d2), Long.valueOf(elapsedRealtime), cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29791h = this;
                        this.f29784a = aN;
                        this.f29785b = a2;
                        this.f29786c = aVar;
                        this.f29787d = mVar;
                        this.f29788e = d2;
                        this.f29789f = elapsedRealtime;
                        this.f29790g = cVar;
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onFailure(NetExecutor netExecutor, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, netExecutor, iOException) == null) {
                            this.f29791h.E = 3;
                            c.a(this.f29789f, true, false, this.f29787d, -2L, new NetResponse(false, -2, iOException.getMessage(), null, null, this.f29789f, SystemClock.elapsedRealtime()));
                            this.f29790g.b(-14).g(g.a(-14));
                            a aVar2 = new a(this.f29791h, 2, -14, g.a(-14), null, this.f29790g);
                            k.f("splashLoadAd", "视频文件缓存失败 onErrorResponse REQUEST_TYPE_REAL_NETWORK");
                            this.f29791h.a(15000, aVar2, (q) null, (e) null, (String) null);
                        }
                    }

                    @Override // com.bytedance.sdk.component.net.callback.NetCallback
                    public void onResponse(NetExecutor netExecutor, NetResponse netResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netExecutor, netResponse) == null) {
                            if (!netResponse.isSuccess() || netResponse.getFile() == null || !netResponse.getFile().exists()) {
                                this.f29791h.E = 3;
                                this.f29790g.b(-14).g(g.a(-14));
                                a aVar2 = new a(this.f29791h, 2, -14, g.a(-14), null, this.f29790g);
                                k.f("splashLoadAd", "视频文件缓存失败 response == null REQUEST_TYPE_REAL_NETWORK");
                                this.f29791h.a(15000, aVar2, (q) null, (e) null, (String) null);
                                c.a(this.f29789f, true, false, this.f29787d, netResponse.getCode(), netResponse);
                                return;
                            }
                            if (!this.f29784a) {
                                c.a(this.f29785b);
                                com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).a(this.f29785b);
                            }
                            com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).b(new q(this.f29786c, this.f29787d, null));
                            k.f("splashLoadAd", "视频文件获取成功, 尝试加载视频开屏");
                            com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).a(new q(this.f29786c, this.f29787d, null), new a.d(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.10.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass10 f29792a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f29792a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.component.splash.a.d
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        b bVar = this.f29792a.f29791h;
                                        bVar.a(15000, this.f29792a.f29788e + "");
                                    }
                                }
                            });
                            c.a(this.f29789f, true, true, this.f29787d, 0L, netResponse);
                        }
                    }
                });
                return;
            }
            k.f("splashLoadAd", "未下发视频文件，则加载图片完成后给予回调");
            a(aVar, context, cVar);
        }
    }

    private void a() {
        AdSlot adSlot;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.l == null || (adSlot = this.f29773a) == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        this.l.b(this.f29773a, this.f29774b);
    }

    private void a(int i2) {
        int g2;
        w wVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || (g2 = o.h().g(this.C)) >= i2 || g2 <= 0 || o.h().f(this.C) != 2 || (wVar = this.f29778f) == null) {
            return;
        }
        wVar.sendEmptyMessageDelayed(4, i2 - g2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, this, i2, str) == null) {
            k.f("splashLoadAd", "tryDisplaySplashAdFromCache rit " + str);
            if (this.l.b(str)) {
                this.l.a(str, new a.c(this, str, i2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f29813a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f29814b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ b f29815c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29815c = this;
                        this.f29813a = str;
                        this.f29814b = i2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                    public void a(@NonNull q qVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                            this.f29815c.B = qVar.a();
                            b bVar = this.f29815c;
                            bVar.b(bVar.B);
                            if (qVar.a() != null && qVar.a().V() != null && qVar.a().V().i() != null) {
                                String a2 = this.f29815c.l.a(qVar.a());
                                if (a2 == null) {
                                    k.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath == null tryDisplaySplashImageFromCache");
                                    this.f29815c.a(this.f29813a);
                                    return;
                                }
                                k.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath " + a2);
                                com.bytedance.sdk.openadsdk.j.a.c a3 = this.f29815c.a(4, qVar);
                                e a4 = this.f29815c.a(qVar, a2);
                                if (this.f29814b == 15000) {
                                    this.f29815c.n.set(!this.f29815c.a(qVar.a()));
                                } else {
                                    this.f29815c.j = a4;
                                }
                                this.f29815c.o.set(!this.f29815c.a(qVar.a()));
                                if (this.f29814b == 15000 || !this.f29815c.p) {
                                    this.f29815c.m.set(true);
                                    k.c("splashLoadAd", "不检测直接返回缓存....splashAd=" + a4);
                                    k.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess 加载视频缓存");
                                    b bVar2 = this.f29815c;
                                    bVar2.a(this.f29814b, new a(bVar2, 1, 0, null, a4, a3), qVar, a4, a2);
                                } else {
                                    this.f29815c.a(qVar, a4, a2);
                                }
                                if (this.f29815c.a(qVar.a())) {
                                    this.f29815c.a(qVar, a4, a2, a3, this.f29814b);
                                    return;
                                }
                                return;
                            }
                            k.f("splashLoadAd", "tryDisplaySplashAdFromCache videoPath == null tryDisplaySplashImageFromCache");
                            this.f29815c.a(this.f29813a);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f29815c.a(this.f29813a);
                        }
                    }
                });
            } else {
                a(str);
            }
        }
    }

    private void d(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65591, this, cVar) == null) {
            k.f("splashLoadAd", "reportMarkAtRespSucc outer_call_send");
            if (cVar == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            k.f("splashLoadAd", "reportMarkAtRespSucc sSplashLoadImageSource " + com.bytedance.sdk.openadsdk.k.a.c.f31646a);
            try {
                jSONObject.put("image_CacheType", com.bytedance.sdk.openadsdk.k.a.c.f31646a);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.j.a.a().c(cVar.b(jSONObject.toString()));
        }
    }

    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar)) == null) ? mVar != null && mVar.d() == 2 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.j.a.c a(int i2, q qVar) {
        InterceptResult invokeIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65547, this, i2, qVar)) == null) {
            String str3 = null;
            if (qVar == null || qVar.a() == null) {
                str = null;
                str2 = null;
            } else {
                str2 = qVar.a().ak();
                str = qVar.a().ao();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str3 = new JSONObject(str).getString(IAdRequestParam.REQ_ID);
                    } catch (Throwable unused) {
                    }
                }
            }
            if (str3 == null) {
                str3 = this.f29774b.f30200a;
            }
            com.bytedance.sdk.openadsdk.j.a.c c2 = com.bytedance.sdk.openadsdk.j.a.c.b().f(str3).a(i2).c(this.f29773a.getCodeId());
            if (str2 != null) {
                c2.d(str2);
            }
            if (str != null) {
                c2.h(str);
            }
            return c2;
        }
        return (com.bytedance.sdk.openadsdk.j.a.c) invokeIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65582, this, mVar) == null) || mVar == null || this.z == null) {
            return;
        }
        if (mVar.V() != null) {
            this.z.c(2);
        } else {
            this.z.c(1);
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65577, this, i2) == null) || this.z == null) {
            return;
        }
        if (i2 == 15000 && this.n.get()) {
            this.z.a("real_time_ad");
        } else {
            this.z.a("cache_ad");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, str) == null) {
            this.l.b(str, new a.c(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29816a;

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
                    this.f29816a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a(@NonNull q qVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                        com.bytedance.sdk.openadsdk.j.a.c a2 = this.f29816a.a(4, qVar);
                        this.f29816a.B = qVar.a();
                        b bVar = this.f29816a;
                        bVar.b(bVar.B);
                        if (!c.b(qVar)) {
                            if (this.f29816a.e()) {
                                k.b("splashLoadAd", "缓存广告素材解析出错");
                                b bVar2 = this.f29816a;
                                bVar2.a(bVar2.f29773a);
                                return;
                            }
                            b bVar3 = this.f29816a;
                            bVar3.a(15001, new a(bVar3, 2, 0, null, null, a2), qVar, (e) null, (String) null);
                            return;
                        }
                        qVar.a().b(true);
                        qVar.a().c(false);
                        this.f29816a.o.set(!this.f29816a.a(qVar.a()));
                        e a3 = this.f29816a.a(qVar, (String) null);
                        if (!this.f29816a.p) {
                            k.c("splashLoadAd", ".....不检测直接返回缓存....");
                            this.f29816a.m.set(true);
                            b bVar4 = this.f29816a;
                            bVar4.a(15001, new a(bVar4, 1, 0, null, a3, a2), qVar, a3, (String) null);
                        } else {
                            this.f29816a.a(qVar, a3, (String) null);
                        }
                        if (this.f29816a.a(qVar.a())) {
                            this.f29816a.a(qVar, a3, (String) null, a2, 15001);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k.b("splashLoadAd", "缓存广告对象解析出错");
                        if (!this.f29816a.e()) {
                            com.bytedance.sdk.openadsdk.j.a.c a2 = this.f29816a.a(4, (q) null);
                            b bVar = this.f29816a;
                            bVar.a(15001, new a(bVar, 2, 0, null, null, a2), (q) null, (e) null, (String) null);
                            return;
                        }
                        b bVar2 = this.f29816a;
                        bVar2.a(bVar2.f29773a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, adSlot) == null) {
            k.f("splashLoadAd", "try LoadSplashAdFromNetwork......");
            com.bytedance.sdk.openadsdk.j.a.c a2 = a(3, (q) null);
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                this.f29774b.f30204e = 2;
            }
            p pVar = this.f29776d;
            if (pVar instanceof com.bytedance.sdk.openadsdk.core.q) {
                ((com.bytedance.sdk.openadsdk.core.q) pVar).a(this.z);
            }
            this.f29776d.a(adSlot, this.f29774b, 3, new p.b(this, a2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29817a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29818b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29818b = this;
                    this.f29817a = a2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29817a.b(i2).g(str);
                        if (i2 == 20001) {
                            this.f29818b.E = 1;
                        } else {
                            this.f29818b.E = 0;
                        }
                        k.b("splashLoadAd", "tryLoadSplashAdFromNetwork REQUEST_TYPE_REAL_NETWORK onError" + i2 + ",msg=" + g.a(i2));
                        b bVar = this.f29818b;
                        bVar.a(15000, new a(bVar, 2, i2, str, null, this.f29817a), (q) null, (e) null, (String) null);
                        k.b("splashLoadAd", str + i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        this.f29818b.g();
                        this.f29818b.z.j(System.currentTimeMillis());
                        if (aVar != null) {
                            this.f29817a.f(aVar.a());
                        }
                        if (c.b(aVar)) {
                            m mVar = aVar.c().get(0);
                            String ao = mVar.ao();
                            String ak = mVar.ak();
                            this.f29818b.w = aVar;
                            if (!TextUtils.isEmpty(ao)) {
                                this.f29817a.h(ao).d(ak);
                                try {
                                    this.f29817a.f(new JSONObject(ao).optString(IAdRequestParam.REQ_ID));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            k.f("splashLoadAd", "tryLoadSplashAdFromNetwork splashAdMeta.isValid() " + mVar.aK());
                            if (mVar.aK()) {
                                this.f29818b.q = 0L;
                                this.f29818b.B = mVar;
                                this.f29818b.b(mVar);
                                this.f29818b.c(mVar);
                                int u = mVar.u();
                                int v = mVar.v();
                                com.bytedance.sdk.openadsdk.q.e.a(v);
                                k.f("splashLoadAd", " 开屏素材存储是否是内部存储还是外部存储 storageFrom " + v);
                                k.f("splashLoadAd", "tryLoadSplashAdFromNetwork cacheSort " + u);
                                if (u == 1) {
                                    b bVar = this.f29818b;
                                    bVar.a(aVar, bVar.f29777e, this.f29817a);
                                    return;
                                }
                                b bVar2 = this.f29818b;
                                bVar2.b(aVar, bVar2.f29777e, this.f29817a);
                                return;
                            }
                            this.f29818b.a(this.f29817a);
                            return;
                        }
                        this.f29818b.a(this.f29817a);
                    }
                }
            });
        }
    }

    private void b(com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, this, cVar) == null) {
            k.f("splashLoadAd", "onLogTimeoutEvent");
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "splash_timeout", cVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29811a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29812b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29812b = this;
                    this.f29811a = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29812b.c(this.f29811a);
                        com.bytedance.sdk.openadsdk.j.a.a().g(this.f29811a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, cVar) == null) {
            k.b("SplashAdLoadManager", "网络请求的广告解析失败");
            cVar.b(-3).g(g.a(-3));
            a aVar = new a(this, 2, -3, g.a(-3), null, cVar);
            this.E = 1;
            a(15000, aVar, (q) null, (e) null, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.e.a aVar, Context context, com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, this, aVar, context, cVar) == null) {
            k.f("splashLoadAd", " SplashUtils preLoadImage");
            if (!c.b(aVar) || context == null) {
                return;
            }
            m mVar = aVar.c().get(0);
            if (mVar.ad() == null || mVar.ad().size() <= 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.l lVar = mVar.ad().get(0);
            String a2 = lVar.a();
            k.b("splashLoadAd", "开屏加载的图片链接 url " + a2);
            int b2 = lVar.b();
            boolean z = mVar.V() != null;
            this.r = System.currentTimeMillis();
            this.s = SystemClock.elapsedRealtime();
            c.a(mVar, z ? 2 : 0);
            com.bytedance.sdk.openadsdk.k.d.b().d().a(this.z);
            com.bytedance.sdk.openadsdk.q.g.a(context, new com.bytedance.sdk.openadsdk.k.a(a2, lVar.g()), b2, new g.a(this, aVar, z, mVar, cVar, a2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f29819a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f29820b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ m f29821c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29822d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f29823e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f29824f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, Boolean.valueOf(z), mVar, cVar, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29824f = this;
                    this.f29819a = aVar;
                    this.f29820b = z;
                    this.f29821c = mVar;
                    this.f29822d = cVar;
                    this.f29823e = a2;
                }

                @Override // com.bytedance.sdk.openadsdk.q.g.a
                @MainThread
                public void a(@NonNull com.bytedance.sdk.openadsdk.k.a.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                        this.f29824f.a(bVar);
                        k.f("splashLoadAd", "图片加载成功");
                        c.a(this.f29819a);
                        this.f29824f.z.d(com.bytedance.sdk.openadsdk.k.a.c.f31646a);
                        if (!this.f29820b) {
                            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "preLoadImage") { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f29825a;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(r8);
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r8};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            super((String) newInitContext.callArgs[0]);
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f29825a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f29825a.f29821c, "splash_ad", System.currentTimeMillis() - this.f29825a.f29824f.r);
                                    }
                                }
                            }, 5);
                        }
                        if (!bVar.c()) {
                            this.f29824f.E = 3;
                            c.a(this.f29822d, this.f29823e);
                            this.f29822d.b(-7).g(com.bytedance.sdk.openadsdk.core.g.a(-7));
                            a aVar2 = new a(this.f29824f, 2, -7, com.bytedance.sdk.openadsdk.core.g.a(-7), null, this.f29822d);
                            k.b("splashLoadAd", "preLoadImage  data == null REQUEST_TYPE_REAL_NETWORK");
                            this.f29824f.E = 3;
                            this.f29824f.a(15000, aVar2, (q) null, (e) null, (String) null);
                            if (this.f29820b) {
                                c.a(this.f29824f.s, false, false, this.f29821c, -7, null);
                            }
                            k.b("SplashAdLoadManager", "图片加载失败");
                            return;
                        }
                        this.f29821c.c(false);
                        e eVar = new e(this.f29824f.f29777e, this.f29821c, this.f29824f.f29773a, "splash_ad");
                        this.f29824f.f29781i = eVar;
                        if (this.f29824f.D != null) {
                            this.f29824f.f29781i.c(this.f29824f.D);
                        }
                        eVar.a(bVar);
                        this.f29824f.n.set(this.f29821c.d() == 1);
                        this.f29824f.a(15000, new a(this.f29824f, 1, 0, null, eVar, this.f29822d), (q) null, eVar, (String) null);
                        if (this.f29824f.a(this.f29821c)) {
                            this.f29824f.a((q) null, eVar, (String) null, this.f29822d);
                        }
                        if (this.f29820b) {
                            c.a(this.f29824f.s, false, true, this.f29821c, 0L, null);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.q.g.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f29824f.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.q.g.a
                @MainThread
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.a(this.f29819a);
                        this.f29824f.E = 3;
                        c.a(this.f29822d, this.f29823e);
                        this.f29822d.b(-7).g(com.bytedance.sdk.openadsdk.core.g.a(-7));
                        k.b("splashLoadAd", "splashLoad----5-LoadImageBytes-onFailed-code=-7,msg=" + com.bytedance.sdk.openadsdk.core.g.a(-7));
                        b bVar = this.f29824f;
                        bVar.a(15000, new a(bVar, 2, -7, com.bytedance.sdk.openadsdk.core.g.a(-7), null, this.f29822d), (q) null, (e) null, (String) null);
                        if (this.f29820b) {
                            c.a(this.f29824f.s, false, false, this.f29821c, -7L, null);
                        }
                        k.b("SplashAdLoadManager", "图片加载失败");
                    }
                }
            }, true);
            a(context, mVar, b2);
        }
    }

    private void a(Context context, m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65553, this, context, mVar, i2) == null) || mVar == null) {
            return;
        }
        String O = mVar.O();
        if (TextUtils.isEmpty(O)) {
            return;
        }
        com.bytedance.sdk.openadsdk.q.g.a(context, new com.bytedance.sdk.openadsdk.k.a(O, ""), i2, new g.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f29826a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29826a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.q.g.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.g.a
            public void a(@NonNull com.bytedance.sdk.openadsdk.k.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && bVar.c()) {
                    this.f29826a.D = bVar;
                    if (this.f29826a.f29781i != null) {
                        this.f29826a.f29781i.c(bVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.q.g.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(q qVar, e eVar, String str, com.bytedance.sdk.openadsdk.j.a.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{qVar, eVar, str, cVar, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener(this, i2, eVar, cVar, qVar, str) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f29793a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f29794b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29795c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ q f29796d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f29797e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ b f29798f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), eVar, cVar, qVar, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29798f = this;
                        this.f29793a = i2;
                        this.f29794b = eVar;
                        this.f29795c = cVar;
                        this.f29796d = qVar;
                        this.f29797e = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i3) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i3) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str2, i3) == null) {
                            if (this.f29793a == 15000) {
                                this.f29798f.n.set(true);
                                k.b("splashLoadAd", "模版渲染--》onRenderFail msg: " + str2 + " code " + i3);
                            } else {
                                this.f29798f.o.set(true);
                                k.b("splashLoadAd", "缓存模版渲染--》onRenderFail msg: " + str2 + " code " + i3);
                            }
                            b bVar = this.f29798f;
                            bVar.a(this.f29793a, new a(bVar, 1, 0, null, this.f29794b, this.f29795c), this.f29796d, this.f29794b, this.f29797e);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            if (this.f29793a == 15000) {
                                this.f29798f.n.set(true);
                                k.b("splashLoadAd", "模版渲染--》onRenderSuccess start....= 实时 ");
                            } else {
                                this.f29798f.o.set(true);
                                k.b("splashLoadAd", "缓存模版渲染--》onRenderSuccess start....=缓存");
                            }
                            b bVar = this.f29798f;
                            bVar.a(this.f29793a, new a(bVar, 1, 0, null, this.f29794b, this.f29795c), this.f29796d, this.f29794b, this.f29797e);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(q qVar, e eVar, String str, com.bytedance.sdk.openadsdk.j.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, this, qVar, eVar, str, cVar) == null) {
            synchronized (this) {
                if (eVar == null) {
                    return;
                }
                eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener(this, qVar, eVar, cVar, str) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ q f29799a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f29800b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29801c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f29802d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ b f29803e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, qVar, eVar, cVar, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29803e = this;
                        this.f29799a = qVar;
                        this.f29800b = eVar;
                        this.f29801c = cVar;
                        this.f29802d = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str2, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str2, i2) == null) {
                            this.f29803e.n.set(true);
                            k.b("splashLoadAd", "实时模版渲染--》onRenderFail msg: " + str2 + " code " + i2);
                            int i3 = this.f29799a == null ? 15000 : 15001;
                            b bVar = this.f29803e;
                            bVar.a(i3, new a(bVar, 1, 0, null, this.f29800b, this.f29801c), this.f29799a, this.f29800b, this.f29802d);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            this.f29803e.n.set(true);
                            int i2 = this.f29799a == null ? 15000 : 15001;
                            StringBuilder sb = new StringBuilder();
                            sb.append("实时模版渲染--》onRenderSuccess start....=");
                            sb.append(i2 == 15000 ? "实时" : "缓存");
                            k.b("splashLoadAd", sb.toString());
                            b bVar = this.f29803e;
                            bVar.a(i2, new a(bVar, 1, 0, null, this.f29800b, this.f29801c), this.f29799a, this.f29800b, this.f29802d);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, this, qVar, eVar, str) == null) {
            k.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
            if (c.a(qVar)) {
                m a2 = qVar.a();
                o.f().a(a2.ak(), a2.ao(), new p.a(this, eVar, a(4, qVar), qVar, str) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f29804a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.j.a.c f29805b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ q f29806c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f29807d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ b f29808e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, eVar, r8, qVar, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29808e = this;
                        this.f29804a = eVar;
                        this.f29805b = r8;
                        this.f29806c = qVar;
                        this.f29807d = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(boolean z, long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            c.a(this.f29808e.f29773a, z, j, j2);
                            if (!z || this.f29808e.f29779g.get()) {
                                if (this.f29808e.e() && !this.f29808e.f29779g.get()) {
                                    k.b("splashLoadAd", "开屏视频缓存广告不在投放期并且开屏广告没有回调出去则加载");
                                    b bVar = this.f29808e;
                                    bVar.a(bVar.f29773a);
                                    return;
                                }
                                k.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
                                int i2 = (int) j;
                                this.f29805b.b(i2).g(com.bytedance.sdk.openadsdk.core.g.a(i2));
                                b bVar2 = this.f29808e;
                                bVar2.a(15001, new a(bVar2, 2, 0, null, null, this.f29805b), this.f29806c, (e) null, (String) null);
                                return;
                            }
                            k.b("splashLoadAd", "check 成功回调.......");
                            this.f29808e.m.set(true);
                            b bVar3 = this.f29808e;
                            bVar3.a(15001, new a(bVar3, 1, 0, null, this.f29804a, this.f29805b), this.f29806c, this.f29804a, this.f29807d);
                        }
                    }
                });
                return;
            }
            k.b("splashLoadAd", "checkAdFromServer check fail !!!!");
            if (e()) {
                k.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
                a(this.f29773a);
                return;
            }
            com.bytedance.sdk.openadsdk.j.a.c a3 = a(4, (q) null);
            k.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
            a(15001, new a(this, 2, 0, null, null, a3), qVar, (e) null, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
        if (r8.G.get() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        com.bytedance.sdk.component.utils.k.d("splashLoadAd", "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        com.bytedance.sdk.component.utils.k.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r8.m.get() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
        if (r8.n.get() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r8.o.get() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (r8.H == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
        com.bytedance.sdk.component.utils.k.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！");
        r8.z.a("cache_ad");
        a(r8.H);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0100, code lost:
        if (r8.m.get() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0108, code lost:
        if (r8.o.get() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
        com.bytedance.sdk.component.utils.k.d("splashLoadAd", "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0112, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i2, a aVar, q qVar, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i2), aVar, qVar, eVar, str}) == null) {
            synchronized (this) {
                boolean z = true;
                try {
                    if (i2 == 15000) {
                        k.f("splashLoadAd", "splashAdTryCallback start....实时请求来了！=" + eVar);
                        this.F.set(true);
                    } else if (i2 == 15001) {
                        k.f("splashLoadAd", "splashAdTryCallback start....缓存请求来了！=" + eVar);
                        this.G.set(true);
                    } else if (i2 == 15004) {
                        k.f("splashLoadAd", "splashAdTryCallback start....超时请求来了！=" + eVar);
                        this.E = 2;
                    } else if (i2 == 15003) {
                        k.f("splashLoadAd", "splashAdTryCallback start....渲染超时请求来了！=" + eVar);
                    }
                    if (this.f29779g.get()) {
                        k.f("splashLoadAd", "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！");
                    } else if (eVar == null) {
                        if (!this.t.get() && !this.u.get()) {
                            k.d("splashLoadAd", "普通类型走这，直接失败回调");
                            b(i2);
                            a(aVar);
                        }
                        if (i2 == 15001) {
                            if (!this.F.get()) {
                                k.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！");
                                return;
                            }
                            k.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！");
                        } else if (this.t.get() && i2 == 15004) {
                            k.d("splashLoadAd", "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>");
                            if (this.G.get()) {
                                if (!this.F.get()) {
                                    k.d("splashLoadAd", "如果实时已超时，实时是否渲染成功 " + this.n.get() + " 缓存渲染是否成功 " + this.o.get());
                                    if (this.m.get() && (this.n.get() || this.o.get())) {
                                        k.d("splashLoadAd", "如果实时已超时，缓存成功直接回调");
                                        this.z.a("cache_ad");
                                        a(this.H);
                                        return;
                                    }
                                    k.d("splashLoadAd", "如果实时已超时，直接失败回调");
                                }
                            } else {
                                k.d("splashLoadAd", "如果实时已超时，缓存也失败直接回调，直接失败回调");
                            }
                        }
                        b(i2);
                        a(aVar);
                    } else {
                        if (str == null && qVar != null && eVar != null) {
                            eVar.a(new com.bytedance.sdk.openadsdk.k.a.b(qVar.b()));
                        }
                        if (this.t.get() && i2 == 15001) {
                            if (this.G.get() && !this.F.get()) {
                                k.d("splashLoadAd", "如果缓存先回来,实时还没有回来，实时是否渲染成功 " + this.n.get() + " 缓存渲染是否成功 " + this.o.get());
                                if (this.m.get() && this.o.get()) {
                                    k.d("splashLoadAd", "缓存赋值给resultTemp");
                                    this.H = aVar;
                                    k.d("splashLoadAd", "如果缓存先回来,实时还没有回来，等待实时回来");
                                    return;
                                }
                            }
                            if (this.F.get() && this.f29781i != null && this.f29781i.b()) {
                                k.d("splashLoadAd", "此时实时可能在渲染，避免缓存的渲染成功后直接被回调");
                                return;
                            }
                        }
                        if (i2 == 15000) {
                            k.d("splashLoadAd", "splashAdTryCallback 实时或渲染成功回调......！");
                        }
                        if (this.t.get() && i2 == 15000 && !this.n.get()) {
                            k.b("splashLoadAd", "优先实时，且实时类型广告图片加载成功；如果是模板广告且渲染未成功，则继续等待");
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("splashAdTryCallback..（ 是否缓存已check成功：");
                        sb.append(this.m.get());
                        sb.append(" || 是否渲染超时：");
                        sb.append(i2 == 15003);
                        sb.append(" || 是否为实时请求");
                        if (i2 != 15000) {
                            z = false;
                        }
                        sb.append(z);
                        sb.append("） && （是否实时模版渲染完成：");
                        sb.append(this.n.get());
                        sb.append(" || 是否缓存模版渲染完成：");
                        sb.append(this.o.get());
                        sb.append("）");
                        k.b("splashLoadAd", sb.toString());
                        if ((this.m.get() || i2 == 15000 || i2 == 15003) && (this.n.get() || this.o.get())) {
                            b(i2);
                            a(aVar);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, bVar) == null) || bVar == null || this.z == null) {
            return;
        }
        byte[] b2 = bVar.b();
        if (b2 != null && this.z.i() == 0.0d) {
            this.z.a(b2.length / 1024.0f);
        }
        Bitmap a2 = bVar.a();
        if (a2 != null && TextUtils.isEmpty(this.z.j())) {
            this.z.b(a2.getWidth() + "X" + a2.getHeight());
        }
        Map<String, String> e2 = bVar.e();
        if (e2 == null || e2.size() <= 0 || this.z.k() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : e2.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, e2.get(str));
                } catch (Exception e3) {
                    k.f("SplashAdLoadManager", e3.getMessage());
                }
            }
        }
        this.z.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(q qVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, qVar, str)) == null) {
            if (c.a(qVar)) {
                if (!TextUtils.isEmpty(str)) {
                    qVar.a().c(true);
                }
                e eVar = new e(this.f29777e, qVar.a(), str, this.f29773a, "splash_ad");
                if (TextUtils.isEmpty(str)) {
                    this.f29780h = eVar;
                }
                return eVar;
            }
            return null;
        }
        return (e) invokeLL.objValue;
    }

    private synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, aVar) == null) {
            synchronized (this) {
                k.f("splashLoadAd", "onCallback ......");
                i();
                if (aVar == null) {
                    k.a("splashAdListener is null, then return");
                    k.remove(this);
                } else if (this.f29775c == null) {
                    k.a("splashAdListener is null, then return");
                    if (aVar.f29827a == 3) {
                        b(aVar.f29831e);
                    }
                    k.remove(this);
                } else if (!this.f29779g.get()) {
                    this.f29779g.set(true);
                    int i2 = aVar.f29827a;
                    if (i2 == 1) {
                        d(aVar.f29831e);
                        this.f29775c.onSplashAdLoad(aVar.f29830d);
                        d(this.B);
                    } else if (i2 == 2) {
                        k.f("splashLoadAd", "onCallback CALLBACK_RESULT_FAILED");
                        com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g(this, "onCallback", aVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a f29809a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ b f29810b;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r8);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r8, aVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        super((String) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f29810b = this;
                                this.f29809a = aVar;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f29810b.c(this.f29809a.f29831e);
                                }
                            }
                        });
                        this.f29775c.onError(aVar.f29828b, aVar.f29829c);
                    } else if (i2 != 3) {
                        this.f29775c.onError(-2, com.bytedance.sdk.openadsdk.core.g.a(-2));
                    } else {
                        k.f("splashLoadAd", "onCallback CALLBACK_RESULT_TIMEOUT");
                        b(aVar.f29831e);
                        this.f29775c.onTimeout();
                    }
                    if (this.f29778f != null) {
                        this.f29778f.removeMessages(2);
                        this.f29778f.removeMessages(4);
                    }
                    this.f29775c = null;
                    k.remove(this);
                } else {
                    this.f29775c = null;
                    if (aVar.f29827a == 3) {
                        b(aVar.f29831e);
                    }
                    k.remove(this);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            if (message.what == 1) {
                if (!this.f29779g.get()) {
                    this.f29779g.set(true);
                    b();
                    k.b("SplashAdLoadManager", "尝试从缓存中取");
                } else {
                    i();
                    k.b("SplashAdLoadManager", "开始预加载");
                }
                this.f29778f.removeCallbacksAndMessages(null);
            }
            if (message.what == 2) {
                this.f29778f.removeCallbacksAndMessages(null);
                if (this.f29779g.get()) {
                    return;
                }
                k.b("splashLoadAd", "MSG_USER_TIME_OUT----7-");
                a(15004, new a(this, 3, 0, null, null, a(0, (q) null)), (q) null, (e) null, (String) null);
            }
            if (message.what == 4) {
                k.b("splashLoadAd", "handleMsg MSG_SPLASH_TIME_OUT ");
                this.f29778f.removeMessages(4);
                if (this.f29779g.get()) {
                    return;
                }
                this.n.set(true);
                this.o.set(true);
                m mVar = this.B;
                if (mVar == null) {
                    return;
                }
                boolean au = mVar.au();
                com.bytedance.sdk.openadsdk.j.a.c a2 = a(3, (q) null);
                if (au) {
                    e eVar = this.j;
                    if (eVar == null) {
                        return;
                    }
                    String a3 = eVar.a();
                    k.b("splashLoadAd", "MSG_SPLASH_TIME_OUT videoCachePath " + a3);
                    a(15003, new a(this, 1, 0, null, eVar, a2), (q) null, eVar, a3);
                } else {
                    e eVar2 = this.f29780h;
                    if (eVar2 == null) {
                        return;
                    }
                    a(15003, new a(this, 1, 0, null, eVar2, a2), (q) null, eVar2, (String) null);
                }
            }
            if (message.what == 5) {
                j();
            }
        }
    }
}
