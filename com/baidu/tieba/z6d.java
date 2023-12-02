package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PubCardFreq;
/* loaded from: classes9.dex */
public class z6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PubCardFreq pubCardFreq) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pubCardFreq)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "start_time", pubCardFreq.start_time);
            ktc.a(jSONObject, "end_time", pubCardFreq.end_time);
            ktc.a(jSONObject, "show_times", pubCardFreq.show_times);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
