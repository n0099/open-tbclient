package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes4.dex */
public class kc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public jc3 a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908238, "Lcom/baidu/tieba/kc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908238, "Lcom/baidu/tieba/kc3;");
                return;
            }
        }
        c = vj1.a;
    }

    public kc3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public synchronized void a(gc3 gc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gc3Var) == null) {
            synchronized (this) {
                if (gc3Var != null) {
                    if (!TextUtils.isEmpty(gc3Var.a) && !TextUtils.isEmpty(gc3Var.c) && !TextUtils.isEmpty(gc3Var.b)) {
                        if (gc3Var.e == -1) {
                            return;
                        }
                        SQLiteDatabase f = f();
                        if (f == null) {
                            return;
                        }
                        if (c) {
                            Log.d("SwanCookieDatabase", "addCookie cookie=" + gc3Var.toString());
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("domain", gc3Var.a);
                        contentValues.put("path", gc3Var.b);
                        contentValues.put("name", gc3Var.c);
                        contentValues.put("value", gc3Var.d);
                        contentValues.put("expires", Long.valueOf(gc3Var.e));
                        contentValues.put(ClientCookie.SECURE_ATTR, Boolean.valueOf(gc3Var.f));
                        f.insert("cookies", null, contentValues);
                    }
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "clearExpiredCookies");
                }
                f.delete("cookies", "expires <= ?", new String[]{Long.toString(System.currentTimeMillis())});
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                try {
                    if (c) {
                        Log.d("SwanCookieDatabase", "close");
                    }
                    this.a.close();
                    this.a = null;
                    this.b = true;
                } catch (Exception e) {
                    l02.k("SwanCookieDatabase", "close fail:" + Log.getStackTraceString(e));
                }
            }
        }
    }

    public synchronized void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                if (c) {
                    Log.d("SwanCookieDatabase", "deleteCookies domain=" + str + ";path=" + str2 + ";name=" + str3);
                }
                f.delete("cookies", "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    public synchronized ArrayList<gc3> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                if (c) {
                    Log.d("SwanCookieDatabase", "getCookiesForDomain baseDomain=" + str);
                }
                ArrayList<gc3> arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(str)) {
                    return arrayList;
                }
                SQLiteDatabase f = f();
                if (f == null) {
                    return arrayList;
                }
                Cursor query = f.query("cookies", new String[]{"_id", "domain", "path", "name", "value", "expires", ClientCookie.SECURE_ATTR}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
                if (query == null) {
                    return arrayList;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("domain");
                    int columnIndex2 = query.getColumnIndex("path");
                    int columnIndex3 = query.getColumnIndex("name");
                    int columnIndex4 = query.getColumnIndex("value");
                    int columnIndex5 = query.getColumnIndex("expires");
                    int columnIndex6 = query.getColumnIndex(ClientCookie.SECURE_ATTR);
                    do {
                        gc3 gc3Var = new gc3();
                        gc3Var.a = query.getString(columnIndex);
                        gc3Var.b = query.getString(columnIndex2);
                        gc3Var.c = query.getString(columnIndex3);
                        gc3Var.d = query.getString(columnIndex4);
                        if (query.isNull(columnIndex5)) {
                            gc3Var.e = -1L;
                        } else {
                            gc3Var.e = query.getLong(columnIndex5);
                        }
                        gc3Var.f = query.getShort(columnIndex6) != 0;
                        gc3Var.i = 1;
                        if (gc3Var.e > currentTimeMillis) {
                            arrayList.add(gc3Var);
                            if (c) {
                                Log.d("SwanCookieDatabase", "getCookiesForDomain cookie=" + gc3Var.toString());
                            }
                        }
                    } while (query.moveToNext());
                    nr2.a(query);
                    return arrayList;
                }
                nr2.a(query);
                return arrayList;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public final SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b) {
                return null;
            }
            jc3 jc3Var = this.a;
            if (jc3Var != null) {
                return jc3Var.getWritableDatabase();
            }
            String appId = k33.K().getAppId();
            if (!k33.K().E()) {
                l02.k("SwanCookieDatabase", "getSQLiteDatabase currentAppId =" + appId);
                return null;
            }
            String t = ta3.t(k33.K().q());
            l02.k("SwanCookieDatabase", "initDbHelper name =" + t);
            jc3 jc3Var2 = new jc3(sm2.c(), t);
            this.a = jc3Var2;
            return jc3Var2.getWritableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    public synchronized void g(Runnable runnable) {
        String str;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            synchronized (this) {
                SQLiteDatabase f = f();
                if (f == null) {
                    return;
                }
                try {
                    f.beginTransaction();
                    runnable.run();
                    f.setTransactionSuccessful();
                    try {
                        f.endTransaction();
                    } catch (Exception e) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e);
                        l02.k(str, stackTraceString);
                    }
                } catch (Exception e2) {
                    l02.k("SwanCookieDatabase", Log.getStackTraceString(e2));
                    try {
                        f.endTransaction();
                    } catch (Exception e3) {
                        str = "SwanCookieDatabase";
                        stackTraceString = Log.getStackTraceString(e3);
                        l02.k(str, stackTraceString);
                    }
                }
            }
        }
    }

    public synchronized void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                f();
            }
        }
    }
}
