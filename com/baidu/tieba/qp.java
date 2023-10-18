package com.baidu.tieba;

import androidx.annotation.CallSuper;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public interface qp {
    @CallSuper
    void a(SubTaskState subTaskState);

    boolean b(TaskInfo taskInfo, int i);

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean b(qp qpVar, TaskInfo taskInfo, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, qpVar, taskInfo, i)) == null) ? i == 304 : invokeLLI.booleanValue;
        }

        public static void a(qp qpVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, qpVar, subTaskState) == null) && !qpVar.b(subTaskState.getTaskInfo(), subTaskState.getTaskStatus().getCurStatusCode())) {
                qpVar.a(subTaskState);
            }
        }

        @CallSuper
        public static void c(qp qpVar, SubTaskState subTaskState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, qpVar, subTaskState) == null) {
                tp.c.b(subTaskState);
            }
        }
    }
}
