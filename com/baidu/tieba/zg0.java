package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public zg0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
    }

    @NonNull
    public static zg0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            zg0 zg0Var = new zg0();
            JSONObject c = my0.c(str);
            zg0Var.a = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_1);
            zg0Var.b = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_2);
            zg0Var.c = c.optString(PermissionStorage.PermissionItem.ITEM_EXT_3);
            return zg0Var;
        }
        return (zg0) invokeL.objValue;
    }

    public static String b(@NonNull zg0 zg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zg0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_1, zg0Var.a);
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_2, zg0Var.b);
                jSONObject.put(PermissionStorage.PermissionItem.ITEM_EXT_3, zg0Var.c);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
