package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class rj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sz0 a(@NonNull yj0 yj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yj0Var)) == null) {
            sz0 sz0Var = new sz0();
            sz0Var.o(yj0Var.e());
            sz0Var.u(yj0Var.b);
            sz0Var.t(yj0Var.c.status);
            sz0Var.q(yj0Var.d);
            sz0Var.v(yj0Var.g);
            File file = yj0Var.h;
            if (file != null) {
                sz0Var.m(file.getAbsolutePath());
            } else {
                sz0Var.m("");
            }
            sz0Var.r((int) (yj0Var.i * 1000.0f));
            sz0Var.w((int) (yj0Var.j * 1000.0f));
            sz0Var.s(yj0Var.l);
            sz0Var.n(yj0Var.m);
            ck0 ck0Var = yj0Var.p;
            if (ck0Var != null) {
                sz0Var.p(ck0.b(ck0Var));
            } else {
                sz0Var.p("");
            }
            zj0 zj0Var = yj0Var.q;
            if (zj0Var != null) {
                sz0Var.k(zj0.b(zj0Var));
            } else {
                sz0Var.k("");
            }
            bk0 bk0Var = yj0Var.r;
            if (bk0Var != null) {
                sz0Var.l(bk0.b(bk0Var));
            } else {
                sz0Var.l("");
            }
            return sz0Var;
        }
        return (sz0) invokeL.objValue;
    }

    public static yj0 b(@NonNull sz0 sz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sz0Var)) == null) {
            yj0 yj0Var = new yj0();
            yj0Var.h(sz0Var.g());
            yj0Var.b = sz0Var.z();
            yj0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == sz0Var.y()) {
                    yj0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            yj0Var.d = sz0Var.i();
            yj0Var.g = sz0Var.A();
            if (!TextUtils.isEmpty(sz0Var.e())) {
                yj0Var.h = new File(sz0Var.e());
            }
            yj0Var.i = sz0Var.j() / 1000.0f;
            yj0Var.j = sz0Var.B() / 1000.0f;
            yj0Var.l = sz0Var.x();
            yj0Var.m = sz0Var.f();
            yj0Var.p = ck0.a(sz0Var.h());
            yj0Var.q = zj0.a(sz0Var.c());
            yj0Var.r = bk0.a(sz0Var.d());
            return yj0Var;
        }
        return (yj0) invokeL.objValue;
    }
}
