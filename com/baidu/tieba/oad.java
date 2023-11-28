package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TwZhiBoUser;
/* loaded from: classes7.dex */
public class oad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TwZhiBoUser twZhiBoUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, twZhiBoUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "anchor_level", twZhiBoUser.anchor_level);
            ltc.a(jSONObject, "in_black_list", twZhiBoUser.in_black_list);
            ltc.a(jSONObject, "field_ex", twZhiBoUser.field_ex);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
