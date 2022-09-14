package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class yg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yg1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public yg1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static yg1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (yg1.class) {
                    if (b == null) {
                        b = new yg1(context);
                    }
                }
            }
            return b;
        }
        return (yg1) invokeL.objValue;
    }

    public String b(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String d = new sh1(this.a, null).d(jSONObject, j);
                        if (!TextUtils.isEmpty(d)) {
                            return d;
                        }
                    }
                } catch (Throwable th) {
                    ii1.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public final void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("1");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    wg1.f(this.a).C("k_retry_code_cm", optJSONArray.toString());
                } else {
                    wg1.f(this.a).C("k_retry_code_cm", "");
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("2");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    wg1.f(this.a).C("k_retry_code_cu", optJSONArray2.toString());
                } else {
                    wg1.f(this.a).C("k_retry_code_cu", "");
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("3");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    wg1.f(this.a).C("k_retry_code_ct", optJSONArray3.toString());
                    return;
                } else {
                    wg1.f(this.a).C("k_retry_code_ct", "");
                    return;
                }
            }
            wg1.f(this.a).C("k_retry_code_cm", "");
            wg1.f(this.a).C("k_retry_code_cu", "");
            wg1.f(this.a).C("k_retry_code_ct", "");
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                try {
                    if (f()) {
                        return true;
                    }
                    sh1 sh1Var = new sh1(this.a, null);
                    String b2 = sh1Var.b();
                    if (TextUtils.isEmpty(b2)) {
                        for (int i = 0; i < 3; i++) {
                            b2 = sh1Var.b();
                            if (!TextUtils.isEmpty(b2)) {
                                break;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(b2)) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    int optInt = jSONObject.optInt("0", -1);
                    if (optInt == 2) {
                        wg1.f(this.a).S(false);
                    } else {
                        wg1.f(this.a).S(true);
                    }
                    if (optInt == 1 || optInt == 3) {
                        return true;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("1");
                    if (optJSONObject == null) {
                        return false;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("yd_config");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("app_id");
                        String optString2 = optJSONObject2.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            fh1.k(FunAdSdk.PLATFORM_CM, optString, optString2);
                        }
                        int optInt2 = optJSONObject2.optInt("status", -1);
                        if (optInt2 == 1) {
                            wg1.f(this.a).l(true);
                        } else if (optInt2 == 2) {
                            wg1.f(this.a).l(false);
                        }
                        wg1.f(this.a).Y(optJSONObject2.toString());
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
                    if (optJSONObject3 != null) {
                        String optString3 = optJSONObject3.optString("app_id");
                        String optString4 = optJSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            fh1.k(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                        }
                        int optInt3 = optJSONObject3.optInt("status", -1);
                        if (optInt3 == 1) {
                            wg1.f(this.a).w(true);
                        } else if (optInt3 == 2) {
                            wg1.f(this.a).w(false);
                        }
                        wg1.f(this.a).s(optJSONObject3.toString());
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
                    if (optJSONObject4 != null) {
                        String optString5 = optJSONObject4.optString("app_id");
                        String optString6 = optJSONObject4.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            fh1.k("cu", optString5, optString6);
                        }
                        int optInt4 = optJSONObject4.optInt("status", -1);
                        if (optInt4 == 1) {
                            wg1.f(this.a).D(true);
                        } else if (optInt4 == 2) {
                            wg1.f(this.a).D(false);
                        }
                        wg1.f(this.a).M(optJSONObject4.toString());
                    }
                    JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
                    if (optJSONObject5 != null) {
                        String optString7 = optJSONObject5.optString(GameGuideConfigInfo.KEY_APP_KEY, "");
                        String optString8 = optJSONObject5.optString("secret_key", "");
                        if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            vg1.b = optString7;
                            vg1.c = optString8;
                            wg1.f(this.a).H(optString7, optString8);
                        }
                    }
                    wg1.f(this.a).Q(optJSONObject.optString("encrypt_key", ""));
                    JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
                    if (optJSONObject6 != null) {
                        wg1.f(this.a).I("1".equals(optJSONObject6.optString("1", "1")));
                        wg1.f(this.a).y(optJSONObject6.optInt("2"));
                        wg1.f(this.a).N("1".equals(optJSONObject6.optString("3", "0")));
                        c(optJSONObject6.optJSONObject("4"));
                    }
                    wg1.f(this.a).j(jSONObject.optLong("3", 300L) * 1000);
                    wg1.f(this.a).P(System.currentTimeMillis());
                    return true;
                } catch (Throwable th) {
                    ii1.d(th);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public String e(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String i = new sh1(this.a, null).i(jSONObject, j);
                        if (!TextUtils.isEmpty(i)) {
                            return i;
                        }
                    }
                } catch (Throwable th) {
                    ii1.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (System.currentTimeMillis() - wg1.f(this.a).i0() > wg1.f(this.a).E()) {
                    return false;
                }
                String o0 = wg1.f(this.a).o0();
                String O = wg1.f(this.a).O();
                String f0 = wg1.f(this.a).f0();
                if (TextUtils.isEmpty(o0) && TextUtils.isEmpty(O) && TextUtils.isEmpty(f0)) {
                    return false;
                }
                if (!TextUtils.isEmpty(o0)) {
                    JSONObject jSONObject = new JSONObject(o0);
                    String string = jSONObject.getString("app_id");
                    String string2 = jSONObject.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        fh1.k(FunAdSdk.PLATFORM_CM, string, string2);
                    }
                }
                if (!TextUtils.isEmpty(O)) {
                    JSONObject jSONObject2 = new JSONObject(O);
                    String string3 = jSONObject2.getString("app_id");
                    String string4 = jSONObject2.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        fh1.k(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                    }
                }
                if (TextUtils.isEmpty(f0)) {
                    return true;
                }
                JSONObject jSONObject3 = new JSONObject(f0);
                String optString = jSONObject3.optString("app_id");
                String optString2 = jSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return true;
                }
                fh1.k("cu", optString, optString2);
                return true;
            } catch (Throwable th) {
                ii1.d(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
