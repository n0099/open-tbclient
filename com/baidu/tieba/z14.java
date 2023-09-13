package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.swan.game.guide.install.InstallActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes9.dex */
public class z14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948307084, "Lcom/baidu/tieba/z14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948307084, "Lcom/baidu/tieba/z14;");
                return;
            }
        }
        a = rr1.a;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return vj3.a().getLong("install_authorize_guide_time_key", 0L);
        }
        return invokeV.longValue;
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return vj3.a().getLong("install_continue_guide_time_key", 0L);
        }
        return invokeV.longValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && !AppRuntime.getAppContext().getPackageManager().canRequestPackageInstalls()) {
                return "authorize";
            }
            return "continue";
        }
        return (String) invokeV.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return vj3.a().getInt("install_guide_count_key", 0);
        }
        return invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return vj3.a().getInt("install_guide_max_count_key", 3);
        }
        return invokeV.intValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return vj3.a().getBoolean("install_guide_switch_key", false);
        }
        return invokeV.booleanValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            vj3.a().edit().putLong("install_authorize_guide_time_key", System.currentTimeMillis()).apply();
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            vj3.a().edit().putLong("install_continue_guide_time_key", System.currentTimeMillis()).apply();
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            vj3.a().edit().putInt("install_guide_count_key", vj3.a().getInt("install_guide_count_key", 0) + 1).apply();
        }
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (context.getPackageManager() == null) {
                    return false;
                }
                if (context.getPackageManager().getPackageInfo(str, 0) == null) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, File file, boolean z) {
        InterceptResult invokeLLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, context, file, z)) == null) {
            if (context != null && file != null && file.isFile() && file.exists()) {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
                if (a) {
                    Log.e("GameCenterApkUtil", "install apk start");
                }
                try {
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(1342177280);
                    intent.putExtra(ApkUtil.KEY_INSTALLER_PACKAGE_NAME, context.getPackageName());
                    if (z) {
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                    }
                    if (Build.VERSION.SDK_INT < 24) {
                        intent.setComponent(new ComponentName(ApkUtil.PACKAGE_INSTALLER, ApkUtil.PACKAGE_INSTALLER_ACTIVITY));
                    }
                    m(context, file, intent);
                    if ((context instanceof Activity) && g14.o.D()) {
                        intent.setAction("android.intent.action.INSTALL_PACKAGE");
                        intent.setFlags(0);
                        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                        if (Build.VERSION.SDK_INT >= 24) {
                            intent.addFlags(1);
                        }
                        if (context instanceof InstallActivity) {
                            i = 1345431;
                        } else {
                            i = 0;
                        }
                        ((Activity) context).startActivityForResult(intent, i);
                    } else {
                        context.startActivity(intent);
                    }
                    if (a) {
                        Log.e("GameCenterApkUtil", "install apk done");
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                    intent.setComponent(null);
                    m(context, file, intent);
                    try {
                        context.startActivity(intent);
                        if (a) {
                            Log.e("GameCenterApkUtil", "retry install apk done");
                        }
                    } catch (Exception e2) {
                        if (a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean i(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, context, str, z)) == null) {
            if (a) {
                Log.e("GameCenterApkUtil", "call installApk filePath = " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return h(context, new File(str), z);
            } catch (Exception e) {
                if (!a) {
                    return false;
                }
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (f() && l(str) && d() < e()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            vj3.a().edit().putBoolean("install_guide_switch_key", z).apply();
        }
    }

    public static boolean k(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(str);
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
                    String str2 = queryIntentActivities.iterator().next().activityInfo.name;
                    Intent intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.LAUNCHER");
                    intent2.setComponent(new ComponentName(str, str2));
                    intent2.setFlags(270532608);
                    try {
                        context.startActivity(intent2);
                        if (a) {
                            Log.d("GameCenterApkUtil", "openApp:packageName = " + str);
                            return true;
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(String str) {
        InterceptResult invokeL;
        long b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.equals(str, "authorize")) {
                b = a();
            } else {
                b = b();
            }
            if ((System.currentTimeMillis() / 86400000) - (b / 86400000) > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean m(Context context, File file, Intent intent) {
        InterceptResult invokeLLL;
        ActivityInfo activityInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, context, file, intent)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                    if (uriForFile == null) {
                        return false;
                    }
                    intent.setDataAndType(uriForFile, intent.getType());
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    if (queryIntentActivities == null) {
                        return true;
                    }
                    for (ResolveInfo resolveInfo : queryIntentActivities) {
                        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                            context.grantUriPermission(str, uriForFile, 1);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    if (!a) {
                        return false;
                    }
                    throw e;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
