package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.hoa;
import com.baidu.tieba.wna;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class yna extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static yna e;
    public static ReentrantLock f;
    public transient /* synthetic */ FieldHolder $fh;
    public ana a;
    public Context b;
    public ReentrantReadWriteLock c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948337309, "Lcom/baidu/tieba/yna;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948337309, "Lcom/baidu/tieba/yna;");
                return;
            }
        }
        d = aoa.m();
        e = null;
        f = new ReentrantLock();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Log.w("UBCDatabaseHelper", "Database is being closed");
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            A(false);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            A(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yna(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 9);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.c = new ReentrantReadWriteLock(true);
        this.a = new ana(context);
        this.b = context;
    }

    public int S(koa koaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, koaVar)) == null) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * FROM ");
            sb.append("event");
            sb.append(" WHERE ");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(-1);
            sb.append(" AND ");
            sb.append("reallog");
            sb.append(" = \"1\"");
            return L(sb.toString(), koaVar);
        }
        return invokeL.intValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, sQLiteDatabase) == null) {
            if (d) {
                Log.i("UBCDatabaseHelper", "Creating database bdbehavior.db version 9");
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
                sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER);");
                joa.a().f(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, "0");
            } catch (Exception e2) {
                Log.w("UBCDatabaseHelper", "Error while creating db: " + e2.toString());
            }
        }
    }

    public static yna Q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (e == null) {
                f.lock();
                if (e == null) {
                    e = new yna(context);
                }
                f.unlock();
            }
            return e;
        }
        return (yna) invokeL.objValue;
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE arrival ADD COLUMN callcnt INTEGER");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    public final void q(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER);");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long currentTimeMillis = System.currentTimeMillis() - fna.o().k();
                        Cursor cursor = null;
                        i3 = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                        try {
                            if (d) {
                                Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + i3);
                            }
                            i2 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                            try {
                                if (d) {
                                    Log.d("UBCDatabaseHelper", "clearInvalidData: delete event count:" + i2);
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - 86400000;
                                StringBuilder sb = new StringBuilder(256);
                                sb.append("SELECT ");
                                sb.append("flowhandle");
                                sb.append(" FROM ");
                                sb.append("flow");
                                sb.append(" WHERE ");
                                if (!z) {
                                    sb.append("begintime");
                                    sb.append(" < ");
                                    sb.append(currentTimeMillis2);
                                    sb.append(" AND ");
                                }
                                sb.append("endtime");
                                sb.append(" is NULL ");
                                sb.append(" AND ");
                                sb.append(SpeedStatsUtils.UBC_KEY_OPTION);
                                sb.append(" = 0");
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                                    if (rawQuery != null) {
                                        try {
                                            if (rawQuery.getCount() > 0) {
                                                rawQuery.moveToFirst();
                                                do {
                                                    arrayList.add(Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("flowhandle"))));
                                                } while (rawQuery.moveToNext());
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = rawQuery;
                                            bpa.a(cursor);
                                            throw th;
                                        }
                                    }
                                    bpa.a(rawQuery);
                                    if (arrayList.size() > 0) {
                                        if (d) {
                                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                                        }
                                        String P = P(arrayList);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("flowhandle");
                                        sb2.append(" in (");
                                        sb2.append(P);
                                        sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                                        writableDatabase.delete("flow", sb2.toString(), null);
                                        writableDatabase.delete("event", sb2.toString(), null);
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                    writableDatabase.endTransaction();
                                    i = C("flow");
                                    try {
                                        try {
                                            int C = C("event");
                                            this.c.writeLock().unlock();
                                            if (i3 > 0 || i2 > 0) {
                                                coa.a().e(String.valueOf(fna.o().k()), i3, i2, 0);
                                                hoa.m().s(i2, i3);
                                            }
                                            if (i <= 0 && C <= 0) {
                                                return;
                                            }
                                        } catch (SQLException e2) {
                                            e = e2;
                                            if (d) {
                                                e.printStackTrace();
                                            }
                                            this.a.h(e);
                                            this.c.writeLock().unlock();
                                            if (i3 > 0 || i2 > 0) {
                                                coa.a().e(String.valueOf(fna.o().k()), i3, i2, 0);
                                                hoa.m().s(i2, i3);
                                            }
                                            if (i <= 0) {
                                                return;
                                            }
                                            hoa.m().t();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        this.c.writeLock().unlock();
                                        if (i3 <= 0 || i2 > 0) {
                                            coa.a().e(String.valueOf(fna.o().k()), i3, i2, 0);
                                            hoa.m().s(i2, i3);
                                        }
                                        if (i > 0) {
                                            hoa.m().t();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                writableDatabase.endTransaction();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    i = 0;
                } catch (Throwable th7) {
                    th = th7;
                    i = 0;
                    this.c.writeLock().unlock();
                    if (i3 <= 0) {
                    }
                    coa.a().e(String.valueOf(fna.o().k()), i3, i2, 0);
                    hoa.m().s(i2, i3);
                    if (i > 0) {
                    }
                    throw th;
                }
            } catch (SQLException e4) {
                e = e4;
                i = 0;
                i2 = 0;
                i3 = 0;
            } catch (Throwable th8) {
                th = th8;
                i = 0;
                i2 = 0;
                i3 = 0;
                this.c.writeLock().unlock();
                if (i3 <= 0) {
                }
                coa.a().e(String.valueOf(fna.o().k()), i3, i2, 0);
                hoa.m().s(i2, i3);
                if (i > 0) {
                }
                throw th;
            }
            hoa.m().t();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|(3:110|111|112)(1:11)|(6:15|(5:16|17|(5:19|(1:21)(1:37)|22|(3:28|29|(1:31))|24)(13:38|(1:40)(2:89|(1:91))|(1:42)|43|(1:45)|(1:47)|48|(1:50)|(1:53)|54|(13:60|61|(1:63)|64|(1:68)|69|70|71|(1:75)|76|(1:78)|79|(1:82))(1:56)|57|(1:59))|25|(1:27)(0))|94|95|96|97)(0)|93|94|95|96|97) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0207, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0208, code lost:
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x020b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x020c, code lost:
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0218, code lost:
        if (com.baidu.tieba.yna.d != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x021d, code lost:
        r1.a.h(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022c, code lost:
        r1.c.readLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0235, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d3 A[Catch: all -> 0x01f5, RuntimeException -> 0x01f9, TryCatch #9 {RuntimeException -> 0x01f9, blocks: (B:7:0x0029, B:9:0x0033, B:15:0x0041, B:17:0x0047, B:18:0x0088, B:21:0x00c8, B:25:0x00d8, B:27:0x00e2, B:29:0x00ed, B:35:0x00fd, B:88:0x01d8, B:32:0x00f6, B:34:0x00fa, B:36:0x0105, B:38:0x010f, B:43:0x0122, B:44:0x0127, B:46:0x012d, B:48:0x0134, B:49:0x013d, B:51:0x0143, B:54:0x014c, B:55:0x0156, B:57:0x015c, B:59:0x0169, B:60:0x016e, B:62:0x0174, B:64:0x017e, B:66:0x0185, B:68:0x018b, B:70:0x0191, B:71:0x019a, B:73:0x01a3, B:74:0x01ac, B:85:0x01cd, B:87:0x01d3, B:77:0x01b8, B:83:0x01c7, B:39:0x0115, B:41:0x011b), top: B:129:0x0029, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01df A[LOOP:0: B:18:0x0088->B:91:0x01df, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W(ena enaVar) {
        Cursor cursor;
        ena enaVar2;
        String str;
        String str2;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, enaVar) == null) {
            yna ynaVar = this;
            String str3 = "isSend";
            ynaVar.c.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                            if (enaVar == null) {
                                try {
                                    enaVar2 = new ena();
                                } catch (Throwable th) {
                                    th = th;
                                    bpa.a(cursor);
                                    throw th;
                                }
                            } else {
                                enaVar2 = enaVar;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            ynaVar = this;
                        }
                    } catch (RuntimeException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                    }
                } catch (SQLException e3) {
                    e = e3;
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("eventid");
                    int columnIndex2 = cursor.getColumnIndex("switch");
                    int columnIndex3 = cursor.getColumnIndex("sample");
                    int columnIndex4 = cursor.getColumnIndex("reserve1");
                    int columnIndex5 = cursor.getColumnIndex("reserve2");
                    int columnIndex6 = cursor.getColumnIndex("cycle");
                    int columnIndex7 = cursor.getColumnIndex("uploadrule");
                    int columnIndex8 = cursor.getColumnIndex("recordrule");
                    int columnIndex9 = cursor.getColumnIndex("extend");
                    int columnIndex10 = cursor.getColumnIndex("reallog");
                    String str4 = "gflow";
                    while (true) {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        int i2 = cursor.getInt(columnIndex3);
                        int i3 = columnIndex;
                        String string3 = cursor.getString(columnIndex4);
                        int i4 = columnIndex2;
                        String string4 = cursor.getString(columnIndex5);
                        int i5 = columnIndex3;
                        int i6 = cursor.getInt(columnIndex6);
                        int i7 = columnIndex4;
                        int i8 = cursor.getInt(columnIndex7);
                        int i9 = columnIndex5;
                        int i10 = cursor.getInt(columnIndex8);
                        int i11 = columnIndex6;
                        String string5 = cursor.getString(columnIndex9);
                        int i12 = columnIndex7;
                        String string6 = cursor.getString(columnIndex10);
                        int i13 = columnIndex10;
                        if (lna.a(string)) {
                            lna lnaVar = new lna();
                            lnaVar.a = TextUtils.equals(string2, "1");
                            if (i6 == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            lnaVar.b = z;
                            lnaVar.c = i6;
                            if (!TextUtils.isEmpty(string5)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(string5);
                                    if (jSONObject.has(str3)) {
                                        lnaVar.d = jSONObject.optBoolean(str3, true);
                                    }
                                } catch (JSONException e4) {
                                    if (d) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                            enaVar2.a = lnaVar;
                            str = str3;
                            str2 = str4;
                        } else {
                            str = str3;
                            if (TextUtils.equals(string2, "0")) {
                                enaVar2.b.add(string);
                            } else if (TextUtils.equals(string2, "1")) {
                                enaVar2.f.add(string);
                            }
                            if (i6 == 0) {
                                enaVar2.c.add(string);
                            }
                            if (TextUtils.equals(string3, "1")) {
                                enaVar2.e.add(string);
                            }
                            if (i2 > 0) {
                                enaVar2.h.put(string, Integer.valueOf(i2));
                            }
                            if (!TextUtils.isEmpty(string4)) {
                                enaVar2.i.put(string, string4);
                            }
                            if (i8 != 0 && i10 != 0) {
                                enaVar2.j.put(string, new kna(string, i10, i8));
                            }
                            if (!TextUtils.isEmpty(string5)) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(string5);
                                    if (jSONObject2.has(Constant.ID_TYPE)) {
                                        enaVar2.k.add(string);
                                    }
                                    if (jSONObject2.has("ch") && TextUtils.equals(jSONObject2.getString("ch"), "1")) {
                                        enaVar2.g.add(string);
                                    }
                                    str2 = str4;
                                    try {
                                        if (jSONObject2.has(str2) && (i = jSONObject2.getInt(str2)) != 0) {
                                            enaVar2.m.put(string, Integer.valueOf(i));
                                        }
                                        int optInt = jSONObject2.optInt("uploadType", -1);
                                        if (optInt != -1) {
                                            enaVar2.n.put(string, Integer.valueOf(optInt));
                                        }
                                        int optInt2 = jSONObject2.optInt("lcache", 2);
                                        if (optInt2 == 1 || optInt2 == 0) {
                                            enaVar2.o.put(string, Integer.valueOf(optInt2));
                                        }
                                    } catch (JSONException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        if (TextUtils.equals(string6, "1")) {
                                        }
                                        if (cursor.moveToNext()) {
                                        }
                                        bpa.a(cursor);
                                        ynaVar = this;
                                        ynaVar.c.readLock().unlock();
                                    }
                                } catch (JSONException e6) {
                                    e = e6;
                                    str2 = str4;
                                }
                            } else {
                                str2 = str4;
                            }
                            if (TextUtils.equals(string6, "1")) {
                                enaVar2.l.add(string);
                            }
                        }
                        if (cursor.moveToNext()) {
                            columnIndex = i3;
                            str4 = str2;
                            columnIndex2 = i4;
                            columnIndex3 = i5;
                            columnIndex4 = i7;
                            columnIndex5 = i9;
                            columnIndex6 = i11;
                            columnIndex7 = i12;
                            str3 = str;
                            columnIndex10 = i13;
                        }
                    }
                    bpa.a(cursor);
                    ynaVar = this;
                    ynaVar.c.readLock().unlock();
                }
                bpa.a(cursor);
                ynaVar = this;
                ynaVar.c.readLock().unlock();
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public void a(koa koaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, koaVar) == null) {
            yna ynaVar = this;
            boolean H = fna.o().H();
            ynaVar.c.readLock().lock();
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SELECT a.* FROM ");
                    sb.append("event");
                    sb.append(" a ");
                    sb.append("LEFT JOIN ");
                    sb.append("config");
                    sb.append(" b ");
                    sb.append("ON a.");
                    sb.append("eventid");
                    sb.append(" = b.");
                    sb.append("eventid");
                    sb.append(" WHERE ");
                    sb.append("a.");
                    sb.append("flowhandle");
                    sb.append(" = ");
                    sb.append(-1);
                    sb.append(" AND ");
                    sb.append("(a.");
                    sb.append("reallog");
                    sb.append(" = '0' OR a.");
                    sb.append("reallog");
                    sb.append(" = '')");
                    if (H) {
                        sb.append(" AND (b.");
                        sb.append("switch");
                        sb.append(" IS NULL OR b.");
                        sb.append("switch");
                        sb.append(" = '");
                        sb.append("1");
                        sb.append("')");
                    } else {
                        sb.append(" AND b.");
                        sb.append("switch");
                        sb.append(" = '");
                        sb.append("1");
                        sb.append("'");
                    }
                    sb.append(" ORDER BY b.");
                    sb.append("cycle");
                    sb.append(" ASC");
                    ynaVar.L(sb.toString(), koaVar);
                } catch (SQLException e2) {
                    e = e2;
                }
                if (!koaVar.w() && !koaVar.z()) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        sb2.append("SELECT a.* FROM ");
                        sb2.append("flow");
                        sb2.append(" a ");
                        sb2.append("LEFT JOIN ");
                        sb2.append("config");
                        sb2.append(" b ");
                        sb2.append("ON a.");
                        sb2.append("flowid");
                        sb2.append(" = b.");
                        sb2.append("eventid");
                        sb2.append(" WHERE ");
                        sb2.append(" a.");
                        sb2.append("endtime");
                        sb2.append(" IS NOT NULL");
                        if (H) {
                            sb2.append(" AND (b.");
                            sb2.append("switch");
                            sb2.append(" IS NULL OR b.");
                            sb2.append("switch");
                            sb2.append(" = '");
                            sb2.append("1");
                            sb2.append("')");
                        } else {
                            sb2.append(" AND b.");
                            sb2.append("switch");
                            sb2.append(" = '");
                            sb2.append("1");
                            sb2.append("'");
                        }
                        sb2.append(" ORDER BY b.");
                        sb2.append("cycle");
                        sb2.append(" ASC");
                        ynaVar = this;
                        ynaVar.O(sb2.toString(), koaVar);
                    } catch (SQLException e3) {
                        e = e3;
                        ynaVar = this;
                        if (d) {
                            e.printStackTrace();
                        }
                        ynaVar.a.h(e);
                        ynaVar.c.readLock().unlock();
                        return;
                    } catch (Throwable th) {
                        th = th;
                        ynaVar = this;
                        ynaVar.c.readLock().unlock();
                        throw th;
                    }
                    ynaVar.c.readLock().unlock();
                    return;
                }
                ynaVar.c.readLock().unlock();
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public boolean c0(List<ina> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    SQLiteStatement compileStatement = writableDatabase.compileStatement("replace into config(eventid,type,recordrule,uploadrule,cycle,switch,sample,reserve1,reserve2,extend,reallog" + SmallTailInfo.EMOTION_SUFFIX + " values(?,?,?,?,?,?,?,?,?,?,?)");
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        try {
                            for (ina inaVar : list) {
                                compileStatement.clearBindings();
                                compileStatement.bindString(1, inaVar.c());
                                if (inaVar.getType() == 1) {
                                    compileStatement.bindString(2, "1");
                                } else {
                                    compileStatement.bindString(2, "0");
                                }
                                int e2 = inaVar.e();
                                int d2 = inaVar.d();
                                if (e2 != 0 && d2 != 0) {
                                    compileStatement.bindLong(3, e2);
                                    compileStatement.bindLong(4, d2);
                                }
                                if (inaVar.o()) {
                                    compileStatement.bindLong(5, 0L);
                                } else {
                                    compileStatement.bindLong(5, inaVar.h());
                                }
                                if (inaVar.s()) {
                                    compileStatement.bindString(6, "1");
                                } else {
                                    compileStatement.bindString(6, "0");
                                }
                                compileStatement.bindLong(7, inaVar.g());
                                if (inaVar.k()) {
                                    compileStatement.bindString(8, "1");
                                } else {
                                    compileStatement.bindString(8, "0");
                                }
                                String a = inaVar.a();
                                if (!TextUtils.isEmpty(a)) {
                                    compileStatement.bindString(9, a);
                                }
                                JSONObject jSONObject = new JSONObject();
                                if (inaVar.m()) {
                                    jSONObject.put(Constant.ID_TYPE, "1");
                                }
                                if (inaVar.n()) {
                                    jSONObject.put("ch", "1");
                                }
                                if (inaVar.l()) {
                                    jSONObject.put("dfc", "1");
                                }
                                jSONObject.put("version", inaVar.j());
                                int b = inaVar.b();
                                if (inaVar.r()) {
                                    jSONObject.put("gflow", Integer.toString(b));
                                }
                                if (!inaVar.t()) {
                                    jSONObject.put("uploadType", Integer.toString(inaVar.i()));
                                }
                                int f2 = inaVar.f();
                                if (f2 != 2) {
                                    jSONObject.put("lcache", f2);
                                }
                                if (lna.a(inaVar.c())) {
                                    jSONObject.put("isSend", inaVar.q());
                                }
                                compileStatement.bindString(10, jSONObject.toString());
                                if (inaVar.p()) {
                                    compileStatement.bindString(11, "1");
                                } else {
                                    compileStatement.bindString(11, "0");
                                }
                                if (compileStatement.executeUpdateDelete() <= 0) {
                                    return false;
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            if (d) {
                                Log.d("UBCDatabaseHelper", "updateConfig success count: " + list.size());
                            }
                            return true;
                        } catch (JSONException e3) {
                            if (d) {
                                e3.printStackTrace();
                            }
                            writableDatabase.endTransaction();
                            return false;
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e4) {
                    if (d) {
                        e4.printStackTrace();
                    }
                    this.a.h(e4);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public void B(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            if (i >= 0 && !TextUtils.isEmpty(str)) {
                this.c.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("state", "2");
                            contentValues.put("endtime", Long.valueOf(j));
                            if (jSONArray != null && jSONArray.length() > 0) {
                                contentValues.put("slot", jSONArray.toString());
                            }
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                            if (d && update != 1) {
                                Log.d("UBCDatabaseHelper", "endFlow#performTransaction: endFlow count:" + update);
                            }
                            wna.f().a(str, false);
                            hoa.m().y(str, update);
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } finally {
                        this.c.writeLock().unlock();
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "endFlow#flowHandle invalid");
            }
        }
    }

    public final boolean g(SQLiteDatabase sQLiteDatabase, ona onaVar, int i, koa koaVar) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048614, this, sQLiteDatabase, onaVar, i, koaVar)) == null) {
            if (onaVar.k() < 0) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                StringBuilder sb = new StringBuilder(256);
                sb.append("SELECT ");
                sb.append("eventid");
                sb.append(" , ");
                sb.append("begintime");
                sb.append(" , ");
                sb.append("content");
                sb.append(" FROM ");
                sb.append("event");
                sb.append(" WHERE ");
                sb.append("flowhandle");
                sb.append(" = ");
                sb.append(onaVar.k());
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                if (rawQuery != null && rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    int columnIndex = rawQuery.getColumnIndex("eventid");
                    int columnIndex2 = rawQuery.getColumnIndex("begintime");
                    int columnIndex3 = rawQuery.getColumnIndex("content");
                    do {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", rawQuery.getString(columnIndex));
                        jSONObject.put("timestamp", Long.toString(rawQuery.getLong(columnIndex2)));
                        jSONObject.put("content", rawQuery.getString(columnIndex3));
                        jSONArray.put(jSONObject);
                    } while (rawQuery.moveToNext());
                    onaVar.w(jSONArray);
                }
                bpa.a(rawQuery);
                if (koaVar.c(onaVar, i)) {
                    if (!TextUtils.isEmpty(onaVar.j())) {
                        koaVar.K("1");
                    }
                    if (onaVar.i() > 0 && onaVar.i() > koaVar.s()) {
                        koaVar.J(0L, onaVar.i());
                    }
                    if (onaVar.c() > 0) {
                        if (koaVar.t() == 0 || onaVar.c() < koaVar.t()) {
                            koaVar.J(onaVar.c(), 0L);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            } catch (RuntimeException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            } catch (JSONException unused) {
                if (d) {
                    Log.d("UBCDatabaseHelper", "json exception:");
                }
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0100, code lost:
        if (0 <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0103, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[Catch: all -> 0x00e3, TryCatch #0 {all -> 0x00e3, blocks: (B:6:0x0017, B:22:0x0074, B:32:0x008a, B:34:0x00a3, B:35:0x00b9, B:31:0x0086, B:41:0x00df, B:42:0x00e2), top: B:65:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int C(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Throwable th;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.c.writeLock().lock();
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        try {
                            cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM " + str, null);
                        } catch (RuntimeException e2) {
                            e = e2;
                            cursor = null;
                        } catch (Throwable th2) {
                            cursor = null;
                            th = th2;
                            bpa.a(cursor);
                            throw th;
                        }
                        if (cursor != null) {
                            try {
                                try {
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    if (d) {
                                        e.printStackTrace();
                                    }
                                    bpa.a(cursor);
                                    i = 0;
                                    i2 = writableDatabase.delete(str, "_id < " + i, null);
                                    if (d) {
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                }
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    if (cursor.getInt(0) > hoa.m().l()) {
                                        int i3 = cursor.getInt(1);
                                        int i4 = cursor.getInt(2);
                                        if (hoa.m().o()) {
                                            i = (i3 + i4) / 3;
                                        } else {
                                            i = (i3 + i4) / 2;
                                        }
                                        bpa.a(cursor);
                                        i2 = writableDatabase.delete(str, "_id < " + i, null);
                                        if (d) {
                                            Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + i2);
                                        }
                                        writableDatabase.setTransactionSuccessful();
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bpa.a(cursor);
                                throw th;
                            }
                        }
                        i = 0;
                        bpa.a(cursor);
                        i2 = writableDatabase.delete(str, "_id < " + i, null);
                        if (d) {
                        }
                        writableDatabase.setTransactionSuccessful();
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e4) {
                    if (d) {
                        e4.printStackTrace();
                    }
                    this.a.h(e4);
                    this.c.writeLock().unlock();
                }
            } finally {
                this.c.writeLock().unlock();
                if (0 > 0) {
                    coa.a().b(String.valueOf(fna.o().l()), 0, str);
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    public ina I(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.c.readLock().lock();
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                    boolean equals = TextUtils.equals(cursor.getString(cursor.getColumnIndex("switch")), "1");
                                    int i = cursor.getInt(cursor.getColumnIndex("cycle"));
                                    if (i == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    ina inaVar = new ina(string, equals, z, i, TextUtils.equals("1", cursor.getString(cursor.getColumnIndex("type"))) ? 1 : 0, TextUtils.equals(cursor.getString(cursor.getColumnIndex("reserve1")), "1"));
                                    String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                    if (!TextUtils.isEmpty(string2)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(string2);
                                            String optString = jSONObject.optString("dfc");
                                            if (!TextUtils.isEmpty(optString)) {
                                                inaVar.x(TextUtils.equals(optString, "1"));
                                            }
                                            String optString2 = jSONObject.optString("version");
                                            if (!TextUtils.isEmpty(optString2)) {
                                                inaVar.G(optString2);
                                            }
                                            if (jSONObject.has("uploadType")) {
                                                inaVar.F(jSONObject.optInt("uploadType", -1));
                                            }
                                            int optInt = jSONObject.optInt("lcache", 2);
                                            if (optInt == 1 || optInt == 0) {
                                                inaVar.B(optInt);
                                            }
                                            if (lna.a(string) && jSONObject.has("isSend")) {
                                                inaVar.y(jSONObject.optBoolean("isSend", true));
                                            }
                                        } catch (JSONException e2) {
                                            if (d) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    inaVar.E(TextUtils.equals(cursor.getString(cursor.getColumnIndex("reallog")), "1"));
                                    bpa.a(cursor);
                                    return inaVar;
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                if (d) {
                                    e.printStackTrace();
                                }
                                bpa.a(cursor);
                                return null;
                            }
                        }
                    } catch (RuntimeException e4) {
                        e = e4;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bpa.a(null);
                        throw th;
                    }
                    bpa.a(cursor);
                } catch (SQLException e5) {
                    if (d) {
                        e5.printStackTrace();
                    }
                    this.a.h(e5);
                }
                return null;
            } finally {
                this.c.readLock().unlock();
            }
        }
        return (ina) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0100 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef A[Catch: all -> 0x0122, SQLException -> 0x0124, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SQLException -> 0x0124, blocks: (B:8:0x001b, B:41:0x00ef, B:44:0x00fc, B:61:0x011e, B:62:0x0121), top: B:79:0x001b, outer: #2 }] */
    /* JADX WARN: Type inference failed for: r15v0, types: [int] */
    /* JADX WARN: Type inference failed for: r15v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, wna.a> T(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (i <= 0) {
                return null;
            }
            ?? readLock = this.c.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        readLock = getReadableDatabase();
                        HashMap hashMap = new HashMap();
                        try {
                            try {
                                readLock.beginTransactionNonExclusive();
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                cursor = readLock.rawQuery("SELECT ubcid" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ubctime" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "count" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "callcnt FROM arrival WHERE date(ubctime) > date('now', '-" + ((int) i) + " day')  ORDER BY date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + WordCommandManager.DESC, null);
                                if (cursor != null) {
                                    try {
                                        if (cursor.getCount() > 0) {
                                            cursor.moveToFirst();
                                            int columnIndex = cursor.getColumnIndex("ubcid");
                                            int columnIndex2 = cursor.getColumnIndex("ubctime");
                                            int columnIndex3 = cursor.getColumnIndex("count");
                                            int columnIndex4 = cursor.getColumnIndex("callcnt");
                                            do {
                                                String string = cursor.getString(columnIndex);
                                                String string2 = cursor.getString(columnIndex2);
                                                int i2 = cursor.getInt(columnIndex3);
                                                int i3 = cursor.getInt(columnIndex4);
                                                if (i2 >= 1 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                                    wna.f().e(hashMap, string2, string, i2, i3);
                                                }
                                            } while (cursor.moveToNext());
                                        }
                                    } catch (SQLException e2) {
                                        e = e2;
                                        if (d) {
                                            e.printStackTrace();
                                        }
                                        this.a.h(e);
                                        bpa.a(cursor);
                                        readLock.setTransactionSuccessful();
                                        if (hashMap.size() > 0) {
                                        }
                                        return null;
                                    }
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                cursor = null;
                            } catch (Throwable th2) {
                                th = th2;
                                i = 0;
                                bpa.a(i);
                                throw th;
                            }
                            bpa.a(cursor);
                            readLock.setTransactionSuccessful();
                            if (hashMap.size() > 0) {
                                return hashMap;
                            }
                        } catch (SQLException e4) {
                            if (d) {
                                e4.printStackTrace();
                            }
                            this.a.h(e4);
                        } catch (RuntimeException e5) {
                            if (d) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (SQLException e6) {
                        if (d) {
                            e6.printStackTrace();
                        }
                        this.a.h(e6);
                    }
                    return null;
                } finally {
                    readLock.endTransaction();
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
        return (Map) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9 A[Catch: all -> 0x00f8, TryCatch #0 {all -> 0x00f8, blocks: (B:11:0x0024, B:14:0x005d, B:16:0x0070, B:18:0x0090, B:19:0x0099, B:21:0x009f, B:23:0x00a6, B:24:0x00ae, B:26:0x00b8, B:34:0x00c9, B:35:0x00d2, B:37:0x00dd, B:38:0x00f1, B:29:0x00bf, B:31:0x00c3, B:15:0x0069), top: B:61:0x0024, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd A[Catch: all -> 0x00f8, TryCatch #0 {all -> 0x00f8, blocks: (B:11:0x0024, B:14:0x005d, B:16:0x0070, B:18:0x0090, B:19:0x0099, B:21:0x009f, B:23:0x00a6, B:24:0x00ae, B:26:0x00b8, B:34:0x00c9, B:35:0x00d2, B:37:0x00dd, B:38:0x00f1, B:29:0x00bf, B:31:0x00c3, B:15:0x0069), top: B:61:0x0024, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a0(ona onaVar) {
        SQLiteDatabase writableDatabase;
        ContentValues contentValues;
        JSONObject jSONObject;
        boolean z;
        boolean z2;
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onaVar) == null) {
            if (onaVar != null && !TextUtils.isEmpty(onaVar.l())) {
                this.c.writeLock().lock();
                try {
                    try {
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("flowid", onaVar.l());
                            contentValues.put("flowhandle", Integer.valueOf(onaVar.k()));
                            contentValues.put("state", onaVar.o());
                            contentValues.put("begintime", Long.valueOf(onaVar.c()));
                            if (onaVar.m() != null) {
                                contentValues.put("content", onaVar.m().toString());
                            } else {
                                contentValues.put("content", onaVar.g());
                            }
                            contentValues.put(SpeedStatsUtils.UBC_KEY_OPTION, Integer.valueOf(onaVar.n()));
                            contentValues.put("reserve1", onaVar.j());
                            if (!TextUtils.isEmpty(onaVar.f())) {
                                contentValues.put("reserve2", onaVar.f());
                            }
                            jSONObject = new JSONObject();
                            z = true;
                            try {
                                z2 = false;
                                if (onaVar.p()) {
                                    jSONObject.put("ctr", "1");
                                    z = false;
                                }
                                d2 = onaVar.d();
                            } catch (JSONException e2) {
                                if (d) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e3) {
                        if (d) {
                            e3.printStackTrace();
                        }
                        this.a.h(e3);
                    }
                    if (!TextUtils.isEmpty(d2)) {
                        jSONObject.put("bizInfo", d2);
                        if (!z2) {
                            contentValues.put("extend", jSONObject.toString());
                        }
                        long insert = writableDatabase.insert("flow", null, contentValues);
                        if (d) {
                            Log.d("UBCDatabaseHelper", "saveFlow#performTransaction: rowId=" + insert);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    }
                    z2 = z;
                    if (!z2) {
                    }
                    long insert2 = writableDatabase.insert("flow", null, contentValues);
                    if (d) {
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } finally {
                    this.c.writeLock().unlock();
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "saveFlow#event id must not be null");
            }
        }
    }

    public final String D(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT a.* FROM ");
            if (z) {
                sb.append("event");
                sb.append(" a ");
                sb.append("LEFT JOIN ");
                sb.append("config");
                sb.append(" b ");
                sb.append("ON a.");
                sb.append("eventid");
                sb.append(" = b.");
                sb.append("eventid");
                sb.append(" WHERE ");
                sb.append("a.");
                sb.append("flowhandle");
                sb.append(" = ");
                sb.append(-1);
                sb.append(" AND ");
                sb.append("(a.");
                sb.append("reallog");
                sb.append(" = '0' OR a.");
                sb.append("reallog");
                sb.append(" = '')");
            } else {
                sb.append("flow");
                sb.append(" a ");
                sb.append("LEFT JOIN ");
                sb.append("config");
                sb.append(" b ");
                sb.append("ON a.");
                sb.append("flowid");
                sb.append(" = b.");
                sb.append("eventid");
                sb.append(" WHERE ");
                sb.append("a.");
                sb.append("endtime");
                sb.append(" IS NOT NULL");
            }
            if (z3) {
                sb.append(" AND (b.");
                sb.append("switch");
                sb.append(" IS NULL OR b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("')");
            } else {
                sb.append(" AND b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("'");
            }
            if (z2) {
                sb.append(" AND ");
                sb.append("(b.");
                sb.append("cycle");
                sb.append(" = 0)");
                sb.append(" ORDER BY a.");
                sb.append("begintime");
                sb.append(WordCommandManager.DESC);
            } else {
                sb.append(" AND ");
                sb.append("(b.");
                sb.append("cycle");
                sb.append(" > 0)");
                sb.append(" ORDER BY a.");
                sb.append("begintime");
                sb.append(" ASC");
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public int E(koa koaVar, koa koaVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, koaVar, koaVar2)) == null) {
            int G = G(koaVar, koaVar2);
            if (koaVar.z() && koaVar2.z()) {
                return 1;
            }
            if (koaVar.w() && koaVar2.w()) {
                return 0;
            }
            return F(koaVar, koaVar2) | G;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0162 A[EDGE_INSN: B:136:0x0162->B:88:0x0162 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0164 A[LOOP:0: B:131:0x0055->B:89:0x0164, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int F(koa koaVar, koa koaVar2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, koaVar, koaVar2)) == null) {
            this.c.readLock().lock();
            int i = 0;
            try {
                try {
                    boolean z2 = koaVar.z();
                    boolean z3 = koaVar2.z();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery("SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"", null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                int i2 = 0;
                                while (true) {
                                    try {
                                        String string = cursor.getString(columnIndex);
                                        if (!TextUtils.isEmpty(string)) {
                                            mna mnaVar = new mna(string);
                                            boolean e2 = fna.o().e(string);
                                            if (z2 && z3) {
                                                break;
                                            } else if ((!z2 || !e2) && (!z3 || e2)) {
                                                try {
                                                    if (koaVar.w() && koaVar2.w()) {
                                                        bpa.a(cursor);
                                                        return i;
                                                    } else if ((!e2 || !koaVar.w()) && (!e2 || !koaVar2.w())) {
                                                        z = z2;
                                                        mnaVar.B(cursor.getLong(columnIndex2));
                                                        String string2 = cursor.getString(columnIndex3);
                                                        if (!TextUtils.isEmpty(string2)) {
                                                            mnaVar.t(string2);
                                                        }
                                                        String string3 = cursor.getString(columnIndex4);
                                                        if (!TextUtils.isEmpty(string3)) {
                                                            mnaVar.w(string3);
                                                        }
                                                        String string4 = cursor.getString(columnIndex5);
                                                        if (!TextUtils.isEmpty(string4)) {
                                                            mnaVar.s(string4);
                                                        }
                                                        String string5 = cursor.getString(columnIndex6);
                                                        if (!TextUtils.isEmpty(string5)) {
                                                            JSONObject jSONObject = new JSONObject(string5);
                                                            if (jSONObject.has("ctr")) {
                                                                mnaVar.u(true);
                                                            }
                                                            if (jSONObject.has("bizInfo")) {
                                                                mnaVar.r(jSONObject.optString("bizInfo"));
                                                            }
                                                        }
                                                        int g = mnaVar.g();
                                                        if (e2) {
                                                            if (d(mnaVar, g, koaVar)) {
                                                                if (koaVar.z()) {
                                                                    z = true;
                                                                }
                                                                if (i2 == 0) {
                                                                    i2 = 1;
                                                                }
                                                                if (!koaVar.w() && koaVar2.w()) {
                                                                    bpa.a(cursor);
                                                                    this.c.readLock().unlock();
                                                                    return 0;
                                                                }
                                                                i = 0;
                                                                if (z && z3) {
                                                                    break;
                                                                }
                                                                if (!cursor.moveToNext()) {
                                                                }
                                                            } else {
                                                                i = 0;
                                                                if (!cursor.moveToNext()) {
                                                                    break;
                                                                }
                                                                z2 = z;
                                                            }
                                                        } else {
                                                            if (d(mnaVar, g, koaVar2)) {
                                                                if (koaVar2.z()) {
                                                                    z3 = true;
                                                                }
                                                                if (i2 == 0) {
                                                                }
                                                                if (!koaVar.w()) {
                                                                }
                                                                i = 0;
                                                                if (z) {
                                                                    break;
                                                                    break;
                                                                }
                                                                if (!cursor.moveToNext()) {
                                                                }
                                                            }
                                                            i = 0;
                                                            if (!cursor.moveToNext()) {
                                                            }
                                                        }
                                                    }
                                                } catch (SQLException e3) {
                                                    e = e3;
                                                    i = i2;
                                                    if (d) {
                                                        e.printStackTrace();
                                                    }
                                                    this.a.h(e);
                                                    return i;
                                                }
                                            }
                                        }
                                        z = z2;
                                        i = 0;
                                        if (!cursor.moveToNext()) {
                                        }
                                    } catch (RuntimeException e4) {
                                        e = e4;
                                        i = i2;
                                        if (d) {
                                            e.printStackTrace();
                                        }
                                        bpa.a(cursor);
                                        return i;
                                    } catch (JSONException unused) {
                                        i = i2;
                                        if (d) {
                                            Log.d("UBCDatabaseHelper", "json exception:");
                                        }
                                        bpa.a(cursor);
                                        return i;
                                    } catch (Throwable th) {
                                        th = th;
                                        i = i2;
                                        bpa.a(cursor);
                                        throw th;
                                    }
                                }
                                i = i2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (RuntimeException e5) {
                        e = e5;
                    } catch (JSONException unused2) {
                    }
                    bpa.a(cursor);
                } catch (SQLException e6) {
                    e = e6;
                }
                return i;
            } finally {
                this.c.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0150 A[EDGE_INSN: B:123:0x0150->B:62:0x0150 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0143 A[Catch: RuntimeException -> 0x0159, all -> 0x017c, TryCatch #10 {all -> 0x017c, blocks: (B:60:0x014a, B:54:0x013c, B:57:0x0143, B:79:0x0170, B:81:0x0174), top: B:113:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0152 A[LOOP:0: B:12:0x0069->B:63:0x0152, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018d A[Catch: all -> 0x019f, TryCatch #12 {all -> 0x019f, blocks: (B:71:0x0165, B:93:0x0189, B:95:0x018d, B:96:0x0190, B:82:0x0177, B:84:0x017d, B:85:0x0180), top: B:116:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int O(String str, koa koaVar) {
        InterceptResult invokeLL;
        yna ynaVar;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, koaVar)) == null) {
            this.c.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            try {
                                cursor = readableDatabase.rawQuery(str, null);
                                if (cursor != null && cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    int columnIndex = cursor.getColumnIndex("flowid");
                                    int columnIndex2 = cursor.getColumnIndex("flowhandle");
                                    int columnIndex3 = cursor.getColumnIndex("state");
                                    int columnIndex4 = cursor.getColumnIndex("begintime");
                                    int columnIndex5 = cursor.getColumnIndex("endtime");
                                    int columnIndex6 = cursor.getColumnIndex("content");
                                    int columnIndex7 = cursor.getColumnIndex(SpeedStatsUtils.UBC_KEY_OPTION);
                                    int columnIndex8 = cursor.getColumnIndex("reserve1");
                                    int columnIndex9 = cursor.getColumnIndex("reserve2");
                                    int columnIndex10 = cursor.getColumnIndex("slot");
                                    int columnIndex11 = cursor.getColumnIndex("extend");
                                    while (true) {
                                        try {
                                            if (!"2".equals(cursor.getString(columnIndex3)) && (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) <= 86400000 || (cursor.getInt(columnIndex7) & 4) == 0)) {
                                                i2 = columnIndex;
                                                i3 = columnIndex2;
                                                ynaVar = this;
                                                try {
                                                    if (cursor.moveToNext()) {
                                                        break;
                                                    }
                                                    columnIndex = i2;
                                                    columnIndex2 = i3;
                                                } catch (RuntimeException e2) {
                                                    e = e2;
                                                    if (d) {
                                                        e.printStackTrace();
                                                    }
                                                    bpa.a(cursor);
                                                    i = 0;
                                                    ynaVar.c.readLock().unlock();
                                                    return i;
                                                }
                                            }
                                            ona onaVar = new ona();
                                            onaVar.A(cursor.getString(columnIndex));
                                            onaVar.z(cursor.getInt(columnIndex2));
                                            i2 = columnIndex;
                                            i3 = columnIndex2;
                                            onaVar.q(cursor.getLong(columnIndex4));
                                            onaVar.v(cursor.getLong(columnIndex5));
                                            String string = cursor.getString(columnIndex6);
                                            if (!TextUtils.isEmpty(string)) {
                                                onaVar.t(string);
                                            }
                                            String string2 = cursor.getString(columnIndex8);
                                            if (!TextUtils.isEmpty(string2)) {
                                                onaVar.y(string2);
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                                onaVar.s(cursor.getString(columnIndex9));
                                            }
                                            String string3 = cursor.getString(columnIndex10);
                                            if (columnIndex10 >= 0 && !TextUtils.isEmpty(string3)) {
                                                onaVar.B(string3);
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex11));
                                                    if (jSONObject.has("ctr")) {
                                                        try {
                                                            onaVar.u(true);
                                                        } catch (JSONException e3) {
                                                            e = e3;
                                                            e.printStackTrace();
                                                            ynaVar = this;
                                                            if (!ynaVar.g(readableDatabase, onaVar, onaVar.h(), koaVar)) {
                                                            }
                                                            i = 1;
                                                            bpa.a(cursor);
                                                            ynaVar.c.readLock().unlock();
                                                            return i;
                                                        }
                                                    }
                                                    if (jSONObject.has("bizInfo")) {
                                                        onaVar.r(jSONObject.optString("bizInfo"));
                                                    }
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                }
                                            }
                                            ynaVar = this;
                                            if (!ynaVar.g(readableDatabase, onaVar, onaVar.h(), koaVar)) {
                                                break;
                                            }
                                            if (!koaVar.z()) {
                                                break;
                                            }
                                            if (cursor.moveToNext()) {
                                            }
                                        } catch (RuntimeException e5) {
                                            e = e5;
                                            ynaVar = this;
                                        } catch (Throwable th) {
                                            th = th;
                                            bpa.a(cursor);
                                            throw th;
                                        }
                                    }
                                    i = 1;
                                } else {
                                    ynaVar = this;
                                    i = 0;
                                }
                            } catch (SQLException e6) {
                                e = e6;
                                i = 0;
                                if (d) {
                                    e.printStackTrace();
                                }
                                ynaVar.a.h(e);
                                ynaVar.c.readLock().unlock();
                                return i;
                            }
                            try {
                                bpa.a(cursor);
                            } catch (SQLException e7) {
                                e = e7;
                                if (d) {
                                }
                                ynaVar.a.h(e);
                                ynaVar.c.readLock().unlock();
                                return i;
                            }
                        } catch (RuntimeException e8) {
                            e = e8;
                            ynaVar = this;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    this.c.readLock().unlock();
                    throw th;
                }
            } catch (SQLException e9) {
                e = e9;
                ynaVar = this;
            } catch (Throwable th5) {
                th = th5;
                this.c.readLock().unlock();
                throw th;
            }
            ynaVar.c.readLock().unlock();
            return i;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0174 A[Catch: all -> 0x01bd, TryCatch #4 {all -> 0x01bd, blocks: (B:39:0x0143, B:41:0x0148, B:46:0x0156, B:49:0x016b, B:51:0x0174, B:53:0x017e, B:54:0x0183, B:56:0x018e, B:57:0x01a2, B:44:0x0150), top: B:88:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018e A[Catch: all -> 0x01bd, TryCatch #4 {all -> 0x01bd, blocks: (B:39:0x0143, B:41:0x0148, B:46:0x0156, B:49:0x016b, B:51:0x0174, B:53:0x017e, B:54:0x0183, B:56:0x018e, B:57:0x01a2, B:44:0x0150), top: B:88:0x0143 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o(koa koaVar, String str) {
        InterceptResult invokeLL;
        boolean z;
        int i;
        int i2;
        koa koaVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, koaVar, str)) == null) {
            String str2 = "0";
            SparseArray<Integer> r = koaVar.r();
            ArrayList q = koaVar.q();
            boolean B = koaVar.B();
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        try {
                            if (r != null) {
                                try {
                                    if (r.size() > 0) {
                                        int size = r.size();
                                        ArrayList arrayList = new ArrayList(size);
                                        for (int i3 = 0; i3 < size; i3++) {
                                            arrayList.add(Integer.valueOf(r.keyAt(i3)));
                                        }
                                        String P = P(arrayList);
                                        if (d) {
                                            Log.d("UBCDatabaseHelper", "save file name " + str + " delete flow handle ids = " + P);
                                        }
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("flowhandle");
                                        sb.append(" in (");
                                        sb.append(P);
                                        sb.append(SmallTailInfo.EMOTION_SUFFIX);
                                        i = writableDatabase.delete("flow", sb.toString(), null);
                                        if (d) {
                                            Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: flow table delete count:" + i);
                                        }
                                        try {
                                            int delete = writableDatabase.delete("event", sb.toString(), null);
                                            if (d) {
                                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete);
                                            }
                                            if (q == null && q.size() > 0) {
                                                String P2 = P(q);
                                                if (d) {
                                                    Log.d("UBCDatabaseHelper", "delete event ids = " + P2);
                                                }
                                                i2 = writableDatabase.delete("event", "eventid in (" + P2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                                                if (d) {
                                                    Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: event table count2:" + i2);
                                                }
                                                koaVar2 = koaVar;
                                            } else {
                                                koaVar2 = koaVar;
                                                i2 = 0;
                                            }
                                            p(writableDatabase, koaVar2);
                                            if ((r != null && r.size() > 0) || (q != null && q.size() > 0)) {
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put(BreakpointSQLiteKey.FILENAME, str);
                                                contentValues.put("state", "0");
                                                if (B) {
                                                    str2 = "1";
                                                }
                                                contentValues.put("reserve1", str2);
                                                if (koaVar.x()) {
                                                    String N = N(koaVar);
                                                    if (!TextUtils.isEmpty(N)) {
                                                        contentValues.put("reserve2", N);
                                                    }
                                                }
                                                long insert = writableDatabase.insert("file", null, contentValues);
                                                if (d) {
                                                    Log.d("UBCDatabaseHelper", "clearUploadedData#save file: rowId=" + insert);
                                                }
                                            }
                                            writableDatabase.setTransactionSuccessful();
                                            writableDatabase.endTransaction();
                                            hoa.m().s(i2, i);
                                            this.c.writeLock().unlock();
                                            return true;
                                        } catch (Throwable th) {
                                            th = th;
                                            i2 = 0;
                                            writableDatabase.endTransaction();
                                            hoa.m().s(i2, i);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    i = 0;
                                    i2 = 0;
                                    writableDatabase.endTransaction();
                                    hoa.m().s(i2, i);
                                    throw th;
                                }
                            }
                            if (r != null) {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put(BreakpointSQLiteKey.FILENAME, str);
                                contentValues2.put("state", "0");
                                if (B) {
                                }
                                contentValues2.put("reserve1", str2);
                                if (koaVar.x()) {
                                }
                                long insert2 = writableDatabase.insert("file", null, contentValues2);
                                if (d) {
                                }
                                writableDatabase.setTransactionSuccessful();
                                writableDatabase.endTransaction();
                                hoa.m().s(i2, i);
                                this.c.writeLock().unlock();
                                return true;
                            }
                            writableDatabase.endTransaction();
                            hoa.m().s(i2, i);
                            this.c.writeLock().unlock();
                            return true;
                        } catch (SQLException e2) {
                            e = e2;
                            z = true;
                            if (d) {
                                e.printStackTrace();
                            }
                            this.a.h(e);
                            return z;
                        }
                        p(writableDatabase, koaVar2);
                        ContentValues contentValues22 = new ContentValues();
                        contentValues22.put(BreakpointSQLiteKey.FILENAME, str);
                        contentValues22.put("state", "0");
                        if (B) {
                        }
                        contentValues22.put("reserve1", str2);
                        if (koaVar.x()) {
                        }
                        long insert22 = writableDatabase.insert("file", null, contentValues22);
                        if (d) {
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (Throwable th3) {
                        th = th3;
                        writableDatabase.endTransaction();
                        hoa.m().s(i2, i);
                        throw th;
                    }
                    i = 0;
                    if (q == null) {
                    }
                    koaVar2 = koaVar;
                    i2 = 0;
                } catch (SQLException e3) {
                    e = e3;
                    z = false;
                }
            } finally {
                this.c.writeLock().unlock();
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x01f5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0216 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:129:0x0231 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:179:0x0204 */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:14|15)|(2:47|(2:49|(7:(8:60|(1:(18:83|84|85|(1:87)|88|(1:90)|91|(1:93)|94|(1:98)|99|100|(5:133|134|(1:136)|137|(1:139))|102|(3:104|105|(6:107|22|23|24|25|(1:28)(1:27))(3:108|(1:110)|111))(6:128|(2:130|(1:132))|23|24|25|(0)(0))|(1:113)|114|(5:124|(1:127)|24|25|(0)(0))(4:118|119|120|121)))(4:64|65|66|67)|71|72|(1:74)|75|31|32)|56|22|23|24|25|(0)(0))(2:52|53)))|21|22|23|24|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0214, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0216, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0240, code lost:
        r0.printStackTrace();
        r3 = r3;
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0207 A[LOOP:0: B:172:0x0077->B:111:0x0207, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0240 A[Catch: all -> 0x0244, TRY_LEAVE, TryCatch #4 {all -> 0x0244, blocks: (B:135:0x023c, B:137:0x0240), top: B:161:0x023c }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0204 A[EDGE_INSN: B:177:0x0204->B:110:0x0204 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.yna] */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int G(koa koaVar, koa koaVar2) {
        InterceptResult invokeLL;
        yna ynaVar;
        yna ynaVar2;
        ?? r3;
        boolean z;
        boolean z2;
        Cursor cursor;
        yna ynaVar3;
        boolean z3;
        yna ynaVar4;
        boolean z4;
        SQLiteDatabase sQLiteDatabase;
        int i;
        int i2;
        String str;
        SQLiteDatabase sQLiteDatabase2;
        yna ynaVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, koaVar, koaVar2)) == null) {
            yna ynaVar6 = this;
            String str2 = "bizInfo";
            ReentrantReadWriteLock.ReadLock readLock = ynaVar6.c.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        z = koaVar.z();
                        z2 = koaVar2.z();
                        ynaVar = getReadableDatabase();
                        cursor = null;
                        try {
                            try {
                                cursor = ynaVar.rawQuery(" SELECT * FROM flow", null);
                            } catch (SQLException e2) {
                                e = e2;
                            }
                        } catch (RuntimeException e3) {
                            e = e3;
                            ynaVar3 = ynaVar6;
                            z3 = false;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r6.c.readLock().unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    yna ynaVar7 = ynaVar6;
                    ynaVar7.c.readLock().unlock();
                    throw th;
                }
            } catch (SQLException e4) {
                e = e4;
                ynaVar = ynaVar6;
                readLock = null;
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("flowid");
                int columnIndex2 = cursor.getColumnIndex("flowhandle");
                int columnIndex3 = cursor.getColumnIndex("state");
                int columnIndex4 = cursor.getColumnIndex("begintime");
                int columnIndex5 = cursor.getColumnIndex("endtime");
                int columnIndex6 = cursor.getColumnIndex("content");
                int columnIndex7 = cursor.getColumnIndex(SpeedStatsUtils.UBC_KEY_OPTION);
                int columnIndex8 = cursor.getColumnIndex("reserve1");
                int columnIndex9 = cursor.getColumnIndex("reserve2");
                boolean z5 = z;
                int columnIndex10 = cursor.getColumnIndex("slot");
                boolean z6 = z2;
                int columnIndex11 = cursor.getColumnIndex("extend");
                boolean z7 = false;
                SQLiteDatabase sQLiteDatabase3 = ynaVar;
                while (true) {
                    try {
                        sQLiteDatabase = sQLiteDatabase3;
                    } catch (RuntimeException e5) {
                        e = e5;
                        ynaVar = ynaVar6;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                        String string = cursor.getString(columnIndex);
                        int i3 = cursor.getInt(columnIndex2);
                        if (i3 >= 0) {
                            i = columnIndex2;
                            boolean e6 = fna.o().e(string);
                            if (z5 && z6) {
                                ynaVar = ynaVar6;
                                break;
                            }
                            if ((!z5 || !e6) && (!z6 || e6)) {
                                if (koaVar.w() && koaVar2.w()) {
                                    try {
                                        bpa.a(cursor);
                                        ynaVar6.c.readLock().unlock();
                                        return 0;
                                    } catch (SQLException e7) {
                                        e = e7;
                                        ynaVar = ynaVar6;
                                    }
                                } else if ((!e6 || !koaVar.w()) && (!e6 || !koaVar2.w())) {
                                    i2 = columnIndex3;
                                    ona onaVar = new ona();
                                    onaVar.A(cursor.getString(columnIndex));
                                    onaVar.z(i3);
                                    try {
                                        onaVar.q(cursor.getLong(columnIndex4));
                                        onaVar.v(cursor.getLong(columnIndex5));
                                        String string2 = cursor.getString(columnIndex6);
                                        if (!TextUtils.isEmpty(string2)) {
                                            onaVar.t(string2);
                                        }
                                        String string3 = cursor.getString(columnIndex8);
                                        if (!TextUtils.isEmpty(string3)) {
                                            onaVar.y(string3);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                            onaVar.s(cursor.getString(columnIndex9));
                                        }
                                        String string4 = cursor.getString(columnIndex10);
                                        if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                            onaVar.B(string4);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex11));
                                                if (jSONObject.has("ctr")) {
                                                    onaVar.u(true);
                                                }
                                                if (jSONObject.has(str2)) {
                                                    onaVar.r(jSONObject.optString(str2));
                                                }
                                            } catch (JSONException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        int h = onaVar.h();
                                        if (e6) {
                                            ynaVar = this;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            if (!ynaVar.g(sQLiteDatabase2, onaVar, h, koaVar)) {
                                                str = str2;
                                                ynaVar5 = ynaVar;
                                                ynaVar = ynaVar5;
                                                if (!cursor.moveToNext()) {
                                                    break;
                                                }
                                                columnIndex2 = i;
                                                columnIndex3 = i2;
                                                str2 = str;
                                                yna ynaVar8 = ynaVar;
                                                sQLiteDatabase3 = sQLiteDatabase2;
                                                ynaVar6 = ynaVar8;
                                            } else {
                                                str = str2;
                                                if (koaVar.z()) {
                                                    z5 = true;
                                                }
                                            }
                                        } else {
                                            ynaVar = this;
                                            str = str2;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            boolean g = ynaVar.g(sQLiteDatabase2, onaVar, h, koaVar2);
                                            ynaVar5 = ynaVar;
                                            if (g) {
                                                if (koaVar2.z()) {
                                                    z6 = true;
                                                }
                                            }
                                            ynaVar = ynaVar5;
                                            if (!cursor.moveToNext()) {
                                            }
                                        }
                                        if (!z7) {
                                            z7 = true;
                                        }
                                        if (koaVar.w() && koaVar2.w()) {
                                            try {
                                                bpa.a(cursor);
                                                ynaVar.c.readLock().unlock();
                                                return 0;
                                            } catch (SQLException e9) {
                                                e = e9;
                                            }
                                        } else {
                                            ynaVar = ynaVar;
                                            ynaVar = ynaVar;
                                            if (z5 && z6) {
                                                break;
                                            }
                                            if (!cursor.moveToNext()) {
                                            }
                                        }
                                    } catch (RuntimeException e10) {
                                        e = e10;
                                        ynaVar = this;
                                        z3 = z7;
                                        ynaVar3 = ynaVar;
                                        try {
                                            z4 = z3;
                                            ynaVar4 = ynaVar3;
                                            if (d) {
                                            }
                                            bpa.a(cursor);
                                            r3 = z4;
                                            ynaVar2 = ynaVar4;
                                            ynaVar2.c.readLock().unlock();
                                            return r3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bpa.a(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bpa.a(cursor);
                                        throw th;
                                    }
                                }
                                readLock = z7;
                                if (d) {
                                    e.printStackTrace();
                                }
                                ynaVar.a.h(e);
                                r3 = readLock;
                                ynaVar2 = ynaVar;
                                ynaVar2.c.readLock().unlock();
                                return r3;
                            }
                            ynaVar = ynaVar6;
                            str = str2;
                            i2 = columnIndex3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            ynaVar5 = ynaVar;
                            ynaVar = ynaVar5;
                            if (!cursor.moveToNext()) {
                            }
                        }
                    }
                    ynaVar = ynaVar6;
                    str = str2;
                    i = columnIndex2;
                    i2 = columnIndex3;
                    sQLiteDatabase2 = sQLiteDatabase;
                    ynaVar5 = ynaVar;
                    ynaVar = ynaVar5;
                    if (!cursor.moveToNext()) {
                    }
                }
                z4 = z7;
                ynaVar4 = ynaVar;
            } else {
                ynaVar4 = ynaVar6;
                z4 = false;
            }
            bpa.a(cursor);
            r3 = z4;
            ynaVar2 = ynaVar4;
            ynaVar2.c.readLock().unlock();
            return r3;
        }
        return invokeLL.intValue;
    }

    public HashMap<String, String> H(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, arrayList)) == null) {
            this.c.readLock().lock();
            HashMap<String, String> hashMap = new HashMap<>();
            String P = P(arrayList);
            try {
                try {
                    cursor = null;
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                }
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT eventid,extend FROM config WHERE eventid in (" + P + SmallTailInfo.EMOTION_SUFFIX, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                    hashMap.put(string, string2);
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (SQLiteException e3) {
                        if (d) {
                            e3.printStackTrace();
                        }
                    }
                    return hashMap;
                } finally {
                    bpa.a(cursor);
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
        return (HashMap) invokeL.objValue;
    }

    public void Y(mna mnaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, mnaVar) == null) {
            if (mnaVar != null && !TextUtils.isEmpty(mnaVar.l())) {
                this.c.writeLock().lock();
                try {
                    try {
                        ContentValues M = M(mnaVar);
                        String k = mnaVar.k();
                        String l = mnaVar.l();
                        int j = mnaVar.j();
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            if (l(k, l, j, writableDatabase)) {
                                long insert = writableDatabase.insert("event", null, M);
                                if (d) {
                                    Log.d("UBCDatabaseHelper", "saveEvent#performTransaction: rowId=" + insert);
                                }
                                if (insert > 0) {
                                    hoa.m().x(l, j);
                                    if (mnaVar.j() == -1) {
                                        wna.f().a(mnaVar.l(), false);
                                    }
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                        this.a.h(e2);
                    }
                } finally {
                    this.c.writeLock().unlock();
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "saveEvent#event id must not be null");
            }
        }
    }

    public boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.c.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery("SELECT * FROM config WHERE eventid=\"" + str + "\"", null);
                    if (cursor != null && cursor.getCount() != 0) {
                        int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                        writableDatabase.setTransactionSuccessful();
                        if (delete > 0) {
                            z = true;
                        }
                        return z;
                    }
                    return true;
                } finally {
                    bpa.a(cursor);
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                if (d) {
                    e2.printStackTrace();
                }
                this.a.h(e2);
                return false;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            this.c.readLock().lock();
            int i = 0;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery("SELECT COUNT(eventid) FROM config", null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                i = cursor.getInt(0);
                            }
                        } catch (SQLException e2) {
                            if (d) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        bpa.a(cursor);
                    }
                } finally {
                    this.c.readLock().unlock();
                }
            } catch (SQLException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, null, null);
                        if (d) {
                            Log.d("UBCDatabaseHelper", "updateAllSentFileFail#performTransaction: update file table:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean s() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            this.c.writeLock().lock();
            boolean z = false;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        i = writableDatabase.delete("event", "reallog =?", new String[]{"1"});
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (SQLException e2) {
                            e = e2;
                            if (d) {
                                e.printStackTrace();
                            }
                            this.a.h(e);
                            if (i > 0) {
                            }
                            return z;
                        }
                    } catch (SQLException e3) {
                        e = e3;
                        i = 0;
                    }
                    if (i > 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (d) {
                    e4.printStackTrace();
                }
                this.a.h(e4);
                return false;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public void w() {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
                try {
                    int delete = writableDatabase.delete("file", null, null);
                    if (d) {
                        Log.d("UBCDatabaseHelper", "deleteAllSentFile#performTransaction: delete file table:" + delete);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    public int K(ArrayList<String> arrayList, boolean z, koa koaVar) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{arrayList, Boolean.valueOf(z), koaVar})) == null) {
            String P = P(arrayList);
            if (z) {
                str = " in  (";
            } else {
                str = " not in (";
            }
            if (TextUtils.isEmpty(P) && z) {
                return 0;
            }
            StringBuilder sb = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(P)) {
                sb.append("SELECT * FROM ");
                sb.append("flow");
            } else {
                sb.append("SELECT * ");
                sb.append(" FROM ");
                sb.append("flow");
                sb.append(" WHERE ");
                sb.append("flowid");
                sb.append(str);
                sb.append(P);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            int O = O(sb.toString(), koaVar);
            if (koaVar.w()) {
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(P)) {
                sb2.append("SELECT *  FROM ");
                sb2.append("event");
                sb2.append(" WHERE ");
                sb2.append("flowhandle");
                sb2.append(" = ");
                sb2.append(-1);
                sb2.append(" AND ");
                sb2.append("reallog");
                sb2.append(" = \"0\"");
            } else {
                sb2.append("SELECT *  FROM ");
                sb2.append("event");
                sb2.append(" WHERE ");
                sb2.append("eventid");
                sb2.append(str);
                sb2.append(P);
                sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                sb2.append(" AND ");
                sb2.append("flowhandle");
                sb2.append(" = ");
                sb2.append(-1);
                sb2.append(" AND ");
                sb2.append("reallog");
                sb2.append(" = \"0\"");
            }
            return L(sb2.toString(), koaVar) | O;
        }
        return invokeCommon.intValue;
    }

    public final int L(String str, koa koaVar) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, koaVar)) == null) {
            this.c.readLock().lock();
            int i = 0;
            try {
                try {
                    cursor = null;
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery(str, null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("begintime");
                            int columnIndex3 = cursor.getColumnIndex("content");
                            int columnIndex4 = cursor.getColumnIndex("reserve1");
                            int columnIndex5 = cursor.getColumnIndex("reserve2");
                            int columnIndex6 = cursor.getColumnIndex("extend");
                            do {
                                String string = cursor.getString(columnIndex);
                                if (!TextUtils.isEmpty(string)) {
                                    mna mnaVar = new mna(string);
                                    mnaVar.B(cursor.getLong(columnIndex2));
                                    String string2 = cursor.getString(columnIndex3);
                                    if (!TextUtils.isEmpty(string2)) {
                                        mnaVar.t(string2);
                                    }
                                    String string3 = cursor.getString(columnIndex4);
                                    if (!TextUtils.isEmpty(string3)) {
                                        mnaVar.w(string3);
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                        mnaVar.s(cursor.getString(columnIndex5));
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                        JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex6));
                                        if (jSONObject.has("ctr")) {
                                            mnaVar.u(true);
                                        }
                                        if (jSONObject.has(SpeedStatsUtils.UBC_KEY_OPTION)) {
                                            mnaVar.z(jSONObject.optInt(SpeedStatsUtils.UBC_KEY_OPTION, 0));
                                        }
                                        if (jSONObject.has("bizInfo")) {
                                            mnaVar.r(jSONObject.optString("bizInfo"));
                                        }
                                    }
                                    if (!d(mnaVar, mnaVar.g(), koaVar)) {
                                        break;
                                    } else if (koaVar.z()) {
                                        break;
                                    }
                                }
                            } while (cursor.moveToNext());
                            i = 1;
                        }
                    } catch (RuntimeException e3) {
                        if (d) {
                            e3.printStackTrace();
                        }
                    } catch (JSONException unused) {
                        if (d) {
                            Log.d("UBCDatabaseHelper", "json exception:");
                        }
                    }
                    return i;
                } finally {
                    bpa.a(cursor);
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    public final ContentValues M(mna mnaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, mnaVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(mnaVar.j()));
            contentValues.put("eventid", mnaVar.l());
            contentValues.put("begintime", Long.valueOf(mnaVar.p()));
            if (!TextUtils.isEmpty(mnaVar.f())) {
                contentValues.put("content", mnaVar.f());
            } else if (mnaVar.m() != null && !TextUtils.isEmpty(mnaVar.m().toString())) {
                contentValues.put("content", mnaVar.m().toString());
            }
            if (!TextUtils.isEmpty(mnaVar.h())) {
                contentValues.put("reserve1", mnaVar.h());
            }
            if (!TextUtils.isEmpty(mnaVar.e())) {
                contentValues.put("reserve2", mnaVar.e());
            }
            JSONObject jSONObject = new JSONObject();
            boolean z = true;
            try {
                boolean z2 = false;
                if (mnaVar.q()) {
                    jSONObject.put("ctr", "1");
                    z = false;
                }
                if ((mnaVar.n() & 128) != 0) {
                    jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, mnaVar.n());
                    z = false;
                }
                String c = mnaVar.c();
                if (!TextUtils.isEmpty(c)) {
                    jSONObject.put("bizInfo", c);
                } else {
                    z2 = z;
                }
                if (!z2) {
                    contentValues.put("extend", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(mnaVar.o())) {
                contentValues.put("reallog", mnaVar.o());
            } else {
                contentValues.put("reallog", "0");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00b4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    public nna U(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            ?? r0 = " , ";
            this.c.readLock().lock();
            nna nnaVar = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT state , reserve1 , reserve2 FROM file WHERE " + BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(cursor.getColumnIndex("state"));
                                    String str2 = "";
                                    boolean z = false;
                                    if (!cursor.isNull(cursor.getColumnIndex("reserve1"))) {
                                        str2 = cursor.getString(cursor.getColumnIndex("reserve1"));
                                    }
                                    if (!cursor.isNull(cursor.getColumnIndex("reserve2"))) {
                                        z = X(cursor.getString(cursor.getColumnIndex("reserve2")));
                                    }
                                    nnaVar = new nna(str, string, str2, z);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                if (d) {
                                    e.printStackTrace();
                                }
                                bpa.a(cursor);
                                return nnaVar;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r0 = 0;
                        bpa.a(r0);
                        throw th;
                    }
                    bpa.a(cursor);
                } catch (SQLException e4) {
                    if (d) {
                        e4.printStackTrace();
                    }
                    this.a.h(e4);
                }
                return nnaVar;
            } finally {
                this.c.readLock().unlock();
            }
        }
        return (nna) invokeL.objValue;
    }

    public void V(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sparseArray) == null) {
            this.c.readLock().lock();
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    cursor = null;
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT eventid , type , cycle FROM config WHERE switch=\"1\" AND (reallog = \"0\" OR reallog = \"\")", null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("type");
                            int columnIndex3 = cursor.getColumnIndex("cycle");
                            boolean I = fna.o().I();
                            int w = fna.o().w();
                            do {
                                String string = cursor.getString(columnIndex);
                                if (!lna.a(string)) {
                                    cursor.getString(columnIndex2);
                                    int i = cursor.getInt(columnIndex3);
                                    if (i != 0) {
                                        if (I) {
                                            i = w;
                                        } else if (i < 1) {
                                            i = 1;
                                        } else if (i > 720) {
                                            i = 720;
                                        }
                                    }
                                    if (string != null) {
                                        ArrayList arrayList = sparseArray.get(i);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            sparseArray.put(i, arrayList);
                                        }
                                        arrayList.add(string);
                                    }
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (RuntimeException e3) {
                        if (d) {
                            e3.printStackTrace();
                        }
                    }
                } finally {
                    bpa.a(cursor);
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public final String N(koa koaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, koaVar)) == null) {
            if (koaVar != null && koaVar.x()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ubc_data_backend_type", "1");
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    if (d) {
                        e2.printStackTrace();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String P(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append("'");
                sb.append(arrayList.get(i));
                sb.append("'");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.equals(new JSONObject(str).optString("ubc_data_backend_type", "0"), "1")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void Z(List<mna> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            if (list != null && list.size() != 0) {
                for (mna mnaVar : list) {
                    Y(mnaVar);
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "saveEvents#data must not be null");
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x0203 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0222 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0116 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: com.baidu.tieba.yna */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.baidu.tieba.yna */
    /* JADX WARN: Can't wrap try/catch for region: R(18:3|(12:4|5|6|7|8|9|10|(9:102|103|104|105|106|107|108|109|110)(6:12|13|14|15|16|17)|18|19|20|21)|(3:70|71|(18:73|74|75|76|24|25|26|27|(1:29)(1:55)|30|31|32|33|(1:37)|39|40|41|42))|23|24|25|26|27|(0)(0)|30|31|32|33|(2:35|37)|39|40|41|42) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:3|4|5|6|7|8|9|10|(9:102|103|104|105|106|107|108|109|110)(6:12|13|14|15|16|17)|18|19|20|21|(3:70|71|(18:73|74|75|76|24|25|26|27|(1:29)(1:55)|30|31|32|33|(1:37)|39|40|41|42))|23|24|25|26|27|(0)(0)|30|31|32|33|(2:35|37)|39|40|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x020e, code lost:
        if (com.baidu.tieba.yna.d != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0210, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0213, code lost:
        r3.a.h(r0);
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0223, code lost:
        r3.c.readLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x022c, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d8, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d9, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01dd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01de, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f3, code lost:
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f7, code lost:
        r3 = r24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #23 {all -> 0x01fa, blocks: (B:37:0x0113, B:63:0x0148, B:65:0x014c), top: B:124:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018d A[Catch: all -> 0x01d8, RuntimeException -> 0x01dd, TryCatch #22 {RuntimeException -> 0x01dd, all -> 0x01d8, blocks: (B:67:0x0150, B:69:0x018d, B:71:0x01ba, B:70:0x01a7), top: B:148:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a7 A[Catch: all -> 0x01d8, RuntimeException -> 0x01dd, TryCatch #22 {RuntimeException -> 0x01dd, all -> 0x01d8, blocks: (B:67:0x0150, B:69:0x018d, B:71:0x01ba, B:70:0x01a7), top: B:148:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c5 A[Catch: RuntimeException -> 0x01d6, all -> 0x01ec, TryCatch #0 {RuntimeException -> 0x01d6, blocks: (B:73:0x01bf, B:75:0x01c5, B:77:0x01cb), top: B:122:0x01bf }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.hoa$d] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.baidu.tieba.yna] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public hoa.d R() {
        InterceptResult invokeV;
        SQLiteDatabase readableDatabase;
        String str;
        Cursor cursor;
        String str2;
        hoa.d dVar;
        String str3;
        Cursor cursor2;
        Cursor cursor3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ?? r1 = this;
            String str5 = "'";
            String str6 = " AND b.";
            String str7 = "')";
            hoa.d dVar2 = new hoa.d();
            boolean H = fna.o().H();
            yna readLock = r1.c.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        readableDatabase = getReadableDatabase();
                        try {
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("SELECT COUNT(*) FROM ");
                                str = "SELECT COUNT(*) FROM ";
                                try {
                                    sb.append("event");
                                    sb.append(" a ");
                                    sb.append("LEFT JOIN ");
                                    sb.append("config");
                                    sb.append(" b ");
                                    sb.append("ON a.");
                                    sb.append("eventid");
                                    sb.append(" = b.");
                                    sb.append("eventid");
                                    sb.append(" WHERE ");
                                    sb.append("a.");
                                    sb.append("flowhandle");
                                    sb.append(" = ");
                                    sb.append(-1);
                                    sb.append(" AND ");
                                    sb.append("(a.");
                                    sb.append("reallog");
                                    sb.append(" = '0' OR a.");
                                    sb.append("reallog");
                                    sb.append(" = '')");
                                    if (!H) {
                                        str2 = "1";
                                        str3 = " IS NULL OR b.";
                                        try {
                                            sb.append(str6);
                                            sb.append("switch");
                                            sb.append(" = '");
                                            sb.append(str2);
                                            str6 = str6;
                                            str4 = str5;
                                        } catch (RuntimeException e2) {
                                            e = e2;
                                            str6 = str6;
                                            dVar = dVar2;
                                            cursor2 = null;
                                            r1 = dVar;
                                            if (d) {
                                            }
                                            bpa.a(cursor2);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("flow");
                                            sb2.append(" a ");
                                            sb2.append("LEFT JOIN ");
                                            sb2.append("config");
                                            sb2.append(" b ");
                                            sb2.append("ON a.");
                                            sb2.append("flowid");
                                            sb2.append(" = b.");
                                            sb2.append("eventid");
                                            sb2.append(" WHERE ");
                                            sb2.append(" a.");
                                            sb2.append("endtime");
                                            sb2.append(" IS NOT NULL");
                                            if (H) {
                                            }
                                            cursor3 = null;
                                            cursor3 = readableDatabase.rawQuery(sb2.toString(), null);
                                            if (cursor3 != null) {
                                            }
                                            bpa.a(cursor3);
                                            yna ynaVar = this;
                                            hoa.d dVar3 = r1;
                                            ynaVar.c.readLock().unlock();
                                            return dVar3;
                                        }
                                        try {
                                            sb.append(str4);
                                        } catch (RuntimeException e3) {
                                            e = e3;
                                            str5 = str4;
                                            dVar = dVar2;
                                            cursor2 = null;
                                            r1 = dVar;
                                            if (d) {
                                            }
                                            bpa.a(cursor2);
                                            StringBuilder sb22 = new StringBuilder();
                                            sb22.append(str);
                                            sb22.append("flow");
                                            sb22.append(" a ");
                                            sb22.append("LEFT JOIN ");
                                            sb22.append("config");
                                            sb22.append(" b ");
                                            sb22.append("ON a.");
                                            sb22.append("flowid");
                                            sb22.append(" = b.");
                                            sb22.append("eventid");
                                            sb22.append(" WHERE ");
                                            sb22.append(" a.");
                                            sb22.append("endtime");
                                            sb22.append(" IS NOT NULL");
                                            if (H) {
                                            }
                                            cursor3 = null;
                                            cursor3 = readableDatabase.rawQuery(sb22.toString(), null);
                                            if (cursor3 != null) {
                                            }
                                            bpa.a(cursor3);
                                            yna ynaVar2 = this;
                                            hoa.d dVar32 = r1;
                                            ynaVar2.c.readLock().unlock();
                                            return dVar32;
                                        }
                                    } else {
                                        try {
                                            try {
                                                sb.append(" AND (b.");
                                                sb.append("switch");
                                                sb.append(" IS NULL OR b.");
                                                sb.append("switch");
                                                sb.append(" = '");
                                                str2 = "1";
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                str2 = "1";
                                            }
                                            try {
                                                sb.append(str2);
                                                str3 = " IS NULL OR b.";
                                            } catch (RuntimeException e5) {
                                                e = e5;
                                                str3 = " IS NULL OR b.";
                                                dVar = dVar2;
                                                cursor2 = null;
                                                r1 = dVar;
                                                if (d) {
                                                }
                                                bpa.a(cursor2);
                                                StringBuilder sb222 = new StringBuilder();
                                                sb222.append(str);
                                                sb222.append("flow");
                                                sb222.append(" a ");
                                                sb222.append("LEFT JOIN ");
                                                sb222.append("config");
                                                sb222.append(" b ");
                                                sb222.append("ON a.");
                                                sb222.append("flowid");
                                                sb222.append(" = b.");
                                                sb222.append("eventid");
                                                sb222.append(" WHERE ");
                                                sb222.append(" a.");
                                                sb222.append("endtime");
                                                sb222.append(" IS NOT NULL");
                                                if (H) {
                                                }
                                                cursor3 = null;
                                                try {
                                                    cursor3 = readableDatabase.rawQuery(sb222.toString(), null);
                                                    if (cursor3 != null) {
                                                    }
                                                } catch (RuntimeException e6) {
                                                    e = e6;
                                                    if (d) {
                                                        e.printStackTrace();
                                                    }
                                                    bpa.a(cursor3);
                                                    yna ynaVar22 = this;
                                                    hoa.d dVar322 = r1;
                                                    ynaVar22.c.readLock().unlock();
                                                    return dVar322;
                                                }
                                                bpa.a(cursor3);
                                                yna ynaVar222 = this;
                                                hoa.d dVar3222 = r1;
                                                ynaVar222.c.readLock().unlock();
                                                return dVar3222;
                                            }
                                            try {
                                                sb.append(str7);
                                                str7 = str7;
                                                str4 = str5;
                                            } catch (RuntimeException e7) {
                                                e = e7;
                                                str7 = str7;
                                                dVar = dVar2;
                                                cursor2 = null;
                                                r1 = dVar;
                                                if (d) {
                                                }
                                                bpa.a(cursor2);
                                                StringBuilder sb2222 = new StringBuilder();
                                                sb2222.append(str);
                                                sb2222.append("flow");
                                                sb2222.append(" a ");
                                                sb2222.append("LEFT JOIN ");
                                                sb2222.append("config");
                                                sb2222.append(" b ");
                                                sb2222.append("ON a.");
                                                sb2222.append("flowid");
                                                sb2222.append(" = b.");
                                                sb2222.append("eventid");
                                                sb2222.append(" WHERE ");
                                                sb2222.append(" a.");
                                                sb2222.append("endtime");
                                                sb2222.append(" IS NOT NULL");
                                                if (H) {
                                                }
                                                cursor3 = null;
                                                cursor3 = readableDatabase.rawQuery(sb2222.toString(), null);
                                                if (cursor3 != null) {
                                                }
                                                bpa.a(cursor3);
                                                yna ynaVar2222 = this;
                                                hoa.d dVar32222 = r1;
                                                ynaVar2222.c.readLock().unlock();
                                                return dVar32222;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = null;
                                            bpa.a(cursor);
                                            throw th;
                                        }
                                    }
                                    str5 = str4;
                                } catch (RuntimeException e8) {
                                    e = e8;
                                    str2 = "1";
                                    dVar = dVar2;
                                    str3 = " IS NULL OR b.";
                                    cursor2 = null;
                                    r1 = dVar;
                                    if (d) {
                                    }
                                    bpa.a(cursor2);
                                    StringBuilder sb22222 = new StringBuilder();
                                    sb22222.append(str);
                                    sb22222.append("flow");
                                    sb22222.append(" a ");
                                    sb22222.append("LEFT JOIN ");
                                    sb22222.append("config");
                                    sb22222.append(" b ");
                                    sb22222.append("ON a.");
                                    sb22222.append("flowid");
                                    sb22222.append(" = b.");
                                    sb22222.append("eventid");
                                    sb22222.append(" WHERE ");
                                    sb22222.append(" a.");
                                    sb22222.append("endtime");
                                    sb22222.append(" IS NOT NULL");
                                    if (H) {
                                    }
                                    cursor3 = null;
                                    cursor3 = readableDatabase.rawQuery(sb22222.toString(), null);
                                    if (cursor3 != null) {
                                    }
                                    bpa.a(cursor3);
                                    yna ynaVar22222 = this;
                                    hoa.d dVar322222 = r1;
                                    ynaVar22222.c.readLock().unlock();
                                    return dVar322222;
                                }
                                try {
                                    cursor2 = readableDatabase.rawQuery(sb.toString(), null);
                                } catch (RuntimeException e9) {
                                    e = e9;
                                    dVar = dVar2;
                                    cursor2 = null;
                                    r1 = dVar;
                                    if (d) {
                                    }
                                    bpa.a(cursor2);
                                    StringBuilder sb222222 = new StringBuilder();
                                    sb222222.append(str);
                                    sb222222.append("flow");
                                    sb222222.append(" a ");
                                    sb222222.append("LEFT JOIN ");
                                    sb222222.append("config");
                                    sb222222.append(" b ");
                                    sb222222.append("ON a.");
                                    sb222222.append("flowid");
                                    sb222222.append(" = b.");
                                    sb222222.append("eventid");
                                    sb222222.append(" WHERE ");
                                    sb222222.append(" a.");
                                    sb222222.append("endtime");
                                    sb222222.append(" IS NOT NULL");
                                    if (H) {
                                    }
                                    cursor3 = null;
                                    cursor3 = readableDatabase.rawQuery(sb222222.toString(), null);
                                    if (cursor3 != null) {
                                    }
                                    bpa.a(cursor3);
                                    yna ynaVar222222 = this;
                                    hoa.d dVar3222222 = r1;
                                    ynaVar222222.c.readLock().unlock();
                                    return dVar3222222;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = null;
                            }
                        } catch (RuntimeException e10) {
                            e = e10;
                            str = "SELECT COUNT(*) FROM ";
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SQLException e11) {
                    e = e11;
                }
            } catch (SQLException e12) {
                e = e12;
                readLock = r1;
                r1 = dVar2;
            } catch (Throwable th4) {
                th = th4;
                readLock = r1;
            }
            try {
                if (cursor2 != null) {
                    try {
                    } catch (RuntimeException e13) {
                        e = e13;
                        dVar = dVar2;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = cursor2;
                        bpa.a(cursor);
                        throw th;
                    }
                    if (cursor2.getCount() > 0) {
                        cursor2.moveToFirst();
                        dVar = dVar2;
                        try {
                            try {
                                dVar.a = cursor2.getInt(0);
                                r1 = dVar;
                            } catch (RuntimeException e14) {
                                e = e14;
                                r1 = dVar;
                                if (d) {
                                    e.printStackTrace();
                                    r1 = dVar;
                                }
                                bpa.a(cursor2);
                                StringBuilder sb2222222 = new StringBuilder();
                                sb2222222.append(str);
                                sb2222222.append("flow");
                                sb2222222.append(" a ");
                                sb2222222.append("LEFT JOIN ");
                                sb2222222.append("config");
                                sb2222222.append(" b ");
                                sb2222222.append("ON a.");
                                sb2222222.append("flowid");
                                sb2222222.append(" = b.");
                                sb2222222.append("eventid");
                                sb2222222.append(" WHERE ");
                                sb2222222.append(" a.");
                                sb2222222.append("endtime");
                                sb2222222.append(" IS NOT NULL");
                                if (H) {
                                }
                                cursor3 = null;
                                cursor3 = readableDatabase.rawQuery(sb2222222.toString(), null);
                                if (cursor3 != null) {
                                }
                                bpa.a(cursor3);
                                yna ynaVar2222222 = this;
                                hoa.d dVar32222222 = r1;
                                ynaVar2222222.c.readLock().unlock();
                                return dVar32222222;
                            }
                            bpa.a(cursor2);
                            StringBuilder sb22222222 = new StringBuilder();
                            sb22222222.append(str);
                            sb22222222.append("flow");
                            sb22222222.append(" a ");
                            sb22222222.append("LEFT JOIN ");
                            sb22222222.append("config");
                            sb22222222.append(" b ");
                            sb22222222.append("ON a.");
                            sb22222222.append("flowid");
                            sb22222222.append(" = b.");
                            sb22222222.append("eventid");
                            sb22222222.append(" WHERE ");
                            sb22222222.append(" a.");
                            sb22222222.append("endtime");
                            sb22222222.append(" IS NOT NULL");
                            if (H) {
                                sb22222222.append(" AND (b.");
                                sb22222222.append("switch");
                                sb22222222.append(str3);
                                sb22222222.append("switch");
                                sb22222222.append(" = '");
                                sb22222222.append(str2);
                                sb22222222.append(str7);
                            } else {
                                sb22222222.append(str6);
                                sb22222222.append("switch");
                                sb22222222.append(" = '");
                                sb22222222.append(str2);
                                sb22222222.append(str5);
                            }
                            cursor3 = null;
                            cursor3 = readableDatabase.rawQuery(sb22222222.toString(), null);
                            if (cursor3 != null && cursor3.getCount() > 0) {
                                cursor3.moveToFirst();
                                r1.b = cursor3.getInt(0);
                            }
                            bpa.a(cursor3);
                            yna ynaVar22222222 = this;
                            hoa.d dVar322222222 = r1;
                            ynaVar22222222.c.readLock().unlock();
                            return dVar322222222;
                        } catch (Throwable th6) {
                            th = th6;
                            cursor = cursor2;
                            bpa.a(cursor);
                            throw th;
                        }
                    }
                }
                cursor3 = readableDatabase.rawQuery(sb22222222.toString(), null);
                if (cursor3 != null) {
                    cursor3.moveToFirst();
                    r1.b = cursor3.getInt(0);
                }
                bpa.a(cursor3);
                yna ynaVar222222222 = this;
                hoa.d dVar3222222222 = r1;
                ynaVar222222222.c.readLock().unlock();
                return dVar3222222222;
            } catch (Throwable th7) {
                th = th7;
                bpa.a(cursor3);
                throw th;
            }
            r1 = dVar2;
            bpa.a(cursor2);
            StringBuilder sb222222222 = new StringBuilder();
            sb222222222.append(str);
            sb222222222.append("flow");
            sb222222222.append(" a ");
            sb222222222.append("LEFT JOIN ");
            sb222222222.append("config");
            sb222222222.append(" b ");
            sb222222222.append("ON a.");
            sb222222222.append("flowid");
            sb222222222.append(" = b.");
            sb222222222.append("eventid");
            sb222222222.append(" WHERE ");
            sb222222222.append(" a.");
            sb222222222.append("endtime");
            sb222222222.append(" IS NOT NULL");
            if (H) {
            }
            cursor3 = null;
        } else {
            return (hoa.d) invokeV.objValue;
        }
    }

    public void b(koa koaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, koaVar) == null) {
            boolean H = fna.o().H();
            this.c.readLock().lock();
            try {
                try {
                    L(D(true, true, H), koaVar);
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
                if (!koaVar.w() && !koaVar.z()) {
                    L(D(true, false, H), koaVar);
                    if (!koaVar.w() && !koaVar.z()) {
                        O(D(false, true, H), koaVar);
                        if (!koaVar.w() && !koaVar.z()) {
                            O(D(false, false, H), koaVar);
                        }
                    }
                }
            } finally {
                this.c.readLock().unlock();
            }
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        if (d) {
                            Log.d("UBCDatabaseHelper", "updateSendedFileFail#performTransaction: update file table:" + update);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        if (d) {
                            Log.d("UBCDatabaseHelper", "deleteSendedFile#performTransaction: delete file table:" + delete);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    public final boolean d(mna mnaVar, int i, koa koaVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048608, this, mnaVar, i, koaVar)) == null) {
            boolean c = koaVar.c(mnaVar, i);
            if (c) {
                if (!TextUtils.isEmpty(mnaVar.h())) {
                    koaVar.K("1");
                }
                long p = mnaVar.p();
                if (p > 0) {
                    if (koaVar.t() == 0 || p < koaVar.t()) {
                        koaVar.J(p, 0L);
                    }
                    if (p > koaVar.s()) {
                        koaVar.J(0L, p);
                    }
                }
            }
            return c;
        }
        return invokeLIL.booleanValue;
    }

    public void d0(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048609, this, str, i, str2) == null) {
            if (i >= 0 && !TextUtils.isEmpty(str)) {
                this.c.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", str2);
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                            if (d && update != 1) {
                                Log.d("UBCDatabaseHelper", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                        this.a.h(e2);
                    }
                } finally {
                    this.c.writeLock().unlock();
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "updateFlowValue#flowHandle invalid");
            }
        }
    }

    public void f0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", str2);
                        writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    public void h(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048615, this, str, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.writeLock().lock();
        String str3 = "callcnt";
        if (z) {
            str2 = "callcnt";
        } else {
            str2 = "count";
        }
        if (z) {
            str3 = "count";
        }
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE arrival SET " + str2 + " = " + str2 + " + 1, state = 0 WHERE ubcid = ? AND date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + " = date(\"now\")");
                        compileStatement.clearBindings();
                        compileStatement.bindString(1, str);
                        if (compileStatement.executeUpdateDelete() <= 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("ubcid", str);
                            contentValues.put(str2, (Integer) 1);
                            contentValues.put(str3, (Integer) 0);
                            contentValues.put("state", (Integer) 0);
                            writableDatabase.insert("arrival", null, contentValues);
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                        this.a.h(e2);
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                if (d) {
                    e3.printStackTrace();
                }
                this.a.h(e3);
            }
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public void k(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, str, i) == null) {
            if (i >= 0 && !TextUtils.isEmpty(str)) {
                this.c.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            int delete = writableDatabase.delete("flow", "flowid=\"" + str + "\" AND flowhandle = " + i, null);
                            if (d) {
                                Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow flow count:" + delete);
                            }
                            int delete2 = writableDatabase.delete("event", "flowhandle = " + i, null);
                            if (d) {
                                Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow event count:" + delete2);
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                        this.a.h(e2);
                    }
                } finally {
                    this.c.writeLock().unlock();
                }
            } else if (d) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
            }
        }
    }

    public void p(SQLiteDatabase sQLiteDatabase, koa koaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048626, this, sQLiteDatabase, koaVar) == null) && koaVar != null && !koaVar.y() && koaVar.l().size() >= 1) {
            this.c.writeLock().lock();
            try {
                try {
                    Set<String> l = koaVar.l();
                    String[] strArr = (String[]) l.toArray(new String[l.size()]);
                    String[] strArr2 = new String[l.size()];
                    Arrays.fill(strArr2, "?");
                    String join = TextUtils.join(",", strArr2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("date(");
                    sb.append("ubctime");
                    sb.append(") in (");
                    sb.append(join);
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                    String sb2 = sb.toString();
                    sb.append(" AND ");
                    sb.append("date(");
                    sb.append("ubctime");
                    sb.append(") < date('now')");
                    int delete = sQLiteDatabase.delete("arrival", sb.toString(), strArr);
                    if (d) {
                        Log.d("UBCDatabaseHelper", "clearUploadedUBCRecords delete " + delete + " records");
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", (Integer) 1);
                    int update = sQLiteDatabase.update("arrival", contentValues, sb2, strArr);
                    if (d) {
                        Log.d("UBCDatabaseHelper", "clearUploadedUBCRecords update " + update + " records");
                    }
                } catch (SQLException e2) {
                    if (d) {
                        e2.printStackTrace();
                    }
                    this.a.h(e2);
                }
            } finally {
                this.c.writeLock().unlock();
            }
        }
    }

    public final boolean l(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048619, this, str, str2, i, sQLiteDatabase)) == null) {
            this.c.writeLock().lock();
            try {
                boolean equals = str.equals(str2);
                boolean z = false;
                if (!equals) {
                    Cursor cursor = null;
                    try {
                        cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i, null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(0);
                            if (!TextUtils.isEmpty(string)) {
                                if ("1".equals(string)) {
                                    z = true;
                                }
                            }
                        }
                    } catch (SQLException e2) {
                        if (d) {
                            e2.printStackTrace();
                        }
                        this.a.h(e2);
                    } catch (RuntimeException e3) {
                        if (d) {
                            e3.printStackTrace();
                        }
                    }
                    bpa.a(cursor);
                } else {
                    z = true;
                }
                return z;
            } finally {
                this.c.writeLock().unlock();
            }
        }
        return invokeLLIL.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.c.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    Cursor cursor = null;
                    try {
                        try {
                            int delete = writableDatabase.delete("arrival", "date(ubctime) <= date('now', '-7 day') ", null);
                            if (d) {
                                Log.d("UBCDatabaseHelper", "clearInvalidUBCRecords delete " + delete + " records");
                            }
                            int delete2 = writableDatabase.delete("arrival", "state = 1 AND date(ubctime) < date('now')", null);
                            if (d) {
                                Log.d("UBCDatabaseHelper", "clearInvalidUBCRecords delete " + delete2 + " records");
                            }
                            Cursor rawQuery = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM arrival", null);
                            int i = 0;
                            if (rawQuery != null) {
                                try {
                                    if (rawQuery.getCount() > 0) {
                                        rawQuery.moveToFirst();
                                        if (rawQuery.getInt(0) > 15000) {
                                            i = (rawQuery.getInt(1) + rawQuery.getInt(2)) / 3;
                                        }
                                    }
                                } catch (SQLException e2) {
                                    cursor = rawQuery;
                                    e = e2;
                                    if (d) {
                                        e.printStackTrace();
                                    }
                                    this.a.h(e);
                                    bpa.a(cursor);
                                    writableDatabase.endTransaction();
                                } catch (Throwable th) {
                                    cursor = rawQuery;
                                    th = th;
                                    bpa.a(cursor);
                                    writableDatabase.endTransaction();
                                    throw th;
                                }
                            }
                            int delete3 = writableDatabase.delete("arrival", "_id < " + i, null);
                            if (d) {
                                Log.d("UBCDatabaseHelper", "clearInvalidUBCRecords delete count:" + delete3);
                            }
                            writableDatabase.setTransactionSuccessful();
                            bpa.a(rawQuery);
                        } catch (SQLException e3) {
                            e = e3;
                        }
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } finally {
                    this.c.writeLock().unlock();
                }
            } catch (SQLException e4) {
                if (d) {
                    e4.printStackTrace();
                }
                this.a.h(e4);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048625, this, sQLiteDatabase, i, i2) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i < i2) {
                    switch (i) {
                        case 1:
                            r(sQLiteDatabase);
                            break;
                        case 2:
                            j(sQLiteDatabase);
                            break;
                        case 3:
                            e(sQLiteDatabase);
                            break;
                        case 4:
                            f(sQLiteDatabase);
                            break;
                        case 6:
                            i(sQLiteDatabase);
                            break;
                        case 7:
                            q(sQLiteDatabase);
                            break;
                        case 8:
                            c(sQLiteDatabase);
                            break;
                    }
                    i++;
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
