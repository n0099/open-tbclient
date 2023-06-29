package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class wl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p31 a(@NonNull dm0 dm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dm0Var)) == null) {
            p31 p31Var = new p31();
            p31Var.o(dm0Var.e());
            p31Var.u(dm0Var.b);
            p31Var.t(dm0Var.c.status);
            p31Var.q(dm0Var.d);
            p31Var.v(dm0Var.g);
            File file = dm0Var.h;
            if (file != null) {
                p31Var.m(file.getAbsolutePath());
            } else {
                p31Var.m("");
            }
            p31Var.r((int) (dm0Var.i * 1000.0f));
            p31Var.w((int) (dm0Var.j * 1000.0f));
            p31Var.s(dm0Var.l);
            p31Var.n(dm0Var.m);
            hm0 hm0Var = dm0Var.p;
            if (hm0Var != null) {
                p31Var.p(hm0.b(hm0Var));
            } else {
                p31Var.p("");
            }
            em0 em0Var = dm0Var.q;
            if (em0Var != null) {
                p31Var.k(em0.b(em0Var));
            } else {
                p31Var.k("");
            }
            gm0 gm0Var = dm0Var.r;
            if (gm0Var != null) {
                p31Var.l(gm0.b(gm0Var));
            } else {
                p31Var.l("");
            }
            return p31Var;
        }
        return (p31) invokeL.objValue;
    }

    public static dm0 b(@NonNull p31 p31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p31Var)) == null) {
            dm0 dm0Var = new dm0();
            dm0Var.h(p31Var.g());
            dm0Var.b = p31Var.z();
            dm0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == p31Var.y()) {
                    dm0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            dm0Var.d = p31Var.i();
            dm0Var.g = p31Var.A();
            if (!TextUtils.isEmpty(p31Var.e())) {
                dm0Var.h = new File(p31Var.e());
            }
            dm0Var.i = p31Var.j() / 1000.0f;
            dm0Var.j = p31Var.B() / 1000.0f;
            dm0Var.l = p31Var.x();
            dm0Var.m = p31Var.f();
            dm0Var.p = hm0.a(p31Var.h());
            dm0Var.q = em0.a(p31Var.c());
            dm0Var.r = gm0.a(p31Var.d());
            return dm0Var;
        }
        return (dm0) invokeL.objValue;
    }
}
