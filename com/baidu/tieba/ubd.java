package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes8.dex */
public class ubd extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Zan zan) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zan)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "num", zan.num);
            if (zan.liker_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : zan.liker_list) {
                    jSONArray.put(qad.b(user));
                }
                ltc.a(jSONObject, "liker_list", jSONArray);
            }
            ltc.a(jSONObject, "is_liked", zan.is_liked);
            ltc.a(jSONObject, "last_time", zan.last_time);
            if (zan.liker_id != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (Long l : zan.liker_id) {
                    jSONArray2.put(l.longValue());
                }
                ltc.a(jSONObject, "liker_id", jSONArray2);
            }
            ltc.a(jSONObject, "consent_type", zan.consent_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
