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
/* loaded from: classes5.dex */
public final class g implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f28336a;
    public static final /* synthetic */ boolean s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28337b;

    /* renamed from: c  reason: collision with root package name */
    public final b f28338c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, i> f28339d;

    /* renamed from: e  reason: collision with root package name */
    public final String f28340e;

    /* renamed from: f  reason: collision with root package name */
    public int f28341f;

    /* renamed from: g  reason: collision with root package name */
    public int f28342g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28343h;

    /* renamed from: i  reason: collision with root package name */
    public final m f28344i;
    public long j;
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

    /* loaded from: classes5.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final b f28378f;
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
            f28378f = new b() { // from class: com.bytedance.sdk.component.b.b.a.e.g.b.1
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
                        iVar.a(com.bytedance.sdk.component.b.b.a.e.b.f28288e);
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
        f28336a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp Http2Connection", true));
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
        this.f28339d = new LinkedHashMap();
        this.j = 0L;
        this.l = new n();
        this.m = new n();
        this.n = false;
        this.r = new LinkedHashSet();
        this.f28344i = aVar.f28376f;
        boolean z = aVar.f28377g;
        this.f28337b = z;
        this.f28338c = aVar.f28375e;
        int i4 = z ? 1 : 2;
        this.f28342g = i4;
        if (aVar.f28377g) {
            this.f28342g = i4 + 2;
        }
        this.v = aVar.f28377g ? 1 : 2;
        if (aVar.f28377g) {
            this.l.a(7, 16777216);
        }
        this.f28340e = aVar.f28372b;
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.b.b.a.c.a(com.bytedance.sdk.component.b.b.a.c.a("OkHttp %s Push Observer", this.f28340e), true));
        this.m.a(7, 65535);
        this.m.a(5, 16384);
        this.k = this.m.d();
        this.o = aVar.f28371a;
        this.p = new j(aVar.f28374d, this.f28337b);
        this.q = new c(this, new h(aVar.f28373c, this.f28337b));
    }

    public synchronized i a(int i2) {
        InterceptResult invokeI;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                iVar = this.f28339d.get(Integer.valueOf(i2));
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
                remove = this.f28339d.remove(Integer.valueOf(i2));
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
            a(com.bytedance.sdk.component.b.b.a.e.b.f28284a, com.bytedance.sdk.component.b.b.a.e.b.f28289f);
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                z = this.f28343h;
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
            this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, bVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f28368a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.b.a.e.b f28369c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f28370d;

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
                    this.f28370d = this;
                    this.f28368a = i2;
                    this.f28369c = bVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f28370d.f28344i.a(this.f28368a, this.f28369c);
                        synchronized (this.f28370d) {
                            this.f28370d.r.remove(Integer.valueOf(this.f28368a));
                        }
                    }
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Socket f28371a;

        /* renamed from: b  reason: collision with root package name */
        public String f28372b;

        /* renamed from: c  reason: collision with root package name */
        public com.bytedance.sdk.component.b.a.e f28373c;

        /* renamed from: d  reason: collision with root package name */
        public com.bytedance.sdk.component.b.a.d f28374d;

        /* renamed from: e  reason: collision with root package name */
        public b f28375e;

        /* renamed from: f  reason: collision with root package name */
        public m f28376f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28377g;

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
            this.f28375e = b.f28378f;
            this.f28376f = m.f28436a;
            this.f28377g = z;
        }

        public a a(Socket socket, String str, com.bytedance.sdk.component.b.a.e eVar, com.bytedance.sdk.component.b.a.d dVar) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socket, str, eVar, dVar)) == null) {
                this.f28371a = socket;
                this.f28372b = str;
                this.f28373c = eVar;
                this.f28374d = dVar;
                return this;
            }
            return (a) invokeLLLL.objValue;
        }

        public a a(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                this.f28375e = bVar;
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
                    if (!this.f28343h) {
                        i3 = this.f28342g;
                        this.f28342g += 2;
                        iVar = new i(i3, this, z3, false, list);
                        if (z && this.k != 0 && iVar.f28399b != 0) {
                            z2 = false;
                            if (iVar.b()) {
                                this.f28339d.put(Integer.valueOf(i3), iVar);
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
                } else if (!this.f28337b) {
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

    public void a(int i2, boolean z, com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
        int min;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), cVar, Long.valueOf(j)}) == null) {
            if (j == 0) {
                this.p.a(z, i2, cVar, 0);
                return;
            }
            while (j > 0) {
                synchronized (this) {
                    while (this.k <= 0) {
                        try {
                            if (this.f28339d.containsKey(Integer.valueOf(i2))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                    min = Math.min((int) Math.min(j, this.k), this.p.c());
                    j2 = min;
                    this.k -= j2;
                }
                j -= j2;
                this.p.a(z && j == 0, i2, cVar, min);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends com.bytedance.sdk.component.b.b.a.b implements h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final h f28379a;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f28380c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, h hVar) {
            super("OkHttp %s", gVar.f28340e);
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
            this.f28380c = gVar;
            this.f28379a = hVar;
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
                if (this.f28380c.d(i2)) {
                    this.f28380c.a(i2, eVar, i3, z);
                    return;
                }
                i a2 = this.f28380c.a(i2);
                if (a2 == null) {
                    this.f28380c.a(i2, com.bytedance.sdk.component.b.b.a.e.b.f28285b);
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
                com.bytedance.sdk.component.b.b.a.e.b bVar3 = com.bytedance.sdk.component.b.b.a.e.b.f28286c;
                try {
                    try {
                        this.f28379a.a(this);
                        while (this.f28379a.a(false, (h.b) this)) {
                        }
                        bVar = com.bytedance.sdk.component.b.b.a.e.b.f28284a;
                        try {
                            try {
                                bVar2 = com.bytedance.sdk.component.b.b.a.e.b.f28289f;
                                gVar = this.f28380c;
                            } catch (IOException unused) {
                                bVar = com.bytedance.sdk.component.b.b.a.e.b.f28285b;
                                bVar2 = com.bytedance.sdk.component.b.b.a.e.b.f28285b;
                                gVar = this.f28380c;
                                gVar.a(bVar, bVar2);
                                com.bytedance.sdk.component.b.b.a.c.a(this.f28379a);
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                this.f28380c.a(bVar, bVar3);
                            } catch (IOException unused2) {
                            }
                            com.bytedance.sdk.component.b.b.a.c.a(this.f28379a);
                            throw th;
                        }
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar3;
                    this.f28380c.a(bVar, bVar3);
                    com.bytedance.sdk.component.b.b.a.c.a(this.f28379a);
                    throw th;
                }
                gVar.a(bVar, bVar2);
                com.bytedance.sdk.component.b.b.a.c.a(this.f28379a);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, int i2, int i3, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
                if (this.f28380c.d(i2)) {
                    this.f28380c.a(i2, list, z);
                    return;
                }
                synchronized (this.f28380c) {
                    i a2 = this.f28380c.a(i2);
                    if (a2 == null) {
                        if (this.f28380c.f28343h) {
                            return;
                        }
                        if (i2 <= this.f28380c.f28341f) {
                            return;
                        }
                        if (i2 % 2 == this.f28380c.f28342g % 2) {
                            return;
                        }
                        i iVar = new i(i2, this.f28380c, false, z, list);
                        this.f28380c.f28341f = i2;
                        this.f28380c.f28339d.put(Integer.valueOf(i2), iVar);
                        g.f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s stream %d", new Object[]{this.f28380c.f28340e, Integer.valueOf(i2)}, iVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ i f28381a;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ c f28382c;

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
                                this.f28382c = this;
                                this.f28381a = iVar;
                            }

                            @Override // com.bytedance.sdk.component.b.b.a.b
                            public void c() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        this.f28382c.f28380c.f28338c.a(this.f28381a);
                                    } catch (IOException e2) {
                                        com.bytedance.sdk.component.b.b.a.g.e b2 = com.bytedance.sdk.component.b.b.a.g.e.b();
                                        b2.a(4, "Http2Connection.Listener failure for " + this.f28382c.f28380c.f28340e, e2);
                                        try {
                                            this.f28381a.a(com.bytedance.sdk.component.b.b.a.e.b.f28285b);
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
                if (this.f28380c.d(i2)) {
                    this.f28380c.c(i2, bVar);
                    return;
                }
                i b2 = this.f28380c.b(i2);
                if (b2 != null) {
                    b2.c(bVar);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(boolean z, n nVar) {
            i[] iVarArr;
            long j;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048585, this, z, nVar) == null) {
                synchronized (this.f28380c) {
                    int d2 = this.f28380c.m.d();
                    if (z) {
                        this.f28380c.m.a();
                    }
                    this.f28380c.m.a(nVar);
                    a(nVar);
                    int d3 = this.f28380c.m.d();
                    iVarArr = null;
                    if (d3 == -1 || d3 == d2) {
                        j = 0;
                    } else {
                        j = d3 - d2;
                        if (!this.f28380c.n) {
                            this.f28380c.a(j);
                            this.f28380c.n = true;
                        }
                        if (!this.f28380c.f28339d.isEmpty()) {
                            iVarArr = (i[]) this.f28380c.f28339d.values().toArray(new i[this.f28380c.f28339d.size()]);
                        }
                    }
                    g.f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s settings", this.f28380c.f28340e) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f28383a;

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
                            this.f28383a = this;
                        }

                        @Override // com.bytedance.sdk.component.b.b.a.b
                        public void c() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                g gVar = this.f28383a.f28380c;
                                gVar.f28338c.a(gVar);
                            }
                        }
                    });
                }
                if (iVarArr == null || j == 0) {
                    return;
                }
                for (i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
        }

        private void a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, nVar) == null) {
                g.f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s ACK Settings", new Object[]{this.f28380c.f28340e}, nVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.c.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ n f28384a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f28385c;

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
                        this.f28385c = this;
                        this.f28384a = nVar;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f28385c.f28380c.p.a(this.f28384a);
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
                    l c2 = this.f28380c.c(i2);
                    if (c2 != null) {
                        c2.b();
                        return;
                    }
                    return;
                }
                this.f28380c.a(true, i2, i3, (l) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar, com.bytedance.sdk.component.b.a.f fVar) {
            i[] iVarArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bVar, fVar) == null) {
                fVar.g();
                synchronized (this.f28380c) {
                    iVarArr = (i[]) this.f28380c.f28339d.values().toArray(new i[this.f28380c.f28339d.size()]);
                    this.f28380c.f28343h = true;
                }
                for (i iVar : iVarArr) {
                    if (iVar.a() > i2 && iVar.c()) {
                        iVar.c(com.bytedance.sdk.component.b.b.a.e.b.f28288e);
                        this.f28380c.b(iVar.a());
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (i2 == 0) {
                    synchronized (this.f28380c) {
                        this.f28380c.k += j;
                        this.f28380c.notifyAll();
                    }
                    return;
                }
                i a2 = this.f28380c.a(i2);
                if (a2 != null) {
                    synchronized (a2) {
                        a2.a(j);
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.e.h.b
        public void a(int i2, int i3, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, list) == null) {
                this.f28380c.a(i3, list);
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.k += j;
            if (j > 0) {
                notifyAll();
            }
        }
    }

    public void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, bVar) == null) {
            f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s stream %d", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, bVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f28345a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.component.b.b.a.e.b f28346c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f28347d;

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
                    this.f28347d = this;
                    this.f28345a = i2;
                    this.f28346c = bVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f28347d.b(this.f28345a, this.f28346c);
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp Window Update %s stream %d", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, j) { // from class: com.bytedance.sdk.component.b.b.a.e.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f28348a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f28349c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f28350d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, r10, Integer.valueOf(i2), Long.valueOf(j)};
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
                    this.f28350d = this;
                    this.f28348a = i2;
                    this.f28349c = j;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f28350d.p.a(this.f28348a, this.f28349c);
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
            f28336a.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s ping %08x%08x", new Object[]{this.f28340e, Integer.valueOf(i2), Integer.valueOf(i3)}, z, i2, i3, lVar) { // from class: com.bytedance.sdk.component.b.b.a.e.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f28351a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f28352c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f28353d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ l f28354e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ g f28355f;

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
                    this.f28355f = this;
                    this.f28351a = z;
                    this.f28352c = i2;
                    this.f28353d = i3;
                    this.f28354e = lVar;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f28355f.b(this.f28351a, this.f28352c, this.f28353d, this.f28354e);
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
                    if (this.f28343h) {
                        return;
                    }
                    this.f28343h = true;
                    this.p.a(this.f28341f, bVar, com.bytedance.sdk.component.b.b.a.c.f28221a);
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
                if (this.f28339d.isEmpty()) {
                    iVarArr = null;
                } else {
                    iVarArr = (i[]) this.f28339d.values().toArray(new i[this.f28339d.size()]);
                    this.f28339d.clear();
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
                    a(i2, com.bytedance.sdk.component.b.b.a.e.b.f28285b);
                    return;
                }
                this.r.add(Integer.valueOf(i2));
                this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Request[%s]", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, list) { // from class: com.bytedance.sdk.component.b.b.a.e.g.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f28356a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ List f28357c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ g f28358d;

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
                        this.f28358d = this;
                        this.f28356a = i2;
                        this.f28357c = list;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f28358d.f28344i.a(this.f28356a, this.f28357c)) {
                            try {
                                this.f28358d.p.a(this.f28356a, com.bytedance.sdk.component.b.b.a.e.b.f28289f);
                                synchronized (this.f28358d) {
                                    this.f28358d.r.remove(Integer.valueOf(this.f28356a));
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
            this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, list, z) { // from class: com.bytedance.sdk.component.b.b.a.e.g.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f28359a;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ List f28360c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f28361d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ g f28362e;

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
                    this.f28362e = this;
                    this.f28359a = i2;
                    this.f28360c = list;
                    this.f28361d = z;
                }

                @Override // com.bytedance.sdk.component.b.b.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean a2 = this.f28362e.f28344i.a(this.f28359a, this.f28360c, this.f28361d);
                        if (a2) {
                            try {
                                this.f28362e.p.a(this.f28359a, com.bytedance.sdk.component.b.b.a.e.b.f28289f);
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        if (a2 || this.f28361d) {
                            synchronized (this.f28362e) {
                                this.f28362e.r.remove(Integer.valueOf(this.f28359a));
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
            long j = i3;
            eVar.a(j);
            eVar.a(cVar, j);
            if (cVar.b() == j) {
                this.t.execute(new com.bytedance.sdk.component.b.b.a.b(this, "OkHttp %s Push Data[%s]", new Object[]{this.f28340e, Integer.valueOf(i2)}, i2, cVar, i3, z) { // from class: com.bytedance.sdk.component.b.b.a.e.g.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f28363a;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.component.b.a.c f28364c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ int f28365d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ boolean f28366e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ g f28367f;

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
                        this.f28367f = this;
                        this.f28363a = i2;
                        this.f28364c = cVar;
                        this.f28365d = i3;
                        this.f28366e = z;
                    }

                    @Override // com.bytedance.sdk.component.b.b.a.b
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                boolean a2 = this.f28367f.f28344i.a(this.f28363a, this.f28364c, this.f28365d, this.f28366e);
                                if (a2) {
                                    this.f28367f.p.a(this.f28363a, com.bytedance.sdk.component.b.b.a.e.b.f28289f);
                                }
                                if (a2 || this.f28366e) {
                                    synchronized (this.f28367f) {
                                        this.f28367f.r.remove(Integer.valueOf(this.f28363a));
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
