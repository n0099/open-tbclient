package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes9.dex */
public class zzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Media media) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, media)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", media.type);
            qoc.a(jSONObject, "small_pic", media.small_pic);
            qoc.a(jSONObject, "big_pic", media.big_pic);
            qoc.a(jSONObject, "water_pic", media.water_pic);
            qoc.a(jSONObject, "vpic", media.vpic);
            qoc.a(jSONObject, "vsrc", media.vsrc);
            qoc.a(jSONObject, "vhsrc", media.vhsrc);
            qoc.a(jSONObject, "src_pic", media.src_pic);
            qoc.a(jSONObject, "text", media.text);
            qoc.a(jSONObject, "width", media.width);
            qoc.a(jSONObject, "height", media.height);
            qoc.a(jSONObject, "bsize", media.bsize);
            qoc.a(jSONObject, "during_time", media.during_time);
            qoc.a(jSONObject, "e_type", media.e_type);
            qoc.a(jSONObject, "origin_pic", media.origin_pic);
            qoc.a(jSONObject, "origin_size", media.origin_size);
            qoc.a(jSONObject, "post_id", media.post_id);
            qoc.a(jSONObject, "dynamic_pic", media.dynamic_pic);
            qoc.a(jSONObject, "is_long_pic", media.is_long_pic);
            qoc.a(jSONObject, "show_original_btn", media.show_original_btn);
            qoc.a(jSONObject, "is_blocked_pic", media.is_blocked_pic);
            qoc.a(jSONObject, "wth_mid_loc", media.wth_mid_loc);
            qoc.a(jSONObject, "hth_mid_loc", media.hth_mid_loc);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, media.jump_url);
            qoc.a(jSONObject, "guide_text", media.guide_text);
            qoc.a(jSONObject, "lottie_type", media.lottie_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
