package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AbilityConf;
/* loaded from: classes7.dex */
public class ltc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AbilityConf abilityConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, abilityConf)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "bot_uk", abilityConf.bot_uk);
            ktc.a(jSONObject, "skill_id", abilityConf.skill_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
