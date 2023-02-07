package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.ef3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class z23 implements au2 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> e;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, SwanAppConfigData> c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z23 a;

        public a(z23 z23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z23Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.b();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (au2.a) {
                    Log.d("SwanPerformance", "async batch parse app.json cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(z23 z23Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z23Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final long b(@NonNull File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
                return file.lastModified();
            }
            return invokeL.longValue;
        }

        public /* synthetic */ b(z23 z23Var, a aVar) {
            this(z23Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                if (file == null) {
                    return 1;
                }
                if (file2 == null) {
                    return -1;
                }
                return (int) ((b(file) - b(file2)) * (-1));
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final z23 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-281758577, "Lcom/baidu/tieba/z23$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-281758577, "Lcom/baidu/tieba/z23$c;");
                    return;
                }
            }
            a = new z23(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308014, "Lcom/baidu/tieba/z23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308014, "Lcom/baidu/tieba/z23;");
                return;
            }
        }
        e = new HashSet();
    }

    public z23() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap<>();
        this.d = false;
        h();
    }

    public static z23 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.a;
        }
        return (z23) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.c;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                this.c.clear();
            }
            this.d = false;
            if (au2.a) {
                Log.d("SwanPerformance", "release app.json batch cache");
            }
        }
    }

    public /* synthetic */ z23(a aVar) {
        this();
    }

    public final void b() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File g = sr2.g();
            if (g.exists() && (listFiles = g.listFiles()) != null && listFiles.length != 0) {
                for (String str : e) {
                    c(new File(g, str));
                }
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
            e.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
            e.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
            e.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
            e.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
        }
    }

    public final void c(File file) {
        File d;
        SwanAppConfigData a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && file != null && file.exists() && file.isDirectory() && (d = d(file)) != null && (a2 = ot2.a(d)) != null) {
            this.c.put(d.getAbsolutePath(), a2);
        }
    }

    public final File d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            if (file != null && !file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    if (listFiles.length > 1) {
                        Arrays.sort(listFiles, new b(this, null));
                    }
                    return listFiles[0];
                }
                ef3.b bVar = new ef3.b(10012);
                bVar.h(file.getAbsolutePath());
                bVar.k("async parse swanApp");
                bVar.m();
                if (au2.a) {
                    Log.d("SwanPerformance", file.getAbsolutePath() + " is an empty folder");
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void g(String str) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str) && (concurrentHashMap = this.c) != null && !concurrentHashMap.isEmpty()) {
            Iterator<Map.Entry<String, SwanAppConfigData>> it = this.c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, SwanAppConfigData> next = it.next();
                if (next != null) {
                    String key = next.getKey();
                    if (!TextUtils.isEmpty(key) && key.contains(str)) {
                        this.c.remove(key);
                        break;
                    }
                }
            }
            if (au2.a) {
                Log.d("SwanPerformance", "release app.json appId = " + str);
            }
        }
    }

    @AnyThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.d) {
                if (au2.a) {
                    Log.d("SwanPerformance", "has batch parse app.json, size = " + this.c.size());
                    return;
                }
                return;
            }
            this.d = true;
            try {
                ql3.k(new a(this), "startAsyncBatchParseAppJson");
            } catch (Throwable th) {
                if (au2.a) {
                    Log.e("SwanPerformance", "batch parse app.json exception");
                    th.printStackTrace();
                }
            }
        }
    }

    public SwanAppConfigData j(File file) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String absolutePath = file.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = this.c.get(absolutePath);
            if (au2.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("try obtain config data success = ");
                if (swanAppConfigData != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.d("SwanPerformance", sb.toString());
            }
            return swanAppConfigData;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }
}
