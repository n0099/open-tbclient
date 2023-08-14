package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n06 extends BitmapDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public Rect c;
    public String d;
    public Matrix e;
    public int f;
    public int g;
    public float h;

    public n06(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = 0.9f;
        this.b = context;
        this.a = i;
        this.d = String.valueOf(i);
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.f = i;
            this.g = i2;
            Rect rect = this.c;
            if (rect == null) {
                return;
            }
            super.setBounds(rect.left, rect.top + i2, rect.right, rect.bottom);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BdImage bdImage;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) && this.a > 0 && this.b != null) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            TbImageMemoryCache B = TbImageMemoryCache.B();
            if (B != null && (str2 = this.d) != null) {
                bdImage = B.D(str2);
            } else {
                bdImage = null;
            }
            if (bdImage == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.b, this.a);
                if (resBitmap != null) {
                    bdImage = new BdImage(resBitmap, false, (String) null);
                }
                if (B != null && bdImage != null && (str = this.d) != null) {
                    B.m(str, bdImage);
                }
            }
            if (bdImage != null) {
                int width = bdImage.getWidth();
                int height = bdImage.getHeight();
                if (width > 0 && height > 0 && this.c != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (height <= 0 && width <= 0 && this.f == 0 && this.g == 0) {
                        bdImage.drawImageTo(canvas, 0.0f, 0.0f, (Paint) null);
                    } else {
                        if (this.e == null) {
                            Matrix matrix = new Matrix();
                            this.e = matrix;
                            matrix.postTranslate(this.f, this.g);
                            Rect rect = this.c;
                            float f = (rect.right - rect.left) / width;
                            float f2 = (rect.bottom - rect.top) / height;
                            if (f >= f2) {
                                f = f2;
                            }
                            if (f < 1.0f) {
                                this.e.postScale(f, f);
                            }
                        }
                        if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                            float f3 = this.h;
                            colorMatrix.setScale(f3, f3, f3, 1.0f);
                            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                            bdImage.drawImageTo(canvas, this.e, paint);
                        } else {
                            bdImage.drawImageTo(canvas, this.e, null);
                        }
                    }
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            this.c = new Rect(i, i2, i3, i4);
            this.e = null;
            super.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            this.c = new Rect(rect);
            this.e = null;
            super.setBounds(rect);
        }
    }
}
