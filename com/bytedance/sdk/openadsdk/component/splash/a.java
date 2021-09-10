package com.bytedance.sdk.openadsdk.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.e.q;
import com.bytedance.sdk.openadsdk.core.e.t;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.g;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements w.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f66010a;

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f66011b;

    /* renamed from: c  reason: collision with root package name */
    public static final Integer f66012c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f66013d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f66014e;

    /* renamed from: f  reason: collision with root package name */
    public final w f66015f;

    /* renamed from: g  reason: collision with root package name */
    public final WeakHashMap<Integer, c> f66016g;

    /* renamed from: h  reason: collision with root package name */
    public final WeakHashMap<Integer, d> f66017h;

    /* renamed from: i  reason: collision with root package name */
    public e f66018i;

    /* renamed from: j  reason: collision with root package name */
    public f f66019j;
    public long k;
    public long l;
    public AtomicBoolean m;
    public C1900a n;

    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1900a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f66029a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, C1901a> f66030b;

        /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1901a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f66032a;

            /* renamed from: b  reason: collision with root package name */
            public AdSlot f66033b;

            /* renamed from: c  reason: collision with root package name */
            public n f66034c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f66035d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1900a f66036e;

            public C1901a(C1900a c1900a, String str, AdSlot adSlot, n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1900a, str, adSlot, nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66036e = c1900a;
                this.f66035d = false;
                this.f66032a = str;
                this.f66033b = adSlot;
                this.f66034c = nVar;
            }

            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.f66035d = z;
                }
            }

            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66035d : invokeV.booleanValue;
            }
        }

        private boolean b(ConcurrentHashMap<String, C1901a> concurrentHashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, concurrentHashMap)) == null) {
                if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                    return false;
                }
                for (Map.Entry<String, C1901a> entry : concurrentHashMap.entrySet()) {
                    C1901a value = entry.getValue();
                    if (value != null && !value.a()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        private void c(ConcurrentHashMap<String, C1901a> concurrentHashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65550, this, concurrentHashMap) == null) || concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return;
            }
            k.f("SplashAdCacheManager", "重置开屏rit请求状态");
            Iterator<Map.Entry<String, C1901a>> it = concurrentHashMap.entrySet().iterator();
            if (it == null) {
                return;
            }
            while (it.hasNext()) {
                C1901a value = it.next().getValue();
                if (value != null) {
                    value.a(false);
                }
            }
        }

        public C1900a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66029a = a.a(o.a());
            this.f66030b = new ConcurrentHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot, n nVar) {
            int y;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, adSlot, nVar) == null) || adSlot == null || nVar == null || TextUtils.isEmpty(adSlot.getCodeId()) || !a()) {
                return;
            }
            if (!this.f66030b.containsKey(adSlot.getCodeId())) {
                k.f("SplashAdCacheManager", "add adSlot.getCodeId() " + adSlot.getCodeId());
                this.f66030b.put(adSlot.getCodeId(), new C1901a(this, adSlot.getCodeId(), adSlot, nVar));
            }
            if (!o.k() && (y = o.h().y()) > 0) {
                o.j();
                com.bytedance.sdk.component.d.e.d().scheduleWithFixedDelay(new g(this, "timeLoopLoadAd") { // from class: com.bytedance.sdk.openadsdk.component.splash.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ C1900a f66031a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8};
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
                        this.f66031a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            k.f("SplashAdCacheManager", "触发定时器进行检测实现需要加载开屏广告");
                            C1900a c1900a = this.f66031a;
                            c1900a.a(c1900a.f66030b);
                        }
                    }
                }, 0L, (y * 60000) + 10000, TimeUnit.MILLISECONDS);
            }
        }

        private boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? o.h().x() == 1 && o.h().y() > 0 : invokeV.booleanValue;
        }

        private int a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
                if (j2 <= 0) {
                    return 0;
                }
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis <= 0) {
                    return 0;
                }
                k.f("SplashAdCacheManager", "CircleLoadSplashAd getIntervalTime temp " + currentTimeMillis);
                return (int) (currentTimeMillis / 60000);
            }
            return invokeJ.intValue;
        }

        private boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
                k.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd rit " + str);
                long b2 = com.bytedance.sdk.openadsdk.q.e.b(str);
                k.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd lastLoadAdTime " + b2);
                return a(b2) >= o.h().y();
            }
            return invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConcurrentHashMap<String, C1901a> concurrentHashMap) {
            Map.Entry<String, C1901a> next;
            C1901a value;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, this, concurrentHashMap) == null) {
                if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                    Iterator<Map.Entry<String, C1901a>> it = concurrentHashMap.entrySet().iterator();
                    if (it == null) {
                        return;
                    }
                    while (it.hasNext() && (next = it.next()) != null && (value = next.getValue()) != null) {
                        if (!value.a()) {
                            AdSlot adSlot = value.f66033b;
                            n nVar = value.f66034c;
                            k.f("SplashAdCacheManager", " loadSplashParamHashMapTest " + concurrentHashMap.size());
                            k.f("SplashAdCacheManager", "byRitLoadSplashAd 开始请求广告");
                            value.a(true);
                            a(next.getKey(), adSlot, nVar);
                            return;
                        }
                    }
                    return;
                }
                k.f("SplashAdCacheManager", "mloadSplashParaHashMap == null || mloadSplashParaHashMap.size() == 0 ");
            }
        }

        private void a(String str, AdSlot adSlot, n nVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65545, this, str, adSlot, nVar) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (a(str)) {
                if (this.f66029a != null) {
                    k.f("SplashAdCacheManager", "adSlot " + adSlot.getExpressViewAcceptedWidth() + GlideException.IndentedAppendable.INDENT + adSlot.getExpressViewAcceptedHeight());
                    StringBuilder sb = new StringBuilder();
                    sb.append("循环请求广告 adSlot getCodeId ");
                    sb.append(adSlot.getCodeId());
                    k.f(" SplashAdCacheManager", sb.toString());
                    this.f66029a.a(adSlot, nVar);
                }
            } else if (b(this.f66030b)) {
                k.f("SplashAdCacheManager", "还存在没有加载的开屏rit需要加载开屏");
                a(this.f66030b);
            } else {
                c(this.f66030b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adSlot) == null) || adSlot == null || this.f66030b == null || TextUtils.isEmpty(adSlot.getCodeId())) {
                return;
            }
            k.f("SplashAdCacheManager", "SplashAdCacheManager 已经加载过了 adSlot.getCodeId() " + adSlot.getCodeId());
            C1901a c1901a = this.f66030b.get(adSlot.getCodeId());
            if (c1901a != null) {
                c1901a.a(true);
            }
            k.f("SplashAdCacheManager", "SplashAdCacheManager 是否需要加载其他rit开屏广告");
            a(this.f66030b);
            if (b(this.f66030b)) {
                return;
            }
            c(this.f66030b);
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f66037a;

        /* renamed from: b  reason: collision with root package name */
        public long f66038b;

        /* renamed from: c  reason: collision with root package name */
        public long f66039c;

        /* renamed from: d  reason: collision with root package name */
        public long f66040d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66037a = true;
            this.f66038b = 0L;
            this.f66039c = 0L;
            this.f66040d = 0L;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a();

        void a(@NonNull q qVar);
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes9.dex */
    public class e extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66041a;

        /* renamed from: b  reason: collision with root package name */
        public String f66042b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, String str) {
            super("ReadCacheTask");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66041a = aVar;
            this.f66042b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Message obtainMessage = this.f66041a.f66015f.obtainMessage();
                obtainMessage.what = 1;
                try {
                    com.bytedance.sdk.openadsdk.core.e.a f2 = this.f66041a.f(this.f66042b);
                    q qVar = new q(f2, null, null);
                    if (f2 != null && f2.c() != null && !f2.c().isEmpty()) {
                        m mVar = f2.c().get(0);
                        l a2 = this.f66041a.a(f2);
                        if (mVar != null && mVar.aK() && a2 != null) {
                            byte[] a3 = ImageLoaderWrapper.a(a2);
                            if (a3 != null && a3.length != 0) {
                                com.bytedance.sdk.openadsdk.k.a.c.f67970a = 1;
                                k.b("splashLoadAd", " readSplashAdFromCache 获取文件成功 ");
                                qVar.a(mVar);
                                qVar.a(a3);
                            }
                            k.b("splashLoadAd", " readSplashAdFromCache 获取缓存失败 ");
                            obtainMessage.obj = null;
                        }
                    }
                    obtainMessage.obj = qVar;
                } catch (Throwable unused) {
                }
                this.f66041a.f66015f.sendMessage(obtainMessage);
                try {
                    k.f("splashLoadAd", "获取缓存广告之后将其清空 clearCache " + this.f66042b);
                    this.f66041a.d(this.f66042b);
                } catch (Throwable unused2) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                this.f66042b = str;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66043a;

        /* renamed from: b  reason: collision with root package name */
        public q f66044b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, q qVar) {
            super("WriteCacheTask");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66043a = aVar;
            this.f66044b = qVar;
        }

        private void c() {
            int c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.f66043a.f66015f == null) {
                return;
            }
            Message obtainMessage = this.f66043a.f66015f.obtainMessage();
            obtainMessage.what = 3;
            try {
                c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(this.f66044b);
            } catch (Throwable unused) {
            }
            if (c2 > 0) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", "materialMeta" + c2, this.f66044b.c().d());
                } else {
                    SharedPreferences.Editor edit = o.a().getSharedPreferences("tt_materialMeta", 0).edit();
                    edit.putString("materialMeta" + c2, this.f66044b.c().d()).apply();
                    this.f66043a.f66015f.sendMessage(obtainMessage);
                    return;
                }
            }
            this.f66043a.f66015f.sendMessage(obtainMessage);
        }

        public void a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
                this.f66044b = qVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1669049253, "Lcom/bytedance/sdk/openadsdk/component/splash/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1669049253, "Lcom/bytedance/sdk/openadsdk/component/splash/a;");
                return;
            }
        }
        f66010a = 1;
        f66011b = 2;
        f66012c = 3;
    }

    public a(Context context) {
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
        this.f66015f = new w(Looper.getMainLooper(), this);
        this.f66016g = new WeakHashMap<>();
        this.f66017h = new WeakHashMap<>();
        this.k = 0L;
        this.l = 0L;
        this.m = new AtomicBoolean(false);
        if (context != null) {
            this.f66014e = context.getApplicationContext();
        }
    }

    private void c(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, qVar) == null) {
            f fVar = this.f66019j;
            if (fVar == null) {
                this.f66019j = new f(this, qVar);
            } else {
                fVar.a(qVar);
            }
            com.bytedance.sdk.component.d.e.a(this.f66019j, 10);
        }
    }

    private g e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            e eVar = this.f66018i;
            if (eVar != null) {
                eVar.a(str);
            } else {
                this.f66018i = new e(this, str);
            }
            return this.f66018i;
        }
        return (g) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.e.a f(String str) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_materialMeta", "materialMeta" + str, (String) null);
            } else {
                SharedPreferences sharedPreferences = b().getSharedPreferences("tt_materialMeta", 0);
                string = sharedPreferences.getString("materialMeta" + str, null);
            }
            if (!TextUtils.isEmpty(string)) {
                try {
                    q.a a2 = q.a.a(new JSONObject(string));
                    if (a2 != null && a2.f66988h != null) {
                        return a2.f66988h;
                    }
                } catch (JSONException unused) {
                }
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.core.e.a) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_materialMeta", "materialMeta" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_ad_cache" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_video_ad_cache" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_materialMeta", 0).edit();
        edit.remove("materialMeta" + str).apply();
        SharedPreferences.Editor edit2 = b().getSharedPreferences("tt_splash", 0).edit();
        SharedPreferences.Editor remove = edit2.remove("has_ad_cache" + str);
        SharedPreferences.Editor remove2 = remove.remove("has_video_ad_cache" + str);
        SharedPreferences.Editor remove3 = remove2.remove("expiration" + str);
        remove3.remove("expiration" + str).apply();
    }

    private Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Context context = this.f66014e;
            return context != null ? context : o.a();
        }
        return (Context) invokeV.objValue;
    }

    public void b(com.bytedance.sdk.openadsdk.core.e.q qVar) {
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, qVar) == null) || (c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(qVar)) <= 0) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + c2, Boolean.TRUE);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
        edit.putBoolean("has_video_ad_cache" + c2, true).apply();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (f66013d == null) {
                synchronized (a.class) {
                    if (f66013d == null) {
                        f66013d = new a(context);
                    }
                }
            }
            return f66013d;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            b bVar = new b();
            if (TextUtils.isEmpty(str)) {
                return bVar;
            }
            boolean z = true;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                long a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + str, 0L);
                long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "update" + str, 0L);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis >= a3 && currentTimeMillis < a2) {
                    z = false;
                }
                bVar.f66037a = z;
                bVar.f66038b = a3;
                bVar.f66039c = a2;
                bVar.f66040d = currentTimeMillis;
                return bVar;
            }
            SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
            long j2 = sharedPreferences.getLong("expiration" + str, 0L);
            long j3 = sharedPreferences.getLong("update" + str, 0L);
            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
            if (currentTimeMillis2 >= j3 && currentTimeMillis2 < j2) {
                z = false;
            }
            bVar.f66037a = z;
            bVar.f66038b = j3;
            bVar.f66039c = j2;
            bVar.f66040d = currentTimeMillis2;
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void b(String str, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, cVar) == null) {
            if (TextUtils.isEmpty(str)) {
                cVar.a();
                return;
            }
            this.f66016g.put(f66010a, cVar);
            com.bytedance.sdk.component.d.e.a(e(str), 10);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.q qVar) {
        int c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, qVar) == null) || qVar == null || (c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(qVar)) <= 0) {
            return;
        }
        a(c2, qVar.a().aq());
        c(qVar);
    }

    public void a(com.bytedance.sdk.openadsdk.core.e.q qVar, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, qVar, dVar) == null) || dVar == null) {
            return;
        }
        this.f66017h.put(f66012c, dVar);
        a(qVar);
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + str, false);
            }
            SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
            return sharedPreferences.getBoolean("has_video_ad_cache" + str, false);
        }
        return invokeL.booleanValue;
    }

    private void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + i2, Long.valueOf(j2));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "update" + i2, Long.valueOf(System.currentTimeMillis() / 1000));
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + i2, Boolean.TRUE);
                return;
            }
            SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
            SharedPreferences.Editor putLong = edit.putLong("expiration" + i2, j2);
            SharedPreferences.Editor putLong2 = putLong.putLong("update" + i2, System.currentTimeMillis() / 1000);
            putLong2.putBoolean("has_ad_cache" + i2, true).apply();
        }
    }

    public void b(AdSlot adSlot, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, adSlot, nVar) == null) || adSlot == null || nVar == null) {
            return;
        }
        if (this.n == null) {
            this.n = new C1900a();
        }
        this.n.a(adSlot, nVar);
    }

    private void c(AdSlot adSlot, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, this, adSlot, nVar) == null) {
            if (this.m.getAndSet(true)) {
                k.b("splashLoad", "已在预加载开屏广告....不再发出");
                return;
            }
            if ((o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) && nVar != null) {
                nVar.f66493e = 2;
            }
            o.f().a(adSlot, nVar, 4, new p.b(this, adSlot) { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66023a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66024b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adSlot};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66024b = this;
                    this.f66023a = adSlot;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        k.b("splashLoad", "广告物料预加载失败...." + str + i2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(i2);
                        k.b("SplashAdCacheManager", sb.toString());
                        this.f66024b.m.set(false);
                        if (this.f66024b.n != null) {
                            this.f66024b.n.a(this.f66023a);
                        }
                        if (this.f66023a != null) {
                            com.bytedance.sdk.openadsdk.q.e.a(System.currentTimeMillis(), this.f66023a.getCodeId());
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (!com.bytedance.sdk.openadsdk.component.splash.c.b(aVar)) {
                            this.f66024b.m.set(false);
                            if (this.f66024b.n != null) {
                                this.f66024b.n.a(this.f66023a);
                            }
                        } else {
                            k.b("splashLoad", "广告物料预加载成功....");
                            m mVar = aVar.c().get(0);
                            if (mVar.aK()) {
                                boolean z = mVar.V() != null;
                                if (mVar.ad() == null || mVar.ad().size() <= 0) {
                                    return;
                                }
                                l lVar = mVar.ad().get(0);
                                String a2 = lVar.a();
                                int b2 = lVar.b();
                                this.f66024b.k = System.currentTimeMillis();
                                com.bytedance.sdk.openadsdk.component.splash.c.a(mVar, z ? 2 : 0);
                                this.f66024b.l = SystemClock.elapsedRealtime();
                                t c2 = com.bytedance.sdk.openadsdk.k.d.b().d().c();
                                if (c2 != null) {
                                    c2.b(false);
                                }
                                com.bytedance.sdk.openadsdk.q.g.a(this.f66024b.f66014e, new com.bytedance.sdk.openadsdk.k.a(a2, lVar.g()), b2, new g.a(this, aVar, z, mVar) { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.a f66025a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ boolean f66026b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ m f66027c;

                                    /* renamed from: d  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass3 f66028d;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, aVar, Boolean.valueOf(z), mVar};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f66028d = this;
                                        this.f66025a = aVar;
                                        this.f66026b = z;
                                        this.f66027c = mVar;
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.q.g.a
                                    @MainThread
                                    public void a(@NonNull com.bytedance.sdk.openadsdk.k.a.b bVar) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                                            com.bytedance.sdk.openadsdk.component.splash.c.a(this.f66025a);
                                            if (!this.f66026b) {
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f66027c, "splash_ad", System.currentTimeMillis() - this.f66028d.f66024b.k);
                                            }
                                            this.f66028d.f66024b.k = 0L;
                                            k.b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                                            k.b("splashLoad", "预加载成功，广告缓存到本地----10");
                                            a.a(this.f66028d.f66024b.f66014e).a(new com.bytedance.sdk.openadsdk.core.e.q(this.f66025a, this.f66027c, bVar.b()));
                                            if (this.f66026b) {
                                                com.bytedance.sdk.openadsdk.component.splash.c.a(this.f66028d.f66024b.l, false, true, this.f66027c, 0L, null);
                                            }
                                            this.f66028d.f66024b.m.set(false);
                                            if (this.f66028d.f66024b.n != null) {
                                                this.f66028d.f66024b.n.a(this.f66028d.f66023a);
                                            }
                                        }
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.q.g.a
                                    public void b() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                        }
                                    }

                                    @Override // com.bytedance.sdk.openadsdk.q.g.a
                                    @MainThread
                                    public void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            com.bytedance.sdk.openadsdk.component.splash.c.a(this.f66025a);
                                            k.b("SplashAdCacheManager", "图片数据加载失败");
                                            k.b("splashLoad", "图片数据预加载失败....");
                                            if (this.f66026b) {
                                                com.bytedance.sdk.openadsdk.component.splash.c.a(this.f66028d.f66024b.l, false, false, this.f66027c, -7L, null);
                                            }
                                            this.f66028d.f66024b.m.set(false);
                                            if (this.f66028d.f66024b.n != null) {
                                                this.f66028d.f66024b.n.a(this.f66028d.f66023a);
                                            }
                                        }
                                    }
                                }, true);
                            }
                        }
                        if (this.f66023a != null) {
                            com.bytedance.sdk.openadsdk.q.e.a(System.currentTimeMillis(), this.f66023a.getCodeId());
                        }
                    }
                }
            });
        }
    }

    public void a(String str, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, cVar) == null) {
            this.f66016g.put(f66011b, cVar);
            if (TextUtils.isEmpty(str)) {
                Message obtainMessage = this.f66015f.obtainMessage();
                obtainMessage.what = 2;
                this.f66015f.sendMessage(obtainMessage);
                return;
            }
            com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "readSplashMaterialMeta", str) { // from class: com.bytedance.sdk.openadsdk.component.splash.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f66020a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66021b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str};
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
                    this.f66021b = this;
                    this.f66020a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    m mVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k.b("TTExecutor", "readSplashMaterialMeta....->run....");
                        Message obtainMessage2 = this.f66021b.f66015f.obtainMessage();
                        obtainMessage2.what = 2;
                        try {
                            com.bytedance.sdk.openadsdk.core.e.a f2 = this.f66021b.f(this.f66020a);
                            com.bytedance.sdk.openadsdk.core.e.q qVar = new com.bytedance.sdk.openadsdk.core.e.q(f2, null, null);
                            if (f2 != null && f2.c() != null && !f2.c().isEmpty() && (mVar = f2.c().get(0)) != null) {
                                qVar.a(mVar);
                            }
                            obtainMessage2.obj = qVar;
                        } catch (Throwable unused) {
                        }
                        this.f66021b.f66015f.sendMessage(obtainMessage2);
                        this.f66021b.d(this.f66020a);
                    }
                }
            }, 10);
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + str, false);
            }
            SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
            return sharedPreferences.getBoolean("has_ad_cache" + str, false);
        }
        return invokeL.booleanValue;
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (z) {
                return "splash_video_cache_" + str + "/";
            }
            return "/splash_video_cache_" + str + "/";
        }
        return (String) invokeLZ.objValue;
    }

    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, file) == null) {
            try {
                k.f("splashLoadAd", "SplashAdCacheManager trimFileCache " + file.getPath());
                h.d().s().a(file);
            } catch (IOException e2) {
                k.f("SplashAdCacheManager", "trimFileCache IOException:" + e2.toString());
            }
        }
    }

    public String a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            if (mVar == null || mVar.V() == null || TextUtils.isEmpty(mVar.V().i())) {
                return null;
            }
            String i2 = mVar.V().i();
            String l = mVar.V().l();
            if (mVar.aN()) {
                File a2 = com.bytedance.sdk.openadsdk.a.b.a(l);
                if (a2.exists() && a2.length() > 0) {
                    return a2.getAbsolutePath();
                }
            }
            return a(i2, l, String.valueOf(com.bytedance.sdk.openadsdk.q.q.d(mVar.ao())));
        }
        return (String) invokeL.objValue;
    }

    public String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.e.a(str);
            }
            String a2 = a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b());
            k.f("splashLoadAd", "getVideoPath  cacheDirPath " + a2);
            File a3 = com.bytedance.sdk.openadsdk.component.splash.c.a(this.f66014e, a2, str2);
            if (a3 != null && a3.exists() && a3.isFile()) {
                k.f("splashLoadAd", "getVideoPath  file.getAbsolutePath() " + a3.getAbsolutePath());
                return a3.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLL.objValue;
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        WeakHashMap<Integer, d> weakHashMap;
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, message) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                c remove2 = this.f66016g.remove(f66010a);
                if (remove2 != null) {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.e.q)) {
                        remove2.a((com.bytedance.sdk.openadsdk.core.e.q) obj);
                        k.b("SplashAdCacheManager", "缓存反序列化成功");
                    } else {
                        remove2.a();
                        k.b("SplashAdCacheManager", "缓存反序列化失败");
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OnLoadCacheCallback is null: ");
                sb.append(remove2 == null);
                k.b("SplashAdCacheManager", sb.toString());
                this.f66015f.removeCallbacksAndMessages(null);
            } else if (i2 != 2) {
                if (i2 != 3 || (weakHashMap = this.f66017h) == null || (remove = weakHashMap.remove(f66012c)) == null) {
                    return;
                }
                remove.a();
            } else {
                c remove3 = this.f66016g.remove(f66011b);
                if (remove3 != null) {
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof com.bytedance.sdk.openadsdk.core.e.q)) {
                        remove3.a((com.bytedance.sdk.openadsdk.core.e.q) obj2);
                        k.b("SplashAdCacheManager", "视频物料缓存反序列化成功");
                    } else {
                        remove3.a();
                        k.b("SplashAdCacheManager", "视频物料缓存反序列化失败");
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("OnLoadCacheCallback is null: ");
                sb2.append(remove3 == null);
                k.b("SplashAdCacheManager", sb2.toString());
                this.f66015f.removeCallbacksAndMessages(null);
            }
        }
    }

    public boolean a(AdSlot adSlot, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, adSlot, z)) == null) {
            b c2 = a(this.f66014e).c(adSlot.getCodeId());
            if (z && c2.f66037a) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf((c2.f66040d - c2.f66038b) / 3600));
                    com.bytedance.sdk.openadsdk.j.a.a().m(com.bytedance.sdk.openadsdk.j.a.c.b().a(4).c(adSlot.getCodeId()).b(jSONObject.toString()));
                } catch (Throwable unused) {
                }
            }
            return c2.f66037a;
        }
        return invokeLZ.booleanValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x003c -> B:39:0x003c). Please submit an issue!!! */
    public void a() {
        File externalCacheDir;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta");
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash");
                } else {
                    b().getSharedPreferences("tt_materialMeta", 0).edit().clear().apply();
                    b().getSharedPreferences("tt_splash", 0).edit().clear().apply();
                }
            } catch (Throwable unused) {
            }
            try {
                if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && b().getExternalCacheDir() != null) {
                    externalCacheDir = b().getExternalCacheDir();
                } else {
                    externalCacheDir = b().getCacheDir();
                }
                if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66022a;

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
                        this.f66022a = this;
                    }

                    @Override // java.io.FileFilter
                    public boolean accept(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                            if (file != null) {
                                String name = file.getName();
                                return name.contains("splash_ad_cache") || name.contains("splash_video_cache");
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                })) == null || listFiles.length <= 0) {
                    return;
                }
                for (File file : listFiles) {
                    try {
                        com.bytedance.sdk.component.utils.f.c(file);
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public void a(AdSlot adSlot, n nVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, adSlot, nVar) == null) && o.h().a(com.bytedance.sdk.openadsdk.q.q.a(adSlot)) && adSlot != null && TextUtils.isEmpty(adSlot.getBidAdm())) {
            n nVar2 = nVar == null ? new n() : nVar.a();
            nVar2.f66494f = System.currentTimeMillis();
            c(adSlot, nVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
        InterceptResult invokeL;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, aVar)) == null) {
            if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (mVar = aVar.c().get(0)) == null) {
                return null;
            }
            l lVar = mVar.ad().get(0);
            if (lVar == null) {
                if (mVar.ad() == null || mVar.ad().size() == 0) {
                    return null;
                }
                lVar = mVar.ad().get(0);
            }
            if (lVar == null) {
                return null;
            }
            return lVar;
        }
        return (l) invokeL.objValue;
    }
}
