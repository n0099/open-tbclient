package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserTaskInfo;
/* loaded from: classes8.dex */
public class uad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserTaskInfo userTaskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userTaskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", userTaskInfo.id);
            ktc.a(jSONObject, "name", userTaskInfo.name);
            ktc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, userTaskInfo.brief);
            ktc.a(jSONObject, "task_icon_url", userTaskInfo.task_icon_url);
            ktc.a(jSONObject, "status", userTaskInfo.status);
            ktc.a(jSONObject, "target_num", userTaskInfo.target_num);
            ktc.a(jSONObject, "curr_num", userTaskInfo.curr_num);
            ktc.a(jSONObject, "task_type", userTaskInfo.task_type);
            ktc.a(jSONObject, "weight", userTaskInfo.weight);
            ktc.a(jSONObject, "act_type", userTaskInfo.act_type);
            ktc.a(jSONObject, "target_scheme", userTaskInfo.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
