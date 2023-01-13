package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tbclient.App;
/* loaded from: classes6.dex */
public class vm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<ut4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ut4 ut4Var, ut4 ut4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ut4Var, ut4Var2)) == null) {
                if (ut4Var.e() && ut4Var2.e()) {
                    return ut4Var.j() - ut4Var2.j();
                }
                int i = -1;
                if (!ut4Var.e() && !ut4Var2.e()) {
                    if (ut4Var.u() == null) {
                        g = -1;
                    } else {
                        g = vm8.g(ut4Var.u());
                    }
                    if (ut4Var2.u() != null) {
                        i = vm8.g(ut4Var2.u());
                    }
                    return g - i;
                } else if (ut4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<yn> a(List<yn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo u;
        AdvertAppInfo u2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (uq7.e(list)) {
                return hashSet;
            }
            Set<yn> a2 = cp8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (yn ynVar : list) {
                if (ynVar != null) {
                    for (yn ynVar2 : a2) {
                        if ((ynVar instanceof ut4) && (u2 = ((ut4) ynVar).u()) != null && ynVar2.hashCode() == u2.hashCode()) {
                            u2.i = ((AdvertAppInfo) ynVar2).i;
                        }
                    }
                    if ((ynVar instanceof ut4) && (u = ((ut4) ynVar).u()) != null && u.i == null) {
                        ks4 ks4Var = new ks4();
                        u.i = ks4Var;
                        ks4Var.a = str;
                        ks4Var.b = i;
                        ks4Var.g = u.g;
                        ks4Var.h = false;
                        hashSet.add(u);
                    }
                }
            }
            a2.addAll(hashSet);
            cp8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<ut4> i(List<ut4> list, List<yn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (uq7.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ut4 ut4Var = (ut4) uq7.d(list, i4);
                if (ut4Var != null && ut4Var.u() != null) {
                    int i5 = uq7.i(list2);
                    int g = g(ut4Var.u()) - 1;
                    if (g < 0) {
                        n(ut4Var.u());
                    } else {
                        if (ut4Var.e()) {
                            i2 = ut4Var.j();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(ut4Var.u());
                        } else {
                            ut4Var.setPosition(i2);
                            uq7.b(list2, ut4Var, i2);
                            arrayList.add(ut4Var);
                        }
                    }
                }
            }
            while (i < uq7.i(list2)) {
                yn ynVar = list2.get(i);
                if (ynVar instanceof ut4) {
                    i3++;
                } else if (ynVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) ynVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (uq7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = uq7.i(list) - 1; i3 >= 0 && !(uq7.d(list, i3) instanceof ut4); i3--) {
                if (uq7.d(list, i3) instanceof jv4) {
                    int i4 = ((jv4) uq7.d(list, i3)).position;
                    if (i4 != i2) {
                        i++;
                        i2 = i4;
                    }
                } else {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static void c(List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || uq7.e(list)) {
            return;
        }
        Iterator<yn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ut4) {
                it.remove();
            }
        }
    }

    public static String f(@NonNull AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, advertAppInfo)) == null) {
            return "#Nad=" + advertAppInfo.g;
        }
        return (String) invokeL.objValue;
    }

    public static int g(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, advertAppInfo)) == null) {
            if (advertAppInfo == null) {
                return 0;
            }
            if (TextUtils.isEmpty(advertAppInfo.f)) {
                return -1;
            }
            return yg.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static boolean j(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("#Nad=");
        }
        return invokeL.booleanValue;
    }

    public static int k(@Nullable AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, advertAppInfo)) == null) {
            int m = advertAppInfo.m();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return m;
        }
        return invokeL.intValue;
    }

    public static boolean l(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) {
            return advertAppInfo.b();
        }
        return invokeL.booleanValue;
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<ut4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < uq7.i(list); i++) {
                if (uq7.d(list, i) instanceof ut4) {
                    ((ut4) uq7.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        gx8 gx8Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || uq7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof ut4)) {
                    if ((next instanceof jv4) && (threadData = ((jv4) next).t) != null && (gx8Var = threadData.funAdData) != null) {
                        gx8Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof gt5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = wm8.a((App) next);
                } else {
                    if (next instanceof ut4) {
                        ut4 ut4Var = (ut4) next;
                        if (ut4Var.u() != null) {
                            str2 = ut4Var.u().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                    i2 = i;
                }
            }
        }
    }

    public static String e(List<yn> list, boolean z) {
        InterceptResult invokeLZ;
        ut4 ut4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !uq7.e(list)) {
                int i = 0;
                for (int i2 = uq7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((uq7.d(list, i2) instanceof ut4) && (ut4Var = (ut4) uq7.d(list, i2)) != null && !l(ut4Var.u())) {
                        sb.append(ut4Var.j() + 1);
                        sb.append(",");
                        i++;
                    }
                }
                if (sb.length() <= 1) {
                    return sb.toString();
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static List<ut4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (uq7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.p(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    ep8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void m(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, advertAppInfo, i) == null) {
            ep8.h(advertAppInfo, 1, i);
        }
    }
}
