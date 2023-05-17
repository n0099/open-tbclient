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
/* loaded from: classes6.dex */
public class jr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final jr4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-680689920, "Lcom/baidu/tieba/jr4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-680689920, "Lcom/baidu/tieba/jr4$a;");
                    return;
                }
            }
            a = new jr4();
        }
    }

    public jr4() {
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

    public static final jr4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (jr4) invokeV.objValue;
    }

    public synchronized long a(lr4 lr4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lr4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, lr4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(lr4 lr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lr4Var)) == null) {
            synchronized (this) {
                if (lr4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, lr4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<lr4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (lr4 lr4Var : list) {
                    h(f, lr4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(lr4 lr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lr4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (lr4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(lr4Var.d()), String.valueOf(lr4Var.q())});
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

    public synchronized void k(List<lr4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (lr4 lr4Var : list) {
                    j(f, lr4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(lr4 lr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lr4Var)) == null) {
            if (lr4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(lr4Var.d()));
            contentValues.put("missionid", Integer.valueOf(lr4Var.q()));
            contentValues.put("activitysource", lr4Var.e());
            contentValues.put("calltype", Integer.valueOf(lr4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(lr4Var.x()));
            contentValues.put("browsetimepage", lr4Var.g());
            contentValues.put("browsetime", Long.valueOf(lr4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(lr4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(lr4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(lr4Var.k()));
            contentValues.put("cleartime", Long.valueOf(lr4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(lr4Var.t()));
            contentValues.put("tid", Long.valueOf(lr4Var.C()));
            contentValues.put("fid", Long.valueOf(lr4Var.o()));
            contentValues.put("threadtext", lr4Var.B());
            contentValues.put("threadimg", lr4Var.z());
            contentValues.put("threadforum", Long.valueOf(lr4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(lr4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(lr4Var.w()));
            contentValues.put("token", lr4Var.E());
            contentValues.put("executingMissionList", lr4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final lr4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                lr4 lr4Var = new lr4();
                lr4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                lr4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                lr4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                lr4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                lr4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                lr4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                lr4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                lr4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                lr4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                lr4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                lr4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                lr4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                lr4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                lr4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                lr4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                lr4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                lr4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                lr4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                lr4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                lr4Var.Q(lr4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                lr4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return lr4Var;
            }
            return null;
        }
        return (lr4) invokeL.objValue;
    }

    public synchronized List<lr4> f() {
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
                    lr4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                si.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, lr4 lr4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, lr4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(lr4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, lr4 lr4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, lr4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(lr4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(lr4Var.d()), String.valueOf(lr4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
