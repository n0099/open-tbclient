package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.a21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z11 implements a21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z11(SQLiteDatabase sQLiteDatabase) {
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

    public z11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.a21
    public a21.a a(h21 h21Var, y11... y11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h21Var, y11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(h21Var, y11VarArr);
                if (i == 0) {
                    j = insert(h21Var);
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
                return new a21.a(j, i);
            }
        } else {
            return (a21.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.a21
    public int delete(h21 h21Var, y11... y11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, h21Var, y11VarArr)) == null) {
            String g = h21Var.b().g();
            Column[] b = b(h21Var, y11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, i21.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.a21
    public int update(h21 h21Var, y11... y11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, h21Var, y11VarArr)) == null) {
            String g = h21Var.b().g();
            i21 j = i21.j(b(h21Var, y11VarArr));
            return this.a.update(g, h21Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(h21 h21Var, y11... y11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h21Var, y11VarArr)) == null) {
            if (y11VarArr.length > 0) {
                return e21.d(h21Var, y11VarArr);
            }
            return e21.d(h21Var, h21Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, i21 i21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, i21Var)) == null) {
            return this.a.delete(str, i21Var.l(), i21Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(h21 h21Var, y11... y11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, h21Var, y11VarArr)) == null) {
            return query(h21Var, i21.j(b(h21Var, y11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(h21 h21Var, i21 i21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, h21Var, i21Var)) == null) {
            return update(h21Var.b().g(), h21Var.a(), i21Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.a21
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.a21
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.a21
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

    @Override // com.baidu.tieba.a21
    public Cursor query(m21 m21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m21Var)) == null) {
            return new n21(this.b.rawQuery(m21Var.f(), m21Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(h21 h21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, h21Var)) == null) {
            g21 b = h21Var.b();
            String g = b.g();
            y11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, h21Var.a());
            }
            Column column = e21.d(h21Var, f[0])[0];
            boolean n = e21.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + h21Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, h21Var.a());
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

    public int update(String str, ContentValues contentValues, i21 i21Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, i21Var)) == null) {
            String[] strArr = null;
            if (i21Var != null) {
                str2 = i21Var.l();
            } else {
                str2 = null;
            }
            if (i21Var != null) {
                strArr = i21Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, y11[] y11VarArr, i21 i21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, y11VarArr, i21Var)) == null) {
            return new n21(this.b.rawQuery("SELECT " + d21.d(y11VarArr) + " FROM " + str + i21Var.k(), i21Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(h21 h21Var, i21 i21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, h21Var, i21Var)) == null) {
            n21 n21Var = new n21(this.b.rawQuery("SELECT " + d21.d(h21Var.b().d()) + " FROM " + h21Var.b().g() + i21Var.k(), i21Var.e()));
            boolean moveToFirst = n21Var.moveToFirst();
            if (moveToFirst) {
                f21.a(n21Var, h21Var);
            }
            n21Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends h21> cls, i21 i21Var, y11[] y11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, i21Var, y11VarArr, objArr)) == null) {
            if (y11VarArr.length != 0 && objArr.length == y11VarArr.length) {
                return update(b21.b(cls).g(), e21.c(y11VarArr, objArr), i21Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, i21 i21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, i21Var)) == null) {
            return update(str, e21.e(columnArr), i21Var);
        }
        return invokeLLL.intValue;
    }
}
