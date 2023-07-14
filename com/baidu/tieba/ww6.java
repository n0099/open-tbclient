package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ww6 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285043, "Lcom/baidu/tieba/ww6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285043, "Lcom/baidu/tieba/ww6;");
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

    public static final boolean a(ov6 ov6Var, ov6 ov6Var2, ox6 ox6Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{ov6Var, ov6Var2, ox6Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = ox6Var.getWidth();
            float q = ov6Var.f().q();
            float q2 = ov6Var2.f().q();
            long j3 = j - ov6Var.j();
            float f = width;
            float f2 = (float) j2;
            if (f - ((q2 + f) * (((float) (j - ov6Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final boolean c(ov6 ov6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, ov6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ov6Var, "<this>");
            if (j - ov6Var.j() < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(ov6 ov6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, ov6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ov6Var, "<this>");
            if (!e(ov6Var, j) && !c(ov6Var, j)) {
                return false;
            }
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(ov6 ov6Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, ov6Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ov6Var, "<this>");
            if (j - ov6Var.j() > ov6Var.g()) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(ov6 ov6Var, ov6 danmaku, ox6 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{ov6Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(ov6Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(ov6Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - ov6Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(ov6Var, j) || e(danmaku, j)) {
                return false;
            }
            if (ov6Var.e().j() != 5 && ov6Var.e().j() != 4 && !a(ov6Var, danmaku, displayer, j, j2) && !a(ov6Var, danmaku, displayer, j + j2, j2)) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
