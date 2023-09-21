package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class y04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (context.getPackageManager() == null) {
                    return false;
                }
                context.getPackageManager().getPackageInfo(str, 0);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return b(AppRuntime.getAppContext(), new File(str), z);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static boolean b(Context context, File file, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, context, file, z)) == null) {
            if (context != null && file != null && file.isFile() && file.exists()) {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                try {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(1342177280);
                    intent.putExtra(ApkUtil.KEY_INSTALLER_PACKAGE_NAME, context.getPackageName());
                    if (z) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (!z04.m()) {
                        intent.setComponent(new ComponentName(ApkUtil.PACKAGE_INSTALLER, ApkUtil.PACKAGE_INSTALLER_ACTIVITY));
                    }
                    e(context, file, intent);
                    context.startActivity(intent);
                } catch (Exception unused) {
                    intent.setComponent(null);
                    e(context, file, intent);
                    try {
                        context.startActivity(intent);
                    } catch (Exception unused2) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static String d(Context context, @NonNull String str) {
        InterceptResult invokeLL;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) != null) {
                return packageArchiveInfo.packageName;
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean e(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        ActivityInfo activityInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, file, intent)) == null) {
            if (z04.m()) {
                try {
                    Uri l = yz3.b().l(context, file);
                    if (l == null) {
                        return false;
                    }
                    intent.setDataAndType(l, intent.getType());
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities == null) {
                        return true;
                    }
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                            context.grantUriPermission(str, l, 1);
                        }
                    }
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
