package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.am4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class kl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(xi4<T> xi4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, xi4Var, t, str, str2)) == null) {
            if (t == null || xi4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, xi4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, xi4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, xi4<T> xi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, xi4Var)) == null) {
            if (xi4Var == null || t == null) {
                return false;
            }
            if (t instanceof ek4) {
                ek4 ek4Var = (ek4) t;
                return a(xi4Var, t, ek4Var.l, ek4Var.n);
            } else if (!(t instanceof am4.a)) {
                return false;
            } else {
                fk4 fk4Var = ((am4.a) t).d;
                return a(xi4Var, t, fk4Var.l, fk4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static il4<bk4> c(bk4 bk4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bk4Var, bj4Var)) == null) {
            if (bj4Var == null || !b(bk4Var, bj4Var.r())) {
                return null;
            }
            return new il4<>(new hl4(bk4Var), bk4Var, new fl4(bj4Var.r()));
        }
        return (il4) invokeLL.objValue;
    }

    public static il4<dk4> d(dk4 dk4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dk4Var, bj4Var)) == null) {
            if (bj4Var == null || !b(dk4Var, bj4Var.s())) {
                return null;
            }
            return new il4<>(new hl4(dk4Var), dk4Var, new fl4(bj4Var.s()));
        }
        return (il4) invokeLL.objValue;
    }

    public static il4<fk4> g(fk4 fk4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, fk4Var, bj4Var)) == null) {
            if (bj4Var == null || !b(fk4Var, bj4Var.u())) {
                return null;
            }
            return new il4<>(new hl4(fk4Var), fk4Var, new fl4(bj4Var.u()));
        }
        return (il4) invokeLL.objValue;
    }

    public static il4<hk4> i(hk4 hk4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, hk4Var, bj4Var)) == null) {
            if (bj4Var == null || !b(hk4Var, bj4Var.x())) {
                return null;
            }
            return new il4<>(new hl4(hk4Var), hk4Var, new fl4(bj4Var.x()));
        }
        return (il4) invokeLL.objValue;
    }

    public static il4<ik4> j(ik4 ik4Var, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ik4Var, bj4Var)) == null) {
            if (bj4Var == null || !b(ik4Var, bj4Var.z())) {
                return null;
            }
            return new il4<>(new hl4(ik4Var), ik4Var, new fl4(bj4Var.z()));
        }
        return (il4) invokeLL.objValue;
    }

    public static List<il4<hk4>> e(List<hk4> list, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, bj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (hk4 hk4Var : list) {
                    if (b(hk4Var, bj4Var.q())) {
                        arrayList.add(new il4(new hl4(hk4Var), hk4Var, new fl4(bj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<il4<am4.a>> f(List<am4.a> list, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, bj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (am4.a aVar : list) {
                    fk4 fk4Var = aVar.d;
                    if (fk4Var != null && b(aVar, bj4Var.v())) {
                        arrayList.add(new il4(new hl4(fk4Var), aVar, new fl4(bj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<il4<gk4>> h(List<gk4> list, bj4 bj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, bj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (gk4 gk4Var : list) {
                    if (b(gk4Var, bj4Var.A())) {
                        arrayList.add(new il4(new hl4(gk4Var), gk4Var, new fl4(bj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, xi4<T> xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, xi4Var) == null) {
            xi4Var.e(t, new ak4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
