package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ze4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class je4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(wb4<T> wb4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, wb4Var, t, str, str2)) == null) {
            if (t == null || wb4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, wb4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, wb4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, wb4<T> wb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, wb4Var)) == null) {
            if (wb4Var == null || t == null) {
                return false;
            }
            if (t instanceof dd4) {
                dd4 dd4Var = (dd4) t;
                return a(wb4Var, t, dd4Var.l, dd4Var.n);
            } else if (!(t instanceof ze4.a)) {
                return false;
            } else {
                ed4 ed4Var = ((ze4.a) t).d;
                return a(wb4Var, t, ed4Var.l, ed4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static he4<ad4> c(ad4 ad4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ad4Var, ac4Var)) == null) {
            if (ac4Var == null || !b(ad4Var, ac4Var.r())) {
                return null;
            }
            return new he4<>(new ge4(ad4Var), ad4Var, new ee4(ac4Var.r()));
        }
        return (he4) invokeLL.objValue;
    }

    public static he4<cd4> d(cd4 cd4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cd4Var, ac4Var)) == null) {
            if (ac4Var == null || !b(cd4Var, ac4Var.s())) {
                return null;
            }
            return new he4<>(new ge4(cd4Var), cd4Var, new ee4(ac4Var.s()));
        }
        return (he4) invokeLL.objValue;
    }

    public static he4<ed4> g(ed4 ed4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, ed4Var, ac4Var)) == null) {
            if (ac4Var == null || !b(ed4Var, ac4Var.u())) {
                return null;
            }
            return new he4<>(new ge4(ed4Var), ed4Var, new ee4(ac4Var.u()));
        }
        return (he4) invokeLL.objValue;
    }

    public static he4<gd4> i(gd4 gd4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, gd4Var, ac4Var)) == null) {
            if (ac4Var == null || !b(gd4Var, ac4Var.x())) {
                return null;
            }
            return new he4<>(new ge4(gd4Var), gd4Var, new ee4(ac4Var.x()));
        }
        return (he4) invokeLL.objValue;
    }

    public static he4<hd4> j(hd4 hd4Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, hd4Var, ac4Var)) == null) {
            if (ac4Var == null || !b(hd4Var, ac4Var.z())) {
                return null;
            }
            return new he4<>(new ge4(hd4Var), hd4Var, new ee4(ac4Var.z()));
        }
        return (he4) invokeLL.objValue;
    }

    public static List<he4<gd4>> e(List<gd4> list, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, ac4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ac4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (gd4 gd4Var : list) {
                    if (b(gd4Var, ac4Var.q())) {
                        arrayList.add(new he4(new ge4(gd4Var), gd4Var, new ee4(ac4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<he4<ze4.a>> f(List<ze4.a> list, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, ac4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ac4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ze4.a aVar : list) {
                    ed4 ed4Var = aVar.d;
                    if (ed4Var != null && b(aVar, ac4Var.v())) {
                        arrayList.add(new he4(new ge4(ed4Var), aVar, new ee4(ac4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<he4<fd4>> h(List<fd4> list, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, ac4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ac4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (fd4 fd4Var : list) {
                    if (b(fd4Var, ac4Var.A())) {
                        arrayList.add(new he4(new ge4(fd4Var), fd4Var, new ee4(ac4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, wb4<T> wb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, wb4Var) == null) {
            wb4Var.e(t, new zc4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
