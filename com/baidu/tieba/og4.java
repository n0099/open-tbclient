package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.tieba.eh4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class og4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(be4<T> be4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, be4Var, t, str, str2)) == null) {
            if (t == null || be4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, "md5", be4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, "downloadUrl", be4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, be4<T> be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, be4Var)) == null) {
            if (be4Var == null || t == null) {
                return false;
            }
            if (t instanceof if4) {
                if4 if4Var = (if4) t;
                return a(be4Var, t, if4Var.l, if4Var.n);
            } else if (!(t instanceof eh4.a)) {
                return false;
            } else {
                jf4 jf4Var = ((eh4.a) t).d;
                return a(be4Var, t, jf4Var.l, jf4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static mg4<ff4> c(ff4 ff4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ff4Var, fe4Var)) == null) {
            if (fe4Var == null || !b(ff4Var, fe4Var.r())) {
                return null;
            }
            return new mg4<>(new lg4(ff4Var), ff4Var, new jg4(fe4Var.r()));
        }
        return (mg4) invokeLL.objValue;
    }

    public static mg4<hf4> d(hf4 hf4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hf4Var, fe4Var)) == null) {
            if (fe4Var == null || !b(hf4Var, fe4Var.s())) {
                return null;
            }
            return new mg4<>(new lg4(hf4Var), hf4Var, new jg4(fe4Var.s()));
        }
        return (mg4) invokeLL.objValue;
    }

    public static mg4<jf4> g(jf4 jf4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jf4Var, fe4Var)) == null) {
            if (fe4Var == null || !b(jf4Var, fe4Var.u())) {
                return null;
            }
            return new mg4<>(new lg4(jf4Var), jf4Var, new jg4(fe4Var.u()));
        }
        return (mg4) invokeLL.objValue;
    }

    public static mg4<lf4> i(lf4 lf4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, lf4Var, fe4Var)) == null) {
            if (fe4Var == null || !b(lf4Var, fe4Var.x())) {
                return null;
            }
            return new mg4<>(new lg4(lf4Var), lf4Var, new jg4(fe4Var.x()));
        }
        return (mg4) invokeLL.objValue;
    }

    public static mg4<mf4> j(mf4 mf4Var, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, mf4Var, fe4Var)) == null) {
            if (fe4Var == null || !b(mf4Var, fe4Var.z())) {
                return null;
            }
            return new mg4<>(new lg4(mf4Var), mf4Var, new jg4(fe4Var.z()));
        }
        return (mg4) invokeLL.objValue;
    }

    public static List<mg4<lf4>> e(List<lf4> list, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, fe4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (fe4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (lf4 lf4Var : list) {
                    if (b(lf4Var, fe4Var.q())) {
                        arrayList.add(new mg4(new lg4(lf4Var), lf4Var, new jg4(fe4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<mg4<eh4.a>> f(List<eh4.a> list, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, fe4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (fe4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (eh4.a aVar : list) {
                    jf4 jf4Var = aVar.d;
                    if (jf4Var != null && b(aVar, fe4Var.v())) {
                        arrayList.add(new mg4(new lg4(jf4Var), aVar, new jg4(fe4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<mg4<kf4>> h(List<kf4> list, fe4 fe4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, fe4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (fe4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (kf4 kf4Var : list) {
                    if (b(kf4Var, fe4Var.A())) {
                        arrayList.add(new mg4(new lg4(kf4Var), kf4Var, new jg4(fe4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, be4<T> be4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, be4Var) == null) {
            be4Var.e(t, new ef4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
