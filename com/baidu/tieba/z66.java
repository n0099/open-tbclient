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
public class z66 {
    public static /* synthetic */ Interceptable $ic;
    public static z66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public z66() {
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

    public static synchronized z66 f() {
        InterceptResult invokeV;
        z66 z66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (z66.class) {
                if (a == null) {
                    a = new z66();
                }
                z66Var = a;
            }
            return z66Var;
        }
        return (z66) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            j88.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    public final int a(w78 w78Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w78Var)) == null) {
            SQLiteDatabase c = i88.c();
            int i = 0;
            if (c == null) {
                return 0;
            }
            try {
                if (!o(c, w78Var.b())) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(w78Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = j88.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(w78Var.b())});
                try {
                    w78Var.h(correctUserIdAfterOverflowCut);
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
                sQLiteDatabase = i88.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = j88.d().e("select * from tb_new_friends", new String[0]);
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
                    wi.a(cursor);
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
                sQLiteDatabase = i88.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = j88.d().e("select * from tb_new_friends", new String[0]);
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
                wi.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return c(i88.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public void l(w78 w78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, w78Var) == null) {
            try {
                k(i88.c(), w78Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<w78> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (w78 w78Var : list) {
                    k(i88.c(), w78Var);
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
            return o(i88.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return j88.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public synchronized w78 e(long j) {
        InterceptResult invokeJ;
        w78 w78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                w78Var = new w78();
                Cursor cursor = null;
                try {
                    cursor = j88.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        w78Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        w78Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        w78Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        w78Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        w78Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                wi.a(cursor);
            }
            return w78Var;
        }
        return (w78) invokeJ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(w78 w78Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, w78Var)) == null) {
            SQLiteDatabase c = i88.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, w78Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(w78Var.f()));
                        contentValues.put("isread", Integer.valueOf(w78Var.c()));
                        i = j88.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(w78Var.b())});
                    } else {
                        k(c, w78Var);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public List<w78> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = j88.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            w78 w78Var = new w78();
                            w78Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            w78Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            w78Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            w78Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            w78Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            w78Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(w78Var);
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
                wi.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public List<w78> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = i88.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = j88.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    w78 w78Var = new w78();
                                    w78Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (w78Var.b() < 0) {
                                        a(w78Var);
                                    }
                                    w78Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    w78Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    w78Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    w78Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    w78Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(w78Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    wi.a(cursor);
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
                    cursor = j88.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
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
                wi.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, w78 w78Var) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, w78Var) == null) && w78Var != null && w78Var.b() != 0 && !TextUtils.isEmpty(w78Var.d())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = i88.c();
            }
            if (sQLiteDatabase != null) {
                c(sQLiteDatabase, w78Var.b());
                if (i(sQLiteDatabase) >= 200) {
                    b(d(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(w78Var.b()));
                    contentValues.put("uname", w78Var.d());
                    contentValues.put("uportrait", w78Var.e());
                    contentValues.put("ucontent", w78Var.a());
                    contentValues.put("ustatus", Integer.valueOf(w78Var.f()));
                    contentValues.put("isread", Integer.valueOf(w78Var.c()));
                    j88.d().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = i88.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = j88.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
                    wi.a(cursor);
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }
}
