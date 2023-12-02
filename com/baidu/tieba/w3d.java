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
public class w3d extends ktc {
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
                    jSONArray.put(pad.b(user));
                }
                ktc.a(jSONObject, "user_list", jSONArray);
            }
            ktc.a(jSONObject, "fans_count", hotTWThreadInfo.fans_count);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
