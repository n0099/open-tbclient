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
import com.baidu.tieba.lg2;
import com.baidu.tieba.o72;
import com.baidu.tieba.qf2;
import com.baidu.tieba.sr2;
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
/* loaded from: classes5.dex */
public class lb2 implements t53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile lb2 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<PrefetchEvent> a;
    public final AtomicInteger b;
    public final int c;
    public volatile boolean d;
    public final List<Bundle> e;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.t53
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final AtomicInteger e;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean a;
        public volatile sa2 b;
        public final List<hb2> c;
        public final List<String> d;

        /* renamed from: com.baidu.tieba.lb2$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0329c extends wa2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c f;

            /* renamed from: com.baidu.tieba.lb2$c$c$a */
            /* loaded from: classes5.dex */
            public class a extends va2 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0329c e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(C0329c c0329c, String str, String str2) {
                    super(str, str2);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0329c, str, str2};
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
                    this.e = c0329c;
                }

                @Override // com.baidu.tieba.va2
                public lg2 e() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        lg2.b bVar = new lg2.b();
                        bVar.c(1);
                        bVar.b(this.e.f.n());
                        return bVar.a();
                    }
                    return (lg2) invokeV.objValue;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0329c(c cVar, Context context) {
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

            @Override // com.baidu.tieba.wa2
            public va2 h(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    return new a(this, str, "runtime/index.js");
                }
                return (va2) invokeL.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class a implements hb2 {
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

            @Override // com.baidu.tieba.hb2
            public void onReady() {
                u72 f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.d.b != null && (f = this.d.b.f()) != null && !f.isDestroyed()) {
                        this.d.s(this.a, f);
                        this.d.r(f, this.b);
                        if (lb2.f) {
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

        /* loaded from: classes5.dex */
        public class b extends k72 {
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

            @Override // com.baidu.tieba.k72
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (lb2.f) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-638267474, "Lcom/baidu/tieba/lb2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-638267474, "Lcom/baidu/tieba/lb2$c;");
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

        public final sa2 j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new C0329c(this, AppRuntime.getAppContext());
            }
            return (sa2) invokeV.objValue;
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
                    for (hb2 hb2Var : this.c) {
                        if (hb2Var != null) {
                            hb2Var.onReady();
                        }
                    }
                    this.c.clear();
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public final synchronized void g(hb2 hb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hb2Var) == null) {
                synchronized (this) {
                    if (hb2Var == null) {
                        return;
                    }
                    if (this.a) {
                        hb2Var.onReady();
                        return;
                    }
                    if (!this.c.contains(hb2Var)) {
                        this.c.add(hb2Var);
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
                if (!sr2.z(file) || !sr2.y(file)) {
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
                    if (lb2.f) {
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

        public final void s(String str, u72 u72Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048588, this, str, u72Var) == null) && (u72Var instanceof eg2)) {
                ((eg2) u72Var).B0(m());
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
                String m = sr2.m(new File(file, "app.json"));
                prefetchEvent.appConfig = m;
                hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m);
                SwanAppConfigData c = SwanAppConfigData.c(prefetchEvent.appConfig, file);
                if (c == null || p(c)) {
                    return null;
                }
                String f = c.f();
                prefetchEvent.pageUrl = f;
                hashMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, f);
                String f2 = om3.f(prefetchEvent.pageUrl);
                String o = om3.o(prefetchEvent.pageUrl);
                String c2 = oc3.c(f2, c);
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

        public final sa2 i() {
            InterceptResult invokeV;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (lb2.f) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                sa2 j2 = j();
                j2.loadUrl(om3.w(qf2.U().Y()));
                j2.b(new b(this, j));
                return j2;
            }
            return (sa2) invokeV.objValue;
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
                o72.a d = o72.b.d();
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
                if (lb2.f) {
                    Log.d("PreCodeCacheManager", "code cache master id - " + str);
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public final void r(@NonNull u72 u72Var, PrefetchEvent prefetchEvent) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, u72Var, prefetchEvent) == null) {
                if (lb2.f) {
                    j = System.currentTimeMillis();
                } else {
                    j = 0;
                }
                PrefetchEvent.c h = h(prefetchEvent, "preload");
                if (h != null) {
                    si2.a(u72Var, h);
                    if (lb2.f) {
                        long currentTimeMillis = System.currentTimeMillis();
                        Log.d("PreCodeCacheManager", "send code cache msg cost - " + (currentTimeMillis - j) + "ms");
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (lb2.f) {
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
                if (lb2.f) {
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
                if (qf2.U().k0() && e()) {
                    return new c(null);
                }
                if (lb2.f) {
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
                            if (lb2.f) {
                                e.printStackTrace();
                            }
                            a();
                        }
                    } catch (Throwable th) {
                        if (lb2.f) {
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
                boolean c = qf2.v.c();
                String Y = qf2.U().Y();
                if (!TextUtils.isEmpty(Y) && new File(Y).exists()) {
                    z = true;
                } else {
                    z = false;
                }
                re3 c2 = pe3.c();
                if (qf2.U().s0() && c && z && c2.b()) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947937037, "Lcom/baidu/tieba/lb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947937037, "Lcom/baidu/tieba/lb2;");
                return;
            }
        }
        f = gp1.a;
    }

    public static lb2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (lb2.class) {
                    if (g == null) {
                        g = new lb2();
                    }
                }
            }
            return g;
        }
        return (lb2) invokeV.objValue;
    }

    public final v53 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            v53 e = x53.k().e();
            if (e != null && !e.E()) {
                return e;
            }
            return null;
        }
        return (v53) invokeV.objValue;
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
        x53.k().b(this);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d = true;
            p();
        }
    }

    public lb2() {
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

    @Override // com.baidu.tieba.t53
    public void a(String str, v53 v53Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, v53Var) == null) && TextUtils.equals(str, "event_puppet_online") && !v53Var.E()) {
            n(v53Var);
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
            if ((ProcessUtils.isMainProcess() && !qm3.G() && !ds2.w0().c()) || TextUtils.isEmpty(str) || j <= 0) {
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
        d(b(str, sr2.e.i(str, String.valueOf(j)).getPath() + File.separator));
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048581, this, str, j) != null) || !ProcessUtils.isMainProcess() || !c(str, j)) {
            return;
        }
        v53 h = h();
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

    public final void o(v53 v53Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, v53Var, bundle) == null) {
            m53 e = m53.e();
            o53 o53Var = new o53(130, bundle);
            o53Var.b(v53Var.b);
            e.h(o53Var);
            if (f) {
                Log.d("PreCodeCacheManager", "current process - " + v53Var.b.index);
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

    public final synchronized void n(v53 v53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, v53Var) == null) {
            synchronized (this) {
                if (this.e.size() <= 0) {
                    return;
                }
                if (f) {
                    Log.d("PreCodeCacheManager", "send msg from cache");
                }
                for (Bundle bundle : this.e) {
                    o(v53Var, bundle);
                }
                this.e.clear();
            }
        }
    }
}
