package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes9.dex */
public final class ApplicationVersionSignature {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY;
    public static final String TAG = "AppVersionSignature";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1535645013, "Lcom/bumptech/glide/signature/ApplicationVersionSignature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1535645013, "Lcom/bumptech/glide/signature/ApplicationVersionSignature;");
                return;
            }
        }
        PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }

    public ApplicationVersionSignature() {
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

    @Nullable
    public static PackageInfo getPackageInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                String str = "Cannot resolve info for" + context.getPackageName();
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    @NonNull
    public static String getVersionCode(@Nullable PackageInfo packageInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, packageInfo)) == null) {
            if (packageInfo != null) {
                return String.valueOf(packageInfo.versionCode);
            }
            return UUID.randomUUID().toString();
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static Key obtain(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String packageName = context.getPackageName();
            Key key = PACKAGE_NAME_TO_KEY.get(packageName);
            if (key == null) {
                Key obtainVersionSignature = obtainVersionSignature(context);
                Key putIfAbsent = PACKAGE_NAME_TO_KEY.putIfAbsent(packageName, obtainVersionSignature);
                return putIfAbsent == null ? obtainVersionSignature : putIfAbsent;
            }
            return key;
        }
        return (Key) invokeL.objValue;
    }

    @NonNull
    public static Key obtainVersionSignature(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? new ObjectKey(getVersionCode(getPackageInfo(context))) : (Key) invokeL.objValue;
    }

    @VisibleForTesting
    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            PACKAGE_NAME_TO_KEY.clear();
        }
    }
}
