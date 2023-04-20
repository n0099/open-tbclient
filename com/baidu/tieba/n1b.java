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
/* loaded from: classes5.dex */
public class n1b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends b2b<t1b<? super T>> {
        @Override // com.baidu.tieba.b2b
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends f2b<t1b<? super R>, t1b<? super T>> {
        @Override // com.baidu.tieba.f2b
        /* synthetic */ R call(T t);
    }

    public n1b(a<T> aVar) {
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

    public static <T> n1b<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new n1b<>(u5b.h(aVar));
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> n1b<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> n1b<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> n1b<T> i(Iterable<? extends n1b<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> n1b<T> j(n1b<? extends n1b<? extends T>> n1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, n1bVar)) == null) {
            if (n1bVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) n1bVar).F(UtilityFunctions.b());
            }
            return (n1b<T>) n1bVar.g(OperatorMerge.a(false));
        }
        return (n1b) invokeL.objValue;
    }

    public final n1b<T> b(b2b<? super T> b2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2bVar)) == null) {
            return a(new m2b(this, new r3b(b2bVar, Actions.a(), Actions.a())));
        }
        return (n1b) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.f2b<? super T, ? extends com.baidu.tieba.n1b<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> n1b<R> d(f2b<? super T, ? extends n1b<? extends R>> f2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f2bVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(f2bVar);
            }
            return j(h(f2bVar));
        }
        return (n1b) invokeL.objValue;
    }

    public final <R> n1b<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new n2b(this.a, bVar));
        }
        return (n1b) invokeL.objValue;
    }

    public final <R> n1b<R> h(f2b<? super T, ? extends R> f2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2bVar)) == null) {
            return a(new o2b(this, f2bVar));
        }
        return (n1b) invokeL.objValue;
    }

    public final n1b<T> k(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, q1bVar)) == null) {
            return l(q1bVar, w3b.c);
        }
        return (n1b) invokeL.objValue;
    }

    public final l5b<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (l5b) invokeI.objValue;
    }

    public final u1b u(t1b<? super T> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, t1bVar)) == null) {
            return v(t1bVar, this);
        }
        return (u1b) invokeL.objValue;
    }

    public final u1b w(b2b<? super T> b2bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, b2bVar)) == null) {
            if (b2bVar != null) {
                return u(new s3b(b2bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (u1b) invokeL.objValue;
    }

    public final n1b<T> y(q1b q1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, q1bVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(q1bVar);
            }
            return a(new x2b(this, q1bVar));
        }
        return (n1b) invokeL.objValue;
    }

    public static <T> n1b<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (n1b) invokeV.objValue;
    }

    public final n1b<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (n1b<T>) g(u2b.a());
        }
        return (n1b) invokeV.objValue;
    }

    public final l5b<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (l5b) invokeV.objValue;
    }

    public final n1b<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return p2b.a(this);
        }
        return (n1b) invokeV.objValue;
    }

    public final u1b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new s3b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (u1b) invokeV.objValue;
    }

    public static <T> u1b v(t1b<? super T> t1bVar, n1b<T> n1bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, t1bVar, n1bVar)) == null) {
            if (t1bVar != null) {
                if (n1bVar.a != null) {
                    t1bVar.d();
                    if (!(t1bVar instanceof o5b)) {
                        t1bVar = new o5b(t1bVar);
                    }
                    try {
                        u5b.p(n1bVar, n1bVar.a).call(t1bVar);
                        return u5b.o(t1bVar);
                    } catch (Throwable th) {
                        z1b.e(th);
                        if (t1bVar.isUnsubscribed()) {
                            u5b.j(u5b.m(th));
                        } else {
                            try {
                                t1bVar.onError(u5b.m(th));
                            } catch (Throwable th2) {
                                z1b.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                u5b.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return k6b.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (u1b) invokeLL.objValue;
    }

    public final n1b<T> A(long j, TimeUnit timeUnit, n1b<? extends T> n1bVar, q1b q1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, n1bVar, q1bVar})) == null) {
            return (n1b<T>) g(new y2b(j, timeUnit, n1bVar, q1bVar));
        }
        return (n1b) invokeCommon.objValue;
    }

    public final l5b<T> q(int i, long j, TimeUnit timeUnit, q1b q1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, q1bVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, q1bVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (l5b) invokeCommon.objValue;
    }

    public final u1b B(t1b<? super T> t1bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t1bVar)) == null) {
            try {
                t1bVar.d();
                u5b.p(this, this.a).call(t1bVar);
                return u5b.o(t1bVar);
            } catch (Throwable th) {
                z1b.e(th);
                try {
                    t1bVar.onError(u5b.m(th));
                    return k6b.c();
                } catch (Throwable th2) {
                    z1b.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    u5b.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (u1b) invokeL.objValue;
    }

    public final n1b<T> l(q1b q1bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, q1bVar, i)) == null) {
            return m(q1bVar, false, i);
        }
        return (n1b) invokeLI.objValue;
    }

    public final n1b<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (n1b) invokeJL.objValue;
    }

    public final n1b<T> m(q1b q1bVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{q1bVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(q1bVar);
            }
            return (n1b<T>) g(new t2b(q1bVar, z, i));
        }
        return (n1b) invokeCommon.objValue;
    }

    public final l5b<T> r(long j, TimeUnit timeUnit, q1b q1bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, q1bVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, q1bVar);
        }
        return (l5b) invokeCommon.objValue;
    }

    public final u1b x(b2b<? super T> b2bVar, b2b<Throwable> b2bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, b2bVar, b2bVar2)) == null) {
            if (b2bVar != null) {
                if (b2bVar2 != null) {
                    return u(new s3b(b2bVar, b2bVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (u1b) invokeLL.objValue;
    }
}
