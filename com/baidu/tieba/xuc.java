package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AwardInfo;
/* loaded from: classes9.dex */
public class xuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AwardInfo awardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, awardInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "award_id", awardInfo.award_id);
            ltc.a(jSONObject, "award_act_id", awardInfo.award_act_id);
            ltc.a(jSONObject, "award_name", awardInfo.award_name);
            ltc.a(jSONObject, "award_imgsrc", awardInfo.award_imgsrc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
