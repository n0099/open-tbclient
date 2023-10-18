package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Autowired
/* loaded from: classes8.dex */
public class uk4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IRemoteUBCService a;
    public static final Map<String, Integer> b;
    public static final Set<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948213867, "Lcom/baidu/tieba/uk4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948213867, "Lcom/baidu/tieba/uk4;");
                return;
            }
        }
        b = new HashMap();
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER);
        c.add("671");
        b.put(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, -1);
        b.put("671", -1);
    }

    public uk4() {
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

    public static Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    @Inject
    public static bl4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return wx2.a();
        }
        return (bl4) invokeV.objValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            Integer num = b.get(str);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == -1) {
                intValue = jl4.e().getInt(str2, 0);
            } else {
                intValue = num.intValue();
            }
            int i = intValue + 1;
            if (i >= Integer.MAX_VALUE || i < 0) {
                return 0;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!c.contains(str)) {
                return str2;
            }
            bl4 h = h();
            if (h != null && h.p()) {
                synchronized (uk4.class) {
                    String str3 = "ubc_counter" + str;
                    int a2 = a(str, str3);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put("counter", a2);
                        str2 = jSONObject.toString();
                        jl4.e().putInt(str3, a2);
                        b.put(str, Integer.valueOf(a2));
                    } catch (JSONException unused) {
                    }
                }
                return str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject)) == null) {
            if (!c.contains(str)) {
                return jSONObject;
            }
            bl4 h = h();
            if (h != null && h.p()) {
                synchronized (uk4.class) {
                    String str2 = "ubc_counter" + str;
                    int a2 = a(str, str2);
                    try {
                        jSONObject.put("counter", a2);
                        jl4.e().putInt(str2, a2);
                        b.put(str, Integer.valueOf(a2));
                    } catch (JSONException unused) {
                    }
                }
                return jSONObject;
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static Flow d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return e(str, "", 0);
        }
        return (Flow) invokeL.objValue;
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            j(str, "", 0);
        }
    }

    public static Flow e(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, str, str2, i)) == null) {
            return fl4.b().a(str, str2, i);
        }
        return (Flow) invokeLLI.objValue;
    }

    public static void j(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i) == null) {
            if (ze1.g()) {
                str2 = b(str, str2);
            }
            if (ol4.a()) {
                fl4.b().e(str, str2, i);
            }
        }
    }

    public static void l(String str, Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65549, null, str, map, i) == null) && ol4.a()) {
            fl4.b().f(str, map, i);
        }
    }

    public static void n(String str, JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, str, jSONObject, i) == null) {
            if (ze1.g()) {
                c(str, jSONObject);
            }
            if (ol4.a()) {
                fl4.b().g(str, jSONObject, i);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static IRemoteUBCService g() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (a == null) {
                synchronized (uk4.class) {
                    if (a == null) {
                        IBinder f = IPCServiceManager.f("open_log", true);
                        if (f != null) {
                            if (f != null) {
                                a = IRemoteUBCService.Stub.asInterface(f);
                            }
                        } else {
                            throw new RemoteException("Ceres get remote service empty !");
                        }
                    }
                }
            }
            return a;
        }
        return (IRemoteUBCService) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            j(str, str2, 0);
        }
    }

    public static void k(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            l(str, map, 0);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, jSONObject) == null) {
            n(str, jSONObject, 0);
        }
    }
}
