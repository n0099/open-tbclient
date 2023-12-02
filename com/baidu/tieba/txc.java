package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedLinkComponent;
import tbclient.PbLinkInfo;
/* loaded from: classes8.dex */
public class txc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedLinkComponent feedLinkComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedLinkComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (feedLinkComponent.links != null) {
                JSONArray jSONArray = new JSONArray();
                for (PbLinkInfo pbLinkInfo : feedLinkComponent.links) {
                    jSONArray.put(b6d.b(pbLinkInfo));
                }
                ktc.a(jSONObject, "links", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
