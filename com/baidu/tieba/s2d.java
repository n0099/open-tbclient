package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RobotSkill;
/* loaded from: classes8.dex */
public class s2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RobotSkill robotSkill) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, robotSkill)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "robot_uk", robotSkill.robot_uk);
            if (robotSkill.skill_ids != null) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : robotSkill.skill_ids) {
                    jSONArray.put(num.intValue());
                }
                qoc.a(jSONObject, "skill_ids", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
