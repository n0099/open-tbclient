package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserRankPresentInfo;
/* loaded from: classes7.dex */
public class q5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserRankPresentInfo userRankPresentInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userRankPresentInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", userRankPresentInfo.user_id);
            qoc.a(jSONObject, "user_name", userRankPresentInfo.user_name);
            qoc.a(jSONObject, "present_num", userRankPresentInfo.present_num);
            qoc.a(jSONObject, "present_scores", userRankPresentInfo.present_scores);
            qoc.a(jSONObject, "portrait", userRankPresentInfo.portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
