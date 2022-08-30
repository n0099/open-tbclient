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
public final class tq {
    public static /* synthetic */ Interceptable $ic;
    public static final tq a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318160, "Lcom/baidu/tieba/tq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318160, "Lcom/baidu/tieba/tq;");
                return;
            }
        }
        a = new tq();
    }

    public tq() {
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

    public final qq a(TaskInfo taskInfo, UniqueId uniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskInfo, uniqueId)) == null) {
            if (Intrinsics.areEqual(uniqueId, vq.c.a())) {
                return new vq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, wq.c.a())) {
                return new wq(taskInfo);
            }
            if (Intrinsics.areEqual(uniqueId, xq.c.a())) {
                return new xq(taskInfo);
            }
            return null;
        }
        return (qq) invokeLL.objValue;
    }
}
