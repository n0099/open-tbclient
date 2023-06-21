package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes7.dex */
public class tl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static m31 a(@NonNull am0 am0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, am0Var)) == null) {
            m31 m31Var = new m31();
            m31Var.o(am0Var.e());
            m31Var.u(am0Var.b);
            m31Var.t(am0Var.c.status);
            m31Var.q(am0Var.d);
            m31Var.v(am0Var.g);
            File file = am0Var.h;
            if (file != null) {
                m31Var.m(file.getAbsolutePath());
            } else {
                m31Var.m("");
            }
            m31Var.r((int) (am0Var.i * 1000.0f));
            m31Var.w((int) (am0Var.j * 1000.0f));
            m31Var.s(am0Var.l);
            m31Var.n(am0Var.m);
            em0 em0Var = am0Var.p;
            if (em0Var != null) {
                m31Var.p(em0.b(em0Var));
            } else {
                m31Var.p("");
            }
            bm0 bm0Var = am0Var.q;
            if (bm0Var != null) {
                m31Var.k(bm0.b(bm0Var));
            } else {
                m31Var.k("");
            }
            dm0 dm0Var = am0Var.r;
            if (dm0Var != null) {
                m31Var.l(dm0.b(dm0Var));
            } else {
                m31Var.l("");
            }
            return m31Var;
        }
        return (m31) invokeL.objValue;
    }

    public static am0 b(@NonNull m31 m31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m31Var)) == null) {
            am0 am0Var = new am0();
            am0Var.h(m31Var.g());
            am0Var.b = m31Var.z();
            am0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == m31Var.y()) {
                    am0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            am0Var.d = m31Var.i();
            am0Var.g = m31Var.A();
            if (!TextUtils.isEmpty(m31Var.e())) {
                am0Var.h = new File(m31Var.e());
            }
            am0Var.i = m31Var.j() / 1000.0f;
            am0Var.j = m31Var.B() / 1000.0f;
            am0Var.l = m31Var.x();
            am0Var.m = m31Var.f();
            am0Var.p = em0.a(m31Var.h());
            am0Var.q = bm0.a(m31Var.c());
            am0Var.r = dm0.a(m31Var.d());
            return am0Var;
        }
        return (am0) invokeL.objValue;
    }
}
