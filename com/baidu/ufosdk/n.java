package com.baidu.ufosdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.hybrid.api.IBridgeApi;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, HashMap<String, Method>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-516310606, "Lcom/baidu/ufosdk/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-516310606, "Lcom/baidu/ufosdk/n;");
                return;
            }
        }
        a = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(WebView webView, String str) {
        InterceptResult invokeLL;
        boolean z;
        p pVar;
        o oVar;
        String str2;
        boolean z2;
        HashMap<String, Method> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, webView, str)) == null) {
            if (webView == null) {
                return "client delegate null";
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("ufobridge://") && !str.contains("#")) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return "url not legitimate";
            }
            try {
                pVar = new p(Uri.parse(str));
                try {
                    oVar = new o(webView, pVar.e);
                } catch (Exception unused) {
                    oVar = null;
                    str2 = "";
                    if (oVar != null) {
                        if (TextUtils.isEmpty(pVar.b)) {
                        }
                        z2 = false;
                        if (z2) {
                            hashMap = a.get(pVar.b);
                            if (hashMap == null) {
                            }
                            str2 = pVar.b + "." + pVar.c + " not find";
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            return str2;
                        }
                    }
                    oVar = new o(webView, "");
                    str2 = "apiName unRegister";
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    return str2;
                }
            } catch (Exception unused2) {
                pVar = null;
            }
            str2 = "";
            if (oVar != null && pVar != null) {
                if (TextUtils.isEmpty(pVar.b) && !TextUtils.isEmpty(pVar.c) && !TextUtils.isEmpty(pVar.d)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && a.containsKey(pVar.b)) {
                    hashMap = a.get(pVar.b);
                    if (hashMap == null && hashMap.size() != 0 && hashMap.containsKey(pVar.c)) {
                        Method method = hashMap.get(pVar.c);
                        if (method != null) {
                            try {
                                method.invoke(null, webView.getContext(), pVar, oVar);
                            } catch (Throwable th) {
                                str2 = th.toString();
                            }
                        }
                    } else {
                        str2 = pVar.b + "." + pVar.c + " not find";
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        oVar.a("10101", str2);
                    }
                    return str2;
                }
            }
            oVar = new o(webView, "");
            str2 = "apiName unRegister";
            if (!TextUtils.isEmpty(str2)) {
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Method> a(Class cls) {
        InterceptResult invokeL;
        Method[] declaredMethods;
        String name;
        Class<?>[] parameterTypes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            HashMap<String, Method> hashMap = new HashMap<>();
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getModifiers() == 9 && (name = method.getName()) != null && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 3 && parameterTypes[0] == Context.class && parameterTypes[1] == p.class && parameterTypes[2] == o.class) {
                    hashMap.put(name, method);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void a(String str, Class<? extends IBridgeApi> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, cls) == null) {
            try {
                if (str.startsWith(IBridgeApi.UFO_API_PREFIX)) {
                    a.put(str, a(cls));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
