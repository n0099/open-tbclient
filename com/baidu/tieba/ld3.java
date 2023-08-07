package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tieba.ha2;
import com.baidu.tieba.vv2;
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
public class ld3 {
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
        public final /* synthetic */ ha2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fa2 c;
        public final /* synthetic */ y03 d;
        public final /* synthetic */ ForbiddenInfo e;

        public a(ld3 ld3Var, ha2 ha2Var, String str, fa2 fa2Var, y03 y03Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld3Var, ha2Var, str, fa2Var, y03Var, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha2Var;
            this.b = str;
            this.c = fa2Var;
            this.d = y03Var;
            this.e = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ha2.b i = this.a.i(this.b);
                i.n(ha2.g, ha2.i);
                i.j(this.c);
                i.b();
                mh3.j(this.d, this.e.errCode);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ld3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-636390672, "Lcom/baidu/tieba/ld3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-636390672, "Lcom/baidu/tieba/ld3$b;");
                    return;
                }
            }
            a = new ld3(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947938990, "Lcom/baidu/tieba/ld3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947938990, "Lcom/baidu/tieba/ld3;");
                return;
            }
        }
        e = ir1.a;
    }

    public ld3() {
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

    public static ld3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (ld3) invokeV.objValue;
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

    public /* synthetic */ ld3(a aVar) {
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
            o73 e2 = o73.e();
            q73 q73Var = new q73(131, bundle);
            q73Var.d();
            e2.h(q73Var);
        }
    }

    public boolean a(y03 y03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y03Var)) == null) {
            if (y03Var == null || !a32.e(xa3.K().q().Y())) {
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
            return g(y03Var);
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

    public boolean g(y03 y03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y03Var)) == null) {
            if (y03Var == null) {
                return false;
            }
            String str = y03Var.a;
            String str2 = y03Var.d;
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
                                    if (TextUtils.isEmpty(y03Var.b)) {
                                        return false;
                                    }
                                    List<String> c = qo3.c(optString2);
                                    String[] split = y03Var.b.split("&");
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
                                if (TextUtils.isEmpty(y03Var.b)) {
                                    return false;
                                }
                                List<String> c2 = qo3.c(optString3);
                                String[] split2 = y03Var.b.split("&");
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

    public final boolean h(y03 y03Var) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y03Var)) == null) {
            if (y03Var == null) {
                return false;
            }
            String str = y03Var.d;
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

    public void i(String str, y03 y03Var) {
        ha2 U;
        String b2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, str, y03Var) != null) || y03Var == null || (U = lw2.T().U()) == null || (U.m() instanceof fa2)) {
            return;
        }
        if (h(y03Var)) {
            b2 = y03.c(y03Var);
        } else {
            b2 = y03.b(y03Var);
        }
        if (e) {
            String str2 = d;
            Log.d(str2, "jump from " + str + " ; path = " + b2);
        }
        ya3 q = xa3.K().q();
        vv2.a W = q.W();
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
        so3.e0(new a(this, U, str, fa2.h3(String.valueOf(forbiddenInfo.errCode.a()), "type_path_forbidden", "", -1, forbiddenInfo, 0, 0), y03Var, forbiddenInfo));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            gj3 a2 = mj3.a();
            String O = xa3.K().q().O();
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
                JSONArray e2 = yn3.e(string);
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
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, forbiddenInfo) != null) || (b0 = ya3.b0()) == null) {
            return;
        }
        b0.q();
        SwanAppActivity w = b0.w();
        if (w == null) {
            return;
        }
        String i = dk3.i(lw2.T().getCoreVersion(), b0.Y().G());
        rm3 rm3Var = new rm3();
        rm3Var.k(5L);
        rm3Var.i(48L);
        rm3Var.d("page forbidden");
        forbiddenInfo.errCode = rm3Var;
        forbiddenInfo.forbiddenDetail = w.getString(R.string.obfuscated_res_0x7f0f01d1, so3.D(), i, String.valueOf(rm3Var.a()));
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
                mj3.a().edit().putString(c, jSONArray2).putString(e2, str).apply();
                if (e) {
                    String str3 = d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        mj3.a().edit().remove(c).remove(e2).apply();
        if (e) {
            String str4 = d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }
}
