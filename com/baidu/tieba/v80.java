package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
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
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes6.dex */
public final class v80 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n80 D;
    public static volatile v80 E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public Runnable B;
    public Runnable C;
    public final Map<Integer, Boolean> a;
    public AtomicInteger b;
    public int c;
    public boolean d;
    public volatile LinkedList<s80> e;
    public final HashMap<Long, s80> f;
    public final Object g;
    public final Object h;
    public z80 i;
    public Map<Long, q80> j;
    public Map<Long, q80> k;
    public j l;
    public i m;
    public h n;
    public boolean o;
    public AtomicInteger p;
    public Context q;
    public t80 r;
    public k s;
    public HandlerThread t;
    public g u;
    public long v;
    public String w;
    public String x;
    public String y;
    public String z;

    public final long K(int i2) {
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
    public final class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ v80 d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l90.c(this.a.d.q);
                    l90.e("lcp connect:" + (System.currentTimeMillis() - this.a.d.A));
                }
            }
        }

        public e(v80 v80Var, String str, String str2, Integer num) {
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
        public synchronized void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    try {
                    } catch (Exception e) {
                        m90.c("SocketTransceiver", "connectRunnable", e);
                    }
                    if (this.d.I()) {
                        m90.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                        e80.h(this.d.q).g(601110).d("P11", "socket create begin, but socket has created ok.").d("con_err_code", "P11").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
                        return;
                    }
                    if (this.d.m != null && this.d.m.isAlive()) {
                        this.d.m.interrupt();
                        m90.a("SocketTransceiver", "readThread interrupt");
                    }
                    if (this.d.l != null && this.d.l.isAlive()) {
                        this.d.l.interrupt();
                        m90.a("SocketTransceiver", "sendThread interrupt");
                    }
                    f fVar = new f(this.d, this.c, this.b);
                    this.d.u.a(this.b);
                    this.d.u.postDelayed(fVar, 15000L);
                    try {
                        e80.h(this.d.q).g(601110).c("socket_begin", System.currentTimeMillis());
                        u80 e2 = this.d.r.e(this.b, Integer.valueOf(this.a).intValue());
                        if (this.d.I()) {
                            e80.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).d("P12", "socketConnect after, but socket has created ok.").d("con_err_code", "P12").b("retry_cout", this.d.p.get()).e();
                            m90.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            this.d.J(e2);
                        } else if (!e2.b.booleanValue()) {
                            e80.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("P14", "connect env error:" + this.b).d("con_err_code", "P14").b("retry_cout", this.d.p.get()).e();
                            this.d.u.removeCallbacks(fVar);
                            this.d.i0("connect env error:", this.b);
                        } else {
                            synchronized (this.d.a) {
                                m90.a("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                this.d.u.removeCallbacks(fVar);
                                fVar.a();
                                if (this.d.I()) {
                                    m90.a("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    this.d.J(e2);
                                    return;
                                }
                                if (this.d.a.get(this.c) == null) {
                                    m90.a("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                    this.d.r.c(e2);
                                }
                                e80.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis()).b("connect_state", 3).d("P15", "create Socket ok").d("con_err_code", "P15");
                                Context context = this.d.q;
                                if (this.d.p.get() == 0) {
                                    i = 1;
                                } else {
                                    i = 2;
                                }
                                n90.B(context, i);
                                m90.d("SocketTransceiver", "create Socket ok");
                                r80.g(this.d.q, this.b);
                                e80.h(this.d.q).g(601110).c("login_begin", System.currentTimeMillis());
                                this.d.f0(this.d.i.b(this.d.q, 1L));
                                this.d.v = SystemClock.currentThreadTimeMillis();
                                if (k90.a(this.d.q) != 0) {
                                    h90.a(this.d.q).b(new a(this));
                                }
                                m90.a("SocketTransceiver", "connectImpl time:" + this.d.v);
                                v80.D.a = -2;
                                this.d.o = false;
                                this.d.l = new j(this.d, this.b);
                                this.d.l.start();
                                this.d.m = new i(this.d, this.b);
                                this.d.m.start();
                            }
                        }
                    } catch (Throwable th) {
                        String str = "Throwable : " + th;
                        m90.c("SocketTransceiver", str, th);
                        this.d.u.removeCallbacks(fVar);
                        fVar.a();
                        synchronized (this.d.a) {
                            if (this.d.a.get(this.c) != null) {
                                this.d.a.remove(this.c);
                                return;
                            }
                            this.d.O("ConnectTask exception:" + str, this.b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements r80.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ v80 d;

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

        @Override // com.baidu.tieba.r80.d
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                m90.a("SocketTransceiver", "-----try to connect ip:" + str2);
                if (TextUtils.isEmpty(str2)) {
                    str2 = this.a;
                }
                v80 v80Var = this.d;
                v80Var.w = str2;
                g80 d = e80.h(v80Var.q).g(601110).c("dns_end", System.currentTimeMillis()).d(ClientCookie.PORT_ATTR, this.b).d("ip", str2).d("domain", this.a).d(ProbeTB.PROTOCOL, this.c);
                d.d("P31", "DNS result:" + i).d("con_err_code", "P31");
                if (i == 0) {
                    e80.h(this.d.q).g(601110).b("connect_state", 2);
                    h90 a = h90.a(this.d.q);
                    v80 v80Var2 = this.d;
                    a.b(new e(v80Var2, str2, this.b, Integer.valueOf(v80Var2.b.incrementAndGet())));
                    return;
                }
                e80.h(this.d.q).g(601110).c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.d.p.get()).e();
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.M();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v80 a;

        public c(v80 v80Var) {
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
                v80Var.f0(v80Var.i.b(this.a.q, 1L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390823397, "Lcom/baidu/tieba/v80$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-390823397, "Lcom/baidu/tieba/v80$d;");
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;
        public boolean b;
        public String c;
        public final /* synthetic */ v80 d;

        public f(v80 v80Var, Integer num, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v80Var, num, str};
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
            this.b = false;
            this.a = num;
            this.c = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b = true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.d.a) {
                    if (!this.b && v80.D.a != 0) {
                        this.d.a.put(this.a, Boolean.TRUE);
                        e80.h(this.d.q).g(601110).c("socket_end", System.currentTimeMillis());
                        this.d.O("time out:", this.c);
                        return;
                    }
                    m90.b("SocketTransceiver", "ConnectTimeOutTask has stoped");
                    this.d.u.removeCallbacks(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(v80 v80Var, Looper looper) {
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
                    synchronized (this.b.h) {
                        this.b.Y(j, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ v80 b;

        public h(v80 v80Var) {
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

        public /* synthetic */ h(v80 v80Var, a aVar) {
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
                this.b.u.removeCallbacks(this.b.n);
                if (n90.m(this.b.q)) {
                    this.b.u.postDelayed(this.b.n, this.a);
                    v80 v80Var = this.b;
                    v80Var.f0(v80Var.i.b(this.b.q, 3L));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        public i(v80 v80Var, String str) {
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
                while (!this.b.o) {
                    try {
                        try {
                            s80 c = this.b.i.c(this.b.r.b());
                            if (c != null && c.n > 0) {
                                this.b.u.removeCallbacks(this.b.s);
                                c.m = false;
                                m90.d("SocketTransceiver", "ReadThread :" + c.toString());
                                if (!c.k) {
                                    if (c.i == 1 && c.h == 4) {
                                        Context context = this.b.q;
                                        j90.a(context, 1L, "read", c.n + "");
                                    }
                                    if (c.i == 50 && c.h == 2) {
                                        Context context2 = this.b.q;
                                        j90.a(context2, 50L, "read", c.n + "");
                                    }
                                    synchronized (this.b.h) {
                                        m90.a("SocketTransceiver", "ReadThread handleResponseMessage...");
                                        s80Var = (s80) this.b.f.remove(Long.valueOf(c.n));
                                    }
                                    this.b.W(c, s80Var, this.a);
                                }
                                synchronized (this.b.h) {
                                    if (this.b.f.size() != 0) {
                                        m90.a("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                        this.b.s.b(c.n);
                                        this.b.s.a(this.a);
                                        this.b.u.a(this.a);
                                        this.b.u.postDelayed(this.b.s, c.b);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            if (this.b.o) {
                                return;
                            }
                            m90.c("SocketTransceiver", "ReadThread exception: " + e, e);
                            this.b.d = false;
                            v80 v80Var = this.b;
                            v80Var.O("ReadThread exception: " + e, this.a);
                            return;
                        }
                    } catch (Exception e2) {
                        if (this.b.o) {
                            return;
                        }
                        m90.c("SocketTransceiver", "onStartCommand", e2);
                        this.b.d = false;
                        v80 v80Var2 = this.b;
                        v80Var2.O("onStartCommand:" + e2, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ v80 b;

        public j(v80 v80Var, String str) {
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
                while (!this.b.o) {
                    try {
                        s80 s80Var = null;
                        try {
                            synchronized (this.b.e) {
                                if (this.b.e.size() == 0) {
                                    this.b.e.wait();
                                } else {
                                    s80Var = (s80) this.b.e.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            m90.b("SocketTransceiver", "SendThread wait exception: " + e);
                            v80 v80Var = this.b;
                            v80Var.O("SendThread wait exception: " + e, this.a);
                        }
                        if (s80Var != null) {
                            try {
                                if (!this.b.o) {
                                    s80Var.m = true;
                                    s80Var.j = v80.D.a;
                                    if (s80Var.o) {
                                        synchronized (this.b.h) {
                                            if (this.b.f.isEmpty()) {
                                                this.b.u.removeCallbacks(this.b.s);
                                                this.b.s.b(s80Var.n);
                                                this.b.s.a(this.a);
                                                this.b.u.a(this.a);
                                                this.b.u.postDelayed(this.b.s, 15000L);
                                            }
                                        }
                                    }
                                    m90.e("SocketTransceiver", "SendThread :" + s80Var.toString());
                                    if (s80Var.i == 1 && s80Var.h == 4) {
                                        Context context = this.b.q;
                                        j90.a(context, 1L, "send", s80Var.n + "");
                                    }
                                    if (s80Var.i == 50 && s80Var.h == 2) {
                                        Context context2 = this.b.q;
                                        j90.a(context2, 50L, "send", s80Var.n + "");
                                    }
                                    synchronized (this.b.g) {
                                        this.b.r.f(s80Var);
                                    }
                                    if (!s80Var.k && s80Var.o) {
                                        synchronized (this.b.h) {
                                            this.b.f.put(Long.valueOf(s80Var.n), s80Var);
                                        }
                                    }
                                } else {
                                    this.b.X(s80Var.n, this.a);
                                    return;
                                }
                            } catch (Exception e2) {
                                m90.c("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                                this.b.T(s80Var.n, e2.toString(), this.a);
                                v80 v80Var2 = this.b;
                                v80Var2.O("SendThread sendMessage Exception:" + e2, this.a);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        m90.c("SocketTransceiver", "SendThread Exception:", e3);
                        v80 v80Var3 = this.b;
                        v80Var3.O("SendThread Exception:" + e3, this.a);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public final /* synthetic */ v80 c;

        public k(v80 v80Var) {
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

        public /* synthetic */ k(v80 v80Var, a aVar) {
            this(v80Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.c.Y(this.a, this.b);
            this.c.O("read and write thread timeout:", this.b);
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
        D = new n80();
    }

    public n80 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return D;
        }
        return (n80) invokeV.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("com.baidu.lcp.sdk.connect.state", D.a);
            intent.setAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(this.q).sendBroadcast(intent);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            m90.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            f0(this.i.b(this.q, 3L));
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c = 0;
            this.p.set(0);
            r80.i();
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || !n90.m(this.q)) {
            return;
        }
        d0();
        M();
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
        this.a = new TreeMap();
        this.b = new AtomicInteger(0);
        this.c = 0;
        this.d = false;
        this.e = new LinkedList<>();
        this.f = new LinkedHashMap();
        this.g = new Object();
        this.h = new Object();
        this.i = new z80();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.n = new h(this, null);
        this.o = false;
        this.p = new AtomicInteger(0);
        this.s = new k(this, null);
        this.x = "";
        this.y = "";
        this.z = "";
        this.B = new b(this);
        this.C = new c(this);
        this.q = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new g(this, this.t.getLooper());
    }

    public static synchronized v80 S(Context context) {
        InterceptResult invokeL;
        v80 v80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (v80.class) {
                if (E == null) {
                    E = new v80(context.getApplicationContext());
                }
                v80Var = E;
            }
            return v80Var;
        }
        return (v80) invokeL.objValue;
    }

    public synchronized void H(BLCPRequest bLCPRequest, q80 q80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, q80Var) == null) {
            synchronized (this) {
                if (!n90.m(this.q)) {
                    return;
                }
                s80 s80Var = new s80();
                s80Var.h = bLCPRequest.a;
                s80Var.i = bLCPRequest.b;
                s80Var.a = bLCPRequest.c;
                if (bLCPRequest.d < 0) {
                    s80Var.n = System.currentTimeMillis();
                } else {
                    s80Var.n = bLCPRequest.d;
                }
                int i2 = d.a[bLCPRequest.e.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            s80Var.b = 15000L;
                        } else {
                            s80Var.b = 50000L;
                        }
                    } else {
                        s80Var.b = 30000L;
                    }
                } else {
                    s80Var.b = 20000L;
                }
                if (bLCPRequest instanceof p80) {
                    long j2 = (s80Var.h * 10000) + s80Var.i;
                    s80Var.n = j2;
                    g0(s80Var.h, s80Var.i, j2, true, q80Var);
                } else {
                    g0(s80Var.h, s80Var.i, s80Var.n, false, q80Var);
                    this.i.a(s80Var, true);
                    f0(s80Var);
                }
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t80 t80Var = this.r;
            if (t80Var != null && t80Var.a() != null && this.r.a().c != null && this.r.a().c.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J(u80 u80Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u80Var) == null) && u80Var != null && u80Var.a.booleanValue()) {
            try {
                if (u80Var.c != null) {
                    if (u80Var.c.hashCode() == this.r.a().c.hashCode()) {
                        m90.e("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    u80Var.c.close();
                    u80Var.c = null;
                    if (u80Var.d != null) {
                        u80Var.d.close();
                        u80Var.d = null;
                    }
                    if (u80Var.e != null) {
                        u80Var.e.close();
                        u80Var.e = null;
                    }
                    m90.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                m90.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                m90.a("SocketTransceiver", "fatalAllMessage begin ");
                synchronized (this.e) {
                    while (this.e.size() > 0) {
                        Q(this.e.removeFirst(), str);
                    }
                    m90.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                synchronized (this.h) {
                    m90.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.f.keySet()) {
                        Q(this.f.get(l), str);
                    }
                    this.f.clear();
                    m90.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
            } catch (Exception e2) {
                m90.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final synchronized void L(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                e80.h(this.q).g(601110).c("dns_begin", System.currentTimeMillis());
                r80.c(this.q).b(str, new a(this, str, str2, str3));
            }
        }
    }

    public final void W(s80 s80Var, s80 s80Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, s80Var, s80Var2, str) == null) {
            long j2 = s80Var.h;
            if (j2 == 1) {
                U(s80Var, str);
            } else if (j2 != -1) {
                a0(s80Var);
            } else if (s80Var2 == null) {
            } else {
                if (s80Var2.h == 1) {
                    U(s80Var2, str);
                } else {
                    a0(s80Var2);
                }
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    e80.h(this.q).g(601110).d("net_connect", "false").c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                if (D.a != 0 && D.a != -2) {
                    this.u.removeCallbacks(this.B);
                    this.u.removeCallbacks(this.C);
                    this.u.removeCallbacks(this.n);
                    c0();
                    return;
                }
                m90.d("SocketTransceiver", "connectImpl connect state:" + D.a);
                e80.h(this.q).g(601110).b("inner_connect_state", D.a).c("flow_end_time", System.currentTimeMillis()).d("P33", "connectImpl error").d("con_err_code", "P33").b("retry_cout", this.p.get()).e();
            }
        }
    }

    public final synchronized void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            synchronized (this) {
                if (!n90.m(this.q)) {
                    return;
                }
                m90.d("SocketTransceiver", "destroy");
                D.a = -1;
                setChanged();
                notifyObservers(D);
                Z();
                this.u.removeCallbacks(this.s);
                this.o = true;
                if (this.r != null) {
                    synchronized (this.e) {
                        this.e.notifyAll();
                        m90.d("SocketTransceiver", "destroy notifyAll");
                    }
                    try {
                        this.r.d();
                        m90.a("SocketTransceiver", "destroy socketClose ok");
                    } catch (Exception e2) {
                        this.r.c(null);
                        m90.c("SocketTransceiver", "Exception destroy:", e2);
                    }
                }
            }
        }
    }

    public final void X(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048591, this, j2, str) == null) {
            try {
                if (this.f.size() > 0 && this.f.containsKey(Long.valueOf(j2))) {
                    m90.a("SocketTransceiver", "handle msg socket stoped!!! " + this.f.get(Long.valueOf(j2)).toString());
                    s80 remove = this.f.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.c = 8006;
                    remove.d = "socket stopped :";
                    W(remove, remove, str);
                }
            } catch (Exception e2) {
                m90.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void Y(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048592, this, j2, str) == null) {
            try {
                if (this.f.size() > 0 && this.f.containsKey(Long.valueOf(j2))) {
                    m90.a("SocketTransceiver", "handle msg timeout!!! " + this.f.get(Long.valueOf(j2)).toString());
                    s80 remove = this.f.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.c = 8004;
                    remove.d = "socket timeout";
                    W(remove, remove, str);
                }
            } catch (Exception e2) {
                m90.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public final synchronized void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            synchronized (this) {
                m90.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.d + ", net :" + RequsetNetworkUtils.isConnected(this.q) + ", isSmallFlow :" + n90.m(this.q));
                e80.h(this.q).g(601110).d("P13", str).d("con_err_code", "P13").c("flow_end_time", System.currentTimeMillis()).b("retry_cout", this.p.get()).e();
                g80 c2 = e80.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis());
                StringBuilder sb = new StringBuilder();
                sb.append("disconnectedByLcp:");
                sb.append(str);
                c2.d("source", sb.toString());
                if (!n90.m(this.q)) {
                    return;
                }
                P(str2);
                if (this.d) {
                    g80 c3 = e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                    c3.d("P16", "disconnectedByLcp:" + this.d).d("con_err_code", "P16").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                N(str, str2);
                if (!RequsetNetworkUtils.isConnected(this.q)) {
                    e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).d("con_err_code", "P17").d("net_connect", "false").b("retry_cout", this.p.get()).e();
                    d0();
                    return;
                }
                e0(false);
            }
        }
    }

    public final void Q(s80 s80Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, s80Var, str) == null) && s80Var != null && s80Var.h != 1) {
            m90.b("SocketTransceiver", "fetalAndClearAllMsgs :" + s80Var.n + ", serviceId :" + s80Var.h + ", methodId :" + s80Var.i);
            W(new s80(), s80Var, str);
        }
    }

    public synchronized void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            synchronized (this) {
                if (!n90.m(this.q)) {
                    return;
                }
                m90.d("SocketTransceiver", "---socketDisconnect---");
                this.o = true;
                this.d = true;
                P(str2);
                d0();
                this.u.removeCallbacks(this.B);
                this.u.removeCallbacks(this.C);
                this.u.removeCallbacks(this.n);
                r80.h(this.q, null, false);
                N(str, str2);
            }
        }
    }

    public final void T(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.f.size() > 0 && this.f.containsKey(Long.valueOf(j2))) {
                    m90.a("SocketTransceiver", "handle msg exception!!! " + this.f.get(Long.valueOf(j2)).toString());
                    s80 remove = this.f.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.c = 8005;
                    remove.d = "socket exception :" + str;
                    W(remove, remove, str2);
                }
            } catch (Exception e2) {
                m90.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void V(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                e80.h(this.q).g(601110).c("login_end", System.currentTimeMillis()).c("flow_end_time", System.currentTimeMillis()).b("connect_state", 4).d("P55", "lcp login success").d("con_err_code", "lcp login success").b("retry_cout", this.p.get()).e();
                this.p.set(0);
                D.a = 0;
                setChanged();
                notifyObservers(D);
                Z();
                if (!z) {
                    return;
                }
                this.u.a(str);
                this.u.postDelayed(this.n, j2);
                m90.a("SocketTransceiver", "ping every 1分钟 ");
            } catch (Exception e2) {
                m90.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void U(s80 s80Var, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, s80Var, str) == null) {
            long j2 = 60000;
            if (s80Var.c == 0) {
                long j3 = s80Var.g;
                if (j3 > 0) {
                    j2 = j3;
                }
                long j4 = s80Var.i;
                if (j4 == 1) {
                    V(j2, true, str);
                    return;
                } else if (j4 == 2) {
                    i0("LCP logout:", str);
                    D.a = s80Var.j;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    return;
                } else if (j4 == 3) {
                    this.n.a(j2);
                    return;
                } else {
                    return;
                }
            }
            String str2 = " errorcode:" + s80Var.c + " errmsg:" + s80Var.d;
            if (!String.valueOf(s80Var.c).startsWith(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK) && (i2 = s80Var.c) != 1011 && i2 != 2003) {
                if (i2 == 1012) {
                    e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
                    m90.a("SocketTransceiver", "login error :" + s80Var.c);
                    return;
                } else if (i2 == 1013) {
                    V(60000L, false, str);
                    return;
                } else {
                    D.a = -1;
                    setChanged();
                    notifyObservers(D);
                    Z();
                    e0(true);
                    return;
                }
            }
            m90.a("SocketTransceiver", "login error, then request token, error :" + s80Var.c);
            i0("errorCode:" + String.valueOf(s80Var.c), str);
            n90.z(this.q, "");
            e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis()).c("login_end", System.currentTimeMillis()).d("P45", "lcp login failed:" + str2).d("con_err_code", "P45").b("retry_cout", this.p.get()).e();
            e80.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "lcp login failed:" + str2);
            o80.e().l();
        }
    }

    public final synchronized void a0(s80 s80Var) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, s80Var) == null) {
            synchronized (this) {
                q80 q80Var = null;
                try {
                    if (!s80Var.e) {
                        j2 = s80Var.n;
                    } else {
                        j2 = (s80Var.h * 10000) + s80Var.i;
                    }
                    Long valueOf = Long.valueOf(j2);
                    m90.a("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + s80Var.n + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
                    if (this.k.size() > 0 && this.k.containsKey(valueOf)) {
                        q80Var = this.k.get(valueOf);
                    } else if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        q80Var = this.j.remove(valueOf);
                    }
                    if (q80Var != null) {
                        m90.a("SocketTransceiver", "onBLCPResponse methodId :" + s80Var.i + ", serviceId :" + s80Var.h + ", error :" + s80Var.c + ", msgId :" + s80Var.n + ", errMsg :" + s80Var.d + ", invoke keys :" + this.j.keySet().toString());
                        q80Var.onResponse(s80Var.c, s80Var.d, s80Var.h, s80Var.i, s80Var.n, s80Var.f);
                        if (s80Var.c == 1011) {
                            m90.a("SocketTransceiver", "onBLCPResponse errorCode :" + s80Var.c + ", and will send lcm login msg .");
                            f0(this.i.b(this.q, 1L));
                        }
                    }
                } catch (Exception e2) {
                    m90.c("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
                }
            }
        }
    }

    public final void e0(boolean z) {
        Runnable runnable;
        Runnable runnable2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            try {
                this.p.incrementAndGet();
                if (this.p.get() <= 10 && D.a == -1) {
                    long K = K(this.p.get());
                    this.u.removeCallbacks(this.n);
                    g gVar = this.u;
                    if (z) {
                        runnable = this.B;
                    } else {
                        runnable = this.C;
                    }
                    gVar.removeCallbacks(runnable);
                    g gVar2 = this.u;
                    if (z) {
                        runnable2 = this.C;
                    } else {
                        runnable2 = this.B;
                    }
                    gVar2.postDelayed(runnable2, K);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Schedule retry ");
                    if (z) {
                        str = "login";
                    } else {
                        str = "connect";
                    }
                    sb.append(str);
                    sb.append(" -- retry times: ");
                    sb.append(this.p.get());
                    sb.append(" time delay: ");
                    sb.append(K);
                    String sb2 = sb.toString();
                    e80.h(this.q).g(601110).d("P44", sb2).d("con_err_code", "P44");
                    m90.d("SocketTransceiver", sb2);
                    return;
                }
                g80 c2 = e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P19", "failedNumber：" + this.p.get() + ",connectState:" + D.a).d("con_err_code", "P19").b("retry_cout", this.p.get()).e();
            } catch (Exception e2) {
                g80 c3 = e80.h(this.q).g(601110).c("flow_end_time", System.currentTimeMillis());
                c3.d("P20", "retry exception:" + e2).d("con_err_code", "P20").b("retry_cout", this.p.get()).e();
                m90.c("SocketTransceiver", "retry Exception", e2);
            }
        }
    }

    public final synchronized void c0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                this.A = System.currentTimeMillis();
                if (!this.x.isEmpty() && !this.y.isEmpty() && r80.d()) {
                    L(this.x, this.y, this.z);
                    return;
                }
                m90.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.c);
                String[] split = n90.h(this.q, this.c).split(":");
                if (split.length < 3) {
                    return;
                }
                if (TextUtils.isEmpty(split[0])) {
                    str = "tcp";
                } else {
                    str = split[0];
                }
                String str2 = split[1];
                String str3 = split[2];
                if (this.c >= n90.i(this.q)) {
                    this.c = 0;
                    m90.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.r = new w80(this.q, "tls");
                    this.x = "lcs.baidu.com";
                    this.y = "443";
                    this.z = "tls";
                    L("lcs.baidu.com", "443", "tls");
                    return;
                }
                if ("quic".equals(str) && !(this.r instanceof QuicMessageHandler)) {
                    this.r = new QuicMessageHandler(this.q);
                } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.r instanceof w80))) {
                    this.r = new w80(this.q, str);
                }
                this.c++;
                if (this.r != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    m90.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                    this.x = str2;
                    this.y = str3;
                    this.z = str;
                    L(str2, str3, str);
                } else {
                    this.x = "";
                    this.y = "";
                    c0();
                }
            }
        }
    }

    public final synchronized void f0(s80 s80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, s80Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    m90.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.e) {
                    boolean z = false;
                    Iterator<s80> it = this.e.iterator();
                    while (it.hasNext()) {
                        s80 next = it.next();
                        m90.a("SocketTransceiver", "sendMessage queue :" + next.n);
                        if (next.l) {
                            z = true;
                        }
                    }
                    if (s80Var.l) {
                        if (!z && D.a == -1) {
                            this.e.addFirst(s80Var);
                            this.e.notifyAll();
                        }
                        m90.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + D.a);
                    } else if (D.a == -1) {
                        if (I()) {
                            if (this.e.size() <= 0 || !z) {
                                this.e.addFirst(this.i.b(this.q, 1L));
                                this.e.notifyAll();
                            }
                            if (!s80Var.k) {
                                this.e.add(s80Var);
                                this.e.notifyAll();
                            }
                        } else {
                            if (s80Var.k) {
                                e80.h(this.q).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", "ping");
                                c0();
                            }
                            this.e.add(s80Var);
                        }
                    } else {
                        this.e.add(s80Var);
                        this.e.notifyAll();
                    }
                }
            }
        }
    }

    public final void g0(long j2, long j3, long j4, boolean z, q80 q80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), q80Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (z) {
                if (q80Var != null) {
                    this.k.put(valueOf, q80Var);
                }
            } else {
                this.j.put(valueOf, q80Var);
            }
            m90.a("SocketTransceiver", "isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.j.keySet().toString() + ", notify keys :" + this.k.keySet().toString());
        }
    }
}
