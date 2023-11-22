package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserTaskInfo;
/* loaded from: classes8.dex */
public class s5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserTaskInfo userTaskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userTaskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", userTaskInfo.id);
            qoc.a(jSONObject, "name", userTaskInfo.name);
            qoc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, userTaskInfo.brief);
            qoc.a(jSONObject, "task_icon_url", userTaskInfo.task_icon_url);
            qoc.a(jSONObject, "status", userTaskInfo.status);
            qoc.a(jSONObject, "target_num", userTaskInfo.target_num);
            qoc.a(jSONObject, "curr_num", userTaskInfo.curr_num);
            qoc.a(jSONObject, "task_type", userTaskInfo.task_type);
            qoc.a(jSONObject, "weight", userTaskInfo.weight);
            qoc.a(jSONObject, "act_type", userTaskInfo.act_type);
            qoc.a(jSONObject, "target_scheme", userTaskInfo.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
