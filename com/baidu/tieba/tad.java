package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserRankPresentInfo;
/* loaded from: classes8.dex */
public class tad extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserRankPresentInfo userRankPresentInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userRankPresentInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", userRankPresentInfo.user_id);
            ltc.a(jSONObject, "user_name", userRankPresentInfo.user_name);
            ltc.a(jSONObject, "present_num", userRankPresentInfo.present_num);
            ltc.a(jSONObject, "present_scores", userRankPresentInfo.present_scores);
            ltc.a(jSONObject, "portrait", userRankPresentInfo.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
