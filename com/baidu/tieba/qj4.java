package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.gk4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class qj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(dh4<T> dh4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, dh4Var, t, str, str2)) == null) {
            if (t == null || dh4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, dh4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, dh4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, dh4<T> dh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, dh4Var)) == null) {
            if (dh4Var == null || t == null) {
                return false;
            }
            if (t instanceof ki4) {
                ki4 ki4Var = (ki4) t;
                return a(dh4Var, t, ki4Var.l, ki4Var.n);
            } else if (!(t instanceof gk4.a)) {
                return false;
            } else {
                li4 li4Var = ((gk4.a) t).d;
                return a(dh4Var, t, li4Var.l, li4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static oj4<hi4> c(hi4 hi4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, hi4Var, hh4Var)) == null) {
            if (hh4Var == null || !b(hi4Var, hh4Var.r())) {
                return null;
            }
            return new oj4<>(new nj4(hi4Var), hi4Var, new lj4(hh4Var.r()));
        }
        return (oj4) invokeLL.objValue;
    }

    public static oj4<ji4> d(ji4 ji4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ji4Var, hh4Var)) == null) {
            if (hh4Var == null || !b(ji4Var, hh4Var.s())) {
                return null;
            }
            return new oj4<>(new nj4(ji4Var), ji4Var, new lj4(hh4Var.s()));
        }
        return (oj4) invokeLL.objValue;
    }

    public static oj4<li4> g(li4 li4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, li4Var, hh4Var)) == null) {
            if (hh4Var == null || !b(li4Var, hh4Var.u())) {
                return null;
            }
            return new oj4<>(new nj4(li4Var), li4Var, new lj4(hh4Var.u()));
        }
        return (oj4) invokeLL.objValue;
    }

    public static oj4<ni4> i(ni4 ni4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, ni4Var, hh4Var)) == null) {
            if (hh4Var == null || !b(ni4Var, hh4Var.x())) {
                return null;
            }
            return new oj4<>(new nj4(ni4Var), ni4Var, new lj4(hh4Var.x()));
        }
        return (oj4) invokeLL.objValue;
    }

    public static oj4<oi4> j(oi4 oi4Var, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, oi4Var, hh4Var)) == null) {
            if (hh4Var == null || !b(oi4Var, hh4Var.z())) {
                return null;
            }
            return new oj4<>(new nj4(oi4Var), oi4Var, new lj4(hh4Var.z()));
        }
        return (oj4) invokeLL.objValue;
    }

    public static List<oj4<ni4>> e(List<ni4> list, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, hh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ni4 ni4Var : list) {
                    if (b(ni4Var, hh4Var.q())) {
                        arrayList.add(new oj4(new nj4(ni4Var), ni4Var, new lj4(hh4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<oj4<gk4.a>> f(List<gk4.a> list, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, hh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (gk4.a aVar : list) {
                    li4 li4Var = aVar.d;
                    if (li4Var != null && b(aVar, hh4Var.v())) {
                        arrayList.add(new oj4(new nj4(li4Var), aVar, new lj4(hh4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<oj4<mi4>> h(List<mi4> list, hh4 hh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, hh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (mi4 mi4Var : list) {
                    if (b(mi4Var, hh4Var.A())) {
                        arrayList.add(new oj4(new nj4(mi4Var), mi4Var, new lj4(hh4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, dh4<T> dh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, dh4Var) == null) {
            dh4Var.e(t, new gi4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
