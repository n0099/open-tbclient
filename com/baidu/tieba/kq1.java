package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public class kq1 implements ss1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: com.baidu.tieba.kq1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0327a implements nm3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.kq1$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0328a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ File a;
                public final /* synthetic */ C0327a b;

                public RunnableC0328a(C0327a c0327a, File file) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0327a, file};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = c0327a;
                    this.a = file;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        gl3.a(this.b.c.a, this.a);
                    }
                }
            }

            public C0327a(a aVar, File file, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, file, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = file;
                this.b = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    try {
                        File file = new File(this.a, "report");
                        yn4.l(file);
                        kq1.e(file, this.b, str);
                        kq1.d(file);
                        File file2 = new File(this.a, "report.zip");
                        yn4.j(file2);
                        yn4.X(file.getAbsolutePath(), file2.getAbsolutePath());
                        yn4.L(file);
                        ol3.a0(new RunnableC0328a(this, file2));
                    } catch (Exception e) {
                        u42.b("DefaultSwanAppLogManager", Log.getStackTraceString(e));
                        m73.g(AppRuntime.getAppContext(), this.c.a.getString(R.string.obfuscated_res_0x7f0f1350)).G();
                    }
                }
            }
        }

        public a(kq1 kq1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                File a3 = f72.a3();
                if (a3 == null) {
                    u42.k("DefaultSwanAppLogManager", "cacheDir 为 null");
                } else if (!a3.exists() && !a3.mkdirs()) {
                    u42.k("DefaultSwanAppLogManager", "cacheDir 为不存在且创建目录失败：" + a3.getAbsolutePath());
                } else {
                    nk3.i(this.a, new C0327a(this, a3, nk3.l(this.a) + "===== 启动信息 =====\n"));
                }
            }
        }
    }

    public kq1() {
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

    @Override // com.baidu.tieba.ss1
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, context) != null) || context == null) {
            return;
        }
        ok3.k(new a(this, context), "log上报");
    }

    public static void d(File file) {
        File[] C;
        File[] C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, file) == null) {
            File file2 = new File(file, "swan");
            yn4.e(br2.p0().a(), file2);
            for (File file3 : yn4.C(file2)) {
                if (file3.isDirectory()) {
                    for (File file4 : yn4.C(file3)) {
                        if (file4 != null && file4.isFile() && !file4.getName().endsWith(".log")) {
                            yn4.L(file4);
                        }
                    }
                }
            }
        }
    }

    public static void e(File file, String str, String str2) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, str, str2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String g = ik3.g(currentTimeMillis, "yyyyMMdd");
            File file2 = new File(file, "runninginfo_" + g + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION);
            String g2 = ik3.g(currentTimeMillis, "yyyy-MM-dd HH:mm:ss");
            PrintWriter printWriter = new PrintWriter(file2);
            printWriter.println(g2 + "\n" + str + str2);
            printWriter.flush();
            printWriter.close();
        }
    }
}
