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
    private String frS;
    private Bitmap gAM;
    private Bitmap gAN;
    private Bitmap gAO;
    private Bitmap gAP;
    private int gAQ;
    private int gAR;
    private Rect gAS;
    private float gAT;
    private float gAU;
    private TextPaint gAV;
    private int gAW;
    private int gAX;
    private int gAY;
    private int gAZ;
    private float gBA;
    private Bitmap gBB;
    private Bitmap gBC;
    private Bitmap gBD;
    private Bitmap gBE;
    private float gBF;
    private StaticLayout gBG;
    private int gBH;
    private boolean gBI;
    private ColorMatrixColorFilter gBJ;
    private int gBa;
    private int gBb;
    private int gBc;
    private int gBd;
    private boolean gBe;
    private Drawable gBf;
    private Bitmap gBg;
    private int gBh;
    private int gBi;
    private boolean gBj;
    private int gBk;
    private boolean gBl;
    private String gBm;
    private String gBn;
    private int gBo;
    private int gBp;
    private boolean gBq;
    private int gBr;
    private boolean gBs;
    private int gBt;
    private boolean gBu;
    private boolean gBv;
    private boolean gBw;
    private Drawable gBx;
    private Bitmap gBy;
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
        this.gAW = a.f(context, 20.0f);
        this.gAX = a.f(context, 3.0f);
        this.gBb = a.f(context, 1.0f);
        this.gBc = -1;
        this.bfh = a.f(context, 90.0f);
        this.gAY = a.f(context, 200.0f);
        this.gBa = a.f(context, 140.0f);
        this.gBd = 0;
        this.gBe = false;
        this.gBf = null;
        this.gBg = null;
        this.gBh = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gBi = 1000;
        this.gBj = false;
        this.gBk = 0;
        this.gBl = false;
        this.gAQ = a.f(context, 2.0f);
        this.frS = null;
        this.gBo = a.e(context, 14.0f);
        this.gBp = -1;
        this.gBq = false;
        this.gBr = a.f(context, 20.0f);
        this.gBs = false;
        this.gBt = Color.parseColor("#22000000");
        this.gBu = false;
        this.gBv = false;
        this.gBw = false;
        this.gAV = new TextPaint();
        this.gAV.setAntiAlias(true);
        this.gBH = a.f(context, 4.0f);
        this.gBI = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gBJ = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.gAW;
        options.outHeight = this.gAW;
        this.gAM = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gAN = Bitmap.createBitmap(this.gAM, 0, 0, this.gAM.getWidth(), this.gAM.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gAO = Bitmap.createBitmap(this.gAM, 0, 0, this.gAM.getWidth(), this.gAM.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gAP = Bitmap.createBitmap(this.gAM, 0, 0, this.gAM.getWidth(), this.gAM.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bfh = typedArray.getDimensionPixelSize(i, this.bfh);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gAX = typedArray.getDimensionPixelSize(i, this.gAX);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gAW = typedArray.getDimensionPixelSize(i, this.gAW);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gBb = typedArray.getDimensionPixelSize(i, this.gBb);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gAY = typedArray.getDimensionPixelSize(i, this.gAY);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aCm = typedArray.getColor(i, this.aCm);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gBc = typedArray.getColor(i, this.gBc);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gBd = typedArray.getDimensionPixelSize(i, this.gBd);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gBe = typedArray.getBoolean(i, this.gBe);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gBf = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gBh = typedArray.getDimensionPixelSize(i, this.gBh);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gBi = typedArray.getInteger(i, this.gBi);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gBj = typedArray.getBoolean(i, this.gBj);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gBk = typedArray.getDimensionPixelSize(i, this.gBk);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gBa = typedArray.getDimensionPixelSize(i, this.gBa);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gBl = typedArray.getBoolean(i, this.gBl);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gBn = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gBm = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gBo = typedArray.getDimensionPixelSize(i, this.gBo);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gBp = typedArray.getColor(i, this.gBp);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gBq = typedArray.getBoolean(i, this.gBq);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gBr = typedArray.getDimensionPixelSize(i, this.gBr);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gBs = typedArray.getBoolean(i, this.gBs);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gBu = typedArray.getBoolean(i, this.gBu);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gBt = typedArray.getColor(i, this.gBt);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gBv = typedArray.getBoolean(i, this.gBv);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gBw = typedArray.getBoolean(i, this.gBw);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gBx = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gBI = typedArray.getBoolean(i, this.gBI);
        }
    }

    private void bsH() {
        if (this.gBx != null) {
            this.gBD = ((BitmapDrawable) this.gBx).getBitmap();
        }
        if (this.gBD == null) {
            this.gBD = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gBD = a.c(this.gBD, this.gBc);
        }
        this.gBE = a.adjustPhotoRotation(this.gBD, 90);
        this.gBE = a.adjustPhotoRotation(this.gBE, 90);
        this.gBE = a.adjustPhotoRotation(this.gBE, 90);
        if (this.gBf != null) {
            this.gBB = ((BitmapDrawable) this.gBf).getBitmap();
        }
        if (this.gBB == null) {
            this.gBB = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gBB = a.c(this.gBB, this.gBc);
        }
        this.gBC = a.adjustPhotoRotation(this.gBB, 90);
        this.gBF = (1.0f * this.gAX) / 2.0f;
        this.gAV.setTextSize(this.gBo);
        this.gAV.setColor(this.gBp);
        setIsBarcode(this.gBl);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gAS != null) {
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
            canvas.drawRect(0.0f, 0.0f, width, this.gAS.top, this.mPaint);
            canvas.drawRect(0.0f, this.gAS.top, this.gAS.left, this.gAS.bottom + 1, this.mPaint);
            canvas.drawRect(this.gAS.right + 1, this.gAS.top, width, this.gAS.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gAS.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gBh > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gBh);
            canvas.drawRect(this.gAS, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gAM, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gAN, getMainFrameRight() - this.gAM.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gAO, getMainFrameLeft(), getMainFrameBottom() - this.gAM.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gAP, getMainFrameRight() - this.gAM.getWidth(), getMainFrameBottom() - this.gAM.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gAS.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gAS.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gAS.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gAS.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gBh / 2;
    }

    private void E(Canvas canvas) {
        if (this.gBl) {
            if (this.gBy != null) {
                RectF rectF = new RectF(this.gAS.left + this.gBF + 0.5f, this.gAS.top + this.gBF + this.gBd, this.gBA, (this.gAS.bottom - this.gBF) - this.gBd);
                Rect rect = new Rect((int) (this.gBy.getWidth() - rectF.width()), 0, this.gBy.getWidth(), this.gBy.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gBy, rect, rectF, this.mPaint);
            } else if (this.gBg != null) {
                canvas.drawBitmap(this.gBg, (Rect) null, new RectF(this.gAU, this.gAS.top + this.gBF + this.gBd, this.gAU + this.gBg.getWidth(), (this.gAS.bottom - this.gBF) - this.gBd), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gBc);
                canvas.drawRect(this.gAU, this.gBd + this.gAS.top + this.gBF, this.gBb + this.gAU, (this.gAS.bottom - this.gBF) - this.gBd, this.mPaint);
            }
        } else if (this.gBy != null) {
            RectF rectF2 = new RectF(this.gAS.left + this.gBF + this.gBd, this.gAS.top + this.gBF + 0.5f, (this.gAS.right - this.gBF) - this.gBd, this.gBz);
            Rect rect2 = new Rect(0, (int) (this.gBy.getHeight() - rectF2.height()), this.gBy.getWidth(), this.gBy.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gBJ);
            canvas.drawBitmap(this.gBy, rect2, rectF2, this.mPaint);
        } else if (this.gBg != null) {
            canvas.drawBitmap(this.gBg, (Rect) null, new RectF(this.gAS.left + this.gBF + this.gBd, this.gAT, (this.gAS.right - this.gBF) - this.gBd, this.gAT + this.gBg.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gBc);
            canvas.drawRect(this.gBd + this.gAS.left + this.gBF, this.gAT, (this.gAS.right - this.gBF) - this.gBd, this.gBb + this.gAT, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.frS) && this.gBG != null) {
            if (this.gBq) {
                if (this.gBu) {
                    this.mPaint.setColor(this.gBt);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gBs) {
                        Rect rect = new Rect();
                        this.gAV.getTextBounds(this.frS, 0, this.frS.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gBH;
                        canvas.drawRoundRect(new RectF(width, (this.gAS.bottom + this.gBr) - this.gBH, rect.width() + width + (this.gBH * 2), this.gAS.bottom + this.gBr + this.gBG.getHeight() + this.gBH), this.gBH, this.gBH, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gAS.left, (this.gAS.bottom + this.gBr) - this.gBH, this.gAS.right, this.gAS.bottom + this.gBr + this.gBG.getHeight() + this.gBH), this.gBH, this.gBH, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gBs) {
                    canvas.translate(0.0f, this.gAS.bottom + this.gBr);
                } else {
                    canvas.translate(this.gAS.left + this.gBH, this.gAS.bottom + this.gBr);
                }
                this.gBG.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gBu) {
                this.mPaint.setColor(this.gBt);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gBs) {
                    Rect rect2 = new Rect();
                    this.gAV.getTextBounds(this.frS, 0, this.frS.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gBH;
                    canvas.drawRoundRect(new RectF(width2, ((this.gAS.top - this.gBr) - this.gBG.getHeight()) - this.gBH, rect2.width() + width2 + (this.gBH * 2), (this.gAS.top - this.gBr) + this.gBH), this.gBH, this.gBH, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gAS.left, ((this.gAS.top - this.gBr) - this.gBG.getHeight()) - this.gBH, this.gAS.right, (this.gAS.top - this.gBr) + this.gBH), this.gBH, this.gBH, this.mPaint);
                }
            }
            canvas.save();
            if (this.gBs) {
                canvas.translate(0.0f, (this.gAS.top - this.gBr) - this.gBG.getHeight());
            } else {
                canvas.translate(this.gAS.left + this.gBH, (this.gAS.top - this.gBr) - this.gBG.getHeight());
            }
            this.gBG.draw(canvas);
            canvas.restore();
        }
    }

    private void bsI() {
        if (this.gBl) {
            if (this.gBy == null) {
                this.gAU += this.gAQ;
                int i = this.gBb;
                if (this.gBg != null) {
                    i = this.gBg.getWidth();
                }
                if (this.gBv) {
                    if (i + this.gAU > this.gAS.right - this.gBF || this.gAU < this.gAS.left + this.gBF) {
                        this.gAQ = -this.gAQ;
                    }
                } else {
                    if (i + this.gAU > this.gAS.right - this.gBF) {
                        this.gAU = this.gAS.left + this.gBF + 0.5f;
                    }
                }
            } else {
                this.gBA += this.gAQ;
                if (this.gBA > this.gAS.right - this.gBF) {
                    this.gBA = this.gAS.left + this.gBF + 0.5f;
                }
            }
        } else if (this.gBy == null) {
            this.gAT += this.gAQ;
            int i2 = this.gBb;
            if (this.gBg != null) {
                i2 = this.gBg.getHeight();
            }
            if (this.gBv) {
                if (i2 + this.gAT > this.gAS.bottom - this.gBF || this.gAT < this.gAS.top + this.gBF) {
                    this.gAQ = -this.gAQ;
                }
            } else {
                if (i2 + this.gAT > this.gAS.bottom - this.gBF) {
                    this.gAT = this.gAS.top + this.gBF + 0.5f;
                }
            }
        } else {
            this.gBz += this.gAQ;
            if (this.gBz > this.gAS.bottom - this.gBF) {
                this.gBz = this.gAS.top + this.gBF + 0.5f;
            }
        }
        postInvalidateDelayed(this.gAR, this.gAS.left, this.gAS.top, this.gAS.right, this.gAS.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bsJ();
    }

    private void bsJ() {
        int i = this.bfh + this.gBk;
        int width = (getWidth() - this.gAY) / 2;
        this.gAS = new Rect(width, i, this.gAY + width, this.gAZ + i);
        if (this.gBl) {
            float f = this.gAS.left + this.gBF + 0.5f;
            this.gAU = f;
            this.gBA = f;
            return;
        }
        float f2 = this.gAS.top + this.gBF + 0.5f;
        this.gAT = f2;
        this.gBz = f2;
    }

    public Rect sU(int i) {
        if (this.gBI) {
            Rect rect = new Rect(this.gAS);
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
        this.gBl = z;
        if (this.gBx != null || this.gBw) {
            if (this.gBl) {
                this.gBy = this.gBE;
            } else {
                this.gBy = this.gBD;
            }
        } else if (this.gBf != null || this.gBe) {
            if (this.gBl) {
                this.gBg = this.gBC;
            } else {
                this.gBg = this.gBB;
            }
        }
        if (this.gBl) {
            this.frS = this.gBn;
            this.gAZ = this.gBa;
            this.gAR = (int) (((this.gBi * 1.0f) * this.gAQ) / this.gAY);
        } else {
            this.frS = this.gBm;
            this.gAZ = this.gAY;
            this.gAR = (int) (((this.gBi * 1.0f) * this.gAQ) / this.gAZ);
        }
        if (!TextUtils.isEmpty(this.frS)) {
            if (this.gBs) {
                this.gBG = new StaticLayout(this.frS, this.gAV, a.cV(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gBG = new StaticLayout(this.frS, this.gAV, this.gAY - (this.gBH * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gBj) {
            int i = a.cV(getContext()).y;
            if (this.gBk == 0) {
                this.bfh = (i - this.gAZ) / 2;
            } else {
                this.bfh = ((i - this.gAZ) / 2) + (this.gBk / 2);
            }
        }
        bsJ();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gBl;
    }

    public int getMaskColor() {
        return this.aCm;
    }

    public void setMaskColor(int i) {
        this.aCm = i;
    }

    public int getCornerLength() {
        return this.gAW;
    }

    public void setCornerLength(int i) {
        this.gAW = i;
    }

    public int getCornerSize() {
        return this.gAX;
    }

    public void setCornerSize(int i) {
        this.gAX = i;
    }

    public int getRectWidth() {
        return this.gAY;
    }

    public void setRectWidth(int i) {
        this.gAY = i;
    }

    public int getRectHeight() {
        return this.gAZ;
    }

    public void setRectHeight(int i) {
        this.gAZ = i;
    }

    public int getBarcodeRectHeight() {
        return this.gBa;
    }

    public void setBarcodeRectHeight(int i) {
        this.gBa = i;
    }

    public int getTopOffset() {
        return this.bfh;
    }

    public void setTopOffset(int i) {
        this.bfh = i;
    }

    public int getScanLineSize() {
        return this.gBb;
    }

    public void setScanLineSize(int i) {
        this.gBb = i;
    }

    public int getScanLineColor() {
        return this.gBc;
    }

    public void setScanLineColor(int i) {
        this.gBc = i;
    }

    public int getScanLineMargin() {
        return this.gBd;
    }

    public void setScanLineMargin(int i) {
        this.gBd = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gBe = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gBf;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gBf = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gBg;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gBg = bitmap;
    }

    public int getBorderSize() {
        return this.gBh;
    }

    public void setBorderSize(int i) {
        this.gBh = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gBi;
    }

    public void setAnimTime(int i) {
        this.gBi = i;
    }

    public void setCenterVertical(boolean z) {
        this.gBj = z;
    }

    public int getToolbarHeight() {
        return this.gBk;
    }

    public void setToolbarHeight(int i) {
        this.gBk = i;
    }

    public String getQRCodeTipText() {
        return this.gBm;
    }

    public void setQRCodeTipText(String str) {
        this.gBm = str;
    }

    public String getBarCodeTipText() {
        return this.gBn;
    }

    public void setBarCodeTipText(String str) {
        this.gBn = str;
    }

    public String getTipText() {
        return this.frS;
    }

    public void setTipText(String str) {
        this.frS = str;
    }

    public int getTipTextColor() {
        return this.gBp;
    }

    public void setTipTextColor(int i) {
        this.gBp = i;
    }

    public int getTipTextSize() {
        return this.gBo;
    }

    public void setTipTextSize(int i) {
        this.gBo = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gBq = z;
    }

    public int getTipTextMargin() {
        return this.gBr;
    }

    public void setTipTextMargin(int i) {
        this.gBr = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gBs = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gBu = z;
    }

    public int getTipBackgroundColor() {
        return this.gBt;
    }

    public void setTipBackgroundColor(int i) {
        this.gBt = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gBv = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gBw = z;
    }

    public float getHalfCornerSize() {
        return this.gBF;
    }

    public void setHalfCornerSize(float f) {
        this.gBF = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gBG;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gBG = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gBH;
    }

    public void setTipBackgroundRadius(int i) {
        this.gBH = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gBI = z;
    }
}
