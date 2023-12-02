package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ParrScores;
/* loaded from: classes9.dex */
public class x5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ParrScores parrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, parrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "scores_total", parrScores.scores_total);
            ktc.a(jSONObject, "scores_fetch", parrScores.scores_fetch);
            ktc.a(jSONObject, "scores_money", parrScores.scores_money);
            ktc.a(jSONObject, "scores_other", parrScores.scores_other);
            ktc.a(jSONObject, "update_time", parrScores.update_time);
            ktc.a(jSONObject, "level", parrScores.level);
            ktc.a(jSONObject, Constants.EXTRA_CONFIG_LIMIT, parrScores.limit);
            ktc.a(jSONObject, "i_total", parrScores.i_total);
            ktc.a(jSONObject, "i_money", parrScores.i_money);
            ktc.a(jSONObject, "i_other", parrScores.i_other);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
