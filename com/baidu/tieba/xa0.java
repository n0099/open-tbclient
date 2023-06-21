package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class xa0 implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadFactory k;
    public static final BlockingQueue<Runnable> l;
    public static final Executor m;
    public static volatile xa0 n;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseIntArray a;
    public final LinkedList<d> b;
    public final LinkedList<d> c;
    public final LinkedList<d> d;
    public volatile int e;
    public volatile int f;
    public volatile int g;
    public volatile int h;
    public HandlerThread i;
    public Handler j;

    /* loaded from: classes8.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "BdAsyncTask #" + String.valueOf(this.a.getAndIncrement());
                ee0.g(str);
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xa0 xa0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof d)) {
                        return;
                    }
                    this.a.j((d) obj2);
                } else if (i == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                    this.a.i((d) obj);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(xa0 xa0Var, ya0 ya0Var) {
            super(ya0Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa0Var, ya0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ya0) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (e() == 4) {
                            Process.setThreadPriority(-2);
                        } else if (e() == 3) {
                            Process.setThreadPriority(-1);
                        } else if (e() == 2) {
                            Process.setThreadPriority(0);
                        } else {
                            Process.setThreadPriority(10);
                        }
                    } catch (Exception e) {
                        ee0.d(e.getMessage());
                    }
                    j();
                } finally {
                    if (!h()) {
                        this.b.j.sendMessageDelayed(this.b.j.obtainMessage(2, this), 1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ya0<?> a;

        public d(ya0<?> ya0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            if (ya0Var != null && ya0Var.b() != null) {
                this.a = ya0Var;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.b().j() != null) {
                    return this.a.b().j().a();
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.b().j() != null) {
                    return this.a.b().j().b();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public BdAsyncTaskParallelType d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.b().j() != null) {
                    return this.a.b().j().getType();
                }
                return BdAsyncTaskParallelType.MAX_PARALLEL;
            }
            return (BdAsyncTaskParallelType) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.b().k();
            }
            return invokeV.intValue;
        }

        public BdAsyncTask<?, ?, ?> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.a.b();
            }
            return (BdAsyncTask) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.a.isCancelled();
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a.b().m();
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.a.b().n();
            }
            return invokeV.booleanValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    this.a.run();
                } catch (OutOfMemoryError e) {
                    ee0.e(e);
                }
            }
        }

        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.a.b().y(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948293506, "Lcom/baidu/tieba/xa0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948293506, "Lcom/baidu/tieba/xa0;");
                return;
            }
        }
        k = new a();
        l = new SynchronousQueue();
        m = new ThreadPoolExecutor(7, 256, 30L, TimeUnit.SECONDS, l, k, new ThreadPoolExecutor.DiscardPolicy());
        n = null;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "mWaitingTasks = " + this.b.size() + " mRunningTasks = " + this.c.size() + " mTimeOutTasks = " + this.d.size();
        }
        return (String) invokeV.objValue;
    }

    public xa0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SparseIntArray();
        this.b = new LinkedList<>();
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        HandlerThread handlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.i = handlerThread;
        handlerThread.start();
        this.j = new b(this, this.i.getLooper());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdAsyncTask) == null) {
            synchronized (this) {
                Iterator<d> it = this.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null && next.f() == bdAsyncTask) {
                        break;
                    }
                }
            }
        }
    }

    public static xa0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (n == null) {
                synchronized (xa0.class) {
                    if (n == null) {
                        n = new xa0();
                    }
                }
            }
            return n;
        }
        return (xa0) invokeV.objValue;
    }

    public final boolean c(int i, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            BdAsyncTaskParallelType d2 = dVar.d();
            if (d2 == BdAsyncTaskParallelType.SERIAL) {
                if (i < 1) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.TWO_PARALLEL) {
                if (i < 2) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.THREE_PARALLEL) {
                if (i < 3) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.FOUR_PARALLEL) {
                if (i < 4) {
                    return true;
                }
            } else if (d2 != BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < dVar.b()) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final synchronized void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                this.c.add(dVar);
                this.b.remove(dVar);
                m.execute(dVar);
                this.j.sendMessageDelayed(this.j.obtainMessage(1, dVar), LiveFeedPageSdk.REFRESH_TIME);
                int e = dVar.e();
                if (e != 1) {
                    if (e != 2) {
                        if (e != 3) {
                            if (e == 4) {
                                this.e++;
                                if (this.e >= 7) {
                                    ee0.d("SuperHight Task too much num = " + this.e);
                                }
                            }
                        } else {
                            this.f++;
                        }
                    } else {
                        this.g++;
                    }
                } else {
                    this.h++;
                }
                int c2 = dVar.c();
                if (c2 != 0) {
                    this.a.put(c2, this.a.get(c2, 0) + 1);
                }
            }
        }
    }

    public final synchronized void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                if (dVar.i()) {
                    this.d.remove(dVar);
                } else {
                    this.c.remove(dVar);
                    this.j.removeMessages(1, dVar);
                    int e = dVar.e();
                    if (e != 1) {
                        if (e != 2) {
                            if (e != 3) {
                                if (e == 4) {
                                    this.e--;
                                }
                            } else {
                                this.f--;
                            }
                        } else {
                            this.g--;
                        }
                    } else {
                        this.h--;
                    }
                    int c2 = dVar.c();
                    if (c2 != 0) {
                        int i = this.a.get(c2) - 1;
                        if (i <= 0) {
                            this.a.delete(c2);
                        } else {
                            this.a.put(c2, i);
                        }
                        if (i < 0) {
                            ee0.d("removeTask error < 0");
                        }
                    }
                }
            }
        }
    }

    public synchronized void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                for (int i = 0; i < this.b.size(); i++) {
                    d dVar2 = this.b.get(i);
                    if (dVar2 != null) {
                        int c2 = dVar2.c();
                        int e = dVar2.e();
                        if (e != 1) {
                            if (e != 2) {
                                if (e != 3) {
                                    if (e == 4 && c2 == 0) {
                                        d(dVar2);
                                        return;
                                    }
                                } else if (this.f + this.g + this.h >= 7) {
                                    return;
                                }
                            } else if (this.f + this.g + this.h >= 6) {
                                return;
                            }
                        } else if (this.f + this.g + this.h >= 5) {
                            return;
                        }
                        if (c(this.a.get(c2), dVar2)) {
                            d(dVar2);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            synchronized (this) {
                if (!(runnable instanceof ya0)) {
                    return;
                }
                c cVar = new c(this, (ya0) runnable);
                if (cVar.h()) {
                    new Thread(cVar).start();
                    return;
                }
                f(cVar);
                i(null);
            }
        }
    }

    public final synchronized void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                int size = this.b.size();
                int i = 0;
                while (i < size && this.b.get(i).e() >= dVar.e()) {
                    i++;
                }
                this.b.add(i, dVar);
            }
        }
    }

    public final synchronized void j(d dVar) {
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                if (!dVar.g()) {
                    dVar.k(true);
                    this.d.add(dVar);
                    if (this.d.size() > 242 && (poll = this.d.poll()) != null) {
                        poll.a();
                    }
                } else {
                    ee0.d("task TimeOut but it's cancelled()");
                }
                i(null);
            }
        }
    }
}
