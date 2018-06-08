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
    private int aWn;
    private int atY;
    private String eYO;
    private Bitmap ggF;
    private Bitmap ggG;
    private Bitmap ggH;
    private Bitmap ggI;
    private int ggJ;
    private int ggK;
    private Rect ggL;
    private float ggM;
    private float ggN;
    private TextPaint ggO;
    private int ggP;
    private int ggQ;
    private int ggR;
    private int ggS;
    private int ggT;
    private int ggU;
    private int ggV;
    private int ggW;
    private boolean ggX;
    private Drawable ggY;
    private Bitmap ggZ;
    private int ghA;
    private boolean ghB;
    private ColorMatrixColorFilter ghC;
    private int gha;
    private int ghb;
    private boolean ghc;
    private int ghd;
    private boolean ghe;
    private String ghf;
    private String ghg;
    private int ghh;
    private int ghi;
    private boolean ghj;
    private int ghk;
    private boolean ghl;
    private int ghm;
    private boolean ghn;
    private boolean gho;
    private boolean ghp;
    private Drawable ghq;
    private Bitmap ghr;
    private float ghs;
    private float ght;
    private Bitmap ghu;
    private Bitmap ghv;
    private Bitmap ghw;
    private Bitmap ghx;
    private float ghy;
    private StaticLayout ghz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.atY = Color.parseColor("#33FFFFFF");
        this.ggP = a.f(context, 20.0f);
        this.ggQ = a.f(context, 3.0f);
        this.ggU = a.f(context, 1.0f);
        this.ggV = -1;
        this.aWn = a.f(context, 90.0f);
        this.ggR = a.f(context, 200.0f);
        this.ggT = a.f(context, 140.0f);
        this.ggW = 0;
        this.ggX = false;
        this.ggY = null;
        this.ggZ = null;
        this.gha = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.ghb = 1000;
        this.ghc = false;
        this.ghd = 0;
        this.ghe = false;
        this.ggJ = a.f(context, 2.0f);
        this.eYO = null;
        this.ghh = a.e(context, 14.0f);
        this.ghi = -1;
        this.ghj = false;
        this.ghk = a.f(context, 20.0f);
        this.ghl = false;
        this.ghm = Color.parseColor("#22000000");
        this.ghn = false;
        this.gho = false;
        this.ghp = false;
        this.ggO = new TextPaint();
        this.ggO.setAntiAlias(true);
        this.ghA = a.f(context, 4.0f);
        this.ghB = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ghC = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bnC();
        bnB();
    }

    private void bnB() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ggP;
        options.outHeight = this.ggP;
        this.ggF = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.ggG = Bitmap.createBitmap(this.ggF, 0, 0, this.ggF.getWidth(), this.ggF.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.ggH = Bitmap.createBitmap(this.ggF, 0, 0, this.ggF.getWidth(), this.ggF.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ggI = Bitmap.createBitmap(this.ggF, 0, 0, this.ggF.getWidth(), this.ggF.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.m.QRCodeView_qrcv_topOffset) {
            this.aWn = typedArray.getDimensionPixelSize(i, this.aWn);
        } else if (i == d.m.QRCodeView_qrcv_cornerSize) {
            this.ggQ = typedArray.getDimensionPixelSize(i, this.ggQ);
        } else if (i == d.m.QRCodeView_qrcv_cornerLength) {
            this.ggP = typedArray.getDimensionPixelSize(i, this.ggP);
        } else if (i == d.m.QRCodeView_qrcv_scanLineSize) {
            this.ggU = typedArray.getDimensionPixelSize(i, this.ggU);
        } else if (i == d.m.QRCodeView_qrcv_rectWidth) {
            this.ggR = typedArray.getDimensionPixelSize(i, this.ggR);
        } else if (i == d.m.QRCodeView_qrcv_maskColor) {
            this.atY = typedArray.getColor(i, this.atY);
        } else if (i == d.m.QRCodeView_qrcv_scanLineColor) {
            this.ggV = typedArray.getColor(i, this.ggV);
        } else if (i == d.m.QRCodeView_qrcv_scanLineMargin) {
            this.ggW = typedArray.getDimensionPixelSize(i, this.ggW);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ggX = typedArray.getBoolean(i, this.ggX);
        } else if (i == d.m.QRCodeView_qrcv_customScanLineDrawable) {
            this.ggY = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_borderSize) {
            this.gha = typedArray.getDimensionPixelSize(i, this.gha);
        } else if (i == d.m.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.m.QRCodeView_qrcv_animTime) {
            this.ghb = typedArray.getInteger(i, this.ghb);
        } else if (i == d.m.QRCodeView_qrcv_isCenterVertical) {
            this.ghc = typedArray.getBoolean(i, this.ghc);
        } else if (i == d.m.QRCodeView_qrcv_toolbarHeight) {
            this.ghd = typedArray.getDimensionPixelSize(i, this.ghd);
        } else if (i == d.m.QRCodeView_qrcv_barcodeRectHeight) {
            this.ggT = typedArray.getDimensionPixelSize(i, this.ggT);
        } else if (i == d.m.QRCodeView_qrcv_isBarcode) {
            this.ghe = typedArray.getBoolean(i, this.ghe);
        } else if (i == d.m.QRCodeView_qrcv_barCodeTipText) {
            this.ghg = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_qrCodeTipText) {
            this.ghf = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_tipTextSize) {
            this.ghh = typedArray.getDimensionPixelSize(i, this.ghh);
        } else if (i == d.m.QRCodeView_qrcv_tipTextColor) {
            this.ghi = typedArray.getColor(i, this.ghi);
        } else if (i == d.m.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ghj = typedArray.getBoolean(i, this.ghj);
        } else if (i == d.m.QRCodeView_qrcv_tipTextMargin) {
            this.ghk = typedArray.getDimensionPixelSize(i, this.ghk);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ghl = typedArray.getBoolean(i, this.ghl);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipBackground) {
            this.ghn = typedArray.getBoolean(i, this.ghn);
        } else if (i == d.m.QRCodeView_qrcv_tipBackgroundColor) {
            this.ghm = typedArray.getColor(i, this.ghm);
        } else if (i == d.m.QRCodeView_qrcv_isScanLineReverse) {
            this.gho = typedArray.getBoolean(i, this.gho);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ghp = typedArray.getBoolean(i, this.ghp);
        } else if (i == d.m.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ghq = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.ghB = typedArray.getBoolean(i, this.ghB);
        }
    }

    private void bnC() {
        if (this.ghq != null) {
            this.ghw = ((BitmapDrawable) this.ghq).getBitmap();
        }
        if (this.ghw == null) {
            this.ghw = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ghw = a.d(this.ghw, this.ggV);
        }
        this.ghx = a.c(this.ghw, 90);
        this.ghx = a.c(this.ghx, 90);
        this.ghx = a.c(this.ghx, 90);
        if (this.ggY != null) {
            this.ghu = ((BitmapDrawable) this.ggY).getBitmap();
        }
        if (this.ghu == null) {
            this.ghu = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ghu = a.d(this.ghu, this.ggV);
        }
        this.ghv = a.c(this.ghu, 90);
        this.ghy = (1.0f * this.ggQ) / 2.0f;
        this.ggO.setTextSize(this.ghh);
        this.ggO.setColor(this.ghi);
        setIsBarcode(this.ghe);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ggL != null) {
            A(canvas);
            B(canvas);
            D(canvas);
            E(canvas);
            C(canvas);
            bnD();
        }
    }

    private void A(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.atY != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.atY);
            canvas.drawRect(0.0f, 0.0f, width, this.ggL.top, this.mPaint);
            canvas.drawRect(0.0f, this.ggL.top, this.ggL.left, this.ggL.bottom + 1, this.mPaint);
            canvas.drawRect(this.ggL.right + 1, this.ggL.top, width, this.ggL.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ggL.bottom + 1, width, height, this.mPaint);
        }
    }

    private void B(Canvas canvas) {
        if (this.gha > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gha);
            canvas.drawRect(this.ggL, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.ggF, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ggG, getMainFrameRight() - this.ggF.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ggH, getMainFrameLeft(), getMainFrameBottom() - this.ggF.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ggI, getMainFrameRight() - this.ggF.getWidth(), getMainFrameBottom() - this.ggF.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ggL.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ggL.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ggL.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ggL.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gha / 2;
    }

    private void D(Canvas canvas) {
        if (this.ghe) {
            if (this.ghr != null) {
                RectF rectF = new RectF(this.ggL.left + this.ghy + 0.5f, this.ggL.top + this.ghy + this.ggW, this.ght, (this.ggL.bottom - this.ghy) - this.ggW);
                Rect rect = new Rect((int) (this.ghr.getWidth() - rectF.width()), 0, this.ghr.getWidth(), this.ghr.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ghr, rect, rectF, this.mPaint);
            } else if (this.ggZ != null) {
                canvas.drawBitmap(this.ggZ, (Rect) null, new RectF(this.ggN, this.ggL.top + this.ghy + this.ggW, this.ggN + this.ggZ.getWidth(), (this.ggL.bottom - this.ghy) - this.ggW), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ggV);
                canvas.drawRect(this.ggN, this.ggW + this.ggL.top + this.ghy, this.ggU + this.ggN, (this.ggL.bottom - this.ghy) - this.ggW, this.mPaint);
            }
        } else if (this.ghr != null) {
            RectF rectF2 = new RectF(this.ggL.left + this.ghy + this.ggW, this.ggL.top + this.ghy + 0.5f, (this.ggL.right - this.ghy) - this.ggW, this.ghs);
            Rect rect2 = new Rect(0, (int) (this.ghr.getHeight() - rectF2.height()), this.ghr.getWidth(), this.ghr.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ghC);
            canvas.drawBitmap(this.ghr, rect2, rectF2, this.mPaint);
        } else if (this.ggZ != null) {
            canvas.drawBitmap(this.ggZ, (Rect) null, new RectF(this.ggL.left + this.ghy + this.ggW, this.ggM, (this.ggL.right - this.ghy) - this.ggW, this.ggM + this.ggZ.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ggV);
            canvas.drawRect(this.ggW + this.ggL.left + this.ghy, this.ggM, (this.ggL.right - this.ghy) - this.ggW, this.ggU + this.ggM, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        if (!TextUtils.isEmpty(this.eYO) && this.ghz != null) {
            if (this.ghj) {
                if (this.ghn) {
                    this.mPaint.setColor(this.ghm);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ghl) {
                        Rect rect = new Rect();
                        this.ggO.getTextBounds(this.eYO, 0, this.eYO.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ghA;
                        canvas.drawRoundRect(new RectF(width, (this.ggL.bottom + this.ghk) - this.ghA, rect.width() + width + (this.ghA * 2), this.ggL.bottom + this.ghk + this.ghz.getHeight() + this.ghA), this.ghA, this.ghA, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ggL.left, (this.ggL.bottom + this.ghk) - this.ghA, this.ggL.right, this.ggL.bottom + this.ghk + this.ghz.getHeight() + this.ghA), this.ghA, this.ghA, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ghl) {
                    canvas.translate(0.0f, this.ggL.bottom + this.ghk);
                } else {
                    canvas.translate(this.ggL.left + this.ghA, this.ggL.bottom + this.ghk);
                }
                this.ghz.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ghn) {
                this.mPaint.setColor(this.ghm);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ghl) {
                    Rect rect2 = new Rect();
                    this.ggO.getTextBounds(this.eYO, 0, this.eYO.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ghA;
                    canvas.drawRoundRect(new RectF(width2, ((this.ggL.top - this.ghk) - this.ghz.getHeight()) - this.ghA, rect2.width() + width2 + (this.ghA * 2), (this.ggL.top - this.ghk) + this.ghA), this.ghA, this.ghA, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ggL.left, ((this.ggL.top - this.ghk) - this.ghz.getHeight()) - this.ghA, this.ggL.right, (this.ggL.top - this.ghk) + this.ghA), this.ghA, this.ghA, this.mPaint);
                }
            }
            canvas.save();
            if (this.ghl) {
                canvas.translate(0.0f, (this.ggL.top - this.ghk) - this.ghz.getHeight());
            } else {
                canvas.translate(this.ggL.left + this.ghA, (this.ggL.top - this.ghk) - this.ghz.getHeight());
            }
            this.ghz.draw(canvas);
            canvas.restore();
        }
    }

    private void bnD() {
        if (this.ghe) {
            if (this.ghr == null) {
                this.ggN += this.ggJ;
                int i = this.ggU;
                if (this.ggZ != null) {
                    i = this.ggZ.getWidth();
                }
                if (this.gho) {
                    if (i + this.ggN > this.ggL.right - this.ghy || this.ggN < this.ggL.left + this.ghy) {
                        this.ggJ = -this.ggJ;
                    }
                } else {
                    if (i + this.ggN > this.ggL.right - this.ghy) {
                        this.ggN = this.ggL.left + this.ghy + 0.5f;
                    }
                }
            } else {
                this.ght += this.ggJ;
                if (this.ght > this.ggL.right - this.ghy) {
                    this.ght = this.ggL.left + this.ghy + 0.5f;
                }
            }
        } else if (this.ghr == null) {
            this.ggM += this.ggJ;
            int i2 = this.ggU;
            if (this.ggZ != null) {
                i2 = this.ggZ.getHeight();
            }
            if (this.gho) {
                if (i2 + this.ggM > this.ggL.bottom - this.ghy || this.ggM < this.ggL.top + this.ghy) {
                    this.ggJ = -this.ggJ;
                }
            } else {
                if (i2 + this.ggM > this.ggL.bottom - this.ghy) {
                    this.ggM = this.ggL.top + this.ghy + 0.5f;
                }
            }
        } else {
            this.ghs += this.ggJ;
            if (this.ghs > this.ggL.bottom - this.ghy) {
                this.ghs = this.ggL.top + this.ghy + 0.5f;
            }
        }
        postInvalidateDelayed(this.ggK, this.ggL.left, this.ggL.top, this.ggL.right, this.ggL.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bnE();
    }

    private void bnE() {
        int i = this.aWn + this.ghd;
        int width = (getWidth() - this.ggR) / 2;
        this.ggL = new Rect(width, i, this.ggR + width, this.ggS + i);
        if (this.ghe) {
            float f = this.ggL.left + this.ghy + 0.5f;
            this.ggN = f;
            this.ght = f;
            return;
        }
        float f2 = this.ggL.top + this.ghy + 0.5f;
        this.ggM = f2;
        this.ghs = f2;
    }

    public Rect rU(int i) {
        if (this.ghB) {
            Rect rect = new Rect(this.ggL);
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
        this.ghe = z;
        if (this.ghq != null || this.ghp) {
            if (this.ghe) {
                this.ghr = this.ghx;
            } else {
                this.ghr = this.ghw;
            }
        } else if (this.ggY != null || this.ggX) {
            if (this.ghe) {
                this.ggZ = this.ghv;
            } else {
                this.ggZ = this.ghu;
            }
        }
        if (this.ghe) {
            this.eYO = this.ghg;
            this.ggS = this.ggT;
            this.ggK = (int) (((this.ghb * 1.0f) * this.ggJ) / this.ggR);
        } else {
            this.eYO = this.ghf;
            this.ggS = this.ggR;
            this.ggK = (int) (((this.ghb * 1.0f) * this.ggJ) / this.ggS);
        }
        if (!TextUtils.isEmpty(this.eYO)) {
            if (this.ghl) {
                this.ghz = new StaticLayout(this.eYO, this.ggO, a.cc(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ghz = new StaticLayout(this.eYO, this.ggO, this.ggR - (this.ghA * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ghc) {
            int i = a.cc(getContext()).y;
            if (this.ghd == 0) {
                this.aWn = (i - this.ggS) / 2;
            } else {
                this.aWn = ((i - this.ggS) / 2) + (this.ghd / 2);
            }
        }
        bnE();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ghe;
    }

    public int getMaskColor() {
        return this.atY;
    }

    public void setMaskColor(int i) {
        this.atY = i;
    }

    public int getCornerLength() {
        return this.ggP;
    }

    public void setCornerLength(int i) {
        this.ggP = i;
    }

    public int getCornerSize() {
        return this.ggQ;
    }

    public void setCornerSize(int i) {
        this.ggQ = i;
    }

    public int getRectWidth() {
        return this.ggR;
    }

    public void setRectWidth(int i) {
        this.ggR = i;
    }

    public int getRectHeight() {
        return this.ggS;
    }

    public void setRectHeight(int i) {
        this.ggS = i;
    }

    public int getBarcodeRectHeight() {
        return this.ggT;
    }

    public void setBarcodeRectHeight(int i) {
        this.ggT = i;
    }

    public int getTopOffset() {
        return this.aWn;
    }

    public void setTopOffset(int i) {
        this.aWn = i;
    }

    public int getScanLineSize() {
        return this.ggU;
    }

    public void setScanLineSize(int i) {
        this.ggU = i;
    }

    public int getScanLineColor() {
        return this.ggV;
    }

    public void setScanLineColor(int i) {
        this.ggV = i;
    }

    public int getScanLineMargin() {
        return this.ggW;
    }

    public void setScanLineMargin(int i) {
        this.ggW = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ggX = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ggY;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ggY = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ggZ;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ggZ = bitmap;
    }

    public int getBorderSize() {
        return this.gha;
    }

    public void setBorderSize(int i) {
        this.gha = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ghb;
    }

    public void setAnimTime(int i) {
        this.ghb = i;
    }

    public void setCenterVertical(boolean z) {
        this.ghc = z;
    }

    public int getToolbarHeight() {
        return this.ghd;
    }

    public void setToolbarHeight(int i) {
        this.ghd = i;
    }

    public String getQRCodeTipText() {
        return this.ghf;
    }

    public void setQRCodeTipText(String str) {
        this.ghf = str;
    }

    public String getBarCodeTipText() {
        return this.ghg;
    }

    public void setBarCodeTipText(String str) {
        this.ghg = str;
    }

    public String getTipText() {
        return this.eYO;
    }

    public void setTipText(String str) {
        this.eYO = str;
    }

    public int getTipTextColor() {
        return this.ghi;
    }

    public void setTipTextColor(int i) {
        this.ghi = i;
    }

    public int getTipTextSize() {
        return this.ghh;
    }

    public void setTipTextSize(int i) {
        this.ghh = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ghj = z;
    }

    public int getTipTextMargin() {
        return this.ghk;
    }

    public void setTipTextMargin(int i) {
        this.ghk = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ghl = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ghn = z;
    }

    public int getTipBackgroundColor() {
        return this.ghm;
    }

    public void setTipBackgroundColor(int i) {
        this.ghm = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gho = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ghp = z;
    }

    public float getHalfCornerSize() {
        return this.ghy;
    }

    public void setHalfCornerSize(float f) {
        this.ghy = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ghz;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ghz = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ghA;
    }

    public void setTipBackgroundRadius(int i) {
        this.ghA = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ghB = z;
    }
}
