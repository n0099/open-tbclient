package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ComponentFactory;
import tbclient.FeedFeedback;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes8.dex */
public class usc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedLayout feedLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedLayout)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedLayout.components != null) {
                JSONArray jSONArray = new JSONArray();
                for (ComponentFactory componentFactory : feedLayout.components) {
                    jSONArray.put(drc.b(componentFactory));
                }
                poc.a(jSONObject, "components", jSONArray);
            }
            poc.a(jSONObject, "schema", feedLayout.schema);
            if (feedLayout.log_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedLayout.log_info) {
                    jSONArray2.put(tsc.b(feedKV));
                }
                poc.a(jSONObject, "log_info", jSONArray2);
            }
            FeedFeedback feedFeedback = feedLayout.feedback;
            if (feedFeedback != null) {
                poc.a(jSONObject, "feedback", isc.b(feedFeedback));
            }
            if (feedLayout.business_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (FeedKV feedKV2 : feedLayout.business_info) {
                    jSONArray3.put(tsc.b(feedKV2));
                }
                poc.a(jSONObject, "business_info", jSONArray3);
            }
            if (feedLayout.appendix != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FeedKV feedKV3 : feedLayout.appendix) {
                    jSONArray4.put(tsc.b(feedKV3));
                }
                poc.a(jSONObject, "appendix", jSONArray4);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
