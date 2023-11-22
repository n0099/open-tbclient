package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RobotEntrance;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes8.dex */
public class r2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RobotEntrance robotEntrance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, robotEntrance)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (robotEntrance.robot_skill_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (RobotSkillInfo robotSkillInfo : robotEntrance.robot_skill_info) {
                    jSONArray.put(t2d.b(robotSkillInfo));
                }
                qoc.a(jSONObject, "robot_skill_info", jSONArray);
            }
            if (robotEntrance.bottom_bar_robot_skill != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (RobotSkill robotSkill : robotEntrance.bottom_bar_robot_skill) {
                    jSONArray2.put(s2d.b(robotSkill));
                }
                qoc.a(jSONObject, "bottom_bar_robot_skill", jSONArray2);
            }
            if (robotEntrance.first_floor_bar_robot_skill != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (RobotSkill robotSkill2 : robotEntrance.first_floor_bar_robot_skill) {
                    jSONArray3.put(s2d.b(robotSkill2));
                }
                qoc.a(jSONObject, "first_floor_bar_robot_skill", jSONArray3);
            }
            qoc.a(jSONObject, "bottom_bar_click_guide", robotEntrance.bottom_bar_click_guide);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
