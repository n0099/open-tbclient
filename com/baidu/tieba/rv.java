package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public interface rv {
    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean b(rv rvVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, rvVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        public static void a(rv rvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, rvVar, subTaskState) == null) && !rvVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                rvVar.a(subTaskState);
            }
        }

        @CallSuper
        public static void c(rv rvVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, rvVar, subTaskState) == null) {
                uv.c.b(subTaskState);
            }
        }
    }
}
