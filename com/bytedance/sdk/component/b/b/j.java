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
/* loaded from: classes5.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f28653c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f28654d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.b.a.b.d f28655a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28656b;

    /* renamed from: e  reason: collision with root package name */
    public final int f28657e;

    /* renamed from: f  reason: collision with root package name */
    public final long f28658f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f28659g;

    /* renamed from: h  reason: collision with root package name */
    public final Deque<com.bytedance.sdk.component.b.b.a.b.c> f28660h;

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
        f28653c = !j.class.desiredAssertionStatus();
        f28654d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp ConnectionPool", true));
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
            if (f28653c || Thread.holdsLock(this)) {
                for (com.bytedance.sdk.component.b.b.a.b.c cVar : this.f28660h) {
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
            if (f28653c || Thread.holdsLock(this)) {
                if (!cVar.f28284a && this.f28657e != 0) {
                    notifyAll();
                    return false;
                }
                this.f28660h.remove(cVar);
                return true;
            }
            throw new AssertionError();
        }
        return invokeL.booleanValue;
    }

    public j(int i2, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f28659g = new Runnable(this) { // from class: com.bytedance.sdk.component.b.b.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f28661a;

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
                this.f28661a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                while (true) {
                    long a2 = this.f28661a.a(System.nanoTime());
                    if (a2 == -1) {
                        return;
                    }
                    if (a2 > 0) {
                        long j2 = a2 / 1000000;
                        long j3 = a2 - (1000000 * j2);
                        synchronized (this.f28661a) {
                            try {
                                this.f28661a.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f28660h = new ArrayDeque();
        this.f28655a = new com.bytedance.sdk.component.b.b.a.b.d();
        this.f28657e = i2;
        this.f28658f = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    public Socket a(a aVar, com.bytedance.sdk.component.b.b.a.b.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, gVar)) == null) {
            if (f28653c || Thread.holdsLock(this)) {
                for (com.bytedance.sdk.component.b.b.a.b.c cVar : this.f28660h) {
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
            if (!f28653c && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (!this.f28656b) {
                this.f28656b = true;
                f28654d.execute(this.f28659g);
            }
            this.f28660h.add(cVar);
        }
    }

    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this) {
                com.bytedance.sdk.component.b.b.a.b.c cVar = null;
                long j2 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (com.bytedance.sdk.component.b.b.a.b.c cVar2 : this.f28660h) {
                    if (a(cVar2, j) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j3 = j - cVar2.f28288e;
                        if (j3 > j2) {
                            cVar = cVar2;
                            j2 = j3;
                        }
                    }
                }
                if (j2 < this.f28658f && i2 <= this.f28657e) {
                    if (i2 > 0) {
                        return this.f28658f - j2;
                    }
                    if (i3 > 0) {
                        return this.f28658f;
                    }
                    this.f28656b = false;
                    return -1L;
                }
                this.f28660h.remove(cVar);
                com.bytedance.sdk.component.b.b.a.c.a(cVar.c());
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    private int a(com.bytedance.sdk.component.b.b.a.b.c cVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, cVar, j)) == null) {
            List<Reference<com.bytedance.sdk.component.b.b.a.b.g>> list = cVar.f28287d;
            int i2 = 0;
            while (i2 < list.size()) {
                Reference<com.bytedance.sdk.component.b.b.a.b.g> reference = list.get(i2);
                if (reference.get() != null) {
                    i2++;
                } else {
                    com.bytedance.sdk.component.b.b.a.g.e.b().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f28314a);
                    list.remove(i2);
                    cVar.f28284a = true;
                    if (list.isEmpty()) {
                        cVar.f28288e = j - this.f28658f;
                        return 0;
                    }
                }
            }
            return list.size();
        }
        return invokeLJ.intValue;
    }
}
