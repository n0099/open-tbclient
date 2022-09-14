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
public class zh1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zh1 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Context b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(zh1 zh1Var, Context context, a aVar) {
            this(zh1Var, context);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL("create table if not exists rp_tb(id integer primary key autoincrement, a text, c integer, d integer);");
                } catch (Throwable th) {
                    ii1.d(th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(zh1 zh1Var, Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh1Var, context};
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
    }

    public zh1(Context context) {
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

    public static zh1 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (c == null) {
                synchronized (zh1.class) {
                    if (c == null) {
                        c = new zh1(context);
                    }
                }
            }
            return c;
        }
        return (zh1) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<ai1> b(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (ArrayList) invokeL.objValue;
        }
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
                        ArrayList<ai1> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            ai1 ai1Var = new ai1();
                            ai1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                            ai1Var.c(ki1.a(this.b, cursor.getString(cursor.getColumnIndex("a"))));
                            ai1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                            ai1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                            arrayList.add(ai1Var);
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ii1.d(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                ii1.d(th3);
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
                                ii1.d(th4);
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
                    ii1.d(th5);
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public void c(ai1 ai1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai1Var) == null) || ai1Var == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", ki1.b(this.b, ai1Var.d().getBytes()));
            contentValues.put("c", Integer.valueOf(ai1Var.h()));
            contentValues.put("d", Integer.valueOf(ai1Var.f()));
            this.a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            ii1.d(th);
        }
    }

    public void d(ArrayList<ai1> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) || arrayList == null) {
            return;
        }
        try {
            if (arrayList.size() == 0) {
                return;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                f(arrayList.get(i));
            }
        } catch (Throwable th) {
            ii1.d(th);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<ai1> e(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (ArrayList) invokeL.objValue;
        }
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
                        ArrayList<ai1> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            ai1 ai1Var = new ai1();
                            ai1Var.b(cursor.getInt(cursor.getColumnIndex("id")));
                            ai1Var.c(ki1.a(this.b, cursor.getString(cursor.getColumnIndex("a"))));
                            ai1Var.g(cursor.getInt(cursor.getColumnIndex("c")));
                            ai1Var.e(cursor.getInt(cursor.getColumnIndex("d")));
                            arrayList.add(ai1Var);
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ii1.d(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                ii1.d(th3);
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
                                ii1.d(th4);
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
                    ii1.d(th5);
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public final void f(ai1 ai1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ai1Var) == null) {
            try {
                this.a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(ai1Var.a())});
            } catch (Throwable th) {
                System.currentTimeMillis();
                ii1.d(th);
            }
        }
    }
}
