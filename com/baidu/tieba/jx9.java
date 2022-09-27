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
public class jx9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes4.dex */
    public class a extends kx9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx9 b;
        public final /* synthetic */ tx9 c;

        public a(jx9 jx9Var, tx9 tx9Var, tx9 tx9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, tx9Var, tx9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx9Var;
            this.c = tx9Var2;
        }

        @Override // com.baidu.tieba.kx9
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

        @Override // com.baidu.tieba.kx9
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
    public class b implements tx9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx9 a;

        public b(jx9 jx9Var, tx9 tx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, tx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tx9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c<T> extends tx9<kx9<? super T>> {
        @Override // com.baidu.tieba.tx9
        /* synthetic */ void call(T t);
    }

    public jx9(c<T> cVar) {
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
        this.a = m1a.i(cVar);
    }

    public static <T> fx9<T> a(jx9<T> jx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jx9Var)) == null) ? fx9.a(new xy9(jx9Var.a)) : (fx9) invokeL.objValue;
    }

    public static <T> jx9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new jx9<>(cVar) : (jx9) invokeL.objValue;
    }

    public static <T> jx9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? pz9.m(t) : (jx9) invokeL.objValue;
    }

    public final jx9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (jx9) invokeJL.objValue;
    }

    public final jx9<T> d(long j, TimeUnit timeUnit, ix9 ix9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, ix9Var})) == null) ? b(new sy9(this.a, j, timeUnit, ix9Var)) : (jx9) invokeCommon.objValue;
    }

    public final jx9<T> e(tx9<Throwable> tx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tx9Var)) == null) {
            if (tx9Var != null) {
                return b(new ty9(this, Actions.a(), new b(this, tx9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (jx9) invokeL.objValue;
    }

    public final jx9<T> f(tx9<? super T> tx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tx9Var)) == null) {
            if (tx9Var != null) {
                return b(new ty9(this, tx9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (jx9) invokeL.objValue;
    }

    public final jx9<T> h(ix9 ix9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ix9Var)) == null) {
            if (this instanceof pz9) {
                return ((pz9) this).n(ix9Var);
            }
            if (ix9Var != null) {
                return b(new wy9(this.a, ix9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (jx9) invokeL.objValue;
    }

    public final mx9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (mx9) invokeV.objValue;
    }

    public final mx9 j(kx9<? super T> kx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kx9Var)) == null) {
            if (kx9Var != null) {
                try {
                    m1a.t(this, this.a).call(kx9Var);
                    return m1a.s(kx9Var);
                } catch (Throwable th) {
                    rx9.e(th);
                    try {
                        kx9Var.b(m1a.r(th));
                        return c2a.b();
                    } catch (Throwable th2) {
                        rx9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        m1a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (mx9) invokeL.objValue;
    }

    public final mx9 k(tx9<? super T> tx9Var, tx9<Throwable> tx9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tx9Var, tx9Var2)) == null) {
            if (tx9Var != null) {
                if (tx9Var2 != null) {
                    return j(new a(this, tx9Var2, tx9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (mx9) invokeLL.objValue;
    }

    public final fx9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (fx9) invokeV.objValue;
    }
}
