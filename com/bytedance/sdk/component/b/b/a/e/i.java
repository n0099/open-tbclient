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
/* loaded from: classes6.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ boolean f28287i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f28288a;

    /* renamed from: b  reason: collision with root package name */
    public long f28289b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28290c;

    /* renamed from: d  reason: collision with root package name */
    public final g f28291d;

    /* renamed from: e  reason: collision with root package name */
    public final a f28292e;

    /* renamed from: f  reason: collision with root package name */
    public final c f28293f;

    /* renamed from: g  reason: collision with root package name */
    public final c f28294g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.component.b.b.a.e.b f28295h;
    public final List<com.bytedance.sdk.component.b.b.a.e.c> j;
    public List<com.bytedance.sdk.component.b.b.a.e.c> k;
    public boolean l;
    public final b m;

    /* loaded from: classes6.dex */
    public class c extends com.bytedance.sdk.component.b.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f28308b;

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
            this.f28308b = iVar;
        }

        @Override // com.bytedance.sdk.component.b.a.a
        public void a_() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28308b.b(com.bytedance.sdk.component.b.b.a.e.b.f28179f);
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
        f28287i = !i.class.desiredAssertionStatus();
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
        this.f28288a = 0L;
        this.f28293f = new c(this);
        this.f28294g = new c(this);
        this.f28295h = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list != null) {
            this.f28290c = i2;
            this.f28291d = gVar;
            this.f28289b = gVar.m.d();
            this.m = new b(this, gVar.l.d());
            a aVar = new a(this);
            this.f28292e = aVar;
            this.m.f28303b = z2;
            aVar.f28298b = z;
            this.j = list;
            return;
        }
        throw new NullPointerException("requestHeaders == null");
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28290c : invokeV.intValue;
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f28295h != null) {
                    return false;
                }
                if ((this.m.f28303b || this.m.f28302a) && (this.f28292e.f28298b || this.f28292e.f28297a)) {
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
            return this.f28291d.f28227b == ((this.f28290c & 1) == 1);
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
                    this.f28293f.a();
                    while (this.k == null && this.f28295h == null) {
                        l();
                    }
                    this.f28293f.h();
                    list = this.k;
                    if (list != null) {
                        this.k = null;
                    } else {
                        throw new o(this.f28295h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28293f : (t) invokeV.objValue;
    }

    public t f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28294g : (t) invokeV.objValue;
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
            return this.f28292e;
        }
        return (r) invokeV.objValue;
    }

    public void i() {
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!f28287i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                this.m.f28303b = true;
                b2 = b();
                notifyAll();
            }
            if (b2) {
                return;
            }
            this.f28291d.b(this.f28290c);
        }
    }

    public void j() throws IOException {
        boolean z;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!f28287i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            synchronized (this) {
                z = !this.m.f28303b && this.m.f28302a && (this.f28292e.f28298b || this.f28292e.f28297a);
                b2 = b();
            }
            if (z) {
                a(com.bytedance.sdk.component.b.b.a.e.b.f28179f);
            } else if (b2) {
            } else {
                this.f28291d.b(this.f28290c);
            }
        }
    }

    public void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            a aVar = this.f28292e;
            if (!aVar.f28297a) {
                if (!aVar.f28298b) {
                    if (this.f28295h != null) {
                        throw new o(this.f28295h);
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
            this.f28291d.b(this.f28290c, bVar);
        }
    }

    public synchronized void c(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            synchronized (this) {
                if (this.f28295h == null) {
                    this.f28295h = bVar;
                    notifyAll();
                }
            }
        }
    }

    public void a(List<com.bytedance.sdk.component.b.b.a.e.c> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (!f28287i && Thread.holdsLock(this)) {
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
            this.f28291d.b(this.f28290c);
        }
    }

    public void b(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && d(bVar)) {
            this.f28291d.a(this.f28290c, bVar);
        }
    }

    private boolean d(com.bytedance.sdk.component.b.b.a.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bVar)) == null) {
            if (f28287i || !Thread.holdsLock(this)) {
                synchronized (this) {
                    if (this.f28295h != null) {
                        return false;
                    }
                    if (this.m.f28303b && this.f28292e.f28298b) {
                        return false;
                    }
                    this.f28295h = bVar;
                    notifyAll();
                    this.f28291d.b(this.f28290c);
                    return true;
                }
            }
            throw new AssertionError();
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public final class a implements r {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28296c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28297a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28298b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f28299d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28300e;

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
            f28296c = !i.class.desiredAssertionStatus();
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
            this.f28299d = iVar;
            this.f28300e = new com.bytedance.sdk.component.b.a.c();
        }

        private void a(boolean z) throws IOException {
            long min;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
                synchronized (this.f28299d) {
                    this.f28299d.f28294g.a();
                    while (this.f28299d.f28289b <= 0 && !this.f28298b && !this.f28297a && this.f28299d.f28295h == null) {
                        this.f28299d.l();
                    }
                    this.f28299d.f28294g.h();
                    this.f28299d.k();
                    min = Math.min(this.f28299d.f28289b, this.f28300e.b());
                    this.f28299d.f28289b -= min;
                }
                this.f28299d.f28294g.a();
                try {
                    this.f28299d.f28291d.a(this.f28299d.f28290c, z && min == this.f28300e.b(), this.f28300e, min);
                } finally {
                    this.f28299d.f28294g.h();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (!f28296c && Thread.holdsLock(this.f28299d)) {
                    throw new AssertionError();
                }
                this.f28300e.a_(cVar, j);
                while (this.f28300e.b() >= 16384) {
                    a(false);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!f28296c && Thread.holdsLock(this.f28299d)) {
                    throw new AssertionError();
                }
                synchronized (this.f28299d) {
                    if (this.f28297a) {
                        return;
                    }
                    if (!this.f28299d.f28292e.f28298b) {
                        if (this.f28300e.b() > 0) {
                            while (this.f28300e.b() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar = this.f28299d;
                            iVar.f28291d.a(iVar.f28290c, true, (com.bytedance.sdk.component.b.a.c) null, 0L);
                        }
                    }
                    synchronized (this.f28299d) {
                        this.f28297a = true;
                    }
                    this.f28299d.f28291d.b();
                    this.f28299d.j();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (!f28296c && Thread.holdsLock(this.f28299d)) {
                    throw new AssertionError();
                }
                synchronized (this.f28299d) {
                    this.f28299d.k();
                }
                while (this.f28300e.b() > 0) {
                    a(false);
                    this.f28299d.f28291d.b();
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28299d.f28294g : (t) invokeV.objValue;
        }
    }

    public void a(com.bytedance.sdk.component.b.a.e eVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, eVar, i2) == null) {
            if (!f28287i && Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            this.m.a(eVar, i2);
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements s {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ boolean f28301c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f28302a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28303b;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f28304d;

        /* renamed from: e  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28305e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.c f28306f;

        /* renamed from: g  reason: collision with root package name */
        public final long f28307g;

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
            f28301c = !i.class.desiredAssertionStatus();
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
            this.f28304d = iVar;
            this.f28305e = new com.bytedance.sdk.component.b.a.c();
            this.f28306f = new com.bytedance.sdk.component.b.a.c();
            this.f28307g = j;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.f28304d.f28293f.a();
                while (this.f28306f.b() == 0 && !this.f28303b && !this.f28302a && this.f28304d.f28295h == null) {
                    try {
                        this.f28304d.l();
                    } finally {
                        this.f28304d.f28293f.h();
                    }
                }
            }
        }

        private void c() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65539, this) == null) {
                if (!this.f28302a) {
                    if (this.f28304d.f28295h != null) {
                        throw new o(this.f28304d.f28295h);
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
                    synchronized (this.f28304d) {
                        b();
                        c();
                        if (this.f28306f.b() == 0) {
                            return -1L;
                        }
                        long a2 = this.f28306f.a(cVar, Math.min(j, this.f28306f.b()));
                        this.f28304d.f28288a += a2;
                        if (this.f28304d.f28288a >= this.f28304d.f28291d.l.d() / 2) {
                            this.f28304d.f28291d.a(this.f28304d.f28290c, this.f28304d.f28288a);
                            this.f28304d.f28288a = 0L;
                        }
                        synchronized (this.f28304d.f28291d) {
                            this.f28304d.f28291d.j += a2;
                            if (this.f28304d.f28291d.j >= this.f28304d.f28291d.l.d() / 2) {
                                this.f28304d.f28291d.a(0, this.f28304d.f28291d.j);
                                this.f28304d.f28291d.j = 0L;
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
                synchronized (this.f28304d) {
                    this.f28302a = true;
                    this.f28306f.r();
                    this.f28304d.notifyAll();
                }
                this.f28304d.j();
            }
        }

        public void a(com.bytedance.sdk.component.b.a.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, eVar, j) == null) {
                if (!f28301c && Thread.holdsLock(this.f28304d)) {
                    throw new AssertionError();
                }
                while (j > 0) {
                    synchronized (this.f28304d) {
                        z = this.f28303b;
                        z2 = true;
                        z3 = this.f28306f.b() + j > this.f28307g;
                    }
                    if (z3) {
                        eVar.h(j);
                        this.f28304d.b(com.bytedance.sdk.component.b.b.a.e.b.f28177d);
                        return;
                    } else if (z) {
                        eVar.h(j);
                        return;
                    } else {
                        long a2 = eVar.a(this.f28305e, j);
                        if (a2 != -1) {
                            j -= a2;
                            synchronized (this.f28304d) {
                                if (this.f28306f.b() != 0) {
                                    z2 = false;
                                }
                                this.f28306f.a(this.f28305e);
                                if (z2) {
                                    this.f28304d.notifyAll();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28304d.f28293f : (t) invokeV.objValue;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f28289b += j;
            if (j > 0) {
                notifyAll();
            }
        }
    }
}
