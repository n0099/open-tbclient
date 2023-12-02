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
public class m6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PollInfo pollInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pollInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", pollInfo.type);
            ktc.a(jSONObject, "is_multi", pollInfo.is_multi);
            ktc.a(jSONObject, "total_num", pollInfo.total_num);
            ktc.a(jSONObject, "options_count", pollInfo.options_count);
            ktc.a(jSONObject, "is_polled", pollInfo.is_polled);
            ktc.a(jSONObject, "polled_value", pollInfo.polled_value);
            ktc.a(jSONObject, "tips", pollInfo.tips);
            ktc.a(jSONObject, "end_time", pollInfo.end_time);
            if (pollInfo.options != null) {
                JSONArray jSONArray = new JSONArray();
                for (PollOption pollOption : pollInfo.options) {
                    jSONArray.put(n6d.b(pollOption));
                }
                ktc.a(jSONObject, "options", jSONArray);
            }
            ktc.a(jSONObject, "status", pollInfo.status);
            ktc.a(jSONObject, "total_poll", pollInfo.total_poll);
            ktc.a(jSONObject, "title", pollInfo.title);
            ktc.a(jSONObject, "last_time", pollInfo.last_time);
            if (pollInfo.business_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : pollInfo.business_info) {
                    jSONArray2.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "business_info", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
