package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, q41... q41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, q41VarArr) == null) {
            int i = 0;
            for (q41 q41Var : q41VarArr) {
                for (Column column : q41Var.b().c()) {
                    n41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(q41 q41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, q41Var, cursor) == null) {
            n41.i(cursor, q41Var.b().c());
        }
    }
}
