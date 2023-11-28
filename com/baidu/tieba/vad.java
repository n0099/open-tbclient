package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserTaskInfo;
/* loaded from: classes8.dex */
public class vad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserTaskInfo userTaskInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userTaskInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", userTaskInfo.id);
            ltc.a(jSONObject, "name", userTaskInfo.name);
            ltc.a(jSONObject, DBTableDefine.GroupInfoColumns.COLUMN_BRIEF, userTaskInfo.brief);
            ltc.a(jSONObject, "task_icon_url", userTaskInfo.task_icon_url);
            ltc.a(jSONObject, "status", userTaskInfo.status);
            ltc.a(jSONObject, "target_num", userTaskInfo.target_num);
            ltc.a(jSONObject, "curr_num", userTaskInfo.curr_num);
            ltc.a(jSONObject, "task_type", userTaskInfo.task_type);
            ltc.a(jSONObject, "weight", userTaskInfo.weight);
            ltc.a(jSONObject, "act_type", userTaskInfo.act_type);
            ltc.a(jSONObject, "target_scheme", userTaskInfo.target_scheme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
