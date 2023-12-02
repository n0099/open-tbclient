package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WorldCupInfo;
/* loaded from: classes7.dex */
public class qbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupInfo worldCupInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "avatar_teamflag_url", worldCupInfo.avatar_teamflag_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
