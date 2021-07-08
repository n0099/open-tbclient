package com.bytedance.sdk.component.adnet.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.b.d;
/* loaded from: classes5.dex */
public class a implements d.InterfaceC0314d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap.Config f28047a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28048b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28049c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView.ScaleType f28050d;

    public a(int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), scaleType, config};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28047a = config;
        this.f28048b = i2;
        this.f28049c = i3;
        this.f28050d = scaleType;
    }

    @VisibleForTesting
    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIII = interceptable.invokeIIII(65537, null, i2, i3, i4, i5)) != null) {
            return invokeIIII.intValue;
        }
        double min = Math.min(i2 / i4, i3 / i5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    public static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), scaleType})) == null) {
            if (i2 == 0 && i3 == 0) {
                return i4;
            }
            if (scaleType == ImageView.ScaleType.FIT_XY) {
                return i2 == 0 ? i4 : i2;
            } else if (i2 == 0) {
                return (int) (i4 * (i3 / i5));
            } else {
                if (i3 == 0) {
                    return i2;
                }
                double d2 = i5 / i4;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d3 = i3;
                    return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
                }
                double d4 = i3;
                return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.bytedance.sdk.component.adnet.b.d.InterfaceC0314d
    public Bitmap a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (this.f28048b == 0 && this.f28049c == 0) {
                options.inPreferredConfig = this.f28047a;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a2 = a(this.f28048b, this.f28049c, i2, i3, this.f28050d);
            int a3 = a(this.f28049c, this.f28048b, i3, i2, this.f28050d);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a2, a3);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null) {
                if (decodeByteArray.getWidth() > a2 || decodeByteArray.getHeight() > a3) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                    decodeByteArray.recycle();
                    return createScaledBitmap;
                }
                return decodeByteArray;
            }
            return decodeByteArray;
        }
        return (Bitmap) invokeL.objValue;
    }
}
