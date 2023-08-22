package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k32> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948046653, "Lcom/baidu/tieba/q94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948046653, "Lcom/baidu/tieba/q94;");
                return;
            }
        }
        b = nr1.a;
    }

    public q94(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        if (jSONArray == null) {
            return;
        }
        if (b) {
            Log.d("SwanGamePreloadConfig", "jsonArray:" + jSONArray);
        }
        int length = jSONArray.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("type");
                char c = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 1095692943) {
                    if (hashCode == 1427818632 && optString.equals("download")) {
                        c = 1;
                    }
                } else if (optString.equals("request")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1 && i4 < 10) {
                        this.a.add(a(optJSONObject));
                        i4++;
                    }
                } else if (i3 < 3) {
                    this.a.add(b(optJSONObject));
                    i3++;
                }
            }
        }
    }

    public final k32 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            k32 k32Var = new k32();
            k32Var.G("type", jSONObject.optString("type"));
            k32Var.G("url", jSONObject.optString("url"));
            k32Var.G("filePath", jSONObject.optString("filePath"));
            k32Var.G("header", c(jSONObject.optJSONObject("header")));
            return k32Var;
        }
        return (k32) invokeL.objValue;
    }

    public final k32 b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            k32 k32Var = new k32();
            k32Var.G("type", jSONObject.optString("type"));
            k32Var.G("url", jSONObject.optString("url"));
            k32Var.G("responseType", jSONObject.optString("responseType"));
            k32Var.G("header", c(jSONObject.optJSONObject("header")));
            return k32Var;
        }
        return (k32) invokeL.objValue;
    }

    public final k32 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            k32 k32Var = new k32();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                k32Var.G(next, jSONObject.optString(next));
            }
            return k32Var;
        }
        return (k32) invokeL.objValue;
    }
}
