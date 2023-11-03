package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.UniversalLabel;
/* loaded from: classes7.dex */
public class l5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UniversalLabel universalLabel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, universalLabel)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "label_id", universalLabel.label_id);
            poc.a(jSONObject, "label_text", universalLabel.label_text);
            poc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, universalLabel.text_color);
            poc.a(jSONObject, "text_color_black", universalLabel.text_color_black);
            poc.a(jSONObject, "background_color", universalLabel.background_color);
            poc.a(jSONObject, "background_color_black", universalLabel.background_color_black);
            poc.a(jSONObject, "round_radius", universalLabel.round_radius);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
