package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class xp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final xp4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-281728848, "Lcom/baidu/tieba/xp4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-281728848, "Lcom/baidu/tieba/xp4$a;");
                    return;
                }
            }
            a = new xp4();
        }
    }

    public xp4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final xp4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (xp4) invokeV.objValue;
    }

    public synchronized long a(zp4 zp4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zp4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, zp4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(zp4 zp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zp4Var)) == null) {
            synchronized (this) {
                if (zp4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, zp4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<zp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (zp4 zp4Var : list) {
                    h(f, zp4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(zp4 zp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zp4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (zp4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(zp4Var.d()), String.valueOf(zp4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                if (delete >= 0) {
                    z = true;
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void k(List<zp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (zp4 zp4Var : list) {
                    j(f, zp4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(zp4 zp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zp4Var)) == null) {
            if (zp4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(zp4Var.d()));
            contentValues.put("missionid", Integer.valueOf(zp4Var.q()));
            contentValues.put("activitysource", zp4Var.e());
            contentValues.put("calltype", Integer.valueOf(zp4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(zp4Var.x()));
            contentValues.put("browsetimepage", zp4Var.g());
            contentValues.put("browsetime", Long.valueOf(zp4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(zp4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(zp4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(zp4Var.k()));
            contentValues.put("cleartime", Long.valueOf(zp4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(zp4Var.t()));
            contentValues.put("tid", Long.valueOf(zp4Var.C()));
            contentValues.put("fid", Long.valueOf(zp4Var.o()));
            contentValues.put("threadtext", zp4Var.B());
            contentValues.put("threadimg", zp4Var.z());
            contentValues.put("threadforum", Long.valueOf(zp4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(zp4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(zp4Var.w()));
            contentValues.put("token", zp4Var.E());
            contentValues.put("executingMissionList", zp4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final zp4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                zp4 zp4Var = new zp4();
                zp4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                zp4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                zp4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                zp4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                zp4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                zp4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                zp4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                zp4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                zp4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                zp4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                zp4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                zp4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                zp4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                zp4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                zp4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                zp4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                zp4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                zp4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                zp4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                zp4Var.Q(zp4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                zp4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return zp4Var;
            }
            return null;
        }
        return (zp4) invokeL.objValue;
    }

    public synchronized List<zp4> f() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f.rawQuery("SELECT * FROM activity_mission_info", null);
                while (rawQuery.moveToNext()) {
                    zp4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ji.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, zp4 zp4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, zp4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(zp4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, zp4 zp4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, zp4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(zp4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(zp4Var.d()), String.valueOf(zp4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
