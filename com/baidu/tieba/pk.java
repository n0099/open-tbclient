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
import com.baidu.tieba.vk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.ranges.RangesKt___RangesKt;
/* loaded from: classes7.dex */
public class pk extends BuoyComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean i;
    public vk j;
    public String k;
    public volatile long l;
    public final qk m;
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

    /* loaded from: classes7.dex */
    public static final class a extends vk.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pk a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(pk pkVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pkVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pkVar;
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.D(j2);
                pk pkVar = this.a;
                pkVar.z(pkVar.n, null);
                vk E = this.a.E();
                if (E != null) {
                    E.a(j, j2);
                }
            }
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M(true);
                vk E = this.a.E();
                if (E != null) {
                    E.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                pk.N(this.a, false, 1, null);
                vk E = this.a.E();
                if (E != null) {
                    E.onFinish();
                }
            }
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.M(true);
                vk E = this.a.E();
                if (E != null) {
                    E.onPause();
                }
            }
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                pk.N(this.a, false, 1, null);
                vk E = this.a.E();
                if (E != null) {
                    E.onResume();
                }
            }
        }

        @Override // com.baidu.tieba.vk.a, com.baidu.tieba.vk
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                pk.N(this.a, false, 1, null);
                vk E = this.a.E();
                if (E != null) {
                    E.onStart();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pk(ln<TaskBuoyViewData, TaskBuoyViewModel> lnVar, qk qkVar, TaskInfo taskInfo) {
        super(lnVar, qkVar, taskInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lnVar, qkVar, taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ln) objArr2[0], (TaskBuoyViewModel) objArr2[1], (TaskInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = qkVar;
        this.n = taskInfo;
        this.i = true;
        this.k = "";
        qkVar.o(new a(this));
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

    public final synchronized void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            synchronized (this) {
                this.l += j;
            }
        }
    }

    public void H(boolean z) {
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

    public static /* synthetic */ void N(pk pkVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            pkVar.M(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncVisitTime");
    }

    public final vk E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (vk) invokeV.objValue;
    }

    public final boolean F() {
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

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            H(true);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            J("");
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            L("");
        }
    }

    @Override // com.baidu.bdtask.component.buoy.BuoyComponent
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.m.m();
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || !F()) {
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

    public void L(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || !F()) {
            return;
        }
        if (BDPTask.m.l(this.n.getActionId(), str)) {
            this.m.m();
            BDPTask.m.i(this.n.getActionId(), 0L, str);
            return;
        }
        this.k = str;
        this.i = true;
        M(true);
        this.m.p();
    }

    public final synchronized void M(boolean z) {
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

    @Override // com.baidu.tieba.gk
    public void b(TaskInfo taskInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, taskInfo, i, str) == null) {
            if (i == 304) {
                z(taskInfo, null);
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
