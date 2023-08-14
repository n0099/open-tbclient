package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class v56 {
    public static /* synthetic */ Interceptable $ic;
    public static v56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public v56() {
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

    public static synchronized v56 f() {
        InterceptResult invokeV;
        v56 v56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (v56.class) {
                if (a == null) {
                    a = new v56();
                }
                v56Var = a;
            }
            return v56Var;
        }
        return (v56) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            ub8.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    public final int a(gb8 gb8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gb8Var)) == null) {
            SQLiteDatabase c = tb8.c();
            int i = 0;
            if (c == null) {
                return 0;
            }
            try {
                if (!o(c, gb8Var.b())) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(gb8Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = ub8.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(gb8Var.b())});
                try {
                    gb8Var.h(correctUserIdAfterOverflowCut);
                    return update;
                } catch (Exception e) {
                    e = e;
                    i = update;
                    e.printStackTrace();
                    return i;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return invokeL.intValue;
        }
    }

    public final long d(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = tb8.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = ub8.d().e("select * from tb_new_friends", new String[0]);
                            if (cursor != null && cursor.moveToNext()) {
                                return cursor.getLong(cursor.getColumnIndex("uid"));
                            }
                        } catch (SQLiteException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 0L;
                } finally {
                    ci.a(cursor);
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sQLiteDatabase)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = tb8.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = ub8.d().e("select * from tb_new_friends", new String[0]);
                    if (cursor != null && cursor.moveToFirst()) {
                        return cursor.getCount();
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                ci.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return c(tb8.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public void l(gb8 gb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gb8Var) == null) {
            try {
                k(tb8.c(), gb8Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<gb8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (gb8 gb8Var : list) {
                    k(tb8.c(), gb8Var);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean n(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
            return o(tb8.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return ub8.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public synchronized gb8 e(long j) {
        InterceptResult invokeJ;
        gb8 gb8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                gb8Var = new gb8();
                Cursor cursor = null;
                try {
                    cursor = ub8.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        gb8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        gb8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        gb8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        gb8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        gb8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                ci.a(cursor);
            }
            return gb8Var;
        }
        return (gb8) invokeJ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(gb8 gb8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, gb8Var)) == null) {
            SQLiteDatabase c = tb8.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, gb8Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(gb8Var.f()));
                        contentValues.put("isread", Integer.valueOf(gb8Var.c()));
                        i = ub8.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(gb8Var.b())});
                    } else {
                        k(c, gb8Var);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public List<gb8> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = ub8.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            gb8 gb8Var = new gb8();
                            gb8Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            gb8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            gb8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            gb8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            gb8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            gb8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(gb8Var);
                        }
                        p();
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return arrayList;
            } finally {
                ci.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public List<gb8> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = tb8.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = ub8.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    gb8 gb8Var = new gb8();
                                    gb8Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (gb8Var.b() < 0) {
                                        a(gb8Var);
                                    }
                                    gb8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    gb8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    gb8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    gb8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    gb8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(gb8Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    ci.a(cursor);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = ub8.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getInt(0);
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                ci.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, gb8 gb8Var) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, gb8Var) == null) && gb8Var != null && gb8Var.b() != 0 && !TextUtils.isEmpty(gb8Var.d())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = tb8.c();
            }
            if (sQLiteDatabase != null) {
                c(sQLiteDatabase, gb8Var.b());
                if (i(sQLiteDatabase) >= 200) {
                    b(d(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(gb8Var.b()));
                    contentValues.put("uname", gb8Var.d());
                    contentValues.put("uportrait", gb8Var.e());
                    contentValues.put("ucontent", gb8Var.a());
                    contentValues.put("ustatus", Integer.valueOf(gb8Var.f()));
                    contentValues.put("isread", Integer.valueOf(gb8Var.c()));
                    ub8.d().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = tb8.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = ub8.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                            if (cursor.moveToFirst()) {
                                z = true;
                            }
                        }
                    } catch (SQLiteException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    ci.a(cursor);
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }
}
