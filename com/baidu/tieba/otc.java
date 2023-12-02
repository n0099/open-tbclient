package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActBtn;
/* loaded from: classes7.dex */
public class otc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActBtn actBtn) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actBtn)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", actBtn.type);
            ktc.a(jSONObject, "url", actBtn.url);
            ktc.a(jSONObject, "text", actBtn.text);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
