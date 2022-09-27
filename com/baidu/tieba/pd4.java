package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.fe4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class pd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(cb4<T> cb4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, cb4Var, t, str, str2)) == null) {
            if (t == null || cb4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, cb4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, cb4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, cb4<T> cb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, cb4Var)) == null) {
            if (cb4Var == null || t == null) {
                return false;
            }
            if (t instanceof jc4) {
                jc4 jc4Var = (jc4) t;
                return a(cb4Var, t, jc4Var.l, jc4Var.n);
            } else if (t instanceof fe4.a) {
                kc4 kc4Var = ((fe4.a) t).d;
                return a(cb4Var, t, kc4Var.l, kc4Var.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static nd4<gc4> c(gc4 gc4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gc4Var, gb4Var)) == null) {
            if (gb4Var != null && b(gc4Var, gb4Var.r())) {
                return new nd4<>(new md4(gc4Var), gc4Var, new kd4(gb4Var.r()));
            }
            return null;
        }
        return (nd4) invokeLL.objValue;
    }

    public static nd4<ic4> d(ic4 ic4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ic4Var, gb4Var)) == null) {
            if (gb4Var != null && b(ic4Var, gb4Var.s())) {
                return new nd4<>(new md4(ic4Var), ic4Var, new kd4(gb4Var.s()));
            }
            return null;
        }
        return (nd4) invokeLL.objValue;
    }

    public static List<nd4<mc4>> e(List<mc4> list, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, gb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gb4Var != null && list != null && list.size() > 0) {
                for (mc4 mc4Var : list) {
                    if (b(mc4Var, gb4Var.q())) {
                        arrayList.add(new nd4(new md4(mc4Var), mc4Var, new kd4(gb4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<nd4<fe4.a>> f(List<fe4.a> list, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, gb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gb4Var != null && list != null && list.size() > 0) {
                for (fe4.a aVar : list) {
                    kc4 kc4Var = aVar.d;
                    if (kc4Var != null && b(aVar, gb4Var.v())) {
                        arrayList.add(new nd4(new md4(kc4Var), aVar, new kd4(gb4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static nd4<kc4> g(kc4 kc4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, kc4Var, gb4Var)) == null) {
            if (gb4Var != null && b(kc4Var, gb4Var.u())) {
                return new nd4<>(new md4(kc4Var), kc4Var, new kd4(gb4Var.u()));
            }
            return null;
        }
        return (nd4) invokeLL.objValue;
    }

    public static List<nd4<lc4>> h(List<lc4> list, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, gb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gb4Var != null && list != null && list.size() > 0) {
                for (lc4 lc4Var : list) {
                    if (b(lc4Var, gb4Var.A())) {
                        arrayList.add(new nd4(new md4(lc4Var), lc4Var, new kd4(gb4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static nd4<mc4> i(mc4 mc4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, mc4Var, gb4Var)) == null) {
            if (gb4Var != null && b(mc4Var, gb4Var.x())) {
                return new nd4<>(new md4(mc4Var), mc4Var, new kd4(gb4Var.x()));
            }
            return null;
        }
        return (nd4) invokeLL.objValue;
    }

    public static nd4<nc4> j(nc4 nc4Var, gb4 gb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, nc4Var, gb4Var)) == null) {
            if (gb4Var != null && b(nc4Var, gb4Var.z())) {
                return new nd4<>(new md4(nc4Var), nc4Var, new kd4(gb4Var.z()));
            }
            return null;
        }
        return (nd4) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, cb4<T> cb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, cb4Var) == null) {
            cb4Var.e(t, new fc4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
