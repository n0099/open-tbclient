package com.baidu.tieba;

import com.baidu.tieba.jz9;
import com.baidu.tieba.kz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class q1a<T> extends kz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes5.dex */
    public class a implements kz9.c<T> {
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

        public void call(lz9<? super T> lz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lz9Var) == null) {
                lz9Var.c((Object) this.a);
            }
        }

        @Override // com.baidu.tieba.kz9.c, com.baidu.tieba.uz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((lz9) ((lz9) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<T> implements kz9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b1a a;
        public final T b;

        public b(b1a b1aVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b1aVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b1aVar;
            this.b = t;
        }

        public void call(lz9<? super T> lz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lz9Var) == null) {
                lz9Var.a(this.a.a(new d(lz9Var, this.b)));
            }
        }

        @Override // com.baidu.tieba.kz9.c, com.baidu.tieba.uz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((lz9) ((lz9) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class c<T> implements kz9.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jz9 a;
        public final T b;

        public c(jz9 jz9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz9Var;
            this.b = t;
        }

        public void call(lz9<? super T> lz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lz9Var) == null) {
                jz9.a createWorker = this.a.createWorker();
                lz9Var.a(createWorker);
                createWorker.b(new d(lz9Var, this.b));
            }
        }

        @Override // com.baidu.tieba.kz9.c, com.baidu.tieba.uz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((lz9) ((lz9) obj));
        }
    }

    /* loaded from: classes5.dex */
    public static final class d<T> implements tz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lz9<? super T> a;
        public final T b;

        public d(lz9<? super T> lz9Var, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz9Var, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz9Var;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.baidu.tieba.tz9
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
    public q1a(T t) {
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
                super((kz9.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> q1a<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            return new q1a<>(t);
        }
        return (q1a) invokeL.objValue;
    }

    public kz9<T> n(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jz9Var)) == null) {
            if (jz9Var instanceof b1a) {
                return kz9.b(new b((b1a) jz9Var, this.b));
            }
            return kz9.b(new c(jz9Var, this.b));
        }
        return (kz9) invokeL.objValue;
    }
}
