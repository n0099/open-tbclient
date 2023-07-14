package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.re;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public abstract class pe<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t9 a;
    public String b;
    public re.b c;
    public re.a d;
    public int e;
    public LinkedList<String> f;
    public Object g;

    public abstract boolean d(String str);

    public abstract int g();

    public abstract te<T> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable;

    public abstract void k(String str, String str2, int i, int i2);

    public abstract String l(String str);

    public abstract ContentValues p(te<T> teVar);

    public abstract Cursor q(SQLiteDatabase sQLiteDatabase, String str);

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pe a;

        public a(pe peVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {peVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = peVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    public pe(t9 t9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new LinkedList<>();
        this.g = new Object();
        this.a = t9Var;
    }

    public synchronized void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            synchronized (this) {
                synchronized (this.g) {
                    if (this.f.contains(str)) {
                        return;
                    }
                    this.f.addLast(str);
                    if (z) {
                        j();
                    }
                }
            }
        }
    }

    public void r(re reVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, reVar, str) == null) {
            this.b = str;
            if (reVar instanceof re.b) {
                this.c = (re.b) reVar;
            }
            if (reVar instanceof re.a) {
                this.d = (re.a) reVar;
            }
        }
    }

    public void b(te<T> teVar) {
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, teVar) == null) {
            try {
                synchronized (this.g) {
                    this.f.remove(teVar.a);
                }
                ContentValues p = p(teVar);
                SQLiteDatabase f = this.a.f();
                if (f.update(this.b, p, "m_key = ?", new String[]{teVar.a}) == 0) {
                    f.insert(this.b, null, p);
                    if (this.d != null) {
                        j();
                    }
                }
                if (this.c != null && (d = this.c.d(teVar)) != null) {
                    e(d);
                }
            } catch (Throwable th) {
                this.a.i(th, "addOrUpdateTextCacheItem");
            }
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.e = 0;
            synchronized (this.g) {
                this.f.clear();
            }
            if (d(str)) {
                BdCacheService.n().g().delete(str);
            }
        }
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.a.f().delete(this.b, "m_key = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.i(th, "deleteCacheItem");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public te<T> f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return i(this.a.f(), str);
            } catch (Throwable th) {
                this.a.i(th, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE);
                return null;
            }
        }
        return (te) invokeL.objValue;
    }

    public t9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (t9) invokeV.objValue;
    }

    public void j() {
        re.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (aVar = this.d) != null) {
            this.e++;
            if (this.e >= ((int) Math.min(aVar.getMaxSize() * 0.2d, 5.0d))) {
                this.e = 0;
                ch.a().b(new a(this));
            }
        }
    }

    public void m() {
        String removeFirst;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.f.isEmpty()) {
            return;
        }
        SQLiteDatabase f = this.a.f();
        f.beginTransaction();
        while (true) {
            try {
                synchronized (this.g) {
                    if (this.f.isEmpty()) {
                        break;
                    }
                    removeFirst = this.f.removeFirst();
                }
                f.delete(this.b, "m_key = ?", new String[]{String.valueOf(removeFirst)});
            } finally {
                try {
                } finally {
                }
            }
        }
        f.setTransactionSuccessful();
        this.e = 0;
    }

    @SuppressLint({"Range"})
    public void n(String str) {
        re.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || (aVar = this.d) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            aVar.c();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                te<?> teVar = new te<>();
                teVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                teVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                teVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                teVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String h = this.d.h(teVar);
                if (h != null) {
                    a(h, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }

    @SuppressLint({"Range"})
    public void o(String str) {
        re.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || (bVar = this.c) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            bVar.e();
            cursor = q(this.a.f(), str);
            while (cursor.moveToNext()) {
                te<?> teVar = new te<>();
                teVar.a = cursor.getString(cursor.getColumnIndex("m_key"));
                teVar.d = cursor.getLong(cursor.getColumnIndex("saveTime"));
                teVar.e = cursor.getLong(cursor.getColumnIndex("lastHitTime"));
                teVar.f = cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                String g = this.c.g(teVar);
                if (g != null) {
                    a(g, false);
                }
            }
            m();
        } finally {
            try {
            } finally {
            }
        }
    }
}
