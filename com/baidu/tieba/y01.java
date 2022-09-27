package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class y01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, a11... a11VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, a11VarArr) == null) {
            int i = 0;
            for (a11 a11Var : a11VarArr) {
                for (Column column : a11Var.b().c()) {
                    x01.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(a11 a11Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, a11Var, cursor) == null) {
            x01.i(cursor, a11Var.b().c());
        }
    }
}
