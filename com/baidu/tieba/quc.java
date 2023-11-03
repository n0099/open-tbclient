package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Classify;
/* loaded from: classes8.dex */
public class quc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Classify classify) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, classify)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "name", classify.name);
            poc.a(jSONObject, "id", classify.id);
            poc.a(jSONObject, "class_id", classify.class_id);
            poc.a(jSONObject, ForumSquareActivityConfig.FORUM_CLASS_NAME, classify.class_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
