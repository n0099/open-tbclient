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
public class wp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final wp4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-310357999, "Lcom/baidu/tieba/wp4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-310357999, "Lcom/baidu/tieba/wp4$a;");
                    return;
                }
            }
            a = new wp4();
        }
    }

    public wp4() {
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

    public static final wp4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.a;
        }
        return (wp4) invokeV.objValue;
    }

    public synchronized long a(yp4 yp4Var) {
        InterceptResult invokeL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yp4Var)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                h = h(f, yp4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
            }
            return h;
        }
        return invokeL.longValue;
    }

    public synchronized long i(yp4 yp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, yp4Var)) == null) {
            synchronized (this) {
                if (yp4Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long j = j(f, yp4Var);
                f.setTransactionSuccessful();
                f.endTransaction();
                return j;
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(List<yp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (yp4 yp4Var : list) {
                    h(f, yp4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized boolean e(yp4 yp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yp4Var)) == null) {
            synchronized (this) {
                boolean z = false;
                if (yp4Var == null) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete("activity_mission_info", "activityid = ? and missionid = ?", new String[]{String.valueOf(yp4Var.d()), String.valueOf(yp4Var.q())});
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

    public synchronized void k(List<yp4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            synchronized (this) {
                if (ListUtils.isEmpty(list)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                for (yp4 yp4Var : list) {
                    j(f, yp4Var);
                }
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public final ContentValues c(yp4 yp4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yp4Var)) == null) {
            if (yp4Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("activityid", Integer.valueOf(yp4Var.d()));
            contentValues.put("missionid", Integer.valueOf(yp4Var.q()));
            contentValues.put("activitysource", yp4Var.e());
            contentValues.put("calltype", Integer.valueOf(yp4Var.i()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TASK_TYPE, Integer.valueOf(yp4Var.x()));
            contentValues.put("browsetimepage", yp4Var.g());
            contentValues.put("browsetime", Long.valueOf(yp4Var.f()));
            contentValues.put("threadnum", Integer.valueOf(yp4Var.A()));
            contentValues.put("forumnum", Integer.valueOf(yp4Var.p()));
            contentValues.put("cleartype", Integer.valueOf(yp4Var.k()));
            contentValues.put("cleartime", Long.valueOf(yp4Var.j()));
            contentValues.put("specificcleartime", Long.valueOf(yp4Var.t()));
            contentValues.put("tid", Long.valueOf(yp4Var.C()));
            contentValues.put("fid", Long.valueOf(yp4Var.o()));
            contentValues.put("threadtext", yp4Var.B());
            contentValues.put("threadimg", yp4Var.z());
            contentValues.put("threadforum", Long.valueOf(yp4Var.y()));
            contentValues.put("totalLimit", Integer.valueOf(yp4Var.F()));
            contentValues.put("completedLimitCount", Integer.valueOf(yp4Var.w()));
            contentValues.put("token", yp4Var.E());
            contentValues.put("executingMissionList", yp4Var.b());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final yp4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                yp4 yp4Var = new yp4();
                yp4Var.T(cursor.getInt(cursor.getColumnIndex("activityid")));
                yp4Var.c0(cursor.getInt(cursor.getColumnIndex("missionid")));
                yp4Var.U(cursor.getString(cursor.getColumnIndex("activitysource")));
                yp4Var.X(cursor.getInt(cursor.getColumnIndex("calltype")));
                yp4Var.g0(cursor.getInt(cursor.getColumnIndex(DownloadDataConstants.Columns.COLUMN_TASK_TYPE)));
                yp4Var.W(cursor.getString(cursor.getColumnIndex("browsetimepage")));
                yp4Var.V(cursor.getLong(cursor.getColumnIndex("browsetime")));
                yp4Var.j0(cursor.getInt(cursor.getColumnIndex("threadnum")));
                yp4Var.b0(cursor.getInt(cursor.getColumnIndex("forumnum")));
                yp4Var.Z(cursor.getInt(cursor.getColumnIndex("cleartype")));
                yp4Var.Y(cursor.getLong(cursor.getColumnIndex("cleartime")));
                yp4Var.e0(cursor.getLong(cursor.getColumnIndex("specificcleartime")));
                yp4Var.l0(cursor.getLong(cursor.getColumnIndex("tid")));
                yp4Var.a0(cursor.getLong(cursor.getColumnIndex("fid")));
                yp4Var.k0(cursor.getString(cursor.getColumnIndex("threadtext")));
                yp4Var.i0(cursor.getString(cursor.getColumnIndex("threadimg")));
                yp4Var.h0(cursor.getInt(cursor.getColumnIndex("threadforum")));
                yp4Var.n0(cursor.getInt(cursor.getColumnIndex("totalLimit")));
                yp4Var.f0(cursor.getInt(cursor.getColumnIndex("completedLimitCount")));
                yp4Var.Q(yp4Var.x(), cursor.getString(cursor.getColumnIndex("executingMissionList")));
                yp4Var.m0(cursor.getString(cursor.getColumnIndex("token")));
                return yp4Var;
            }
            return null;
        }
        return (yp4) invokeL.objValue;
    }

    public synchronized List<yp4> f() {
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
                    yp4 d = d(rawQuery);
                    if (d != null) {
                        linkedList.add(d);
                    }
                }
                f.setTransactionSuccessful();
                ii.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final long h(SQLiteDatabase sQLiteDatabase, yp4 yp4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, yp4Var)) == null) {
            try {
                return sQLiteDatabase.insert("activity_mission_info", null, c(yp4Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final long j(SQLiteDatabase sQLiteDatabase, yp4 yp4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, yp4Var)) == null) {
            try {
                return sQLiteDatabase.update("activity_mission_info", c(yp4Var), "activityid = ? and missionid = ?", new String[]{String.valueOf(yp4Var.d()), String.valueOf(yp4Var.q())});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }
}
