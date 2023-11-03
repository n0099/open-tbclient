package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupPk;
/* loaded from: classes9.dex */
public class yxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupPk worldCupPk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupPk)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "sum_game", worldCupPk.sum_game);
            poc.a(jSONObject, "sum_bonus", worldCupPk.sum_bonus);
            poc.a(jSONObject, "prize_url", worldCupPk.prize_url);
            poc.a(jSONObject, "url", worldCupPk.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
