package com.baidu.tieba;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.toast.ToastUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class ua3 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static String b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 2) {
                        view2.setAlpha(1.0f);
                        return false;
                    }
                    return false;
                }
                view2.setAlpha(0.2f);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948204226, "Lcom/baidu/tieba/ua3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948204226, "Lcom/baidu/tieba/ua3;");
                return;
            }
        }
        a = nr1.a;
        String str = lp3.c;
        b = null;
        c = null;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Build.VERSION.SDK_INT >= 25) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!Build.FINGERPRINT.contains(ToastUtils.MEIZU_ROM) && !Pattern.compile(ToastUtils.MEIZU_ROM, 2).matcher(Build.DISPLAY).find()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = f("ro.miui.ui.version.name");
            }
            if (a) {
                Log.d(ToastUtils.TAG, "OsName = " + b);
            }
            return !TextUtils.isEmpty(b);
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                c = f("ro.build.version.incremental");
            }
            if (a) {
                Log.d(ToastUtils.TAG, "sMiuiVersion = " + c);
            }
            if (!TextUtils.isEmpty(c) && (split = c.split(".")) != null && split.length >= 1 && split[0].length() >= 2) {
                String substring = split[0].substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    try {
                        if (Integer.parseInt(substring) < 9) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Object e(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        InterceptResult invokeLL;
        Field declaredField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) {
            if (obj == null || (declaredField = obj.getClass().getDeclaredField(str)) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        }
        return invokeLL.objValue;
    }

    public static void k(Toast toast, @StyleRes int i) {
        Object e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, toast, i) == null) {
            try {
                Object e2 = e(toast, "mTN");
                if (e2 != null && (e = e(e2, "mParams")) != null && (e instanceof WindowManager.LayoutParams)) {
                    ((WindowManager.LayoutParams) e).windowAnimations = i;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static String f(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                String readLine = bufferedReader.readLine();
                hr4.d(bufferedReader);
                if (readLine == null) {
                    return "";
                }
                return readLine;
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                hr4.d(bufferedReader2);
                hr4.d(bufferedReader2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                hr4.d(bufferedReader2);
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context != null && Build.VERSION.SDK_INT >= 19) {
                try {
                    Object systemService = context.getSystemService("appops");
                    if (systemService == null || (method = systemService.getClass().getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class)) == null) {
                        return false;
                    }
                    if (((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() != 0) {
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, str) == null) && a) {
            Log.d(ToastUtils.TAG, Log.getStackTraceString(new Throwable(str)));
        }
    }

    public static void i(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, view2) == null) && view2 != null) {
            view2.setOnTouchListener(new a());
        }
    }

    public static void j(Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, null, drawable) != null) || drawable == null) {
            return;
        }
        drawable.setColorFilter(ku2.c().getResources().getColor(R.color.obfuscated_res_0x7f06046e), PorterDuff.Mode.SRC_ATOP);
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (!a() || g(context) || Build.VERSION.SDK_INT < 23) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (!b()) {
                return false;
            }
            if (c() && g(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (!m(context) && !d()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && !l(context)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
