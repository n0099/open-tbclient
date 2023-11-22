package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TbreadDispatch;
/* loaded from: classes7.dex */
public class l4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TbreadDispatch tbreadDispatch) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbreadDispatch)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "floor_num", tbreadDispatch.floor_num);
            qoc.a(jSONObject, "product_type", tbreadDispatch.product_type);
            qoc.a(jSONObject, "product_id", tbreadDispatch.product_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
