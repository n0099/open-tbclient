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
public final class zp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zp() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, yq yqVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, yqVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(yqVar);
            }
            return bVar2;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b b(com.baidu.bdtask.ctrl.b bVar, String str) {
        InterceptResult invokeLL;
        SubTaskState k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, str)) == null) {
            TaskInfo f = bVar.f(str);
            if (f != null && !pv.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(yq yqVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yqVar, bVar)) == null) {
            if (Intrinsics.areEqual(yqVar, (jq) (!(yqVar instanceof jq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, yqVar);
                jq jqVar = (jq) yqVar;
                a.h(jqVar.h());
                a.i(jqVar.h(), jqVar.i());
                SubTaskState k = a.k(jqVar.f());
                if (k != null) {
                    k.setInterceptor(jqVar.j());
                    k.updateStatus(jqVar.g(), Integer.valueOf(jqVar.a()), jqVar.d());
                }
                b(a, jqVar.f());
                return a;
            }
            if (Intrinsics.areEqual(yqVar, (bq) (!(yqVar instanceof bq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, yqVar);
                bq bqVar = (bq) yqVar;
                SubTaskState k2 = a2.k(bqVar.f());
                if (k2 != null) {
                    k2.updateStatus(bqVar.g(), Integer.valueOf(bqVar.a()), bqVar.d());
                    k2.updateExtraUnRegisterMsg(bqVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(yqVar, (iq) (!(yqVar instanceof iq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, yqVar);
                iq iqVar = (iq) yqVar;
                SubTaskState k3 = a3.k(iqVar.f());
                if (k3 != null) {
                    k3.updateStatus(iqVar.g(), Integer.valueOf(iqVar.a()), iqVar.d()).getTaskStatus().setInterruptErrorNo(iqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(yqVar, (aq) (!(yqVar instanceof aq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, yqVar);
                aq aqVar = (aq) yqVar;
                SubTaskState k4 = a4.k(aqVar.f());
                if (k4 != null) {
                    k4.updateStatus(aqVar.g(), Integer.valueOf(aqVar.a()), aqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(yqVar, (cq) (!(yqVar instanceof cq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, yqVar);
                cq cqVar = (cq) yqVar;
                SubTaskState k5 = a5.k(cqVar.f());
                if (k5 != null) {
                    k5.updateStatus(cqVar.g(), Integer.valueOf(cqVar.a()), cqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(cqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, cqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(cqVar.h());
                    }
                }
                b(a5, cqVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(yqVar, (dq) (!(yqVar instanceof dq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, yqVar);
                dq dqVar = (dq) yqVar;
                SubTaskState k6 = a6.k(dqVar.f());
                if (k6 != null) {
                    k6.updateStatus(dqVar.g(), Integer.valueOf(dqVar.a()), dqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(dqVar.h());
                    if (!TextUtils.isEmpty(dqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, dqVar.j(), dqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(dqVar.i());
                }
                b(a6, dqVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(yqVar, (hq) (!(yqVar instanceof hq) ? null : yqVar))) {
                hq hqVar = (hq) yqVar;
                TaskInfo k7 = hqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, yqVar);
                SubTaskState k8 = a7.k(hqVar.f());
                if (k8 != null) {
                    if (iv.a.a(hqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(hqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(hqVar.i(), Integer.valueOf(hqVar.a()), hqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(hqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(hqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, hqVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(yqVar, (fq) (!(yqVar instanceof fq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, yqVar);
                fq fqVar = (fq) yqVar;
                SubTaskState k9 = a8.k(fqVar.f());
                if (k9 != null) {
                    k9.updateStatus(fqVar.g(), Integer.valueOf(fqVar.a()), fqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(yqVar, (gq) (!(yqVar instanceof gq) ? null : yqVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, yqVar);
                SubTaskState k10 = a9.k(((gq) yqVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(yqVar, yqVar instanceof eq ? yqVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, yqVar);
                eq eqVar = (eq) yqVar;
                SubTaskState k11 = a10.k(eqVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(eqVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(eqVar.g());
                }
                return a10;
            }
            return a(bVar, yqVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
