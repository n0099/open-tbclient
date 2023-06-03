package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class sl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l31 a(@NonNull zl0 zl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, zl0Var)) == null) {
            l31 l31Var = new l31();
            l31Var.o(zl0Var.e());
            l31Var.u(zl0Var.b);
            l31Var.t(zl0Var.c.status);
            l31Var.q(zl0Var.d);
            l31Var.v(zl0Var.g);
            File file = zl0Var.h;
            if (file != null) {
                l31Var.m(file.getAbsolutePath());
            } else {
                l31Var.m("");
            }
            l31Var.r((int) (zl0Var.i * 1000.0f));
            l31Var.w((int) (zl0Var.j * 1000.0f));
            l31Var.s(zl0Var.l);
            l31Var.n(zl0Var.m);
            dm0 dm0Var = zl0Var.p;
            if (dm0Var != null) {
                l31Var.p(dm0.b(dm0Var));
            } else {
                l31Var.p("");
            }
            am0 am0Var = zl0Var.q;
            if (am0Var != null) {
                l31Var.k(am0.b(am0Var));
            } else {
                l31Var.k("");
            }
            cm0 cm0Var = zl0Var.r;
            if (cm0Var != null) {
                l31Var.l(cm0.b(cm0Var));
            } else {
                l31Var.l("");
            }
            return l31Var;
        }
        return (l31) invokeL.objValue;
    }

    public static zl0 b(@NonNull l31 l31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l31Var)) == null) {
            zl0 zl0Var = new zl0();
            zl0Var.h(l31Var.g());
            zl0Var.b = l31Var.z();
            zl0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == l31Var.y()) {
                    zl0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            zl0Var.d = l31Var.i();
            zl0Var.g = l31Var.A();
            if (!TextUtils.isEmpty(l31Var.e())) {
                zl0Var.h = new File(l31Var.e());
            }
            zl0Var.i = l31Var.j() / 1000.0f;
            zl0Var.j = l31Var.B() / 1000.0f;
            zl0Var.l = l31Var.x();
            zl0Var.m = l31Var.f();
            zl0Var.p = dm0.a(l31Var.h());
            zl0Var.q = am0.a(l31Var.c());
            zl0Var.r = cm0.a(l31Var.d());
            return zl0Var;
        }
        return (zl0) invokeL.objValue;
    }
}
