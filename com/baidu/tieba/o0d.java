package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.FeedGroupInfo;
import tbclient.FrsPage.GroupFeedCard;
/* loaded from: classes7.dex */
public class o0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GroupFeedCard groupFeedCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, groupFeedCard)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "card_title", groupFeedCard.card_title);
            ktc.a(jSONObject, "index", groupFeedCard.index);
            if (groupFeedCard.group_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedGroupInfo feedGroupInfo : groupFeedCard.group_list) {
                    jSONArray.put(yzc.b(feedGroupInfo));
                }
                ktc.a(jSONObject, "group_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
