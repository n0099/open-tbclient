package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes7.dex */
public class k2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecommendInfo recommendInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recommendInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", recommendInfo.title);
            if (recommendInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                    jSONArray.put(u2d.b(schoolRecomUserInfo));
                }
                poc.a(jSONObject, "user_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
