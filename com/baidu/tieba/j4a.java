package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
public class j4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Comparator<t25> {
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
        public int compare(t25 t25Var, t25 t25Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t25Var, t25Var2)) == null) {
                if (t25Var.k() && t25Var2.k()) {
                    return t25Var.n() - t25Var2.n();
                }
                int i = -1;
                if (!t25Var.k() && !t25Var2.k()) {
                    if (t25Var.A() == null) {
                        g = -1;
                    } else {
                        g = j4a.g(t25Var.A());
                    }
                    if (t25Var2.A() != null) {
                        i = j4a.g(t25Var2.A());
                    }
                    return g - i;
                } else if (t25Var.k()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<bn> a(List<bn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo A;
        AdvertAppInfo A2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (t49.e(list)) {
                return hashSet;
            }
            Set<bn> a2 = t6a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (bn bnVar : list) {
                if (bnVar != null) {
                    for (bn bnVar2 : a2) {
                        if ((bnVar instanceof t25) && (A2 = ((t25) bnVar).A()) != null && bnVar2.hashCode() == A2.hashCode()) {
                            A2.i = ((AdvertAppInfo) bnVar2).i;
                        }
                    }
                    if ((bnVar instanceof t25) && (A = ((t25) bnVar).A()) != null && A.i == null) {
                        g15 g15Var = new g15();
                        A.i = g15Var;
                        g15Var.a = str;
                        g15Var.b = i;
                        g15Var.g = A.g;
                        g15Var.h = false;
                        hashSet.add(A);
                    }
                }
            }
            a2.addAll(hashSet);
            t6a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<t25> i(List<t25> list, List<bn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (t49.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                t25 t25Var = (t25) t49.d(list, i4);
                if (t25Var != null && t25Var.A() != null) {
                    int i5 = t49.i(list2);
                    int g = g(t25Var.A()) - 1;
                    if (g < 0) {
                        n(t25Var.A());
                    } else {
                        if (t25Var.k()) {
                            i2 = t25Var.n();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(t25Var.A());
                        } else {
                            t25Var.setPosition(i2);
                            t49.b(list2, t25Var, i2);
                            arrayList.add(t25Var);
                        }
                    }
                }
            }
            while (i < t49.i(list2)) {
                bn bnVar = list2.get(i);
                if (bnVar instanceof t25) {
                    i3++;
                } else if (bnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) bnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (t49.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = t49.i(list) - 1; i3 >= 0 && !(t49.d(list, i3) instanceof t25); i3--) {
                if (t49.d(list, i3) instanceof h45) {
                    int i4 = ((h45) t49.d(list, i3)).position;
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

    public static void c(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || t49.e(list)) {
            return;
        }
        Iterator<bn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof t25) {
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
            return JavaTypesHelper.toInt(advertAppInfo.f, -1);
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

    public static void o(List<t25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < t49.i(list); i++) {
                if (t49.d(list, i) instanceof t25) {
                    ((t25) t49.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        xja xjaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || t49.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof t25)) {
                    if ((next instanceof h45) && (threadData = ((h45) next).t) != null && (xjaVar = threadData.funAdData) != null) {
                        xjaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof w66)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = k4a.a((App) next);
                } else {
                    if (next instanceof t25) {
                        t25 t25Var = (t25) next;
                        if (t25Var.A() != null) {
                            str2 = t25Var.A().a;
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

    public static String e(List<bn> list, boolean z) {
        InterceptResult invokeLZ;
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !t49.e(list)) {
                int i = 0;
                for (int i2 = t49.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((t49.d(list, i2) instanceof t25) && (t25Var = (t25) t49.d(list, i2)) != null && !l(t25Var.A())) {
                        sb.append(t25Var.n() + 1);
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

    public static List<t25> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (t49.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    v6a.h(advertAppInfo, 1, k);
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
            v6a.h(advertAppInfo, 1, i);
        }
    }
}
