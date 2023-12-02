package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WindowToast;
/* loaded from: classes7.dex */
public class nbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WindowToast windowToast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, windowToast)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "toast_type", windowToast.toast_type);
            ktc.a(jSONObject, "toast_link", windowToast.toast_link);
            ktc.a(jSONObject, "toast_content", windowToast.toast_content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
