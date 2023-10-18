package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class xf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hy0 a(@NonNull eg0 eg0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, eg0Var)) == null) {
            hy0 hy0Var = new hy0();
            hy0Var.o(eg0Var.e());
            hy0Var.u(eg0Var.b);
            hy0Var.t(eg0Var.c.status);
            hy0Var.q(eg0Var.d);
            hy0Var.v(eg0Var.g);
            File file = eg0Var.h;
            if (file != null) {
                hy0Var.m(file.getAbsolutePath());
            } else {
                hy0Var.m("");
            }
            hy0Var.r((int) (eg0Var.i * 1000.0f));
            hy0Var.w((int) (eg0Var.j * 1000.0f));
            hy0Var.s(eg0Var.l);
            hy0Var.n(eg0Var.m);
            ig0 ig0Var = eg0Var.p;
            if (ig0Var != null) {
                hy0Var.p(ig0.b(ig0Var));
            } else {
                hy0Var.p("");
            }
            fg0 fg0Var = eg0Var.q;
            if (fg0Var != null) {
                hy0Var.k(fg0.b(fg0Var));
            } else {
                hy0Var.k("");
            }
            hg0 hg0Var = eg0Var.r;
            if (hg0Var != null) {
                hy0Var.l(hg0.b(hg0Var));
            } else {
                hy0Var.l("");
            }
            return hy0Var;
        }
        return (hy0) invokeL.objValue;
    }

    public static eg0 b(@NonNull hy0 hy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hy0Var)) == null) {
            eg0 eg0Var = new eg0();
            eg0Var.h(hy0Var.g());
            eg0Var.b = hy0Var.z();
            eg0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == hy0Var.y()) {
                    eg0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            eg0Var.d = hy0Var.i();
            eg0Var.g = hy0Var.A();
            if (!TextUtils.isEmpty(hy0Var.e())) {
                eg0Var.h = new File(hy0Var.e());
            }
            eg0Var.i = hy0Var.j() / 1000.0f;
            eg0Var.j = hy0Var.B() / 1000.0f;
            eg0Var.l = hy0Var.x();
            eg0Var.m = hy0Var.f();
            eg0Var.p = ig0.a(hy0Var.h());
            eg0Var.q = fg0.a(hy0Var.c());
            eg0Var.r = hg0.a(hy0Var.d());
            return eg0Var;
        }
        return (eg0) invokeL.objValue;
    }
}
