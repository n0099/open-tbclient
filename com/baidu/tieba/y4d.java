package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.LotteryRegular;
/* loaded from: classes9.dex */
public class y4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LotteryRegular lotteryRegular) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lotteryRegular)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "regular", lotteryRegular.regular);
            if (lotteryRegular.chance != null) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : lotteryRegular.chance) {
                    jSONArray.put(num.intValue());
                }
                ltc.a(jSONObject, "chance", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
