package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GodInfo;
/* loaded from: classes7.dex */
public class oyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GodInfo godInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, godInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", godInfo.id);
            qoc.a(jSONObject, "intro", godInfo.intro);
            qoc.a(jSONObject, "type", godInfo.type);
            qoc.a(jSONObject, "fid", godInfo.fid);
            qoc.a(jSONObject, "followed", godInfo.followed);
            qoc.a(jSONObject, "recommend_reason", godInfo.recommend_reason);
            qoc.a(jSONObject, "forum_name", godInfo.forum_name);
            qoc.a(jSONObject, "can_send_msg", godInfo.can_send_msg);
            qoc.a(jSONObject, "prefix", godInfo.prefix);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
