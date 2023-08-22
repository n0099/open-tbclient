package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Method;
@SuppressLint({"ObsoleteSdkInt"})
/* loaded from: classes7.dex */
public class o93 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;
    public boolean b;
    public boolean c;
    public View d;
    public View e;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final boolean e;
        public final float f;

        public b(Activity activity, boolean z, boolean z2) {
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Resources resources = activity.getResources();
            if (resources.getConfiguration().orientation == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.e = z3;
            this.f = g(activity);
            this.a = b(resources, "status_bar_height");
            a(activity);
            this.c = d(activity);
            this.d = f(activity);
            this.b = this.c > 0;
        }

        public /* synthetic */ b(Activity activity, boolean z, boolean z2, a aVar) {
            this(activity, z, z2);
        }

        @TargetApi(14)
        public final int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                if (Build.VERSION.SDK_INT >= 14) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(16843499, typedValue, true);
                    return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final float g(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 16) {
                    activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                }
                float f = displayMetrics.density;
                return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
            }
            return invokeL.floatValue;
        }

        public final int b(Resources resources, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resources, str)) == null) {
                int identifier = resources.getIdentifier(str, EMABTest.TYPE_DIMEN, "android");
                if (identifier > 0) {
                    return resources.getDimensionPixelSize(identifier);
                }
                return 0;
            }
            return invokeLL.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.b;
            }
            return invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.f < 600.0f && !this.e) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @TargetApi(14)
        public final int d(Context context) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT >= 14 && i(context)) {
                    if (this.e) {
                        str = "navigation_bar_height";
                    } else {
                        str = "navigation_bar_height_landscape";
                    }
                    return b(resources, str);
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @TargetApi(14)
        public final int f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT >= 14 && i(context)) {
                    return b(resources, "navigation_bar_width");
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @TargetApi(14)
        public final boolean i(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                if (identifier != 0) {
                    boolean z = resources.getBoolean(identifier);
                    if ("1".equals(o93.f)) {
                        return false;
                    }
                    if ("0".equals(o93.f)) {
                        return true;
                    }
                    return z;
                }
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987040, "Lcom/baidu/tieba/o93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987040, "Lcom/baidu/tieba/o93;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class);
                declaredMethod.setAccessible(true);
                f = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f = null;
            }
        }
    }

    @TargetApi(19)
    public o93(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{SystemBarTintManager.windowTranslucentStatus, SystemBarTintManager.windowTranslucentNavigation});
            try {
                this.b = obtainStyledAttributes.getBoolean(0, false);
                this.c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.b = true;
                }
                if ((attributes.flags & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0) {
                    this.c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        b bVar = new b(activity, this.b, this.c, null);
        this.a = bVar;
        if (!bVar.j()) {
            this.c = false;
        }
        if (this.b) {
            d(activity, viewGroup);
        }
        if (this.c) {
            c(activity, viewGroup);
        }
    }

    public void b(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.b) {
            View view2 = this.d;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void c(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewGroup) == null) {
            this.e = new View(context);
            if (this.a.k()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.a.c());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.a.e(), -1);
                layoutParams.gravity = 5;
            }
            this.e.setLayoutParams(layoutParams);
            this.e.setBackgroundColor(-1728053248);
            this.e.setVisibility(8);
            viewGroup.addView(this.e);
        }
    }

    public final void d(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, viewGroup) == null) {
            this.d = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.a.h());
            layoutParams.gravity = 48;
            if (this.c && !this.a.k()) {
                layoutParams.rightMargin = this.a.e();
            }
            this.d.setLayoutParams(layoutParams);
            this.d.setBackgroundColor(-1728053248);
            this.d.setVisibility(8);
            viewGroup.addView(this.d);
        }
    }
}
