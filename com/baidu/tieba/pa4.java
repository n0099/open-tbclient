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
public class pa4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<j42> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055302, "Lcom/baidu/tieba/pa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055302, "Lcom/baidu/tieba/pa4;");
                return;
            }
        }
        b = ms1.a;
    }

    public pa4(JSONArray jSONArray) {
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

    public final j42 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            j42 j42Var = new j42();
            j42Var.G("type", jSONObject.optString("type"));
            j42Var.G("url", jSONObject.optString("url"));
            j42Var.G("filePath", jSONObject.optString("filePath"));
            j42Var.G("header", c(jSONObject.optJSONObject("header")));
            return j42Var;
        }
        return (j42) invokeL.objValue;
    }

    public final j42 b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            j42 j42Var = new j42();
            j42Var.G("type", jSONObject.optString("type"));
            j42Var.G("url", jSONObject.optString("url"));
            j42Var.G("responseType", jSONObject.optString("responseType"));
            j42Var.G("header", c(jSONObject.optJSONObject("header")));
            return j42Var;
        }
        return (j42) invokeL.objValue;
    }

    public final j42 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            j42 j42Var = new j42();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                j42Var.G(next, jSONObject.optString(next));
            }
            return j42Var;
        }
        return (j42) invokeL.objValue;
    }
}
