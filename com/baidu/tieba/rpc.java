package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.tieba.goc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public final class rpc<T> implements doc.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final goc a;
    public final boolean b;
    public final int c;

    /* loaded from: classes8.dex */
    public static final class a<T> extends joc<T> implements qoc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final joc<? super T> e;
        public final goc.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.baidu.tieba.rpc$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0462a implements foc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0462a(a aVar) {
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

            @Override // com.baidu.tieba.foc
            public void request(long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                    cpc.b(this.a.k, j);
                    this.a.i();
                }
            }
        }

        public a(goc gocVar, joc<? super T> jocVar, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gocVar, jocVar, Boolean.valueOf(z), Integer.valueOf(i)};
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
            this.e = jocVar;
            this.f = gocVar.createWorker();
            this.g = z;
            i = i <= 0 ? vqc.c : i;
            this.i = i - (i >> 2);
            if (jsc.b()) {
                this.h = new vrc(i);
            } else {
                this.h = new arc(i);
            }
            e(i);
        }

        public boolean g(boolean z, boolean z2, joc<? super T> jocVar, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jocVar, queue})) == null) {
                if (jocVar.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    jocVar.onError(th);
                                } else {
                                    jocVar.onCompleted();
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
                            jocVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            jocVar.onCompleted();
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

        @Override // com.baidu.tieba.qoc
        public void call() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                joc<? super T> jocVar = this.e;
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
                        if (g(z2, z, jocVar, queue)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        jocVar.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = cpc.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), jocVar, queue)) {
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
                joc<? super T> jocVar = this.e;
                jocVar.f(new C0462a(this));
                jocVar.b(this.f);
                jocVar.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !isUnsubscribed() && !this.j) {
                this.j = true;
                i();
            }
        }

        @Override // com.baidu.tieba.eoc
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                tsc.j(th);
            }
        }

        @Override // com.baidu.tieba.eoc
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

    public rpc(goc gocVar, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gocVar, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gocVar;
        this.b = z;
        this.c = i <= 0 ? vqc.c : i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.woc
    /* renamed from: a */
    public joc<? super T> call(joc<? super T> jocVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jocVar)) == null) {
            goc gocVar = this.a;
            if (gocVar instanceof kqc) {
                return jocVar;
            }
            if (gocVar instanceof pqc) {
                return jocVar;
            }
            a aVar = new a(gocVar, jocVar, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (joc) invokeL.objValue;
    }
}
