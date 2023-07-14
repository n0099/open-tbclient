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
/* loaded from: classes7.dex */
public class p92 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016800, "Lcom/baidu/tieba/p92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016800, "Lcom/baidu/tieba/p92;");
                return;
            }
        }
        h = fs1.a;
    }

    public p92() {
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

    public static p92 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            p92 p92Var = new p92();
            try {
                p92Var.a = jSONObject.getString("appKey");
                p92Var.b = jSONObject.getString(DeepLinkItem.DEEPLINK_APPURL_KEY) + "?swanJsVersion=" + al3.h(0) + "&appVersion=" + pp3.D();
                p92Var.c = jSONObject.getString("wsUrl");
                p92Var.d = jSONObject.optString("notInHistory", "1");
                p92Var.e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                p92Var.f = jSONObject.optString("slavePreload");
                p92Var.g = jSONObject.optJSONArray("hosts");
                return p92Var;
            } catch (JSONException unused) {
                if (h) {
                    Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                    return null;
                }
                return null;
            }
        }
        return (p92) invokeL.objValue;
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
