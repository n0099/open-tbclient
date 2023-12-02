package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ShowIcon;
/* loaded from: classes9.dex */
public class x1d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShowIcon showIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, showIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", showIcon.icon);
            ktc.a(jSONObject, "name", showIcon.name);
            ktc.a(jSONObject, "url", showIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
