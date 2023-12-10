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
public class k2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TagInfo tagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "forum_id", tagInfo.forum_id);
            ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_ID, tagInfo.tag_id);
            ltc.a(jSONObject, PushConstants.SUB_TAGS_STATUS_NAME, tagInfo.tag_name);
            ltc.a(jSONObject, "color", tagInfo.color);
            ltc.a(jSONObject, "hot_value", tagInfo.hot_value);
            ltc.a(jSONObject, "tag_type", tagInfo.tag_type);
            ltc.a(jSONObject, "tag_level", tagInfo.tag_level);
            ltc.a(jSONObject, "influence", tagInfo.influence);
            ltc.a(jSONObject, "relation_weight", tagInfo.relation_weight);
            ltc.a(jSONObject, "op_time", tagInfo.op_time);
            RecomTagInfo recomTagInfo = tagInfo.recom_tag;
            if (recomTagInfo != null) {
                ltc.a(jSONObject, "recom_tag", l7d.b(recomTagInfo));
            }
            ltc.a(jSONObject, QuestionTagListRequestMessage.KEY_CATEGORY, tagInfo.first_category);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
