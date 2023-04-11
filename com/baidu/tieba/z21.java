package com.baidu.tieba;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile o21 a;
    public volatile o21 b;
    public volatile o21 c;
    public int d;
    public long e;

    public z21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = 0L;
    }

    public o21 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == null) {
                synchronized (this) {
                    if (this.c == null) {
                        this.c = (o21) BaseExecutorCell.b(l21.i, BaseExecutorCell.ExecutorType.DREDGE_DISASTER);
                    }
                }
            }
            return this.c;
        }
        return (o21) invokeV.objValue;
    }

    public o21 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = (o21) BaseExecutorCell.b(l21.g, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.a;
        }
        return (o21) invokeV.objValue;
    }

    public o21 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = (o21) BaseExecutorCell.b(l21.h, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.b;
        }
        return (o21) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            double a = a31.f().g().a();
            if (a >= l21.j && 3 != this.d) {
                if (a >= l21.k) {
                    z = true;
                } else {
                    z = false;
                }
                if (z || SystemClock.elapsedRealtime() - this.e > l21.m) {
                    g();
                    this.e = SystemClock.elapsedRealtime();
                    a31.f().j(l21.m + 10);
                    return 1;
                }
            }
            if (this.d == 0 || a >= l21.l || SystemClock.elapsedRealtime() - this.e <= l21.n) {
                return 0;
            }
            b();
            this.e = SystemClock.elapsedRealtime();
            a31.f().j(l21.n + 10);
            return -1;
        }
        return invokeV.intValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.d;
            if (1 == i) {
                e().j();
                this.d = 0;
            } else if (2 == i) {
                f().j();
                this.d = 1;
            } else if (3 == i) {
                d().j();
                this.d = 2;
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = this.d;
            if (i == 0) {
                e().i();
                this.d = 1;
            } else if (1 == i) {
                f().i();
                this.d = 2;
            } else if (2 == i) {
                d().i();
                this.d = 3;
            }
        }
    }

    public boolean c(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, elasticTask)) == null) {
            int i = this.d;
            if (i == 0) {
                return false;
            }
            if (i == 1) {
                return e().c(elasticTask);
            }
            if (i == 2) {
                if (e().c(elasticTask)) {
                    return true;
                }
                return f().c(elasticTask);
            } else if (i != 3) {
                return false;
            } else {
                if (e().c(elasticTask) || f().c(elasticTask)) {
                    return true;
                }
                return d().c(elasticTask);
            }
        }
        return invokeL.booleanValue;
    }
}
