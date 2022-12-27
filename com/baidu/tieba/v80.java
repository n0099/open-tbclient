package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
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
import com.baidu.tieba.o80;
import com.baidu.tieba.r80;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.IOException;
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
/* loaded from: classes6.dex */
public final class v80 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l80 F;
    public static volatile v80 G;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public Runnable E;
    public AtomicInteger a;
    public int b;
    public boolean c;
    public volatile LinkedList<s80> d;
    public final HashMap<Long, s80> e;
    public final Object f;
    public final Object g;
    public z80 h;
    public Map<Long, q80> i;
    public Map<Long, q80> j;
    public h k;
    public g l;
    public f m;
    public boolean n;
    public AtomicInteger o;
    public Context p;
    public t80 q;
    public j r;
    public i s;
    public HandlerThread t;
    public e u;
    @SuppressLint({"MobilebdThread"})
    public Thread v;
    public AtomicBoolean w;
    public AtomicBoolean x;
    public long y;
    public long z;

    public final long N(int i2) {
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ v80 d;

        /* renamed from: com.baidu.tieba.v80$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0458a implements r80.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ a b;

            public C0458a(a aVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = j;
            }

            @Override // com.baidu.tieba.r80.d
            public void a(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                    l90.b("SocketTransceiver", "DNS resolve result ip: " + str2 + " cost: " + (System.currentTimeMillis() - this.a) + " ms");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.b.a;
                    }
                    v80 v80Var = this.b.d;
                    v80Var.A = str2;
                    e80 g = d80.h(v80Var.p).g(601110);
                    g.c("dns_end", System.currentTimeMillis());
                    g.d(ClientCookie.PORT_ATTR, this.b.b);
                    g.d("ip", str2);
                    g.d("domain", this.b.a);
                    g.d(ProbeTB.PROTOCOL, this.b.c);
                    g.d("con_err_code", "P31");
                    g.b("retry_cout", this.b.d.o.get());
                    g.b("connect_state", 2);
                    if (v80.F.a == -1) {
                        a aVar = this.b;
                        v80 v80Var2 = aVar.d;
                        new d(v80Var2, str2, aVar.b, Integer.valueOf(v80Var2.a.incrementAndGet())).run();
                    }
                }
            }
        }

        public a(v80 v80Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v80Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                d80.h(this.d.p).g(601110).c("dns_begin", System.currentTimeMillis());
                r80.c(this.d.p).b(this.a, new C0458a(this, currentTimeMillis));
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ v80 d;

        /* loaded from: classes6.dex */
        public class a implements Callable<u80> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public u80 call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    l90.a("SocketTransceiver", "socketStateFutureTask star call()");
                    d80.h(this.a.d.p).g(601110).d("P22", "socket connect thread start");
                    return this.a.d.q.e(this.a.b, Integer.valueOf(this.a.a).intValue());
                }
                return (u80) invokeV.objValue;
            }
        }

        public d(v80 v80Var, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v80Var;
            this.b = str;
            this.a = str2;
            this.c = num;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MobilebdThread"})
        public synchronized void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    l90.a("SocketTransceiver", "start socket connect, connectTaskId: " + this.c);
                    try {
                    } catch (Exception e) {
                        l90.c("SocketTransceiver", "socket connect by ConnectTask occur exception: ", e);
                        this.d.R("socket connect by ConnectTask occur exception: " + e, this.b, true);
                    }
                    if (v80.F.a != -1) {
                        l90.a("SocketTransceiver", "socketConnectState is " + this.d.U() + ", return");
                        return;
                    }
                    v80.F.a = -2;
                    if (this.d.L()) {
                        l90.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                        e80 g = d80.h(this.d.p).g(601110);
                        g.d("P11", "socket create begin, but socket has created ok.");
                        g.d("con_err_code", "P11");
                        g.b("retry_cout", this.d.o.get());
                        this.d.M();
                    }
                    if (this.d.v != null && this.d.v.isAlive()) {
                        this.d.v.interrupt();
                        l90.a("SocketTransceiver", "socketConnectThread interrupt");
                    }
                    if (this.d.l != null && this.d.l.isAlive()) {
                        this.d.l.interrupt();
                        l90.a("SocketTransceiver", "readThread interrupt");
                    }
                    if (this.d.k != null && this.d.k.isAlive()) {
                        this.d.k.interrupt();
                        l90.a("SocketTransceiver", "sendThread interrupt");
                    }
                    try {
                        l90.a("SocketTransceiver", "socket ConnectTask start create Socket Object for connect");
                        long currentTimeMillis = System.currentTimeMillis();
                        e80 g2 = d80.h(this.d.p).g(601110);
                        g2.b("connect_state", 3);
                        g2.c("socket_begin", System.currentTimeMillis());
                        FutureTask futureTask = new FutureTask(new a(this));
                        this.d.v = new Thread(futureTask);
                        this.d.v.start();
                        l90.a("SocketTransceiver", "ConnectTask run FutureTask by socketConnectThread for create Socket Object");
                        u80 u80Var = (u80) futureTask.get(5000L, TimeUnit.MILLISECONDS);
                        d80.h(this.d.p).g(601110).c("socket_end", System.currentTimeMillis());
                        l90.b("SocketTransceiver", "socket ConnectTask create Socket end, cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        if (u80Var != null) {
                            if (this.d.L()) {
                                l90.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                e80 g3 = d80.h(this.d.p).g(601110);
                                g3.d("P12", "socketConnect after, but socket has created ok.");
                                g3.d("con_err_code", "P12");
                                g3.b("retry_cout", this.d.o.get());
                                this.d.M();
                            }
                            if (!u80Var.b.booleanValue()) {
                                e80 g4 = d80.h(this.d.p).g(601110);
                                g4.d("P14", "connect env error:" + this.b);
                                g4.d("con_err_code", "P14");
                                g4.b("retry_cout", this.d.o.get());
                                this.d.o0("connect env error:", this.b);
                                return;
                            }
                            l90.a("SocketTransceiver", "socketState verified ENV approved, start setCurrentSocketState");
                            this.d.q.c(u80Var);
                            if (this.d.v != null && this.d.v.isAlive()) {
                                this.d.v.interrupt();
                                l90.a("SocketTransceiver", "socketConnectThread interrupt");
                            }
                            l90.d("SocketTransceiver", "create Socket ok");
                            e80 g5 = d80.h(this.d.p).g(601110);
                            g5.d("P15", "create Socket ok");
                            g5.d("con_err_code", "P15");
                            Context context = this.d.p;
                            if (this.d.o.get() == 0) {
                                i = 1;
                            } else {
                                i = 2;
                            }
                            m90.z(context, i);
                            r80.g(this.d.p, this.b);
                            l90.a("SocketTransceiver", "socket ConnectTask end, start lcp login");
                            this.d.l0(this.d.W(true));
                            this.d.y = SystemClock.currentThreadTimeMillis();
                            l90.a("SocketTransceiver", "socket connected: create socket success when currentThreadTimeMillis is " + this.d.y);
                            this.d.n = false;
                            this.d.k = new h(this.d, this.b);
                            this.d.k.start();
                            this.d.l = new g(this.d, this.b);
                            this.d.l.start();
                            this.d.w.set(false);
                            l90.b("SocketTransceiver", "connectTaskRunning.set(false)");
                            return;
                        }
                        throw new RuntimeException("crate socket end, get SocketState is null");
                    } catch (Throwable th) {
                        String str = "ConnectTask exception: " + th;
                        l90.c("SocketTransceiver", str, th);
                        l90.b("SocketTransceiver", "socket ConnectTask create Socket end, cost time: " + (System.currentTimeMillis() - 0) + " ms");
                        if (this.d.v != null && this.d.v.isAlive()) {
                            this.d.v.interrupt();
                            l90.a("SocketTransceiver", "socketConnectThread interrupt");
                        }
                        d80.h(this.d.p).g(601110).c("socket_end", System.currentTimeMillis());
                        this.d.R(str, this.b, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v80 a;

        public b(v80 v80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v80Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v80 v80Var = this.a;
                v80Var.l0(v80Var.W(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390823428, "Lcom/baidu/tieba/v80$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-390823428, "Lcom/baidu/tieba/v80$c;");
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

    /* loaded from: classes6.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v80 v80Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, looper};
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
            this.b = v80Var;
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
                    synchronized (this.b.g) {
                        this.b.e0(j, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ v80 b;

        public f(v80 v80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v80Var;
            this.a = 60000L;
        }

        public /* synthetic */ f(v80 v80Var, a aVar) {
            this(v80Var);
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
                this.b.u.removeCallbacks(this.b.m);
                this.b.u.postDelayed(this.b.m, this.a);
                v80 v80Var = this.b;
                v80Var.l0(v80Var.h.b(this.b.p, 3L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        public g(v80 v80Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v80Var;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            s80 s80Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.n) {
                    try {
                        s80 s80Var2 = null;
                        try {
                            s80Var2 = this.b.h.c(this.b.q.b());
                            if (s80Var2 != null && s80Var2.o > 0) {
                                this.b.u.removeCallbacks(this.b.r);
                                s80Var2.n = false;
                                if (k90.a) {
                                    l90.d("SocketTransceiver", "ReadThread receive a message : " + s80Var2.toString());
                                }
                                if (!s80Var2.l) {
                                    if (s80Var2.j == 1 && s80Var2.i == 4) {
                                        Context context = this.b.p;
                                        j90.a(context, 1L, "read", s80Var2.o + "");
                                    }
                                    if (s80Var2.j == 50 && s80Var2.i == 2) {
                                        Context context2 = this.b.p;
                                        j90.a(context2, 50L, "read", s80Var2.o + "");
                                    }
                                    synchronized (this.b.g) {
                                        s80Var = (s80) this.b.e.remove(Long.valueOf(s80Var2.o));
                                        if (s80Var != null) {
                                            l90.a("SocketTransceiver", "ReadThread receive a msg which we request before");
                                        }
                                    }
                                    this.b.c0(s80Var2, s80Var, this.a);
                                }
                                synchronized (this.b.g) {
                                    if (this.b.e.size() != 0) {
                                        l90.a("SocketTransceiver", "ReadThread [sendMessageMap.size() != 0], restart socketReadAndWriteTimeoutRunnable");
                                        this.b.r.b(s80Var2.o);
                                        this.b.r.a(this.a);
                                        this.b.u.a(this.a);
                                        this.b.u.postDelayed(this.b.r, s80Var2.c);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            l90.c("SocketTransceiver", "ReadThread read message exception, mClose is " + this.b.n + " exception: " + e, e);
                            this.b.Y(s80Var2, true);
                            if (this.b.n) {
                                return;
                            }
                            this.b.c = false;
                            v80 v80Var = this.b;
                            v80Var.R("ReadThread read message exception: " + e, this.a, false);
                            return;
                        }
                    } catch (Exception e2) {
                        l90.c("SocketTransceiver", "ReadThread exception, mClose is " + this.b.n + " exception: " + e2, e2);
                        if (this.b.n) {
                            return;
                        }
                        this.b.c = false;
                        v80 v80Var2 = this.b;
                        v80Var2.R("ReadThread exception: " + e2, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        public h(v80 v80Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v80Var;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.n) {
                    try {
                        s80 s80Var = null;
                        try {
                            synchronized (this.b.d) {
                                if (this.b.d.size() == 0) {
                                    this.b.d.wait();
                                } else {
                                    s80Var = (s80) this.b.d.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            l90.b("SocketTransceiver", "SendThread wait exception, mClose is " + this.b.n + ", exception: " + e);
                            if (this.b.n) {
                                return;
                            }
                            this.b.c = false;
                            v80 v80Var = this.b;
                            v80Var.R("SendThread wait exception: " + e, this.a, false);
                        }
                        if (s80Var != null) {
                            try {
                                if (!this.b.n) {
                                    s80Var.n = true;
                                    s80Var.k = v80.F.a;
                                    if (s80Var.p) {
                                        synchronized (this.b.g) {
                                            if (this.b.e.isEmpty()) {
                                                this.b.u.removeCallbacks(this.b.r);
                                                this.b.r.b(s80Var.o);
                                                this.b.r.a(this.a);
                                                this.b.u.a(this.a);
                                                this.b.u.postDelayed(this.b.r, 5000L);
                                            }
                                        }
                                    }
                                    if (k90.a) {
                                        l90.e("SocketTransceiver", "SendThread :" + s80Var.toString());
                                    }
                                    if (s80Var.j == 1 && s80Var.i == 4) {
                                        Context context = this.b.p;
                                        j90.a(context, 1L, "send", s80Var.o + "");
                                    }
                                    if (s80Var.j == 50 && s80Var.i == 2) {
                                        Context context2 = this.b.p;
                                        j90.a(context2, 50L, "send", s80Var.o + "");
                                    }
                                    s80Var.b = System.currentTimeMillis();
                                    synchronized (this.b.f) {
                                        this.b.q.f(s80Var);
                                    }
                                    if (!s80Var.l && s80Var.p) {
                                        synchronized (this.b.g) {
                                            this.b.e.put(Long.valueOf(s80Var.o), s80Var);
                                        }
                                    }
                                } else {
                                    this.b.d0(s80Var.o, this.a);
                                    return;
                                }
                            } catch (Exception e2) {
                                l90.c("SocketTransceiver", "SendThread sendMessage message exception, mClose is " + this.b.n, e2);
                                this.b.Y(s80Var, false);
                                this.b.Z(s80Var.o, e2.toString(), this.a);
                                if (this.b.n) {
                                    return;
                                }
                                this.b.c = false;
                                v80 v80Var2 = this.b;
                                v80Var2.R("SendThread sendMessage Exception:" + e2, this.a, false);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        l90.c("SocketTransceiver", "SendThread Exception, mClose is " + this.b.n, e3);
                        if (this.b.n) {
                            return;
                        }
                        this.b.c = false;
                        v80 v80Var3 = this.b;
                        v80Var3.R("SendThread Exception:" + e3, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        public i(v80 v80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v80Var;
            this.a = "";
        }

        public /* synthetic */ i(v80 v80Var, a aVar) {
            this(v80Var);
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
                e80 b = d80.h(this.b.p).b(601110);
                b.c("flow_start_time", System.currentTimeMillis());
                b.d("P18", "retry by disconnect");
                b.d("con_err_code", "P18");
                b.d("source", "retry : " + this.a);
                this.b.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public final /* synthetic */ v80 c;

        public j(v80 v80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v80Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a = j;
            }
        }

        public /* synthetic */ j(v80 v80Var, a aVar) {
            this(v80Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.e0(this.a, this.b);
                this.c.R("read and write thread timeout:", this.b, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948194523, "Lcom/baidu/tieba/v80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948194523, "Lcom/baidu/tieba/v80;");
                return;
            }
        }
        F = new l80();
    }

    public final String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (F.a == -1) {
                return "UNCONNECTED";
            }
            if (F.a == -2) {
                return "CONNECTING";
            }
            return "CONNECTED";
        }
        return (String) invokeV.objValue;
    }

    public l80 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return F;
        }
        return (l80) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            l90.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            l0(this.h.b(this.p, 3L));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            l90.a("SocketTransceiver", "resetConnectParameter");
            this.b = 0;
            this.o.set(0);
            r80.i();
        }
    }

    public synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                l90.a("SocketTransceiver", "socketConnect");
                this.c = false;
                j0();
                P();
            }
        }
    }

    public v80(Context context) {
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
        this.a = new AtomicInteger(0);
        this.b = 0;
        this.c = false;
        this.d = new LinkedList<>();
        this.e = new LinkedHashMap();
        this.f = new Object();
        this.g = new Object();
        this.h = new z80();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.m = new f(this, null);
        this.n = false;
        this.o = new AtomicInteger(0);
        this.r = new j(this, null);
        this.s = new i(this, null);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = new b(this);
        this.p = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new e(this, this.t.getLooper());
    }

    public static synchronized v80 V(Context context) {
        InterceptResult invokeL;
        v80 v80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            synchronized (v80.class) {
                if (G == null) {
                    G = new v80(context.getApplicationContext());
                }
                v80Var = G;
            }
            return v80Var;
        }
        return (v80) invokeL.objValue;
    }

    public synchronized void K(BLCPRequest bLCPRequest, q80 q80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, q80Var) == null) {
            synchronized (this) {
                s80 s80Var = new s80();
                s80Var.i = bLCPRequest.a;
                s80Var.j = bLCPRequest.b;
                s80Var.a = bLCPRequest.c;
                if (bLCPRequest.d < 0) {
                    s80Var.o = System.currentTimeMillis();
                } else {
                    s80Var.o = bLCPRequest.d;
                }
                int i2 = c.a[bLCPRequest.e.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            s80Var.c = 5000L;
                        } else {
                            s80Var.c = 50000L;
                        }
                    } else {
                        s80Var.c = 30000L;
                    }
                } else {
                    s80Var.c = 20000L;
                }
                if (bLCPRequest instanceof p80) {
                    long j2 = (s80Var.i * 10000) + s80Var.j;
                    s80Var.o = j2;
                    m0(s80Var.i, s80Var.j, j2, true, q80Var);
                } else {
                    m0(s80Var.i, s80Var.j, s80Var.o, false, q80Var);
                    this.h.a(s80Var, true);
                    l0(s80Var);
                }
            }
        }
    }

    public final void d0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048594, this, j2, str) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    l90.a("SocketTransceiver", "handle msg socket stoped!!! " + this.e.get(Long.valueOf(j2)).toString());
                    s80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8006;
                    remove.e = "socket stopped :";
                    c0(remove, remove, str);
                }
            } catch (Exception e2) {
                l90.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void e0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048595, this, j2, str) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    l90.a("SocketTransceiver", "handle msg timeout!!! " + this.e.get(Long.valueOf(j2)).toString());
                    s80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = ResponseCode.LCP_TIME_OUT;
                    remove.e = "socket timeout";
                    c0(remove, remove, str);
                }
            } catch (Exception e2) {
                l90.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t80 t80Var = this.q;
            if (t80Var != null && t80Var.a() != null && this.q.a().c != null && this.q.a().c.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        u80 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (a2 = this.q.a()) != null && a2.a.booleanValue()) {
            try {
                if (a2.c != null) {
                    a2.c.close();
                    a2.c = null;
                    if (a2.d != null) {
                        a2.d.close();
                        a2.d = null;
                    }
                    if (a2.e != null) {
                        a2.e.close();
                        a2.e = null;
                    }
                    l90.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                l90.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final synchronized void O(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                if (!this.w.getAndSet(true)) {
                    l90.b("SocketTransceiver", "connectTaskRunning.set(true)");
                    i90.a(this.p).b(new a(this, str, str2, str3));
                } else {
                    l90.b("SocketTransceiver", "connect() return, ");
                }
            }
        }
    }

    public final void c0(s80 s80Var, s80 s80Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, s80Var, s80Var2, str) == null) {
            f0(s80Var2, s80Var, str);
            long j2 = s80Var.i;
            if (j2 == 1) {
                a0(s80Var, str);
            } else if (j2 != -1) {
                g0(s80Var);
            } else if (s80Var2 == null) {
            } else {
                if (s80Var2.i == 1) {
                    a0(s80Var2, str);
                } else {
                    g0(s80Var2);
                }
            }
        }
    }

    public final synchronized void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.p)) {
                    e80 g2 = d80.h(this.p).g(601110);
                    g2.d("net_connect", "false");
                    g2.c("flow_end_time", System.currentTimeMillis());
                    g2.d("P33", "socket connectImpl error, no net");
                    g2.d("con_err_code", "P33");
                    g2.b("retry_cout", this.o.get());
                    g2.b("connect_state", -1);
                    g2.e();
                    j0();
                    F.a = -1;
                    p0(false);
                    return;
                }
                l90.d("SocketTransceiver", "connectImpl socket connect state:" + U());
                if (F.a != 0 && F.a != -2) {
                    this.u.removeCallbacks(this.s);
                    this.u.removeCallbacks(this.E);
                    this.u.removeCallbacks(this.m);
                    i0();
                    return;
                }
                e80 g3 = d80.h(this.p).g(601110);
                g3.b("inner_connect_state", F.a);
                g3.d("P34", "socket connectImpl repeat");
                g3.d("con_err_code", "P34");
                g3.b("retry_cout", this.o.get());
            }
        }
    }

    public final synchronized void Q(String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                if (k90.a) {
                    l90.d("SocketTransceiver", "destroy socket connect start, reason : " + str + ", host: " + str2 + ", syncStatus: " + z + ", isConnectException: " + z2);
                }
                this.u.removeCallbacks(this.r);
                this.n = true;
                if (this.q != null) {
                    synchronized (this.d) {
                        this.d.notifyAll();
                        l90.d("SocketTransceiver", "destroy socket connect, sendQueue notifyAll");
                    }
                    try {
                        this.q.d();
                        l90.a("SocketTransceiver", "destroy socket connect, socketClose success");
                    } catch (Exception e2) {
                        this.q.c(null);
                        l90.c("SocketTransceiver", "Exception destroy:", e2);
                    }
                }
                F.a = -1;
                if (z) {
                    e80 g2 = d80.h(this.p).g(601110);
                    g2.d("P17", str);
                    g2.d("con_err_code", "P17");
                    p0(true);
                } else {
                    if (m80.g().h() == 0) {
                        l80 l80Var = new l80();
                        l80Var.a = -2;
                        setChanged();
                        notifyObservers(l80Var);
                        m80.g().j();
                    }
                    if (z2) {
                        e80 g3 = d80.h(this.p).g(601110);
                        g3.c("flow_end_time", System.currentTimeMillis());
                        g3.b("retry_cout", this.o.get());
                        g3.d("P21", "connect end by exception:" + str);
                        g3.d("con_err_code", "P21");
                        g3.e();
                    }
                }
            }
        }
    }

    public synchronized void R(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, str, str2, z) == null) {
            synchronized (this) {
                if (k90.a) {
                    l90.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.c + ", net :" + RequsetNetworkUtils.isConnected(this.p) + ", reason : " + str);
                }
                S(str2);
                if (this.c) {
                    e80 g2 = d80.h(this.p).g(601110);
                    g2.d("P16", "disconnectedByLcp:" + this.c);
                    g2.d("con_err_code", "P16");
                    g2.b("retry_cout", this.o.get());
                    j0();
                    return;
                }
                d80.h(this.p).g(601110).c("destory_starttime", System.currentTimeMillis());
                Q(str, str2, false, z);
                d80.h(this.p).g(601110).c("destory_endtime", System.currentTimeMillis());
                if (z) {
                    this.w.set(false);
                    l90.b("SocketTransceiver", "connectTaskRunning.set(false)");
                }
                k0(false, str2, str);
            }
        }
    }

    public final void Z(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    l90.a("SocketTransceiver", "handle msg exception!!! " + this.e.get(Long.valueOf(j2)).toString());
                    s80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8005;
                    remove.e = "socket exception :" + str;
                    c0(remove, remove, str2);
                }
            } catch (Exception e2) {
                l90.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void b0(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                e80 g2 = d80.h(this.p).g(601110);
                g2.c("login_end", System.currentTimeMillis());
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("connect_state", 4);
                g2.d("P55", "lcp login success");
                g2.d("con_err_code", "lcp login success");
                g2.b("retry_cout", this.o.get());
                g2.e();
                this.o.set(0);
                F.a = 0;
                l90.b("SocketTransceiver", "lcm login success, cost: , lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
                p0(false);
                if (!z) {
                    return;
                }
                this.u.a(str);
                this.u.postDelayed(this.m, j2);
                l90.a("SocketTransceiver", "ping every 1分钟 ");
            } catch (Exception e2) {
                l90.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                l90.a("SocketTransceiver", "socket connect disConnect, fatalAllMessage begin ");
                d80.h(this.p).g(601110).b("sendQueue_length", this.d.size());
                d80.h(this.p).g(601110).c("sendQueue_starttime", System.currentTimeMillis());
                synchronized (this.d) {
                    while (this.d.size() > 0) {
                        T(this.d.removeFirst(), str);
                    }
                    l90.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                d80.h(this.p).g(601110).c("sendQueue_endtime", System.currentTimeMillis());
                d80.h(this.p).g(601110).b("sendMessageMap_length", this.e.size());
                d80.h(this.p).g(601110).c("sendMessageMap_starttime", System.currentTimeMillis());
                synchronized (this.g) {
                    l90.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.e.keySet()) {
                        T(this.e.get(l), str);
                    }
                    this.e.clear();
                    l90.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
                d80.h(this.p).g(601110).c("sendMessageMap_endtime", System.currentTimeMillis());
            } catch (Exception e2) {
                l90.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final synchronized void l0(s80 s80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, s80Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    l90.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.d) {
                    boolean z = false;
                    Iterator<s80> it = this.d.iterator();
                    while (it.hasNext()) {
                        s80 next = it.next();
                        l90.a("SocketTransceiver", "sendMessage queue :" + next.o);
                        if (next.m) {
                            z = true;
                        }
                    }
                    if (s80Var.m) {
                        if (!z && F.a == -2) {
                            this.d.addFirst(s80Var);
                            this.d.notifyAll();
                        }
                        l90.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + U());
                    } else if (F.a == -1) {
                        if (L()) {
                            if (this.d.size() <= 0 || !z) {
                                this.d.addFirst(W(true));
                                this.d.notifyAll();
                            }
                            if (!s80Var.l) {
                                this.d.add(s80Var);
                                this.d.notifyAll();
                            }
                        } else {
                            if (s80Var.l && m80.g().h() == -1) {
                                m80.g().f("ping");
                            }
                            this.d.add(s80Var);
                        }
                    } else {
                        this.d.add(s80Var);
                        this.d.notifyAll();
                    }
                }
            }
        }
    }

    public final void T(s80 s80Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, s80Var, str) == null) && s80Var != null && s80Var.i != 1) {
            l90.b("SocketTransceiver", "fetalAndClearMsg : " + s80Var.o + ", serviceId :" + s80Var.i + ", methodId :" + s80Var.j);
            c0(new s80(), s80Var, str);
        }
    }

    public final void Y(s80 s80Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, s80Var, z) == null) && s80Var != null && s80Var.j == 50 && s80Var.i == 2) {
            if (z) {
                str = "ReadThread read ImLoginMessage occur exception";
            } else {
                str = "SendThread send ImLoginMessage occur exception";
            }
            e80 g2 = d80.h(this.p).g(601110);
            g2.c("login_end", System.currentTimeMillis());
            g2.d("P46", str);
            g2.d("con_err_code", "P46");
        }
    }

    public synchronized void o0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) {
            synchronized (this) {
                l90.d("SocketTransceiver", "---socketDisconnect---");
                this.n = true;
                this.c = true;
                S(str2);
                j0();
                this.u.removeCallbacks(this.s);
                this.u.removeCallbacks(this.E);
                this.u.removeCallbacks(this.m);
                r80.h(this.p, null, false);
                Q(str, str2, true, true);
                this.w.set(false);
            }
        }
    }

    public final s80 W(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (z) {
                this.z = System.currentTimeMillis();
                e80 g2 = d80.h(this.p).g(601110);
                g2.b("connect_state", 4);
                g2.c("login_begin", System.currentTimeMillis());
            }
            return this.h.b(this.p, 1L);
        }
        return (s80) invokeZ.objValue;
    }

    public final void a0(s80 s80Var, String str) {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, s80Var, str) == null) {
            if (s80Var.d == 0) {
                long j3 = s80Var.h;
                if (j3 <= 0) {
                    j2 = 60000;
                } else {
                    j2 = j3;
                }
                long j4 = s80Var.j;
                if (j4 == 1) {
                    b0(j2, true, str);
                    return;
                } else if (j4 == 2) {
                    l90.d("SocketTransceiver", "LCP logout, cur msg.connectState is " + s80Var.k);
                    o0("LCP logout:", str);
                    return;
                } else if (j4 == 3) {
                    this.m.a(j2);
                    return;
                } else {
                    return;
                }
            }
            String str2 = " errorcode:" + s80Var.d + " errmsg:" + s80Var.e;
            if (!String.valueOf(s80Var.d).startsWith(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK) && (i2 = s80Var.d) != 1011 && i2 != 2001 && i2 != 2003) {
                if (i2 == 1012) {
                    l90.a("SocketTransceiver", "login error :" + str2 + ", lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
                    e80 g2 = d80.h(this.p).g(601110);
                    g2.c("login_end", System.currentTimeMillis());
                    StringBuilder sb = new StringBuilder();
                    sb.append("lcp login failed:");
                    sb.append(str2);
                    g2.d("P45", sb.toString());
                    g2.d("con_err_code", "P45");
                    if (!this.x.getAndSet(true)) {
                        m90.x(this.p, "");
                        o0(str2, str);
                        m80.g().f("lcp login failed:");
                        this.x.set(false);
                        return;
                    }
                    return;
                } else if (i2 == 1013) {
                    b0(60000L, false, str);
                    return;
                } else {
                    l90.a("SocketTransceiver", "login error :" + str2);
                    e80 g3 = d80.h(this.p).g(601110);
                    g3.c("login_end", System.currentTimeMillis());
                    g3.d("P47", "lcp login failed:" + str2);
                    g3.d("con_err_code", "P47");
                    F.a = -1;
                    k0(true, str, str2);
                    return;
                }
            }
            l90.a("SocketTransceiver", "login error, then request token, error code :" + s80Var.d + ", lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
            e80 g4 = d80.h(this.p).g(601110);
            g4.c("login_end", System.currentTimeMillis());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lcp login failed:");
            sb2.append(str2);
            g4.d("P45", sb2.toString());
            g4.d("con_err_code", "P45");
            if (!this.x.getAndSet(true)) {
                m90.x(this.p, "");
                o0(str2, str);
                m80.g().f("lcp login failed:");
                this.x.set(false);
            }
        }
    }

    public final void f0(s80 s80Var, s80 s80Var2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, s80Var, s80Var2, str) == null) && s80Var != null) {
            e80 b2 = d80.h(this.p).b(601111);
            b2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, s80Var2.o);
            b2.c("service_id", s80Var2.i);
            b2.c("method_id", s80Var2.j);
            b2.b("error_code", s80Var2.d);
            b2.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, s80Var2.e);
            b2.c("request_time", s80Var.b);
            b2.c("response_time", System.currentTimeMillis());
            b2.d("ext", "");
            b2.d(ProbeTB.PROTOCOL, this.B);
            b2.d("ip", this.A);
            b2.d("domain", this.C);
            b2.d(ClientCookie.PORT_ATTR, this.D);
            b2.e();
        }
    }

    public final synchronized void g0(s80 s80Var) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, s80Var) == null) {
            synchronized (this) {
                q80 q80Var = null;
                try {
                    if (!s80Var.f) {
                        j2 = s80Var.o;
                    } else {
                        j2 = (s80Var.i * 10000) + s80Var.j;
                    }
                    Long valueOf = Long.valueOf(j2);
                    if (k90.a) {
                        l90.a("SocketTransceiver", "onBLCPResponse,  key:" + valueOf + ", methodId :" + s80Var.j + ", serviceId :" + s80Var.i + ", error :" + s80Var.d + ", msgId :" + s80Var.o + ", errMsg :" + s80Var.e + ", invoke keys :" + this.i.keySet().toString() + ", notify keys :" + this.j.keySet().toString());
                    }
                    if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        q80Var = this.j.get(valueOf);
                    } else if (this.i.size() > 0 && this.i.containsKey(valueOf)) {
                        q80Var = this.i.remove(valueOf);
                    }
                    if (q80Var != null) {
                        if (q80Var instanceof o80) {
                            o80.a aVar = new o80.a();
                            long j3 = s80Var.i;
                            aVar.a = s80Var.j;
                            aVar.b = s80Var.o;
                            aVar.c = s80Var.g;
                            aVar.d = s80Var.q;
                            ((o80) q80Var).onResponse(s80Var.d, s80Var.e, aVar);
                        } else {
                            q80Var.onResponse(s80Var.d, s80Var.e, s80Var.i, s80Var.j, s80Var.o, s80Var.g);
                        }
                        if (s80Var.d == 1011) {
                            l90.a("SocketTransceiver", "onBLCPResponse, errorCode :" + s80Var.d + ", and will send lcm login msg .");
                            l0(W(false));
                        }
                    }
                } catch (Exception e2) {
                    l90.c("SocketTransceiver", "onBLCPResponse, Exception!!!", e2);
                }
            }
        }
    }

    public final synchronized void i0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                if (!this.C.isEmpty() && !this.D.isEmpty() && r80.d()) {
                    O(this.C, this.D, this.B);
                    return;
                }
                l90.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.b);
                int i2 = m90.i(this.p);
                String[] split = m90.h(this.p, this.b).split(":");
                if (split.length < 3) {
                    if (this.b < i2) {
                        this.b++;
                        this.C = "";
                        this.D = "";
                        i0();
                    }
                    return;
                }
                if (TextUtils.isEmpty(split[0])) {
                    str = "tcp";
                } else {
                    str = split[0];
                }
                String str2 = split[1];
                String str3 = split[2];
                if (this.b >= i2) {
                    this.b = 0;
                    l90.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.q = new w80(this.p, "tls");
                    this.C = "lcs.baidu.com";
                    this.D = "443";
                    this.B = "tls";
                    O("lcs.baidu.com", "443", "tls");
                } else {
                    if ("quic".equals(str) && !(this.q instanceof QuicMessageHandler)) {
                        this.q = new QuicMessageHandler(this.p);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.q instanceof w80))) {
                        this.q = new w80(this.p, str);
                    }
                    this.b++;
                    if (this.q != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        l90.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.C = str2;
                        this.D = str3;
                        this.B = str;
                        O(str2, str3, str);
                    } else {
                        this.C = "";
                        this.D = "";
                        i0();
                    }
                }
            }
        }
    }

    public final void k0(boolean z, String str, String str2) {
        String str3;
        Runnable runnable;
        Runnable runnable2;
        int i2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            try {
                if (this.o.get() <= 10 && F.a == -1) {
                    this.u.removeCallbacks(this.m);
                    e eVar = this.u;
                    if (z) {
                        runnable = this.s;
                    } else {
                        runnable = this.E;
                    }
                    eVar.removeCallbacks(runnable);
                    this.s.a(str2);
                    if (z) {
                        runnable2 = this.E;
                    } else {
                        runnable2 = this.s;
                    }
                    Message obtain = Message.obtain(this.u, runnable2);
                    if (z) {
                        i2 = 202020;
                    } else {
                        i2 = 101010;
                    }
                    obtain.what = i2;
                    if (!this.u.hasMessages(i2)) {
                        this.o.incrementAndGet();
                        long N = N(this.o.get());
                        StringBuilder sb = new StringBuilder();
                        sb.append("waiting Schedule retry ");
                        if (z) {
                            str4 = "login";
                        } else {
                            str4 = "connect";
                        }
                        sb.append(str4);
                        sb.append(" , retry times: ");
                        sb.append(this.o.get());
                        sb.append(" time delay: ");
                        sb.append(N);
                        sb.append(", reason: ");
                        sb.append(str2);
                        String sb2 = sb.toString();
                        e80 g2 = d80.h(this.p).g(601110);
                        g2.d("P44", sb2);
                        g2.d("con_err_code", "P44");
                        this.u.sendMessageDelayed(obtain, N);
                        l90.d("SocketTransceiver", sb2);
                        return;
                    }
                    l90.d("SocketTransceiver", "waiting Schedule retry， but handler queue had this runnable, pass");
                    return;
                }
                o0("retry strategy had cost " + this.o.get() + " and stop retry, cur connectState:" + F.a + ", reason: " + str2, str);
            } catch (Exception e2) {
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
                l90.b("SocketTransceiver", sb4);
                o0(sb4, str);
            }
        }
    }

    public final void m0(long j2, long j3, long j4, boolean z, q80 q80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), q80Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (z) {
                if (q80Var != null) {
                    this.j.put(valueOf, q80Var);
                }
            } else {
                this.i.put(valueOf, q80Var);
            }
            if (k90.a) {
                l90.a("SocketTransceiver", "addMessageToQueue isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.i.keySet().toString() + ", notify keys :" + this.j.keySet().toString());
            }
        }
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (k90.a) {
                l90.a("SocketTransceiver", "socket connect state change, sync to lcp global connect state, cur socket state is " + U());
            }
            if (z && F.a == -1 && m80.g().h() == -2) {
                e80 g2 = d80.h(this.p).g(601110);
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("retry_cout", this.o.get());
                g2.e();
            }
            setChanged();
            notifyObservers(F);
            m80.g().j();
        }
    }
}
