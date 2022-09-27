package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class j24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xu2 d = d();
            if (d != null) {
                return d.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(WebSocketTask task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task) == null) {
            Intrinsics.checkNotNullParameter(task, "task");
            xu2 d = d();
            if (d != null) {
                d.b(task);
            }
        }
    }

    public final void c(String taskId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskId) == null) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            xu2 d = d();
            if (d != null) {
                d.c(taskId);
            }
        }
    }

    public final xu2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            l33 M = l33.M();
            if (M != null) {
                return M.m0();
            }
            return null;
        }
        return (xu2) invokeV.objValue;
    }
}
