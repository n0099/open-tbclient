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
public class ptc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumShowInfoTag forumShowInfoTag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumShowInfoTag)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", forumShowInfoTag.text);
            ThemeColorInfo themeColorInfo = forumShowInfoTag.text_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = forumShowInfoTag.bg_color;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "bg_color", p4d.b(themeColorInfo2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
