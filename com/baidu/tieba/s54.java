package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        e43 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, aVar) != null) || aVar == null || TextUtils.isEmpty(str) || (M = e43.M()) == null) {
            return;
        }
        if (r54.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = r54.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            ob4.h(new jf4(M.b, M.k0(), a2, 1), new v54(M.b, M.k0(), r54.b().c(str, 2), aVar));
        }
    }
}
