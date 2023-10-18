package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.jg4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(gd4<T> gd4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, gd4Var, t, str, str2)) == null) {
            if (t == null || gd4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, gd4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, "downloadUrl", gd4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, gd4<T> gd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, gd4Var)) == null) {
            if (gd4Var == null || t == null) {
                return false;
            }
            if (t instanceof ne4) {
                ne4 ne4Var = (ne4) t;
                return a(gd4Var, t, ne4Var.l, ne4Var.n);
            } else if (!(t instanceof jg4.a)) {
                return false;
            } else {
                oe4 oe4Var = ((jg4.a) t).d;
                return a(gd4Var, t, oe4Var.l, oe4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static rf4<ke4> c(ke4 ke4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ke4Var, kd4Var)) == null) {
            if (kd4Var == null || !b(ke4Var, kd4Var.r())) {
                return null;
            }
            return new rf4<>(new qf4(ke4Var), ke4Var, new of4(kd4Var.r()));
        }
        return (rf4) invokeLL.objValue;
    }

    public static rf4<me4> d(me4 me4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, me4Var, kd4Var)) == null) {
            if (kd4Var == null || !b(me4Var, kd4Var.s())) {
                return null;
            }
            return new rf4<>(new qf4(me4Var), me4Var, new of4(kd4Var.s()));
        }
        return (rf4) invokeLL.objValue;
    }

    public static rf4<oe4> g(oe4 oe4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, oe4Var, kd4Var)) == null) {
            if (kd4Var == null || !b(oe4Var, kd4Var.u())) {
                return null;
            }
            return new rf4<>(new qf4(oe4Var), oe4Var, new of4(kd4Var.u()));
        }
        return (rf4) invokeLL.objValue;
    }

    public static rf4<qe4> i(qe4 qe4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, qe4Var, kd4Var)) == null) {
            if (kd4Var == null || !b(qe4Var, kd4Var.x())) {
                return null;
            }
            return new rf4<>(new qf4(qe4Var), qe4Var, new of4(kd4Var.x()));
        }
        return (rf4) invokeLL.objValue;
    }

    public static rf4<re4> j(re4 re4Var, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, re4Var, kd4Var)) == null) {
            if (kd4Var == null || !b(re4Var, kd4Var.z())) {
                return null;
            }
            return new rf4<>(new qf4(re4Var), re4Var, new of4(kd4Var.z()));
        }
        return (rf4) invokeLL.objValue;
    }

    public static List<rf4<qe4>> e(List<qe4> list, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, kd4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (kd4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (qe4 qe4Var : list) {
                    if (b(qe4Var, kd4Var.q())) {
                        arrayList.add(new rf4(new qf4(qe4Var), qe4Var, new of4(kd4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<rf4<jg4.a>> f(List<jg4.a> list, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, kd4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (kd4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (jg4.a aVar : list) {
                    oe4 oe4Var = aVar.d;
                    if (oe4Var != null && b(aVar, kd4Var.v())) {
                        arrayList.add(new rf4(new qf4(oe4Var), aVar, new of4(kd4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<rf4<pe4>> h(List<pe4> list, kd4 kd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, kd4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (kd4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (pe4 pe4Var : list) {
                    if (b(pe4Var, kd4Var.A())) {
                        arrayList.add(new rf4(new qf4(pe4Var), pe4Var, new of4(kd4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, gd4<T> gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, gd4Var) == null) {
            gd4Var.e(t, new je4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
