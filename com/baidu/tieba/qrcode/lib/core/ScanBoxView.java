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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ScanBoxView extends View {
    private int aXm;
    private int auq;
    private String fcR;
    private Bitmap glP;
    private Bitmap glQ;
    private Bitmap glR;
    private Bitmap glS;
    private int glT;
    private int glU;
    private Rect glV;
    private float glW;
    private float glX;
    private TextPaint glY;
    private int glZ;
    private Drawable gmA;
    private Bitmap gmB;
    private float gmC;
    private float gmD;
    private Bitmap gmE;
    private Bitmap gmF;
    private Bitmap gmG;
    private Bitmap gmH;
    private float gmI;
    private StaticLayout gmJ;
    private int gmK;
    private boolean gmL;
    private ColorMatrixColorFilter gmM;
    private int gma;
    private int gmb;
    private int gmc;
    private int gmd;
    private int gme;
    private int gmf;
    private int gmg;
    private boolean gmh;
    private Drawable gmi;
    private Bitmap gmj;
    private int gmk;
    private int gml;
    private boolean gmm;
    private int gmn;
    private boolean gmo;
    private String gmp;
    private String gmq;
    private int gmr;
    private int gms;
    private boolean gmt;
    private int gmu;
    private boolean gmv;
    private int gmw;
    private boolean gmx;
    private boolean gmy;
    private boolean gmz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.auq = Color.parseColor("#33FFFFFF");
        this.glZ = a.f(context, 20.0f);
        this.gma = a.f(context, 3.0f);
        this.gme = a.f(context, 1.0f);
        this.gmf = -1;
        this.aXm = a.f(context, 90.0f);
        this.gmb = a.f(context, 200.0f);
        this.gmd = a.f(context, 140.0f);
        this.gmg = 0;
        this.gmh = false;
        this.gmi = null;
        this.gmj = null;
        this.gmk = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gml = 1000;
        this.gmm = false;
        this.gmn = 0;
        this.gmo = false;
        this.glT = a.f(context, 2.0f);
        this.fcR = null;
        this.gmr = a.e(context, 14.0f);
        this.gms = -1;
        this.gmt = false;
        this.gmu = a.f(context, 20.0f);
        this.gmv = false;
        this.gmw = Color.parseColor("#22000000");
        this.gmx = false;
        this.gmy = false;
        this.gmz = false;
        this.glY = new TextPaint();
        this.glY.setAntiAlias(true);
        this.gmK = a.f(context, 4.0f);
        this.gmL = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gmM = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bmK();
        bmJ();
    }

    private void bmJ() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.glZ;
        options.outHeight = this.glZ;
        this.glP = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.glQ = Bitmap.createBitmap(this.glP, 0, 0, this.glP.getWidth(), this.glP.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.glR = Bitmap.createBitmap(this.glP, 0, 0, this.glP.getWidth(), this.glP.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.glS = Bitmap.createBitmap(this.glP, 0, 0, this.glP.getWidth(), this.glP.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.aXm = typedArray.getDimensionPixelSize(i, this.aXm);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.gma = typedArray.getDimensionPixelSize(i, this.gma);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.glZ = typedArray.getDimensionPixelSize(i, this.glZ);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.gme = typedArray.getDimensionPixelSize(i, this.gme);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.gmb = typedArray.getDimensionPixelSize(i, this.gmb);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.auq = typedArray.getColor(i, this.auq);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.gmf = typedArray.getColor(i, this.gmf);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.gmg = typedArray.getDimensionPixelSize(i, this.gmg);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gmh = typedArray.getBoolean(i, this.gmh);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gmi = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.gmk = typedArray.getDimensionPixelSize(i, this.gmk);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.gml = typedArray.getInteger(i, this.gml);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.gmm = typedArray.getBoolean(i, this.gmm);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.gmn = typedArray.getDimensionPixelSize(i, this.gmn);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gmd = typedArray.getDimensionPixelSize(i, this.gmd);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.gmo = typedArray.getBoolean(i, this.gmo);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.gmq = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gmp = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.gmr = typedArray.getDimensionPixelSize(i, this.gmr);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.gms = typedArray.getColor(i, this.gms);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gmt = typedArray.getBoolean(i, this.gmt);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.gmu = typedArray.getDimensionPixelSize(i, this.gmu);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gmv = typedArray.getBoolean(i, this.gmv);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gmx = typedArray.getBoolean(i, this.gmx);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gmw = typedArray.getColor(i, this.gmw);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gmy = typedArray.getBoolean(i, this.gmy);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gmz = typedArray.getBoolean(i, this.gmz);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gmA = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gmL = typedArray.getBoolean(i, this.gmL);
        }
    }

    private void bmK() {
        if (this.gmA != null) {
            this.gmG = ((BitmapDrawable) this.gmA).getBitmap();
        }
        if (this.gmG == null) {
            this.gmG = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gmG = a.d(this.gmG, this.gmf);
        }
        this.gmH = a.c(this.gmG, 90);
        this.gmH = a.c(this.gmH, 90);
        this.gmH = a.c(this.gmH, 90);
        if (this.gmi != null) {
            this.gmE = ((BitmapDrawable) this.gmi).getBitmap();
        }
        if (this.gmE == null) {
            this.gmE = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gmE = a.d(this.gmE, this.gmf);
        }
        this.gmF = a.c(this.gmE, 90);
        this.gmI = (1.0f * this.gma) / 2.0f;
        this.glY.setTextSize(this.gmr);
        this.glY.setColor(this.gms);
        setIsBarcode(this.gmo);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.glV != null) {
            C(canvas);
            D(canvas);
            F(canvas);
            G(canvas);
            E(canvas);
            bmL();
        }
    }

    private void C(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.auq != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.auq);
            canvas.drawRect(0.0f, 0.0f, width, this.glV.top, this.mPaint);
            canvas.drawRect(0.0f, this.glV.top, this.glV.left, this.glV.bottom + 1, this.mPaint);
            canvas.drawRect(this.glV.right + 1, this.glV.top, width, this.glV.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.glV.bottom + 1, width, height, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.gmk > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gmk);
            canvas.drawRect(this.glV, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.glP, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.glQ, getMainFrameRight() - this.glP.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.glR, getMainFrameLeft(), getMainFrameBottom() - this.glP.getHeight(), this.mPaint);
        canvas.drawBitmap(this.glS, getMainFrameRight() - this.glP.getWidth(), getMainFrameBottom() - this.glP.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.glV.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.glV.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.glV.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.glV.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gmk / 2;
    }

    private void F(Canvas canvas) {
        if (this.gmo) {
            if (this.gmB != null) {
                RectF rectF = new RectF(this.glV.left + this.gmI + 0.5f, this.glV.top + this.gmI + this.gmg, this.gmD, (this.glV.bottom - this.gmI) - this.gmg);
                Rect rect = new Rect((int) (this.gmB.getWidth() - rectF.width()), 0, this.gmB.getWidth(), this.gmB.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gmB, rect, rectF, this.mPaint);
            } else if (this.gmj != null) {
                canvas.drawBitmap(this.gmj, (Rect) null, new RectF(this.glX, this.glV.top + this.gmI + this.gmg, this.glX + this.gmj.getWidth(), (this.glV.bottom - this.gmI) - this.gmg), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gmf);
                canvas.drawRect(this.glX, this.gmg + this.glV.top + this.gmI, this.gme + this.glX, (this.glV.bottom - this.gmI) - this.gmg, this.mPaint);
            }
        } else if (this.gmB != null) {
            RectF rectF2 = new RectF(this.glV.left + this.gmI + this.gmg, this.glV.top + this.gmI + 0.5f, (this.glV.right - this.gmI) - this.gmg, this.gmC);
            Rect rect2 = new Rect(0, (int) (this.gmB.getHeight() - rectF2.height()), this.gmB.getWidth(), this.gmB.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gmM);
            canvas.drawBitmap(this.gmB, rect2, rectF2, this.mPaint);
        } else if (this.gmj != null) {
            canvas.drawBitmap(this.gmj, (Rect) null, new RectF(this.glV.left + this.gmI + this.gmg, this.glW, (this.glV.right - this.gmI) - this.gmg, this.glW + this.gmj.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gmf);
            canvas.drawRect(this.gmg + this.glV.left + this.gmI, this.glW, (this.glV.right - this.gmI) - this.gmg, this.gme + this.glW, this.mPaint);
        }
    }

    private void G(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fcR) && this.gmJ != null) {
            if (this.gmt) {
                if (this.gmx) {
                    this.mPaint.setColor(this.gmw);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gmv) {
                        Rect rect = new Rect();
                        this.glY.getTextBounds(this.fcR, 0, this.fcR.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gmK;
                        canvas.drawRoundRect(new RectF(width, (this.glV.bottom + this.gmu) - this.gmK, rect.width() + width + (this.gmK * 2), this.glV.bottom + this.gmu + this.gmJ.getHeight() + this.gmK), this.gmK, this.gmK, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.glV.left, (this.glV.bottom + this.gmu) - this.gmK, this.glV.right, this.glV.bottom + this.gmu + this.gmJ.getHeight() + this.gmK), this.gmK, this.gmK, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gmv) {
                    canvas.translate(0.0f, this.glV.bottom + this.gmu);
                } else {
                    canvas.translate(this.glV.left + this.gmK, this.glV.bottom + this.gmu);
                }
                this.gmJ.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gmx) {
                this.mPaint.setColor(this.gmw);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gmv) {
                    Rect rect2 = new Rect();
                    this.glY.getTextBounds(this.fcR, 0, this.fcR.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gmK;
                    canvas.drawRoundRect(new RectF(width2, ((this.glV.top - this.gmu) - this.gmJ.getHeight()) - this.gmK, rect2.width() + width2 + (this.gmK * 2), (this.glV.top - this.gmu) + this.gmK), this.gmK, this.gmK, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.glV.left, ((this.glV.top - this.gmu) - this.gmJ.getHeight()) - this.gmK, this.glV.right, (this.glV.top - this.gmu) + this.gmK), this.gmK, this.gmK, this.mPaint);
                }
            }
            canvas.save();
            if (this.gmv) {
                canvas.translate(0.0f, (this.glV.top - this.gmu) - this.gmJ.getHeight());
            } else {
                canvas.translate(this.glV.left + this.gmK, (this.glV.top - this.gmu) - this.gmJ.getHeight());
            }
            this.gmJ.draw(canvas);
            canvas.restore();
        }
    }

    private void bmL() {
        if (this.gmo) {
            if (this.gmB == null) {
                this.glX += this.glT;
                int i = this.gme;
                if (this.gmj != null) {
                    i = this.gmj.getWidth();
                }
                if (this.gmy) {
                    if (i + this.glX > this.glV.right - this.gmI || this.glX < this.glV.left + this.gmI) {
                        this.glT = -this.glT;
                    }
                } else {
                    if (i + this.glX > this.glV.right - this.gmI) {
                        this.glX = this.glV.left + this.gmI + 0.5f;
                    }
                }
            } else {
                this.gmD += this.glT;
                if (this.gmD > this.glV.right - this.gmI) {
                    this.gmD = this.glV.left + this.gmI + 0.5f;
                }
            }
        } else if (this.gmB == null) {
            this.glW += this.glT;
            int i2 = this.gme;
            if (this.gmj != null) {
                i2 = this.gmj.getHeight();
            }
            if (this.gmy) {
                if (i2 + this.glW > this.glV.bottom - this.gmI || this.glW < this.glV.top + this.gmI) {
                    this.glT = -this.glT;
                }
            } else {
                if (i2 + this.glW > this.glV.bottom - this.gmI) {
                    this.glW = this.glV.top + this.gmI + 0.5f;
                }
            }
        } else {
            this.gmC += this.glT;
            if (this.gmC > this.glV.bottom - this.gmI) {
                this.gmC = this.glV.top + this.gmI + 0.5f;
            }
        }
        postInvalidateDelayed(this.glU, this.glV.left, this.glV.top, this.glV.right, this.glV.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bmM();
    }

    private void bmM() {
        int i = this.aXm + this.gmn;
        int width = (getWidth() - this.gmb) / 2;
        this.glV = new Rect(width, i, this.gmb + width, this.gmc + i);
        if (this.gmo) {
            float f = this.glV.left + this.gmI + 0.5f;
            this.glX = f;
            this.gmD = f;
            return;
        }
        float f2 = this.glV.top + this.gmI + 0.5f;
        this.glW = f2;
        this.gmC = f2;
    }

    public Rect sa(int i) {
        if (this.gmL) {
            Rect rect = new Rect(this.glV);
            float measuredHeight = (1.0f * i) / getMeasuredHeight();
            rect.left = (int) (rect.left * measuredHeight);
            rect.right = (int) (rect.right * measuredHeight);
            rect.top = (int) (rect.top * measuredHeight);
            rect.bottom = (int) (measuredHeight * rect.bottom);
            return rect;
        }
        return null;
    }

    public void setIsBarcode(boolean z) {
        this.gmo = z;
        if (this.gmA != null || this.gmz) {
            if (this.gmo) {
                this.gmB = this.gmH;
            } else {
                this.gmB = this.gmG;
            }
        } else if (this.gmi != null || this.gmh) {
            if (this.gmo) {
                this.gmj = this.gmF;
            } else {
                this.gmj = this.gmE;
            }
        }
        if (this.gmo) {
            this.fcR = this.gmq;
            this.gmc = this.gmd;
            this.glU = (int) (((this.gml * 1.0f) * this.glT) / this.gmb);
        } else {
            this.fcR = this.gmp;
            this.gmc = this.gmb;
            this.glU = (int) (((this.gml * 1.0f) * this.glT) / this.gmc);
        }
        if (!TextUtils.isEmpty(this.fcR)) {
            if (this.gmv) {
                this.gmJ = new StaticLayout(this.fcR, this.glY, a.cc(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gmJ = new StaticLayout(this.fcR, this.glY, this.gmb - (this.gmK * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gmm) {
            int i = a.cc(getContext()).y;
            if (this.gmn == 0) {
                this.aXm = (i - this.gmc) / 2;
            } else {
                this.aXm = ((i - this.gmc) / 2) + (this.gmn / 2);
            }
        }
        bmM();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gmo;
    }

    public int getMaskColor() {
        return this.auq;
    }

    public void setMaskColor(int i) {
        this.auq = i;
    }

    public int getCornerLength() {
        return this.glZ;
    }

    public void setCornerLength(int i) {
        this.glZ = i;
    }

    public int getCornerSize() {
        return this.gma;
    }

    public void setCornerSize(int i) {
        this.gma = i;
    }

    public int getRectWidth() {
        return this.gmb;
    }

    public void setRectWidth(int i) {
        this.gmb = i;
    }

    public int getRectHeight() {
        return this.gmc;
    }

    public void setRectHeight(int i) {
        this.gmc = i;
    }

    public int getBarcodeRectHeight() {
        return this.gmd;
    }

    public void setBarcodeRectHeight(int i) {
        this.gmd = i;
    }

    public int getTopOffset() {
        return this.aXm;
    }

    public void setTopOffset(int i) {
        this.aXm = i;
    }

    public int getScanLineSize() {
        return this.gme;
    }

    public void setScanLineSize(int i) {
        this.gme = i;
    }

    public int getScanLineColor() {
        return this.gmf;
    }

    public void setScanLineColor(int i) {
        this.gmf = i;
    }

    public int getScanLineMargin() {
        return this.gmg;
    }

    public void setScanLineMargin(int i) {
        this.gmg = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gmh = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gmi;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gmi = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gmj;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gmj = bitmap;
    }

    public int getBorderSize() {
        return this.gmk;
    }

    public void setBorderSize(int i) {
        this.gmk = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gml;
    }

    public void setAnimTime(int i) {
        this.gml = i;
    }

    public void setCenterVertical(boolean z) {
        this.gmm = z;
    }

    public int getToolbarHeight() {
        return this.gmn;
    }

    public void setToolbarHeight(int i) {
        this.gmn = i;
    }

    public String getQRCodeTipText() {
        return this.gmp;
    }

    public void setQRCodeTipText(String str) {
        this.gmp = str;
    }

    public String getBarCodeTipText() {
        return this.gmq;
    }

    public void setBarCodeTipText(String str) {
        this.gmq = str;
    }

    public String getTipText() {
        return this.fcR;
    }

    public void setTipText(String str) {
        this.fcR = str;
    }

    public int getTipTextColor() {
        return this.gms;
    }

    public void setTipTextColor(int i) {
        this.gms = i;
    }

    public int getTipTextSize() {
        return this.gmr;
    }

    public void setTipTextSize(int i) {
        this.gmr = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gmt = z;
    }

    public int getTipTextMargin() {
        return this.gmu;
    }

    public void setTipTextMargin(int i) {
        this.gmu = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gmv = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gmx = z;
    }

    public int getTipBackgroundColor() {
        return this.gmw;
    }

    public void setTipBackgroundColor(int i) {
        this.gmw = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gmy = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gmz = z;
    }

    public float getHalfCornerSize() {
        return this.gmI;
    }

    public void setHalfCornerSize(float f) {
        this.gmI = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gmJ;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gmJ = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gmK;
    }

    public void setTipBackgroundRadius(int i) {
        this.gmK = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gmL = z;
    }
}
