package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qj0 implements tj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g01 a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ qj0 b;

        public a(qj0 qj0Var, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj0Var, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj0Var;
            this.a = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (String str : this.a) {
                        sz0 sz0Var = new sz0();
                        sz0Var.o(str);
                        this.b.a.delete(sz0Var, new e01[0]);
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ qj0 b;

        public b(qj0 qj0Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj0Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj0Var;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.a.entrySet()) {
                        yj0 yj0Var = (yj0) entry.getValue();
                        if (yj0Var != null) {
                            sz0 a = rj0.a(yj0Var);
                            if (!TextUtils.isEmpty(a.g())) {
                                this.b.a.a(a, new e01[0]);
                            }
                        }
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz0 a;
        public final /* synthetic */ qj0 b;

        public c(qj0 qj0Var, sz0 sz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj0Var, sz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj0Var;
            this.a = sz0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.a(this.a, new e01[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz0 a;
        public final /* synthetic */ qj0 b;

        public d(qj0 qj0Var, sz0 sz0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj0Var, sz0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qj0Var;
            this.a = sz0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.update(this.a, new e01[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public e(qj0 qj0Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj0Var, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.run();
                } catch (Throwable th) {
                    if (!ag0.a) {
                        Log.d("AdDownloadDBHelper", "wrapExecutor", th);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static tj0 a;
        public static final tj0 b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements tj0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            public a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = th;
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("v", "5.8.0.17");
                    hashMap.put("e", this.a.toString());
                    uz0.b(new ClogBuilder().y(ClogBuilder.LogType.CHECK).k("12").l("4000").m(new JSONObject(hashMap).toString()));
                }
            }

            @Override // com.baidu.tieba.tj0
            public List<yj0> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ArrayList() : (List) invokeV.objValue;
            }

            @Override // com.baidu.tieba.tj0
            public void b(HashMap<String, yj0> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.tieba.tj0
            public void c(sz0 sz0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sz0Var) == null) {
                }
            }

            @Override // com.baidu.tieba.tj0
            public void update(sz0 sz0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, sz0Var) == null) {
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487793040, "Lcom/baidu/tieba/qj0$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-487793040, "Lcom/baidu/tieba/qj0$f;");
                    return;
                }
            }
            try {
                if (r21.b()) {
                    a = new qj0(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            b = a;
        }

        public static tj0 b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) ? new a(th) : (tj0) invokeL.objValue;
        }
    }

    public /* synthetic */ qj0(a aVar) {
        this();
    }

    public static tj0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f.b : (tj0) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.baidu.tieba.tj0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<yj0> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            sz0 sz0Var = new sz0();
            s01 e2 = s01.e();
            e2.a("o", sz0Var.b().d());
            e2.c("o", sz0Var);
            HashSet hashSet = new HashSet();
            Cursor query = this.a.query(e2);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    do {
                        sz0 sz0Var2 = new sz0();
                        l01.b(sz0Var2, query);
                        if (sz0Var2.x() + pj0.b < currentTimeMillis) {
                            hashSet.add(sz0Var2.g());
                        } else {
                            jz0.b(arrayList, rj0.b(sz0Var2));
                        }
                    } while (query.moveToNext());
                    pi0.a(query);
                    if (hashSet.size() > 0) {
                        f(new a(this, hashSet), "remove_outdated_apk_data", 3);
                    }
                    return arrayList;
                }
                pi0.a(query);
                if (hashSet.size() > 0) {
                }
                return arrayList;
            } catch (Throwable th) {
                pi0.a(query);
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj0
    public void b(HashMap<String, yj0> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || lz0.c(hashMap)) {
            return;
        }
        f(new b(this, hashMap), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.tj0
    public void c(sz0 sz0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sz0Var) == null) || TextUtils.isEmpty(sz0Var.g())) {
            return;
        }
        f(new c(this, sz0Var), "update_apk_data", 3);
    }

    public final void f(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            v01.c(new e(this, runnable), str, i);
        }
    }

    @Override // com.baidu.tieba.tj0
    public void update(sz0 sz0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, sz0Var) == null) || TextUtils.isEmpty(sz0Var.g())) {
            return;
        }
        f(new d(this, sz0Var), "update_apk_data", 3);
    }

    public qj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        sj0 sj0Var = new sj0();
        sj0Var.getReadableDatabase();
        sj0Var.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(mi0.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new uj0(openDatabase);
    }
}
