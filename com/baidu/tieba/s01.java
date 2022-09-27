package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.t01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class s01 implements t01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public s01(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.t01
    public t01.a a(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, a11Var, r01VarArr)) != null) {
            return (t01.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(a11Var, r01VarArr);
            r0 = i == 0 ? insert(a11Var) : 0L;
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
            return new t01.a(r0, i);
        }
    }

    public final Column[] b(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a11Var, r01VarArr)) == null) {
            if (r01VarArr.length > 0) {
                return x01.d(a11Var, r01VarArr);
            }
            return x01.d(a11Var, a11Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.t01
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
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

    public int delete(String str, b11 b11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, b11Var)) == null) ? this.a.delete(str, b11Var.l(), b11Var.e()) : invokeLL.intValue;
    }

    @Override // com.baidu.tieba.t01
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(a11 a11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, a11Var)) == null) {
            z01 b = a11Var.b();
            String g = b.g();
            r01[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, a11Var.a());
            }
            Column column = x01.d(a11Var, f[0])[0];
            boolean n = x01.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + a11Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, a11Var.a());
            if (n) {
                int type = column.type();
                if (type == 2) {
                    ((IntegerColumn) column).setValue((int) insert);
                } else if (type == 3) {
                    ((LongColumn) column).setValue(insert);
                } else {
                    throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    public boolean query(a11 a11Var, b11 b11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, a11Var, b11Var)) == null) {
            g11 g11Var = new g11(this.b.rawQuery("SELECT " + w01.d(a11Var.b().d()) + " FROM " + a11Var.b().g() + b11Var.k(), b11Var.e()));
            boolean moveToFirst = g11Var.moveToFirst();
            if (moveToFirst) {
                y01.a(g11Var, a11Var);
            }
            g11Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.t01
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.t01
    public int update(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, a11Var, r01VarArr)) == null) {
            String g = a11Var.b().g();
            b11 j = b11.j(b(a11Var, r01VarArr));
            return this.a.update(g, a11Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.t01
    public int delete(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, a11Var, r01VarArr)) == null) {
            String g = a11Var.b().g();
            Column[] b = b(a11Var, r01VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, b11.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s01(SQLiteDatabase sQLiteDatabase) {
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

    public int update(Class<? extends a11> cls, b11 b11Var, r01[] r01VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, b11Var, r01VarArr, objArr)) == null) {
            if (r01VarArr.length != 0 && objArr.length == r01VarArr.length) {
                return update(u01.b(cls).g(), x01.c(r01VarArr, objArr), b11Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(a11 a11Var, r01... r01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, a11Var, r01VarArr)) == null) ? query(a11Var, b11.j(b(a11Var, r01VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, r01[] r01VarArr, b11 b11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, r01VarArr, b11Var)) == null) {
            return new g11(this.b.rawQuery("SELECT " + w01.d(r01VarArr) + " FROM " + str + b11Var.k(), b11Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(a11 a11Var, b11 b11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, a11Var, b11Var)) == null) ? update(a11Var.b().g(), a11Var.a(), b11Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, b11 b11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, b11Var)) == null) {
            return this.a.update(str, contentValues, b11Var != null ? b11Var.l() : null, b11Var != null ? b11Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.t01
    public Cursor query(f11 f11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, f11Var)) == null) ? new g11(this.b.rawQuery(f11Var.f(), f11Var.b())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, b11 b11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, b11Var)) == null) ? update(str, x01.e(columnArr), b11Var) : invokeLLL.intValue;
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
}
