package com.baidu.tieba;

import android.util.Log;
import android.view.Choreographer;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class rd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public class b extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final ExecutorService a;
            public final AtomicInteger b;
            public final List<Float> c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ int e;
            public final /* synthetic */ Timer f;
            public final /* synthetic */ qd3 g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ b i;

            /* renamed from: com.baidu.tieba.rd3$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0404a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public RunnableC0404a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Float f;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        float b = s52.b();
                        this.a.g.d.add(Long.valueOf(System.currentTimeMillis()));
                        b bVar = this.a;
                        bVar.g.e.add(Integer.valueOf(bVar.i.b.get()));
                        this.a.g.f.add(Float.valueOf(b));
                        t52.c i = t52.i();
                        this.a.g.h.add(Float.valueOf(i.a));
                        this.a.g.i.add(Float.valueOf(i.b));
                        this.a.g.g.add(Float.valueOf(i.c));
                        List<Float> list = this.a.c;
                        if (kl3.D()) {
                            f = Float.valueOf(b);
                        } else {
                            f = null;
                        }
                        list.add(f);
                    }
                }
            }

            public b(a aVar, boolean z, int i, Timer timer, qd3 qd3Var, boolean z2, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Boolean.valueOf(z), Integer.valueOf(i), timer, qd3Var, Boolean.valueOf(z2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = z;
                this.e = i;
                this.f = timer;
                this.g = qd3Var;
                this.h = z2;
                this.i = bVar;
                this.a = Executors.newCachedThreadPool();
                this.b = new AtomicInteger(0);
                this.c = new CopyOnWriteArrayList();
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.d && this.b.getAndIncrement() >= this.e) {
                        rd3.l(true);
                    }
                    if (!rd3.b) {
                        this.f.cancel();
                        this.a.shutdown();
                        t42.b("SwanAppStabilityDataUtil", "采集静态数据");
                        this.g.b = t52.e().floatValue();
                        this.g.c = dd2.k().m(s73.K().getAppId(), true);
                        this.g.a(this.c);
                        t42.i("SwanAppStabilityDataUtil", "采集结果：" + this.g);
                        if (rd3.c) {
                            t42.b("SwanAppStabilityDataUtil", "发送JSMessage=" + this.g);
                            rd3.i(this.g);
                        }
                        if (this.h) {
                            q13.e(this.g.c());
                            return;
                        }
                        return;
                    }
                    this.a.submit(new RunnableC0404a(this));
                }
            }
        }

        /* renamed from: com.baidu.tieba.rd3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0403a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public RunnableC0403a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().postFrameCallback(this.a);
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qd3 qd3Var = new qd3();
                qd3Var.a = sd3.d(qd3Var.a);
                boolean f = sd3.f();
                int c = sd3.c(0);
                if (sd3.e(0) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                Timer timer = new Timer();
                b bVar = new b(null);
                nl3.e0(new RunnableC0403a(this, bVar));
                timer.schedule(new b(this, f, c, timer, qd3Var, z, bVar), 0L, qd3Var.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public AtomicInteger b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Choreographer.getInstance().removeFrameCallback(this.a);
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = -1L;
            this.b = new AtomicInteger(-1);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                if (!rd3.b) {
                    nl3.e0(new a(this));
                    return;
                }
                long j2 = this.a;
                if (j2 > 0 && this.b.get() != (i = (int) (1.0E9d / (j - j2)))) {
                    this.b.set(i);
                    t42.b("SwanAppStabilityDataUtil", "#doFrame fps=" + this.b);
                }
                this.a = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117736, "Lcom/baidu/tieba/rd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117736, "Lcom/baidu/tieba/rd3;");
                return;
            }
        }
        a = do1.a;
        b = false;
        c = false;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sd3.g() && e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (!mi2.a() && !x62.c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (sd3.h() && e()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return sd3.f();
        }
        return invokeV.booleanValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            if (b) {
                t42.i("SwanAppStabilityDataUtil", "#startObtainData 正在采集中，退出");
                return;
            }
            b = true;
            t42.i("SwanAppStabilityDataUtil", "#startObtainData 开始采集数据");
            ExecutorUtilsExt.postOnElastic(new a(), "稳定性工具链-设备数据采集", 3);
        }
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            c = z;
            b = false;
            sd3.b();
            t42.b("SwanAppStabilityDataUtil", "#stopObtainData 已停止采集数据");
        }
    }

    public static synchronized void h(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, str) == null) {
            synchronized (rd3.class) {
                pd3.c(jSONObject, str);
            }
        }
    }

    public static void i(qd3 qd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, qd3Var) == null) {
            Map<String, String> d = qd3Var.d();
            if (a) {
                Log.d("SwanAppStabilityDataUtil", "#sendJsMessage data=" + JSONObject.wrap(d));
            }
            gt2.U().u(new uh2("sendStabilityData", d));
        }
    }

    public static void j(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            HashMap hashMap = new HashMap();
            if (z) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put("status", str);
            gt2.U().u(new uh2("toggleStabilityTestStatus", hashMap));
        }
    }
}
