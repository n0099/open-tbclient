package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tts.client.SpeechSynthesizer;
import com.facebook.common.internal.Sets;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import okhttp3.CertificatePinner;
/* loaded from: classes8.dex */
public final class yb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948324351, "Lcom/baidu/tieba/yb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948324351, "Lcom/baidu/tieba/yb3;");
                return;
            }
        }
        a = rr1.a;
        b = Sets.newHashSet("https", SpeechSynthesizer.REQUEST_PROTOCOL_WSS);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a && !g73.A()) {
                Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
                return true;
            } else if (TextUtils.isEmpty(str)) {
                h82.i("WebSafeCheckers", "action is not in white list: action=" + str);
                return false;
            } else {
                hb3 M = hb3.M();
                if (M == null) {
                    h82.o("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> b2 = M.l0().b();
                if (b2 != null && b2.contains(str)) {
                    if (a) {
                        Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + b2);
                    }
                    return true;
                }
                h82.i("WebSafeCheckers", "action is not in adLanding white list: action=" + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (a && !g73.A()) {
                Log.w("WebSafeCheckers", "checkWebAction: Debug下鉴权未开启");
                return true;
            } else if (TextUtils.isEmpty(str)) {
                h82.o("WebSafeCheckers", "action is not in white list: action=" + str);
                return false;
            } else {
                hb3 M = hb3.M();
                if (M == null) {
                    h82.o("WebSafeCheckers", "get swanApp Null " + str);
                    return false;
                }
                List<String> d = M.l0().d(false);
                if (d != null && d.contains(str)) {
                    if (a) {
                        Log.d("WebSafeCheckers", "Action in white list: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + d);
                    }
                    return true;
                }
                h82.b("WebSafeCheckers", "Action not in white list: action=" + str + ", whitelist=", d);
                StringBuilder sb = new StringBuilder();
                sb.append("action is not in white list: action=");
                sb.append(str);
                h82.i("WebSafeCheckers", sb.toString());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() != 0) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (TextUtils.equals(str, str2)) {
                            return true;
                        }
                        if (str2.startsWith(CertificatePinner.Pin.WILDCARD) && str.endsWith(str2.substring(2))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        boolean z;
        String host;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.i("WebSafeCheckers", "requestName : " + str);
                    Log.i("WebSafeCheckers", "requestUrl : " + str2);
                }
                boolean z2 = !g73.w();
                boolean z3 = false;
                if (z2) {
                    if (a) {
                        Log.d("WebSafeCheckers", "debug包serverDomains鉴权关闭： " + z2);
                    }
                    return 0;
                }
                boolean i = i();
                if (!i) {
                    if (a) {
                        Log.d("WebSafeCheckers", "开发包serverDomains鉴权关闭： " + i);
                    }
                    return 0;
                } else if (!d(str2)) {
                    return 2;
                } else {
                    boolean r = ou2.g0().r();
                    if (!r) {
                        if (a) {
                            Log.d("WebSafeCheckers", "AB实验serverDomains鉴权关闭： " + r);
                        }
                        return 0;
                    }
                    hb3 M = hb3.M();
                    if (M == null) {
                        return 1;
                    }
                    String str4 = M.b;
                    if (TextUtils.isEmpty(str4)) {
                        return 1;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        return !e73.c(str, str2, f73.h(str3)) ? 1 : 0;
                    }
                    if (!new File(zb3.i(str4)).exists()) {
                        if (a) {
                            Log.w("WebSafeCheckers", "服务器域名配置文件未下发放行");
                        }
                        return 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        host = new URI(str2).getHost();
                        list = M.l0().c(hb3.g0(), str, false).b;
                        z = b(host, list);
                    } catch (URISyntaxException e) {
                        e = e;
                    }
                    try {
                        h82.b("WebSafeCheckers", "serverDomain: " + host + ", ServerDomains: ", list);
                        StringBuilder sb = new StringBuilder();
                        sb.append("domain: ");
                        sb.append(host);
                        h82.i("WebSafeCheckers", sb.toString());
                    } catch (URISyntaxException e2) {
                        e = e2;
                        z3 = z;
                        if (a) {
                            Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                        }
                        z = z3;
                        if (!z) {
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (a) {
                        }
                        return !z;
                    }
                    if (!z) {
                        h82.i("WebSafeCheckers", "domain is not in white list");
                    }
                    long currentTimeMillis22 = System.currentTimeMillis();
                    if (a) {
                        Log.d("WebSafeCheckers", "serverDomain: cost time = " + (currentTimeMillis22 - currentTimeMillis) + "ms");
                        if (z != 0) {
                            Log.d("WebSafeCheckers", "serverDomain in white list");
                        } else {
                            Log.d("WebSafeCheckers", "serverDomain not in white list");
                        }
                    }
                    return !z;
                }
            }
            if (a) {
                Log.d("WebSafeCheckers", "server domains: requestName or requestUrl is empty");
            }
            return 1;
        }
        return invokeLLL.intValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            for (String str2 : b) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            if (g73.o()) {
                return true;
            }
            boolean p = ou2.g0().p();
            if (a) {
                Log.d("WebSafeCheckers", "abTestHttpsProtocolSwitch=" + p);
            }
            if (!p && str.startsWith("http")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("weixin://wap/pay")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("alipays://platformapi/startapp")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("weixin://wap/pay") && !lowerCase.startsWith("alipays://platformapi/startapp")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(String str) {
        InterceptResult invokeL;
        long j;
        boolean z;
        String str2;
        String host;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            hb3 b0 = hb3.b0();
            boolean z2 = false;
            if (b0 == null) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            if (!g73.A()) {
                if (a) {
                    Log.w("WebSafeCheckers", "checkWebHost: Debug下鉴权未开启");
                }
                return true;
            }
            boolean z3 = ou2.g0().z();
            if (!z3) {
                if (a) {
                    Log.w("WebSafeCheckers", "ABTest : webDomains switch " + z3);
                }
                return true;
            } else if (!i()) {
                if (a) {
                    Log.d("WebSafeCheckers", "checkWebDomains: 线下环境开发者授权跳过域名校验");
                }
                return true;
            } else {
                String g0 = hb3.g0();
                if (!zb3.n(g0)) {
                    return true;
                }
                List<String> e = b0.l0().e(g0, false);
                if (lowerCase.startsWith("weixin://wap/pay") && e.contains("wx.tenpay.com")) {
                    h82.k("WebSafeCheckers", "url is weixin pay, Domain in white list url: " + str + " name: " + b0.Z());
                    ai3.K("wechatH5", "intoPayment", 0);
                    ai3.G("wechatH5", str, e);
                    return true;
                } else if (lowerCase.startsWith("alipays://platformapi/startapp") && (e.contains("*.alipay.com") || e.contains("*.alipayobjects.com"))) {
                    h82.k("WebSafeCheckers", "url is ali pay, Domain in white list url: " + str + " whiteDomains: " + e + " name: " + b0.Z());
                    ai3.K("alipayH5", "intoPayment", 0);
                    ai3.G("alipayH5", str, e);
                    return true;
                } else {
                    if (a) {
                        j = System.nanoTime();
                    } else {
                        j = 0;
                    }
                    if (TextUtils.isEmpty(str)) {
                        if (a) {
                            Log.w("WebSafeCheckers", "checkWebDomain: url is empty");
                        }
                        return false;
                    }
                    try {
                        host = new URL(str).getHost();
                        if (!TextUtils.isEmpty(host) && e != null) {
                            for (String str3 : e) {
                                if (str3 != null) {
                                    if (str3.startsWith(CertificatePinner.Pin.WILDCARD)) {
                                        if (host.endsWith(str3.substring(2))) {
                                            z = true;
                                            break;
                                        }
                                    } else if (TextUtils.equals(str3, host)) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z = false;
                    } catch (MalformedURLException e2) {
                        e = e2;
                    }
                    try {
                        h82.b("WebSafeCheckers", "domain: ", host, ", domains: ", e);
                        h82.i("WebSafeCheckers", "domain: " + host);
                    } catch (MalformedURLException e3) {
                        e = e3;
                        z2 = z;
                        if (a) {
                            Log.e("WebSafeCheckers", Log.getStackTraceString(e));
                        }
                        z = z2;
                        if (!z) {
                        }
                        if (a) {
                        }
                        return z;
                    }
                    if (!z) {
                        h82.i("WebSafeCheckers", "domain is not in white list：" + e);
                    }
                    if (a) {
                        long nanoTime = System.nanoTime();
                        if (z) {
                            str2 = "Domain in white list";
                        } else {
                            str2 = "Domain not in white list";
                        }
                        Log.d("WebSafeCheckers", str2);
                        Log.d("WebSafeCheckers", "checkWebDomain耗时(ms): " + (((float) (nanoTime - j)) / 1000000.0f));
                    }
                    return z;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (gb3.K().k() != 0 || !SwanAppConfigData.j.d()) {
                return true;
            }
            if (a) {
                Log.d("WebSafeCheckers", "授权跳过url校验");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (hb3.M() == null) {
                return false;
            }
            return m13.g().j(gb3.K().q().W().f0());
        }
        return invokeV.booleanValue;
    }
}
