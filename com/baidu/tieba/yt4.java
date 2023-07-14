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
/* loaded from: classes8.dex */
public class yt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final yt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249405613, "Lcom/baidu/tieba/yt4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-249405613, "Lcom/baidu/tieba/yt4$a;");
                    return;
                }
            }
            a = new yt4();
        }
    }

    public yt4() {
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

    public static final yt4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (yt4) invokeV.objValue;
    }

    public synchronized long a(au4 au4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, au4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, au4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(au4 au4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, au4Var)) == null) {
            synchronized (this) {
                if (au4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, au4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<au4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (au4 au4Var : list) {
                    h(f, au4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(au4 au4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, au4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (au4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(au4Var.d()), String.valueOf(au4Var.q())});
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

    public synchronized void k(List<au4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (au4 au4Var : list) {
                    j(f, au4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(au4 au4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, au4Var)) == null) {
            if (au4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(au4Var.d()));
            contentValues.put("missionid", Integer.valueOf(au4Var.q()));
            contentValues.put("activitysource", au4Var.e());
            contentValues.put("calltype", Integer.valueOf(au4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(au4Var.x()));
            contentValues.put("browsetimepage", au4Var.g());
            contentValues.put("browsetime", Long.valueOf(au4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(au4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(au4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(au4Var.k()));
            contentValues.put("cleartime", Long.valueOf(au4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(au4Var.t()));
            contentValues.put("tid", Long.valueOf(au4Var.C()));
            contentValues.put("fid", Long.valueOf(au4Var.o()));
            contentValues.put("threadtext", au4Var.B());
            contentValues.put("threadimg", au4Var.z());
            contentValues.put("threadforum", Long.valueOf(au4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(au4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(au4Var.w()));
            contentValues.put("token", au4Var.E());
            contentValues.put("executingMissionList", au4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final au4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                au4 au4Var = new au4();
                au4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                au4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                au4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                au4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                au4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                au4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                au4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                au4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                au4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                au4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                au4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                au4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                au4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                au4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                au4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                au4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                au4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                au4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                au4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                au4Var.Q(au4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                au4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return au4Var;
            }
            return null;
        }
        return (au4) invokeL.objValue;
    }

    public synchronized List<au4> f() {
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
                    au4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, au4 au4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, au4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(au4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, au4 au4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, au4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(au4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(au4Var.d()), String.valueOf(au4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
