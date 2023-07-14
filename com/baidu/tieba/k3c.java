package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u1c;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class k3c<T> implements u1c.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x1c a;
    public final u1c<T> b;

    /* loaded from: classes6.dex */
    public class a implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a2c a;
        public final /* synthetic */ x1c.a b;
        public final /* synthetic */ k3c c;

        /* renamed from: com.baidu.tieba.k3c$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0366a extends a2c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Thread e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.k3c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0367a implements w1c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ w1c a;
                public final /* synthetic */ C0366a b;

                /* renamed from: com.baidu.tieba.k3c$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class C0368a implements h2c {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ C0367a b;

                    public C0368a(C0367a c0367a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0367a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0367a;
                        this.a = j;
                    }

                    @Override // com.baidu.tieba.h2c
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.b.a.request(this.a);
                        }
                    }
                }

                public C0367a(C0366a c0366a, w1c w1cVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0366a, w1cVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0366a;
                    this.a = w1cVar;
                }

                @Override // com.baidu.tieba.w1c
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.b.e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.b.f.b.b(new C0368a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0366a(a aVar, a2c a2cVar, Thread thread) {
                super(a2cVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, a2cVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((a2c) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.e = thread;
            }

            @Override // com.baidu.tieba.a2c
            public void f(w1c w1cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, w1cVar) == null) {
                    this.f.a.f(new C0367a(this, w1cVar));
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    try {
                        this.f.a.onError(th);
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f.a.onNext(t);
                }
            }

            @Override // com.baidu.tieba.v1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        this.f.a.onCompleted();
                    } finally {
                        this.f.b.unsubscribe();
                    }
                }
            }
        }

        public a(k3c k3cVar, a2c a2cVar, x1c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k3cVar, a2cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k3cVar;
            this.a = a2cVar;
            this.b = aVar;
        }

        @Override // com.baidu.tieba.h2c
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.O(new C0366a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public k3c(u1c<T> u1cVar, x1c x1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1cVar, x1cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = x1cVar;
        this.b = u1cVar;
    }

    public void call(a2c<? super T> a2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a2cVar) == null) {
            x1c.a createWorker = this.a.createWorker();
            a2cVar.b(createWorker);
            createWorker.b(new a(this, a2cVar, createWorker));
        }
    }

    @Override // com.baidu.tieba.u1c.a, com.baidu.tieba.i2c
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((a2c) ((a2c) obj));
    }
}
