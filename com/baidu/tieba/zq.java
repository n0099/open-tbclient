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
public final class zq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, yr yrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, yrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(yrVar);
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
                if (pw.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(yr yrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        yr yrVar2;
        yr yrVar3;
        yr yrVar4;
        yr yrVar5;
        yr yrVar6;
        yr yrVar7;
        yr yrVar8;
        yr yrVar9;
        yr yrVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yrVar, bVar)) == null) {
            er erVar = null;
            if (!(yrVar instanceof jr)) {
                yrVar2 = null;
            } else {
                yrVar2 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (jr) yrVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, yrVar);
                jr jrVar = (jr) yrVar;
                a.h(jrVar.h());
                a.i(jrVar.h(), jrVar.i());
                SubTaskState k = a.k(jrVar.f());
                if (k != null) {
                    k.setInterceptor(jrVar.j());
                    k.updateStatus(jrVar.g(), Integer.valueOf(jrVar.a()), jrVar.d());
                }
                b(a, jrVar.f());
                return a;
            }
            if (!(yrVar instanceof br)) {
                yrVar3 = null;
            } else {
                yrVar3 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (br) yrVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, yrVar);
                br brVar = (br) yrVar;
                SubTaskState k2 = a2.k(brVar.f());
                if (k2 != null) {
                    k2.updateStatus(brVar.g(), Integer.valueOf(brVar.a()), brVar.d());
                    k2.updateExtraUnRegisterMsg(brVar.h());
                }
                return a2;
            }
            if (!(yrVar instanceof ir)) {
                yrVar4 = null;
            } else {
                yrVar4 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (ir) yrVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, yrVar);
                ir irVar = (ir) yrVar;
                SubTaskState k3 = a3.k(irVar.f());
                if (k3 != null) {
                    k3.updateStatus(irVar.g(), Integer.valueOf(irVar.a()), irVar.d()).getTaskStatus().setInterruptErrorNo(irVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(yrVar instanceof ar)) {
                yrVar5 = null;
            } else {
                yrVar5 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (ar) yrVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, yrVar);
                ar arVar = (ar) yrVar;
                SubTaskState k4 = a4.k(arVar.f());
                if (k4 != null) {
                    k4.updateStatus(arVar.g(), Integer.valueOf(arVar.a()), arVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(yrVar instanceof cr)) {
                yrVar6 = null;
            } else {
                yrVar6 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (cr) yrVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, yrVar);
                cr crVar = (cr) yrVar;
                SubTaskState k5 = a5.k(crVar.f());
                if (k5 != null) {
                    k5.updateStatus(crVar.g(), Integer.valueOf(crVar.a()), crVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(crVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, crVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(crVar.h());
                    }
                }
                b(a5, crVar.f());
                return a5;
            }
            if (!(yrVar instanceof dr)) {
                yrVar7 = null;
            } else {
                yrVar7 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (dr) yrVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, yrVar);
                dr drVar = (dr) yrVar;
                SubTaskState k6 = a6.k(drVar.f());
                if (k6 != null) {
                    k6.updateStatus(drVar.g(), Integer.valueOf(drVar.a()), drVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(drVar.h());
                    if (!TextUtils.isEmpty(drVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, drVar.j(), drVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(drVar.i());
                }
                b(a6, drVar.f());
                return a6;
            }
            if (!(yrVar instanceof hr)) {
                yrVar8 = null;
            } else {
                yrVar8 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (hr) yrVar8)) {
                hr hrVar = (hr) yrVar;
                TaskInfo k7 = hrVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, yrVar);
                SubTaskState k8 = a7.k(hrVar.f());
                if (k8 != null) {
                    if (iw.a.a(hrVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(hrVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(hrVar.i(), Integer.valueOf(hrVar.a()), hrVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(hrVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(hrVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, hrVar.f());
                return a7;
            }
            if (!(yrVar instanceof fr)) {
                yrVar9 = null;
            } else {
                yrVar9 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (fr) yrVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, yrVar);
                fr frVar = (fr) yrVar;
                SubTaskState k9 = a8.k(frVar.f());
                if (k9 != null) {
                    k9.updateStatus(frVar.g(), Integer.valueOf(frVar.a()), frVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(yrVar instanceof gr)) {
                yrVar10 = null;
            } else {
                yrVar10 = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, (gr) yrVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, yrVar);
                SubTaskState k10 = a9.k(((gr) yrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (yrVar instanceof er) {
                erVar = yrVar;
            }
            if (Intrinsics.areEqual(yrVar, erVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, yrVar);
                er erVar2 = (er) yrVar;
                SubTaskState k11 = a10.k(erVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(erVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(erVar2.g());
                }
                return a10;
            }
            return a(bVar, yrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
