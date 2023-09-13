package com.baidu.tieba;

import com.baidu.tieba.vac;
import com.baidu.tieba.wac;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class jdc<T> extends wac<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes6.dex */
    public class a implements wac.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;

        public a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }

        public void call(xac<? super T> xacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
                xacVar.c((Object) this.a);
            }
        }

        @Override // com.baidu.tieba.wac.c, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xac) ((xac) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements wac.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ucc a;
        public final T b;

        public b(ucc uccVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uccVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uccVar;
            this.b = t;
        }

        public void call(xac<? super T> xacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
                xacVar.a(this.a.a(new d(xacVar, this.b)));
            }
        }

        @Override // com.baidu.tieba.wac.c, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xac) ((xac) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<T> implements wac.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final vac a;
        public final T b;

        public c(vac vacVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vacVar, t};
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
            this.b = t;
        }

        public void call(xac<? super T> xacVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xacVar) == null) {
                vac.a createWorker = this.a.createWorker();
                xacVar.a(createWorker);
                createWorker.b(new d(xacVar, this.b));
            }
        }

        @Override // com.baidu.tieba.wac.c, com.baidu.tieba.gbc
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xac) ((xac) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class d<T> implements fbc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final xac<? super T> a;
        public final T b;

        public d(xac<? super T> xacVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xacVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xacVar;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.baidu.tieba.fbc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.c((T) this.b);
                } catch (Throwable th) {
                    this.a.b(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jdc(T t) {
        super(new a(t));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wac.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> jdc<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            return new jdc<>(t);
        }
        return (jdc) invokeL.objValue;
    }

    public wac<T> n(vac vacVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vacVar)) == null) {
            if (vacVar instanceof ucc) {
                return wac.b(new b((ucc) vacVar, this.b));
            }
            return wac.b(new c(vacVar, this.b));
        }
        return (wac) invokeL.objValue;
    }
}
