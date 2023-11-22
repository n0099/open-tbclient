package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendTag;
/* loaded from: classes9.dex */
public class y4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadRecommendTag threadRecommendTag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadRecommendTag)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "text", threadRecommendTag.text);
            ThemeColorInfo themeColorInfo = threadRecommendTag.text_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = threadRecommendTag.background_color;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "background_color", q4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = threadRecommendTag.boundary_color;
            if (themeColorInfo3 != null) {
                qoc.a(jSONObject, "boundary_color", q4d.b(themeColorInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
