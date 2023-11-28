package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.HotTWThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class x3d extends ltc {
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
                    jSONArray.put(qad.b(user));
                }
                ltc.a(jSONObject, "user_list", jSONArray);
            }
            ltc.a(jSONObject, "fans_count", hotTWThreadInfo.fans_count);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
