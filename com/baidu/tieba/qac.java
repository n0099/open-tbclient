package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vac;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes7.dex */
public class qac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* loaded from: classes7.dex */
    public interface f extends gbc<rac> {
        @Override // com.baidu.tieba.gbc
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vac a;
        public final /* synthetic */ qac b;

        /* loaded from: classes7.dex */
        public class a implements rac {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vac.a a;
            public final /* synthetic */ rac b;
            public final /* synthetic */ kdc c;

            /* renamed from: com.baidu.tieba.qac$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0464a implements fbc {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0464a(a aVar) {
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

                @Override // com.baidu.tieba.fbc
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

            /* renamed from: com.baidu.tieba.qac$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0465b implements fbc {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Throwable a;
                public final /* synthetic */ a b;

                public C0465b(a aVar, Throwable th) {
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

                @Override // com.baidu.tieba.fbc
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

            public a(b bVar, vac.a aVar, rac racVar, kdc kdcVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aVar, racVar, kdcVar};
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
                this.b = racVar;
                this.c = kdcVar;
            }

            @Override // com.baidu.tieba.rac
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b(new C0464a(this));
                }
            }

            @Override // com.baidu.tieba.rac
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.a.b(new C0465b(this, th));
                }
            }

            @Override // com.baidu.tieba.rac
            public void onSubscribe(zac zacVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zacVar) == null) {
                    this.c.a(zacVar);
                }
            }
        }

        public b(qac qacVar, vac vacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qacVar, vacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qacVar;
            this.a = vacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, racVar) == null) {
                kdc kdcVar = new kdc();
                vac.a createWorker = this.a.createWorker();
                kdcVar.a(createWorker);
                racVar.onSubscribe(kdcVar);
                this.b.j(new a(this, createWorker, racVar, kdcVar));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vac a;
        public final /* synthetic */ qac b;

        /* loaded from: classes7.dex */
        public class a implements fbc {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rac a;
            public final /* synthetic */ vac.a b;
            public final /* synthetic */ e c;

            public a(e eVar, rac racVar, vac.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, racVar, aVar};
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
                this.a = racVar;
                this.b = aVar;
            }

            @Override // com.baidu.tieba.fbc
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

        public e(qac qacVar, vac vacVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qacVar, vacVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qacVar;
            this.a = vacVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, racVar) == null) {
                vac.a createWorker = this.a.createWorker();
                createWorker.b(new a(this, racVar, createWorker));
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
        @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, racVar) == null) {
                racVar.onSubscribe(wfc.c());
                racVar.onCompleted();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements rac {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ufc a;

        public c(qac qacVar, ufc ufcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qacVar, ufcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ufcVar;
        }

        @Override // com.baidu.tieba.rac
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.unsubscribe();
            }
        }

        @Override // com.baidu.tieba.rac
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                gfc.j(th);
                this.a.unsubscribe();
                qac.c(th);
            }
        }

        @Override // com.baidu.tieba.rac
        public void onSubscribe(zac zacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zacVar) == null) {
                this.a.a(zacVar);
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
        @Override // com.baidu.tieba.qac.f, com.baidu.tieba.gbc
        public void call(rac racVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, racVar) == null) {
                racVar.onSubscribe(wfc.c());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086550, "Lcom/baidu/tieba/qac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086550, "Lcom/baidu/tieba/qac;");
                return;
            }
        }
        new qac(new a(), false);
        new qac(new d(), false);
    }

    public qac(f fVar) {
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
        this.a = gfc.g(fVar);
    }

    public qac(f fVar, boolean z) {
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
        this.a = z ? gfc.g(fVar) : fVar;
    }

    public static qac a(Iterable<? extends qac> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            e(iterable);
            return b(new CompletableOnSubscribeConcatIterable(iterable));
        }
        return (qac) invokeL.objValue;
    }

    public static qac b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            e(fVar);
            try {
                return new qac(fVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                gfc.j(th);
                throw i(th);
            }
        }
        return (qac) invokeL.objValue;
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

    public final qac d(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vacVar)) == null) {
            e(vacVar);
            return b(new b(this, vacVar));
        }
        return (qac) invokeL.objValue;
    }

    public final void g(rac racVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, racVar) == null) {
            if (!(racVar instanceof zec)) {
                racVar = new zec(racVar);
            }
            j(racVar);
        }
    }

    public final qac h(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vacVar)) == null) {
            e(vacVar);
            return b(new e(this, vacVar));
        }
        return (qac) invokeL.objValue;
    }

    public final void j(rac racVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, racVar) == null) {
            e(racVar);
            try {
                gfc.e(this, this.a).call(racVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                ebc.e(th);
                Throwable d2 = gfc.d(th);
                gfc.j(d2);
                throw i(d2);
            }
        }
    }

    public final zac f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ufc ufcVar = new ufc();
            j(new c(this, ufcVar));
            return ufcVar;
        }
        return (zac) invokeV.objValue;
    }
}
