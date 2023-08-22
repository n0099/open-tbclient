package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.m61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes6.dex */
public class j71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ float b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public a(Context context, float f, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Float.valueOf(f), view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = f;
            this.c = view2;
            this.d = view3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                int a = m61.c.a(this.a, this.b);
                this.c.getHitRect(rect);
                rect.left -= a;
                rect.right += a;
                rect.top -= a;
                rect.bottom += a;
                this.d.setTouchDelegate(new TouchDelegate(rect, this.c));
            }
        }
    }

    public static void a(Context context, View view2, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{context, view2, Float.valueOf(f)}) != null) || view2 == null) {
            return;
        }
        ViewParent parent = view2.getParent();
        if (!View.class.isInstance(parent)) {
            return;
        }
        View view3 = (View) parent;
        view3.post(new a(context, f, view2, view3));
    }

    public static String b(String str, String str2, float f, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f), textPaint})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
            if (!TextUtils.isEmpty(ellipsize)) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 == null || !view2.isShown()) {
                return false;
            }
            Rect rect = new Rect();
            if (!view2.getGlobalVisibleRect(rect)) {
                return false;
            }
            long height = rect.height() * rect.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 <= 0 || height * 100 < height2 * 50) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void d(@NonNull Context context, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, marginLayoutParams, str) == null) {
            int[] iArr = {0, 0, 0, 0};
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length == 4) {
                    for (int i = 0; i < 4; i++) {
                        try {
                            iArr[i] = Integer.parseInt(split[i]);
                        } catch (NumberFormatException unused) {
                            iArr[i] = 0;
                        }
                    }
                }
            }
            marginLayoutParams.setMargins(m61.c.a(context, iArr[0]), m61.c.a(context, iArr[1]), m61.c.a(context, iArr[2]), m61.c.a(context, iArr[3]));
        }
    }

    public static void e(@NonNull RelativeLayout.LayoutParams layoutParams, @NonNull int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, layoutParams, i) == null) && i > 0) {
            if ((i & 1) == 1) {
                layoutParams.addRule(10);
            }
            if ((i & 2) == 2) {
                layoutParams.addRule(12);
            }
            if ((i & 4) == 4) {
                layoutParams.addRule(9);
            }
            if ((i & 8) == 8) {
                layoutParams.addRule(11);
            }
            if ((i & 16) == 16) {
                layoutParams.addRule(14);
            }
            if ((i & 32) == 32) {
                layoutParams.addRule(15);
            }
        }
    }

    public static void f(@Nullable View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, view2) != null) || view2 == null) {
            return;
        }
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
}
