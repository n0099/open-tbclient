package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class rj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static k11 a(@NonNull yj0 yj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yj0Var)) == null) {
            k11 k11Var = new k11();
            k11Var.o(yj0Var.e());
            k11Var.u(yj0Var.b);
            k11Var.t(yj0Var.c.status);
            k11Var.q(yj0Var.d);
            k11Var.v(yj0Var.g);
            File file = yj0Var.h;
            if (file != null) {
                k11Var.m(file.getAbsolutePath());
            } else {
                k11Var.m("");
            }
            k11Var.r((int) (yj0Var.i * 1000.0f));
            k11Var.w((int) (yj0Var.j * 1000.0f));
            k11Var.s(yj0Var.l);
            k11Var.n(yj0Var.m);
            ck0 ck0Var = yj0Var.p;
            if (ck0Var != null) {
                k11Var.p(ck0.b(ck0Var));
            } else {
                k11Var.p("");
            }
            zj0 zj0Var = yj0Var.q;
            if (zj0Var != null) {
                k11Var.k(zj0.b(zj0Var));
            } else {
                k11Var.k("");
            }
            bk0 bk0Var = yj0Var.r;
            if (bk0Var != null) {
                k11Var.l(bk0.b(bk0Var));
            } else {
                k11Var.l("");
            }
            return k11Var;
        }
        return (k11) invokeL.objValue;
    }

    public static yj0 b(@NonNull k11 k11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k11Var)) == null) {
            yj0 yj0Var = new yj0();
            yj0Var.h(k11Var.g());
            yj0Var.b = k11Var.z();
            yj0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == k11Var.y()) {
                    yj0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            yj0Var.d = k11Var.i();
            yj0Var.g = k11Var.A();
            if (!TextUtils.isEmpty(k11Var.e())) {
                yj0Var.h = new File(k11Var.e());
            }
            yj0Var.i = k11Var.j() / 1000.0f;
            yj0Var.j = k11Var.B() / 1000.0f;
            yj0Var.l = k11Var.x();
            yj0Var.m = k11Var.f();
            yj0Var.p = ck0.a(k11Var.h());
            yj0Var.q = zj0.a(k11Var.c());
            yj0Var.r = bk0.a(k11Var.d());
            return yj0Var;
        }
        return (yj0) invokeL.objValue;
    }
}
