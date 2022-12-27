package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.ee9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes7.dex */
public class BuildInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @CalledByNative
    public static String getGMSVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? "gms versionCode not available." : (String) invokeL.objValue;
    }

    public BuildInfo() {
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

    @CalledByNative
    public static String getAndroidBuildFingerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.FINGERPRINT;
            return str.substring(0, Math.min(str.length(), 128));
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getAndroidBuildId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Build.ID;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Build.BRAND;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getBuildType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return Build.TYPE;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return Build.DEVICE;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDeviceManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return Build.MANUFACTURER;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return Build.MODEL;
        }
        return (String) invokeV.objValue;
    }

    @CalledByNative
    public static int getSdkInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public static String getPackageLabel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String str = "";
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                PackageManager packageManager = context.getPackageManager();
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
                if (applicationLabel != null) {
                    str = applicationLabel.toString();
                }
                return str;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getPackageVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo.versionCode <= 0) {
                    return "";
                }
                return Integer.toString(packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                ee9.a("BuildInfo", "versionCode not available.");
                return "versionCode not available.";
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getPackageVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo.versionName == null) {
                    return "";
                }
                return packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                ee9.a("BuildInfo", "versionName not available");
                return "versionName not available";
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context != null) {
                str = context.getPackageName();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
