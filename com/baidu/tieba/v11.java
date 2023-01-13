package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, x11... x11VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, x11VarArr) == null) {
            int i = 0;
            for (x11 x11Var : x11VarArr) {
                for (Column column : x11Var.b().c()) {
                    u11.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(x11 x11Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, x11Var, cursor) == null) {
            u11.i(cursor, x11Var.b().c());
        }
    }
}
