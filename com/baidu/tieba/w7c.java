package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e6c;
import com.baidu.tieba.h6c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes8.dex */
public class w7c<T> implements h6c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Long a;
    public final u6c b;
    public final e6c.d c;

    /* loaded from: classes8.dex */
    public static final class a<T> extends n6c<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentLinkedQueue<Object> e;
        public final AtomicLong f;
        public final n6c<? super T> g;
        public final AtomicBoolean h;
        public final BackpressureDrainManager i;
        public final u6c j;
        public final e6c.d k;

        public a(n6c<? super T> n6cVar, Long l, u6c u6cVar, e6c.d dVar) {
            AtomicLong atomicLong;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6cVar, l, u6cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = new ConcurrentLinkedQueue<>();
            this.h = new AtomicBoolean(false);
            this.g = n6cVar;
            if (l != null) {
                atomicLong = new AtomicLong(l.longValue());
            } else {
                atomicLong = null;
            }
            this.f = atomicLong;
            this.j = u6cVar;
            this.i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.g.onError(th);
                } else {
                    this.g.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return NotificationLite.a(this.g, obj);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.i6c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, th) == null) && !this.h.get()) {
                this.i.terminateAndDrain(th);
            }
        }

        @Override // com.baidu.tieba.i6c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, t) != null) || !g()) {
                return;
            }
            this.e.offer(NotificationLite.i(t));
            this.i.drain();
        }

        @Override // com.baidu.tieba.n6c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        public j6c h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.i;
            }
            return (j6c) invokeV.objValue;
        }

        @Override // com.baidu.tieba.i6c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.h.get()) {
                this.i.terminateAndDrain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.e.peek();
            }
            return invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.e.poll();
                AtomicLong atomicLong = this.f;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x004d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g() {
            InterceptResult invokeV;
            long j;
            boolean z;
            u6c u6cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f == null) {
                    return true;
                }
                do {
                    j = this.f.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e) {
                            if (this.h.compareAndSet(false, true)) {
                                unsubscribe();
                                this.g.onError(e);
                            }
                        }
                        if (this.k.a() && poll() != null) {
                            z = true;
                            u6cVar = this.j;
                            if (u6cVar != null) {
                                try {
                                    u6cVar.call();
                                } catch (Throwable th) {
                                    t6c.e(th);
                                    this.i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        u6cVar = this.j;
                        if (u6cVar != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f.compareAndSet(j, j - 1));
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final w7c<?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361598488, "Lcom/baidu/tieba/w7c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361598488, "Lcom/baidu/tieba/w7c$b;");
                    return;
                }
            }
            a = new w7c<>();
        }
    }

    public w7c() {
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
        this.a = null;
        this.b = null;
        this.c = e6c.b;
    }

    public static <T> w7c<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (w7c<T>) b.a;
        }
        return (w7c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a7c
    /* renamed from: a */
    public n6c<? super T> call(n6c<? super T> n6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n6cVar)) == null) {
            a aVar = new a(n6cVar, this.a, this.b, this.c);
            n6cVar.b(aVar);
            n6cVar.f(aVar.h());
            return aVar;
        }
        return (n6c) invokeL.objValue;
    }
}
