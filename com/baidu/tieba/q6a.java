package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes5.dex */
public class q6a {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public static final SimpleDateFormat b;
    public static final SimpleDateFormat c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                File[] f = n6a.f();
                if (f != null && f.length > 0) {
                    synchronized (q6a.a) {
                        for (File file : f) {
                            if (currentTimeMillis - file.lastModified() > 172800000) {
                                file.delete();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045165, "Lcom/baidu/tieba/q6a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045165, "Lcom/baidu/tieba/q6a;");
                return;
            }
        }
        a = new Object();
        b = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);
        c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            p6a.b().post(new a());
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (a) {
                d = d("looper", str);
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String str3 = "";
            BufferedWriter bufferedWriter = null;
            try {
                File c2 = n6a.c();
                long currentTimeMillis = System.currentTimeMillis();
                str3 = c2.getAbsolutePath() + "/" + str + "-" + b.format(Long.valueOf(currentTimeMillis)) + ".log";
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
                try {
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write("**********************");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write(c.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.write(str2);
                    bufferedWriter2.write("\r\n");
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    try {
                        Log.e("LogWriter", "save: ", th);
                        return str3;
                    } finally {
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e) {
                                Log.e("LogWriter", "save: ", e);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }
}
