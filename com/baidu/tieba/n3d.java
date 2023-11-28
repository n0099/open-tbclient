package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GameAttr;
import tbclient.SignatureInfo;
/* loaded from: classes7.dex */
public class n3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameAttr gameAttr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameAttr)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", gameAttr.user_id);
            SignatureInfo signatureInfo = gameAttr.signature_info;
            if (signatureInfo != null) {
                ltc.a(jSONObject, "signature_info", j8d.b(signatureInfo));
            }
            ltc.a(jSONObject, "is_open", gameAttr.is_open);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
