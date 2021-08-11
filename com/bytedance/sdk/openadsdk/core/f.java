package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f66190c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f66191a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66192b;

    /* renamed from: com.bytedance.sdk.openadsdk.core.f$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends AbstractCursor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66210a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66210a = fVar;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return 0.0d;
            }
            return invokeI.doubleValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                return 0.0f;
            }
            return invokeI.floatValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                return 0;
            }
            return invokeI.intValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                return (short) 0;
            }
            return invokeI.shortValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                return null;
            }
            return (String) invokeI.objValue;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                return true;
            }
            return invokeI.booleanValue;
        }

        public /* synthetic */ b(f fVar, AnonymousClass1 anonymousClass1) {
            this(fVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210334672, "Lcom/bytedance/sdk/openadsdk/core/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210334672, "Lcom/bytedance/sdk/openadsdk/core/f;");
                return;
            }
        }
        f66190c = new Object();
    }

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f66192b = context == null ? o.a() : context.getApplicationContext();
            if (this.f66191a == null) {
                this.f66191a = new c(this);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Context context = this.f66192b;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66191a : (c) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66211a;

        /* renamed from: b  reason: collision with root package name */
        public SQLiteDatabase f66212b;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66211a = fVar;
            this.f66212b = null;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, MOVE_EXCEPTION, THROW, IF, INVOKE, INVOKE, THROW, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private synchronized void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                synchronized (this) {
                    try {
                        synchronized (f.f66190c) {
                            if (this.f66212b == null || !this.f66212b.isOpen()) {
                                SQLiteDatabase writableDatabase = new a(this.f66211a, this.f66211a.c()).getWritableDatabase();
                                this.f66212b = writableDatabase;
                                writableDatabase.setLockingEnabled(false);
                            }
                        }
                    } finally {
                    }
                }
            }
        }

        private synchronized boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                synchronized (this) {
                    SQLiteDatabase sQLiteDatabase = this.f66212b;
                    if (sQLiteDatabase != null) {
                        z = sQLiteDatabase.inTransaction();
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized void a(String str) throws SQLException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                synchronized (this) {
                    try {
                        d();
                        this.f66212b.execSQL(str);
                    } catch (Throwable th) {
                        if (e()) {
                            throw th;
                        }
                    }
                }
            }
        }

        public synchronized void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                synchronized (this) {
                    d();
                    if (this.f66212b == null) {
                        return;
                    }
                    this.f66212b.setTransactionSuccessful();
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    d();
                    if (this.f66212b == null) {
                        return;
                    }
                    this.f66212b.endTransaction();
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            InterceptResult invokeCommon;
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, strArr, str2, strArr2, str3, str4, str5})) == null) {
                synchronized (this) {
                    try {
                        d();
                        cursor = this.f66212b.query(str, strArr, str2, strArr2, str3, str4, str5);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        b bVar = new b(this.f66211a, null);
                        if (e()) {
                            throw th;
                        }
                        cursor = bVar;
                    }
                }
                return cursor;
            }
            return (Cursor) invokeCommon.objValue;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            InterceptResult invokeLLLL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, contentValues, str2, strArr)) == null) {
                synchronized (this) {
                    try {
                        d();
                        i2 = this.f66212b.update(str, contentValues, str2, strArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (e()) {
                            throw e2;
                        }
                        i2 = 0;
                    }
                }
                return i2;
            }
            return invokeLLLL.intValue;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            InterceptResult invokeLLL;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, contentValues)) == null) {
                synchronized (this) {
                    try {
                        d();
                        j2 = this.f66212b.insert(str, str2, contentValues);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (e()) {
                            throw e2;
                        }
                        j2 = -1;
                    }
                }
                return j2;
            }
            return invokeLLL.longValue;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            InterceptResult invokeLLL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, strArr)) == null) {
                synchronized (this) {
                    try {
                        d();
                        i2 = this.f66212b.delete(str, str2, strArr);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (e()) {
                            throw e2;
                        }
                        i2 = 0;
                    }
                }
                return i2;
            }
            return invokeLLL.intValue;
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this) {
                    d();
                    if (this.f66212b == null) {
                        return;
                    }
                    this.f66212b.beginTransaction();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f66193a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f66194b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66194b = fVar;
            this.f66193a = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, sQLiteDatabase, context) == null) {
                com.bytedance.sdk.component.utils.k.b("DBHelper", "initDB........");
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.e.f.d());
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.e.n.f());
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.e.l.d());
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.p.g.b());
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
                sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.o.a.c());
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
            }
        }

        private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, sQLiteDatabase)) == null) {
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                    if (rawQuery != null) {
                        while (rawQuery.moveToNext()) {
                            String string = rawQuery.getString(0);
                            if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.close();
                    }
                } catch (Exception unused) {
                }
                return arrayList;
            }
            return (ArrayList) invokeL.objValue;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    a(sQLiteDatabase, this.f66193a);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                try {
                    com.bytedance.sdk.component.utils.k.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i2 + ",new:" + i3);
                    if (i2 <= i3) {
                        a(sQLiteDatabase, this.f66194b.f66192b);
                    } else {
                        a(sQLiteDatabase);
                        a(sQLiteDatabase, this.f66194b.f66192b);
                        com.bytedance.sdk.component.utils.k.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                    }
                    if (i2 == 1) {
                        com.bytedance.sdk.component.utils.k.b("DBHelper", "onUpgrade.....执行表创建.....");
                    } else if (i2 == 2) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    } else if (i2 == 3) {
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.e.n.f());
                    } else if (i2 == 4) {
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
                    } else if (i2 == 5) {
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.e.l.d());
                    } else if (i2 != 7) {
                    } else {
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.o.a.c());
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    }
                } catch (Throwable unused) {
                }
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) || (b2 = b(sQLiteDatabase)) == null || b2.size() <= 0) {
                return;
            }
            Iterator<String> it = b2.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}
