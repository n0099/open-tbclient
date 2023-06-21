package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.a41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z31 implements a41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z31(SQLiteDatabase sQLiteDatabase) {
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

    public z31(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.a41
    public a41.a a(h41 h41Var, y31... y31VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h41Var, y31VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(h41Var, y31VarArr);
                if (i == 0) {
                    j = insert(h41Var);
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
                return new a41.a(j, i);
            }
        } else {
            return (a41.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.a41
    public int delete(h41 h41Var, y31... y31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, h41Var, y31VarArr)) == null) {
            String g = h41Var.b().g();
            Column[] b = b(h41Var, y31VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, i41.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.a41
    public int update(h41 h41Var, y31... y31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, h41Var, y31VarArr)) == null) {
            String g = h41Var.b().g();
            i41 j = i41.j(b(h41Var, y31VarArr));
            return this.a.update(g, h41Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(h41 h41Var, y31... y31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h41Var, y31VarArr)) == null) {
            if (y31VarArr.length > 0) {
                return e41.d(h41Var, y31VarArr);
            }
            return e41.d(h41Var, h41Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, i41 i41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, i41Var)) == null) {
            return this.a.delete(str, i41Var.l(), i41Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(h41 h41Var, y31... y31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, h41Var, y31VarArr)) == null) {
            return query(h41Var, i41.j(b(h41Var, y31VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(h41 h41Var, i41 i41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, h41Var, i41Var)) == null) {
            return update(h41Var.b().g(), h41Var.a(), i41Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.a41
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.a41
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.a41
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

    @Override // com.baidu.tieba.a41
    public Cursor query(m41 m41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m41Var)) == null) {
            return new n41(this.b.rawQuery(m41Var.f(), m41Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(h41 h41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, h41Var)) == null) {
            g41 b = h41Var.b();
            String g = b.g();
            y31[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, h41Var.a());
            }
            Column column = e41.d(h41Var, f[0])[0];
            boolean n = e41.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + h41Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, h41Var.a());
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

    public int update(String str, ContentValues contentValues, i41 i41Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, i41Var)) == null) {
            String[] strArr = null;
            if (i41Var != null) {
                str2 = i41Var.l();
            } else {
                str2 = null;
            }
            if (i41Var != null) {
                strArr = i41Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, y31[] y31VarArr, i41 i41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, y31VarArr, i41Var)) == null) {
            return new n41(this.b.rawQuery("SELECT " + d41.d(y31VarArr) + " FROM " + str + i41Var.k(), i41Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(h41 h41Var, i41 i41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, h41Var, i41Var)) == null) {
            n41 n41Var = new n41(this.b.rawQuery("SELECT " + d41.d(h41Var.b().d()) + " FROM " + h41Var.b().g() + i41Var.k(), i41Var.e()));
            boolean moveToFirst = n41Var.moveToFirst();
            if (moveToFirst) {
                f41.a(n41Var, h41Var);
            }
            n41Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends h41> cls, i41 i41Var, y31[] y31VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, i41Var, y31VarArr, objArr)) == null) {
            if (y31VarArr.length != 0 && objArr.length == y31VarArr.length) {
                return update(b41.b(cls).g(), e41.c(y31VarArr, objArr), i41Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, i41 i41Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, i41Var)) == null) {
            return update(str, e41.e(columnArr), i41Var);
        }
        return invokeLLL.intValue;
    }
}
