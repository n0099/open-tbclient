package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, p41... p41VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, p41VarArr) == null) {
            int i = 0;
            for (p41 p41Var : p41VarArr) {
                for (Column column : p41Var.b().c()) {
                    m41.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(p41 p41Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, p41Var, cursor) == null) {
            m41.i(cursor, p41Var.b().c());
        }
    }
}
