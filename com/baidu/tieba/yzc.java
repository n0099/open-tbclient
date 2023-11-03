package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes9.dex */
public class yzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Media media) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, media)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", media.type);
            poc.a(jSONObject, "small_pic", media.small_pic);
            poc.a(jSONObject, "big_pic", media.big_pic);
            poc.a(jSONObject, "water_pic", media.water_pic);
            poc.a(jSONObject, "vpic", media.vpic);
            poc.a(jSONObject, "vsrc", media.vsrc);
            poc.a(jSONObject, "vhsrc", media.vhsrc);
            poc.a(jSONObject, "src_pic", media.src_pic);
            poc.a(jSONObject, "text", media.text);
            poc.a(jSONObject, "width", media.width);
            poc.a(jSONObject, "height", media.height);
            poc.a(jSONObject, "bsize", media.bsize);
            poc.a(jSONObject, "during_time", media.during_time);
            poc.a(jSONObject, "e_type", media.e_type);
            poc.a(jSONObject, "origin_pic", media.origin_pic);
            poc.a(jSONObject, "origin_size", media.origin_size);
            poc.a(jSONObject, "post_id", media.post_id);
            poc.a(jSONObject, "dynamic_pic", media.dynamic_pic);
            poc.a(jSONObject, "is_long_pic", media.is_long_pic);
            poc.a(jSONObject, "show_original_btn", media.show_original_btn);
            poc.a(jSONObject, "is_blocked_pic", media.is_blocked_pic);
            poc.a(jSONObject, "wth_mid_loc", media.wth_mid_loc);
            poc.a(jSONObject, "hth_mid_loc", media.hth_mid_loc);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, media.jump_url);
            poc.a(jSONObject, "guide_text", media.guide_text);
            poc.a(jSONObject, "lottie_type", media.lottie_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
