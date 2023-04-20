package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.y11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x11 implements y11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x11(SQLiteDatabase sQLiteDatabase) {
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

    public x11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.y11
    public y11.a a(f21 f21Var, w11... w11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f21Var, w11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(f21Var, w11VarArr);
                if (i == 0) {
                    j = insert(f21Var);
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
                return new y11.a(j, i);
            }
        } else {
            return (y11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.y11
    public int delete(f21 f21Var, w11... w11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, f21Var, w11VarArr)) == null) {
            String g = f21Var.b().g();
            Column[] b = b(f21Var, w11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, g21.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y11
    public int update(f21 f21Var, w11... w11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, f21Var, w11VarArr)) == null) {
            String g = f21Var.b().g();
            g21 j = g21.j(b(f21Var, w11VarArr));
            return this.a.update(g, f21Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(f21 f21Var, w11... w11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f21Var, w11VarArr)) == null) {
            if (w11VarArr.length > 0) {
                return c21.d(f21Var, w11VarArr);
            }
            return c21.d(f21Var, f21Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, g21 g21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, g21Var)) == null) {
            return this.a.delete(str, g21Var.l(), g21Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(f21 f21Var, w11... w11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, f21Var, w11VarArr)) == null) {
            return query(f21Var, g21.j(b(f21Var, w11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(f21 f21Var, g21 g21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, f21Var, g21Var)) == null) {
            return update(f21Var.b().g(), f21Var.a(), g21Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.y11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.y11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.y11
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

    @Override // com.baidu.tieba.y11
    public Cursor query(k21 k21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k21Var)) == null) {
            return new l21(this.b.rawQuery(k21Var.f(), k21Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(f21 f21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f21Var)) == null) {
            e21 b = f21Var.b();
            String g = b.g();
            w11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, f21Var.a());
            }
            Column column = c21.d(f21Var, f[0])[0];
            boolean n = c21.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + f21Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, f21Var.a());
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

    public int update(String str, ContentValues contentValues, g21 g21Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, g21Var)) == null) {
            String[] strArr = null;
            if (g21Var != null) {
                str2 = g21Var.l();
            } else {
                str2 = null;
            }
            if (g21Var != null) {
                strArr = g21Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, w11[] w11VarArr, g21 g21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, w11VarArr, g21Var)) == null) {
            return new l21(this.b.rawQuery("SELECT " + b21.d(w11VarArr) + " FROM " + str + g21Var.k(), g21Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(f21 f21Var, g21 g21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, f21Var, g21Var)) == null) {
            l21 l21Var = new l21(this.b.rawQuery("SELECT " + b21.d(f21Var.b().d()) + " FROM " + f21Var.b().g() + g21Var.k(), g21Var.e()));
            boolean moveToFirst = l21Var.moveToFirst();
            if (moveToFirst) {
                d21.a(l21Var, f21Var);
            }
            l21Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends f21> cls, g21 g21Var, w11[] w11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, g21Var, w11VarArr, objArr)) == null) {
            if (w11VarArr.length != 0 && objArr.length == w11VarArr.length) {
                return update(z11.b(cls).g(), c21.c(w11VarArr, objArr), g21Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, g21 g21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, g21Var)) == null) {
            return update(str, c21.e(columnArr), g21Var);
        }
        return invokeLLL.intValue;
    }
}
