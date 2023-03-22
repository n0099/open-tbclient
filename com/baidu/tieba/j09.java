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
/* loaded from: classes5.dex */
public class j09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<xx4> {
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
        public int compare(xx4 xx4Var, xx4 xx4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xx4Var, xx4Var2)) == null) {
                if (xx4Var.e() && xx4Var2.e()) {
                    return xx4Var.l() - xx4Var2.l();
                }
                int i = -1;
                if (!xx4Var.e() && !xx4Var2.e()) {
                    if (xx4Var.A() == null) {
                        g = -1;
                    } else {
                        g = j09.g(xx4Var.A());
                    }
                    if (xx4Var2.A() != null) {
                        i = j09.g(xx4Var2.A());
                    }
                    return g - i;
                } else if (xx4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<gn> a(List<gn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo A;
        AdvertAppInfo A2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (v38.e(list)) {
                return hashSet;
            }
            Set<gn> a2 = q29.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (gn gnVar : list) {
                if (gnVar != null) {
                    for (gn gnVar2 : a2) {
                        if ((gnVar instanceof xx4) && (A2 = ((xx4) gnVar).A()) != null && gnVar2.hashCode() == A2.hashCode()) {
                            A2.i = ((AdvertAppInfo) gnVar2).i;
                        }
                    }
                    if ((gnVar instanceof xx4) && (A = ((xx4) gnVar).A()) != null && A.i == null) {
                        mw4 mw4Var = new mw4();
                        A.i = mw4Var;
                        mw4Var.a = str;
                        mw4Var.b = i;
                        mw4Var.g = A.g;
                        mw4Var.h = false;
                        hashSet.add(A);
                    }
                }
            }
            a2.addAll(hashSet);
            q29.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<xx4> i(List<xx4> list, List<gn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (v38.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                xx4 xx4Var = (xx4) v38.d(list, i4);
                if (xx4Var != null && xx4Var.A() != null) {
                    int i5 = v38.i(list2);
                    int g = g(xx4Var.A()) - 1;
                    if (g < 0) {
                        n(xx4Var.A());
                    } else {
                        if (xx4Var.e()) {
                            i2 = xx4Var.l();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(xx4Var.A());
                        } else {
                            xx4Var.setPosition(i2);
                            v38.b(list2, xx4Var, i2);
                            arrayList.add(xx4Var);
                        }
                    }
                }
            }
            while (i < v38.i(list2)) {
                gn gnVar = list2.get(i);
                if (gnVar instanceof xx4) {
                    i3++;
                } else if (gnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) gnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<gn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (v38.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = v38.i(list) - 1; i3 >= 0 && !(v38.d(list, i3) instanceof xx4); i3--) {
                if (v38.d(list, i3) instanceof mz4) {
                    int i4 = ((mz4) v38.d(list, i3)).position;
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

    public static void c(List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || v38.e(list)) {
            return;
        }
        Iterator<gn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof xx4) {
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
            int k = advertAppInfo.k();
            if (g(advertAppInfo) < 0) {
                return 23;
            }
            return k;
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

    public static void o(List<xx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < v38.i(list); i++) {
                if (v38.d(list, i) instanceof xx4) {
                    ((xx4) v38.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        zb9 zb9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || v38.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof xx4)) {
                    if ((next instanceof mz4) && (threadData = ((mz4) next).t) != null && (zb9Var = threadData.funAdData) != null) {
                        zb9Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof py5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = k09.a((App) next);
                } else {
                    if (next instanceof xx4) {
                        xx4 xx4Var = (xx4) next;
                        if (xx4Var.A() != null) {
                            str2 = xx4Var.A().a;
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

    public static String e(List<gn> list, boolean z) {
        InterceptResult invokeLZ;
        xx4 xx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !v38.e(list)) {
                int i = 0;
                for (int i2 = v38.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((v38.d(list, i2) instanceof xx4) && (xx4Var = (xx4) v38.d(list, i2)) != null && !l(xx4Var.A())) {
                        sb.append(xx4Var.l() + 1);
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

    public static List<xx4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (v38.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.o(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    s29.h(advertAppInfo, 1, k);
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
            s29.h(advertAppInfo, 1, i);
        }
    }
}
