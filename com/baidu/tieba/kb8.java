package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
public class kb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Comparator<vp4> {
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
        public int compare(vp4 vp4Var, vp4 vp4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vp4Var, vp4Var2)) == null) {
                if (vp4Var.e() && vp4Var2.e()) {
                    return vp4Var.i() - vp4Var2.i();
                }
                if (vp4Var.e() || vp4Var2.e()) {
                    return vp4Var.e() ? -1 : 1;
                }
                return (vp4Var.p() == null ? -1 : kb8.g(vp4Var.p())) - (vp4Var2.p() != null ? kb8.g(vp4Var2.p()) : -1);
            }
            return invokeLL.intValue;
        }
    }

    public static Set<pn> a(List<pn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (if7.e(list)) {
                return hashSet;
            }
            Set<pn> a2 = rd8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (pn pnVar : list) {
                if (pnVar != null) {
                    for (pn pnVar2 : a2) {
                        if ((pnVar instanceof vp4) && (p2 = ((vp4) pnVar).p()) != null && pnVar2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) pnVar2).i;
                        }
                    }
                    if ((pnVar instanceof vp4) && (p = ((vp4) pnVar).p()) != null && p.i == null) {
                        mo4 mo4Var = new mo4();
                        p.i = mo4Var;
                        mo4Var.a = str;
                        mo4Var.b = i;
                        mo4Var.g = p.g;
                        mo4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            rd8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static int b(@NonNull List<pn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (if7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = if7.i(list) - 1; i3 >= 0 && !(if7.d(list, i3) instanceof vp4); i3--) {
                if (if7.d(list, i3) instanceof kr4) {
                    int i4 = ((kr4) if7.d(list, i3)).position;
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

    public static void c(List<pn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || if7.e(list)) {
            return;
        }
        Iterator<pn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof vp4) {
                it.remove();
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) || TextUtils.isEmpty(str) || if7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean z = next instanceof vp4;
            if (z || (next instanceof App)) {
                if (next instanceof App) {
                    str2 = lb8.a((App) next);
                } else {
                    if (z) {
                        vp4 vp4Var = (vp4) next;
                        if (vp4Var.p() != null) {
                            str2 = vp4Var.p().a;
                        }
                    }
                    str2 = "";
                }
                if (TextUtils.equals(str, str2)) {
                    it.remove();
                }
            }
        }
    }

    public static String e(List<pn> list, boolean z) {
        InterceptResult invokeLZ;
        vp4 vp4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !if7.e(list)) {
                int i = 0;
                for (int i2 = if7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((if7.d(list, i2) instanceof vp4) && (vp4Var = (vp4) if7.d(list, i2)) != null && !l(vp4Var.p())) {
                        sb.append(vp4Var.i() + 1);
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
            return pg.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static List<vp4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (if7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    td8.h(advertAppInfo, 1, k);
                } else {
                    arrayList.add(advertAppInfo);
                }
            }
            Log.e("frs", "src ad jiaoyan size " + arrayList.size());
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<vp4> i(List<vp4> list, List<pn> list2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (if7.e(list)) {
                return arrayList;
            }
            o(list);
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                vp4 vp4Var = (vp4) if7.d(list, i3);
                if (vp4Var != null && vp4Var.p() != null) {
                    int i4 = if7.i(list2);
                    int g = g(vp4Var.p()) - 1;
                    if (g < 0) {
                        n(vp4Var.p());
                    } else {
                        int i5 = vp4Var.e() ? vp4Var.i() : g + i;
                        if (i5 > i4) {
                            n(vp4Var.p());
                        } else {
                            vp4Var.setPosition(i5);
                            if7.b(list2, vp4Var, i5);
                            arrayList.add(vp4Var);
                        }
                    }
                }
            }
            while (i < if7.i(list2)) {
                pn pnVar = list2.get(i);
                if (pnVar instanceof vp4) {
                    i2++;
                } else if (pnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) pnVar).position += i2;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, advertAppInfo)) == null) ? advertAppInfo.b() : invokeL.booleanValue;
    }

    public static void m(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, advertAppInfo, i) == null) {
            td8.h(advertAppInfo, 1, i);
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            m(advertAppInfo, 23);
        }
    }

    public static void o(List<vp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < if7.i(list); i++) {
                if (if7.d(list, i) instanceof vp4) {
                    ((vp4) if7.d(list, i)).setPosition(i);
                }
            }
        }
    }
}
