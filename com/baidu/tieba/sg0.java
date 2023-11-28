package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nz0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sg0 extends mz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sg0(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SQLiteDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized nz0.a a(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        nz0.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, uz0Var, lz0VarArr)) == null) {
            synchronized (this) {
                a = super.a(uz0Var, lz0VarArr);
            }
            return a;
        }
        return (nz0.a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized boolean b(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uz0Var, lz0VarArr)) == null) {
            synchronized (this) {
                try {
                    b = super.b(uz0Var, lz0VarArr);
                } catch (Exception unused) {
                    return false;
                }
            }
            return b;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized int e(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, uz0Var, lz0VarArr)) == null) {
            synchronized (this) {
                try {
                    e = super.e(uz0Var, lz0VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return e;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized int f(uz0 uz0Var, lz0... lz0VarArr) {
        InterceptResult invokeLL;
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, uz0Var, lz0VarArr)) == null) {
            synchronized (this) {
                try {
                    f = super.f(uz0Var, lz0VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return f;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.mz0
    public synchronized int h(String str, vz0 vz0Var) {
        InterceptResult invokeLL;
        int h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, vz0Var)) == null) {
            synchronized (this) {
                try {
                    h = super.h(str, vz0Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return h;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.mz0
    public synchronized boolean j(uz0 uz0Var, vz0 vz0Var) {
        InterceptResult invokeLL;
        boolean j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, uz0Var, vz0Var)) == null) {
            synchronized (this) {
                try {
                    j = super.j(uz0Var, vz0Var);
                } catch (Exception unused) {
                    return false;
                }
            }
            return j;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                try {
                    super.beginTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                try {
                    super.endTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                try {
                    super.setTransactionSuccessful();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized long c(uz0 uz0Var) {
        InterceptResult invokeL;
        long c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uz0Var)) == null) {
            synchronized (this) {
                try {
                    c = super.c(uz0Var);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return c;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.mz0, com.baidu.tieba.nz0
    public synchronized Cursor d(zz0 zz0Var) {
        InterceptResult invokeL;
        Cursor d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zz0Var)) == null) {
            synchronized (this) {
                try {
                    d = super.d(zz0Var);
                } catch (Exception unused) {
                    return new a01(null);
                }
            }
            return d;
        }
        return (Cursor) invokeL.objValue;
    }
}
