package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Ticket;
/* loaded from: classes7.dex */
public class m2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Ticket ticket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ticket)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "time", ticket.time);
            ltc.a(jSONObject, "url", ticket.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
