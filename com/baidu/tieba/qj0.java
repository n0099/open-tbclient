package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class qj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static j11 a(@NonNull xj0 xj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, xj0Var)) == null) {
            j11 j11Var = new j11();
            j11Var.o(xj0Var.e());
            j11Var.u(xj0Var.b);
            j11Var.t(xj0Var.c.status);
            j11Var.q(xj0Var.d);
            j11Var.v(xj0Var.g);
            File file = xj0Var.h;
            if (file != null) {
                j11Var.m(file.getAbsolutePath());
            } else {
                j11Var.m("");
            }
            j11Var.r((int) (xj0Var.i * 1000.0f));
            j11Var.w((int) (xj0Var.j * 1000.0f));
            j11Var.s(xj0Var.l);
            j11Var.n(xj0Var.m);
            bk0 bk0Var = xj0Var.p;
            if (bk0Var != null) {
                j11Var.p(bk0.b(bk0Var));
            } else {
                j11Var.p("");
            }
            yj0 yj0Var = xj0Var.q;
            if (yj0Var != null) {
                j11Var.k(yj0.b(yj0Var));
            } else {
                j11Var.k("");
            }
            ak0 ak0Var = xj0Var.r;
            if (ak0Var != null) {
                j11Var.l(ak0.b(ak0Var));
            } else {
                j11Var.l("");
            }
            return j11Var;
        }
        return (j11) invokeL.objValue;
    }

    public static xj0 b(@NonNull j11 j11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, j11Var)) == null) {
            xj0 xj0Var = new xj0();
            xj0Var.h(j11Var.g());
            xj0Var.b = j11Var.z();
            xj0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == j11Var.y()) {
                    xj0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            xj0Var.d = j11Var.i();
            xj0Var.g = j11Var.A();
            if (!TextUtils.isEmpty(j11Var.e())) {
                xj0Var.h = new File(j11Var.e());
            }
            xj0Var.i = j11Var.j() / 1000.0f;
            xj0Var.j = j11Var.B() / 1000.0f;
            xj0Var.l = j11Var.x();
            xj0Var.m = j11Var.f();
            xj0Var.p = bk0.a(j11Var.h());
            xj0Var.q = yj0.a(j11Var.c());
            xj0Var.r = ak0.a(j11Var.d());
            return xj0Var;
        }
        return (xj0) invokeL.objValue;
    }
}
