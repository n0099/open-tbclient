package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PkItem;
import tbclient.PkModule;
/* loaded from: classes7.dex */
public class l6d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PkModule pkModule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pkModule)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "pk_id", pkModule.pk_id);
            ltc.a(jSONObject, "user_pk_id", pkModule.user_pk_id);
            PkItem pkItem = pkModule.agree;
            if (pkItem != null) {
                ltc.a(jSONObject, "agree", k6d.b(pkItem));
            }
            PkItem pkItem2 = pkModule.disagree;
            if (pkItem2 != null) {
                ltc.a(jSONObject, "disagree", k6d.b(pkItem2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
