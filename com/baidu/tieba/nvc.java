package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BusinessMix;
/* loaded from: classes7.dex */
public class nvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static BusinessMix b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            BusinessMix.Builder builder = new BusinessMix.Builder();
            if (jSONObject.has("mix_type")) {
                builder.mix_type = Integer.valueOf(jSONObject.optInt("mix_type"));
            }
            if (jSONObject.has("url")) {
                builder.url = jSONObject.optString("url");
            }
            if (jSONObject.has("scheme")) {
                builder.scheme = jSONObject.optString("scheme");
            }
            if (jSONObject.has("jump_type")) {
                builder.jump_type = Integer.valueOf(jSONObject.optInt("jump_type"));
            }
            if (jSONObject.has("package_name")) {
                builder.package_name = jSONObject.optString("package_name");
            }
            return builder.build(true);
        }
        return (BusinessMix) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull BusinessMix businessMix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, businessMix)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "mix_type", businessMix.mix_type);
            ktc.a(jSONObject, "url", businessMix.url);
            ktc.a(jSONObject, "scheme", businessMix.scheme);
            ktc.a(jSONObject, "jump_type", businessMix.jump_type);
            ktc.a(jSONObject, "package_name", businessMix.package_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
