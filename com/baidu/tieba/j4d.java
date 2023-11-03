package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TbmallMonthIcon;
/* loaded from: classes6.dex */
public class j4d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TbmallMonthIcon tbmallMonthIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbmallMonthIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "mon", tbmallMonthIcon.mon);
            poc.a(jSONObject, "icon", tbmallMonthIcon.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
