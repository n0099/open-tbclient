package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewParrScores;
/* loaded from: classes7.dex */
public class m5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewParrScores newParrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newParrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "scores_total", newParrScores.scores_total);
            ltc.a(jSONObject, "update_time", newParrScores.update_time);
            ltc.a(jSONObject, "i_total", newParrScores.i_total);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
