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
public final class x36 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249486, "Lcom/baidu/tieba/x36;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249486, "Lcom/baidu/tieba/x36;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(p26 p26Var, p26 p26Var2, p46 p46Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{p26Var, p26Var2, p46Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = p46Var.getWidth();
            float q = p26Var.f().q();
            float q2 = p26Var2.f().q();
            long j3 = j - p26Var.j();
            float f = width;
            float f2 = (float) j2;
            return f - ((q2 + f) * (((float) (j - p26Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(p26 p26Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, p26Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return j - p26Var.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(p26 p26Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, p26Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return e(p26Var, j) || c(p26Var, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(p26 p26Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, p26Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            return j - p26Var.j() > p26Var.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(p26 p26Var, p26 danmaku, p46 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{p26Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(p26Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(p26Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - p26Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(p26Var, j) || e(danmaku, j)) {
                return false;
            }
            return p26Var.e().j() == 5 || p26Var.e().j() == 4 || a(p26Var, danmaku, displayer, j, j2) || a(p26Var, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
