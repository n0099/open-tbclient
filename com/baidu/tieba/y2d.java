package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes9.dex */
public class y2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupGameTeam worldCupGameTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupGameTeam)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "name", worldCupGameTeam.name);
            ktc.a(jSONObject, "logo_url", worldCupGameTeam.logo_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
