package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes8.dex */
public class ra0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile int a = -1;
    public static volatile String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948114760, "Lcom/baidu/tieba/ra0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948114760, "Lcom/baidu/tieba/ra0;");
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    String path = Environment.getExternalStorageDirectory().getPath();
                    if (path == null || path.length() <= 0) {
                        oa0.d(Utils.TAG, "External path is null, so SDCard no free space");
                        return -1L;
                    }
                    StatFs statFs = new StatFs(path);
                    return statFs.getBlockSize() * statFs.getAvailableBlocks();
                }
                return -1L;
            } catch (Exception unused) {
                oa0.d(Utils.TAG, "SDCard no free space");
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = null;
            try {
                if (e(context)) {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                } else if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
                    str = context.getExternalCacheDir().getPath();
                }
            } catch (Exception unused) {
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = null;
            if (context == null) {
                oa0.e(Utils.TAG, "getVideoStatisticsPath ctx = null");
                return null;
            }
            String b2 = b(context);
            if (!TextUtils.isEmpty(b2)) {
                str = b2 + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "video_statistic" + File.separator + "duplayer" + File.separator + context.getPackageName();
            }
            String str2 = context.getFilesDir().getAbsolutePath() + File.separator + ".video_statistic" + File.separator + "duplayer";
            oa0.c(Utils.TAG, "Utils.getExternalStorageSpace():" + a());
            if (a() < Config.FULL_TRACE_LOG_LIMIT || str == null) {
                str = str2;
            }
            new File(str).mkdirs();
            if (!f()) {
                str = str + File.separator + com.baidu.mobads.sdk.internal.cl.b;
            }
            oa0.c(Utils.TAG, "getVideoStatisticsPath folder:" + str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                b = g();
                if (TextUtils.isEmpty(b)) {
                    b = h();
                }
                return b;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    if (packageManager.checkPermission(com.kuaishou.weapon.p0.h.i, context.getPackageName()) == 0) {
                        return packageManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a < 0) {
                Context a2 = ma0.a();
                if (a2 == null || a2.getPackageName().equals(d())) {
                    a = 1;
                } else {
                    a = 0;
                }
            }
            return a == 1;
        }
        return invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int myPid = Process.myPid();
            try {
                ActivityManager activityManager = (ActivityManager) ma0.a().getSystemService("activity");
                if (activityManager != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                        if (runningAppProcessInfo.pid == myPid) {
                            return runningAppProcessInfo.processName;
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, null)) != null) {
            return (String) invokeV.objValue;
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
