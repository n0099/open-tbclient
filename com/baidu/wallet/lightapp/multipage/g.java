package com.baidu.wallet.lightapp.multipage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f25757a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Map<String, String>> f25758b;

    /* renamed from: com.baidu.wallet.lightapp.multipage.g$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static g f25759a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549812090, "Lcom/baidu/wallet/lightapp/multipage/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549812090, "Lcom/baidu/wallet/lightapp/multipage/g$a;");
                    return;
                }
            }
            f25759a = new g(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(36326295, "Lcom/baidu/wallet/lightapp/multipage/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(36326295, "Lcom/baidu/wallet/lightapp/multipage/g;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f25757a = hashSet;
        hashSet.add("getItem");
        f25757a.add("setItem");
        f25757a.add("clear");
        f25757a.add("key");
        f25757a.add(CloudStabilityUBCUtils.KEY_LENGTH);
        f25757a.add("removeItem");
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? f25757a.contains(str) : invokeL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f25758b.remove(str);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            for (Map.Entry<String, Map<String, String>> entry : this.f25758b.entrySet()) {
                if (entry.getKey().startsWith(str)) {
                    this.f25758b.remove(entry.getKey());
                }
            }
        }
    }

    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f25758b.containsKey(str)) {
                return this.f25758b.get(str).size();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25758b = new ConcurrentHashMap();
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f25759a : (g) invokeV.objValue;
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.f25758b.containsKey(str2) && this.f25758b.get(str2).containsKey(str)) {
            this.f25758b.get(str2).remove(str);
        }
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f25758b.containsKey(str2) && this.f25758b.get(str2).containsKey(str)) {
                return this.f25758b.get(str2).get(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            for (String str3 : this.f25758b.keySet()) {
                if (!TextUtils.isEmpty(str3) && str3.startsWith(str)) {
                    concurrentHashMap2.put(str3, this.f25758b.get(str3));
                    concurrentHashMap.put(str2 + str3.substring(str3.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) + 1, str3.length()), this.f25758b.get(str3));
                }
            }
            for (String str4 : concurrentHashMap2.keySet()) {
                this.f25758b.remove(str4);
            }
            Iterator it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                String str5 = (String) it.next();
                if (this.f25758b.containsKey(str5)) {
                    Map map = (Map) concurrentHashMap.get(str5);
                    Iterator it2 = map.keySet().iterator();
                    while (it.hasNext()) {
                        String str6 = (String) it2.next();
                        if (!this.f25758b.get(str5).containsKey(str6)) {
                            this.f25758b.get(str5).put(str6, map.get(str6));
                        }
                    }
                } else {
                    this.f25758b.put(str5, concurrentHashMap.get(str5));
                }
            }
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            if (this.f25758b.containsKey(str3)) {
                this.f25758b.get(str3).put(str, str2);
                return;
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(str, str2);
            this.f25758b.put(str3, concurrentHashMap);
        }
    }

    public String c(String str, String str2) {
        int i2;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (Exception unused) {
                i2 = -1;
            }
            if (this.f25758b.containsKey(str2)) {
                Map<String, String> map = this.f25758b.get(str2);
                String[] strArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
                if (i2 < 0 || i2 >= strArr.length) {
                    return null;
                }
                return strArr[i2];
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(String str, String[] strArr) {
        InterceptResult invokeLL;
        char c2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr)) == null) {
            b();
            switch (str.hashCode()) {
                case -1106363674:
                    if (str.equals(CloudStabilityUBCUtils.KEY_LENGTH)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -354615841:
                    if (str.equals("clear_by_tab")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -75439223:
                    if (str.equals("getItem")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 106079:
                    if (str.equals("key")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1098253751:
                    if (str.equals("removeItem")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1280882667:
                    if (str.equals(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1984670357:
                    if (str.equals("setItem")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    if (strArr.length >= 3) {
                        str2 = a(strArr[0], strArr[2]);
                        break;
                    }
                    str2 = null;
                    break;
                case 1:
                    if (strArr.length >= 3) {
                        a(strArr[0], strArr[1], strArr[2]);
                    }
                    str2 = null;
                    break;
                case 2:
                    if (strArr.length >= 3) {
                        b(strArr[0], strArr[2]);
                    }
                    str2 = null;
                    break;
                case 3:
                    if (strArr.length >= 3) {
                        b(strArr[2]);
                    }
                    str2 = null;
                    break;
                case 4:
                    if (strArr.length >= 3) {
                        str2 = c(strArr[0], strArr[2]);
                        break;
                    }
                    str2 = null;
                    break;
                case 5:
                    if (strArr.length >= 2) {
                        d(strArr[0], strArr[1]);
                    }
                    str2 = null;
                    break;
                case 6:
                    if (strArr.length >= 1) {
                        c(strArr[0]);
                    }
                    str2 = null;
                    break;
                case 7:
                    if (strArr.length >= 3) {
                        str2 = "" + d(strArr[2]);
                        break;
                    }
                    str2 = null;
                    break;
                default:
                    str2 = null;
                    break;
            }
            b();
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
