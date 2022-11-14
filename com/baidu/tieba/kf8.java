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
/* loaded from: classes4.dex */
public class kf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<gt4> {
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
        public int compare(gt4 gt4Var, gt4 gt4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gt4Var, gt4Var2)) == null) {
                if (gt4Var.e() && gt4Var2.e()) {
                    return gt4Var.i() - gt4Var2.i();
                }
                int i = -1;
                if (!gt4Var.e() && !gt4Var2.e()) {
                    if (gt4Var.p() == null) {
                        g = -1;
                    } else {
                        g = kf8.g(gt4Var.p());
                    }
                    if (gt4Var2.p() != null) {
                        i = kf8.g(gt4Var2.p());
                    }
                    return g - i;
                } else if (gt4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<xn> a(List<xn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (gj7.e(list)) {
                return hashSet;
            }
            Set<xn> a2 = rh8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (xn xnVar : list) {
                if (xnVar != null) {
                    for (xn xnVar2 : a2) {
                        if ((xnVar instanceof gt4) && (p2 = ((gt4) xnVar).p()) != null && xnVar2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) xnVar2).i;
                        }
                    }
                    if ((xnVar instanceof gt4) && (p = ((gt4) xnVar).p()) != null && p.i == null) {
                        xr4 xr4Var = new xr4();
                        p.i = xr4Var;
                        xr4Var.a = str;
                        xr4Var.b = i;
                        xr4Var.g = p.g;
                        xr4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            rh8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<gt4> i(List<gt4> list, List<xn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gj7.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                gt4 gt4Var = (gt4) gj7.d(list, i4);
                if (gt4Var != null && gt4Var.p() != null) {
                    int i5 = gj7.i(list2);
                    int g = g(gt4Var.p()) - 1;
                    if (g < 0) {
                        n(gt4Var.p());
                    } else {
                        if (gt4Var.e()) {
                            i2 = gt4Var.i();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(gt4Var.p());
                        } else {
                            gt4Var.setPosition(i2);
                            gj7.b(list2, gt4Var, i2);
                            arrayList.add(gt4Var);
                        }
                    }
                }
            }
            while (i < gj7.i(list2)) {
                xn xnVar = list2.get(i);
                if (xnVar instanceof gt4) {
                    i3++;
                } else if (xnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) xnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (gj7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = gj7.i(list) - 1; i3 >= 0 && !(gj7.d(list, i3) instanceof gt4); i3--) {
                if (gj7.d(list, i3) instanceof wu4) {
                    int i4 = ((wu4) gj7.d(list, i3)).position;
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

    public static void c(List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || gj7.e(list)) {
            return;
        }
        Iterator<xn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof gt4) {
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
            return xg.e(advertAppInfo.f, -1);
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
            int n = advertAppInfo.n();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return n;
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

    public static void o(List<gt4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < gj7.i(list); i++) {
                if (gj7.d(list, i) instanceof gt4) {
                    ((gt4) gj7.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        jp8 jp8Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || gj7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof gt4)) {
                    if ((next instanceof wu4) && (threadData = ((wu4) next).t) != null && (jp8Var = threadData.funAdData) != null) {
                        jp8Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof qr5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = lf8.a((App) next);
                } else {
                    if (next instanceof gt4) {
                        gt4 gt4Var = (gt4) next;
                        if (gt4Var.p() != null) {
                            str2 = gt4Var.p().a;
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

    public static String e(List<xn> list, boolean z) {
        InterceptResult invokeLZ;
        gt4 gt4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !gj7.e(list)) {
                int i = 0;
                for (int i2 = gj7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((gj7.d(list, i2) instanceof gt4) && (gt4Var = (gt4) gj7.d(list, i2)) != null && !l(gt4Var.p())) {
                        sb.append(gt4Var.i() + 1);
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

    public static List<gt4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gj7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    th8.h(advertAppInfo, 1, k);
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
            th8.h(advertAppInfo, 1, i);
        }
    }
}
