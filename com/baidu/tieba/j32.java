package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public JSONArray g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832288, "Lcom/baidu/tieba/j32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832288, "Lcom/baidu/tieba/j32;");
                return;
            }
        }
        h = am1.a;
    }

    public j32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static j32 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            j32 j32Var = new j32();
            try {
                j32Var.a = jSONObject.getString("appKey");
                j32Var.b = jSONObject.getString(DeepLinkItem.DEEPLINK_APPURL_KEY) + "?swanJsVersion=" + ue3.h(0) + "&appVersion=" + jj3.D();
                j32Var.c = jSONObject.getString("wsUrl");
                j32Var.d = jSONObject.optString("notInHistory", "1");
                j32Var.e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                j32Var.f = jSONObject.optString("slavePreload");
                j32Var.g = jSONObject.optJSONArray("hosts");
                return j32Var;
            } catch (JSONException unused) {
                if (h) {
                    Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                    return null;
                }
                return null;
            }
        }
        return (j32) invokeL.objValue;
    }

    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return b(i, this.b);
        }
        return (String) invokeI.objValue;
    }

    public String c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return b(i, this.c);
        }
        return (String) invokeI.objValue;
    }

    public final String b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str)) == null) {
            if (this.g != null && !TextUtils.isEmpty(str) && i >= 0 && i < this.g.length()) {
                Uri parse = Uri.parse(str);
                String optString = this.g.optString(i);
                if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                    return str.replace(parse.getHost(), optString);
                }
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }
}
