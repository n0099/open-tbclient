package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.UserStory;
/* loaded from: classes8.dex */
public class r5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull UserStory userStory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userStory)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", userStory.user_id);
            qoc.a(jSONObject, "user_name", userStory.user_name);
            qoc.a(jSONObject, "portrait", userStory.portrait);
            qoc.a(jSONObject, "has_read", userStory.has_read);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
