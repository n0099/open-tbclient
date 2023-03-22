package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v11 implements w11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v11(SQLiteDatabase sQLiteDatabase) {
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

    public v11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.w11
    public w11.a a(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d21Var, u11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(d21Var, u11VarArr);
                if (i == 0) {
                    j = insert(d21Var);
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
                return new w11.a(j, i);
            }
        } else {
            return (w11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.w11
    public int delete(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, d21Var, u11VarArr)) == null) {
            String g = d21Var.b().g();
            Column[] b = b(d21Var, u11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, e21.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.w11
    public int update(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, d21Var, u11VarArr)) == null) {
            String g = d21Var.b().g();
            e21 j = e21.j(b(d21Var, u11VarArr));
            return this.a.update(g, d21Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d21Var, u11VarArr)) == null) {
            if (u11VarArr.length > 0) {
                return a21.d(d21Var, u11VarArr);
            }
            return a21.d(d21Var, d21Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, e21 e21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, e21Var)) == null) {
            return this.a.delete(str, e21Var.l(), e21Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, d21Var, u11VarArr)) == null) {
            return query(d21Var, e21.j(b(d21Var, u11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(d21 d21Var, e21 e21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, d21Var, e21Var)) == null) {
            return update(d21Var.b().g(), d21Var.a(), e21Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.w11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.w11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.w11
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

    @Override // com.baidu.tieba.w11
    public Cursor query(i21 i21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, i21Var)) == null) {
            return new j21(this.b.rawQuery(i21Var.f(), i21Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(d21 d21Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d21Var)) == null) {
            c21 b = d21Var.b();
            String g = b.g();
            u11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, d21Var.a());
            }
            Column column = a21.d(d21Var, f[0])[0];
            boolean n = a21.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + d21Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, d21Var.a());
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

    public int update(String str, ContentValues contentValues, e21 e21Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, e21Var)) == null) {
            String[] strArr = null;
            if (e21Var != null) {
                str2 = e21Var.l();
            } else {
                str2 = null;
            }
            if (e21Var != null) {
                strArr = e21Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, u11[] u11VarArr, e21 e21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, u11VarArr, e21Var)) == null) {
            return new j21(this.b.rawQuery("SELECT " + z11.d(u11VarArr) + " FROM " + str + e21Var.k(), e21Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(d21 d21Var, e21 e21Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, d21Var, e21Var)) == null) {
            j21 j21Var = new j21(this.b.rawQuery("SELECT " + z11.d(d21Var.b().d()) + " FROM " + d21Var.b().g() + e21Var.k(), e21Var.e()));
            boolean moveToFirst = j21Var.moveToFirst();
            if (moveToFirst) {
                b21.a(j21Var, d21Var);
            }
            j21Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends d21> cls, e21 e21Var, u11[] u11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, e21Var, u11VarArr, objArr)) == null) {
            if (u11VarArr.length != 0 && objArr.length == u11VarArr.length) {
                return update(x11.b(cls).g(), a21.c(u11VarArr, objArr), e21Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, e21 e21Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, e21Var)) == null) {
            return update(str, a21.e(columnArr), e21Var);
        }
        return invokeLLL.intValue;
    }
}
