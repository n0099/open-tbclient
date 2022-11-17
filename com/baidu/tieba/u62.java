package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.bn2;
import com.baidu.tieba.ub2;
import com.baidu.tieba.x22;
import com.baidu.tieba.za2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u62 implements c13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile u62 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<PrefetchEvent> a;
    public final AtomicInteger b;
    public final int c;
    public volatile boolean d;
    public final List<Bundle> e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.c13
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final AtomicInteger e;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public volatile b62 b;
        public final List<q62> c;
        public final List<String> d;

        /* renamed from: com.baidu.tieba.u62$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0439c extends f62 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c f;

            /* renamed from: com.baidu.tieba.u62$c$c$a */
            /* loaded from: classes6.dex */
            public class a extends e62 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0439c e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(C0439c c0439c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0439c, str, str2};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (String) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = c0439c;
                }

                @Override // com.baidu.tieba.e62
                public ub2 e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        ub2.b bVar = new ub2.b();
                        bVar.c(1);
                        bVar.b(this.e.f.n());
                        return bVar.a();
                    }
                    return (ub2) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0439c(c cVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = cVar;
            }

            @Override // com.baidu.tieba.f62
            public e62 h(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    return new a(this, str, "runtime/index.js");
                }
                return (e62) invokeL.objValue;
            }
        }

        /* loaded from: classes6.dex */
        public class a implements q62 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ PrefetchEvent b;
            public final /* synthetic */ CountDownLatch c;
            public final /* synthetic */ c d;

            public a(c cVar, String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, prefetchEvent, countDownLatch};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = cVar;
                this.a = str;
                this.b = prefetchEvent;
                this.c = countDownLatch;
            }

            @Override // com.baidu.tieba.q62
            public void onReady() {
                d32 f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.d.b != null && (f = this.d.b.f()) != null && !f.isDestroyed()) {
                        this.d.s(this.a, f);
                        this.d.r(f, this.b);
                        if (u62.f) {
                            Log.d("PreCodeCacheManager", "fill code cache finish for - " + this.a);
                        }
                    }
                    CountDownLatch countDownLatch = this.c;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b extends t22 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ c b;

            public b(c cVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = j;
            }

            @Override // com.baidu.tieba.t22
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (u62.f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "create a new master cost - " + (currentTimeMillis - this.a) + "ms");
                    }
                    super.a(str);
                    this.b.a = true;
                    this.b.q();
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421240039, "Lcom/baidu/tieba/u62$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-421240039, "Lcom/baidu/tieba/u62$c;");
                    return;
                }
            }
            e = new AtomicInteger(1000);
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = new ArrayList();
            this.d = new CopyOnWriteArrayList();
        }

        public final b62 j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new C0439c(this, AppRuntime.getAppContext());
            }
            return (b62) invokeV.objValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null) {
                this.b.destroy();
            }
        }

        public final synchronized void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this) {
                    for (q62 q62Var : this.c) {
                        if (q62Var != null) {
                            q62Var.onReady();
                        }
                    }
                    this.c.clear();
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public final synchronized void g(q62 q62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q62Var) == null) {
                synchronized (this) {
                    if (q62Var == null) {
                        return;
                    }
                    if (this.a) {
                        q62Var.onReady();
                        return;
                    }
                    if (!this.c.contains(q62Var)) {
                        this.c.add(q62Var);
                    }
                }
            }
        }

        public final boolean o(PrefetchEvent prefetchEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, prefetchEvent)) == null) {
                if (prefetchEvent == null) {
                    return false;
                }
                String str = prefetchEvent.appPath;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                if (!bn2.z(file) || !bn2.y(file)) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean p(@NonNull SwanAppConfigData swanAppConfigData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, swanAppConfigData)) == null) {
                String str = swanAppConfigData.n;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    return new JSONObject(str).has("_modules");
                } catch (JSONException e2) {
                    if (u62.f) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public void l(String str, PrefetchEvent prefetchEvent, CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, prefetchEvent, countDownLatch) == null) {
                if (this.b == null) {
                    this.b = i();
                }
                this.d.add(str);
                g(new a(this, str, prefetchEvent, countDownLatch));
            }
        }

        public final void s(String str, d32 d32Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, d32Var) == null) && (d32Var instanceof nb2)) {
                ((nb2) d32Var).B0(m());
            }
        }

        public final PrefetchEvent.c h(PrefetchEvent prefetchEvent, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, str)) == null) {
                if (!o(prefetchEvent)) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", prefetchEvent.appId);
                hashMap.put("schema", prefetchEvent.schema);
                hashMap.put("state", prefetchEvent.state);
                hashMap.put("scene", prefetchEvent.scene);
                hashMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, prefetchEvent.appPath);
                hashMap.put("pageType", prefetchEvent.pageType);
                File file = new File(prefetchEvent.appPath);
                String m = bn2.m(new File(file, "app.json"));
                prefetchEvent.appConfig = m;
                hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m);
                SwanAppConfigData c = SwanAppConfigData.c(prefetchEvent.appConfig, file);
                if (c == null || p(c)) {
                    return null;
                }
                String f = c.f();
                prefetchEvent.pageUrl = f;
                hashMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, f);
                String f2 = xh3.f(prefetchEvent.pageUrl);
                String o = xh3.o(prefetchEvent.pageUrl);
                String c2 = x73.c(f2, c);
                if (!TextUtils.equals(f2, c2)) {
                    if (!TextUtils.isEmpty(o)) {
                        c2 = c2 + "?" + o;
                    }
                    hashMap.put("pageRoutePath", c2);
                }
                return new PrefetchEvent.c(hashMap, str);
            }
            return (PrefetchEvent.c) invokeLL.objValue;
        }

        public final b62 i() {
            InterceptResult invokeV;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (u62.f) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                b62 j2 = j();
                j2.loadUrl(xh3.w(za2.U().Y()));
                j2.b(new b(this, j));
                return j2;
            }
            return (b62) invokeV.objValue;
        }

        public final V8EngineConfiguration.CodeCacheSetting m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
                codeCacheSetting.id = "appjs";
                ArrayList<String> arrayList = new ArrayList<>();
                codeCacheSetting.pathList = arrayList;
                arrayList.addAll(this.d);
                x22.a d = x22.b.d();
                codeCacheSetting.maxCount = d.a;
                codeCacheSetting.sizeLimit = d.b;
                codeCacheSetting.diskCodeCacheSizeThreshold = d.c;
                return codeCacheSetting;
            }
            return (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        public final String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String str = "master" + e.getAndIncrement();
                if (u62.f) {
                    Log.d("PreCodeCacheManager", "code cache master id - " + str);
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public final void r(@NonNull d32 d32Var, PrefetchEvent prefetchEvent) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, d32Var, prefetchEvent) == null) {
                if (u62.f) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                PrefetchEvent.c h = h(prefetchEvent, "preload");
                if (h != null) {
                    be2.a(d32Var, h);
                    if (u62.f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis - j) + "ms");
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public boolean b;
        public final BlockingQueue<PrefetchEvent> c;
        public final AtomicInteger d;
        public c e;
        public int f;

        public b(int i, @NonNull BlockingQueue<PrefetchEvent> blockingQueue, @NonNull AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), blockingQueue, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = 0;
            this.a = i <= 0 ? 30 : i;
            this.b = false;
            this.c = blockingQueue;
            this.d = atomicInteger;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b = true;
                this.d.decrementAndGet();
                b();
                if (u62.f) {
                    Log.d("PreCodeCacheManager", "CodeCacheFillTask destroy");
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c cVar = this.e;
                if (cVar != null) {
                    cVar.k();
                    this.e = null;
                }
                if (u62.f) {
                    Log.d("PreCodeCacheManager", "master destroy");
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                int i = this.f + 1;
                this.f = i;
                if (i >= 10) {
                    this.f = 0;
                    b();
                }
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ExecutorUtilsExt.postOnElastic(this, "code_cache_fill_thread", 3);
            }
        }

        public final void c(PrefetchEvent prefetchEvent) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
                if (this.e == null) {
                    this.e = d();
                }
                if (this.e == null) {
                    a();
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.e.l(prefetchEvent.appPath, prefetchEvent, countDownLatch);
                countDownLatch.await(3L, TimeUnit.SECONDS);
                f();
            }
        }

        public final c d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (za2.U().k0() && e()) {
                    return new c(null);
                }
                if (u62.f) {
                    Log.d("PreCodeCacheManager", "v8 master can not create");
                }
                return null;
            }
            return (c) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                while (!this.b) {
                    try {
                        try {
                            PrefetchEvent poll = this.c.poll(this.a, TimeUnit.SECONDS);
                            if (poll == null) {
                                a();
                            } else {
                                c(poll);
                            }
                        } catch (InterruptedException e) {
                            if (u62.f) {
                                e.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (u62.f) {
                            th.printStackTrace();
                        }
                        a();
                        return;
                    }
                }
            }
        }

        public final boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean c = za2.v.c();
                String Y = za2.U().Y();
                if (!TextUtils.isEmpty(Y) && new File(Y).exists()) {
                    z = true;
                } else {
                    z = false;
                }
                aa3 c2 = y93.c();
                if (za2.U().s0() && c && z && c2.b()) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948162872, "Lcom/baidu/tieba/u62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948162872, "Lcom/baidu/tieba/u62;");
                return;
            }
        }
        f = pk1.a;
    }

    public static u62 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (u62.class) {
                    if (g == null) {
                        g = new u62();
                    }
                }
            }
            return g;
        }
        return (u62) invokeV.objValue;
    }

    public final e13 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e13 e = g13.k().e();
            if (e != null && !e.E()) {
                return e;
            }
            return null;
        }
        return (e13) invokeV.objValue;
    }

    public final b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new b(30, this.a, this.b);
        }
        return (b) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !ProcessUtils.isMainProcess()) {
            return;
        }
        g13.k().b(this);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d = true;
            p();
        }
    }

    public u62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedBlockingQueue();
        this.b = new AtomicInteger(0);
        this.c = 1;
        this.e = new ArrayList();
        m();
        if (f) {
            Log.d("PreCodeCacheManager", "max master size - " + this.c);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.a.size() > 0 && this.b.get() < this.c) {
            if (this.b.incrementAndGet() > this.c) {
                this.b.decrementAndGet();
                return;
            }
            j().g();
            if (f) {
                Log.d("PreCodeCacheManager", "start a new code cache fill task");
                Log.d("PreCodeCacheManager", "master size - " + this.b.get());
            }
        }
    }

    @Override // com.baidu.tieba.c13
    public void a(String str, e13 e13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, e13Var) == null) && TextUtils.equals(str, "event_puppet_online") && !e13Var.E()) {
            n(e13Var);
        }
    }

    public final PrefetchEvent b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            PrefetchEvent.b bVar = new PrefetchEvent.b();
            bVar.a(str);
            bVar.e("show");
            bVar.c("fill_code_cache");
            PrefetchEvent b2 = bVar.b();
            b2.appPath = str2;
            b2.pageType = "main";
            return b2;
        }
        return (PrefetchEvent) invokeLL.objValue;
    }

    public final boolean c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            if ((ProcessUtils.isMainProcess() && !zh3.G() && !mn2.w0().c()) || TextUtils.isEmpty(str) || j <= 0) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public final void d(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, prefetchEvent) == null) {
            this.a.offer(prefetchEvent);
            if (this.d) {
                p();
            }
        }
    }

    public final synchronized void l(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            synchronized (this) {
                if (bundle == null) {
                    return;
                }
                this.e.add(bundle);
                if (f) {
                    Log.d("PreCodeCacheManager", "add fill code cache msg to cache");
                }
            }
        }
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048580, this, str, j) != null) || !c(str, j) || ProcessUtils.isMainProcess()) {
            return;
        }
        if (f) {
            Log.d("PreCodeCacheManager", "start to fill code cache app - " + str + " , version - " + j);
        }
        d(b(str, bn2.e.i(str, String.valueOf(j)).getPath() + File.separator));
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048581, this, str, j) != null) || !ProcessUtils.isMainProcess() || !c(str, j)) {
            return;
        }
        e13 h = h();
        if (h == null) {
            if (f) {
                Log.d("PreCodeCacheManager", "there is no blank client");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("cc_app_id", str);
        bundle.putLong("cc_app_version", j);
        if (h.T()) {
            o(h, bundle);
        } else {
            l(bundle);
        }
    }

    public final void o(e13 e13Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, e13Var, bundle) == null) {
            v03 e = v03.e();
            x03 x03Var = new x03(130, bundle);
            x03Var.b(e13Var.b);
            e.h(x03Var);
            if (f) {
                Log.d("PreCodeCacheManager", "current process - " + e13Var.b.index);
            }
        }
    }

    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, bundle) != null) || bundle == null || bundle.size() <= 0 || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        e(bundle.getString("cc_app_id"), bundle.getLong("cc_app_version"));
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("master")) {
                return false;
            }
            String substring = str.substring(6);
            if (!TextUtils.isDigitsOnly(substring)) {
                return false;
            }
            try {
                i = Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
                i = 0;
            }
            if (i < 1000) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized void n(e13 e13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, e13Var) == null) {
            synchronized (this) {
                if (this.e.size() <= 0) {
                    return;
                }
                if (f) {
                    Log.d("PreCodeCacheManager", "send msg from cache");
                }
                for (Bundle bundle : this.e) {
                    o(e13Var, bundle);
                }
                this.e.clear();
            }
        }
    }
}
