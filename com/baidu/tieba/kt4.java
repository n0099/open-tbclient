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
public class kt4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final kt4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-650213727, "Lcom/baidu/tieba/kt4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-650213727, "Lcom/baidu/tieba/kt4$a;");
                    return;
                }
            }
            a = new kt4();
        }
    }

    public kt4() {
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

    public static final kt4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (kt4) invokeV.objValue;
    }

    public synchronized long a(mt4 mt4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mt4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, mt4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(mt4 mt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, mt4Var)) == null) {
            synchronized (this) {
                if (mt4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, mt4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<mt4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (mt4 mt4Var : list) {
                    h(f, mt4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(mt4 mt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mt4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (mt4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(mt4Var.d()), String.valueOf(mt4Var.q())});
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

    public synchronized void k(List<mt4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (mt4 mt4Var : list) {
                    j(f, mt4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(mt4 mt4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mt4Var)) == null) {
            if (mt4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(mt4Var.d()));
            contentValues.put("missionid", Integer.valueOf(mt4Var.q()));
            contentValues.put("activitysource", mt4Var.e());
            contentValues.put("calltype", Integer.valueOf(mt4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(mt4Var.x()));
            contentValues.put("browsetimepage", mt4Var.g());
            contentValues.put("browsetime", Long.valueOf(mt4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(mt4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(mt4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(mt4Var.k()));
            contentValues.put("cleartime", Long.valueOf(mt4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(mt4Var.t()));
            contentValues.put("tid", Long.valueOf(mt4Var.C()));
            contentValues.put("fid", Long.valueOf(mt4Var.o()));
            contentValues.put("threadtext", mt4Var.B());
            contentValues.put("threadimg", mt4Var.z());
            contentValues.put("threadforum", Long.valueOf(mt4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(mt4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(mt4Var.w()));
            contentValues.put("token", mt4Var.E());
            contentValues.put("executingMissionList", mt4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final mt4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                mt4 mt4Var = new mt4();
                mt4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                mt4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                mt4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                mt4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                mt4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                mt4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                mt4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                mt4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                mt4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                mt4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                mt4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                mt4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                mt4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                mt4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                mt4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                mt4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                mt4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                mt4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                mt4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                mt4Var.Q(mt4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                mt4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return mt4Var;
            }
            return null;
        }
        return (mt4) invokeL.objValue;
    }

    public synchronized List<mt4> f() {
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
                    mt4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                fi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, mt4 mt4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, mt4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(mt4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, mt4 mt4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, mt4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(mt4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(mt4Var.d()), String.valueOf(mt4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
