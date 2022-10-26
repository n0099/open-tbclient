package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes5.dex */
public class pd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public final class a implements Comparator {
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
        public int compare(os4 os4Var, os4 os4Var2) {
            InterceptResult invokeLL;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, os4Var, os4Var2)) == null) {
                if (os4Var.e() && os4Var2.e()) {
                    return os4Var.i() - os4Var2.i();
                }
                int i = -1;
                if (!os4Var.e() && !os4Var2.e()) {
                    if (os4Var.p() == null) {
                        g = -1;
                    } else {
                        g = pd8.g(os4Var.p());
                    }
                    if (os4Var2.p() != null) {
                        i = pd8.g(os4Var2.p());
                    }
                    return g - i;
                } else if (os4Var.e()) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return invokeLL.intValue;
        }
    }

    public static Set a(List list, int i, String str) {
        InterceptResult invokeLIL;
        AdvertAppInfo p;
        AdvertAppInfo p2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, list, i, str)) == null) {
            HashSet hashSet = new HashSet();
            if (lh7.e(list)) {
                return hashSet;
            }
            Set<eo> a2 = wf8.a(str);
            if (a2 == null) {
                a2 = new HashSet();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar != null) {
                    for (eo eoVar2 : a2) {
                        if ((eoVar instanceof os4) && (p2 = ((os4) eoVar).p()) != null && eoVar2.hashCode() == p2.hashCode()) {
                            p2.i = ((AdvertAppInfo) eoVar2).i;
                        }
                    }
                    if ((eoVar instanceof os4) && (p = ((os4) eoVar).p()) != null && p.i == null) {
                        fr4 fr4Var = new fr4();
                        p.i = fr4Var;
                        fr4Var.a = str;
                        fr4Var.b = i;
                        fr4Var.g = p.g;
                        fr4Var.h = false;
                        hashSet.add(p);
                    }
                }
            }
            a2.addAll(hashSet);
            wf8.b(str, a2);
            return hashSet;
        }
        return (Set) invokeLIL.objValue;
    }

    public static List i(List list, List list2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, list, list2, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (lh7.e(list)) {
                return arrayList;
            }
            o(list);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                os4 os4Var = (os4) lh7.d(list, i4);
                if (os4Var != null && os4Var.p() != null) {
                    int i5 = lh7.i(list2);
                    int g = g(os4Var.p()) - 1;
                    if (g < 0) {
                        n(os4Var.p());
                    } else {
                        if (os4Var.e()) {
                            i2 = os4Var.i();
                        } else {
                            i2 = g + i;
                        }
                        if (i2 > i5) {
                            n(os4Var.p());
                        } else {
                            os4Var.setPosition(i2);
                            lh7.b(list2, os4Var, i2);
                            arrayList.add(os4Var);
                        }
                    }
                }
            }
            while (i < lh7.i(list2)) {
                eo eoVar = (eo) list2.get(i);
                if (eoVar instanceof os4) {
                    i3++;
                } else if (eoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) eoVar).position += i3;
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeLLI.objValue;
    }

    public static int b(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int i = 0;
            if (lh7.e(list)) {
                return 0;
            }
            int i2 = -1;
            for (int i3 = lh7.i(list) - 1; i3 >= 0 && !(lh7.d(list, i3) instanceof os4); i3--) {
                if (lh7.d(list, i3) instanceof du4) {
                    int i4 = ((du4) lh7.d(list, i3)).position;
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

    public static void c(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || lh7.e(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof os4) {
                it.remove();
            }
        }
    }

    public static String f(AdvertAppInfo advertAppInfo) {
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
            return eh.e(advertAppInfo.f, -1);
        }
        return invokeL.intValue;
    }

    public static boolean j(String str) {
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

    public static int k(AdvertAppInfo advertAppInfo) {
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

    public static void o(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, list) == null) {
            Collections.sort(list, new a());
        }
    }

    public static void p(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, list) == null) {
            for (int i = 0; i < lh7.i(list); i++) {
                if (lh7.d(list, i) instanceof os4) {
                    ((os4) lh7.d(list, i)).setPosition(i);
                }
            }
        }
    }

    public static void d(String str, List list) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, list) == null) && !TextUtils.isEmpty(str) && !lh7.e(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                boolean z = next instanceof os4;
                if (z || (next instanceof App)) {
                    if (next instanceof App) {
                        str2 = qd8.a((App) next);
                    } else {
                        if (z) {
                            os4 os4Var = (os4) next;
                            if (os4Var.p() != null) {
                                str2 = os4Var.p().a;
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
    }

    public static String e(List list, boolean z) {
        InterceptResult invokeLZ;
        os4 os4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, list, z)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!z && !lh7.e(list)) {
                int i = 0;
                for (int i2 = lh7.i(list) - 1; i2 >= 0 && i < 6; i2--) {
                    if ((lh7.d(list, i2) instanceof os4) && (os4Var = (os4) lh7.d(list, i2)) != null && !l(os4Var.p())) {
                        sb.append(os4Var.i() + 1);
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

    public static List h(List list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (lh7.e(list)) {
                return arrayList;
            }
            Log.e("frs", "src ad list size " + list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.s((App) it.next());
                advertAppInfo.j = str;
                int k = k(advertAppInfo);
                if (k != 0) {
                    yf8.h(advertAppInfo, 1, k);
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
            yf8.h(advertAppInfo, 1, i);
        }
    }
}
