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
public class zy8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yy8 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof yy8)) {
                return null;
            }
            return (yy8) iLegoAdvert;
        }
        return (yy8) invokeL.objValue;
    }

    public static void b(yy8 yy8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, yy8Var) == null) && yy8Var != null && yy8Var.getParallelCharge() != null) {
            ky0.b(yy8Var.getParallelCharge().b);
            Iterator<String> it = yy8Var.getParallelCharge().c.iterator();
            while (it.hasNext()) {
                ky0.b(it.next());
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
            jy0.e(clogBuilder);
        }
    }

    public static boolean d(yy8 yy8Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yy8Var)) == null) {
            if (yy8Var == null || yy8Var.getParallelCharge() == null) {
                return false;
            }
            String str = yy8Var.getParallelCharge().a;
            ky0.b(str);
            if (!TextUtils.isEmpty(str)) {
                z = true;
            } else {
                z = false;
            }
            Iterator<String> it = yy8Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!z && TextUtils.isEmpty(next)) {
                    z = false;
                } else {
                    z = true;
                }
                ky0.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
