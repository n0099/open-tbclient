package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.WidthHeight;
/* loaded from: classes7.dex */
public class mbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WidthHeight widthHeight) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, widthHeight)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "width", widthHeight.width);
            ktc.a(jSONObject, "height", widthHeight.height);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
