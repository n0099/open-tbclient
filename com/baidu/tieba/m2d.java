package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes7.dex */
public class m2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TipInfo tipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tipInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "tip_name", tipInfo.tip_name);
            ktc.a(jSONObject, "tip_pop_title", tipInfo.tip_pop_title);
            ktc.a(jSONObject, "tip_pop", tipInfo.tip_pop);
            ktc.a(jSONObject, "tip_notice", tipInfo.tip_notice);
            ktc.a(jSONObject, "tip_interval", tipInfo.tip_interval);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
