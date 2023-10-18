package com.baidu.tieba;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class pk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final ArrayList<String> a;
    public static String b;
    public static String c;
    public static boolean d;
    public static String e;
    public static String f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948064943, "Lcom/baidu/tieba/pk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948064943, "Lcom/baidu/tieba/pk5;");
                return;
            }
        }
        a = new ArrayList<>();
        d = false;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                b = d(TbadkCoreApplication.getInst().getApp());
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return f;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return g;
        }
        return (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return j(c());
        }
        return invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return h(TbadkCoreApplication.getInst().getPackageName());
        }
        return invokeV.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!d) {
                r(context);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            String c2 = c();
            if (str != null && str.equalsIgnoreCase(c2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, null, str) != null) || !TbadkCoreApplication.getInst().isDebugMode()) {
            return;
        }
        Log.e("MutiProcess", str);
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            e = str;
        }
    }

    public static void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            d = z;
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            f = str;
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            g = str;
        }
    }

    public static void r(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, context) == null) && context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            String str = packageName + ":swan";
            c = str;
            a.clear();
            a.add(packageName);
            a.add(packageName + ":remote");
            a.add(packageName + ":cdnTachometer");
            a.add(packageName + ":daemon");
            a.add(packageName + ":third");
            a.add(packageName + ":pluginInstaller");
            a.add(packageName + ":xiaoying");
            a.add(packageName + ":media");
            a.add(packageName + ":kmyas__");
            a.add(packageName + ":guardService");
            a.add(packageName + ":warkup");
            a.add(str);
            a.add(packageName + ":bdservice_v1");
            a.add(packageName + ":live");
            m("initProcess-->CurrentProcessName=" + c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Iterator<String> it = a.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next()) || str.toLowerCase().startsWith(c)) {
                    return true;
                }
                while (it.hasNext()) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
