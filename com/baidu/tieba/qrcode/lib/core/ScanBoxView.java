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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.i0.o2.b.a.a;
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
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
    public Bitmap f20667e;
    public Bitmap e0;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f20668f;
    public float f0;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f20669g;
    public StaticLayout g0;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f20670h;
    public int h0;
    public int i;
    public boolean i0;
    public int j;
    public Context j0;
    public Rect k;
    public ColorMatrixColorFilter k0;
    public float l;
    public float m;
    public Paint n;
    public TextPaint o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    public ScanBoxView(Context context) {
        super(context);
        this.j0 = context;
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
        this.i = a.b(context, 2.0f);
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
        this.k0 = new ColorMatrixColorFilter(colorMatrix2);
    }

    private int getBitmapOffset() {
        return this.C / 2;
    }

    private int getMainFrameBottom() {
        return this.k.bottom + getBitmapOffset();
    }

    private int getMainFrameLeft() {
        return (this.k.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.k.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.k.top - getBitmapOffset()) - 1;
    }

    public final void a() {
        Drawable drawable = this.U;
        if (drawable != null) {
            this.d0 = ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.d0 == null) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.d0 = decodeResource;
            this.d0 = a.e(decodeResource, this.x);
        }
        Bitmap a2 = a.a(this.d0, 90);
        this.e0 = a2;
        Bitmap a3 = a.a(a2, 90);
        this.e0 = a3;
        this.e0 = a.a(a3, 90);
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

    public final void b() {
        int i;
        if (this.H) {
            i = this.v + this.G;
        } else {
            i = this.v;
        }
        int width = (getWidth() - this.s) / 2;
        Rect rect = new Rect(width, i, this.s + width, this.t + i);
        this.k = rect;
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

    public final void c(Canvas canvas) {
        if (this.C > 0) {
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setColor(this.D);
            this.n.setAntiAlias(false);
            this.n.setStrokeWidth(this.C);
            canvas.drawRect(this.k, this.n);
        }
    }

    public final void d(Canvas canvas) {
        this.n.reset();
        this.n.setAntiAlias(false);
        canvas.drawBitmap(this.f20667e, getMainFrameLeft(), getMainFrameTop(), this.n);
        canvas.drawBitmap(this.f20668f, getMainFrameRight() - this.f20667e.getWidth(), getMainFrameTop(), this.n);
        canvas.drawBitmap(this.f20669g, getMainFrameLeft(), getMainFrameBottom() - this.f20667e.getHeight(), this.n);
        canvas.drawBitmap(this.f20670h, getMainFrameRight() - this.f20667e.getWidth(), getMainFrameBottom() - this.f20667e.getHeight(), this.n);
    }

    public final void e(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.p != 0) {
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(this.p);
            float f2 = width;
            canvas.drawRect(0.0f, 0.0f, f2, this.k.top, this.n);
            Rect rect = this.k;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.n);
            Rect rect2 = this.k;
            canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.n);
            canvas.drawRect(0.0f, this.k.bottom + 1, f2, height, this.n);
        }
    }

    public final void f(Canvas canvas) {
        if (this.H) {
            if (this.V != null) {
                Rect rect = this.k;
                float f2 = this.f0;
                int i = this.y;
                RectF rectF = new RectF(rect.left + f2 + 0.5f, rect.top + f2 + i, this.a0, (rect.bottom - f2) - i);
                Rect rect2 = new Rect((int) (this.V.getWidth() - rectF.width()), 0, this.V.getWidth(), this.V.getHeight());
                if (rect2.left < 0) {
                    rect2.left = 0;
                    rectF.left = rectF.right - rect2.width();
                }
                canvas.drawBitmap(this.V, rect2, rectF, this.n);
            } else if (this.B != null) {
                float f3 = this.m;
                canvas.drawBitmap(this.B, (Rect) null, new RectF(f3, this.k.top + this.f0 + this.y, this.B.getWidth() + f3, (this.k.bottom - this.f0) - this.y), this.n);
            } else {
                this.n.setStyle(Paint.Style.FILL);
                this.n.setColor(this.x);
                float f4 = this.m;
                Rect rect3 = this.k;
                float f5 = this.f0;
                int i2 = this.y;
                canvas.drawRect(f4, rect3.top + f5 + i2, this.w + f4, (rect3.bottom - f5) - i2, this.n);
            }
        } else if (this.V != null) {
            Rect rect4 = this.k;
            float f6 = this.f0;
            int i3 = this.y;
            RectF rectF2 = new RectF(rect4.left + f6 + i3, rect4.top + f6 + 0.5f, (rect4.right - f6) - i3, this.W);
            Rect rect5 = new Rect(0, (int) (this.V.getHeight() - rectF2.height()), this.V.getWidth(), this.V.getHeight());
            if (rect5.top < 0) {
                rect5.top = 0;
                rectF2.top = rectF2.bottom - rect5.height();
            }
            this.n.setColorFilter(this.k0);
            canvas.drawBitmap(this.V, rect5, rectF2, this.n);
        } else if (this.B != null) {
            Rect rect6 = this.k;
            float f7 = this.f0;
            int i4 = this.y;
            float f8 = rect6.left + f7 + i4;
            float f9 = this.l;
            canvas.drawBitmap(this.B, (Rect) null, new RectF(f8, f9, (rect6.right - f7) - i4, this.B.getHeight() + f9), this.n);
        } else {
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(this.x);
            Rect rect7 = this.k;
            float f10 = this.f0;
            int i5 = this.y;
            float f11 = this.l;
            canvas.drawRect(rect7.left + f10 + i5, f11, (rect7.right - f10) - i5, f11 + this.w, this.n);
        }
    }

    public final void g(Canvas canvas) {
        Rect rect;
        Rect rect2;
        if (TextUtils.isEmpty(this.K) || this.g0 == null) {
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
                    RectF rectF = new RectF(width, (this.k.bottom + this.O) - this.h0, rect3.width() + width + (this.h0 * 2), this.k.bottom + this.O + this.g0.getHeight() + this.h0);
                    int i = this.h0;
                    canvas.drawRoundRect(rectF, i, i, this.n);
                } else {
                    int i2 = this.k.bottom;
                    int i3 = this.O;
                    RectF rectF2 = new RectF(rect2.left, (i2 + i3) - this.h0, rect2.right, i2 + i3 + this.g0.getHeight() + this.h0);
                    int i4 = this.h0;
                    canvas.drawRoundRect(rectF2, i4, i4, this.n);
                }
            }
            canvas.save();
            if (this.P) {
                canvas.translate(0.0f, this.k.bottom + this.O);
            } else {
                Rect rect4 = this.k;
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
                int i5 = this.h0;
                RectF rectF3 = new RectF(width2, ((this.k.top - this.O) - this.g0.getHeight()) - this.h0, rect5.width() + width2 + (i5 * 2), (this.k.top - this.O) + i5);
                int i6 = this.h0;
                canvas.drawRoundRect(rectF3, i6, i6, this.n);
            } else {
                int height = (this.k.top - this.O) - this.g0.getHeight();
                int i7 = this.h0;
                Rect rect6 = this.k;
                RectF rectF4 = new RectF(rect.left, height - i7, rect6.right, (rect6.top - this.O) + i7);
                int i8 = this.h0;
                canvas.drawRoundRect(rectF4, i8, i8, this.n);
            }
        }
        canvas.save();
        if (this.P) {
            canvas.translate(0.0f, (this.k.top - this.O) - this.g0.getHeight());
        } else {
            Rect rect7 = this.k;
            canvas.translate(rect7.left + this.h0, (rect7.top - this.O) - this.g0.getHeight());
        }
        this.g0.draw(canvas);
        canvas.restore();
    }

    public int getAnimTime() {
        return this.E;
    }

    public String getBarCodeTipText() {
        return this.J;
    }

    public int getBarcodeRectHeight() {
        return this.u;
    }

    public int getBorderColor() {
        return this.D;
    }

    public int getBorderSize() {
        return this.C;
    }

    public int getCornerLength() {
        return this.q;
    }

    public int getCornerSize() {
        return this.r;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.A;
    }

    public float getHalfCornerSize() {
        return this.f0;
    }

    public boolean getIsBarcode() {
        return this.H;
    }

    public int getMaskColor() {
        return this.p;
    }

    public String getQRCodeTipText() {
        return this.I;
    }

    public int getRectHeight() {
        return this.t;
    }

    public int getRectWidth() {
        return this.s;
    }

    public Bitmap getScanLineBitmap() {
        return this.B;
    }

    public int getScanLineColor() {
        return this.x;
    }

    public int getScanLineMargin() {
        return this.y;
    }

    public int getScanLineSize() {
        return this.w;
    }

    public int getTipBackgroundColor() {
        return this.Q;
    }

    public int getTipBackgroundRadius() {
        return this.h0;
    }

    public String getTipText() {
        return this.K;
    }

    public int getTipTextColor() {
        return this.M;
    }

    public int getTipTextMargin() {
        return this.O;
    }

    public int getTipTextSize() {
        return this.L;
    }

    public StaticLayout getTipTextSl() {
        return this.g0;
    }

    public int getToolbarHeight() {
        return this.G;
    }

    public int getTopOffset() {
        return this.v;
    }

    public Rect h(int i) {
        if (this.i0) {
            Rect rect = new Rect(this.k);
            float measuredHeight = (i * 1.0f) / getMeasuredHeight();
            rect.left = (int) (rect.left * measuredHeight);
            rect.right = (int) (rect.right * measuredHeight);
            rect.top = (int) (rect.top * measuredHeight);
            rect.bottom = (int) (rect.bottom * measuredHeight);
            return rect;
        }
        return null;
    }

    public final void i() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = this.q;
        options.outWidth = i;
        options.outHeight = i;
        this.f20667e = BitmapHelper.getResBitmap(this.j0, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        Bitmap bitmap = this.f20667e;
        this.f20668f = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f20667e.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        Bitmap bitmap2 = this.f20667e;
        this.f20669g = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f20667e.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        Bitmap bitmap3 = this.f20667e;
        this.f20670h = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f20667e.getHeight(), matrix, false);
    }

    public final void j(int i, TypedArray typedArray) {
        if (i == R$styleable.QRCodeView_qrcv_topOffset) {
            this.v = typedArray.getDimensionPixelSize(i, this.v);
        } else if (i == R$styleable.QRCodeView_qrcv_cornerSize) {
            this.r = typedArray.getDimensionPixelSize(i, this.r);
        } else if (i == R$styleable.QRCodeView_qrcv_cornerLength) {
            this.q = typedArray.getDimensionPixelSize(i, this.q);
        } else if (i == R$styleable.QRCodeView_qrcv_scanLineSize) {
            this.w = typedArray.getDimensionPixelSize(i, this.w);
        } else if (i == R$styleable.QRCodeView_qrcv_rectWidth) {
            this.s = typedArray.getDimensionPixelSize(i, this.s);
        } else if (i == R$styleable.QRCodeView_qrcv_maskColor) {
            this.p = typedArray.getColor(i, this.p);
        } else if (i == R$styleable.QRCodeView_qrcv_scanLineColor) {
            this.x = typedArray.getColor(i, this.x);
        } else if (i == R$styleable.QRCodeView_qrcv_scanLineMargin) {
            this.y = typedArray.getDimensionPixelSize(i, this.y);
        } else if (i == R$styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.z = typedArray.getBoolean(i, this.z);
        } else if (i == R$styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.A = typedArray.getDrawable(i);
        } else if (i == R$styleable.QRCodeView_qrcv_borderSize) {
            this.C = typedArray.getDimensionPixelSize(i, this.C);
        } else if (i == R$styleable.QRCodeView_qrcv_borderColor) {
            this.D = typedArray.getColor(i, this.D);
        } else if (i == R$styleable.QRCodeView_qrcv_animTime) {
            this.E = typedArray.getInteger(i, this.E);
        } else if (i == R$styleable.QRCodeView_qrcv_isCenterVertical) {
            this.F = typedArray.getBoolean(i, this.F);
        } else if (i == R$styleable.QRCodeView_qrcv_toolbarHeight) {
            this.G = typedArray.getDimensionPixelSize(i, this.G);
        } else if (i == R$styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.u = typedArray.getDimensionPixelSize(i, this.u);
        } else if (i == R$styleable.QRCodeView_qrcv_isBarcode) {
            this.H = typedArray.getBoolean(i, this.H);
        } else if (i == R$styleable.QRCodeView_qrcv_barCodeTipText) {
            this.J = typedArray.getString(i);
        } else if (i == R$styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.I = typedArray.getString(i);
        } else if (i == R$styleable.QRCodeView_qrcv_tipTextSize) {
            this.L = typedArray.getDimensionPixelSize(i, this.L);
        } else if (i == R$styleable.QRCodeView_qrcv_tipTextColor) {
            this.M = typedArray.getColor(i, this.M);
        } else if (i == R$styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.N = typedArray.getBoolean(i, this.N);
        } else if (i == R$styleable.QRCodeView_qrcv_tipTextMargin) {
            this.O = typedArray.getDimensionPixelSize(i, this.O);
        } else if (i == R$styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.P = typedArray.getBoolean(i, this.P);
        } else if (i == R$styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.R = typedArray.getBoolean(i, this.R);
        } else if (i == R$styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.Q = typedArray.getColor(i, this.Q);
        } else if (i == R$styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.S = typedArray.getBoolean(i, this.S);
        } else if (i == R$styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.T = typedArray.getBoolean(i, this.T);
        } else if (i == R$styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.U = typedArray.getDrawable(i);
        } else if (i == R$styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.i0 = typedArray.getBoolean(i, this.i0);
        }
    }

    public void k(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            j(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        a();
        i();
    }

    public final void l() {
        if (this.H) {
            if (this.V == null) {
                this.m += this.i;
                int i = this.w;
                Bitmap bitmap = this.B;
                if (bitmap != null) {
                    i = bitmap.getWidth();
                }
                if (this.S) {
                    float f2 = this.m;
                    Rect rect = this.k;
                    float f3 = this.f0;
                    if (i + f2 > rect.right - f3 || f2 < rect.left + f3) {
                        this.i = -this.i;
                    }
                } else {
                    float f4 = this.m + i;
                    Rect rect2 = this.k;
                    float f5 = this.f0;
                    if (f4 > rect2.right - f5) {
                        this.m = rect2.left + f5 + 0.5f;
                    }
                }
            } else {
                float f6 = this.a0 + this.i;
                this.a0 = f6;
                Rect rect3 = this.k;
                float f7 = this.f0;
                if (f6 > rect3.right - f7) {
                    this.a0 = rect3.left + f7 + 0.5f;
                }
            }
        } else if (this.V == null) {
            this.l += this.i;
            int i2 = this.w;
            Bitmap bitmap2 = this.B;
            if (bitmap2 != null) {
                i2 = bitmap2.getHeight();
            }
            if (this.S) {
                float f8 = this.l;
                Rect rect4 = this.k;
                float f9 = this.f0;
                if (i2 + f8 > rect4.bottom - f9 || f8 < rect4.top + f9) {
                    this.i = -this.i;
                }
            } else {
                float f10 = this.l + i2;
                Rect rect5 = this.k;
                float f11 = this.f0;
                if (f10 > rect5.bottom - f11) {
                    this.l = rect5.top + f11 + 0.5f;
                }
            }
        } else {
            float f12 = this.W + this.i;
            this.W = f12;
            Rect rect6 = this.k;
            float f13 = this.f0;
            if (f12 > rect6.bottom - f13) {
                this.W = rect6.top + f13 + 0.5f;
            }
        }
        long j = this.j;
        Rect rect7 = this.k;
        postInvalidateDelayed(j, rect7.left, rect7.top, rect7.right, rect7.bottom);
    }

    public void m() {
        this.o.setColor(this.M);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.k == null) {
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
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }

    public void setAnimTime(int i) {
        this.E = i;
    }

    public void setBarCodeTipText(String str) {
        this.J = str;
    }

    public void setBarcodeRectHeight(int i) {
        this.u = i;
    }

    public void setBorderColor(int i) {
        this.D = i;
    }

    public void setBorderSize(int i) {
        this.C = i;
    }

    public void setCenterVertical(boolean z) {
        this.F = z;
    }

    public void setCornerLength(int i) {
        this.q = i;
    }

    public void setCornerSize(int i) {
        this.r = i;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.A = drawable;
    }

    public void setHalfCornerSize(float f2) {
        this.f0 = f2;
    }

    public void setIsBarcode(boolean z) {
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
            this.j = (int) (((this.E * 1.0f) * this.i) / this.s);
        } else {
            this.K = this.I;
            int i = this.s;
            this.t = i;
            this.j = (int) (((this.E * 1.0f) * this.i) / i);
        }
        if (!TextUtils.isEmpty(this.K)) {
            if (this.P) {
                this.g0 = new StaticLayout(this.K, this.o, a.d(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.g0 = new StaticLayout(this.K, this.o, this.s - (this.h0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.F) {
            int i2 = a.d(getContext()).y;
            int i3 = this.G;
            if (i3 == 0) {
                this.v = (i2 - this.t) / 2;
            } else if (this.H) {
                this.v = ((i2 - this.t) / 2) + (i3 / 2);
            } else {
                this.v = (i2 - this.t) / 2;
            }
        }
        b();
        postInvalidate();
    }

    public void setMaskColor(int i) {
        this.p = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.i0 = z;
    }

    public void setQRCodeTipText(String str) {
        this.I = str;
    }

    public void setRectHeight(int i) {
        this.t = i;
    }

    public void setRectWidth(int i) {
        this.s = i;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.B = bitmap;
    }

    public void setScanLineColor(int i) {
        this.x = i;
    }

    public void setScanLineMargin(int i) {
        this.y = i;
    }

    public void setScanLineReverse(boolean z) {
        this.S = z;
    }

    public void setScanLineSize(int i) {
        this.w = i;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.T = z;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.z = z;
    }

    public void setShowTipBackground(boolean z) {
        this.R = z;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.P = z;
    }

    public void setTipBackgroundColor(int i) {
        this.Q = i;
    }

    public void setTipBackgroundRadius(int i) {
        this.h0 = i;
    }

    public void setTipText(String str) {
        this.K = str;
    }

    public void setTipTextBelowRect(boolean z) {
        this.N = z;
    }

    public void setTipTextColor(int i) {
        this.M = i;
    }

    public void setTipTextMargin(int i) {
        this.O = i;
    }

    public void setTipTextSize(int i) {
        this.L = i;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.g0 = staticLayout;
    }

    public void setToolbarHeight(int i) {
        this.G = i;
    }

    public void setTopOffset(int i) {
        this.v = i;
    }
}
