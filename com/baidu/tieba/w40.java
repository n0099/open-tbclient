package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.o40;
import com.baidu.tieba.r40;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.ExceptionCode;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class w40 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l40 L;
    public static volatile w40 M;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public long H;
    public String I;
    public QuicMessageHandler.c J;
    public Runnable K;
    public String a;
    public String b;
    public AtomicInteger c;
    public int d;
    public boolean e;
    public volatile LinkedList<t40> f;
    public final HashMap<Long, t40> g;
    public final Object h;
    public final Object i;
    public c50 j;
    public Map<Long, q40> k;
    public Map<Long, q40> l;
    public i m;
    public h n;
    public g o;
    public boolean p;
    public AtomicInteger q;
    public Context r;
    public u40 s;
    public k t;
    public j u;
    public HandlerThread v;
    public f w;
    @SuppressLint({"MobilebdThread"})
    public Thread x;
    public AtomicBoolean y;
    public AtomicBoolean z;

    public final long R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 3) {
                return i2 * 1000;
            }
            return 3000L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a implements QuicMessageHandler.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w40 a;

        /* renamed from: com.baidu.tieba.w40$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0510a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0510a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && w40.L.a != -2) {
                    w40 w40Var = this.a.a;
                    w40Var.V("quic connect close ", w40Var.B, false);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.a.z.getAndSet(true)) {
                    this.a.a.w.removeCallbacks(this.a.a.t);
                    p50.O(this.a.a.r, "");
                    w40 w40Var = this.a.a;
                    w40Var.x0("quic receive server error: APPLICATION CLOSE", w40Var.B);
                    m40.h().f("lcp login failed:");
                    this.a.a.z.set(false);
                }
            }
        }

        public a(w40 w40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w40Var;
        }

        @Override // com.baidu.lcp.sdk.connect.QuicMessageHandler.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && w40.L.a != -2 && !this.a.w.hasMessages(303030)) {
                this.a.w.removeCallbacks(this.a.t);
                Message obtain = Message.obtain(this.a.w, new RunnableC0510a(this));
                obtain.what = 303030;
                this.a.w.sendMessage(obtain);
            }
        }

        @Override // com.baidu.lcp.sdk.connect.QuicMessageHandler.c
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.a.z.get()) {
                this.a.w.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ w40 d;

        /* loaded from: classes8.dex */
        public class a implements r40.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ b b;

            public a(b bVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = j;
            }

            @Override // com.baidu.tieba.r40.d
            public void a(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (n50.a) {
                        o50.b("SocketTransceiver", "DNS resolve result ip: " + str2 + " cost: " + (currentTimeMillis - this.a) + " ms");
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.b.a;
                    }
                    w40 w40Var = this.b.d;
                    w40Var.B = str2;
                    w40Var.F = this.b.d.F + " > dnsEnd: " + currentTimeMillis;
                    f40 g = e40.h(this.b.d.r).g(601110);
                    g.c("dns_end", currentTimeMillis);
                    g.d(ClientCookie.PORT_ATTR, this.b.b);
                    g.d("ip", str2);
                    g.d("domain", this.b.a);
                    g.d(ProbeTB.PROTOCOL, this.b.c);
                    g.d("con_err_code", "P31");
                    g.b("retry_cout", this.b.d.q.get());
                    g.b("connect_state", 2);
                    if (w40.L.a == -1) {
                        b bVar = this.b;
                        w40 w40Var2 = bVar.d;
                        new e(w40Var2, str2, bVar.b, Integer.valueOf(w40Var2.c.incrementAndGet())).run();
                        return;
                    }
                    w40 w40Var3 = this.b.d;
                    w40Var3.F = this.b.d.F + " > dnsEndExce: ";
                }
            }
        }

        public b(w40 w40Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w40Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                f40 g = e40.h(this.d.r).g(601110);
                g.c("dns_begin", System.currentTimeMillis());
                g.d("orig_protocol", this.d.G);
                w40 w40Var = this.d;
                w40Var.F = this.d.F + " > dnsStart: " + currentTimeMillis;
                r40.a(this.d.r).b(this.a, new a(this, currentTimeMillis));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ w40 d;

        /* loaded from: classes8.dex */
        public class a implements Callable<v40> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public v40 call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    w40 w40Var = this.a.d;
                    w40Var.F = this.a.d.F + " > socket: start: " + System.currentTimeMillis();
                    if (n50.a) {
                        o50.a("SocketTransceiver", "socketStateFutureTask star call()");
                    }
                    e40.h(this.a.d.r).g(601110).d("P22", "socket connect thread start");
                    return this.a.d.s.h(this.a.b, Integer.valueOf(this.a.a).intValue());
                }
                return (v40) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                Context context = this.a.d.r;
                String str = this.a.b;
                s40.a(context, str, "" + this.a.d.H);
                Context context2 = this.a.d.r;
                s40.b(context2, "" + this.a.d.H);
            }
        }

        public e(w40 w40Var, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w40Var;
            this.b = str;
            this.a = str2;
            this.c = num;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MobilebdThread"})
        public synchronized void run() {
            l50 a2;
            b bVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    if (n50.a) {
                        o50.a("SocketTransceiver", "start socket connect, connectTaskId: " + this.c + ", mPingLogId :" + this.d.H);
                    }
                    w40 w40Var = this.d;
                    w40Var.F = this.d.F + " > conn: start: " + System.currentTimeMillis();
                    try {
                    } catch (Exception e) {
                        if (n50.a) {
                            o50.c("SocketTransceiver", "socket connect by ConnectTask occur exception: ", e);
                        }
                        w40 w40Var2 = this.d;
                        w40Var2.V("socket connect by ConnectTask occur exception: " + e, this.b, true);
                        a2 = l50.a(this.d.r);
                        bVar = new b(this);
                    }
                    if (w40.L.a != -1) {
                        w40 w40Var3 = this.d;
                        w40Var3.F = this.d.F + " > conn: end1: " + System.currentTimeMillis();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "socketConnectState is " + this.d.Y() + ", return");
                        }
                        l50.a(this.d.r).b(new b(this));
                        return;
                    }
                    w40.L.a = -2;
                    if (this.d.P()) {
                        w40 w40Var4 = this.d;
                        w40Var4.F = this.d.F + " > conn: end2: " + System.currentTimeMillis();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                        }
                        f40 g = e40.h(this.d.r).g(601110);
                        g.d("P11", "socket create begin, but socket has created ok.");
                        g.d("con_err_code", "P11");
                        g.b("retry_cout", this.d.q.get());
                        this.d.Q(this.d.s.b());
                    }
                    this.d.p = true;
                    if (this.d.x != null && this.d.x.isAlive()) {
                        this.d.x.interrupt();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "socketConnectThread interrupt");
                        }
                    }
                    if (this.d.n != null && this.d.n.isAlive()) {
                        this.d.n.interrupt();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "readThread interrupt");
                        }
                    }
                    if (this.d.m != null && this.d.m.isAlive()) {
                        this.d.m.interrupt();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "sendThread interrupt");
                        }
                    }
                    if (n50.a) {
                        o50.a("SocketTransceiver", "socket ConnectTask start create Socket Object for connect");
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    f40 g2 = e40.h(this.d.r).g(601110);
                    g2.b("connect_state", 3);
                    g2.c("socket_begin", System.currentTimeMillis());
                    FutureTask futureTask = new FutureTask(new a(this));
                    this.d.x = new Thread(futureTask);
                    this.d.x.start();
                    if (n50.a) {
                        o50.a("SocketTransceiver", "ConnectTask run FutureTask by socketConnectThread for create Socket Object");
                    }
                    v40 v40Var = (v40) futureTask.get(10000L, TimeUnit.MILLISECONDS);
                    w40 w40Var5 = this.d;
                    w40Var5.F = this.d.F + " > socket: end: " + System.currentTimeMillis();
                    e40.h(this.d.r).g(601110).c("socket_end", System.currentTimeMillis());
                    if (n50.a) {
                        o50.b("SocketTransceiver", "socket ConnectTask create Socket end, cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                    if (v40Var != null) {
                        if (this.d.P()) {
                            w40 w40Var6 = this.d;
                            w40Var6.F = this.d.F + " > conn: end3: " + System.currentTimeMillis();
                            if (n50.a) {
                                o50.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            }
                            f40 g3 = e40.h(this.d.r).g(601110);
                            g3.d("P12", "socketConnect after, but socket has created ok.");
                            g3.d("con_err_code", "P12");
                            g3.b("retry_cout", this.d.q.get());
                            this.d.Q(v40Var);
                        }
                        if (!v40Var.b.booleanValue()) {
                            w40 w40Var7 = this.d;
                            w40Var7.F = this.d.F + " > conn: end4: " + System.currentTimeMillis();
                            f40 g4 = e40.h(this.d.r).g(601110);
                            g4.d("P14", "connect env error:" + this.b);
                            g4.d("con_err_code", "P14");
                            g4.b("retry_cout", this.d.q.get());
                            this.d.x0("connect env error:", this.b);
                            l50.a(this.d.r).b(new b(this));
                            return;
                        }
                        if (n50.a) {
                            o50.a("SocketTransceiver", "socketState verified ENV approved, start setCurrentSocketState");
                        }
                        this.d.s.f(v40Var);
                        if (this.d.x != null && this.d.x.isAlive()) {
                            this.d.x.interrupt();
                            if (n50.a) {
                                o50.a("SocketTransceiver", "socketConnectThread interrupt");
                            }
                        }
                        w40 w40Var8 = this.d;
                        w40Var8.F = this.d.F + " > conn: suc: " + System.currentTimeMillis();
                        if (n50.a) {
                            o50.d("SocketTransceiver", "create Socket ok");
                        }
                        f40 g5 = e40.h(this.d.r).g(601110);
                        g5.d("P15", "create Socket ok");
                        g5.d("con_err_code", "P15");
                        Context context = this.d.r;
                        if (this.d.q.get() == 0) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        p50.Q(context, i);
                        r40.d(this.d.r, this.b);
                        if (n50.a) {
                            o50.a("SocketTransceiver", "socket ConnectTask end, start lcp login");
                        }
                        this.d.u0(this.d.a0(true));
                        this.d.p = false;
                        this.d.m = new i(this.d, this.b);
                        this.d.m.start();
                        this.d.n = new h(this.d, this.b);
                        this.d.n.start();
                        this.d.y.set(false);
                        w40 w40Var9 = this.d;
                        w40Var9.F = this.d.F + " > conn: end: " + System.currentTimeMillis();
                        if (n50.a) {
                            o50.b("SocketTransceiver", "connectTaskRunning.set(false)");
                        }
                        a2 = l50.a(this.d.r);
                        bVar = new b(this);
                        a2.b(bVar);
                        return;
                    }
                    throw new RuntimeException("crate socket end, get SocketState is null");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w40 a;

        public c(w40 w40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w40Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w40 w40Var = this.a;
                w40Var.u0(w40Var.a0(false));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365888330, "Lcom/baidu/tieba/w40$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-365888330, "Lcom/baidu/tieba/w40$d;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ w40 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(w40 w40Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w40Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = str;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    long j = message.arg1;
                    synchronized (this.b.i) {
                        this.b.l0(j, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ w40 b;

        public g(w40 w40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w40Var;
            this.a = 60000L;
        }

        public /* synthetic */ g(w40 w40Var, a aVar) {
            this(w40Var);
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.w.removeCallbacks(this.b.o);
                this.b.w.postDelayed(this.b.o, this.a);
                w40 w40Var = this.b;
                w40Var.u0(w40Var.j.b(this.b.r, 3L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ w40 b;

        public h(w40 w40Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w40Var;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            t40 t40Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.p) {
                    try {
                        t40 t40Var2 = null;
                        try {
                            t40Var2 = this.b.j.c(this.b.s.e());
                            if (t40Var2 != null && t40Var2.o > 0) {
                                this.b.w.removeCallbacks(this.b.t);
                                t40Var2.n = false;
                                if (n50.a) {
                                    o50.d("SocketTransceiver", "ReadThread receive a message : " + t40Var2.toString());
                                }
                                if (!t40Var2.l) {
                                    synchronized (this.b.i) {
                                        t40Var = (t40) this.b.g.remove(Long.valueOf(t40Var2.o));
                                        if (n50.a && t40Var != null) {
                                            o50.a("SocketTransceiver", "ReadThread receive a msg which we request before");
                                        }
                                    }
                                    if (t40Var2.d == -1) {
                                        t40Var2.d = 8001;
                                    }
                                    this.b.i0(t40Var2, t40Var, this.a);
                                }
                                synchronized (this.b.i) {
                                    if (this.b.g.size() != 0) {
                                        if (n50.a) {
                                            o50.a("SocketTransceiver", "ReadThread [sendMessageMap.size() != 0], restart socketReadAndWriteTimeoutRunnable");
                                        }
                                        this.b.t.c(t40Var2.o);
                                        this.b.t.b(this.a);
                                        this.b.t.a(t40Var2.l);
                                        this.b.w.a(this.a);
                                        this.b.w.postDelayed(this.b.t, t40Var2.c);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            if (n50.a) {
                                o50.c("SocketTransceiver", "ReadThread read message exception, mClose is " + this.b.p + " exception: " + e, e);
                            }
                            w40 w40Var = this.b;
                            w40Var.j0("ReadThread exception:" + e.toString());
                            this.b.e0(t40Var2, true);
                            if (this.b.p) {
                                return;
                            }
                            this.b.e = false;
                            w40 w40Var2 = this.b;
                            w40Var2.V("ReadThread read message exception: " + e, this.a, false);
                            return;
                        }
                    } catch (Exception e2) {
                        if (n50.a) {
                            o50.c("SocketTransceiver", "ReadThread exception, mClose is " + this.b.p + " exception: " + e2, e2);
                        }
                        w40 w40Var3 = this.b;
                        w40Var3.j0("ReadThread exception:" + e2.toString());
                        if (this.b.p) {
                            return;
                        }
                        this.b.e = false;
                        w40 w40Var4 = this.b;
                        w40Var4.V("ReadThread exception: " + e2, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ w40 b;

        public i(w40 w40Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w40Var;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.p) {
                    try {
                        t40 t40Var = null;
                        try {
                            synchronized (this.b.f) {
                                if (this.b.f.size() == 0) {
                                    this.b.f.wait();
                                } else {
                                    t40Var = (t40) this.b.f.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            if (n50.a) {
                                o50.b("SocketTransceiver", "SendThread wait exception, mClose is " + this.b.p + ", exception: " + e);
                            }
                            if (this.b.p) {
                                return;
                            }
                            this.b.e = false;
                            w40 w40Var = this.b;
                            w40Var.V("SendThread wait exception: " + e, this.a, false);
                        }
                        if (t40Var != null) {
                            try {
                                if (!this.b.p) {
                                    t40Var.n = true;
                                    t40Var.k = w40.L.a;
                                    if (t40Var.p) {
                                        synchronized (this.b.i) {
                                            if (this.b.g.isEmpty()) {
                                                this.b.w.removeCallbacks(this.b.t);
                                                this.b.t.c(t40Var.o);
                                                this.b.t.b(this.a);
                                                this.b.t.a(t40Var.l);
                                                this.b.w.a(this.a);
                                                this.b.w.postDelayed(this.b.t, 10000L);
                                            }
                                        }
                                    }
                                    if (n50.a) {
                                        o50.e("SocketTransceiver", "SendThread :" + t40Var.toString());
                                    }
                                    t40Var.b = System.currentTimeMillis();
                                    synchronized (this.b.h) {
                                        this.b.s.i(t40Var);
                                    }
                                    if (!t40Var.l && t40Var.p) {
                                        synchronized (this.b.i) {
                                            this.b.g.put(Long.valueOf(t40Var.o), t40Var);
                                        }
                                    }
                                } else {
                                    this.b.k0(t40Var.o, this.a);
                                    return;
                                }
                            } catch (Exception e2) {
                                if (n50.a) {
                                    o50.c("SocketTransceiver", "SendThread sendMessage message exception, mClose is " + this.b.p, e2);
                                }
                                w40 w40Var2 = this.b;
                                w40Var2.j0("WriteThread exception:" + e2.toString());
                                this.b.e0(t40Var, false);
                                this.b.f0(t40Var.o, e2.toString(), this.a);
                                if (this.b.p) {
                                    return;
                                }
                                this.b.e = false;
                                w40 w40Var3 = this.b;
                                w40Var3.V("SendThread sendMessage Exception:" + e2, this.a, false);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        if (n50.a) {
                            o50.c("SocketTransceiver", "SendThread Exception, mClose is " + this.b.p, e3);
                        }
                        w40 w40Var4 = this.b;
                        w40Var4.j0("WriteThread exception:" + e3.toString());
                        if (this.b.p) {
                            return;
                        }
                        this.b.e = false;
                        w40 w40Var5 = this.b;
                        w40Var5.V("SendThread Exception:" + e3, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ w40 b;

        public j(w40 w40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w40Var;
            this.a = "";
        }

        public /* synthetic */ j(w40 w40Var, a aVar) {
            this(w40Var);
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str == null) {
                    this.a = "";
                } else {
                    this.a = str;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                w40 w40Var = this.b;
                w40Var.F = this.b.F + " > retry: connect: " + System.currentTimeMillis();
                f40 b = e40.h(this.b.r).b(601110);
                b.c("flow_start_time", System.currentTimeMillis());
                b.d("P18", "retry by disconnect");
                b.d("con_err_code", "P18");
                b.d("source", "retry : " + this.a);
                this.b.T();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public boolean c;
        public final /* synthetic */ w40 d;

        public k(w40 w40Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w40Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w40Var;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.c = z;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b = str;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                this.a = j;
            }
        }

        public /* synthetic */ k(w40 w40Var, a aVar) {
            this(w40Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.d.l0(this.a, this.b);
                if (this.c) {
                    this.d.V("read and write thread timeout:", this.b, false);
                } else {
                    this.d.p0();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948220470, "Lcom/baidu/tieba/w40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948220470, "Lcom/baidu/tieba/w40;");
                return;
            }
        }
        L = new l40();
    }

    public static long b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            long nanoTime = System.nanoTime();
            return (System.currentTimeMillis() * 1000) + ((nanoTime - ((nanoTime / 1000000) * 1000000)) / 1000);
        }
        return invokeV.longValue;
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            u40 u40Var = this.s;
            if (u40Var != null && u40Var.c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (L.a == -1) {
                return "UNCONNECTED";
            }
            if (L.a == -2) {
                return "CONNECTING";
            }
            return "CONNECTED";
        }
        return (String) invokeV.objValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public l40 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return L;
        }
        return (l40) invokeV.objValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (n50.a) {
                o50.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            }
            u0(this.j.b(this.r, 3L));
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (n50.a) {
                o50.a("SocketTransceiver", "resetConnectParameter");
            }
            this.d = 0;
            this.q.set(0);
            r40.f(this.r);
            this.H = b0();
        }
    }

    public w40(Context context) {
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
        this.a = null;
        this.b = null;
        this.c = new AtomicInteger(0);
        this.d = 0;
        this.e = false;
        this.f = new LinkedList<>();
        this.g = new LinkedHashMap();
        this.h = new Object();
        this.i = new Object();
        this.j = new c50();
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.o = new g(this, null);
        this.p = false;
        this.q = new AtomicInteger(0);
        this.t = new k(this, null);
        this.u = new j(this, null);
        this.y = new AtomicBoolean(false);
        this.z = new AtomicBoolean(false);
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = 0L;
        this.I = "";
        this.J = new a(this);
        this.K = new c(this);
        this.r = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.v = handlerThread;
        handlerThread.start();
        this.w = new f(this, this.v.getLooper());
    }

    public final void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                if (n50.a) {
                    o50.a("SocketTransceiver", "socket connect disConnect, fatalAllMessage begin ");
                }
                e40.h(this.r).g(601110).b("sendQueue_length", this.f.size());
                e40.h(this.r).g(601110).c("sendQueue_starttime", System.currentTimeMillis());
                synchronized (this.f) {
                    while (this.f.size() > 0) {
                        X(this.f.removeFirst(), str, "fatal exception :");
                    }
                    if (n50.a) {
                        o50.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                    }
                }
                e40.h(this.r).g(601110).c("sendQueue_endtime", System.currentTimeMillis());
                e40.h(this.r).g(601110).b("sendMessageMap_length", this.g.size());
                e40.h(this.r).g(601110).c("sendMessageMap_starttime", System.currentTimeMillis());
                synchronized (this.i) {
                    if (n50.a) {
                        o50.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    }
                    for (Long l : this.g.keySet()) {
                        X(this.g.get(l), str, "fatal send msg exception :");
                    }
                    this.g.clear();
                    if (n50.a) {
                        o50.a("SocketTransceiver", "fatalAllMessage mSync end");
                    }
                }
                e40.h(this.r).g(601110).c("sendMessageMap_endtime", System.currentTimeMillis());
            } catch (Exception e2) {
                if (n50.a) {
                    o50.c("SocketTransceiver", "fatalAllMessage Exception", e2);
                }
            }
        }
    }

    public final synchronized void u0(t40 t40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, t40Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    if (n50.a) {
                        o50.c("SocketTransceiver", "sendMessage Exception :", e2);
                    }
                }
                synchronized (this.f) {
                    boolean z = false;
                    Iterator<t40> it = this.f.iterator();
                    while (it.hasNext()) {
                        t40 next = it.next();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "sendMessage queue :" + next.o);
                        }
                        if (next.m) {
                            z = true;
                        }
                    }
                    if (t40Var.m) {
                        if (!z && L.a == -2) {
                            this.f.addFirst(t40Var);
                            this.f.notifyAll();
                        }
                        if (n50.a) {
                            o50.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + Y());
                        }
                    } else if (L.a == -1) {
                        if (P()) {
                            if (this.f.size() <= 0 || !z) {
                                this.f.addFirst(a0(true));
                                this.f.notifyAll();
                            }
                            if (!t40Var.l) {
                                this.f.add(t40Var);
                                this.f.notifyAll();
                            }
                        } else {
                            if (t40Var.l && m40.h().i() == -1) {
                                m40.h().f("ping");
                            }
                            this.f.add(t40Var);
                        }
                    } else {
                        this.f.add(t40Var);
                        this.f.notifyAll();
                    }
                }
            }
        }
    }

    public static synchronized w40 Z(Context context) {
        InterceptResult invokeL;
        w40 w40Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            synchronized (w40.class) {
                if (M == null) {
                    M = new w40(context.getApplicationContext());
                }
                w40Var = M;
            }
            return w40Var;
        }
        return (w40) invokeL.objValue;
    }

    public final void Q(v40 v40Var) {
        v40 b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v40Var) == null) && (b2 = this.s.b()) != null && b2.a.booleanValue()) {
            this.s.a(v40Var);
            o50.a("SocketTransceiver", "closeExistedConnection ok");
        }
    }

    public final void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.D = "";
            this.E = "";
            q0(str);
        }
    }

    public synchronized void O(BLCPRequest bLCPRequest, q40 q40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, q40Var) == null) {
            synchronized (this) {
                t40 t40Var = new t40();
                t40Var.i = bLCPRequest.a;
                t40Var.j = bLCPRequest.b;
                t40Var.a = bLCPRequest.c;
                t40Var.b = System.currentTimeMillis();
                if (bLCPRequest.d < 0) {
                    t40Var.o = System.currentTimeMillis();
                } else {
                    t40Var.o = bLCPRequest.d;
                }
                int i2 = d.a[bLCPRequest.e.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            t40Var.c = 10000L;
                        } else {
                            t40Var.c = 50000L;
                        }
                    } else {
                        t40Var.c = 30000L;
                    }
                } else {
                    t40Var.c = 20000L;
                }
                if (bLCPRequest instanceof p40) {
                    long j2 = (t40Var.i * 10000) + t40Var.j;
                    t40Var.o = j2;
                    v0(t40Var.i, t40Var.j, j2, true, q40Var);
                } else {
                    v0(t40Var.i, t40Var.j, t40Var.o, false, q40Var);
                    this.j.a(t40Var, true);
                    u0(t40Var);
                }
            }
        }
    }

    public final void k0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j2, str) == null) {
            try {
                if (this.g.size() > 0 && this.g.containsKey(Long.valueOf(j2))) {
                    if (n50.a) {
                        o50.a("SocketTransceiver", "handle msg socket stoped!!! " + this.g.get(Long.valueOf(j2)).toString());
                    }
                    t40 remove = this.g.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8006;
                    remove.e = "socket stopped :";
                    i0(remove, remove, str);
                }
            } catch (Exception e2) {
                if (n50.a) {
                    o50.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
                }
            }
        }
    }

    public final void l0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048597, this, j2, str) == null) {
            try {
                if (this.g.size() > 0 && this.g.containsKey(Long.valueOf(j2))) {
                    if (n50.a) {
                        o50.a("SocketTransceiver", "handle msg timeout!!! " + this.g.get(Long.valueOf(j2)).toString());
                    }
                    t40 remove = this.g.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = ResponseCode.LCP_TIME_OUT;
                    remove.e = "socket timeout";
                    i0(remove, remove, str);
                }
            } catch (Exception e2) {
                if (n50.a) {
                    o50.a("SocketTransceiver", "handle msg timeout!!! " + e2);
                }
            }
        }
    }

    public synchronized void x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            synchronized (this) {
                this.F += " > discon: start: " + System.currentTimeMillis();
                if (n50.a) {
                    o50.d("SocketTransceiver", "---socketDisconnect---");
                }
                this.p = true;
                this.e = true;
                W(str2);
                this.w.removeCallbacks(this.u);
                this.w.removeCallbacks(this.K);
                this.w.removeCallbacks(this.o);
                r40.e(this.r, null, false);
                U(str, str2, true, true);
                r0();
                this.y.set(false);
            }
        }
    }

    public final synchronized void S(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                if (p50.r(this.r) && !this.y.getAndSet(true)) {
                    if (n50.a) {
                        o50.b("SocketTransceiver", "connectTaskRunning.set(true)");
                    }
                    this.F += " > conn(): " + System.currentTimeMillis();
                    l50.a(this.r).b(new b(this, str, str2, str3));
                } else {
                    o50.b("SocketTransceiver", "connect() return, ");
                }
            }
        }
    }

    public final void X(t40 t40Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, t40Var, str, str2) == null) && t40Var != null && t40Var.i != 1) {
            if (n50.a) {
                o50.b("SocketTransceiver", "fetalAndClearMsg : " + t40Var.o + ", serviceId :" + t40Var.i + ", methodId :" + t40Var.j);
            }
            t40 t40Var2 = new t40();
            t40Var.d = 8009;
            t40Var.e = str2;
            i0(t40Var2, t40Var, str);
        }
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.r)) {
                    f40 g2 = e40.h(this.r).g(601110);
                    g2.d("net_connect", "false");
                    g2.c("flow_end_time", System.currentTimeMillis());
                    g2.d("P33", "socket connectImpl error, no net");
                    g2.d("con_err_code", "P33");
                    g2.b("retry_cout", this.q.get());
                    g2.b("connect_state", -1);
                    g2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.H);
                    g2.d("server_info", this.I);
                    g2.e();
                    r0();
                    L.a = -1;
                    y0(false);
                    return;
                }
                o50.d("SocketTransceiver", "connectImpl socket connect state:" + Y());
                if (L.a != 0 && L.a != -2) {
                    this.w.removeCallbacks(this.u);
                    this.w.removeCallbacks(this.K);
                    this.w.removeCallbacks(this.o);
                    q0("");
                    return;
                }
                f40 g3 = e40.h(this.r).g(601110);
                g3.b("inner_connect_state", L.a);
                g3.d("P34", "socket connectImpl repeat");
                g3.d("con_err_code", "P34");
                g3.b("retry_cout", this.q.get());
            }
        }
    }

    public final synchronized void U(String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                this.F += " > destroy: start: " + System.currentTimeMillis();
                if (n50.a) {
                    o50.d("SocketTransceiver", "destroy socket connect start, reason : " + str + ", host: " + str2 + ", syncStatus: " + z + ", isConnectException: " + z2);
                }
                this.w.removeCallbacks(this.t);
                this.p = true;
                if (this.s != null) {
                    synchronized (this.f) {
                        this.f.notifyAll();
                        if (n50.a) {
                            o50.d("SocketTransceiver", "destroy socket connect, sendQueue notifyAll");
                        }
                    }
                    try {
                        this.s.g();
                        if (n50.a) {
                            o50.a("SocketTransceiver", "destroy socket connect, socketClose success");
                        }
                    } catch (Exception e2) {
                        this.s.f(null);
                        if (n50.a) {
                            o50.c("SocketTransceiver", "Exception destroy:", e2);
                        }
                    }
                }
                L.a = -1;
                if (z) {
                    f40 g2 = e40.h(this.r).g(601110);
                    g2.d("P17", str);
                    g2.d("con_err_code", "P17");
                    y0(true);
                } else {
                    if (m40.h().i() == 0) {
                        this.F += " > sync: start1: " + System.currentTimeMillis();
                        l40 l40Var = new l40();
                        l40Var.a = -2;
                        setChanged();
                        notifyObservers(l40Var);
                        m40.h().m();
                    }
                    if (z2) {
                        f40 g3 = e40.h(this.r).g(601110);
                        g3.c("flow_end_time", System.currentTimeMillis());
                        g3.b("retry_cout", this.q.get());
                        g3.d("P21", "connect end by exception:" + str);
                        g3.d("con_err_code", "P21");
                        g3.d("connect_route", this.F);
                        g3.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.H);
                        g3.d("server_info", this.I);
                        g3.e();
                        this.F = "";
                        this.H = b0();
                    }
                }
            }
        }
    }

    public synchronized void V(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, str, str2, z) == null) {
            synchronized (this) {
                this.F += " > disconnlcp: start: " + System.currentTimeMillis();
                if (n50.a) {
                    o50.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.e + ", net :" + RequsetNetworkUtils.isConnected(this.r) + ", reason : " + str);
                }
                W(str2);
                if (this.e) {
                    this.F += " > disconnlcp: return1: " + System.currentTimeMillis();
                    f40 g2 = e40.h(this.r).g(601110);
                    g2.d("P16", "disconnectedByLcp:" + this.e);
                    g2.d("con_err_code", "P16");
                    g2.b("retry_cout", this.q.get());
                    r0();
                    return;
                }
                e40.h(this.r).g(601110).c("destory_starttime", System.currentTimeMillis());
                U(str, str2, false, z);
                e40.h(this.r).g(601110).c("destory_endtime", System.currentTimeMillis());
                if (z) {
                    this.y.set(false);
                    if (n50.a) {
                        o50.b("SocketTransceiver", "connectTaskRunning.set(false)");
                    }
                }
                s0(false, str2, str);
            }
        }
    }

    public final void h0(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                this.F += " > lcm: suc: " + System.currentTimeMillis();
                if (n50.a) {
                    o50.b("SocketTransceiver", "lcm login success, cost: , lcm cost: " + (System.currentTimeMillis() - this.A) + ms.c);
                }
                f40 g2 = e40.h(this.r).g(601110);
                g2.c("login_end", System.currentTimeMillis());
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("connect_state", 4);
                g2.d("P55", "lcp login success");
                g2.d("con_err_code", "lcp login success");
                g2.b("retry_cout", this.q.get());
                g2.d("connect_route", this.F);
                g2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.H);
                g2.d("server_info", this.I);
                g2.e();
                this.F = "";
                this.H = b0();
                this.q.set(0);
                L.a = 0;
                y0(false);
                if (!z) {
                    return;
                }
                this.w.a(str);
                this.w.postDelayed(this.o, j2);
                if (n50.a) {
                    o50.a("SocketTransceiver", "ping every 1分钟 ");
                }
            } catch (Exception e2) {
                if (n50.a) {
                    o50.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
                }
            }
        }
    }

    public final t40 a0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (z) {
                this.F += " > lcm: start: " + System.currentTimeMillis();
                this.A = System.currentTimeMillis();
                f40 g2 = e40.h(this.r).g(601110);
                g2.b("connect_state", 4);
                g2.c("login_begin", System.currentTimeMillis());
            }
            return this.j.b(this.r, 1L);
        }
        return (t40) invokeZ.objValue;
    }

    public final void e0(t40 t40Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, t40Var, z) == null) && t40Var != null && t40Var.j == 50 && t40Var.i == 2) {
            if (z) {
                str = "ReadThread read ImLoginMessage occur exception";
            } else {
                str = "SendThread send ImLoginMessage occur exception";
            }
            f40 g2 = e40.h(this.r).g(601110);
            g2.c("login_end", System.currentTimeMillis());
            g2.d("P46", str);
            g2.d("con_err_code", "P46");
        }
    }

    public final void f0(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.g.size() > 0 && this.g.containsKey(Long.valueOf(j2))) {
                    if (n50.a) {
                        o50.a("SocketTransceiver", "handle msg exception!!! " + this.g.get(Long.valueOf(j2)).toString());
                    }
                    t40 remove = this.g.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8005;
                    remove.e = "socket exception :" + str;
                    i0(remove, remove, str2);
                }
            } catch (Exception e2) {
                if (n50.a) {
                    o50.a("SocketTransceiver", "handle msg exception!!! " + e2);
                }
            }
        }
    }

    public final void g0(t40 t40Var, String str) {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, t40Var, str) == null) {
            if (t40Var.d == 0) {
                long j3 = t40Var.h;
                if (j3 <= 0) {
                    j2 = 60000;
                } else {
                    j2 = j3;
                }
                long j4 = t40Var.j;
                if (j4 == 1) {
                    h0(j2, true, str);
                    return;
                } else if (j4 == 2) {
                    this.F += " > lcm: fail1: " + System.currentTimeMillis();
                    if (n50.a) {
                        o50.d("SocketTransceiver", "LCP logout, cur msg.connectState is " + t40Var.k);
                    }
                    x0("LCP logout:", str);
                    return;
                } else if (j4 == 3) {
                    this.o.a(j2);
                    return;
                } else {
                    return;
                }
            }
            String str2 = " errorcode:" + t40Var.d + " errmsg:" + t40Var.e;
            if (!String.valueOf(t40Var.d).startsWith(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK) && (i2 = t40Var.d) != 1011 && i2 != 2001 && i2 != 2003) {
                if (i2 == 1012) {
                    this.F += " > lcm: fail3: " + System.currentTimeMillis();
                    if (n50.a) {
                        o50.a("SocketTransceiver", "login error :" + str2 + ", lcm cost: " + (System.currentTimeMillis() - this.A) + ms.c);
                    }
                    f40 g2 = e40.h(this.r).g(601110);
                    g2.c("login_end", System.currentTimeMillis());
                    g2.d("P45", "lcp login failed:" + str2);
                    g2.d("con_err_code", "P45");
                    if (!this.z.getAndSet(true)) {
                        p50.O(this.r, "");
                        x0(str2, str);
                        m40.h().f("lcp login failed:");
                        this.z.set(false);
                        return;
                    }
                    return;
                } else if (i2 == 1013) {
                    h0(60000L, false, str);
                    return;
                } else {
                    this.F += " > lcm: fail4: " + System.currentTimeMillis();
                    if (n50.a) {
                        o50.a("SocketTransceiver", "login error :" + str2);
                    }
                    f40 g3 = e40.h(this.r).g(601110);
                    g3.c("login_end", System.currentTimeMillis());
                    g3.d("P47", "lcp login failed:" + str2);
                    g3.d("con_err_code", "P47");
                    L.a = -1;
                    s0(true, str, str2);
                    return;
                }
            }
            this.F += " > lcm: fail2: " + System.currentTimeMillis();
            if (n50.a) {
                o50.a("SocketTransceiver", "login error, then request token, error code :" + t40Var.d + ", lcm cost: " + (System.currentTimeMillis() - this.A) + ms.c);
            }
            f40 g4 = e40.h(this.r).g(601110);
            g4.c("login_end", System.currentTimeMillis());
            g4.d("P45", "lcp login failed:" + str2);
            g4.d("con_err_code", "P45");
            if (!this.z.getAndSet(true)) {
                p50.O(this.r, "");
                x0(str2, str);
                m40.h().f("lcp login failed:");
                this.z.set(false);
            }
        }
    }

    public final void i0(t40 t40Var, t40 t40Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, t40Var, t40Var2, str) == null) {
            m0(t40Var2, t40Var, str);
            long j2 = t40Var.i;
            if (j2 == 1) {
                g0(t40Var, str);
            } else if (j2 != -1) {
                o0(t40Var);
            } else if (t40Var2 == null) {
            } else {
                if (t40Var2.i == 1) {
                    g0(t40Var2, str);
                } else {
                    o0(t40Var2);
                }
            }
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            f40 g2 = e40.h(this.r).g(111111);
            g2.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str);
            g2.c("occur_time", System.currentTimeMillis());
            g2.d("server_info", this.I);
            g2.e();
        }
    }

    public final void m0(t40 t40Var, t40 t40Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, t40Var, t40Var2, str) == null) {
            if (t40Var != null) {
                if (t40Var.b <= 0) {
                    t40Var.b = System.currentTimeMillis();
                }
                if (t40Var2.i == 1 && t40Var2.j == 1) {
                    this.I = t40Var2.r;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    for (n40 n40Var : t40Var2.q) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("event", n40Var.a);
                        jSONObject.put("timestamp_ms", n40Var.b);
                        jSONArray.put(jSONObject);
                    }
                    o50.a("SocketTransceiver", "eventList size :" + jSONArray.length() + ", eventList=" + jSONArray);
                } catch (Exception e2) {
                    o50.c("SocketTransceiver", "eventList Exception ", e2);
                }
                f40 b2 = e40.h(this.r).b(601111);
                b2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, t40Var2.o);
                b2.c("service_id", t40Var2.i);
                b2.c("method_id", t40Var2.j);
                b2.b("error_code", t40Var2.d);
                b2.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, t40Var2.e);
                b2.c("request_time", t40Var.b);
                b2.c("response_time", System.currentTimeMillis());
                b2.d("ext", "");
                b2.d(ProbeTB.PROTOCOL, this.C);
                b2.d("ip", this.B);
                b2.d("domain", this.D);
                b2.d(ClientCookie.PORT_ATTR, this.E);
                b2.c("request_body_size", t40Var.s);
                b2.c("response_body_size", t40Var2.t);
                b2.d("server_info", this.I);
                b2.d("event_list", jSONArray.toString());
                b2.e();
                return;
            }
            f40 b3 = e40.h(this.r).b(222222);
            b3.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, t40Var2.o);
            b3.c("service_id", t40Var2.i);
            b3.c("method_id", t40Var2.j);
            b3.b("error_code", t40Var2.d);
            b3.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, t40Var2.e);
            b3.e();
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public final boolean n0() {
        InterceptResult invokeV;
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            String absolutePath = this.r.getDir("lcp_quic", 0).getAbsolutePath();
            String str = absolutePath + File.separator + "libquiche.0.10.1.so";
            String str2 = absolutePath + File.separator + "libbd-quic.1.1.so";
            o50.a("SocketTransceiver", "quicheSoFilePath " + str);
            o50.a("SocketTransceiver", "bdQuicSoFilePath " + str2);
            try {
                file = new File(str);
                file2 = new File(str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (file.exists() && file2.exists()) {
                System.load(str);
                System.load(str2);
                z = true;
                o50.a("SocketTransceiver", "load quic so cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void o0(t40 t40Var) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, t40Var) == null) {
            synchronized (this) {
                q40 q40Var = null;
                try {
                    if (!t40Var.f) {
                        j2 = t40Var.o;
                    } else {
                        j2 = (t40Var.i * 10000) + t40Var.j;
                    }
                    Long valueOf = Long.valueOf(j2);
                    if (n50.a) {
                        o50.a("SocketTransceiver", "onBLCPResponse,  key:" + valueOf + ", methodId :" + t40Var.j + ", serviceId :" + t40Var.i + ", error :" + t40Var.d + ", msgId :" + t40Var.o + ", errMsg :" + t40Var.e + ", invoke keys :" + this.k.keySet().toString() + ", notify keys :" + this.l.keySet().toString());
                    }
                    if (this.l.size() > 0 && this.l.containsKey(valueOf)) {
                        q40Var = this.l.get(valueOf);
                    } else if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        q40Var = this.k.remove(valueOf);
                    }
                    if (q40Var != null) {
                        if (q40Var instanceof o40) {
                            o40.a aVar = new o40.a();
                            long j3 = t40Var.i;
                            aVar.a = t40Var.j;
                            aVar.b = t40Var.o;
                            aVar.c = t40Var.g;
                            aVar.d = t40Var.q;
                            ((o40) q40Var).onResponse(t40Var.d, t40Var.e, aVar);
                        } else {
                            q40Var.onResponse(t40Var.d, t40Var.e, t40Var.i, t40Var.j, t40Var.o, t40Var.g);
                        }
                        if (t40Var.d == 1011) {
                            if (n50.a) {
                                o50.a("SocketTransceiver", "onBLCPResponse, errorCode :" + t40Var.d + ", and will send lcm login msg .");
                            }
                            u0(a0(false));
                        }
                    }
                } catch (Exception e2) {
                    if (n50.a) {
                        o50.c("SocketTransceiver", "onBLCPResponse, Exception!!!", e2);
                    }
                }
            }
        }
    }

    public final synchronized void q0(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            synchronized (this) {
                this.F += " > proto: " + System.currentTimeMillis();
                if (!this.D.isEmpty() && !this.E.isEmpty() && r40.b()) {
                    S(this.D, this.E, this.C);
                    return;
                }
                int p = p50.p(this.r);
                String[] split = p50.o(this.r, this.d).split(":");
                if (n50.a) {
                    o50.f("SocketTransceiver", "protocolOption thread : " + Thread.activeCount() + ", cur : " + Thread.currentThread() + "，protocol count : " + p + " protocol index : " + this.d);
                }
                if (split.length < 3) {
                    if (this.d < p) {
                        this.d++;
                        this.D = "";
                        this.E = "";
                        q0("");
                    }
                } else {
                    if (TextUtils.isEmpty(split[0])) {
                        str2 = "tcp";
                    } else {
                        str2 = split[0];
                    }
                    this.G = str2;
                    String str3 = split[1];
                    String str4 = split[2];
                    if (this.d >= p) {
                        this.d = 0;
                        if (n50.a) {
                            o50.a("SocketTransceiver", "protocolOption failed, connectip:" + str3 + ", port:" + str4 + ", protocolType:" + this.G);
                        }
                        this.s = new x40("tls");
                        this.D = "lcs.baidu.com";
                        this.E = "443";
                        this.C = "tls";
                        S("lcs.baidu.com", "443", "tls");
                    } else if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.G)) {
                        o50.b("SocketTransceiver", "protocol relegate: current protocol is " + this.G);
                        this.d = this.d + 1;
                        t0(str);
                    } else {
                        if ("quic".equals(this.G) && !(this.s instanceof QuicMessageHandler)) {
                            if (split.length == 4 && TextUtils.equals(split[3], "1")) {
                                if (n0()) {
                                    if (TextUtils.isEmpty(this.b)) {
                                        this.b = QuicMessageHandler.z().bdQuicVersion();
                                    }
                                    if (TextUtils.isEmpty(this.a)) {
                                        this.a = QuicMessageHandler.z().quicheVersion();
                                    }
                                    o50.b("SocketTransceiver", "quic so file load succcess, bdQuicVersion is " + this.b + " quicheVersion is " + this.a);
                                    if (TextUtils.equals(this.b, "1.1") && TextUtils.equals(this.a, "0.10.1")) {
                                        o50.b("SocketTransceiver", "quic protocol select success");
                                        QuicMessageHandler z = QuicMessageHandler.z();
                                        z.K(new QuicMessageHandler.e(this.J));
                                        this.s = z;
                                    } else {
                                        o50.b("SocketTransceiver", " bd_quic_version or quiche verison not we need");
                                        this.d++;
                                        t0("quic");
                                    }
                                } else {
                                    o50.b("SocketTransceiver", "quic protocol load so file occur exception");
                                    this.d++;
                                    t0("quic");
                                    return;
                                }
                            } else {
                                o50.b("SocketTransceiver", "quic protocol check `version` fail");
                                this.d++;
                                t0("quic");
                                return;
                            }
                        } else if ("tcp".equals(this.G) || ("tls".equals(this.G) && !(this.s instanceof x40))) {
                            this.s = new x40(this.G);
                        }
                        this.d++;
                        if (this.s != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            if (n50.a) {
                                o50.a("SocketTransceiver", "type :" + this.G + ", host :" + str3 + ", port :" + str4);
                            }
                            this.D = str3;
                            this.E = str4;
                            this.C = this.G;
                            S(str3, str4, this.G);
                        } else {
                            t0("");
                        }
                    }
                }
            }
        }
    }

    public final void s0(boolean z, String str, String str2) {
        String str3;
        Runnable runnable;
        Runnable runnable2;
        int i2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            try {
                if (this.s != null && TextUtils.equals(this.s.d(), "quic") && this.q.get() >= 2) {
                    o50.d("SocketTransceiver", "quic retey times more than 3, relegate to TCP");
                    this.w.removeCallbacks(this.u);
                    this.w.removeCallbacks(this.K);
                    this.w.removeCallbacks(this.o);
                    r40.e(this.r, null, false);
                    this.D = "";
                    this.E = "";
                    this.w.postDelayed(this.u, R(1));
                } else if (this.q.get() <= 10 && L.a == -1) {
                    this.F += " > retry: start: " + System.currentTimeMillis();
                    this.w.removeCallbacks(this.o);
                    f fVar = this.w;
                    if (z) {
                        runnable = this.u;
                    } else {
                        runnable = this.K;
                    }
                    fVar.removeCallbacks(runnable);
                    this.u.a(str2);
                    if (z) {
                        runnable2 = this.K;
                    } else {
                        runnable2 = this.u;
                    }
                    Message obtain = Message.obtain(this.w, runnable2);
                    if (z) {
                        i2 = 202020;
                    } else {
                        i2 = 101010;
                    }
                    obtain.what = i2;
                    if (!this.w.hasMessages(i2)) {
                        this.F += " > retry: start1: " + System.currentTimeMillis();
                        this.q.incrementAndGet();
                        long R = R(this.q.get());
                        StringBuilder sb = new StringBuilder();
                        sb.append("waiting Schedule retry ");
                        if (z) {
                            str4 = "login";
                        } else {
                            str4 = ExceptionCode.CONNECT;
                        }
                        sb.append(str4);
                        sb.append(" , retry times: ");
                        sb.append(this.q.get());
                        sb.append(" time delay: ");
                        sb.append(R);
                        sb.append(", reason: ");
                        sb.append(str2);
                        String sb2 = sb.toString();
                        f40 g2 = e40.h(this.r).g(601110);
                        g2.d("P44", sb2);
                        g2.d("con_err_code", "P44");
                        this.w.sendMessageDelayed(obtain, R);
                        o50.d("SocketTransceiver", sb2);
                        return;
                    }
                    this.F += " > retry: exit1: " + System.currentTimeMillis();
                    if (n50.a) {
                        o50.d("SocketTransceiver", "waiting Schedule retry， but handler queue had this runnable, pass");
                    }
                } else {
                    this.F += " > retry: fail: " + System.currentTimeMillis();
                    x0("retry strategy had cost " + this.q.get() + " and stop retry, cur connectState:" + L.a + ", reason: " + str2, str);
                }
            } catch (Exception e2) {
                this.F += " > retry: exce: " + System.currentTimeMillis();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("socket retry by ");
                if (z) {
                    str3 = "retryLcmLoginRunnable";
                } else {
                    str3 = "retrySocketConnectRunnable";
                }
                sb3.append(str3);
                sb3.append(", reason: ");
                sb3.append(str2);
                sb3.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb3.append("retry exception:");
                sb3.append(e2.getMessage());
                String sb4 = sb3.toString();
                o50.b("SocketTransceiver", sb4);
                x0(sb4, str);
            }
        }
    }

    public final void v0(long j2, long j3, long j4, boolean z, q40 q40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), q40Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (z) {
                if (q40Var != null) {
                    this.l.put(valueOf, q40Var);
                }
            } else {
                this.k.put(valueOf, q40Var);
            }
            if (n50.a) {
                o50.a("SocketTransceiver", "addMessageToQueue isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.k.keySet().toString() + ", notify keys :" + this.l.keySet().toString());
            }
        }
    }

    public synchronized void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            synchronized (this) {
                if (n50.a) {
                    o50.a("SocketTransceiver", "socketConnect");
                }
                this.e = false;
                this.D = "";
                this.E = "";
                r0();
                T();
                this.H = b0();
            }
        }
    }

    public final void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            if (n50.a) {
                o50.a("SocketTransceiver", "socket connect state change, sync to lcp global connect state, cur socket state is " + Y());
            }
            this.F += " > sync: start: " + System.currentTimeMillis();
            if (z && L.a == -1 && m40.h().i() == -2) {
                f40 g2 = e40.h(this.r).g(601110);
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("retry_cout", this.q.get());
                g2.d("connect_route", this.F);
                g2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, this.H);
                g2.d("server_info", this.I);
                g2.e();
                this.F = "";
                this.H = b0();
            }
            setChanged();
            notifyObservers(L);
            m40.h().m();
        }
    }
}
