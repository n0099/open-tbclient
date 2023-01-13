package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.q11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class p11 implements q11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p11(SQLiteDatabase sQLiteDatabase) {
        this(sQLiteDatabase, sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SQLiteDatabase) objArr2[0], (SQLiteDatabase) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public p11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, sQLiteDatabase2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = sQLiteDatabase;
        this.b = sQLiteDatabase2;
    }

    @Override // com.baidu.tieba.q11
    public q11.a a(x11 x11Var, o11... o11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, x11Var, o11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(x11Var, o11VarArr);
                if (i == 0) {
                    j = insert(x11Var);
                }
                this.a.setTransactionSuccessful();
            } catch (Exception unused) {
                i = 0;
            } catch (Throwable th) {
                try {
                    this.a.endTransaction();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                this.a.endTransaction();
            } catch (Exception unused3) {
                return new q11.a(j, i);
            }
        } else {
            return (q11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.q11
    public int delete(x11 x11Var, o11... o11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, x11Var, o11VarArr)) == null) {
            String g = x11Var.b().g();
            Column[] b = b(x11Var, o11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, y11.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.q11
    public int update(x11 x11Var, o11... o11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, x11Var, o11VarArr)) == null) {
            String g = x11Var.b().g();
            y11 j = y11.j(b(x11Var, o11VarArr));
            return this.a.update(g, x11Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(x11 x11Var, o11... o11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x11Var, o11VarArr)) == null) {
            if (o11VarArr.length > 0) {
                return u11.d(x11Var, o11VarArr);
            }
            return u11.d(x11Var, x11Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, y11 y11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, y11Var)) == null) {
            return this.a.delete(str, y11Var.l(), y11Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(x11 x11Var, o11... o11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, x11Var, o11VarArr)) == null) {
            return query(x11Var, y11.j(b(x11Var, o11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(x11 x11Var, y11 y11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, x11Var, y11Var)) == null) {
            return update(x11Var.b().g(), x11Var.a(), y11Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.q11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.q11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.q11
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final boolean c(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, columnArr)) == null) {
            for (Column column : columnArr) {
                if (column == null || !column.isAssignedValue) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.q11
    public Cursor query(c21 c21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c21Var)) == null) {
            return new d21(this.b.rawQuery(c21Var.f(), c21Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(x11 x11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x11Var)) == null) {
            w11 b = x11Var.b();
            String g = b.g();
            o11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, x11Var.a());
            }
            Column column = u11.d(x11Var, f[0])[0];
            boolean n = u11.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + x11Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, x11Var.a());
            if (n) {
                int type = column.type();
                if (type != 2) {
                    if (type == 3) {
                        ((LongColumn) column).setValue(insert);
                    } else {
                        throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                    }
                } else {
                    ((IntegerColumn) column).setValue((int) insert);
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    public long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, objArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < strArr.length; i++) {
                contentValues.put(strArr[i], String.valueOf(objArr[i]));
            }
            return this.a.insert(str, null, contentValues);
        }
        return invokeLLL.longValue;
    }

    public int update(String str, ContentValues contentValues, y11 y11Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, y11Var)) == null) {
            String[] strArr = null;
            if (y11Var != null) {
                str2 = y11Var.l();
            } else {
                str2 = null;
            }
            if (y11Var != null) {
                strArr = y11Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, o11[] o11VarArr, y11 y11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, o11VarArr, y11Var)) == null) {
            return new d21(this.b.rawQuery("SELECT " + t11.d(o11VarArr) + " FROM " + str + y11Var.k(), y11Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(x11 x11Var, y11 y11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, x11Var, y11Var)) == null) {
            d21 d21Var = new d21(this.b.rawQuery("SELECT " + t11.d(x11Var.b().d()) + " FROM " + x11Var.b().g() + y11Var.k(), y11Var.e()));
            boolean moveToFirst = d21Var.moveToFirst();
            if (moveToFirst) {
                v11.a(d21Var, x11Var);
            }
            d21Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends x11> cls, y11 y11Var, o11[] o11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, y11Var, o11VarArr, objArr)) == null) {
            if (o11VarArr.length != 0 && objArr.length == o11VarArr.length) {
                return update(r11.b(cls).g(), u11.c(o11VarArr, objArr), y11Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, y11 y11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, y11Var)) == null) {
            return update(str, u11.e(columnArr), y11Var);
        }
        return invokeLLL.intValue;
    }
}
