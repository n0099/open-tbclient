package com.bytedance.sdk.component.b.b.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public final class d implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f64794a;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ boolean f64795j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.f.a f64796b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64797c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.component.b.a.d f64798d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashMap<String, b> f64799e;

    /* renamed from: f  reason: collision with root package name */
    public int f64800f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64801g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64802h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64803i;
    public long k;
    public long l;
    public long m;
    public final Executor n;
    public final Runnable o;

    /* loaded from: classes9.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f64804a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f64805b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f64806c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64807d;

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f64804a.f64813f != this) {
                return;
            }
            int i2 = 0;
            while (true) {
                d dVar = this.f64806c;
                if (i2 < dVar.f64797c) {
                    try {
                        dVar.f64796b.a(this.f64804a.f64811d[i2]);
                    } catch (IOException unused) {
                    }
                    i2++;
                } else {
                    this.f64804a.f64813f = null;
                    return;
                }
            }
        }

        public void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f64806c) {
                    if (!this.f64807d) {
                        if (this.f64804a.f64813f == this) {
                            this.f64806c.a(this, false);
                        }
                        this.f64807d = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f64808a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f64809b;

        /* renamed from: c  reason: collision with root package name */
        public final File[] f64810c;

        /* renamed from: d  reason: collision with root package name */
        public final File[] f64811d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64812e;

        /* renamed from: f  reason: collision with root package name */
        public a f64813f;

        /* renamed from: g  reason: collision with root package name */
        public long f64814g;

        public void a(com.bytedance.sdk.component.b.a.d dVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                for (long j2 : this.f64809b) {
                    dVar.i(32).l(j2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952388974, "Lcom/bytedance/sdk/component/b/b/a/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952388974, "Lcom/bytedance/sdk/component/b/b/a/a/d;");
                return;
            }
        }
        f64795j = !d.class.desiredAssertionStatus();
        f64794a = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    private synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (b()) {
                    throw new IllegalStateException("cache is closed");
                }
            }
        }
    }

    public synchronized void a(a aVar, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, aVar, z) == null) {
            synchronized (this) {
                b bVar = aVar.f64804a;
                if (bVar.f64813f == aVar) {
                    if (z && !bVar.f64812e) {
                        for (int i2 = 0; i2 < this.f64797c; i2++) {
                            if (aVar.f64805b[i2]) {
                                if (!this.f64796b.b(bVar.f64811d[i2])) {
                                    aVar.b();
                                    return;
                                }
                            } else {
                                aVar.b();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f64797c; i3++) {
                        File file = bVar.f64811d[i3];
                        if (z) {
                            if (this.f64796b.b(file)) {
                                File file2 = bVar.f64810c[i3];
                                this.f64796b.a(file, file2);
                                long j2 = bVar.f64809b[i3];
                                long c2 = this.f64796b.c(file2);
                                bVar.f64809b[i3] = c2;
                                this.l = (this.l - j2) + c2;
                            }
                        } else {
                            this.f64796b.a(file);
                        }
                    }
                    this.f64800f++;
                    bVar.f64813f = null;
                    if (bVar.f64812e | z) {
                        bVar.f64812e = true;
                        this.f64798d.b("CLEAN").i(32);
                        this.f64798d.b(bVar.f64808a);
                        bVar.a(this.f64798d);
                        this.f64798d.i(10);
                        if (z) {
                            long j3 = this.m;
                            this.m = 1 + j3;
                            bVar.f64814g = j3;
                        }
                    } else {
                        this.f64799e.remove(bVar.f64808a);
                        this.f64798d.b("REMOVE").i(32);
                        this.f64798d.b(bVar.f64808a);
                        this.f64798d.i(10);
                    }
                    this.f64798d.flush();
                    if (this.l > this.k || a()) {
                        this.n.execute(this.o);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                z = this.f64802h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            while (this.l > this.k) {
                a(this.f64799e.values().iterator().next());
            }
            this.f64803i = false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f64801g && !this.f64802h) {
                    for (b bVar : (b[]) this.f64799e.values().toArray(new b[this.f64799e.size()])) {
                        if (bVar.f64813f != null) {
                            bVar.f64813f.b();
                        }
                    }
                    c();
                    this.f64798d.close();
                    this.f64798d = null;
                    this.f64802h = true;
                    return;
                }
                this.f64802h = true;
            }
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.f64801g) {
                    d();
                    c();
                    this.f64798d.flush();
                }
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f64800f;
            return i2 >= 2000 && i2 >= this.f64799e.size();
        }
        return invokeV.booleanValue;
    }

    public boolean a(b bVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            a aVar = bVar.f64813f;
            if (aVar != null) {
                aVar.a();
            }
            for (int i2 = 0; i2 < this.f64797c; i2++) {
                this.f64796b.a(bVar.f64810c[i2]);
                long j2 = this.l;
                long[] jArr = bVar.f64809b;
                this.l = j2 - jArr[i2];
                jArr[i2] = 0;
            }
            this.f64800f++;
            this.f64798d.b("REMOVE").i(32).b(bVar.f64808a).i(10);
            this.f64799e.remove(bVar.f64808a);
            if (a()) {
                this.n.execute(this.o);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
