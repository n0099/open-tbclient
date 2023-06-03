package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.z31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y31 implements z31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y31(SQLiteDatabase sQLiteDatabase) {
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

    public y31(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.z31
    public z31.a a(g41 g41Var, x31... x31VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g41Var, x31VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(g41Var, x31VarArr);
                if (i == 0) {
                    j = insert(g41Var);
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
                return new z31.a(j, i);
            }
        } else {
            return (z31.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.z31
    public int delete(g41 g41Var, x31... x31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, g41Var, x31VarArr)) == null) {
            String g = g41Var.b().g();
            Column[] b = b(g41Var, x31VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, h41.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z31
    public int update(g41 g41Var, x31... x31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, g41Var, x31VarArr)) == null) {
            String g = g41Var.b().g();
            h41 j = h41.j(b(g41Var, x31VarArr));
            return this.a.update(g, g41Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(g41 g41Var, x31... x31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g41Var, x31VarArr)) == null) {
            if (x31VarArr.length > 0) {
                return d41.d(g41Var, x31VarArr);
            }
            return d41.d(g41Var, g41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, h41 h41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, h41Var)) == null) {
            return this.a.delete(str, h41Var.l(), h41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(g41 g41Var, x31... x31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, g41Var, x31VarArr)) == null) {
            return query(g41Var, h41.j(b(g41Var, x31VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(g41 g41Var, h41 h41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, g41Var, h41Var)) == null) {
            return update(g41Var.b().g(), g41Var.a(), h41Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z31
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.z31
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.z31
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

    @Override // com.baidu.tieba.z31
    public Cursor query(l41 l41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l41Var)) == null) {
            return new m41(this.b.rawQuery(l41Var.f(), l41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(g41 g41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, g41Var)) == null) {
            f41 b = g41Var.b();
            String g = b.g();
            x31[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, g41Var.a());
            }
            Column column = d41.d(g41Var, f[0])[0];
            boolean n = d41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + g41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, g41Var.a());
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

    public int update(String str, ContentValues contentValues, h41 h41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, h41Var)) == null) {
            String[] strArr = null;
            if (h41Var != null) {
                str2 = h41Var.l();
            } else {
                str2 = null;
            }
            if (h41Var != null) {
                strArr = h41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, x31[] x31VarArr, h41 h41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, x31VarArr, h41Var)) == null) {
            return new m41(this.b.rawQuery("SELECT " + c41.d(x31VarArr) + " FROM " + str + h41Var.k(), h41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(g41 g41Var, h41 h41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, g41Var, h41Var)) == null) {
            m41 m41Var = new m41(this.b.rawQuery("SELECT " + c41.d(g41Var.b().d()) + " FROM " + g41Var.b().g() + h41Var.k(), h41Var.e()));
            boolean moveToFirst = m41Var.moveToFirst();
            if (moveToFirst) {
                e41.a(m41Var, g41Var);
            }
            m41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends g41> cls, h41 h41Var, x31[] x31VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, h41Var, x31VarArr, objArr)) == null) {
            if (x31VarArr.length != 0 && objArr.length == x31VarArr.length) {
                return update(a41.b(cls).g(), d41.c(x31VarArr, objArr), h41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, h41 h41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, h41Var)) == null) {
            return update(str, d41.e(columnArr), h41Var);
        }
        return invokeLLL.intValue;
    }
}
