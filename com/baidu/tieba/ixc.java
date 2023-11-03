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
public class ixc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagInfo tagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "forum_id", tagInfo.forum_id);
            poc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_ID, tagInfo.tag_id);
            poc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tagInfo.tag_name);
            poc.a(jSONObject, "color", tagInfo.color);
            poc.a(jSONObject, "hot_value", tagInfo.hot_value);
            poc.a(jSONObject, "tag_type", tagInfo.tag_type);
            poc.a(jSONObject, "tag_level", tagInfo.tag_level);
            poc.a(jSONObject, "influence", tagInfo.influence);
            poc.a(jSONObject, "relation_weight", tagInfo.relation_weight);
            poc.a(jSONObject, "op_time", tagInfo.op_time);
            RecomTagInfo recomTagInfo = tagInfo.recom_tag;
            if (recomTagInfo != null) {
                poc.a(jSONObject, "recom_tag", h2d.b(recomTagInfo));
            }
            poc.a(jSONObject, QuestionTagListRequestMessage.KEY_CATEGORY, tagInfo.first_category);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
