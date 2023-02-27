package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class zk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static s21 a(@NonNull gl0 gl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gl0Var)) == null) {
            s21 s21Var = new s21();
            s21Var.o(gl0Var.e());
            s21Var.u(gl0Var.b);
            s21Var.t(gl0Var.c.status);
            s21Var.q(gl0Var.d);
            s21Var.v(gl0Var.g);
            File file = gl0Var.h;
            if (file != null) {
                s21Var.m(file.getAbsolutePath());
            } else {
                s21Var.m("");
            }
            s21Var.r((int) (gl0Var.i * 1000.0f));
            s21Var.w((int) (gl0Var.j * 1000.0f));
            s21Var.s(gl0Var.l);
            s21Var.n(gl0Var.m);
            kl0 kl0Var = gl0Var.p;
            if (kl0Var != null) {
                s21Var.p(kl0.b(kl0Var));
            } else {
                s21Var.p("");
            }
            hl0 hl0Var = gl0Var.q;
            if (hl0Var != null) {
                s21Var.k(hl0.b(hl0Var));
            } else {
                s21Var.k("");
            }
            jl0 jl0Var = gl0Var.r;
            if (jl0Var != null) {
                s21Var.l(jl0.b(jl0Var));
            } else {
                s21Var.l("");
            }
            return s21Var;
        }
        return (s21) invokeL.objValue;
    }

    public static gl0 b(@NonNull s21 s21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, s21Var)) == null) {
            gl0 gl0Var = new gl0();
            gl0Var.h(s21Var.g());
            gl0Var.b = s21Var.z();
            gl0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == s21Var.y()) {
                    gl0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            gl0Var.d = s21Var.i();
            gl0Var.g = s21Var.A();
            if (!TextUtils.isEmpty(s21Var.e())) {
                gl0Var.h = new File(s21Var.e());
            }
            gl0Var.i = s21Var.j() / 1000.0f;
            gl0Var.j = s21Var.B() / 1000.0f;
            gl0Var.l = s21Var.x();
            gl0Var.m = s21Var.f();
            gl0Var.p = kl0.a(s21Var.h());
            gl0Var.q = hl0.a(s21Var.c());
            gl0Var.r = jl0.a(s21Var.d());
            return gl0Var;
        }
        return (gl0) invokeL.objValue;
    }
}
