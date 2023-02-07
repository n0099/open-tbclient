package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.z21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y21 implements z21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public y21(SQLiteDatabase sQLiteDatabase) {
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

    public y21(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.z21
    public z21.a a(g31 g31Var, x21... x21VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g31Var, x21VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(g31Var, x21VarArr);
                if (i == 0) {
                    j = insert(g31Var);
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
                return new z21.a(j, i);
            }
        } else {
            return (z21.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.z21
    public int delete(g31 g31Var, x21... x21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, g31Var, x21VarArr)) == null) {
            String g = g31Var.b().g();
            Column[] b = b(g31Var, x21VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, h31.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z21
    public int update(g31 g31Var, x21... x21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, g31Var, x21VarArr)) == null) {
            String g = g31Var.b().g();
            h31 j = h31.j(b(g31Var, x21VarArr));
            return this.a.update(g, g31Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(g31 g31Var, x21... x21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g31Var, x21VarArr)) == null) {
            if (x21VarArr.length > 0) {
                return d31.d(g31Var, x21VarArr);
            }
            return d31.d(g31Var, g31Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, h31 h31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, h31Var)) == null) {
            return this.a.delete(str, h31Var.l(), h31Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(g31 g31Var, x21... x21VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, g31Var, x21VarArr)) == null) {
            return query(g31Var, h31.j(b(g31Var, x21VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(g31 g31Var, h31 h31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, g31Var, h31Var)) == null) {
            return update(g31Var.b().g(), g31Var.a(), h31Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.z21
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.z21
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.z21
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

    @Override // com.baidu.tieba.z21
    public Cursor query(l31 l31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, l31Var)) == null) {
            return new m31(this.b.rawQuery(l31Var.f(), l31Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(g31 g31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, g31Var)) == null) {
            f31 b = g31Var.b();
            String g = b.g();
            x21[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, g31Var.a());
            }
            Column column = d31.d(g31Var, f[0])[0];
            boolean n = d31.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + g31Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, g31Var.a());
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

    public int update(String str, ContentValues contentValues, h31 h31Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, h31Var)) == null) {
            String[] strArr = null;
            if (h31Var != null) {
                str2 = h31Var.l();
            } else {
                str2 = null;
            }
            if (h31Var != null) {
                strArr = h31Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, x21[] x21VarArr, h31 h31Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, x21VarArr, h31Var)) == null) {
            return new m31(this.b.rawQuery("SELECT " + c31.d(x21VarArr) + " FROM " + str + h31Var.k(), h31Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(g31 g31Var, h31 h31Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, g31Var, h31Var)) == null) {
            m31 m31Var = new m31(this.b.rawQuery("SELECT " + c31.d(g31Var.b().d()) + " FROM " + g31Var.b().g() + h31Var.k(), h31Var.e()));
            boolean moveToFirst = m31Var.moveToFirst();
            if (moveToFirst) {
                e31.a(m31Var, g31Var);
            }
            m31Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends g31> cls, h31 h31Var, x21[] x21VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, h31Var, x21VarArr, objArr)) == null) {
            if (x21VarArr.length != 0 && objArr.length == x21VarArr.length) {
                return update(a31.b(cls).g(), d31.c(x21VarArr, objArr), h31Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, h31 h31Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, h31Var)) == null) {
            return update(str, d31.e(columnArr), h31Var);
        }
        return invokeLLL.intValue;
    }
}
