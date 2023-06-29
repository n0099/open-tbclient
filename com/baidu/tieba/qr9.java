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
public class qr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<c35> {
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
        public int compare(c35 c35Var, c35 c35Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c35Var, c35Var2)) == null) {
                if (c35Var.j() && c35Var2.j()) {
                    return c35Var.r() - c35Var2.r();
                }
                int i = -1;
                if (!c35Var.j() && !c35Var2.j()) {
                    if (c35Var.G() == null) {
                        g = -1;
                    } else {
                        g = qr9.g(c35Var.G());
                    }
                    if (c35Var2.G() != null) {
                        i = qr9.g(c35Var2.G());
                    }
                    return g - i;
                } else if (c35Var.j()) {
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
        AdvertAppInfo G;
        AdvertAppInfo G2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (du8.e(list)) {
                return hashSet;
            }
            Set<xn> a2 = zt9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (xn xnVar : list) {
                if (xnVar != null) {
                    for (xn xnVar2 : a2) {
                        if ((xnVar instanceof c35) && (G2 = ((c35) xnVar).G()) != null && xnVar2.hashCode() == G2.hashCode()) {
                            G2.i = ((AdvertAppInfo) xnVar2).i;
                        }
                    }
                    if ((xnVar instanceof c35) && (G = ((c35) xnVar).G()) != null && G.i == null) {
                        q15 q15Var = new q15();
                        G.i = q15Var;
                        q15Var.a = str;
                        q15Var.b = i;
                        q15Var.g = G.g;
                        q15Var.h = false;
                        hashSet.add(G);
                    }
                }
            }
            a2.addAll(hashSet);
            zt9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<c35> i(List<c35> list, List<xn> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (du8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                c35 c35Var = (c35) du8.d(list, i4);
                if (c35Var != null && c35Var.G() != null) {
                    int i5 = du8.i(list2);
                    int g = g(c35Var.G()) - 1;
                    if (g < 0) {
                        n(c35Var.G());
                    } else {
                        if (c35Var.j()) {
                            i2 = c35Var.r();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(c35Var.G());
                        } else {
                            c35Var.setPosition(i2);
                            du8.b(list2, c35Var, i2);
                            arrayList.add(c35Var);
                        }
                    }
                }
            }
            while (i < du8.i(list2)) {
                xn xnVar = list2.get(i);
                if (xnVar instanceof c35) {
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
            if (du8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = du8.i(list) - 1; i3 >= 0 && !(du8.d(list, i3) instanceof c35); i3--) {
                if (du8.d(list, i3) instanceof r45) {
                    int i4 = ((r45) du8.d(list, i3)).position;
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
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || du8.e(list)) {
            return;
        }
        Iterator<xn> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof c35) {
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
            return vg.e(advertAppInfo.f, -1);
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

    public static void o(List<c35> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < du8.i(list); i++) {
                if (du8.d(list, i) instanceof c35) {
                    ((c35) du8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        l4a l4aVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || du8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof c35)) {
                    if ((next instanceof r45) && (threadData = ((r45) next).t) != null && (l4aVar = threadData.funAdData) != null) {
                        l4aVar.p(true);
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
                    str2 = rr9.a((App) next);
                } else {
                    if (next instanceof c35) {
                        c35 c35Var = (c35) next;
                        if (c35Var.G() != null) {
                            str2 = c35Var.G().a;
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
        c35 c35Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !du8.e(list)) {
                int i = 0;
                for (int i2 = du8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((du8.d(list, i2) instanceof c35) && (c35Var = (c35) du8.d(list, i2)) != null && !l(c35Var.G())) {
                        sb.append(c35Var.r() + 1);
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

    public static List<c35> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (du8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    bu9.h(advertAppInfo, 1, k);
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
            bu9.h(advertAppInfo, 1, i);
        }
    }
}
