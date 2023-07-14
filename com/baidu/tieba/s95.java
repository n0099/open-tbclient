package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, long j, int i, String str2, int i2, String str3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2, Integer.valueOf(i2), str3, objArr}) == null) {
            eh ehVar = new eh();
            ehVar.c("cmd", Integer.valueOf(i));
            if (!TextUtils.isEmpty(str2)) {
                ehVar.b("action", str2);
            }
            ehVar.b("errNo", String.valueOf(i2));
            if (!TextUtils.isEmpty(str3) && i2 != 0) {
                ehVar.b(StatConstants.KEY_EXT_ERR_MSG, str3);
            }
            if (objArr != null && objArr.length > 0) {
                ehVar.c(objArr);
            }
            if (i2 == 0) {
                BdStatisticsManager.getInstance().debug(str, j, null, ehVar);
            } else {
                BdStatisticsManager.getInstance().error(str, j, (String) null, ehVar);
            }
        }
    }
}
