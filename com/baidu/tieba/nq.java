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
public final class nq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public nq() {
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

    public final com.baidu.bdtask.ctrl.b a(com.baidu.bdtask.ctrl.b bVar, mr mrVar) {
        InterceptResult invokeLL;
        com.baidu.bdtask.ctrl.b bVar2;
        TaskStatus taskStatus;
        TaskStatusRuntime taskStatusRuntime;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, mrVar)) == null) {
            if (bVar == null || (bVar2 = bVar.e()) == null) {
                bVar2 = new com.baidu.bdtask.ctrl.b();
            }
            SubTaskState c = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c != null) {
                c.processRuleDataMaxValueFix();
            }
            SubTaskState c2 = com.baidu.bdtask.ctrl.b.c(bVar2, null, 1, null);
            if (c2 != null && (taskStatus = c2.getTaskStatus()) != null && (taskStatusRuntime = taskStatus.getTaskStatusRuntime()) != null) {
                taskStatusRuntime.setCurAction(mrVar);
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
            if (f != null && !dw.a.c(f.getTaskRule().getExpireTime()) && (k = bVar.k(str)) != null) {
                k.updateStatus(22, 103, "task is expired");
                k.getTaskStatus().clearProcess();
            }
            return bVar;
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }

    public final com.baidu.bdtask.ctrl.b c(mr mrVar, com.baidu.bdtask.ctrl.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mrVar, bVar)) == null) {
            if (Intrinsics.areEqual(mrVar, (xq) (!(mrVar instanceof xq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a = a(bVar, mrVar);
                xq xqVar = (xq) mrVar;
                a.h(xqVar.h());
                a.i(xqVar.h(), xqVar.i());
                SubTaskState k = a.k(xqVar.f());
                if (k != null) {
                    k.setInterceptor(xqVar.j());
                    k.updateStatus(xqVar.g(), Integer.valueOf(xqVar.a()), xqVar.d());
                }
                b(a, xqVar.f());
                return a;
            }
            if (Intrinsics.areEqual(mrVar, (pq) (!(mrVar instanceof pq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a2 = a(bVar, mrVar);
                pq pqVar = (pq) mrVar;
                SubTaskState k2 = a2.k(pqVar.f());
                if (k2 != null) {
                    k2.updateStatus(pqVar.g(), Integer.valueOf(pqVar.a()), pqVar.d());
                    k2.updateExtraUnRegisterMsg(pqVar.h());
                }
                return a2;
            }
            if (Intrinsics.areEqual(mrVar, (wq) (!(mrVar instanceof wq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a3 = a(bVar, mrVar);
                wq wqVar = (wq) mrVar;
                SubTaskState k3 = a3.k(wqVar.f());
                if (k3 != null) {
                    k3.updateStatus(wqVar.g(), Integer.valueOf(wqVar.a()), wqVar.d()).getTaskStatus().setInterruptErrorNo(wqVar.h());
                    k3.clearProcess();
                    k3.cleanDuplicateId();
                }
                return a3;
            }
            if (Intrinsics.areEqual(mrVar, (oq) (!(mrVar instanceof oq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a4 = a(bVar, mrVar);
                oq oqVar = (oq) mrVar;
                SubTaskState k4 = a4.k(oqVar.f());
                if (k4 != null) {
                    k4.updateStatus(oqVar.g(), Integer.valueOf(oqVar.a()), oqVar.d());
                    k4.reset2Running(k4.getTaskInfo().isPassiveTask());
                }
                return a4;
            }
            if (Intrinsics.areEqual(mrVar, (qq) (!(mrVar instanceof qq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a5 = a(bVar, mrVar);
                qq qqVar = (qq) mrVar;
                SubTaskState k5 = a5.k(qqVar.f());
                if (k5 != null) {
                    k5.updateStatus(qqVar.g(), Integer.valueOf(qqVar.a()), qqVar.d());
                    TaskProcess process = k5.getTaskStatus().getProcess();
                    if (!TextUtils.isEmpty(qqVar.i())) {
                        process.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, qqVar.i(), 1L, 0L, 4, null));
                    }
                    process.addClickNumber();
                    if (k5.getTaskInfo().getTaskRule().isNeedUnique()) {
                        process.cacheDuplicateId(qqVar.h());
                    }
                }
                b(a5, qqVar.f());
                return a5;
            }
            if (Intrinsics.areEqual(mrVar, (rq) (!(mrVar instanceof rq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a6 = a(bVar, mrVar);
                rq rqVar = (rq) mrVar;
                SubTaskState k6 = a6.k(rqVar.f());
                if (k6 != null) {
                    k6.updateStatus(rqVar.g(), Integer.valueOf(rqVar.a()), rqVar.d());
                    TaskStatus taskStatus = k6.getTaskStatus();
                    TaskProcess process2 = taskStatus.getProcess();
                    process2.addStayTime(rqVar.h());
                    if (!TextUtils.isEmpty(rqVar.j())) {
                        process2.addEnvTag(TaskEnvTag.a.a(TaskEnvTag.Companion, rqVar.j(), rqVar.h(), 0L, 4, null));
                    }
                    taskStatus.getTaskStatusRuntime().setCurDuplicateId(rqVar.i());
                }
                b(a6, rqVar.f());
                return a6;
            }
            if (Intrinsics.areEqual(mrVar, (vq) (!(mrVar instanceof vq) ? null : mrVar))) {
                vq vqVar = (vq) mrVar;
                TaskInfo k7 = vqVar.k();
                com.baidu.bdtask.ctrl.b a7 = a(bVar, mrVar);
                SubTaskState k8 = a7.k(vqVar.f());
                if (k8 != null) {
                    if (wv.a.a(vqVar.a()) && k8.getTaskInfo().getTaskRule().isNeedSkipRequestError()) {
                        k8.updateStatus(vqVar.i(), 0, "");
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(true);
                    } else {
                        k8.updateStatus(vqVar.i(), Integer.valueOf(vqVar.a()), vqVar.d());
                        k8.updateTaskInfoByMerge(k7);
                        k8.updateTaskInfoWithResponse(vqVar.j());
                        k8.getTaskStatus().getTaskStatusRuntime().setResponseDataIsCache(false);
                        if (k8.getTaskInfo().getTaskRule().isNeedUnique() && k8.getTaskInfo().isVisitAction()) {
                            k8.getTaskStatus().getProcess().cacheDuplicateId(vqVar.l());
                        }
                        k8.clearProcessTags();
                        k8.addExitOnce();
                    }
                }
                b(a7, vqVar.f());
                return a7;
            }
            if (Intrinsics.areEqual(mrVar, (tq) (!(mrVar instanceof tq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a8 = a(bVar, mrVar);
                tq tqVar = (tq) mrVar;
                SubTaskState k9 = a8.k(tqVar.f());
                if (k9 != null) {
                    k9.updateStatus(tqVar.g(), Integer.valueOf(tqVar.a()), tqVar.d()).getTaskStatus().getTaskStatusRuntime().setDuplicated(true);
                }
                return a8;
            }
            if (Intrinsics.areEqual(mrVar, (uq) (!(mrVar instanceof uq) ? null : mrVar))) {
                com.baidu.bdtask.ctrl.b a9 = a(bVar, mrVar);
                SubTaskState k10 = a9.k(((uq) mrVar).f());
                if (k10 != null) {
                    k10.resetExit();
                }
                return a9;
            }
            if (Intrinsics.areEqual(mrVar, mrVar instanceof sq ? mrVar : null)) {
                com.baidu.bdtask.ctrl.b a10 = a(bVar, mrVar);
                sq sqVar = (sq) mrVar;
                SubTaskState k11 = a10.k(sqVar.f());
                if (k11 != null && k11.getTaskInfo().getTaskRule().isNeedUnique() && !TextUtils.isEmpty(sqVar.g())) {
                    k11.getTaskStatus().getProcess().cacheDuplicateId(sqVar.g());
                }
                return a10;
            }
            return a(bVar, mrVar);
        }
        return (com.baidu.bdtask.ctrl.b) invokeLL.objValue;
    }
}
