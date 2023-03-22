package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class kj6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947915058, "Lcom/baidu/tieba/kj6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947915058, "Lcom/baidu/tieba/kj6;");
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

    public static final boolean a(ci6 ci6Var, ci6 ci6Var2, ck6 ck6Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{ci6Var, ci6Var2, ck6Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = ck6Var.getWidth();
            float q = ci6Var.f().q();
            float q2 = ci6Var2.f().q();
            long k = j - ci6Var.k();
            float f = width;
            float f2 = (float) j2;
            if (f - ((q2 + f) * (((float) (j - ci6Var2.k())) / f2)) < (f - ((f + q) * (((float) k) / f2))) + q) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean c(ci6 ci6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, ci6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ci6Var, "<this>");
            if (j - ci6Var.k() < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(ci6 ci6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, ci6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ci6Var, "<this>");
            if (!e(ci6Var, j) && !c(ci6Var, j)) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(ci6 ci6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, ci6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ci6Var, "<this>");
            if (j - ci6Var.k() > ci6Var.g()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(ci6 ci6Var, ci6 danmaku, ck6 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{ci6Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(ci6Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(ci6Var, j)) {
                return false;
            }
            long k = danmaku.k() - ci6Var.k();
            if (k <= 0) {
                return true;
            }
            if (Math.abs(k) >= j2 || e(ci6Var, j) || e(danmaku, j)) {
                return false;
            }
            if (ci6Var.e().k() != 5 && ci6Var.e().k() != 4 && !a(ci6Var, danmaku, displayer, j, j2) && !a(ci6Var, danmaku, displayer, j + j2, j2)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
