package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupPk;
/* loaded from: classes9.dex */
public class zxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupPk worldCupPk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupPk)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "sum_game", worldCupPk.sum_game);
            qoc.a(jSONObject, "sum_bonus", worldCupPk.sum_bonus);
            qoc.a(jSONObject, "prize_url", worldCupPk.prize_url);
            qoc.a(jSONObject, "url", worldCupPk.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
