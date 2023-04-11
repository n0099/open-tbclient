package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.tieba.ce3;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pe3 extends u33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059115, "Lcom/baidu/tieba/pe3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059115, "Lcom/baidu/tieba/pe3;");
                return;
            }
        }
        f = eo1.a;
    }

    public pe3() {
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

    public static boolean e(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals("0", str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void f(String str, String str2, @Nullable JSONObject jSONObject) {
        String str3;
        String I1;
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, str, str2, jSONObject) != null) || !e(str2)) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        String str4 = StringUtil.NULL_STRING;
        if (str2 == null) {
            str2 = StringUtil.NULL_STRING;
        }
        try {
            jSONObject2.put("version", str2);
            if (str == null) {
                str3 = StringUtil.NULL_STRING;
            } else {
                str3 = str;
            }
            jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str3);
            u73 M = u73.M();
            if (M != null) {
                rs2.a Y = M.Y();
                if (Y == null) {
                    I1 = StringUtil.NULL_STRING;
                } else {
                    I1 = Y.I1();
                }
                jSONObject2.put("launchInfo", I1);
                SwanAppActivity w = M.w();
                rs2 rs2Var = null;
                if (w != null && (intent = w.getIntent()) != null) {
                    rs2Var = rs2.d1(intent);
                }
                if (rs2Var != null) {
                    str4 = rs2Var.I1();
                }
                jSONObject2.put("launchInfoIntent", str4);
            } else {
                jSONObject2.put("swanApp", StringUtil.NULL_STRING);
            }
            jSONObject2.put("stackTrace", ol3.y());
            if (jSONObject != null) {
                jSONObject2.put("reportExtInfo", jSONObject);
            }
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        p43 y = t73.K().y();
        if (y != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_swan_appid", str);
            bundle.putString("key_report_info", jSONObject2.toString());
            y.W(bundle, pe3.class);
        }
    }

    @Override // com.baidu.tieba.u33
    public void b(@NonNull Bundle bundle) {
        re2 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String str = "";
            String string = bundle.getString("key_swan_appid", "");
            String string2 = bundle.getString("key_report_info", "");
            if (!TextUtils.isEmpty(string2)) {
                str = string2;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                if (f) {
                    Log.e("VersionBusinessUbc", "execCall: ", e);
                }
                e.printStackTrace();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (!TextUtils.isEmpty(string) && (o = SwanAppDbControl.f(AppRuntime.getAppContext()).o(string)) != null) {
                try {
                    jSONObject.put("appDbInfo", o.a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (f) {
                Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
            }
            ce3.b bVar = new ce3.b(10002);
            bVar.i(jSONObject.toString());
            bVar.m();
            c();
        }
    }
}
