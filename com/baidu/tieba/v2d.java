package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes8.dex */
public class v2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static VideoImageColor b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            VideoImageColor.Builder builder = new VideoImageColor.Builder();
            if (jSONObject.has("time")) {
                builder.time = Integer.valueOf(jSONObject.optInt("time"));
            }
            if (jSONObject.has("color")) {
                builder.color = jSONObject.optString("color");
            }
            return builder.build(true);
        }
        return (VideoImageColor) invokeL.objValue;
    }

    @NonNull
    public static JSONObject c(@NonNull VideoImageColor videoImageColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoImageColor)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "time", videoImageColor.time);
            ktc.a(jSONObject, "color", videoImageColor.color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
