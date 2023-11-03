package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.MemberShowIcon;
/* loaded from: classes9.dex */
public class zvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MemberShowIcon memberShowIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, memberShowIcon)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", memberShowIcon.icon);
            poc.a(jSONObject, "name", memberShowIcon.name);
            poc.a(jSONObject, "url", memberShowIcon.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
