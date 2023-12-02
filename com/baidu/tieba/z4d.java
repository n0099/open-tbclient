package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MaskLayerText;
/* loaded from: classes9.dex */
public class z4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MaskLayerText maskLayerText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, maskLayerText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "text", maskLayerText.text);
            ktc.a(jSONObject, "schema", maskLayerText.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
