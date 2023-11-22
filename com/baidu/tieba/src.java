package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Ecom;
/* loaded from: classes8.dex */
public class src extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Ecom ecom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ecom)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_seller", ecom.is_seller);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
