package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, b11... b11VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, b11VarArr) == null) {
            int i = 0;
            for (b11 b11Var : b11VarArr) {
                for (Column column : b11Var.b().c()) {
                    y01.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(b11 b11Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, b11Var, cursor) == null) {
            y01.i(cursor, b11Var.b().c());
        }
    }
}
