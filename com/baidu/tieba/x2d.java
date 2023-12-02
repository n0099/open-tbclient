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
public class x2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupGame worldCupGame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupGame)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", worldCupGame.title);
            ktc.a(jSONObject, "status", worldCupGame.status);
            ktc.a(jSONObject, "url", worldCupGame.url);
            if (worldCupGame.team != null) {
                JSONArray jSONArray = new JSONArray();
                for (WorldCupGameTeam worldCupGameTeam : worldCupGame.team) {
                    jSONArray.put(y2d.b(worldCupGameTeam));
                }
                ktc.a(jSONObject, "team", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
