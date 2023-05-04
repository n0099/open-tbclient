package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class tj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static m11 a(@NonNull ak0 ak0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ak0Var)) == null) {
            m11 m11Var = new m11();
            m11Var.o(ak0Var.e());
            m11Var.u(ak0Var.b);
            m11Var.t(ak0Var.c.status);
            m11Var.q(ak0Var.d);
            m11Var.v(ak0Var.g);
            File file = ak0Var.h;
            if (file != null) {
                m11Var.m(file.getAbsolutePath());
            } else {
                m11Var.m("");
            }
            m11Var.r((int) (ak0Var.i * 1000.0f));
            m11Var.w((int) (ak0Var.j * 1000.0f));
            m11Var.s(ak0Var.l);
            m11Var.n(ak0Var.m);
            ek0 ek0Var = ak0Var.p;
            if (ek0Var != null) {
                m11Var.p(ek0.b(ek0Var));
            } else {
                m11Var.p("");
            }
            bk0 bk0Var = ak0Var.q;
            if (bk0Var != null) {
                m11Var.k(bk0.b(bk0Var));
            } else {
                m11Var.k("");
            }
            dk0 dk0Var = ak0Var.r;
            if (dk0Var != null) {
                m11Var.l(dk0.b(dk0Var));
            } else {
                m11Var.l("");
            }
            return m11Var;
        }
        return (m11) invokeL.objValue;
    }

    public static ak0 b(@NonNull m11 m11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m11Var)) == null) {
            ak0 ak0Var = new ak0();
            ak0Var.h(m11Var.g());
            ak0Var.b = m11Var.z();
            ak0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == m11Var.y()) {
                    ak0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            ak0Var.d = m11Var.i();
            ak0Var.g = m11Var.A();
            if (!TextUtils.isEmpty(m11Var.e())) {
                ak0Var.h = new File(m11Var.e());
            }
            ak0Var.i = m11Var.j() / 1000.0f;
            ak0Var.j = m11Var.B() / 1000.0f;
            ak0Var.l = m11Var.x();
            ak0Var.m = m11Var.f();
            ak0Var.p = ek0.a(m11Var.h());
            ak0Var.q = bk0.a(m11Var.c());
            ak0Var.r = dk0.a(m11Var.d());
            return ak0Var;
        }
        return (ak0) invokeL.objValue;
    }
}
