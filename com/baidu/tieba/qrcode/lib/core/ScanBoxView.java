package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qa8;
/* loaded from: classes4.dex */
public class ScanBoxView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public int C;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public int H;
    public int I;
    public boolean J;
    public int K;
    public boolean L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public Drawable Q;
    public Bitmap R;
    public float S;
    public float T;
    public Bitmap U;
    public Bitmap V;
    public Bitmap W;
    public Bitmap a;
    public Bitmap a0;
    public Bitmap b;
    public float b0;
    public Bitmap c;
    public StaticLayout c0;
    public Bitmap d;
    public int d0;
    public int e;
    public boolean e0;
    public int f;
    public Context f0;
    public Rect g;
    public ColorMatrixColorFilter g0;
    public float h;
    public float i;
    public Paint j;
    public TextPaint k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public Drawable w;
    public Bitmap x;
    public int y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanBoxView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f0 = context;
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.l = Color.parseColor("#33FFFFFF");
        this.m = qa8.b(context, 20.0f);
        this.n = qa8.b(context, 3.0f);
        this.s = qa8.b(context, 1.0f);
        this.t = -1;
        this.r = qa8.b(context, 90.0f);
        this.o = qa8.b(context, 200.0f);
        this.q = qa8.b(context, 140.0f);
        this.u = 0;
        this.v = false;
        this.w = null;
        this.x = null;
        this.y = qa8.b(context, 1.0f);
        this.z = -1;
        this.A = 1000;
        this.B = false;
        this.C = 0;
        this.D = false;
        this.e = qa8.b(context, 2.0f);
        this.G = null;
        this.H = qa8.f(context, 14.0f);
        this.I = -1;
        this.J = false;
        this.K = qa8.b(context, 20.0f);
        this.L = false;
        this.M = Color.parseColor("#22000000");
        this.N = false;
        this.O = false;
        this.P = false;
        TextPaint textPaint = new TextPaint();
        this.k = textPaint;
        textPaint.setAntiAlias(true);
        this.d0 = qa8.b(context, 4.0f);
        this.e0 = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.g0 = new ColorMatrixColorFilter(colorMatrix2);
    }

    private int getBitmapOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.y / 2 : invokeV.intValue;
    }

    private int getMainFrameBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.g.bottom + getBitmapOffset() : invokeV.intValue;
    }

    private int getMainFrameLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (this.g.left - getBitmapOffset()) - 1 : invokeV.intValue;
    }

    private int getMainFrameRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.g.right + getBitmapOffset() : invokeV.intValue;
    }

    private int getMainFrameTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? (this.g.top - getBitmapOffset()) - 1 : invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Drawable drawable = this.Q;
            if (drawable != null) {
                this.W = ((BitmapDrawable) drawable).getBitmap();
            }
            if (this.W == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f080ec7);
                this.W = decodeResource;
                this.W = qa8.e(decodeResource, this.t);
            }
            Bitmap a = qa8.a(this.W, 90);
            this.a0 = a;
            Bitmap a2 = qa8.a(a, 90);
            this.a0 = a2;
            this.a0 = qa8.a(a2, 90);
            Drawable drawable2 = this.w;
            if (drawable2 != null) {
                this.U = ((BitmapDrawable) drawable2).getBitmap();
            }
            if (this.U == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f080ec7);
                this.U = decodeResource2;
                this.U = qa8.e(decodeResource2, this.t);
            }
            this.V = qa8.a(this.U, 90);
            this.b0 = (this.n * 1.0f) / 2.0f;
            this.k.setTextSize(this.H);
            this.k.setColor(this.I);
            setIsBarcode(this.D);
        }
    }

    public final void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.D) {
                i = this.r + this.C;
            } else {
                i = this.r;
            }
            int width = (getWidth() - this.o) / 2;
            Rect rect = new Rect(width, i, this.o + width, this.p + i);
            this.g = rect;
            if (this.D) {
                float f = rect.left + this.b0 + 0.5f;
                this.i = f;
                this.T = f;
                return;
            }
            float f2 = rect.top + this.b0 + 0.5f;
            this.h = f2;
            this.S = f2;
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.y <= 0) {
            return;
        }
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(this.z);
        this.j.setAntiAlias(false);
        this.j.setStrokeWidth(this.y);
        canvas.drawRect(this.g, this.j);
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            this.j.reset();
            this.j.setAntiAlias(false);
            canvas.drawBitmap(this.a, getMainFrameLeft(), getMainFrameTop(), this.j);
            canvas.drawBitmap(this.b, getMainFrameRight() - this.a.getWidth(), getMainFrameTop(), this.j);
            canvas.drawBitmap(this.c, getMainFrameLeft(), getMainFrameBottom() - this.a.getHeight(), this.j);
            canvas.drawBitmap(this.d, getMainFrameRight() - this.a.getWidth(), getMainFrameBottom() - this.a.getHeight(), this.j);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (this.l != 0) {
                this.j.setStyle(Paint.Style.FILL);
                this.j.setColor(this.l);
                float f = width;
                canvas.drawRect(0.0f, 0.0f, f, this.g.top, this.j);
                Rect rect = this.g;
                canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.j);
                Rect rect2 = this.g;
                canvas.drawRect(rect2.right + 1, rect2.top, f, rect2.bottom + 1, this.j);
                canvas.drawRect(0.0f, this.g.bottom + 1, f, height, this.j);
            }
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (this.D) {
                if (this.R != null) {
                    Rect rect = this.g;
                    float f = this.b0;
                    int i = this.u;
                    RectF rectF = new RectF(rect.left + f + 0.5f, rect.top + f + i, this.T, (rect.bottom - f) - i);
                    Rect rect2 = new Rect((int) (this.R.getWidth() - rectF.width()), 0, this.R.getWidth(), this.R.getHeight());
                    if (rect2.left < 0) {
                        rect2.left = 0;
                        rectF.left = rectF.right - rect2.width();
                    }
                    canvas.drawBitmap(this.R, rect2, rectF, this.j);
                } else if (this.x != null) {
                    float f2 = this.i;
                    canvas.drawBitmap(this.x, (Rect) null, new RectF(f2, this.g.top + this.b0 + this.u, this.x.getWidth() + f2, (this.g.bottom - this.b0) - this.u), this.j);
                } else {
                    this.j.setStyle(Paint.Style.FILL);
                    this.j.setColor(this.t);
                    float f3 = this.i;
                    Rect rect3 = this.g;
                    float f4 = this.b0;
                    int i2 = this.u;
                    canvas.drawRect(f3, rect3.top + f4 + i2, this.s + f3, (rect3.bottom - f4) - i2, this.j);
                }
            } else if (this.R != null) {
                Rect rect4 = this.g;
                float f5 = this.b0;
                int i3 = this.u;
                RectF rectF2 = new RectF(rect4.left + f5 + i3, rect4.top + f5 + 0.5f, (rect4.right - f5) - i3, this.S);
                Rect rect5 = new Rect(0, (int) (this.R.getHeight() - rectF2.height()), this.R.getWidth(), this.R.getHeight());
                if (rect5.top < 0) {
                    rect5.top = 0;
                    rectF2.top = rectF2.bottom - rect5.height();
                }
                this.j.setColorFilter(this.g0);
                canvas.drawBitmap(this.R, rect5, rectF2, this.j);
            } else if (this.x != null) {
                Rect rect6 = this.g;
                float f6 = this.b0;
                int i4 = this.u;
                float f7 = rect6.left + f6 + i4;
                float f8 = this.h;
                canvas.drawBitmap(this.x, (Rect) null, new RectF(f7, f8, (rect6.right - f6) - i4, this.x.getHeight() + f8), this.j);
            } else {
                this.j.setStyle(Paint.Style.FILL);
                this.j.setColor(this.t);
                Rect rect7 = this.g;
                float f9 = this.b0;
                int i5 = this.u;
                float f10 = this.h;
                canvas.drawRect(rect7.left + f9 + i5, f10, (rect7.right - f9) - i5, f10 + this.s, this.j);
            }
        }
    }

    public final void g(Canvas canvas) {
        Rect rect;
        Rect rect2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || TextUtils.isEmpty(this.G) || this.c0 == null) {
            return;
        }
        if (this.J) {
            if (this.N) {
                this.j.setColor(this.M);
                this.j.setStyle(Paint.Style.FILL);
                if (this.L) {
                    Rect rect3 = new Rect();
                    TextPaint textPaint = this.k;
                    String str = this.G;
                    textPaint.getTextBounds(str, 0, str.length(), rect3);
                    float width = ((canvas.getWidth() - rect3.width()) / 2) - this.d0;
                    RectF rectF = new RectF(width, (this.g.bottom + this.K) - this.d0, rect3.width() + width + (this.d0 * 2), this.g.bottom + this.K + this.c0.getHeight() + this.d0);
                    int i = this.d0;
                    canvas.drawRoundRect(rectF, i, i, this.j);
                } else {
                    int i2 = this.g.bottom;
                    int i3 = this.K;
                    RectF rectF2 = new RectF(rect2.left, (i2 + i3) - this.d0, rect2.right, i2 + i3 + this.c0.getHeight() + this.d0);
                    int i4 = this.d0;
                    canvas.drawRoundRect(rectF2, i4, i4, this.j);
                }
            }
            canvas.save();
            if (this.L) {
                canvas.translate(0.0f, this.g.bottom + this.K);
            } else {
                Rect rect4 = this.g;
                canvas.translate(rect4.left + this.d0, rect4.bottom + this.K);
            }
            this.c0.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.N) {
            this.j.setColor(this.M);
            this.j.setStyle(Paint.Style.FILL);
            if (this.L) {
                Rect rect5 = new Rect();
                TextPaint textPaint2 = this.k;
                String str2 = this.G;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect5);
                float width2 = ((canvas.getWidth() - rect5.width()) / 2) - this.d0;
                int i5 = this.d0;
                RectF rectF3 = new RectF(width2, ((this.g.top - this.K) - this.c0.getHeight()) - this.d0, rect5.width() + width2 + (i5 * 2), (this.g.top - this.K) + i5);
                int i6 = this.d0;
                canvas.drawRoundRect(rectF3, i6, i6, this.j);
            } else {
                int height = (this.g.top - this.K) - this.c0.getHeight();
                int i7 = this.d0;
                Rect rect6 = this.g;
                RectF rectF4 = new RectF(rect.left, height - i7, rect6.right, (rect6.top - this.K) + i7);
                int i8 = this.d0;
                canvas.drawRoundRect(rectF4, i8, i8, this.j);
            }
        }
        canvas.save();
        if (this.L) {
            canvas.translate(0.0f, (this.g.top - this.K) - this.c0.getHeight());
        } else {
            Rect rect7 = this.g;
            canvas.translate(rect7.left + this.d0, (rect7.top - this.K) - this.c0.getHeight());
        }
        this.c0.draw(canvas);
        canvas.restore();
    }

    public int getAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.A : invokeV.intValue;
    }

    public String getBarCodeTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public int getBarcodeRectHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z : invokeV.intValue;
    }

    public int getBorderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.y : invokeV.intValue;
    }

    public int getCornerLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.intValue;
    }

    public Drawable getCustomScanLineDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.w : (Drawable) invokeV.objValue;
    }

    public float getHalfCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b0 : invokeV.floatValue;
    }

    public boolean getIsBarcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public int getMaskColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.l : invokeV.intValue;
    }

    public String getQRCodeTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public int getRectHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p : invokeV.intValue;
    }

    public int getRectWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.o : invokeV.intValue;
    }

    public Bitmap getScanLineBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.x : (Bitmap) invokeV.objValue;
    }

    public int getScanLineColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.t : invokeV.intValue;
    }

    public int getScanLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.u : invokeV.intValue;
    }

    public int getScanLineSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : invokeV.intValue;
    }

    public int getTipBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.M : invokeV.intValue;
    }

    public int getTipBackgroundRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.d0 : invokeV.intValue;
    }

    public String getTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public int getTipTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.I : invokeV.intValue;
    }

    public int getTipTextMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.K : invokeV.intValue;
    }

    public int getTipTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.H : invokeV.intValue;
    }

    public StaticLayout getTipTextSl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.c0 : (StaticLayout) invokeV.objValue;
    }

    public int getToolbarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.C : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.r : invokeV.intValue;
    }

    public Rect h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            if (this.e0) {
                Rect rect = new Rect(this.g);
                float measuredHeight = (i * 1.0f) / getMeasuredHeight();
                rect.left = (int) (rect.left * measuredHeight);
                rect.right = (int) (rect.right * measuredHeight);
                rect.top = (int) (rect.top * measuredHeight);
                rect.bottom = (int) (rect.bottom * measuredHeight);
                return rect;
            }
            return null;
        }
        return (Rect) invokeI.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = this.m;
            options.outWidth = i;
            options.outHeight = i;
            this.a = BitmapHelper.getResBitmap(this.f0, R.drawable.obfuscated_res_0x7f080a44, options);
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            Bitmap bitmap = this.a;
            this.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.a.getHeight(), matrix, false);
            matrix.postRotate(180.0f);
            Bitmap bitmap2 = this.a;
            this.c = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.a.getHeight(), matrix, false);
            matrix.postRotate(270.0f);
            Bitmap bitmap3 = this.a;
            this.d = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.a.getHeight(), matrix, false);
        }
    }

    public final void j(int i, TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i, typedArray) == null) {
            if (i == 29) {
                this.r = typedArray.getDimensionPixelSize(i, this.r);
            } else if (i == 6) {
                this.n = typedArray.getDimensionPixelSize(i, this.n);
            } else if (i == 5) {
                this.m = typedArray.getDimensionPixelSize(i, this.m);
            } else if (i == 23) {
                this.s = typedArray.getDimensionPixelSize(i, this.s);
            } else if (i == 20) {
                this.o = typedArray.getDimensionPixelSize(i, this.o);
            } else if (i == 18) {
                this.l = typedArray.getColor(i, this.l);
            } else if (i == 21) {
                this.t = typedArray.getColor(i, this.t);
            } else if (i == 22) {
                this.u = typedArray.getDimensionPixelSize(i, this.u);
            } else if (i == 14) {
                this.v = typedArray.getBoolean(i, this.v);
            } else if (i == 8) {
                this.w = typedArray.getDrawable(i);
            } else if (i == 4) {
                this.y = typedArray.getDimensionPixelSize(i, this.y);
            } else if (i == 3) {
                this.z = typedArray.getColor(i, this.z);
            } else if (i == 0) {
                this.A = typedArray.getInteger(i, this.A);
            } else if (i == 10) {
                this.B = typedArray.getBoolean(i, this.B);
            } else if (i == 28) {
                this.C = typedArray.getDimensionPixelSize(i, this.C);
            } else if (i == 2) {
                this.q = typedArray.getDimensionPixelSize(i, this.q);
            } else if (i == 9) {
                this.D = typedArray.getBoolean(i, this.D);
            } else if (i == 1) {
                this.F = typedArray.getString(i);
            } else if (i == 19) {
                this.E = typedArray.getString(i);
            } else if (i == 27) {
                this.H = typedArray.getDimensionPixelSize(i, this.H);
            } else if (i == 25) {
                this.I = typedArray.getColor(i, this.I);
            } else if (i == 17) {
                this.J = typedArray.getBoolean(i, this.J);
            } else if (i == 26) {
                this.K = typedArray.getDimensionPixelSize(i, this.K);
            } else if (i == 16) {
                this.L = typedArray.getBoolean(i, this.L);
            } else if (i == 15) {
                this.N = typedArray.getBoolean(i, this.N);
            } else if (i == 24) {
                this.M = typedArray.getColor(i, this.M);
            } else if (i == 12) {
                this.O = typedArray.getBoolean(i, this.O);
            } else if (i == 13) {
                this.P = typedArray.getBoolean(i, this.P);
            } else if (i == 7) {
                this.Q = typedArray.getDrawable(i);
            } else if (i == 11) {
                this.e0 = typedArray.getBoolean(i, this.e0);
            }
        }
    }

    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04057e, R.attr.obfuscated_res_0x7f04057f, R.attr.obfuscated_res_0x7f040580, R.attr.obfuscated_res_0x7f040581, R.attr.obfuscated_res_0x7f040582, R.attr.obfuscated_res_0x7f040583, R.attr.obfuscated_res_0x7f040584, R.attr.obfuscated_res_0x7f040585, R.attr.obfuscated_res_0x7f040586, R.attr.obfuscated_res_0x7f040587, R.attr.obfuscated_res_0x7f040588, R.attr.obfuscated_res_0x7f040589, R.attr.obfuscated_res_0x7f04058a, R.attr.obfuscated_res_0x7f04058b, R.attr.obfuscated_res_0x7f04058c, R.attr.obfuscated_res_0x7f04058d, R.attr.obfuscated_res_0x7f04058e, R.attr.obfuscated_res_0x7f04058f, R.attr.obfuscated_res_0x7f040590, R.attr.obfuscated_res_0x7f040591, R.attr.obfuscated_res_0x7f040592, R.attr.obfuscated_res_0x7f040593, R.attr.obfuscated_res_0x7f040594, R.attr.obfuscated_res_0x7f040595, R.attr.obfuscated_res_0x7f040596, R.attr.obfuscated_res_0x7f040597, R.attr.obfuscated_res_0x7f040598, R.attr.obfuscated_res_0x7f040599, R.attr.obfuscated_res_0x7f04059a, R.attr.obfuscated_res_0x7f04059b});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                j(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
            }
            obtainStyledAttributes.recycle();
            a();
            i();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.D) {
                if (this.R == null) {
                    this.i += this.e;
                    int i = this.s;
                    Bitmap bitmap = this.x;
                    if (bitmap != null) {
                        i = bitmap.getWidth();
                    }
                    if (this.O) {
                        float f = this.i;
                        Rect rect = this.g;
                        float f2 = this.b0;
                        if (i + f > rect.right - f2 || f < rect.left + f2) {
                            this.e = -this.e;
                        }
                    } else {
                        float f3 = this.i + i;
                        Rect rect2 = this.g;
                        float f4 = this.b0;
                        if (f3 > rect2.right - f4) {
                            this.i = rect2.left + f4 + 0.5f;
                        }
                    }
                } else {
                    float f5 = this.T + this.e;
                    this.T = f5;
                    Rect rect3 = this.g;
                    float f6 = this.b0;
                    if (f5 > rect3.right - f6) {
                        this.T = rect3.left + f6 + 0.5f;
                    }
                }
            } else if (this.R == null) {
                this.h += this.e;
                int i2 = this.s;
                Bitmap bitmap2 = this.x;
                if (bitmap2 != null) {
                    i2 = bitmap2.getHeight();
                }
                if (this.O) {
                    float f7 = this.h;
                    Rect rect4 = this.g;
                    float f8 = this.b0;
                    if (i2 + f7 > rect4.bottom - f8 || f7 < rect4.top + f8) {
                        this.e = -this.e;
                    }
                } else {
                    float f9 = this.h + i2;
                    Rect rect5 = this.g;
                    float f10 = this.b0;
                    if (f9 > rect5.bottom - f10) {
                        this.h = rect5.top + f10 + 0.5f;
                    }
                }
            } else {
                float f11 = this.S + this.e;
                this.S = f11;
                Rect rect6 = this.g;
                float f12 = this.b0;
                if (f11 > rect6.bottom - f12) {
                    this.S = rect6.top + f12 + 0.5f;
                }
            }
            long j = this.f;
            Rect rect7 = this.g;
            postInvalidateDelayed(j, rect7.left, rect7.top, rect7.right, rect7.bottom);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.k.setColor(this.I);
            setIsBarcode(false);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, canvas) == null) || this.g == null) {
            return;
        }
        e(canvas);
        c(canvas);
        f(canvas);
        g(canvas);
        d(canvas);
        l();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048617, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            b();
        }
    }

    public void setAnimTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.A = i;
        }
    }

    public void setBarCodeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.F = str;
        }
    }

    public void setBarcodeRectHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.q = i;
        }
    }

    public void setBorderColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.z = i;
        }
    }

    public void setBorderSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.y = i;
        }
    }

    public void setCenterVertical(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.B = z;
        }
    }

    public void setCornerLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.m = i;
        }
    }

    public void setCornerSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.n = i;
        }
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, drawable) == null) {
            this.w = drawable;
        }
    }

    public void setHalfCornerSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048627, this, f) == null) {
            this.b0 = f;
        }
    }

    public void setIsBarcode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.D = z;
            if (this.Q == null && !this.P) {
                if (this.w != null || this.v) {
                    if (this.D) {
                        this.x = this.V;
                    } else {
                        this.x = this.U;
                    }
                }
            } else if (this.D) {
                this.R = this.a0;
            } else {
                this.R = this.W;
            }
            if (this.D) {
                this.G = this.F;
                this.p = this.q;
                this.f = (int) (((this.A * 1.0f) * this.e) / this.o);
            } else {
                this.G = this.E;
                int i = this.o;
                this.p = i;
                this.f = (int) (((this.A * 1.0f) * this.e) / i);
            }
            if (!TextUtils.isEmpty(this.G)) {
                if (this.L) {
                    this.c0 = new StaticLayout(this.G, this.k, qa8.d(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                } else {
                    this.c0 = new StaticLayout(this.G, this.k, this.o - (this.d0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                }
            }
            if (this.B) {
                int i2 = qa8.d(getContext()).y;
                int i3 = this.C;
                if (i3 == 0) {
                    this.r = (i2 - this.p) / 2;
                } else if (this.D) {
                    this.r = ((i2 - this.p) / 2) + (i3 / 2);
                } else {
                    this.r = (i2 - this.p) / 2;
                }
            }
            b();
            postInvalidate();
        }
    }

    public void setMaskColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.l = i;
        }
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.e0 = z;
        }
    }

    public void setQRCodeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.E = str;
        }
    }

    public void setRectHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i) == null) {
            this.p = i;
        }
    }

    public void setRectWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            this.o = i;
        }
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bitmap) == null) {
            this.x = bitmap;
        }
    }

    public void setScanLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.t = i;
        }
    }

    public void setScanLineMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.u = i;
        }
    }

    public void setScanLineReverse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.O = z;
        }
    }

    public void setScanLineSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.s = i;
        }
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.P = z;
        }
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.v = z;
        }
    }

    public void setShowTipBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.N = z;
        }
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.L = z;
        }
    }

    public void setTipBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.M = i;
        }
    }

    public void setTipBackgroundRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.d0 = i;
        }
    }

    public void setTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.G = str;
        }
    }

    public void setTipTextBelowRect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.J = z;
        }
    }

    public void setTipTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.I = i;
        }
    }

    public void setTipTextMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.K = i;
        }
    }

    public void setTipTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.H = i;
        }
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, staticLayout) == null) {
            this.c0 = staticLayout;
        }
    }

    public void setToolbarHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.C = i;
        }
    }

    public void setTopOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i) == null) {
            this.r = i;
        }
    }
}
