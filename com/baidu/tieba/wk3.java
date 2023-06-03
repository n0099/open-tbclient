package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
/* loaded from: classes8.dex */
public class wk3 extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "CREATE TABLE cookies (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,value TEXT,domain TEXT,path TEXT,expires INTEGER,secure INTEGER,ext TEXT);" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948273418, "Lcom/baidu/tieba/wk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948273418, "Lcom/baidu/tieba/wk3;");
                return;
            }
        }
        b = is1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk3(@NonNull Context context, String str) {
        super(context.getApplicationContext(), c(str), (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String o = uu2.o(str);
            File file = new File(o);
            if (!file.exists() && !file.mkdirs()) {
                y82.k("SwanCookieDBHelper", "mkdirs fail: " + o);
            }
            return o + File.separator + "smCookie.db";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"BDThrowableCheck"})
    public synchronized SQLiteDatabase getReadableDatabase() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                try {
                    sQLiteDatabase = super.getReadableDatabase();
                } catch (Exception e2) {
                    sQLiteDatabase = null;
                    e = e2;
                }
                try {
                    String databaseName = getDatabaseName();
                    if (!new File(databaseName).exists()) {
                        y82.k("SwanCookieDBHelper", "getReadableDatabase file is not exit: " + databaseName);
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    y82.k("SwanCookieDBHelper", "getRead fail mAppId =" + this.a + ParamableElem.DIVIDE_PARAM + Log.getStackTraceString(e));
                    if (b) {
                        throw new RuntimeException(e);
                    }
                    return sQLiteDatabase;
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"BDThrowableCheck"})
    public synchronized SQLiteDatabase getWritableDatabase() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Exception e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (Exception e2) {
                    sQLiteDatabase = null;
                    e = e2;
                }
                try {
                    String databaseName = getDatabaseName();
                    if (!new File(databaseName).exists()) {
                        y82.k("SwanCookieDBHelper", "getWritableDatabase file is not exit: " + databaseName);
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    y82.k("SwanCookieDBHelper", "getWrite fail mAppId =" + this.a + ParamableElem.DIVIDE_PARAM + Log.getStackTraceString(e));
                    if (b) {
                        throw new RuntimeException(e);
                    }
                    return sQLiteDatabase;
                }
                return sQLiteDatabase;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            if (b) {
                Log.d("SwanCookieDBHelper", "onCreate");
            }
            try {
                sQLiteDatabase.execSQL(a());
            } catch (Exception e) {
                y82.k("SwanCookieDBHelper", "createTableSql fail:" + Log.getStackTraceString(e));
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i, i2) == null) && b) {
            Log.d("SwanCookieDBHelper", "oldVersion = " + i + ";newVersion=" + i2);
        }
    }
}
