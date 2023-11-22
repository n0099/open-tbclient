package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemDetail;
/* loaded from: classes9.dex */
public class yyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemDetail itemDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "name", itemDetail.name);
            qoc.a(jSONObject, "value", itemDetail.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
