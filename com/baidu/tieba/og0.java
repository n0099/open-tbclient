package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class og0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yy0 a(@NonNull vg0 vg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vg0Var)) == null) {
            yy0 yy0Var = new yy0();
            yy0Var.o(vg0Var.e());
            yy0Var.u(vg0Var.b);
            yy0Var.t(vg0Var.c.status);
            yy0Var.q(vg0Var.d);
            yy0Var.v(vg0Var.g);
            File file = vg0Var.h;
            if (file != null) {
                yy0Var.m(file.getAbsolutePath());
            } else {
                yy0Var.m("");
            }
            yy0Var.r((int) (vg0Var.i * 1000.0f));
            yy0Var.w((int) (vg0Var.j * 1000.0f));
            yy0Var.s(vg0Var.l);
            yy0Var.n(vg0Var.m);
            zg0 zg0Var = vg0Var.p;
            if (zg0Var != null) {
                yy0Var.p(zg0.b(zg0Var));
            } else {
                yy0Var.p("");
            }
            wg0 wg0Var = vg0Var.q;
            if (wg0Var != null) {
                yy0Var.k(wg0.b(wg0Var));
            } else {
                yy0Var.k("");
            }
            yg0 yg0Var = vg0Var.r;
            if (yg0Var != null) {
                yy0Var.l(yg0.b(yg0Var));
            } else {
                yy0Var.l("");
            }
            return yy0Var;
        }
        return (yy0) invokeL.objValue;
    }

    public static vg0 b(@NonNull yy0 yy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yy0Var)) == null) {
            vg0 vg0Var = new vg0();
            vg0Var.h(yy0Var.g());
            vg0Var.b = yy0Var.z();
            vg0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == yy0Var.y()) {
                    vg0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            vg0Var.d = yy0Var.i();
            vg0Var.g = yy0Var.A();
            if (!TextUtils.isEmpty(yy0Var.e())) {
                vg0Var.h = new File(yy0Var.e());
            }
            vg0Var.i = yy0Var.j() / 1000.0f;
            vg0Var.j = yy0Var.B() / 1000.0f;
            vg0Var.l = yy0Var.x();
            vg0Var.m = yy0Var.f();
            vg0Var.p = zg0.a(yy0Var.h());
            vg0Var.q = wg0.a(yy0Var.c());
            vg0Var.r = yg0.a(yy0Var.d());
            return vg0Var;
        }
        return (vg0) invokeL.objValue;
    }
}
