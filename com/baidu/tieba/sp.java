package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes8.dex */
public final class sp {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.baidu.bdtask.strategy.impl.lifecycle.b a;
    public final com.baidu.bdtask.strategy.impl.lifecycle.c b;
    public final com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, ll> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317168, "Lcom/baidu/tieba/sp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317168, "Lcom/baidu/tieba/sp;");
                return;
            }
        }
        d = new a(null);
    }

    /* loaded from: classes8.dex */
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final sp a(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, ll> dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                return new sp(dVar, null);
            }
            return (sp) invokeL.objValue;
        }
    }

    public sp(com.baidu.bdtask.framework.redux.d<com.baidu.bdtask.ctrl.b, ll> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = dVar;
        this.a = new com.baidu.bdtask.strategy.impl.lifecycle.b(dVar);
        this.b = new com.baidu.bdtask.strategy.impl.lifecycle.c(this.c);
    }

    public /* synthetic */ sp(com.baidu.bdtask.framework.redux.d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }

    public void a(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.b.h(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.h(subTaskState);
            }
        }
    }

    public void b(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.b.i(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.i(subTaskState);
            }
        }
    }

    public void c(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.b.j(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.j(subTaskState);
            }
        }
    }

    public void d(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.b.k(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.k(subTaskState);
            }
        }
    }

    public void e(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, subTaskState) == null) {
            if (f(subTaskState).isPassiveTask()) {
                this.b.l(subTaskState);
            } else if (f(subTaskState).isInitiActiveTask()) {
                this.a.l(subTaskState);
            }
        }
    }

    public final TaskInfo f(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, subTaskState)) == null) {
            return subTaskState.getTaskInfo();
        }
        return (TaskInfo) invokeL.objValue;
    }
}
