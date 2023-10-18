package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.executor.BaseExecutorCell;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class pz0 extends BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "SerialElasticExecutorCell" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pz0(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i != 1) {
            String d = d();
            Log.w(d, "You are creating a SerialExecutorCell with maxThreadNum " + i + ". For SerialExecutorCell, maxThreadNum must be 1. So it will be forced to set to 1.");
            this.b = 1;
        }
        this.c = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (e() < 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final synchronized ElasticTask k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.a.isEmpty()) {
                    return null;
                }
                return this.a.get(0);
            }
        }
        return (ElasticTask) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public synchronized void f(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, elasticTask) == null) {
            synchronized (this) {
                super.f(elasticTask);
                if (jz0.b) {
                    yz0.f().n(jz0.c + 10);
                }
            }
        }
    }

    @Override // com.baidu.nadcore.thread.executor.BaseExecutorCell
    public synchronized void g(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, elasticTask) == null) {
            synchronized (this) {
                super.g(elasticTask);
                yz0.f().o();
            }
        }
    }

    public final void i(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            elasticTask.h(null);
            this.c.shutdown();
            this.a.clear();
            this.c = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            yz0.f().o();
        }
    }

    public synchronized boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (!jz0.b) {
                    return false;
                }
                ElasticTask k = k();
                if (k == null) {
                    return false;
                }
                if (k.c() < jz0.c) {
                    return false;
                }
                i(k);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
