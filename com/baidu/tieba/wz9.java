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
public class wz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends g0a<xz9<? super T>> {
        @Override // com.baidu.tieba.g0a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends xz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0a b;
        public final /* synthetic */ g0a c;

        public a(wz9 wz9Var, g0a g0aVar, g0a g0aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz9Var, g0aVar, g0aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g0aVar;
            this.c = g0aVar2;
        }

        @Override // com.baidu.tieba.xz9
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

        @Override // com.baidu.tieba.xz9
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
    public class b implements g0a<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g0a a;

        public b(wz9 wz9Var, g0a g0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz9Var, g0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.g0a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public wz9(c<T> cVar) {
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
        this.a = z3a.i(cVar);
    }

    public final wz9<T> h(vz9 vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vz9Var)) == null) {
            if (this instanceof c2a) {
                return ((c2a) this).n(vz9Var);
            }
            if (vz9Var != null) {
                return b(new j1a(this.a, vz9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (wz9) invokeL.objValue;
    }

    public static <T> sz9<T> a(wz9<T> wz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wz9Var)) == null) {
            return sz9.a(new k1a(wz9Var.a));
        }
        return (sz9) invokeL.objValue;
    }

    public static <T> wz9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new wz9<>(cVar);
        }
        return (wz9) invokeL.objValue;
    }

    public static <T> wz9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return c2a.m(t);
        }
        return (wz9) invokeL.objValue;
    }

    public final wz9<T> e(g0a<Throwable> g0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g0aVar)) == null) {
            if (g0aVar != null) {
                return b(new g1a(this, Actions.a(), new b(this, g0aVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (wz9) invokeL.objValue;
    }

    public final wz9<T> f(g0a<? super T> g0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, g0aVar)) == null) {
            if (g0aVar != null) {
                return b(new g1a(this, g0aVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (wz9) invokeL.objValue;
    }

    public final wz9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (wz9) invokeJL.objValue;
    }

    public final zz9 k(g0a<? super T> g0aVar, g0a<Throwable> g0aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, g0aVar, g0aVar2)) == null) {
            if (g0aVar != null) {
                if (g0aVar2 != null) {
                    return j(new a(this, g0aVar2, g0aVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (zz9) invokeLL.objValue;
    }

    public final wz9<T> d(long j, TimeUnit timeUnit, vz9 vz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, vz9Var})) == null) {
            return b(new f1a(this.a, j, timeUnit, vz9Var));
        }
        return (wz9) invokeCommon.objValue;
    }

    public final zz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (zz9) invokeV.objValue;
    }

    public final sz9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (sz9) invokeV.objValue;
    }

    public final zz9 j(xz9<? super T> xz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, xz9Var)) == null) {
            if (xz9Var != null) {
                try {
                    z3a.t(this, this.a).call(xz9Var);
                    return z3a.s(xz9Var);
                } catch (Throwable th) {
                    e0a.e(th);
                    try {
                        xz9Var.b(z3a.r(th));
                        return p4a.b();
                    } catch (Throwable th2) {
                        e0a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        z3a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (zz9) invokeL.objValue;
    }
}
