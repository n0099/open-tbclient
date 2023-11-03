package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserRankPresentInfo;
/* loaded from: classes7.dex */
public class p5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserRankPresentInfo userRankPresentInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userRankPresentInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", userRankPresentInfo.user_id);
            poc.a(jSONObject, "user_name", userRankPresentInfo.user_name);
            poc.a(jSONObject, "present_num", userRankPresentInfo.present_num);
            poc.a(jSONObject, "present_scores", userRankPresentInfo.present_scores);
            poc.a(jSONObject, "portrait", userRankPresentInfo.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
