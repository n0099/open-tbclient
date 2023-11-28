package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.tieba.bh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class lg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(yd4<T> yd4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, yd4Var, t, str, str2)) == null) {
            if (t == null || yd4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, "md5", yd4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, "downloadUrl", yd4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, yd4<T> yd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, yd4Var)) == null) {
            if (yd4Var == null || t == null) {
                return false;
            }
            if (t instanceof ff4) {
                ff4 ff4Var = (ff4) t;
                return a(yd4Var, t, ff4Var.l, ff4Var.n);
            } else if (!(t instanceof bh4.a)) {
                return false;
            } else {
                gf4 gf4Var = ((bh4.a) t).d;
                return a(yd4Var, t, gf4Var.l, gf4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static jg4<cf4> c(cf4 cf4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cf4Var, ce4Var)) == null) {
            if (ce4Var == null || !b(cf4Var, ce4Var.r())) {
                return null;
            }
            return new jg4<>(new ig4(cf4Var), cf4Var, new gg4(ce4Var.r()));
        }
        return (jg4) invokeLL.objValue;
    }

    public static jg4<ef4> d(ef4 ef4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ef4Var, ce4Var)) == null) {
            if (ce4Var == null || !b(ef4Var, ce4Var.s())) {
                return null;
            }
            return new jg4<>(new ig4(ef4Var), ef4Var, new gg4(ce4Var.s()));
        }
        return (jg4) invokeLL.objValue;
    }

    public static jg4<gf4> g(gf4 gf4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, gf4Var, ce4Var)) == null) {
            if (ce4Var == null || !b(gf4Var, ce4Var.u())) {
                return null;
            }
            return new jg4<>(new ig4(gf4Var), gf4Var, new gg4(ce4Var.u()));
        }
        return (jg4) invokeLL.objValue;
    }

    public static jg4<if4> i(if4 if4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, if4Var, ce4Var)) == null) {
            if (ce4Var == null || !b(if4Var, ce4Var.x())) {
                return null;
            }
            return new jg4<>(new ig4(if4Var), if4Var, new gg4(ce4Var.x()));
        }
        return (jg4) invokeLL.objValue;
    }

    public static jg4<jf4> j(jf4 jf4Var, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jf4Var, ce4Var)) == null) {
            if (ce4Var == null || !b(jf4Var, ce4Var.z())) {
                return null;
            }
            return new jg4<>(new ig4(jf4Var), jf4Var, new gg4(ce4Var.z()));
        }
        return (jg4) invokeLL.objValue;
    }

    public static List<jg4<if4>> e(List<if4> list, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, ce4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ce4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (if4 if4Var : list) {
                    if (b(if4Var, ce4Var.q())) {
                        arrayList.add(new jg4(new ig4(if4Var), if4Var, new gg4(ce4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<jg4<bh4.a>> f(List<bh4.a> list, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, ce4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ce4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (bh4.a aVar : list) {
                    gf4 gf4Var = aVar.d;
                    if (gf4Var != null && b(aVar, ce4Var.v())) {
                        arrayList.add(new jg4(new ig4(gf4Var), aVar, new gg4(ce4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<jg4<hf4>> h(List<hf4> list, ce4 ce4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ce4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ce4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (hf4 hf4Var : list) {
                    if (b(hf4Var, ce4Var.A())) {
                        arrayList.add(new jg4(new ig4(hf4Var), hf4Var, new gg4(ce4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, yd4<T> yd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, yd4Var) == null) {
            yd4Var.e(t, new bf4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
