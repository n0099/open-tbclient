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
public class vz9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes6.dex */
    public interface c<T> extends f0a<wz9<? super T>> {
        @Override // com.baidu.tieba.f0a
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes6.dex */
    public class a extends wz9<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f0a b;
        public final /* synthetic */ f0a c;

        public a(vz9 vz9Var, f0a f0aVar, f0a f0aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz9Var, f0aVar, f0aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f0aVar;
            this.c = f0aVar2;
        }

        @Override // com.baidu.tieba.wz9
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

        @Override // com.baidu.tieba.wz9
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
    public class b implements f0a<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f0a a;

        public b(vz9 vz9Var, f0a f0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz9Var, f0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f0aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f0a
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public vz9(c<T> cVar) {
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
        this.a = y3a.i(cVar);
    }

    public final vz9<T> h(uz9 uz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uz9Var)) == null) {
            if (this instanceof b2a) {
                return ((b2a) this).n(uz9Var);
            }
            if (uz9Var != null) {
                return b(new i1a(this.a, uz9Var));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (vz9) invokeL.objValue;
    }

    public static <T> rz9<T> a(vz9<T> vz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vz9Var)) == null) {
            return rz9.a(new j1a(vz9Var.a));
        }
        return (rz9) invokeL.objValue;
    }

    public static <T> vz9<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new vz9<>(cVar);
        }
        return (vz9) invokeL.objValue;
    }

    public static <T> vz9<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return b2a.m(t);
        }
        return (vz9) invokeL.objValue;
    }

    public final vz9<T> e(f0a<Throwable> f0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f0aVar)) == null) {
            if (f0aVar != null) {
                return b(new f1a(this, Actions.a(), new b(this, f0aVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (vz9) invokeL.objValue;
    }

    public final vz9<T> f(f0a<? super T> f0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f0aVar)) == null) {
            if (f0aVar != null) {
                return b(new f1a(this, f0aVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (vz9) invokeL.objValue;
    }

    public final vz9<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (vz9) invokeJL.objValue;
    }

    public final yz9 k(f0a<? super T> f0aVar, f0a<Throwable> f0aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, f0aVar, f0aVar2)) == null) {
            if (f0aVar != null) {
                if (f0aVar2 != null) {
                    return j(new a(this, f0aVar2, f0aVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (yz9) invokeLL.objValue;
    }

    public final vz9<T> d(long j, TimeUnit timeUnit, uz9 uz9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, uz9Var})) == null) {
            return b(new e1a(this.a, j, timeUnit, uz9Var));
        }
        return (vz9) invokeCommon.objValue;
    }

    public final yz9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (yz9) invokeV.objValue;
    }

    public final rz9<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (rz9) invokeV.objValue;
    }

    public final yz9 j(wz9<? super T> wz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wz9Var)) == null) {
            if (wz9Var != null) {
                try {
                    y3a.t(this, this.a).call(wz9Var);
                    return y3a.s(wz9Var);
                } catch (Throwable th) {
                    d0a.e(th);
                    try {
                        wz9Var.b(y3a.r(th));
                        return o4a.b();
                    } catch (Throwable th2) {
                        d0a.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        y3a.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (yz9) invokeL.objValue;
    }
}
