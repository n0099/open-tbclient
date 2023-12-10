package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AtMsgBase;
/* loaded from: classes8.dex */
public class uuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AtMsgBase atMsgBase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, atMsgBase)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "msg_id", atMsgBase.msg_id);
            ltc.a(jSONObject, "msg_key", atMsgBase.msg_key);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
