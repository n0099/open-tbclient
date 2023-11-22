package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewParrScores;
/* loaded from: classes6.dex */
public class j0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewParrScores newParrScores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newParrScores)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "scores_total", newParrScores.scores_total);
            qoc.a(jSONObject, "update_time", newParrScores.update_time);
            qoc.a(jSONObject, "i_total", newParrScores.i_total);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
