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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ScanBoxView extends View {
    private int aGB;
    private int bjw;
    private String fCP;
    private Bitmap gLU;
    private Bitmap gLV;
    private Bitmap gLW;
    private Bitmap gLX;
    private int gLY;
    private int gLZ;
    private boolean gMA;
    private int gMB;
    private boolean gMC;
    private boolean gMD;
    private boolean gME;
    private Drawable gMF;
    private Bitmap gMG;
    private float gMH;
    private float gMI;
    private Bitmap gMJ;
    private Bitmap gMK;
    private Bitmap gML;
    private Bitmap gMM;
    private float gMN;
    private StaticLayout gMO;
    private int gMP;
    private boolean gMQ;
    private ColorMatrixColorFilter gMR;
    private Rect gMa;
    private float gMb;
    private float gMc;
    private TextPaint gMd;
    private int gMe;
    private int gMf;
    private int gMg;
    private int gMh;
    private int gMi;
    private int gMj;
    private int gMk;
    private int gMl;
    private boolean gMm;
    private Drawable gMn;
    private Bitmap gMo;
    private int gMp;
    private int gMq;
    private boolean gMr;
    private int gMs;
    private boolean gMt;
    private String gMu;
    private String gMv;
    private int gMw;
    private int gMx;
    private boolean gMy;
    private int gMz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGB = Color.parseColor("#33FFFFFF");
        this.gMe = a.f(context, 20.0f);
        this.gMf = a.f(context, 3.0f);
        this.gMj = a.f(context, 1.0f);
        this.gMk = -1;
        this.bjw = a.f(context, 90.0f);
        this.gMg = a.f(context, 200.0f);
        this.gMi = a.f(context, 140.0f);
        this.gMl = 0;
        this.gMm = false;
        this.gMn = null;
        this.gMo = null;
        this.gMp = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gMq = 1000;
        this.gMr = false;
        this.gMs = 0;
        this.gMt = false;
        this.gLY = a.f(context, 2.0f);
        this.fCP = null;
        this.gMw = a.e(context, 14.0f);
        this.gMx = -1;
        this.gMy = false;
        this.gMz = a.f(context, 20.0f);
        this.gMA = false;
        this.gMB = Color.parseColor("#22000000");
        this.gMC = false;
        this.gMD = false;
        this.gME = false;
        this.gMd = new TextPaint();
        this.gMd.setAntiAlias(true);
        this.gMP = a.f(context, 4.0f);
        this.gMQ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gMR = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        buH();
        buG();
    }

    private void buG() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gMe;
        options.outHeight = this.gMe;
        this.gLU = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gLV = Bitmap.createBitmap(this.gLU, 0, 0, this.gLU.getWidth(), this.gLU.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gLW = Bitmap.createBitmap(this.gLU, 0, 0, this.gLU.getWidth(), this.gLU.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gLX = Bitmap.createBitmap(this.gLU, 0, 0, this.gLU.getWidth(), this.gLU.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bjw = typedArray.getDimensionPixelSize(i, this.bjw);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gMf = typedArray.getDimensionPixelSize(i, this.gMf);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gMe = typedArray.getDimensionPixelSize(i, this.gMe);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gMj = typedArray.getDimensionPixelSize(i, this.gMj);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gMg = typedArray.getDimensionPixelSize(i, this.gMg);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aGB = typedArray.getColor(i, this.aGB);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gMk = typedArray.getColor(i, this.gMk);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gMl = typedArray.getDimensionPixelSize(i, this.gMl);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gMm = typedArray.getBoolean(i, this.gMm);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gMn = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gMp = typedArray.getDimensionPixelSize(i, this.gMp);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gMq = typedArray.getInteger(i, this.gMq);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gMr = typedArray.getBoolean(i, this.gMr);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gMs = typedArray.getDimensionPixelSize(i, this.gMs);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gMi = typedArray.getDimensionPixelSize(i, this.gMi);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gMt = typedArray.getBoolean(i, this.gMt);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gMv = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gMu = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gMw = typedArray.getDimensionPixelSize(i, this.gMw);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gMx = typedArray.getColor(i, this.gMx);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gMy = typedArray.getBoolean(i, this.gMy);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gMz = typedArray.getDimensionPixelSize(i, this.gMz);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gMA = typedArray.getBoolean(i, this.gMA);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gMC = typedArray.getBoolean(i, this.gMC);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gMB = typedArray.getColor(i, this.gMB);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gMD = typedArray.getBoolean(i, this.gMD);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gME = typedArray.getBoolean(i, this.gME);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gMF = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gMQ = typedArray.getBoolean(i, this.gMQ);
        }
    }

    private void buH() {
        if (this.gMF != null) {
            this.gML = ((BitmapDrawable) this.gMF).getBitmap();
        }
        if (this.gML == null) {
            this.gML = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gML = a.c(this.gML, this.gMk);
        }
        this.gMM = a.adjustPhotoRotation(this.gML, 90);
        this.gMM = a.adjustPhotoRotation(this.gMM, 90);
        this.gMM = a.adjustPhotoRotation(this.gMM, 90);
        if (this.gMn != null) {
            this.gMJ = ((BitmapDrawable) this.gMn).getBitmap();
        }
        if (this.gMJ == null) {
            this.gMJ = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gMJ = a.c(this.gMJ, this.gMk);
        }
        this.gMK = a.adjustPhotoRotation(this.gMJ, 90);
        this.gMN = (1.0f * this.gMf) / 2.0f;
        this.gMd.setTextSize(this.gMw);
        this.gMd.setColor(this.gMx);
        setIsBarcode(this.gMt);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gMa != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            buI();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aGB != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aGB);
            canvas.drawRect(0.0f, 0.0f, width, this.gMa.top, this.mPaint);
            canvas.drawRect(0.0f, this.gMa.top, this.gMa.left, this.gMa.bottom + 1, this.mPaint);
            canvas.drawRect(this.gMa.right + 1, this.gMa.top, width, this.gMa.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gMa.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gMp > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gMp);
            canvas.drawRect(this.gMa, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gLU, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gLV, getMainFrameRight() - this.gLU.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gLW, getMainFrameLeft(), getMainFrameBottom() - this.gLU.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gLX, getMainFrameRight() - this.gLU.getWidth(), getMainFrameBottom() - this.gLU.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gMa.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gMa.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gMa.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gMa.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gMp / 2;
    }

    private void E(Canvas canvas) {
        if (this.gMt) {
            if (this.gMG != null) {
                RectF rectF = new RectF(this.gMa.left + this.gMN + 0.5f, this.gMa.top + this.gMN + this.gMl, this.gMI, (this.gMa.bottom - this.gMN) - this.gMl);
                Rect rect = new Rect((int) (this.gMG.getWidth() - rectF.width()), 0, this.gMG.getWidth(), this.gMG.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gMG, rect, rectF, this.mPaint);
            } else if (this.gMo != null) {
                canvas.drawBitmap(this.gMo, (Rect) null, new RectF(this.gMc, this.gMa.top + this.gMN + this.gMl, this.gMc + this.gMo.getWidth(), (this.gMa.bottom - this.gMN) - this.gMl), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gMk);
                canvas.drawRect(this.gMc, this.gMl + this.gMa.top + this.gMN, this.gMj + this.gMc, (this.gMa.bottom - this.gMN) - this.gMl, this.mPaint);
            }
        } else if (this.gMG != null) {
            RectF rectF2 = new RectF(this.gMa.left + this.gMN + this.gMl, this.gMa.top + this.gMN + 0.5f, (this.gMa.right - this.gMN) - this.gMl, this.gMH);
            Rect rect2 = new Rect(0, (int) (this.gMG.getHeight() - rectF2.height()), this.gMG.getWidth(), this.gMG.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gMR);
            canvas.drawBitmap(this.gMG, rect2, rectF2, this.mPaint);
        } else if (this.gMo != null) {
            canvas.drawBitmap(this.gMo, (Rect) null, new RectF(this.gMa.left + this.gMN + this.gMl, this.gMb, (this.gMa.right - this.gMN) - this.gMl, this.gMb + this.gMo.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gMk);
            canvas.drawRect(this.gMl + this.gMa.left + this.gMN, this.gMb, (this.gMa.right - this.gMN) - this.gMl, this.gMj + this.gMb, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fCP) && this.gMO != null) {
            if (this.gMy) {
                if (this.gMC) {
                    this.mPaint.setColor(this.gMB);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gMA) {
                        Rect rect = new Rect();
                        this.gMd.getTextBounds(this.fCP, 0, this.fCP.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gMP;
                        canvas.drawRoundRect(new RectF(width, (this.gMa.bottom + this.gMz) - this.gMP, rect.width() + width + (this.gMP * 2), this.gMa.bottom + this.gMz + this.gMO.getHeight() + this.gMP), this.gMP, this.gMP, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gMa.left, (this.gMa.bottom + this.gMz) - this.gMP, this.gMa.right, this.gMa.bottom + this.gMz + this.gMO.getHeight() + this.gMP), this.gMP, this.gMP, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gMA) {
                    canvas.translate(0.0f, this.gMa.bottom + this.gMz);
                } else {
                    canvas.translate(this.gMa.left + this.gMP, this.gMa.bottom + this.gMz);
                }
                this.gMO.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gMC) {
                this.mPaint.setColor(this.gMB);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gMA) {
                    Rect rect2 = new Rect();
                    this.gMd.getTextBounds(this.fCP, 0, this.fCP.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gMP;
                    canvas.drawRoundRect(new RectF(width2, ((this.gMa.top - this.gMz) - this.gMO.getHeight()) - this.gMP, rect2.width() + width2 + (this.gMP * 2), (this.gMa.top - this.gMz) + this.gMP), this.gMP, this.gMP, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gMa.left, ((this.gMa.top - this.gMz) - this.gMO.getHeight()) - this.gMP, this.gMa.right, (this.gMa.top - this.gMz) + this.gMP), this.gMP, this.gMP, this.mPaint);
                }
            }
            canvas.save();
            if (this.gMA) {
                canvas.translate(0.0f, (this.gMa.top - this.gMz) - this.gMO.getHeight());
            } else {
                canvas.translate(this.gMa.left + this.gMP, (this.gMa.top - this.gMz) - this.gMO.getHeight());
            }
            this.gMO.draw(canvas);
            canvas.restore();
        }
    }

    private void buI() {
        if (this.gMt) {
            if (this.gMG == null) {
                this.gMc += this.gLY;
                int i = this.gMj;
                if (this.gMo != null) {
                    i = this.gMo.getWidth();
                }
                if (this.gMD) {
                    if (i + this.gMc > this.gMa.right - this.gMN || this.gMc < this.gMa.left + this.gMN) {
                        this.gLY = -this.gLY;
                    }
                } else {
                    if (i + this.gMc > this.gMa.right - this.gMN) {
                        this.gMc = this.gMa.left + this.gMN + 0.5f;
                    }
                }
            } else {
                this.gMI += this.gLY;
                if (this.gMI > this.gMa.right - this.gMN) {
                    this.gMI = this.gMa.left + this.gMN + 0.5f;
                }
            }
        } else if (this.gMG == null) {
            this.gMb += this.gLY;
            int i2 = this.gMj;
            if (this.gMo != null) {
                i2 = this.gMo.getHeight();
            }
            if (this.gMD) {
                if (i2 + this.gMb > this.gMa.bottom - this.gMN || this.gMb < this.gMa.top + this.gMN) {
                    this.gLY = -this.gLY;
                }
            } else {
                if (i2 + this.gMb > this.gMa.bottom - this.gMN) {
                    this.gMb = this.gMa.top + this.gMN + 0.5f;
                }
            }
        } else {
            this.gMH += this.gLY;
            if (this.gMH > this.gMa.bottom - this.gMN) {
                this.gMH = this.gMa.top + this.gMN + 0.5f;
            }
        }
        postInvalidateDelayed(this.gLZ, this.gMa.left, this.gMa.top, this.gMa.right, this.gMa.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        buJ();
    }

    private void buJ() {
        int i = this.bjw + this.gMs;
        int width = (getWidth() - this.gMg) / 2;
        this.gMa = new Rect(width, i, this.gMg + width, this.gMh + i);
        if (this.gMt) {
            float f = this.gMa.left + this.gMN + 0.5f;
            this.gMc = f;
            this.gMI = f;
            return;
        }
        float f2 = this.gMa.top + this.gMN + 0.5f;
        this.gMb = f2;
        this.gMH = f2;
    }

    public Rect tU(int i) {
        if (this.gMQ) {
            Rect rect = new Rect(this.gMa);
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
        this.gMt = z;
        if (this.gMF != null || this.gME) {
            if (this.gMt) {
                this.gMG = this.gMM;
            } else {
                this.gMG = this.gML;
            }
        } else if (this.gMn != null || this.gMm) {
            if (this.gMt) {
                this.gMo = this.gMK;
            } else {
                this.gMo = this.gMJ;
            }
        }
        if (this.gMt) {
            this.fCP = this.gMv;
            this.gMh = this.gMi;
            this.gLZ = (int) (((this.gMq * 1.0f) * this.gLY) / this.gMg);
        } else {
            this.fCP = this.gMu;
            this.gMh = this.gMg;
            this.gLZ = (int) (((this.gMq * 1.0f) * this.gLY) / this.gMh);
        }
        if (!TextUtils.isEmpty(this.fCP)) {
            if (this.gMA) {
                this.gMO = new StaticLayout(this.fCP, this.gMd, a.cU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gMO = new StaticLayout(this.fCP, this.gMd, this.gMg - (this.gMP * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gMr) {
            int i = a.cU(getContext()).y;
            if (this.gMs == 0) {
                this.bjw = (i - this.gMh) / 2;
            } else {
                this.bjw = ((i - this.gMh) / 2) + (this.gMs / 2);
            }
        }
        buJ();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gMt;
    }

    public int getMaskColor() {
        return this.aGB;
    }

    public void setMaskColor(int i) {
        this.aGB = i;
    }

    public int getCornerLength() {
        return this.gMe;
    }

    public void setCornerLength(int i) {
        this.gMe = i;
    }

    public int getCornerSize() {
        return this.gMf;
    }

    public void setCornerSize(int i) {
        this.gMf = i;
    }

    public int getRectWidth() {
        return this.gMg;
    }

    public void setRectWidth(int i) {
        this.gMg = i;
    }

    public int getRectHeight() {
        return this.gMh;
    }

    public void setRectHeight(int i) {
        this.gMh = i;
    }

    public int getBarcodeRectHeight() {
        return this.gMi;
    }

    public void setBarcodeRectHeight(int i) {
        this.gMi = i;
    }

    public int getTopOffset() {
        return this.bjw;
    }

    public void setTopOffset(int i) {
        this.bjw = i;
    }

    public int getScanLineSize() {
        return this.gMj;
    }

    public void setScanLineSize(int i) {
        this.gMj = i;
    }

    public int getScanLineColor() {
        return this.gMk;
    }

    public void setScanLineColor(int i) {
        this.gMk = i;
    }

    public int getScanLineMargin() {
        return this.gMl;
    }

    public void setScanLineMargin(int i) {
        this.gMl = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gMm = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gMn;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gMn = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gMo;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gMo = bitmap;
    }

    public int getBorderSize() {
        return this.gMp;
    }

    public void setBorderSize(int i) {
        this.gMp = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gMq;
    }

    public void setAnimTime(int i) {
        this.gMq = i;
    }

    public void setCenterVertical(boolean z) {
        this.gMr = z;
    }

    public int getToolbarHeight() {
        return this.gMs;
    }

    public void setToolbarHeight(int i) {
        this.gMs = i;
    }

    public String getQRCodeTipText() {
        return this.gMu;
    }

    public void setQRCodeTipText(String str) {
        this.gMu = str;
    }

    public String getBarCodeTipText() {
        return this.gMv;
    }

    public void setBarCodeTipText(String str) {
        this.gMv = str;
    }

    public String getTipText() {
        return this.fCP;
    }

    public void setTipText(String str) {
        this.fCP = str;
    }

    public int getTipTextColor() {
        return this.gMx;
    }

    public void setTipTextColor(int i) {
        this.gMx = i;
    }

    public int getTipTextSize() {
        return this.gMw;
    }

    public void setTipTextSize(int i) {
        this.gMw = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gMy = z;
    }

    public int getTipTextMargin() {
        return this.gMz;
    }

    public void setTipTextMargin(int i) {
        this.gMz = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gMA = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gMC = z;
    }

    public int getTipBackgroundColor() {
        return this.gMB;
    }

    public void setTipBackgroundColor(int i) {
        this.gMB = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gMD = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gME = z;
    }

    public float getHalfCornerSize() {
        return this.gMN;
    }

    public void setHalfCornerSize(float f) {
        this.gMN = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gMO;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gMO = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gMP;
    }

    public void setTipBackgroundRadius(int i) {
        this.gMP = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gMQ = z;
    }
}
