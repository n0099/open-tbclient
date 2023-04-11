package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class r72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ File b;

        public a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (r72.class) {
                    yn4.S(this.a, this.b, true);
                }
                r72.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Comparator<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l, Long l2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l, l2)) == null) {
                return l2.compareTo(l);
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074460, "Lcom/baidu/tieba/r72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074460, "Lcom/baidu/tieba/r72;");
                return;
            }
        }
        a = eo1.a;
    }

    public r72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static File b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            String f = f();
            if (f == null) {
                return null;
            }
            File file = new File(f + File.separator + j);
            if (file.exists()) {
                yn4.L(file);
            }
            yn4.h(file);
            return file;
        }
        return (File) invokeJ.objValue;
    }

    public static long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try {
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
                if (parse == null) {
                    return -1L;
                }
                return parse.getTime();
            } catch (ParseException e) {
                if (eo1.a) {
                    e.printStackTrace();
                }
                return -1L;
            }
        }
        return invokeJ.longValue;
    }

    public static void c() {
        u73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || (b0 = u73.b0()) == null || TextUtils.isEmpty(b0.getAppId())) {
            return;
        }
        File file = new File(qq2.g().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            yn4.j(file);
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            u73 b0 = u73.b0();
            if (b0 == null) {
                return null;
            }
            String appId = b0.getAppId();
            if (TextUtils.isEmpty(appId)) {
                return null;
            }
            return qq2.g().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
        }
        return (String) invokeV.objValue;
    }

    public static File d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            File[] g = g();
            if (g != null && g.length != 0) {
                File file = null;
                for (File file2 : g) {
                    try {
                        long parseLong = Long.parseLong(file2.getName());
                        if (parseLong == j) {
                            file = file2;
                        } else if (j - parseLong >= 259200000) {
                            yn4.j(file2);
                        }
                    } catch (NumberFormatException unused) {
                        yn4.j(file2);
                    }
                }
                if (file == null) {
                    return b(j);
                }
                return file;
            }
            return b(j);
        }
        return (File) invokeJ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            File[] g = g();
            if (g == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap(new b());
            long i = i(System.currentTimeMillis());
            for (File file : g) {
                try {
                    long parseLong = Long.parseLong(file.getName());
                    if (i - parseLong >= 259200000) {
                        yn4.j(file);
                    } else {
                        List<String> F = yn4.F(file);
                        if (F != null && F.size() > 0) {
                            treeMap.put(Long.valueOf(parseLong), F);
                        }
                    }
                } catch (NumberFormatException unused) {
                    yn4.j(file);
                }
            }
            if (treeMap.size() == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder("\n（二）历史日志");
            for (Map.Entry entry : treeMap.entrySet()) {
                sb.append("\n----------【");
                sb.append(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(((Long) entry.getKey()).longValue())));
                sb.append("】----------");
                for (String str : (List) entry.getValue()) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("\n");
                        sb.append(str);
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String f = f();
            if (f == null) {
                return null;
            }
            File file = new File(f);
            if (!file.exists() || !file.isDirectory()) {
                return null;
            }
            return file.listFiles();
        }
        return (File[]) invokeV.objValue;
    }

    public static void h(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65545, null, j, str) == null) {
            long i = i(j);
            if (i == -1) {
                if (a) {
                    Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                    return;
                }
                return;
            }
            File d = d(i);
            if (d != null && d.exists()) {
                ok3.k(new a(str, d), "saveLaunchTipsLog");
            }
        }
    }
}
