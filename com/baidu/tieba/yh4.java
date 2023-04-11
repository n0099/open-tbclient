package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.oi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class yh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(lf4<T> lf4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, lf4Var, t, str, str2)) == null) {
            if (t == null || lf4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, lf4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, lf4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, lf4<T> lf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, lf4Var)) == null) {
            if (lf4Var == null || t == null) {
                return false;
            }
            if (t instanceof sg4) {
                sg4 sg4Var = (sg4) t;
                return a(lf4Var, t, sg4Var.l, sg4Var.n);
            } else if (!(t instanceof oi4.a)) {
                return false;
            } else {
                tg4 tg4Var = ((oi4.a) t).d;
                return a(lf4Var, t, tg4Var.l, tg4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static wh4<pg4> c(pg4 pg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pg4Var, pf4Var)) == null) {
            if (pf4Var == null || !b(pg4Var, pf4Var.r())) {
                return null;
            }
            return new wh4<>(new vh4(pg4Var), pg4Var, new th4(pf4Var.r()));
        }
        return (wh4) invokeLL.objValue;
    }

    public static wh4<rg4> d(rg4 rg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, rg4Var, pf4Var)) == null) {
            if (pf4Var == null || !b(rg4Var, pf4Var.s())) {
                return null;
            }
            return new wh4<>(new vh4(rg4Var), rg4Var, new th4(pf4Var.s()));
        }
        return (wh4) invokeLL.objValue;
    }

    public static wh4<tg4> g(tg4 tg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, tg4Var, pf4Var)) == null) {
            if (pf4Var == null || !b(tg4Var, pf4Var.u())) {
                return null;
            }
            return new wh4<>(new vh4(tg4Var), tg4Var, new th4(pf4Var.u()));
        }
        return (wh4) invokeLL.objValue;
    }

    public static wh4<vg4> i(vg4 vg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, vg4Var, pf4Var)) == null) {
            if (pf4Var == null || !b(vg4Var, pf4Var.x())) {
                return null;
            }
            return new wh4<>(new vh4(vg4Var), vg4Var, new th4(pf4Var.x()));
        }
        return (wh4) invokeLL.objValue;
    }

    public static wh4<wg4> j(wg4 wg4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, wg4Var, pf4Var)) == null) {
            if (pf4Var == null || !b(wg4Var, pf4Var.z())) {
                return null;
            }
            return new wh4<>(new vh4(wg4Var), wg4Var, new th4(pf4Var.z()));
        }
        return (wh4) invokeLL.objValue;
    }

    public static List<wh4<vg4>> e(List<vg4> list, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, pf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (pf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (vg4 vg4Var : list) {
                    if (b(vg4Var, pf4Var.q())) {
                        arrayList.add(new wh4(new vh4(vg4Var), vg4Var, new th4(pf4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<wh4<oi4.a>> f(List<oi4.a> list, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, pf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (pf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (oi4.a aVar : list) {
                    tg4 tg4Var = aVar.d;
                    if (tg4Var != null && b(aVar, pf4Var.v())) {
                        arrayList.add(new wh4(new vh4(tg4Var), aVar, new th4(pf4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<wh4<ug4>> h(List<ug4> list, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, pf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (pf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ug4 ug4Var : list) {
                    if (b(ug4Var, pf4Var.A())) {
                        arrayList.add(new wh4(new vh4(ug4Var), ug4Var, new th4(pf4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, lf4<T> lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, lf4Var) == null) {
            lf4Var.e(t, new og4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
