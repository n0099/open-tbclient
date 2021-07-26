package com.bytedance.sdk.component.b.b.a.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.r;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ boolean f28491i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28492a;

    /* renamed from: b  reason: collision with root package name */
    public long f28493b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28494c;

    /* renamed from: d  reason: collision with root package name */
    public final g f28495d;

    /* renamed from: e  reason: collision with root package name */
    public final a f28496e;

    /* renamed from: f  reason: collision with root package name */
    public final c f28497f;

    /* renamed from: g  reason: collision with root package name */
    public final c f28498g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.component.b.b.a.e.b f28499h;
    public final List<com.bytedance.sdk.component.b.b.a.e.c> j;
    public List<com.bytedance.sdk.component.b.b.a.e.c> k;
    public boolean l;
    public final b m;

    /* loaded from: classes5.dex */
    public class c extends com.bytedance.sdk.component.b.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f28512b;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28512b = iVar;
        }

        @Override // com.bytedance.sdk.component.b.a.a
        public void a_() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28512b.b(com.bytedance.sdk.component.b.b.a.e.b.f28383f);
            }
        }

        @Override // com.bytedance.sdk.component.b.a.a
        public IOException b(IOException iOException) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
            return (IOException) invokeL.objValue;
        }

        public void h() throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && b()) {
                throw b((IOException) null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269655, "Lcom/bytedance/sdk/component/b/b/a/e/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269655, "Lcom/bytedance/sdk/component/b/b/a/e/i;");
                return;
            }
        }
        f28491i = !i.class.desiredAssertionStatus();
    }

    public i(int i2, g gVar, boolean z, boolean z2, List<com.bytedance.sdk.component.b.b.a.e.c> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2), list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28492a = 0L;
        this.f28497f = new c(this);
        this.f28498g = new c(this);
        this.f28499h = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f28494c = i2;
            this.f28495d = gVar;
            this.f28493b = gVar.m.d();
            this.m = new b(this, gVar.l.d());
            a aVar = new a(this);
            this.f28496e = aVar;
            this.m.f28507b = z2;
            aVar.f28502b = z;
            this.j = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28494c : invokeV.intValue;
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f28499h != null) {
                    return false;
                }
                if ((this.m.f28507b || this.m.f28506a) && (this.f28496e.f28502b || this.f28496e.f28501a)) {
                    if (this.l) {
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f28495d.f28431b == ((this.f28494c & 1) == 1);
        }
        return invokeV.booleanValue;
    }

    public synchronized List<com.bytedance.sdk.component.b.b.a.e.c> d() throws IOException {
        InterceptResult invokeV;
        List<com.bytedance.sdk.component.b.b.a.e.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                if (c()) {
                    this.f28497f.a();
                    while (this.k == null && this.f28499h == null) {
                        l();
                    }
                    this.f28497f.h();
                    list = this.k;
                    if (list != null) {
                        this.k = null;
                    } else {
                        throw new o(this.f28499h);
                    }
                } else {
                    throw new IllegalStateException("servers cannot read response headers");
                }
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public t e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28497f : (t) invokeV.objValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28498g : (t) invokeV.objValue;
    }

    public s g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (s) invokeV.objValue;
    }

    public r h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                if (!this.l && !c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
            return this.f28496e;
        }
        return (r) invokeV.objValue;
    }

    public void i() {
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!f28491i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                this.m.f28507b = true;
                b2 = b();
                notifyAll();
            }
            if (b2) {
                return;
            }
            this.f28495d.b(this.f28494c);
        }
    }

    public void j() throws IOException {
        boolean z;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!f28491i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                z = !this.m.f28507b && this.m.f28506a && (this.f28496e.f28502b || this.f28496e.f28501a);
                b2 = b();
            }
            if (z) {
                a(com.bytedance.sdk.component.b.b.a.e.b.f28383f);
            } else if (b2) {
            } else {
                this.f28495d.b(this.f28494c);
            }
        }
    }

    public void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a aVar = this.f28496e;
            if (!aVar.f28501a) {
                if (!aVar.f28502b) {
                    if (this.f28499h != null) {
                        throw new o(this.f28499h);
                    }
                    return;
                }
                throw new IOException("stream finished");
            }
            throw new IOException("stream closed");
        }
    }

    public void l() throws InterruptedIOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            try {
                wait();
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
    }

    public void a(com.bytedance.sdk.component.b.b.a.e.b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && d(bVar)) {
            this.f28495d.b(this.f28494c, bVar);
        }
    }

    public synchronized void c(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                if (this.f28499h == null) {
                    this.f28499h = bVar;
                    notifyAll();
                }
            }
        }
    }

    public void a(List<com.bytedance.sdk.component.b.b.a.e.c> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (!f28491i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                z = true;
                this.l = true;
                if (this.k == null) {
                    this.k = list;
                    z = b();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.k);
                    arrayList.add(null);
                    arrayList.addAll(list);
                    this.k = arrayList;
                }
            }
            if (z) {
                return;
            }
            this.f28495d.b(this.f28494c);
        }
    }

    public void b(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && d(bVar)) {
            this.f28495d.a(this.f28494c, bVar);
        }
    }

    private boolean d(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bVar)) == null) {
            if (f28491i || !Thread.holdsLock(this)) {
                synchronized (this) {
                    if (this.f28499h != null) {
                        return false;
                    }
                    if (this.m.f28507b && this.f28496e.f28502b) {
                        return false;
                    }
                    this.f28499h = bVar;
                    notifyAll();
                    this.f28495d.b(this.f28494c);
                    return true;
                }
            }
            throw new AssertionError();
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public final class a implements r {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28500c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28501a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28502b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f28503d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28504e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-303123444, "Lcom/bytedance/sdk/component/b/b/a/e/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-303123444, "Lcom/bytedance/sdk/component/b/b/a/e/i$a;");
                    return;
                }
            }
            f28500c = !i.class.desiredAssertionStatus();
        }

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28503d = iVar;
            this.f28504e = new com.bytedance.sdk.component.b.a.c();
        }

        private void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
                synchronized (this.f28503d) {
                    this.f28503d.f28498g.a();
                    while (this.f28503d.f28493b <= 0 && !this.f28502b && !this.f28501a && this.f28503d.f28499h == null) {
                        this.f28503d.l();
                    }
                    this.f28503d.f28498g.h();
                    this.f28503d.k();
                    min = Math.min(this.f28503d.f28493b, this.f28504e.b());
                    this.f28503d.f28493b -= min;
                }
                this.f28503d.f28498g.a();
                try {
                    this.f28503d.f28495d.a(this.f28503d.f28494c, z && min == this.f28504e.b(), this.f28504e, min);
                } finally {
                    this.f28503d.f28498g.h();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (!f28500c && Thread.holdsLock(this.f28503d)) {
                    throw new AssertionError();
                }
                this.f28504e.a_(cVar, j);
                while (this.f28504e.b() >= 16384) {
                    a(false);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!f28500c && Thread.holdsLock(this.f28503d)) {
                    throw new AssertionError();
                }
                synchronized (this.f28503d) {
                    if (this.f28501a) {
                        return;
                    }
                    if (!this.f28503d.f28496e.f28502b) {
                        if (this.f28504e.b() > 0) {
                            while (this.f28504e.b() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar = this.f28503d;
                            iVar.f28495d.a(iVar.f28494c, true, (com.bytedance.sdk.component.b.a.c) null, 0L);
                        }
                    }
                    synchronized (this.f28503d) {
                        this.f28501a = true;
                    }
                    this.f28503d.f28495d.b();
                    this.f28503d.j();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (!f28500c && Thread.holdsLock(this.f28503d)) {
                    throw new AssertionError();
                }
                synchronized (this.f28503d) {
                    this.f28503d.k();
                }
                while (this.f28504e.b() > 0) {
                    a(false);
                    this.f28503d.f28495d.b();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28503d.f28498g : (t) invokeV.objValue;
        }
    }

    public void a(com.bytedance.sdk.component.b.a.e eVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (!f28491i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            this.m.a(eVar, i2);
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28505c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28506a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28507b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f28508d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28509e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28510f;

        /* renamed from: g  reason: collision with root package name */
        public final long f28511g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-303123413, "Lcom/bytedance/sdk/component/b/b/a/e/i$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-303123413, "Lcom/bytedance/sdk/component/b/b/a/e/i$b;");
                    return;
                }
            }
            f28505c = !i.class.desiredAssertionStatus();
        }

        public b(i iVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28508d = iVar;
            this.f28509e = new com.bytedance.sdk.component.b.a.c();
            this.f28510f = new com.bytedance.sdk.component.b.a.c();
            this.f28511g = j;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f28508d.f28497f.a();
                while (this.f28510f.b() == 0 && !this.f28507b && !this.f28506a && this.f28508d.f28499h == null) {
                    try {
                        this.f28508d.l();
                    } finally {
                        this.f28508d.f28497f.h();
                    }
                }
            }
        }

        private void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                if (!this.f28506a) {
                    if (this.f28508d.f28499h != null) {
                        throw new o(this.f28508d.f28499h);
                    }
                    return;
                }
                throw new IOException("stream closed");
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    synchronized (this.f28508d) {
                        b();
                        c();
                        if (this.f28510f.b() == 0) {
                            return -1L;
                        }
                        long a2 = this.f28510f.a(cVar, Math.min(j, this.f28510f.b()));
                        this.f28508d.f28492a += a2;
                        if (this.f28508d.f28492a >= this.f28508d.f28495d.l.d() / 2) {
                            this.f28508d.f28495d.a(this.f28508d.f28494c, this.f28508d.f28492a);
                            this.f28508d.f28492a = 0L;
                        }
                        synchronized (this.f28508d.f28495d) {
                            this.f28508d.f28495d.j += a2;
                            if (this.f28508d.f28495d.j >= this.f28508d.f28495d.l.d() / 2) {
                                this.f28508d.f28495d.a(0, this.f28508d.f28495d.j);
                                this.f28508d.f28495d.j = 0L;
                            }
                        }
                        return a2;
                    }
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this.f28508d) {
                    this.f28506a = true;
                    this.f28510f.r();
                    this.f28508d.notifyAll();
                }
                this.f28508d.j();
            }
        }

        public void a(com.bytedance.sdk.component.b.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eVar, j) == null) {
                if (!f28505c && Thread.holdsLock(this.f28508d)) {
                    throw new AssertionError();
                }
                while (j > 0) {
                    synchronized (this.f28508d) {
                        z = this.f28507b;
                        z2 = true;
                        z3 = this.f28510f.b() + j > this.f28511g;
                    }
                    if (z3) {
                        eVar.h(j);
                        this.f28508d.b(com.bytedance.sdk.component.b.b.a.e.b.f28381d);
                        return;
                    } else if (z) {
                        eVar.h(j);
                        return;
                    } else {
                        long a2 = eVar.a(this.f28509e, j);
                        if (a2 != -1) {
                            j -= a2;
                            synchronized (this.f28508d) {
                                if (this.f28510f.b() != 0) {
                                    z2 = false;
                                }
                                this.f28510f.a(this.f28509e);
                                if (z2) {
                                    this.f28508d.notifyAll();
                                }
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28508d.f28497f : (t) invokeV.objValue;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f28493b += j;
            if (j > 0) {
                notifyAll();
            }
        }
    }
}
