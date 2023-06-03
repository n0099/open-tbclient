package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskEnvTag;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.ctrl.model.TaskStatusRuntime;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class yq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, xr xrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, xrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(xrVar);
            }
            return bVar2;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b b(com.baidu.bdtask.ctrl.b bVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str)) == null) {
            TaskInfo f = bVar.f(str);
            if (f != null) {
                if (ow.a.c(f.getTaskRule().getExpireTime())) {
                    return bVar;
                }
                SubTaskState k = bVar.k(str);
                if (k != null) {
                    k.updateStatus(22, 103, "task is expired");
                    k.getTaskStatus().clearProcess();
                }
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(xr xrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        xr xrVar2;
        xr xrVar3;
        xr xrVar4;
        xr xrVar5;
        xr xrVar6;
        xr xrVar7;
        xr xrVar8;
        xr xrVar9;
        xr xrVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xrVar, bVar)) == null) {
            dr drVar = null;
            if (!(xrVar instanceof ir)) {
                xrVar2 = null;
            } else {
                xrVar2 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (ir) xrVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, xrVar);
                ir irVar = (ir) xrVar;
                a.h(irVar.h());
                a.i(irVar.h(), irVar.i());
                SubTaskState k = a.k(irVar.f());
                if (k != null) {
                    k.setInterceptor(irVar.j());
                    k.updateStatus(irVar.g(), Integer.valueOf(irVar.a()), irVar.d());
                }
                b(a, irVar.f());
                return a;
            }
            if (!(xrVar instanceof ar)) {
                xrVar3 = null;
            } else {
                xrVar3 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (ar) xrVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, xrVar);
                ar arVar = (ar) xrVar;
                SubTaskState k2 = a2.k(arVar.f());
                if (k2 != null) {
                    k2.updateStatus(arVar.g(), Integer.valueOf(arVar.a()), arVar.d());
                    k2.updateExtraUnRegisterMsg(arVar.h());
                }
                return a2;
            }
            if (!(xrVar instanceof hr)) {
                xrVar4 = null;
            } else {
                xrVar4 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (hr) xrVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, xrVar);
                hr hrVar = (hr) xrVar;
                SubTaskState k3 = a3.k(hrVar.f());
                if (k3 != null) {
                    k3.updateStatus(hrVar.g(), Integer.valueOf(hrVar.a()), hrVar.d()).getTaskStatus().setInterruptErrorNo(hrVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(xrVar instanceof zq)) {
                xrVar5 = null;
            } else {
                xrVar5 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (zq) xrVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, xrVar);
                zq zqVar = (zq) xrVar;
                SubTaskState k4 = a4.k(zqVar.f());
                if (k4 != null) {
                    k4.updateStatus(zqVar.g(), Integer.valueOf(zqVar.a()), zqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(xrVar instanceof br)) {
                xrVar6 = null;
            } else {
                xrVar6 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (br) xrVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, xrVar);
                br brVar = (br) xrVar;
                SubTaskState k5 = a5.k(brVar.f());
                if (k5 != null) {
                    k5.updateStatus(brVar.g(), Integer.valueOf(brVar.a()), brVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(brVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, brVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(brVar.h());
                    }
                }
                b(a5, brVar.f());
                return a5;
            }
            if (!(xrVar instanceof cr)) {
                xrVar7 = null;
            } else {
                xrVar7 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (cr) xrVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, xrVar);
                cr crVar = (cr) xrVar;
                SubTaskState k6 = a6.k(crVar.f());
                if (k6 != null) {
                    k6.updateStatus(crVar.g(), Integer.valueOf(crVar.a()), crVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(crVar.h());
                    if (!TextUtils.isEmpty(crVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, crVar.j(), crVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(crVar.i());
                }
                b(a6, crVar.f());
                return a6;
            }
            if (!(xrVar instanceof gr)) {
                xrVar8 = null;
            } else {
                xrVar8 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (gr) xrVar8)) {
                gr grVar = (gr) xrVar;
                TaskInfo k7 = grVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, xrVar);
                SubTaskState k8 = a7.k(grVar.f());
                if (k8 != null) {
                    if (hw.a.a(grVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(grVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(grVar.i(), Integer.valueOf(grVar.a()), grVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(grVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(grVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, grVar.f());
                return a7;
            }
            if (!(xrVar instanceof er)) {
                xrVar9 = null;
            } else {
                xrVar9 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (er) xrVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, xrVar);
                er erVar = (er) xrVar;
                SubTaskState k9 = a8.k(erVar.f());
                if (k9 != null) {
                    k9.updateStatus(erVar.g(), Integer.valueOf(erVar.a()), erVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(xrVar instanceof fr)) {
                xrVar10 = null;
            } else {
                xrVar10 = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, (fr) xrVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, xrVar);
                SubTaskState k10 = a9.k(((fr) xrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (xrVar instanceof dr) {
                drVar = xrVar;
            }
            if (Intrinsics.areEqual(xrVar, drVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, xrVar);
                dr drVar2 = (dr) xrVar;
                SubTaskState k11 = a10.k(drVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(drVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(drVar2.g());
                }
                return a10;
            }
            return a(bVar, xrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
