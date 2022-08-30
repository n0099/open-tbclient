package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.q01;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class rj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) ? (file == null || TextUtils.isEmpty(file.getPath()) || (packageManager = eh0.b().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 1)) == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) ? "" : applicationInfo.packageName : (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                eh0.b().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) ? d(file, false) : invokeL.booleanValue;
    }

    public static boolean d(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, file, z)) == null) {
            if (e(file)) {
                Context b = eh0.b();
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(1342177280);
                    intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", b.getPackageName());
                    if (z) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (!q01.b.e()) {
                        intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
                    }
                    k01.a(b, file, intent);
                    k01.d(b, intent);
                } catch (Exception unused) {
                    intent.setComponent(null);
                    k01.a(b, file, intent);
                    try {
                        b.startActivity(intent);
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean e(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) ? (file == null || TextUtils.isEmpty(file.getAbsolutePath()) || !file.exists() || (packageManager = eh0.b().getPackageManager()) == null || packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 1) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = eh0.b().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return false;
            }
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return k01.e(eh0.b(), intent2, true);
        }
        return invokeL.booleanValue;
    }
}
