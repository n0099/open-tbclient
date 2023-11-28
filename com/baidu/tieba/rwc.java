package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EditConfig;
/* loaded from: classes8.dex */
public class rwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EditConfig editConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, editConfig)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "show_edit", editConfig.show_edit);
            ltc.a(jSONObject, "is_first_edit", editConfig.is_first_edit);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
