package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.sweetsqlite.BooleanColumn;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class qz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ContentValues a(Column[] columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, columnArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (Column column : columnArr) {
                if (column.isAssignedValue) {
                    int type = column.type();
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                                if (type == 4) {
                                    contentValues.put(column.field.b, ((StringColumn) column).getValue());
                                } else {
                                    throw new IllegalStateException("Unsupported type:" + column.type());
                                }
                            } else {
                                contentValues.put(column.field.b, Long.valueOf(((LongColumn) column).getValue()));
                            }
                        } else {
                            contentValues.put(column.field.b, Integer.valueOf(((IntegerColumn) column).getValue()));
                        }
                    } else {
                        contentValues.put(column.field.b, Integer.valueOf(((BooleanColumn) column).getValue() ? 1 : 0));
                    }
                }
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static Column[] b(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tz0Var, kz0VarArr)) == null) {
            Column[] columnArr = new Column[kz0VarArr.length];
            for (int i = 0; i < kz0VarArr.length; i++) {
                columnArr[i] = tz0Var.b().c()[jz0.a(tz0Var.b().d(), kz0VarArr[i])];
            }
            return columnArr;
        }
        return (Column[]) invokeLL.objValue;
    }

    public static void c(Column column, Column column2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, column, column2) == null) && column.type() == column2.type()) {
            column2.isAssignedValue = column.isAssignedValue;
            int type = column.type();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            ((StringColumn) column2).value = ((StringColumn) column).value;
                            return;
                        }
                        throw new IllegalStateException("Unsupported type:" + column.type());
                    }
                    ((LongColumn) column2).value = ((LongColumn) column).value;
                    return;
                }
                ((IntegerColumn) column2).value = ((IntegerColumn) column).value;
                return;
            }
            ((BooleanColumn) column2).value = ((BooleanColumn) column).value;
        }
    }

    public static boolean d(BooleanColumn booleanColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, booleanColumn, cursor, i)) == null) {
            boolean z2 = true;
            if (i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (cursor.getInt(i) <= 0) {
                    z2 = false;
                }
                booleanColumn.setValue(z2);
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static void g(Cursor cursor, Column[] columnArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, cursor, columnArr, i) == null) {
            if (!cursor.isBeforeFirst() && !cursor.isAfterLast()) {
                for (int i2 = 0; i2 < i; i2++) {
                    columnArr[i2].clear();
                    e(columnArr[i2], cursor, i2);
                }
                return;
            }
            throw new IllegalStateException("cursor is not in range.");
        }
    }

    public static void e(Column column, Cursor cursor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, column, cursor, i) == null) {
            int type = column.type();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            j((StringColumn) column, cursor, i);
                            return;
                        }
                        throw new IllegalStateException("Unsupported type:" + column.type());
                    }
                    i((LongColumn) column, cursor, i);
                    return;
                }
                h((IntegerColumn) column, cursor, i);
                return;
            }
            d((BooleanColumn) column, cursor, i);
        }
    }

    public static void f(Cursor cursor, Column[] columnArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, cursor, columnArr) == null) {
            g(cursor, columnArr, columnArr.length);
        }
    }

    public static boolean h(IntegerColumn integerColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, integerColumn, cursor, i)) == null) {
            if (i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                integerColumn.setValue(cursor.getInt(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean i(LongColumn longColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, longColumn, cursor, i)) == null) {
            if (i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                longColumn.setValue(cursor.getLong(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean j(StringColumn stringColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, stringColumn, cursor, i)) == null) {
            if (i >= 0 && cursor.getColumnCount() > i && !cursor.isNull(i)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                stringColumn.setValue(cursor.getString(i));
            }
            return z;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean k(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, column)) == null) {
            if (column != null && column.field.d == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
