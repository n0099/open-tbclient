package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sj0 extends v11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sj0(SQLiteDatabase sQLiteDatabase) {
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

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized w11.a a(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        w11.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, d21Var, u11VarArr)) == null) {
            synchronized (this) {
                a = super.a(d21Var, u11VarArr);
            }
            return a;
        }
        return (w11.a) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized int delete(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, d21Var, u11VarArr)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(d21Var, u11VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized boolean query(d21 d21Var, e21 e21Var) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, d21Var, e21Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(d21Var, e21Var);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized int update(d21 d21Var, e21 e21Var) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, d21Var, e21Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(d21Var, e21Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                try {
                    super.beginTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                try {
                    super.endTransaction();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                try {
                    super.setTransactionSuccessful();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.baidu.tieba.v11
    public synchronized int delete(String str, e21 e21Var) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, e21Var)) == null) {
            synchronized (this) {
                try {
                    delete = super.delete(str, e21Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized boolean query(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, d21Var, u11VarArr)) == null) {
            synchronized (this) {
                try {
                    query = super.query(d21Var, u11VarArr);
                } catch (Exception unused) {
                    return false;
                }
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized int update(d21 d21Var, u11... u11VarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, d21Var, u11VarArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(d21Var, u11VarArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized long insert(d21 d21Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, d21Var)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(d21Var);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.v11, com.baidu.tieba.w11
    public synchronized Cursor query(i21 i21Var) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, i21Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(i21Var);
                } catch (Exception unused) {
                    return new j21(null);
                }
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, strArr, objArr)) == null) {
            synchronized (this) {
                try {
                    insert = super.insert(str, strArr, objArr);
                } catch (Exception unused) {
                    return -1L;
                }
            }
            return insert;
        }
        return invokeLLL.longValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized Cursor query(String str, u11[] u11VarArr, e21 e21Var) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, u11VarArr, e21Var)) == null) {
            synchronized (this) {
                try {
                    query = super.query(str, u11VarArr, e21Var);
                } catch (Exception unused) {
                    return new j21(null);
                }
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized int update(String str, ContentValues contentValues, e21 e21Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, contentValues, e21Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, contentValues, e21Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized int update(Class<? extends d21> cls, e21 e21Var, u11[] u11VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, cls, e21Var, u11VarArr, objArr)) == null) {
            synchronized (this) {
                try {
                    update = super.update(cls, e21Var, u11VarArr, objArr);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.baidu.tieba.v11
    public synchronized int update(String str, Column[] columnArr, e21 e21Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, columnArr, e21Var)) == null) {
            synchronized (this) {
                try {
                    update = super.update(str, columnArr, e21Var);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return update;
        }
        return invokeLLL.intValue;
    }
}
