package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DelThreadText;
/* loaded from: classes7.dex */
public class mrc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DelThreadText delThreadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, delThreadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text_id", delThreadText.text_id);
            poc.a(jSONObject, "text_info", delThreadText.text_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
