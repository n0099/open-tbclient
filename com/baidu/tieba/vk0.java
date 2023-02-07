package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class vk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l21 a(@NonNull cl0 cl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cl0Var)) == null) {
            l21 l21Var = new l21();
            l21Var.o(cl0Var.e());
            l21Var.u(cl0Var.b);
            l21Var.t(cl0Var.c.status);
            l21Var.q(cl0Var.d);
            l21Var.v(cl0Var.g);
            File file = cl0Var.h;
            if (file != null) {
                l21Var.m(file.getAbsolutePath());
            } else {
                l21Var.m("");
            }
            l21Var.r((int) (cl0Var.i * 1000.0f));
            l21Var.w((int) (cl0Var.j * 1000.0f));
            l21Var.s(cl0Var.l);
            l21Var.n(cl0Var.m);
            gl0 gl0Var = cl0Var.p;
            if (gl0Var != null) {
                l21Var.p(gl0.b(gl0Var));
            } else {
                l21Var.p("");
            }
            dl0 dl0Var = cl0Var.q;
            if (dl0Var != null) {
                l21Var.k(dl0.b(dl0Var));
            } else {
                l21Var.k("");
            }
            fl0 fl0Var = cl0Var.r;
            if (fl0Var != null) {
                l21Var.l(fl0.b(fl0Var));
            } else {
                l21Var.l("");
            }
            return l21Var;
        }
        return (l21) invokeL.objValue;
    }

    public static cl0 b(@NonNull l21 l21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l21Var)) == null) {
            cl0 cl0Var = new cl0();
            cl0Var.h(l21Var.g());
            cl0Var.b = l21Var.z();
            cl0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == l21Var.y()) {
                    cl0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            cl0Var.d = l21Var.i();
            cl0Var.g = l21Var.A();
            if (!TextUtils.isEmpty(l21Var.e())) {
                cl0Var.h = new File(l21Var.e());
            }
            cl0Var.i = l21Var.j() / 1000.0f;
            cl0Var.j = l21Var.B() / 1000.0f;
            cl0Var.l = l21Var.x();
            cl0Var.m = l21Var.f();
            cl0Var.p = gl0.a(l21Var.h());
            cl0Var.q = dl0.a(l21Var.c());
            cl0Var.r = fl0.a(l21Var.d());
            return cl0Var;
        }
        return (cl0) invokeL.objValue;
    }
}
