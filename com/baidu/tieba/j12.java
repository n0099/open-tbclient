package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jf3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes4.dex */
public class j12 {
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
    public ConcurrentMap e;
    public boolean f;
    public int g;
    public int h;

    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ j12 b;

        public b(j12 j12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j12Var;
        }

        public /* synthetic */ b(j12 j12Var, a aVar) {
            this(j12Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = true;
                String a = l12.a();
                if (!TextUtils.isEmpty(a)) {
                    this.b.e.put("cpu", a);
                }
                this.a = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public final /* synthetic */ j12 c;

        public c(j12 j12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j12Var;
            this.a = -1L;
            this.b = -1;
        }

        public /* synthetic */ c(j12 j12Var, a aVar) {
            this(j12Var);
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

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public static final j12 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-740778274, "Lcom/baidu/tieba/j12$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-740778274, "Lcom/baidu/tieba/j12$d;");
                    return;
                }
            }
            a = new j12(null);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j12 a;

        public e(j12 j12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j12Var;
        }

        public /* synthetic */ e(j12 j12Var, a aVar) {
            this(j12Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.e != null) {
                this.a.f();
                this.a.e.put("mem", Long.valueOf(((ActivityManager) tm2.c().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
                if (this.a.a != null) {
                    this.a.a.sendEmptyMessageDelayed(0, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements jf3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j12 a;

        public f(j12 j12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j12Var;
        }

        public /* synthetic */ f(j12 j12Var, a aVar) {
            this(j12Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(Set set) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) && set != null && set.size() > 0) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    hf3 hf3Var = (hf3) it.next();
                    this.a.e.put(hf3Var.a, hf3Var.a());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830366, "Lcom/baidu/tieba/j12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830366, "Lcom/baidu/tieba/j12;");
                return;
            }
        }
        i = wj1.a;
        j = if3.d.a;
        k = if3.b.a;
        l = if3.c.a;
        String str = if3.g.a;
        m = if3.i.a;
        n = if3.e.a;
        o = if3.f.a;
        p = if3.h.a;
        q = if3.j.a;
        r = if3.k.a;
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
                jf3.a().j(this.b, new hf3[0]);
                this.b = null;
            }
            this.c = null;
            this.d = null;
            if (i) {
                Log.d("PropertyMonitor", "Stop system monitor");
            }
        }
    }

    public j12() {
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

    public static j12 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return d.a;
        }
        return (j12) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.d.a) {
            gg3.k(this.d, "swanAppCpuMonitor");
        }
    }

    public Map h() {
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

    public /* synthetic */ j12(a aVar) {
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
            jf3.a().g(this.b, if3.d, if3.b, if3.c, if3.i, if3.e, if3.f, if3.g, if3.h, if3.j, if3.k);
            e eVar = new e(this, null);
            this.a = eVar;
            eVar.sendEmptyMessage(0);
            if (i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }
}
