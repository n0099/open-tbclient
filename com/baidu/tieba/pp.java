package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.qp;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class pp implements qp {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final rp a;
    public final com.baidu.bdtask.strategy.e b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448314285, "Lcom/baidu/tieba/pp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448314285, "Lcom/baidu/tieba/pp;");
                return;
            }
        }
        c = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public final pp a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new pp(null);
            }
            return (pp) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public pp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new rp();
        this.b = new com.baidu.bdtask.strategy.e();
    }

    public /* synthetic */ pp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.baidu.tieba.qp
    public void a(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            qp.a.c(this, subTaskState);
            if (subTaskState.getTaskInfo().isInitiActiveTask()) {
                this.a.a(subTaskState);
            } else if (subTaskState.getTaskInfo().isPassiveTask()) {
                this.b.a(subTaskState);
            }
        }
    }

    public void c(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subTaskState) == null) {
            if (subTaskState.getTaskInfo().isInitiActiveTask()) {
                this.a.c(subTaskState);
            } else if (subTaskState.getTaskInfo().isPassiveTask()) {
                this.b.c(subTaskState);
            }
        }
    }

    @Override // com.baidu.tieba.qp
    public boolean b(TaskInfo taskInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i)) == null) {
            if (taskInfo.isInitiActiveTask()) {
                return this.a.b(taskInfo, i);
            }
            if (taskInfo.isPassiveTask()) {
                return this.b.b(taskInfo, i);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
