package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class vba {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<EncodeHintType, Object> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236404, "Lcom/baidu/tieba/vba;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236404, "Lcom/baidu/tieba/vba;");
                return;
            }
        }
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        a = enumMap;
        enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) "utf-8");
        a.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        a.put(EncodeHintType.MARGIN, 0);
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bitmap, bitmap2)) == null) {
            if (bitmap != null && bitmap2 != null) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = bitmap2.getWidth();
                int height2 = bitmap2.getHeight();
                float f = ((width * 1.0f) / 5.0f) / width2;
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    canvas.scale(f, f, width / 2, height / 2);
                    canvas.drawBitmap(bitmap2, (width - width2) / 2, (height - height2) / 2, (Paint) null);
                    canvas.save();
                    canvas.restore();
                    return createBitmap;
                } catch (Exception unused) {
                    return null;
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            return c(str, i, -16777216, -1, null);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap c(String str, int i, int i2, int i3, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitmap})) == null) {
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, i, i, a);
                int[] iArr = new int[i * i];
                for (int i4 = 0; i4 < i; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        if (encode.get(i5, i4)) {
                            iArr[(i4 * i) + i5] = i2;
                        } else {
                            iArr[(i4 * i) + i5] = i3;
                        }
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
                return a(createBitmap, bitmap);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
