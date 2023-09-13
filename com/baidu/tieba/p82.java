package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
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
public class p82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public JSONArray c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015839, "Lcom/baidu/tieba/p82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015839, "Lcom/baidu/tieba/p82;");
                return;
            }
        }
        i = rr1.a;
    }

    public p82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static p82 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            p82 p82Var = new p82();
            try {
                p82Var.c = jSONObject.getJSONArray("host");
                p82Var.b = jSONObject.getString("appKey");
                p82Var.a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                p82Var.d = jSONObject.getString("serverPort");
                p82Var.f = jSONObject.getString("wsServerPort");
                Uri.decode(jSONObject.optString("url"));
                p82Var.g = jSONObject.optString("notInHistory", "1");
                p82Var.h = jSONObject.optLong("coreVersion");
            } catch (JSONException unused) {
                if (i) {
                    Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
                }
            }
            return p82Var;
        }
        return (p82) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            JSONArray jSONArray = this.c;
            if (jSONArray == null) {
                return "";
            }
            return jSONArray.optString(i2);
        }
        return (String) invokeI.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return "http://" + str + ":" + this.d + "/app.zip";
        }
        return (String) invokeL.objValue;
    }
}
