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
public class zq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final zq4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223547025, "Lcom/baidu/tieba/zq4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-223547025, "Lcom/baidu/tieba/zq4$a;");
                    return;
                }
            }
            a = new zq4();
        }
    }

    public zq4() {
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

    public static final zq4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (zq4) invokeV.objValue;
    }

    public synchronized long a(br4 br4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, br4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, br4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(br4 br4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, br4Var)) == null) {
            synchronized (this) {
                if (br4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, br4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<br4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (br4 br4Var : list) {
                    h(f, br4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(br4 br4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, br4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (br4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(br4Var.d()), String.valueOf(br4Var.q())});
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

    public synchronized void k(List<br4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (br4 br4Var : list) {
                    j(f, br4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(br4 br4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, br4Var)) == null) {
            if (br4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(br4Var.d()));
            contentValues.put("missionid", Integer.valueOf(br4Var.q()));
            contentValues.put("activitysource", br4Var.e());
            contentValues.put("calltype", Integer.valueOf(br4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(br4Var.x()));
            contentValues.put("browsetimepage", br4Var.g());
            contentValues.put("browsetime", Long.valueOf(br4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(br4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(br4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(br4Var.k()));
            contentValues.put("cleartime", Long.valueOf(br4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(br4Var.t()));
            contentValues.put("tid", Long.valueOf(br4Var.C()));
            contentValues.put("fid", Long.valueOf(br4Var.o()));
            contentValues.put("threadtext", br4Var.B());
            contentValues.put("threadimg", br4Var.z());
            contentValues.put("threadforum", Long.valueOf(br4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(br4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(br4Var.w()));
            contentValues.put("token", br4Var.E());
            contentValues.put("executingMissionList", br4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final br4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                br4 br4Var = new br4();
                br4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                br4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                br4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                br4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                br4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                br4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                br4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                br4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                br4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                br4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                br4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                br4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                br4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                br4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                br4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                br4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                br4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                br4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                br4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                br4Var.Q(br4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                br4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return br4Var;
            }
            return null;
        }
        return (br4) invokeL.objValue;
    }

    public synchronized List<br4> f() {
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
                    br4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, br4 br4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, br4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(br4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, br4 br4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, br4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(br4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(br4Var.d()), String.valueOf(br4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
