package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.df4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ne4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(ac4<T> ac4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ac4Var, t, str, str2)) == null) {
            if (t == null || ac4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, ac4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, ac4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, ac4<T> ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, ac4Var)) == null) {
            if (ac4Var == null || t == null) {
                return false;
            }
            if (t instanceof hd4) {
                hd4 hd4Var = (hd4) t;
                return a(ac4Var, t, hd4Var.l, hd4Var.n);
            } else if (!(t instanceof df4.a)) {
                return false;
            } else {
                id4 id4Var = ((df4.a) t).d;
                return a(ac4Var, t, id4Var.l, id4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static le4<ed4> c(ed4 ed4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ed4Var, ec4Var)) == null) {
            if (ec4Var == null || !b(ed4Var, ec4Var.r())) {
                return null;
            }
            return new le4<>(new ke4(ed4Var), ed4Var, new ie4(ec4Var.r()));
        }
        return (le4) invokeLL.objValue;
    }

    public static le4<gd4> d(gd4 gd4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gd4Var, ec4Var)) == null) {
            if (ec4Var == null || !b(gd4Var, ec4Var.s())) {
                return null;
            }
            return new le4<>(new ke4(gd4Var), gd4Var, new ie4(ec4Var.s()));
        }
        return (le4) invokeLL.objValue;
    }

    public static le4<id4> g(id4 id4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, id4Var, ec4Var)) == null) {
            if (ec4Var == null || !b(id4Var, ec4Var.u())) {
                return null;
            }
            return new le4<>(new ke4(id4Var), id4Var, new ie4(ec4Var.u()));
        }
        return (le4) invokeLL.objValue;
    }

    public static le4<kd4> i(kd4 kd4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, kd4Var, ec4Var)) == null) {
            if (ec4Var == null || !b(kd4Var, ec4Var.x())) {
                return null;
            }
            return new le4<>(new ke4(kd4Var), kd4Var, new ie4(ec4Var.x()));
        }
        return (le4) invokeLL.objValue;
    }

    public static le4<ld4> j(ld4 ld4Var, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ld4Var, ec4Var)) == null) {
            if (ec4Var == null || !b(ld4Var, ec4Var.z())) {
                return null;
            }
            return new le4<>(new ke4(ld4Var), ld4Var, new ie4(ec4Var.z()));
        }
        return (le4) invokeLL.objValue;
    }

    public static List<le4<kd4>> e(List<kd4> list, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, ec4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ec4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (kd4 kd4Var : list) {
                    if (b(kd4Var, ec4Var.q())) {
                        arrayList.add(new le4(new ke4(kd4Var), kd4Var, new ie4(ec4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<le4<df4.a>> f(List<df4.a> list, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, ec4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ec4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (df4.a aVar : list) {
                    id4 id4Var = aVar.d;
                    if (id4Var != null && b(aVar, ec4Var.v())) {
                        arrayList.add(new le4(new ke4(id4Var), aVar, new ie4(ec4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<le4<jd4>> h(List<jd4> list, ec4 ec4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ec4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ec4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (jd4 jd4Var : list) {
                    if (b(jd4Var, ec4Var.A())) {
                        arrayList.add(new le4(new ke4(jd4Var), jd4Var, new ie4(ec4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, ac4<T> ac4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, ac4Var) == null) {
            ac4Var.e(t, new dd4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
