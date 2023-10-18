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
public class wy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Comparator<bx4> {
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
        public int compare(bx4 bx4Var, bx4 bx4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bx4Var, bx4Var2)) == null) {
                if (bx4Var.k() && bx4Var2.k()) {
                    return bx4Var.n() - bx4Var2.n();
                }
                int i = -1;
                if (!bx4Var.k() && !bx4Var2.k()) {
                    if (bx4Var.B() == null) {
                        g = -1;
                    } else {
                        g = wy9.g(bx4Var.B());
                    }
                    if (bx4Var2.B() != null) {
                        i = wy9.g(bx4Var2.B());
                    }
                    return g - i;
                } else if (bx4Var.k()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<yh> a(List<yh> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (ez8.e(list)) {
                return hashSet;
            }
            Set<yh> a2 = g1a.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (yh yhVar : list) {
                if (yhVar != null) {
                    for (yh yhVar2 : a2) {
                        if ((yhVar instanceof bx4) && (B2 = ((bx4) yhVar).B()) != null && yhVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) yhVar2).i;
                        }
                    }
                    if ((yhVar instanceof bx4) && (B = ((bx4) yhVar).B()) != null && B.i == null) {
                        ov4 ov4Var = new ov4();
                        B.i = ov4Var;
                        ov4Var.a = str;
                        ov4Var.b = i;
                        ov4Var.g = B.g;
                        ov4Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            g1a.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<bx4> i(List<bx4> list, List<yh> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ez8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                bx4 bx4Var = (bx4) ez8.d(list, i4);
                if (bx4Var != null && bx4Var.B() != null) {
                    int i5 = ez8.i(list2);
                    int g = g(bx4Var.B()) - 1;
                    if (g < 0) {
                        n(bx4Var.B());
                    } else {
                        if (bx4Var.k()) {
                            i2 = bx4Var.n();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(bx4Var.B());
                        } else {
                            bx4Var.setPosition(i2);
                            ez8.b(list2, bx4Var, i2);
                            arrayList.add(bx4Var);
                        }
                    }
                }
            }
            while (i < ez8.i(list2)) {
                yh yhVar = list2.get(i);
                if (yhVar instanceof bx4) {
                    i3++;
                } else if (yhVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) yhVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (ez8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = ez8.i(list) - 1; i3 >= 0 && !(ez8.d(list, i3) instanceof bx4); i3--) {
                if (ez8.d(list, i3) instanceof py4) {
                    int i4 = ((py4) ez8.d(list, i3)).position;
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

    public static void c(List<yh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || ez8.e(list)) {
            return;
        }
        Iterator<yh> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof bx4) {
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

    public static void o(List<bx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < ez8.i(list); i++) {
                if (ez8.d(list, i) instanceof bx4) {
                    ((bx4) ez8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        nea neaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || ez8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof bx4)) {
                    if ((next instanceof py4) && (threadData = ((py4) next).t) != null && (neaVar = threadData.funAdData) != null) {
                        neaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof f16)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = xy9.a((App) next);
                } else {
                    if (next instanceof bx4) {
                        bx4 bx4Var = (bx4) next;
                        if (bx4Var.B() != null) {
                            str2 = bx4Var.B().a;
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

    public static String e(List<yh> list, boolean z) {
        InterceptResult invokeLZ;
        bx4 bx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !ez8.e(list)) {
                int i = 0;
                for (int i2 = ez8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((ez8.d(list, i2) instanceof bx4) && (bx4Var = (bx4) ez8.d(list, i2)) != null && !l(bx4Var.B())) {
                        sb.append(bx4Var.n() + 1);
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

    public static List<bx4> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ez8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    i1a.h(advertAppInfo, 1, k);
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
            i1a.h(advertAppInfo, 1, i);
        }
    }
}
