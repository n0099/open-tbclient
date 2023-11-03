package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WindowToast;
/* loaded from: classes6.dex */
public class j6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WindowToast windowToast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, windowToast)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "toast_type", windowToast.toast_type);
            poc.a(jSONObject, "toast_link", windowToast.toast_link);
            poc.a(jSONObject, "toast_content", windowToast.toast_content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
