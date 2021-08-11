package com.baidu.wallet.core.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class PermissionsUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PermissionsUtil";
    public static HashMap<String, PermissionListener> listenerMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1436243763, "Lcom/baidu/wallet/core/permission/PermissionsUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1436243763, "Lcom/baidu/wallet/core/permission/PermissionsUtil;");
                return;
            }
        }
        listenerMap = new HashMap<>();
    }

    public PermissionsUtil() {
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

    public static PermissionListener fetchListener(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? listenerMap.remove(str) : (PermissionListener) invokeL.objValue;
    }

    public static void gotoSetting(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    public static boolean hasPermission(@NonNull Context context, @NonNull String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            if (strArr.length == 0) {
                return false;
            }
            for (String str : strArr) {
                if (!PermissionManager.checkCallingPermission(context, str)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isGranted(@NonNull int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iArr)) == null) {
            if (iArr.length == 0) {
                return false;
            }
            for (int i2 : iArr) {
                if (i2 != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void requestPermission(@NonNull Context context, @NonNull PermissionListener permissionListener, @NonNull String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, permissionListener, strArr) == null) || permissionListener == null || strArr == null || strArr.length == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            permissionListener.permissionGranted(Arrays.asList(strArr));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!hasPermission(context, strArr[i2])) {
                arrayList.add(strArr[i2]);
            }
        }
        if (arrayList.size() == 0) {
            permissionListener.permissionGranted(Arrays.asList(strArr));
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        listenerMap.put(valueOf, permissionListener);
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("permission", (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra("key", valueOf);
        intent.addFlags(268435456);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }
}
