package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class v21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, x21... x21VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, x21VarArr) == null) {
            int i = 0;
            for (x21 x21Var : x21VarArr) {
                for (Column column : x21Var.b().c()) {
                    u21.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(x21 x21Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, x21Var, cursor) == null) {
            u21.i(cursor, x21Var.b().c());
        }
    }
}
