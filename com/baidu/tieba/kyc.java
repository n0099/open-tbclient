package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GameAttr;
import tbclient.SignatureInfo;
/* loaded from: classes7.dex */
public class kyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GameAttr gameAttr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gameAttr)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", gameAttr.user_id);
            SignatureInfo signatureInfo = gameAttr.signature_info;
            if (signatureInfo != null) {
                qoc.a(jSONObject, "signature_info", g3d.b(signatureInfo));
            }
            qoc.a(jSONObject, "is_open", gameAttr.is_open);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
