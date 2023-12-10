package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupGame;
import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes9.dex */
public class y2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupGame worldCupGame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupGame)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", worldCupGame.title);
            ltc.a(jSONObject, "status", worldCupGame.status);
            ltc.a(jSONObject, "url", worldCupGame.url);
            if (worldCupGame.team != null) {
                JSONArray jSONArray = new JSONArray();
                for (WorldCupGameTeam worldCupGameTeam : worldCupGame.team) {
                    jSONArray.put(z2d.b(worldCupGameTeam));
                }
                ltc.a(jSONObject, "team", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
