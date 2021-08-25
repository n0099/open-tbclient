package com.bytedance.sdk.component.image.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ImageView.ScaleType f65032a;

    /* renamed from: b  reason: collision with root package name */
    public static final Bitmap.Config f65033b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap.Config f65034c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65035d;

    /* renamed from: e  reason: collision with root package name */
    public final int f65036e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView.ScaleType f65037f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1240750188, "Lcom/bytedance/sdk/component/image/c/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1240750188, "Lcom/bytedance/sdk/component/image/c/b/a;");
                return;
            }
        }
        f65032a = ImageView.ScaleType.CENTER_INSIDE;
        f65033b = Bitmap.Config.ARGB_4444;
    }

    public a(int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), scaleType, config};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f65034c = config;
        this.f65035d = i2;
        this.f65036e = i3;
        this.f65037f = scaleType;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) != null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), scaleType})) == null) {
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

    public Bitmap a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (this.f65035d == 0 && this.f65036e == 0) {
                options.inPreferredConfig = this.f65034c;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a2 = a(this.f65035d, this.f65036e, i2, i3, this.f65037f);
            int a3 = a(this.f65036e, this.f65035d, i3, i2, this.f65037f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a2, a3);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null) {
                if (decodeByteArray.getWidth() > a2 || decodeByteArray.getHeight() > a3) {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                    if (createScaledBitmap != decodeByteArray) {
                        decodeByteArray.recycle();
                    }
                    return createScaledBitmap;
                }
                return decodeByteArray;
            }
            return decodeByteArray;
        }
        return (Bitmap) invokeL.objValue;
    }
}
