package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ClientPlatform;
import tbclient.FrsPage.StarSchedule;
/* loaded from: classes8.dex */
public class ruc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ClientPlatform clientPlatform) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, clientPlatform)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "schedule_cal", clientPlatform.schedule_cal);
            StarSchedule starSchedule = clientPlatform.star_schedule;
            if (starSchedule != null) {
                poc.a(jSONObject, "star_schedule", fxc.b(starSchedule));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
