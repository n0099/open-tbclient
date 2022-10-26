package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bitmap, i, i2)) == null) {
            if (bitmap == null || i <= 0 || i2 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception | OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
