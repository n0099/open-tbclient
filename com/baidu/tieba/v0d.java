package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ParrScores;
/* loaded from: classes8.dex */
public class v0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ParrScores parrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, parrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "scores_total", parrScores.scores_total);
            qoc.a(jSONObject, "scores_fetch", parrScores.scores_fetch);
            qoc.a(jSONObject, "scores_money", parrScores.scores_money);
            qoc.a(jSONObject, "scores_other", parrScores.scores_other);
            qoc.a(jSONObject, "update_time", parrScores.update_time);
            qoc.a(jSONObject, "level", parrScores.level);
            qoc.a(jSONObject, Constants.EXTRA_CONFIG_LIMIT, parrScores.limit);
            qoc.a(jSONObject, "i_total", parrScores.i_total);
            qoc.a(jSONObject, "i_money", parrScores.i_money);
            qoc.a(jSONObject, "i_other", parrScores.i_other);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
