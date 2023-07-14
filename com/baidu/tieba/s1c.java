package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x1c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes7.dex */
public class s1c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* loaded from: classes7.dex */
    public interface f extends i2c<t1c> {
        @Override // com.baidu.tieba.i2c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x1c a;
        public final /* synthetic */ s1c b;

        /* loaded from: classes7.dex */
        public class a implements t1c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ x1c.a a;
            public final /* synthetic */ t1c b;
            public final /* synthetic */ l4c c;

            /* renamed from: com.baidu.tieba.s1c$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0475a implements h2c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0475a(a aVar) {
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

                @Override // com.baidu.tieba.h2c
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.a.b.onCompleted();
                        } finally {
                            this.a.c.unsubscribe();
                        }
                    }
                }
            }

            /* renamed from: com.baidu.tieba.s1c$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0476b implements h2c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Throwable a;
                public final /* synthetic */ a b;

                public C0476b(a aVar, Throwable th) {
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

                @Override // com.baidu.tieba.h2c
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.b.b.onError(this.a);
                        } finally {
                            this.b.c.unsubscribe();
                        }
                    }
                }
            }

            public a(b bVar, x1c.a aVar, t1c t1cVar, l4c l4cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, t1cVar, l4cVar};
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
                this.b = t1cVar;
                this.c = l4cVar;
            }

            @Override // com.baidu.tieba.t1c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b(new C0475a(this));
                }
            }

            @Override // com.baidu.tieba.t1c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.a.b(new C0476b(this, th));
                }
            }

            @Override // com.baidu.tieba.t1c
            public void onSubscribe(b2c b2cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2cVar) == null) {
                    this.c.a(b2cVar);
                }
            }
        }

        public b(s1c s1cVar, x1c x1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s1cVar, x1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s1cVar;
            this.a = x1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t1cVar) == null) {
                l4c l4cVar = new l4c();
                x1c.a createWorker = this.a.createWorker();
                l4cVar.a(createWorker);
                t1cVar.onSubscribe(l4cVar);
                this.b.j(new a(this, createWorker, t1cVar, l4cVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x1c a;
        public final /* synthetic */ s1c b;

        /* loaded from: classes7.dex */
        public class a implements h2c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t1c a;
            public final /* synthetic */ x1c.a b;
            public final /* synthetic */ e c;

            public a(e eVar, t1c t1cVar, x1c.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, t1cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = eVar;
                this.a = t1cVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.h2c
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.c.b.j(this.a);
                    } finally {
                        this.b.unsubscribe();
                    }
                }
            }
        }

        public e(s1c s1cVar, x1c x1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s1cVar, x1cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s1cVar;
            this.a = x1cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t1cVar) == null) {
                x1c.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, t1cVar, createWorker));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t1cVar) == null) {
                t1cVar.onSubscribe(x6c.c());
                t1cVar.onCompleted();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements t1c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v6c a;

        public c(s1c s1cVar, v6c v6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s1cVar, v6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v6cVar;
        }

        @Override // com.baidu.tieba.t1c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.t1c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                h6c.j(th);
                this.a.unsubscribe();
                s1c.c(th);
            }
        }

        @Override // com.baidu.tieba.t1c
        public void onSubscribe(b2c b2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2cVar) == null) {
                this.a.a(b2cVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s1c.f, com.baidu.tieba.i2c
        public void call(t1c t1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t1cVar) == null) {
                t1cVar.onSubscribe(x6c.c());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100004, "Lcom/baidu/tieba/s1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100004, "Lcom/baidu/tieba/s1c;");
                return;
            }
        }
        new s1c(new a(), false);
        new s1c(new d(), false);
    }

    public s1c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = h6c.g(fVar);
    }

    public s1c(f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = z ? h6c.g(fVar) : fVar;
    }

    public static s1c a(Iterable<? extends s1c> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            e(iterable);
            return b(new CompletableOnSubscribeConcatIterable(iterable));
        }
        return (s1c) invokeL.objValue;
    }

    public static s1c b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            e(fVar);
            try {
                return new s1c(fVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                h6c.j(th);
                throw i(th);
            }
        }
        return (s1c) invokeL.objValue;
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> T e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static NullPointerException i(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            return nullPointerException;
        }
        return (NullPointerException) invokeL.objValue;
    }

    public final s1c d(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x1cVar)) == null) {
            e(x1cVar);
            return b(new b(this, x1cVar));
        }
        return (s1c) invokeL.objValue;
    }

    public final void g(t1c t1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1cVar) == null) {
            if (!(t1cVar instanceof a6c)) {
                t1cVar = new a6c(t1cVar);
            }
            j(t1cVar);
        }
    }

    public final s1c h(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, x1cVar)) == null) {
            e(x1cVar);
            return b(new e(this, x1cVar));
        }
        return (s1c) invokeL.objValue;
    }

    public final void j(t1c t1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t1cVar) == null) {
            e(t1cVar);
            try {
                h6c.e(this, this.a).call(t1cVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                g2c.e(th);
                Throwable d2 = h6c.d(th);
                h6c.j(d2);
                throw i(d2);
            }
        }
    }

    public final b2c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            v6c v6cVar = new v6c();
            j(new c(this, v6cVar));
            return v6cVar;
        }
        return (b2c) invokeV.objValue;
    }
}
