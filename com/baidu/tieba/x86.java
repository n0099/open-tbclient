package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class x86 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254291, "Lcom/baidu/tieba/x86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254291, "Lcom/baidu/tieba/x86;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public static final boolean a(p76 p76Var, p76 p76Var2, p96 p96Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{p76Var, p76Var2, p96Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = p96Var.getWidth();
            float q = p76Var.f().q();
            float q2 = p76Var2.f().q();
            long j3 = j - p76Var.j();
            float f = width;
            float f2 = (float) j2;
            if (f - ((q2 + f) * (((float) (j - p76Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean c(p76 p76Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, p76Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p76Var, "<this>");
            if (j - p76Var.j() < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(p76 p76Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, p76Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p76Var, "<this>");
            if (!e(p76Var, j) && !c(p76Var, j)) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(p76 p76Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, p76Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p76Var, "<this>");
            if (j - p76Var.j() > p76Var.g()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(p76 p76Var, p76 danmaku, p96 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{p76Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(p76Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(p76Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - p76Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(p76Var, j) || e(danmaku, j)) {
                return false;
            }
            if (p76Var.e().j() != 5 && p76Var.e().j() != 4 && !a(p76Var, danmaku, displayer, j, j2) && !a(p76Var, danmaku, displayer, j + j2, j2)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
