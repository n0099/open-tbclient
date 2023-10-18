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
/* loaded from: classes8.dex */
public class wf0 implements zf0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vy0 a;

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static zf0 a;
        public static final zf0 b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements zf0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            @Override // com.baidu.tieba.zf0
            public void b(hy0 hy0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hy0Var) == null) {
                }
            }

            @Override // com.baidu.tieba.zf0
            public void c(HashMap<String, eg0> hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                }
            }

            @Override // com.baidu.tieba.zf0
            public void d(hy0 hy0Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, hy0Var) == null) {
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
                    hashMap.put("v", "5.12.0.110");
                    hashMap.put("e", this.a.toString());
                    jy0.e(new ClogBuilder().y(ClogBuilder.LogType.CHECK).k("12").l("4000").m(new JSONObject(hashMap).toString()));
                }
            }

            @Override // com.baidu.tieba.zf0
            public List<eg0> a() {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-319712218, "Lcom/baidu/tieba/wf0$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-319712218, "Lcom/baidu/tieba/wf0$f;");
                    return;
                }
            }
            try {
                if (p11.b()) {
                    a = new wf0(null);
                } else {
                    a = b(null);
                }
            } catch (Throwable th) {
                a = b(th);
            }
            b = a;
        }

        public static zf0 b(Throwable th) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
                return new a(th);
            }
            return (zf0) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ wf0 b;

        public a(wf0 wf0Var, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf0Var, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wf0Var;
            this.a = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (String str : this.a) {
                        hy0 hy0Var = new hy0();
                        hy0Var.o(str);
                        this.b.a.e(hy0Var, new ty0[0]);
                    }
                    this.b.a.setTransactionSuccessful();
                } finally {
                    this.b.a.endTransaction();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ wf0 b;

        public b(wf0 wf0Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf0Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wf0Var;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.beginTransaction();
                try {
                    for (Map.Entry entry : this.a.entrySet()) {
                        eg0 eg0Var = (eg0) entry.getValue();
                        if (eg0Var != null) {
                            hy0 a = xf0.a(eg0Var);
                            if (!TextUtils.isEmpty(a.g())) {
                                this.b.a.a(a, new ty0[0]);
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

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy0 a;
        public final /* synthetic */ wf0 b;

        public c(wf0 wf0Var, hy0 hy0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf0Var, hy0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wf0Var;
            this.a = hy0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.a(this.a, new ty0[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy0 a;
        public final /* synthetic */ wf0 b;

        public d(wf0 wf0Var, hy0 hy0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf0Var, hy0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wf0Var;
            this.a = hy0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.f(this.a, new ty0[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;

        public e(wf0 wf0Var, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wf0Var, runnable};
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
                    if (!yb0.a) {
                        Log.d("AdDownloadDBHelper", "wrapExecutor", th);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    public wf0() {
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
        yf0 yf0Var = new yf0();
        yf0Var.getReadableDatabase();
        yf0Var.close();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(pe0.b().getDatabasePath("nad.core.download.db").getPath(), null, 0);
        openDatabase.setLocale(Locale.US);
        this.a = new ag0(openDatabase);
    }

    public /* synthetic */ wf0(a aVar) {
        this();
    }

    @Override // com.baidu.tieba.zf0
    public void b(hy0 hy0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hy0Var) != null) || TextUtils.isEmpty(hy0Var.g())) {
            return;
        }
        g(new d(this, hy0Var), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.zf0
    public void c(HashMap<String, eg0> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) != null) || vx0.c(hashMap)) {
            return;
        }
        g(new b(this, hashMap), "update_apk_data", 3);
    }

    @Override // com.baidu.tieba.zf0
    public void d(hy0 hy0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, hy0Var) != null) || TextUtils.isEmpty(hy0Var.g())) {
            return;
        }
        g(new c(this, hy0Var), "update_apk_data", 3);
    }

    public static zf0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return f.b;
        }
        return (zf0) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.baidu.tieba.zf0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<eg0> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            hy0 hy0Var = new hy0();
            hz0 f2 = hz0.f();
            f2.a("o", hy0Var.b().d());
            f2.c("o", hy0Var);
            HashSet hashSet = new HashSet();
            Cursor d2 = this.a.d(f2);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (d2.moveToFirst()) {
                    do {
                        hy0 hy0Var2 = new hy0();
                        az0.b(hy0Var2, d2);
                        if (hy0Var2.x() + vf0.b < currentTimeMillis) {
                            hashSet.add(hy0Var2.g());
                        } else {
                            tx0.b(arrayList, xf0.b(hy0Var2));
                        }
                    } while (d2.moveToNext());
                    se0.a(d2);
                    if (hashSet.size() > 0) {
                        g(new a(this, hashSet), "remove_outdated_apk_data", 3);
                    }
                    return arrayList;
                }
                se0.a(d2);
                if (hashSet.size() > 0) {
                }
                return arrayList;
            } catch (Throwable th) {
                se0.a(d2);
                throw th;
            }
        }
        return (List) invokeV.objValue;
    }

    public final void g(@NonNull Runnable runnable, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, runnable, str, i) == null) {
            kz0.c(new e(this, runnable), str, i);
        }
    }
}
