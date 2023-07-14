package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.z41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y41 implements z41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y41(SQLiteDatabase sQLiteDatabase) {
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

    public y41(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.z41
    public z41.a a(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g51Var, x41VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(g51Var, x41VarArr);
                if (i == 0) {
                    j = insert(g51Var);
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
                return new z41.a(j, i);
            }
        } else {
            return (z41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.z41
    public int delete(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, g51Var, x41VarArr)) == null) {
            String g = g51Var.b().g();
            Column[] c = c(g51Var, x41VarArr);
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (!d(c[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, h51.j(c));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z41
    public int update(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, g51Var, x41VarArr)) == null) {
            String g = g51Var.b().g();
            h51 j = h51.j(c(g51Var, x41VarArr));
            return this.a.update(g, g51Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.z41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.z41
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    public final Column[] c(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, g51Var, x41VarArr)) == null) {
            if (x41VarArr.length > 0) {
                return d51.d(g51Var, x41VarArr);
            }
            return d51.d(g51Var, g51Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, h51 h51Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, h51Var)) == null) {
            return this.a.delete(str, h51Var.l(), h51Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(g51 g51Var, x41... x41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, g51Var, x41VarArr)) == null) {
            return query(g51Var, h51.j(c(g51Var, x41VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(g51 g51Var, h51 h51Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, g51Var, h51Var)) == null) {
            return update(g51Var.b().g(), g51Var.a(), h51Var);
        }
        return invokeLL.intValue;
    }

    public final boolean d(Column... columnArr) {
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

    @Override // com.baidu.tieba.z41
    public Cursor query(l51 l51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l51Var)) == null) {
            return new m51(this.b.rawQuery(l51Var.f(), l51Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(g51 g51Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, g51Var)) == null) {
            f51 b = g51Var.b();
            String g = b.g();
            x41[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, g51Var.a());
            }
            Column column = d51.d(g51Var, f[0])[0];
            boolean n = d51.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + g51Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, g51Var.a());
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

    public int update(String str, ContentValues contentValues, h51 h51Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, h51Var)) == null) {
            String[] strArr = null;
            if (h51Var != null) {
                str2 = h51Var.l();
            } else {
                str2 = null;
            }
            if (h51Var != null) {
                strArr = h51Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, x41[] x41VarArr, h51 h51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, x41VarArr, h51Var)) == null) {
            return new m51(this.b.rawQuery("SELECT " + c51.d(x41VarArr) + " FROM " + str + h51Var.k(), h51Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(g51 g51Var, h51 h51Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, g51Var, h51Var)) == null) {
            m51 m51Var = new m51(this.b.rawQuery("SELECT " + c51.d(g51Var.b().d()) + " FROM " + g51Var.b().g() + h51Var.k(), h51Var.e()));
            boolean moveToFirst = m51Var.moveToFirst();
            if (moveToFirst) {
                e51.a(m51Var, g51Var);
            }
            m51Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends g51> cls, h51 h51Var, x41[] x41VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, h51Var, x41VarArr, objArr)) == null) {
            if (x41VarArr.length != 0 && objArr.length == x41VarArr.length) {
                return update(a51.b(cls).g(), d51.c(x41VarArr, objArr), h51Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, h51 h51Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, h51Var)) == null) {
            return update(str, d51.e(columnArr), h51Var);
        }
        return invokeLLL.intValue;
    }
}
