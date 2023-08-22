package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        db3 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, aVar) != null) || aVar == null || TextUtils.isEmpty(str) || (M = db3.M()) == null) {
            return;
        }
        if (qc4.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = qc4.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            ni4.h(new im4(M.b, M.k0(), a2, 1), new uc4(M.b, M.k0(), qc4.b().c(str, 2), aVar));
        }
    }
}
