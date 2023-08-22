package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class z8c<T> implements n7c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q7c a;
    public final boolean b;
    public final int c;

    /* loaded from: classes9.dex */
    public static final class a<T> extends t7c<T> implements a8c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t7c<? super T> e;
        public final q7c.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.baidu.tieba.z8c$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0552a implements p7c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0552a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.p7c
            public void request(long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                    k8c.b(this.a.k, j);
                    this.a.i();
                }
            }
        }

        public a(q7c q7cVar, t7c<? super T> t7cVar, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q7cVar, t7cVar, Boolean.valueOf(z), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new AtomicLong();
            this.l = new AtomicLong();
            this.e = t7cVar;
            this.f = q7cVar.createWorker();
            this.g = z;
            i = i <= 0 ? dac.c : i;
            this.i = i - (i >> 2);
            if (rbc.b()) {
                this.h = new dbc(i);
            } else {
                this.h = new iac(i);
            }
            e(i);
        }

        public boolean g(boolean z, boolean z2, t7c<? super T> t7cVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), t7cVar, queue})) == null) {
                if (t7cVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    t7cVar.onError(th);
                                } else {
                                    t7cVar.onCompleted();
                                }
                                return false;
                            } finally {
                            }
                        }
                        return false;
                    }
                    Throwable th2 = this.m;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            t7cVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            t7cVar.onCompleted();
                            return true;
                        } finally {
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.tieba.a8c
        public void call() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                t7c<? super T> t7cVar = this.e;
                long j2 = 1;
                do {
                    long j3 = this.k.get();
                    while (true) {
                        i = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z2 = this.j;
                        Object poll = queue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (g(z2, z, t7cVar, queue)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        t7cVar.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = k8c.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), t7cVar, queue)) {
                        return;
                    }
                    this.n = j;
                    j2 = this.l.addAndGet(-j2);
                } while (j2 != 0);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                t7c<? super T> t7cVar = this.e;
                t7cVar.f(new C0552a(this));
                t7cVar.b(this.f);
                t7cVar.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !isUnsubscribed() && !this.j) {
                this.j = true;
                i();
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                bcc.j(th);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && !isUnsubscribed() && !this.j) {
                if (!this.h.offer(NotificationLite.i(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    i();
                }
            }
        }
    }

    public z8c(q7c q7cVar, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q7cVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q7cVar;
        this.b = z;
        this.c = i <= 0 ? dac.c : i;
    }

    public t7c<? super T> call(t7c<? super T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t7cVar)) == null) {
            q7c q7cVar = this.a;
            if (q7cVar instanceof s9c) {
                return t7cVar;
            }
            if (q7cVar instanceof x9c) {
                return t7cVar;
            }
            a aVar = new a(q7cVar, t7cVar, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (t7c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n7c.b, com.baidu.tieba.g8c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((t7c) ((t7c) obj));
    }
}
