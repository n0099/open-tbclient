package com.baidu.wallet.newbindcard.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f62424a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f62425b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f62426c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f62427d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f62428e = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.newbindcard.c.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.newbindcard.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1848a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f62429a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1490459213, "Lcom/baidu/wallet/newbindcard/c/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1490459213, "Lcom/baidu/wallet/newbindcard/c/a$a;");
                    return;
                }
            }
            f62429a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1963559920, "Lcom/baidu/wallet/newbindcard/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1963559920, "Lcom/baidu/wallet/newbindcard/c/a;");
        }
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(String str, Map<String, Object> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, map, strArr) == null) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(g());
            if (strArr != null) {
                for (String str2 : strArr) {
                    arrayList.add(str2);
                }
            }
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
            StatisticManager.onEventEndWithValues(str, arrayList, map);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f62426c : (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f62427d : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f62428e : (String) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            f();
            f62424a = null;
            f62425b = null;
            f62426c = null;
            f62427d = null;
            f62428e = null;
        }
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? C1848a.f62429a : (a) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            f();
            if (!TextUtils.isEmpty(f62424a)) {
                return f62424a;
            }
            String h2 = h();
            f62424a = h2;
            return h2;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            f();
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
    }

    public a() {
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

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            f62426c = str;
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f62427d = str;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            f62428e = str;
        }
    }

    public static void a(String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, strArr) == null) {
            f();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(g());
            if (strArr != null) {
                for (String str2 : strArr) {
                    arrayList.add(str2);
                }
            }
            StatisticManager.onEventEndWithValues(str, arrayList);
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f62425b : (String) invokeV.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            f62425b = str;
        }
    }
}
