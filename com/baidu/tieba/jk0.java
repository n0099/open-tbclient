package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class jk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c21 a(@NonNull qk0 qk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qk0Var)) == null) {
            c21 c21Var = new c21();
            c21Var.o(qk0Var.e());
            c21Var.u(qk0Var.b);
            c21Var.t(qk0Var.c.status);
            c21Var.q(qk0Var.d);
            c21Var.v(qk0Var.g);
            File file = qk0Var.h;
            if (file != null) {
                c21Var.m(file.getAbsolutePath());
            } else {
                c21Var.m("");
            }
            c21Var.r((int) (qk0Var.i * 1000.0f));
            c21Var.w((int) (qk0Var.j * 1000.0f));
            c21Var.s(qk0Var.l);
            c21Var.n(qk0Var.m);
            uk0 uk0Var = qk0Var.p;
            if (uk0Var != null) {
                c21Var.p(uk0.b(uk0Var));
            } else {
                c21Var.p("");
            }
            rk0 rk0Var = qk0Var.q;
            if (rk0Var != null) {
                c21Var.k(rk0.b(rk0Var));
            } else {
                c21Var.k("");
            }
            tk0 tk0Var = qk0Var.r;
            if (tk0Var != null) {
                c21Var.l(tk0.b(tk0Var));
            } else {
                c21Var.l("");
            }
            return c21Var;
        }
        return (c21) invokeL.objValue;
    }

    public static qk0 b(@NonNull c21 c21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c21Var)) == null) {
            qk0 qk0Var = new qk0();
            qk0Var.h(c21Var.g());
            qk0Var.b = c21Var.z();
            qk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == c21Var.y()) {
                    qk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            qk0Var.d = c21Var.i();
            qk0Var.g = c21Var.A();
            if (!TextUtils.isEmpty(c21Var.e())) {
                qk0Var.h = new File(c21Var.e());
            }
            qk0Var.i = c21Var.j() / 1000.0f;
            qk0Var.j = c21Var.B() / 1000.0f;
            qk0Var.l = c21Var.x();
            qk0Var.m = c21Var.f();
            qk0Var.p = uk0.a(c21Var.h());
            qk0Var.q = rk0.a(c21Var.c());
            qk0Var.r = tk0.a(c21Var.d());
            return qk0Var;
        }
        return (qk0) invokeL.objValue;
    }
}
