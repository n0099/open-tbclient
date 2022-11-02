package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gz9;
import com.baidu.tieba.jz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes5.dex */
public final class m0a<T> implements gz9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jz9 a;
    public final boolean b;
    public final int c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends mz9<T> implements tz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final mz9<? super T> e;
        public final jz9.a f;
        public final boolean g;
        public final Queue<Object> h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k;
        public final AtomicLong l;
        public Throwable m;
        public long n;

        /* renamed from: com.baidu.tieba.m0a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0342a implements iz9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0342a(a aVar) {
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

            @Override // com.baidu.tieba.iz9
            public void request(long j) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
                    b0a.b(this.a.k, j);
                    this.a.i();
                }
            }
        }

        public a(jz9 jz9Var, mz9<? super T> mz9Var, boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz9Var, mz9Var, Boolean.valueOf(z), Integer.valueOf(i)};
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
            this.e = mz9Var;
            this.f = jz9Var.createWorker();
            this.g = z;
            i = i <= 0 ? p1a.c : i;
            this.i = i - (i >> 2);
            if (d3a.b()) {
                this.h = new p2a(i);
            } else {
                this.h = new u1a(i);
            }
            e(i);
        }

        public boolean g(boolean z, boolean z2, mz9<? super T> mz9Var, Queue<Object> queue) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), mz9Var, queue})) == null) {
                if (mz9Var.isUnsubscribed()) {
                    queue.clear();
                    return true;
                } else if (z) {
                    if (this.g) {
                        if (z2) {
                            Throwable th = this.m;
                            try {
                                if (th != null) {
                                    mz9Var.onError(th);
                                } else {
                                    mz9Var.onCompleted();
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
                            mz9Var.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            mz9Var.onCompleted();
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

        @Override // com.baidu.tieba.tz9
        public void call() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long j = this.n;
                Queue<Object> queue = this.h;
                mz9<? super T> mz9Var = this.e;
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
                        if (g(z2, z, mz9Var, queue)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        mz9Var.onNext((Object) NotificationLite.e(poll));
                        j++;
                        if (j == this.i) {
                            j3 = b0a.g(this.k, j);
                            e(j);
                            j = 0;
                        }
                    }
                    if (i == 0 && g(this.j, queue.isEmpty(), mz9Var, queue)) {
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
                mz9<? super T> mz9Var = this.e;
                mz9Var.f(new C0342a(this));
                mz9Var.b(this.f);
                mz9Var.b(this);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.l.getAndIncrement() == 0) {
                this.f.b(this);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !isUnsubscribed() && !this.j) {
                this.j = true;
                i();
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (!isUnsubscribed() && !this.j) {
                    this.m = th;
                    this.j = true;
                    i();
                    return;
                }
                n3a.j(th);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && !isUnsubscribed() && !this.j) {
                if (!this.h.offer(NotificationLite.h(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    i();
                }
            }
        }
    }

    public m0a(jz9 jz9Var, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jz9Var, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jz9Var;
        this.b = z;
        this.c = i <= 0 ? p1a.c : i;
    }

    public mz9<? super T> call(mz9<? super T> mz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mz9Var)) == null) {
            jz9 jz9Var = this.a;
            if (jz9Var instanceof e1a) {
                return mz9Var;
            }
            if (jz9Var instanceof j1a) {
                return mz9Var;
            }
            a aVar = new a(jz9Var, mz9Var, this.b, this.c);
            aVar.h();
            return aVar;
        }
        return (mz9) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gz9.b, com.baidu.tieba.yz9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((mz9) ((mz9) obj));
    }
}
