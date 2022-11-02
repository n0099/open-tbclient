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
public class ze8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<ft4> {
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
        public int compare(ft4 ft4Var, ft4 ft4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ft4Var, ft4Var2)) == null) {
                if (ft4Var.e() && ft4Var2.e()) {
                    return ft4Var.i() - ft4Var2.i();
                }
                int i = -1;
                if (!ft4Var.e() && !ft4Var2.e()) {
                    if (ft4Var.p() == null) {
                        g = -1;
                    } else {
                        g = ze8.g(ft4Var.p());
                    }
                    if (ft4Var2.p() != null) {
                        i = ze8.g(ft4Var2.p());
                    }
                    return g - i;
                } else if (ft4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<wn> a(List<wn> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (vi7.e(list)) {
                return hashSet;
            }
            Set<wn> a2 = gh8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (wn wnVar : list) {
                if (wnVar != null) {
                    for (wn wnVar2 : a2) {
                        if ((wnVar instanceof ft4) && (p2 = ((ft4) wnVar).p()) != null && wnVar2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) wnVar2).i;
                        }
                    }
                    if ((wnVar instanceof ft4) && (p = ((ft4) wnVar).p()) != null && p.i == null) {
                        wr4 wr4Var = new wr4();
                        p.i = wr4Var;
                        wr4Var.a = str;
                        wr4Var.b = i;
                        wr4Var.g = p.g;
                        wr4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            gh8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<ft4> i(List<ft4> list, List<wn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (vi7.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ft4 ft4Var = (ft4) vi7.d(list, i4);
                if (ft4Var != null && ft4Var.p() != null) {
                    int i5 = vi7.i(list2);
                    int g = g(ft4Var.p()) - 1;
                    if (g < 0) {
                        n(ft4Var.p());
                    } else {
                        if (ft4Var.e()) {
                            i2 = ft4Var.i();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(ft4Var.p());
                        } else {
                            ft4Var.setPosition(i2);
                            vi7.b(list2, ft4Var, i2);
                            arrayList.add(ft4Var);
                        }
                    }
                }
            }
            while (i < vi7.i(list2)) {
                wn wnVar = list2.get(i);
                if (wnVar instanceof ft4) {
                    i3++;
                } else if (wnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) wnVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (vi7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = vi7.i(list) - 1; i3 >= 0 && !(vi7.d(list, i3) instanceof ft4); i3--) {
                if (vi7.d(list, i3) instanceof vu4) {
                    int i4 = ((vu4) vi7.d(list, i3)).position;
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

    public static void c(List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || vi7.e(list)) {
            return;
        }
        Iterator<wn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ft4) {
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

    public static void o(List<ft4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < vi7.i(list); i++) {
                if (vi7.d(list, i) instanceof ft4) {
                    ((ft4) vi7.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        yo8 yo8Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || vi7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof ft4)) {
                    if ((next instanceof vu4) && (threadData = ((vu4) next).t) != null && (yo8Var = threadData.funAdData) != null) {
                        yo8Var.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof er5)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = af8.a((App) next);
                } else {
                    if (next instanceof ft4) {
                        ft4 ft4Var = (ft4) next;
                        if (ft4Var.p() != null) {
                            str2 = ft4Var.p().a;
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

    public static String e(List<wn> list, boolean z) {
        InterceptResult invokeLZ;
        ft4 ft4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !vi7.e(list)) {
                int i = 0;
                for (int i2 = vi7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((vi7.d(list, i2) instanceof ft4) && (ft4Var = (ft4) vi7.d(list, i2)) != null && !l(ft4Var.p())) {
                        sb.append(ft4Var.i() + 1);
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

    public static List<ft4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (vi7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    ih8.h(advertAppInfo, 1, k);
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
            ih8.h(advertAppInfo, 1, i);
        }
    }
}
