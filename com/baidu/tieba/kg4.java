package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ah4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class kg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(xd4<T> xd4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, xd4Var, t, str, str2)) == null) {
            if (t == null || xd4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, xd4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, "downloadUrl", xd4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, xd4<T> xd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, xd4Var)) == null) {
            if (xd4Var == null || t == null) {
                return false;
            }
            if (t instanceof ef4) {
                ef4 ef4Var = (ef4) t;
                return a(xd4Var, t, ef4Var.l, ef4Var.n);
            } else if (!(t instanceof ah4.a)) {
                return false;
            } else {
                ff4 ff4Var = ((ah4.a) t).d;
                return a(xd4Var, t, ff4Var.l, ff4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static ig4<bf4> c(bf4 bf4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bf4Var, be4Var)) == null) {
            if (be4Var == null || !b(bf4Var, be4Var.r())) {
                return null;
            }
            return new ig4<>(new hg4(bf4Var), bf4Var, new fg4(be4Var.r()));
        }
        return (ig4) invokeLL.objValue;
    }

    public static ig4<df4> d(df4 df4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, df4Var, be4Var)) == null) {
            if (be4Var == null || !b(df4Var, be4Var.s())) {
                return null;
            }
            return new ig4<>(new hg4(df4Var), df4Var, new fg4(be4Var.s()));
        }
        return (ig4) invokeLL.objValue;
    }

    public static ig4<ff4> g(ff4 ff4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, ff4Var, be4Var)) == null) {
            if (be4Var == null || !b(ff4Var, be4Var.u())) {
                return null;
            }
            return new ig4<>(new hg4(ff4Var), ff4Var, new fg4(be4Var.u()));
        }
        return (ig4) invokeLL.objValue;
    }

    public static ig4<hf4> i(hf4 hf4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, hf4Var, be4Var)) == null) {
            if (be4Var == null || !b(hf4Var, be4Var.x())) {
                return null;
            }
            return new ig4<>(new hg4(hf4Var), hf4Var, new fg4(be4Var.x()));
        }
        return (ig4) invokeLL.objValue;
    }

    public static ig4<if4> j(if4 if4Var, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, if4Var, be4Var)) == null) {
            if (be4Var == null || !b(if4Var, be4Var.z())) {
                return null;
            }
            return new ig4<>(new hg4(if4Var), if4Var, new fg4(be4Var.z()));
        }
        return (ig4) invokeLL.objValue;
    }

    public static List<ig4<hf4>> e(List<hf4> list, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, be4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (be4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (hf4 hf4Var : list) {
                    if (b(hf4Var, be4Var.q())) {
                        arrayList.add(new ig4(new hg4(hf4Var), hf4Var, new fg4(be4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ig4<ah4.a>> f(List<ah4.a> list, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, be4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (be4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ah4.a aVar : list) {
                    ff4 ff4Var = aVar.d;
                    if (ff4Var != null && b(aVar, be4Var.v())) {
                        arrayList.add(new ig4(new hg4(ff4Var), aVar, new fg4(be4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ig4<gf4>> h(List<gf4> list, be4 be4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, be4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (be4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (gf4 gf4Var : list) {
                    if (b(gf4Var, be4Var.A())) {
                        arrayList.add(new ig4(new hg4(gf4Var), gf4Var, new fg4(be4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, xd4<T> xd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, xd4Var) == null) {
            xd4Var.e(t, new af4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
