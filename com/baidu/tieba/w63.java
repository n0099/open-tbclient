package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tieba.gp2;
import com.baidu.tieba.s32;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w63 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "SwanAppPageForbidden";
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<JSONObject> b;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s32 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ q32 c;
        public final /* synthetic */ ju2 d;
        public final /* synthetic */ ForbiddenInfo e;

        public a(w63 w63Var, s32 s32Var, String str, q32 q32Var, ju2 ju2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w63Var, s32Var, str, q32Var, ju2Var, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s32Var;
            this.b = str;
            this.c = q32Var;
            this.d = ju2Var;
            this.e = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s32.b i = this.a.i(this.b);
                i.n(s32.g, s32.i);
                i.j(this.c);
                i.b();
                xa3.j(this.d, this.e.errCode);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final w63 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-363951977, "Lcom/baidu/tieba/w63$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-363951977, "Lcom/baidu/tieba/w63$b;");
                    return;
                }
            }
            a = new w63(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948222485, "Lcom/baidu/tieba/w63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948222485, "Lcom/baidu/tieba/w63;");
                return;
            }
        }
        e = tk1.a;
    }

    public w63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    public static w63 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (w63) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (e) {
                Log.d(d, "releaseData");
            }
            this.a = false;
            this.c = null;
            List<JSONObject> list = this.b;
            if (list != null) {
                list.clear();
                this.b = null;
            }
        }
    }

    public /* synthetic */ w63(a aVar) {
        this();
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return str + "_forbidden_ban_page";
        }
        return (String) invokeL.objValue;
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return str + "_forbidden_tips";
        }
        return (String) invokeL.objValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_key", str);
            z03 e2 = z03.e();
            b13 b13Var = new b13(131, bundle);
            b13Var.d();
            e2.h(b13Var);
        }
    }

    public boolean a(ju2 ju2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ju2Var)) == null) {
            if (ju2Var == null || !lw1.e(i43.K().q().Y())) {
                return false;
            }
            if (!this.a) {
                j();
            }
            List<JSONObject> list = this.b;
            if (list == null || list.isEmpty()) {
                return false;
            }
            if (e) {
                Log.d(d, "ForbiddenPage Check");
            }
            return g(ju2Var);
        }
        return invokeL.booleanValue;
    }

    public final boolean f(String[] strArr, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, strArr, list)) == null) {
            if (list == null || list.isEmpty() || strArr == null || strArr.length == 0) {
                return false;
            }
            List asList = Arrays.asList(strArr);
            if (asList.isEmpty()) {
                return false;
            }
            for (String str : list) {
                if (!asList.contains(str)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ju2 ju2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ju2Var)) == null) {
            if (ju2Var == null) {
                return false;
            }
            String str = ju2Var.a;
            String str2 = ju2Var.d;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                List<JSONObject> list = this.b;
                if (list == null) {
                    return false;
                }
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null && !jSONObject.isNull("type") && !jSONObject.isNull("path")) {
                        int optInt = jSONObject.optInt("type");
                        String optString = jSONObject.optString("path");
                        if (TextUtils.equals(str, optString) || TextUtils.equals(str2, optString)) {
                            if (optInt == 1) {
                                return true;
                            }
                            if (optInt != 2) {
                                if (optInt == 3 && !jSONObject.isNull("query")) {
                                    String optString2 = jSONObject.optString("query");
                                    if (TextUtils.isEmpty(ju2Var.b)) {
                                        return false;
                                    }
                                    List<String> c = bi3.c(optString2);
                                    String[] split = ju2Var.b.split("&");
                                    if (split == null || split.length == 0 || c == null || c.isEmpty()) {
                                        return false;
                                    }
                                    if (f(split, c)) {
                                        return true;
                                    }
                                }
                            } else if (jSONObject.isNull("query")) {
                                continue;
                            } else {
                                String optString3 = jSONObject.optString("query");
                                if (TextUtils.isEmpty(ju2Var.b)) {
                                    return false;
                                }
                                List<String> c2 = bi3.c(optString3);
                                String[] split2 = ju2Var.b.split("&");
                                if (split2 == null || split2.length == 0 || c2 == null || c2.isEmpty() || split2.length != c2.size()) {
                                    return false;
                                }
                                if (f(split2, c2)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean h(ju2 ju2Var) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ju2Var)) == null) {
            if (ju2Var == null) {
                return false;
            }
            String str = ju2Var.d;
            if (TextUtils.isEmpty(str) || (list = this.b) == null) {
                return false;
            }
            for (JSONObject jSONObject : list) {
                if (jSONObject != null && TextUtils.equals(str, jSONObject.optString("path"))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(String str, ju2 ju2Var) {
        s32 V;
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, ju2Var) != null) || ju2Var == null || (V = wp2.U().V()) == null || (V.m() instanceof q32)) {
            return;
        }
        if (h(ju2Var)) {
            b2 = ju2.c(ju2Var);
        } else {
            b2 = ju2.b(ju2Var);
        }
        if (e) {
            String str2 = d;
            Log.d(str2, "jump from " + str + " ; path = " + b2);
        }
        j43 q = i43.K().q();
        gp2.a W = q.W();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = q.getAppId();
        forbiddenInfo.appKey = q.O();
        forbiddenInfo.appTitle = W.K();
        forbiddenInfo.forbiddenReason = d();
        forbiddenInfo.forbiddenInformation = this.c;
        forbiddenInfo.launchSource = W.T();
        forbiddenInfo.launchPath = b2;
        forbiddenInfo.enableSlidingFlag = 0;
        l(forbiddenInfo);
        di3.e0(new a(this, V, str, q32.f3(String.valueOf(forbiddenInfo.errCode.a()), "type_path_forbidden", "", -1, forbiddenInfo, 0, 0), ju2Var, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            rc3 a2 = xc3.a();
            String O = i43.K().q().O();
            if (a2 == null) {
                return;
            }
            String string = a2.getString(c(O), null);
            if (e) {
                String str = d;
                Log.d(str, "readData, appKey = " + O + " ; tips = " + this.c + " ; page = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                this.b = null;
            } else {
                JSONArray e2 = jh3.e(string);
                if (e2 == null) {
                    return;
                }
                int length = e2.length();
                this.b = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = e2.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.b.add(optJSONObject);
                    }
                }
                this.c = a2.getString(e(O), null);
            }
            this.a = true;
        }
    }

    public final void l(ForbiddenInfo forbiddenInfo) {
        j43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, forbiddenInfo) != null) || (b0 = j43.b0()) == null) {
            return;
        }
        b0.q();
        SwanAppActivity w = b0.w();
        if (w == null) {
            return;
        }
        String i = od3.i(wp2.U().M(), b0.Y().G());
        cg3 cg3Var = new cg3();
        cg3Var.k(5L);
        cg3Var.i(48L);
        cg3Var.d("page forbidden");
        forbiddenInfo.errCode = cg3Var;
        forbiddenInfo.forbiddenDetail = w.getString(R.string.obfuscated_res_0x7f0f01a7, di3.D(), i, String.valueOf(cg3Var.a()));
    }

    public void n(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048588, this, jSONArray, str, str2) != null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String c = c(str2);
        String e2 = e(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            String jSONArray2 = jSONArray.toString();
            if (optJSONObject != null) {
                xc3.a().edit().putString(c, jSONArray2).putString(e2, str).apply();
                if (e) {
                    String str3 = d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        xc3.a().edit().remove(c).remove(e2).apply();
        if (e) {
            String str4 = d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }
}
