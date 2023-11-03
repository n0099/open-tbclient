package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PopInfo;
/* loaded from: classes7.dex */
public class l1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PopInfo popInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, popInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "if_pop", popInfo.if_pop);
            poc.a(jSONObject, "title", popInfo.title);
            poc.a(jSONObject, "v_title", popInfo.v_title);
            poc.a(jSONObject, "ahead_info", popInfo.ahead_info);
            poc.a(jSONObject, "ahead_url", popInfo.ahead_url);
            poc.a(jSONObject, "ok_info", popInfo.ok_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
