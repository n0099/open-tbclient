package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.VideoImageColor;
/* loaded from: classes8.dex */
public class w2d extends ltc {
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
            ltc.a(jSONObject, "time", videoImageColor.time);
            ltc.a(jSONObject, "color", videoImageColor.color);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
