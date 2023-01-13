package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class z72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<Integer> b;
    public static final Map<String, Long> c;
    public static int d;
    public static final ej3<String, String> e;
    public static final ej3<kf4.a, String> f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements ej3<String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? str : (String) invokeL.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.ej3
        public /* bridge */ /* synthetic */ String a(String str) {
            String str2 = str;
            b(str2);
            return str2;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements ej3<kf4.a, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ej3
        /* renamed from: b */
        public String a(kf4.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar == null) {
                    return "";
                }
                return aVar.b();
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948312788, "Lcom/baidu/tieba/z72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948312788, "Lcom/baidu/tieba/z72;");
                return;
            }
        }
        a = tk1.a;
        b = Sets.newHashSet(0, 1010, 1011, 1012, 1020, 1015);
        c = new ConcurrentHashMap();
        d = 1800;
        e = new a();
        f = new b();
    }

    public static <T> T a(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, t)) == null) {
            if (a) {
                Log.i("PreDownloadUtils", "Recorded=" + c.size() + " # " + str + " => " + t);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Long l = c.get(str);
            if (l == null || System.currentTimeMillis() - l.longValue() > d * 1000) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return g(str, true);
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return g(str, false);
        }
        return invokeL.booleanValue;
    }

    public static List<String> h(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            return j(e, collection);
        }
        return (List) invokeL.objValue;
    }

    public static List<kf4.a> i(Collection<kf4.a> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, collection)) == null) {
            return j(f, collection);
        }
        return (List) invokeL.objValue;
    }

    public static boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            return b.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    public static boolean m(dd4 dd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, dd4Var)) == null) {
            if (dd4Var != null && l(dd4Var.a)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str2 != null) {
                str = str + str2;
            }
            return c(str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (str2 != null && str != null) {
                str = str + str2;
            }
            return e(str);
        }
        return invokeLL.booleanValue;
    }

    public static <SwanItemT> List<SwanItemT> j(@NonNull ej3<SwanItemT, String> ej3Var, Collection<SwanItemT> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ej3Var, collection)) == null) {
            return k(ej3Var, collection, false);
        }
        return (List) invokeLL.objValue;
    }

    public static boolean g(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            String str2 = "shouldDownloadItem app=" + str + " record=" + z + ZeusCrashHandler.NAME_SEPERATOR;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z) {
                c.put(str, Long.valueOf(System.currentTimeMillis()));
                z2 = true;
            } else {
                z2 = !c.containsKey(str);
            }
            Boolean valueOf = Boolean.valueOf(z2);
            a(str2 + " should", valueOf);
            if (!valueOf.booleanValue()) {
                Boolean valueOf2 = Boolean.valueOf(b(str));
                a(str2 + " AB", valueOf2);
                if (!valueOf2.booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static <SwanItemT> List<SwanItemT> k(@NonNull ej3<SwanItemT, String> ej3Var, Collection<SwanItemT> collection, boolean z) {
        InterceptResult invokeLLZ;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, ej3Var, collection, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (collection != null) {
                for (SwanItemT swanitemt : collection) {
                    if (swanitemt == null) {
                        a2 = "";
                    } else {
                        a2 = ej3Var.a(swanitemt);
                    }
                    if (g(a2, z)) {
                        arrayList.add(swanitemt);
                    }
                }
                a("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
            }
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    public static boolean n(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            Iterator<Map.Entry<String, Long>> it = c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Long> next = it.next();
                if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                    it.remove();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
