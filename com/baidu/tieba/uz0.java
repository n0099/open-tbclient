package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, wz0... wz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, wz0VarArr) == null) {
            int i = 0;
            for (wz0 wz0Var : wz0VarArr) {
                for (Column column : wz0Var.b().c()) {
                    tz0.e(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(wz0 wz0Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, wz0Var, cursor) == null) {
            tz0.f(cursor, wz0Var.b().c());
        }
    }
}
