package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tieba.hb2;
import com.baidu.tieba.vw2;
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
public class le3 {
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
        public final /* synthetic */ hb2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fb2 c;
        public final /* synthetic */ y13 d;
        public final /* synthetic */ ForbiddenInfo e;

        public a(le3 le3Var, hb2 hb2Var, String str, fb2 fb2Var, y13 y13Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le3Var, hb2Var, str, fb2Var, y13Var, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hb2Var;
            this.b = str;
            this.c = fb2Var;
            this.d = y13Var;
            this.e = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hb2.b i = this.a.i(this.b);
                i.n(hb2.g, hb2.i);
                i.j(this.c);
                i.b();
                mi3.j(this.d, this.e.errCode);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final le3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-635467151, "Lcom/baidu/tieba/le3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-635467151, "Lcom/baidu/tieba/le3$b;");
                    return;
                }
            }
            a = new le3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939951, "Lcom/baidu/tieba/le3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939951, "Lcom/baidu/tieba/le3;");
                return;
            }
        }
        e = is1.a;
    }

    public le3() {
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

    public static le3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (le3) invokeV.objValue;
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

    public /* synthetic */ le3(a aVar) {
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
            o83 e2 = o83.e();
            q83 q83Var = new q83(131, bundle);
            q83Var.d();
            e2.h(q83Var);
        }
    }

    public boolean a(y13 y13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y13Var)) == null) {
            if (y13Var == null || !a42.e(xb3.K().q().Y())) {
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
            return g(y13Var);
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

    public boolean g(y13 y13Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y13Var)) == null) {
            if (y13Var == null) {
                return false;
            }
            String str = y13Var.a;
            String str2 = y13Var.d;
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
                                    if (TextUtils.isEmpty(y13Var.b)) {
                                        return false;
                                    }
                                    List<String> c = qp3.c(optString2);
                                    String[] split = y13Var.b.split("&");
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
                                if (TextUtils.isEmpty(y13Var.b)) {
                                    return false;
                                }
                                List<String> c2 = qp3.c(optString3);
                                String[] split2 = y13Var.b.split("&");
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

    public final boolean h(y13 y13Var) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y13Var)) == null) {
            if (y13Var == null) {
                return false;
            }
            String str = y13Var.d;
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

    public void i(String str, y13 y13Var) {
        hb2 U;
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, y13Var) != null) || y13Var == null || (U = lx2.T().U()) == null || (U.m() instanceof fb2)) {
            return;
        }
        if (h(y13Var)) {
            b2 = y13.c(y13Var);
        } else {
            b2 = y13.b(y13Var);
        }
        if (e) {
            String str2 = d;
            Log.d(str2, "jump from " + str + " ; path = " + b2);
        }
        yb3 q = xb3.K().q();
        vw2.a W = q.W();
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
        sp3.e0(new a(this, U, str, fb2.h3(String.valueOf(forbiddenInfo.errCode.a()), "type_path_forbidden", "", -1, forbiddenInfo, 0, 0), y13Var, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            gk3 a2 = mk3.a();
            String O = xb3.K().q().O();
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
                JSONArray e2 = yo3.e(string);
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
        yb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, forbiddenInfo) != null) || (b0 = yb3.b0()) == null) {
            return;
        }
        b0.q();
        SwanAppActivity w = b0.w();
        if (w == null) {
            return;
        }
        String i = dl3.i(lx2.T().getCoreVersion(), b0.Y().G());
        rn3 rn3Var = new rn3();
        rn3Var.k(5L);
        rn3Var.i(48L);
        rn3Var.d("page forbidden");
        forbiddenInfo.errCode = rn3Var;
        forbiddenInfo.forbiddenDetail = w.getString(R.string.obfuscated_res_0x7f0f01cf, sp3.D(), i, String.valueOf(rn3Var.a()));
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
                mk3.a().edit().putString(c, jSONArray2).putString(e2, str).apply();
                if (e) {
                    String str3 = d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        mk3.a().edit().remove(c).remove(e2).apply();
        if (e) {
            String str4 = d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }
}
