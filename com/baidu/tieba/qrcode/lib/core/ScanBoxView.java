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
    private int aHe;
    private int bkk;
    private String fDK;
    private Bitmap gMZ;
    private String gNA;
    private int gNB;
    private int gNC;
    private boolean gND;
    private int gNE;
    private boolean gNF;
    private int gNG;
    private boolean gNH;
    private boolean gNI;
    private boolean gNJ;
    private Drawable gNK;
    private Bitmap gNL;
    private float gNM;
    private float gNN;
    private Bitmap gNO;
    private Bitmap gNP;
    private Bitmap gNQ;
    private Bitmap gNR;
    private float gNS;
    private StaticLayout gNT;
    private int gNU;
    private boolean gNV;
    private ColorMatrixColorFilter gNW;
    private Bitmap gNa;
    private Bitmap gNb;
    private Bitmap gNc;
    private int gNd;
    private int gNe;
    private Rect gNf;
    private float gNg;
    private float gNh;
    private TextPaint gNi;
    private int gNj;
    private int gNk;
    private int gNl;
    private int gNm;
    private int gNn;
    private int gNo;
    private int gNp;
    private int gNq;
    private boolean gNr;
    private Drawable gNs;
    private Bitmap gNt;
    private int gNu;
    private int gNv;
    private boolean gNw;
    private int gNx;
    private boolean gNy;
    private String gNz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aHe = Color.parseColor("#33FFFFFF");
        this.gNj = a.f(context, 20.0f);
        this.gNk = a.f(context, 3.0f);
        this.gNo = a.f(context, 1.0f);
        this.gNp = -1;
        this.bkk = a.f(context, 90.0f);
        this.gNl = a.f(context, 200.0f);
        this.gNn = a.f(context, 140.0f);
        this.gNq = 0;
        this.gNr = false;
        this.gNs = null;
        this.gNt = null;
        this.gNu = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gNv = 1000;
        this.gNw = false;
        this.gNx = 0;
        this.gNy = false;
        this.gNd = a.f(context, 2.0f);
        this.fDK = null;
        this.gNB = a.e(context, 14.0f);
        this.gNC = -1;
        this.gND = false;
        this.gNE = a.f(context, 20.0f);
        this.gNF = false;
        this.gNG = Color.parseColor("#22000000");
        this.gNH = false;
        this.gNI = false;
        this.gNJ = false;
        this.gNi = new TextPaint();
        this.gNi.setAntiAlias(true);
        this.gNU = a.f(context, 4.0f);
        this.gNV = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gNW = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.gNj;
        options.outHeight = this.gNj;
        this.gMZ = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gNa = Bitmap.createBitmap(this.gMZ, 0, 0, this.gMZ.getWidth(), this.gMZ.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gNb = Bitmap.createBitmap(this.gMZ, 0, 0, this.gMZ.getWidth(), this.gMZ.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gNc = Bitmap.createBitmap(this.gMZ, 0, 0, this.gMZ.getWidth(), this.gMZ.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bkk = typedArray.getDimensionPixelSize(i, this.bkk);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gNk = typedArray.getDimensionPixelSize(i, this.gNk);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gNj = typedArray.getDimensionPixelSize(i, this.gNj);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gNo = typedArray.getDimensionPixelSize(i, this.gNo);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gNl = typedArray.getDimensionPixelSize(i, this.gNl);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aHe = typedArray.getColor(i, this.aHe);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gNp = typedArray.getColor(i, this.gNp);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gNq = typedArray.getDimensionPixelSize(i, this.gNq);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gNr = typedArray.getBoolean(i, this.gNr);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gNs = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gNu = typedArray.getDimensionPixelSize(i, this.gNu);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gNv = typedArray.getInteger(i, this.gNv);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gNw = typedArray.getBoolean(i, this.gNw);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gNx = typedArray.getDimensionPixelSize(i, this.gNx);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gNn = typedArray.getDimensionPixelSize(i, this.gNn);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gNy = typedArray.getBoolean(i, this.gNy);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gNA = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gNz = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gNB = typedArray.getDimensionPixelSize(i, this.gNB);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gNC = typedArray.getColor(i, this.gNC);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gND = typedArray.getBoolean(i, this.gND);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gNE = typedArray.getDimensionPixelSize(i, this.gNE);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gNF = typedArray.getBoolean(i, this.gNF);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gNH = typedArray.getBoolean(i, this.gNH);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gNG = typedArray.getColor(i, this.gNG);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gNI = typedArray.getBoolean(i, this.gNI);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gNJ = typedArray.getBoolean(i, this.gNJ);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gNK = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gNV = typedArray.getBoolean(i, this.gNV);
        }
    }

    private void bvq() {
        if (this.gNK != null) {
            this.gNQ = ((BitmapDrawable) this.gNK).getBitmap();
        }
        if (this.gNQ == null) {
            this.gNQ = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gNQ = a.c(this.gNQ, this.gNp);
        }
        this.gNR = a.adjustPhotoRotation(this.gNQ, 90);
        this.gNR = a.adjustPhotoRotation(this.gNR, 90);
        this.gNR = a.adjustPhotoRotation(this.gNR, 90);
        if (this.gNs != null) {
            this.gNO = ((BitmapDrawable) this.gNs).getBitmap();
        }
        if (this.gNO == null) {
            this.gNO = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gNO = a.c(this.gNO, this.gNp);
        }
        this.gNP = a.adjustPhotoRotation(this.gNO, 90);
        this.gNS = (1.0f * this.gNk) / 2.0f;
        this.gNi.setTextSize(this.gNB);
        this.gNi.setColor(this.gNC);
        setIsBarcode(this.gNy);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gNf != null) {
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
        if (this.aHe != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aHe);
            canvas.drawRect(0.0f, 0.0f, width, this.gNf.top, this.mPaint);
            canvas.drawRect(0.0f, this.gNf.top, this.gNf.left, this.gNf.bottom + 1, this.mPaint);
            canvas.drawRect(this.gNf.right + 1, this.gNf.top, width, this.gNf.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gNf.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gNu > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gNu);
            canvas.drawRect(this.gNf, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gMZ, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gNa, getMainFrameRight() - this.gMZ.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gNb, getMainFrameLeft(), getMainFrameBottom() - this.gMZ.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gNc, getMainFrameRight() - this.gMZ.getWidth(), getMainFrameBottom() - this.gMZ.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gNf.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gNf.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gNf.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gNf.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gNu / 2;
    }

    private void E(Canvas canvas) {
        if (this.gNy) {
            if (this.gNL != null) {
                RectF rectF = new RectF(this.gNf.left + this.gNS + 0.5f, this.gNf.top + this.gNS + this.gNq, this.gNN, (this.gNf.bottom - this.gNS) - this.gNq);
                Rect rect = new Rect((int) (this.gNL.getWidth() - rectF.width()), 0, this.gNL.getWidth(), this.gNL.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gNL, rect, rectF, this.mPaint);
            } else if (this.gNt != null) {
                canvas.drawBitmap(this.gNt, (Rect) null, new RectF(this.gNh, this.gNf.top + this.gNS + this.gNq, this.gNh + this.gNt.getWidth(), (this.gNf.bottom - this.gNS) - this.gNq), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gNp);
                canvas.drawRect(this.gNh, this.gNq + this.gNf.top + this.gNS, this.gNo + this.gNh, (this.gNf.bottom - this.gNS) - this.gNq, this.mPaint);
            }
        } else if (this.gNL != null) {
            RectF rectF2 = new RectF(this.gNf.left + this.gNS + this.gNq, this.gNf.top + this.gNS + 0.5f, (this.gNf.right - this.gNS) - this.gNq, this.gNM);
            Rect rect2 = new Rect(0, (int) (this.gNL.getHeight() - rectF2.height()), this.gNL.getWidth(), this.gNL.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gNW);
            canvas.drawBitmap(this.gNL, rect2, rectF2, this.mPaint);
        } else if (this.gNt != null) {
            canvas.drawBitmap(this.gNt, (Rect) null, new RectF(this.gNf.left + this.gNS + this.gNq, this.gNg, (this.gNf.right - this.gNS) - this.gNq, this.gNg + this.gNt.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gNp);
            canvas.drawRect(this.gNq + this.gNf.left + this.gNS, this.gNg, (this.gNf.right - this.gNS) - this.gNq, this.gNo + this.gNg, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fDK) && this.gNT != null) {
            if (this.gND) {
                if (this.gNH) {
                    this.mPaint.setColor(this.gNG);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gNF) {
                        Rect rect = new Rect();
                        this.gNi.getTextBounds(this.fDK, 0, this.fDK.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gNU;
                        canvas.drawRoundRect(new RectF(width, (this.gNf.bottom + this.gNE) - this.gNU, rect.width() + width + (this.gNU * 2), this.gNf.bottom + this.gNE + this.gNT.getHeight() + this.gNU), this.gNU, this.gNU, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gNf.left, (this.gNf.bottom + this.gNE) - this.gNU, this.gNf.right, this.gNf.bottom + this.gNE + this.gNT.getHeight() + this.gNU), this.gNU, this.gNU, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gNF) {
                    canvas.translate(0.0f, this.gNf.bottom + this.gNE);
                } else {
                    canvas.translate(this.gNf.left + this.gNU, this.gNf.bottom + this.gNE);
                }
                this.gNT.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gNH) {
                this.mPaint.setColor(this.gNG);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gNF) {
                    Rect rect2 = new Rect();
                    this.gNi.getTextBounds(this.fDK, 0, this.fDK.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gNU;
                    canvas.drawRoundRect(new RectF(width2, ((this.gNf.top - this.gNE) - this.gNT.getHeight()) - this.gNU, rect2.width() + width2 + (this.gNU * 2), (this.gNf.top - this.gNE) + this.gNU), this.gNU, this.gNU, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gNf.left, ((this.gNf.top - this.gNE) - this.gNT.getHeight()) - this.gNU, this.gNf.right, (this.gNf.top - this.gNE) + this.gNU), this.gNU, this.gNU, this.mPaint);
                }
            }
            canvas.save();
            if (this.gNF) {
                canvas.translate(0.0f, (this.gNf.top - this.gNE) - this.gNT.getHeight());
            } else {
                canvas.translate(this.gNf.left + this.gNU, (this.gNf.top - this.gNE) - this.gNT.getHeight());
            }
            this.gNT.draw(canvas);
            canvas.restore();
        }
    }

    private void bvr() {
        if (this.gNy) {
            if (this.gNL == null) {
                this.gNh += this.gNd;
                int i = this.gNo;
                if (this.gNt != null) {
                    i = this.gNt.getWidth();
                }
                if (this.gNI) {
                    if (i + this.gNh > this.gNf.right - this.gNS || this.gNh < this.gNf.left + this.gNS) {
                        this.gNd = -this.gNd;
                    }
                } else {
                    if (i + this.gNh > this.gNf.right - this.gNS) {
                        this.gNh = this.gNf.left + this.gNS + 0.5f;
                    }
                }
            } else {
                this.gNN += this.gNd;
                if (this.gNN > this.gNf.right - this.gNS) {
                    this.gNN = this.gNf.left + this.gNS + 0.5f;
                }
            }
        } else if (this.gNL == null) {
            this.gNg += this.gNd;
            int i2 = this.gNo;
            if (this.gNt != null) {
                i2 = this.gNt.getHeight();
            }
            if (this.gNI) {
                if (i2 + this.gNg > this.gNf.bottom - this.gNS || this.gNg < this.gNf.top + this.gNS) {
                    this.gNd = -this.gNd;
                }
            } else {
                if (i2 + this.gNg > this.gNf.bottom - this.gNS) {
                    this.gNg = this.gNf.top + this.gNS + 0.5f;
                }
            }
        } else {
            this.gNM += this.gNd;
            if (this.gNM > this.gNf.bottom - this.gNS) {
                this.gNM = this.gNf.top + this.gNS + 0.5f;
            }
        }
        postInvalidateDelayed(this.gNe, this.gNf.left, this.gNf.top, this.gNf.right, this.gNf.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bvs();
    }

    private void bvs() {
        int i = this.bkk + this.gNx;
        int width = (getWidth() - this.gNl) / 2;
        this.gNf = new Rect(width, i, this.gNl + width, this.gNm + i);
        if (this.gNy) {
            float f = this.gNf.left + this.gNS + 0.5f;
            this.gNh = f;
            this.gNN = f;
            return;
        }
        float f2 = this.gNf.top + this.gNS + 0.5f;
        this.gNg = f2;
        this.gNM = f2;
    }

    public Rect tY(int i) {
        if (this.gNV) {
            Rect rect = new Rect(this.gNf);
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
        this.gNy = z;
        if (this.gNK != null || this.gNJ) {
            if (this.gNy) {
                this.gNL = this.gNR;
            } else {
                this.gNL = this.gNQ;
            }
        } else if (this.gNs != null || this.gNr) {
            if (this.gNy) {
                this.gNt = this.gNP;
            } else {
                this.gNt = this.gNO;
            }
        }
        if (this.gNy) {
            this.fDK = this.gNA;
            this.gNm = this.gNn;
            this.gNe = (int) (((this.gNv * 1.0f) * this.gNd) / this.gNl);
        } else {
            this.fDK = this.gNz;
            this.gNm = this.gNl;
            this.gNe = (int) (((this.gNv * 1.0f) * this.gNd) / this.gNm);
        }
        if (!TextUtils.isEmpty(this.fDK)) {
            if (this.gNF) {
                this.gNT = new StaticLayout(this.fDK, this.gNi, a.cU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gNT = new StaticLayout(this.fDK, this.gNi, this.gNl - (this.gNU * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gNw) {
            int i = a.cU(getContext()).y;
            if (this.gNx == 0) {
                this.bkk = (i - this.gNm) / 2;
            } else {
                this.bkk = ((i - this.gNm) / 2) + (this.gNx / 2);
            }
        }
        bvs();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gNy;
    }

    public int getMaskColor() {
        return this.aHe;
    }

    public void setMaskColor(int i) {
        this.aHe = i;
    }

    public int getCornerLength() {
        return this.gNj;
    }

    public void setCornerLength(int i) {
        this.gNj = i;
    }

    public int getCornerSize() {
        return this.gNk;
    }

    public void setCornerSize(int i) {
        this.gNk = i;
    }

    public int getRectWidth() {
        return this.gNl;
    }

    public void setRectWidth(int i) {
        this.gNl = i;
    }

    public int getRectHeight() {
        return this.gNm;
    }

    public void setRectHeight(int i) {
        this.gNm = i;
    }

    public int getBarcodeRectHeight() {
        return this.gNn;
    }

    public void setBarcodeRectHeight(int i) {
        this.gNn = i;
    }

    public int getTopOffset() {
        return this.bkk;
    }

    public void setTopOffset(int i) {
        this.bkk = i;
    }

    public int getScanLineSize() {
        return this.gNo;
    }

    public void setScanLineSize(int i) {
        this.gNo = i;
    }

    public int getScanLineColor() {
        return this.gNp;
    }

    public void setScanLineColor(int i) {
        this.gNp = i;
    }

    public int getScanLineMargin() {
        return this.gNq;
    }

    public void setScanLineMargin(int i) {
        this.gNq = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gNr = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gNs;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gNs = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gNt;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gNt = bitmap;
    }

    public int getBorderSize() {
        return this.gNu;
    }

    public void setBorderSize(int i) {
        this.gNu = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gNv;
    }

    public void setAnimTime(int i) {
        this.gNv = i;
    }

    public void setCenterVertical(boolean z) {
        this.gNw = z;
    }

    public int getToolbarHeight() {
        return this.gNx;
    }

    public void setToolbarHeight(int i) {
        this.gNx = i;
    }

    public String getQRCodeTipText() {
        return this.gNz;
    }

    public void setQRCodeTipText(String str) {
        this.gNz = str;
    }

    public String getBarCodeTipText() {
        return this.gNA;
    }

    public void setBarCodeTipText(String str) {
        this.gNA = str;
    }

    public String getTipText() {
        return this.fDK;
    }

    public void setTipText(String str) {
        this.fDK = str;
    }

    public int getTipTextColor() {
        return this.gNC;
    }

    public void setTipTextColor(int i) {
        this.gNC = i;
    }

    public int getTipTextSize() {
        return this.gNB;
    }

    public void setTipTextSize(int i) {
        this.gNB = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gND = z;
    }

    public int getTipTextMargin() {
        return this.gNE;
    }

    public void setTipTextMargin(int i) {
        this.gNE = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gNF = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gNH = z;
    }

    public int getTipBackgroundColor() {
        return this.gNG;
    }

    public void setTipBackgroundColor(int i) {
        this.gNG = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gNI = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gNJ = z;
    }

    public float getHalfCornerSize() {
        return this.gNS;
    }

    public void setHalfCornerSize(float f) {
        this.gNS = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gNT;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gNT = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gNU;
    }

    public void setTipBackgroundRadius(int i) {
        this.gNU = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gNV = z;
    }
}
