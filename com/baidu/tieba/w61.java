package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ClogBuilder.LogType logType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, logType, str, str2, str3) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.u(ClogBuilder.Page.NAVIDEO_POP_WEB_PANEL);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.k(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.p(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.j(str2);
            }
            l11.b(clogBuilder);
        }
    }
}
