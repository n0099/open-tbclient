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
public final class wp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wp() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, vq vqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, vqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(vqVar);
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
                if (mv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(vq vqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        vq vqVar2;
        vq vqVar3;
        vq vqVar4;
        vq vqVar5;
        vq vqVar6;
        vq vqVar7;
        vq vqVar8;
        vq vqVar9;
        vq vqVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vqVar, bVar)) == null) {
            bq bqVar = null;
            if (!(vqVar instanceof gq)) {
                vqVar2 = null;
            } else {
                vqVar2 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (gq) vqVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, vqVar);
                gq gqVar = (gq) vqVar;
                a.h(gqVar.h());
                a.i(gqVar.h(), gqVar.i());
                SubTaskState k = a.k(gqVar.f());
                if (k != null) {
                    k.setInterceptor(gqVar.j());
                    k.updateStatus(gqVar.g(), Integer.valueOf(gqVar.a()), gqVar.d());
                }
                b(a, gqVar.f());
                return a;
            }
            if (!(vqVar instanceof yp)) {
                vqVar3 = null;
            } else {
                vqVar3 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (yp) vqVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, vqVar);
                yp ypVar = (yp) vqVar;
                SubTaskState k2 = a2.k(ypVar.f());
                if (k2 != null) {
                    k2.updateStatus(ypVar.g(), Integer.valueOf(ypVar.a()), ypVar.d());
                    k2.updateExtraUnRegisterMsg(ypVar.h());
                }
                return a2;
            }
            if (!(vqVar instanceof fq)) {
                vqVar4 = null;
            } else {
                vqVar4 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (fq) vqVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, vqVar);
                fq fqVar = (fq) vqVar;
                SubTaskState k3 = a3.k(fqVar.f());
                if (k3 != null) {
                    k3.updateStatus(fqVar.g(), Integer.valueOf(fqVar.a()), fqVar.d()).getTaskStatus().setInterruptErrorNo(fqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(vqVar instanceof xp)) {
                vqVar5 = null;
            } else {
                vqVar5 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (xp) vqVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, vqVar);
                xp xpVar = (xp) vqVar;
                SubTaskState k4 = a4.k(xpVar.f());
                if (k4 != null) {
                    k4.updateStatus(xpVar.g(), Integer.valueOf(xpVar.a()), xpVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(vqVar instanceof zp)) {
                vqVar6 = null;
            } else {
                vqVar6 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (zp) vqVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, vqVar);
                zp zpVar = (zp) vqVar;
                SubTaskState k5 = a5.k(zpVar.f());
                if (k5 != null) {
                    k5.updateStatus(zpVar.g(), Integer.valueOf(zpVar.a()), zpVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(zpVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, zpVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(zpVar.h());
                    }
                }
                b(a5, zpVar.f());
                return a5;
            }
            if (!(vqVar instanceof aq)) {
                vqVar7 = null;
            } else {
                vqVar7 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (aq) vqVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, vqVar);
                aq aqVar = (aq) vqVar;
                SubTaskState k6 = a6.k(aqVar.f());
                if (k6 != null) {
                    k6.updateStatus(aqVar.g(), Integer.valueOf(aqVar.a()), aqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(aqVar.h());
                    if (!TextUtils.isEmpty(aqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, aqVar.j(), aqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(aqVar.i());
                }
                b(a6, aqVar.f());
                return a6;
            }
            if (!(vqVar instanceof eq)) {
                vqVar8 = null;
            } else {
                vqVar8 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (eq) vqVar8)) {
                eq eqVar = (eq) vqVar;
                TaskInfo k7 = eqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, vqVar);
                SubTaskState k8 = a7.k(eqVar.f());
                if (k8 != null) {
                    if (fv.a.a(eqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(eqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(eqVar.i(), Integer.valueOf(eqVar.a()), eqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(eqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(eqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, eqVar.f());
                return a7;
            }
            if (!(vqVar instanceof cq)) {
                vqVar9 = null;
            } else {
                vqVar9 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (cq) vqVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, vqVar);
                cq cqVar = (cq) vqVar;
                SubTaskState k9 = a8.k(cqVar.f());
                if (k9 != null) {
                    k9.updateStatus(cqVar.g(), Integer.valueOf(cqVar.a()), cqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(vqVar instanceof dq)) {
                vqVar10 = null;
            } else {
                vqVar10 = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, (dq) vqVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, vqVar);
                SubTaskState k10 = a9.k(((dq) vqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (vqVar instanceof bq) {
                bqVar = vqVar;
            }
            if (Intrinsics.areEqual(vqVar, bqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, vqVar);
                bq bqVar2 = (bq) vqVar;
                SubTaskState k11 = a10.k(bqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(bqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(bqVar2.g());
                }
                return a10;
            }
            return a(bVar, vqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
