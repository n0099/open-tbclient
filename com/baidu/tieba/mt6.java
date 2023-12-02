package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mt6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947984250, "Lcom/baidu/tieba/mt6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947984250, "Lcom/baidu/tieba/mt6;");
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

    public static final boolean a(es6 es6Var, es6 es6Var2, eu6 eu6Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{es6Var, es6Var2, eu6Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = eu6Var.getWidth();
            float q = es6Var.f().q();
            float q2 = es6Var2.f().q();
            long j3 = j - es6Var.j();
            float f = width;
            float f2 = (float) j2;
            if (f - ((q2 + f) * (((float) (j - es6Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean c(es6 es6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, es6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(es6Var, "<this>");
            if (j - es6Var.j() < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(es6 es6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, es6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(es6Var, "<this>");
            if (!e(es6Var, j) && !c(es6Var, j)) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(es6 es6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, es6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(es6Var, "<this>");
            if (j - es6Var.j() > es6Var.g()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(es6 es6Var, es6 danmaku, eu6 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{es6Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(es6Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(es6Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - es6Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(es6Var, j) || e(danmaku, j)) {
                return false;
            }
            if (es6Var.e().j() != 5 && es6Var.e().j() != 4 && !a(es6Var, danmaku, displayer, j, j2) && !a(es6Var, danmaku, displayer, j + j2, j2)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
