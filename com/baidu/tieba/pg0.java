package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class pg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bz0 a(@NonNull wg0 wg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wg0Var)) == null) {
            bz0 bz0Var = new bz0();
            bz0Var.o(wg0Var.e());
            bz0Var.u(wg0Var.b);
            bz0Var.t(wg0Var.c.status);
            bz0Var.q(wg0Var.d);
            bz0Var.v(wg0Var.g);
            File file = wg0Var.h;
            if (file != null) {
                bz0Var.m(file.getAbsolutePath());
            } else {
                bz0Var.m("");
            }
            bz0Var.r((int) (wg0Var.i * 1000.0f));
            bz0Var.w((int) (wg0Var.j * 1000.0f));
            bz0Var.s(wg0Var.l);
            bz0Var.n(wg0Var.m);
            ah0 ah0Var = wg0Var.p;
            if (ah0Var != null) {
                bz0Var.p(ah0.b(ah0Var));
            } else {
                bz0Var.p("");
            }
            xg0 xg0Var = wg0Var.q;
            if (xg0Var != null) {
                bz0Var.k(xg0.b(xg0Var));
            } else {
                bz0Var.k("");
            }
            zg0 zg0Var = wg0Var.r;
            if (zg0Var != null) {
                bz0Var.l(zg0.b(zg0Var));
            } else {
                bz0Var.l("");
            }
            return bz0Var;
        }
        return (bz0) invokeL.objValue;
    }

    public static wg0 b(@NonNull bz0 bz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bz0Var)) == null) {
            wg0 wg0Var = new wg0();
            wg0Var.h(bz0Var.g());
            wg0Var.b = bz0Var.z();
            wg0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == bz0Var.y()) {
                    wg0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            wg0Var.d = bz0Var.i();
            wg0Var.g = bz0Var.A();
            if (!TextUtils.isEmpty(bz0Var.e())) {
                wg0Var.h = new File(bz0Var.e());
            }
            wg0Var.i = bz0Var.j() / 1000.0f;
            wg0Var.j = bz0Var.B() / 1000.0f;
            wg0Var.l = bz0Var.x();
            wg0Var.m = bz0Var.f();
            wg0Var.p = ah0.a(bz0Var.h());
            wg0Var.q = xg0.a(bz0Var.c());
            wg0Var.r = zg0.a(bz0Var.d());
            return wg0Var;
        }
        return (wg0) invokeL.objValue;
    }
}
