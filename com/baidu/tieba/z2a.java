package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e3a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes7.dex */
public class z2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* loaded from: classes7.dex */
    public interface f extends p3a<a3a> {
        @Override // com.baidu.tieba.p3a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e3a a;
        public final /* synthetic */ z2a b;

        /* loaded from: classes7.dex */
        public class a implements a3a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e3a.a a;
            public final /* synthetic */ a3a b;
            public final /* synthetic */ m5a c;

            /* renamed from: com.baidu.tieba.z2a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0499a implements o3a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0499a(a aVar) {
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

                @Override // com.baidu.tieba.o3a
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

            /* renamed from: com.baidu.tieba.z2a$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0500b implements o3a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Throwable a;
                public final /* synthetic */ a b;

                public C0500b(a aVar, Throwable th) {
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

                @Override // com.baidu.tieba.o3a
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

            public a(b bVar, e3a.a aVar, a3a a3aVar, m5a m5aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, a3aVar, m5aVar};
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
                this.b = a3aVar;
                this.c = m5aVar;
            }

            @Override // com.baidu.tieba.a3a
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b(new C0499a(this));
                }
            }

            @Override // com.baidu.tieba.a3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.a.b(new C0500b(this, th));
                }
            }

            @Override // com.baidu.tieba.a3a
            public void onSubscribe(i3a i3aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i3aVar) == null) {
                    this.c.a(i3aVar);
                }
            }
        }

        public b(z2a z2aVar, e3a e3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z2aVar, e3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z2aVar;
            this.a = e3aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z2a.f, com.baidu.tieba.p3a
        public void call(a3a a3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a3aVar) == null) {
                m5a m5aVar = new m5a();
                e3a.a createWorker = this.a.createWorker();
                m5aVar.a(createWorker);
                a3aVar.onSubscribe(m5aVar);
                this.b.j(new a(this, createWorker, a3aVar, m5aVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e3a a;
        public final /* synthetic */ z2a b;

        /* loaded from: classes7.dex */
        public class a implements o3a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a3a a;
            public final /* synthetic */ e3a.a b;
            public final /* synthetic */ e c;

            public a(e eVar, a3a a3aVar, e3a.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, a3aVar, aVar};
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
                this.a = a3aVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.o3a
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

        public e(z2a z2aVar, e3a e3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z2aVar, e3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z2aVar;
            this.a = e3aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z2a.f, com.baidu.tieba.p3a
        public void call(a3a a3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a3aVar) == null) {
                e3a.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, a3aVar, createWorker));
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
        @Override // com.baidu.tieba.z2a.f, com.baidu.tieba.p3a
        public void call(a3a a3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a3aVar) == null) {
                a3aVar.onSubscribe(y7a.c());
                a3aVar.onCompleted();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a3a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w7a a;

        public c(z2a z2aVar, w7a w7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z2aVar, w7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w7aVar;
        }

        @Override // com.baidu.tieba.a3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.a3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                i7a.j(th);
                this.a.unsubscribe();
                z2a.c(th);
            }
        }

        @Override // com.baidu.tieba.a3a
        public void onSubscribe(i3a i3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i3aVar) == null) {
                this.a.a(i3aVar);
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
        @Override // com.baidu.tieba.z2a.f, com.baidu.tieba.p3a
        public void call(a3a a3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, a3aVar) == null) {
                a3aVar.onSubscribe(y7a.c());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948309440, "Lcom/baidu/tieba/z2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948309440, "Lcom/baidu/tieba/z2a;");
                return;
            }
        }
        new z2a(new a(), false);
        new z2a(new d(), false);
    }

    public z2a(f fVar) {
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
        this.a = i7a.g(fVar);
    }

    public z2a(f fVar, boolean z) {
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
        this.a = z ? i7a.g(fVar) : fVar;
    }

    public static z2a a(Iterable<? extends z2a> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            e(iterable);
            return b(new CompletableOnSubscribeConcatIterable(iterable));
        }
        return (z2a) invokeL.objValue;
    }

    public static z2a b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            e(fVar);
            try {
                return new z2a(fVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                i7a.j(th);
                throw i(th);
            }
        }
        return (z2a) invokeL.objValue;
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

    public final z2a d(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e3aVar)) == null) {
            e(e3aVar);
            return b(new b(this, e3aVar));
        }
        return (z2a) invokeL.objValue;
    }

    public final void g(a3a a3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a3aVar) == null) {
            if (!(a3aVar instanceof b7a)) {
                a3aVar = new b7a(a3aVar);
            }
            j(a3aVar);
        }
    }

    public final z2a h(e3a e3aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e3aVar)) == null) {
            e(e3aVar);
            return b(new e(this, e3aVar));
        }
        return (z2a) invokeL.objValue;
    }

    public final void j(a3a a3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a3aVar) == null) {
            e(a3aVar);
            try {
                i7a.e(this, this.a).call(a3aVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                n3a.e(th);
                Throwable d2 = i7a.d(th);
                i7a.j(d2);
                throw i(d2);
            }
        }
    }

    public final i3a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            w7a w7aVar = new w7a();
            j(new c(this, w7aVar));
            return w7aVar;
        }
        return (i3a) invokeV.objValue;
    }
}
