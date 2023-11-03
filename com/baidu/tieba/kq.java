package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.service.ubc.model.UBCActionTaskInfo;
import com.baidu.bdtask.service.ubc.model.UBCRecoveryTaskQueue;
import com.baidu.bdtask.service.ubc.model.UBCRegisterTaskInfo;
import com.baidu.bdtask.service.ubc.model.UBCTaskStatusInfo;
import com.baidu.bdtask.service.ubc.model.UBCUnRegisterTaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class kq {
    public static /* synthetic */ Interceptable $ic;
    public static lq a;
    public static boolean b;
    public static final kq c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309511, "Lcom/baidu/tieba/kq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309511, "Lcom/baidu/tieba/kq;");
                return;
            }
        }
        c = new kq();
    }

    public kq() {
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

    public final void a() {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_info_sync", new JSONObject());
        }
    }

    public final void b(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subTaskState) == null) {
            TaskStatus taskStatus = subTaskState.getTaskStatus();
            TaskInfo taskInfo = subTaskState.getTaskInfo();
            if (taskStatus.isRegistered()) {
                f(UBCRegisterTaskInfo.Companion.a(taskInfo, taskStatus));
            } else if (taskStatus.isRunning()) {
                g(new UBCTaskStatusInfo(taskInfo, taskStatus, 0, null, 12, null));
            } else if (taskStatus.isFinished()) {
                j(new UBCTaskStatusInfo(taskInfo, taskStatus, 0, null, 12, null));
            }
        }
    }

    public final void c(TaskInfo taskInfo, TaskStatus taskStatus) {
        bq f;
        sp v;
        bq f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, taskInfo, taskStatus) == null) {
            lq lqVar = new lq(taskInfo.getSingleKey(), cq.a.d(taskStatus));
            if (!Intrinsics.areEqual(lqVar, a)) {
                a = lqVar;
                if (Intrinsics.areEqual(lqVar.a(), "y_task_local_done") && !b && (v = BDPTask.m.v()) != null && (f2 = v.f()) != null) {
                    f2.a("y_task_start", "c_pv", cq.b(cq.a, taskInfo.getId(), taskInfo.getActTaskId(), null, 4, null));
                }
                if (Intrinsics.areEqual(lqVar.a(), "y_task_start") || Intrinsics.areEqual(lqVar.a(), "y_task_local_done")) {
                    b = true;
                }
                if (Intrinsics.areEqual(lqVar.a(), "y_task_active") || Intrinsics.areEqual(lqVar.a(), "y_task_done")) {
                    b = false;
                }
                sp v2 = BDPTask.m.v();
                if (v2 != null && (f = v2.f()) != null) {
                    f.a(lqVar.a(), "c_pv", cq.b(cq.a, taskInfo.getId(), taskInfo.getActTaskId(), null, 4, null));
                }
            }
        }
    }

    public final void d(UBCActionTaskInfo uBCActionTaskInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, uBCActionTaskInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_action", uBCActionTaskInfo.toJson());
        }
    }

    public final void e(UBCRecoveryTaskQueue uBCRecoveryTaskQueue) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, uBCRecoveryTaskQueue) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_sdk_init", uBCRecoveryTaskQueue.toJson());
        }
    }

    public final void f(UBCRegisterTaskInfo uBCRegisterTaskInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, uBCRegisterTaskInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_register", uBCRegisterTaskInfo.toJson());
        }
    }

    public final void g(UBCTaskStatusInfo uBCTaskStatusInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, uBCTaskStatusInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_running", uBCTaskStatusInfo.toJson());
        }
    }

    public final void h(UBCUnRegisterTaskInfo uBCUnRegisterTaskInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, uBCUnRegisterTaskInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_unregistered", uBCUnRegisterTaskInfo.toJson());
        }
    }

    public void i(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subTaskState) == null) {
            c(subTaskState.getTaskInfo(), subTaskState.getTaskStatus());
            f(UBCRegisterTaskInfo.Companion.a(subTaskState.getTaskInfo(), subTaskState.getTaskStatus()));
        }
    }

    public final void j(UBCTaskStatusInfo uBCTaskStatusInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, uBCTaskStatusInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_done_req", uBCTaskStatusInfo.toJson());
        }
    }

    public void k(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, subTaskState) == null) {
            c(subTaskState.getTaskInfo(), subTaskState.getTaskStatus());
            g(new UBCTaskStatusInfo(subTaskState.getTaskInfo(), subTaskState.getTaskStatus(), 0, null, 12, null));
        }
    }

    public final void l(UBCTaskStatusInfo uBCTaskStatusInfo) {
        sp v;
        bq f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, uBCTaskStatusInfo) == null) && (v = BDPTask.m.v()) != null && (f = v.f()) != null) {
            f.b("task_passive_interrupted", uBCTaskStatusInfo.toJson());
        }
    }

    public void m(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, subTaskState) == null) {
            c(subTaskState.getTaskInfo(), subTaskState.getTaskStatus());
            j(new UBCTaskStatusInfo(subTaskState.getTaskInfo(), subTaskState.getTaskStatus(), 0, null, 12, null));
        }
    }

    public void n(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, subTaskState) == null) {
            l(new UBCTaskStatusInfo(subTaskState.getTaskInfo(), subTaskState.getTaskStatus(), 0, null, 12, null));
        }
    }

    public void o(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, subTaskState) == null) {
            h(new UBCUnRegisterTaskInfo(subTaskState.getTaskInfo(), subTaskState.getTaskStatus()));
        }
    }
}
