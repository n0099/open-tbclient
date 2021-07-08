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
import com.bytedance.sdk.component.adnet.b.b;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.u;
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
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.r.f;
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
public class b implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public static Set<b> l;
    public transient /* synthetic */ FieldHolder $fh;
    public t A;
    public boolean B;
    public m C;
    public int D;
    public com.bytedance.sdk.openadsdk.l.a.d E;
    public int F;
    public AtomicBoolean G;
    public AtomicBoolean H;
    public a I;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f29676a;

    /* renamed from: b  reason: collision with root package name */
    public n f29677b;

    /* renamed from: c  reason: collision with root package name */
    public TTAdNative.SplashAdListener f29678c;

    /* renamed from: d  reason: collision with root package name */
    public final p f29679d;

    /* renamed from: e  reason: collision with root package name */
    public Context f29680e;

    /* renamed from: f  reason: collision with root package name */
    public final u f29681f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f29682g;

    /* renamed from: h  reason: collision with root package name */
    public e f29683h;

    /* renamed from: i  reason: collision with root package name */
    public e f29684i;
    public e j;
    public e k;
    public com.bytedance.sdk.openadsdk.component.splash.a m;
    public AtomicBoolean n;
    public AtomicBoolean o;
    public AtomicBoolean p;
    public boolean q;
    public long r;
    public long s;
    public long t;
    public final AtomicBoolean u;
    public final AtomicBoolean v;
    public com.bytedance.sdk.openadsdk.core.e.a w;
    public com.bytedance.sdk.openadsdk.core.e.a x;
    public com.bytedance.sdk.openadsdk.k.a.c y;
    public int z;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29731a;

        /* renamed from: b  reason: collision with root package name */
        public int f29732b;

        /* renamed from: c  reason: collision with root package name */
        public String f29733c;

        /* renamed from: d  reason: collision with root package name */
        public TTSplashAd f29734d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.k.a.c f29735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f29736f;

        public a(b bVar, int i2, int i3, String str, TTSplashAd tTSplashAd, com.bytedance.sdk.openadsdk.k.a.c cVar) {
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
            this.f29736f = bVar;
            this.f29731a = i2;
            this.f29732b = i3;
            this.f29733c = str;
            this.f29734d = tTSplashAd;
            this.f29735e = cVar;
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
        l = Collections.synchronizedSet(new HashSet());
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
        this.f29678c = null;
        this.f29682g = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.t = 0L;
        this.u = new AtomicBoolean(false);
        this.v = new AtomicBoolean(false);
        this.z = 0;
        this.B = false;
        this.F = 4;
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(false);
        if (context != null) {
            this.f29680e = context.getApplicationContext();
        }
        this.f29679d = o.f();
        this.f29681f = new u(Looper.getMainLooper(), this);
        Context context2 = this.f29680e;
        this.m = com.bytedance.sdk.openadsdk.component.splash.a.a(context2 == null ? o.a() : context2);
        this.q = o.h().t();
        l.add(this);
        f();
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
            j.f("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
            com.bytedance.sdk.openadsdk.k.a.c a2 = a(15001, (q) null);
            if (!this.m.b(this.f29676a.getCodeId()) && !this.m.a(this.f29676a.getCodeId())) {
                j.f("splashLoadAd", "没有缓存数据..........");
                if (this.u.get() || this.v.get()) {
                    a(15001, new a(this, 2, -12, g.a(-12), null, a2), (q) null, (e) null, (String) null);
                }
                this.z = 0;
                return false;
            } else if (this.m.a(this.f29676a, true)) {
                j.b("splashLoadAd", "======== 缓存过期 ========");
                if (this.u.get() || this.v.get()) {
                    a(15001, new a(this, 2, -11, g.a(-11), null, a2), (q) null, (e) null, (String) null);
                }
                this.z = 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            int f2 = o.h().f(this.D);
            return (2 == f2 || 3 == f2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            t tVar = new t();
            this.A = tVar;
            tVar.m(System.currentTimeMillis());
            if (l.f30347f.get()) {
                this.A.b(0);
                l.f30347f.set(false);
                return;
            }
            this.A.b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65598, this) == null) || this.A == null) {
            return;
        }
        this.A.a(System.currentTimeMillis() - this.A.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65601, this) == null) || this.f29680e == null || this.C == null || this.A == null || !o.h().v()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(OkHttpNetworkFetcher.IMAGE_SIZE, this.A.i());
            jSONObject.put("image_resolution", this.A.j());
            jSONObject.put("image_response_header", this.A.k());
            jSONObject.put("download_client_start_time", this.A.p());
            jSONObject.put("download_net_time", this.A.q());
            jSONObject.put("download_write_time", this.A.r());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.f29680e, this.C, "splash_ad", "download_image_duration", this.A.f(), jSONObject);
    }

    private void i() {
        com.bytedance.sdk.openadsdk.component.splash.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65602, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.a(this.f29676a, this.f29677b);
    }

    private void j() {
        com.bytedance.sdk.openadsdk.core.e.a aVar;
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65604, this) == null) || (aVar = this.w) == null || this.y == null || aVar.c() == null || this.w.c().size() == 0 || (mVar = this.w.c().get(0)) == null || mVar.u() != 3) {
            return;
        }
        q qVar = new q(this.w, mVar, null);
        if (mVar.V() == null) {
            return;
        }
        String i2 = mVar.V().i();
        if (TextUtils.isEmpty(i2)) {
            return;
        }
        e a2 = a(qVar, i2);
        a(15003, new a(this, 1, 0, null, a2, this.y), qVar, a2, i2);
    }

    private n k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            n nVar = new n();
            nVar.f30105f = currentTimeMillis;
            return nVar;
        }
        return (n) invokeV.objValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, this)) == null) {
            if (d()) {
                a(15001, this.f29676a.getCodeId());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65587, this, mVar) == null) && mVar != null && mVar.V() == null) {
            int f2 = o.h().f(this.D);
            this.B = f2 == 0 || f2 == 2;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || this.f29678c == null) {
            return;
        }
        int f2 = o.h().f(this.D);
        this.A.a(f2);
        if (f2 == 0) {
            this.u.set(false);
            this.v.set(false);
            j.b("splashLoadAd", "splash_type_real_time=====只走实时");
            a(this.f29676a);
        } else if (f2 == 1) {
            this.u.set(false);
            this.v.set(false);
            j.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
            if (!c()) {
                j.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                a(this.f29676a);
                return;
            }
            j.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
        } else if (f2 == 2) {
            j.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
            this.u.set(true);
            this.v.set(false);
            a(this.f29676a);
            c();
        } else if (f2 != 3) {
        } else {
            this.u.set(false);
            this.v.set(true);
            j.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
            a(this.f29676a);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, this, cVar) == null) {
            j.f("splashLoadAd", "reportMarkAtRespFail outer_call_no_rsp");
            if (cVar == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (d()) {
                i2 = 1;
            } else {
                i2 = this.z;
                if (i2 == 2) {
                    c.a(this.f29680e, this.f29676a);
                }
            }
            j.f("splashLoadAd", "reportMarkAtRespFail cacheStatus " + i2);
            try {
                jSONObject.put("if_have_cache", i2);
                jSONObject.put("if_have_rt_ads", this.F);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.k.a.a().d(cVar.b(jSONObject.toString()));
        }
    }

    private void d(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65591, this, mVar) == null) || this.f29680e == null || mVar == null || this.A == null || !o.h().v()) {
            return;
        }
        boolean M = o.h().M();
        boolean w = this.A.w();
        long currentTimeMillis = System.currentTimeMillis();
        if (w) {
            this.A.c(currentTimeMillis - this.A.t());
        } else {
            t tVar = this.A;
            tVar.k(currentTimeMillis - tVar.y());
            this.A.o(currentTimeMillis - this.A.t());
        }
        JSONObject jSONObject = new JSONObject();
        if (M) {
            try {
                jSONObject.put("pre_connect_status", l.f30345d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("if_pre_connect", M ? 1 : 0);
        jSONObject.put("splash_load_type", this.A.a());
        jSONObject.put("splash_final_type", this.A.b());
        jSONObject.put("active_type", this.A.c());
        jSONObject.put("splash_creative_type", this.A.d());
        jSONObject.put("splash_load_type", this.A.a());
        if (this.B) {
            jSONObject.put("load_duration", this.A.e());
            jSONObject.put("download_image_duration", this.A.x());
            jSONObject.put("cache_image_duration", this.A.g());
            jSONObject.put("image_cachetype", this.A.h());
            jSONObject.put(OkHttpNetworkFetcher.IMAGE_SIZE, this.A.i());
            jSONObject.put("image_resolution", this.A.j());
            jSONObject.put("image_response_header", this.A.k());
            jSONObject.put("client_start_time", this.A.l());
            jSONObject.put("network_time", this.A.m());
            jSONObject.put("sever_time", this.A.n());
            jSONObject.put("client_end_time", this.A.o());
            jSONObject.put("download_client_start_time", this.A.p());
            jSONObject.put("download_net_time", this.A.q());
            jSONObject.put("download_write_time", this.A.r());
            jSONObject.put("download_client_end_time", this.A.s());
        }
        com.bytedance.sdk.openadsdk.e.d.a(this.f29680e, mVar, "splash_ad", "splash_ad_loadtime", currentTimeMillis - this.A.u(), jSONObject);
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    public void a(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot, splashAdListener, i2) == null) {
            this.f29677b = k();
            this.f29676a = adSlot;
            this.f29678c = splashAdListener;
            this.f29682g.set(false);
            this.f29683h = null;
            this.f29684i = null;
            this.j = null;
            this.k = null;
            j.b("splashLoadAd", "开发者传入的超时时长 timeOut " + i2);
            this.D = com.bytedance.sdk.openadsdk.r.o.a(adSlot);
            long j = (long) i2;
            int c2 = o.h().c(adSlot.getCodeId());
            j.b("splashLoadAd", "云控的超时时长 cloudTimeOut " + c2);
            if (c2 > 0) {
                j.b("splashLoadAd", "云控控制的超时时长大于0比较 较服务端下发的超时时长和开发者配置的超时时长 ");
                if (c2 >= i2) {
                    i2 = c2;
                }
            } else if (i2 < 500) {
                i2 = 500;
            }
            j.f("splashLoadAd", "getSplashAd 实际 timeOut " + i2);
            long j2 = (long) i2;
            this.f29681f.sendEmptyMessageDelayed(2, j2);
            int i3 = i2 + (-300);
            if (i3 > 0) {
                this.f29681f.sendEmptyMessageDelayed(5, i3);
            }
            a(i2);
            n nVar = this.f29677b;
            nVar.f30106g = j;
            nVar.f30107h = c2;
            nVar.f30108i = j2;
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "getSplashAd", j) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f29685a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29686b;

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
                    this.f29686b = this;
                    this.f29685a = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("publisher_timeout_control", this.f29685a);
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.k.a.a().b(com.bytedance.sdk.openadsdk.k.a.c.b().a(3).c(this.f29686b.f29676a.getCodeId()).g(this.f29686b.f29677b.f30100a).b(jSONObject.toString()));
                    }
                }
            });
            b();
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.openadsdk.core.e.a aVar, Context context, com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65581, this, aVar, context, cVar) == null) {
            j.f("splashLoadAd", " SplashUtils preLoadVideo");
            if (!c.b(aVar) || context == null) {
                return;
            }
            m mVar = aVar.c().get(0);
            int d2 = com.bytedance.sdk.openadsdk.r.o.d(mVar.ao());
            x V = mVar.V();
            c.a(mVar, V != null ? 2 : 0);
            if (V != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String i2 = V.i();
                j.f("splashLoadAd", "SplashUtils preLoadVideo videoUrl " + i2);
                if (i2 == null) {
                    a(aVar, context, cVar);
                    return;
                }
                this.w = aVar;
                this.y = cVar;
                c.a(mVar, 1);
                String l2 = V.l();
                if (TextUtils.isEmpty(l2)) {
                    l2 = com.bytedance.sdk.component.utils.e.a(i2);
                }
                String str = l2;
                boolean aN = mVar.aN();
                File a2 = c.a(str, d2, aN);
                if (o.h().e(String.valueOf(d2)) && !com.bytedance.sdk.component.utils.m.d(o.a())) {
                    if (str != null && a2.exists()) {
                        j.b("splashLoadAd", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                        com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).b(new q(aVar, mVar, null));
                        a(15000, d2 + "");
                        return;
                    }
                    j.b("splashLoadAd", "非wifi环境");
                    return;
                }
                com.bytedance.sdk.openadsdk.l.e.b().a(i2, new b.a(this, aN, a2, str, aVar, mVar, d2, elapsedRealtime, cVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f29687a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ File f29688b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f29689c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f29690d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ m f29691e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ int f29692f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ long f29693g;

                    /* renamed from: h  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29694h;

                    /* renamed from: i  reason: collision with root package name */
                    public final /* synthetic */ b f29695i;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(aN), a2, str, aVar, mVar, Integer.valueOf(d2), Long.valueOf(elapsedRealtime), cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29695i = this;
                        this.f29687a = aN;
                        this.f29688b = a2;
                        this.f29689c = str;
                        this.f29690d = aVar;
                        this.f29691e = mVar;
                        this.f29692f = d2;
                        this.f29693g = elapsedRealtime;
                        this.f29694h = cVar;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File a(String str2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str2)) == null) {
                            try {
                                if (this.f29687a && this.f29688b.exists() && this.f29688b.length() > 0) {
                                    j.b("SplashAdLoadManager", "get ad from brand video cache！");
                                    return this.f29688b;
                                }
                                File parentFile = this.f29688b.getParentFile();
                                if (parentFile == null || !parentFile.exists()) {
                                    return null;
                                }
                                j.b("splashLoadAd", "SplashAdLoadManager getFile " + str2);
                                c.a(this.f29688b);
                                return h.d().s().a(this.f29689c, parentFile);
                            } catch (IOException e2) {
                                j.f("splashLoadAd", "datastoreGet throw IOException : " + e2.toString());
                                return null;
                            }
                        }
                        return (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.c.a
                    public void a(long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public File b(String str2) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, str2)) == null) ? this.f29688b : (File) invokeL.objValue;
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void b(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, mVar2) == null) {
                            this.f29695i.F = 3;
                            c.a(this.f29693g, true, false, this.f29691e, mVar2 == null ? -2L : mVar2.f28038h, mVar2);
                            this.f29694h.b(-14).h(g.a(-14));
                            a aVar2 = new a(this.f29695i, 2, -14, g.a(-14), null, this.f29694h);
                            j.f("splashLoadAd", "视频文件缓存失败 onErrorResponse REQUEST_TYPE_REAL_NETWORK");
                            this.f29695i.a(15000, aVar2, (q) null, (e) null, (String) null);
                        }
                    }

                    @Override // com.bytedance.sdk.component.adnet.b.b.a
                    public void a(String str2, File file) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048579, this, str2, file) == null) || file == null || this.f29687a) {
                            return;
                        }
                        j.b("splashLoadAd", "SplashAdLoadManager 视频文件下载成功保存到本地 putFile s " + str2 + " File " + file.getPath());
                        c.a(file);
                        com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).a(file);
                    }

                    @Override // com.bytedance.sdk.component.adnet.core.m.a
                    public void a(com.bytedance.sdk.component.adnet.core.m<File> mVar2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar2) == null) {
                            if (mVar2 == null || mVar2.f28031a == null) {
                                this.f29695i.F = 3;
                                this.f29694h.b(-14).h(g.a(-14));
                                a aVar2 = new a(this.f29695i, 2, -14, g.a(-14), null, this.f29694h);
                                j.f("splashLoadAd", "视频文件缓存失败 response == null REQUEST_TYPE_REAL_NETWORK");
                                this.f29695i.a(15000, aVar2, (q) null, (e) null, (String) null);
                                c.a(this.f29693g, true, false, this.f29691e, mVar2 == null ? -3L : mVar2.f28038h, mVar2);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).b(new q(this.f29690d, this.f29691e, null));
                            j.f("splashLoadAd", "视频文件获取成功, 尝试加载视频开屏");
                            com.bytedance.sdk.openadsdk.component.splash.a.a(o.a()).a(new q(this.f29690d, this.f29691e, null), new a.d(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.10.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass10 f29696a;

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
                                    this.f29696a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.component.splash.a.d
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        b bVar = this.f29696a.f29695i;
                                        bVar.a(15000, this.f29696a.f29692f + "");
                                    }
                                }
                            });
                            c.a(this.f29693g, true, true, this.f29691e, 0L, mVar2);
                        }
                    }
                });
                return;
            }
            j.f("splashLoadAd", "未下发视频文件，则加载图片完成后给予回调");
            a(aVar, context, cVar);
        }
    }

    private void a() {
        AdSlot adSlot;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.m == null || (adSlot = this.f29676a) == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        this.m.b(this.f29676a, this.f29677b);
    }

    private void a(int i2) {
        int g2;
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65550, this, i2) == null) || (g2 = o.h().g(this.D)) >= i2 || g2 <= 0 || o.h().f(this.D) != 2 || (uVar = this.f29681f) == null) {
            return;
        }
        uVar.sendEmptyMessageDelayed(4, i2 - g2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, this, i2, str) == null) {
            j.f("splashLoadAd", "tryDisplaySplashAdFromCache rit " + str);
            if (this.m.b(str)) {
                this.m.a(str, new a.c(this, str, i2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f29717a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f29718b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ b f29719c;

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
                        this.f29719c = this;
                        this.f29717a = str;
                        this.f29718b = i2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                    public void a(@NonNull q qVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                            this.f29719c.C = qVar.a();
                            b bVar = this.f29719c;
                            bVar.b(bVar.C);
                            if (qVar.a() != null && qVar.a().V() != null && qVar.a().V().i() != null) {
                                String a2 = this.f29719c.m.a(qVar.a());
                                if (a2 == null) {
                                    j.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath == null tryDisplaySplashImageFromCache");
                                    this.f29719c.a(this.f29717a);
                                    return;
                                }
                                j.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath " + a2);
                                com.bytedance.sdk.openadsdk.k.a.c a3 = this.f29719c.a(4, qVar);
                                e a4 = this.f29719c.a(qVar, a2);
                                if (this.f29718b == 15000) {
                                    this.f29719c.o.set(!this.f29719c.a(qVar.a()));
                                    this.f29719c.k = a4;
                                } else {
                                    this.f29719c.j = a4;
                                }
                                this.f29719c.p.set(!this.f29719c.a(qVar.a()));
                                if (this.f29718b == 15000 || !this.f29719c.q) {
                                    this.f29719c.n.set(true);
                                    j.c("splashLoadAd", "不检测直接返回缓存....splashAd=" + a4);
                                    j.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess 加载视频缓存");
                                    b bVar2 = this.f29719c;
                                    bVar2.a(this.f29718b, new a(bVar2, 1, 0, null, a4, a3), qVar, a4, a2);
                                } else {
                                    this.f29719c.a(qVar, a4, a2);
                                }
                                if (this.f29719c.a(qVar.a())) {
                                    this.f29719c.a(qVar, a4, a2, a3, this.f29718b);
                                    return;
                                }
                                return;
                            }
                            j.f("splashLoadAd", "tryDisplaySplashAdFromCache videoPath == null tryDisplaySplashImageFromCache");
                            this.f29719c.a(this.f29717a);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f29719c.a(this.f29717a);
                        }
                    }
                });
            } else {
                a(str);
            }
        }
    }

    private void d(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, this, cVar) == null) {
            j.f("splashLoadAd", "reportMarkAtRespSucc outer_call_send");
            if (cVar == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            j.f("splashLoadAd", "reportMarkAtRespSucc sSplashLoadImageSource " + com.bytedance.sdk.openadsdk.l.a.b.f31406a);
            try {
                jSONObject.put("image_CacheType", com.bytedance.sdk.openadsdk.l.a.b.f31406a);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.k.a.a().c(cVar.b(jSONObject.toString()));
        }
    }

    public boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar)) == null) ? mVar != null && mVar.d() == 2 : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.k.a.c a(int i2, q qVar) {
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
                str3 = this.f29677b.f30100a;
            }
            com.bytedance.sdk.openadsdk.k.a.c c2 = com.bytedance.sdk.openadsdk.k.a.c.b().g(str3).a(i2).c(this.f29676a.getCodeId());
            if (str2 != null) {
                c2.d(str2);
            }
            if (str != null) {
                c2.i(str);
            }
            return c2;
        }
        return (com.bytedance.sdk.openadsdk.k.a.c) invokeIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65582, this, mVar) == null) || mVar == null || this.A == null) {
            return;
        }
        if (mVar.V() != null) {
            this.A.c(2);
        } else {
            this.A.c(1);
        }
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65577, this, i2) == null) || this.A == null) {
            return;
        }
        if (i2 == 15000 && this.o.get()) {
            this.A.a("real_time_ad");
        } else {
            this.A.a("cache_ad");
        }
    }

    private void b(com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65583, this, cVar) == null) {
            j.f("splashLoadAd", "onLogTimeoutEvent");
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "splash_timeout", cVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29715a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29716b;

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
                    this.f29716b = this;
                    this.f29715a = cVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29716b.c(this.f29715a);
                        com.bytedance.sdk.openadsdk.k.a.a().g(this.f29715a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, str) == null) {
            this.m.b(str, new a.c(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29720a;

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
                    this.f29720a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a(@NonNull q qVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                        com.bytedance.sdk.openadsdk.k.a.c a2 = this.f29720a.a(4, qVar);
                        this.f29720a.C = qVar.a();
                        b bVar = this.f29720a;
                        bVar.b(bVar.C);
                        if (!c.b(qVar)) {
                            if (this.f29720a.e()) {
                                j.b("splashLoadAd", "缓存广告素材解析出错");
                                b bVar2 = this.f29720a;
                                bVar2.a(bVar2.f29676a);
                                return;
                            }
                            b bVar3 = this.f29720a;
                            bVar3.a(15001, new a(bVar3, 2, 0, null, null, a2), qVar, (e) null, (String) null);
                            return;
                        }
                        qVar.a().b(true);
                        qVar.a().c(false);
                        this.f29720a.p.set(!this.f29720a.a(qVar.a()));
                        e a3 = this.f29720a.a(qVar, (String) null);
                        if (!this.f29720a.q) {
                            j.c("splashLoadAd", ".....不检测直接返回缓存....");
                            this.f29720a.n.set(true);
                            b bVar4 = this.f29720a;
                            bVar4.a(15001, new a(bVar4, 1, 0, null, a3, a2), qVar, a3, (String) null);
                        } else {
                            this.f29720a.a(qVar, a3, (String) null);
                        }
                        if (this.f29720a.a(qVar.a())) {
                            this.f29720a.a(qVar, a3, (String) null, a2, 15001);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        j.b("splashLoadAd", "缓存广告对象解析出错");
                        if (!this.f29720a.e()) {
                            com.bytedance.sdk.openadsdk.k.a.c a2 = this.f29720a.a(4, (q) null);
                            b bVar = this.f29720a;
                            bVar.a(15001, new a(bVar, 2, 0, null, null, a2), (q) null, (e) null, (String) null);
                            return;
                        }
                        b bVar2 = this.f29720a;
                        bVar2.a(bVar2.f29676a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, adSlot) == null) {
            j.f("splashLoadAd", "try LoadSplashAdFromNetwork......");
            com.bytedance.sdk.openadsdk.k.a.c a2 = a(3, (q) null);
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                this.f29677b.f30104e = 2;
            }
            p pVar = this.f29679d;
            if (pVar instanceof com.bytedance.sdk.openadsdk.core.q) {
                ((com.bytedance.sdk.openadsdk.core.q) pVar).a(this.A);
            }
            this.f29679d.a(adSlot, this.f29677b, 3, new p.b(this, a2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29721a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f29722b;

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
                    this.f29722b = this;
                    this.f29721a = a2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f29721a.b(i2).h(str);
                        if (i2 == 20001) {
                            this.f29722b.F = 1;
                        } else {
                            this.f29722b.F = 0;
                        }
                        j.b("splashLoadAd", "tryLoadSplashAdFromNetwork REQUEST_TYPE_REAL_NETWORK onError" + i2 + ",msg=" + g.a(i2));
                        b bVar = this.f29722b;
                        bVar.a(15000, new a(bVar, 2, i2, str, null, this.f29721a), (q) null, (e) null, (String) null);
                        j.b("splashLoadAd", str + i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        this.f29722b.g();
                        this.f29722b.A.l(System.currentTimeMillis());
                        if (aVar != null) {
                            this.f29721a.g(aVar.a());
                        }
                        if (c.b(aVar)) {
                            m mVar = aVar.c().get(0);
                            String ao = mVar.ao();
                            String ak = mVar.ak();
                            this.f29722b.x = aVar;
                            if (!TextUtils.isEmpty(ao)) {
                                this.f29721a.i(ao).d(ak);
                                try {
                                    this.f29721a.g(new JSONObject(ao).optString(IAdRequestParam.REQ_ID));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            j.f("splashLoadAd", "tryLoadSplashAdFromNetwork splashAdMeta.isValid() " + mVar.aK());
                            if (mVar.aK()) {
                                this.f29722b.r = 0L;
                                this.f29722b.C = mVar;
                                this.f29722b.b(mVar);
                                this.f29722b.c(mVar);
                                int u = mVar.u();
                                int v = mVar.v();
                                com.bytedance.sdk.openadsdk.r.d.a(v);
                                j.f("splashLoadAd", " 开屏素材存储是否是内部存储还是外部存储 storageFrom " + v);
                                j.f("splashLoadAd", "tryLoadSplashAdFromNetwork cacheSort " + u);
                                if (u == 1) {
                                    b bVar = this.f29722b;
                                    bVar.a(aVar, bVar.f29680e, this.f29721a);
                                    return;
                                }
                                b bVar2 = this.f29722b;
                                bVar2.b(aVar, bVar2.f29680e, this.f29721a);
                                return;
                            }
                            this.f29722b.a(this.f29721a);
                            return;
                        }
                        this.f29722b.a(this.f29721a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, this, cVar) == null) {
            j.b("SplashAdLoadManager", "网络请求的广告解析失败");
            cVar.b(-3).h(g.a(-3));
            a aVar = new a(this, 2, -3, g.a(-3), null, cVar);
            this.F = 1;
            a(15000, aVar, (q) null, (e) null, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.e.a aVar, Context context, com.bytedance.sdk.openadsdk.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, this, aVar, context, cVar) == null) {
            j.f("splashLoadAd", " SplashUtils preLoadImage");
            if (!c.b(aVar) || context == null) {
                return;
            }
            m mVar = aVar.c().get(0);
            if (mVar.ad() == null || mVar.ad().size() <= 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.e.l lVar = mVar.ad().get(0);
            String a2 = lVar.a();
            j.b("splashLoadAd", "开屏加载的图片链接 url " + a2);
            int b2 = lVar.b();
            boolean z = mVar.V() != null;
            this.s = System.currentTimeMillis();
            this.t = SystemClock.elapsedRealtime();
            c.a(mVar, z ? 2 : 0);
            com.bytedance.sdk.openadsdk.l.e.b().e().a(this.A);
            f.a(context, new com.bytedance.sdk.openadsdk.l.b(a2, lVar.g()), b2, new f.a(this, aVar, z, mVar, cVar, a2) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f29723a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f29724b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ m f29725c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29726d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f29727e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ b f29728f;

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
                    this.f29728f = this;
                    this.f29723a = aVar;
                    this.f29724b = z;
                    this.f29725c = mVar;
                    this.f29726d = cVar;
                    this.f29727e = a2;
                }

                @Override // com.bytedance.sdk.openadsdk.r.f.a
                @MainThread
                public void a(@NonNull com.bytedance.sdk.openadsdk.l.a.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                        this.f29728f.a(dVar);
                        j.f("splashLoadAd", "图片加载成功");
                        c.a(this.f29723a);
                        this.f29728f.A.d(com.bytedance.sdk.openadsdk.l.a.b.f31406a);
                        if (!this.f29724b) {
                            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "preLoadImage") { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass8 f29729a;

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
                                    this.f29729a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f29729a.f29725c, "splash_ad", System.currentTimeMillis() - this.f29729a.f29728f.s);
                                    }
                                }
                            }, 5);
                        }
                        if (!dVar.c()) {
                            this.f29728f.F = 3;
                            c.a(this.f29726d, this.f29727e);
                            this.f29726d.b(-7).h(g.a(-7));
                            a aVar2 = new a(this.f29728f, 2, -7, g.a(-7), null, this.f29726d);
                            j.b("splashLoadAd", "preLoadImage  data == null REQUEST_TYPE_REAL_NETWORK");
                            this.f29728f.F = 3;
                            this.f29728f.a(15000, aVar2, (q) null, (e) null, (String) null);
                            if (this.f29724b) {
                                c.a(this.f29728f.t, false, false, this.f29725c, -7, null);
                            }
                            j.b("SplashAdLoadManager", "图片加载失败");
                            return;
                        }
                        this.f29725c.c(false);
                        e eVar = new e(this.f29728f.f29680e, this.f29725c, this.f29728f.f29676a, "splash_ad");
                        this.f29728f.f29684i = eVar;
                        if (this.f29728f.E != null) {
                            this.f29728f.f29684i.c(this.f29728f.E);
                        }
                        eVar.a(dVar);
                        this.f29728f.o.set(this.f29725c.d() == 1);
                        this.f29728f.a(15000, new a(this.f29728f, 1, 0, null, eVar, this.f29726d), (q) null, eVar, (String) null);
                        if (this.f29728f.a(this.f29725c)) {
                            this.f29728f.a((q) null, eVar, (String) null, this.f29726d);
                        }
                        if (this.f29724b) {
                            c.a(this.f29728f.t, false, true, this.f29725c, 0L, null);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.r.f.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f29728f.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.r.f.a
                @MainThread
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.a(this.f29723a);
                        this.f29728f.F = 3;
                        c.a(this.f29726d, this.f29727e);
                        this.f29726d.b(-7).h(g.a(-7));
                        j.b("splashLoadAd", "splashLoad----5-LoadImageBytes-onFailed-code=-7,msg=" + g.a(-7));
                        b bVar = this.f29728f;
                        bVar.a(15000, new a(bVar, 2, -7, g.a(-7), null, this.f29726d), (q) null, (e) null, (String) null);
                        if (this.f29724b) {
                            c.a(this.f29728f.t, false, false, this.f29725c, -7L, null);
                        }
                        j.b("SplashAdLoadManager", "图片加载失败");
                    }
                }
            }, true);
            a(context, mVar);
        }
    }

    private void a(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, this, context, mVar) == null) || mVar == null) {
            return;
        }
        String O = mVar.O();
        if (TextUtils.isEmpty(O)) {
            return;
        }
        f.a(context, new com.bytedance.sdk.openadsdk.l.b(O, ""), mVar.L(), new f.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f29730a;

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
                this.f29730a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.r.f.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.f.a
            public void a(@NonNull com.bytedance.sdk.openadsdk.l.a.d dVar) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) && dVar.c()) {
                    this.f29730a.E = dVar;
                    if (this.f29730a.f29684i != null) {
                        this.f29730a.f29684i.c(dVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.r.f.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(q qVar, e eVar, String str, com.bytedance.sdk.openadsdk.k.a.c cVar, int i2) {
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
                    public final /* synthetic */ int f29697a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f29698b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29699c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ q f29700d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ String f29701e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ b f29702f;

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
                        this.f29702f = this;
                        this.f29697a = i2;
                        this.f29698b = eVar;
                        this.f29699c = cVar;
                        this.f29700d = qVar;
                        this.f29701e = str;
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
                            if (this.f29697a == 15000) {
                                this.f29702f.o.set(true);
                                j.b("splashLoadAd", "模版渲染--》onRenderFail msg: " + str2 + " code " + i3);
                            } else {
                                this.f29702f.p.set(true);
                                j.b("splashLoadAd", "缓存模版渲染--》onRenderFail msg: " + str2 + " code " + i3);
                            }
                            b bVar = this.f29702f;
                            bVar.a(this.f29697a, new a(bVar, 1, 0, null, this.f29698b, this.f29699c), this.f29700d, this.f29698b, this.f29701e);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            if (this.f29697a == 15000) {
                                this.f29702f.o.set(true);
                                j.b("splashLoadAd", "模版渲染--》onRenderSuccess start....= 实时 ");
                            } else {
                                this.f29702f.p.set(true);
                                j.b("splashLoadAd", "缓存模版渲染--》onRenderSuccess start....=缓存");
                            }
                            b bVar = this.f29702f;
                            bVar.a(this.f29697a, new a(bVar, 1, 0, null, this.f29698b, this.f29699c), this.f29700d, this.f29698b, this.f29701e);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(q qVar, e eVar, String str, com.bytedance.sdk.openadsdk.k.a.c cVar) {
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
                    public final /* synthetic */ q f29703a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f29704b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29705c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f29706d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ b f29707e;

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
                        this.f29707e = this;
                        this.f29703a = qVar;
                        this.f29704b = eVar;
                        this.f29705c = cVar;
                        this.f29706d = str;
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
                            this.f29707e.o.set(true);
                            j.b("splashLoadAd", "实时模版渲染--》onRenderFail msg: " + str2 + " code " + i2);
                            int i3 = this.f29703a == null ? 15000 : 15001;
                            b bVar = this.f29707e;
                            bVar.a(i3, new a(bVar, 1, 0, null, this.f29704b, this.f29705c), this.f29703a, this.f29704b, this.f29706d);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f2, float f3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                            this.f29707e.o.set(true);
                            int i2 = this.f29703a == null ? 15000 : 15001;
                            StringBuilder sb = new StringBuilder();
                            sb.append("实时模版渲染--》onRenderSuccess start....=");
                            sb.append(i2 == 15000 ? "实时" : "缓存");
                            j.b("splashLoadAd", sb.toString());
                            b bVar = this.f29707e;
                            bVar.a(i2, new a(bVar, 1, 0, null, this.f29704b, this.f29705c), this.f29703a, this.f29704b, this.f29706d);
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
            j.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
            if (c.a(qVar)) {
                m a2 = qVar.a();
                o.f().a(a2.ak(), a2.ao(), new p.a(this, eVar, a(4, qVar), qVar, str) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f29708a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.k.a.c f29709b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ q f29710c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f29711d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ b f29712e;

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
                        this.f29712e = this;
                        this.f29708a = eVar;
                        this.f29709b = r8;
                        this.f29710c = qVar;
                        this.f29711d = str;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.p.a
                    public void a(boolean z, long j, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            c.a(this.f29712e.f29676a, z, j, j2);
                            if (!z || this.f29712e.f29682g.get()) {
                                if (this.f29712e.e() && !this.f29712e.f29682g.get()) {
                                    j.b("splashLoadAd", "开屏视频缓存广告不在投放期并且开屏广告没有回调出去则加载");
                                    b bVar = this.f29712e;
                                    bVar.a(bVar.f29676a);
                                    return;
                                }
                                j.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
                                int i2 = (int) j;
                                this.f29709b.b(i2).h(g.a(i2));
                                b bVar2 = this.f29712e;
                                bVar2.a(15001, new a(bVar2, 2, 0, null, null, this.f29709b), this.f29710c, (e) null, (String) null);
                                return;
                            }
                            j.b("splashLoadAd", "check 成功回调.......");
                            this.f29712e.n.set(true);
                            b bVar3 = this.f29712e;
                            bVar3.a(15001, new a(bVar3, 1, 0, null, this.f29708a, this.f29709b), this.f29710c, this.f29708a, this.f29711d);
                        }
                    }
                });
                return;
            }
            j.b("splashLoadAd", "checkAdFromServer check fail !!!!");
            if (e()) {
                j.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
                a(this.f29676a);
                return;
            }
            com.bytedance.sdk.openadsdk.k.a.c a3 = a(4, (q) null);
            j.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
            a(15001, new a(this, 2, 0, null, null, a3), qVar, (e) null, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
        if (r8.H.get() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
        com.bytedance.sdk.component.utils.j.d("splashLoadAd", "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        com.bytedance.sdk.component.utils.j.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r8.n.get() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d7, code lost:
        if (r8.o.get() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r8.p.get() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (r8.I == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
        com.bytedance.sdk.component.utils.j.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！");
        r8.A.a("cache_ad");
        a(r8.I);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f9, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0100, code lost:
        if (r8.n.get() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0108, code lost:
        if (r8.p.get() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010a, code lost:
        com.bytedance.sdk.component.utils.j.d("splashLoadAd", "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！");
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
                        j.f("splashLoadAd", "splashAdTryCallback start....实时请求来了！=" + eVar);
                        this.G.set(true);
                    } else if (i2 == 15001) {
                        j.f("splashLoadAd", "splashAdTryCallback start....缓存请求来了！=" + eVar);
                        this.H.set(true);
                    } else if (i2 == 15004) {
                        j.f("splashLoadAd", "splashAdTryCallback start....超时请求来了！=" + eVar);
                        this.F = 2;
                    } else if (i2 == 15003) {
                        j.f("splashLoadAd", "splashAdTryCallback start....渲染超时请求来了！=" + eVar);
                    }
                    if (this.f29682g.get()) {
                        j.f("splashLoadAd", "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！");
                    } else if (eVar == null) {
                        if (!this.u.get() && !this.v.get()) {
                            j.d("splashLoadAd", "普通类型走这，直接失败回调");
                            b(i2);
                            a(aVar);
                        }
                        if (i2 == 15001) {
                            if (!this.G.get()) {
                                j.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！");
                                return;
                            }
                            j.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！");
                        } else if (this.u.get() && i2 == 15004) {
                            j.d("splashLoadAd", "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>");
                            if (this.H.get()) {
                                if (!this.G.get()) {
                                    j.d("splashLoadAd", "如果实时已超时，实时是否渲染成功 " + this.o.get() + " 缓存渲染是否成功 " + this.p.get());
                                    if (this.n.get() && (this.o.get() || this.p.get())) {
                                        j.d("splashLoadAd", "如果实时已超时，缓存成功直接回调");
                                        this.A.a("cache_ad");
                                        a(this.I);
                                        return;
                                    }
                                    j.d("splashLoadAd", "如果实时已超时，直接失败回调");
                                }
                            } else {
                                j.d("splashLoadAd", "如果实时已超时，缓存也失败直接回调，直接失败回调");
                            }
                        }
                        b(i2);
                        a(aVar);
                    } else {
                        if (str == null && qVar != null && eVar != null) {
                            eVar.a(new com.bytedance.sdk.openadsdk.l.a.d(qVar.b()));
                        }
                        if (this.u.get() && i2 == 15001) {
                            if (this.H.get() && !this.G.get()) {
                                j.d("splashLoadAd", "如果缓存先回来,实时还没有回来，实时是否渲染成功 " + this.o.get() + " 缓存渲染是否成功 " + this.p.get());
                                if (this.n.get() && this.p.get()) {
                                    j.d("splashLoadAd", "缓存赋值给resultTemp");
                                    this.I = aVar;
                                    j.d("splashLoadAd", "如果缓存先回来,实时还没有回来，等待实时回来");
                                    return;
                                }
                            }
                            if (this.G.get() && this.f29684i != null && this.f29684i.b()) {
                                j.d("splashLoadAd", "此时实时可能在渲染，避免缓存的渲染成功后直接被回调");
                                return;
                            }
                        }
                        if (i2 == 15000) {
                            j.d("splashLoadAd", "splashAdTryCallback 实时或渲染成功回调......！");
                        }
                        if (this.u.get() && i2 == 15000 && !this.o.get()) {
                            j.b("splashLoadAd", "优先实时，且实时类型广告图片加载成功；如果是模板广告且渲染未成功，则继续等待");
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("splashAdTryCallback..（ 是否缓存已check成功：");
                        sb.append(this.n.get());
                        sb.append(" || 是否渲染超时：");
                        sb.append(i2 == 15003);
                        sb.append(" || 是否为实时请求");
                        if (i2 != 15000) {
                            z = false;
                        }
                        sb.append(z);
                        sb.append("） && （是否实时模版渲染完成：");
                        sb.append(this.o.get());
                        sb.append(" || 是否缓存模版渲染完成：");
                        sb.append(this.p.get());
                        sb.append("）");
                        j.b("splashLoadAd", sb.toString());
                        if ((this.n.get() || i2 == 15000 || i2 == 15003) && (this.o.get() || this.p.get())) {
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
    public void a(com.bytedance.sdk.openadsdk.l.a.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, dVar) == null) || dVar == null || this.A == null) {
            return;
        }
        byte[] b2 = dVar.b();
        if (b2 != null && this.A.i() == 0.0d) {
            this.A.a(b2.length / 1024.0f);
        }
        Bitmap a2 = dVar.a();
        if (a2 != null && TextUtils.isEmpty(this.A.j())) {
            this.A.b(a2.getWidth() + "X" + a2.getHeight());
        }
        Map<String, String> e2 = dVar.e();
        if (e2 == null || e2.size() <= 0 || this.A.k() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : e2.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, e2.get(str));
                } catch (Exception e3) {
                    j.f("SplashAdLoadManager", e3.getMessage());
                }
            }
        }
        this.A.a(jSONObject);
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
                e eVar = new e(this.f29680e, qVar.a(), str, this.f29676a, "splash_ad");
                if (TextUtils.isEmpty(str)) {
                    this.f29683h = eVar;
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
                j.f("splashLoadAd", "onCallback ......");
                i();
                if (aVar == null) {
                    j.a("splashAdListener is null, then return");
                    l.remove(this);
                } else if (this.f29678c == null) {
                    j.a("splashAdListener is null, then return");
                    if (aVar.f29731a == 3) {
                        b(aVar.f29735e);
                    }
                    l.remove(this);
                } else if (!this.f29682g.get()) {
                    this.f29682g.set(true);
                    int i2 = aVar.f29731a;
                    if (i2 == 1) {
                        d(aVar.f29735e);
                        this.f29678c.onSplashAdLoad(aVar.f29734d);
                        d(this.C);
                    } else if (i2 == 2) {
                        j.f("splashLoadAd", "onCallback CALLBACK_RESULT_FAILED");
                        com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onCallback", aVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.b.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a f29713a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ b f29714b;

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
                                this.f29714b = this;
                                this.f29713a = aVar;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f29714b.c(this.f29713a.f29735e);
                                }
                            }
                        });
                        this.f29678c.onError(aVar.f29732b, aVar.f29733c);
                    } else if (i2 != 3) {
                        this.f29678c.onError(-2, g.a(-2));
                    } else {
                        j.f("splashLoadAd", "onCallback CALLBACK_RESULT_TIMEOUT");
                        b(aVar.f29735e);
                        this.f29678c.onTimeout();
                    }
                    if (this.f29681f != null) {
                        this.f29681f.removeMessages(2);
                        this.f29681f.removeMessages(4);
                    }
                    this.f29678c = null;
                    l.remove(this);
                } else {
                    this.f29678c = null;
                    if (aVar.f29731a == 3) {
                        b(aVar.f29735e);
                    }
                    l.remove(this);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            if (message.what == 1) {
                if (!this.f29682g.get()) {
                    this.f29682g.set(true);
                    b();
                    j.b("SplashAdLoadManager", "尝试从缓存中取");
                } else {
                    i();
                    j.b("SplashAdLoadManager", "开始预加载");
                }
                this.f29681f.removeCallbacksAndMessages(null);
            }
            if (message.what == 2) {
                this.f29681f.removeCallbacksAndMessages(null);
                if (this.f29682g.get()) {
                    return;
                }
                j.b("splashLoadAd", "MSG_USER_TIME_OUT----7-");
                a(15004, new a(this, 3, 0, null, null, a(0, (q) null)), (q) null, (e) null, (String) null);
            }
            if (message.what == 4) {
                j.b("splashLoadAd", "handleMsg MSG_SPLASH_TIME_OUT ");
                this.f29681f.removeMessages(4);
                if (this.f29682g.get()) {
                    return;
                }
                this.o.set(true);
                this.p.set(true);
                m mVar = this.C;
                if (mVar == null) {
                    return;
                }
                boolean au = mVar.au();
                com.bytedance.sdk.openadsdk.k.a.c a2 = a(3, (q) null);
                if (au) {
                    e eVar = this.j;
                    if (eVar == null) {
                        return;
                    }
                    String a3 = eVar.a();
                    j.b("splashLoadAd", "MSG_SPLASH_TIME_OUT videoCachePath " + a3);
                    a(15003, new a(this, 1, 0, null, eVar, a2), (q) null, eVar, a3);
                } else {
                    e eVar2 = this.f29683h;
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
