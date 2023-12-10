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
public class zf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yf9 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof yf9)) {
                return null;
            }
            return (yf9) iLegoAdvert;
        }
        return (yf9) invokeL.objValue;
    }

    public static void b(yf9 yf9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, yf9Var) == null) && yf9Var != null && yf9Var.getParallelCharge() != null) {
            ez0.b(yf9Var.getParallelCharge().b);
            Iterator<String> it = yf9Var.getParallelCharge().c.iterator();
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

    public static boolean d(yf9 yf9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yf9Var)) == null) {
            if (yf9Var == null || yf9Var.getParallelCharge() == null) {
                return false;
            }
            String str = yf9Var.getParallelCharge().a;
            ez0.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator<String> it = yf9Var.getParallelCharge().d.iterator();
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
