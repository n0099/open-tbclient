package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes7.dex */
public class q3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GodInfo godInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, godInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "id", godInfo.id);
            ktc.a(jSONObject, "intro", godInfo.intro);
            ktc.a(jSONObject, "type", godInfo.type);
            ktc.a(jSONObject, "fid", godInfo.fid);
            ktc.a(jSONObject, "followed", godInfo.followed);
            ktc.a(jSONObject, "recommend_reason", godInfo.recommend_reason);
            ktc.a(jSONObject, "forum_name", godInfo.forum_name);
            ktc.a(jSONObject, "can_send_msg", godInfo.can_send_msg);
            ktc.a(jSONObject, "prefix", godInfo.prefix);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
