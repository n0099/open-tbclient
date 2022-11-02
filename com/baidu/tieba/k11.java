package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.l11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k11 implements l11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k11(SQLiteDatabase sQLiteDatabase) {
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

    public k11(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.l11
    public l11.a a(s11 s11Var, j11... j11VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, s11Var, j11VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = update(s11Var, j11VarArr);
                if (i == 0) {
                    j = insert(s11Var);
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
                return new l11.a(j, i);
            }
        } else {
            return (l11.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.l11
    public int delete(s11 s11Var, j11... j11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, s11Var, j11VarArr)) == null) {
            String g = s11Var.b().g();
            Column[] b = b(s11Var, j11VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, t11.j(b));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.l11
    public int update(s11 s11Var, j11... j11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, s11Var, j11VarArr)) == null) {
            String g = s11Var.b().g();
            t11 j = t11.j(b(s11Var, j11VarArr));
            return this.a.update(g, s11Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] b(s11 s11Var, j11... j11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s11Var, j11VarArr)) == null) {
            if (j11VarArr.length > 0) {
                return p11.d(s11Var, j11VarArr);
            }
            return p11.d(s11Var, s11Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    public int delete(String str, t11 t11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, t11Var)) == null) {
            return this.a.delete(str, t11Var.l(), t11Var.e());
        }
        return invokeLL.intValue;
    }

    public boolean query(s11 s11Var, j11... j11VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, s11Var, j11VarArr)) == null) {
            return query(s11Var, t11.j(b(s11Var, j11VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int update(s11 s11Var, t11 t11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, s11Var, t11Var)) == null) {
            return update(s11Var.b().g(), s11Var.a(), t11Var);
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.l11
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.l11
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.l11
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

    @Override // com.baidu.tieba.l11
    public Cursor query(x11 x11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, x11Var)) == null) {
            return new y11(this.b.rawQuery(x11Var.f(), x11Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public long insert(s11 s11Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, s11Var)) == null) {
            r11 b = s11Var.b();
            String g = b.g();
            j11[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, s11Var.a());
            }
            Column column = p11.d(s11Var, f[0])[0];
            boolean n = p11.n(column);
            if (n && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + s11Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, s11Var.a());
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

    public int update(String str, ContentValues contentValues, t11 t11Var) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, t11Var)) == null) {
            String[] strArr = null;
            if (t11Var != null) {
                str2 = t11Var.l();
            } else {
                str2 = null;
            }
            if (t11Var != null) {
                strArr = t11Var.e();
            }
            return this.a.update(str, contentValues, str2, strArr);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(String str, j11[] j11VarArr, t11 t11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, j11VarArr, t11Var)) == null) {
            return new y11(this.b.rawQuery("SELECT " + o11.d(j11VarArr) + " FROM " + str + t11Var.k(), t11Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public boolean query(s11 s11Var, t11 t11Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, s11Var, t11Var)) == null) {
            y11 y11Var = new y11(this.b.rawQuery("SELECT " + o11.d(s11Var.b().d()) + " FROM " + s11Var.b().g() + t11Var.k(), t11Var.e()));
            boolean moveToFirst = y11Var.moveToFirst();
            if (moveToFirst) {
                q11.a(y11Var, s11Var);
            }
            y11Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    public int update(Class<? extends s11> cls, t11 t11Var, j11[] j11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, t11Var, j11VarArr, objArr)) == null) {
            if (j11VarArr.length != 0 && objArr.length == j11VarArr.length) {
                return update(m11.b(cls).g(), p11.c(j11VarArr, objArr), t11Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public int update(String str, Column[] columnArr, t11 t11Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, t11Var)) == null) {
            return update(str, p11.e(columnArr), t11Var);
        }
        return invokeLLL.intValue;
    }
}
