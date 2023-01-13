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
public class k8a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<T> a;

    /* loaded from: classes5.dex */
    public interface a<T> extends y8a<q8a<? super T>> {
        @Override // com.baidu.tieba.y8a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes5.dex */
    public interface b<R, T> extends c9a<q8a<? super R>, q8a<? super T>> {
        @Override // com.baidu.tieba.c9a
        /* synthetic */ R call(T t);
    }

    public k8a(a<T> aVar) {
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

    public static <T> k8a<T> a(a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return new k8a<>(rca.h(aVar));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> k8a<T> e(Iterable<? extends T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            return a(new OnSubscribeFromIterable(iterable));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> k8a<T> f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, t)) == null) {
            return ScalarSynchronousObservable.C(t);
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> k8a<T> i(Iterable<? extends k8a<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iterable)) == null) {
            return j(e(iterable));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> k8a<T> j(k8a<? extends k8a<? extends T>> k8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, k8aVar)) == null) {
            if (k8aVar.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) k8aVar).F(UtilityFunctions.b());
            }
            return (k8a<T>) k8aVar.g(OperatorMerge.a(false));
        }
        return (k8a) invokeL.objValue;
    }

    public final k8a<T> b(y8a<? super T> y8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y8aVar)) == null) {
            return a(new j9a(this, new oaa(y8aVar, Actions.a(), Actions.a())));
        }
        return (k8a) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.c9a<? super T, ? extends com.baidu.tieba.k8a<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> k8a<R> d(c9a<? super T, ? extends k8a<? extends R>> c9aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, c9aVar)) == null) {
            if (getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) this).F(c9aVar);
            }
            return j(h(c9aVar));
        }
        return (k8a) invokeL.objValue;
    }

    public final <R> k8a<R> g(b<? extends R, ? super T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            return a(new k9a(this.a, bVar));
        }
        return (k8a) invokeL.objValue;
    }

    public final <R> k8a<R> h(c9a<? super T, ? extends R> c9aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c9aVar)) == null) {
            return a(new l9a(this, c9aVar));
        }
        return (k8a) invokeL.objValue;
    }

    public final k8a<T> k(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, n8aVar)) == null) {
            return l(n8aVar, taa.c);
        }
        return (k8a) invokeL.objValue;
    }

    public final ica<T> p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return OperatorReplay.E(this, i);
        }
        return (ica) invokeI.objValue;
    }

    public final r8a u(q8a<? super T> q8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, q8aVar)) == null) {
            return v(q8aVar, this);
        }
        return (r8a) invokeL.objValue;
    }

    public final r8a w(y8a<? super T> y8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, y8aVar)) == null) {
            if (y8aVar != null) {
                return u(new paa(y8aVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (r8a) invokeL.objValue;
    }

    public final k8a<T> y(n8a n8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, n8aVar)) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(n8aVar);
            }
            return a(new u9a(this, n8aVar));
        }
        return (k8a) invokeL.objValue;
    }

    public static <T> k8a<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return EmptyObservableHolder.instance();
        }
        return (k8a) invokeV.objValue;
    }

    public final k8a<T> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (k8a<T>) g(r9a.a());
        }
        return (k8a) invokeV.objValue;
    }

    public final ica<T> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return OperatorReplay.D(this);
        }
        return (ica) invokeV.objValue;
    }

    public final k8a<T> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return m9a.a(this);
        }
        return (k8a) invokeV.objValue;
    }

    public final r8a t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return u(new paa(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        return (r8a) invokeV.objValue;
    }

    public static <T> r8a v(q8a<? super T> q8aVar, k8a<T> k8aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, q8aVar, k8aVar)) == null) {
            if (q8aVar != null) {
                if (k8aVar.a != null) {
                    q8aVar.d();
                    if (!(q8aVar instanceof lca)) {
                        q8aVar = new lca(q8aVar);
                    }
                    try {
                        rca.p(k8aVar, k8aVar.a).call(q8aVar);
                        return rca.o(q8aVar);
                    } catch (Throwable th) {
                        w8a.e(th);
                        if (q8aVar.isUnsubscribed()) {
                            rca.j(rca.m(th));
                        } else {
                            try {
                                q8aVar.onError(rca.m(th));
                            } catch (Throwable th2) {
                                w8a.e(th2);
                                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                                rca.m(onErrorFailedException);
                                throw onErrorFailedException;
                            }
                        }
                        return hda.c();
                    }
                }
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
            throw new IllegalArgumentException("subscriber can not be null");
        }
        return (r8a) invokeLL.objValue;
    }

    public final k8a<T> A(long j, TimeUnit timeUnit, k8a<? extends T> k8aVar, n8a n8aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), timeUnit, k8aVar, n8aVar})) == null) {
            return (k8a<T>) g(new v9a(j, timeUnit, k8aVar, n8aVar));
        }
        return (k8a) invokeCommon.objValue;
    }

    public final ica<T> q(int i, long j, TimeUnit timeUnit, n8a n8aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit, n8aVar})) == null) {
            if (i >= 0) {
                return OperatorReplay.G(this, j, timeUnit, n8aVar, i);
            }
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return (ica) invokeCommon.objValue;
    }

    public final r8a B(q8a<? super T> q8aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q8aVar)) == null) {
            try {
                q8aVar.d();
                rca.p(this, this.a).call(q8aVar);
                return rca.o(q8aVar);
            } catch (Throwable th) {
                w8a.e(th);
                try {
                    q8aVar.onError(rca.m(th));
                    return hda.c();
                } catch (Throwable th2) {
                    w8a.e(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rca.m(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
        }
        return (r8a) invokeL.objValue;
    }

    public final k8a<T> l(n8a n8aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, n8aVar, i)) == null) {
            return m(n8aVar, false, i);
        }
        return (k8a) invokeLI.objValue;
    }

    public final k8a<T> z(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, timeUnit)) == null) {
            return A(j, timeUnit, null, Schedulers.computation());
        }
        return (k8a) invokeJL.objValue;
    }

    public final k8a<T> m(n8a n8aVar, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{n8aVar, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (this instanceof ScalarSynchronousObservable) {
                return ((ScalarSynchronousObservable) this).G(n8aVar);
            }
            return (k8a<T>) g(new q9a(n8aVar, z, i));
        }
        return (k8a) invokeCommon.objValue;
    }

    public final ica<T> r(long j, TimeUnit timeUnit, n8a n8aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), timeUnit, n8aVar})) == null) {
            return OperatorReplay.F(this, j, timeUnit, n8aVar);
        }
        return (ica) invokeCommon.objValue;
    }

    public final r8a x(y8a<? super T> y8aVar, y8a<Throwable> y8aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, y8aVar, y8aVar2)) == null) {
            if (y8aVar != null) {
                if (y8aVar2 != null) {
                    return u(new paa(y8aVar, y8aVar2, Actions.a()));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onNext can not be null");
        }
        return (r8a) invokeLL.objValue;
    }
}
