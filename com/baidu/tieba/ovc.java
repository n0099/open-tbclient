package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Group;
/* loaded from: classes7.dex */
public class ovc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Group group) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, group)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "hide_recommend_group", group.hide_recommend_group);
            qoc.a(jSONObject, "group_count", group.group_count);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
