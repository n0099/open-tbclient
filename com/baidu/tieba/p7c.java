package com.baidu.tieba;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o4c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.render.RenderEngine;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class p7c implements j2c, g2c {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AtomicBoolean v;
    public static volatile p7c w;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final boolean d;
    public final int e;
    public n7c f;
    public HashMap<String, String> g;
    public Context h;
    public WeakReference<k7c> i;
    public final List<j7c> j;
    public final List<j7c> k;
    public int l;
    public int m;
    public AtomicBoolean n;
    public AtomicBoolean o;
    public final AtomicBoolean p;
    public final Queue<Long> q;
    public final AtomicBoolean r;
    public Handler s;
    public HashMap<String, String> t;
    public o4c.a u;

    /* loaded from: classes7.dex */
    public class a implements o4c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ p7c b;

        public a(p7c p7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p7cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p7cVar;
            this.a = 0L;
        }

        @Override // com.baidu.tieba.o4c.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    TLog.m("[PreferenceSubProcess]", "PreferenceSubProcess app background");
                    this.b.r.set(false);
                }
            }
        }

        @Override // com.baidu.tieba.o4c.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                synchronized (this) {
                    if (j <= this.a) {
                        return;
                    }
                    this.a = j;
                    this.b.r.set(true);
                    TLog.m("[PreferenceSubProcess]", "PreferenceSubProcess app front ground");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p7c a;

        public b(p7c p7cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p7cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p7cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = false;
                if (!this.a.p.get() && p7c.v.compareAndSet(false, true)) {
                    z = true;
                }
                if (z) {
                    TLog.h("[PreferenceSubProcess]", "init render engine onInitTimeout.");
                    c7c.b(true);
                    if (this.a.o.get()) {
                        str = "initRenderEngineFail";
                    } else {
                        str = "initTimeout";
                    }
                    TLog.h("[PreferenceSubProcess]", "close RenderEngine!!!");
                    RenderEngine.r.a().D(this.a);
                    RenderEngine.r.a().C(this.a);
                    n3c.h().g();
                    this.a.t(str);
                    TLog.h("[PreferenceSubProcess]", "onInitTimeout: destroy RenderEngine!!!");
                    RenderEngine.r.a().s();
                    for (j7c j7cVar : this.a.k) {
                        j7cVar.a(str, p7c.v.get(), new HashMap<>());
                    }
                    for (j7c j7cVar2 : this.a.j) {
                        j7cVar2.a(str, p7c.v.get(), new HashMap<>());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016397, "Lcom/baidu/tieba/p7c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016397, "Lcom/baidu/tieba/p7c;");
                return;
            }
        }
        v = new AtomicBoolean(false);
        w = null;
    }

    public static p7c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (w == null) {
                synchronized (p7c.class) {
                    if (w == null) {
                        w = new p7c();
                        q7c.c();
                    }
                }
            }
            return w;
        }
        return (p7c) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return v.get();
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p.get();
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.s == null) {
            return;
        }
        TLog.h("[PreferenceSubProcess]", "stopInitTimeout");
        this.s.removeCallbacksAndMessages(null);
    }

    public p7c() {
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
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(true);
        new AtomicBoolean(false);
        this.e = hashCode();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new WeakReference<>(null);
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.l = 0;
        this.m = 0;
        this.n = new AtomicBoolean(true);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new LinkedList();
        this.r = new AtomicBoolean(true);
        this.s = null;
        this.t = null;
        this.u = new a(this);
        boolean x = RenderEngine.r.a().x();
        this.d = x;
        if (x) {
            this.f = new n7c(String.valueOf(this.e));
            this.s = new Handler(Looper.getMainLooper());
        } else {
            TLog.m("[PreferenceSubProcess]", "subprocess is not support in current devices!!");
        }
        c7c.d(this.d);
        o4c.b(this.u);
        TLog.h("[PreferenceSubProcess]", "PreferenceSubProcess constor");
    }

    public final void p() {
        boolean v2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TLog.h("[PreferenceSubProcess]", "initSubProcessInternal begin !!!");
            boolean z = false;
            if (this.h != null && this.a.compareAndSet(false, true)) {
                TLog.h("[PreferenceSubProcess]", "do initSubProcessInternal!!!");
                RenderEngine.r.a().r(this);
                n3c.h().i();
                if (this.c.compareAndSet(true, false)) {
                    TLog.h("[PreferenceSubProcess]", "initSubProcessInternal, init RenderEngine");
                    if (this.t == null) {
                        this.t = new HashMap<>();
                    }
                    String v3 = j5c.v(this.h);
                    if (v3 != null) {
                        this.t.put("nativeLib", v3);
                    }
                    if (this.t == null) {
                        v2 = RenderEngine.r.a().u(this.h, this);
                    } else {
                        v2 = RenderEngine.r.a().v(this.h, this, this.t);
                    }
                    this.n.set(v2);
                    this.o.set(!v2);
                    if (!v2) {
                        v.set(true);
                        w();
                        TLog.h("[PreferenceSubProcess]", "initSubProcessInternal end, init RenderEngine Fail");
                    } else {
                        v();
                        TLog.h("[PreferenceSubProcess]", "initSubProcessInternal end, init RenderEngine success");
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("initSubProcessInternal end, but don't render engine this time, mFinistTimeInitEngineSuccess: ");
            sb.append(this.n.get());
            sb.append(", mAppContext: ");
            if (this.h != null) {
                z = true;
            }
            sb.append(z);
            sb.append(", renderEngineInited: ");
            sb.append(this.a.get());
            TLog.h("[PreferenceSubProcess]", sb.toString());
        }
    }

    public boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (this.d) {
                this.h = context;
                if (context != null) {
                    this.h = context.getApplicationContext();
                }
                p();
                return this.n.get();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, hashMap) == null) && this.d) {
            this.g = hashMap;
            if (this.b.get()) {
                this.f.s(hashMap);
            }
        }
    }

    public void j(j7c j7cVar, boolean z) {
        List<j7c> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, j7cVar, z) == null) && this.d && j7cVar != null) {
            if (z) {
                list = this.k;
            } else {
                list = this.j;
            }
            if (!list.contains(j7cVar)) {
                list.add(j7cVar);
            }
        }
    }

    @Override // com.baidu.tieba.g2c
    public void a(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            TLog.h("[PreferenceSubProcess]", "on service crash: " + str);
            boolean z = v.get() ^ true;
            s(str);
            t(str);
            if (this.b.compareAndSet(true, false)) {
                TLog.h("[PreferenceSubProcess]", "close msg client!!!");
                this.f.a();
            }
            if (this.a.get()) {
                TLog.h("[PreferenceSubProcess]", "close RenderEngine!!!");
                RenderEngine.r.a().D(this);
                RenderEngine.r.a().C(this);
            }
            n3c.h().g();
            this.a.set(false);
            this.c.set(true);
            if (!v.get()) {
                p();
            } else {
                TLog.h("[PreferenceSubProcess]", "on service crash, destroy RenderEngine!!!");
                RenderEngine.r.a().s();
            }
            if (z) {
                for (j7c j7cVar : this.k) {
                    j7cVar.a(str, v.get(), new HashMap<>());
                }
                for (j7c j7cVar2 : this.j) {
                    j7cVar2.a(str, v.get(), new HashMap<>());
                }
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            int d = q7c.c().d();
            int i = q7c.c().i();
            int f = q7c.c().f();
            int a2 = q7c.c().a();
            int b2 = q7c.c().b();
            HashMap hashMap = new HashMap();
            hashMap.put("playercnt", String.valueOf(d));
            hashMap.put("playtask", String.valueOf(i));
            hashMap.put("livetask", String.valueOf(f));
            hashMap.put("frontground", String.valueOf(this.r.get() ? 1 : 0));
            hashMap.put("fail2Main", String.valueOf(v.get() ? 1 : 0));
            hashMap.put("crashcnt", String.valueOf(this.l));
            hashMap.put("rctCrashCnt", String.valueOf(this.m));
            hashMap.put("downloadclient", String.valueOf(a2));
            hashMap.put("downloadTask", String.valueOf(b2));
            StringBuilder sb = new StringBuilder("");
            sb.append("crashReason=");
            sb.append(str);
            sb.append("&playercnt=");
            sb.append(d);
            sb.append("&playtask=");
            sb.append(i);
            sb.append("&livetask=");
            sb.append(f);
            sb.append("&frontground=");
            sb.append(this.r.get() ? 1 : 0);
            sb.append("&fail2Main=");
            sb.append(v.get() ? 1 : 0);
            sb.append("&crashcnt=");
            sb.append(this.l);
            sb.append("&rctCrashCnt=");
            sb.append(this.m);
            sb.append("&downloadclient=");
            sb.append(a2);
            sb.append("&downloadTask=");
            sb.append(b2);
            TLog.h("[PreferenceSubProcess]", sb.toString());
            l7c d2 = Preference.d();
            if (d2 != null) {
                d2.a(1, sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.j2c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TLog.h("[PreferenceSubProcess]", "on service connect");
            w();
            this.p.set(true);
            if (v.get()) {
                TLog.h("[PreferenceSubProcess]", "on service connect fail over to main process, destroy the renderEngine and return");
                RenderEngine.r.a().s();
                return;
            }
            this.o.set(false);
            if (this.b.compareAndSet(false, true)) {
                TLog.h("[PreferenceSubProcess]", "init msg client!!!");
                this.f.c(o7c.class);
                this.f.q();
                HashMap<String, String> hashMap = this.g;
                if (hashMap != null) {
                    this.f.s(hashMap);
                }
            }
            k7c k7cVar = this.i.get();
            if (k7cVar != null) {
                k7cVar.a();
            }
        }
    }

    public final int l() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap<String, String> hashMap = this.g;
            int i2 = 1;
            if (hashMap != null && (str = hashMap.get("MC_SUBPROCESS_CRASH_LIMIT")) != null) {
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    TLog.g(this, "mMediaConfig, crashCntLimitKey-" + str + ": " + e.toString());
                }
                if (i >= 0 && i <= 100) {
                    i2 = i;
                }
                TLog.h("[PreferenceSubProcess]", "getCrashCntLimit: " + i2);
                return i2;
            }
            i = 1;
            if (i >= 0) {
                i2 = i;
            }
            TLog.h("[PreferenceSubProcess]", "getCrashCntLimit: " + i2);
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m() {
        InterceptResult invokeV;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap<String, String> hashMap = this.g;
            int i2 = 15000;
            if (hashMap != null && (str = hashMap.get("MC_SUBPROCESS_INIT_TIMEOUT")) != null) {
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                    TLog.g(this, "mMediaConfig, Subprocess InitTimeoutMs-" + str + ": " + e.toString());
                }
                if (i >= 5000 && i <= 180000) {
                    i2 = i;
                }
                if (this.o.get()) {
                    i2 = 3000;
                }
                TLog.h("[PreferenceSubProcess]", "getInitTimeoutMs: " + i2);
                return i2;
            }
            i = 15000;
            if (i >= 5000) {
                i2 = i;
            }
            if (this.o.get()) {
            }
            TLog.h("[PreferenceSubProcess]", "getInitTimeoutMs: " + i2);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.j2c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TLog.h("[PreferenceSubProcess]", "on service disconnect");
            this.p.set(false);
            if (this.h != null && !v.get()) {
                TLog.h("[PreferenceSubProcess]", "onDisconnect, init RenderEngine again");
                if (this.t == null) {
                    this.o.set(!RenderEngine.r.a().u(this.h, this));
                } else {
                    this.o.set(!RenderEngine.r.a().v(this.h, this, this.t));
                }
                v();
            }
        }
    }

    public final void s(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.l++;
            long currentTimeMillis = System.currentTimeMillis();
            this.q.offer(Long.valueOf(currentTimeMillis));
            this.m = this.q.size();
            TLog.h("[PreferenceSubProcess]", "onCrashCheck, time:" + currentTimeMillis + ",crashCnt:" + this.m);
            if (this.m > l()) {
                Long poll = this.q.poll();
                if (poll != null && currentTimeMillis - poll.longValue() < 300000) {
                    TLog.h("[PreferenceSubProcess]", "onCrashCheck##fail over to main process, crash cnt:" + this.m + ", first:" + poll + ", now:" + currentTimeMillis + ",interval:" + (currentTimeMillis - poll.longValue()) + "ms");
                    v.set(true);
                    c7c.b(true);
                    return;
                }
                int i = this.m;
                if (i > 0) {
                    this.m = i - 1;
                }
            }
        }
    }

    public final void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (handler = this.s) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        TLog.h("[PreferenceSubProcess]", "startInitTimeout");
        if (!v.get()) {
            this.s.postDelayed(new b(this), m());
        }
    }
}
