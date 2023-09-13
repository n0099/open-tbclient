package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public interface uu {
    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean b(uu uuVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, uuVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        public static void a(uu uuVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, uuVar, subTaskState) == null) && !uuVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                uuVar.a(subTaskState);
            }
        }

        @CallSuper
        public static void c(uu uuVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, uuVar, subTaskState) == null) {
                xu.c.b(subTaskState);
            }
        }
    }
}
