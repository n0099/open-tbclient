package com.baidu.wallet.base.camera.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes8.dex */
public class Yuv implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-173807009, "Lcom/baidu/wallet/base/camera/internal/Yuv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-173807009, "Lcom/baidu/wallet/base/camera/internal/Yuv;");
                return;
            }
        }
        System.loadLibrary("bd_yuv");
    }

    public Yuv() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void rotateCrop(byte[] bArr, int i2, int i3, Rect rect, int i4, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, Integer.valueOf(i4), bArr2}) == null) || bArr == null || rect == null || bArr2 == null) {
            return;
        }
        int i5 = i2 * i3;
        int width = rect.width() * rect.height();
        if (bArr.length == i5 + (i5 >> 1) && bArr2.length == width * 3) {
            rotateCropArray(bArr, i2, i3, rect.left, rect.top, rect.right, rect.bottom, i4, bArr2);
        }
    }

    public static native void rotateCropArray(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2);

    public static native void rotateCropBmp(byte[] bArr, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap);

    public static void rotateCropLuminance(byte[] bArr, int i2, int i3, Rect rect, int i4, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), rect, Integer.valueOf(i4), bArr2}) == null) || bArr == null || rect == null || bArr2 == null) {
            return;
        }
        int i5 = i2 * i3;
        int width = rect.width() * rect.height();
        if (bArr.length < i5 || bArr2.length < width) {
            return;
        }
        rotateCropLuminance0(bArr, i2, i3, rect.left, rect.top, rect.right, rect.bottom, i4, bArr2);
    }

    public static native void rotateCropLuminance0(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2);
}
