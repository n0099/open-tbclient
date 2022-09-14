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
/* loaded from: classes6.dex */
public class uw9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public class a extends vw9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex9 b;
        public final /* synthetic */ ex9 c;

        public a(uw9 uw9Var, ex9 ex9Var, ex9 ex9Var2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw9Var, ex9Var, ex9Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex9Var;
            this.c = ex9Var2;
        }

        @Override // com.baidu.tieba.vw9
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

        @Override // com.baidu.tieba.vw9
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

    /* loaded from: classes6.dex */
    public class b implements ex9<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex9 a;

        public b(uw9 uw9Var, ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw9Var, ex9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ex9
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c<T> extends ex9<vw9<? super T>> {
        @Override // com.baidu.tieba.ex9
        /* synthetic */ void call(T t);
    }

    public uw9(c<T> cVar) {
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
        this.a = x0a.i(cVar);
    }

    public static <T> qw9<T> a(uw9<T> uw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uw9Var)) == null) ? qw9.a(new iy9(uw9Var.a)) : (qw9) invokeL.objValue;
    }

    public static <T> uw9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) ? new uw9<>(cVar) : (uw9) invokeL.objValue;
    }

    public static <T> uw9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) ? az9.m(t) : (uw9) invokeL.objValue;
    }

    public final uw9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) ? d(j, timeUnit, Schedulers.computation()) : (uw9) invokeJL.objValue;
    }

    public final uw9<T> d(long j, TimeUnit timeUnit, tw9 tw9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, tw9Var})) == null) ? b(new dy9(this.a, j, timeUnit, tw9Var)) : (uw9) invokeCommon.objValue;
    }

    public final uw9<T> e(ex9<Throwable> ex9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ex9Var)) == null) {
            if (ex9Var != null) {
                return b(new ey9(this, Actions.a(), new b(this, ex9Var)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (uw9) invokeL.objValue;
    }

    public final uw9<T> f(ex9<? super T> ex9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ex9Var)) == null) {
            if (ex9Var != null) {
                return b(new ey9(this, ex9Var, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (uw9) invokeL.objValue;
    }

    public final uw9<T> h(tw9 tw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tw9Var)) == null) {
            if (this instanceof az9) {
                return ((az9) this).n(tw9Var);
            }
            if (tw9Var != null) {
                return b(new hy9(this.a, tw9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (uw9) invokeL.objValue;
    }

    public final xw9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k(Actions.a(), Actions.b()) : (xw9) invokeV.objValue;
    }

    public final xw9 j(vw9<? super T> vw9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vw9Var)) == null) {
            if (vw9Var != null) {
                try {
                    x0a.t(this, this.a).call(vw9Var);
                    return x0a.s(vw9Var);
                } catch (Throwable th) {
                    cx9.e(th);
                    try {
                        vw9Var.b(x0a.r(th));
                        return n1a.b();
                    } catch (Throwable th2) {
                        cx9.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        x0a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (xw9) invokeL.objValue;
    }

    public final xw9 k(ex9<? super T> ex9Var, ex9<Throwable> ex9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, ex9Var, ex9Var2)) == null) {
            if (ex9Var != null) {
                if (ex9Var2 != null) {
                    return j(new a(this, ex9Var2, ex9Var));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (xw9) invokeLL.objValue;
    }

    public final qw9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(this) : (qw9) invokeV.objValue;
    }
}
