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

    public static zy0 a(@NonNull wg0 wg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wg0Var)) == null) {
            zy0 zy0Var = new zy0();
            zy0Var.o(wg0Var.e());
            zy0Var.u(wg0Var.b);
            zy0Var.t(wg0Var.c.status);
            zy0Var.q(wg0Var.d);
            zy0Var.v(wg0Var.g);
            File file = wg0Var.h;
            if (file != null) {
                zy0Var.m(file.getAbsolutePath());
            } else {
                zy0Var.m("");
            }
            zy0Var.r((int) (wg0Var.i * 1000.0f));
            zy0Var.w((int) (wg0Var.j * 1000.0f));
            zy0Var.s(wg0Var.l);
            zy0Var.n(wg0Var.m);
            ah0 ah0Var = wg0Var.p;
            if (ah0Var != null) {
                zy0Var.p(ah0.b(ah0Var));
            } else {
                zy0Var.p("");
            }
            xg0 xg0Var = wg0Var.q;
            if (xg0Var != null) {
                zy0Var.k(xg0.b(xg0Var));
            } else {
                zy0Var.k("");
            }
            zg0 zg0Var = wg0Var.r;
            if (zg0Var != null) {
                zy0Var.l(zg0.b(zg0Var));
            } else {
                zy0Var.l("");
            }
            return zy0Var;
        }
        return (zy0) invokeL.objValue;
    }

    public static wg0 b(@NonNull zy0 zy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zy0Var)) == null) {
            wg0 wg0Var = new wg0();
            wg0Var.h(zy0Var.g());
            wg0Var.b = zy0Var.z();
            wg0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == zy0Var.y()) {
                    wg0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            wg0Var.d = zy0Var.i();
            wg0Var.g = zy0Var.A();
            if (!TextUtils.isEmpty(zy0Var.e())) {
                wg0Var.h = new File(zy0Var.e());
            }
            wg0Var.i = zy0Var.j() / 1000.0f;
            wg0Var.j = zy0Var.B() / 1000.0f;
            wg0Var.l = zy0Var.x();
            wg0Var.m = zy0Var.f();
            wg0Var.p = ah0.a(zy0Var.h());
            wg0Var.q = xg0.a(zy0Var.c());
            wg0Var.r = zg0.a(zy0Var.d());
            return wg0Var;
        }
        return (wg0) invokeL.objValue;
    }
}
