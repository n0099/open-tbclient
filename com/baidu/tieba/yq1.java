package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class yq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yq1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(Context context, a aVar) {
            this(context);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("create table if not exists rp_tb(id integer primary key autoincrement, a text, c integer, d integer);");
                } catch (Throwable th) {
                    hr1.d(th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) && i == 1 && i2 == 2) {
                try {
                    sQLiteDatabase.delete("rp_tb", null, null);
                } catch (Throwable th) {
                    hr1.d(th);
                }
            }
        }
    }

    public yq1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(context, null);
    }

    public final void f(zq1 zq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zq1Var) == null) {
            try {
                this.a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(zq1Var.a())});
            } catch (Throwable th) {
                System.currentTimeMillis();
                hr1.d(th);
            }
        }
    }

    public static yq1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (yq1.class) {
                    if (b == null) {
                        b = new yq1(context);
                    }
                }
            }
            return b;
        }
        return (yq1) invokeL.objValue;
    }

    public void d(ArrayList<zq1> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        f(arrayList.get(i));
                    }
                }
            } catch (Throwable th) {
                hr1.d(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<zq1> b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                cursor = this.a.getWritableDatabase().rawQuery("SELECT * FROM rp_tb WHERE c IN (" + str + ") LIMIT 100", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<zq1> arrayList = new ArrayList<>();
                            ArrayList<zq1> arrayList2 = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                zq1 zq1Var = new zq1();
                                zq1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                byte[] b2 = fr1.b(cursor.getString(cursor.getColumnIndex("a")));
                                if (b2 == null) {
                                    arrayList2.add(zq1Var);
                                } else {
                                    zq1Var.c(new String(b2));
                                    zq1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                    zq1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                    arrayList.add(zq1Var);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                d(arrayList2);
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            hr1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    hr1.d(th2);
                                }
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th3) {
                                    hr1.d(th3);
                                }
                            }
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Throwable th4) {
                        hr1.d(th4);
                    }
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
        } else {
            return (ArrayList) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<zq1> e(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                cursor = this.a.getWritableDatabase().rawQuery("SELECT * FROM rp_tb WHERE c IN (" + str + ") and d=2 LIMIT 100", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<zq1> arrayList = new ArrayList<>();
                            ArrayList<zq1> arrayList2 = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                zq1 zq1Var = new zq1();
                                zq1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                byte[] b2 = fr1.b(cursor.getString(cursor.getColumnIndex("a")));
                                if (b2 == null) {
                                    arrayList2.add(zq1Var);
                                } else {
                                    zq1Var.c(new String(b2));
                                    zq1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                    zq1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                    arrayList.add(zq1Var);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                d(arrayList2);
                            }
                            return arrayList;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            hr1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    hr1.d(th2);
                                }
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th3) {
                                    hr1.d(th3);
                                }
                            }
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Throwable th4) {
                        hr1.d(th4);
                    }
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
        } else {
            return (ArrayList) invokeL.objValue;
        }
    }

    public void c(zq1 zq1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zq1Var) != null) || zq1Var == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", fr1.a(zq1Var.d().getBytes()));
            contentValues.put("c", Integer.valueOf(zq1Var.h()));
            contentValues.put("d", Integer.valueOf(zq1Var.f()));
            this.a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            hr1.d(th);
        }
    }
}
