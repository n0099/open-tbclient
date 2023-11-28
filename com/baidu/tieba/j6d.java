package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PicDecoration;
import tbclient.PicInfo;
/* loaded from: classes6.dex */
public class j6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PicInfo picInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, picInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "small_pic_url", picInfo.small_pic_url);
            ltc.a(jSONObject, "big_pic_url", picInfo.big_pic_url);
            ltc.a(jSONObject, "origin_pic_url", picInfo.origin_pic_url);
            ltc.a(jSONObject, "width", picInfo.width);
            ltc.a(jSONObject, "height", picInfo.height);
            ltc.a(jSONObject, "is_long_pic", picInfo.is_long_pic);
            ltc.a(jSONObject, "crop_point_width_ratio", picInfo.crop_point_width_ratio);
            ltc.a(jSONObject, "crop_point_height_ratio", picInfo.crop_point_height_ratio);
            if (picInfo.decoration != null) {
                JSONArray jSONArray = new JSONArray();
                for (PicDecoration picDecoration : picInfo.decoration) {
                    jSONArray.put(i6d.b(picDecoration));
                }
                ltc.a(jSONObject, "decoration", jSONArray);
            }
            ltc.a(jSONObject, "scheme", picInfo.scheme);
            ltc.a(jSONObject, "pic_type", picInfo.pic_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
