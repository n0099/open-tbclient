package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RewardMaterial;
/* loaded from: classes8.dex */
public class t7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RewardMaterial rewardMaterial) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rewardMaterial)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", rewardMaterial.icon);
            ltc.a(jSONObject, "unlock_level", rewardMaterial.unlock_level);
            ltc.a(jSONObject, "is_matched", rewardMaterial.is_matched);
            ltc.a(jSONObject, "is_newest_matched_level", rewardMaterial.is_newest_matched_level);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
