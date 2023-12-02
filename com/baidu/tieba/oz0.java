package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.pz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oz0 implements pz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public oz0(SQLiteDatabase sQLiteDatabase) {
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

    public oz0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.pz0
    public pz0.a a(wz0 wz0Var, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wz0Var, nz0VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = f(wz0Var, nz0VarArr);
                if (i == 0) {
                    j = c(wz0Var);
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
                return new pz0.a(j, i);
            }
        } else {
            return (pz0.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.pz0
    public int e(wz0 wz0Var, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, wz0Var, nz0VarArr)) == null) {
            String g = wz0Var.b().g();
            Column[] i = i(wz0Var, nz0VarArr);
            int length = i.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!k(i[i2])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return h(g, xz0.k(i));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.pz0
    public int f(wz0 wz0Var, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, wz0Var, nz0VarArr)) == null) {
            String g = wz0Var.b().g();
            xz0 k = xz0.k(i(wz0Var, nz0VarArr));
            return this.a.update(g, wz0Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.pz0
    public boolean b(wz0 wz0Var, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wz0Var, nz0VarArr)) == null) {
            return j(wz0Var, xz0.k(i(wz0Var, nz0VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int h(String str, xz0 xz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, xz0Var)) == null) {
            return this.a.delete(str, xz0Var.m(), xz0Var.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] i(wz0 wz0Var, nz0... nz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, wz0Var, nz0VarArr)) == null) {
            if (nz0VarArr.length > 0) {
                return tz0.b(wz0Var, nz0VarArr);
            }
            return tz0.b(wz0Var, wz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.pz0
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.pz0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.pz0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.pz0
    public long c(wz0 wz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, wz0Var)) == null) {
            vz0 b = wz0Var.b();
            String g = b.g();
            nz0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, wz0Var.a());
            }
            Column column = tz0.b(wz0Var, f[0])[0];
            boolean k = tz0.k(column);
            if (k && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + wz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, wz0Var.a());
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

    @Override // com.baidu.tieba.pz0
    public Cursor d(b01 b01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b01Var)) == null) {
            return new c01(this.b.rawQuery(b01Var.g(), b01Var.b()));
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

    public boolean j(wz0 wz0Var, xz0 xz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wz0Var, xz0Var)) == null) {
            c01 c01Var = new c01(this.b.rawQuery("SELECT " + sz0.e(wz0Var.b().d()) + " FROM " + wz0Var.b().g() + xz0Var.l(), xz0Var.e()));
            boolean moveToFirst = c01Var.moveToFirst();
            if (moveToFirst) {
                uz0.a(c01Var, wz0Var);
            }
            c01Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }
}
