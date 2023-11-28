package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedItem;
import tbclient.FeedKV;
/* loaded from: classes8.dex */
public class rxc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedItem feedItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedItem)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon_url", feedItem.icon_url);
            ltc.a(jSONObject, "icon_ratio", feedItem.icon_ratio);
            ltc.a(jSONObject, "name", feedItem.name);
            ltc.a(jSONObject, "score", feedItem.score);
            if (feedItem.tags != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : feedItem.tags) {
                    jSONArray.put(str);
                }
                ltc.a(jSONObject, "tags", jSONArray);
            }
            ltc.a(jSONObject, "button_name", feedItem.button_name);
            ltc.a(jSONObject, "button_link", feedItem.button_link);
            if (feedItem.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedItem.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
