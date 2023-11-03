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
public final class rl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rl() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, qm qmVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, qmVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(qmVar);
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
                if (hr.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(qm qmVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        qm qmVar2;
        qm qmVar3;
        qm qmVar4;
        qm qmVar5;
        qm qmVar6;
        qm qmVar7;
        qm qmVar8;
        qm qmVar9;
        qm qmVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, qmVar, bVar)) == null) {
            wl wlVar = null;
            if (!(qmVar instanceof bm)) {
                qmVar2 = null;
            } else {
                qmVar2 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (bm) qmVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, qmVar);
                bm bmVar = (bm) qmVar;
                a.h(bmVar.h());
                a.i(bmVar.h(), bmVar.i());
                SubTaskState k = a.k(bmVar.f());
                if (k != null) {
                    k.setInterceptor(bmVar.j());
                    k.updateStatus(bmVar.g(), Integer.valueOf(bmVar.a()), bmVar.d());
                }
                b(a, bmVar.f());
                return a;
            }
            if (!(qmVar instanceof tl)) {
                qmVar3 = null;
            } else {
                qmVar3 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (tl) qmVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, qmVar);
                tl tlVar = (tl) qmVar;
                SubTaskState k2 = a2.k(tlVar.f());
                if (k2 != null) {
                    k2.updateStatus(tlVar.g(), Integer.valueOf(tlVar.a()), tlVar.d());
                    k2.updateExtraUnRegisterMsg(tlVar.h());
                }
                return a2;
            }
            if (!(qmVar instanceof am)) {
                qmVar4 = null;
            } else {
                qmVar4 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (am) qmVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, qmVar);
                am amVar = (am) qmVar;
                SubTaskState k3 = a3.k(amVar.f());
                if (k3 != null) {
                    k3.updateStatus(amVar.g(), Integer.valueOf(amVar.a()), amVar.d()).getTaskStatus().setInterruptErrorNo(amVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(qmVar instanceof sl)) {
                qmVar5 = null;
            } else {
                qmVar5 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (sl) qmVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, qmVar);
                sl slVar = (sl) qmVar;
                SubTaskState k4 = a4.k(slVar.f());
                if (k4 != null) {
                    k4.updateStatus(slVar.g(), Integer.valueOf(slVar.a()), slVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(qmVar instanceof ul)) {
                qmVar6 = null;
            } else {
                qmVar6 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (ul) qmVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, qmVar);
                ul ulVar = (ul) qmVar;
                SubTaskState k5 = a5.k(ulVar.f());
                if (k5 != null) {
                    k5.updateStatus(ulVar.g(), Integer.valueOf(ulVar.a()), ulVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(ulVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, ulVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(ulVar.h());
                    }
                }
                b(a5, ulVar.f());
                return a5;
            }
            if (!(qmVar instanceof vl)) {
                qmVar7 = null;
            } else {
                qmVar7 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (vl) qmVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, qmVar);
                vl vlVar = (vl) qmVar;
                SubTaskState k6 = a6.k(vlVar.f());
                if (k6 != null) {
                    k6.updateStatus(vlVar.g(), Integer.valueOf(vlVar.a()), vlVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(vlVar.h());
                    if (!TextUtils.isEmpty(vlVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, vlVar.j(), vlVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(vlVar.i());
                }
                b(a6, vlVar.f());
                return a6;
            }
            if (!(qmVar instanceof zl)) {
                qmVar8 = null;
            } else {
                qmVar8 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (zl) qmVar8)) {
                zl zlVar = (zl) qmVar;
                TaskInfo k7 = zlVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, qmVar);
                SubTaskState k8 = a7.k(zlVar.f());
                if (k8 != null) {
                    if (ar.a.a(zlVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(zlVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(zlVar.i(), Integer.valueOf(zlVar.a()), zlVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(zlVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(zlVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, zlVar.f());
                return a7;
            }
            if (!(qmVar instanceof xl)) {
                qmVar9 = null;
            } else {
                qmVar9 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (xl) qmVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, qmVar);
                xl xlVar = (xl) qmVar;
                SubTaskState k9 = a8.k(xlVar.f());
                if (k9 != null) {
                    k9.updateStatus(xlVar.g(), Integer.valueOf(xlVar.a()), xlVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(qmVar instanceof yl)) {
                qmVar10 = null;
            } else {
                qmVar10 = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, (yl) qmVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, qmVar);
                SubTaskState k10 = a9.k(((yl) qmVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (qmVar instanceof wl) {
                wlVar = qmVar;
            }
            if (Intrinsics.areEqual(qmVar, wlVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, qmVar);
                wl wlVar2 = (wl) qmVar;
                SubTaskState k11 = a10.k(wlVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(wlVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(wlVar2.g());
                }
                return a10;
            }
            return a(bVar, qmVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
