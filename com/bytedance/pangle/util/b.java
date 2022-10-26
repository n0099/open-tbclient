package com.bytedance.pangle.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1401944984, "Lcom/bytedance/pangle/util/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1401944984, "Lcom/bytedance/pangle/util/b;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ComponentName componentName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String packageName = context.getPackageName();
            return (TextUtils.isEmpty(packageName) || (runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1)) == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null || !packageName.equals(componentName.getPackageName())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b == null) {
                File file = new File(context.getApplicationInfo().sourceDir);
                String[] a2 = com.bytedance.pangle.util.a.b.a(file);
                if (TextUtils.isEmpty(a2[0])) {
                    a2 = com.bytedance.pangle.util.a.a.a(file);
                }
                String str = a2[0];
                b = str;
                if (TextUtils.isEmpty(str)) {
                    ZeusLogger.e(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + a2[2]);
                }
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0013 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b1654612903156dc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            while (true) {
                char c = 'J';
                char c2 = '7';
                while (true) {
                    switch (c) {
                        case 'H':
                            break;
                        case 'I':
                            switch (c2) {
                                case '^':
                                    break;
                                case '_':
                                case '`':
                                    break;
                                default:
                                    switch (c2) {
                                    }
                            }
                            c = 'I';
                            c2 = '`';
                            break;
                        case 'J':
                            switch (c2) {
                            }
                            c = 'I';
                            c2 = '`';
                            break;
                        default:
                            c = 'H';
                    }
                }
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) (charArray[i] ^ i);
            }
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }
}
