package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThreadAblum;
/* loaded from: classes9.dex */
public class x9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadAblum threadAblum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadAblum)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", threadAblum.id);
            ltc.a(jSONObject, "tab_id", threadAblum.tab_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
