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
/* loaded from: classes7.dex */
public final class xp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xp() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, wq wqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, wqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(wqVar);
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
                if (nv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(wq wqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        wq wqVar2;
        wq wqVar3;
        wq wqVar4;
        wq wqVar5;
        wq wqVar6;
        wq wqVar7;
        wq wqVar8;
        wq wqVar9;
        wq wqVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wqVar, bVar)) == null) {
            cq cqVar = null;
            if (!(wqVar instanceof hq)) {
                wqVar2 = null;
            } else {
                wqVar2 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (hq) wqVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, wqVar);
                hq hqVar = (hq) wqVar;
                a.h(hqVar.h());
                a.i(hqVar.h(), hqVar.i());
                SubTaskState k = a.k(hqVar.f());
                if (k != null) {
                    k.setInterceptor(hqVar.j());
                    k.updateStatus(hqVar.g(), Integer.valueOf(hqVar.a()), hqVar.d());
                }
                b(a, hqVar.f());
                return a;
            }
            if (!(wqVar instanceof zp)) {
                wqVar3 = null;
            } else {
                wqVar3 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (zp) wqVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, wqVar);
                zp zpVar = (zp) wqVar;
                SubTaskState k2 = a2.k(zpVar.f());
                if (k2 != null) {
                    k2.updateStatus(zpVar.g(), Integer.valueOf(zpVar.a()), zpVar.d());
                    k2.updateExtraUnRegisterMsg(zpVar.h());
                }
                return a2;
            }
            if (!(wqVar instanceof gq)) {
                wqVar4 = null;
            } else {
                wqVar4 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (gq) wqVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, wqVar);
                gq gqVar = (gq) wqVar;
                SubTaskState k3 = a3.k(gqVar.f());
                if (k3 != null) {
                    k3.updateStatus(gqVar.g(), Integer.valueOf(gqVar.a()), gqVar.d()).getTaskStatus().setInterruptErrorNo(gqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(wqVar instanceof yp)) {
                wqVar5 = null;
            } else {
                wqVar5 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (yp) wqVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, wqVar);
                yp ypVar = (yp) wqVar;
                SubTaskState k4 = a4.k(ypVar.f());
                if (k4 != null) {
                    k4.updateStatus(ypVar.g(), Integer.valueOf(ypVar.a()), ypVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(wqVar instanceof aq)) {
                wqVar6 = null;
            } else {
                wqVar6 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (aq) wqVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, wqVar);
                aq aqVar = (aq) wqVar;
                SubTaskState k5 = a5.k(aqVar.f());
                if (k5 != null) {
                    k5.updateStatus(aqVar.g(), Integer.valueOf(aqVar.a()), aqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(aqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, aqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(aqVar.h());
                    }
                }
                b(a5, aqVar.f());
                return a5;
            }
            if (!(wqVar instanceof bq)) {
                wqVar7 = null;
            } else {
                wqVar7 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (bq) wqVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, wqVar);
                bq bqVar = (bq) wqVar;
                SubTaskState k6 = a6.k(bqVar.f());
                if (k6 != null) {
                    k6.updateStatus(bqVar.g(), Integer.valueOf(bqVar.a()), bqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(bqVar.h());
                    if (!TextUtils.isEmpty(bqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, bqVar.j(), bqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(bqVar.i());
                }
                b(a6, bqVar.f());
                return a6;
            }
            if (!(wqVar instanceof fq)) {
                wqVar8 = null;
            } else {
                wqVar8 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (fq) wqVar8)) {
                fq fqVar = (fq) wqVar;
                TaskInfo k7 = fqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, wqVar);
                SubTaskState k8 = a7.k(fqVar.f());
                if (k8 != null) {
                    if (gv.a.a(fqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(fqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(fqVar.i(), Integer.valueOf(fqVar.a()), fqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(fqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(fqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, fqVar.f());
                return a7;
            }
            if (!(wqVar instanceof dq)) {
                wqVar9 = null;
            } else {
                wqVar9 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (dq) wqVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, wqVar);
                dq dqVar = (dq) wqVar;
                SubTaskState k9 = a8.k(dqVar.f());
                if (k9 != null) {
                    k9.updateStatus(dqVar.g(), Integer.valueOf(dqVar.a()), dqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(wqVar instanceof eq)) {
                wqVar10 = null;
            } else {
                wqVar10 = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, (eq) wqVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, wqVar);
                SubTaskState k10 = a9.k(((eq) wqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (wqVar instanceof cq) {
                cqVar = wqVar;
            }
            if (Intrinsics.areEqual(wqVar, cqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, wqVar);
                cq cqVar2 = (cq) wqVar;
                SubTaskState k11 = a10.k(cqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(cqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(cqVar2.g());
                }
                return a10;
            }
            return a(bVar, wqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
