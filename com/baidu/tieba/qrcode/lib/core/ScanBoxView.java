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
    private int aHd;
    private int bkj;
    private String fDJ;
    private Bitmap gMY;
    private Bitmap gMZ;
    private int gNA;
    private int gNB;
    private boolean gNC;
    private int gND;
    private boolean gNE;
    private int gNF;
    private boolean gNG;
    private boolean gNH;
    private boolean gNI;
    private Drawable gNJ;
    private Bitmap gNK;
    private float gNL;
    private float gNM;
    private Bitmap gNN;
    private Bitmap gNO;
    private Bitmap gNP;
    private Bitmap gNQ;
    private float gNR;
    private StaticLayout gNS;
    private int gNT;
    private boolean gNU;
    private ColorMatrixColorFilter gNV;
    private Bitmap gNa;
    private Bitmap gNb;
    private int gNc;
    private int gNd;
    private Rect gNe;
    private float gNf;
    private float gNg;
    private TextPaint gNh;
    private int gNi;
    private int gNj;
    private int gNk;
    private int gNl;
    private int gNm;
    private int gNn;
    private int gNo;
    private int gNp;
    private boolean gNq;
    private Drawable gNr;
    private Bitmap gNs;
    private int gNt;
    private int gNu;
    private boolean gNv;
    private int gNw;
    private boolean gNx;
    private String gNy;
    private String gNz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aHd = Color.parseColor("#33FFFFFF");
        this.gNi = a.f(context, 20.0f);
        this.gNj = a.f(context, 3.0f);
        this.gNn = a.f(context, 1.0f);
        this.gNo = -1;
        this.bkj = a.f(context, 90.0f);
        this.gNk = a.f(context, 200.0f);
        this.gNm = a.f(context, 140.0f);
        this.gNp = 0;
        this.gNq = false;
        this.gNr = null;
        this.gNs = null;
        this.gNt = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gNu = 1000;
        this.gNv = false;
        this.gNw = 0;
        this.gNx = false;
        this.gNc = a.f(context, 2.0f);
        this.fDJ = null;
        this.gNA = a.e(context, 14.0f);
        this.gNB = -1;
        this.gNC = false;
        this.gND = a.f(context, 20.0f);
        this.gNE = false;
        this.gNF = Color.parseColor("#22000000");
        this.gNG = false;
        this.gNH = false;
        this.gNI = false;
        this.gNh = new TextPaint();
        this.gNh.setAntiAlias(true);
        this.gNT = a.f(context, 4.0f);
        this.gNU = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gNV = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bvq();
        bvp();
    }

    private void bvp() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gNi;
        options.outHeight = this.gNi;
        this.gMY = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gMZ = Bitmap.createBitmap(this.gMY, 0, 0, this.gMY.getWidth(), this.gMY.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gNa = Bitmap.createBitmap(this.gMY, 0, 0, this.gMY.getWidth(), this.gMY.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gNb = Bitmap.createBitmap(this.gMY, 0, 0, this.gMY.getWidth(), this.gMY.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bkj = typedArray.getDimensionPixelSize(i, this.bkj);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gNj = typedArray.getDimensionPixelSize(i, this.gNj);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gNi = typedArray.getDimensionPixelSize(i, this.gNi);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gNn = typedArray.getDimensionPixelSize(i, this.gNn);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gNk = typedArray.getDimensionPixelSize(i, this.gNk);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aHd = typedArray.getColor(i, this.aHd);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gNo = typedArray.getColor(i, this.gNo);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gNp = typedArray.getDimensionPixelSize(i, this.gNp);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gNq = typedArray.getBoolean(i, this.gNq);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gNr = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gNt = typedArray.getDimensionPixelSize(i, this.gNt);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gNu = typedArray.getInteger(i, this.gNu);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gNv = typedArray.getBoolean(i, this.gNv);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gNw = typedArray.getDimensionPixelSize(i, this.gNw);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gNm = typedArray.getDimensionPixelSize(i, this.gNm);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gNx = typedArray.getBoolean(i, this.gNx);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gNz = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gNy = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gNA = typedArray.getDimensionPixelSize(i, this.gNA);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gNB = typedArray.getColor(i, this.gNB);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gNC = typedArray.getBoolean(i, this.gNC);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gND = typedArray.getDimensionPixelSize(i, this.gND);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gNE = typedArray.getBoolean(i, this.gNE);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gNG = typedArray.getBoolean(i, this.gNG);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gNF = typedArray.getColor(i, this.gNF);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gNH = typedArray.getBoolean(i, this.gNH);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gNI = typedArray.getBoolean(i, this.gNI);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gNJ = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gNU = typedArray.getBoolean(i, this.gNU);
        }
    }

    private void bvq() {
        if (this.gNJ != null) {
            this.gNP = ((BitmapDrawable) this.gNJ).getBitmap();
        }
        if (this.gNP == null) {
            this.gNP = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gNP = a.c(this.gNP, this.gNo);
        }
        this.gNQ = a.adjustPhotoRotation(this.gNP, 90);
        this.gNQ = a.adjustPhotoRotation(this.gNQ, 90);
        this.gNQ = a.adjustPhotoRotation(this.gNQ, 90);
        if (this.gNr != null) {
            this.gNN = ((BitmapDrawable) this.gNr).getBitmap();
        }
        if (this.gNN == null) {
            this.gNN = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gNN = a.c(this.gNN, this.gNo);
        }
        this.gNO = a.adjustPhotoRotation(this.gNN, 90);
        this.gNR = (1.0f * this.gNj) / 2.0f;
        this.gNh.setTextSize(this.gNA);
        this.gNh.setColor(this.gNB);
        setIsBarcode(this.gNx);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gNe != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            bvr();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aHd != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aHd);
            canvas.drawRect(0.0f, 0.0f, width, this.gNe.top, this.mPaint);
            canvas.drawRect(0.0f, this.gNe.top, this.gNe.left, this.gNe.bottom + 1, this.mPaint);
            canvas.drawRect(this.gNe.right + 1, this.gNe.top, width, this.gNe.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gNe.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gNt > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gNt);
            canvas.drawRect(this.gNe, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gMY, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gMZ, getMainFrameRight() - this.gMY.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gNa, getMainFrameLeft(), getMainFrameBottom() - this.gMY.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gNb, getMainFrameRight() - this.gMY.getWidth(), getMainFrameBottom() - this.gMY.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gNe.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gNe.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gNe.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gNe.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gNt / 2;
    }

    private void E(Canvas canvas) {
        if (this.gNx) {
            if (this.gNK != null) {
                RectF rectF = new RectF(this.gNe.left + this.gNR + 0.5f, this.gNe.top + this.gNR + this.gNp, this.gNM, (this.gNe.bottom - this.gNR) - this.gNp);
                Rect rect = new Rect((int) (this.gNK.getWidth() - rectF.width()), 0, this.gNK.getWidth(), this.gNK.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gNK, rect, rectF, this.mPaint);
            } else if (this.gNs != null) {
                canvas.drawBitmap(this.gNs, (Rect) null, new RectF(this.gNg, this.gNe.top + this.gNR + this.gNp, this.gNg + this.gNs.getWidth(), (this.gNe.bottom - this.gNR) - this.gNp), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gNo);
                canvas.drawRect(this.gNg, this.gNp + this.gNe.top + this.gNR, this.gNn + this.gNg, (this.gNe.bottom - this.gNR) - this.gNp, this.mPaint);
            }
        } else if (this.gNK != null) {
            RectF rectF2 = new RectF(this.gNe.left + this.gNR + this.gNp, this.gNe.top + this.gNR + 0.5f, (this.gNe.right - this.gNR) - this.gNp, this.gNL);
            Rect rect2 = new Rect(0, (int) (this.gNK.getHeight() - rectF2.height()), this.gNK.getWidth(), this.gNK.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gNV);
            canvas.drawBitmap(this.gNK, rect2, rectF2, this.mPaint);
        } else if (this.gNs != null) {
            canvas.drawBitmap(this.gNs, (Rect) null, new RectF(this.gNe.left + this.gNR + this.gNp, this.gNf, (this.gNe.right - this.gNR) - this.gNp, this.gNf + this.gNs.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gNo);
            canvas.drawRect(this.gNp + this.gNe.left + this.gNR, this.gNf, (this.gNe.right - this.gNR) - this.gNp, this.gNn + this.gNf, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fDJ) && this.gNS != null) {
            if (this.gNC) {
                if (this.gNG) {
                    this.mPaint.setColor(this.gNF);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gNE) {
                        Rect rect = new Rect();
                        this.gNh.getTextBounds(this.fDJ, 0, this.fDJ.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gNT;
                        canvas.drawRoundRect(new RectF(width, (this.gNe.bottom + this.gND) - this.gNT, rect.width() + width + (this.gNT * 2), this.gNe.bottom + this.gND + this.gNS.getHeight() + this.gNT), this.gNT, this.gNT, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gNe.left, (this.gNe.bottom + this.gND) - this.gNT, this.gNe.right, this.gNe.bottom + this.gND + this.gNS.getHeight() + this.gNT), this.gNT, this.gNT, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gNE) {
                    canvas.translate(0.0f, this.gNe.bottom + this.gND);
                } else {
                    canvas.translate(this.gNe.left + this.gNT, this.gNe.bottom + this.gND);
                }
                this.gNS.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gNG) {
                this.mPaint.setColor(this.gNF);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gNE) {
                    Rect rect2 = new Rect();
                    this.gNh.getTextBounds(this.fDJ, 0, this.fDJ.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gNT;
                    canvas.drawRoundRect(new RectF(width2, ((this.gNe.top - this.gND) - this.gNS.getHeight()) - this.gNT, rect2.width() + width2 + (this.gNT * 2), (this.gNe.top - this.gND) + this.gNT), this.gNT, this.gNT, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gNe.left, ((this.gNe.top - this.gND) - this.gNS.getHeight()) - this.gNT, this.gNe.right, (this.gNe.top - this.gND) + this.gNT), this.gNT, this.gNT, this.mPaint);
                }
            }
            canvas.save();
            if (this.gNE) {
                canvas.translate(0.0f, (this.gNe.top - this.gND) - this.gNS.getHeight());
            } else {
                canvas.translate(this.gNe.left + this.gNT, (this.gNe.top - this.gND) - this.gNS.getHeight());
            }
            this.gNS.draw(canvas);
            canvas.restore();
        }
    }

    private void bvr() {
        if (this.gNx) {
            if (this.gNK == null) {
                this.gNg += this.gNc;
                int i = this.gNn;
                if (this.gNs != null) {
                    i = this.gNs.getWidth();
                }
                if (this.gNH) {
                    if (i + this.gNg > this.gNe.right - this.gNR || this.gNg < this.gNe.left + this.gNR) {
                        this.gNc = -this.gNc;
                    }
                } else {
                    if (i + this.gNg > this.gNe.right - this.gNR) {
                        this.gNg = this.gNe.left + this.gNR + 0.5f;
                    }
                }
            } else {
                this.gNM += this.gNc;
                if (this.gNM > this.gNe.right - this.gNR) {
                    this.gNM = this.gNe.left + this.gNR + 0.5f;
                }
            }
        } else if (this.gNK == null) {
            this.gNf += this.gNc;
            int i2 = this.gNn;
            if (this.gNs != null) {
                i2 = this.gNs.getHeight();
            }
            if (this.gNH) {
                if (i2 + this.gNf > this.gNe.bottom - this.gNR || this.gNf < this.gNe.top + this.gNR) {
                    this.gNc = -this.gNc;
                }
            } else {
                if (i2 + this.gNf > this.gNe.bottom - this.gNR) {
                    this.gNf = this.gNe.top + this.gNR + 0.5f;
                }
            }
        } else {
            this.gNL += this.gNc;
            if (this.gNL > this.gNe.bottom - this.gNR) {
                this.gNL = this.gNe.top + this.gNR + 0.5f;
            }
        }
        postInvalidateDelayed(this.gNd, this.gNe.left, this.gNe.top, this.gNe.right, this.gNe.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bvs();
    }

    private void bvs() {
        int i = this.bkj + this.gNw;
        int width = (getWidth() - this.gNk) / 2;
        this.gNe = new Rect(width, i, this.gNk + width, this.gNl + i);
        if (this.gNx) {
            float f = this.gNe.left + this.gNR + 0.5f;
            this.gNg = f;
            this.gNM = f;
            return;
        }
        float f2 = this.gNe.top + this.gNR + 0.5f;
        this.gNf = f2;
        this.gNL = f2;
    }

    public Rect tY(int i) {
        if (this.gNU) {
            Rect rect = new Rect(this.gNe);
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
        this.gNx = z;
        if (this.gNJ != null || this.gNI) {
            if (this.gNx) {
                this.gNK = this.gNQ;
            } else {
                this.gNK = this.gNP;
            }
        } else if (this.gNr != null || this.gNq) {
            if (this.gNx) {
                this.gNs = this.gNO;
            } else {
                this.gNs = this.gNN;
            }
        }
        if (this.gNx) {
            this.fDJ = this.gNz;
            this.gNl = this.gNm;
            this.gNd = (int) (((this.gNu * 1.0f) * this.gNc) / this.gNk);
        } else {
            this.fDJ = this.gNy;
            this.gNl = this.gNk;
            this.gNd = (int) (((this.gNu * 1.0f) * this.gNc) / this.gNl);
        }
        if (!TextUtils.isEmpty(this.fDJ)) {
            if (this.gNE) {
                this.gNS = new StaticLayout(this.fDJ, this.gNh, a.cU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gNS = new StaticLayout(this.fDJ, this.gNh, this.gNk - (this.gNT * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gNv) {
            int i = a.cU(getContext()).y;
            if (this.gNw == 0) {
                this.bkj = (i - this.gNl) / 2;
            } else {
                this.bkj = ((i - this.gNl) / 2) + (this.gNw / 2);
            }
        }
        bvs();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gNx;
    }

    public int getMaskColor() {
        return this.aHd;
    }

    public void setMaskColor(int i) {
        this.aHd = i;
    }

    public int getCornerLength() {
        return this.gNi;
    }

    public void setCornerLength(int i) {
        this.gNi = i;
    }

    public int getCornerSize() {
        return this.gNj;
    }

    public void setCornerSize(int i) {
        this.gNj = i;
    }

    public int getRectWidth() {
        return this.gNk;
    }

    public void setRectWidth(int i) {
        this.gNk = i;
    }

    public int getRectHeight() {
        return this.gNl;
    }

    public void setRectHeight(int i) {
        this.gNl = i;
    }

    public int getBarcodeRectHeight() {
        return this.gNm;
    }

    public void setBarcodeRectHeight(int i) {
        this.gNm = i;
    }

    public int getTopOffset() {
        return this.bkj;
    }

    public void setTopOffset(int i) {
        this.bkj = i;
    }

    public int getScanLineSize() {
        return this.gNn;
    }

    public void setScanLineSize(int i) {
        this.gNn = i;
    }

    public int getScanLineColor() {
        return this.gNo;
    }

    public void setScanLineColor(int i) {
        this.gNo = i;
    }

    public int getScanLineMargin() {
        return this.gNp;
    }

    public void setScanLineMargin(int i) {
        this.gNp = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gNq = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gNr;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gNr = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gNs;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gNs = bitmap;
    }

    public int getBorderSize() {
        return this.gNt;
    }

    public void setBorderSize(int i) {
        this.gNt = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gNu;
    }

    public void setAnimTime(int i) {
        this.gNu = i;
    }

    public void setCenterVertical(boolean z) {
        this.gNv = z;
    }

    public int getToolbarHeight() {
        return this.gNw;
    }

    public void setToolbarHeight(int i) {
        this.gNw = i;
    }

    public String getQRCodeTipText() {
        return this.gNy;
    }

    public void setQRCodeTipText(String str) {
        this.gNy = str;
    }

    public String getBarCodeTipText() {
        return this.gNz;
    }

    public void setBarCodeTipText(String str) {
        this.gNz = str;
    }

    public String getTipText() {
        return this.fDJ;
    }

    public void setTipText(String str) {
        this.fDJ = str;
    }

    public int getTipTextColor() {
        return this.gNB;
    }

    public void setTipTextColor(int i) {
        this.gNB = i;
    }

    public int getTipTextSize() {
        return this.gNA;
    }

    public void setTipTextSize(int i) {
        this.gNA = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gNC = z;
    }

    public int getTipTextMargin() {
        return this.gND;
    }

    public void setTipTextMargin(int i) {
        this.gND = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gNE = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gNG = z;
    }

    public int getTipBackgroundColor() {
        return this.gNF;
    }

    public void setTipBackgroundColor(int i) {
        this.gNF = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gNH = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gNI = z;
    }

    public float getHalfCornerSize() {
        return this.gNR;
    }

    public void setHalfCornerSize(float f) {
        this.gNR = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gNS;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gNS = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gNT;
    }

    public void setTipBackgroundRadius(int i) {
        this.gNT = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gNU = z;
    }
}
