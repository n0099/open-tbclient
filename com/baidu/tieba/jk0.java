package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class jk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c11 a(@NonNull qk0 qk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qk0Var)) == null) {
            c11 c11Var = new c11();
            c11Var.o(qk0Var.e());
            c11Var.u(qk0Var.b);
            c11Var.t(qk0Var.c.status);
            c11Var.q(qk0Var.d);
            c11Var.v(qk0Var.g);
            File file = qk0Var.h;
            if (file != null) {
                c11Var.m(file.getAbsolutePath());
            } else {
                c11Var.m("");
            }
            c11Var.r((int) (qk0Var.i * 1000.0f));
            c11Var.w((int) (qk0Var.j * 1000.0f));
            c11Var.s(qk0Var.l);
            c11Var.n(qk0Var.m);
            uk0 uk0Var = qk0Var.p;
            if (uk0Var != null) {
                c11Var.p(uk0.b(uk0Var));
            } else {
                c11Var.p("");
            }
            rk0 rk0Var = qk0Var.q;
            if (rk0Var != null) {
                c11Var.k(rk0.b(rk0Var));
            } else {
                c11Var.k("");
            }
            tk0 tk0Var = qk0Var.r;
            if (tk0Var != null) {
                c11Var.l(tk0.b(tk0Var));
            } else {
                c11Var.l("");
            }
            return c11Var;
        }
        return (c11) invokeL.objValue;
    }

    public static qk0 b(@NonNull c11 c11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c11Var)) == null) {
            qk0 qk0Var = new qk0();
            qk0Var.h(c11Var.g());
            qk0Var.b = c11Var.z();
            qk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == c11Var.y()) {
                    qk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            qk0Var.d = c11Var.i();
            qk0Var.g = c11Var.A();
            if (!TextUtils.isEmpty(c11Var.e())) {
                qk0Var.h = new File(c11Var.e());
            }
            qk0Var.i = c11Var.j() / 1000.0f;
            qk0Var.j = c11Var.B() / 1000.0f;
            qk0Var.l = c11Var.x();
            qk0Var.m = c11Var.f();
            qk0Var.p = uk0.a(c11Var.h());
            qk0Var.q = rk0.a(c11Var.c());
            qk0Var.r = tk0.a(c11Var.d());
            return qk0Var;
        }
        return (qk0) invokeL.objValue;
    }
}
