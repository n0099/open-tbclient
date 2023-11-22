package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupGame;
import tbclient.FrsPage.WorldCupGameTeam;
/* loaded from: classes8.dex */
public class vxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupGame worldCupGame) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupGame)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", worldCupGame.title);
            qoc.a(jSONObject, "status", worldCupGame.status);
            qoc.a(jSONObject, "url", worldCupGame.url);
            if (worldCupGame.team != null) {
                JSONArray jSONArray = new JSONArray();
                for (WorldCupGameTeam worldCupGameTeam : worldCupGame.team) {
                    jSONArray.put(wxc.b(worldCupGameTeam));
                }
                qoc.a(jSONObject, "team", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
