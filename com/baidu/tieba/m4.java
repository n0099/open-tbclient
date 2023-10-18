package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.sql.SQLException;
/* loaded from: classes7.dex */
public class m4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;
    public l4.a b;
    public l4 c;

    public m4(l4 l4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = l4Var;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (m4.class) {
                if (this.a != null && this.a.isOpen()) {
                    return;
                }
                try {
                    this.c.setOnCreateCallback(this.b);
                    this.a = this.c.getWritableDatabase();
                } catch (RuntimeException e) {
                    if (z) {
                        h(e, "ensureDatabaseReady");
                    } else {
                        throw e;
                    }
                }
            }
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SQLiteDatabase f = f();
            if (f == null) {
                return false;
            }
            try {
                f.execSQL(str);
                return true;
            } catch (Throwable th) {
                h(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.a != null) {
                    this.a.close();
                    this.a = null;
                }
            } catch (Exception e) {
                BdLog.e("closeDatabase：" + e.getMessage());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        boolean dropDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (m4.class) {
                a();
                try {
                    dropDatabase = this.c.dropDatabase(BdBaseApplication.getInst().getContext());
                } catch (Exception e) {
                    BdLog.e("deleteDatabase：" + e.getMessage());
                    this.a = null;
                    return false;
                }
            }
            return dropDatabase;
        }
        return invokeV.booleanValue;
    }

    public boolean e(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, objArr)) == null) {
            SQLiteDatabase f = f();
            if (f == null) {
                return false;
            }
            try {
                f.execSQL(str, objArr);
                return true;
            } catch (Throwable th) {
                h(th, "execSQLNoException:" + str);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return g(true);
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public SQLiteDatabase g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            c(z);
            return this.a;
        }
        return (SQLiteDatabase) invokeZ.objValue;
    }

    public void j(l4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public void h(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, th, str) != null) || th == null || !(th instanceof SQLiteException)) {
            return;
        }
        if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
            BdLog.w("database corrupted. recreate!");
            try {
                b();
            } catch (Throwable th2) {
                BdLog.detailException("failed to drop database. msg:", th2);
            }
            this.a = null;
        } else if (!(th instanceof SQLiteAbortException) && !(th instanceof SQLiteConstraintException)) {
            if (th instanceof SQLiteDiskIOException) {
                this.a = null;
            } else if (th instanceof SQLiteFullException) {
                this.a = null;
            } else if (th instanceof SQLiteDoneException) {
                this.a = null;
            } else if (!(th instanceof SQLiteMisuseException)) {
                this.a = null;
            }
        }
    }

    public Cursor i(String str, String[] strArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr)) == null) {
            SQLiteDatabase g = g(false);
            if (g != null) {
                return g.rawQuery(str, strArr);
            }
            throw new SQLException("unable to open database.");
        }
        return (Cursor) invokeLL.objValue;
    }
}
