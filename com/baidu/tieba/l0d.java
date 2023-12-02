package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.GconAccount;
/* loaded from: classes7.dex */
public class l0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GconAccount gconAccount) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gconAccount)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "has_account", gconAccount.has_account);
            ktc.a(jSONObject, "menu_name", gconAccount.menu_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
