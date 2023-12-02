package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class yf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xf9 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof xf9)) {
                return null;
            }
            return (xf9) iLegoAdvert;
        }
        return (xf9) invokeL.objValue;
    }

    public static void b(xf9 xf9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, xf9Var) == null) && xf9Var != null && xf9Var.getParallelCharge() != null) {
            ez0.b(xf9Var.getParallelCharge().b);
            Iterator<String> it = xf9Var.getParallelCharge().c.iterator();
            while (it.hasNext()) {
                ez0.b(it.next());
            }
        }
    }

    public static void c(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, advertAppInfo) == null) && d(a(advertAppInfo))) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.EXCEPTION).k("1").l(DpStatConstants.FILECACHE_CLOSE_TYPE_OPT_DISABLE).p(advertAppInfo.g);
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.h;
            if (iLegoAdvert != null) {
                clogBuilder.m(String.valueOf(iLegoAdvert.getGoodsStyle()));
            }
            dz0.e(clogBuilder);
        }
    }

    public static boolean d(xf9 xf9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xf9Var)) == null) {
            if (xf9Var == null || xf9Var.getParallelCharge() == null) {
                return false;
            }
            String str = xf9Var.getParallelCharge().a;
            ez0.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator<String> it = xf9Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!z && TextUtils.isEmpty(next)) {
                    z = false;
                } else {
                    z = true;
                }
                ez0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
