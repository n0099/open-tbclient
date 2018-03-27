package com.baidu.tieba.qrcode.lib.a;

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
public class f extends View {
    private int bDS;
    private int bax;
    private String frI;
    private String gAa;
    private String gAb;
    private int gAc;
    private int gAd;
    private boolean gAe;
    private int gAf;
    private boolean gAg;
    private int gAh;
    private boolean gAi;
    private boolean gAj;
    private boolean gAk;
    private Drawable gAl;
    private Bitmap gAm;
    private float gAn;
    private float gAo;
    private Bitmap gAp;
    private Bitmap gAq;
    private Bitmap gAr;
    private Bitmap gAs;
    private float gAt;
    private StaticLayout gAu;
    private int gAv;
    private boolean gAw;
    private ColorMatrixColorFilter gAx;
    private Bitmap gzA;
    private Bitmap gzB;
    private Bitmap gzC;
    private Bitmap gzD;
    private int gzE;
    private int gzF;
    private Rect gzG;
    private float gzH;
    private float gzI;
    private TextPaint gzJ;
    private int gzK;
    private int gzL;
    private int gzM;
    private int gzN;
    private int gzO;
    private int gzP;
    private int gzQ;
    private int gzR;
    private boolean gzS;
    private Drawable gzT;
    private Bitmap gzU;
    private int gzV;
    private int gzW;
    private boolean gzX;
    private int gzY;
    private boolean gzZ;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bax = Color.parseColor("#33FFFFFF");
        this.gzK = a.f(context, 20.0f);
        this.gzL = a.f(context, 3.0f);
        this.gzP = a.f(context, 1.0f);
        this.gzQ = -1;
        this.bDS = a.f(context, 90.0f);
        this.gzM = a.f(context, 200.0f);
        this.gzO = a.f(context, 140.0f);
        this.gzR = 0;
        this.gzS = false;
        this.gzT = null;
        this.gzU = null;
        this.gzV = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gzW = 1000;
        this.gzX = false;
        this.gzY = 0;
        this.gzZ = false;
        this.gzE = a.f(context, 2.0f);
        this.frI = null;
        this.gAc = a.e(context, 14.0f);
        this.gAd = -1;
        this.gAe = false;
        this.gAf = a.f(context, 20.0f);
        this.gAg = false;
        this.gAh = Color.parseColor("#22000000");
        this.gAi = false;
        this.gAj = false;
        this.gAk = false;
        this.gzJ = new TextPaint();
        this.gzJ.setAntiAlias(true);
        this.gAv = a.f(context, 4.0f);
        this.gAw = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gAx = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bny();
        bnx();
    }

    private void bnx() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gzK;
        options.outHeight = this.gzK;
        this.gzA = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gzB = Bitmap.createBitmap(this.gzA, 0, 0, this.gzA.getWidth(), this.gzA.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gzC = Bitmap.createBitmap(this.gzA, 0, 0, this.gzA.getWidth(), this.gzA.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gzD = Bitmap.createBitmap(this.gzA, 0, 0, this.gzA.getWidth(), this.gzA.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.bDS = typedArray.getDimensionPixelSize(i, this.bDS);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.gzL = typedArray.getDimensionPixelSize(i, this.gzL);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.gzK = typedArray.getDimensionPixelSize(i, this.gzK);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.gzP = typedArray.getDimensionPixelSize(i, this.gzP);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.gzM = typedArray.getDimensionPixelSize(i, this.gzM);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.bax = typedArray.getColor(i, this.bax);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.gzQ = typedArray.getColor(i, this.gzQ);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.gzR = typedArray.getDimensionPixelSize(i, this.gzR);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gzS = typedArray.getBoolean(i, this.gzS);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gzT = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.gzV = typedArray.getDimensionPixelSize(i, this.gzV);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.gzW = typedArray.getInteger(i, this.gzW);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.gzX = typedArray.getBoolean(i, this.gzX);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.gzY = typedArray.getDimensionPixelSize(i, this.gzY);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gzO = typedArray.getDimensionPixelSize(i, this.gzO);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.gzZ = typedArray.getBoolean(i, this.gzZ);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.gAb = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gAa = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.gAc = typedArray.getDimensionPixelSize(i, this.gAc);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.gAd = typedArray.getColor(i, this.gAd);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gAe = typedArray.getBoolean(i, this.gAe);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.gAf = typedArray.getDimensionPixelSize(i, this.gAf);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gAg = typedArray.getBoolean(i, this.gAg);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gAi = typedArray.getBoolean(i, this.gAi);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gAh = typedArray.getColor(i, this.gAh);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gAj = typedArray.getBoolean(i, this.gAj);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gAk = typedArray.getBoolean(i, this.gAk);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gAl = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gAw = typedArray.getBoolean(i, this.gAw);
        }
    }

    private void bny() {
        if (this.gAl != null) {
            this.gAr = ((BitmapDrawable) this.gAl).getBitmap();
        }
        if (this.gAr == null) {
            this.gAr = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gAr = a.f(this.gAr, this.gzQ);
        }
        this.gAs = a.e(this.gAr, 90);
        this.gAs = a.e(this.gAs, 90);
        this.gAs = a.e(this.gAs, 90);
        if (this.gzT != null) {
            this.gAp = ((BitmapDrawable) this.gzT).getBitmap();
        }
        if (this.gAp == null) {
            this.gAp = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gAp = a.f(this.gAp, this.gzQ);
        }
        this.gAq = a.e(this.gAp, 90);
        this.gAt = (1.0f * this.gzL) / 2.0f;
        this.gzJ.setTextSize(this.gAc);
        this.gzJ.setColor(this.gAd);
        setIsBarcode(this.gzZ);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gzG != null) {
            C(canvas);
            D(canvas);
            F(canvas);
            G(canvas);
            E(canvas);
            bnz();
        }
    }

    private void C(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bax != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bax);
            canvas.drawRect(0.0f, 0.0f, width, this.gzG.top, this.mPaint);
            canvas.drawRect(0.0f, this.gzG.top, this.gzG.left, this.gzG.bottom + 1, this.mPaint);
            canvas.drawRect(this.gzG.right + 1, this.gzG.top, width, this.gzG.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gzG.bottom + 1, width, height, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.gzV > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gzV);
            canvas.drawRect(this.gzG, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gzA, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzB, getMainFrameRight() - this.gzA.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzC, getMainFrameLeft(), getMainFrameBottom() - this.gzA.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gzD, getMainFrameRight() - this.gzA.getWidth(), getMainFrameBottom() - this.gzA.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gzG.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gzG.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gzG.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gzG.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gzV / 2;
    }

    private void F(Canvas canvas) {
        if (this.gzZ) {
            if (this.gAm != null) {
                RectF rectF = new RectF(this.gzG.left + this.gAt + 0.5f, this.gzG.top + this.gAt + this.gzR, this.gAo, (this.gzG.bottom - this.gAt) - this.gzR);
                Rect rect = new Rect((int) (this.gAm.getWidth() - rectF.width()), 0, this.gAm.getWidth(), this.gAm.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gAm, rect, rectF, this.mPaint);
            } else if (this.gzU != null) {
                canvas.drawBitmap(this.gzU, (Rect) null, new RectF(this.gzI, this.gzG.top + this.gAt + this.gzR, this.gzI + this.gzU.getWidth(), (this.gzG.bottom - this.gAt) - this.gzR), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gzQ);
                canvas.drawRect(this.gzI, this.gzR + this.gzG.top + this.gAt, this.gzP + this.gzI, (this.gzG.bottom - this.gAt) - this.gzR, this.mPaint);
            }
        } else if (this.gAm != null) {
            RectF rectF2 = new RectF(this.gzG.left + this.gAt + this.gzR, this.gzG.top + this.gAt + 0.5f, (this.gzG.right - this.gAt) - this.gzR, this.gAn);
            Rect rect2 = new Rect(0, (int) (this.gAm.getHeight() - rectF2.height()), this.gAm.getWidth(), this.gAm.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gAx);
            canvas.drawBitmap(this.gAm, rect2, rectF2, this.mPaint);
        } else if (this.gzU != null) {
            canvas.drawBitmap(this.gzU, (Rect) null, new RectF(this.gzG.left + this.gAt + this.gzR, this.gzH, (this.gzG.right - this.gAt) - this.gzR, this.gzH + this.gzU.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gzQ);
            canvas.drawRect(this.gzR + this.gzG.left + this.gAt, this.gzH, (this.gzG.right - this.gAt) - this.gzR, this.gzP + this.gzH, this.mPaint);
        }
    }

    private void G(Canvas canvas) {
        if (!TextUtils.isEmpty(this.frI) && this.gAu != null) {
            if (this.gAe) {
                if (this.gAi) {
                    this.mPaint.setColor(this.gAh);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gAg) {
                        Rect rect = new Rect();
                        this.gzJ.getTextBounds(this.frI, 0, this.frI.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gAv;
                        canvas.drawRoundRect(new RectF(width, (this.gzG.bottom + this.gAf) - this.gAv, rect.width() + width + (this.gAv * 2), this.gzG.bottom + this.gAf + this.gAu.getHeight() + this.gAv), this.gAv, this.gAv, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gzG.left, (this.gzG.bottom + this.gAf) - this.gAv, this.gzG.right, this.gzG.bottom + this.gAf + this.gAu.getHeight() + this.gAv), this.gAv, this.gAv, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gAg) {
                    canvas.translate(0.0f, this.gzG.bottom + this.gAf);
                } else {
                    canvas.translate(this.gzG.left + this.gAv, this.gzG.bottom + this.gAf);
                }
                this.gAu.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gAi) {
                this.mPaint.setColor(this.gAh);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gAg) {
                    Rect rect2 = new Rect();
                    this.gzJ.getTextBounds(this.frI, 0, this.frI.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gAv;
                    canvas.drawRoundRect(new RectF(width2, ((this.gzG.top - this.gAf) - this.gAu.getHeight()) - this.gAv, rect2.width() + width2 + (this.gAv * 2), (this.gzG.top - this.gAf) + this.gAv), this.gAv, this.gAv, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gzG.left, ((this.gzG.top - this.gAf) - this.gAu.getHeight()) - this.gAv, this.gzG.right, (this.gzG.top - this.gAf) + this.gAv), this.gAv, this.gAv, this.mPaint);
                }
            }
            canvas.save();
            if (this.gAg) {
                canvas.translate(0.0f, (this.gzG.top - this.gAf) - this.gAu.getHeight());
            } else {
                canvas.translate(this.gzG.left + this.gAv, (this.gzG.top - this.gAf) - this.gAu.getHeight());
            }
            this.gAu.draw(canvas);
            canvas.restore();
        }
    }

    private void bnz() {
        if (this.gzZ) {
            if (this.gAm == null) {
                this.gzI += this.gzE;
                int i = this.gzP;
                if (this.gzU != null) {
                    i = this.gzU.getWidth();
                }
                if (this.gAj) {
                    if (i + this.gzI > this.gzG.right - this.gAt || this.gzI < this.gzG.left + this.gAt) {
                        this.gzE = -this.gzE;
                    }
                } else {
                    if (i + this.gzI > this.gzG.right - this.gAt) {
                        this.gzI = this.gzG.left + this.gAt + 0.5f;
                    }
                }
            } else {
                this.gAo += this.gzE;
                if (this.gAo > this.gzG.right - this.gAt) {
                    this.gAo = this.gzG.left + this.gAt + 0.5f;
                }
            }
        } else if (this.gAm == null) {
            this.gzH += this.gzE;
            int i2 = this.gzP;
            if (this.gzU != null) {
                i2 = this.gzU.getHeight();
            }
            if (this.gAj) {
                if (i2 + this.gzH > this.gzG.bottom - this.gAt || this.gzH < this.gzG.top + this.gAt) {
                    this.gzE = -this.gzE;
                }
            } else {
                if (i2 + this.gzH > this.gzG.bottom - this.gAt) {
                    this.gzH = this.gzG.top + this.gAt + 0.5f;
                }
            }
        } else {
            this.gAn += this.gzE;
            if (this.gAn > this.gzG.bottom - this.gAt) {
                this.gAn = this.gzG.top + this.gAt + 0.5f;
            }
        }
        postInvalidateDelayed(this.gzF, this.gzG.left, this.gzG.top, this.gzG.right, this.gzG.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bnA();
    }

    private void bnA() {
        int i = this.bDS + this.gzY;
        int width = (getWidth() - this.gzM) / 2;
        this.gzG = new Rect(width, i, this.gzM + width, this.gzN + i);
        if (this.gzZ) {
            float f = this.gzG.left + this.gAt + 0.5f;
            this.gzI = f;
            this.gAo = f;
            return;
        }
        float f2 = this.gzG.top + this.gAt + 0.5f;
        this.gzH = f2;
        this.gAn = f2;
    }

    public Rect um(int i) {
        if (this.gAw) {
            Rect rect = new Rect(this.gzG);
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
        this.gzZ = z;
        if (this.gAl != null || this.gAk) {
            if (this.gzZ) {
                this.gAm = this.gAs;
            } else {
                this.gAm = this.gAr;
            }
        } else if (this.gzT != null || this.gzS) {
            if (this.gzZ) {
                this.gzU = this.gAq;
            } else {
                this.gzU = this.gAp;
            }
        }
        if (this.gzZ) {
            this.frI = this.gAb;
            this.gzN = this.gzO;
            this.gzF = (int) (((this.gzW * 1.0f) * this.gzE) / this.gzM);
        } else {
            this.frI = this.gAa;
            this.gzN = this.gzM;
            this.gzF = (int) (((this.gzW * 1.0f) * this.gzE) / this.gzN);
        }
        if (!TextUtils.isEmpty(this.frI)) {
            if (this.gAg) {
                this.gAu = new StaticLayout(this.frI, this.gzJ, a.cd(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gAu = new StaticLayout(this.frI, this.gzJ, this.gzM - (this.gAv * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gzX) {
            int i = a.cd(getContext()).y;
            if (this.gzY == 0) {
                this.bDS = (i - this.gzN) / 2;
            } else {
                this.bDS = ((i - this.gzN) / 2) + (this.gzY / 2);
            }
        }
        bnA();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gzZ;
    }

    public int getMaskColor() {
        return this.bax;
    }

    public void setMaskColor(int i) {
        this.bax = i;
    }

    public int getCornerLength() {
        return this.gzK;
    }

    public void setCornerLength(int i) {
        this.gzK = i;
    }

    public int getCornerSize() {
        return this.gzL;
    }

    public void setCornerSize(int i) {
        this.gzL = i;
    }

    public int getRectWidth() {
        return this.gzM;
    }

    public void setRectWidth(int i) {
        this.gzM = i;
    }

    public int getRectHeight() {
        return this.gzN;
    }

    public void setRectHeight(int i) {
        this.gzN = i;
    }

    public int getBarcodeRectHeight() {
        return this.gzO;
    }

    public void setBarcodeRectHeight(int i) {
        this.gzO = i;
    }

    public int getTopOffset() {
        return this.bDS;
    }

    public void setTopOffset(int i) {
        this.bDS = i;
    }

    public int getScanLineSize() {
        return this.gzP;
    }

    public void setScanLineSize(int i) {
        this.gzP = i;
    }

    public int getScanLineColor() {
        return this.gzQ;
    }

    public void setScanLineColor(int i) {
        this.gzQ = i;
    }

    public int getScanLineMargin() {
        return this.gzR;
    }

    public void setScanLineMargin(int i) {
        this.gzR = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gzS = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gzT;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gzT = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gzU;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gzU = bitmap;
    }

    public int getBorderSize() {
        return this.gzV;
    }

    public void setBorderSize(int i) {
        this.gzV = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gzW;
    }

    public void setAnimTime(int i) {
        this.gzW = i;
    }

    public void setCenterVertical(boolean z) {
        this.gzX = z;
    }

    public int getToolbarHeight() {
        return this.gzY;
    }

    public void setToolbarHeight(int i) {
        this.gzY = i;
    }

    public String getQRCodeTipText() {
        return this.gAa;
    }

    public void setQRCodeTipText(String str) {
        this.gAa = str;
    }

    public String getBarCodeTipText() {
        return this.gAb;
    }

    public void setBarCodeTipText(String str) {
        this.gAb = str;
    }

    public String getTipText() {
        return this.frI;
    }

    public void setTipText(String str) {
        this.frI = str;
    }

    public int getTipTextColor() {
        return this.gAd;
    }

    public void setTipTextColor(int i) {
        this.gAd = i;
    }

    public int getTipTextSize() {
        return this.gAc;
    }

    public void setTipTextSize(int i) {
        this.gAc = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gAe = z;
    }

    public int getTipTextMargin() {
        return this.gAf;
    }

    public void setTipTextMargin(int i) {
        this.gAf = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gAg = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gAi = z;
    }

    public int getTipBackgroundColor() {
        return this.gAh;
    }

    public void setTipBackgroundColor(int i) {
        this.gAh = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gAj = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gAk = z;
    }

    public float getHalfCornerSize() {
        return this.gAt;
    }

    public void setHalfCornerSize(float f) {
        this.gAt = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gAu;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gAu = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gAv;
    }

    public void setTipBackgroundRadius(int i) {
        this.gAv = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gAw = z;
    }
}
