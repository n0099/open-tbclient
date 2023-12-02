package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.TbVipInfo;
/* loaded from: classes7.dex */
public class l9d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TbVipInfo tbVipInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbVipInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "intro", tbVipInfo.intro);
            ktc.a(jSONObject, "v_url", tbVipInfo.v_url);
            ktc.a(jSONObject, "v_detail", tbVipInfo.v_detail);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
