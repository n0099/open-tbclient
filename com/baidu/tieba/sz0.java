package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, uz0... uz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, uz0VarArr) == null) {
            int i = 0;
            for (uz0 uz0Var : uz0VarArr) {
                for (Column column : uz0Var.b().c()) {
                    rz0.e(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(uz0 uz0Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, uz0Var, cursor) == null) {
            rz0.f(cursor, uz0Var.b().c());
        }
    }
}
