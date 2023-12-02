package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes9.dex */
public class z9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadRecommendInfo threadRecommendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadRecommendInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum_avatar", threadRecommendInfo.forum_avatar);
            ktc.a(jSONObject, "forum_name", threadRecommendInfo.forum_name);
            ktc.a(jSONObject, "show_num", threadRecommendInfo.show_num);
            ktc.a(jSONObject, "show_type", threadRecommendInfo.show_type);
            ktc.a(jSONObject, "recommend_reason", threadRecommendInfo.recommend_reason);
            ktc.a(jSONObject, "topic_id", threadRecommendInfo.topic_id);
            ktc.a(jSONObject, "recommend_type", threadRecommendInfo.recommend_type);
            ktc.a(jSONObject, "recommend_tail", threadRecommendInfo.recommend_tail);
            ktc.a(jSONObject, "recommend_icon", threadRecommendInfo.recommend_icon);
            ThemeColorInfo themeColorInfo = threadRecommendInfo.recommend_type_color;
            if (themeColorInfo != null) {
                ktc.a(jSONObject, "recommend_type_color", s9d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = threadRecommendInfo.recommend_reason_color;
            if (themeColorInfo2 != null) {
                ktc.a(jSONObject, "recommend_reason_color", s9d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = threadRecommendInfo.strip_color;
            if (themeColorInfo3 != null) {
                ktc.a(jSONObject, "strip_color", s9d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = threadRecommendInfo.background_color;
            if (themeColorInfo4 != null) {
                ktc.a(jSONObject, "background_color", s9d.b(themeColorInfo4));
            }
            ktc.a(jSONObject, "jump_link", threadRecommendInfo.jump_link);
            ktc.a(jSONObject, "business_type", threadRecommendInfo.business_type);
            ktc.a(jSONObject, "business_id", threadRecommendInfo.business_id);
            ktc.a(jSONObject, "jump_icon", threadRecommendInfo.jump_icon);
            ktc.a(jSONObject, "jump_text", threadRecommendInfo.jump_text);
            ThemeColorInfo themeColorInfo5 = threadRecommendInfo.jump_text_color;
            if (themeColorInfo5 != null) {
                ktc.a(jSONObject, "jump_text_color", s9d.b(themeColorInfo5));
            }
            ThemeColorInfo themeColorInfo6 = threadRecommendInfo.dot_color;
            if (themeColorInfo6 != null) {
                ktc.a(jSONObject, "dot_color", s9d.b(themeColorInfo6));
            }
            ThemeColorInfo themeColorInfo7 = threadRecommendInfo.tail_color;
            if (themeColorInfo7 != null) {
                ktc.a(jSONObject, TailEditActivityConfig.TAIL_COLOR, s9d.b(themeColorInfo7));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
