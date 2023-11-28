package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class lj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947944756, "Lcom/baidu/tieba/lj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947944756, "Lcom/baidu/tieba/lj3;");
                return;
            }
        }
        a = sm1.a;
        HashMap hashMap = new HashMap(14);
        b = hashMap;
        hashMap.put(com.kuaishou.weapon.p0.g.g, "定位");
        b.put(com.kuaishou.weapon.p0.g.h, "定位");
        b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, "录音");
        b.put("android.permission.READ_CONTACTS", "读取联系人");
        b.put("android.permission.ACCESS_NETWORK_STATE", "访问网络状态");
        b.put("android.permission.REORDER_TASKS", "开机自启");
        b.put(com.kuaishou.weapon.p0.g.a, "网络");
        b.put("android.permission.REQUEST_INSTALL_PACKAGES", "安装软件包");
        b.put("android.permission.READ_CALENDAR", "读取日历");
        b.put("android.permission.WRITE_CALENDAR", "写入日历");
        b.put("android.permission.WRITE_EXTERNAL_STORAGE", "存储");
        b.put(com.kuaishou.weapon.p0.g.i, "存储");
        b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, "相机");
        b.put("android.permission.WRITE_SETTINGS", "系统设置");
        b.put("android.permission.SYSTEM_ALERT_WINDOW", "悬浮窗");
    }

    public static Map<String, ComponentName> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(RomUtils.MANUFACTURER_HUAWEI, new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            hashMap.put("letv", new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.PermissionAndApps"));
            hashMap.put("lg", new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            hashMap.put("sony", new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        km4.d(bufferedReader);
                        return readLine;
                    } catch (IOException e) {
                        e = e;
                        if (a) {
                            e.printStackTrace();
                        }
                        km4.d(bufferedReader);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    km4.d(bufferedReader2);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                km4.d(bufferedReader2);
                throw th;
            }
        } else {
            return (String) invokeV.objValue;
        }
    }

    public static Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(pk3.a, "com.coloros.safecenter");
            hashMap.put("vivo", "com.bairenkeji.icaller");
            hashMap.put("coolpad", "com.yulong.android.security:remote");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static PackageInfo d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static void k(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, intent) == null) {
            if (context != null && intent != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            } else if (a) {
                Log.e("SwanAppPermissionHelper", "context or intent is null");
            }
        }
    }

    public static void l(Context context, ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, componentName) == null) {
            try {
                Intent intent = new Intent(context.getPackageName());
                intent.setComponent(componentName);
                context.startActivity(intent);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static ResolveInfo e(Context context, PackageInfo packageInfo) {
        InterceptResult invokeLL;
        List<ResolveInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, packageInfo)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            try {
                list = context.getPackageManager().queryIntentActivities(intent, 0);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                list = null;
            }
            if (list == null || list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
        return (ResolveInfo) invokeLL.objValue;
    }

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            PackageInfo d = d(context, str);
            if (d == null) {
                f(context);
                return;
            }
            ResolveInfo e = e(context, d);
            if (e == null) {
                f(context);
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(e.activityInfo.packageName, e.activityInfo.name));
                context.startActivity(intent);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
                f(context);
            }
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            k(context, intent);
        }
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            String str2 = b.get(str);
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, context) != null) || context == null) {
            return;
        }
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            f(context);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (a) {
            Log.d("SwanAppPermissionHelper", "goPermissionPage : " + lowerCase);
        }
        if (TextUtils.equals(lowerCase, RomUtils.MANUFACTURER_XIAOMI)) {
            i(context);
        } else if (TextUtils.equals(lowerCase, "meizu")) {
            h(context);
        } else {
            Map<String, ComponentName> a2 = a();
            if (a2.containsKey(lowerCase)) {
                l(context, a2.get(lowerCase));
                return;
            }
            Map<String, String> b2 = b();
            if (b2.containsKey(lowerCase)) {
                m(context, b2.get(lowerCase));
            } else {
                f(context);
            }
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            String c = c();
            if (a) {
                Log.d("SwanAppPermissionHelper", "goPermissionPageForXiaomi rom version : " + c);
            }
            Intent intent = new Intent();
            if (!"V10".equals(c) && !"V9".equals(c) && !"V8".equals(c)) {
                if (!"V7".equals(c) && !"V6".equals(c)) {
                    f(context);
                    return;
                }
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent.putExtra("extra_pkgname", context.getPackageName());
                k(context, intent);
                return;
            }
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            k(context, intent);
        }
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            try {
                Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("packageName", context.getPackageName());
                context.startActivity(intent);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
                f(context);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT < 23) {
                    return true;
                }
                int i = -1;
                try {
                    i = ContextCompat.checkSelfPermission(context, str);
                } catch (Exception e) {
                    if (a) {
                        throw e;
                    }
                }
                if (i != 0) {
                    return false;
                }
                return true;
            } else if (!a) {
                return false;
            } else {
                throw new IllegalArgumentException("context or permission is null");
            }
        }
        return invokeLL.booleanValue;
    }
}
