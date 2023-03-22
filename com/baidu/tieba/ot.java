package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.meter.TaskMeterData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ot extends ht<TaskMeterData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jt a;

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskMeterData.key : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ot(jt jtVar) {
        super(jtVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jtVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jt) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ht
    /* renamed from: c */
    public TaskMeterData a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                jSONObject = new JSONObject(str);
                optInt = jSONObject.optInt(TaskResponseData.keyUiType);
            } catch (Exception e) {
                e = e;
            }
            try {
                ht a = this.a.a(TaskUIData.key);
                String optString = jSONObject.optString(TaskUIData.key);
                Intrinsics.checkExpressionValueIsNotNull(optString, "guide.optString(TaskUIData.key)");
                TaskUIData taskUIData = (TaskUIData) a.a(optString);
                if (taskUIData == null) {
                    taskUIData = new TaskUIData(null, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
                }
                return new TaskMeterData(optInt, taskUIData);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return new TaskMeterData(0, null, 3, null);
            }
        }
        return (TaskMeterData) invokeL.objValue;
    }
}
