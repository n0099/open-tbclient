package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o51 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o51 b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947983134, "Lcom/baidu/tieba/o51;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947983134, "Lcom/baidu/tieba/o51;");
        }
    }

    public o51() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0L;
    }

    public static o51 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (o51.class) {
                    if (b == null) {
                        b = new o51();
                    }
                }
            }
            return b;
        }
        return (o51) invokeV.objValue;
    }

    public ElasticTask a(@NonNull Runnable runnable, @NonNull String str, int i) {
        InterceptResult invokeLLI;
        ElasticTask elasticTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, runnable, str, i)) == null) {
            if (runnable != null && !TextUtils.isEmpty(str)) {
                synchronized (this) {
                    long j = this.a + 1;
                    this.a = j;
                    elasticTask = new ElasticTask(runnable, str, j, i);
                }
                return elasticTask;
            }
            throw new IllegalArgumentException("illegal params");
        }
        return (ElasticTask) invokeLLI.objValue;
    }
}
