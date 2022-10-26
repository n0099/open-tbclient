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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class pl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public static final pl4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514456140, "Lcom/baidu/tieba/pl4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-514456140, "Lcom/baidu/tieba/pl4$a;");
                    return;
                }
            }
            a = new pl4();
        }
    }

    public pl4() {
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

    public static final pl4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (pl4) invokeV.objValue;
    }

    public synchronized long a(rl4 rl4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rl4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, rl4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rl4Var)) == null) {
            synchronized (this) {
                if (rl4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, rl4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    h(f, (rl4) it.next());
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rl4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (rl4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(rl4Var.d()), String.valueOf(rl4Var.q())});
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

    public synchronized void k(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    j(f, (rl4) it.next());
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(rl4 rl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rl4Var)) == null) {
            if (rl4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(rl4Var.d()));
            contentValues.put("missionid", Integer.valueOf(rl4Var.q()));
            contentValues.put("activitysource", rl4Var.e());
            contentValues.put("calltype", Integer.valueOf(rl4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(rl4Var.x()));
            contentValues.put("browsetimepage", rl4Var.g());
            contentValues.put("browsetime", Long.valueOf(rl4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(rl4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(rl4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(rl4Var.k()));
            contentValues.put("cleartime", Long.valueOf(rl4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(rl4Var.t()));
            contentValues.put("tid", Long.valueOf(rl4Var.C()));
            contentValues.put("fid", Long.valueOf(rl4Var.o()));
            contentValues.put("threadtext", rl4Var.B());
            contentValues.put("threadimg", rl4Var.z());
            contentValues.put("threadforum", Long.valueOf(rl4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(rl4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(rl4Var.w()));
            contentValues.put("token", rl4Var.E());
            contentValues.put("executingMissionList", rl4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final rl4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                rl4 rl4Var = new rl4();
                rl4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                rl4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                rl4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                rl4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                rl4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                rl4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                rl4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                rl4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                rl4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                rl4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                rl4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                rl4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                rl4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                rl4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                rl4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                rl4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                rl4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                rl4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                rl4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                rl4Var.Q(rl4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                rl4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return rl4Var;
            }
            return null;
        }
        return (rl4) invokeL.objValue;
    }

    public synchronized List f() {
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
                    rl4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                gj.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, rl4 rl4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, rl4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(rl4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, rl4 rl4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, rl4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(rl4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(rl4Var.d()), String.valueOf(rl4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
