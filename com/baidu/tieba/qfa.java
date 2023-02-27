package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qfa implements mfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONObject a;

    public qfa(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b(inputStream);
    }

    public qfa(InputStream inputStream, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = b(inputStream);
        c(str);
    }

    @Override // com.baidu.tieba.mfa
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (str.endsWith("/")) {
                return str2;
            }
            String[] split = str.split("/");
            try {
                JSONObject jSONObject = this.a;
                for (int i = 1; i < split.length; i++) {
                    if (i == split.length - 1) {
                        str = jSONObject.get(split[i]).toString();
                        return str;
                    }
                    jSONObject = jSONObject.getJSONObject(split[i]);
                }
            } catch (JSONException unused) {
                Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final JSONObject b(InputStream inputStream) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            if (inputStream != null) {
                try {
                    return new JSONObject(ifa.g(inputStream, "UTF-8"));
                } catch (IOException unused) {
                    str = "IOException when reading the 'Config' from InputStream.";
                    Log.e("InputStreamReader", str);
                    return new JSONObject();
                } catch (JSONException unused2) {
                    str = "JSONException when reading the 'Config' from InputStream.";
                    Log.e("InputStreamReader", str);
                    return new JSONObject();
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                JSONObject e = e(str);
                if (e == null) {
                    return;
                }
                String a = a("/configuration_version", "");
                BigDecimal bigDecimal = new BigDecimal("0.0");
                try {
                    bigDecimal = BigDecimal.valueOf(Double.parseDouble(a));
                } catch (NumberFormatException unused) {
                    Log.d("InputStreamReader", "configuration_version to double error");
                }
                if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                    this.a.getJSONObject("client").put("app_id", e.getString("app_id"));
                } else if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                    Iterator<String> keys = e.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!"package_name".equals(next)) {
                            d(next, e.get(next), this.a);
                        }
                    }
                }
            } catch (JSONException unused2) {
                Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
            }
        }
    }

    public final void d(String str, Object obj, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, str, obj, jSONObject) == null) || str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            d(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    public final JSONObject e(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            JSONArray jSONArray = this.a.getJSONArray("appInfos");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString("package_name").equals(str)) {
                    return jSONObject;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "InputStreamReader{config=" + this.a.toString().hashCode() + '}';
        }
        return (String) invokeV.objValue;
    }
}
