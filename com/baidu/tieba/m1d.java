package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PopInfo;
/* loaded from: classes7.dex */
public class m1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PopInfo popInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, popInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "if_pop", popInfo.if_pop);
            qoc.a(jSONObject, "title", popInfo.title);
            qoc.a(jSONObject, "v_title", popInfo.v_title);
            qoc.a(jSONObject, "ahead_info", popInfo.ahead_info);
            qoc.a(jSONObject, "ahead_url", popInfo.ahead_url);
            qoc.a(jSONObject, "ok_info", popInfo.ok_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
