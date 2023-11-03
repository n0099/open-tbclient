package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes7.dex */
public class nyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GodInfo godInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, godInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", godInfo.id);
            poc.a(jSONObject, "intro", godInfo.intro);
            poc.a(jSONObject, "type", godInfo.type);
            poc.a(jSONObject, "fid", godInfo.fid);
            poc.a(jSONObject, "followed", godInfo.followed);
            poc.a(jSONObject, "recommend_reason", godInfo.recommend_reason);
            poc.a(jSONObject, "forum_name", godInfo.forum_name);
            poc.a(jSONObject, "can_send_msg", godInfo.can_send_msg);
            poc.a(jSONObject, "prefix", godInfo.prefix);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
