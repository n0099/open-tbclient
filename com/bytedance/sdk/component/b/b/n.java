package com.bytedance.sdk.component.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.y;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65269a;

    /* renamed from: b  reason: collision with root package name */
    public int f65270b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f65271c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f65272d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<y.a> f65273e;

    /* renamed from: f  reason: collision with root package name */
    public final Deque<y.a> f65274f;

    /* renamed from: g  reason: collision with root package name */
    public final Deque<y> f65275g;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65269a = 64;
        this.f65270b = 5;
        this.f65273e = new ArrayDeque();
        this.f65274f = new ArrayDeque();
        this.f65275g = new ArrayDeque();
    }

    private int c(y.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            int i2 = 0;
            for (y.a aVar2 : this.f65274f) {
                if (aVar2.a().equals(aVar.a())) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f65274f.size() >= this.f65269a || this.f65273e.isEmpty()) {
            return;
        }
        Iterator<y.a> it = this.f65273e.iterator();
        while (it.hasNext()) {
            y.a next = it.next();
            if (c(next) < this.f65270b) {
                it.remove();
                this.f65274f.add(next);
                a().execute(next);
            }
            if (this.f65274f.size() >= this.f65269a) {
                return;
            }
        }
    }

    public synchronized ExecutorService a() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f65272d == null) {
                    this.f65272d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp Dispatcher", false));
                }
                executorService = this.f65272d;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void b(y.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            a(this.f65274f, aVar, true);
        }
    }

    public synchronized int d() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.f65274f.size() + this.f65275g.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            a(this.f65275g, yVar, false);
        }
    }

    public synchronized List<e> b() {
        InterceptResult invokeV;
        List<e> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (y.a aVar : this.f65273e) {
                    arrayList.add(aVar.b());
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<e> c() {
        InterceptResult invokeV;
        List<e> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f65275g);
                for (y.a aVar : this.f65274f) {
                    arrayList.add(aVar.b());
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized void a(y.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                if (this.f65274f.size() < this.f65269a && c(aVar) < this.f65270b) {
                    this.f65274f.add(aVar);
                    a().execute(aVar);
                } else {
                    this.f65273e.add(aVar);
                }
            }
        }
    }

    public synchronized void a(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yVar) == null) {
            synchronized (this) {
                this.f65275g.add(yVar);
            }
        }
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int d2;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, this, deque, t, z) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    if (z) {
                        e();
                    }
                    d2 = d();
                    runnable = this.f65271c;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            if (d2 != 0 || runnable == null) {
                return;
            }
            runnable.run();
        }
    }
}
