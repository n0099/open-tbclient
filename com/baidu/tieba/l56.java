package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class l56 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893916, "Lcom/baidu/tieba/l56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893916, "Lcom/baidu/tieba/l56;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(d46 d46Var, d46 d46Var2, d66 d66Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{d46Var, d46Var2, d66Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = d66Var.getWidth();
            float q = d46Var.f().q();
            float q2 = d46Var2.f().q();
            long j3 = j - d46Var.j();
            float f = width;
            float f2 = (float) j2;
            return f - ((q2 + f) * (((float) (j - d46Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(d46 d46Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, d46Var, j)) == null) {
            Intrinsics.checkNotNullParameter(d46Var, "<this>");
            return j - d46Var.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(d46 d46Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, d46Var, j)) == null) {
            Intrinsics.checkNotNullParameter(d46Var, "<this>");
            return e(d46Var, j) || c(d46Var, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(d46 d46Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, d46Var, j)) == null) {
            Intrinsics.checkNotNullParameter(d46Var, "<this>");
            return j - d46Var.j() > d46Var.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(d46 d46Var, d46 danmaku, d66 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{d46Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(d46Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(d46Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - d46Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(d46Var, j) || e(danmaku, j)) {
                return false;
            }
            return d46Var.e().j() == 5 || d46Var.e().j() == 4 || a(d46Var, danmaku, displayer, j, j2) || a(d46Var, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
