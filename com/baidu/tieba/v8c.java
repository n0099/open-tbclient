package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7c;
import com.baidu.tieba.q7c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class v8c<T> implements n7c.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final TimeUnit b;
    public final q7c c;

    /* loaded from: classes8.dex */
    public class a extends t7c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean e;
        public final /* synthetic */ q7c.a f;
        public final /* synthetic */ t7c g;
        public final /* synthetic */ v8c h;

        /* renamed from: com.baidu.tieba.v8c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0496a implements a8c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0496a(a aVar) {
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

            @Override // com.baidu.tieba.a8c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    if (!aVar.e) {
                        aVar.e = true;
                        aVar.g.onCompleted();
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements a8c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;
            public final /* synthetic */ a b;

            public b(a aVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = th;
            }

            @Override // com.baidu.tieba.a8c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    if (!aVar.e) {
                        aVar.e = true;
                        aVar.g.onError(this.a);
                        this.b.f.unsubscribe();
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements a8c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Object a;
            public final /* synthetic */ a b;

            public c(a aVar, Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = obj;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.baidu.tieba.t7c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.a8c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    if (!aVar.e) {
                        aVar.g.onNext(this.a);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v8c v8cVar, t7c t7cVar, q7c.a aVar, t7c t7cVar2) {
            super(t7cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v8cVar, t7cVar, aVar, t7cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t7c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = v8cVar;
            this.f = aVar;
            this.g = t7cVar2;
        }

        @Override // com.baidu.tieba.o7c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q7c.a aVar = this.f;
                C0496a c0496a = new C0496a(this);
                v8c v8cVar = this.h;
                aVar.c(c0496a, v8cVar.a, v8cVar.b);
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f.b(new b(this, th));
            }
        }

        @Override // com.baidu.tieba.o7c
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                q7c.a aVar = this.f;
                c cVar = new c(this, t);
                v8c v8cVar = this.h;
                aVar.c(cVar, v8cVar.a, v8cVar.b);
            }
        }
    }

    public v8c(long j, TimeUnit timeUnit, q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, q7cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = timeUnit;
        this.c = q7cVar;
    }

    public t7c<? super T> call(t7c<? super T> t7cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t7cVar)) == null) {
            q7c.a createWorker = this.c.createWorker();
            t7cVar.b(createWorker);
            return new a(this, t7cVar, createWorker, t7cVar);
        }
        return (t7c) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n7c.b, com.baidu.tieba.g8c
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((t7c) ((t7c) obj));
    }
}
