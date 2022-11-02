package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, s11... s11VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, s11VarArr) == null) {
            int i = 0;
            for (s11 s11Var : s11VarArr) {
                for (Column column : s11Var.b().c()) {
                    p11.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(s11 s11Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, s11Var, cursor) == null) {
            p11.i(cursor, s11Var.b().c());
        }
    }
}
