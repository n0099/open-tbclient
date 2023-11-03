package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AbilityConf;
import tbclient.CallRobotEntrance;
import tbclient.StyleConf;
/* loaded from: classes8.dex */
public class rqc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CallRobotEntrance callRobotEntrance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, callRobotEntrance)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "ability_type", callRobotEntrance.ability_type);
            AbilityConf abilityConf = callRobotEntrance.ability_conf;
            if (abilityConf != null) {
                poc.a(jSONObject, "ability_conf", qoc.b(abilityConf));
            }
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null) {
                poc.a(jSONObject, "style_conf", t3d.b(styleConf));
            }
            poc.a(jSONObject, "skill_id", callRobotEntrance.skill_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
