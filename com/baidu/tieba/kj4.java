package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ak4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class kj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(xg4<T> xg4Var, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, xg4Var, t, str, str2)) == null) {
            if (t == null || xg4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, xg4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, xg4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, xg4<T> xg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, xg4Var)) == null) {
            if (xg4Var == null || t == null) {
                return false;
            }
            if (t instanceof ei4) {
                ei4 ei4Var = (ei4) t;
                return a(xg4Var, t, ei4Var.l, ei4Var.n);
            } else if (!(t instanceof ak4.a)) {
                return false;
            } else {
                fi4 fi4Var = ((ak4.a) t).d;
                return a(xg4Var, t, fi4Var.l, fi4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static ij4<bi4> c(bi4 bi4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bi4Var, bh4Var)) == null) {
            if (bh4Var == null || !b(bi4Var, bh4Var.r())) {
                return null;
            }
            return new ij4<>(new hj4(bi4Var), bi4Var, new fj4(bh4Var.r()));
        }
        return (ij4) invokeLL.objValue;
    }

    public static ij4<di4> d(di4 di4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, di4Var, bh4Var)) == null) {
            if (bh4Var == null || !b(di4Var, bh4Var.s())) {
                return null;
            }
            return new ij4<>(new hj4(di4Var), di4Var, new fj4(bh4Var.s()));
        }
        return (ij4) invokeLL.objValue;
    }

    public static ij4<fi4> g(fi4 fi4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, fi4Var, bh4Var)) == null) {
            if (bh4Var == null || !b(fi4Var, bh4Var.u())) {
                return null;
            }
            return new ij4<>(new hj4(fi4Var), fi4Var, new fj4(bh4Var.u()));
        }
        return (ij4) invokeLL.objValue;
    }

    public static ij4<hi4> i(hi4 hi4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, hi4Var, bh4Var)) == null) {
            if (bh4Var == null || !b(hi4Var, bh4Var.x())) {
                return null;
            }
            return new ij4<>(new hj4(hi4Var), hi4Var, new fj4(bh4Var.x()));
        }
        return (ij4) invokeLL.objValue;
    }

    public static ij4<ii4> j(ii4 ii4Var, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, ii4Var, bh4Var)) == null) {
            if (bh4Var == null || !b(ii4Var, bh4Var.z())) {
                return null;
            }
            return new ij4<>(new hj4(ii4Var), ii4Var, new fj4(bh4Var.z()));
        }
        return (ij4) invokeLL.objValue;
    }

    public static List<ij4<hi4>> e(List<hi4> list, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, bh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (hi4 hi4Var : list) {
                    if (b(hi4Var, bh4Var.q())) {
                        arrayList.add(new ij4(new hj4(hi4Var), hi4Var, new fj4(bh4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ij4<ak4.a>> f(List<ak4.a> list, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, bh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (ak4.a aVar : list) {
                    fi4 fi4Var = aVar.d;
                    if (fi4Var != null && b(aVar, bh4Var.v())) {
                        arrayList.add(new ij4(new hj4(fi4Var), aVar, new fj4(bh4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<ij4<gi4>> h(List<gi4> list, bh4 bh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, bh4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (bh4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                for (gi4 gi4Var : list) {
                    if (b(gi4Var, bh4Var.A())) {
                        arrayList.add(new ij4(new hj4(gi4Var), gi4Var, new fj4(bh4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, xg4<T> xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, xg4Var) == null) {
            xg4Var.e(t, new ai4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
