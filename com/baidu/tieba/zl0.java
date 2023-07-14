package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class zl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l41 a(@NonNull gm0 gm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gm0Var)) == null) {
            l41 l41Var = new l41();
            l41Var.o(gm0Var.e());
            l41Var.u(gm0Var.b);
            l41Var.t(gm0Var.c.status);
            l41Var.q(gm0Var.d);
            l41Var.v(gm0Var.g);
            File file = gm0Var.h;
            if (file != null) {
                l41Var.m(file.getAbsolutePath());
            } else {
                l41Var.m("");
            }
            l41Var.r((int) (gm0Var.i * 1000.0f));
            l41Var.w((int) (gm0Var.j * 1000.0f));
            l41Var.s(gm0Var.l);
            l41Var.n(gm0Var.m);
            km0 km0Var = gm0Var.p;
            if (km0Var != null) {
                l41Var.p(km0.b(km0Var));
            } else {
                l41Var.p("");
            }
            hm0 hm0Var = gm0Var.q;
            if (hm0Var != null) {
                l41Var.k(hm0.b(hm0Var));
            } else {
                l41Var.k("");
            }
            jm0 jm0Var = gm0Var.r;
            if (jm0Var != null) {
                l41Var.l(jm0.b(jm0Var));
            } else {
                l41Var.l("");
            }
            return l41Var;
        }
        return (l41) invokeL.objValue;
    }

    public static gm0 b(@NonNull l41 l41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l41Var)) == null) {
            gm0 gm0Var = new gm0();
            gm0Var.h(l41Var.g());
            gm0Var.b = l41Var.z();
            gm0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == l41Var.y()) {
                    gm0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            gm0Var.d = l41Var.i();
            gm0Var.g = l41Var.A();
            if (!TextUtils.isEmpty(l41Var.e())) {
                gm0Var.h = new File(l41Var.e());
            }
            gm0Var.i = l41Var.j() / 1000.0f;
            gm0Var.j = l41Var.B() / 1000.0f;
            gm0Var.l = l41Var.x();
            gm0Var.m = l41Var.f();
            gm0Var.p = km0.a(l41Var.h());
            gm0Var.q = hm0.a(l41Var.c());
            gm0Var.r = jm0.a(l41Var.d());
            return gm0Var;
        }
        return (gm0) invokeL.objValue;
    }
}
