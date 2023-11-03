package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserTaskInfo;
/* loaded from: classes8.dex */
public class r5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserTaskInfo userTaskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userTaskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", userTaskInfo.id);
            poc.a(jSONObject, "name", userTaskInfo.name);
            poc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, userTaskInfo.brief);
            poc.a(jSONObject, "task_icon_url", userTaskInfo.task_icon_url);
            poc.a(jSONObject, "status", userTaskInfo.status);
            poc.a(jSONObject, "target_num", userTaskInfo.target_num);
            poc.a(jSONObject, "curr_num", userTaskInfo.curr_num);
            poc.a(jSONObject, "task_type", userTaskInfo.task_type);
            poc.a(jSONObject, "weight", userTaskInfo.weight);
            poc.a(jSONObject, "act_type", userTaskInfo.act_type);
            poc.a(jSONObject, "target_scheme", userTaskInfo.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
