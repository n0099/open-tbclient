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
/* loaded from: classes8.dex */
public class u94 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<o32> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165817, "Lcom/baidu/tieba/u94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165817, "Lcom/baidu/tieba/u94;");
                return;
            }
        }
        b = rr1.a;
    }

    public u94(JSONArray jSONArray) {
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

    public final o32 a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            o32 o32Var = new o32();
            o32Var.G("type", jSONObject.optString("type"));
            o32Var.G("url", jSONObject.optString("url"));
            o32Var.G("filePath", jSONObject.optString("filePath"));
            o32Var.G("header", c(jSONObject.optJSONObject("header")));
            return o32Var;
        }
        return (o32) invokeL.objValue;
    }

    public final o32 b(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            o32 o32Var = new o32();
            o32Var.G("type", jSONObject.optString("type"));
            o32Var.G("url", jSONObject.optString("url"));
            o32Var.G("responseType", jSONObject.optString("responseType"));
            o32Var.G("header", c(jSONObject.optJSONObject("header")));
            return o32Var;
        }
        return (o32) invokeL.objValue;
    }

    public final o32 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            o32 o32Var = new o32();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                o32Var.G(next, jSONObject.optString(next));
            }
            return o32Var;
        }
        return (o32) invokeL.objValue;
    }
}
