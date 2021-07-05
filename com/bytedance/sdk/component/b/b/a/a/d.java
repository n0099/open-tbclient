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
/* loaded from: classes6.dex */
public final class d implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28054a;
    public static final /* synthetic */ boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.f.a f28055b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28056c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.component.b.a.d f28057d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashMap<String, b> f28058e;

    /* renamed from: f  reason: collision with root package name */
    public int f28059f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28060g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28061h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28062i;
    public long k;
    public long l;
    public long m;
    public final Executor n;
    public final Runnable o;

    /* loaded from: classes6.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b f28063a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f28064b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f28065c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28066d;

        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.f28063a.f28072f != this) {
                return;
            }
            int i2 = 0;
            while (true) {
                d dVar = this.f28065c;
                if (i2 < dVar.f28056c) {
                    try {
                        dVar.f28055b.a(this.f28063a.f28070d[i2]);
                    } catch (IOException unused) {
                    }
                    i2++;
                } else {
                    this.f28063a.f28072f = null;
                    return;
                }
            }
        }

        public void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.f28065c) {
                    if (!this.f28066d) {
                        if (this.f28063a.f28072f == this) {
                            this.f28065c.a(this, false);
                        }
                        this.f28066d = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f28067a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f28068b;

        /* renamed from: c  reason: collision with root package name */
        public final File[] f28069c;

        /* renamed from: d  reason: collision with root package name */
        public final File[] f28070d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28071e;

        /* renamed from: f  reason: collision with root package name */
        public a f28072f;

        /* renamed from: g  reason: collision with root package name */
        public long f28073g;

        public void a(com.bytedance.sdk.component.b.a.d dVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                for (long j : this.f28068b) {
                    dVar.i(32).l(j);
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
        j = !d.class.desiredAssertionStatus();
        f28054a = Pattern.compile("[a-z0-9_-]{1,120}");
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
                b bVar = aVar.f28063a;
                if (bVar.f28072f == aVar) {
                    if (z && !bVar.f28071e) {
                        for (int i2 = 0; i2 < this.f28056c; i2++) {
                            if (aVar.f28064b[i2]) {
                                if (!this.f28055b.b(bVar.f28070d[i2])) {
                                    aVar.b();
                                    return;
                                }
                            } else {
                                aVar.b();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f28056c; i3++) {
                        File file = bVar.f28070d[i3];
                        if (z) {
                            if (this.f28055b.b(file)) {
                                File file2 = bVar.f28069c[i3];
                                this.f28055b.a(file, file2);
                                long j2 = bVar.f28068b[i3];
                                long c2 = this.f28055b.c(file2);
                                bVar.f28068b[i3] = c2;
                                this.l = (this.l - j2) + c2;
                            }
                        } else {
                            this.f28055b.a(file);
                        }
                    }
                    this.f28059f++;
                    bVar.f28072f = null;
                    if (bVar.f28071e | z) {
                        bVar.f28071e = true;
                        this.f28057d.b("CLEAN").i(32);
                        this.f28057d.b(bVar.f28067a);
                        bVar.a(this.f28057d);
                        this.f28057d.i(10);
                        if (z) {
                            long j3 = this.m;
                            this.m = 1 + j3;
                            bVar.f28073g = j3;
                        }
                    } else {
                        this.f28058e.remove(bVar.f28067a);
                        this.f28057d.b("REMOVE").i(32);
                        this.f28057d.b(bVar.f28067a);
                        this.f28057d.i(10);
                    }
                    this.f28057d.flush();
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
                z = this.f28061h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            while (this.l > this.k) {
                a(this.f28058e.values().iterator().next());
            }
            this.f28062i = false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.f28060g && !this.f28061h) {
                    for (b bVar : (b[]) this.f28058e.values().toArray(new b[this.f28058e.size()])) {
                        if (bVar.f28072f != null) {
                            bVar.f28072f.b();
                        }
                    }
                    c();
                    this.f28057d.close();
                    this.f28057d = null;
                    this.f28061h = true;
                    return;
                }
                this.f28061h = true;
            }
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.f28060g) {
                    d();
                    c();
                    this.f28057d.flush();
                }
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f28059f;
            return i2 >= 2000 && i2 >= this.f28058e.size();
        }
        return invokeV.booleanValue;
    }

    public boolean a(b bVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            a aVar = bVar.f28072f;
            if (aVar != null) {
                aVar.a();
            }
            for (int i2 = 0; i2 < this.f28056c; i2++) {
                this.f28055b.a(bVar.f28069c[i2]);
                long j2 = this.l;
                long[] jArr = bVar.f28068b;
                this.l = j2 - jArr[i2];
                jArr[i2] = 0;
            }
            this.f28059f++;
            this.f28057d.b("REMOVE").i(32).b(bVar.f28067a).i(10);
            this.f28058e.remove(bVar.f28067a);
            if (a()) {
                this.n.execute(this.o);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
