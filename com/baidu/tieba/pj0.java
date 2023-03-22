package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class pj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i11 a(@NonNull wj0 wj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wj0Var)) == null) {
            i11 i11Var = new i11();
            i11Var.o(wj0Var.e());
            i11Var.u(wj0Var.b);
            i11Var.t(wj0Var.c.status);
            i11Var.q(wj0Var.d);
            i11Var.v(wj0Var.g);
            File file = wj0Var.h;
            if (file != null) {
                i11Var.m(file.getAbsolutePath());
            } else {
                i11Var.m("");
            }
            i11Var.r((int) (wj0Var.i * 1000.0f));
            i11Var.w((int) (wj0Var.j * 1000.0f));
            i11Var.s(wj0Var.l);
            i11Var.n(wj0Var.m);
            ak0 ak0Var = wj0Var.p;
            if (ak0Var != null) {
                i11Var.p(ak0.b(ak0Var));
            } else {
                i11Var.p("");
            }
            xj0 xj0Var = wj0Var.q;
            if (xj0Var != null) {
                i11Var.k(xj0.b(xj0Var));
            } else {
                i11Var.k("");
            }
            zj0 zj0Var = wj0Var.r;
            if (zj0Var != null) {
                i11Var.l(zj0.b(zj0Var));
            } else {
                i11Var.l("");
            }
            return i11Var;
        }
        return (i11) invokeL.objValue;
    }

    public static wj0 b(@NonNull i11 i11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i11Var)) == null) {
            wj0 wj0Var = new wj0();
            wj0Var.h(i11Var.g());
            wj0Var.b = i11Var.z();
            wj0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == i11Var.y()) {
                    wj0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            wj0Var.d = i11Var.i();
            wj0Var.g = i11Var.A();
            if (!TextUtils.isEmpty(i11Var.e())) {
                wj0Var.h = new File(i11Var.e());
            }
            wj0Var.i = i11Var.j() / 1000.0f;
            wj0Var.j = i11Var.B() / 1000.0f;
            wj0Var.l = i11Var.x();
            wj0Var.m = i11Var.f();
            wj0Var.p = ak0.a(i11Var.h());
            wj0Var.q = xj0.a(i11Var.c());
            wj0Var.r = zj0.a(i11Var.d());
            return wj0Var;
        }
        return (wj0) invokeL.objValue;
    }
}
