package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.bm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ll4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(yi4<T> yi4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, yi4Var, t, str, str2)) == null) {
            if (t == null || yi4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, yi4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, yi4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, yi4<T> yi4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, yi4Var)) == null) {
            if (yi4Var == null || t == null) {
                return false;
            }
            if (t instanceof fk4) {
                fk4 fk4Var = (fk4) t;
                return a(yi4Var, t, fk4Var.l, fk4Var.n);
            } else if (!(t instanceof bm4.a)) {
                return false;
            } else {
                gk4 gk4Var = ((bm4.a) t).d;
                return a(yi4Var, t, gk4Var.l, gk4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static jl4<ck4> c(ck4 ck4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ck4Var, cj4Var)) == null) {
            if (cj4Var == null || !b(ck4Var, cj4Var.r())) {
                return null;
            }
            return new jl4<>(new il4(ck4Var), ck4Var, new gl4(cj4Var.r()));
        }
        return (jl4) invokeLL.objValue;
    }

    public static jl4<ek4> d(ek4 ek4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ek4Var, cj4Var)) == null) {
            if (cj4Var == null || !b(ek4Var, cj4Var.s())) {
                return null;
            }
            return new jl4<>(new il4(ek4Var), ek4Var, new gl4(cj4Var.s()));
        }
        return (jl4) invokeLL.objValue;
    }

    public static jl4<gk4> g(gk4 gk4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, gk4Var, cj4Var)) == null) {
            if (cj4Var == null || !b(gk4Var, cj4Var.u())) {
                return null;
            }
            return new jl4<>(new il4(gk4Var), gk4Var, new gl4(cj4Var.u()));
        }
        return (jl4) invokeLL.objValue;
    }

    public static jl4<ik4> i(ik4 ik4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, ik4Var, cj4Var)) == null) {
            if (cj4Var == null || !b(ik4Var, cj4Var.x())) {
                return null;
            }
            return new jl4<>(new il4(ik4Var), ik4Var, new gl4(cj4Var.x()));
        }
        return (jl4) invokeLL.objValue;
    }

    public static jl4<jk4> j(jk4 jk4Var, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jk4Var, cj4Var)) == null) {
            if (cj4Var == null || !b(jk4Var, cj4Var.z())) {
                return null;
            }
            return new jl4<>(new il4(jk4Var), jk4Var, new gl4(cj4Var.z()));
        }
        return (jl4) invokeLL.objValue;
    }

    public static List<jl4<ik4>> e(List<ik4> list, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, cj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ik4 ik4Var : list) {
                    if (b(ik4Var, cj4Var.q())) {
                        arrayList.add(new jl4(new il4(ik4Var), ik4Var, new gl4(cj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<jl4<bm4.a>> f(List<bm4.a> list, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, cj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (bm4.a aVar : list) {
                    gk4 gk4Var = aVar.d;
                    if (gk4Var != null && b(aVar, cj4Var.v())) {
                        arrayList.add(new jl4(new il4(gk4Var), aVar, new gl4(cj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<jl4<hk4>> h(List<hk4> list, cj4 cj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, cj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (hk4 hk4Var : list) {
                    if (b(hk4Var, cj4Var.A())) {
                        arrayList.add(new jl4(new il4(hk4Var), hk4Var, new gl4(cj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, yi4<T> yi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, yi4Var) == null) {
            yi4Var.e(t, new bk4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
