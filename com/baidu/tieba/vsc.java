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
public class vsc extends qoc {
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
                    jSONArray.put(erc.b(componentFactory));
                }
                qoc.a(jSONObject, "components", jSONArray);
            }
            qoc.a(jSONObject, "schema", feedLayout.schema);
            if (feedLayout.log_info != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (FeedKV feedKV : feedLayout.log_info) {
                    jSONArray2.put(usc.b(feedKV));
                }
                qoc.a(jSONObject, "log_info", jSONArray2);
            }
            FeedFeedback feedFeedback = feedLayout.feedback;
            if (feedFeedback != null) {
                qoc.a(jSONObject, "feedback", jsc.b(feedFeedback));
            }
            if (feedLayout.business_info != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (FeedKV feedKV2 : feedLayout.business_info) {
                    jSONArray3.put(usc.b(feedKV2));
                }
                qoc.a(jSONObject, "business_info", jSONArray3);
            }
            if (feedLayout.appendix != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (FeedKV feedKV3 : feedLayout.appendix) {
                    jSONArray4.put(usc.b(feedKV3));
                }
                qoc.a(jSONObject, "appendix", jSONArray4);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
