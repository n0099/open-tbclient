package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, n01... n01VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, n01VarArr) == null) {
            int i = 0;
            for (n01 n01Var : n01VarArr) {
                for (Column column : n01Var.b().c()) {
                    k01.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(n01 n01Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, n01Var, cursor) == null) {
            k01.i(cursor, n01Var.b().c());
        }
    }
}
