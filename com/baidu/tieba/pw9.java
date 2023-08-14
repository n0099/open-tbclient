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
/* loaded from: classes7.dex */
public class pw9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Comparator<i25> {
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
        public int compare(i25 i25Var, i25 i25Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, i25Var, i25Var2)) == null) {
                if (i25Var.k() && i25Var2.k()) {
                    return i25Var.p() - i25Var2.p();
                }
                int i = -1;
                if (!i25Var.k() && !i25Var2.k()) {
                    if (i25Var.B() == null) {
                        g = -1;
                    } else {
                        g = pw9.g(i25Var.B());
                    }
                    if (i25Var2.B() != null) {
                        i = pw9.g(i25Var2.B());
                    }
                    return g - i;
                } else if (i25Var.k()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set<ym> a(List<ym> list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo B;
        AdvertAppInfo B2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (dy8.e(list)) {
                return hashSet;
            }
            Set<ym> a2 = zy9.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            for (ym ymVar : list) {
                if (ymVar != null) {
                    for (ym ymVar2 : a2) {
                        if ((ymVar instanceof i25) && (B2 = ((i25) ymVar).B()) != null && ymVar2.hashCode() == B2.hashCode()) {
                            B2.i = ((AdvertAppInfo) ymVar2).i;
                        }
                    }
                    if ((ymVar instanceof i25) && (B = ((i25) ymVar).B()) != null && B.i == null) {
                        v05 v05Var = new v05();
                        B.i = v05Var;
                        v05Var.a = str;
                        v05Var.b = i;
                        v05Var.g = B.g;
                        v05Var.h = false;
                        hashSet.add(B);
                    }
                }
            }
            a2.addAll(hashSet);
            zy9.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List<i25> i(List<i25> list, List<ym> list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (dy8.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i25 i25Var = (i25) dy8.d(list, i4);
                if (i25Var != null && i25Var.B() != null) {
                    int i5 = dy8.i(list2);
                    int g = g(i25Var.B()) - 1;
                    if (g < 0) {
                        n(i25Var.B());
                    } else {
                        if (i25Var.k()) {
                            i2 = i25Var.p();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(i25Var.B());
                        } else {
                            i25Var.setPosition(i2);
                            dy8.b(list2, i25Var, i2);
                            arrayList.add(i25Var);
                        }
                    }
                }
            }
            while (i < dy8.i(list2)) {
                ym ymVar = list2.get(i);
                if (ymVar instanceof i25) {
                    i3++;
                } else if (ymVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) ymVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(@NonNull List<ym> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (dy8.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = dy8.i(list) - 1; i3 >= 0 && !(dy8.d(list, i3) instanceof i25); i3--) {
                if (dy8.d(list, i3) instanceof w35) {
                    int i4 = ((w35) dy8.d(list, i3)).position;
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

    public static void c(List<ym> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || dy8.e(list)) {
            return;
        }
        Iterator<ym> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof i25) {
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

    public static void o(List<i25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < dy8.i(list); i++) {
                if (dy8.d(list, i) instanceof i25) {
                    ((i25) dy8.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        ThreadData threadData;
        pba pbaVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, str, list) != null) || dy8.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            i++;
            Object next = it.next();
            if (StringUtils.isNull(str)) {
                if (!(next instanceof App) && !(next instanceof i25)) {
                    if ((next instanceof w35) && (threadData = ((w35) next).t) != null && (pbaVar = threadData.funAdData) != null) {
                        pbaVar.p(true);
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            } else {
                if (i2 + 1 == i && (next instanceof i56)) {
                    it.remove();
                }
                if (next instanceof App) {
                    str2 = qw9.a((App) next);
                } else {
                    if (next instanceof i25) {
                        i25 i25Var = (i25) next;
                        if (i25Var.B() != null) {
                            str2 = i25Var.B().a;
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

    public static String e(List<ym> list, boolean z) {
        InterceptResult invokeLZ;
        i25 i25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !dy8.e(list)) {
                int i = 0;
                for (int i2 = dy8.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((dy8.d(list, i2) instanceof i25) && (i25Var = (i25) dy8.d(list, i2)) != null && !l(i25Var.B())) {
                        sb.append(i25Var.p() + 1);
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

    public static List<i25> h(List<App> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (dy8.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            for (App app : list) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    bz9.h(advertAppInfo, 1, k);
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
            bz9.h(advertAppInfo, 1, i);
        }
    }
}
