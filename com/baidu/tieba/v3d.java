package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.StyleContentInfo;
/* loaded from: classes8.dex */
public class v3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StyleContentInfo styleContentInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, styleContentInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "content_color", styleContentInfo.content_color);
            poc.a(jSONObject, "icon", styleContentInfo.icon);
            poc.a(jSONObject, "content_icon", styleContentInfo.content_icon);
            poc.a(jSONObject, "dynamic_icon", styleContentInfo.dynamic_icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
