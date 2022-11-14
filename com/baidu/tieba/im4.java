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
/* loaded from: classes4.dex */
public class im4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final im4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-713936676, "Lcom/baidu/tieba/im4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-713936676, "Lcom/baidu/tieba/im4$a;");
                    return;
                }
            }
            a = new im4();
        }
    }

    public im4() {
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

    public static final im4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (im4) invokeV.objValue;
    }

    public synchronized long a(km4 km4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, km4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, km4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(km4 km4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, km4Var)) == null) {
            synchronized (this) {
                if (km4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, km4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<km4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (km4 km4Var : list) {
                    h(f, km4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(km4 km4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, km4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (km4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(km4Var.d()), String.valueOf(km4Var.q())});
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

    public synchronized void k(List<km4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (km4 km4Var : list) {
                    j(f, km4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(km4 km4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, km4Var)) == null) {
            if (km4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(km4Var.d()));
            contentValues.put("missionid", Integer.valueOf(km4Var.q()));
            contentValues.put("activitysource", km4Var.e());
            contentValues.put("calltype", Integer.valueOf(km4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(km4Var.x()));
            contentValues.put("browsetimepage", km4Var.g());
            contentValues.put("browsetime", Long.valueOf(km4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(km4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(km4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(km4Var.k()));
            contentValues.put("cleartime", Long.valueOf(km4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(km4Var.t()));
            contentValues.put("tid", Long.valueOf(km4Var.C()));
            contentValues.put("fid", Long.valueOf(km4Var.o()));
            contentValues.put("threadtext", km4Var.B());
            contentValues.put("threadimg", km4Var.z());
            contentValues.put("threadforum", Long.valueOf(km4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(km4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(km4Var.w()));
            contentValues.put("token", km4Var.E());
            contentValues.put("executingMissionList", km4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final km4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                km4 km4Var = new km4();
                km4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                km4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                km4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                km4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                km4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                km4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                km4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                km4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                km4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                km4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                km4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                km4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                km4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                km4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                km4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                km4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                km4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                km4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                km4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                km4Var.Q(km4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                km4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return km4Var;
            }
            return null;
        }
        return (km4) invokeL.objValue;
    }

    public synchronized List<km4> f() {
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
                    km4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                zi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, km4 km4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, km4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(km4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, km4 km4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, km4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(km4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(km4Var.d()), String.valueOf(km4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
