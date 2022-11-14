package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.m11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l11 implements m11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l11(SQLiteDatabase sQLiteDatabase) {
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

    public l11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.m11
    public m11.a a(t11 t11Var, k11... k11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t11Var, k11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(t11Var, k11VarArr);
                if (i == 0) {
                    j = insert(t11Var);
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
                return new m11.a(j, i);
            }
        } else {
            return (m11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.m11
    public int delete(t11 t11Var, k11... k11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, t11Var, k11VarArr)) == null) {
            String g = t11Var.b().g();
            Column[] b = b(t11Var, k11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, u11.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.m11
    public int update(t11 t11Var, k11... k11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, t11Var, k11VarArr)) == null) {
            String g = t11Var.b().g();
            u11 j = u11.j(b(t11Var, k11VarArr));
            return this.a.update(g, t11Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(t11 t11Var, k11... k11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t11Var, k11VarArr)) == null) {
            if (k11VarArr.length > 0) {
                return q11.d(t11Var, k11VarArr);
            }
            return q11.d(t11Var, t11Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, u11 u11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, u11Var)) == null) {
            return this.a.delete(str, u11Var.l(), u11Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(t11 t11Var, k11... k11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, t11Var, k11VarArr)) == null) {
            return query(t11Var, u11.j(b(t11Var, k11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(t11 t11Var, u11 u11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, t11Var, u11Var)) == null) {
            return update(t11Var.b().g(), t11Var.a(), u11Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.m11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.m11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.m11
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

    @Override // com.baidu.tieba.m11
    public Cursor query(y11 y11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, y11Var)) == null) {
            return new z11(this.b.rawQuery(y11Var.f(), y11Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(t11 t11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, t11Var)) == null) {
            s11 b = t11Var.b();
            String g = b.g();
            k11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, t11Var.a());
            }
            Column column = q11.d(t11Var, f[0])[0];
            boolean n = q11.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + t11Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, t11Var.a());
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

    public int update(String str, ContentValues contentValues, u11 u11Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, u11Var)) == null) {
            String[] strArr = null;
            if (u11Var != null) {
                str2 = u11Var.l();
            } else {
                str2 = null;
            }
            if (u11Var != null) {
                strArr = u11Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, k11[] k11VarArr, u11 u11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, k11VarArr, u11Var)) == null) {
            return new z11(this.b.rawQuery("SELECT " + p11.d(k11VarArr) + " FROM " + str + u11Var.k(), u11Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(t11 t11Var, u11 u11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, t11Var, u11Var)) == null) {
            z11 z11Var = new z11(this.b.rawQuery("SELECT " + p11.d(t11Var.b().d()) + " FROM " + t11Var.b().g() + u11Var.k(), u11Var.e()));
            boolean moveToFirst = z11Var.moveToFirst();
            if (moveToFirst) {
                r11.a(z11Var, t11Var);
            }
            z11Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends t11> cls, u11 u11Var, k11[] k11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, u11Var, k11VarArr, objArr)) == null) {
            if (k11VarArr.length != 0 && objArr.length == k11VarArr.length) {
                return update(n11.b(cls).g(), q11.c(k11VarArr, objArr), u11Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, u11 u11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, u11Var)) == null) {
            return update(str, q11.e(columnArr), u11Var);
        }
        return invokeLLL.intValue;
    }
}
