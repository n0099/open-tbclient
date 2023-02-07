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
/* loaded from: classes7.dex */
public class xn1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xn1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Context b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xn1 xn1Var, Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn1Var, context};
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

        public /* synthetic */ b(xn1 xn1Var, Context context, a aVar) {
            this(xn1Var, context);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("create table if not exists rp_tb(id integer primary key autoincrement, a text, c integer, d integer);");
                } catch (Throwable th) {
                    go1.d(th);
                }
            }
        }
    }

    public xn1(Context context) {
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
        this.b = context;
        this.a = new b(this, this.b, null);
    }

    public final void f(yn1 yn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yn1Var) == null) {
            try {
                this.a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(yn1Var.a())});
            } catch (Throwable th) {
                System.currentTimeMillis();
                go1.d(th);
            }
        }
    }

    public static xn1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (xn1.class) {
                    if (c == null) {
                        c = new xn1(context);
                    }
                }
            }
            return c;
        }
        return (xn1) invokeL.objValue;
    }

    public void d(ArrayList<yn1> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        f(arrayList.get(i));
                    }
                }
            } catch (Throwable th) {
                go1.d(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<yn1> b(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM rp_tb WHERE c IN (");
                sb.append(str);
                sb.append(") LIMIT 100");
                cursor = writableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<yn1> arrayList = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                yn1 yn1Var = new yn1();
                                yn1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                yn1Var.c(io1.a(this.b, cursor.getString(cursor.getColumnIndex("a"))));
                                yn1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                yn1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                arrayList.add(yn1Var);
                            }
                            return arrayList;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            go1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th3) {
                                    go1.d(th3);
                                }
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th4) {
                                    go1.d(th4);
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
                    } catch (Throwable th5) {
                        go1.d(th5);
                    }
                }
                return null;
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
        } else {
            return (ArrayList) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<yn1> e(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM rp_tb WHERE c IN (");
                sb.append(str);
                sb.append(") and ");
                sb.append("d");
                sb.append("=");
                sb.append(2);
                sb.append(" LIMIT 100");
                cursor = writableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            ArrayList<yn1> arrayList = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                yn1 yn1Var = new yn1();
                                yn1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                                yn1Var.c(io1.a(this.b, cursor.getString(cursor.getColumnIndex("a"))));
                                yn1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                                yn1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                                arrayList.add(yn1Var);
                            }
                            return arrayList;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            go1.d(th);
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th3) {
                                    go1.d(th3);
                                }
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                try {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                } catch (Throwable th4) {
                                    go1.d(th4);
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
                    } catch (Throwable th5) {
                        go1.d(th5);
                    }
                }
                return null;
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
        } else {
            return (ArrayList) invokeL.objValue;
        }
    }

    public void c(yn1 yn1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yn1Var) != null) || yn1Var == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", io1.b(this.b, yn1Var.d().getBytes()));
            contentValues.put("c", Integer.valueOf(yn1Var.h()));
            contentValues.put("d", Integer.valueOf(yn1Var.f()));
            this.a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            go1.d(th);
        }
    }
}
