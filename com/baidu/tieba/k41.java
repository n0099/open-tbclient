package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, m41... m41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, m41VarArr) == null) {
            int i = 0;
            for (m41 m41Var : m41VarArr) {
                for (Column column : m41Var.b().c()) {
                    j41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(m41 m41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, m41Var, cursor) == null) {
            j41.i(cursor, m41Var.b().c());
        }
    }
}
