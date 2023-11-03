package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class rz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, tz0... tz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, tz0VarArr) == null) {
            int i = 0;
            for (tz0 tz0Var : tz0VarArr) {
                for (Column column : tz0Var.b().c()) {
                    qz0.e(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(tz0 tz0Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tz0Var, cursor) == null) {
            qz0.f(cursor, tz0Var.b().c());
        }
    }
}
