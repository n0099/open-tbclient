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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ScanBoxView extends View {
    private int aXm;
    private int aur;
    private String fcL;
    private Bitmap glS;
    private Bitmap glT;
    private Bitmap glU;
    private Bitmap glV;
    private int glW;
    private int glX;
    private Rect glY;
    private float glZ;
    private boolean gmA;
    private boolean gmB;
    private boolean gmC;
    private Drawable gmD;
    private Bitmap gmE;
    private float gmF;
    private float gmG;
    private Bitmap gmH;
    private Bitmap gmI;
    private Bitmap gmJ;
    private Bitmap gmK;
    private float gmL;
    private StaticLayout gmM;
    private int gmN;
    private boolean gmO;
    private ColorMatrixColorFilter gmP;
    private float gma;
    private TextPaint gmb;
    private int gmc;
    private int gmd;
    private int gme;
    private int gmf;
    private int gmg;
    private int gmh;
    private int gmi;
    private int gmj;
    private boolean gmk;
    private Drawable gml;
    private Bitmap gmm;
    private int gmn;
    private int gmo;
    private boolean gmp;
    private int gmq;
    private boolean gmr;
    private String gms;
    private String gmt;
    private int gmu;
    private int gmv;
    private boolean gmw;
    private int gmx;
    private boolean gmy;
    private int gmz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aur = Color.parseColor("#33FFFFFF");
        this.gmc = a.f(context, 20.0f);
        this.gmd = a.f(context, 3.0f);
        this.gmh = a.f(context, 1.0f);
        this.gmi = -1;
        this.aXm = a.f(context, 90.0f);
        this.gme = a.f(context, 200.0f);
        this.gmg = a.f(context, 140.0f);
        this.gmj = 0;
        this.gmk = false;
        this.gml = null;
        this.gmm = null;
        this.gmn = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gmo = 1000;
        this.gmp = false;
        this.gmq = 0;
        this.gmr = false;
        this.glW = a.f(context, 2.0f);
        this.fcL = null;
        this.gmu = a.e(context, 14.0f);
        this.gmv = -1;
        this.gmw = false;
        this.gmx = a.f(context, 20.0f);
        this.gmy = false;
        this.gmz = Color.parseColor("#22000000");
        this.gmA = false;
        this.gmB = false;
        this.gmC = false;
        this.gmb = new TextPaint();
        this.gmb.setAntiAlias(true);
        this.gmN = a.f(context, 4.0f);
        this.gmO = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gmP = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bmL();
        bmK();
    }

    private void bmK() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gmc;
        options.outHeight = this.gmc;
        this.glS = BitmapHelper.getResBitmap(this.mContext, f.C0146f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.glT = Bitmap.createBitmap(this.glS, 0, 0, this.glS.getWidth(), this.glS.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.glU = Bitmap.createBitmap(this.glS, 0, 0, this.glS.getWidth(), this.glS.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.glV = Bitmap.createBitmap(this.glS, 0, 0, this.glS.getWidth(), this.glS.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == f.l.QRCodeView_qrcv_topOffset) {
            this.aXm = typedArray.getDimensionPixelSize(i, this.aXm);
        } else if (i == f.l.QRCodeView_qrcv_cornerSize) {
            this.gmd = typedArray.getDimensionPixelSize(i, this.gmd);
        } else if (i == f.l.QRCodeView_qrcv_cornerLength) {
            this.gmc = typedArray.getDimensionPixelSize(i, this.gmc);
        } else if (i == f.l.QRCodeView_qrcv_scanLineSize) {
            this.gmh = typedArray.getDimensionPixelSize(i, this.gmh);
        } else if (i == f.l.QRCodeView_qrcv_rectWidth) {
            this.gme = typedArray.getDimensionPixelSize(i, this.gme);
        } else if (i == f.l.QRCodeView_qrcv_maskColor) {
            this.aur = typedArray.getColor(i, this.aur);
        } else if (i == f.l.QRCodeView_qrcv_scanLineColor) {
            this.gmi = typedArray.getColor(i, this.gmi);
        } else if (i == f.l.QRCodeView_qrcv_scanLineMargin) {
            this.gmj = typedArray.getDimensionPixelSize(i, this.gmj);
        } else if (i == f.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gmk = typedArray.getBoolean(i, this.gmk);
        } else if (i == f.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gml = typedArray.getDrawable(i);
        } else if (i == f.l.QRCodeView_qrcv_borderSize) {
            this.gmn = typedArray.getDimensionPixelSize(i, this.gmn);
        } else if (i == f.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == f.l.QRCodeView_qrcv_animTime) {
            this.gmo = typedArray.getInteger(i, this.gmo);
        } else if (i == f.l.QRCodeView_qrcv_isCenterVertical) {
            this.gmp = typedArray.getBoolean(i, this.gmp);
        } else if (i == f.l.QRCodeView_qrcv_toolbarHeight) {
            this.gmq = typedArray.getDimensionPixelSize(i, this.gmq);
        } else if (i == f.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gmg = typedArray.getDimensionPixelSize(i, this.gmg);
        } else if (i == f.l.QRCodeView_qrcv_isBarcode) {
            this.gmr = typedArray.getBoolean(i, this.gmr);
        } else if (i == f.l.QRCodeView_qrcv_barCodeTipText) {
            this.gmt = typedArray.getString(i);
        } else if (i == f.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gms = typedArray.getString(i);
        } else if (i == f.l.QRCodeView_qrcv_tipTextSize) {
            this.gmu = typedArray.getDimensionPixelSize(i, this.gmu);
        } else if (i == f.l.QRCodeView_qrcv_tipTextColor) {
            this.gmv = typedArray.getColor(i, this.gmv);
        } else if (i == f.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gmw = typedArray.getBoolean(i, this.gmw);
        } else if (i == f.l.QRCodeView_qrcv_tipTextMargin) {
            this.gmx = typedArray.getDimensionPixelSize(i, this.gmx);
        } else if (i == f.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gmy = typedArray.getBoolean(i, this.gmy);
        } else if (i == f.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gmA = typedArray.getBoolean(i, this.gmA);
        } else if (i == f.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gmz = typedArray.getColor(i, this.gmz);
        } else if (i == f.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gmB = typedArray.getBoolean(i, this.gmB);
        } else if (i == f.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gmC = typedArray.getBoolean(i, this.gmC);
        } else if (i == f.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gmD = typedArray.getDrawable(i);
        } else if (i == f.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gmO = typedArray.getBoolean(i, this.gmO);
        }
    }

    private void bmL() {
        if (this.gmD != null) {
            this.gmJ = ((BitmapDrawable) this.gmD).getBitmap();
        }
        if (this.gmJ == null) {
            this.gmJ = BitmapFactory.decodeResource(getResources(), f.C0146f.pc_scan_line);
            this.gmJ = a.c(this.gmJ, this.gmi);
        }
        this.gmK = a.adjustPhotoRotation(this.gmJ, 90);
        this.gmK = a.adjustPhotoRotation(this.gmK, 90);
        this.gmK = a.adjustPhotoRotation(this.gmK, 90);
        if (this.gml != null) {
            this.gmH = ((BitmapDrawable) this.gml).getBitmap();
        }
        if (this.gmH == null) {
            this.gmH = BitmapFactory.decodeResource(getResources(), f.C0146f.pc_scan_line);
            this.gmH = a.c(this.gmH, this.gmi);
        }
        this.gmI = a.adjustPhotoRotation(this.gmH, 90);
        this.gmL = (1.0f * this.gmd) / 2.0f;
        this.gmb.setTextSize(this.gmu);
        this.gmb.setColor(this.gmv);
        setIsBarcode(this.gmr);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.glY != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            bmM();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aur != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aur);
            canvas.drawRect(0.0f, 0.0f, width, this.glY.top, this.mPaint);
            canvas.drawRect(0.0f, this.glY.top, this.glY.left, this.glY.bottom + 1, this.mPaint);
            canvas.drawRect(this.glY.right + 1, this.glY.top, width, this.glY.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.glY.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gmn > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gmn);
            canvas.drawRect(this.glY, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.glS, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.glT, getMainFrameRight() - this.glS.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.glU, getMainFrameLeft(), getMainFrameBottom() - this.glS.getHeight(), this.mPaint);
        canvas.drawBitmap(this.glV, getMainFrameRight() - this.glS.getWidth(), getMainFrameBottom() - this.glS.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.glY.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.glY.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.glY.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.glY.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gmn / 2;
    }

    private void E(Canvas canvas) {
        if (this.gmr) {
            if (this.gmE != null) {
                RectF rectF = new RectF(this.glY.left + this.gmL + 0.5f, this.glY.top + this.gmL + this.gmj, this.gmG, (this.glY.bottom - this.gmL) - this.gmj);
                Rect rect = new Rect((int) (this.gmE.getWidth() - rectF.width()), 0, this.gmE.getWidth(), this.gmE.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gmE, rect, rectF, this.mPaint);
            } else if (this.gmm != null) {
                canvas.drawBitmap(this.gmm, (Rect) null, new RectF(this.gma, this.glY.top + this.gmL + this.gmj, this.gma + this.gmm.getWidth(), (this.glY.bottom - this.gmL) - this.gmj), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gmi);
                canvas.drawRect(this.gma, this.gmj + this.glY.top + this.gmL, this.gmh + this.gma, (this.glY.bottom - this.gmL) - this.gmj, this.mPaint);
            }
        } else if (this.gmE != null) {
            RectF rectF2 = new RectF(this.glY.left + this.gmL + this.gmj, this.glY.top + this.gmL + 0.5f, (this.glY.right - this.gmL) - this.gmj, this.gmF);
            Rect rect2 = new Rect(0, (int) (this.gmE.getHeight() - rectF2.height()), this.gmE.getWidth(), this.gmE.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gmP);
            canvas.drawBitmap(this.gmE, rect2, rectF2, this.mPaint);
        } else if (this.gmm != null) {
            canvas.drawBitmap(this.gmm, (Rect) null, new RectF(this.glY.left + this.gmL + this.gmj, this.glZ, (this.glY.right - this.gmL) - this.gmj, this.glZ + this.gmm.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gmi);
            canvas.drawRect(this.gmj + this.glY.left + this.gmL, this.glZ, (this.glY.right - this.gmL) - this.gmj, this.gmh + this.glZ, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fcL) && this.gmM != null) {
            if (this.gmw) {
                if (this.gmA) {
                    this.mPaint.setColor(this.gmz);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gmy) {
                        Rect rect = new Rect();
                        this.gmb.getTextBounds(this.fcL, 0, this.fcL.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gmN;
                        canvas.drawRoundRect(new RectF(width, (this.glY.bottom + this.gmx) - this.gmN, rect.width() + width + (this.gmN * 2), this.glY.bottom + this.gmx + this.gmM.getHeight() + this.gmN), this.gmN, this.gmN, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.glY.left, (this.glY.bottom + this.gmx) - this.gmN, this.glY.right, this.glY.bottom + this.gmx + this.gmM.getHeight() + this.gmN), this.gmN, this.gmN, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gmy) {
                    canvas.translate(0.0f, this.glY.bottom + this.gmx);
                } else {
                    canvas.translate(this.glY.left + this.gmN, this.glY.bottom + this.gmx);
                }
                this.gmM.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gmA) {
                this.mPaint.setColor(this.gmz);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gmy) {
                    Rect rect2 = new Rect();
                    this.gmb.getTextBounds(this.fcL, 0, this.fcL.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gmN;
                    canvas.drawRoundRect(new RectF(width2, ((this.glY.top - this.gmx) - this.gmM.getHeight()) - this.gmN, rect2.width() + width2 + (this.gmN * 2), (this.glY.top - this.gmx) + this.gmN), this.gmN, this.gmN, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.glY.left, ((this.glY.top - this.gmx) - this.gmM.getHeight()) - this.gmN, this.glY.right, (this.glY.top - this.gmx) + this.gmN), this.gmN, this.gmN, this.mPaint);
                }
            }
            canvas.save();
            if (this.gmy) {
                canvas.translate(0.0f, (this.glY.top - this.gmx) - this.gmM.getHeight());
            } else {
                canvas.translate(this.glY.left + this.gmN, (this.glY.top - this.gmx) - this.gmM.getHeight());
            }
            this.gmM.draw(canvas);
            canvas.restore();
        }
    }

    private void bmM() {
        if (this.gmr) {
            if (this.gmE == null) {
                this.gma += this.glW;
                int i = this.gmh;
                if (this.gmm != null) {
                    i = this.gmm.getWidth();
                }
                if (this.gmB) {
                    if (i + this.gma > this.glY.right - this.gmL || this.gma < this.glY.left + this.gmL) {
                        this.glW = -this.glW;
                    }
                } else {
                    if (i + this.gma > this.glY.right - this.gmL) {
                        this.gma = this.glY.left + this.gmL + 0.5f;
                    }
                }
            } else {
                this.gmG += this.glW;
                if (this.gmG > this.glY.right - this.gmL) {
                    this.gmG = this.glY.left + this.gmL + 0.5f;
                }
            }
        } else if (this.gmE == null) {
            this.glZ += this.glW;
            int i2 = this.gmh;
            if (this.gmm != null) {
                i2 = this.gmm.getHeight();
            }
            if (this.gmB) {
                if (i2 + this.glZ > this.glY.bottom - this.gmL || this.glZ < this.glY.top + this.gmL) {
                    this.glW = -this.glW;
                }
            } else {
                if (i2 + this.glZ > this.glY.bottom - this.gmL) {
                    this.glZ = this.glY.top + this.gmL + 0.5f;
                }
            }
        } else {
            this.gmF += this.glW;
            if (this.gmF > this.glY.bottom - this.gmL) {
                this.gmF = this.glY.top + this.gmL + 0.5f;
            }
        }
        postInvalidateDelayed(this.glX, this.glY.left, this.glY.top, this.glY.right, this.glY.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bmN();
    }

    private void bmN() {
        int i = this.aXm + this.gmq;
        int width = (getWidth() - this.gme) / 2;
        this.glY = new Rect(width, i, this.gme + width, this.gmf + i);
        if (this.gmr) {
            float f = this.glY.left + this.gmL + 0.5f;
            this.gma = f;
            this.gmG = f;
            return;
        }
        float f2 = this.glY.top + this.gmL + 0.5f;
        this.glZ = f2;
        this.gmF = f2;
    }

    public Rect sa(int i) {
        if (this.gmO) {
            Rect rect = new Rect(this.glY);
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
        this.gmr = z;
        if (this.gmD != null || this.gmC) {
            if (this.gmr) {
                this.gmE = this.gmK;
            } else {
                this.gmE = this.gmJ;
            }
        } else if (this.gml != null || this.gmk) {
            if (this.gmr) {
                this.gmm = this.gmI;
            } else {
                this.gmm = this.gmH;
            }
        }
        if (this.gmr) {
            this.fcL = this.gmt;
            this.gmf = this.gmg;
            this.glX = (int) (((this.gmo * 1.0f) * this.glW) / this.gme);
        } else {
            this.fcL = this.gms;
            this.gmf = this.gme;
            this.glX = (int) (((this.gmo * 1.0f) * this.glW) / this.gmf);
        }
        if (!TextUtils.isEmpty(this.fcL)) {
            if (this.gmy) {
                this.gmM = new StaticLayout(this.fcL, this.gmb, a.cb(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gmM = new StaticLayout(this.fcL, this.gmb, this.gme - (this.gmN * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gmp) {
            int i = a.cb(getContext()).y;
            if (this.gmq == 0) {
                this.aXm = (i - this.gmf) / 2;
            } else {
                this.aXm = ((i - this.gmf) / 2) + (this.gmq / 2);
            }
        }
        bmN();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gmr;
    }

    public int getMaskColor() {
        return this.aur;
    }

    public void setMaskColor(int i) {
        this.aur = i;
    }

    public int getCornerLength() {
        return this.gmc;
    }

    public void setCornerLength(int i) {
        this.gmc = i;
    }

    public int getCornerSize() {
        return this.gmd;
    }

    public void setCornerSize(int i) {
        this.gmd = i;
    }

    public int getRectWidth() {
        return this.gme;
    }

    public void setRectWidth(int i) {
        this.gme = i;
    }

    public int getRectHeight() {
        return this.gmf;
    }

    public void setRectHeight(int i) {
        this.gmf = i;
    }

    public int getBarcodeRectHeight() {
        return this.gmg;
    }

    public void setBarcodeRectHeight(int i) {
        this.gmg = i;
    }

    public int getTopOffset() {
        return this.aXm;
    }

    public void setTopOffset(int i) {
        this.aXm = i;
    }

    public int getScanLineSize() {
        return this.gmh;
    }

    public void setScanLineSize(int i) {
        this.gmh = i;
    }

    public int getScanLineColor() {
        return this.gmi;
    }

    public void setScanLineColor(int i) {
        this.gmi = i;
    }

    public int getScanLineMargin() {
        return this.gmj;
    }

    public void setScanLineMargin(int i) {
        this.gmj = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gmk = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gml;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gml = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gmm;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gmm = bitmap;
    }

    public int getBorderSize() {
        return this.gmn;
    }

    public void setBorderSize(int i) {
        this.gmn = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gmo;
    }

    public void setAnimTime(int i) {
        this.gmo = i;
    }

    public void setCenterVertical(boolean z) {
        this.gmp = z;
    }

    public int getToolbarHeight() {
        return this.gmq;
    }

    public void setToolbarHeight(int i) {
        this.gmq = i;
    }

    public String getQRCodeTipText() {
        return this.gms;
    }

    public void setQRCodeTipText(String str) {
        this.gms = str;
    }

    public String getBarCodeTipText() {
        return this.gmt;
    }

    public void setBarCodeTipText(String str) {
        this.gmt = str;
    }

    public String getTipText() {
        return this.fcL;
    }

    public void setTipText(String str) {
        this.fcL = str;
    }

    public int getTipTextColor() {
        return this.gmv;
    }

    public void setTipTextColor(int i) {
        this.gmv = i;
    }

    public int getTipTextSize() {
        return this.gmu;
    }

    public void setTipTextSize(int i) {
        this.gmu = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gmw = z;
    }

    public int getTipTextMargin() {
        return this.gmx;
    }

    public void setTipTextMargin(int i) {
        this.gmx = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gmy = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gmA = z;
    }

    public int getTipBackgroundColor() {
        return this.gmz;
    }

    public void setTipBackgroundColor(int i) {
        this.gmz = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gmB = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gmC = z;
    }

    public float getHalfCornerSize() {
        return this.gmL;
    }

    public void setHalfCornerSize(float f) {
        this.gmL = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gmM;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gmM = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gmN;
    }

    public void setTipBackgroundRadius(int i) {
        this.gmN = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gmO = z;
    }
}
