package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.yd3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class vg3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ yi3 c;

        public a(int i, long j, yi3 yi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), yi3Var};
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
            this.c = yi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    vg3.f(jSONObject, sv2.c(), this.a, this.b);
                } catch (Exception e) {
                    fh3.f(jSONObject, "errorMsg", e.getMessage());
                }
                this.c.a(jSONObject);
            }
        }
    }

    public vg3() {
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
                synchronized (vg3.class) {
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

    public static void d(@NonNull cp2 cp2Var, @NonNull yi3<JSONObject> yi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cp2Var, yi3Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(cp2Var.i("host_launch_type"), cp2Var.k("box_cold_launch"), yi3Var), "getDeviceInfoAsync", 2);
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
            fh3.f(jSONObject, "model", Build.MODEL);
            fh3.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            fh3.f(jSONObject, "netStatus", Integer.valueOf(i));
            yd3.a a2 = yd3.a(mn2.c());
            if (a2 == null) {
                i3 = -1;
            } else {
                i3 = a2.a;
            }
            fh3.f(jSONObject, "batteryLevel", Integer.valueOf(i3));
            fh3.f(jSONObject, "appCurVersion", zh3.D());
            fh3.f(jSONObject, "startupType", String.valueOf(i2));
            fh3.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(bn2.i());
            fh3.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            fh3.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) e43.K().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                fh3.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                fh3.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                if (memoryInfo.lowMemory) {
                    str = "1";
                } else {
                    str = "0";
                }
                fh3.f(jSONObject, "lowMemory", str);
            }
        }
    }
}
