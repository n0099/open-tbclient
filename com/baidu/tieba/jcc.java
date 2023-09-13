package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sac;
import com.baidu.tieba.vac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class jcc<T> implements sac.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vac a;
    public final sac<T> b;

    /* loaded from: classes6.dex */
    public class a implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yac a;
        public final /* synthetic */ vac.a b;
        public final /* synthetic */ jcc c;

        /* renamed from: com.baidu.tieba.jcc$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0355a extends yac<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Thread e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.jcc$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0356a implements uac {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ uac a;
                public final /* synthetic */ C0355a b;

                /* renamed from: com.baidu.tieba.jcc$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes6.dex */
                public class C0357a implements fbc {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ C0356a b;

                    public C0357a(C0356a c0356a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0356a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0356a;
                        this.a = j;
                    }

                    @Override // com.baidu.tieba.fbc
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.b.a.request(this.a);
                        }
                    }
                }

                public C0356a(C0355a c0355a, uac uacVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0355a, uacVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0355a;
                    this.a = uacVar;
                }

                @Override // com.baidu.tieba.uac
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.b.e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.b.f.b.b(new C0357a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0355a(a aVar, yac yacVar, Thread thread) {
                super(yacVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, yacVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((yac) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.e = thread;
            }

            @Override // com.baidu.tieba.yac
            public void f(uac uacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, uacVar) == null) {
                    this.f.a.f(new C0356a(this, uacVar));
                }
            }

            @Override // com.baidu.tieba.tac
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

            @Override // com.baidu.tieba.tac
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f.a.onNext(t);
                }
            }

            @Override // com.baidu.tieba.tac
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

        public a(jcc jccVar, yac yacVar, vac.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jccVar, yacVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jccVar;
            this.a = yacVar;
            this.b = aVar;
        }

        @Override // com.baidu.tieba.fbc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.O(new C0355a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public jcc(sac<T> sacVar, vac vacVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sacVar, vacVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vacVar;
        this.b = sacVar;
    }

    public void call(yac<? super T> yacVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yacVar) == null) {
            vac.a createWorker = this.a.createWorker();
            yacVar.b(createWorker);
            createWorker.b(new a(this, yacVar, createWorker));
        }
    }

    @Override // com.baidu.tieba.sac.a, com.baidu.tieba.gbc
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yac) ((yac) obj));
    }
}
