package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class y74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        k63 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, aVar) != null) || aVar == null || TextUtils.isEmpty(str) || (M = k63.M()) == null) {
            return;
        }
        if (x74.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = x74.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            ud4.h(new ph4(M.b, M.l0(), a2, 1), new b84(M.b, M.l0(), x74.b().c(str, 2), aVar));
        }
    }
}
