package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.HotTWThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class tyc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HotTWThreadInfo hotTWThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hotTWThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (hotTWThreadInfo.user_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : hotTWThreadInfo.user_list) {
                    jSONArray.put(m5d.b(user));
                }
                poc.a(jSONObject, "user_list", jSONArray);
            }
            poc.a(jSONObject, "fans_count", hotTWThreadInfo.fans_count);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
