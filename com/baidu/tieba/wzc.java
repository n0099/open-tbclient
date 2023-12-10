package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.CoverImageColor;
/* loaded from: classes9.dex */
public class wzc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static CoverImageColor b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            CoverImageColor.Builder builder = new CoverImageColor.Builder();
            if (jSONObject.has("value")) {
                builder.value = jSONObject.optString("value");
            }
            if (jSONObject.has("model")) {
                builder.model = Integer.valueOf(jSONObject.optInt("model"));
            }
            return builder.build(true);
        }
        return (CoverImageColor) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull CoverImageColor coverImageColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, coverImageColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "value", coverImageColor.value);
            ltc.a(jSONObject, "model", coverImageColor.model);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
