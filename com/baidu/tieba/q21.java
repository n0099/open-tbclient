package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p21[] a;

    public q21() {
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
        this.a = new p21[4];
        if (e21.s.length != 4) {
            Log.e(QueueManager.TAG, "Elastic Queue size incompatible!");
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.a[i3] = new p21();
        }
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!c(0).d()) {
                return 9999999.0d;
            }
            double d = 0.0d;
            for (int i = 0; i < 4; i++) {
                d += this.a[i].a() * e21.s[i];
            }
            return d / 1000.0d;
        }
        return invokeV.doubleValue;
    }

    public ElasticTask b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < 4; i++) {
                if (!this.a[i].d()) {
                    return this.a[i].b();
                }
            }
            return null;
        }
        return (ElasticTask) invokeV.objValue;
    }

    public p21 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            int i2 = 0;
            while (true) {
                int[] iArr = e21.a;
                if (i2 < iArr.length) {
                    if (iArr[i2] == i) {
                        return this.a[i2];
                    }
                    i2++;
                } else {
                    p21[] p21VarArr = this.a;
                    return p21VarArr[p21VarArr.length - 1];
                }
            }
        } else {
            return (p21) invokeI.objValue;
        }
    }

    public void e(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            c(elasticTask.b()).e(elasticTask);
        }
    }

    public void d(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            c(i).c(runnable, str, i);
        }
    }
}
