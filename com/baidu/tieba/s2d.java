package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.CallRobotEntrance;
import tbclient.RobotSkillInfo;
import tbclient.StyleContentInfo;
/* loaded from: classes8.dex */
public class s2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RobotSkillInfo robotSkillInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, robotSkillInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (robotSkillInfo.robot_skill_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (CallRobotEntrance callRobotEntrance : robotSkillInfo.robot_skill_list) {
                    jSONArray.put(rqc.b(callRobotEntrance));
                }
                poc.a(jSONObject, "robot_skill_list", jSONArray);
            }
            poc.a(jSONObject, "robot_uk", robotSkillInfo.robot_uk);
            poc.a(jSONObject, "robot_portrait", robotSkillInfo.robot_portrait);
            poc.a(jSONObject, "robot_name", robotSkillInfo.robot_name);
            StyleContentInfo styleContentInfo = robotSkillInfo.style_day;
            if (styleContentInfo != null) {
                poc.a(jSONObject, "style_day", v3d.b(styleContentInfo));
            }
            StyleContentInfo styleContentInfo2 = robotSkillInfo.style_dark;
            if (styleContentInfo2 != null) {
                poc.a(jSONObject, "style_dark", v3d.b(styleContentInfo2));
            }
            poc.a(jSONObject, "new_skill_guide", robotSkillInfo.new_skill_guide);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
