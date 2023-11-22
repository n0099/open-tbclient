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
/* loaded from: classes7.dex */
public class q0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NovelRecomCard novelRecomCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, novelRecomCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon_url", novelRecomCard.icon_url);
            qoc.a(jSONObject, "title", novelRecomCard.title);
            if (novelRecomCard.title_labels != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThemeColorInfo themeColorInfo : novelRecomCard.title_labels) {
                    jSONArray.put(q4d.b(themeColorInfo));
                }
                qoc.a(jSONObject, "title_labels", jSONArray);
            }
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, novelRecomCard.author);
            qoc.a(jSONObject, "abstract", novelRecomCard._abstract);
            qoc.a(jSONObject, "chapter_name", novelRecomCard.chapter_name);
            qoc.a(jSONObject, "chapter_time", novelRecomCard.chapter_time);
            ThemeColorInfo themeColorInfo2 = novelRecomCard.chapter_new_labels;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "chapter_new_labels", q4d.b(themeColorInfo2));
            }
            qoc.a(jSONObject, "button_name", novelRecomCard.button_name);
            qoc.a(jSONObject, "button_scheme", novelRecomCard.button_scheme);
            qoc.a(jSONObject, "card_scheme", novelRecomCard.card_scheme);
            qoc.a(jSONObject, "bottom_title", novelRecomCard.bottom_title);
            ThemeColorInfo themeColorInfo3 = novelRecomCard.bottom_left_icon;
            if (themeColorInfo3 != null) {
                qoc.a(jSONObject, "bottom_left_icon", q4d.b(themeColorInfo3));
            }
            qoc.a(jSONObject, "bottom_scheme", novelRecomCard.bottom_scheme);
            qoc.a(jSONObject, "bottom_guide", novelRecomCard.bottom_guide);
            ThemeColorInfo themeColorInfo4 = novelRecomCard.bottom_right_icon;
            if (themeColorInfo4 != null) {
                qoc.a(jSONObject, "bottom_right_icon", q4d.b(themeColorInfo4));
            }
            ThemeColorInfo themeColorInfo5 = novelRecomCard.chapter_bg_color;
            if (themeColorInfo5 != null) {
                qoc.a(jSONObject, "chapter_bg_color", q4d.b(themeColorInfo5));
            }
            ThemeColorInfo themeColorInfo6 = novelRecomCard.chapter_name_color;
            if (themeColorInfo6 != null) {
                qoc.a(jSONObject, "chapter_name_color", q4d.b(themeColorInfo6));
            }
            ThemeColorInfo themeColorInfo7 = novelRecomCard.bottom_right_icon_2;
            if (themeColorInfo7 != null) {
                qoc.a(jSONObject, "bottom_right_icon_2", q4d.b(themeColorInfo7));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
