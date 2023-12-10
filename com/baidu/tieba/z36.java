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
/* loaded from: classes9.dex */
public class z36 {
    public static /* synthetic */ Interceptable $ic;
    public static z36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public z36() {
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

    public static synchronized z36 f() {
        InterceptResult invokeV;
        z36 z36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (z36.class) {
                if (a == null) {
                    a = new z36();
                }
                z36Var = a;
            }
            return z36Var;
        }
        return (z36) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            gu8.e().i("tb_new_friends", contentValues, null, null);
        }
    }

    public final int a(st8 st8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, st8Var)) == null) {
            SQLiteDatabase c = fu8.c();
            int i = 0;
            if (c == null) {
                return 0;
            }
            try {
                if (!o(c, st8Var.b())) {
                    return 0;
                }
                ContentValues contentValues = new ContentValues();
                long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(st8Var.b());
                contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                int i2 = gu8.e().i("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(st8Var.b())});
                try {
                    st8Var.h(correctUserIdAfterOverflowCut);
                    return i2;
                } catch (Exception e) {
                    e = e;
                    i = i2;
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
                sQLiteDatabase = fu8.c();
            }
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        try {
                            cursor = gu8.e().g("select * from tb_new_friends", new String[0]);
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
                    sd.a(cursor);
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
                sQLiteDatabase = fu8.c();
            }
            Cursor cursor = null;
            try {
                if (sQLiteDatabase == null) {
                    return 0;
                }
                try {
                    cursor = gu8.e().g("select * from tb_new_friends", new String[0]);
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
                sd.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return c(fu8.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public void l(st8 st8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, st8Var) == null) {
            try {
                k(fu8.c(), st8Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(List<st8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            try {
                for (st8 st8Var : list) {
                    k(fu8.c(), st8Var);
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
            return o(fu8.c(), j);
        }
        return invokeJ.booleanValue;
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, j)) == null) {
            try {
                return gu8.e().b("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLJ.booleanValue;
    }

    public synchronized st8 e(long j) {
        InterceptResult invokeJ;
        st8 st8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                st8Var = new st8();
                Cursor cursor = null;
                try {
                    cursor = gu8.e().g("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null && cursor.moveToNext()) {
                        st8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        st8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        st8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        st8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                        st8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                sd.a(cursor);
            }
            return st8Var;
        }
        return (st8) invokeJ.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0057 -> B:22:0x005c). Please submit an issue!!! */
    public int q(st8 st8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, st8Var)) == null) {
            SQLiteDatabase c = fu8.c();
            int i = 0;
            if (c != null) {
                try {
                    if (o(c, st8Var.b())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(st8Var.f()));
                        contentValues.put("isread", Integer.valueOf(st8Var.c()));
                        i = gu8.e().i("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(st8Var.b())});
                    } else {
                        k(c, st8Var);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public List<st8> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = gu8.e().g("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            st8 st8Var = new st8();
                            st8Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                            st8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                            st8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                            st8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                            st8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                            st8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(st8Var);
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
                sd.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public List<st8> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SQLiteDatabase c = fu8.c();
            ArrayList arrayList = new ArrayList();
            if (c != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = gu8.e().g("select * from tb_new_friends ORDER BY _id DESC", null);
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                st8 st8Var = new st8();
                                st8Var.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                if (st8Var.b() < 0) {
                                    a(st8Var);
                                }
                                st8Var.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                st8Var.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                st8Var.j(cursor.getString(cursor.getColumnIndex("uname")));
                                st8Var.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                st8Var.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                arrayList.add(st8Var);
                            }
                        }
                    } catch (SQLiteException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    sd.a(cursor);
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
                    cursor = gu8.e().g("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
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
                sd.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, st8 st8Var) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, sQLiteDatabase, st8Var) == null) && st8Var != null && st8Var.b() != 0 && !TextUtils.isEmpty(st8Var.d())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = fu8.c();
            }
            if (sQLiteDatabase != null) {
                c(sQLiteDatabase, st8Var.b());
                if (i(sQLiteDatabase) >= 200) {
                    b(d(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(st8Var.b()));
                    contentValues.put("uname", st8Var.d());
                    contentValues.put("uportrait", st8Var.e());
                    contentValues.put("ucontent", st8Var.a());
                    contentValues.put("ustatus", Integer.valueOf(st8Var.f()));
                    contentValues.put("isread", Integer.valueOf(st8Var.c()));
                    gu8.e().f("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, sQLiteDatabase, j)) == null) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = fu8.c();
            }
            boolean z = false;
            if (sQLiteDatabase != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = gu8.e().g("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
                    sd.a(cursor);
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }
}
