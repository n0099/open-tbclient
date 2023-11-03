package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeColorInfo;
import tbclient.ThreadRecommendInfo;
/* loaded from: classes8.dex */
public class w4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadRecommendInfo threadRecommendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadRecommendInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "forum_avatar", threadRecommendInfo.forum_avatar);
            poc.a(jSONObject, "forum_name", threadRecommendInfo.forum_name);
            poc.a(jSONObject, "show_num", threadRecommendInfo.show_num);
            poc.a(jSONObject, "show_type", threadRecommendInfo.show_type);
            poc.a(jSONObject, "recommend_reason", threadRecommendInfo.recommend_reason);
            poc.a(jSONObject, "topic_id", threadRecommendInfo.topic_id);
            poc.a(jSONObject, "recommend_type", threadRecommendInfo.recommend_type);
            poc.a(jSONObject, "recommend_tail", threadRecommendInfo.recommend_tail);
            poc.a(jSONObject, "recommend_icon", threadRecommendInfo.recommend_icon);
            ThemeColorInfo themeColorInfo = threadRecommendInfo.recommend_type_color;
            if (themeColorInfo != null) {
                poc.a(jSONObject, "recommend_type_color", p4d.b(themeColorInfo));
            }
            ThemeColorInfo themeColorInfo2 = threadRecommendInfo.recommend_reason_color;
            if (themeColorInfo2 != null) {
                poc.a(jSONObject, "recommend_reason_color", p4d.b(themeColorInfo2));
            }
            ThemeColorInfo themeColorInfo3 = threadRecommendInfo.strip_color;
            if (themeColorInfo3 != null) {
                poc.a(jSONObject, "strip_color", p4d.b(themeColorInfo3));
            }
            ThemeColorInfo themeColorInfo4 = threadRecommendInfo.background_color;
            if (themeColorInfo4 != null) {
                poc.a(jSONObject, "background_color", p4d.b(themeColorInfo4));
            }
            poc.a(jSONObject, "jump_link", threadRecommendInfo.jump_link);
            poc.a(jSONObject, "business_type", threadRecommendInfo.business_type);
            poc.a(jSONObject, "business_id", threadRecommendInfo.business_id);
            poc.a(jSONObject, "jump_icon", threadRecommendInfo.jump_icon);
            poc.a(jSONObject, "jump_text", threadRecommendInfo.jump_text);
            ThemeColorInfo themeColorInfo5 = threadRecommendInfo.jump_text_color;
            if (themeColorInfo5 != null) {
                poc.a(jSONObject, "jump_text_color", p4d.b(themeColorInfo5));
            }
            ThemeColorInfo themeColorInfo6 = threadRecommendInfo.dot_color;
            if (themeColorInfo6 != null) {
                poc.a(jSONObject, "dot_color", p4d.b(themeColorInfo6));
            }
            ThemeColorInfo themeColorInfo7 = threadRecommendInfo.tail_color;
            if (themeColorInfo7 != null) {
                poc.a(jSONObject, TailEditActivityConfig.TAIL_COLOR, p4d.b(themeColorInfo7));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
