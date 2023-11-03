package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserGrowth;
import tbclient.UserTaskInfo;
/* loaded from: classes7.dex */
public class n5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserGrowth userGrowth) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userGrowth)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "level_id", userGrowth.level_id);
            poc.a(jSONObject, "score", userGrowth.score);
            poc.a(jSONObject, "target_score", userGrowth.target_score);
            poc.a(jSONObject, "tmoney", userGrowth.tmoney);
            if (userGrowth.task_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (UserTaskInfo userTaskInfo : userGrowth.task_info) {
                    jSONArray.put(r5d.b(userTaskInfo));
                }
                poc.a(jSONObject, "task_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
