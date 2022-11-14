package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, t11... t11VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, t11VarArr) == null) {
            int i = 0;
            for (t11 t11Var : t11VarArr) {
                for (Column column : t11Var.b().c()) {
                    q11.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(t11 t11Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, t11Var, cursor) == null) {
            q11.i(cursor, t11Var.b().c());
        }
    }
}
