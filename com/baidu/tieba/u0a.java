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
/* loaded from: classes8.dex */
public class u0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Comparator<o25> {
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
        public int compare(o25 o25Var, o25 o25Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o25Var, o25Var2)) == null) {
                if (o25Var.k() && o25Var2.k()) {
                    return o25Var.p() - o25Var2.p();
                }
                int i = -1;
                if (!o25Var.k() && !o25Var2.k()) {
                    if (o25Var.B() == null) {
                        g = -1;
                    } else {
                        g = u0a.g(o25Var.B());
                    }
                    if (o25Var2.B() != null) {
                        i = u0a.g(o25Var2.B());
                    }
                    return g - i;
                } else if (o25Var.k()) {
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
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (g29.e(list)) {
                return hashSet;
            }
            Set<bn> a2 = e3a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (bn bnVar : list) {
                if (bnVar != null) {
                    for (bn bnVar2 : a2) {
                        if ((bnVar instanceof o25) && (B2 = ((o25) bnVar).B()) != null && bnVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) bnVar2).i;
                        }
                    }
                    if ((bnVar instanceof o25) && (B = ((o25) bnVar).B()) != null && B.i == null) {
                        b15 b15Var = new b15();
                        B.i = b15Var;
                        b15Var.a = str;
                        b15Var.b = i;
                        b15Var.g = B.g;
                        b15Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            e3a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<o25> i(List<o25> list, List<bn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (g29.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                o25 o25Var = (o25) g29.d(list, i4);
                if (o25Var != null && o25Var.B() != null) {
                    int i5 = g29.i(list2);
                    int g = g(o25Var.B()) - 1;
                    if (g < 0) {
                        n(o25Var.B());
                    } else {
                        if (o25Var.k()) {
                            i2 = o25Var.p();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(o25Var.B());
                        } else {
                            o25Var.setPosition(i2);
                            g29.b(list2, o25Var, i2);
                            arrayList.add(o25Var);
                        }
                    }
                }
            }
            while (i < g29.i(list2)) {
                bn bnVar = list2.get(i);
                if (bnVar instanceof o25) {
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
            if (g29.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = g29.i(list) - 1; i3 >= 0 && !(g29.d(list, i3) instanceof o25); i3--) {
                if (g29.d(list, i3) instanceof c45) {
                    int i4 = ((c45) g29.d(list, i3)).position;
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
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || g29.e(list)) {
            return;
        }
        Iterator<bn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof o25) {
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

    public static void o(List<o25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < g29.i(list); i++) {
                if (g29.d(list, i) instanceof o25) {
                    ((o25) g29.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        xfa xfaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || g29.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof o25)) {
                    if ((next instanceof c45) && (threadData = ((c45) next).t) != null && (xfaVar = threadData.funAdData) != null) {
                        xfaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof z56)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = v0a.a((App) next);
                } else {
                    if (next instanceof o25) {
                        o25 o25Var = (o25) next;
                        if (o25Var.B() != null) {
                            str2 = o25Var.B().a;
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
        o25 o25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !g29.e(list)) {
                int i = 0;
                for (int i2 = g29.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((g29.d(list, i2) instanceof o25) && (o25Var = (o25) g29.d(list, i2)) != null && !l(o25Var.B())) {
                        sb.append(o25Var.p() + 1);
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

    public static List<o25> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (g29.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    g3a.h(advertAppInfo, 1, k);
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
            g3a.h(advertAppInfo, 1, i);
        }
    }
}
