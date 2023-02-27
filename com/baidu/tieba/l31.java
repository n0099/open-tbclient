package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, n31... n31VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, n31VarArr) == null) {
            int i = 0;
            for (n31 n31Var : n31VarArr) {
                for (Column column : n31Var.b().c()) {
                    k31.h(column, cursor, i);
                    i++;
                }
            }
        }
    }

    public static void b(n31 n31Var, Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, n31Var, cursor) == null) {
            k31.i(cursor, n31Var.b().c());
        }
    }
}
