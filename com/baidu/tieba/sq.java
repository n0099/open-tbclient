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
/* loaded from: classes6.dex */
public final class sq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, rr rrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, rrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(rrVar);
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
                if (iw.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(rr rrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        rr rrVar2;
        rr rrVar3;
        rr rrVar4;
        rr rrVar5;
        rr rrVar6;
        rr rrVar7;
        rr rrVar8;
        rr rrVar9;
        rr rrVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rrVar, bVar)) == null) {
            xq xqVar = null;
            if (!(rrVar instanceof cr)) {
                rrVar2 = null;
            } else {
                rrVar2 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (cr) rrVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, rrVar);
                cr crVar = (cr) rrVar;
                a.h(crVar.h());
                a.i(crVar.h(), crVar.i());
                SubTaskState k = a.k(crVar.f());
                if (k != null) {
                    k.setInterceptor(crVar.j());
                    k.updateStatus(crVar.g(), Integer.valueOf(crVar.a()), crVar.d());
                }
                b(a, crVar.f());
                return a;
            }
            if (!(rrVar instanceof uq)) {
                rrVar3 = null;
            } else {
                rrVar3 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (uq) rrVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, rrVar);
                uq uqVar = (uq) rrVar;
                SubTaskState k2 = a2.k(uqVar.f());
                if (k2 != null) {
                    k2.updateStatus(uqVar.g(), Integer.valueOf(uqVar.a()), uqVar.d());
                    k2.updateExtraUnRegisterMsg(uqVar.h());
                }
                return a2;
            }
            if (!(rrVar instanceof br)) {
                rrVar4 = null;
            } else {
                rrVar4 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (br) rrVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, rrVar);
                br brVar = (br) rrVar;
                SubTaskState k3 = a3.k(brVar.f());
                if (k3 != null) {
                    k3.updateStatus(brVar.g(), Integer.valueOf(brVar.a()), brVar.d()).getTaskStatus().setInterruptErrorNo(brVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(rrVar instanceof tq)) {
                rrVar5 = null;
            } else {
                rrVar5 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (tq) rrVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, rrVar);
                tq tqVar = (tq) rrVar;
                SubTaskState k4 = a4.k(tqVar.f());
                if (k4 != null) {
                    k4.updateStatus(tqVar.g(), Integer.valueOf(tqVar.a()), tqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(rrVar instanceof vq)) {
                rrVar6 = null;
            } else {
                rrVar6 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (vq) rrVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, rrVar);
                vq vqVar = (vq) rrVar;
                SubTaskState k5 = a5.k(vqVar.f());
                if (k5 != null) {
                    k5.updateStatus(vqVar.g(), Integer.valueOf(vqVar.a()), vqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(vqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, vqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(vqVar.h());
                    }
                }
                b(a5, vqVar.f());
                return a5;
            }
            if (!(rrVar instanceof wq)) {
                rrVar7 = null;
            } else {
                rrVar7 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (wq) rrVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, rrVar);
                wq wqVar = (wq) rrVar;
                SubTaskState k6 = a6.k(wqVar.f());
                if (k6 != null) {
                    k6.updateStatus(wqVar.g(), Integer.valueOf(wqVar.a()), wqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(wqVar.h());
                    if (!TextUtils.isEmpty(wqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, wqVar.j(), wqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(wqVar.i());
                }
                b(a6, wqVar.f());
                return a6;
            }
            if (!(rrVar instanceof ar)) {
                rrVar8 = null;
            } else {
                rrVar8 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (ar) rrVar8)) {
                ar arVar = (ar) rrVar;
                TaskInfo k7 = arVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, rrVar);
                SubTaskState k8 = a7.k(arVar.f());
                if (k8 != null) {
                    if (bw.a.a(arVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(arVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(arVar.i(), Integer.valueOf(arVar.a()), arVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(arVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(arVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, arVar.f());
                return a7;
            }
            if (!(rrVar instanceof yq)) {
                rrVar9 = null;
            } else {
                rrVar9 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (yq) rrVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, rrVar);
                yq yqVar = (yq) rrVar;
                SubTaskState k9 = a8.k(yqVar.f());
                if (k9 != null) {
                    k9.updateStatus(yqVar.g(), Integer.valueOf(yqVar.a()), yqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(rrVar instanceof zq)) {
                rrVar10 = null;
            } else {
                rrVar10 = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, (zq) rrVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, rrVar);
                SubTaskState k10 = a9.k(((zq) rrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (rrVar instanceof xq) {
                xqVar = rrVar;
            }
            if (Intrinsics.areEqual(rrVar, xqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, rrVar);
                xq xqVar2 = (xq) rrVar;
                SubTaskState k11 = a10.k(xqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(xqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(xqVar2.g());
                }
                return a10;
            }
            return a(bVar, rrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
