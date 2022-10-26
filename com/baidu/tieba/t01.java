package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.u01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class t01 implements u01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t01(SQLiteDatabase sQLiteDatabase) {
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

    public t01(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.u01
    public u01.a a(b11 b11Var, s01... s01VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b11Var, s01VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(b11Var, s01VarArr);
                if (i == 0) {
                    j = insert(b11Var);
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
                return new u01.a(j, i);
            }
        } else {
            return (u01.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.u01
    public int delete(b11 b11Var, s01... s01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, b11Var, s01VarArr)) == null) {
            String g = b11Var.b().g();
            Column[] b = b(b11Var, s01VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, c11.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.u01
    public int update(b11 b11Var, s01... s01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, b11Var, s01VarArr)) == null) {
            String g = b11Var.b().g();
            c11 j = c11.j(b(b11Var, s01VarArr));
            return this.a.update(g, b11Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(b11 b11Var, s01... s01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b11Var, s01VarArr)) == null) {
            if (s01VarArr.length > 0) {
                return y01.d(b11Var, s01VarArr);
            }
            return y01.d(b11Var, b11Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, c11 c11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, c11Var)) == null) {
            return this.a.delete(str, c11Var.l(), c11Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(b11 b11Var, s01... s01VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, b11Var, s01VarArr)) == null) {
            return query(b11Var, c11.j(b(b11Var, s01VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(b11 b11Var, c11 c11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, b11Var, c11Var)) == null) {
            return update(b11Var.b().g(), b11Var.a(), c11Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.u01
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.u01
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.u01
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

    @Override // com.baidu.tieba.u01
    public Cursor query(g11 g11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, g11Var)) == null) {
            return new h11(this.b.rawQuery(g11Var.f(), g11Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(b11 b11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, b11Var)) == null) {
            a11 b = b11Var.b();
            String g = b.g();
            s01[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, b11Var.a());
            }
            Column column = y01.d(b11Var, f[0])[0];
            boolean n = y01.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + b11Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, b11Var.a());
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

    public int update(String str, ContentValues contentValues, c11 c11Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, c11Var)) == null) {
            String[] strArr = null;
            if (c11Var != null) {
                str2 = c11Var.l();
            } else {
                str2 = null;
            }
            if (c11Var != null) {
                strArr = c11Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, s01[] s01VarArr, c11 c11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, s01VarArr, c11Var)) == null) {
            return new h11(this.b.rawQuery("SELECT " + x01.d(s01VarArr) + " FROM " + str + c11Var.k(), c11Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(b11 b11Var, c11 c11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, b11Var, c11Var)) == null) {
            h11 h11Var = new h11(this.b.rawQuery("SELECT " + x01.d(b11Var.b().d()) + " FROM " + b11Var.b().g() + c11Var.k(), c11Var.e()));
            boolean moveToFirst = h11Var.moveToFirst();
            if (moveToFirst) {
                z01.a(h11Var, b11Var);
            }
            h11Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class cls, c11 c11Var, s01[] s01VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, c11Var, s01VarArr, objArr)) == null) {
            if (s01VarArr.length != 0 && objArr.length == s01VarArr.length) {
                return update(v01.b(cls).g(), y01.c(s01VarArr, objArr), c11Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, c11 c11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, c11Var)) == null) {
            return update(str, y01.e(columnArr), c11Var);
        }
        return invokeLLL.intValue;
    }
}
