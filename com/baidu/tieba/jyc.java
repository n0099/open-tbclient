package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GameAttr;
import tbclient.SignatureInfo;
/* loaded from: classes6.dex */
public class jyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameAttr gameAttr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameAttr)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", gameAttr.user_id);
            SignatureInfo signatureInfo = gameAttr.signature_info;
            if (signatureInfo != null) {
                poc.a(jSONObject, "signature_info", f3d.b(signatureInfo));
            }
            poc.a(jSONObject, "is_open", gameAttr.is_open);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
