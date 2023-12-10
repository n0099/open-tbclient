package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes9.dex */
public class z5d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PayMemberInfo payMemberInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, payMemberInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", payMemberInfo.props_id);
            ltc.a(jSONObject, "end_time", payMemberInfo.end_time);
            ltc.a(jSONObject, "url", payMemberInfo.url);
            ltc.a(jSONObject, "expire_remind", payMemberInfo.expire_remind);
            ltc.a(jSONObject, "pic_url", payMemberInfo.pic_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
