package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class li5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 <= i2 && i4 <= i) {
                return 1;
            }
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            if (round >= round2) {
                round = round2;
            }
            if (round >= 3) {
                if (round < 6.5d) {
                    return 4;
                }
                if (round < 8) {
                    return 8;
                }
            }
            return round;
        }
        return invokeLII.intValue;
    }

    public static Bitmap b(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            Bitmap bitmap = null;
            if (view2 == null || view2.getWidth() <= 0 || view2.getHeight() <= 0) {
                return null;
            }
            try {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                    view2.draw(new Canvas(createBitmap));
                    return createBitmap;
                } catch (OutOfMemoryError e) {
                    BdLog.e(e);
                    return bitmap;
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                bitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.RGB_565);
                view2.draw(new Canvas(bitmap));
                return bitmap;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static float[] d(Bitmap bitmap, Matrix matrix) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bitmap, matrix)) == null) {
            float[] fArr = new float[8];
            matrix.mapPoints(fArr, new float[]{0.0f, 0.0f, bitmap.getWidth(), 0.0f, 0.0f, bitmap.getHeight(), bitmap.getWidth(), bitmap.getHeight()});
            return fArr;
        }
        return (float[]) invokeLL.objValue;
    }

    public static int[] e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            return new int[]{options.outWidth, options.outHeight};
        }
        return (int[]) invokeL.objValue;
    }

    public static Bitmap f(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        InterceptResult invokeLLII;
        Bitmap bitmap3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, bitmap, bitmap2, i, i2)) == null) {
            if (bitmap == null || bitmap2 == null || i <= 0 || i2 <= 0) {
                return null;
            }
            try {
                bitmap3 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError unused) {
                bitmap3 = null;
            }
            try {
                Canvas canvas = new Canvas(bitmap3);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return bitmap3;
            } catch (OutOfMemoryError unused2) {
                try {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    bitmap3 = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
                    Canvas canvas2 = new Canvas(bitmap3);
                    canvas2.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                    canvas2.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                    return bitmap3;
                } catch (OutOfMemoryError e) {
                    BdLog.e(e);
                    return bitmap3;
                }
            }
        }
        return (Bitmap) invokeLLII.objValue;
    }
}
