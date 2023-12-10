package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ParrScores;
/* loaded from: classes9.dex */
public class y5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ParrScores parrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, parrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "scores_total", parrScores.scores_total);
            ltc.a(jSONObject, "scores_fetch", parrScores.scores_fetch);
            ltc.a(jSONObject, "scores_money", parrScores.scores_money);
            ltc.a(jSONObject, "scores_other", parrScores.scores_other);
            ltc.a(jSONObject, "update_time", parrScores.update_time);
            ltc.a(jSONObject, "level", parrScores.level);
            ltc.a(jSONObject, Constants.EXTRA_CONFIG_LIMIT, parrScores.limit);
            ltc.a(jSONObject, "i_total", parrScores.i_total);
            ltc.a(jSONObject, "i_money", parrScores.i_money);
            ltc.a(jSONObject, "i_other", parrScores.i_other);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
