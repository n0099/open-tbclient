package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PbPostZan;
/* loaded from: classes9.dex */
public class z0d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PbPostZan pbPostZan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbPostZan)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "zan_num", pbPostZan.zan_num);
            poc.a(jSONObject, "has_zan", pbPostZan.has_zan);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
