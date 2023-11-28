package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.NovelRecomCard;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public class t5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelRecomCard novelRecomCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelRecomCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon_url", novelRecomCard.icon_url);
            ltc.a(jSONObject, "title", novelRecomCard.title);
            if (novelRecomCard.title_labels != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThemeColorInfo themeColorInfo : novelRecomCard.title_labels) {
                    jSONArray.put(t9d.b(themeColorInfo));
                }
                ltc.a(jSONObject, "title_labels", jSONArray);
            }
            ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelRecomCard.author);
            ltc.a(jSONObject, "abstract", novelRecomCard._abstract);
            ltc.a(jSONObject, "chapter_name", novelRecomCard.chapter_name);
            ltc.a(jSONObject, "chapter_time", novelRecomCard.chapter_time);
            ThemeColorInfo themeColorInfo2 = novelRecomCard.chapter_new_labels;
            if (themeColorInfo2 != null) {
                ltc.a(jSONObject, "chapter_new_labels", t9d.b(themeColorInfo2));
            }
            ltc.a(jSONObject, "button_name", novelRecomCard.button_name);
            ltc.a(jSONObject, "button_scheme", novelRecomCard.button_scheme);
            ltc.a(jSONObject, "card_scheme", novelRecomCard.card_scheme);
            ltc.a(jSONObject, "bottom_title", novelRecomCard.bottom_title);
            ThemeColorInfo themeColorInfo3 = novelRecomCard.bottom_left_icon;
            if (themeColorInfo3 != null) {
                ltc.a(jSONObject, "bottom_left_icon", t9d.b(themeColorInfo3));
            }
            ltc.a(jSONObject, "bottom_scheme", novelRecomCard.bottom_scheme);
            ltc.a(jSONObject, "bottom_guide", novelRecomCard.bottom_guide);
            ThemeColorInfo themeColorInfo4 = novelRecomCard.bottom_right_icon;
            if (themeColorInfo4 != null) {
                ltc.a(jSONObject, "bottom_right_icon", t9d.b(themeColorInfo4));
            }
            ThemeColorInfo themeColorInfo5 = novelRecomCard.chapter_bg_color;
            if (themeColorInfo5 != null) {
                ltc.a(jSONObject, "chapter_bg_color", t9d.b(themeColorInfo5));
            }
            ThemeColorInfo themeColorInfo6 = novelRecomCard.chapter_name_color;
            if (themeColorInfo6 != null) {
                ltc.a(jSONObject, "chapter_name_color", t9d.b(themeColorInfo6));
            }
            ThemeColorInfo themeColorInfo7 = novelRecomCard.bottom_right_icon_2;
            if (themeColorInfo7 != null) {
                ltc.a(jSONObject, "bottom_right_icon_2", t9d.b(themeColorInfo7));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
