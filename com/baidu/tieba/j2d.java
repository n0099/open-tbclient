package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.write.write.message.QuestionTagListRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
import tbclient.FrsPage.TagInfo;
import tbclient.RecomTagInfo;
/* loaded from: classes6.dex */
public class j2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagInfo tagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "forum_id", tagInfo.forum_id);
            ktc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_ID, tagInfo.tag_id);
            ktc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tagInfo.tag_name);
            ktc.a(jSONObject, "color", tagInfo.color);
            ktc.a(jSONObject, "hot_value", tagInfo.hot_value);
            ktc.a(jSONObject, "tag_type", tagInfo.tag_type);
            ktc.a(jSONObject, "tag_level", tagInfo.tag_level);
            ktc.a(jSONObject, "influence", tagInfo.influence);
            ktc.a(jSONObject, "relation_weight", tagInfo.relation_weight);
            ktc.a(jSONObject, "op_time", tagInfo.op_time);
            RecomTagInfo recomTagInfo = tagInfo.recom_tag;
            if (recomTagInfo != null) {
                ktc.a(jSONObject, "recom_tag", k7d.b(recomTagInfo));
            }
            ktc.a(jSONObject, QuestionTagListRequestMessage.KEY_CATEGORY, tagInfo.first_category);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
