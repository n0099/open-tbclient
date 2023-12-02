package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LiveCoverStatus;
/* loaded from: classes8.dex */
public class v4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LiveCoverStatus liveCoverStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveCoverStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "status_num", liveCoverStatus.status_num);
            ktc.a(jSONObject, "status", liveCoverStatus.status);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
