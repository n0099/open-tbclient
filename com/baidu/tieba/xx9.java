package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class xx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* loaded from: classes6.dex */
    public interface a extends ly9 {
        @Override // com.baidu.tieba.ly9
        /* synthetic */ void call(Object obj);
    }

    /* loaded from: classes6.dex */
    public interface b extends py9 {
        @Override // com.baidu.tieba.py9
        /* synthetic */ Object call(Object obj);
    }

    public xx9(a aVar) {
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

    public static xx9 a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new xx9(e2a.h(aVar));
        }
        return (xx9) invokeL.objValue;
    }

    public static xx9 e(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (xx9) invokeL.objValue;
    }

    public static xx9 f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            return ScalarSynchronousObservable.C(obj);
        }
        return (xx9) invokeL.objValue;
    }

    public static xx9 i(Iterable iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (xx9) invokeL.objValue;
    }

    public static xx9 j(xx9 xx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xx9Var)) == null) {
            if (xx9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) xx9Var).F(UtilityFunctions.b());
            }
            return xx9Var.g(OperatorMerge.a(false));
        }
        return (xx9) invokeL.objValue;
    }

    public final xx9 b(ly9 ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ly9Var)) == null) {
            return a(new wy9(this, new b0a(ly9Var, Actions.a(), Actions.a())));
        }
        return (xx9) invokeL.objValue;
    }

    public final xx9 d(py9 py9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, py9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(py9Var);
            }
            return j(h(py9Var));
        }
        return (xx9) invokeL.objValue;
    }

    public final xx9 g(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new xy9(this.a, bVar));
        }
        return (xx9) invokeL.objValue;
    }

    public final xx9 h(py9 py9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, py9Var)) == null) {
            return a(new yy9(this, py9Var));
        }
        return (xx9) invokeL.objValue;
    }

    public final xx9 k(ay9 ay9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ay9Var)) == null) {
            return l(ay9Var, g0a.c);
        }
        return (xx9) invokeL.objValue;
    }

    public final v1a p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (v1a) invokeI.objValue;
    }

    public final ey9 u(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dy9Var)) == null) {
            return v(dy9Var, this);
        }
        return (ey9) invokeL.objValue;
    }

    public final ey9 w(ly9 ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ly9Var)) == null) {
            if (ly9Var != null) {
                return u(new c0a(ly9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ey9) invokeL.objValue;
    }

    public final xx9 y(ay9 ay9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, ay9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(ay9Var);
            }
            return a(new hz9(this, ay9Var));
        }
        return (xx9) invokeL.objValue;
    }

    public static xx9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (xx9) invokeV.objValue;
    }

    public final xx9 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return g(ez9.a());
        }
        return (xx9) invokeV.objValue;
    }

    public final v1a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (v1a) invokeV.objValue;
    }

    public final xx9 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return zy9.a(this);
        }
        return (xx9) invokeV.objValue;
    }

    public final ey9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new c0a(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (ey9) invokeV.objValue;
    }

    public static ey9 v(dy9 dy9Var, xx9 xx9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, dy9Var, xx9Var)) == null) {
            if (dy9Var != null) {
                if (xx9Var.a != null) {
                    dy9Var.d();
                    if (!(dy9Var instanceof y1a)) {
                        dy9Var = new y1a(dy9Var);
                    }
                    try {
                        e2a.p(xx9Var, xx9Var.a).call(dy9Var);
                        return e2a.o(dy9Var);
                    } catch (Throwable th) {
                        jy9.e(th);
                        if (dy9Var.isUnsubscribed()) {
                            e2a.j(e2a.m(th));
                        } else {
                            try {
                                dy9Var.onError(e2a.m(th));
                            } catch (Throwable th2) {
                                jy9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                e2a.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return u2a.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (ey9) invokeLL.objValue;
    }

    public final xx9 A(long j, TimeUnit timeUnit, xx9 xx9Var, ay9 ay9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, xx9Var, ay9Var})) == null) {
            return g(new iz9(j, timeUnit, xx9Var, ay9Var));
        }
        return (xx9) invokeCommon.objValue;
    }

    public final v1a q(int i, long j, TimeUnit timeUnit, ay9 ay9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, ay9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, ay9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (v1a) invokeCommon.objValue;
    }

    public final ey9 B(dy9 dy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dy9Var)) == null) {
            try {
                dy9Var.d();
                e2a.p(this, this.a).call(dy9Var);
                return e2a.o(dy9Var);
            } catch (Throwable th) {
                jy9.e(th);
                try {
                    dy9Var.onError(e2a.m(th));
                    return u2a.c();
                } catch (Throwable th2) {
                    jy9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    e2a.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (ey9) invokeL.objValue;
    }

    public final xx9 l(ay9 ay9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, ay9Var, i)) == null) {
            return m(ay9Var, false, i);
        }
        return (xx9) invokeLI.objValue;
    }

    public final xx9 z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (xx9) invokeJL.objValue;
    }

    public final xx9 m(ay9 ay9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{ay9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(ay9Var);
            }
            return g(new dz9(ay9Var, z, i));
        }
        return (xx9) invokeCommon.objValue;
    }

    public final v1a r(long j, TimeUnit timeUnit, ay9 ay9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, ay9Var})) == null) {
            return OperatorReplay.F(this, j, timeUnit, ay9Var);
        }
        return (v1a) invokeCommon.objValue;
    }

    public final ey9 x(ly9 ly9Var, ly9 ly9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, ly9Var, ly9Var2)) == null) {
            if (ly9Var != null) {
                if (ly9Var2 != null) {
                    return u(new c0a(ly9Var, ly9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (ey9) invokeLL.objValue;
    }
}
