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
public class x4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadRecommendInfo threadRecommendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadRecommendInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "forum_avatar", threadRecommendInfo.forum_avatar);
            qoc.a(jSONObject, "forum_name", threadRecommendInfo.forum_name);
            qoc.a(jSONObject, "show_num", threadRecommendInfo.show_num);
            qoc.a(jSONObject, "show_type", threadRecommendInfo.show_type);
            qoc.a(jSONObject, "recommend_reason", threadRecommendInfo.recommend_reason);
            qoc.a(jSONObject, "topic_id", threadRecommendInfo.topic_id);
            qoc.a(jSONObject, "recommend_type", threadRecommendInfo.recommend_type);
            qoc.a(jSONObject, "recommend_tail", threadRecommendInfo.recommend_tail);
            qoc.a(jSONObject, "recommend_icon", threadRecommendInfo.recommend_icon);
            ThemeColorInfo themeColorInfo = threadRecommendInfo.recommend_type_color;
            if (themeColorInfo != null) {
                qoc.a(jSONObject, "recommend_type_color", q4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = threadRecommendInfo.recommend_reason_color;
            if (themeColorInfo2 != null) {
                qoc.a(jSONObject, "recommend_reason_color", q4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = threadRecommendInfo.strip_color;
            if (themeColorInfo3 != null) {
                qoc.a(jSONObject, "strip_color", q4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = threadRecommendInfo.background_color;
            if (themeColorInfo4 != null) {
                qoc.a(jSONObject, "background_color", q4d.b(themeColorInfo4));
            }
            qoc.a(jSONObject, "jump_link", threadRecommendInfo.jump_link);
            qoc.a(jSONObject, "business_type", threadRecommendInfo.business_type);
            qoc.a(jSONObject, "business_id", threadRecommendInfo.business_id);
            qoc.a(jSONObject, "jump_icon", threadRecommendInfo.jump_icon);
            qoc.a(jSONObject, "jump_text", threadRecommendInfo.jump_text);
            ThemeColorInfo themeColorInfo5 = threadRecommendInfo.jump_text_color;
            if (themeColorInfo5 != null) {
                qoc.a(jSONObject, "jump_text_color", q4d.b(themeColorInfo5));
            }
            ThemeColorInfo themeColorInfo6 = threadRecommendInfo.dot_color;
            if (themeColorInfo6 != null) {
                qoc.a(jSONObject, "dot_color", q4d.b(themeColorInfo6));
            }
            ThemeColorInfo themeColorInfo7 = threadRecommendInfo.tail_color;
            if (themeColorInfo7 != null) {
                qoc.a(jSONObject, TailEditActivityConfig.TAIL_COLOR, q4d.b(themeColorInfo7));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
