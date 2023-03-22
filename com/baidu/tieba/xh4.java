package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ni4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class xh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(kf4<T> kf4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, kf4Var, t, str, str2)) == null) {
            if (t == null || kf4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, kf4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, kf4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, kf4<T> kf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, kf4Var)) == null) {
            if (kf4Var == null || t == null) {
                return false;
            }
            if (t instanceof rg4) {
                rg4 rg4Var = (rg4) t;
                return a(kf4Var, t, rg4Var.l, rg4Var.n);
            } else if (!(t instanceof ni4.a)) {
                return false;
            } else {
                sg4 sg4Var = ((ni4.a) t).d;
                return a(kf4Var, t, sg4Var.l, sg4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static vh4<og4> c(og4 og4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, og4Var, of4Var)) == null) {
            if (of4Var == null || !b(og4Var, of4Var.r())) {
                return null;
            }
            return new vh4<>(new uh4(og4Var), og4Var, new sh4(of4Var.r()));
        }
        return (vh4) invokeLL.objValue;
    }

    public static vh4<qg4> d(qg4 qg4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, qg4Var, of4Var)) == null) {
            if (of4Var == null || !b(qg4Var, of4Var.s())) {
                return null;
            }
            return new vh4<>(new uh4(qg4Var), qg4Var, new sh4(of4Var.s()));
        }
        return (vh4) invokeLL.objValue;
    }

    public static vh4<sg4> g(sg4 sg4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, sg4Var, of4Var)) == null) {
            if (of4Var == null || !b(sg4Var, of4Var.u())) {
                return null;
            }
            return new vh4<>(new uh4(sg4Var), sg4Var, new sh4(of4Var.u()));
        }
        return (vh4) invokeLL.objValue;
    }

    public static vh4<ug4> i(ug4 ug4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, ug4Var, of4Var)) == null) {
            if (of4Var == null || !b(ug4Var, of4Var.x())) {
                return null;
            }
            return new vh4<>(new uh4(ug4Var), ug4Var, new sh4(of4Var.x()));
        }
        return (vh4) invokeLL.objValue;
    }

    public static vh4<vg4> j(vg4 vg4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, vg4Var, of4Var)) == null) {
            if (of4Var == null || !b(vg4Var, of4Var.z())) {
                return null;
            }
            return new vh4<>(new uh4(vg4Var), vg4Var, new sh4(of4Var.z()));
        }
        return (vh4) invokeLL.objValue;
    }

    public static List<vh4<ug4>> e(List<ug4> list, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, of4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (of4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ug4 ug4Var : list) {
                    if (b(ug4Var, of4Var.q())) {
                        arrayList.add(new vh4(new uh4(ug4Var), ug4Var, new sh4(of4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<vh4<ni4.a>> f(List<ni4.a> list, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, of4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (of4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ni4.a aVar : list) {
                    sg4 sg4Var = aVar.d;
                    if (sg4Var != null && b(aVar, of4Var.v())) {
                        arrayList.add(new vh4(new uh4(sg4Var), aVar, new sh4(of4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<vh4<tg4>> h(List<tg4> list, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, of4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (of4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (tg4 tg4Var : list) {
                    if (b(tg4Var, of4Var.A())) {
                        arrayList.add(new vh4(new uh4(tg4Var), tg4Var, new sh4(of4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, kf4<T> kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, kf4Var) == null) {
            kf4Var.e(t, new ng4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
