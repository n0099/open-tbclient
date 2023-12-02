package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ClientPlatform;
import tbclient.FrsPage.StarSchedule;
/* loaded from: classes8.dex */
public class rzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ClientPlatform clientPlatform) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, clientPlatform)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "schedule_cal", clientPlatform.schedule_cal);
            StarSchedule starSchedule = clientPlatform.star_schedule;
            if (starSchedule != null) {
                ktc.a(jSONObject, "star_schedule", g2d.b(starSchedule));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
