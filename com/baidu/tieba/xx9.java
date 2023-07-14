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
/* loaded from: classes8.dex */
public class xx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Comparator<k35> {
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
        public int compare(k35 k35Var, k35 k35Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k35Var, k35Var2)) == null) {
                if (k35Var.l() && k35Var2.l()) {
                    return k35Var.s() - k35Var2.s();
                }
                int i = -1;
                if (!k35Var.l() && !k35Var2.l()) {
                    if (k35Var.G() == null) {
                        g = -1;
                    } else {
                        g = xx9.g(k35Var.G());
                    }
                    if (k35Var2.G() != null) {
                        i = xx9.g(k35Var2.G());
                    }
                    return g - i;
                } else if (k35Var.l()) {
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
        AdvertAppInfo G;
        AdvertAppInfo G2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (g09.e(list)) {
                return hashSet;
            }
            Set<yn> a2 = h0a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (yn ynVar : list) {
                if (ynVar != null) {
                    for (yn ynVar2 : a2) {
                        if ((ynVar instanceof k35) && (G2 = ((k35) ynVar).G()) != null && ynVar2.hashCode() == G2.hashCode()) {
                            G2.i = ((AdvertAppInfo) ynVar2).i;
                        }
                    }
                    if ((ynVar instanceof k35) && (G = ((k35) ynVar).G()) != null && G.i == null) {
                        y15 y15Var = new y15();
                        G.i = y15Var;
                        y15Var.a = str;
                        y15Var.b = i;
                        y15Var.g = G.g;
                        y15Var.h = false;
                        hashSet.add(G);
                    }
                }
            }
            a2.addAll(hashSet);
            h0a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<k35> i(List<k35> list, List<yn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (g09.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                k35 k35Var = (k35) g09.d(list, i4);
                if (k35Var != null && k35Var.G() != null) {
                    int i5 = g09.i(list2);
                    int g = g(k35Var.G()) - 1;
                    if (g < 0) {
                        n(k35Var.G());
                    } else {
                        if (k35Var.l()) {
                            i2 = k35Var.s();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(k35Var.G());
                        } else {
                            k35Var.setPosition(i2);
                            g09.b(list2, k35Var, i2);
                            arrayList.add(k35Var);
                        }
                    }
                }
            }
            while (i < g09.i(list2)) {
                yn ynVar = list2.get(i);
                if (ynVar instanceof k35) {
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
            if (g09.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = g09.i(list) - 1; i3 >= 0 && !(g09.d(list, i3) instanceof k35); i3--) {
                if (g09.d(list, i3) instanceof z45) {
                    int i4 = ((z45) g09.d(list, i3)).position;
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
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || g09.e(list)) {
            return;
        }
        Iterator<yn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof k35) {
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
            return wg.e(advertAppInfo.f, -1);
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
            int h = advertAppInfo.h();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return h;
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

    public static void o(List<k35> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < g09.i(list); i++) {
                if (g09.d(list, i) instanceof k35) {
                    ((k35) g09.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        wca wcaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || g09.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof k35)) {
                    if ((next instanceof z45) && (threadData = ((z45) next).t) != null && (wcaVar = threadData.funAdData) != null) {
                        wcaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof a86)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = yx9.a((App) next);
                } else {
                    if (next instanceof k35) {
                        k35 k35Var = (k35) next;
                        if (k35Var.G() != null) {
                            str2 = k35Var.G().a;
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
        k35 k35Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !g09.e(list)) {
                int i = 0;
                for (int i2 = g09.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((g09.d(list, i2) instanceof k35) && (k35Var = (k35) g09.d(list, i2)) != null && !l(k35Var.G())) {
                        sb.append(k35Var.s() + 1);
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

    public static List<k35> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (g09.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.k(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    j0a.h(advertAppInfo, 1, k);
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
            j0a.h(advertAppInfo, 1, i);
        }
    }
}
