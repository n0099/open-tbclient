package com.baidu.vi;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes8.dex */
public class VDeviceAPI {
    public static /* synthetic */ Interceptable $ic;
    public static PowerManager.WakeLock a;
    public static BroadcastReceiver b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-874432769, "Lcom/baidu/vi/VDeviceAPI;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-874432769, "Lcom/baidu/vi/VDeviceAPI;");
        }
    }

    public static String getCellId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String getImei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getLac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? "" : (String) invokeV.objValue;
    }

    public static String getOsVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? "android" : (String) invokeV.objValue;
    }

    @Deprecated
    public static int getTelecomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public static ScanResult[] getWifiHotpot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return null;
        }
        return (ScanResult[]) invokeV.objValue;
    }

    public static void makeCall(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, str) == null) {
        }
    }

    public static native void onNetworkStateChanged();

    public static int sendMMS(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65567, null, str, str2, str3, str4)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }

    public static void sendSMS(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, str, str2) == null) {
        }
    }

    public static void setScreenAlwaysOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, null, z) == null) {
        }
    }

    public VDeviceAPI() {
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

    public static String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return VIContext.getContext().getPackageManager().getPackageInfo(VIContext.getContext().getApplicationInfo().packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static long getAvailableMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) VIContext.getContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeV.longValue;
    }

    public static String getCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Environment.getDataDirectory().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return SyncSysInfo.getCid();
        }
        return (String) invokeV.objValue;
    }

    public static int getCurrentNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                return Integer.parseInt(NetworkUtil.getCurrentNetMode(VIContext.getContext()));
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static long getFreeSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
        }
        return invokeV.longValue;
    }

    public static String getImsi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) VIContext.getContext().getSystemService("phone");
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static String getModuleFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return VIContext.getContext().getFilesDir().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static long getSdcardFreeSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
        }
        return invokeV.longValue;
    }

    public static String getSdcardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return SysOSUtil.getInstance().getCompatibleSdcardPath();
        }
        return (String) invokeV.objValue;
    }

    public static long getSdcardTotalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
        }
        return invokeV.longValue;
    }

    public static long getTotalSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
        }
        return invokeV.longValue;
    }

    public static boolean isWifiConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            NetworkInfo networkInfo = ((ConnectivityManager) VIContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void setNetworkChangedCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            unsetNetworkChangedCallback();
            b = new e();
            VIContext.getContext().registerReceiver(b, new IntentFilter(NetworkMonitor.NET_CHANGE_ACTION));
        }
    }

    public static void unsetNetworkChangedCallback() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65572, null) == null) && b != null) {
            VIContext.getContext().unregisterReceiver(b);
            b = null;
        }
    }

    public static VNetworkInfo getNetworkInfo(int i) {
        InterceptResult invokeI;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) VIContext.getContext().getSystemService("connectivity");
            if (i != 2) {
                if (i != 3) {
                    networkInfo = null;
                } else {
                    networkInfo = connectivityManager.getNetworkInfo(0);
                }
            } else {
                networkInfo = connectivityManager.getNetworkInfo(1);
            }
            if (networkInfo == null) {
                return null;
            }
            return new VNetworkInfo(networkInfo);
        }
        return (VNetworkInfo) invokeI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getScreenBrightness() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            ContentResolver contentResolver = VIContext.getContext().getContentResolver();
            if (8 <= Build.VERSION.SDK_INT) {
                try {
                    i = Settings.System.getInt(contentResolver, "screen_brightness_mode");
                } catch (Exception unused) {
                }
                if (i != 1) {
                    return -1;
                }
                try {
                    return Settings.System.getInt(contentResolver, "screen_brightness");
                } catch (Settings.SettingNotFoundException unused2) {
                    return -1;
                }
            }
            i = 0;
            if (i != 1) {
            }
        } else {
            return invokeV.intValue;
        }
    }

    public static float getScreenDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (VIContext.getContext() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.density;
        }
        return invokeV.floatValue;
    }

    public static int getScreenDensityDpi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (VIContext.getContext() == null) {
                return 0;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.densityDpi;
        }
        return invokeV.intValue;
    }

    public static float getSystemMetricsX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (VIContext.getContext() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.widthPixels;
        }
        return invokeV.floatValue;
    }

    public static float getSystemMetricsY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (VIContext.getContext() == null) {
                return 0.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) VIContext.getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }
        return invokeV.floatValue;
    }

    public static long getTotalMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            long j = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = Integer.valueOf(readLine.split("\\s+")[1]).intValue();
                }
                bufferedReader.close();
            } catch (IOException unused) {
            }
            return j;
        }
        return invokeV.longValue;
    }

    public static void openUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, str) == null) {
            VIContext.getContext().startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
        }
    }

    public static void setupSoftware(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, str) == null) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            VIContext.getContext().startActivity(intent);
        }
    }
}
