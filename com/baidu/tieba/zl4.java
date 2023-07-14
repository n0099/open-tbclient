package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.pm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class zl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(mj4<T> mj4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, mj4Var, t, str, str2)) == null) {
            if (t == null || mj4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, mj4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, mj4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, mj4<T> mj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, mj4Var)) == null) {
            if (mj4Var == null || t == null) {
                return false;
            }
            if (t instanceof tk4) {
                tk4 tk4Var = (tk4) t;
                return a(mj4Var, t, tk4Var.l, tk4Var.n);
            } else if (!(t instanceof pm4.a)) {
                return false;
            } else {
                uk4 uk4Var = ((pm4.a) t).d;
                return a(mj4Var, t, uk4Var.l, uk4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static xl4<qk4> c(qk4 qk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, qk4Var, qj4Var)) == null) {
            if (qj4Var == null || !b(qk4Var, qj4Var.r())) {
                return null;
            }
            return new xl4<>(new wl4(qk4Var), qk4Var, new ul4(qj4Var.r()));
        }
        return (xl4) invokeLL.objValue;
    }

    public static xl4<sk4> d(sk4 sk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, sk4Var, qj4Var)) == null) {
            if (qj4Var == null || !b(sk4Var, qj4Var.s())) {
                return null;
            }
            return new xl4<>(new wl4(sk4Var), sk4Var, new ul4(qj4Var.s()));
        }
        return (xl4) invokeLL.objValue;
    }

    public static xl4<uk4> g(uk4 uk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, uk4Var, qj4Var)) == null) {
            if (qj4Var == null || !b(uk4Var, qj4Var.u())) {
                return null;
            }
            return new xl4<>(new wl4(uk4Var), uk4Var, new ul4(qj4Var.u()));
        }
        return (xl4) invokeLL.objValue;
    }

    public static xl4<wk4> i(wk4 wk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, wk4Var, qj4Var)) == null) {
            if (qj4Var == null || !b(wk4Var, qj4Var.x())) {
                return null;
            }
            return new xl4<>(new wl4(wk4Var), wk4Var, new ul4(qj4Var.x()));
        }
        return (xl4) invokeLL.objValue;
    }

    public static xl4<xk4> j(xk4 xk4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, xk4Var, qj4Var)) == null) {
            if (qj4Var == null || !b(xk4Var, qj4Var.z())) {
                return null;
            }
            return new xl4<>(new wl4(xk4Var), xk4Var, new ul4(qj4Var.z()));
        }
        return (xl4) invokeLL.objValue;
    }

    public static List<xl4<wk4>> e(List<wk4> list, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, qj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (wk4 wk4Var : list) {
                    if (b(wk4Var, qj4Var.q())) {
                        arrayList.add(new xl4(new wl4(wk4Var), wk4Var, new ul4(qj4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<xl4<pm4.a>> f(List<pm4.a> list, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, qj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (pm4.a aVar : list) {
                    uk4 uk4Var = aVar.d;
                    if (uk4Var != null && b(aVar, qj4Var.v())) {
                        arrayList.add(new xl4(new wl4(uk4Var), aVar, new ul4(qj4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<xl4<vk4>> h(List<vk4> list, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, qj4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (qj4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (vk4 vk4Var : list) {
                    if (b(vk4Var, qj4Var.A())) {
                        arrayList.add(new xl4(new wl4(vk4Var), vk4Var, new ul4(qj4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, mj4<T> mj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, mj4Var) == null) {
            mj4Var.e(t, new pk4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
