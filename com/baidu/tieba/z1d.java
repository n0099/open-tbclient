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
public class z1d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushStatus pushStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "status", pushStatus.status);
            if (pushStatus.types != null) {
                JSONArray jSONArray = new JSONArray();
                for (PushType pushType : pushStatus.types) {
                    jSONArray.put(a2d.b(pushType));
                }
                qoc.a(jSONObject, "types", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
