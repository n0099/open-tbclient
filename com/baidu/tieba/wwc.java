package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ShowIcon;
/* loaded from: classes8.dex */
public class wwc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShowIcon showIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, showIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", showIcon.icon);
            poc.a(jSONObject, "name", showIcon.name);
            poc.a(jSONObject, "url", showIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
