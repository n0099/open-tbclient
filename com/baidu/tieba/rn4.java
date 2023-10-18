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
public class rn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final rn4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-455350796, "Lcom/baidu/tieba/rn4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-455350796, "Lcom/baidu/tieba/rn4$a;");
                    return;
                }
            }
            a = new rn4();
        }
    }

    public rn4() {
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

    public static final rn4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (rn4) invokeV.objValue;
    }

    public synchronized long a(tn4 tn4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tn4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, tn4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(tn4 tn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tn4Var)) == null) {
            synchronized (this) {
                if (tn4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, tn4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<tn4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (tn4 tn4Var : list) {
                    h(f, tn4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(tn4 tn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tn4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (tn4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(tn4Var.d()), String.valueOf(tn4Var.q())});
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

    public synchronized void k(List<tn4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (tn4 tn4Var : list) {
                    j(f, tn4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(tn4 tn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tn4Var)) == null) {
            if (tn4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(tn4Var.d()));
            contentValues.put("missionid", Integer.valueOf(tn4Var.q()));
            contentValues.put("activitysource", tn4Var.e());
            contentValues.put("calltype", Integer.valueOf(tn4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(tn4Var.x()));
            contentValues.put("browsetimepage", tn4Var.g());
            contentValues.put("browsetime", Long.valueOf(tn4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(tn4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(tn4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(tn4Var.k()));
            contentValues.put("cleartime", Long.valueOf(tn4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(tn4Var.t()));
            contentValues.put("tid", Long.valueOf(tn4Var.C()));
            contentValues.put("fid", Long.valueOf(tn4Var.o()));
            contentValues.put("threadtext", tn4Var.B());
            contentValues.put("threadimg", tn4Var.z());
            contentValues.put("threadforum", Long.valueOf(tn4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(tn4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(tn4Var.w()));
            contentValues.put("token", tn4Var.E());
            contentValues.put("executingMissionList", tn4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final tn4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                tn4 tn4Var = new tn4();
                tn4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                tn4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                tn4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                tn4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                tn4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                tn4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                tn4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                tn4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                tn4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                tn4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                tn4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                tn4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                tn4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                tn4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                tn4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                tn4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                tn4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                tn4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                tn4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                tn4Var.Q(tn4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                tn4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return tn4Var;
            }
            return null;
        }
        return (tn4) invokeL.objValue;
    }

    public synchronized List<tn4> f() {
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
                    tn4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                bd.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, tn4 tn4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, tn4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(tn4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, tn4 tn4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, tn4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(tn4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(tn4Var.d()), String.valueOf(tn4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
