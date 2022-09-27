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
public class ol4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final ol4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-543085291, "Lcom/baidu/tieba/ol4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-543085291, "Lcom/baidu/tieba/ol4$a;");
                    return;
                }
            }
            a = new ol4();
        }
    }

    public ol4() {
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

    public static final ol4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (ol4) invokeV.objValue;
    }

    public synchronized long a(ql4 ql4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ql4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, ql4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<ql4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ql4 ql4Var : list) {
                    h(f, ql4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(ql4 ql4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ql4Var)) == null) {
            if (ql4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(ql4Var.d()));
            contentValues.put("missionid", Integer.valueOf(ql4Var.q()));
            contentValues.put("activitysource", ql4Var.e());
            contentValues.put("calltype", Integer.valueOf(ql4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(ql4Var.x()));
            contentValues.put("browsetimepage", ql4Var.g());
            contentValues.put("browsetime", Long.valueOf(ql4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(ql4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(ql4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(ql4Var.k()));
            contentValues.put("cleartime", Long.valueOf(ql4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(ql4Var.t()));
            contentValues.put("tid", Long.valueOf(ql4Var.C()));
            contentValues.put("fid", Long.valueOf(ql4Var.o()));
            contentValues.put("threadtext", ql4Var.B());
            contentValues.put("threadimg", ql4Var.z());
            contentValues.put("threadforum", Long.valueOf(ql4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(ql4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(ql4Var.w()));
            contentValues.put("token", ql4Var.E());
            contentValues.put("executingMissionList", ql4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final ql4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            ql4 ql4Var = new ql4();
            ql4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
            ql4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
            ql4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
            ql4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
            ql4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
            ql4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
            ql4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
            ql4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
            ql4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
            ql4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
            ql4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
            ql4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
            ql4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
            ql4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
            ql4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
            ql4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
            ql4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
            ql4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
            ql4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
            ql4Var.Q(ql4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
            ql4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
            return ql4Var;
        }
        return (ql4) invokeL.objValue;
    }

    public synchronized boolean e(ql4 ql4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ql4Var)) == null) {
            synchronized (this) {
                if (ql4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(ql4Var.d()), String.valueOf(ql4Var.q())});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<ql4> f() {
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
                    ql4 d = d(rawQuery);
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

    public final long h(SQLiteDatabase sQLiteDatabase, ql4 ql4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, ql4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(ql4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized long i(ql4 ql4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ql4Var)) == null) {
            synchronized (this) {
                if (ql4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, ql4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, ql4 ql4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, ql4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(ql4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(ql4Var.d()), String.valueOf(ql4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public synchronized void k(List<ql4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (ql4 ql4Var : list) {
                    j(f, ql4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }
}
