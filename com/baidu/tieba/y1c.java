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
/* loaded from: classes8.dex */
public class y1c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c<T> a;

    /* loaded from: classes8.dex */
    public interface c<T> extends i2c<z1c<? super T>> {
        @Override // com.baidu.tieba.i2c
        /* synthetic */ void call(T t);
    }

    /* loaded from: classes8.dex */
    public class a extends z1c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i2c b;
        public final /* synthetic */ i2c c;

        public a(y1c y1cVar, i2c i2cVar, i2c i2cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1cVar, i2cVar, i2cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i2cVar;
            this.c = i2cVar2;
        }

        @Override // com.baidu.tieba.z1c
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

        @Override // com.baidu.tieba.z1c
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

    /* loaded from: classes8.dex */
    public class b implements i2c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i2c a;

        public b(y1c y1cVar, i2c i2cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y1cVar, i2cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i2c
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.a.call(th);
            }
        }
    }

    public y1c(c<T> cVar) {
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
        this.a = h6c.i(cVar);
    }

    public final y1c<T> h(x1c x1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, x1cVar)) == null) {
            if (this instanceof k4c) {
                return ((k4c) this).n(x1cVar);
            }
            if (x1cVar != null) {
                return b(new r3c(this.a, x1cVar));
            }
            throw new NullPointerException("scheduler is null");
        }
        return (y1c) invokeL.objValue;
    }

    public static <T> u1c<T> a(y1c<T> y1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y1cVar)) == null) {
            return u1c.d(new s3c(y1cVar.a));
        }
        return (u1c) invokeL.objValue;
    }

    public static <T> y1c<T> b(c<T> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            return new y1c<>(cVar);
        }
        return (y1c) invokeL.objValue;
    }

    public static <T> y1c<T> g(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            return k4c.m(t);
        }
        return (y1c) invokeL.objValue;
    }

    public final y1c<T> e(i2c<Throwable> i2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i2cVar)) == null) {
            if (i2cVar != null) {
                return b(new o3c(this, Actions.a(), new b(this, i2cVar)));
            }
            throw new IllegalArgumentException("onError is null");
        }
        return (y1c) invokeL.objValue;
    }

    public final y1c<T> f(i2c<? super T> i2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, i2cVar)) == null) {
            if (i2cVar != null) {
                return b(new o3c(this, i2cVar, Actions.a()));
            }
            throw new IllegalArgumentException("onSuccess is null");
        }
        return (y1c) invokeL.objValue;
    }

    public final y1c<T> c(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, timeUnit)) == null) {
            return d(j, timeUnit, Schedulers.computation());
        }
        return (y1c) invokeJL.objValue;
    }

    public final b2c k(i2c<? super T> i2cVar, i2c<Throwable> i2cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, i2cVar, i2cVar2)) == null) {
            if (i2cVar != null) {
                if (i2cVar2 != null) {
                    return j(new a(this, i2cVar2, i2cVar));
                }
                throw new IllegalArgumentException("onError can not be null");
            }
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        return (b2c) invokeLL.objValue;
    }

    public final y1c<T> d(long j, TimeUnit timeUnit, x1c x1cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), timeUnit, x1cVar})) == null) {
            return b(new n3c(this.a, j, timeUnit, x1cVar));
        }
        return (y1c) invokeCommon.objValue;
    }

    public final b2c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return k(Actions.a(), Actions.b());
        }
        return (b2c) invokeV.objValue;
    }

    public final u1c<T> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return a(this);
        }
        return (u1c) invokeV.objValue;
    }

    public final b2c j(z1c<? super T> z1cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, z1cVar)) == null) {
            if (z1cVar != null) {
                try {
                    h6c.t(this, this.a).call(z1cVar);
                    return h6c.s(z1cVar);
                } catch (Throwable th) {
                    g2c.e(th);
                    try {
                        z1cVar.b(h6c.r(th));
                        return x6c.b();
                    } catch (Throwable th2) {
                        g2c.e(th2);
                        RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                        h6c.r(runtimeException);
                        throw runtimeException;
                    }
                }
            }
            throw new IllegalArgumentException("te is null");
        }
        return (b2c) invokeL.objValue;
    }
}
