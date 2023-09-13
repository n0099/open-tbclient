package com.baidu.tieba;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes7.dex */
public class p4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (int) ((i * 16.0d) / 9.0d) : invokeI.intValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static il0 d(@NonNull AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adCard)) == null) {
            if (zk0.b().query(adCard.getDownloadKey()) != null) {
                return zk0.b().query(adCard.getDownloadKey());
            }
            il0 il0Var = new il0();
            il0Var.h(adCard.getDownloadKey());
            if (adCard.downloadInfo != null) {
                if (TextUtils.isEmpty(il0Var.e())) {
                    il0Var.h(adCard.downloadInfo.b);
                }
                h4a h4aVar = adCard.downloadInfo;
                il0Var.g = h4aVar.b;
                il0Var.d = h4aVar.a;
            }
            if (TextUtils.isEmpty(il0Var.e())) {
                il0Var.h(adCard.adId);
            }
            ml0 ml0Var = new ml0();
            ml0Var.d = adCard.getButtonText();
            ml0Var.j = adCard.adId;
            ml0Var.a = adCard.getExtInfo();
            d15 d15Var = adCard.appInfoModel;
            if (d15Var != null) {
                ml0Var.g = d15Var.b;
                ml0Var.h = d15Var.c;
            }
            if (qj0.n(adCard.cmdScheme)) {
                ml0Var.c = adCard.cmdScheme;
            }
            il0Var.p = ml0Var;
            jl0 jl0Var = new jl0();
            jl0Var.a = adCard.getAdvertAppInfo().j;
            jl0Var.t = o36.a().b();
            jl0Var.s = o36.a().h();
            il0Var.q = jl0Var;
            return il0Var;
        }
        return (il0) invokeL.objValue;
    }

    public static String e(String str, String str2, float f, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Float.valueOf(f), textPaint})) == null) {
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
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65541, null, i, i2, i3, i4)) == null) {
            return l75.G(l75.n(m75.y(), i), i2, i3, i4);
        }
        return (Drawable) invokeIIII.objValue;
    }

    public static int g(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i == i2) {
                return i;
            }
            if (f <= 0.0f) {
                return i;
            }
            if (f >= 1.0f) {
                return i2;
            }
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            int alpha = Color.alpha(i);
            return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
        }
        return invokeCommon.intValue;
    }

    public static int h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return invokeLI.intValue;
    }
}
