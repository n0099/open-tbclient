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
public class ur8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<hy4> {
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
        public int compare(hy4 hy4Var, hy4 hy4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hy4Var, hy4Var2)) == null) {
                if (hy4Var.e() && hy4Var2.e()) {
                    return hy4Var.j() - hy4Var2.j();
                }
                int i = -1;
                if (!hy4Var.e() && !hy4Var2.e()) {
                    if (hy4Var.v() == null) {
                        g = -1;
                    } else {
                        g = ur8.g(hy4Var.v());
                    }
                    if (hy4Var2.v() != null) {
                        i = ur8.g(hy4Var2.v());
                    }
                    return g - i;
                } else if (hy4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<Cdo> a(List<Cdo> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo v;
        AdvertAppInfo v2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (mv7.e(list)) {
                return hashSet;
            }
            Set<Cdo> a2 = bu8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (Cdo cdo : list) {
                if (cdo != null) {
                    for (Cdo cdo2 : a2) {
                        if ((cdo instanceof hy4) && (v2 = ((hy4) cdo).v()) != null && cdo2.hashCode() == v2.hashCode()) {
                            v2.i = ((AdvertAppInfo) cdo2).i;
                        }
                    }
                    if ((cdo instanceof hy4) && (v = ((hy4) cdo).v()) != null && v.i == null) {
                        xw4 xw4Var = new xw4();
                        v.i = xw4Var;
                        xw4Var.a = str;
                        xw4Var.b = i;
                        xw4Var.g = v.g;
                        xw4Var.h = false;
                        hashSet.add(v);
                    }
                }
            }
            a2.addAll(hashSet);
            bu8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<hy4> i(List<hy4> list, List<Cdo> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (mv7.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                hy4 hy4Var = (hy4) mv7.d(list, i4);
                if (hy4Var != null && hy4Var.v() != null) {
                    int i5 = mv7.i(list2);
                    int g = g(hy4Var.v()) - 1;
                    if (g < 0) {
                        n(hy4Var.v());
                    } else {
                        if (hy4Var.e()) {
                            i2 = hy4Var.j();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(hy4Var.v());
                        } else {
                            hy4Var.setPosition(i2);
                            mv7.b(list2, hy4Var, i2);
                            arrayList.add(hy4Var);
                        }
                    }
                }
            }
            while (i < mv7.i(list2)) {
                Cdo cdo = list2.get(i);
                if (cdo instanceof hy4) {
                    i3++;
                } else if (cdo instanceof BaseCardInfo) {
                    ((BaseCardInfo) cdo).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (mv7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = mv7.i(list) - 1; i3 >= 0 && !(mv7.d(list, i3) instanceof hy4); i3--) {
                if (mv7.d(list, i3) instanceof wz4) {
                    int i4 = ((wz4) mv7.d(list, i3)).position;
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

    public static void c(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || mv7.e(list)) {
            return;
        }
        Iterator<Cdo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof hy4) {
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
            return dh.e(advertAppInfo.f, -1);
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

    public static void o(List<hy4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < mv7.i(list); i++) {
                if (mv7.d(list, i) instanceof hy4) {
                    ((hy4) mv7.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        i29 i29Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || mv7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof hy4)) {
                    if ((next instanceof wz4) && (threadData = ((wz4) next).t) != null && (i29Var = threadData.funAdData) != null) {
                        i29Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof sx5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = vr8.a((App) next);
                } else {
                    if (next instanceof hy4) {
                        hy4 hy4Var = (hy4) next;
                        if (hy4Var.v() != null) {
                            str2 = hy4Var.v().a;
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

    public static String e(List<Cdo> list, boolean z) {
        InterceptResult invokeLZ;
        hy4 hy4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !mv7.e(list)) {
                int i = 0;
                for (int i2 = mv7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((mv7.d(list, i2) instanceof hy4) && (hy4Var = (hy4) mv7.d(list, i2)) != null && !l(hy4Var.v())) {
                        sb.append(hy4Var.j() + 1);
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

    public static List<hy4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (mv7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.p(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    du8.h(advertAppInfo, 1, k);
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
            du8.h(advertAppInfo, 1, i);
        }
    }
}
