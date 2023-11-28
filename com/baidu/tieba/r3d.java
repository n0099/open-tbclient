package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes8.dex */
public class r3d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GodInfo godInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, godInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "id", godInfo.id);
            ltc.a(jSONObject, "intro", godInfo.intro);
            ltc.a(jSONObject, "type", godInfo.type);
            ltc.a(jSONObject, "fid", godInfo.fid);
            ltc.a(jSONObject, "followed", godInfo.followed);
            ltc.a(jSONObject, "recommend_reason", godInfo.recommend_reason);
            ltc.a(jSONObject, "forum_name", godInfo.forum_name);
            ltc.a(jSONObject, "can_send_msg", godInfo.can_send_msg);
            ltc.a(jSONObject, "prefix", godInfo.prefix);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
