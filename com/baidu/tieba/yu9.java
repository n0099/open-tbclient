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
public class yu9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes6.dex */
    public interface a<T> extends mv9<ev9<? super T>> {
        @Override // com.baidu.tieba.mv9
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends qv9<ev9<? super R>, ev9<? super T>> {
        @Override // com.baidu.tieba.qv9
        /* synthetic */ R call(T t);
    }

    public yu9(a<T> aVar) {
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

    public static <T> yu9<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? new yu9<>(fz9.h(aVar)) : (yu9) invokeL.objValue;
    }

    public static <T> yu9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? EmptyObservableHolder.instance() : (yu9) invokeV.objValue;
    }

    public static <T> yu9<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) ? a(new OnSubscribeFromIterable(iterable)) : (yu9) invokeL.objValue;
    }

    public static <T> yu9<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) ? ScalarSynchronousObservable.C(t) : (yu9) invokeL.objValue;
    }

    public static <T> yu9<T> i(Iterable<? extends yu9<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) ? j(e(iterable)) : (yu9) invokeL.objValue;
    }

    public static <T> yu9<T> j(yu9<? extends yu9<? extends T>> yu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, yu9Var)) == null) {
            if (yu9Var.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) yu9Var).F(UtilityFunctions.b());
            }
            return (yu9<T>) yu9Var.g(OperatorMerge.a(false));
        }
        return (yu9) invokeL.objValue;
    }

    public static <T> fv9 v(ev9<? super T> ev9Var, yu9<T> yu9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, ev9Var, yu9Var)) == null) {
            if (ev9Var != null) {
                if (yu9Var.a != null) {
                    ev9Var.d();
                    if (!(ev9Var instanceof zy9)) {
                        ev9Var = new zy9(ev9Var);
                    }
                    try {
                        fz9.p(yu9Var, yu9Var.a).call(ev9Var);
                        return fz9.o(ev9Var);
                    } catch (Throwable th) {
                        kv9.e(th);
                        if (ev9Var.isUnsubscribed()) {
                            fz9.j(fz9.m(th));
                        } else {
                            try {
                                ev9Var.onError(fz9.m(th));
                            } catch (Throwable th2) {
                                kv9.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                fz9.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return vz9.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (fv9) invokeLL.objValue;
    }

    public final yu9<T> A(long j, TimeUnit timeUnit, yu9<? extends T> yu9Var, bv9 bv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, yu9Var, bv9Var})) == null) ? (yu9<T>) g(new jw9(j, timeUnit, yu9Var, bv9Var)) : (yu9) invokeCommon.objValue;
    }

    public final fv9 B(ev9<? super T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ev9Var)) == null) {
            try {
                ev9Var.d();
                fz9.p(this, this.a).call(ev9Var);
                return fz9.o(ev9Var);
            } catch (Throwable th) {
                kv9.e(th);
                try {
                    ev9Var.onError(fz9.m(th));
                    return vz9.c();
                } catch (Throwable th2) {
                    kv9.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    fz9.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (fv9) invokeL.objValue;
    }

    public final yu9<T> b(mv9<? super T> mv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mv9Var)) == null) ? a(new xv9(this, new cx9(mv9Var, Actions.a(), Actions.a()))) : (yu9) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.qv9<? super T, ? extends com.baidu.tieba.yu9<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> yu9<R> d(qv9<? super T, ? extends yu9<? extends R>> qv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qv9Var)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(qv9Var);
            }
            return j(h(qv9Var));
        }
        return (yu9) invokeL.objValue;
    }

    public final <R> yu9<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) ? a(new yv9(this.a, bVar)) : (yu9) invokeL.objValue;
    }

    public final <R> yu9<R> h(qv9<? super T, ? extends R> qv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qv9Var)) == null) ? a(new zv9(this, qv9Var)) : (yu9) invokeL.objValue;
    }

    public final yu9<T> k(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bv9Var)) == null) ? l(bv9Var, hx9.c) : (yu9) invokeL.objValue;
    }

    public final yu9<T> l(bv9 bv9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, bv9Var, i)) == null) ? m(bv9Var, false, i) : (yu9) invokeLI.objValue;
    }

    public final yu9<T> m(bv9 bv9Var, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{bv9Var, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(bv9Var);
            }
            return (yu9<T>) g(new ew9(bv9Var, z, i));
        }
        return (yu9) invokeCommon.objValue;
    }

    public final yu9<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (yu9<T>) g(fw9.a()) : (yu9) invokeV.objValue;
    }

    public final wy9<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? OperatorReplay.D(this) : (wy9) invokeV.objValue;
    }

    public final wy9<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? OperatorReplay.E(this, i) : (wy9) invokeI.objValue;
    }

    public final wy9<T> q(int i, long j, TimeUnit timeUnit, bv9 bv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, bv9Var})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, bv9Var, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (wy9) invokeCommon.objValue;
    }

    public final wy9<T> r(long j, TimeUnit timeUnit, bv9 bv9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, bv9Var})) == null) ? OperatorReplay.F(this, j, timeUnit, bv9Var) : (wy9) invokeCommon.objValue;
    }

    public final yu9<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? aw9.a(this) : (yu9) invokeV.objValue;
    }

    public final fv9 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? u(new dx9(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a())) : (fv9) invokeV.objValue;
    }

    public final fv9 u(ev9<? super T> ev9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, ev9Var)) == null) ? v(ev9Var, this) : (fv9) invokeL.objValue;
    }

    public final fv9 w(mv9<? super T> mv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, mv9Var)) == null) {
            if (mv9Var != null) {
                return u(new dx9(mv9Var, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (fv9) invokeL.objValue;
    }

    public final fv9 x(mv9<? super T> mv9Var, mv9<Throwable> mv9Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, mv9Var, mv9Var2)) == null) {
            if (mv9Var != null) {
                if (mv9Var2 != null) {
                    return u(new dx9(mv9Var, mv9Var2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (fv9) invokeLL.objValue;
    }

    public final yu9<T> y(bv9 bv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, bv9Var)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(bv9Var);
            }
            return a(new iw9(this, bv9Var));
        }
        return (yu9) invokeL.objValue;
    }

    public final yu9<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) ? A(j, timeUnit, null, Schedulers.computation()) : (yu9) invokeJL.objValue;
    }
}
