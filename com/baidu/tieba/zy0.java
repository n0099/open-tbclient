package com.baidu.tieba;

import android.database.Cursor;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Cursor cursor, bz0... bz0VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, cursor, bz0VarArr) == null) {
            int i = 0;
            for (bz0 bz0Var : bz0VarArr) {
                for (Column column : bz0Var.b().c()) {
                    yy0.h(column, cursor, i);
                    i++;
                }
            }
        }
    }
}
