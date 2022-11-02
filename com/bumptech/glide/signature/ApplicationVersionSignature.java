package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @VisibleForTesting
    public static void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            PACKAGE_NAME_TO_KEY.clear();
        }
    }

    @Nullable
    public static PackageInfo getPackageInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Cannot resolve info for" + context.getPackageName(), e);
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
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
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return obtainVersionSignature;
            }
            return key;
        }
        return (Key) invokeL.objValue;
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
    public static Key obtainVersionSignature(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return new ObjectKey(getVersionCode(getPackageInfo(context)));
        }
        return (Key) invokeL.objValue;
    }
}
