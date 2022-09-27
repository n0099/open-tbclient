package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class vg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ug7 a(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.h) == null || !(iLegoAdvert instanceof ug7)) {
                return null;
            }
            return (ug7) iLegoAdvert;
        }
        return (ug7) invokeL.objValue;
    }

    public static void b(ug7 ug7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, ug7Var) == null) || ug7Var == null || ug7Var.getParallelCharge() == null) {
            return;
        }
        i01.b(ug7Var.getParallelCharge().b);
        Iterator<String> it = ug7Var.getParallelCharge().c.iterator();
        while (it.hasNext()) {
            i01.b(it.next());
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
            h01.b(clogBuilder);
        }
    }

    public static boolean d(ug7 ug7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ug7Var)) == null) {
            if (ug7Var == null || ug7Var.getParallelCharge() == null) {
                return false;
            }
            String str = ug7Var.getParallelCharge().a;
            i01.b(str);
            boolean z = !TextUtils.isEmpty(str);
            Iterator<String> it = ug7Var.getParallelCharge().d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                z = z || !TextUtils.isEmpty(next);
                i01.b(next);
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
