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
public class mm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final mm4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-599420072, "Lcom/baidu/tieba/mm4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-599420072, "Lcom/baidu/tieba/mm4$a;");
                    return;
                }
            }
            a = new mm4();
        }
    }

    public mm4() {
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

    public static final mm4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (mm4) invokeV.objValue;
    }

    public synchronized long a(om4 om4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, om4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, om4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, om4Var)) == null) {
            synchronized (this) {
                if (om4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, om4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<om4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (om4 om4Var : list) {
                    h(f, om4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, om4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (om4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(om4Var.d()), String.valueOf(om4Var.q())});
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

    public synchronized void k(List<om4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (om4 om4Var : list) {
                    j(f, om4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(om4 om4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, om4Var)) == null) {
            if (om4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(om4Var.d()));
            contentValues.put("missionid", Integer.valueOf(om4Var.q()));
            contentValues.put("activitysource", om4Var.e());
            contentValues.put("calltype", Integer.valueOf(om4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(om4Var.x()));
            contentValues.put("browsetimepage", om4Var.g());
            contentValues.put("browsetime", Long.valueOf(om4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(om4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(om4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(om4Var.k()));
            contentValues.put("cleartime", Long.valueOf(om4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(om4Var.t()));
            contentValues.put("tid", Long.valueOf(om4Var.C()));
            contentValues.put("fid", Long.valueOf(om4Var.o()));
            contentValues.put("threadtext", om4Var.B());
            contentValues.put("threadimg", om4Var.z());
            contentValues.put("threadforum", Long.valueOf(om4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(om4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(om4Var.w()));
            contentValues.put("token", om4Var.E());
            contentValues.put("executingMissionList", om4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final om4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                om4 om4Var = new om4();
                om4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                om4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                om4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                om4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                om4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                om4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                om4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                om4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                om4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                om4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                om4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                om4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                om4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                om4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                om4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                om4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                om4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                om4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                om4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                om4Var.Q(om4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                om4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return om4Var;
            }
            return null;
        }
        return (om4) invokeL.objValue;
    }

    public synchronized List<om4> f() {
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
                    om4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                aj.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, om4 om4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, om4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(om4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, om4 om4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, om4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(om4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(om4Var.d()), String.valueOf(om4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
