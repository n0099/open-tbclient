package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.b.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f64891c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f64892d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.d f64893a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64894b;

    /* renamed from: e  reason: collision with root package name */
    public final int f64895e;

    /* renamed from: f  reason: collision with root package name */
    public final long f64896f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f64897g;

    /* renamed from: h  reason: collision with root package name */
    public final Deque<com.bytedance.sdk.component.b.b.a.b.c> f64898h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731368816, "Lcom/bytedance/sdk/component/b/b/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731368816, "Lcom/bytedance/sdk/component/b/b/j;");
                return;
            }
        }
        f64891c = !j.class.desiredAssertionStatus();
        f64892d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp ConnectionPool", true));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(5, 5L, TimeUnit.MINUTES);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), (TimeUnit) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public com.bytedance.sdk.component.b.b.a.b.c a(a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar, ad adVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, gVar, adVar)) == null) {
            if (f64891c || Thread.holdsLock(this)) {
                for (com.bytedance.sdk.component.b.b.a.b.c cVar : this.f64898h) {
                    if (cVar.a(aVar, adVar)) {
                        gVar.a(cVar, true);
                        return cVar;
                    }
                }
                return null;
            }
            throw new AssertionError();
        }
        return (com.bytedance.sdk.component.b.b.a.b.c) invokeLLL.objValue;
    }

    public boolean b(com.bytedance.sdk.component.b.b.a.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            if (f64891c || Thread.holdsLock(this)) {
                if (!cVar.f64510a && this.f64895e != 0) {
                    notifyAll();
                    return false;
                }
                this.f64898h.remove(cVar);
                return true;
            }
            throw new AssertionError();
        }
        return invokeL.booleanValue;
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f64897g = new Runnable(this) { // from class: com.bytedance.sdk.component.b.b.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f64899a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f64899a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                while (true) {
                    long a2 = this.f64899a.a(System.nanoTime());
                    if (a2 == -1) {
                        return;
                    }
                    if (a2 > 0) {
                        long j3 = a2 / 1000000;
                        long j4 = a2 - (1000000 * j3);
                        synchronized (this.f64899a) {
                            try {
                                this.f64899a.wait(j3, (int) j4);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f64898h = new ArrayDeque();
        this.f64893a = new com.bytedance.sdk.component.b.b.a.b.d();
        this.f64895e = i2;
        this.f64896f = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }

    public Socket a(a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, gVar)) == null) {
            if (f64891c || Thread.holdsLock(this)) {
                for (com.bytedance.sdk.component.b.b.a.b.c cVar : this.f64898h) {
                    if (cVar.a(aVar, null) && cVar.e() && cVar != gVar.b()) {
                        return gVar.a(cVar);
                    }
                }
                return null;
            }
            throw new AssertionError();
        }
        return (Socket) invokeLL.objValue;
    }

    public void a(com.bytedance.sdk.component.b.b.a.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            if (!f64891c && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (!this.f64894b) {
                this.f64894b = true;
                f64892d.execute(this.f64897g);
            }
            this.f64898h.add(cVar);
        }
    }

    public long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            synchronized (this) {
                com.bytedance.sdk.component.b.b.a.b.c cVar = null;
                long j3 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (com.bytedance.sdk.component.b.b.a.b.c cVar2 : this.f64898h) {
                    if (a(cVar2, j2) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j4 = j2 - cVar2.f64514e;
                        if (j4 > j3) {
                            cVar = cVar2;
                            j3 = j4;
                        }
                    }
                }
                if (j3 < this.f64896f && i2 <= this.f64895e) {
                    if (i2 > 0) {
                        return this.f64896f - j3;
                    }
                    if (i3 > 0) {
                        return this.f64896f;
                    }
                    this.f64894b = false;
                    return -1L;
                }
                this.f64898h.remove(cVar);
                com.bytedance.sdk.component.b.b.a.c.a(cVar.c());
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    private int a(com.bytedance.sdk.component.b.b.a.b.c cVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, cVar, j2)) == null) {
            List<Reference<com.bytedance.sdk.component.b.b.a.b.g>> list = cVar.f64513d;
            int i2 = 0;
            while (i2 < list.size()) {
                Reference<com.bytedance.sdk.component.b.b.a.b.g> reference = list.get(i2);
                if (reference.get() != null) {
                    i2++;
                } else {
                    com.bytedance.sdk.component.b.b.a.g.e.b().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f64542a);
                    list.remove(i2);
                    cVar.f64510a = true;
                    if (list.isEmpty()) {
                        cVar.f64514e = j2 - this.f64896f;
                        return 0;
                    }
                }
            }
            return list.size();
        }
        return invokeLJ.intValue;
    }
}
