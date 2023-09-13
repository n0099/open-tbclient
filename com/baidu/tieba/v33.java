package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class v33 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v33 e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public cg1 d;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i != -2) {
                return i != 0 ? 6 : 0;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public v33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static v33 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (e == null) {
                synchronized (v33.class) {
                    if (e == null) {
                        e = new v33();
                    }
                }
            }
            return e;
        }
        return (v33) invokeV.objValue;
    }

    @NonNull
    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", str);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
