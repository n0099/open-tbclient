package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.pi4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(mf4<T> mf4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, mf4Var, t, str, str2)) == null) {
            if (t == null || mf4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, mf4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, mf4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, mf4<T> mf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, mf4Var)) == null) {
            if (mf4Var == null || t == null) {
                return false;
            }
            if (t instanceof tg4) {
                tg4 tg4Var = (tg4) t;
                return a(mf4Var, t, tg4Var.l, tg4Var.n);
            } else if (!(t instanceof pi4.a)) {
                return false;
            } else {
                ug4 ug4Var = ((pi4.a) t).d;
                return a(mf4Var, t, ug4Var.l, ug4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static xh4<qg4> c(qg4 qg4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, qg4Var, qf4Var)) == null) {
            if (qf4Var == null || !b(qg4Var, qf4Var.r())) {
                return null;
            }
            return new xh4<>(new wh4(qg4Var), qg4Var, new uh4(qf4Var.r()));
        }
        return (xh4) invokeLL.objValue;
    }

    public static xh4<sg4> d(sg4 sg4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sg4Var, qf4Var)) == null) {
            if (qf4Var == null || !b(sg4Var, qf4Var.s())) {
                return null;
            }
            return new xh4<>(new wh4(sg4Var), sg4Var, new uh4(qf4Var.s()));
        }
        return (xh4) invokeLL.objValue;
    }

    public static xh4<ug4> g(ug4 ug4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, ug4Var, qf4Var)) == null) {
            if (qf4Var == null || !b(ug4Var, qf4Var.u())) {
                return null;
            }
            return new xh4<>(new wh4(ug4Var), ug4Var, new uh4(qf4Var.u()));
        }
        return (xh4) invokeLL.objValue;
    }

    public static xh4<wg4> i(wg4 wg4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, wg4Var, qf4Var)) == null) {
            if (qf4Var == null || !b(wg4Var, qf4Var.x())) {
                return null;
            }
            return new xh4<>(new wh4(wg4Var), wg4Var, new uh4(qf4Var.x()));
        }
        return (xh4) invokeLL.objValue;
    }

    public static xh4<xg4> j(xg4 xg4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, xg4Var, qf4Var)) == null) {
            if (qf4Var == null || !b(xg4Var, qf4Var.z())) {
                return null;
            }
            return new xh4<>(new wh4(xg4Var), xg4Var, new uh4(qf4Var.z()));
        }
        return (xh4) invokeLL.objValue;
    }

    public static List<xh4<wg4>> e(List<wg4> list, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, qf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (wg4 wg4Var : list) {
                    if (b(wg4Var, qf4Var.q())) {
                        arrayList.add(new xh4(new wh4(wg4Var), wg4Var, new uh4(qf4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<xh4<pi4.a>> f(List<pi4.a> list, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, qf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (pi4.a aVar : list) {
                    ug4 ug4Var = aVar.d;
                    if (ug4Var != null && b(aVar, qf4Var.v())) {
                        arrayList.add(new xh4(new wh4(ug4Var), aVar, new uh4(qf4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<xh4<vg4>> h(List<vg4> list, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, qf4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qf4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (vg4 vg4Var : list) {
                    if (b(vg4Var, qf4Var.A())) {
                        arrayList.add(new xh4(new wh4(vg4Var), vg4Var, new uh4(qf4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, mf4<T> mf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, mf4Var) == null) {
            mf4Var.e(t, new pg4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
