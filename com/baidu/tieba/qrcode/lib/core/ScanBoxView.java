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
    private int aCm;
    private int bfh;
    private String frR;
    private Bitmap gAL;
    private Bitmap gAM;
    private Bitmap gAN;
    private Bitmap gAO;
    private int gAP;
    private int gAQ;
    private Rect gAR;
    private float gAS;
    private float gAT;
    private TextPaint gAU;
    private int gAV;
    private int gAW;
    private int gAX;
    private int gAY;
    private int gAZ;
    private Bitmap gBA;
    private Bitmap gBB;
    private Bitmap gBC;
    private Bitmap gBD;
    private float gBE;
    private StaticLayout gBF;
    private int gBG;
    private boolean gBH;
    private ColorMatrixColorFilter gBI;
    private int gBa;
    private int gBb;
    private int gBc;
    private boolean gBd;
    private Drawable gBe;
    private Bitmap gBf;
    private int gBg;
    private int gBh;
    private boolean gBi;
    private int gBj;
    private boolean gBk;
    private String gBl;
    private String gBm;
    private int gBn;
    private int gBo;
    private boolean gBp;
    private int gBq;
    private boolean gBr;
    private int gBs;
    private boolean gBt;
    private boolean gBu;
    private boolean gBv;
    private Drawable gBw;
    private Bitmap gBx;
    private float gBy;
    private float gBz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aCm = Color.parseColor("#33FFFFFF");
        this.gAV = a.f(context, 20.0f);
        this.gAW = a.f(context, 3.0f);
        this.gBa = a.f(context, 1.0f);
        this.gBb = -1;
        this.bfh = a.f(context, 90.0f);
        this.gAX = a.f(context, 200.0f);
        this.gAZ = a.f(context, 140.0f);
        this.gBc = 0;
        this.gBd = false;
        this.gBe = null;
        this.gBf = null;
        this.gBg = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gBh = 1000;
        this.gBi = false;
        this.gBj = 0;
        this.gBk = false;
        this.gAP = a.f(context, 2.0f);
        this.frR = null;
        this.gBn = a.e(context, 14.0f);
        this.gBo = -1;
        this.gBp = false;
        this.gBq = a.f(context, 20.0f);
        this.gBr = false;
        this.gBs = Color.parseColor("#22000000");
        this.gBt = false;
        this.gBu = false;
        this.gBv = false;
        this.gAU = new TextPaint();
        this.gAU.setAntiAlias(true);
        this.gBG = a.f(context, 4.0f);
        this.gBH = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gBI = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bsH();
        bsG();
    }

    private void bsG() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gAV;
        options.outHeight = this.gAV;
        this.gAL = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gAM = Bitmap.createBitmap(this.gAL, 0, 0, this.gAL.getWidth(), this.gAL.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gAN = Bitmap.createBitmap(this.gAL, 0, 0, this.gAL.getWidth(), this.gAL.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gAO = Bitmap.createBitmap(this.gAL, 0, 0, this.gAL.getWidth(), this.gAL.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bfh = typedArray.getDimensionPixelSize(i, this.bfh);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gAW = typedArray.getDimensionPixelSize(i, this.gAW);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gAV = typedArray.getDimensionPixelSize(i, this.gAV);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gBa = typedArray.getDimensionPixelSize(i, this.gBa);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gAX = typedArray.getDimensionPixelSize(i, this.gAX);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aCm = typedArray.getColor(i, this.aCm);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gBb = typedArray.getColor(i, this.gBb);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gBc = typedArray.getDimensionPixelSize(i, this.gBc);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gBd = typedArray.getBoolean(i, this.gBd);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gBe = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gBg = typedArray.getDimensionPixelSize(i, this.gBg);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gBh = typedArray.getInteger(i, this.gBh);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gBi = typedArray.getBoolean(i, this.gBi);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gBj = typedArray.getDimensionPixelSize(i, this.gBj);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gAZ = typedArray.getDimensionPixelSize(i, this.gAZ);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gBk = typedArray.getBoolean(i, this.gBk);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gBm = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gBl = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gBn = typedArray.getDimensionPixelSize(i, this.gBn);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gBo = typedArray.getColor(i, this.gBo);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gBp = typedArray.getBoolean(i, this.gBp);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gBq = typedArray.getDimensionPixelSize(i, this.gBq);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gBr = typedArray.getBoolean(i, this.gBr);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gBt = typedArray.getBoolean(i, this.gBt);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gBs = typedArray.getColor(i, this.gBs);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gBu = typedArray.getBoolean(i, this.gBu);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gBv = typedArray.getBoolean(i, this.gBv);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gBw = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gBH = typedArray.getBoolean(i, this.gBH);
        }
    }

    private void bsH() {
        if (this.gBw != null) {
            this.gBC = ((BitmapDrawable) this.gBw).getBitmap();
        }
        if (this.gBC == null) {
            this.gBC = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gBC = a.c(this.gBC, this.gBb);
        }
        this.gBD = a.adjustPhotoRotation(this.gBC, 90);
        this.gBD = a.adjustPhotoRotation(this.gBD, 90);
        this.gBD = a.adjustPhotoRotation(this.gBD, 90);
        if (this.gBe != null) {
            this.gBA = ((BitmapDrawable) this.gBe).getBitmap();
        }
        if (this.gBA == null) {
            this.gBA = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gBA = a.c(this.gBA, this.gBb);
        }
        this.gBB = a.adjustPhotoRotation(this.gBA, 90);
        this.gBE = (1.0f * this.gAW) / 2.0f;
        this.gAU.setTextSize(this.gBn);
        this.gAU.setColor(this.gBo);
        setIsBarcode(this.gBk);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gAR != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            bsI();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aCm != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aCm);
            canvas.drawRect(0.0f, 0.0f, width, this.gAR.top, this.mPaint);
            canvas.drawRect(0.0f, this.gAR.top, this.gAR.left, this.gAR.bottom + 1, this.mPaint);
            canvas.drawRect(this.gAR.right + 1, this.gAR.top, width, this.gAR.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gAR.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gBg > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gBg);
            canvas.drawRect(this.gAR, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gAL, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gAM, getMainFrameRight() - this.gAL.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gAN, getMainFrameLeft(), getMainFrameBottom() - this.gAL.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gAO, getMainFrameRight() - this.gAL.getWidth(), getMainFrameBottom() - this.gAL.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gAR.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gAR.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gAR.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gAR.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gBg / 2;
    }

    private void E(Canvas canvas) {
        if (this.gBk) {
            if (this.gBx != null) {
                RectF rectF = new RectF(this.gAR.left + this.gBE + 0.5f, this.gAR.top + this.gBE + this.gBc, this.gBz, (this.gAR.bottom - this.gBE) - this.gBc);
                Rect rect = new Rect((int) (this.gBx.getWidth() - rectF.width()), 0, this.gBx.getWidth(), this.gBx.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gBx, rect, rectF, this.mPaint);
            } else if (this.gBf != null) {
                canvas.drawBitmap(this.gBf, (Rect) null, new RectF(this.gAT, this.gAR.top + this.gBE + this.gBc, this.gAT + this.gBf.getWidth(), (this.gAR.bottom - this.gBE) - this.gBc), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gBb);
                canvas.drawRect(this.gAT, this.gBc + this.gAR.top + this.gBE, this.gBa + this.gAT, (this.gAR.bottom - this.gBE) - this.gBc, this.mPaint);
            }
        } else if (this.gBx != null) {
            RectF rectF2 = new RectF(this.gAR.left + this.gBE + this.gBc, this.gAR.top + this.gBE + 0.5f, (this.gAR.right - this.gBE) - this.gBc, this.gBy);
            Rect rect2 = new Rect(0, (int) (this.gBx.getHeight() - rectF2.height()), this.gBx.getWidth(), this.gBx.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gBI);
            canvas.drawBitmap(this.gBx, rect2, rectF2, this.mPaint);
        } else if (this.gBf != null) {
            canvas.drawBitmap(this.gBf, (Rect) null, new RectF(this.gAR.left + this.gBE + this.gBc, this.gAS, (this.gAR.right - this.gBE) - this.gBc, this.gAS + this.gBf.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gBb);
            canvas.drawRect(this.gBc + this.gAR.left + this.gBE, this.gAS, (this.gAR.right - this.gBE) - this.gBc, this.gBa + this.gAS, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.frR) && this.gBF != null) {
            if (this.gBp) {
                if (this.gBt) {
                    this.mPaint.setColor(this.gBs);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gBr) {
                        Rect rect = new Rect();
                        this.gAU.getTextBounds(this.frR, 0, this.frR.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gBG;
                        canvas.drawRoundRect(new RectF(width, (this.gAR.bottom + this.gBq) - this.gBG, rect.width() + width + (this.gBG * 2), this.gAR.bottom + this.gBq + this.gBF.getHeight() + this.gBG), this.gBG, this.gBG, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gAR.left, (this.gAR.bottom + this.gBq) - this.gBG, this.gAR.right, this.gAR.bottom + this.gBq + this.gBF.getHeight() + this.gBG), this.gBG, this.gBG, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gBr) {
                    canvas.translate(0.0f, this.gAR.bottom + this.gBq);
                } else {
                    canvas.translate(this.gAR.left + this.gBG, this.gAR.bottom + this.gBq);
                }
                this.gBF.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gBt) {
                this.mPaint.setColor(this.gBs);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gBr) {
                    Rect rect2 = new Rect();
                    this.gAU.getTextBounds(this.frR, 0, this.frR.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gBG;
                    canvas.drawRoundRect(new RectF(width2, ((this.gAR.top - this.gBq) - this.gBF.getHeight()) - this.gBG, rect2.width() + width2 + (this.gBG * 2), (this.gAR.top - this.gBq) + this.gBG), this.gBG, this.gBG, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gAR.left, ((this.gAR.top - this.gBq) - this.gBF.getHeight()) - this.gBG, this.gAR.right, (this.gAR.top - this.gBq) + this.gBG), this.gBG, this.gBG, this.mPaint);
                }
            }
            canvas.save();
            if (this.gBr) {
                canvas.translate(0.0f, (this.gAR.top - this.gBq) - this.gBF.getHeight());
            } else {
                canvas.translate(this.gAR.left + this.gBG, (this.gAR.top - this.gBq) - this.gBF.getHeight());
            }
            this.gBF.draw(canvas);
            canvas.restore();
        }
    }

    private void bsI() {
        if (this.gBk) {
            if (this.gBx == null) {
                this.gAT += this.gAP;
                int i = this.gBa;
                if (this.gBf != null) {
                    i = this.gBf.getWidth();
                }
                if (this.gBu) {
                    if (i + this.gAT > this.gAR.right - this.gBE || this.gAT < this.gAR.left + this.gBE) {
                        this.gAP = -this.gAP;
                    }
                } else {
                    if (i + this.gAT > this.gAR.right - this.gBE) {
                        this.gAT = this.gAR.left + this.gBE + 0.5f;
                    }
                }
            } else {
                this.gBz += this.gAP;
                if (this.gBz > this.gAR.right - this.gBE) {
                    this.gBz = this.gAR.left + this.gBE + 0.5f;
                }
            }
        } else if (this.gBx == null) {
            this.gAS += this.gAP;
            int i2 = this.gBa;
            if (this.gBf != null) {
                i2 = this.gBf.getHeight();
            }
            if (this.gBu) {
                if (i2 + this.gAS > this.gAR.bottom - this.gBE || this.gAS < this.gAR.top + this.gBE) {
                    this.gAP = -this.gAP;
                }
            } else {
                if (i2 + this.gAS > this.gAR.bottom - this.gBE) {
                    this.gAS = this.gAR.top + this.gBE + 0.5f;
                }
            }
        } else {
            this.gBy += this.gAP;
            if (this.gBy > this.gAR.bottom - this.gBE) {
                this.gBy = this.gAR.top + this.gBE + 0.5f;
            }
        }
        postInvalidateDelayed(this.gAQ, this.gAR.left, this.gAR.top, this.gAR.right, this.gAR.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bsJ();
    }

    private void bsJ() {
        int i = this.bfh + this.gBj;
        int width = (getWidth() - this.gAX) / 2;
        this.gAR = new Rect(width, i, this.gAX + width, this.gAY + i);
        if (this.gBk) {
            float f = this.gAR.left + this.gBE + 0.5f;
            this.gAT = f;
            this.gBz = f;
            return;
        }
        float f2 = this.gAR.top + this.gBE + 0.5f;
        this.gAS = f2;
        this.gBy = f2;
    }

    public Rect sU(int i) {
        if (this.gBH) {
            Rect rect = new Rect(this.gAR);
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
        this.gBk = z;
        if (this.gBw != null || this.gBv) {
            if (this.gBk) {
                this.gBx = this.gBD;
            } else {
                this.gBx = this.gBC;
            }
        } else if (this.gBe != null || this.gBd) {
            if (this.gBk) {
                this.gBf = this.gBB;
            } else {
                this.gBf = this.gBA;
            }
        }
        if (this.gBk) {
            this.frR = this.gBm;
            this.gAY = this.gAZ;
            this.gAQ = (int) (((this.gBh * 1.0f) * this.gAP) / this.gAX);
        } else {
            this.frR = this.gBl;
            this.gAY = this.gAX;
            this.gAQ = (int) (((this.gBh * 1.0f) * this.gAP) / this.gAY);
        }
        if (!TextUtils.isEmpty(this.frR)) {
            if (this.gBr) {
                this.gBF = new StaticLayout(this.frR, this.gAU, a.cV(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gBF = new StaticLayout(this.frR, this.gAU, this.gAX - (this.gBG * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gBi) {
            int i = a.cV(getContext()).y;
            if (this.gBj == 0) {
                this.bfh = (i - this.gAY) / 2;
            } else {
                this.bfh = ((i - this.gAY) / 2) + (this.gBj / 2);
            }
        }
        bsJ();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gBk;
    }

    public int getMaskColor() {
        return this.aCm;
    }

    public void setMaskColor(int i) {
        this.aCm = i;
    }

    public int getCornerLength() {
        return this.gAV;
    }

    public void setCornerLength(int i) {
        this.gAV = i;
    }

    public int getCornerSize() {
        return this.gAW;
    }

    public void setCornerSize(int i) {
        this.gAW = i;
    }

    public int getRectWidth() {
        return this.gAX;
    }

    public void setRectWidth(int i) {
        this.gAX = i;
    }

    public int getRectHeight() {
        return this.gAY;
    }

    public void setRectHeight(int i) {
        this.gAY = i;
    }

    public int getBarcodeRectHeight() {
        return this.gAZ;
    }

    public void setBarcodeRectHeight(int i) {
        this.gAZ = i;
    }

    public int getTopOffset() {
        return this.bfh;
    }

    public void setTopOffset(int i) {
        this.bfh = i;
    }

    public int getScanLineSize() {
        return this.gBa;
    }

    public void setScanLineSize(int i) {
        this.gBa = i;
    }

    public int getScanLineColor() {
        return this.gBb;
    }

    public void setScanLineColor(int i) {
        this.gBb = i;
    }

    public int getScanLineMargin() {
        return this.gBc;
    }

    public void setScanLineMargin(int i) {
        this.gBc = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gBd = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gBe;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gBe = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gBf;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gBf = bitmap;
    }

    public int getBorderSize() {
        return this.gBg;
    }

    public void setBorderSize(int i) {
        this.gBg = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gBh;
    }

    public void setAnimTime(int i) {
        this.gBh = i;
    }

    public void setCenterVertical(boolean z) {
        this.gBi = z;
    }

    public int getToolbarHeight() {
        return this.gBj;
    }

    public void setToolbarHeight(int i) {
        this.gBj = i;
    }

    public String getQRCodeTipText() {
        return this.gBl;
    }

    public void setQRCodeTipText(String str) {
        this.gBl = str;
    }

    public String getBarCodeTipText() {
        return this.gBm;
    }

    public void setBarCodeTipText(String str) {
        this.gBm = str;
    }

    public String getTipText() {
        return this.frR;
    }

    public void setTipText(String str) {
        this.frR = str;
    }

    public int getTipTextColor() {
        return this.gBo;
    }

    public void setTipTextColor(int i) {
        this.gBo = i;
    }

    public int getTipTextSize() {
        return this.gBn;
    }

    public void setTipTextSize(int i) {
        this.gBn = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gBp = z;
    }

    public int getTipTextMargin() {
        return this.gBq;
    }

    public void setTipTextMargin(int i) {
        this.gBq = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gBr = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gBt = z;
    }

    public int getTipBackgroundColor() {
        return this.gBs;
    }

    public void setTipBackgroundColor(int i) {
        this.gBs = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gBu = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gBv = z;
    }

    public float getHalfCornerSize() {
        return this.gBE;
    }

    public void setHalfCornerSize(float f) {
        this.gBE = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gBF;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gBF = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gBG;
    }

    public void setTipBackgroundRadius(int i) {
        this.gBG = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gBH = z;
    }
}
