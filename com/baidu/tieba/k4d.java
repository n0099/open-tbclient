package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TbmallMonthIcon;
/* loaded from: classes7.dex */
public class k4d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TbmallMonthIcon tbmallMonthIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbmallMonthIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "mon", tbmallMonthIcon.mon);
            qoc.a(jSONObject, "icon", tbmallMonthIcon.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
