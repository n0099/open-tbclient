package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.PushThreadInfo;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class owc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushThreadInfo pushThreadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushThreadInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (pushThreadInfo.thread_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (ThreadInfo threadInfo : pushThreadInfo.thread_list) {
                    jSONArray.put(v4d.b(threadInfo));
                }
                qoc.a(jSONObject, "thread_list", jSONArray);
            }
            qoc.a(jSONObject, "has_pushcard", pushThreadInfo.has_pushcard);
            qoc.a(jSONObject, "has_pushplace", pushThreadInfo.has_pushplace);
            if (pushThreadInfo.user_list != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (User user : pushThreadInfo.user_list) {
                    jSONArray2.put(n5d.b(user));
                }
                qoc.a(jSONObject, "user_list", jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
