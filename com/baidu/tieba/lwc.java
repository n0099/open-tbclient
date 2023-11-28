package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.DelThreadText;
/* loaded from: classes7.dex */
public class lwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull DelThreadText delThreadText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, delThreadText)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "text_id", delThreadText.text_id);
            ltc.a(jSONObject, "text_info", delThreadText.text_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
