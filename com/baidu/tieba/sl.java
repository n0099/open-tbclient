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
public final class sl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sl() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, rm rmVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, rmVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(rmVar);
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
                if (ir.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(rm rmVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        rm rmVar2;
        rm rmVar3;
        rm rmVar4;
        rm rmVar5;
        rm rmVar6;
        rm rmVar7;
        rm rmVar8;
        rm rmVar9;
        rm rmVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rmVar, bVar)) == null) {
            xl xlVar = null;
            if (!(rmVar instanceof cm)) {
                rmVar2 = null;
            } else {
                rmVar2 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (cm) rmVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, rmVar);
                cm cmVar = (cm) rmVar;
                a.h(cmVar.h());
                a.i(cmVar.h(), cmVar.i());
                SubTaskState k = a.k(cmVar.f());
                if (k != null) {
                    k.setInterceptor(cmVar.j());
                    k.updateStatus(cmVar.g(), Integer.valueOf(cmVar.a()), cmVar.d());
                }
                b(a, cmVar.f());
                return a;
            }
            if (!(rmVar instanceof ul)) {
                rmVar3 = null;
            } else {
                rmVar3 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (ul) rmVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, rmVar);
                ul ulVar = (ul) rmVar;
                SubTaskState k2 = a2.k(ulVar.f());
                if (k2 != null) {
                    k2.updateStatus(ulVar.g(), Integer.valueOf(ulVar.a()), ulVar.d());
                    k2.updateExtraUnRegisterMsg(ulVar.h());
                }
                return a2;
            }
            if (!(rmVar instanceof bm)) {
                rmVar4 = null;
            } else {
                rmVar4 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (bm) rmVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, rmVar);
                bm bmVar = (bm) rmVar;
                SubTaskState k3 = a3.k(bmVar.f());
                if (k3 != null) {
                    k3.updateStatus(bmVar.g(), Integer.valueOf(bmVar.a()), bmVar.d()).getTaskStatus().setInterruptErrorNo(bmVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(rmVar instanceof tl)) {
                rmVar5 = null;
            } else {
                rmVar5 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (tl) rmVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, rmVar);
                tl tlVar = (tl) rmVar;
                SubTaskState k4 = a4.k(tlVar.f());
                if (k4 != null) {
                    k4.updateStatus(tlVar.g(), Integer.valueOf(tlVar.a()), tlVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(rmVar instanceof vl)) {
                rmVar6 = null;
            } else {
                rmVar6 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (vl) rmVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, rmVar);
                vl vlVar = (vl) rmVar;
                SubTaskState k5 = a5.k(vlVar.f());
                if (k5 != null) {
                    k5.updateStatus(vlVar.g(), Integer.valueOf(vlVar.a()), vlVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(vlVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, vlVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(vlVar.h());
                    }
                }
                b(a5, vlVar.f());
                return a5;
            }
            if (!(rmVar instanceof wl)) {
                rmVar7 = null;
            } else {
                rmVar7 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (wl) rmVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, rmVar);
                wl wlVar = (wl) rmVar;
                SubTaskState k6 = a6.k(wlVar.f());
                if (k6 != null) {
                    k6.updateStatus(wlVar.g(), Integer.valueOf(wlVar.a()), wlVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(wlVar.h());
                    if (!TextUtils.isEmpty(wlVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, wlVar.j(), wlVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(wlVar.i());
                }
                b(a6, wlVar.f());
                return a6;
            }
            if (!(rmVar instanceof am)) {
                rmVar8 = null;
            } else {
                rmVar8 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (am) rmVar8)) {
                am amVar = (am) rmVar;
                TaskInfo k7 = amVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, rmVar);
                SubTaskState k8 = a7.k(amVar.f());
                if (k8 != null) {
                    if (br.a.a(amVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(amVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(amVar.i(), Integer.valueOf(amVar.a()), amVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(amVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(amVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, amVar.f());
                return a7;
            }
            if (!(rmVar instanceof yl)) {
                rmVar9 = null;
            } else {
                rmVar9 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (yl) rmVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, rmVar);
                yl ylVar = (yl) rmVar;
                SubTaskState k9 = a8.k(ylVar.f());
                if (k9 != null) {
                    k9.updateStatus(ylVar.g(), Integer.valueOf(ylVar.a()), ylVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(rmVar instanceof zl)) {
                rmVar10 = null;
            } else {
                rmVar10 = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, (zl) rmVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, rmVar);
                SubTaskState k10 = a9.k(((zl) rmVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (rmVar instanceof xl) {
                xlVar = rmVar;
            }
            if (Intrinsics.areEqual(rmVar, xlVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, rmVar);
                xl xlVar2 = (xl) rmVar;
                SubTaskState k11 = a10.k(xlVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(xlVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(xlVar2.g());
                }
                return a10;
            }
            return a(bVar, rmVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
