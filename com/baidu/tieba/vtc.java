package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActivitySponsor;
/* loaded from: classes8.dex */
public class vtc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActivitySponsor activitySponsor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activitySponsor)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_sponsor", activitySponsor.is_sponsor);
            ltc.a(jSONObject, "sponsor_url", activitySponsor.sponsor_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
