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
/* loaded from: classes7.dex */
public class z99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<zx4> {
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
        public int compare(zx4 zx4Var, zx4 zx4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zx4Var, zx4Var2)) == null) {
                if (zx4Var.j() && zx4Var2.j()) {
                    return zx4Var.p() - zx4Var2.p();
                }
                int i = -1;
                if (!zx4Var.j() && !zx4Var2.j()) {
                    if (zx4Var.B() == null) {
                        g = -1;
                    } else {
                        g = z99.g(zx4Var.B());
                    }
                    if (zx4Var2.B() != null) {
                        i = z99.g(zx4Var2.B());
                    }
                    return g - i;
                } else if (zx4Var.j()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<hn> a(List<hn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (me8.e(list)) {
                return hashSet;
            }
            Set<hn> a2 = hc9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (hn hnVar : list) {
                if (hnVar != null) {
                    for (hn hnVar2 : a2) {
                        if ((hnVar instanceof zx4) && (B2 = ((zx4) hnVar).B()) != null && hnVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) hnVar2).i;
                        }
                    }
                    if ((hnVar instanceof zx4) && (B = ((zx4) hnVar).B()) != null && B.i == null) {
                        ow4 ow4Var = new ow4();
                        B.i = ow4Var;
                        ow4Var.a = str;
                        ow4Var.b = i;
                        ow4Var.g = B.g;
                        ow4Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            hc9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<zx4> i(List<zx4> list, List<hn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (me8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                zx4 zx4Var = (zx4) me8.d(list, i4);
                if (zx4Var != null && zx4Var.B() != null) {
                    int i5 = me8.i(list2);
                    int g = g(zx4Var.B()) - 1;
                    if (g < 0) {
                        n(zx4Var.B());
                    } else {
                        if (zx4Var.j()) {
                            i2 = zx4Var.p();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(zx4Var.B());
                        } else {
                            zx4Var.setPosition(i2);
                            me8.b(list2, zx4Var, i2);
                            arrayList.add(zx4Var);
                        }
                    }
                }
            }
            while (i < me8.i(list2)) {
                hn hnVar = list2.get(i);
                if (hnVar instanceof zx4) {
                    i3++;
                } else if (hnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) hnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<hn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (me8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = me8.i(list) - 1; i3 >= 0 && !(me8.d(list, i3) instanceof zx4); i3--) {
                if (me8.d(list, i3) instanceof oz4) {
                    int i4 = ((oz4) me8.d(list, i3)).position;
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

    public static void c(List<hn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || me8.e(list)) {
            return;
        }
        Iterator<hn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof zx4) {
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
            return gg.e(advertAppInfo.f, -1);
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

    public static void o(List<zx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < me8.i(list); i++) {
                if (me8.d(list, i) instanceof zx4) {
                    ((zx4) me8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        ql9 ql9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || me8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof zx4)) {
                    if ((next instanceof oz4) && (threadData = ((oz4) next).t) != null && (ql9Var = threadData.funAdData) != null) {
                        ql9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof vz5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = aa9.a((App) next);
                } else {
                    if (next instanceof zx4) {
                        zx4 zx4Var = (zx4) next;
                        if (zx4Var.B() != null) {
                            str2 = zx4Var.B().a;
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

    public static String e(List<hn> list, boolean z) {
        InterceptResult invokeLZ;
        zx4 zx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !me8.e(list)) {
                int i = 0;
                for (int i2 = me8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((me8.d(list, i2) instanceof zx4) && (zx4Var = (zx4) me8.d(list, i2)) != null && !l(zx4Var.B())) {
                        sb.append(zx4Var.p() + 1);
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

    public static List<zx4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (me8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    jc9.h(advertAppInfo, 1, k);
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
            jc9.h(advertAppInfo, 1, i);
        }
    }
}
