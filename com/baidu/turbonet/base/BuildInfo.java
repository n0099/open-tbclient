package com.baidu.turbonet.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.StrictMode;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.repackage.b39;
/* loaded from: classes4.dex */
public class BuildInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.ID : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Build.BRAND : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getBuildType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.TYPE : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDevice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? Build.DEVICE : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDeviceManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Build.MANUFACTURER : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getDeviceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    @CalledByNative
    public static String getGMSVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? "gms versionCode not available." : (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getPackageLabel(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                PackageManager packageManager = context.getPackageManager();
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
                return applicationLabel != null ? applicationLabel.toString() : "";
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String packageName = context != null ? context.getPackageName() : null;
            return packageName != null ? packageName : "";
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
                return packageInfo.versionCode > 0 ? Integer.toString(packageInfo.versionCode) : "";
            } catch (PackageManager.NameNotFoundException unused) {
                b39.a("BuildInfo", "versionCode not available.");
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
                return packageInfo.versionName != null ? packageInfo.versionName : "";
            } catch (PackageManager.NameNotFoundException unused) {
                b39.a("BuildInfo", "versionName not available");
                return "versionName not available";
            }
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static int getSdkInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }
}
