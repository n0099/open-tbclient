package com.baidu.tieba;

import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.utils.UniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class qq {
    public static /* synthetic */ Interceptable $ic;
    public static final qq a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448315277, "Lcom/baidu/tieba/qq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448315277, "Lcom/baidu/tieba/qq;");
                return;
            }
        }
        a = new qq();
    }

    public qq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final nq a(TaskInfo taskInfo, UniqueId uniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskInfo, uniqueId)) == null) {
            if (Intrinsics.areEqual(uniqueId, sq.c.a())) {
                return new sq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, tq.c.a())) {
                return new tq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, uq.c.a())) {
                return new uq(taskInfo);
            }
            return null;
        }
        return (nq) invokeLL.objValue;
    }
}
