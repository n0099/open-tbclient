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
/* loaded from: classes9.dex */
public class yga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements Comparator<yx4> {
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
        public int compare(yx4 yx4Var, yx4 yx4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yx4Var, yx4Var2)) == null) {
                if (yx4Var.j() && yx4Var2.j()) {
                    return yx4Var.m() - yx4Var2.m();
                }
                int i = -1;
                if (!yx4Var.j() && !yx4Var2.j()) {
                    if (yx4Var.w() == null) {
                        g = -1;
                    } else {
                        g = yga.g(yx4Var.w());
                    }
                    if (yx4Var2.w() != null) {
                        i = yga.g(yx4Var2.w());
                    }
                    return g - i;
                } else if (yx4Var.j()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<pi> a(List<pi> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo w;
        AdvertAppInfo w2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (dg9.e(list)) {
                return hashSet;
            }
            Set<pi> a2 = ija.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (pi piVar : list) {
                if (piVar != null) {
                    for (pi piVar2 : a2) {
                        if ((piVar instanceof yx4) && (w2 = ((yx4) piVar).w()) != null && piVar2.hashCode() == w2.hashCode()) {
                            w2.i = ((AdvertAppInfo) piVar2).i;
                        }
                    }
                    if ((piVar instanceof yx4) && (w = ((yx4) piVar).w()) != null && w.i == null) {
                        kw4 kw4Var = new kw4();
                        w.i = kw4Var;
                        kw4Var.a = str;
                        kw4Var.b = i;
                        kw4Var.g = w.g;
                        kw4Var.h = false;
                        hashSet.add(w);
                    }
                }
            }
            a2.addAll(hashSet);
            ija.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<yx4> i(List<yx4> list, List<pi> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (dg9.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                yx4 yx4Var = (yx4) dg9.d(list, i4);
                if (yx4Var != null && yx4Var.w() != null) {
                    int i5 = dg9.i(list2);
                    int g = g(yx4Var.w()) - 1;
                    if (g < 0) {
                        n(yx4Var.w());
                    } else {
                        if (yx4Var.j()) {
                            i2 = yx4Var.m();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(yx4Var.w());
                        } else {
                            yx4Var.setPosition(i2);
                            dg9.b(list2, yx4Var, i2);
                            arrayList.add(yx4Var);
                        }
                    }
                }
            }
            while (i < dg9.i(list2)) {
                pi piVar = list2.get(i);
                if (piVar instanceof yx4) {
                    i3++;
                } else if (piVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) piVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (dg9.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = dg9.i(list) - 1; i3 >= 0 && !(dg9.d(list, i3) instanceof yx4); i3--) {
                if (dg9.d(list, i3) instanceof mz4) {
                    int i4 = ((mz4) dg9.d(list, i3)).position;
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

    public static void c(List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || dg9.e(list)) {
            return;
        }
        Iterator<pi> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof yx4) {
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

    public static void o(List<yx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < dg9.i(list); i++) {
                if (dg9.d(list, i) instanceof yx4) {
                    ((yx4) dg9.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        kwa kwaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || dg9.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof yx4)) {
                    if ((next instanceof mz4) && (threadData = ((mz4) next).t) != null && (kwaVar = threadData.funAdData) != null) {
                        kwaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof l36)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = zga.a((App) next);
                } else {
                    if (next instanceof yx4) {
                        yx4 yx4Var = (yx4) next;
                        if (yx4Var.w() != null) {
                            str2 = yx4Var.w().a;
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

    public static String e(List<pi> list, boolean z) {
        InterceptResult invokeLZ;
        yx4 yx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !dg9.e(list)) {
                int i = 0;
                for (int i2 = dg9.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((dg9.d(list, i2) instanceof yx4) && (yx4Var = (yx4) dg9.d(list, i2)) != null && !l(yx4Var.w())) {
                        sb.append(yx4Var.m() + 1);
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

    public static List<yx4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (dg9.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    kja.h(advertAppInfo, 1, k);
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
            kja.h(advertAppInfo, 1, i);
        }
    }
}
