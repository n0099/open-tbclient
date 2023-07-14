package com.baidu.tieba;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TouchDelegate;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.ext.widget.toast.ToastUtils;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class yi {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static float b = 0.0f;
    public static int c = 0;
    public static int d = 0;
    public static int e = -1;
    public static Toast f;
    public static d g;
    public static String h;
    public static Handler i;
    public static Runnable j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface d {
        void createToastView(boolean z);

        View getToastContentView();

        void setToastString(String str);
    }

    public static double J(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Double.valueOf(d2)})) == null) ? (d2 * 3.141592653589793d) / 180.0d : invokeCommon.doubleValue;
    }

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && yi.f != null) {
                yi.f.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }

        public b() {
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
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ View f;

        public c(View view2, int i, int i2, int i3, int i4, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.getHitRect(rect);
                rect.right += this.b;
                rect.left -= this.c;
                rect.bottom += this.d;
                rect.top -= this.e;
                this.f.setTouchDelegate(new TouchDelegate(rect, this.a));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322717, "Lcom/baidu/tieba/yi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322717, "Lcom/baidu/tieba/yi;");
                return;
            }
        }
        i = new Handler(Looper.getMainLooper());
        j = new a();
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Looper.getMainLooper() != Looper.myLooper() || Looper.getMainLooper().getThread() != Thread.currentThread()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return BdNetTypeUtil.isNetWorkAvailable();
        }
        return invokeV.booleanValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return e;
        }
        return invokeV.intValue;
    }

    public static d y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return g;
        }
        return (d) invokeV.objValue;
    }

    public static void A(Context context, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, view2) != null) || view2 == null) {
            return;
        }
        try {
            if (view2.getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 2);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static ProgressDialog M(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            b bVar = new b();
            if (str != null) {
                return ProgressDialog.show(context, "", str, true, false, bVar);
            }
            return ProgressDialog.show(context, "", context.getResources().getString(R.string.obfuscated_res_0x7f0f003a), true, false, bVar);
        }
        return (ProgressDialog) invokeLL.objValue;
    }

    public static int x(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            e = orientation;
            if (orientation != 1 && orientation != 3) {
                c = displayMetrics.widthPixels;
                d = displayMetrics.heightPixels;
            } else {
                c = displayMetrics.heightPixels;
                d = displayMetrics.widthPixels;
            }
            b = displayMetrics.density;
            a = true;
        }
    }

    public static void K(Context context) {
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            try {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName())) != null) {
                        launchIntentForPackage.addFlags(67108864);
                        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(context, 950731, launchIntentForPackage, LaunchTaskConstants.OTHER_PROCESS));
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                System.exit(0);
            }
        }
    }

    public static boolean C(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            try {
                String str = new String(bArr, 0, 16, "UTF-8");
                if (str.indexOf("RIFF") != 0) {
                    return false;
                }
                if (8 != str.indexOf("WEBPVP8 ")) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                BdLog.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static int[] t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            int[] iArr = new int[2];
            if (context == null) {
                return iArr;
            }
            Display defaultDisplay = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static DisplayMetrics u(Activity activity) {
        InterceptResult invokeL;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, activity)) == null) {
            DisplayMetrics displayMetrics2 = null;
            try {
                displayMetrics = new DisplayMetrics();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics;
            } catch (Exception e3) {
                e = e3;
                displayMetrics2 = displayMetrics;
                BdLog.e(e.toString());
                return displayMetrics2;
            }
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = Build.DISPLAY;
            if (str != null && str.contains(ToastUtils.MEIZU_ROM) && (s = s(str)) != null && s.length() >= 3) {
                int e2 = wg.e(s(s.substring(0, 1)), 0);
                int e3 = wg.e(s(s.substring(1, 2)), 0);
                if (e2 > 3 || (e2 == 3 && e3 >= 5)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String p() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65573;
            InterceptResult invokeV = interceptable.invokeV(65573, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns1").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    zi.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    zi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                zi.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            zi.g(r2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Reader] */
    public static String q() {
        ?? r2;
        Throwable th;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = 65574;
            InterceptResult invokeV = interceptable.invokeV(65574, null);
            if (invokeV != null) {
                return (String) invokeV.objValue;
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop net.dns2").getInputStream()));
                try {
                    String readLine = bufferedReader.readLine();
                    zi.g(bufferedReader);
                    return readLine;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    zi.g(bufferedReader);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                zi.g(r2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            zi.g(r2);
            throw th;
        }
    }

    public static int r() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                            return runningTaskInfo.numActivities;
                        }
                    }
                    return 0;
                }
                return 0;
            } catch (Exception e2) {
                BdLog.e(e2);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static String z() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null && runningTaskInfo.topActivity != null) {
                            return runningTaskInfo.topActivity.getClassName();
                        }
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean E(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr == null || bArr.length < 3 || bArr[0] != 71 || bArr[1] != 73 || bArr[2] != 70) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void L(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, dVar) == null) {
            g = dVar;
        }
    }

    public static float i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            if (!a) {
                B(context);
            }
            return b;
        }
        return invokeL.floatValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            if (!a) {
                B(context);
            }
            return d;
        }
        return invokeL.intValue;
    }

    public static int l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            if (!a) {
                B(context);
            }
            return c;
        }
        return invokeL.intValue;
    }

    public static String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        }
        return (String) invokeL.objValue;
    }

    public static Rect H(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, paint, str)) == null) {
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            return rect;
        }
        return (Rect) invokeLL.objValue;
    }

    public static float I(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, paint, str)) == null) {
            if (paint != null && str != null) {
                return paint.measureText(str);
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    public static void N(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, context, i2) == null) {
            O(context, context.getResources().getString(i2));
        }
    }

    public static void O(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) {
            S(str, 3500, false);
        }
    }

    public static void P(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, view2) == null) {
            try {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view2, 0);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void Q(Context context, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65553, null, context, i2) == null) && context != null) {
            R(context, context.getResources().getString(i2));
        }
    }

    public static void R(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            S(str, 2000, false);
        }
    }

    public static void T(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65556, null, context, i2) == null) {
            S(context.getResources().getString(i2), 2000, true);
        }
    }

    public static int d(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65561, null, context, f2)) == null) {
            if (!a) {
                B(context);
            }
            return (int) ((f2 * b) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static int e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, context, str)) == null) {
            if (context != null && context.getResources() != null && !TextUtils.isEmpty(str)) {
                return context.getResources().getIdentifier(str, "color", context.getPackageName());
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static Field f(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static int g(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65564, null, context, i2)) == null) {
            return context.getResources().getDimensionPixelSize(i2);
        }
        return invokeLI.intValue;
    }

    public static int k(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65568, null, context, z)) == null) {
            if (!a || z) {
                B(context);
            }
            return d;
        }
        return invokeLZ.intValue;
    }

    public static int m(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65570, null, context, z)) == null) {
            if (!a || z) {
                B(context);
            }
            return c;
        }
        return invokeLZ.intValue;
    }

    public static void S(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
            i.removeCallbacks(j);
            if (f != null && Build.VERSION.SDK_INT < 28) {
                d dVar = g;
                if (dVar != null) {
                    dVar.createToastView(z);
                }
                if (!str.equals(h)) {
                    d dVar2 = g;
                    if (dVar2 != null && dVar2.getToastContentView() != null) {
                        g.setToastString(str);
                        f.setView(g.getToastContentView());
                    } else {
                        f.setText(str);
                    }
                }
                d(BdBaseApplication.getInst().getApp(), 100.0f);
                int i3 = BdBaseApplication.getInst().getApp().getResources().getConfiguration().orientation;
                if (i2 == 3500) {
                    f.setDuration(1);
                } else {
                    f.setDuration(0);
                }
                f.setGravity(17, 0, 0);
            } else {
                Toast toast = f;
                if (toast != null) {
                    toast.cancel();
                }
                d dVar3 = g;
                if (dVar3 != null) {
                    dVar3.createToastView(z);
                }
                d dVar4 = g;
                if (dVar4 != null && dVar4.getToastContentView() != null) {
                    Toast toast2 = new Toast(BdBaseApplication.getInst().getApp());
                    f = toast2;
                    ij.a(toast2);
                    if (i2 == 3500) {
                        f.setDuration(1);
                    } else {
                        f.setDuration(0);
                    }
                    g.setToastString(str);
                    f.setView(g.getToastContentView());
                } else {
                    if (i2 == 3500) {
                        Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 1);
                        f = makeText;
                        ij.a(makeText);
                    } else {
                        Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), str, 0);
                        f = makeText2;
                        ij.a(makeText2);
                    }
                    f.setText(str);
                }
                d(BdBaseApplication.getInst().getApp(), 100.0f);
                f.setGravity(17, 0, 0);
            }
            h = str;
            i.postDelayed(j, i2);
            f.show();
        }
    }

    public static String U(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            if (str != null && str2 != null) {
                if (str.indexOf("?") < 0) {
                    str = str + "?";
                } else if (!str.endsWith("?") && !str.endsWith("&")) {
                    if ((URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) && str.contains("#")) {
                        String[] split = str.split("#");
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (i2 == 0) {
                                sb = new StringBuilder(split[0] + "&" + str2);
                            } else {
                                sb.append("#");
                                sb.append(split[i2]);
                            }
                        }
                        return sb.toString();
                    }
                    str = str + "&";
                }
                return str + str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Context context, View view2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{context, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int d2 = d(context, i2);
            int d3 = d(context, i3);
            int d4 = d(context, i4);
            int d5 = d(context, i5);
            View view3 = (View) view2.getParent();
            view3.post(new c(view2, d4, d2, d5, d3, view3));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, null) == null) && BdBaseApplication.getInst().isDebugMode()) {
            if (!F()) {
                StringBuilder sb = new StringBuilder(100);
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i2 = 1; i2 < stackTrace.length; i2++) {
                    sb.append(stackTrace[i2].getClassName());
                    sb.append(".");
                    sb.append(stackTrace[i2].getMethodName());
                    sb.append("  lines = ");
                    sb.append(stackTrace[i2].getLineNumber());
                    sb.append("\n");
                }
                BdLog.e("can not be call not thread! trace = \n" + sb.toString());
                throw new Error("can not be call not thread! trace = " + sb.toString());
            }
        }
    }

    public static double h(double d2, double d3, double d4, double d5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)})) == null) {
            double J = J(d2);
            double J2 = J(d4);
            return Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((J - J2) / 2.0d), 2.0d) + ((Math.cos(J) * Math.cos(J2)) * Math.pow(Math.sin((J(d3) - J(d5)) / 2.0d), 2.0d)))) * 2.0d) * 6378.137d) * 10000.0d) / 10000.0d;
        }
        return invokeCommon.doubleValue;
    }

    public static int[] n(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65571, null, i2, i3, i4, i5)) == null) {
            if (i2 > 0 && i3 > 0 && i4 > 0 && i5 > 0) {
                int[] iArr = new int[2];
                if (i3 > i5) {
                    i2 = (i2 * i5) / i3;
                    i3 = i5;
                }
                if (i2 > i4) {
                    i3 = (i3 * i4) / i2;
                } else {
                    i4 = i2;
                }
                iArr[0] = i4;
                iArr[1] = i3;
                return iArr;
            }
            return null;
        }
        return (int[]) invokeIIII.objValue;
    }

    public static int v(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, activity)) == null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i2 = rect.top;
            if (i2 == 0) {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return i2;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return i2;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return i2;
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                    return i2;
                } catch (NoSuchFieldException e6) {
                    e6.printStackTrace();
                    return i2;
                } catch (NumberFormatException e7) {
                    e7.printStackTrace();
                    return i2;
                } catch (SecurityException e8) {
                    e8.printStackTrace();
                    return i2;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static String w(TextPaint textPaint, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65580, null, textPaint, str, i2)) == null) {
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, i2, TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString();
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }
}
