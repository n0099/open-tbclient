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
public class ml9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<y25> {
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
        public int compare(y25 y25Var, y25 y25Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, y25Var, y25Var2)) == null) {
                if (y25Var.j() && y25Var2.j()) {
                    return y25Var.r() - y25Var2.r();
                }
                int i = -1;
                if (!y25Var.j() && !y25Var2.j()) {
                    if (y25Var.G() == null) {
                        g = -1;
                    } else {
                        g = ml9.g(y25Var.G());
                    }
                    if (y25Var2.G() != null) {
                        i = ml9.g(y25Var2.G());
                    }
                    return g - i;
                } else if (y25Var.j()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<vn> a(List<vn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo G;
        AdvertAppInfo G2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (yo8.e(list)) {
                return hashSet;
            }
            Set<vn> a2 = vn9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (vn vnVar : list) {
                if (vnVar != null) {
                    for (vn vnVar2 : a2) {
                        if ((vnVar instanceof y25) && (G2 = ((y25) vnVar).G()) != null && vnVar2.hashCode() == G2.hashCode()) {
                            G2.i = ((AdvertAppInfo) vnVar2).i;
                        }
                    }
                    if ((vnVar instanceof y25) && (G = ((y25) vnVar).G()) != null && G.i == null) {
                        m15 m15Var = new m15();
                        G.i = m15Var;
                        m15Var.a = str;
                        m15Var.b = i;
                        m15Var.g = G.g;
                        m15Var.h = false;
                        hashSet.add(G);
                    }
                }
            }
            a2.addAll(hashSet);
            vn9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<y25> i(List<y25> list, List<vn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (yo8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                y25 y25Var = (y25) yo8.d(list, i4);
                if (y25Var != null && y25Var.G() != null) {
                    int i5 = yo8.i(list2);
                    int g = g(y25Var.G()) - 1;
                    if (g < 0) {
                        n(y25Var.G());
                    } else {
                        if (y25Var.j()) {
                            i2 = y25Var.r();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(y25Var.G());
                        } else {
                            y25Var.setPosition(i2);
                            yo8.b(list2, y25Var, i2);
                            arrayList.add(y25Var);
                        }
                    }
                }
            }
            while (i < yo8.i(list2)) {
                vn vnVar = list2.get(i);
                if (vnVar instanceof y25) {
                    i3++;
                } else if (vnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) vnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<vn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (yo8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = yo8.i(list) - 1; i3 >= 0 && !(yo8.d(list, i3) instanceof y25); i3--) {
                if (yo8.d(list, i3) instanceof n45) {
                    int i4 = ((n45) yo8.d(list, i3)).position;
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

    public static void c(List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || yo8.e(list)) {
            return;
        }
        Iterator<vn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof y25) {
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
            return tg.e(advertAppInfo.f, -1);
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
            int i = advertAppInfo.i();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return i;
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

    public static void o(List<y25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < yo8.i(list); i++) {
                if (yo8.d(list, i) instanceof y25) {
                    ((y25) yo8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        hy9 hy9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || yo8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof y25)) {
                    if ((next instanceof n45) && (threadData = ((n45) next).t) != null && (hy9Var = threadData.funAdData) != null) {
                        hy9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof m66)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = nl9.a((App) next);
                } else {
                    if (next instanceof y25) {
                        y25 y25Var = (y25) next;
                        if (y25Var.G() != null) {
                            str2 = y25Var.G().a;
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

    public static String e(List<vn> list, boolean z) {
        InterceptResult invokeLZ;
        y25 y25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !yo8.e(list)) {
                int i = 0;
                for (int i2 = yo8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((yo8.d(list, i2) instanceof y25) && (y25Var = (y25) yo8.d(list, i2)) != null && !l(y25Var.G())) {
                        sb.append(y25Var.r() + 1);
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

    public static List<y25> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (yo8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    xn9.h(advertAppInfo, 1, k);
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
            xn9.h(advertAppInfo, 1, i);
        }
    }
}
