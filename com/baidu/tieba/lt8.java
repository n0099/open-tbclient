package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class lt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;

        public a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = i2;
        }
    }

    public static boolean a(Bitmap bitmap, ArrayList<a> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bitmap, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0 || bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                int i = next.a;
                int i2 = next.b;
                if (i >= bitmap.getWidth() || i2 >= bitmap.getHeight()) {
                    return false;
                }
                int pixel = bitmap.getPixel(i, i2);
                if (sparseArray.get(pixel) != null) {
                    return false;
                }
                next.c = pixel;
                sparseArray.put(pixel, next);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap b(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i, i2)) == null) {
            Bitmap bitmap = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, 17, i, i2, null).compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.close();
                return bitmap;
            } catch (Throwable th) {
                th.printStackTrace();
                return bitmap;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(UtilHelper.getUriFromFile(new File(str), intent, context));
                context.sendBroadcast(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static void d(byte[] bArr, int[] iArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65539, null, bArr, iArr, i, i2) == null) {
            int i3 = i * i2;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = 0;
                while (i7 < i) {
                    int i8 = iArr[i5];
                    int i9 = (iArr[i5] & 16711680) >> 16;
                    int i10 = (iArr[i5] & 65280) >> 8;
                    int i11 = 255;
                    int i12 = (iArr[i5] & 255) >> 0;
                    int i13 = (((((i9 * 66) + (i10 * 129)) + (i12 * 25)) + 128) >> 8) + 16;
                    int i14 = (((((i9 * (-38)) - (i10 * 74)) + (i12 * 112)) + 128) >> 8) + 128;
                    int i15 = (((((i9 * 112) - (i10 * 94)) - (i12 * 18)) + 128) >> 8) + 128;
                    int i16 = i4 + 1;
                    if (i13 < 0) {
                        i13 = 0;
                    } else if (i13 > 255) {
                        i13 = 255;
                    }
                    bArr[i4] = (byte) i13;
                    if (i6 % 2 == 0 && i5 % 2 == 0) {
                        int i17 = i3 + 1;
                        if (i15 < 0) {
                            i15 = 0;
                        } else if (i15 > 255) {
                            i15 = 255;
                        }
                        bArr[i3] = (byte) i15;
                        i3 = i17 + 1;
                        if (i14 < 0) {
                            i11 = 0;
                        } else if (i14 <= 255) {
                            i11 = i14;
                        }
                        bArr[i17] = (byte) i11;
                    }
                    i5++;
                    i7++;
                    i4 = i16;
                }
            }
        }
    }

    public static byte[] e(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap)) == null) ? g(bitmap.getWidth(), bitmap.getHeight(), bitmap) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v2, resolved type: java.util.ArrayList<com.baidu.tieba.lt8$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<a> f(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            if (bitmap != null && !bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                SparseArray sparseArray = new SparseArray();
                int i = 0;
                loop0: for (int i2 = 0; i2 < width; i2++) {
                    for (int i3 = 0; i3 < height; i3++) {
                        int pixel = bitmap.getPixel(i2, i3);
                        a aVar = new a(i2, i3);
                        if (sparseArray.get(pixel) == null) {
                            sparseArray.put(pixel, aVar);
                            i++;
                        }
                        if (i == 3) {
                            break loop0;
                        }
                    }
                }
                ArrayList<a> arrayList = new ArrayList<>();
                for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                    arrayList.add(sparseArray.valueAt(i4));
                }
                return arrayList;
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeL.objValue;
    }

    public static byte[] g(int i, int i2, Bitmap bitmap) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65542, null, i, i2, bitmap)) == null) {
            int i3 = i * i2;
            try {
                int[] iArr = new int[i3];
                bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
                byte[] bArr = new byte[(i3 * 3) / 2];
                d(bArr, iArr, i, i2);
                return bArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static Bitmap h(Bitmap bitmap, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, bitmap, f)) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeLF.objValue;
    }
}
