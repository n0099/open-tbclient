package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AbstractComponent;
import tbclient.FeedContentResource;
/* loaded from: classes8.dex */
public class roc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AbstractComponent abstractComponent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, abstractComponent)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (abstractComponent.data != null) {
                JSONArray jSONArray = new JSONArray();
                for (FeedContentResource feedContentResource : abstractComponent.data) {
                    jSONArray.put(fsc.b(feedContentResource));
                }
                poc.a(jSONObject, "data", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
