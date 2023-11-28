package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.nz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mz0 implements nz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mz0(SQLiteDatabase sQLiteDatabase) {
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

    public mz0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.nz0
    public nz0.a a(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uz0Var, lz0VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = f(uz0Var, lz0VarArr);
                if (i == 0) {
                    j = c(uz0Var);
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
                return new nz0.a(j, i);
            }
        } else {
            return (nz0.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.nz0
    public int e(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uz0Var, lz0VarArr)) == null) {
            String g = uz0Var.b().g();
            Column[] i = i(uz0Var, lz0VarArr);
            int length = i.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!k(i[i2])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return h(g, vz0.k(i));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.nz0
    public int f(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, uz0Var, lz0VarArr)) == null) {
            String g = uz0Var.b().g();
            vz0 k = vz0.k(i(uz0Var, lz0VarArr));
            return this.a.update(g, uz0Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.nz0
    public boolean b(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uz0Var, lz0VarArr)) == null) {
            return j(uz0Var, vz0.k(i(uz0Var, lz0VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int h(String str, vz0 vz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, vz0Var)) == null) {
            return this.a.delete(str, vz0Var.m(), vz0Var.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] i(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, uz0Var, lz0VarArr)) == null) {
            if (lz0VarArr.length > 0) {
                return rz0.b(uz0Var, lz0VarArr);
            }
            return rz0.b(uz0Var, uz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.nz0
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.nz0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.nz0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.nz0
    public long c(uz0 uz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uz0Var)) == null) {
            tz0 b = uz0Var.b();
            String g = b.g();
            lz0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, uz0Var.a());
            }
            Column column = rz0.b(uz0Var, f[0])[0];
            boolean k = rz0.k(column);
            if (k && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + uz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, uz0Var.a());
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

    @Override // com.baidu.tieba.nz0
    public Cursor d(zz0 zz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zz0Var)) == null) {
            return new a01(this.b.rawQuery(zz0Var.g(), zz0Var.b()));
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

    public boolean j(uz0 uz0Var, vz0 vz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, uz0Var, vz0Var)) == null) {
            a01 a01Var = new a01(this.b.rawQuery("SELECT " + qz0.e(uz0Var.b().d()) + " FROM " + uz0Var.b().g() + vz0Var.l(), vz0Var.e()));
            boolean moveToFirst = a01Var.moveToFirst();
            if (moveToFirst) {
                sz0.a(a01Var, uz0Var);
            }
            a01Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }
}
