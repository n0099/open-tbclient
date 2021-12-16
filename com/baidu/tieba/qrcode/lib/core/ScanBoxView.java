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
import c.a.s0.g3.b.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ScanBoxView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable A;
    public Bitmap B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public int G;
    public boolean H;
    public String I;
    public String J;
    public String K;
    public int L;
    public int M;
    public boolean N;
    public int O;
    public boolean P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public Drawable U;
    public Bitmap V;
    public float W;
    public float a0;
    public Bitmap b0;
    public Bitmap c0;
    public Bitmap d0;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f49110e;
    public Bitmap e0;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f49111f;
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f49112g;
    public StaticLayout g0;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f49113h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public int f49114i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public int f49115j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f49116k;
    public Context k0;
    public float l;
    public float m;
    public Paint n;
    public TextPaint o;
    public int p;
    public int q;
    public ColorMatrixColorFilter q0;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanBoxView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k0 = context;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.p = Color.parseColor("#33FFFFFF");
        this.q = a.b(context, 20.0f);
        this.r = a.b(context, 3.0f);
        this.w = a.b(context, 1.0f);
        this.x = -1;
        this.v = a.b(context, 90.0f);
        this.s = a.b(context, 200.0f);
        this.u = a.b(context, 140.0f);
        this.y = 0;
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = a.b(context, 1.0f);
        this.D = -1;
        this.E = 1000;
        this.F = false;
        this.G = 0;
        this.H = false;
        this.f49114i = a.b(context, 2.0f);
        this.K = null;
        this.L = a.f(context, 14.0f);
        this.M = -1;
        this.N = false;
        this.O = a.b(context, 20.0f);
        this.P = false;
        this.Q = Color.parseColor("#22000000");
        this.R = false;
        this.S = false;
        this.T = false;
        TextPaint textPaint = new TextPaint();
        this.o = textPaint;
        textPaint.setAntiAlias(true);
        this.h0 = a.b(context, 4.0f);
        this.i0 = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.q0 = new ColorMatrixColorFilter(colorMatrix2);
    }

    private int getBitmapOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.C / 2 : invokeV.intValue;
    }

    private int getMainFrameBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f49116k.bottom + getBitmapOffset() : invokeV.intValue;
    }

    private int getMainFrameLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (this.f49116k.left - getBitmapOffset()) - 1 : invokeV.intValue;
    }

    private int getMainFrameRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.f49116k.right + getBitmapOffset() : invokeV.intValue;
    }

    private int getMainFrameTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? (this.f49116k.top - getBitmapOffset()) - 1 : invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Drawable drawable = this.U;
            if (drawable != null) {
                this.d0 = ((BitmapDrawable) drawable).getBitmap();
            }
            if (this.d0 == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
                this.d0 = decodeResource;
                this.d0 = a.e(decodeResource, this.x);
            }
            Bitmap a = a.a(this.d0, 90);
            this.e0 = a;
            Bitmap a2 = a.a(a, 90);
            this.e0 = a2;
            this.e0 = a.a(a2, 90);
            Drawable drawable2 = this.A;
            if (drawable2 != null) {
                this.b0 = ((BitmapDrawable) drawable2).getBitmap();
            }
            if (this.b0 == null) {
                Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
                this.b0 = decodeResource2;
                this.b0 = a.e(decodeResource2, this.x);
            }
            this.c0 = a.a(this.b0, 90);
            this.f0 = (this.r * 1.0f) / 2.0f;
            this.o.setTextSize(this.L);
            this.o.setColor(this.M);
            setIsBarcode(this.H);
        }
    }

    public final void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.H) {
                i2 = this.v + this.G;
            } else {
                i2 = this.v;
            }
            int width = (getWidth() - this.s) / 2;
            Rect rect = new Rect(width, i2, this.s + width, this.t + i2);
            this.f49116k = rect;
            if (this.H) {
                float f2 = rect.left + this.f0 + 0.5f;
                this.m = f2;
                this.a0 = f2;
                return;
            }
            float f3 = rect.top + this.f0 + 0.5f;
            this.l = f3;
            this.W = f3;
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.C <= 0) {
            return;
        }
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setColor(this.D);
        this.n.setAntiAlias(false);
        this.n.setStrokeWidth(this.C);
        canvas.drawRect(this.f49116k, this.n);
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            this.n.reset();
            this.n.setAntiAlias(false);
            canvas.drawBitmap(this.f49110e, getMainFrameLeft(), getMainFrameTop(), this.n);
            canvas.drawBitmap(this.f49111f, getMainFrameRight() - this.f49110e.getWidth(), getMainFrameTop(), this.n);
            canvas.drawBitmap(this.f49112g, getMainFrameLeft(), getMainFrameBottom() - this.f49110e.getHeight(), this.n);
            canvas.drawBitmap(this.f49113h, getMainFrameRight() - this.f49110e.getWidth(), getMainFrameBottom() - this.f49110e.getHeight(), this.n);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            if (this.p != 0) {
                this.n.setStyle(Paint.Style.FILL);
                this.n.setColor(this.p);
                float f2 = width;
                canvas.drawRect(0.0f, 0.0f, f2, this.f49116k.top, this.n);
                Rect rect = this.f49116k;
                canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.n);
                Rect rect2 = this.f49116k;
                canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.n);
                canvas.drawRect(0.0f, this.f49116k.bottom + 1, f2, height, this.n);
            }
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (this.H) {
                if (this.V != null) {
                    Rect rect = this.f49116k;
                    float f2 = this.f0;
                    int i2 = this.y;
                    RectF rectF = new RectF(rect.left + f2 + 0.5f, rect.top + f2 + i2, this.a0, (rect.bottom - f2) - i2);
                    Rect rect2 = new Rect((int) (this.V.getWidth() - rectF.width()), 0, this.V.getWidth(), this.V.getHeight());
                    if (rect2.left < 0) {
                        rect2.left = 0;
                        rectF.left = rectF.right - rect2.width();
                    }
                    canvas.drawBitmap(this.V, rect2, rectF, this.n);
                } else if (this.B != null) {
                    float f3 = this.m;
                    canvas.drawBitmap(this.B, (Rect) null, new RectF(f3, this.f49116k.top + this.f0 + this.y, this.B.getWidth() + f3, (this.f49116k.bottom - this.f0) - this.y), this.n);
                } else {
                    this.n.setStyle(Paint.Style.FILL);
                    this.n.setColor(this.x);
                    float f4 = this.m;
                    Rect rect3 = this.f49116k;
                    float f5 = this.f0;
                    int i3 = this.y;
                    canvas.drawRect(f4, rect3.top + f5 + i3, this.w + f4, (rect3.bottom - f5) - i3, this.n);
                }
            } else if (this.V != null) {
                Rect rect4 = this.f49116k;
                float f6 = this.f0;
                int i4 = this.y;
                RectF rectF2 = new RectF(rect4.left + f6 + i4, rect4.top + f6 + 0.5f, (rect4.right - f6) - i4, this.W);
                Rect rect5 = new Rect(0, (int) (this.V.getHeight() - rectF2.height()), this.V.getWidth(), this.V.getHeight());
                if (rect5.top < 0) {
                    rect5.top = 0;
                    rectF2.top = rectF2.bottom - rect5.height();
                }
                this.n.setColorFilter(this.q0);
                canvas.drawBitmap(this.V, rect5, rectF2, this.n);
            } else if (this.B != null) {
                Rect rect6 = this.f49116k;
                float f7 = this.f0;
                int i5 = this.y;
                float f8 = rect6.left + f7 + i5;
                float f9 = this.l;
                canvas.drawBitmap(this.B, (Rect) null, new RectF(f8, f9, (rect6.right - f7) - i5, this.B.getHeight() + f9), this.n);
            } else {
                this.n.setStyle(Paint.Style.FILL);
                this.n.setColor(this.x);
                Rect rect7 = this.f49116k;
                float f10 = this.f0;
                int i6 = this.y;
                float f11 = this.l;
                canvas.drawRect(rect7.left + f10 + i6, f11, (rect7.right - f10) - i6, f11 + this.w, this.n);
            }
        }
    }

    public final void g(Canvas canvas) {
        Rect rect;
        Rect rect2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) || TextUtils.isEmpty(this.K) || this.g0 == null) {
            return;
        }
        if (this.N) {
            if (this.R) {
                this.n.setColor(this.Q);
                this.n.setStyle(Paint.Style.FILL);
                if (this.P) {
                    Rect rect3 = new Rect();
                    TextPaint textPaint = this.o;
                    String str = this.K;
                    textPaint.getTextBounds(str, 0, str.length(), rect3);
                    float width = ((canvas.getWidth() - rect3.width()) / 2) - this.h0;
                    RectF rectF = new RectF(width, (this.f49116k.bottom + this.O) - this.h0, rect3.width() + width + (this.h0 * 2), this.f49116k.bottom + this.O + this.g0.getHeight() + this.h0);
                    int i2 = this.h0;
                    canvas.drawRoundRect(rectF, i2, i2, this.n);
                } else {
                    int i3 = this.f49116k.bottom;
                    int i4 = this.O;
                    RectF rectF2 = new RectF(rect2.left, (i3 + i4) - this.h0, rect2.right, i3 + i4 + this.g0.getHeight() + this.h0);
                    int i5 = this.h0;
                    canvas.drawRoundRect(rectF2, i5, i5, this.n);
                }
            }
            canvas.save();
            if (this.P) {
                canvas.translate(0.0f, this.f49116k.bottom + this.O);
            } else {
                Rect rect4 = this.f49116k;
                canvas.translate(rect4.left + this.h0, rect4.bottom + this.O);
            }
            this.g0.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.R) {
            this.n.setColor(this.Q);
            this.n.setStyle(Paint.Style.FILL);
            if (this.P) {
                Rect rect5 = new Rect();
                TextPaint textPaint2 = this.o;
                String str2 = this.K;
                textPaint2.getTextBounds(str2, 0, str2.length(), rect5);
                float width2 = ((canvas.getWidth() - rect5.width()) / 2) - this.h0;
                int i6 = this.h0;
                RectF rectF3 = new RectF(width2, ((this.f49116k.top - this.O) - this.g0.getHeight()) - this.h0, rect5.width() + width2 + (i6 * 2), (this.f49116k.top - this.O) + i6);
                int i7 = this.h0;
                canvas.drawRoundRect(rectF3, i7, i7, this.n);
            } else {
                int height = (this.f49116k.top - this.O) - this.g0.getHeight();
                int i8 = this.h0;
                Rect rect6 = this.f49116k;
                RectF rectF4 = new RectF(rect.left, height - i8, rect6.right, (rect6.top - this.O) + i8);
                int i9 = this.h0;
                canvas.drawRoundRect(rectF4, i9, i9, this.n);
            }
        }
        canvas.save();
        if (this.P) {
            canvas.translate(0.0f, (this.f49116k.top - this.O) - this.g0.getHeight());
        } else {
            Rect rect7 = this.f49116k;
            canvas.translate(rect7.left + this.h0, (rect7.top - this.O) - this.g0.getHeight());
        }
        this.g0.draw(canvas);
        canvas.restore();
    }

    public int getAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : invokeV.intValue;
    }

    public String getBarCodeTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public int getBarcodeRectHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.u : invokeV.intValue;
    }

    public int getBorderColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.D : invokeV.intValue;
    }

    public int getBorderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.C : invokeV.intValue;
    }

    public int getCornerLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q : invokeV.intValue;
    }

    public int getCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : invokeV.intValue;
    }

    public Drawable getCustomScanLineDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.A : (Drawable) invokeV.objValue;
    }

    public float getHalfCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f0 : invokeV.floatValue;
    }

    public boolean getIsBarcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public int getMaskColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.p : invokeV.intValue;
    }

    public String getQRCodeTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public int getRectHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : invokeV.intValue;
    }

    public int getRectWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.s : invokeV.intValue;
    }

    public Rect getScanBoxAreaRect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (this.i0) {
                Rect rect = new Rect(this.f49116k);
                float measuredHeight = (i2 * 1.0f) / getMeasuredHeight();
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

    public Bitmap getScanLineBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.B : (Bitmap) invokeV.objValue;
    }

    public int getScanLineColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.x : invokeV.intValue;
    }

    public int getScanLineMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.y : invokeV.intValue;
    }

    public int getScanLineSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.w : invokeV.intValue;
    }

    public int getTipBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Q : invokeV.intValue;
    }

    public int getTipBackgroundRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.h0 : invokeV.intValue;
    }

    public String getTipText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public int getTipTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.M : invokeV.intValue;
    }

    public int getTipTextMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.O : invokeV.intValue;
    }

    public int getTipTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.L : invokeV.intValue;
    }

    public StaticLayout getTipTextSl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.g0 : (StaticLayout) invokeV.objValue;
    }

    public int getToolbarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.G : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.v : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = this.q;
            options.outWidth = i2;
            options.outHeight = i2;
            this.f49110e = BitmapHelper.getResBitmap(this.k0, R.drawable.icon_scan_upperleft, options);
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            Bitmap bitmap = this.f49110e;
            this.f49111f = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f49110e.getHeight(), matrix, false);
            matrix.postRotate(180.0f);
            Bitmap bitmap2 = this.f49110e;
            this.f49112g = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f49110e.getHeight(), matrix, false);
            matrix.postRotate(270.0f);
            Bitmap bitmap3 = this.f49110e;
            this.f49113h = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f49110e.getHeight(), matrix, false);
        }
    }

    public final void i(int i2, TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048612, this, i2, typedArray) == null) {
            if (i2 == R$styleable.QRCodeView_qrcv_topOffset) {
                this.v = typedArray.getDimensionPixelSize(i2, this.v);
            } else if (i2 == R$styleable.QRCodeView_qrcv_cornerSize) {
                this.r = typedArray.getDimensionPixelSize(i2, this.r);
            } else if (i2 == R$styleable.QRCodeView_qrcv_cornerLength) {
                this.q = typedArray.getDimensionPixelSize(i2, this.q);
            } else if (i2 == R$styleable.QRCodeView_qrcv_scanLineSize) {
                this.w = typedArray.getDimensionPixelSize(i2, this.w);
            } else if (i2 == R$styleable.QRCodeView_qrcv_rectWidth) {
                this.s = typedArray.getDimensionPixelSize(i2, this.s);
            } else if (i2 == R$styleable.QRCodeView_qrcv_maskColor) {
                this.p = typedArray.getColor(i2, this.p);
            } else if (i2 == R$styleable.QRCodeView_qrcv_scanLineColor) {
                this.x = typedArray.getColor(i2, this.x);
            } else if (i2 == R$styleable.QRCodeView_qrcv_scanLineMargin) {
                this.y = typedArray.getDimensionPixelSize(i2, this.y);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
                this.z = typedArray.getBoolean(i2, this.z);
            } else if (i2 == R$styleable.QRCodeView_qrcv_customScanLineDrawable) {
                this.A = typedArray.getDrawable(i2);
            } else if (i2 == R$styleable.QRCodeView_qrcv_borderSize) {
                this.C = typedArray.getDimensionPixelSize(i2, this.C);
            } else if (i2 == R$styleable.QRCodeView_qrcv_borderColor) {
                this.D = typedArray.getColor(i2, this.D);
            } else if (i2 == R$styleable.QRCodeView_qrcv_animTime) {
                this.E = typedArray.getInteger(i2, this.E);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isCenterVertical) {
                this.F = typedArray.getBoolean(i2, this.F);
            } else if (i2 == R$styleable.QRCodeView_qrcv_toolbarHeight) {
                this.G = typedArray.getDimensionPixelSize(i2, this.G);
            } else if (i2 == R$styleable.QRCodeView_qrcv_barcodeRectHeight) {
                this.u = typedArray.getDimensionPixelSize(i2, this.u);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isBarcode) {
                this.H = typedArray.getBoolean(i2, this.H);
            } else if (i2 == R$styleable.QRCodeView_qrcv_barCodeTipText) {
                this.J = typedArray.getString(i2);
            } else if (i2 == R$styleable.QRCodeView_qrcv_qrCodeTipText) {
                this.I = typedArray.getString(i2);
            } else if (i2 == R$styleable.QRCodeView_qrcv_tipTextSize) {
                this.L = typedArray.getDimensionPixelSize(i2, this.L);
            } else if (i2 == R$styleable.QRCodeView_qrcv_tipTextColor) {
                this.M = typedArray.getColor(i2, this.M);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isTipTextBelowRect) {
                this.N = typedArray.getBoolean(i2, this.N);
            } else if (i2 == R$styleable.QRCodeView_qrcv_tipTextMargin) {
                this.O = typedArray.getDimensionPixelSize(i2, this.O);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
                this.P = typedArray.getBoolean(i2, this.P);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isShowTipBackground) {
                this.R = typedArray.getBoolean(i2, this.R);
            } else if (i2 == R$styleable.QRCodeView_qrcv_tipBackgroundColor) {
                this.Q = typedArray.getColor(i2, this.Q);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isScanLineReverse) {
                this.S = typedArray.getBoolean(i2, this.S);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
                this.T = typedArray.getBoolean(i2, this.T);
            } else if (i2 == R$styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
                this.U = typedArray.getDrawable(i2);
            } else if (i2 == R$styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
                this.i0 = typedArray.getBoolean(i2, this.i0);
            }
        }
    }

    public void initCustomAttrs(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, attributeSet) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.QRCodeView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                i(obtainStyledAttributes.getIndex(i2), obtainStyledAttributes);
            }
            obtainStyledAttributes.recycle();
            a();
            h();
        }
    }

    public boolean isCenterVertical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean isOnlyDecodeScanBoxArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public boolean isScanLineReverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public boolean isShowDefaultGridScanLineDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.T : invokeV.booleanValue;
    }

    public boolean isShowDefaultScanLineDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean isShowTipBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.R : invokeV.booleanValue;
    }

    public boolean isShowTipTextAsSingleLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public boolean isTipTextBelowRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.H) {
                if (this.V == null) {
                    this.m += this.f49114i;
                    int i2 = this.w;
                    Bitmap bitmap = this.B;
                    if (bitmap != null) {
                        i2 = bitmap.getWidth();
                    }
                    if (this.S) {
                        float f2 = this.m;
                        Rect rect = this.f49116k;
                        float f3 = this.f0;
                        if (i2 + f2 > rect.right - f3 || f2 < rect.left + f3) {
                            this.f49114i = -this.f49114i;
                        }
                    } else {
                        float f4 = this.m + i2;
                        Rect rect2 = this.f49116k;
                        float f5 = this.f0;
                        if (f4 > rect2.right - f5) {
                            this.m = rect2.left + f5 + 0.5f;
                        }
                    }
                } else {
                    float f6 = this.a0 + this.f49114i;
                    this.a0 = f6;
                    Rect rect3 = this.f49116k;
                    float f7 = this.f0;
                    if (f6 > rect3.right - f7) {
                        this.a0 = rect3.left + f7 + 0.5f;
                    }
                }
            } else if (this.V == null) {
                this.l += this.f49114i;
                int i3 = this.w;
                Bitmap bitmap2 = this.B;
                if (bitmap2 != null) {
                    i3 = bitmap2.getHeight();
                }
                if (this.S) {
                    float f8 = this.l;
                    Rect rect4 = this.f49116k;
                    float f9 = this.f0;
                    if (i3 + f8 > rect4.bottom - f9 || f8 < rect4.top + f9) {
                        this.f49114i = -this.f49114i;
                    }
                } else {
                    float f10 = this.l + i3;
                    Rect rect5 = this.f49116k;
                    float f11 = this.f0;
                    if (f10 > rect5.bottom - f11) {
                        this.l = rect5.top + f11 + 0.5f;
                    }
                }
            } else {
                float f12 = this.W + this.f49114i;
                this.W = f12;
                Rect rect6 = this.f49116k;
                float f13 = this.f0;
                if (f12 > rect6.bottom - f13) {
                    this.W = rect6.top + f13 + 0.5f;
                }
            }
            long j2 = this.f49115j;
            Rect rect7 = this.f49116k;
            postInvalidateDelayed(j2, rect7.left, rect7.top, rect7.right, rect7.bottom);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, canvas) == null) || this.f49116k == null) {
            return;
        }
        e(canvas);
        c(canvas);
        f(canvas);
        g(canvas);
        d(canvas);
        j();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048624, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            b();
        }
    }

    public void refreshTipText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.o.setColor(this.M);
            setIsBarcode(false);
            invalidate();
        }
    }

    public void setAnimTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.E = i2;
        }
    }

    public void setBarCodeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.J = str;
        }
    }

    public void setBarcodeRectHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setBorderColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            this.D = i2;
        }
    }

    public void setBorderSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setCenterVertical(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.F = z;
        }
    }

    public void setCornerLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setCornerSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.r = i2;
        }
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, drawable) == null) {
            this.A = drawable;
        }
    }

    public void setHalfCornerSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            this.f0 = f2;
        }
    }

    public void setIsBarcode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.H = z;
            if (this.U == null && !this.T) {
                if (this.A != null || this.z) {
                    if (this.H) {
                        this.B = this.c0;
                    } else {
                        this.B = this.b0;
                    }
                }
            } else if (this.H) {
                this.V = this.e0;
            } else {
                this.V = this.d0;
            }
            if (this.H) {
                this.K = this.J;
                this.t = this.u;
                this.f49115j = (int) (((this.E * 1.0f) * this.f49114i) / this.s);
            } else {
                this.K = this.I;
                int i2 = this.s;
                this.t = i2;
                this.f49115j = (int) (((this.E * 1.0f) * this.f49114i) / i2);
            }
            if (!TextUtils.isEmpty(this.K)) {
                if (this.P) {
                    this.g0 = new StaticLayout(this.K, this.o, a.d(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                } else {
                    this.g0 = new StaticLayout(this.K, this.o, this.s - (this.h0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                }
            }
            if (this.F) {
                int i3 = a.d(getContext()).y;
                int i4 = this.G;
                if (i4 == 0) {
                    this.v = (i3 - this.t) / 2;
                } else if (this.H) {
                    this.v = ((i3 - this.t) / 2) + (i4 / 2);
                } else {
                    this.v = (i3 - this.t) / 2;
                }
            }
            b();
            postInvalidate();
        }
    }

    public void setMaskColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.i0 = z;
        }
    }

    public void setQRCodeTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.I = str;
        }
    }

    public void setRectHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setRectWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.s = i2;
        }
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, bitmap) == null) {
            this.B = bitmap;
        }
    }

    public void setScanLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setScanLineMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setScanLineReverse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.S = z;
        }
    }

    public void setScanLineSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.T = z;
        }
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.z = z;
        }
    }

    public void setShowTipBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.R = z;
        }
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.P = z;
        }
    }

    public void setTipBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i2) == null) {
            this.Q = i2;
        }
    }

    public void setTipBackgroundRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.h0 = i2;
        }
    }

    public void setTipText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.K = str;
        }
    }

    public void setTipTextBelowRect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.N = z;
        }
    }

    public void setTipTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.M = i2;
        }
    }

    public void setTipTextMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            this.O = i2;
        }
    }

    public void setTipTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.L = i2;
        }
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, staticLayout) == null) {
            this.g0 = staticLayout;
        }
    }

    public void setToolbarHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.G = i2;
        }
    }

    public void setTopOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i2) == null) {
            this.v = i2;
        }
    }
}
