package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserStory;
/* loaded from: classes8.dex */
public class tad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserStory userStory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userStory)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_id", userStory.user_id);
            ktc.a(jSONObject, "user_name", userStory.user_name);
            ktc.a(jSONObject, "portrait", userStory.portrait);
            ktc.a(jSONObject, "has_read", userStory.has_read);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
