package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WindowToast;
/* loaded from: classes7.dex */
public class k6d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WindowToast windowToast) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, windowToast)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "toast_type", windowToast.toast_type);
            qoc.a(jSONObject, "toast_link", windowToast.toast_link);
            qoc.a(jSONObject, "toast_content", windowToast.toast_content);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
