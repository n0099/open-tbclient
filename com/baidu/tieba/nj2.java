package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class nj2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public JSONObject d;

    public nj2() {
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f63.K().k() == 0) {
                return c(this.d, "bbasp_guide_");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String string = ue3.a().getString("swan_guide_toast", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a) {
                return "special";
            }
            if (this.b) {
                return "normal";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.b && !this.a) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONArray optJSONArray = this.d.optJSONArray("custom_guide_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("appid", "");
                    if (g63.h0() == null || TextUtils.equals(g63.h0(), optString)) {
                        return c(optJSONObject, "");
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        int i;
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            boolean z2 = false;
            if (jSONObject == null) {
                return false;
            }
            String optString = jSONObject.optString(str + "count", "3");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    i = Integer.valueOf(optString).intValue();
                } else {
                    i = 0;
                }
                String optString2 = jSONObject.optString(str + "interval", "72");
                if (!TextUtils.isEmpty(optString2)) {
                    j = Long.valueOf(optString2).longValue();
                } else {
                    j = 0;
                }
                long optLong = jSONObject.optLong(str + "last_time", 0L);
                int optInt = jSONObject.optInt(str + "shown_count", 0);
                int optInt2 = jSONObject.optInt(str + "image_index", 0);
                if (System.currentTimeMillis() - optLong > j * 3600000) {
                    z = true;
                } else {
                    z = false;
                }
                boolean i2 = i(jSONObject.optJSONArray("scenes"));
                if (optInt < i && z && i2) {
                    z2 = true;
                }
                if (z2) {
                    g(jSONObject, optInt2, str + "images");
                }
            } catch (NumberFormatException unused) {
            }
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public final int g(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048582, this, jSONObject, i, str)) == null) {
            if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i >= optJSONArray.length()) {
                i = 0;
            }
            this.c = optJSONArray.optString(i);
            return i;
        }
        return invokeLIL.intValue;
    }

    public nj2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.a = false;
            this.b = false;
            this.c = null;
            JSONObject d = d();
            this.d = d;
            if (d != null && d.length() != 0) {
                boolean b = b();
                this.a = b;
                if (b) {
                    return this;
                }
                this.b = a();
            }
            return this;
        }
        return (nj2) invokeV.objValue;
    }

    public final boolean i(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return true;
            }
            String U = f63.K().q().X().U();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(U, jSONArray.optString(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
