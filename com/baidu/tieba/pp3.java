package com.baidu.tieba;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.uu2;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class pp3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static DisplayMetrics b;
    public static final DisplayMetrics c;
    public static final float d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948069686, "Lcom/baidu/tieba/pp3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948069686, "Lcom/baidu/tieba/pp3;");
                return;
            }
        }
        a = is1.a;
        DisplayMetrics displayMetrics = fv2.c().getResources().getDisplayMetrics();
        c = displayMetrics;
        d = displayMetrics.density;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            int identifier = fv2.c().getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android");
            int i = 0;
            if (identifier > 0) {
                try {
                    i = fv2.c().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            if (i == 0) {
                return (int) (d * 25.0f);
            }
            return i;
        }
        return invokeV.intValue;
    }

    public static void A(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && b == null) {
            Application c2 = fv2.c();
            if (c2 != null) {
                context = c2;
            }
            if (context == null) {
                return;
            }
            b = context.getResources().getDisplayMetrics();
        }
    }

    public static boolean E(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, null, z)) == null) {
            return !I((ActivityManager) fv2.c().getSystemService("activity"), ProcessUtils.getCurProcessName(), z);
        }
        return invokeZ.booleanValue;
    }

    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity) && ((Activity) context).isInMultiWindowMode()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean K(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, activity)) == null) {
            if (activity == null) {
                return false;
            }
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (defaultDisplay.getRotation() != 1 && defaultDisplay.getRotation() != 3) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int O(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f)) == null) {
            return N(fv2.c(), f);
        }
        return invokeF.intValue;
    }

    public static float P(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65552, null, f)) == null) {
            return f / l(fv2.c());
        }
        return invokeF.floatValue;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, null, activity) == null) && activity != null && zq3.i) {
            new zq3(activity).n(-1, false, true, true);
        }
    }

    public static void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, activity) == null) && activity != null && zq3.i) {
            new zq3(activity).n(-1, true, false, true);
        }
    }

    public static void c(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, activity) == null) && ho3.d(activity) && ds4.d() && ds4.e(activity)) {
            i(activity);
        }
    }

    public static int g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65560, null, f)) == null) {
            return f(fv2.c(), f);
        }
        return invokeF.intValue;
    }

    public static float h(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65561, null, f)) == null) {
            return f * l(fv2.c());
        }
        return invokeF.floatValue;
    }

    public static float l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            A(fv2.c());
            DisplayMetrics displayMetrics = b;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static int m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            A(fv2.c());
            DisplayMetrics displayMetrics = b;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            A(fv2.c());
            DisplayMetrics displayMetrics = b;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int o(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            A(fv2.c());
            DisplayMetrics displayMetrics = b;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return C(false);
        }
        return invokeV.booleanValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return E(false);
        }
        return invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (fv2.c().getResources().getConfiguration().orientation == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (fv2.c().getResources().getConfiguration().orientation == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return fv2.c().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
        }
        return invokeV.intValue;
    }

    public static Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            return q(lx2.T().getActivity());
        }
        return (Bitmap) invokeV.objValue;
    }

    @UiThread
    public static Bitmap y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            return z(1.0f, 1.0f);
        }
        return (Bitmap) invokeV.objValue;
    }

    public static boolean C(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            String packageName = fv2.c().getPackageName();
            ActivityManager activityManager = (ActivityManager) fv2.c().getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo != null && (!z || Arrays.asList(runningAppProcessInfo.pkgList).contains(packageName))) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && runningAppProcessInfo.importance == 100) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public static Pair<Integer, Integer> e(String str) {
        InterceptResult invokeL;
        long j;
        Pair<Integer, Integer> x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            if (xb3.K().w() == null) {
                x = (Pair) rw2.c().b("screenSize");
                if (x == null) {
                    x = ip3.b();
                }
            } else {
                x = lx2.T().x();
            }
            int intValue = ((Integer) x.first).intValue();
            int d2 = d(((Integer) x.second).intValue(), str);
            if (a) {
                Log.d("SwanAppUIUtils", "preGuessWebViewSize cost - " + (System.currentTimeMillis() - j) + "ms");
            }
            return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(d2));
        }
        return (Pair) invokeL.objValue;
    }

    public static int u(Context context) {
        InterceptResult invokeL;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            int n = n(context);
            int t = t();
            int k = k(context);
            try {
                i = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
            } catch (Resources.NotFoundException e) {
                if (a) {
                    e.printStackTrace();
                }
                i = 0;
            }
            hb2 U = lx2.T().U();
            gb2 gb2Var = null;
            if (U != null) {
                eb2 m = U.m();
                if (m instanceof gb2) {
                    gb2Var = (gb2) m;
                }
            }
            boolean z2 = true;
            if (gb2Var != null && nc3.f(gb2Var.I1())) {
                zq3 K1 = gb2Var.K1();
                z2 = (K1 == null || !K1.i()) ? false : false;
                z = true;
            } else {
                z2 = false;
                z = false;
            }
            int i2 = n - k;
            if (!z2) {
                i2 -= t;
            }
            if (!z) {
                i2 -= i;
            }
            if (i2 <= 0) {
                return 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static boolean G(@NonNull nc3 nc3Var, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, nc3Var, context)) == null) {
            if (zq3.i && (TextUtils.equals(nc3Var.j, ExceptionHandlerImpl.KEY_CUSTOM) || !hp3.h(context))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static int N(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65550, null, context, f)) == null) {
            return (int) (f / l(context));
        }
        return invokeLF.intValue;
    }

    public static int f(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65559, null, context, f)) == null) {
            return (int) (f * l(context));
        }
        return invokeLF.intValue;
    }

    public static int r(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, resources, str)) == null) {
            int identifier = resources.getIdentifier(str, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static boolean H(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, runningAppProcessInfo, z)) == null) {
            if (runningAppProcessInfo == null) {
                return false;
            }
            if (z && !Arrays.asList(runningAppProcessInfo.pkgList).contains(xb3.K().getPackageName())) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return false;
            }
            int i = runningAppProcessInfo.importance;
            if (i != 200 && i != 100) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean I(ActivityManager activityManager, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, activityManager, str, z)) == null) {
            if (activityManager == null) {
                activityManager = (ActivityManager) xb3.K().getSystemService("activity");
            }
            if (activityManager == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str) && H(runningAppProcessInfo, z)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static void M(BdBaseImageView bdBaseImageView, TextView textView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, bdBaseImageView, textView, str) == null) {
            if ("0".equals(str)) {
                bdBaseImageView.setVisibility(8);
                textView.setVisibility(8);
            } else if ("1".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(R.string.obfuscated_res_0x7f0f01bb);
            } else if ("2".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(R.string.obfuscated_res_0x7f0f01bd);
            } else if ("3".equals(String.valueOf(str))) {
                bdBaseImageView.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(R.string.obfuscated_res_0x7f0f01bc);
            }
        }
    }

    public static void Q(Activity activity) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, null, activity) != null) || !ho3.d(activity) || (frameLayout = (FrameLayout) activity.getWindow().getDecorView().getRootView().findViewById(R.id.obfuscated_res_0x7f090180)) == null) {
            return;
        }
        frameLayout.setBackgroundColor(activity.getResources().getColor(R.color.obfuscated_res_0x7f060437));
    }

    public static int s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            if (!F(context)) {
                if (K((Activity) context)) {
                    return n(context);
                }
                return o(context);
            } else if (J()) {
                return n(context);
            } else {
                return o(context);
            }
        }
        return invokeL.intValue;
    }

    public static int v(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, textView)) == null) {
            if (textView == null) {
                return 0;
            }
            Paint paint = new Paint();
            paint.setTextSize(textView.getTextSize());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            if (TextUtils.isEmpty(textView.getText())) {
                return 0;
            }
            return (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 2.0d);
        }
        return invokeL.intValue;
    }

    public static int w(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, textView)) == null) {
            if (textView == null) {
                return 0;
            }
            Paint paint = new Paint();
            paint.setTextSize(textView.getTextSize());
            if (TextUtils.isEmpty(textView.getText())) {
                return 0;
            }
            return (int) paint.measureText(textView.getText().toString());
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(int i, String str) {
        InterceptResult invokeIL;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65557, null, i, str)) == null) {
            Context appContext = AppRuntime.getAppContext();
            try {
                i2 = t();
            } catch (Resources.NotFoundException e) {
                e = e;
                i2 = 0;
            }
            try {
                i3 = appContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
                try {
                    i4 = appContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070101);
                    try {
                        i4 += appContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070102);
                    } catch (Resources.NotFoundException e2) {
                        e = e2;
                        if (a) {
                            e.printStackTrace();
                        }
                        if (TextUtils.isEmpty(str)) {
                        }
                        if (!z) {
                        }
                        if (!z3) {
                        }
                        if (!z4) {
                        }
                        if (z2) {
                        }
                        if (a) {
                        }
                        return Math.max(i5, 0);
                    }
                } catch (Resources.NotFoundException e3) {
                    e = e3;
                    i4 = 0;
                    if (a) {
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    if (!z) {
                    }
                    if (!z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    if (a) {
                    }
                    return Math.max(i5, 0);
                }
            } catch (Resources.NotFoundException e4) {
                e = e4;
                i3 = 0;
                i4 = 0;
                if (a) {
                }
                if (TextUtils.isEmpty(str)) {
                }
                if (!z) {
                }
                if (!z3) {
                }
                if (!z4) {
                }
                if (z2) {
                }
                if (a) {
                }
                return Math.max(i5, 0);
            }
            if (TextUtils.isEmpty(str)) {
                String b2 = qf3.b(qp3.f(str));
                SwanAppConfigData s = lx2.T().s();
                yb3 b0 = yb3.b0();
                if (b0 == null) {
                    return i;
                }
                vw2.a W = b0.W();
                nc3 e5 = lx2.T().e(b2, s, uu2.e.i(W.H(), W.v1()).getPath() + File.separator);
                if (nc3.f(e5)) {
                    z3 = true;
                    z4 = G(e5, appContext);
                } else {
                    z3 = false;
                    z4 = false;
                }
                z = sp3.E(b2);
                z2 = e5.f;
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            if (!z) {
                i5 = i - i4;
            } else {
                i5 = i;
            }
            if (!z3) {
                i5 -= i3;
            }
            if (!z4) {
                i5 -= i2;
            }
            if (z2) {
                i5 -= (int) (h(50.0f) + 0.5f);
            }
            if (a) {
                int e6 = hp3.e(appContext);
                int c2 = ip3.c();
                Log.d("SwanAppUIUtils", "screenHeight:" + i + ",notchHeight:" + e6 + ",navHeight:" + c2 + ",preGuessWebViewHeight:" + i5 + ",pageUrl:" + str + ",hasTab:" + z + ",bottomBarHeight:" + i4 + ",isTransparentBar:" + z3 + ",actionBarHeight:" + i3 + ",isOccupyStatusBar:" + z4 + ",statusBarHeight:" + i2 + ",canPullToRefresh:" + z2);
            }
            return Math.max(i5, 0);
        }
        return invokeIL.intValue;
    }

    public static void i(Activity activity) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65562, null, activity) != null) || !ho3.d(activity) || (frameLayout = (FrameLayout) activity.getWindow().getDecorView().getRootView().findViewById(R.id.obfuscated_res_0x7f090180)) == null) {
            return;
        }
        frameLayout.setBackgroundColor(activity.getResources().getColor(R.color.obfuscated_res_0x7f060437));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ds4.a(activity), -1);
        layoutParams.gravity = 17;
        ((FrameLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f090182)).setLayoutParams(new FrameLayout.LayoutParams(layoutParams));
    }

    public static int k(Context context) {
        InterceptResult invokeL;
        eb2 m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            hb2 U = lx2.T().U();
            int i = 0;
            if (context == null || U == null || (m = U.m()) == null || !(m instanceof gb2) || !((gb2) m).g2()) {
                return 0;
            }
            try {
                i = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070101);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070102);
                if (dimensionPixelSize > 0) {
                    return i + dimensionPixelSize;
                }
                return i;
            } catch (Resources.NotFoundException e) {
                if (a) {
                    e.printStackTrace();
                    return i;
                }
                return i;
            }
        }
        return invokeL.intValue;
    }

    public static Bitmap q(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, activity)) == null) {
            if (activity == null) {
                return null;
            }
            View findViewById = activity.findViewById(16908290);
            Bitmap bitmap = null;
            for (int i = 1; i < 3; i++) {
                try {
                    findViewById.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = findViewById.getDrawingCache();
                    if (drawingCache != null) {
                        bitmap = Bitmap.createScaledBitmap(drawingCache, drawingCache.getWidth() / i, drawingCache.getHeight() / i, false);
                    }
                    findViewById.setDrawingCacheEnabled(false);
                } catch (NullPointerException | OutOfMemoryError e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    @UiThread
    public static Bitmap x(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65577, null, view2, i, i2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @UiThread
    public static Bitmap z(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            lx2 T2 = lx2.T();
            View B = T2.B(T2.C());
            if (B != null && B.getWidth() > 0 && B.getHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap((int) (B.getWidth() * f), (int) (B.getHeight() * f2), Bitmap.Config.ARGB_4444);
                createBitmap.eraseColor(-1);
                B.draw(new Canvas(createBitmap));
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
