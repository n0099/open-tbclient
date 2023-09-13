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
import java.util.Arrays;
/* loaded from: classes7.dex */
public class n41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Object obj, Class<?>... clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, clsArr) == null) {
            for (Class<?> cls : clsArr) {
                if (cls == obj.getClass()) {
                    return;
                }
            }
            throw new IllegalArgumentException("Expected " + Arrays.toString(clsArr) + ", but got" + obj.getClass().getName());
        }
    }

    public static ContentValues b(Column[] columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, columnArr)) == null) {
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

    public static ContentValues e(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, columnArr)) == null) {
            ContentValues contentValues = new ContentValues(columnArr.length);
            for (Column column : columnArr) {
                if (column.isAssignedValue) {
                    int type = column.type();
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                                if (type == 4) {
                                    contentValues.put(column.field.b, h41.d(column));
                                } else {
                                    throw new IllegalArgumentException("Unsupported column type.");
                                }
                            } else {
                                contentValues.put(column.field.b, Long.valueOf(h41.c(column)));
                            }
                        } else {
                            contentValues.put(column.field.b, Integer.valueOf(h41.b(column)));
                        }
                    } else {
                        contentValues.put(column.field.b, Integer.valueOf(h41.a(column) ? 1 : 0));
                    }
                } else {
                    throw new IllegalArgumentException("All columns must be initialized.");
                }
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static ContentValues c(h41[] h41VarArr, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, h41VarArr, objArr)) == null) {
            if (h41VarArr.length == objArr.length) {
                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < h41VarArr.length; i++) {
                    h41 h41Var = h41VarArr[i];
                    Object obj = objArr[i];
                    int i2 = h41Var.a;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    a(obj, String.class, CharSequence.class);
                                    contentValues.put(h41Var.b, (String) obj);
                                } else {
                                    throw new IllegalArgumentException("Unsupported field type.");
                                }
                            } else {
                                a(obj, Long.class, Integer.class, Short.class, Byte.class);
                                contentValues.put(h41Var.b, Long.valueOf(((Long) obj).longValue()));
                            }
                        } else {
                            a(obj, Integer.class, Short.class, Byte.class);
                            contentValues.put(h41Var.b, Integer.valueOf(((Integer) obj).intValue()));
                        }
                    } else {
                        a(obj, Boolean.class);
                        contentValues.put(h41Var.b, Boolean.valueOf(((Boolean) obj).booleanValue()));
                    }
                }
                return contentValues;
            }
            throw new IllegalArgumentException("invalid columns & values pair.");
        }
        return (ContentValues) invokeLL.objValue;
    }

    public static Column[] d(q41 q41Var, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, q41Var, h41VarArr)) == null) {
            Column[] columnArr = new Column[h41VarArr.length];
            for (int i = 0; i < h41VarArr.length; i++) {
                columnArr[i] = q41Var.b().c()[g41.a(q41Var.b().d(), h41VarArr[i])];
            }
            return columnArr;
        }
        return (Column[]) invokeLL.objValue;
    }

    public static void f(Column column, Column column2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, column, column2) == null) && column.type() == column2.type()) {
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

    public static boolean g(BooleanColumn booleanColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, booleanColumn, cursor, i)) == null) {
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

    public static void j(Cursor cursor, Column[] columnArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, null, cursor, columnArr, i) == null) {
            if (!cursor.isBeforeFirst() && !cursor.isAfterLast()) {
                for (int i2 = 0; i2 < i; i2++) {
                    columnArr[i2].clear();
                    h(columnArr[i2], cursor, i2);
                }
                return;
            }
            throw new IllegalStateException("cursor is not in range.");
        }
    }

    public static void h(Column column, Cursor cursor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, column, cursor, i) == null) {
            int type = column.type();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            m((StringColumn) column, cursor, i);
                            return;
                        }
                        throw new IllegalStateException("Unsupported type:" + column.type());
                    }
                    l((LongColumn) column, cursor, i);
                    return;
                }
                k((IntegerColumn) column, cursor, i);
                return;
            }
            g((BooleanColumn) column, cursor, i);
        }
    }

    public static void i(Cursor cursor, Column[] columnArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, cursor, columnArr) == null) {
            j(cursor, columnArr, columnArr.length);
        }
    }

    public static boolean k(IntegerColumn integerColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65546, null, integerColumn, cursor, i)) == null) {
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

    public static boolean l(LongColumn longColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, longColumn, cursor, i)) == null) {
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

    public static boolean m(StringColumn stringColumn, Cursor cursor, int i) {
        InterceptResult invokeLLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65548, null, stringColumn, cursor, i)) == null) {
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

    public static boolean n(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, column)) == null) {
            if (column != null && column.field.d == 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
