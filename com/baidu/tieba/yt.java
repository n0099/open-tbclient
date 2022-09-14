package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class yt extends zt<TaskState> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt(bu buVar) {
        super(buVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bu) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = buVar;
    }

    public final <T extends ITaskModelData> T b(bu buVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buVar, str, str2)) == null) ? buVar.a(str).a(str2) : (T) invokeLLL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.key : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zt
    /* renamed from: d */
    public TaskState a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bu buVar = this.a;
                String optString = jSONObject.optString("info");
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(TaskInfo.key)");
                TaskInfo taskInfo = (TaskInfo) b(buVar, "info", optString);
                if (taskInfo != null) {
                    bu buVar2 = this.a;
                    String optString2 = jSONObject.optString(TaskStatus.key);
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "jsonObject.optString(TaskStatus.key)");
                    TaskStatus taskStatus = (TaskStatus) b(buVar2, TaskStatus.key, optString2);
                    if (taskStatus != null) {
                        return new TaskState(taskInfo, taskStatus);
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TaskState) invokeL.objValue;
    }
}
