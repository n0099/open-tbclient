package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ok0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public ok0() {
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
    public static ok0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ok0 ok0Var = new ok0();
            JSONObject c = p01.c(str);
            ok0Var.a = c.optString("ext1");
            ok0Var.b = c.optString("ext2");
            ok0Var.c = c.optString("ext3");
            return ok0Var;
        }
        return (ok0) invokeL.objValue;
    }

    public static String b(@NonNull ok0 ok0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ok0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext1", ok0Var.a);
                jSONObject.put("ext2", ok0Var.b);
                jSONObject.put("ext3", ok0Var.c);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
