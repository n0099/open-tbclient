package com.bytedance.sdk.component.b.b.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.response.ResponseException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.b.f;
import com.bytedance.sdk.component.b.b.a.e.o;
import com.bytedance.sdk.component.b.b.ad;
import com.bytedance.sdk.component.b.b.j;
import com.bytedance.sdk.component.b.b.p;
import com.bytedance.sdk.component.b.b.u;
import com.bytedance.sdk.component.b.b.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f64352d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a f64353a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.e f64354b;

    /* renamed from: c  reason: collision with root package name */
    public final p f64355c;

    /* renamed from: e  reason: collision with root package name */
    public f.a f64356e;

    /* renamed from: f  reason: collision with root package name */
    public ad f64357f;

    /* renamed from: g  reason: collision with root package name */
    public final j f64358g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f64359h;

    /* renamed from: i  reason: collision with root package name */
    public final f f64360i;

    /* renamed from: j  reason: collision with root package name */
    public int f64361j;
    public c k;
    public boolean l;
    public boolean m;
    public boolean n;
    public com.bytedance.sdk.component.b.b.a.c.c o;

    /* loaded from: classes9.dex */
    public static final class a extends WeakReference<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Object f64362a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, Object obj) {
            super(gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64362a = obj;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952359090, "Lcom/bytedance/sdk/component/b/b/a/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952359090, "Lcom/bytedance/sdk/component/b/b/a/b/g;");
                return;
            }
        }
        f64352d = !g.class.desiredAssertionStatus();
    }

    public g(j jVar, com.bytedance.sdk.component.b.b.a aVar, com.bytedance.sdk.component.b.b.e eVar, p pVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, aVar, eVar, pVar, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64358g = jVar;
        this.f64353a = aVar;
        this.f64354b = eVar;
        this.f64355c = pVar;
        this.f64360i = new f(aVar, h(), eVar, pVar);
        this.f64359h = obj;
    }

    private Socket g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (f64352d || Thread.holdsLock(this.f64358g)) {
                c cVar = this.k;
                if (cVar == null || !cVar.f64330a) {
                    return null;
                }
                return a(false, false, true);
            }
            throw new AssertionError();
        }
        return (Socket) invokeV.objValue;
    }

    private d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? com.bytedance.sdk.component.b.b.a.a.f64284a.a(this.f64358g) : (d) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.b.a.c.c a(w wVar, u.a aVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar, aVar, z)) == null) {
            try {
                com.bytedance.sdk.component.b.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), wVar.r(), z).a(wVar, aVar, this);
                synchronized (this.f64358g) {
                    this.o = a2;
                }
                return a2;
            } catch (IOException e2) {
                throw new e(e2);
            }
        }
        return (com.bytedance.sdk.component.b.b.a.c.c) invokeLLZ.objValue;
    }

    public synchronized c b() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                cVar = this.k;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public void c() {
        c cVar;
        Socket a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f64358g) {
                cVar = this.k;
                a2 = a(false, true, false);
                if (this.k != null) {
                    cVar = null;
                }
            }
            com.bytedance.sdk.component.b.b.a.c.a(a2);
            if (cVar != null) {
                this.f64355c.b(this.f64354b, cVar);
            }
        }
    }

    public void d() {
        c cVar;
        Socket a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.f64358g) {
                cVar = this.k;
                a2 = a(true, false, false);
                if (this.k != null) {
                    cVar = null;
                }
            }
            com.bytedance.sdk.component.b.b.a.c.a(a2);
            if (cVar != null) {
                this.f64355c.b(this.f64354b, cVar);
            }
        }
    }

    public void e() {
        com.bytedance.sdk.component.b.b.a.c.c cVar;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f64358g) {
                this.n = true;
                cVar = this.o;
                cVar2 = this.k;
            }
            if (cVar != null) {
                cVar.c();
            } else if (cVar2 != null) {
                cVar2.b();
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        f.a aVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f64357f != null || ((aVar = this.f64356e) != null && aVar.a()) || this.f64360i.a() : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c b2 = b();
            return b2 != null ? b2.toString() : this.f64353a.toString();
        }
        return (String) invokeV.objValue;
    }

    private void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, cVar) == null) {
            int size = cVar.f64333d.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (cVar.f64333d.get(i2).get() == this) {
                    cVar.f64333d.remove(i2);
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    private c a(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (c) invokeCommon.objValue;
        }
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.f64358g) {
                if (a2.f64331b == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                d();
            }
        }
    }

    private c a(int i2, int i3, int i4, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Socket g2;
        Socket socket;
        c cVar;
        c cVar2;
        ad adVar;
        boolean z2;
        boolean z3;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            synchronized (this.f64358g) {
                if (!this.m) {
                    if (this.o == null) {
                        if (!this.n) {
                            c cVar3 = this.k;
                            g2 = g();
                            socket = null;
                            if (this.k != null) {
                                cVar2 = this.k;
                                cVar = null;
                            } else {
                                cVar = cVar3;
                                cVar2 = null;
                            }
                            if (!this.l) {
                                cVar = null;
                            }
                            if (cVar2 == null) {
                                com.bytedance.sdk.component.b.b.a.a.f64284a.a(this.f64358g, this.f64353a, this, null);
                                if (this.k != null) {
                                    cVar2 = this.k;
                                    adVar = null;
                                    z2 = true;
                                } else {
                                    adVar = this.f64357f;
                                }
                            } else {
                                adVar = null;
                            }
                            z2 = false;
                        } else {
                            throw new IOException(ResponseException.CANCELED);
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            }
            com.bytedance.sdk.component.b.b.a.c.a(g2);
            if (cVar != null) {
                this.f64355c.b(this.f64354b, cVar);
            }
            if (z2) {
                this.f64355c.a(this.f64354b, cVar2);
            }
            if (cVar2 != null) {
                return cVar2;
            }
            if (adVar != null || ((aVar = this.f64356e) != null && aVar.a())) {
                z3 = false;
            } else {
                this.f64356e = this.f64360i.b();
                z3 = true;
            }
            synchronized (this.f64358g) {
                if (this.n) {
                    throw new IOException(ResponseException.CANCELED);
                }
                if (z3) {
                    List<ad> c2 = this.f64356e.c();
                    int size = c2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        ad adVar2 = c2.get(i5);
                        com.bytedance.sdk.component.b.b.a.a.f64284a.a(this.f64358g, this.f64353a, this, adVar2);
                        if (this.k != null) {
                            cVar2 = this.k;
                            this.f64357f = adVar2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (adVar == null) {
                        adVar = this.f64356e.b();
                    }
                    this.f64357f = adVar;
                    this.f64361j = 0;
                    cVar2 = new c(this.f64358g, adVar);
                    a(cVar2, false);
                }
            }
            if (z2) {
                this.f64355c.a(this.f64354b, cVar2);
                return cVar2;
            }
            cVar2.a(i2, i3, i4, z, this.f64354b, this.f64355c);
            h().b(cVar2.a());
            synchronized (this.f64358g) {
                this.l = true;
                com.bytedance.sdk.component.b.b.a.a.f64284a.b(this.f64358g, cVar2);
                if (cVar2.e()) {
                    socket = com.bytedance.sdk.component.b.b.a.a.f64284a.a(this.f64358g, this.f64353a, this);
                    cVar2 = this.k;
                }
            }
            com.bytedance.sdk.component.b.b.a.c.a(socket);
            this.f64355c.a(this.f64354b, cVar2);
            return cVar2;
        }
        return (c) invokeCommon.objValue;
    }

    public void a(boolean z, com.bytedance.sdk.component.b.b.a.c.c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), cVar, Long.valueOf(j2), iOException}) == null) {
            this.f64355c.b(this.f64354b, j2);
            synchronized (this.f64358g) {
                if (cVar != null) {
                    if (cVar == this.o) {
                        if (!z) {
                            this.k.f64331b++;
                        }
                        cVar2 = this.k;
                        a2 = a(z, false, true);
                        if (this.k != null) {
                            cVar2 = null;
                        }
                        z2 = this.m;
                    }
                }
                throw new IllegalStateException("expected " + this.o + " but was " + cVar);
            }
            com.bytedance.sdk.component.b.b.a.c.a(a2);
            if (cVar2 != null) {
                this.f64355c.b(this.f64354b, cVar2);
            }
            if (iOException != null) {
                this.f64355c.a(this.f64354b, iOException);
            } else if (z2) {
                this.f64355c.g(this.f64354b);
            }
        }
    }

    public com.bytedance.sdk.component.b.b.a.c.c a() {
        InterceptResult invokeV;
        com.bytedance.sdk.component.b.b.a.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f64358g) {
                cVar = this.o;
            }
            return cVar;
        }
        return (com.bytedance.sdk.component.b.b.a.c.c) invokeV.objValue;
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Socket socket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (f64352d || Thread.holdsLock(this.f64358g)) {
                if (z3) {
                    this.o = null;
                }
                if (z2) {
                    this.m = true;
                }
                c cVar = this.k;
                if (cVar != null) {
                    if (z) {
                        cVar.f64330a = true;
                    }
                    if (this.o == null) {
                        if (this.m || this.k.f64330a) {
                            b(this.k);
                            if (this.k.f64333d.isEmpty()) {
                                this.k.f64334e = System.nanoTime();
                                if (com.bytedance.sdk.component.b.b.a.a.f64284a.a(this.f64358g, this.k)) {
                                    socket = this.k.c();
                                    this.k = null;
                                    return socket;
                                }
                            }
                            socket = null;
                            this.k = null;
                            return socket;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            throw new AssertionError();
        }
        return (Socket) invokeCommon.objValue;
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iOException) == null) {
            synchronized (this.f64358g) {
                cVar = null;
                if (iOException instanceof o) {
                    o oVar = (o) iOException;
                    if (oVar.f64587a == com.bytedance.sdk.component.b.b.a.e.b.f64432e) {
                        this.f64361j++;
                    }
                    if (oVar.f64587a != com.bytedance.sdk.component.b.b.a.e.b.f64432e || this.f64361j > 1) {
                        this.f64357f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (this.k != null && (!this.k.e() || (iOException instanceof com.bytedance.sdk.component.b.b.a.e.a))) {
                        if (this.k.f64331b == 0) {
                            if (this.f64357f != null && iOException != null) {
                                this.f64360i.a(this.f64357f, iOException);
                            }
                            this.f64357f = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                c cVar2 = this.k;
                a2 = a(z, false, true);
                if (this.k == null && this.l) {
                    cVar = cVar2;
                }
            }
            com.bytedance.sdk.component.b.b.a.c.a(a2);
            if (cVar != null) {
                this.f64355c.b(this.f64354b, cVar);
            }
        }
    }

    public void a(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, cVar, z) == null) {
            if (!f64352d && !Thread.holdsLock(this.f64358g)) {
                throw new AssertionError();
            }
            if (this.k == null) {
                this.k = cVar;
                this.l = z;
                cVar.f64333d.add(new a(this, this.f64359h));
                return;
            }
            throw new IllegalStateException();
        }
    }

    public Socket a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (f64352d || Thread.holdsLock(this.f64358g)) {
                if (this.o == null && this.k.f64333d.size() == 1) {
                    Socket a2 = a(true, false, false);
                    this.k = cVar;
                    cVar.f64333d.add(this.k.f64333d.get(0));
                    return a2;
                }
                throw new IllegalStateException();
            }
            throw new AssertionError();
        }
        return (Socket) invokeL.objValue;
    }
}
