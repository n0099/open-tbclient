package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserStory;
/* loaded from: classes7.dex */
public class q5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserStory userStory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userStory)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", userStory.user_id);
            poc.a(jSONObject, "user_name", userStory.user_name);
            poc.a(jSONObject, "portrait", userStory.portrait);
            poc.a(jSONObject, "has_read", userStory.has_read);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
