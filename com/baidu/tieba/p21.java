package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.q21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p21 implements q21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p21(SQLiteDatabase sQLiteDatabase) {
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

    public p21(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.q21
    public q21.a a(x21 x21Var, o21... o21VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, x21Var, o21VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(x21Var, o21VarArr);
                if (i == 0) {
                    j = insert(x21Var);
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
                return new q21.a(j, i);
            }
        } else {
            return (q21.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.q21
    public int delete(x21 x21Var, o21... o21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, x21Var, o21VarArr)) == null) {
            String g = x21Var.b().g();
            Column[] b = b(x21Var, o21VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, y21.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.q21
    public int update(x21 x21Var, o21... o21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, x21Var, o21VarArr)) == null) {
            String g = x21Var.b().g();
            y21 j = y21.j(b(x21Var, o21VarArr));
            return this.a.update(g, x21Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(x21 x21Var, o21... o21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x21Var, o21VarArr)) == null) {
            if (o21VarArr.length > 0) {
                return u21.d(x21Var, o21VarArr);
            }
            return u21.d(x21Var, x21Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, y21 y21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, y21Var)) == null) {
            return this.a.delete(str, y21Var.l(), y21Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(x21 x21Var, o21... o21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, x21Var, o21VarArr)) == null) {
            return query(x21Var, y21.j(b(x21Var, o21VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(x21 x21Var, y21 y21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, x21Var, y21Var)) == null) {
            return update(x21Var.b().g(), x21Var.a(), y21Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.q21
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.q21
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.q21
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

    @Override // com.baidu.tieba.q21
    public Cursor query(c31 c31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, c31Var)) == null) {
            return new d31(this.b.rawQuery(c31Var.f(), c31Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(x21 x21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, x21Var)) == null) {
            w21 b = x21Var.b();
            String g = b.g();
            o21[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, x21Var.a());
            }
            Column column = u21.d(x21Var, f[0])[0];
            boolean n = u21.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + x21Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, x21Var.a());
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

    public int update(String str, ContentValues contentValues, y21 y21Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, y21Var)) == null) {
            String[] strArr = null;
            if (y21Var != null) {
                str2 = y21Var.l();
            } else {
                str2 = null;
            }
            if (y21Var != null) {
                strArr = y21Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, o21[] o21VarArr, y21 y21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, o21VarArr, y21Var)) == null) {
            return new d31(this.b.rawQuery("SELECT " + t21.d(o21VarArr) + " FROM " + str + y21Var.k(), y21Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(x21 x21Var, y21 y21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, x21Var, y21Var)) == null) {
            d31 d31Var = new d31(this.b.rawQuery("SELECT " + t21.d(x21Var.b().d()) + " FROM " + x21Var.b().g() + y21Var.k(), y21Var.e()));
            boolean moveToFirst = d31Var.moveToFirst();
            if (moveToFirst) {
                v21.a(d31Var, x21Var);
            }
            d31Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends x21> cls, y21 y21Var, o21[] o21VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, y21Var, o21VarArr, objArr)) == null) {
            if (o21VarArr.length != 0 && objArr.length == o21VarArr.length) {
                return update(r21.b(cls).g(), u21.c(o21VarArr, objArr), y21Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, y21 y21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, y21Var)) == null) {
            return update(str, u21.e(columnArr), y21Var);
        }
        return invokeLLL.intValue;
    }
}
