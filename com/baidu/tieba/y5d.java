package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PayMemberInfo;
/* loaded from: classes9.dex */
public class y5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PayMemberInfo payMemberInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, payMemberInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "props_id", payMemberInfo.props_id);
            ktc.a(jSONObject, "end_time", payMemberInfo.end_time);
            ktc.a(jSONObject, "url", payMemberInfo.url);
            ktc.a(jSONObject, "expire_remind", payMemberInfo.expire_remind);
            ktc.a(jSONObject, "pic_url", payMemberInfo.pic_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
