package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class kz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public interface c<T> extends uz9<lz9<? super T>> {
        @Override // com.baidu.tieba.uz9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes4.dex */
    public class a extends lz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz9 b;
        public final /* synthetic */ uz9 c;

        public a(kz9 kz9Var, uz9 uz9Var, uz9 uz9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz9Var, uz9Var, uz9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz9Var;
            this.c = uz9Var2;
        }

        @Override // com.baidu.tieba.lz9
        public final void b(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                try {
                    this.b.call(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.lz9
        public final void c(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                try {
                    this.c.call(t);
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements uz9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz9 a;

        public b(kz9 kz9Var, uz9 uz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz9Var, uz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uz9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public kz9(c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n3a.i(cVar);
    }

    public final kz9<T> h(jz9 jz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jz9Var)) == null) {
            if (this instanceof q1a) {
                return ((q1a) this).n(jz9Var);
            }
            if (jz9Var != null) {
                return b(new x0a(this.a, jz9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (kz9) invokeL.objValue;
    }

    public static <T> gz9<T> a(kz9<T> kz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kz9Var)) == null) {
            return gz9.a(new y0a(kz9Var.a));
        }
        return (gz9) invokeL.objValue;
    }

    public static <T> kz9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new kz9<>(cVar);
        }
        return (kz9) invokeL.objValue;
    }

    public static <T> kz9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return q1a.m(t);
        }
        return (kz9) invokeL.objValue;
    }

    public final kz9<T> e(uz9<Throwable> uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uz9Var)) == null) {
            if (uz9Var != null) {
                return b(new u0a(this, Actions.a(), new b(this, uz9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (kz9) invokeL.objValue;
    }

    public final kz9<T> f(uz9<? super T> uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uz9Var)) == null) {
            if (uz9Var != null) {
                return b(new u0a(this, uz9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (kz9) invokeL.objValue;
    }

    public final kz9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (kz9) invokeJL.objValue;
    }

    public final nz9 k(uz9<? super T> uz9Var, uz9<Throwable> uz9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, uz9Var, uz9Var2)) == null) {
            if (uz9Var != null) {
                if (uz9Var2 != null) {
                    return j(new a(this, uz9Var2, uz9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (nz9) invokeLL.objValue;
    }

    public final kz9<T> d(long j, TimeUnit timeUnit, jz9 jz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, jz9Var})) == null) {
            return b(new t0a(this.a, j, timeUnit, jz9Var));
        }
        return (kz9) invokeCommon.objValue;
    }

    public final nz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (nz9) invokeV.objValue;
    }

    public final gz9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (gz9) invokeV.objValue;
    }

    public final nz9 j(lz9<? super T> lz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, lz9Var)) == null) {
            if (lz9Var != null) {
                try {
                    n3a.t(this, this.a).call(lz9Var);
                    return n3a.s(lz9Var);
                } catch (Throwable th) {
                    sz9.e(th);
                    try {
                        lz9Var.b(n3a.r(th));
                        return d4a.b();
                    } catch (Throwable th2) {
                        sz9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        n3a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (nz9) invokeL.objValue;
    }
}
