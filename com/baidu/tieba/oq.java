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
/* loaded from: classes5.dex */
public final class oq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, nr nrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, nrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(nrVar);
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
                if (ew.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(nr nrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        nr nrVar2;
        nr nrVar3;
        nr nrVar4;
        nr nrVar5;
        nr nrVar6;
        nr nrVar7;
        nr nrVar8;
        nr nrVar9;
        nr nrVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nrVar, bVar)) == null) {
            tq tqVar = null;
            if (!(nrVar instanceof yq)) {
                nrVar2 = null;
            } else {
                nrVar2 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (yq) nrVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, nrVar);
                yq yqVar = (yq) nrVar;
                a.h(yqVar.h());
                a.i(yqVar.h(), yqVar.i());
                SubTaskState k = a.k(yqVar.f());
                if (k != null) {
                    k.setInterceptor(yqVar.j());
                    k.updateStatus(yqVar.g(), Integer.valueOf(yqVar.a()), yqVar.d());
                }
                b(a, yqVar.f());
                return a;
            }
            if (!(nrVar instanceof qq)) {
                nrVar3 = null;
            } else {
                nrVar3 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (qq) nrVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, nrVar);
                qq qqVar = (qq) nrVar;
                SubTaskState k2 = a2.k(qqVar.f());
                if (k2 != null) {
                    k2.updateStatus(qqVar.g(), Integer.valueOf(qqVar.a()), qqVar.d());
                    k2.updateExtraUnRegisterMsg(qqVar.h());
                }
                return a2;
            }
            if (!(nrVar instanceof xq)) {
                nrVar4 = null;
            } else {
                nrVar4 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (xq) nrVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, nrVar);
                xq xqVar = (xq) nrVar;
                SubTaskState k3 = a3.k(xqVar.f());
                if (k3 != null) {
                    k3.updateStatus(xqVar.g(), Integer.valueOf(xqVar.a()), xqVar.d()).getTaskStatus().setInterruptErrorNo(xqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(nrVar instanceof pq)) {
                nrVar5 = null;
            } else {
                nrVar5 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (pq) nrVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, nrVar);
                pq pqVar = (pq) nrVar;
                SubTaskState k4 = a4.k(pqVar.f());
                if (k4 != null) {
                    k4.updateStatus(pqVar.g(), Integer.valueOf(pqVar.a()), pqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(nrVar instanceof rq)) {
                nrVar6 = null;
            } else {
                nrVar6 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (rq) nrVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, nrVar);
                rq rqVar = (rq) nrVar;
                SubTaskState k5 = a5.k(rqVar.f());
                if (k5 != null) {
                    k5.updateStatus(rqVar.g(), Integer.valueOf(rqVar.a()), rqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(rqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, rqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(rqVar.h());
                    }
                }
                b(a5, rqVar.f());
                return a5;
            }
            if (!(nrVar instanceof sq)) {
                nrVar7 = null;
            } else {
                nrVar7 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (sq) nrVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, nrVar);
                sq sqVar = (sq) nrVar;
                SubTaskState k6 = a6.k(sqVar.f());
                if (k6 != null) {
                    k6.updateStatus(sqVar.g(), Integer.valueOf(sqVar.a()), sqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(sqVar.h());
                    if (!TextUtils.isEmpty(sqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, sqVar.j(), sqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(sqVar.i());
                }
                b(a6, sqVar.f());
                return a6;
            }
            if (!(nrVar instanceof wq)) {
                nrVar8 = null;
            } else {
                nrVar8 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (wq) nrVar8)) {
                wq wqVar = (wq) nrVar;
                TaskInfo k7 = wqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, nrVar);
                SubTaskState k8 = a7.k(wqVar.f());
                if (k8 != null) {
                    if (xv.a.a(wqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(wqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(wqVar.i(), Integer.valueOf(wqVar.a()), wqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(wqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(wqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, wqVar.f());
                return a7;
            }
            if (!(nrVar instanceof uq)) {
                nrVar9 = null;
            } else {
                nrVar9 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (uq) nrVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, nrVar);
                uq uqVar = (uq) nrVar;
                SubTaskState k9 = a8.k(uqVar.f());
                if (k9 != null) {
                    k9.updateStatus(uqVar.g(), Integer.valueOf(uqVar.a()), uqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(nrVar instanceof vq)) {
                nrVar10 = null;
            } else {
                nrVar10 = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, (vq) nrVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, nrVar);
                SubTaskState k10 = a9.k(((vq) nrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (nrVar instanceof tq) {
                tqVar = nrVar;
            }
            if (Intrinsics.areEqual(nrVar, tqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, nrVar);
                tq tqVar2 = (tq) nrVar;
                SubTaskState k11 = a10.k(tqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(tqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(tqVar2.g());
                }
                return a10;
            }
            return a(bVar, nrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
