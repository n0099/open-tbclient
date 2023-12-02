package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes8.dex */
public class w11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return l21.b();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return Build.VERSION.SDK_INT;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                if (Build.VERSION.SDK_INT >= 33 && hf0.b().getApplicationInfo().targetSdkVersion >= 33) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static DisplayMetrics a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-368629133, "Lcom/baidu/tieba/w11$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-368629133, "Lcom/baidu/tieba/w11$c;");
            }
        }

        public static int a(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f)) == null) {
                if (context == null) {
                    return 0;
                }
                return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            return invokeLF.intValue;
        }

        public static int m(@Nullable Context context, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(65549, null, context, f)) == null) {
                if (context == null) {
                    return 0;
                }
                return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
            }
            return invokeLF.intValue;
        }

        public static float b(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                j(context);
                DisplayMetrics displayMetrics = a;
                if (displayMetrics != null) {
                    return displayMetrics.density;
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        public static int c(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                DisplayMetrics d = d(context);
                if (d != null) {
                    return d.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static DisplayMetrics d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
                if (context == null) {
                    return null;
                }
                return context.getResources().getDisplayMetrics();
            }
            return (DisplayMetrics) invokeL.objValue;
        }

        public static int e(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
                DisplayMetrics d = d(context);
                if (d != null) {
                    return d.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static int[] g(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
                int[] iArr = new int[2];
                int e = e(context);
                int f = f(context);
                if (e > 0 && f > 0) {
                    iArr[0] = e;
                    iArr[1] = f;
                }
                return iArr;
            }
            return (int[]) invokeL.objValue;
        }

        public static float i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
                TypedValue typedValue = new TypedValue();
                hf0.b().getResources().getValue(i, typedValue, true);
                return typedValue.getFloat();
            }
            return invokeI.floatValue;
        }

        public static void j(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65546, null, context) != null) || a != null || context == null) {
                return;
            }
            a = context.getResources().getDisplayMetrics();
        }

        public static int f(@Nullable Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
                if (context == null) {
                    return 0;
                }
                WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
                if (windowManager == null) {
                    return -1;
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (b.b()) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                    return displayMetrics.heightPixels;
                }
                return c(context);
            }
            return invokeL.intValue;
        }

        public static int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
                int identifier = hf0.b().getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
                int i = 0;
                if (identifier > 0) {
                    try {
                        i = hf0.b().getResources().getDimensionPixelSize(identifier);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i == 0) {
                    return (int) (b(null) * 25.0f);
                }
                return i;
            }
            return invokeV.intValue;
        }

        public static boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
                int[] g = g(hf0.b());
                if (g.length != 2 || g[0] <= 0 || g[1] <= 0 || g[0] / g[1] < 0.5625f) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public static boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
                if (hf0.b().getResources().getConfiguration().orientation == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                return (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, "hw_sc.build.os.version");
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m", "TET-AN00"};
            if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
                for (int i = 0; i < 7; i++) {
                    if (strArr[i].equalsIgnoreCase(Build.MODEL)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                int identifier = Resources.getSystem().getIdentifier("config_os_brand", EMABTest.TYPE_STRING, "android");
                if (identifier != 0) {
                    return context.getString(identifier).equals("harmony");
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
