package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedHeadButton;
import tbclient.FeedKV;
/* loaded from: classes6.dex */
public class ixc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedHeadButton feedHeadButton) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedHeadButton)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", feedHeadButton.type);
            if (feedHeadButton.business_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedKV feedKV : feedHeadButton.business_info) {
                    jSONArray.put(rxc.b(feedKV));
                }
                ktc.a(jSONObject, "business_info", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
