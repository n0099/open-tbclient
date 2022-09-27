package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        l33 M;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str) || (M = l33.M()) == null) {
            return;
        }
        if (y44.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = y44.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            va4.h(new qe4(M.b, M.k0(), a2, 1), new c54(M.b, M.k0(), y44.b().c(str, 2), aVar));
        }
    }
}
