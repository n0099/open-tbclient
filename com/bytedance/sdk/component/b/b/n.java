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
    public int f64743a;

    /* renamed from: b  reason: collision with root package name */
    public int f64744b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f64745c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f64746d;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<y.a> f64747e;

    /* renamed from: f  reason: collision with root package name */
    public final Deque<y.a> f64748f;

    /* renamed from: g  reason: collision with root package name */
    public final Deque<y> f64749g;

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
        this.f64743a = 64;
        this.f64744b = 5;
        this.f64747e = new ArrayDeque();
        this.f64748f = new ArrayDeque();
        this.f64749g = new ArrayDeque();
    }

    private int c(y.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            int i2 = 0;
            for (y.a aVar2 : this.f64748f) {
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
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f64748f.size() >= this.f64743a || this.f64747e.isEmpty()) {
            return;
        }
        Iterator<y.a> it = this.f64747e.iterator();
        while (it.hasNext()) {
            y.a next = it.next();
            if (c(next) < this.f64744b) {
                it.remove();
                this.f64748f.add(next);
                a().execute(next);
            }
            if (this.f64748f.size() >= this.f64743a) {
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
                if (this.f64746d == null) {
                    this.f64746d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.b.b.a.c.a("OkHttp Dispatcher", false));
                }
                executorService = this.f64746d;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void b(y.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            a(this.f64748f, aVar, true);
        }
    }

    public synchronized int d() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.f64748f.size() + this.f64749g.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public void b(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            a(this.f64749g, yVar, false);
        }
    }

    public synchronized List<e> b() {
        InterceptResult invokeV;
        List<e> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (y.a aVar : this.f64747e) {
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
                arrayList.addAll(this.f64749g);
                for (y.a aVar : this.f64748f) {
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
                if (this.f64748f.size() < this.f64743a && c(aVar) < this.f64744b) {
                    this.f64748f.add(aVar);
                    a().execute(aVar);
                } else {
                    this.f64747e.add(aVar);
                }
            }
        }
    }

    public synchronized void a(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yVar) == null) {
            synchronized (this) {
                this.f64749g.add(yVar);
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
                    runnable = this.f64745c;
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
