package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.tieba.vy0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uy0 implements vy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public uy0(SQLiteDatabase sQLiteDatabase) {
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

    public uy0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.baidu.tieba.vy0
    public vy0.a a(cz0 cz0Var, ty0... ty0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cz0Var, ty0VarArr)) == null) {
            long j = 0;
            try {
                this.a.beginTransaction();
                i = f(cz0Var, ty0VarArr);
                if (i == 0) {
                    j = c(cz0Var);
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
                return new vy0.a(j, i);
            }
        } else {
            return (vy0.a) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.vy0
    public int e(cz0 cz0Var, ty0... ty0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cz0Var, ty0VarArr)) == null) {
            String g = cz0Var.b().g();
            Column[] i = i(cz0Var, ty0VarArr);
            int length = i.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!k(i[i2])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return h(g, dz0.k(i));
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.vy0
    public int f(cz0 cz0Var, ty0... ty0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cz0Var, ty0VarArr)) == null) {
            String g = cz0Var.b().g();
            dz0 k = dz0.k(i(cz0Var, ty0VarArr));
            return this.a.update(g, cz0Var.a(), k.m(), k.e());
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.vy0
    public boolean b(cz0 cz0Var, ty0... ty0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cz0Var, ty0VarArr)) == null) {
            return j(cz0Var, dz0.k(i(cz0Var, ty0VarArr)));
        }
        return invokeLL.booleanValue;
    }

    public int h(String str, dz0 dz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, dz0Var)) == null) {
            return this.a.delete(str, dz0Var.m(), dz0Var.e());
        }
        return invokeLL.intValue;
    }

    public final Column[] i(cz0 cz0Var, ty0... ty0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cz0Var, ty0VarArr)) == null) {
            if (ty0VarArr.length > 0) {
                return zy0.b(cz0Var, ty0VarArr);
            }
            return zy0.b(cz0Var, cz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vy0
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    @Override // com.baidu.tieba.vy0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    @Override // com.baidu.tieba.vy0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.baidu.tieba.vy0
    public long c(cz0 cz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cz0Var)) == null) {
            bz0 b = cz0Var.b();
            String g = b.g();
            ty0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, cz0Var.a());
            }
            Column column = zy0.b(cz0Var, f[0])[0];
            boolean k = zy0.k(column);
            if (k && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + cz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, cz0Var.a());
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

    @Override // com.baidu.tieba.vy0
    public Cursor d(hz0 hz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hz0Var)) == null) {
            return new iz0(this.b.rawQuery(hz0Var.g(), hz0Var.b()));
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

    public boolean j(cz0 cz0Var, dz0 dz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cz0Var, dz0Var)) == null) {
            iz0 iz0Var = new iz0(this.b.rawQuery("SELECT " + yy0.e(cz0Var.b().d()) + " FROM " + cz0Var.b().g() + dz0Var.l(), dz0Var.e()));
            boolean moveToFirst = iz0Var.moveToFirst();
            if (moveToFirst) {
                az0.a(iz0Var, cz0Var);
            }
            iz0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }
}
