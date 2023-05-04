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
/* loaded from: classes6.dex */
public class sj0 implements vj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a21 a;

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static vj0 a;
        public static final vj0 b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class a implements vj0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            @Override // com.baidu.tieba.vj0
            public void b(HashMap<String, ak0> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.tieba.vj0
            public void c(m11 m11Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m11Var) == null) {
                }
            }

            @Override // com.baidu.tieba.vj0
            public void update(m11 m11Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, m11Var) == null) {
                }
            }

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
                    hashMap.put("v", "5.11.0.5");
                    hashMap.put("e", this.a.toString());
                    o11.b(new ClogBuilder().y(ClogBuilder.LogType.CHECK).k("12").l("4000").m(new JSONObject(hashMap).toString()));
                }
            }

            @Override // com.baidu.tieba.vj0
            public List<ak0> a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new ArrayList();
                }
                return (List) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-430534738, "Lcom/baidu/tieba/sj0$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-430534738, "Lcom/baidu/tieba/sj0$f;");
                    return;
                }
            }
            try {
                if (o41.b()) {
                    a = new sj0(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            b = a;
        }

        public static vj0 b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
                return new a(th);
            }
            return (vj0) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ sj0 b;

        public a(sj0 sj0Var, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj0Var, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sj0Var;
            this.a = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (String str : this.a) {
                        m11 m11Var = new m11();
                        m11Var.o(str);
                        this.b.a.delete(m11Var, new y11[0]);
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ sj0 b;

        public b(sj0 sj0Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj0Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sj0Var;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.a.entrySet()) {
                        ak0 ak0Var = (ak0) entry.getValue();
                        if (ak0Var != null) {
                            m11 a = tj0.a(ak0Var);
                            if (!TextUtils.isEmpty(a.g())) {
                                this.b.a.a(a, new y11[0]);
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m11 a;
        public final /* synthetic */ sj0 b;

        public c(sj0 sj0Var, m11 m11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj0Var, m11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sj0Var;
            this.a = m11Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.a(this.a, new y11[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m11 a;
        public final /* synthetic */ sj0 b;

        public d(sj0 sj0Var, m11 m11Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj0Var, m11Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sj0Var;
            this.a = m11Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.update(this.a, new y11[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public e(sj0 sj0Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sj0Var, runnable};
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
                    if (!wf0.a) {
                        Log.d("AdDownloadDBHelper", "wrapExecutor", th);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    public sj0() {
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
        uj0 uj0Var = new uj0();
        uj0Var.getReadableDatabase();
        uj0Var.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(li0.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new wj0(openDatabase);
    }

    public /* synthetic */ sj0(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.vj0
    public void b(HashMap<String, ak0> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) != null) || a11.c(hashMap)) {
            return;
        }
        f(new b(this, hashMap), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.vj0
    public void c(m11 m11Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m11Var) != null) || TextUtils.isEmpty(m11Var.g())) {
            return;
        }
        f(new c(this, m11Var), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.vj0
    public void update(m11 m11Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, m11Var) != null) || TextUtils.isEmpty(m11Var.g())) {
            return;
        }
        f(new d(this, m11Var), "update_apk_data", 3);
    }

    public static vj0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f.b;
        }
        return (vj0) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.baidu.tieba.vj0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ak0> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            m11 m11Var = new m11();
            m21 e2 = m21.e();
            e2.a("o", m11Var.b().d());
            e2.c("o", m11Var);
            HashSet hashSet = new HashSet();
            Cursor query = this.a.query(e2);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (query.moveToFirst()) {
                    do {
                        m11 m11Var2 = new m11();
                        f21.b(m11Var2, query);
                        if (m11Var2.x() + rj0.b < currentTimeMillis) {
                            hashSet.add(m11Var2.g());
                        } else {
                            y01.b(arrayList, tj0.b(m11Var2));
                        }
                    } while (query.moveToNext());
                    oi0.a(query);
                    if (hashSet.size() > 0) {
                        f(new a(this, hashSet), "remove_outdated_apk_data", 3);
                    }
                    return arrayList;
                }
                oi0.a(query);
                if (hashSet.size() > 0) {
                }
                return arrayList;
            } catch (Throwable th) {
                oi0.a(query);
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public final void f(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            p21.c(new e(this, runnable), str, i);
        }
    }
}
