package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThreadAblum;
/* loaded from: classes8.dex */
public class t4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadAblum threadAblum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadAblum)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", threadAblum.id);
            poc.a(jSONObject, "tab_id", threadAblum.tab_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
