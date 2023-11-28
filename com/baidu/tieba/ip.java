package com.baidu.tieba;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ip {
    public static /* synthetic */ Interceptable $ic;
    public static final ip a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307558, "Lcom/baidu/tieba/ip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307558, "Lcom/baidu/tieba/ip;");
                return;
            }
        }
        a = new ip();
    }

    public ip() {
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

    public final hp a(TaskStatus taskStatus, TaskInfo taskInfo) {
        InterceptResult invokeLL;
        int i;
        TaskUIData taskUIData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, taskStatus, taskInfo)) == null) {
            if (taskStatus.isFinished()) {
                taskUIData = taskInfo.getResponse().getUi();
                i = taskInfo.getResponse().getUiType();
            } else if (taskStatus.isRunning()) {
                taskUIData = taskInfo.getTaskMeter().getUi();
                i = taskInfo.getTaskMeter().getUiType();
            } else if (taskStatus.isInited() | taskStatus.isRegistered()) {
                taskUIData = taskInfo.getTaskGuide().getUi();
                i = taskInfo.getTaskGuide().getUiType();
            } else {
                i = -1;
                taskUIData = null;
            }
            return new hp(i, taskUIData);
        }
        return (hp) invokeLL.objValue;
    }
}
