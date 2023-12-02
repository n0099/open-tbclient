package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewParrScores;
/* loaded from: classes7.dex */
public class l5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewParrScores newParrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newParrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "scores_total", newParrScores.scores_total);
            ktc.a(jSONObject, "update_time", newParrScores.update_time);
            ktc.a(jSONObject, "i_total", newParrScores.i_total);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
