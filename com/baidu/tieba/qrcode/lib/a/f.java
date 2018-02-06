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
    private int apu;
    private int bEc;
    private int baH;
    private String frE;
    private int gAa;
    private boolean gAb;
    private int gAc;
    private boolean gAd;
    private boolean gAe;
    private boolean gAf;
    private Drawable gAg;
    private Bitmap gAh;
    private float gAi;
    private float gAj;
    private Bitmap gAk;
    private Bitmap gAl;
    private Bitmap gAm;
    private Bitmap gAn;
    private float gAo;
    private StaticLayout gAp;
    private int gAq;
    private boolean gAr;
    private ColorMatrixColorFilter gAs;
    private int gzA;
    private Rect gzB;
    private float gzC;
    private float gzD;
    private TextPaint gzE;
    private int gzF;
    private int gzG;
    private int gzH;
    private int gzI;
    private int gzJ;
    private int gzK;
    private int gzL;
    private int gzM;
    private boolean gzN;
    private Drawable gzO;
    private Bitmap gzP;
    private int gzQ;
    private int gzR;
    private boolean gzS;
    private int gzT;
    private boolean gzU;
    private String gzV;
    private String gzW;
    private int gzX;
    private int gzY;
    private boolean gzZ;
    private Bitmap gzv;
    private Bitmap gzw;
    private Bitmap gzx;
    private Bitmap gzy;
    private int gzz;
    private Context mContext;
    private Paint mPaint;

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.baH = Color.parseColor("#33FFFFFF");
        this.gzF = a.f(context, 20.0f);
        this.gzG = a.f(context, 3.0f);
        this.gzK = a.f(context, 1.0f);
        this.gzL = -1;
        this.bEc = a.f(context, 90.0f);
        this.gzH = a.f(context, 200.0f);
        this.gzJ = a.f(context, 140.0f);
        this.gzM = 0;
        this.gzN = false;
        this.gzO = null;
        this.gzP = null;
        this.gzQ = a.f(context, 1.0f);
        this.apu = -1;
        this.gzR = 1000;
        this.gzS = false;
        this.gzT = 0;
        this.gzU = false;
        this.gzz = a.f(context, 2.0f);
        this.frE = null;
        this.gzX = a.e(context, 14.0f);
        this.gzY = -1;
        this.gzZ = false;
        this.gAa = a.f(context, 20.0f);
        this.gAb = false;
        this.gAc = Color.parseColor("#22000000");
        this.gAd = false;
        this.gAe = false;
        this.gAf = false;
        this.gzE = new TextPaint();
        this.gzE.setAntiAlias(true);
        this.gAq = a.f(context, 4.0f);
        this.gAr = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gAs = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.gzF;
        options.outHeight = this.gzF;
        this.gzv = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gzw = Bitmap.createBitmap(this.gzv, 0, 0, this.gzv.getWidth(), this.gzv.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gzx = Bitmap.createBitmap(this.gzv, 0, 0, this.gzv.getWidth(), this.gzv.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gzy = Bitmap.createBitmap(this.gzv, 0, 0, this.gzv.getWidth(), this.gzv.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.bEc = typedArray.getDimensionPixelSize(i, this.bEc);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.gzG = typedArray.getDimensionPixelSize(i, this.gzG);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.gzF = typedArray.getDimensionPixelSize(i, this.gzF);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.gzK = typedArray.getDimensionPixelSize(i, this.gzK);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.gzH = typedArray.getDimensionPixelSize(i, this.gzH);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.baH = typedArray.getColor(i, this.baH);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.gzL = typedArray.getColor(i, this.gzL);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.gzM = typedArray.getDimensionPixelSize(i, this.gzM);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gzN = typedArray.getBoolean(i, this.gzN);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gzO = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.gzQ = typedArray.getDimensionPixelSize(i, this.gzQ);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.apu = typedArray.getColor(i, this.apu);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.gzR = typedArray.getInteger(i, this.gzR);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.gzS = typedArray.getBoolean(i, this.gzS);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.gzT = typedArray.getDimensionPixelSize(i, this.gzT);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gzJ = typedArray.getDimensionPixelSize(i, this.gzJ);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.gzU = typedArray.getBoolean(i, this.gzU);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.gzW = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gzV = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.gzX = typedArray.getDimensionPixelSize(i, this.gzX);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.gzY = typedArray.getColor(i, this.gzY);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gzZ = typedArray.getBoolean(i, this.gzZ);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.gAa = typedArray.getDimensionPixelSize(i, this.gAa);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gAb = typedArray.getBoolean(i, this.gAb);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gAd = typedArray.getBoolean(i, this.gAd);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gAc = typedArray.getColor(i, this.gAc);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gAe = typedArray.getBoolean(i, this.gAe);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gAf = typedArray.getBoolean(i, this.gAf);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gAg = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gAr = typedArray.getBoolean(i, this.gAr);
        }
    }

    private void bny() {
        if (this.gAg != null) {
            this.gAm = ((BitmapDrawable) this.gAg).getBitmap();
        }
        if (this.gAm == null) {
            this.gAm = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gAm = a.f(this.gAm, this.gzL);
        }
        this.gAn = a.e(this.gAm, 90);
        this.gAn = a.e(this.gAn, 90);
        this.gAn = a.e(this.gAn, 90);
        if (this.gzO != null) {
            this.gAk = ((BitmapDrawable) this.gzO).getBitmap();
        }
        if (this.gAk == null) {
            this.gAk = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.gAk = a.f(this.gAk, this.gzL);
        }
        this.gAl = a.e(this.gAk, 90);
        this.gAo = (1.0f * this.gzG) / 2.0f;
        this.gzE.setTextSize(this.gzX);
        this.gzE.setColor(this.gzY);
        setIsBarcode(this.gzU);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gzB != null) {
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
        if (this.baH != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.baH);
            canvas.drawRect(0.0f, 0.0f, width, this.gzB.top, this.mPaint);
            canvas.drawRect(0.0f, this.gzB.top, this.gzB.left, this.gzB.bottom + 1, this.mPaint);
            canvas.drawRect(this.gzB.right + 1, this.gzB.top, width, this.gzB.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gzB.bottom + 1, width, height, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.gzQ > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.apu);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gzQ);
            canvas.drawRect(this.gzB, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gzv, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzw, getMainFrameRight() - this.gzv.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gzx, getMainFrameLeft(), getMainFrameBottom() - this.gzv.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gzy, getMainFrameRight() - this.gzv.getWidth(), getMainFrameBottom() - this.gzv.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gzB.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gzB.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gzB.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gzB.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gzQ / 2;
    }

    private void F(Canvas canvas) {
        if (this.gzU) {
            if (this.gAh != null) {
                RectF rectF = new RectF(this.gzB.left + this.gAo + 0.5f, this.gzB.top + this.gAo + this.gzM, this.gAj, (this.gzB.bottom - this.gAo) - this.gzM);
                Rect rect = new Rect((int) (this.gAh.getWidth() - rectF.width()), 0, this.gAh.getWidth(), this.gAh.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gAh, rect, rectF, this.mPaint);
            } else if (this.gzP != null) {
                canvas.drawBitmap(this.gzP, (Rect) null, new RectF(this.gzD, this.gzB.top + this.gAo + this.gzM, this.gzD + this.gzP.getWidth(), (this.gzB.bottom - this.gAo) - this.gzM), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gzL);
                canvas.drawRect(this.gzD, this.gzM + this.gzB.top + this.gAo, this.gzK + this.gzD, (this.gzB.bottom - this.gAo) - this.gzM, this.mPaint);
            }
        } else if (this.gAh != null) {
            RectF rectF2 = new RectF(this.gzB.left + this.gAo + this.gzM, this.gzB.top + this.gAo + 0.5f, (this.gzB.right - this.gAo) - this.gzM, this.gAi);
            Rect rect2 = new Rect(0, (int) (this.gAh.getHeight() - rectF2.height()), this.gAh.getWidth(), this.gAh.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gAs);
            canvas.drawBitmap(this.gAh, rect2, rectF2, this.mPaint);
        } else if (this.gzP != null) {
            canvas.drawBitmap(this.gzP, (Rect) null, new RectF(this.gzB.left + this.gAo + this.gzM, this.gzC, (this.gzB.right - this.gAo) - this.gzM, this.gzC + this.gzP.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gzL);
            canvas.drawRect(this.gzM + this.gzB.left + this.gAo, this.gzC, (this.gzB.right - this.gAo) - this.gzM, this.gzK + this.gzC, this.mPaint);
        }
    }

    private void G(Canvas canvas) {
        if (!TextUtils.isEmpty(this.frE) && this.gAp != null) {
            if (this.gzZ) {
                if (this.gAd) {
                    this.mPaint.setColor(this.gAc);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gAb) {
                        Rect rect = new Rect();
                        this.gzE.getTextBounds(this.frE, 0, this.frE.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gAq;
                        canvas.drawRoundRect(new RectF(width, (this.gzB.bottom + this.gAa) - this.gAq, rect.width() + width + (this.gAq * 2), this.gzB.bottom + this.gAa + this.gAp.getHeight() + this.gAq), this.gAq, this.gAq, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gzB.left, (this.gzB.bottom + this.gAa) - this.gAq, this.gzB.right, this.gzB.bottom + this.gAa + this.gAp.getHeight() + this.gAq), this.gAq, this.gAq, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gAb) {
                    canvas.translate(0.0f, this.gzB.bottom + this.gAa);
                } else {
                    canvas.translate(this.gzB.left + this.gAq, this.gzB.bottom + this.gAa);
                }
                this.gAp.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gAd) {
                this.mPaint.setColor(this.gAc);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gAb) {
                    Rect rect2 = new Rect();
                    this.gzE.getTextBounds(this.frE, 0, this.frE.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gAq;
                    canvas.drawRoundRect(new RectF(width2, ((this.gzB.top - this.gAa) - this.gAp.getHeight()) - this.gAq, rect2.width() + width2 + (this.gAq * 2), (this.gzB.top - this.gAa) + this.gAq), this.gAq, this.gAq, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gzB.left, ((this.gzB.top - this.gAa) - this.gAp.getHeight()) - this.gAq, this.gzB.right, (this.gzB.top - this.gAa) + this.gAq), this.gAq, this.gAq, this.mPaint);
                }
            }
            canvas.save();
            if (this.gAb) {
                canvas.translate(0.0f, (this.gzB.top - this.gAa) - this.gAp.getHeight());
            } else {
                canvas.translate(this.gzB.left + this.gAq, (this.gzB.top - this.gAa) - this.gAp.getHeight());
            }
            this.gAp.draw(canvas);
            canvas.restore();
        }
    }

    private void bnz() {
        if (this.gzU) {
            if (this.gAh == null) {
                this.gzD += this.gzz;
                int i = this.gzK;
                if (this.gzP != null) {
                    i = this.gzP.getWidth();
                }
                if (this.gAe) {
                    if (i + this.gzD > this.gzB.right - this.gAo || this.gzD < this.gzB.left + this.gAo) {
                        this.gzz = -this.gzz;
                    }
                } else {
                    if (i + this.gzD > this.gzB.right - this.gAo) {
                        this.gzD = this.gzB.left + this.gAo + 0.5f;
                    }
                }
            } else {
                this.gAj += this.gzz;
                if (this.gAj > this.gzB.right - this.gAo) {
                    this.gAj = this.gzB.left + this.gAo + 0.5f;
                }
            }
        } else if (this.gAh == null) {
            this.gzC += this.gzz;
            int i2 = this.gzK;
            if (this.gzP != null) {
                i2 = this.gzP.getHeight();
            }
            if (this.gAe) {
                if (i2 + this.gzC > this.gzB.bottom - this.gAo || this.gzC < this.gzB.top + this.gAo) {
                    this.gzz = -this.gzz;
                }
            } else {
                if (i2 + this.gzC > this.gzB.bottom - this.gAo) {
                    this.gzC = this.gzB.top + this.gAo + 0.5f;
                }
            }
        } else {
            this.gAi += this.gzz;
            if (this.gAi > this.gzB.bottom - this.gAo) {
                this.gAi = this.gzB.top + this.gAo + 0.5f;
            }
        }
        postInvalidateDelayed(this.gzA, this.gzB.left, this.gzB.top, this.gzB.right, this.gzB.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bnA();
    }

    private void bnA() {
        int i = this.bEc + this.gzT;
        int width = (getWidth() - this.gzH) / 2;
        this.gzB = new Rect(width, i, this.gzH + width, this.gzI + i);
        if (this.gzU) {
            float f = this.gzB.left + this.gAo + 0.5f;
            this.gzD = f;
            this.gAj = f;
            return;
        }
        float f2 = this.gzB.top + this.gAo + 0.5f;
        this.gzC = f2;
        this.gAi = f2;
    }

    public Rect ul(int i) {
        if (this.gAr) {
            Rect rect = new Rect(this.gzB);
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
        this.gzU = z;
        if (this.gAg != null || this.gAf) {
            if (this.gzU) {
                this.gAh = this.gAn;
            } else {
                this.gAh = this.gAm;
            }
        } else if (this.gzO != null || this.gzN) {
            if (this.gzU) {
                this.gzP = this.gAl;
            } else {
                this.gzP = this.gAk;
            }
        }
        if (this.gzU) {
            this.frE = this.gzW;
            this.gzI = this.gzJ;
            this.gzA = (int) (((this.gzR * 1.0f) * this.gzz) / this.gzH);
        } else {
            this.frE = this.gzV;
            this.gzI = this.gzH;
            this.gzA = (int) (((this.gzR * 1.0f) * this.gzz) / this.gzI);
        }
        if (!TextUtils.isEmpty(this.frE)) {
            if (this.gAb) {
                this.gAp = new StaticLayout(this.frE, this.gzE, a.cd(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gAp = new StaticLayout(this.frE, this.gzE, this.gzH - (this.gAq * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gzS) {
            int i = a.cd(getContext()).y;
            if (this.gzT == 0) {
                this.bEc = (i - this.gzI) / 2;
            } else {
                this.bEc = ((i - this.gzI) / 2) + (this.gzT / 2);
            }
        }
        bnA();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gzU;
    }

    public int getMaskColor() {
        return this.baH;
    }

    public void setMaskColor(int i) {
        this.baH = i;
    }

    public int getCornerLength() {
        return this.gzF;
    }

    public void setCornerLength(int i) {
        this.gzF = i;
    }

    public int getCornerSize() {
        return this.gzG;
    }

    public void setCornerSize(int i) {
        this.gzG = i;
    }

    public int getRectWidth() {
        return this.gzH;
    }

    public void setRectWidth(int i) {
        this.gzH = i;
    }

    public int getRectHeight() {
        return this.gzI;
    }

    public void setRectHeight(int i) {
        this.gzI = i;
    }

    public int getBarcodeRectHeight() {
        return this.gzJ;
    }

    public void setBarcodeRectHeight(int i) {
        this.gzJ = i;
    }

    public int getTopOffset() {
        return this.bEc;
    }

    public void setTopOffset(int i) {
        this.bEc = i;
    }

    public int getScanLineSize() {
        return this.gzK;
    }

    public void setScanLineSize(int i) {
        this.gzK = i;
    }

    public int getScanLineColor() {
        return this.gzL;
    }

    public void setScanLineColor(int i) {
        this.gzL = i;
    }

    public int getScanLineMargin() {
        return this.gzM;
    }

    public void setScanLineMargin(int i) {
        this.gzM = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gzN = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gzO;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gzO = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gzP;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gzP = bitmap;
    }

    public int getBorderSize() {
        return this.gzQ;
    }

    public void setBorderSize(int i) {
        this.gzQ = i;
    }

    public int getBorderColor() {
        return this.apu;
    }

    public void setBorderColor(int i) {
        this.apu = i;
    }

    public int getAnimTime() {
        return this.gzR;
    }

    public void setAnimTime(int i) {
        this.gzR = i;
    }

    public void setCenterVertical(boolean z) {
        this.gzS = z;
    }

    public int getToolbarHeight() {
        return this.gzT;
    }

    public void setToolbarHeight(int i) {
        this.gzT = i;
    }

    public String getQRCodeTipText() {
        return this.gzV;
    }

    public void setQRCodeTipText(String str) {
        this.gzV = str;
    }

    public String getBarCodeTipText() {
        return this.gzW;
    }

    public void setBarCodeTipText(String str) {
        this.gzW = str;
    }

    public String getTipText() {
        return this.frE;
    }

    public void setTipText(String str) {
        this.frE = str;
    }

    public int getTipTextColor() {
        return this.gzY;
    }

    public void setTipTextColor(int i) {
        this.gzY = i;
    }

    public int getTipTextSize() {
        return this.gzX;
    }

    public void setTipTextSize(int i) {
        this.gzX = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gzZ = z;
    }

    public int getTipTextMargin() {
        return this.gAa;
    }

    public void setTipTextMargin(int i) {
        this.gAa = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gAb = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gAd = z;
    }

    public int getTipBackgroundColor() {
        return this.gAc;
    }

    public void setTipBackgroundColor(int i) {
        this.gAc = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gAe = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gAf = z;
    }

    public float getHalfCornerSize() {
        return this.gAo;
    }

    public void setHalfCornerSize(float f) {
        this.gAo = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gAp;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gAp = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gAq;
    }

    public void setTipBackgroundRadius(int i) {
        this.gAq = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gAr = z;
    }
}
