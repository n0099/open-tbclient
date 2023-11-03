package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.mz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lz0 implements mz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public lz0(SQLiteDatabase sQLiteDatabase) {
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

    public lz0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.mz0
    public mz0.a a(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tz0Var, kz0VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = f(tz0Var, kz0VarArr);
                if (i == 0) {
                    j = c(tz0Var);
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
                return new mz0.a(j, i);
            }
        } else {
            return (mz0.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.mz0
    public int e(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, tz0Var, kz0VarArr)) == null) {
            String g = tz0Var.b().g();
            Column[] i = i(tz0Var, kz0VarArr);
            int length = i.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!k(i[i2])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return h(g, uz0.k(i));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.mz0
    public int f(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tz0Var, kz0VarArr)) == null) {
            String g = tz0Var.b().g();
            uz0 k = uz0.k(i(tz0Var, kz0VarArr));
            return this.a.update(g, tz0Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.mz0
    public boolean b(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tz0Var, kz0VarArr)) == null) {
            return j(tz0Var, uz0.k(i(tz0Var, kz0VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int h(String str, uz0 uz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, uz0Var)) == null) {
            return this.a.delete(str, uz0Var.m(), uz0Var.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] i(tz0 tz0Var, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, tz0Var, kz0VarArr)) == null) {
            if (kz0VarArr.length > 0) {
                return qz0.b(tz0Var, kz0VarArr);
            }
            return qz0.b(tz0Var, tz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.mz0
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.mz0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.mz0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.mz0
    public long c(tz0 tz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tz0Var)) == null) {
            sz0 b = tz0Var.b();
            String g = b.g();
            kz0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, tz0Var.a());
            }
            Column column = qz0.b(tz0Var, f[0])[0];
            boolean k = qz0.k(column);
            if (k && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + tz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, tz0Var.a());
            if (k) {
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

    @Override // com.baidu.tieba.mz0
    public Cursor d(yz0 yz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yz0Var)) == null) {
            return new zz0(this.b.rawQuery(yz0Var.g(), yz0Var.b()));
        }
        return (Cursor) invokeL.objValue;
    }

    public final boolean k(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, columnArr)) == null) {
            for (Column column : columnArr) {
                if (column == null || !column.isAssignedValue) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean j(tz0 tz0Var, uz0 uz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, tz0Var, uz0Var)) == null) {
            zz0 zz0Var = new zz0(this.b.rawQuery("SELECT " + pz0.e(tz0Var.b().d()) + " FROM " + tz0Var.b().g() + uz0Var.l(), uz0Var.e()));
            boolean moveToFirst = zz0Var.moveToFirst();
            if (moveToFirst) {
                rz0.a(zz0Var, tz0Var);
            }
            zz0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }
}
