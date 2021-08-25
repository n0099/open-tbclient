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
/* loaded from: classes9.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ boolean f64544i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f64545a;

    /* renamed from: b  reason: collision with root package name */
    public long f64546b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64547c;

    /* renamed from: d  reason: collision with root package name */
    public final g f64548d;

    /* renamed from: e  reason: collision with root package name */
    public final a f64549e;

    /* renamed from: f  reason: collision with root package name */
    public final c f64550f;

    /* renamed from: g  reason: collision with root package name */
    public final c f64551g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.component.b.b.a.e.b f64552h;

    /* renamed from: j  reason: collision with root package name */
    public final List<com.bytedance.sdk.component.b.b.a.e.c> f64553j;
    public List<com.bytedance.sdk.component.b.b.a.e.c> k;
    public boolean l;
    public final b m;

    /* loaded from: classes9.dex */
    public class c extends com.bytedance.sdk.component.b.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f64566b;

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
            this.f64566b = iVar;
        }

        @Override // com.bytedance.sdk.component.b.a.a
        public void a_() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64566b.b(com.bytedance.sdk.component.b.b.a.e.b.f64433f);
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
        f64544i = !i.class.desiredAssertionStatus();
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
        this.f64545a = 0L;
        this.f64550f = new c(this);
        this.f64551g = new c(this);
        this.f64552h = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f64547c = i2;
            this.f64548d = gVar;
            this.f64546b = gVar.m.d();
            this.m = new b(this, gVar.l.d());
            a aVar = new a(this);
            this.f64549e = aVar;
            this.m.f64561b = z2;
            aVar.f64556b = z;
            this.f64553j = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64547c : invokeV.intValue;
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f64552h != null) {
                    return false;
                }
                if ((this.m.f64561b || this.m.f64560a) && (this.f64549e.f64556b || this.f64549e.f64555a)) {
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
            return this.f64548d.f64483b == ((this.f64547c & 1) == 1);
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
                    this.f64550f.a();
                    while (this.k == null && this.f64552h == null) {
                        l();
                    }
                    this.f64550f.h();
                    list = this.k;
                    if (list != null) {
                        this.k = null;
                    } else {
                        throw new o(this.f64552h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64550f : (t) invokeV.objValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f64551g : (t) invokeV.objValue;
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
            return this.f64549e;
        }
        return (r) invokeV.objValue;
    }

    public void i() {
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!f64544i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                this.m.f64561b = true;
                b2 = b();
                notifyAll();
            }
            if (b2) {
                return;
            }
            this.f64548d.b(this.f64547c);
        }
    }

    public void j() throws IOException {
        boolean z;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!f64544i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                z = !this.m.f64561b && this.m.f64560a && (this.f64549e.f64556b || this.f64549e.f64555a);
                b2 = b();
            }
            if (z) {
                a(com.bytedance.sdk.component.b.b.a.e.b.f64433f);
            } else if (b2) {
            } else {
                this.f64548d.b(this.f64547c);
            }
        }
    }

    public void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a aVar = this.f64549e;
            if (!aVar.f64555a) {
                if (!aVar.f64556b) {
                    if (this.f64552h != null) {
                        throw new o(this.f64552h);
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
            this.f64548d.b(this.f64547c, bVar);
        }
    }

    public synchronized void c(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                if (this.f64552h == null) {
                    this.f64552h = bVar;
                    notifyAll();
                }
            }
        }
    }

    public void a(List<com.bytedance.sdk.component.b.b.a.e.c> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (!f64544i && Thread.holdsLock(this)) {
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
            this.f64548d.b(this.f64547c);
        }
    }

    public void b(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && d(bVar)) {
            this.f64548d.a(this.f64547c, bVar);
        }
    }

    private boolean d(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bVar)) == null) {
            if (f64544i || !Thread.holdsLock(this)) {
                synchronized (this) {
                    if (this.f64552h != null) {
                        return false;
                    }
                    if (this.m.f64561b && this.f64549e.f64556b) {
                        return false;
                    }
                    this.f64552h = bVar;
                    notifyAll();
                    this.f64548d.b(this.f64547c);
                    return true;
                }
            }
            throw new AssertionError();
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public final class a implements r {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f64554c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64555a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64556b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f64557d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f64558e;

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
            f64554c = !i.class.desiredAssertionStatus();
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
            this.f64557d = iVar;
            this.f64558e = new com.bytedance.sdk.component.b.a.c();
        }

        private void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
                synchronized (this.f64557d) {
                    this.f64557d.f64551g.a();
                    while (this.f64557d.f64546b <= 0 && !this.f64556b && !this.f64555a && this.f64557d.f64552h == null) {
                        this.f64557d.l();
                    }
                    this.f64557d.f64551g.h();
                    this.f64557d.k();
                    min = Math.min(this.f64557d.f64546b, this.f64558e.b());
                    this.f64557d.f64546b -= min;
                }
                this.f64557d.f64551g.a();
                try {
                    this.f64557d.f64548d.a(this.f64557d.f64547c, z && min == this.f64558e.b(), this.f64558e, min);
                } finally {
                    this.f64557d.f64551g.h();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) == null) {
                if (!f64554c && Thread.holdsLock(this.f64557d)) {
                    throw new AssertionError();
                }
                this.f64558e.a_(cVar, j2);
                while (this.f64558e.b() >= 16384) {
                    a(false);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!f64554c && Thread.holdsLock(this.f64557d)) {
                    throw new AssertionError();
                }
                synchronized (this.f64557d) {
                    if (this.f64555a) {
                        return;
                    }
                    if (!this.f64557d.f64549e.f64556b) {
                        if (this.f64558e.b() > 0) {
                            while (this.f64558e.b() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar = this.f64557d;
                            iVar.f64548d.a(iVar.f64547c, true, (com.bytedance.sdk.component.b.a.c) null, 0L);
                        }
                    }
                    synchronized (this.f64557d) {
                        this.f64555a = true;
                    }
                    this.f64557d.f64548d.b();
                    this.f64557d.j();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (!f64554c && Thread.holdsLock(this.f64557d)) {
                    throw new AssertionError();
                }
                synchronized (this.f64557d) {
                    this.f64557d.k();
                }
                while (this.f64558e.b() > 0) {
                    a(false);
                    this.f64557d.f64548d.b();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64557d.f64551g : (t) invokeV.objValue;
        }
    }

    public void a(com.bytedance.sdk.component.b.a.e eVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (!f64544i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            this.m.a(eVar, i2);
        }
    }

    /* loaded from: classes9.dex */
    public final class b implements s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f64559c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f64560a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64561b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f64562d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f64563e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f64564f;

        /* renamed from: g  reason: collision with root package name */
        public final long f64565g;

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
            f64559c = !i.class.desiredAssertionStatus();
        }

        public b(i iVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f64562d = iVar;
            this.f64563e = new com.bytedance.sdk.component.b.a.c();
            this.f64564f = new com.bytedance.sdk.component.b.a.c();
            this.f64565g = j2;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f64562d.f64550f.a();
                while (this.f64564f.b() == 0 && !this.f64561b && !this.f64560a && this.f64562d.f64552h == null) {
                    try {
                        this.f64562d.l();
                    } finally {
                        this.f64562d.f64550f.h();
                    }
                }
            }
        }

        private void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                if (!this.f64560a) {
                    if (this.f64562d.f64552h != null) {
                        throw new o(this.f64562d.f64552h);
                    }
                    return;
                }
                throw new IOException("stream closed");
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                if (j2 >= 0) {
                    synchronized (this.f64562d) {
                        b();
                        c();
                        if (this.f64564f.b() == 0) {
                            return -1L;
                        }
                        long a2 = this.f64564f.a(cVar, Math.min(j2, this.f64564f.b()));
                        this.f64562d.f64545a += a2;
                        if (this.f64562d.f64545a >= this.f64562d.f64548d.l.d() / 2) {
                            this.f64562d.f64548d.a(this.f64562d.f64547c, this.f64562d.f64545a);
                            this.f64562d.f64545a = 0L;
                        }
                        synchronized (this.f64562d.f64548d) {
                            this.f64562d.f64548d.f64491j += a2;
                            if (this.f64562d.f64548d.f64491j >= this.f64562d.f64548d.l.d() / 2) {
                                this.f64562d.f64548d.a(0, this.f64562d.f64548d.f64491j);
                                this.f64562d.f64548d.f64491j = 0L;
                            }
                        }
                        return a2;
                    }
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this.f64562d) {
                    this.f64560a = true;
                    this.f64564f.r();
                    this.f64562d.notifyAll();
                }
                this.f64562d.j();
            }
        }

        public void a(com.bytedance.sdk.component.b.a.e eVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eVar, j2) == null) {
                if (!f64559c && Thread.holdsLock(this.f64562d)) {
                    throw new AssertionError();
                }
                while (j2 > 0) {
                    synchronized (this.f64562d) {
                        z = this.f64561b;
                        z2 = true;
                        z3 = this.f64564f.b() + j2 > this.f64565g;
                    }
                    if (z3) {
                        eVar.h(j2);
                        this.f64562d.b(com.bytedance.sdk.component.b.b.a.e.b.f64431d);
                        return;
                    } else if (z) {
                        eVar.h(j2);
                        return;
                    } else {
                        long a2 = eVar.a(this.f64563e, j2);
                        if (a2 != -1) {
                            j2 -= a2;
                            synchronized (this.f64562d) {
                                if (this.f64564f.b() != 0) {
                                    z2 = false;
                                }
                                this.f64564f.a(this.f64563e);
                                if (z2) {
                                    this.f64562d.notifyAll();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64562d.f64550f : (t) invokeV.objValue;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f64546b += j2;
            if (j2 > 0) {
                notifyAll();
            }
        }
    }
}
