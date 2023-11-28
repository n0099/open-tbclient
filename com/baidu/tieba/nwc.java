package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DetailInfo;
/* loaded from: classes7.dex */
public class nwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DetailInfo detailInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, detailInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text", detailInfo.text);
            ltc.a(jSONObject, "url", detailInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
