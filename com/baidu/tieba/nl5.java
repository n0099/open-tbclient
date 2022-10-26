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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nl5 extends BitmapDrawable {
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
    public float i;

    public nl5(Context context, int i) {
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
        this.i = 0.75f;
        this.b = context;
        this.a = i;
        this.d = String.valueOf(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        pn pnVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && this.a > 0 && this.b != null) {
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            l85 k = l85.k();
            if (k != null && (str2 = this.d) != null) {
                pnVar = k.m(str2);
            } else {
                pnVar = null;
            }
            if (pnVar == null) {
                Bitmap resBitmap = BitmapHelper.getResBitmap(this.b, this.a);
                if (resBitmap != null) {
                    pnVar = new pn(resBitmap, false, (String) null);
                }
                if (k != null && pnVar != null && (str = this.d) != null) {
                    k.d(str, pnVar);
                }
            }
            if (pnVar != null) {
                int r = pnVar.r();
                int m = pnVar.m();
                if (r > 0 && m > 0 && this.c != null) {
                    canvas.save();
                    canvas.clipRect(super.getBounds());
                    if (m <= 0 && r <= 0 && this.f == 0 && this.g == 0) {
                        pnVar.e(canvas, 0.0f, 0.0f, null);
                    } else {
                        if (this.e == null) {
                            Matrix matrix = new Matrix();
                            this.e = matrix;
                            matrix.postTranslate(this.f, this.g);
                            Rect rect = this.c;
                            float f = (rect.right - rect.left) / r;
                            float f2 = (rect.bottom - rect.top) / m;
                            if (f >= f2) {
                                f = f2;
                            }
                            if (f < 1.0f) {
                                this.e.postScale(f, f);
                            }
                        }
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            float f3 = this.i;
                            colorMatrix.setScale(f3, f3, f3, 1.0f);
                            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                            pnVar.f(canvas, this.e, paint);
                        } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                            float f4 = this.h;
                            colorMatrix.setScale(f4, f4, f4, 1.0f);
                            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                            pnVar.f(canvas, this.e, paint);
                        } else {
                            pnVar.f(canvas, this.e, null);
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
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.c = new Rect(i, i2, i3, i4);
            this.e = null;
            super.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) {
            this.c = new Rect(rect);
            this.e = null;
            super.setBounds(rect);
        }
    }
}
