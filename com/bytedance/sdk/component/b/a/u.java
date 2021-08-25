package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import kotlin.UShort;
/* loaded from: classes9.dex */
public final class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f64273a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731339366, "Lcom/bytedance/sdk/component/b/a/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731339366, "Lcom/bytedance/sdk/component/b/a/u;");
                return;
            }
        }
        f64273a = Charset.forName("UTF-8");
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8) : invokeI.intValue;
    }

    public static short a(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Short.valueOf(s)})) == null) {
            int i2 = s & UShort.MAX_VALUE;
            return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
        }
        return invokeCommon.shortValue;
    }

    public static void a(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
                throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)));
            }
        }
    }

    public static <T extends Throwable> void b(Throwable th) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, th) == null) {
            throw th;
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th) == null) {
            b(th);
        }
    }

    public static boolean a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                    return false;
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
