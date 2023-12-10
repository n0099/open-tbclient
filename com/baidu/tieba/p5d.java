package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NoticeMask;
/* loaded from: classes7.dex */
public class p5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NoticeMask noticeMask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, noticeMask)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "attr_type", noticeMask.attr_type);
            ltc.a(jSONObject, "attr_value", noticeMask.attr_value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
