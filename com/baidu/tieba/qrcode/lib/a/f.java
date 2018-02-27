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
    private int bDP;
    private int bav;
    private String frr;
    private Bitmap gAa;
    private Bitmap gAb;
    private Bitmap gAc;
    private float gAd;
    private StaticLayout gAe;
    private int gAf;
    private boolean gAg;
    private ColorMatrixColorFilter gAh;
    private int gzA;
    private int gzB;
    private boolean gzC;
    private Drawable gzD;
    private Bitmap gzE;
    private int gzF;
    private int gzG;
    private boolean gzH;
    private int gzI;
    private boolean gzJ;
    private String gzK;
    private String gzL;
    private int gzM;
    private int gzN;
    private boolean gzO;
    private int gzP;
    private boolean gzQ;
    private int gzR;
    private boolean gzS;
    private boolean gzT;
    private boolean gzU;
    private Drawable gzV;
    private Bitmap gzW;
    private float gzX;
    private float gzY;
    private Bitmap gzZ;
    private Bitmap gzk;
    private Bitmap gzl;
    private Bitmap gzm;
    private Bitmap gzn;
    private int gzo;
    private int gzp;
    private Rect gzq;
    private float gzr;
    private float gzs;
    private TextPaint gzt;
    private int gzu;
    private int gzv;
    private int gzw;
    private int gzx;
    private int gzy;
    private int gzz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bav = Color.parseColor("#33FFFFFF");
        this.gzu = a.f(context, 20.0f);
        this.gzv = a.f(context, 3.0f);
        this.gzz = a.f(context, 1.0f);
        this.gzA = -1;
        this.bDP = a.f(context, 90.0f);
        this.gzw = a.f(context, 200.0f);
        this.gzy = a.f(context, 140.0f);
        this.gzB = 0;
        this.gzC = false;
        this.gzD = null;
        this.gzE = null;
        this.gzF = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gzG = 1000;
        this.gzH = false;
        this.gzI = 0;
        this.gzJ = false;
        this.gzo = a.f(context, 2.0f);
        this.frr = null;
        this.gzM = a.e(context, 14.0f);
        this.gzN = -1;
        this.gzO = false;
        this.gzP = a.f(context, 20.0f);
        this.gzQ = false;
        this.gzR = Color.parseColor("#22000000");
        this.gzS = false;
        this.gzT = false;
        this.gzU = false;
        this.gzt = new TextPaint();
        this.gzt.setAntiAlias(true);
        this.gAf = a.f(context, 4.0f);
        this.gAg = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gAh = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bnx();
        bnw();
    }

    private void bnw() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gzu;
        options.outHeight = this.gzu;
        this.gzk = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gzl = Bitmap.createBitmap(this.gzk, 0, 0, this.gzk.getWidth(), this.gzk.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gzm = Bitmap.createBitmap(this.gzk, 0, 0, this.gzk.getWidth(), this.gzk.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gzn = Bitmap.createBitmap(this.gzk, 0, 0, this.gzk.getWidth(), this.gzk.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.bDP = typedArray.getDimensionPixelSize(i, this.bDP);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.gzv = typedArray.getDimensionPixelSize(i, this.gzv);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.gzu = typedArray.getDimensionPixelSize(i, this.gzu);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.gzz = typedArray.getDimensionPixelSize(i, this.gzz);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.gzw = typedArray.getDimensionPixelSize(i, this.gzw);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.bav = typedArray.getColor(i, this.bav);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.gzA = typedArray.getColor(i, this.gzA);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.gzB = typedArray.getDimensionPixelSize(i, this.gzB);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gzC = typedArray.getBoolean(i, this.gzC);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gzD = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.gzF = typedArray.getDimensionPixelSize(i, this.gzF);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.gzG = typedArray.getInteger(i, this.gzG);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.gzH = typedArray.getBoolean(i, this.gzH);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.gzI = typedArray.getDimensionPixelSize(i, this.gzI);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gzy = typedArray.getDimensionPixelSize(i, this.gzy);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.gzJ = typedArray.getBoolean(i, this.gzJ);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.gzL = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gzK = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.gzM = typedArray.getDimensionPixelSize(i, this.gzM);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.gzN = typedArray.getColor(i, this.gzN);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gzO = typedArray.getBoolean(i, this.gzO);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.gzP = typedArray.getDimensionPixelSize(i, this.gzP);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gzQ = typedArray.getBoolean(i, this.gzQ);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gzS = typedArray.getBoolean(i, this.gzS);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gzR = typedArray.getColor(i, this.gzR);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gzT = typedArray.getBoolean(i, this.gzT);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gzU = typedArray.getBoolean(i, this.gzU);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gzV = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gAg = typedArray.getBoolean(i, this.gAg);
        }
    }

    private void bnx() {
        if (this.gzV != null) {
            this.gAb = ((BitmapDrawable) this.gzV).getBitmap();
        }
        if (this.gAb == null) {
            this.gAb = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gAb = a.f(this.gAb, this.gzA);
        }
        this.gAc = a.e(this.gAb, 90);
        this.gAc = a.e(this.gAc, 90);
        this.gAc = a.e(this.gAc, 90);
        if (this.gzD != null) {
            this.gzZ = ((BitmapDrawable) this.gzD).getBitmap();
        }
        if (this.gzZ == null) {
            this.gzZ = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gzZ = a.f(this.gzZ, this.gzA);
        }
        this.gAa = a.e(this.gzZ, 90);
        this.gAd = (1.0f * this.gzv) / 2.0f;
        this.gzt.setTextSize(this.gzM);
        this.gzt.setColor(this.gzN);
        setIsBarcode(this.gzJ);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gzq != null) {
            C(canvas);
            D(canvas);
            F(canvas);
            G(canvas);
            E(canvas);
            bny();
        }
    }

    private void C(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bav != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bav);
            canvas.drawRect(0.0f, 0.0f, width, this.gzq.top, this.mPaint);
            canvas.drawRect(0.0f, this.gzq.top, this.gzq.left, this.gzq.bottom + 1, this.mPaint);
            canvas.drawRect(this.gzq.right + 1, this.gzq.top, width, this.gzq.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gzq.bottom + 1, width, height, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.gzF > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gzF);
            canvas.drawRect(this.gzq, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gzk, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzl, getMainFrameRight() - this.gzk.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzm, getMainFrameLeft(), getMainFrameBottom() - this.gzk.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gzn, getMainFrameRight() - this.gzk.getWidth(), getMainFrameBottom() - this.gzk.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gzq.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gzq.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gzq.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gzq.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gzF / 2;
    }

    private void F(Canvas canvas) {
        if (this.gzJ) {
            if (this.gzW != null) {
                RectF rectF = new RectF(this.gzq.left + this.gAd + 0.5f, this.gzq.top + this.gAd + this.gzB, this.gzY, (this.gzq.bottom - this.gAd) - this.gzB);
                Rect rect = new Rect((int) (this.gzW.getWidth() - rectF.width()), 0, this.gzW.getWidth(), this.gzW.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gzW, rect, rectF, this.mPaint);
            } else if (this.gzE != null) {
                canvas.drawBitmap(this.gzE, (Rect) null, new RectF(this.gzs, this.gzq.top + this.gAd + this.gzB, this.gzs + this.gzE.getWidth(), (this.gzq.bottom - this.gAd) - this.gzB), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gzA);
                canvas.drawRect(this.gzs, this.gzB + this.gzq.top + this.gAd, this.gzz + this.gzs, (this.gzq.bottom - this.gAd) - this.gzB, this.mPaint);
            }
        } else if (this.gzW != null) {
            RectF rectF2 = new RectF(this.gzq.left + this.gAd + this.gzB, this.gzq.top + this.gAd + 0.5f, (this.gzq.right - this.gAd) - this.gzB, this.gzX);
            Rect rect2 = new Rect(0, (int) (this.gzW.getHeight() - rectF2.height()), this.gzW.getWidth(), this.gzW.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gAh);
            canvas.drawBitmap(this.gzW, rect2, rectF2, this.mPaint);
        } else if (this.gzE != null) {
            canvas.drawBitmap(this.gzE, (Rect) null, new RectF(this.gzq.left + this.gAd + this.gzB, this.gzr, (this.gzq.right - this.gAd) - this.gzB, this.gzr + this.gzE.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gzA);
            canvas.drawRect(this.gzB + this.gzq.left + this.gAd, this.gzr, (this.gzq.right - this.gAd) - this.gzB, this.gzz + this.gzr, this.mPaint);
        }
    }

    private void G(Canvas canvas) {
        if (!TextUtils.isEmpty(this.frr) && this.gAe != null) {
            if (this.gzO) {
                if (this.gzS) {
                    this.mPaint.setColor(this.gzR);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gzQ) {
                        Rect rect = new Rect();
                        this.gzt.getTextBounds(this.frr, 0, this.frr.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gAf;
                        canvas.drawRoundRect(new RectF(width, (this.gzq.bottom + this.gzP) - this.gAf, rect.width() + width + (this.gAf * 2), this.gzq.bottom + this.gzP + this.gAe.getHeight() + this.gAf), this.gAf, this.gAf, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gzq.left, (this.gzq.bottom + this.gzP) - this.gAf, this.gzq.right, this.gzq.bottom + this.gzP + this.gAe.getHeight() + this.gAf), this.gAf, this.gAf, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gzQ) {
                    canvas.translate(0.0f, this.gzq.bottom + this.gzP);
                } else {
                    canvas.translate(this.gzq.left + this.gAf, this.gzq.bottom + this.gzP);
                }
                this.gAe.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gzS) {
                this.mPaint.setColor(this.gzR);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gzQ) {
                    Rect rect2 = new Rect();
                    this.gzt.getTextBounds(this.frr, 0, this.frr.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gAf;
                    canvas.drawRoundRect(new RectF(width2, ((this.gzq.top - this.gzP) - this.gAe.getHeight()) - this.gAf, rect2.width() + width2 + (this.gAf * 2), (this.gzq.top - this.gzP) + this.gAf), this.gAf, this.gAf, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gzq.left, ((this.gzq.top - this.gzP) - this.gAe.getHeight()) - this.gAf, this.gzq.right, (this.gzq.top - this.gzP) + this.gAf), this.gAf, this.gAf, this.mPaint);
                }
            }
            canvas.save();
            if (this.gzQ) {
                canvas.translate(0.0f, (this.gzq.top - this.gzP) - this.gAe.getHeight());
            } else {
                canvas.translate(this.gzq.left + this.gAf, (this.gzq.top - this.gzP) - this.gAe.getHeight());
            }
            this.gAe.draw(canvas);
            canvas.restore();
        }
    }

    private void bny() {
        if (this.gzJ) {
            if (this.gzW == null) {
                this.gzs += this.gzo;
                int i = this.gzz;
                if (this.gzE != null) {
                    i = this.gzE.getWidth();
                }
                if (this.gzT) {
                    if (i + this.gzs > this.gzq.right - this.gAd || this.gzs < this.gzq.left + this.gAd) {
                        this.gzo = -this.gzo;
                    }
                } else {
                    if (i + this.gzs > this.gzq.right - this.gAd) {
                        this.gzs = this.gzq.left + this.gAd + 0.5f;
                    }
                }
            } else {
                this.gzY += this.gzo;
                if (this.gzY > this.gzq.right - this.gAd) {
                    this.gzY = this.gzq.left + this.gAd + 0.5f;
                }
            }
        } else if (this.gzW == null) {
            this.gzr += this.gzo;
            int i2 = this.gzz;
            if (this.gzE != null) {
                i2 = this.gzE.getHeight();
            }
            if (this.gzT) {
                if (i2 + this.gzr > this.gzq.bottom - this.gAd || this.gzr < this.gzq.top + this.gAd) {
                    this.gzo = -this.gzo;
                }
            } else {
                if (i2 + this.gzr > this.gzq.bottom - this.gAd) {
                    this.gzr = this.gzq.top + this.gAd + 0.5f;
                }
            }
        } else {
            this.gzX += this.gzo;
            if (this.gzX > this.gzq.bottom - this.gAd) {
                this.gzX = this.gzq.top + this.gAd + 0.5f;
            }
        }
        postInvalidateDelayed(this.gzp, this.gzq.left, this.gzq.top, this.gzq.right, this.gzq.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bnz();
    }

    private void bnz() {
        int i = this.bDP + this.gzI;
        int width = (getWidth() - this.gzw) / 2;
        this.gzq = new Rect(width, i, this.gzw + width, this.gzx + i);
        if (this.gzJ) {
            float f = this.gzq.left + this.gAd + 0.5f;
            this.gzs = f;
            this.gzY = f;
            return;
        }
        float f2 = this.gzq.top + this.gAd + 0.5f;
        this.gzr = f2;
        this.gzX = f2;
    }

    public Rect um(int i) {
        if (this.gAg) {
            Rect rect = new Rect(this.gzq);
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
        this.gzJ = z;
        if (this.gzV != null || this.gzU) {
            if (this.gzJ) {
                this.gzW = this.gAc;
            } else {
                this.gzW = this.gAb;
            }
        } else if (this.gzD != null || this.gzC) {
            if (this.gzJ) {
                this.gzE = this.gAa;
            } else {
                this.gzE = this.gzZ;
            }
        }
        if (this.gzJ) {
            this.frr = this.gzL;
            this.gzx = this.gzy;
            this.gzp = (int) (((this.gzG * 1.0f) * this.gzo) / this.gzw);
        } else {
            this.frr = this.gzK;
            this.gzx = this.gzw;
            this.gzp = (int) (((this.gzG * 1.0f) * this.gzo) / this.gzx);
        }
        if (!TextUtils.isEmpty(this.frr)) {
            if (this.gzQ) {
                this.gAe = new StaticLayout(this.frr, this.gzt, a.cd(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gAe = new StaticLayout(this.frr, this.gzt, this.gzw - (this.gAf * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gzH) {
            int i = a.cd(getContext()).y;
            if (this.gzI == 0) {
                this.bDP = (i - this.gzx) / 2;
            } else {
                this.bDP = ((i - this.gzx) / 2) + (this.gzI / 2);
            }
        }
        bnz();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gzJ;
    }

    public int getMaskColor() {
        return this.bav;
    }

    public void setMaskColor(int i) {
        this.bav = i;
    }

    public int getCornerLength() {
        return this.gzu;
    }

    public void setCornerLength(int i) {
        this.gzu = i;
    }

    public int getCornerSize() {
        return this.gzv;
    }

    public void setCornerSize(int i) {
        this.gzv = i;
    }

    public int getRectWidth() {
        return this.gzw;
    }

    public void setRectWidth(int i) {
        this.gzw = i;
    }

    public int getRectHeight() {
        return this.gzx;
    }

    public void setRectHeight(int i) {
        this.gzx = i;
    }

    public int getBarcodeRectHeight() {
        return this.gzy;
    }

    public void setBarcodeRectHeight(int i) {
        this.gzy = i;
    }

    public int getTopOffset() {
        return this.bDP;
    }

    public void setTopOffset(int i) {
        this.bDP = i;
    }

    public int getScanLineSize() {
        return this.gzz;
    }

    public void setScanLineSize(int i) {
        this.gzz = i;
    }

    public int getScanLineColor() {
        return this.gzA;
    }

    public void setScanLineColor(int i) {
        this.gzA = i;
    }

    public int getScanLineMargin() {
        return this.gzB;
    }

    public void setScanLineMargin(int i) {
        this.gzB = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gzC = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gzD;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gzD = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gzE;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gzE = bitmap;
    }

    public int getBorderSize() {
        return this.gzF;
    }

    public void setBorderSize(int i) {
        this.gzF = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gzG;
    }

    public void setAnimTime(int i) {
        this.gzG = i;
    }

    public void setCenterVertical(boolean z) {
        this.gzH = z;
    }

    public int getToolbarHeight() {
        return this.gzI;
    }

    public void setToolbarHeight(int i) {
        this.gzI = i;
    }

    public String getQRCodeTipText() {
        return this.gzK;
    }

    public void setQRCodeTipText(String str) {
        this.gzK = str;
    }

    public String getBarCodeTipText() {
        return this.gzL;
    }

    public void setBarCodeTipText(String str) {
        this.gzL = str;
    }

    public String getTipText() {
        return this.frr;
    }

    public void setTipText(String str) {
        this.frr = str;
    }

    public int getTipTextColor() {
        return this.gzN;
    }

    public void setTipTextColor(int i) {
        this.gzN = i;
    }

    public int getTipTextSize() {
        return this.gzM;
    }

    public void setTipTextSize(int i) {
        this.gzM = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gzO = z;
    }

    public int getTipTextMargin() {
        return this.gzP;
    }

    public void setTipTextMargin(int i) {
        this.gzP = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gzQ = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gzS = z;
    }

    public int getTipBackgroundColor() {
        return this.gzR;
    }

    public void setTipBackgroundColor(int i) {
        this.gzR = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gzT = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gzU = z;
    }

    public float getHalfCornerSize() {
        return this.gAd;
    }

    public void setHalfCornerSize(float f) {
        this.gAd = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gAe;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gAe = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gAf;
    }

    public void setTipBackgroundRadius(int i) {
        this.gAf = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gAg = z;
    }
}
