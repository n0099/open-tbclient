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
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class ScanBoxView extends View {
    private int bQR;
    private String kcS;
    private String lAa;
    private String lAb;
    private int lAc;
    private int lAd;
    private boolean lAe;
    private int lAf;
    private boolean lAg;
    private int lAh;
    private boolean lAi;
    private boolean lAj;
    private boolean lAk;
    private Drawable lAl;
    private Bitmap lAm;
    private float lAn;
    private float lAo;
    private Bitmap lAp;
    private Bitmap lAq;
    private Bitmap lAr;
    private Bitmap lAs;
    private float lAt;
    private StaticLayout lAu;
    private int lAv;
    private boolean lAw;
    private ColorMatrixColorFilter lAx;
    private Bitmap lzB;
    private Bitmap lzC;
    private Bitmap lzD;
    private Bitmap lzE;
    private int lzF;
    private int lzG;
    private Rect lzH;
    private float lzI;
    private float lzJ;
    private TextPaint lzK;
    private int lzL;
    private int lzM;
    private int lzN;
    private int lzO;
    private int lzP;
    private int lzQ;
    private int lzR;
    private boolean lzS;
    private Drawable lzT;
    private Bitmap lzU;
    private int lzV;
    private int lzW;
    private boolean lzX;
    private int lzY;
    private boolean lzZ;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.lzL = a.dp2px(context, 20.0f);
        this.lzM = a.dp2px(context, 3.0f);
        this.lzP = a.dp2px(context, 1.0f);
        this.lzQ = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bQR = a.dp2px(context, 200.0f);
        this.lzO = a.dp2px(context, 140.0f);
        this.lzR = 0;
        this.lzS = false;
        this.lzT = null;
        this.lzU = null;
        this.lzV = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.lzW = 1000;
        this.lzX = false;
        this.lzY = 0;
        this.lzZ = false;
        this.lzF = a.dp2px(context, 2.0f);
        this.kcS = null;
        this.lAc = a.h(context, 14.0f);
        this.lAd = -1;
        this.lAe = false;
        this.lAf = a.dp2px(context, 20.0f);
        this.lAg = false;
        this.lAh = Color.parseColor("#22000000");
        this.lAi = false;
        this.lAj = false;
        this.lAk = false;
        this.lzK = new TextPaint();
        this.lzK.setAntiAlias(true);
        this.lAv = a.dp2px(context, 4.0f);
        this.lAw = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lAx = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dmz();
        dmy();
    }

    private void dmy() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.lzL;
        options.outHeight = this.lzL;
        this.lzB = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.lzC = Bitmap.createBitmap(this.lzB, 0, 0, this.lzB.getWidth(), this.lzB.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lzD = Bitmap.createBitmap(this.lzB, 0, 0, this.lzB.getWidth(), this.lzB.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.lzE = Bitmap.createBitmap(this.lzB, 0, 0, this.lzB.getWidth(), this.lzB.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.lzM = typedArray.getDimensionPixelSize(i, this.lzM);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.lzL = typedArray.getDimensionPixelSize(i, this.lzL);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.lzP = typedArray.getDimensionPixelSize(i, this.lzP);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.bQR = typedArray.getDimensionPixelSize(i, this.bQR);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.lzQ = typedArray.getColor(i, this.lzQ);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.lzR = typedArray.getDimensionPixelSize(i, this.lzR);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.lzS = typedArray.getBoolean(i, this.lzS);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.lzT = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.lzV = typedArray.getDimensionPixelSize(i, this.lzV);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.lzW = typedArray.getInteger(i, this.lzW);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.lzX = typedArray.getBoolean(i, this.lzX);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.lzY = typedArray.getDimensionPixelSize(i, this.lzY);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.lzO = typedArray.getDimensionPixelSize(i, this.lzO);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.lzZ = typedArray.getBoolean(i, this.lzZ);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.lAb = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.lAa = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.lAc = typedArray.getDimensionPixelSize(i, this.lAc);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.lAd = typedArray.getColor(i, this.lAd);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.lAe = typedArray.getBoolean(i, this.lAe);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.lAf = typedArray.getDimensionPixelSize(i, this.lAf);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.lAg = typedArray.getBoolean(i, this.lAg);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.lAi = typedArray.getBoolean(i, this.lAi);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.lAh = typedArray.getColor(i, this.lAh);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.lAj = typedArray.getBoolean(i, this.lAj);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.lAk = typedArray.getBoolean(i, this.lAk);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.lAl = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lAw = typedArray.getBoolean(i, this.lAw);
        }
    }

    private void dmz() {
        if (this.lAl != null) {
            this.lAr = ((BitmapDrawable) this.lAl).getBitmap();
        }
        if (this.lAr == null) {
            this.lAr = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lAr = a.g(this.lAr, this.lzQ);
        }
        this.lAs = a.f(this.lAr, 90);
        this.lAs = a.f(this.lAs, 90);
        this.lAs = a.f(this.lAs, 90);
        if (this.lzT != null) {
            this.lAp = ((BitmapDrawable) this.lzT).getBitmap();
        }
        if (this.lAp == null) {
            this.lAp = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lAp = a.g(this.lAp, this.lzQ);
        }
        this.lAq = a.f(this.lAp, 90);
        this.lAt = (1.0f * this.lzM) / 2.0f;
        this.lzK.setTextSize(this.lAc);
        this.lzK.setColor(this.lAd);
        setIsBarcode(this.lzZ);
    }

    public void dmA() {
        this.lzK.setColor(this.lAd);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lzH != null) {
            ae(canvas);
            af(canvas);
            ah(canvas);
            ai(canvas);
            ag(canvas);
            dmB();
        }
    }

    private void ae(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.lzH.top, this.mPaint);
            canvas.drawRect(0.0f, this.lzH.top, this.lzH.left, this.lzH.bottom + 1, this.mPaint);
            canvas.drawRect(this.lzH.right + 1, this.lzH.top, width, this.lzH.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.lzH.bottom + 1, width, height, this.mPaint);
        }
    }

    private void af(Canvas canvas) {
        if (this.lzV > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.lzV);
            canvas.drawRect(this.lzH, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lzB, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lzC, getMainFrameRight() - this.lzB.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lzD, getMainFrameLeft(), getMainFrameBottom() - this.lzB.getHeight(), this.mPaint);
        canvas.drawBitmap(this.lzE, getMainFrameRight() - this.lzB.getWidth(), getMainFrameBottom() - this.lzB.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.lzH.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.lzH.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.lzH.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.lzH.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.lzV / 2;
    }

    private void ah(Canvas canvas) {
        if (this.lzZ) {
            if (this.lAm != null) {
                RectF rectF = new RectF(this.lzH.left + this.lAt + 0.5f, this.lzH.top + this.lAt + this.lzR, this.lAo, (this.lzH.bottom - this.lAt) - this.lzR);
                Rect rect = new Rect((int) (this.lAm.getWidth() - rectF.width()), 0, this.lAm.getWidth(), this.lAm.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.lAm, rect, rectF, this.mPaint);
            } else if (this.lzU != null) {
                canvas.drawBitmap(this.lzU, (Rect) null, new RectF(this.lzJ, this.lzH.top + this.lAt + this.lzR, this.lzJ + this.lzU.getWidth(), (this.lzH.bottom - this.lAt) - this.lzR), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lzQ);
                canvas.drawRect(this.lzJ, this.lzR + this.lzH.top + this.lAt, this.lzP + this.lzJ, (this.lzH.bottom - this.lAt) - this.lzR, this.mPaint);
            }
        } else if (this.lAm != null) {
            RectF rectF2 = new RectF(this.lzH.left + this.lAt + this.lzR, this.lzH.top + this.lAt + 0.5f, (this.lzH.right - this.lAt) - this.lzR, this.lAn);
            Rect rect2 = new Rect(0, (int) (this.lAm.getHeight() - rectF2.height()), this.lAm.getWidth(), this.lAm.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lAx);
            canvas.drawBitmap(this.lAm, rect2, rectF2, this.mPaint);
        } else if (this.lzU != null) {
            canvas.drawBitmap(this.lzU, (Rect) null, new RectF(this.lzH.left + this.lAt + this.lzR, this.lzI, (this.lzH.right - this.lAt) - this.lzR, this.lzI + this.lzU.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.lzQ);
            canvas.drawRect(this.lzR + this.lzH.left + this.lAt, this.lzI, (this.lzH.right - this.lAt) - this.lzR, this.lzP + this.lzI, this.mPaint);
        }
    }

    private void ai(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kcS) && this.lAu != null) {
            if (this.lAe) {
                if (this.lAi) {
                    this.mPaint.setColor(this.lAh);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.lAg) {
                        Rect rect = new Rect();
                        this.lzK.getTextBounds(this.kcS, 0, this.kcS.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lAv;
                        canvas.drawRoundRect(new RectF(width, (this.lzH.bottom + this.lAf) - this.lAv, rect.width() + width + (this.lAv * 2), this.lzH.bottom + this.lAf + this.lAu.getHeight() + this.lAv), this.lAv, this.lAv, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.lzH.left, (this.lzH.bottom + this.lAf) - this.lAv, this.lzH.right, this.lzH.bottom + this.lAf + this.lAu.getHeight() + this.lAv), this.lAv, this.lAv, this.mPaint);
                    }
                }
                canvas.save();
                if (this.lAg) {
                    canvas.translate(0.0f, this.lzH.bottom + this.lAf);
                } else {
                    canvas.translate(this.lzH.left + this.lAv, this.lzH.bottom + this.lAf);
                }
                this.lAu.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.lAi) {
                this.mPaint.setColor(this.lAh);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.lAg) {
                    Rect rect2 = new Rect();
                    this.lzK.getTextBounds(this.kcS, 0, this.kcS.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lAv;
                    canvas.drawRoundRect(new RectF(width2, ((this.lzH.top - this.lAf) - this.lAu.getHeight()) - this.lAv, rect2.width() + width2 + (this.lAv * 2), (this.lzH.top - this.lAf) + this.lAv), this.lAv, this.lAv, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.lzH.left, ((this.lzH.top - this.lAf) - this.lAu.getHeight()) - this.lAv, this.lzH.right, (this.lzH.top - this.lAf) + this.lAv), this.lAv, this.lAv, this.mPaint);
                }
            }
            canvas.save();
            if (this.lAg) {
                canvas.translate(0.0f, (this.lzH.top - this.lAf) - this.lAu.getHeight());
            } else {
                canvas.translate(this.lzH.left + this.lAv, (this.lzH.top - this.lAf) - this.lAu.getHeight());
            }
            this.lAu.draw(canvas);
            canvas.restore();
        }
    }

    private void dmB() {
        if (this.lzZ) {
            if (this.lAm == null) {
                this.lzJ += this.lzF;
                int i = this.lzP;
                if (this.lzU != null) {
                    i = this.lzU.getWidth();
                }
                if (this.lAj) {
                    if (i + this.lzJ > this.lzH.right - this.lAt || this.lzJ < this.lzH.left + this.lAt) {
                        this.lzF = -this.lzF;
                    }
                } else {
                    if (i + this.lzJ > this.lzH.right - this.lAt) {
                        this.lzJ = this.lzH.left + this.lAt + 0.5f;
                    }
                }
            } else {
                this.lAo += this.lzF;
                if (this.lAo > this.lzH.right - this.lAt) {
                    this.lAo = this.lzH.left + this.lAt + 0.5f;
                }
            }
        } else if (this.lAm == null) {
            this.lzI += this.lzF;
            int i2 = this.lzP;
            if (this.lzU != null) {
                i2 = this.lzU.getHeight();
            }
            if (this.lAj) {
                if (i2 + this.lzI > this.lzH.bottom - this.lAt || this.lzI < this.lzH.top + this.lAt) {
                    this.lzF = -this.lzF;
                }
            } else {
                if (i2 + this.lzI > this.lzH.bottom - this.lAt) {
                    this.lzI = this.lzH.top + this.lAt + 0.5f;
                }
            }
        } else {
            this.lAn += this.lzF;
            if (this.lAn > this.lzH.bottom - this.lAt) {
                this.lAn = this.lzH.top + this.lAt + 0.5f;
            }
        }
        postInvalidateDelayed(this.lzG, this.lzH.left, this.lzH.top, this.lzH.right, this.lzH.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dmC();
    }

    private void dmC() {
        int i;
        if (this.lzZ) {
            i = this.mTopOffset + this.lzY;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bQR) / 2;
        this.lzH = new Rect(width, i, this.bQR + width, this.lzN + i);
        if (this.lzZ) {
            float f = this.lzH.left + this.lAt + 0.5f;
            this.lzJ = f;
            this.lAo = f;
            return;
        }
        float f2 = this.lzH.top + this.lAt + 0.5f;
        this.lzI = f2;
        this.lAn = f2;
    }

    public Rect FZ(int i) {
        if (this.lAw) {
            Rect rect = new Rect(this.lzH);
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
        this.lzZ = z;
        if (this.lAl != null || this.lAk) {
            if (this.lzZ) {
                this.lAm = this.lAs;
            } else {
                this.lAm = this.lAr;
            }
        } else if (this.lzT != null || this.lzS) {
            if (this.lzZ) {
                this.lzU = this.lAq;
            } else {
                this.lzU = this.lAp;
            }
        }
        if (this.lzZ) {
            this.kcS = this.lAb;
            this.lzN = this.lzO;
            this.lzG = (int) (((this.lzW * 1.0f) * this.lzF) / this.bQR);
        } else {
            this.kcS = this.lAa;
            this.lzN = this.bQR;
            this.lzG = (int) (((this.lzW * 1.0f) * this.lzF) / this.lzN);
        }
        if (!TextUtils.isEmpty(this.kcS)) {
            if (this.lAg) {
                this.lAu = new StaticLayout(this.kcS, this.lzK, a.fx(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lAu = new StaticLayout(this.kcS, this.lzK, this.bQR - (this.lAv * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.lzX) {
            int i = a.fx(getContext()).y;
            if (this.lzY == 0) {
                this.mTopOffset = (i - this.lzN) / 2;
            } else if (this.lzZ) {
                this.mTopOffset = ((i - this.lzN) / 2) + (this.lzY / 2);
            } else {
                this.mTopOffset = (i - this.lzN) / 2;
            }
        }
        dmC();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.lzZ;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.lzL;
    }

    public void setCornerLength(int i) {
        this.lzL = i;
    }

    public int getCornerSize() {
        return this.lzM;
    }

    public void setCornerSize(int i) {
        this.lzM = i;
    }

    public int getRectWidth() {
        return this.bQR;
    }

    public void setRectWidth(int i) {
        this.bQR = i;
    }

    public int getRectHeight() {
        return this.lzN;
    }

    public void setRectHeight(int i) {
        this.lzN = i;
    }

    public int getBarcodeRectHeight() {
        return this.lzO;
    }

    public void setBarcodeRectHeight(int i) {
        this.lzO = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lzP;
    }

    public void setScanLineSize(int i) {
        this.lzP = i;
    }

    public int getScanLineColor() {
        return this.lzQ;
    }

    public void setScanLineColor(int i) {
        this.lzQ = i;
    }

    public int getScanLineMargin() {
        return this.lzR;
    }

    public void setScanLineMargin(int i) {
        this.lzR = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.lzS = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.lzT;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.lzT = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.lzU;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.lzU = bitmap;
    }

    public int getBorderSize() {
        return this.lzV;
    }

    public void setBorderSize(int i) {
        this.lzV = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.lzW;
    }

    public void setAnimTime(int i) {
        this.lzW = i;
    }

    public void setCenterVertical(boolean z) {
        this.lzX = z;
    }

    public int getToolbarHeight() {
        return this.lzY;
    }

    public void setToolbarHeight(int i) {
        this.lzY = i;
    }

    public String getQRCodeTipText() {
        return this.lAa;
    }

    public void setQRCodeTipText(String str) {
        this.lAa = str;
    }

    public String getBarCodeTipText() {
        return this.lAb;
    }

    public void setBarCodeTipText(String str) {
        this.lAb = str;
    }

    public String getTipText() {
        return this.kcS;
    }

    public void setTipText(String str) {
        this.kcS = str;
    }

    public int getTipTextColor() {
        return this.lAd;
    }

    public void setTipTextColor(int i) {
        this.lAd = i;
    }

    public int getTipTextSize() {
        return this.lAc;
    }

    public void setTipTextSize(int i) {
        this.lAc = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.lAe = z;
    }

    public int getTipTextMargin() {
        return this.lAf;
    }

    public void setTipTextMargin(int i) {
        this.lAf = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.lAg = z;
    }

    public void setShowTipBackground(boolean z) {
        this.lAi = z;
    }

    public int getTipBackgroundColor() {
        return this.lAh;
    }

    public void setTipBackgroundColor(int i) {
        this.lAh = i;
    }

    public void setScanLineReverse(boolean z) {
        this.lAj = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.lAk = z;
    }

    public float getHalfCornerSize() {
        return this.lAt;
    }

    public void setHalfCornerSize(float f) {
        this.lAt = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lAu;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lAu = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lAv;
    }

    public void setTipBackgroundRadius(int i) {
        this.lAv = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lAw = z;
    }
}
