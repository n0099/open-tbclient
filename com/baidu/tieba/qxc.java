package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedItem;
import tbclient.FeedKV;
/* loaded from: classes7.dex */
public class qxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedItem feedItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon_url", feedItem.icon_url);
            ktc.a(jSONObject, "icon_ratio", feedItem.icon_ratio);
            ktc.a(jSONObject, "name", feedItem.name);
            ktc.a(jSONObject, "score", feedItem.score);
            if (feedItem.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : feedItem.tags) {
                    jSONArray.put(str);
                }
                ktc.a(jSONObject, "tags", jSONArray);
            }
            ktc.a(jSONObject, "button_name", feedItem.button_name);
            ktc.a(jSONObject, "button_link", feedItem.button_link);
            if (feedItem.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedItem.business_info) {
                    jSONArray2.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
