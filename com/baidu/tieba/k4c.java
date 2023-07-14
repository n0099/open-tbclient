package com.baidu.tieba;

import com.baidu.tieba.x1c;
import com.baidu.tieba.y1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class k4c<T> extends y1c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T b;

    /* loaded from: classes6.dex */
    public class a implements y1c.c<T> {
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

        public void call(z1c<? super T> z1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
                z1cVar.c((Object) this.a);
            }
        }

        @Override // com.baidu.tieba.y1c.c, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((z1c) ((z1c) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements y1c.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final v3c a;
        public final T b;

        public b(v3c v3cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v3cVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v3cVar;
            this.b = t;
        }

        public void call(z1c<? super T> z1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
                z1cVar.a(this.a.a(new d(z1cVar, this.b)));
            }
        }

        @Override // com.baidu.tieba.y1c.c, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((z1c) ((z1c) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class c<T> implements y1c.c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final x1c a;
        public final T b;

        public c(x1c x1cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x1cVar, t};
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
            this.b = t;
        }

        public void call(z1c<? super T> z1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z1cVar) == null) {
                x1c.a createWorker = this.a.createWorker();
                z1cVar.a(createWorker);
                createWorker.b(new d(z1cVar, this.b));
            }
        }

        @Override // com.baidu.tieba.y1c.c, com.baidu.tieba.i2c
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((z1c) ((z1c) obj));
        }
    }

    /* loaded from: classes6.dex */
    public static final class d<T> implements h2c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final z1c<? super T> a;
        public final T b;

        public d(z1c<? super T> z1cVar, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1cVar, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z1cVar;
            this.b = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // com.baidu.tieba.h2c
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
    public k4c(T t) {
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
                super((y1c.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = t;
    }

    public static <T> k4c<T> m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) {
            return new k4c<>(t);
        }
        return (k4c) invokeL.objValue;
    }

    public y1c<T> n(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x1cVar)) == null) {
            if (x1cVar instanceof v3c) {
                return y1c.b(new b((v3c) x1cVar, this.b));
            }
            return y1c.b(new c(x1cVar, this.b));
        }
        return (y1c) invokeL.objValue;
    }
}
