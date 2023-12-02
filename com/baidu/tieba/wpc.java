package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.doc;
import com.baidu.tieba.goc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class wpc<T> implements doc.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final goc a;
    public final doc<T> b;

    /* loaded from: classes8.dex */
    public class a implements qoc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ joc a;
        public final /* synthetic */ goc.a b;
        public final /* synthetic */ wpc c;

        /* renamed from: com.baidu.tieba.wpc$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0517a extends joc<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Thread e;
            public final /* synthetic */ a f;

            /* renamed from: com.baidu.tieba.wpc$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C0518a implements foc {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ foc a;
                public final /* synthetic */ C0517a b;

                /* renamed from: com.baidu.tieba.wpc$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public class C0519a implements qoc {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;
                    public final /* synthetic */ C0518a b;

                    public C0519a(C0518a c0518a, long j) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {c0518a, Long.valueOf(j)};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = c0518a;
                        this.a = j;
                    }

                    @Override // com.baidu.tieba.qoc
                    public void call() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            this.b.a.request(this.a);
                        }
                    }
                }

                public C0518a(C0517a c0517a, foc focVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0517a, focVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0517a;
                    this.a = focVar;
                }

                @Override // com.baidu.tieba.foc
                public void request(long j) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                        if (this.b.e == Thread.currentThread()) {
                            this.a.request(j);
                        } else {
                            this.b.f.b.b(new C0519a(this, j));
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0517a(a aVar, joc jocVar, Thread thread) {
                super(jocVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jocVar, thread};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((joc) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = aVar;
                this.e = thread;
            }

            @Override // com.baidu.tieba.joc
            public void f(foc focVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, focVar) == null) {
                    this.f.a.f(new C0518a(this, focVar));
                }
            }

            @Override // com.baidu.tieba.eoc
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

            @Override // com.baidu.tieba.eoc
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                    this.f.a.onNext(t);
                }
            }

            @Override // com.baidu.tieba.eoc
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

        public a(wpc wpcVar, joc jocVar, goc.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wpcVar, jocVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wpcVar;
            this.a = jocVar;
            this.b = aVar;
        }

        @Override // com.baidu.tieba.qoc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.b.O(new C0517a(this, this.a, Thread.currentThread()));
            }
        }
    }

    public wpc(doc<T> docVar, goc gocVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {docVar, gocVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gocVar;
        this.b = docVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.roc
    /* renamed from: a */
    public void call(joc<? super T> jocVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jocVar) == null) {
            goc.a createWorker = this.a.createWorker();
            jocVar.b(createWorker);
            createWorker.b(new a(this, jocVar, createWorker));
        }
    }
}
