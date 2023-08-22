package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ClogBuilder.LogType logType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, logType, str, str2, str3) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.u(ClogBuilder.Page.NAD_POP_WEB_PANEL);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.k(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.p(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.j(str2);
            }
            t31.e(clogBuilder);
        }
    }

    public static void b(ClogBuilder.Page page, ClogBuilder.LogType logType, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, page, logType, str, str2, str3) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.u(page);
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.k(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.p(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.j(str2);
            }
            t31.e(clogBuilder);
        }
    }
}
