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
    private int aDa;
    private int bfT;
    private String fth;
    private int gCA;
    private int gCB;
    private int gCC;
    private int gCD;
    private int gCE;
    private boolean gCF;
    private Drawable gCG;
    private Bitmap gCH;
    private int gCI;
    private int gCJ;
    private boolean gCK;
    private int gCL;
    private boolean gCM;
    private String gCN;
    private String gCO;
    private int gCP;
    private int gCQ;
    private boolean gCR;
    private int gCS;
    private boolean gCT;
    private int gCU;
    private boolean gCV;
    private boolean gCW;
    private boolean gCX;
    private Drawable gCY;
    private Bitmap gCZ;
    private Bitmap gCn;
    private Bitmap gCo;
    private Bitmap gCp;
    private Bitmap gCq;
    private int gCr;
    private int gCs;
    private Rect gCt;
    private float gCu;
    private float gCv;
    private TextPaint gCw;
    private int gCx;
    private int gCy;
    private int gCz;
    private float gDa;
    private float gDb;
    private Bitmap gDc;
    private Bitmap gDd;
    private Bitmap gDe;
    private Bitmap gDf;
    private float gDg;
    private StaticLayout gDh;
    private int gDi;
    private boolean gDj;
    private ColorMatrixColorFilter gDk;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aDa = Color.parseColor("#33FFFFFF");
        this.gCx = a.f(context, 20.0f);
        this.gCy = a.f(context, 3.0f);
        this.gCC = a.f(context, 1.0f);
        this.gCD = -1;
        this.bfT = a.f(context, 90.0f);
        this.gCz = a.f(context, 200.0f);
        this.gCB = a.f(context, 140.0f);
        this.gCE = 0;
        this.gCF = false;
        this.gCG = null;
        this.gCH = null;
        this.gCI = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gCJ = 1000;
        this.gCK = false;
        this.gCL = 0;
        this.gCM = false;
        this.gCr = a.f(context, 2.0f);
        this.fth = null;
        this.gCP = a.e(context, 14.0f);
        this.gCQ = -1;
        this.gCR = false;
        this.gCS = a.f(context, 20.0f);
        this.gCT = false;
        this.gCU = Color.parseColor("#22000000");
        this.gCV = false;
        this.gCW = false;
        this.gCX = false;
        this.gCw = new TextPaint();
        this.gCw.setAntiAlias(true);
        this.gDi = a.f(context, 4.0f);
        this.gDj = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gDk = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bsd();
        bsc();
    }

    private void bsc() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gCx;
        options.outHeight = this.gCx;
        this.gCn = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gCo = Bitmap.createBitmap(this.gCn, 0, 0, this.gCn.getWidth(), this.gCn.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gCp = Bitmap.createBitmap(this.gCn, 0, 0, this.gCn.getWidth(), this.gCn.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gCq = Bitmap.createBitmap(this.gCn, 0, 0, this.gCn.getWidth(), this.gCn.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bfT = typedArray.getDimensionPixelSize(i, this.bfT);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gCy = typedArray.getDimensionPixelSize(i, this.gCy);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gCx = typedArray.getDimensionPixelSize(i, this.gCx);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gCC = typedArray.getDimensionPixelSize(i, this.gCC);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gCz = typedArray.getDimensionPixelSize(i, this.gCz);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aDa = typedArray.getColor(i, this.aDa);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gCD = typedArray.getColor(i, this.gCD);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gCE = typedArray.getDimensionPixelSize(i, this.gCE);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gCF = typedArray.getBoolean(i, this.gCF);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gCG = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gCI = typedArray.getDimensionPixelSize(i, this.gCI);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gCJ = typedArray.getInteger(i, this.gCJ);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gCK = typedArray.getBoolean(i, this.gCK);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gCL = typedArray.getDimensionPixelSize(i, this.gCL);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gCB = typedArray.getDimensionPixelSize(i, this.gCB);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gCM = typedArray.getBoolean(i, this.gCM);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gCO = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gCN = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gCP = typedArray.getDimensionPixelSize(i, this.gCP);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gCQ = typedArray.getColor(i, this.gCQ);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gCR = typedArray.getBoolean(i, this.gCR);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gCS = typedArray.getDimensionPixelSize(i, this.gCS);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gCT = typedArray.getBoolean(i, this.gCT);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gCV = typedArray.getBoolean(i, this.gCV);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gCU = typedArray.getColor(i, this.gCU);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gCW = typedArray.getBoolean(i, this.gCW);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gCX = typedArray.getBoolean(i, this.gCX);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gCY = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gDj = typedArray.getBoolean(i, this.gDj);
        }
    }

    private void bsd() {
        if (this.gCY != null) {
            this.gDe = ((BitmapDrawable) this.gCY).getBitmap();
        }
        if (this.gDe == null) {
            this.gDe = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gDe = a.c(this.gDe, this.gCD);
        }
        this.gDf = a.adjustPhotoRotation(this.gDe, 90);
        this.gDf = a.adjustPhotoRotation(this.gDf, 90);
        this.gDf = a.adjustPhotoRotation(this.gDf, 90);
        if (this.gCG != null) {
            this.gDc = ((BitmapDrawable) this.gCG).getBitmap();
        }
        if (this.gDc == null) {
            this.gDc = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gDc = a.c(this.gDc, this.gCD);
        }
        this.gDd = a.adjustPhotoRotation(this.gDc, 90);
        this.gDg = (1.0f * this.gCy) / 2.0f;
        this.gCw.setTextSize(this.gCP);
        this.gCw.setColor(this.gCQ);
        setIsBarcode(this.gCM);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gCt != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            bse();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aDa != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aDa);
            canvas.drawRect(0.0f, 0.0f, width, this.gCt.top, this.mPaint);
            canvas.drawRect(0.0f, this.gCt.top, this.gCt.left, this.gCt.bottom + 1, this.mPaint);
            canvas.drawRect(this.gCt.right + 1, this.gCt.top, width, this.gCt.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gCt.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gCI > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gCI);
            canvas.drawRect(this.gCt, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gCn, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gCo, getMainFrameRight() - this.gCn.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gCp, getMainFrameLeft(), getMainFrameBottom() - this.gCn.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gCq, getMainFrameRight() - this.gCn.getWidth(), getMainFrameBottom() - this.gCn.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gCt.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gCt.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gCt.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gCt.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gCI / 2;
    }

    private void E(Canvas canvas) {
        if (this.gCM) {
            if (this.gCZ != null) {
                RectF rectF = new RectF(this.gCt.left + this.gDg + 0.5f, this.gCt.top + this.gDg + this.gCE, this.gDb, (this.gCt.bottom - this.gDg) - this.gCE);
                Rect rect = new Rect((int) (this.gCZ.getWidth() - rectF.width()), 0, this.gCZ.getWidth(), this.gCZ.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gCZ, rect, rectF, this.mPaint);
            } else if (this.gCH != null) {
                canvas.drawBitmap(this.gCH, (Rect) null, new RectF(this.gCv, this.gCt.top + this.gDg + this.gCE, this.gCv + this.gCH.getWidth(), (this.gCt.bottom - this.gDg) - this.gCE), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gCD);
                canvas.drawRect(this.gCv, this.gCE + this.gCt.top + this.gDg, this.gCC + this.gCv, (this.gCt.bottom - this.gDg) - this.gCE, this.mPaint);
            }
        } else if (this.gCZ != null) {
            RectF rectF2 = new RectF(this.gCt.left + this.gDg + this.gCE, this.gCt.top + this.gDg + 0.5f, (this.gCt.right - this.gDg) - this.gCE, this.gDa);
            Rect rect2 = new Rect(0, (int) (this.gCZ.getHeight() - rectF2.height()), this.gCZ.getWidth(), this.gCZ.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gDk);
            canvas.drawBitmap(this.gCZ, rect2, rectF2, this.mPaint);
        } else if (this.gCH != null) {
            canvas.drawBitmap(this.gCH, (Rect) null, new RectF(this.gCt.left + this.gDg + this.gCE, this.gCu, (this.gCt.right - this.gDg) - this.gCE, this.gCu + this.gCH.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gCD);
            canvas.drawRect(this.gCE + this.gCt.left + this.gDg, this.gCu, (this.gCt.right - this.gDg) - this.gCE, this.gCC + this.gCu, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fth) && this.gDh != null) {
            if (this.gCR) {
                if (this.gCV) {
                    this.mPaint.setColor(this.gCU);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gCT) {
                        Rect rect = new Rect();
                        this.gCw.getTextBounds(this.fth, 0, this.fth.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gDi;
                        canvas.drawRoundRect(new RectF(width, (this.gCt.bottom + this.gCS) - this.gDi, rect.width() + width + (this.gDi * 2), this.gCt.bottom + this.gCS + this.gDh.getHeight() + this.gDi), this.gDi, this.gDi, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gCt.left, (this.gCt.bottom + this.gCS) - this.gDi, this.gCt.right, this.gCt.bottom + this.gCS + this.gDh.getHeight() + this.gDi), this.gDi, this.gDi, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gCT) {
                    canvas.translate(0.0f, this.gCt.bottom + this.gCS);
                } else {
                    canvas.translate(this.gCt.left + this.gDi, this.gCt.bottom + this.gCS);
                }
                this.gDh.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gCV) {
                this.mPaint.setColor(this.gCU);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gCT) {
                    Rect rect2 = new Rect();
                    this.gCw.getTextBounds(this.fth, 0, this.fth.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gDi;
                    canvas.drawRoundRect(new RectF(width2, ((this.gCt.top - this.gCS) - this.gDh.getHeight()) - this.gDi, rect2.width() + width2 + (this.gDi * 2), (this.gCt.top - this.gCS) + this.gDi), this.gDi, this.gDi, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gCt.left, ((this.gCt.top - this.gCS) - this.gDh.getHeight()) - this.gDi, this.gCt.right, (this.gCt.top - this.gCS) + this.gDi), this.gDi, this.gDi, this.mPaint);
                }
            }
            canvas.save();
            if (this.gCT) {
                canvas.translate(0.0f, (this.gCt.top - this.gCS) - this.gDh.getHeight());
            } else {
                canvas.translate(this.gCt.left + this.gDi, (this.gCt.top - this.gCS) - this.gDh.getHeight());
            }
            this.gDh.draw(canvas);
            canvas.restore();
        }
    }

    private void bse() {
        if (this.gCM) {
            if (this.gCZ == null) {
                this.gCv += this.gCr;
                int i = this.gCC;
                if (this.gCH != null) {
                    i = this.gCH.getWidth();
                }
                if (this.gCW) {
                    if (i + this.gCv > this.gCt.right - this.gDg || this.gCv < this.gCt.left + this.gDg) {
                        this.gCr = -this.gCr;
                    }
                } else {
                    if (i + this.gCv > this.gCt.right - this.gDg) {
                        this.gCv = this.gCt.left + this.gDg + 0.5f;
                    }
                }
            } else {
                this.gDb += this.gCr;
                if (this.gDb > this.gCt.right - this.gDg) {
                    this.gDb = this.gCt.left + this.gDg + 0.5f;
                }
            }
        } else if (this.gCZ == null) {
            this.gCu += this.gCr;
            int i2 = this.gCC;
            if (this.gCH != null) {
                i2 = this.gCH.getHeight();
            }
            if (this.gCW) {
                if (i2 + this.gCu > this.gCt.bottom - this.gDg || this.gCu < this.gCt.top + this.gDg) {
                    this.gCr = -this.gCr;
                }
            } else {
                if (i2 + this.gCu > this.gCt.bottom - this.gDg) {
                    this.gCu = this.gCt.top + this.gDg + 0.5f;
                }
            }
        } else {
            this.gDa += this.gCr;
            if (this.gDa > this.gCt.bottom - this.gDg) {
                this.gDa = this.gCt.top + this.gDg + 0.5f;
            }
        }
        postInvalidateDelayed(this.gCs, this.gCt.left, this.gCt.top, this.gCt.right, this.gCt.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bsf();
    }

    private void bsf() {
        int i = this.bfT + this.gCL;
        int width = (getWidth() - this.gCz) / 2;
        this.gCt = new Rect(width, i, this.gCz + width, this.gCA + i);
        if (this.gCM) {
            float f = this.gCt.left + this.gDg + 0.5f;
            this.gCv = f;
            this.gDb = f;
            return;
        }
        float f2 = this.gCt.top + this.gDg + 0.5f;
        this.gCu = f2;
        this.gDa = f2;
    }

    public Rect tn(int i) {
        if (this.gDj) {
            Rect rect = new Rect(this.gCt);
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
        this.gCM = z;
        if (this.gCY != null || this.gCX) {
            if (this.gCM) {
                this.gCZ = this.gDf;
            } else {
                this.gCZ = this.gDe;
            }
        } else if (this.gCG != null || this.gCF) {
            if (this.gCM) {
                this.gCH = this.gDd;
            } else {
                this.gCH = this.gDc;
            }
        }
        if (this.gCM) {
            this.fth = this.gCO;
            this.gCA = this.gCB;
            this.gCs = (int) (((this.gCJ * 1.0f) * this.gCr) / this.gCz);
        } else {
            this.fth = this.gCN;
            this.gCA = this.gCz;
            this.gCs = (int) (((this.gCJ * 1.0f) * this.gCr) / this.gCA);
        }
        if (!TextUtils.isEmpty(this.fth)) {
            if (this.gCT) {
                this.gDh = new StaticLayout(this.fth, this.gCw, a.cQ(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gDh = new StaticLayout(this.fth, this.gCw, this.gCz - (this.gDi * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gCK) {
            int i = a.cQ(getContext()).y;
            if (this.gCL == 0) {
                this.bfT = (i - this.gCA) / 2;
            } else {
                this.bfT = ((i - this.gCA) / 2) + (this.gCL / 2);
            }
        }
        bsf();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gCM;
    }

    public int getMaskColor() {
        return this.aDa;
    }

    public void setMaskColor(int i) {
        this.aDa = i;
    }

    public int getCornerLength() {
        return this.gCx;
    }

    public void setCornerLength(int i) {
        this.gCx = i;
    }

    public int getCornerSize() {
        return this.gCy;
    }

    public void setCornerSize(int i) {
        this.gCy = i;
    }

    public int getRectWidth() {
        return this.gCz;
    }

    public void setRectWidth(int i) {
        this.gCz = i;
    }

    public int getRectHeight() {
        return this.gCA;
    }

    public void setRectHeight(int i) {
        this.gCA = i;
    }

    public int getBarcodeRectHeight() {
        return this.gCB;
    }

    public void setBarcodeRectHeight(int i) {
        this.gCB = i;
    }

    public int getTopOffset() {
        return this.bfT;
    }

    public void setTopOffset(int i) {
        this.bfT = i;
    }

    public int getScanLineSize() {
        return this.gCC;
    }

    public void setScanLineSize(int i) {
        this.gCC = i;
    }

    public int getScanLineColor() {
        return this.gCD;
    }

    public void setScanLineColor(int i) {
        this.gCD = i;
    }

    public int getScanLineMargin() {
        return this.gCE;
    }

    public void setScanLineMargin(int i) {
        this.gCE = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gCF = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gCG;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gCG = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gCH;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gCH = bitmap;
    }

    public int getBorderSize() {
        return this.gCI;
    }

    public void setBorderSize(int i) {
        this.gCI = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gCJ;
    }

    public void setAnimTime(int i) {
        this.gCJ = i;
    }

    public void setCenterVertical(boolean z) {
        this.gCK = z;
    }

    public int getToolbarHeight() {
        return this.gCL;
    }

    public void setToolbarHeight(int i) {
        this.gCL = i;
    }

    public String getQRCodeTipText() {
        return this.gCN;
    }

    public void setQRCodeTipText(String str) {
        this.gCN = str;
    }

    public String getBarCodeTipText() {
        return this.gCO;
    }

    public void setBarCodeTipText(String str) {
        this.gCO = str;
    }

    public String getTipText() {
        return this.fth;
    }

    public void setTipText(String str) {
        this.fth = str;
    }

    public int getTipTextColor() {
        return this.gCQ;
    }

    public void setTipTextColor(int i) {
        this.gCQ = i;
    }

    public int getTipTextSize() {
        return this.gCP;
    }

    public void setTipTextSize(int i) {
        this.gCP = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gCR = z;
    }

    public int getTipTextMargin() {
        return this.gCS;
    }

    public void setTipTextMargin(int i) {
        this.gCS = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gCT = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gCV = z;
    }

    public int getTipBackgroundColor() {
        return this.gCU;
    }

    public void setTipBackgroundColor(int i) {
        this.gCU = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gCW = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gCX = z;
    }

    public float getHalfCornerSize() {
        return this.gDg;
    }

    public void setHalfCornerSize(float f) {
        this.gDg = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gDh;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gDh = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gDi;
    }

    public void setTipBackgroundRadius(int i) {
        this.gDi = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gDj = z;
    }
}
