package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ForumShowInfoTag;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public class oyc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumShowInfoTag forumShowInfoTag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumShowInfoTag)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text", forumShowInfoTag.text);
            ThemeColorInfo themeColorInfo = forumShowInfoTag.text_color;
            if (themeColorInfo != null) {
                ltc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, t9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = forumShowInfoTag.bg_color;
            if (themeColorInfo2 != null) {
                ltc.a(jSONObject, "bg_color", t9d.b(themeColorInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
