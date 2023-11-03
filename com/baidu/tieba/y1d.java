package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PushStatus;
import tbclient.PushType;
/* loaded from: classes9.dex */
public class y1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushStatus pushStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "status", pushStatus.status);
            if (pushStatus.types != null) {
                JSONArray jSONArray = new JSONArray();
                for (PushType pushType : pushStatus.types) {
                    jSONArray.put(z1d.b(pushType));
                }
                poc.a(jSONObject, "types", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
