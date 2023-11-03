package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedKV;
import tbclient.PollInfo;
import tbclient.PollOption;
/* loaded from: classes6.dex */
public class j1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollInfo pollInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", pollInfo.type);
            poc.a(jSONObject, "is_multi", pollInfo.is_multi);
            poc.a(jSONObject, "total_num", pollInfo.total_num);
            poc.a(jSONObject, "options_count", pollInfo.options_count);
            poc.a(jSONObject, "is_polled", pollInfo.is_polled);
            poc.a(jSONObject, "polled_value", pollInfo.polled_value);
            poc.a(jSONObject, "tips", pollInfo.tips);
            poc.a(jSONObject, "end_time", pollInfo.end_time);
            if (pollInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (PollOption pollOption : pollInfo.options) {
                    jSONArray.put(k1d.b(pollOption));
                }
                poc.a(jSONObject, "options", jSONArray);
            }
            poc.a(jSONObject, "status", pollInfo.status);
            poc.a(jSONObject, "total_poll", pollInfo.total_poll);
            poc.a(jSONObject, "title", pollInfo.title);
            poc.a(jSONObject, "last_time", pollInfo.last_time);
            if (pollInfo.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : pollInfo.business_info) {
                    jSONArray2.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
