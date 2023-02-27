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
/* loaded from: classes5.dex */
public class pr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final pr4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-508915014, "Lcom/baidu/tieba/pr4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-508915014, "Lcom/baidu/tieba/pr4$a;");
                    return;
                }
            }
            a = new pr4();
        }
    }

    public pr4() {
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

    public static final pr4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (pr4) invokeV.objValue;
    }

    public synchronized long a(rr4 rr4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rr4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, rr4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rr4Var)) == null) {
            synchronized (this) {
                if (rr4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, rr4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<rr4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (rr4 rr4Var : list) {
                    h(f, rr4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rr4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (rr4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(rr4Var.d()), String.valueOf(rr4Var.q())});
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

    public synchronized void k(List<rr4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (rr4 rr4Var : list) {
                    j(f, rr4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(rr4 rr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rr4Var)) == null) {
            if (rr4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(rr4Var.d()));
            contentValues.put("missionid", Integer.valueOf(rr4Var.q()));
            contentValues.put("activitysource", rr4Var.e());
            contentValues.put("calltype", Integer.valueOf(rr4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(rr4Var.x()));
            contentValues.put("browsetimepage", rr4Var.g());
            contentValues.put("browsetime", Long.valueOf(rr4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(rr4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(rr4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(rr4Var.k()));
            contentValues.put("cleartime", Long.valueOf(rr4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(rr4Var.t()));
            contentValues.put("tid", Long.valueOf(rr4Var.C()));
            contentValues.put("fid", Long.valueOf(rr4Var.o()));
            contentValues.put("threadtext", rr4Var.B());
            contentValues.put("threadimg", rr4Var.z());
            contentValues.put("threadforum", Long.valueOf(rr4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(rr4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(rr4Var.w()));
            contentValues.put("token", rr4Var.E());
            contentValues.put("executingMissionList", rr4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final rr4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                rr4 rr4Var = new rr4();
                rr4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                rr4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                rr4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                rr4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                rr4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                rr4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                rr4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                rr4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                rr4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                rr4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                rr4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                rr4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                rr4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                rr4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                rr4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                rr4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                rr4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                rr4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                rr4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                rr4Var.Q(rr4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                rr4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return rr4Var;
            }
            return null;
        }
        return (rr4) invokeL.objValue;
    }

    public synchronized List<rr4> f() {
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
                    rr4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                fj.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, rr4 rr4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, rr4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(rr4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, rr4 rr4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, rr4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(rr4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(rr4Var.d()), String.valueOf(rr4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
