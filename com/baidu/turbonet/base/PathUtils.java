package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public abstract class PathUtils {
    public static /* synthetic */ Interceptable $ic;
    public static AsyncTask<Void, Void, String[]> a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f51833b;

    /* renamed from: c  reason: collision with root package name */
    public static String f51834c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes12.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1717421294, "Lcom/baidu/turbonet/base/PathUtils$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1717421294, "Lcom/baidu/turbonet/base/PathUtils$a;");
                    return;
                }
            }
            a = PathUtils.c();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(278881803, "Lcom/baidu/turbonet/base/PathUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(278881803, "Lcom/baidu/turbonet/base/PathUtils;");
                return;
            }
        }
        new AtomicBoolean();
    }

    public PathUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? a.a[i2] : (String) invokeI.objValue;
    }

    public static String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (a.cancel(false)) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    StrictMode.allowThreadDiskWrites();
                    String[] d2 = d();
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    return d2;
                }
                return a.get();
            } catch (InterruptedException | ExecutionException unused) {
                return null;
            }
        }
        return (String[]) invokeV.objValue;
    }

    public static String[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String[] strArr = new String[4];
            strArr[0] = f51833b.getDir(f51834c, 0).getPath();
            strArr[1] = f51833b.getDir("textures", 0).getPath();
            strArr[2] = f51833b.getDatabasePath("foo").getParent();
            if (f51833b.getCacheDir() != null) {
                strArr[3] = f51833b.getCacheDir().getPath();
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    @CalledByNative
    public static String getCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? b(3) : (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getDataDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? b(0) : (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getDatabaseDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? b(2) : (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getDownloadsDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                SystemClock.elapsedRealtime();
                return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Environment.getExternalStorageDirectory().getAbsolutePath() : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getNativeLibraryDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.flags;
            return ((i2 & 128) != 0 || (i2 & 1) == 0) ? applicationInfo.nativeLibraryDir : "/system/lib/";
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? b(1) : (String) invokeL.objValue;
    }
}
