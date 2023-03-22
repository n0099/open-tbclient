package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public interface lu {
    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean b(lu luVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, luVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        public static void a(lu luVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, luVar, subTaskState) == null) && !luVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                luVar.a(subTaskState);
            }
        }

        @CallSuper
        public static void c(lu luVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, luVar, subTaskState) == null) {
                ou.c.b(subTaskState);
            }
        }
    }
}
