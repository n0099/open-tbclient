package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.x11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w11 implements x11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w11(SQLiteDatabase sQLiteDatabase) {
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

    public w11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.x11
    public x11.a a(e21 e21Var, v11... v11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, e21Var, v11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(e21Var, v11VarArr);
                if (i == 0) {
                    j = insert(e21Var);
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
                return new x11.a(j, i);
            }
        } else {
            return (x11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.x11
    public int delete(e21 e21Var, v11... v11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, e21Var, v11VarArr)) == null) {
            String g = e21Var.b().g();
            Column[] b = b(e21Var, v11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, f21.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.x11
    public int update(e21 e21Var, v11... v11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, e21Var, v11VarArr)) == null) {
            String g = e21Var.b().g();
            f21 j = f21.j(b(e21Var, v11VarArr));
            return this.a.update(g, e21Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(e21 e21Var, v11... v11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e21Var, v11VarArr)) == null) {
            if (v11VarArr.length > 0) {
                return b21.d(e21Var, v11VarArr);
            }
            return b21.d(e21Var, e21Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, f21 f21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, f21Var)) == null) {
            return this.a.delete(str, f21Var.l(), f21Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(e21 e21Var, v11... v11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, e21Var, v11VarArr)) == null) {
            return query(e21Var, f21.j(b(e21Var, v11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(e21 e21Var, f21 f21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, e21Var, f21Var)) == null) {
            return update(e21Var.b().g(), e21Var.a(), f21Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.x11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.x11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.x11
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

    @Override // com.baidu.tieba.x11
    public Cursor query(j21 j21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, j21Var)) == null) {
            return new k21(this.b.rawQuery(j21Var.f(), j21Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(e21 e21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e21Var)) == null) {
            d21 b = e21Var.b();
            String g = b.g();
            v11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, e21Var.a());
            }
            Column column = b21.d(e21Var, f[0])[0];
            boolean n = b21.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + e21Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, e21Var.a());
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

    public int update(String str, ContentValues contentValues, f21 f21Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, f21Var)) == null) {
            String[] strArr = null;
            if (f21Var != null) {
                str2 = f21Var.l();
            } else {
                str2 = null;
            }
            if (f21Var != null) {
                strArr = f21Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, v11[] v11VarArr, f21 f21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, v11VarArr, f21Var)) == null) {
            return new k21(this.b.rawQuery("SELECT " + a21.d(v11VarArr) + " FROM " + str + f21Var.k(), f21Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(e21 e21Var, f21 f21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, e21Var, f21Var)) == null) {
            k21 k21Var = new k21(this.b.rawQuery("SELECT " + a21.d(e21Var.b().d()) + " FROM " + e21Var.b().g() + f21Var.k(), f21Var.e()));
            boolean moveToFirst = k21Var.moveToFirst();
            if (moveToFirst) {
                c21.a(k21Var, e21Var);
            }
            k21Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends e21> cls, f21 f21Var, v11[] v11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, f21Var, v11VarArr, objArr)) == null) {
            if (v11VarArr.length != 0 && objArr.length == v11VarArr.length) {
                return update(y11.b(cls).g(), b21.c(v11VarArr, objArr), f21Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, f21 f21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, f21Var)) == null) {
            return update(str, b21.e(columnArr), f21Var);
        }
        return invokeLLL.intValue;
    }
}
