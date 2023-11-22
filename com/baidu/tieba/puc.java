package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CardFreq;
/* loaded from: classes7.dex */
public class puc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CardFreq cardFreq) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cardFreq)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "start_time", cardFreq.start_time);
            qoc.a(jSONObject, "end_time", cardFreq.end_time);
            qoc.a(jSONObject, "show_times", cardFreq.show_times);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
