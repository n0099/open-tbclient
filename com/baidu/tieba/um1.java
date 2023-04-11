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
/* loaded from: classes6.dex */
public class um1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile um1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
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
                    dn1.d(th);
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
                    dn1.d(th);
                }
            }
        }
    }

    public um1(Context context) {
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

    public final void f(vm1 vm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vm1Var) == null) {
            try {
                this.a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(vm1Var.a())});
            } catch (Throwable th) {
                System.currentTimeMillis();
                dn1.d(th);
            }
        }
    }

    public static um1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (b == null) {
                synchronized (um1.class) {
                    if (b == null) {
                        b = new um1(context);
                    }
                }
            }
            return b;
        }
        return (um1) invokeL.objValue;
    }

    public void d(ArrayList<vm1> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        f(arrayList.get(i));
                    }
                }
            } catch (Throwable th) {
                dn1.d(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<vm1> b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                cursor = this.a.getWritableDatabase().rawQuery("SELECT * FROM rp_tb WHERE c IN (" + str + ") LIMIT 100", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<vm1> arrayList = new ArrayList<>();
                            ArrayList<vm1> arrayList2 = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                vm1 vm1Var = new vm1();
                                vm1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                byte[] b2 = bn1.b(cursor.getString(cursor.getColumnIndex("a")));
                                if (b2 == null) {
                                    arrayList2.add(vm1Var);
                                } else {
                                    vm1Var.c(new String(b2));
                                    vm1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                    vm1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                    arrayList.add(vm1Var);
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
                            dn1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    dn1.d(th2);
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
                                    dn1.d(th3);
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
                        dn1.d(th4);
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
    public ArrayList<vm1> e(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                cursor = this.a.getWritableDatabase().rawQuery("SELECT * FROM rp_tb WHERE c IN (" + str + ") and d=2 LIMIT 100", null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<vm1> arrayList = new ArrayList<>();
                            ArrayList<vm1> arrayList2 = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                vm1 vm1Var = new vm1();
                                vm1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                byte[] b2 = bn1.b(cursor.getString(cursor.getColumnIndex("a")));
                                if (b2 == null) {
                                    arrayList2.add(vm1Var);
                                } else {
                                    vm1Var.c(new String(b2));
                                    vm1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                    vm1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                    arrayList.add(vm1Var);
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
                            dn1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th2) {
                                    dn1.d(th2);
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
                                    dn1.d(th3);
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
                        dn1.d(th4);
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

    public void c(vm1 vm1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm1Var) != null) || vm1Var == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", bn1.a(vm1Var.d().getBytes()));
            contentValues.put("c", Integer.valueOf(vm1Var.h()));
            contentValues.put("d", Integer.valueOf(vm1Var.f()));
            this.a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            dn1.d(th);
        }
    }
}
