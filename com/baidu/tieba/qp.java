package com.baidu.tieba;

import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class qp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskStatus a;
    public final np b;
    public final TaskProcessData c;
    public final String d;

    public qp(TaskStatus taskStatus, np npVar, TaskProcessData taskProcessData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskStatus, npVar, taskProcessData, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = taskStatus;
        this.b = npVar;
        this.c = taskProcessData;
        this.d = str;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "taskStatus:" + this.a + "\n uiConfig:" + this.b + "\n totalProcess:" + this.c + "\n extra:" + this.d;
        }
        return (String) invokeV.objValue;
    }
}
