package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.mh3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ mm3 c;

        public a(int i, long j, mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = mm3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jk3.f(jSONObject, gz2.c(), this.a, this.b);
                } catch (Exception e) {
                    tk3.f(jSONObject, "errorMsg", e.getMessage());
                }
                this.c.a(jSONObject);
            }
        }
    }

    public jk3() {
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

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                synchronized (jk3.class) {
                    a = e();
                }
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            return new DecimalFormat("#.##").format(j / 1.073741824E9d);
        }
        return (String) invokeJ.objValue;
    }

    public static void d(@NonNull qs2 qs2Var, @NonNull mm3<JSONObject> mm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qs2Var, mm3Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(qs2Var.i("host_launch_type"), qs2Var.k("box_cold_launch"), mm3Var), "getDeviceInfoAsync", 2);
        }
    }

    public static String e() {
        InterceptResult invokeV;
        String replace;
        String replace2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = Build.MODEL;
            String str2 = "NUL";
            if (TextUtils.isEmpty(str)) {
                replace = "NUL";
            } else {
                replace = str.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str3)) {
                replace2 = "0.0";
            } else {
                replace2 = str3.replace("_", "-");
            }
            int i = Build.VERSION.SDK_INT;
            String str4 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str4)) {
                str2 = str4.replace("_", "-");
            }
            return replace + "_" + replace2 + "_" + i + "_" + str2;
        }
        return (String) invokeV.objValue;
    }

    public static void f(@NonNull JSONObject jSONObject, int i, int i2, long j) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            tk3.f(jSONObject, "model", Build.MODEL);
            tk3.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            tk3.f(jSONObject, "netStatus", Integer.valueOf(i));
            mh3.a a2 = mh3.a(ar2.c());
            if (a2 == null) {
                i3 = -1;
            } else {
                i3 = a2.a;
            }
            tk3.f(jSONObject, "batteryLevel", Integer.valueOf(i3));
            tk3.f(jSONObject, "appCurVersion", nl3.D());
            tk3.f(jSONObject, "startupType", String.valueOf(i2));
            tk3.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(pq2.i());
            tk3.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            tk3.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) s73.K().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                tk3.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                tk3.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                if (memoryInfo.lowMemory) {
                    str = "1";
                } else {
                    str = "0";
                }
                tk3.f(jSONObject, "lowMemory", str);
            }
        }
    }
}
