package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class xk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o31 a(@NonNull el0 el0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, el0Var)) == null) {
            o31 o31Var = new o31();
            o31Var.o(el0Var.e());
            o31Var.u(el0Var.b);
            o31Var.t(el0Var.c.status);
            o31Var.q(el0Var.d);
            o31Var.v(el0Var.g);
            File file = el0Var.h;
            if (file != null) {
                o31Var.m(file.getAbsolutePath());
            } else {
                o31Var.m("");
            }
            o31Var.r((int) (el0Var.i * 1000.0f));
            o31Var.w((int) (el0Var.j * 1000.0f));
            o31Var.s(el0Var.l);
            o31Var.n(el0Var.m);
            il0 il0Var = el0Var.p;
            if (il0Var != null) {
                o31Var.p(il0.b(il0Var));
            } else {
                o31Var.p("");
            }
            fl0 fl0Var = el0Var.q;
            if (fl0Var != null) {
                o31Var.k(fl0.b(fl0Var));
            } else {
                o31Var.k("");
            }
            hl0 hl0Var = el0Var.r;
            if (hl0Var != null) {
                o31Var.l(hl0.b(hl0Var));
            } else {
                o31Var.l("");
            }
            return o31Var;
        }
        return (o31) invokeL.objValue;
    }

    public static el0 b(@NonNull o31 o31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o31Var)) == null) {
            el0 el0Var = new el0();
            el0Var.h(o31Var.g());
            el0Var.b = o31Var.z();
            el0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == o31Var.y()) {
                    el0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            el0Var.d = o31Var.i();
            el0Var.g = o31Var.A();
            if (!TextUtils.isEmpty(o31Var.e())) {
                el0Var.h = new File(o31Var.e());
            }
            el0Var.i = o31Var.j() / 1000.0f;
            el0Var.j = o31Var.B() / 1000.0f;
            el0Var.l = o31Var.x();
            el0Var.m = o31Var.f();
            el0Var.p = il0.a(o31Var.h());
            el0Var.q = fl0.a(o31Var.c());
            el0Var.r = hl0.a(o31Var.d());
            return el0Var;
        }
        return (el0) invokeL.objValue;
    }
}
