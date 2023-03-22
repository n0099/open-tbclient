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
public final class vp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vp() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, uq uqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, uqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(uqVar);
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
                if (lv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(uq uqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        uq uqVar2;
        uq uqVar3;
        uq uqVar4;
        uq uqVar5;
        uq uqVar6;
        uq uqVar7;
        uq uqVar8;
        uq uqVar9;
        uq uqVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uqVar, bVar)) == null) {
            aq aqVar = null;
            if (!(uqVar instanceof fq)) {
                uqVar2 = null;
            } else {
                uqVar2 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (fq) uqVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, uqVar);
                fq fqVar = (fq) uqVar;
                a.h(fqVar.h());
                a.i(fqVar.h(), fqVar.i());
                SubTaskState k = a.k(fqVar.f());
                if (k != null) {
                    k.setInterceptor(fqVar.j());
                    k.updateStatus(fqVar.g(), Integer.valueOf(fqVar.a()), fqVar.d());
                }
                b(a, fqVar.f());
                return a;
            }
            if (!(uqVar instanceof xp)) {
                uqVar3 = null;
            } else {
                uqVar3 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (xp) uqVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, uqVar);
                xp xpVar = (xp) uqVar;
                SubTaskState k2 = a2.k(xpVar.f());
                if (k2 != null) {
                    k2.updateStatus(xpVar.g(), Integer.valueOf(xpVar.a()), xpVar.d());
                    k2.updateExtraUnRegisterMsg(xpVar.h());
                }
                return a2;
            }
            if (!(uqVar instanceof eq)) {
                uqVar4 = null;
            } else {
                uqVar4 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (eq) uqVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, uqVar);
                eq eqVar = (eq) uqVar;
                SubTaskState k3 = a3.k(eqVar.f());
                if (k3 != null) {
                    k3.updateStatus(eqVar.g(), Integer.valueOf(eqVar.a()), eqVar.d()).getTaskStatus().setInterruptErrorNo(eqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(uqVar instanceof wp)) {
                uqVar5 = null;
            } else {
                uqVar5 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (wp) uqVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, uqVar);
                wp wpVar = (wp) uqVar;
                SubTaskState k4 = a4.k(wpVar.f());
                if (k4 != null) {
                    k4.updateStatus(wpVar.g(), Integer.valueOf(wpVar.a()), wpVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(uqVar instanceof yp)) {
                uqVar6 = null;
            } else {
                uqVar6 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (yp) uqVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, uqVar);
                yp ypVar = (yp) uqVar;
                SubTaskState k5 = a5.k(ypVar.f());
                if (k5 != null) {
                    k5.updateStatus(ypVar.g(), Integer.valueOf(ypVar.a()), ypVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(ypVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, ypVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(ypVar.h());
                    }
                }
                b(a5, ypVar.f());
                return a5;
            }
            if (!(uqVar instanceof zp)) {
                uqVar7 = null;
            } else {
                uqVar7 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (zp) uqVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, uqVar);
                zp zpVar = (zp) uqVar;
                SubTaskState k6 = a6.k(zpVar.f());
                if (k6 != null) {
                    k6.updateStatus(zpVar.g(), Integer.valueOf(zpVar.a()), zpVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(zpVar.h());
                    if (!TextUtils.isEmpty(zpVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, zpVar.j(), zpVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(zpVar.i());
                }
                b(a6, zpVar.f());
                return a6;
            }
            if (!(uqVar instanceof dq)) {
                uqVar8 = null;
            } else {
                uqVar8 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (dq) uqVar8)) {
                dq dqVar = (dq) uqVar;
                TaskInfo k7 = dqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, uqVar);
                SubTaskState k8 = a7.k(dqVar.f());
                if (k8 != null) {
                    if (ev.a.a(dqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(dqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(dqVar.i(), Integer.valueOf(dqVar.a()), dqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(dqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(dqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, dqVar.f());
                return a7;
            }
            if (!(uqVar instanceof bq)) {
                uqVar9 = null;
            } else {
                uqVar9 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (bq) uqVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, uqVar);
                bq bqVar = (bq) uqVar;
                SubTaskState k9 = a8.k(bqVar.f());
                if (k9 != null) {
                    k9.updateStatus(bqVar.g(), Integer.valueOf(bqVar.a()), bqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(uqVar instanceof cq)) {
                uqVar10 = null;
            } else {
                uqVar10 = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, (cq) uqVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, uqVar);
                SubTaskState k10 = a9.k(((cq) uqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (uqVar instanceof aq) {
                aqVar = uqVar;
            }
            if (Intrinsics.areEqual(uqVar, aqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, uqVar);
                aq aqVar2 = (aq) uqVar;
                SubTaskState k11 = a10.k(aqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(aqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(aqVar2.g());
                }
                return a10;
            }
            return a(bVar, uqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
