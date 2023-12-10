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
/* loaded from: classes7.dex */
public class n6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollInfo pollInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", pollInfo.type);
            ltc.a(jSONObject, "is_multi", pollInfo.is_multi);
            ltc.a(jSONObject, "total_num", pollInfo.total_num);
            ltc.a(jSONObject, "options_count", pollInfo.options_count);
            ltc.a(jSONObject, "is_polled", pollInfo.is_polled);
            ltc.a(jSONObject, "polled_value", pollInfo.polled_value);
            ltc.a(jSONObject, "tips", pollInfo.tips);
            ltc.a(jSONObject, "end_time", pollInfo.end_time);
            if (pollInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (PollOption pollOption : pollInfo.options) {
                    jSONArray.put(o6d.b(pollOption));
                }
                ltc.a(jSONObject, "options", jSONArray);
            }
            ltc.a(jSONObject, "status", pollInfo.status);
            ltc.a(jSONObject, "total_poll", pollInfo.total_poll);
            ltc.a(jSONObject, "title", pollInfo.title);
            ltc.a(jSONObject, "last_time", pollInfo.last_time);
            if (pollInfo.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : pollInfo.business_info) {
                    jSONArray2.put(sxc.b(feedKV));
                }
                ltc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
