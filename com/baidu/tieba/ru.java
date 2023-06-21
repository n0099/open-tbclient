package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.meter.TaskMeterData;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.rule.TaskRuleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ru extends lu<TaskInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nu a;

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "info" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ru(nu nuVar) {
        super(nuVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nu) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nuVar;
    }

    public final <T extends ITaskModelData> T b(nu nuVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nuVar, str, str2)) == null) {
            return nuVar.a(str).a(str2);
        }
        return (T) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lu
    /* renamed from: d */
    public TaskInfo a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String id = jSONObject.optString("id");
                String aid = jSONObject.optString("aid");
                int optInt = jSONObject.optInt("type");
                String token = jSONObject.optString("token");
                int optInt2 = jSONObject.optInt(TaskInfo.keyBehavior, 0);
                String actTaskId = jSONObject.optString(TaskInfo.keyActTaskId);
                String fingerprint = jSONObject.optString(TaskInfo.keyFingerprint);
                nu nuVar = this.a;
                String optString = jSONObject.optString("rule");
                Intrinsics.checkExpressionValueIsNotNull(optString, "infoObj.optString(TaskRuleData.key)");
                TaskRuleData taskRuleData = (TaskRuleData) b(nuVar, "rule", optString);
                if (taskRuleData != null) {
                    nu nuVar2 = this.a;
                    String optString2 = jSONObject.optString("guide");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "infoObj.optString(TaskGuideData.key)");
                    TaskGuideData taskGuideData = (TaskGuideData) b(nuVar2, "guide", optString2);
                    if (taskGuideData != null) {
                        nu nuVar3 = this.a;
                        String optString3 = jSONObject.optString(TaskMeterData.key);
                        Intrinsics.checkExpressionValueIsNotNull(optString3, "infoObj.optString(TaskMeterData.key)");
                        TaskMeterData taskMeterData = (TaskMeterData) b(nuVar3, TaskMeterData.key, optString3);
                        if (taskMeterData != null) {
                            nu nuVar4 = this.a;
                            String optString4 = jSONObject.optString("response");
                            Intrinsics.checkExpressionValueIsNotNull(optString4, "infoObj.optString(TaskResponseData.key)");
                            TaskResponseData taskResponseData = (TaskResponseData) b(nuVar4, "response", optString4);
                            if (taskResponseData != null) {
                                Intrinsics.checkExpressionValueIsNotNull(id, "id");
                                Intrinsics.checkExpressionValueIsNotNull(aid, "aid");
                                Intrinsics.checkExpressionValueIsNotNull(token, "token");
                                Intrinsics.checkExpressionValueIsNotNull(actTaskId, "actTaskId");
                                Intrinsics.checkExpressionValueIsNotNull(fingerprint, "fingerprint");
                                return new TaskInfo(id, aid, optInt, token, optInt2, actTaskId, fingerprint, taskRuleData, taskGuideData, taskMeterData, taskResponseData);
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (TaskInfo) invokeL.objValue;
    }
}
