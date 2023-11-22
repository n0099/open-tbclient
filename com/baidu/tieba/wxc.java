package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes9.dex */
public class wxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupGameTeam worldCupGameTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupGameTeam)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", worldCupGameTeam.name);
            qoc.a(jSONObject, "logo_url", worldCupGameTeam.logo_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
