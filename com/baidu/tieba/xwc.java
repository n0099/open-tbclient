package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ShowIcon;
/* loaded from: classes9.dex */
public class xwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShowIcon showIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, showIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", showIcon.icon);
            qoc.a(jSONObject, "name", showIcon.name);
            qoc.a(jSONObject, "url", showIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
