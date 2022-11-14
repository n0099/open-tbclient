package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class pq extends sq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public TaskResponseData e;
    public TaskInfo f;
    public final String g;

    @Override // com.baidu.tieba.gr
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "TaskFinishReqAction" : (String) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 22;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq(String str, TaskResponseData taskResponseData, TaskInfo taskInfo, String str2, Integer num, String str3) {
        super(str, num, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, taskResponseData, taskInfo, str2, num, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Integer) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = str;
        this.e = taskResponseData;
        this.f = taskInfo;
        this.g = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ pq(String str, TaskResponseData taskResponseData, TaskInfo taskInfo, String str2, Integer num, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r0, r2, r3, r4, (i & 32) == 0 ? str3 : null);
        TaskResponseData taskResponseData2;
        TaskInfo taskInfo2;
        String str4;
        Integer num2;
        if ((i & 2) != 0) {
            taskResponseData2 = null;
        } else {
            taskResponseData2 = taskResponseData;
        }
        if ((i & 4) != 0) {
            taskInfo2 = null;
        } else {
            taskInfo2 = taskInfo;
        }
        if ((i & 8) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i & 16) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
    }

    @Override // com.baidu.tieba.sq
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final TaskResponseData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (TaskResponseData) invokeV.objValue;
    }

    public final TaskInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final void g(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, taskInfo) == null) {
            this.f = taskInfo;
        }
    }

    public final void h(TaskResponseData taskResponseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskResponseData) == null) {
            this.e = taskResponseData;
        }
    }
}
