package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.component.buoy.BuoyComponent;
import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.component.buoy.TaskBuoyViewModel;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.cq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.ranges.RangesKt___RangesKt;
/* loaded from: classes6.dex */
public class wp extends BuoyComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean i;
    public cq j;
    public String k;
    public volatile long l;
    public final xp m;
    public final TaskInfo n;

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public float s(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, taskInfo, taskStatus)) == null) {
            return 1.0f;
        }
        return invokeLL.floatValue;
    }

    /* loaded from: classes6.dex */
    public static final class a extends cq.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(wp wpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wpVar;
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) {
                return;
            }
            this.a.C(j2);
            wp wpVar = this.a;
            wpVar.update(wpVar.n, null);
            cq D = this.a.D();
            if (D != null) {
                D.a(j, j2);
            }
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.L(true);
                cq D = this.a.D();
                if (D != null) {
                    D.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                wp.M(this.a, false, 1, null);
                cq D = this.a.D();
                if (D != null) {
                    D.onFinish();
                }
            }
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.L(true);
                cq D = this.a.D();
                if (D != null) {
                    D.onPause();
                }
            }
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                wp.M(this.a, false, 1, null);
                cq D = this.a.D();
                if (D != null) {
                    D.onResume();
                }
            }
        }

        @Override // com.baidu.tieba.cq.a, com.baidu.tieba.cq
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                wp.M(this.a, false, 1, null);
                cq D = this.a.D();
                if (D != null) {
                    D.onStart();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wp(ss<TaskBuoyViewData, TaskBuoyViewModel> ssVar, xp xpVar, TaskInfo taskInfo) {
        super(ssVar, xpVar, taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ssVar, xpVar, taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ss) objArr2[0], (TaskBuoyViewModel) objArr2[1], (TaskInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = xpVar;
        this.n = taskInfo;
        this.i = true;
        this.k = "";
        xpVar.o(new a(this));
    }

    public final synchronized void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            synchronized (this) {
                this.l += j;
            }
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.i = z;
            this.m.m();
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i = z;
            super.o(z);
            this.m.q();
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public boolean t(TaskStatus taskStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, taskStatus)) == null) {
            return taskStatus.isDuplicated();
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public long r(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, taskInfo, taskStatus)) == null) {
            if (!taskInfo.isVisitAction()) {
                return 0L;
            }
            return taskInfo.getTaskRule().getFormatStay();
        }
        return invokeLL.longValue;
    }

    public static /* synthetic */ void M(wp wpVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            wpVar.L(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncVisitTime");
    }

    public final cq D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (cq) invokeV.objValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TaskState m = BDPTask.m.m(this.n.getActionId());
            if (m == null || !m.getTaskStatus().isEnable() || !u()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            G(true);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I("");
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            K("");
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m.m();
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || !E()) {
            return;
        }
        if (BDPTask.m.l(this.n.getActionId(), str)) {
            BDPTask.m.i(this.n.getActionId(), 0L, str);
            return;
        }
        this.k = str;
        this.i = true;
        this.m.n();
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || !E()) {
            return;
        }
        if (BDPTask.m.l(this.n.getActionId(), str)) {
            this.m.m();
            BDPTask.m.i(this.n.getActionId(), 0L, str);
            return;
        }
        this.k = str;
        this.i = true;
        L(true);
        this.m.p();
    }

    public final synchronized void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            synchronized (this) {
                if (z) {
                    if (this.l == 0) {
                        return;
                    }
                }
                if (this.i) {
                    long j = this.l;
                    this.l = 0L;
                    BDPTask.m.i(this.n.getActionId(), j, this.k);
                }
            }
        }
    }

    @Override // com.baidu.tieba.np
    public void b(TaskInfo taskInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, taskInfo, i, str) == null) {
            if (i == 304) {
                update(taskInfo, null);
            } else {
                o(false);
            }
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public float q(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, taskInfo, taskStatus)) == null) {
            if (!taskInfo.isVisitAction()) {
                return 0.0f;
            }
            long stay = taskInfo.getTaskRule().getStay();
            if (stay == 0) {
                return 0.0f;
            }
            return RangesKt___RangesKt.coerceAtMost(((float) (taskStatus.getProcess().getStayDurTimeMs() + this.l)) / ((float) stay), 1.0f);
        }
        return invokeLL.floatValue;
    }
}
