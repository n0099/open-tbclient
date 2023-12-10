package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.boc;
import com.baidu.tieba.eoc;
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
public class tpc<T> implements eoc.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Long a;
    public final roc b;
    public final boc.d c;

    /* loaded from: classes8.dex */
    public static final class a<T> extends koc<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentLinkedQueue<Object> e;
        public final AtomicLong f;
        public final koc<? super T> g;
        public final AtomicBoolean h;
        public final BackpressureDrainManager i;
        public final roc j;
        public final boc.d k;

        public a(koc<? super T> kocVar, Long l, roc rocVar, boc.d dVar) {
            AtomicLong atomicLong;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kocVar, l, rocVar, dVar};
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
            this.g = kocVar;
            if (l != null) {
                atomicLong = new AtomicLong(l.longValue());
            } else {
                atomicLong = null;
            }
            this.f = atomicLong;
            this.j = rocVar;
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

        @Override // com.baidu.tieba.foc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, th) == null) && !this.h.get()) {
                this.i.terminateAndDrain(th);
            }
        }

        @Override // com.baidu.tieba.foc
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, t) != null) || !g()) {
                return;
            }
            this.e.offer(NotificationLite.i(t));
            this.i.drain();
        }

        @Override // com.baidu.tieba.koc
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        public goc h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.i;
            }
            return (goc) invokeV.objValue;
        }

        @Override // com.baidu.tieba.foc
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
            roc rocVar;
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
                            rocVar = this.j;
                            if (rocVar != null) {
                                try {
                                    rocVar.call();
                                } catch (Throwable th) {
                                    qoc.e(th);
                                    this.i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        rocVar = this.j;
                        if (rocVar != null) {
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
        public static final tpc<?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394845244, "Lcom/baidu/tieba/tpc$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394845244, "Lcom/baidu/tieba/tpc$b;");
                    return;
                }
            }
            a = new tpc<>();
        }
    }

    public tpc() {
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
        this.c = boc.b;
    }

    public static <T> tpc<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (tpc<T>) b.a;
        }
        return (tpc) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xoc
    /* renamed from: a */
    public koc<? super T> call(koc<? super T> kocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kocVar)) == null) {
            a aVar = new a(kocVar, this.a, this.b, this.c);
            kocVar.b(aVar);
            kocVar.f(aVar.h());
            return aVar;
        }
        return (koc) invokeL.objValue;
    }
}
