package com.bytedance.sdk.openadsdk.core.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j.f;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.q;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    @MainThread
    public static JSONArray a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (o.h().E() && h.d().f().alist() && f.f() && e(context)) {
                e.a(new g("getIncrementalInstallApps", context) { // from class: com.bytedance.sdk.openadsdk.core.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f66738a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66738a = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            d.d(this.f66738a);
                        }
                    }
                }, 1);
                return c(context);
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Nullable
    public static JSONArray c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                String b2 = com.bytedance.sdk.openadsdk.core.c.a(context).b("install_app_incremental_string", (String) null);
                if (!TextUtils.isEmpty(b2)) {
                    return new JSONArray((Collection) b(b2));
                }
            } catch (Throwable th) {
                k.a("InstallAppUtils", "getCacheIncrementalApps error: ", th);
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    @WorkerThread
    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            try {
                List<String> a2 = com.bytedance.sdk.openadsdk.core.j.b.c().a(context);
                if (a2 != null && !a2.isEmpty()) {
                    List<String> b2 = b(com.bytedance.sdk.openadsdk.core.c.a(context).b("install_app_string", (String) null));
                    a(context, a(a2));
                    if (b2 != null && !b2.isEmpty()) {
                        a2.removeAll(b2);
                    }
                    b(context, a(a2));
                }
            } catch (Exception e2) {
                k.a("InstallAppUtils", "loadIncrementInstallApps error: ", e2);
            }
        }
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            long longValue = com.bytedance.sdk.openadsdk.core.c.a(context).b("apptime", -1L).longValue();
            return longValue == -1 || System.currentTimeMillis() - longValue > 43200000;
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            com.bytedance.sdk.openadsdk.core.c a2 = com.bytedance.sdk.openadsdk.core.c.a(context);
            a2.a("install_app_incremental_string", str);
            a2.a("apptime", System.currentTimeMillis());
        }
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Arrays.asList(str.split(","));
        }
        return (List) invokeL.objValue;
    }

    @WorkerThread
    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            com.bytedance.sdk.openadsdk.core.c.a(context).a("install_app_string", str);
        }
    }

    public static String a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString().trim();
        }
        return (String) invokeL.objValue;
    }

    @WorkerThread
    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!q.k(o.a()) || q.c(o.a(), str)) {
                if (Build.VERSION.SDK_INT < 29 || o.a().getApplicationInfo().targetSdkVersion < 29) {
                    try {
                        String path = Environment.getExternalStorageDirectory().getPath();
                        File file = new File(path, "android/data/" + str);
                        if (file.exists()) {
                            long a2 = a(file);
                            PackageInfo packageInfo = o.a().getPackageManager().getPackageInfo(str, 0);
                            if (packageInfo != null) {
                                if (packageInfo.lastUpdateTime < a2) {
                                    return true;
                                }
                            }
                            return false;
                        }
                        return false;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file == null || !file.exists()) {
                return 0L;
            }
            return a(file, file.lastModified(), 0);
        }
        return invokeL.longValue;
    }

    public static long a(File file, long j2, int i2) {
        InterceptResult invokeCommon;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (file != null && file.exists()) {
                j2 = Math.max(j2, file.lastModified());
                int i3 = i2 + 1;
                if (i3 >= 50) {
                    return j2;
                }
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        j2 = Math.max(j2, a(file2, j2, i3));
                    }
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }
}
