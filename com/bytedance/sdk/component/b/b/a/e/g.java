package com.bytedance.sdk.component.b.b.a.e;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.e.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class g implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f64282a;
    public static final /* synthetic */ boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f64283b;

    /* renamed from: c  reason: collision with root package name */
    public final b f64284c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, i> f64285d;

    /* renamed from: e  reason: collision with root package name */
    public final String f64286e;

    /* renamed from: f  reason: collision with root package name */
    public int f64287f;

    /* renamed from: g  reason: collision with root package name */
    public int f64288g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64289h;

    /* renamed from: i  reason: collision with root package name */
    public final m f64290i;

    /* renamed from: j  reason: collision with root package name */
    public long f64291j;
    public long k;
    public n l;
    public final n m;
    public boolean n;
    public final Socket o;
    public final j p;
    public final c q;
    public final Set<Integer> r;
    public final ExecutorService t;
    public Map<Integer, l> u;
    public int v;

    /* loaded from: classes9.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final b f64325f;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-303182995, "Lcom/bytedance/sdk/component/b/b/a/e/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-303182995, "Lcom/bytedance/sdk/component/b/b/a/e/g$b;");
                    return;
                }
            }
            f64325f = new b() { // from class: com.bytedance.sdk.component.b.b.a.e.g.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.b.b.a.e.g.b
                public void a(i iVar) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iVar) == null) {
                        iVar.a(com.bytedance.sdk.component.b.b.a.e.b.f64232e);
                    }
                }
            };
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            }
        }

        public abstract void a(i iVar) throws IOException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269717, "Lcom/bytedance/sdk/component/b/b/a/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269717, "Lcom/bytedance/sdk/component/b/b/a/e/g;");
                return;
            }
        }
        s = !g.class.desiredAssertionStatus();
        f64282a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp Http2Connection", true));
    }

    public g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64285d = new LinkedHashMap();
        this.f64291j = 0L;
        this.l = new n();
        this.m = new n();
        this.n = false;
        this.r = new LinkedHashSet();
        this.f64290i = aVar.f64323f;
        boolean z = aVar.f64324g;
        this.f64283b = z;
        this.f64284c = aVar.f64322e;
        int i4 = z ? 1 : 2;
        this.f64288g = i4;
        if (aVar.f64324g) {
            this.f64288g = i4 + 2;
        }
        this.v = aVar.f64324g ? 1 : 2;
        if (aVar.f64324g) {
            this.l.a(7, 16777216);
        }
        this.f64286e = aVar.f64319b;
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.b.b.a.c.a(com.bytedance.sdk.component.b.b.a.c.a("OkHttp %s Push Observer", this.f64286e), true));
        this.m.a(7, 65535);
        this.m.a(5, 16384);
        this.k = this.m.d();
        this.o = aVar.f64318a;
        this.p = new j(aVar.f64321d, this.f64283b);
        this.q = new c(this, new h(aVar.f64320c, this.f64283b));
    }

    public synchronized i a(int i2) {
        InterceptResult invokeI;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                iVar = this.f64285d.get(Integer.valueOf(i2));
            }
            return iVar;
        }
        return (i) invokeI.objValue;
    }

    public synchronized i b(int i2) {
        InterceptResult invokeI;
        i remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            synchronized (this) {
                remove = this.f64285d.remove(Integer.valueOf(i2));
                notifyAll();
            }
            return remove;
        }
        return (i) invokeI.objValue;
    }

    public synchronized l c(int i2) {
        InterceptResult invokeI;
        l remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            synchronized (this) {
                remove = this.u != null ? this.u.remove(Integer.valueOf(i2)) : null;
            }
            return remove;
        }
        return (l) invokeI.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            a(com.bytedance.sdk.component.b.b.a.e.b.f64228a, com.bytedance.sdk.component.b.b.a.e.b.f64233f);
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                z = this.f64289h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? i2 != 0 && (i2 & 1) == 0 : invokeI.booleanValue;
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c2 = this.m.c(Integer.MAX_VALUE);
            }
            return c2;
        }
        return invokeV.intValue;
    }

    public void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            a(true);
        }
    }

    public i a(List<com.bytedance.sdk.component.b.b.a.e.c> list, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, list, z)) == null) ? b(0, list, z) : (i) invokeLZ.objValue;
    }

    public void c(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, bVar) == null) {
            this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, bVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f64315a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.b.a.e.b f64316c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f64317d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i2), bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64317d = this;
                    this.f64315a = i2;
                    this.f64316c = bVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64317d.f64290i.a(this.f64315a, this.f64316c);
                        synchronized (this.f64317d) {
                            this.f64317d.r.remove(Integer.valueOf(this.f64315a));
                        }
                    }
                }
            });
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Socket f64318a;

        /* renamed from: b  reason: collision with root package name */
        public String f64319b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.b.a.e f64320c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.component.b.a.d f64321d;

        /* renamed from: e  reason: collision with root package name */
        public b f64322e;

        /* renamed from: f  reason: collision with root package name */
        public m f64323f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f64324g;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64322e = b.f64325f;
            this.f64323f = m.f64384a;
            this.f64324g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.component.b.a.e eVar, com.bytedance.sdk.component.b.a.d dVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socket, str, eVar, dVar)) == null) {
                this.f64318a = socket;
                this.f64319b = str;
                this.f64320c = eVar;
                this.f64321d = dVar;
                return this;
            }
            return (a) invokeLLLL.objValue;
        }

        public a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f64322e = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public g a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new g(this) : (g) invokeV.objValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[Catch: all -> 0x006d, TryCatch #2 {, blocks: (B:6:0x000a, B:23:0x0047, B:27:0x0056, B:24:0x004d, B:26:0x0051, B:31:0x005f, B:32:0x0066, B:7:0x000b, B:9:0x000f, B:11:0x0023, B:13:0x002b, B:18:0x0035, B:20:0x003b, B:21:0x0044, B:33:0x0067, B:34:0x006c), top: B:45:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private i b(int i2, List<com.bytedance.sdk.component.b.b.a.e.c> list, boolean z) throws IOException {
        InterceptResult invokeCommon;
        int i3;
        i iVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)})) == null) {
            boolean z3 = !z;
            synchronized (this.p) {
                synchronized (this) {
                    if (!this.f64289h) {
                        i3 = this.f64288g;
                        this.f64288g += 2;
                        iVar = new i(i3, this, z3, false, list);
                        if (z && this.k != 0 && iVar.f64346b != 0) {
                            z2 = false;
                            if (iVar.b()) {
                                this.f64285d.put(Integer.valueOf(i3), iVar);
                            }
                        }
                        z2 = true;
                        if (iVar.b()) {
                        }
                    } else {
                        throw new com.bytedance.sdk.component.b.b.a.e.a();
                    }
                }
                if (i2 == 0) {
                    this.p.a(z3, i3, i2, list);
                } else if (!this.f64283b) {
                    this.p.a(i2, i3, list);
                } else {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
            }
            if (z2) {
                this.p.b();
            }
            return iVar;
        }
        return (i) invokeCommon.objValue;
    }

    public void a(int i2, boolean z, com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
        int min;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), cVar, Long.valueOf(j2)}) == null) {
            if (j2 == 0) {
                this.p.a(z, i2, cVar, 0);
                return;
            }
            while (j2 > 0) {
                synchronized (this) {
                    while (this.k <= 0) {
                        try {
                            if (this.f64285d.containsKey(Integer.valueOf(i2))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    min = Math.min((int) Math.min(j2, this.k), this.p.c());
                    j3 = min;
                    this.k -= j3;
                }
                j2 -= j3;
                this.p.a(z && j2 == 0, i2, cVar, min);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends com.bytedance.sdk.component.b.b.a.b implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f64326a;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f64327c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, h hVar) {
            super("OkHttp %s", gVar.f64286e);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Object[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64327c = gVar;
            this.f64326a = hVar;
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, int i3, int i4, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, int i2, com.bytedance.sdk.component.b.a.e eVar, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), eVar, Integer.valueOf(i3)}) == null) {
                if (this.f64327c.d(i2)) {
                    this.f64327c.a(i2, eVar, i3, z);
                    return;
                }
                i a2 = this.f64327c.a(i2);
                if (a2 == null) {
                    this.f64327c.a(i2, com.bytedance.sdk.component.b.b.a.e.b.f64229b);
                    eVar.h(i3);
                    return;
                }
                a2.a(eVar, i3);
                if (z) {
                    a2.i();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.b
        public void c() {
            com.bytedance.sdk.component.b.b.a.e.b bVar;
            com.bytedance.sdk.component.b.b.a.e.b bVar2;
            g gVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                com.bytedance.sdk.component.b.b.a.e.b bVar3 = com.bytedance.sdk.component.b.b.a.e.b.f64230c;
                try {
                    try {
                        this.f64326a.a(this);
                        while (this.f64326a.a(false, (h.b) this)) {
                        }
                        bVar = com.bytedance.sdk.component.b.b.a.e.b.f64228a;
                        try {
                            try {
                                bVar2 = com.bytedance.sdk.component.b.b.a.e.b.f64233f;
                                gVar = this.f64327c;
                            } catch (IOException unused) {
                                bVar = com.bytedance.sdk.component.b.b.a.e.b.f64229b;
                                bVar2 = com.bytedance.sdk.component.b.b.a.e.b.f64229b;
                                gVar = this.f64327c;
                                gVar.a(bVar, bVar2);
                                com.bytedance.sdk.component.b.b.a.c.a(this.f64326a);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.f64327c.a(bVar, bVar3);
                            } catch (IOException unused2) {
                            }
                            com.bytedance.sdk.component.b.b.a.c.a(this.f64326a);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar3;
                    this.f64327c.a(bVar, bVar3);
                    com.bytedance.sdk.component.b.b.a.c.a(this.f64326a);
                    throw th;
                }
                gVar.a(bVar, bVar2);
                com.bytedance.sdk.component.b.b.a.c.a(this.f64326a);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, int i2, int i3, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
                if (this.f64327c.d(i2)) {
                    this.f64327c.a(i2, list, z);
                    return;
                }
                synchronized (this.f64327c) {
                    i a2 = this.f64327c.a(i2);
                    if (a2 == null) {
                        if (this.f64327c.f64289h) {
                            return;
                        }
                        if (i2 <= this.f64327c.f64287f) {
                            return;
                        }
                        if (i2 % 2 == this.f64327c.f64288g % 2) {
                            return;
                        }
                        i iVar = new i(i2, this.f64327c, false, z, list);
                        this.f64327c.f64287f = i2;
                        this.f64327c.f64285d.put(Integer.valueOf(i2), iVar);
                        g.f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s stream %d", new Object[]{this.f64327c.f64286e, Integer.valueOf(i2)}, iVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ i f64328a;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ c f64329c;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r9, r10);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r9, r10, iVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((String) objArr2[0], (Object[]) objArr2[1]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f64329c = this;
                                this.f64328a = iVar;
                            }

                            @Override // com.bytedance.sdk.component.b.b.a.b
                            public void c() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.f64329c.f64327c.f64284c.a(this.f64328a);
                                    } catch (IOException e2) {
                                        com.bytedance.sdk.component.b.b.a.g.e b2 = com.bytedance.sdk.component.b.b.a.g.e.b();
                                        b2.a(4, "Http2Connection.Listener failure for " + this.f64329c.f64327c.f64286e, e2);
                                        try {
                                            this.f64328a.a(com.bytedance.sdk.component.b.b.a.e.b.f64229b);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            }
                        });
                        return;
                    }
                    a2.a(list);
                    if (z) {
                        a2.i();
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, bVar) == null) {
                if (this.f64327c.d(i2)) {
                    this.f64327c.c(i2, bVar);
                    return;
                }
                i b2 = this.f64327c.b(i2);
                if (b2 != null) {
                    b2.c(bVar);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048585, this, z, nVar) == null) {
                synchronized (this.f64327c) {
                    int d2 = this.f64327c.m.d();
                    if (z) {
                        this.f64327c.m.a();
                    }
                    this.f64327c.m.a(nVar);
                    a(nVar);
                    int d3 = this.f64327c.m.d();
                    iVarArr = null;
                    if (d3 == -1 || d3 == d2) {
                        j2 = 0;
                    } else {
                        j2 = d3 - d2;
                        if (!this.f64327c.n) {
                            this.f64327c.a(j2);
                            this.f64327c.n = true;
                        }
                        if (!this.f64327c.f64285d.isEmpty()) {
                            iVarArr = (i[]) this.f64327c.f64285d.values().toArray(new i[this.f64327c.f64285d.size()]);
                        }
                    }
                    g.f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s settings", this.f64327c.f64286e) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f64330a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, r10};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], (Object[]) objArr2[1]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64330a = this;
                        }

                        @Override // com.bytedance.sdk.component.b.b.a.b
                        public void c() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                g gVar = this.f64330a.f64327c;
                                gVar.f64284c.a(gVar);
                            }
                        }
                    });
                }
                if (iVarArr == null || j2 == 0) {
                    return;
                }
                for (i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j2);
                    }
                }
            }
        }

        private void a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, nVar) == null) {
                g.f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s ACK Settings", new Object[]{this.f64327c.f64286e}, nVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ n f64331a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f64332c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, nVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64332c = this;
                        this.f64331a = nVar;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f64332c.f64327c.p.a(this.f64331a);
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (z) {
                    l c2 = this.f64327c.c(i2);
                    if (c2 != null) {
                        c2.b();
                        return;
                    }
                    return;
                }
                this.f64327c.a(true, i2, i3, (l) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar, com.bytedance.sdk.component.b.a.f fVar) {
            i[] iVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bVar, fVar) == null) {
                fVar.g();
                synchronized (this.f64327c) {
                    iVarArr = (i[]) this.f64327c.f64285d.values().toArray(new i[this.f64327c.f64285d.size()]);
                    this.f64327c.f64289h = true;
                }
                for (i iVar : iVarArr) {
                    if (iVar.a() > i2 && iVar.c()) {
                        iVar.c(com.bytedance.sdk.component.b.b.a.e.b.f64232e);
                        this.f64327c.b(iVar.a());
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (i2 == 0) {
                    synchronized (this.f64327c) {
                        this.f64327c.k += j2;
                        this.f64327c.notifyAll();
                    }
                    return;
                }
                i a2 = this.f64327c.a(i2);
                if (a2 != null) {
                    synchronized (a2) {
                        a2.a(j2);
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, int i3, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, list) == null) {
                this.f64327c.a(i3, list);
            }
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.k += j2;
            if (j2 > 0) {
                notifyAll();
            }
        }
    }

    public void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bVar) == null) {
            f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s stream %d", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, bVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f64292a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.b.a.e.b f64293c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f64294d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i2), bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64294d = this;
                    this.f64292a = i2;
                    this.f64293c = bVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f64294d.b(this.f64292a, this.f64293c);
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    public void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, j2) { // from class: com.bytedance.sdk.component.b.b.a.e.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f64295a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f64296c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f64297d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i2), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64297d = this;
                    this.f64295a = i2;
                    this.f64296c = j2;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f64297d.p.a(this.f64295a, this.f64296c);
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    public void a(boolean z, int i2, int i3, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), lVar}) == null) {
            f64282a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s ping %08x%08x", new Object[]{this.f64286e, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, lVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f64298a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f64299c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f64300d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ l f64301e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f64302f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), lVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64302f = this;
                    this.f64298a = z;
                    this.f64299c = i2;
                    this.f64300d = i3;
                    this.f64301e = lVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f64302f.b(this.f64298a, this.f64299c, this.f64300d, this.f64301e);
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    public void b(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, bVar) == null) {
            this.p.a(i2, bVar);
        }
    }

    public void a(com.bytedance.sdk.component.b.b.a.e.b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            synchronized (this.p) {
                synchronized (this) {
                    if (this.f64289h) {
                        return;
                    }
                    this.f64289h = true;
                    this.p.a(this.f64287f, bVar, com.bytedance.sdk.component.b.b.a.c.f64163a);
                }
            }
        }
    }

    public void b(boolean z, int i2, int i3, l lVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), lVar}) == null) {
            synchronized (this.p) {
                if (lVar != null) {
                    lVar.a();
                }
                this.p.a(z, i2, i3);
            }
        }
    }

    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p.b();
        }
    }

    public void a(com.bytedance.sdk.component.b.b.a.e.b bVar, com.bytedance.sdk.component.b.b.a.e.b bVar2) throws IOException {
        i[] iVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, bVar, bVar2) == null) {
            if (!s && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            l[] lVarArr = null;
            try {
                a(bVar);
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            synchronized (this) {
                if (this.f64285d.isEmpty()) {
                    iVarArr = null;
                } else {
                    iVarArr = (i[]) this.f64285d.values().toArray(new i[this.f64285d.size()]);
                    this.f64285d.clear();
                }
                if (this.u != null) {
                    this.u = null;
                    lVarArr = (l[]) this.u.values().toArray(new l[this.u.size()]);
                }
            }
            if (iVarArr != null) {
                for (i iVar : iVarArr) {
                    try {
                        iVar.a(bVar2);
                    } catch (IOException e3) {
                        if (e != null) {
                            e = e3;
                        }
                    }
                }
            }
            if (lVarArr != null) {
                for (l lVar : lVarArr) {
                    lVar.c();
                }
            }
            try {
                this.p.close();
            } catch (IOException e4) {
                if (e == null) {
                    e = e4;
                }
            }
            try {
                this.o.close();
            } catch (IOException e5) {
                e = e5;
            }
            if (e != null) {
                throw e;
            }
        }
    }

    public void a(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.p.a();
                this.p.b(this.l);
                int d2 = this.l.d();
                if (d2 != 65535) {
                    this.p.a(0, d2 - 65535);
                }
            }
            Thread thread = new Thread(this.q);
            thread.setName("tt_pangle_thread_http2_connection" + SystemClock.uptimeMillis());
            thread.start();
        }
    }

    public void a(int i2, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, list) == null) {
            synchronized (this) {
                if (this.r.contains(Integer.valueOf(i2))) {
                    a(i2, com.bytedance.sdk.component.b.b.a.e.b.f64229b);
                    return;
                }
                this.r.add(Integer.valueOf(i2));
                this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Request[%s]", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, list) { // from class: com.bytedance.sdk.component.b.b.a.e.g.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f64303a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ List f64304c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ g f64305d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i2), list};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64305d = this;
                        this.f64303a = i2;
                        this.f64304c = list;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f64305d.f64290i.a(this.f64303a, this.f64304c)) {
                            try {
                                this.f64305d.p.a(this.f64303a, com.bytedance.sdk.component.b.b.a.e.b.f64233f);
                                synchronized (this.f64305d) {
                                    this.f64305d.r.remove(Integer.valueOf(this.f64303a));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void a(int i2, List<com.bytedance.sdk.component.b.b.a.e.c> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)}) == null) {
            this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, list, z) { // from class: com.bytedance.sdk.component.b.b.a.e.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f64306a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ List f64307c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f64308d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f64309e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i2), list, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], (Object[]) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64309e = this;
                    this.f64306a = i2;
                    this.f64307c = list;
                    this.f64308d = z;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean a2 = this.f64309e.f64290i.a(this.f64306a, this.f64307c, this.f64308d);
                        if (a2) {
                            try {
                                this.f64309e.p.a(this.f64306a, com.bytedance.sdk.component.b.b.a.e.b.f64233f);
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        if (a2 || this.f64308d) {
                            synchronized (this.f64309e) {
                                this.f64309e.r.remove(Integer.valueOf(this.f64306a));
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(int i2, com.bytedance.sdk.component.b.a.e eVar, int i3, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), eVar, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            com.bytedance.sdk.component.b.a.c cVar = new com.bytedance.sdk.component.b.a.c();
            long j2 = i3;
            eVar.a(j2);
            eVar.a(cVar, j2);
            if (cVar.b() == j2) {
                this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Data[%s]", new Object[]{this.f64286e, Integer.valueOf(i2)}, i2, cVar, i3, z) { // from class: com.bytedance.sdk.component.b.b.a.e.g.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f64310a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.component.b.a.c f64311c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f64312d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ boolean f64313e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ g f64314f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10, Integer.valueOf(i2), cVar, Integer.valueOf(i3), Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((String) objArr2[0], (Object[]) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64314f = this;
                        this.f64310a = i2;
                        this.f64311c = cVar;
                        this.f64312d = i3;
                        this.f64313e = z;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                boolean a2 = this.f64314f.f64290i.a(this.f64310a, this.f64311c, this.f64312d, this.f64313e);
                                if (a2) {
                                    this.f64314f.p.a(this.f64310a, com.bytedance.sdk.component.b.b.a.e.b.f64233f);
                                }
                                if (a2 || this.f64313e) {
                                    synchronized (this.f64314f) {
                                        this.f64314f.r.remove(Integer.valueOf(this.f64310a));
                                    }
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
                return;
            }
            throw new IOException(cVar.b() + " != " + i3);
        }
    }
}
