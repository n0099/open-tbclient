package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AwardInfo;
/* loaded from: classes8.dex */
public class wuc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AwardInfo awardInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, awardInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "award_id", awardInfo.award_id);
            ktc.a(jSONObject, "award_act_id", awardInfo.award_act_id);
            ktc.a(jSONObject, "award_name", awardInfo.award_name);
            ktc.a(jSONObject, "award_imgsrc", awardInfo.award_imgsrc);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
