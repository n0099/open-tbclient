package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.qj3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes5.dex */
public class q52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public f b;
    public c c;
    public b d;
    public ConcurrentMap<String, Object> e;
    public boolean f;
    public int g;
    public int h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ q52 b;

        public b(q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q52Var;
        }

        public /* synthetic */ b(q52 q52Var, a aVar) {
            this(q52Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = true;
                String a = s52.a();
                if (!TextUtils.isEmpty(a)) {
                    this.b.e.put("cpu", a);
                }
                this.a = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public final /* synthetic */ q52 c;

        public c(q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q52Var;
            this.a = -1L;
            this.b = -1;
        }

        public /* synthetic */ c(q52 q52Var, a aVar) {
            this(q52Var);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(1048576, this, j) != null) || !this.c.f) {
                return;
            }
            long j2 = this.a;
            if (j2 > 0 && this.b != (i = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                this.b = i;
                this.c.e.put("frame", Integer.valueOf(i));
            }
            this.a = j;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final q52 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-536680133, "Lcom/baidu/tieba/q52$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-536680133, "Lcom/baidu/tieba/q52$d;");
                    return;
                }
            }
            a = new q52(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q52 a;

        public e(q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q52Var;
        }

        public /* synthetic */ e(q52 q52Var, a aVar) {
            this(q52Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.e != null) {
                this.a.f();
                this.a.e.put("mem", Long.valueOf(((ActivityManager) ar2.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (this.a.a != null) {
                    this.a.a.sendEmptyMessageDelayed(0, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements qj3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q52 a;

        public f(q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q52Var;
        }

        public /* synthetic */ f(q52 q52Var, a aVar) {
            this(q52Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(Set<oj3<?>> set) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) && set != null && set.size() > 0) {
                for (oj3<?> oj3Var : set) {
                    this.a.e.put(oj3Var.a, oj3Var.a());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948042747, "Lcom/baidu/tieba/q52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948042747, "Lcom/baidu/tieba/q52;");
                return;
            }
        }
        i = do1.a;
        j = pj3.d.a;
        k = pj3.b.a;
        l = pj3.c.a;
        String str = pj3.g.a;
        m = pj3.i.a;
        n = pj3.e.a;
        o = pj3.f.a;
        p = pj3.h.a;
        q = pj3.j.a;
        r = pj3.k.a;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f) {
                if (i) {
                    Log.d("PropertyMonitor", "System monitor not started yet");
                    return;
                }
                return;
            }
            this.f = false;
            e eVar = this.a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.a = null;
            }
            if (this.b != null) {
                qj3.a().j(this.b, new oj3[0]);
                this.b = null;
            }
            this.c = null;
            this.d = null;
            if (i) {
                Log.d("PropertyMonitor", "Stop system monitor");
            }
        }
    }

    public q52() {
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
        this.e = new ConcurrentHashMap();
        this.g = 1000;
    }

    public static q52 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return d.a;
        }
        return (q52) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.d.a) {
            nk3.k(this.d, "swanAppCpuMonitor");
        }
    }

    public Map<String, Object> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.h++;
            j();
            return this.e;
        }
        return (Map) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.h - 1;
            this.h = i2;
            if (i2 <= 0) {
                k();
            }
        }
    }

    public /* synthetic */ q52(a aVar) {
        this();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f) {
                if (i) {
                    Log.d("PropertyMonitor", "System monitor already started");
                    return;
                }
                return;
            }
            this.f = true;
            this.c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.c);
            this.d = new b(this, null);
            this.b = new f(this, null);
            qj3.a().g(this.b, pj3.d, pj3.b, pj3.c, pj3.i, pj3.e, pj3.f, pj3.g, pj3.h, pj3.j, pj3.k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            if (i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }
}
