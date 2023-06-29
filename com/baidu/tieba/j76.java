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
/* loaded from: classes6.dex */
public class j76 {
    public static /* synthetic */ Interceptable $ic;
    public static j76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public j76() {
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

    public static synchronized j76 f() {
        InterceptResult invokeV;
        j76 j76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (j76.class) {
                if (a == null) {
                    a = new j76();
                }
                j76Var = a;
            }
            return j76Var;
        }
        return (j76) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            f98.d().update("tb_new_friends", contentValues, null, null);
        }
    }

    public final int a(r88 r88Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r88Var)) == null) {
            SQLiteDatabase c = e98.c();
            int i = 0;
            if (c == null) {
                return 0;
            }
            try {
                if (!o(c, r88Var.b())) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(r88Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int update = f98.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(r88Var.b())});
                try {
                    r88Var.h(correctUserIdAfterOverflowCut);
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
                sQLiteDatabase = e98.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = f98.d().e("select * from tb_new_friends", new String[0]);
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
                    yi.a(cursor);
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
                sQLiteDatabase = e98.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = f98.d().e("select * from tb_new_friends", new String[0]);
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
                yi.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return c(e98.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public void l(r88 r88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, r88Var) == null) {
            try {
                k(e98.c(), r88Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<r88> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (r88 r88Var : list) {
                    k(e98.c(), r88Var);
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
            return o(e98.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return f98.d().delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public synchronized r88 e(long j) {
        InterceptResult invokeJ;
        r88 r88Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                r88Var = new r88();
                Cursor cursor = null;
                try {
                    cursor = f98.d().e("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        r88Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        r88Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        r88Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        r88Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        r88Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                yi.a(cursor);
            }
            return r88Var;
        }
        return (r88) invokeJ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:22:0x005b). Please submit an issue!!! */
    public int q(r88 r88Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, r88Var)) == null) {
            SQLiteDatabase c = e98.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, r88Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(r88Var.f()));
                        contentValues.put("isread", Integer.valueOf(r88Var.c()));
                        i = f98.d().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(r88Var.b())});
                    } else {
                        k(c, r88Var);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public List<r88> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = f98.d().e("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            r88 r88Var = new r88();
                            r88Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            r88Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            r88Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            r88Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            r88Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            r88Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(r88Var);
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
                yi.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public List<r88> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = e98.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = f98.d().e("select * from tb_new_friends ORDER BY _id DESC", null);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    r88 r88Var = new r88();
                                    r88Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                    if (r88Var.b() < 0) {
                                        a(r88Var);
                                    }
                                    r88Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                    r88Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                    r88Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                    r88Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                    r88Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                    arrayList.add(r88Var);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    yi.a(cursor);
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
                    cursor = f98.d().e("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
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
                yi.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, r88 r88Var) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, r88Var) == null) && r88Var != null && r88Var.b() != 0 && !TextUtils.isEmpty(r88Var.d())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = e98.c();
            }
            if (sQLiteDatabase != null) {
                c(sQLiteDatabase, r88Var.b());
                if (i(sQLiteDatabase) >= 200) {
                    b(d(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(r88Var.b()));
                    contentValues.put("uname", r88Var.d());
                    contentValues.put("uportrait", r88Var.e());
                    contentValues.put("ucontent", r88Var.a());
                    contentValues.put("ustatus", Integer.valueOf(r88Var.f()));
                    contentValues.put("isread", Integer.valueOf(r88Var.c()));
                    f98.d().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = e98.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = f98.d().e("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
                    yi.a(cursor);
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }
}
