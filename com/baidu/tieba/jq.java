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
public final class jq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, ir irVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, irVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(irVar);
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
                if (zv.a.c(f.getTaskRule().getExpireTime())) {
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

    public final com.baidu.bdtask.ctrl.b c(ir irVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        ir irVar2;
        ir irVar3;
        ir irVar4;
        ir irVar5;
        ir irVar6;
        ir irVar7;
        ir irVar8;
        ir irVar9;
        ir irVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, irVar, bVar)) == null) {
            oq oqVar = null;
            if (!(irVar instanceof tq)) {
                irVar2 = null;
            } else {
                irVar2 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (tq) irVar2)) {
                com.baidu.bdtask.ctrl.b a = a(bVar, irVar);
                tq tqVar = (tq) irVar;
                a.h(tqVar.h());
                a.i(tqVar.h(), tqVar.i());
                SubTaskState k = a.k(tqVar.f());
                if (k != null) {
                    k.setInterceptor(tqVar.j());
                    k.updateStatus(tqVar.g(), Integer.valueOf(tqVar.a()), tqVar.d());
                }
                b(a, tqVar.f());
                return a;
            }
            if (!(irVar instanceof lq)) {
                irVar3 = null;
            } else {
                irVar3 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (lq) irVar3)) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, irVar);
                lq lqVar = (lq) irVar;
                SubTaskState k2 = a2.k(lqVar.f());
                if (k2 != null) {
                    k2.updateStatus(lqVar.g(), Integer.valueOf(lqVar.a()), lqVar.d());
                    k2.updateExtraUnRegisterMsg(lqVar.h());
                }
                return a2;
            }
            if (!(irVar instanceof sq)) {
                irVar4 = null;
            } else {
                irVar4 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (sq) irVar4)) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, irVar);
                sq sqVar = (sq) irVar;
                SubTaskState k3 = a3.k(sqVar.f());
                if (k3 != null) {
                    k3.updateStatus(sqVar.g(), Integer.valueOf(sqVar.a()), sqVar.d()).getTaskStatus().setInterruptErrorNo(sqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (!(irVar instanceof kq)) {
                irVar5 = null;
            } else {
                irVar5 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (kq) irVar5)) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, irVar);
                kq kqVar = (kq) irVar;
                SubTaskState k4 = a4.k(kqVar.f());
                if (k4 != null) {
                    k4.updateStatus(kqVar.g(), Integer.valueOf(kqVar.a()), kqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (!(irVar instanceof mq)) {
                irVar6 = null;
            } else {
                irVar6 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (mq) irVar6)) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, irVar);
                mq mqVar = (mq) irVar;
                SubTaskState k5 = a5.k(mqVar.f());
                if (k5 != null) {
                    k5.updateStatus(mqVar.g(), Integer.valueOf(mqVar.a()), mqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(mqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, mqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(mqVar.h());
                    }
                }
                b(a5, mqVar.f());
                return a5;
            }
            if (!(irVar instanceof nq)) {
                irVar7 = null;
            } else {
                irVar7 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (nq) irVar7)) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, irVar);
                nq nqVar = (nq) irVar;
                SubTaskState k6 = a6.k(nqVar.f());
                if (k6 != null) {
                    k6.updateStatus(nqVar.g(), Integer.valueOf(nqVar.a()), nqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(nqVar.h());
                    if (!TextUtils.isEmpty(nqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, nqVar.j(), nqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(nqVar.i());
                }
                b(a6, nqVar.f());
                return a6;
            }
            if (!(irVar instanceof rq)) {
                irVar8 = null;
            } else {
                irVar8 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (rq) irVar8)) {
                rq rqVar = (rq) irVar;
                TaskInfo k7 = rqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, irVar);
                SubTaskState k8 = a7.k(rqVar.f());
                if (k8 != null) {
                    if (sv.a.a(rqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(rqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(rqVar.i(), Integer.valueOf(rqVar.a()), rqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(rqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(rqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, rqVar.f());
                return a7;
            }
            if (!(irVar instanceof pq)) {
                irVar9 = null;
            } else {
                irVar9 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (pq) irVar9)) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, irVar);
                pq pqVar = (pq) irVar;
                SubTaskState k9 = a8.k(pqVar.f());
                if (k9 != null) {
                    k9.updateStatus(pqVar.g(), Integer.valueOf(pqVar.a()), pqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (!(irVar instanceof qq)) {
                irVar10 = null;
            } else {
                irVar10 = irVar;
            }
            if (Intrinsics.areEqual(irVar, (qq) irVar10)) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, irVar);
                SubTaskState k10 = a9.k(((qq) irVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (irVar instanceof oq) {
                oqVar = irVar;
            }
            if (Intrinsics.areEqual(irVar, oqVar)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, irVar);
                oq oqVar2 = (oq) irVar;
                SubTaskState k11 = a10.k(oqVar2.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(oqVar2.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(oqVar2.g());
                }
                return a10;
            }
            return a(bVar, irVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
