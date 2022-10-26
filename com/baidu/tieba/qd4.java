package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.ge4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class qd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(db4 db4Var, Object obj, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, db4Var, obj, str, str2)) == null) {
            if (obj == null || db4Var == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(obj, PackageTable.MD5, db4Var);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(obj, TTDownloadField.TT_DOWNLOAD_URL, db4Var);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean b(Object obj, db4 db4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, db4Var)) == null) {
            if (db4Var == null || obj == null) {
                return false;
            }
            if (obj instanceof kc4) {
                kc4 kc4Var = (kc4) obj;
                return a(db4Var, obj, kc4Var.l, kc4Var.n);
            } else if (!(obj instanceof ge4.a)) {
                return false;
            } else {
                lc4 lc4Var = ((ge4.a) obj).d;
                return a(db4Var, obj, lc4Var.l, lc4Var.n);
            }
        }
        return invokeLL.booleanValue;
    }

    public static od4 c(hc4 hc4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, hc4Var, hb4Var)) == null) {
            if (hb4Var == null || !b(hc4Var, hb4Var.r())) {
                return null;
            }
            return new od4(new nd4(hc4Var), hc4Var, new ld4(hb4Var.r()));
        }
        return (od4) invokeLL.objValue;
    }

    public static od4 d(jc4 jc4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jc4Var, hb4Var)) == null) {
            if (hb4Var == null || !b(jc4Var, hb4Var.s())) {
                return null;
            }
            return new od4(new nd4(jc4Var), jc4Var, new ld4(hb4Var.s()));
        }
        return (od4) invokeLL.objValue;
    }

    public static od4 g(lc4 lc4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, lc4Var, hb4Var)) == null) {
            if (hb4Var == null || !b(lc4Var, hb4Var.u())) {
                return null;
            }
            return new od4(new nd4(lc4Var), lc4Var, new ld4(hb4Var.u()));
        }
        return (od4) invokeLL.objValue;
    }

    public static od4 i(nc4 nc4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, nc4Var, hb4Var)) == null) {
            if (hb4Var == null || !b(nc4Var, hb4Var.x())) {
                return null;
            }
            return new od4(new nd4(nc4Var), nc4Var, new ld4(hb4Var.x()));
        }
        return (od4) invokeLL.objValue;
    }

    public static od4 j(oc4 oc4Var, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, oc4Var, hb4Var)) == null) {
            if (hb4Var == null || !b(oc4Var, hb4Var.z())) {
                return null;
            }
            return new od4(new nd4(oc4Var), oc4Var, new ld4(hb4Var.z()));
        }
        return (od4) invokeLL.objValue;
    }

    public static List e(List list, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, hb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    nc4 nc4Var = (nc4) it.next();
                    if (b(nc4Var, hb4Var.q())) {
                        arrayList.add(new od4(new nd4(nc4Var), nc4Var, new ld4(hb4Var.q())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List f(List list, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, hb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ge4.a aVar = (ge4.a) it.next();
                    lc4 lc4Var = aVar.d;
                    if (lc4Var != null && b(aVar, hb4Var.v())) {
                        arrayList.add(new od4(new nd4(lc4Var), aVar, new ld4(hb4Var.v())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List h(List list, hb4 hb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, hb4Var)) == null) {
            ArrayList arrayList = new ArrayList();
            if (hb4Var == null) {
                return arrayList;
            }
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    mc4 mc4Var = (mc4) it.next();
                    if (b(mc4Var, hb4Var.A())) {
                        arrayList.add(new od4(new nd4(mc4Var), mc4Var, new ld4(hb4Var.A())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void k(Object obj, String str, db4 db4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, obj, str, db4Var) == null) {
            db4Var.e(obj, new gc4(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
