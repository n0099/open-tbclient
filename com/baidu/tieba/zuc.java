package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Focus;
/* loaded from: classes9.dex */
public class zuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Focus focus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, focus)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "time", focus.time);
            poc.a(jSONObject, "title", focus.title);
            poc.a(jSONObject, "link", focus.link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
