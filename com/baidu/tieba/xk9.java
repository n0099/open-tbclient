package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class xk9 extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static xk9 c;
    public static ReentrantLock d;
    public transient /* synthetic */ FieldHolder $fh;
    public ReentrantReadWriteLock a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948303395, "Lcom/baidu/tieba/xk9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948303395, "Lcom/baidu/tieba/xk9;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = null;
        d = new ReentrantLock();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk9(Context context) {
        super(context, "voyager.db", (SQLiteDatabase.CursorFactory) null, 1);
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
        this.a = new ReentrantReadWriteLock(true);
    }

    public static xk9 f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (c == null) {
                d.lock();
                if (c == null) {
                    c = new xk9(context);
                }
                d.unlock();
            }
            return c;
        }
        return (xk9) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.a.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long delete = writableDatabase.delete("task", null, null);
                        if (b) {
                            Log.d("VoyagerDBHelper", "clear task data from table task, count = " + delete);
                        }
                        writableDatabase.setTransactionSuccessful();
                        return true;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e) {
                    if (b) {
                        e.printStackTrace();
                    }
                    this.a.writeLock().unlock();
                    return false;
                }
            } finally {
                this.a.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[Catch: all -> 0x009b, SQLException -> 0x009d, Merged into TryCatch #2 {all -> 0x009b, SQLException -> 0x009d, blocks: (B:5:0x0010, B:16:0x007e, B:17:0x0081, B:25:0x0094, B:26:0x0097, B:27:0x009a, B:31:0x009e, B:33:0x00a2), top: B:45:0x0010 }, TRY_ENTER] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c() {
        InterceptResult invokeV;
        Cursor cursor;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.a.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    cursor = writableDatabase.rawQuery("SELECT * FROM task ORDER BY timestamp LIMIT 1", null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                string = cursor.getString(cursor.getColumnIndex("task_id"));
                                long delete = writableDatabase.delete("task", "task_id =? ", new String[]{string});
                                if (b) {
                                    Log.d("VoyagerDBHelper", "delete task data count: " + delete);
                                }
                                writableDatabase.setTransactionSuccessful();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                writableDatabase.endTransaction();
                                return string;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    string = null;
                    writableDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                    }
                    writableDatabase.endTransaction();
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
            } catch (SQLException e) {
                if (b) {
                    e.printStackTrace();
                }
                return null;
            } finally {
                this.a.writeLock().unlock();
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public final ContentValues d(vk9 vk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vk9Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("task_id", vk9Var.j());
            contentValues.put("timestamp", Long.valueOf(vk9Var.i()));
            contentValues.put("biz_type", vk9Var.a());
            contentValues.put("file_list", vk9Var.g().toString());
            if (!vk9Var.l()) {
                contentValues.put("zip_src", (Integer) 0);
            } else {
                contentValues.put("zip_src", (Integer) 1);
            }
            contentValues.put("priority", Integer.valueOf(vk9Var.h()));
            contentValues.put("upload_count", Integer.valueOf(vk9Var.k()));
            contentValues.put("network_type", Integer.valueOf(vk9Var.f()));
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject b2 = vk9Var.b();
                if (b2 != null) {
                    jSONObject.put("ext_info", b2);
                }
                JSONObject c2 = vk9Var.c();
                if (c2 != null) {
                    jSONObject.put("file_meta", c2);
                }
                jSONObject.put("max_zip_size", vk9Var.e());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            if (jSONObject.length() > 0) {
                contentValues.put("extend", jSONObject.toString());
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean h(vk9 vk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vk9Var)) == null) {
            if (vk9Var != null && !TextUtils.isEmpty(vk9Var.j()) && !TextUtils.isEmpty(vk9Var.a())) {
                this.a.writeLock().lock();
                try {
                    ContentValues d2 = d(vk9Var);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long insert = writableDatabase.insert("task", null, d2);
                        if (b) {
                            Log.d("VoyagerDBHelper", "insert task data into table task, rowId = " + insert);
                        }
                        writableDatabase.setTransactionSuccessful();
                        return true;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e) {
                    if (b) {
                        e.printStackTrace();
                    }
                    return false;
                } finally {
                    this.a.writeLock().unlock();
                }
            }
            if (b) {
                Log.d("VoyagerDBHelper", "insert task data : task id should not null");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String e(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(next);
                i++;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sQLiteDatabase) == null) {
            if (b) {
                Log.i("VoyagerDBHelper", "Creating database voyager.db version: 1");
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE task (_id INTEGER PRIMARY KEY AUTOINCREMENT,task_id TEXT,timestamp LONG,biz_type TEXT,file_list TEXT,zip_src INTEGER,priority INTEGER,upload_count INTEGER,network_type INTEGER,extend TEXT,reserve1 TEXT);");
            } catch (Exception e) {
                if (b) {
                    Log.w("VoyagerDBHelper", "Error while creating db: " + e.toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0142 A[LOOP:0: B:12:0x003a->B:47:0x0142, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014e A[Catch: all -> 0x0187, SQLException -> 0x0189, TRY_ENTER, TryCatch #2 {SQLException -> 0x0189, blocks: (B:5:0x0011, B:52:0x014e, B:53:0x0151, B:57:0x0161, B:60:0x0183, B:61:0x0186), top: B:79:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0157 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: all -> 0x0187, SQLException -> 0x0189, TRY_ENTER, TryCatch #2 {SQLException -> 0x0189, blocks: (B:5:0x0011, B:52:0x014e, B:53:0x0151, B:57:0x0161, B:60:0x0183, B:61:0x0186), top: B:79:0x0011, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014c A[EDGE_INSN: B:83:0x014c->B:51:0x014c ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(@NonNull ArrayList<String> arrayList, @NonNull LinkedList<vk9> linkedList) {
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        Cursor rawQuery;
        long j;
        ArrayList<String> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, arrayList, linkedList) == null) {
            this.a.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    cursor = null;
                    try {
                        rawQuery = writableDatabase.rawQuery("SELECT * FROM task", null);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (SQLException e) {
                    if (b) {
                        e.printStackTrace();
                    }
                }
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToFirst();
                            long currentTimeMillis = System.currentTimeMillis();
                            while (true) {
                                String string = rawQuery.getString(rawQuery.getColumnIndex("task_id"));
                                String string2 = rawQuery.getString(rawQuery.getColumnIndex("biz_type"));
                                long j2 = rawQuery.getLong(rawQuery.getColumnIndex("timestamp"));
                                long b2 = lk9.f().b(string2);
                                int i = rawQuery.getInt(rawQuery.getColumnIndex("upload_count"));
                                int e2 = lk9.f().e(string2);
                                if (b2 + j2 >= currentTimeMillis) {
                                    if (i >= e2) {
                                        arrayList2 = arrayList;
                                        j = currentTimeMillis;
                                    } else {
                                        int i2 = rawQuery.getInt(rawQuery.getColumnIndex("priority"));
                                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("file_list"));
                                        int i3 = rawQuery.getInt(rawQuery.getColumnIndex("network_type"));
                                        boolean z = true;
                                        j = currentTimeMillis;
                                        ArrayList arrayList3 = new ArrayList(Arrays.asList(string3));
                                        if (rawQuery.getInt(rawQuery.getColumnIndex("zip_src")) == 0) {
                                            z = false;
                                        }
                                        vk9.b bVar = new vk9.b(string, string2, arrayList3, j2);
                                        bVar.o(i2);
                                        bVar.n(i3);
                                        bVar.p(z);
                                        vk9 k = bVar.k();
                                        k.s(i);
                                        String string4 = rawQuery.getString(rawQuery.getColumnIndex("extend"));
                                        if (!TextUtils.isEmpty(string4)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(string4);
                                                if (jSONObject.length() > 0) {
                                                    JSONObject optJSONObject = jSONObject.optJSONObject("ext_info");
                                                    if (optJSONObject != null && optJSONObject.length() > 0) {
                                                        k.m(optJSONObject);
                                                    }
                                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("file_meta");
                                                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                                                        k.n(optJSONObject2);
                                                    }
                                                    long optLong = jSONObject.optLong("max_zip_size", 0L);
                                                    if (optLong > 0) {
                                                        k.o(optLong);
                                                    }
                                                }
                                            } catch (JSONException e3) {
                                                if (b) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                        }
                                        linkedList.addFirst(k);
                                        if (rawQuery.moveToNext()) {
                                            break;
                                        }
                                        currentTimeMillis = j;
                                    }
                                } else {
                                    j = currentTimeMillis;
                                    arrayList2 = arrayList;
                                }
                                arrayList2.add(string);
                                if (rawQuery.moveToNext()) {
                                }
                            }
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            if (arrayList.size() != 0) {
                                return;
                            }
                            writableDatabase.delete("task", "task_id IN ( " + e(arrayList) + " )", null);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                }
                if (arrayList.size() != 0) {
                }
            } finally {
                this.a.writeLock().unlock();
            }
        }
    }

    public void i(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vk9Var) == null) {
            if (vk9Var != null && !TextUtils.isEmpty(vk9Var.j()) && !TextUtils.isEmpty(vk9Var.a())) {
                this.a.writeLock().lock();
                try {
                    try {
                        int delete = getWritableDatabase().delete("task", "task_id =? ", new String[]{vk9Var.j()});
                        if (b) {
                            Log.d("VoyagerDBHelper", "delete data from table task, del count = " + delete);
                        }
                    } catch (SQLException e) {
                        if (b) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    this.a.writeLock().unlock();
                }
            } else if (b) {
                Log.d("VoyagerDBHelper", "task data and task id should not null");
            }
        }
    }

    public void j(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vk9Var) == null) {
            if (vk9Var != null && !TextUtils.isEmpty(vk9Var.j()) && !TextUtils.isEmpty(vk9Var.a())) {
                this.a.writeLock().lock();
                try {
                    try {
                        long update = getWritableDatabase().update("task", d(vk9Var), null, null);
                        if (b) {
                            Log.d("VoyagerDBHelper", "update data into table task, update count = " + update);
                        }
                    } catch (SQLException e) {
                        if (b) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    this.a.writeLock().unlock();
                }
            } else if (b) {
                Log.d("VoyagerDBHelper", "task data and task id should not null");
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048586, this, sQLiteDatabase, i, i2) == null) && b) {
            Log.d("VoyagerDBHelper", "old version: " + i + ", new version: " + i2);
        }
    }
}
