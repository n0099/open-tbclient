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
/* loaded from: classes8.dex */
public class ScanBoxView extends View {
    private int cDJ;
    private String lmr;
    private int mBorderColor;
    private Context mContext;
    private Drawable mKA;
    private Bitmap mKB;
    private int mKC;
    private int mKD;
    private boolean mKE;
    private int mKF;
    private boolean mKG;
    private String mKH;
    private String mKI;
    private int mKJ;
    private int mKK;
    private boolean mKL;
    private int mKM;
    private boolean mKN;
    private int mKO;
    private boolean mKP;
    private boolean mKQ;
    private boolean mKR;
    private Drawable mKS;
    private Bitmap mKT;
    private float mKU;
    private float mKV;
    private Bitmap mKW;
    private Bitmap mKX;
    private Bitmap mKY;
    private Bitmap mKZ;
    private Bitmap mKi;
    private Bitmap mKj;
    private Bitmap mKk;
    private Bitmap mKl;
    private int mKm;
    private int mKn;
    private Rect mKo;
    private float mKp;
    private float mKq;
    private TextPaint mKr;
    private int mKs;
    private int mKt;
    private int mKu;
    private int mKv;
    private int mKw;
    private int mKx;
    private int mKy;
    private boolean mKz;
    private float mLa;
    private StaticLayout mLb;
    private int mLc;
    private boolean mLd;
    private ColorMatrixColorFilter mLe;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mKs = a.dp2px(context, 20.0f);
        this.mKt = a.dp2px(context, 3.0f);
        this.mKw = a.dp2px(context, 1.0f);
        this.mKx = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cDJ = a.dp2px(context, 200.0f);
        this.mKv = a.dp2px(context, 140.0f);
        this.mKy = 0;
        this.mKz = false;
        this.mKA = null;
        this.mKB = null;
        this.mKC = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mKD = 1000;
        this.mKE = false;
        this.mKF = 0;
        this.mKG = false;
        this.mKm = a.dp2px(context, 2.0f);
        this.lmr = null;
        this.mKJ = a.h(context, 14.0f);
        this.mKK = -1;
        this.mKL = false;
        this.mKM = a.dp2px(context, 20.0f);
        this.mKN = false;
        this.mKO = Color.parseColor("#22000000");
        this.mKP = false;
        this.mKQ = false;
        this.mKR = false;
        this.mKr = new TextPaint();
        this.mKr.setAntiAlias(true);
        this.mLc = a.dp2px(context, 4.0f);
        this.mLd = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mLe = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dEl();
        dEk();
    }

    private void dEk() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mKs;
        options.outHeight = this.mKs;
        this.mKi = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mKj = Bitmap.createBitmap(this.mKi, 0, 0, this.mKi.getWidth(), this.mKi.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mKk = Bitmap.createBitmap(this.mKi, 0, 0, this.mKi.getWidth(), this.mKi.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mKl = Bitmap.createBitmap(this.mKi, 0, 0, this.mKi.getWidth(), this.mKi.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mKt = typedArray.getDimensionPixelSize(i, this.mKt);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mKs = typedArray.getDimensionPixelSize(i, this.mKs);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mKw = typedArray.getDimensionPixelSize(i, this.mKw);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cDJ = typedArray.getDimensionPixelSize(i, this.cDJ);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mKx = typedArray.getColor(i, this.mKx);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mKy = typedArray.getDimensionPixelSize(i, this.mKy);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mKz = typedArray.getBoolean(i, this.mKz);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mKA = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mKC = typedArray.getDimensionPixelSize(i, this.mKC);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mKD = typedArray.getInteger(i, this.mKD);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mKE = typedArray.getBoolean(i, this.mKE);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mKF = typedArray.getDimensionPixelSize(i, this.mKF);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mKv = typedArray.getDimensionPixelSize(i, this.mKv);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mKG = typedArray.getBoolean(i, this.mKG);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mKI = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mKH = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mKJ = typedArray.getDimensionPixelSize(i, this.mKJ);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mKK = typedArray.getColor(i, this.mKK);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mKL = typedArray.getBoolean(i, this.mKL);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mKM = typedArray.getDimensionPixelSize(i, this.mKM);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mKN = typedArray.getBoolean(i, this.mKN);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mKP = typedArray.getBoolean(i, this.mKP);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mKO = typedArray.getColor(i, this.mKO);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mKQ = typedArray.getBoolean(i, this.mKQ);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mKR = typedArray.getBoolean(i, this.mKR);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mKS = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mLd = typedArray.getBoolean(i, this.mLd);
        }
    }

    private void dEl() {
        if (this.mKS != null) {
            this.mKY = ((BitmapDrawable) this.mKS).getBitmap();
        }
        if (this.mKY == null) {
            this.mKY = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mKY = a.g(this.mKY, this.mKx);
        }
        this.mKZ = a.f(this.mKY, 90);
        this.mKZ = a.f(this.mKZ, 90);
        this.mKZ = a.f(this.mKZ, 90);
        if (this.mKA != null) {
            this.mKW = ((BitmapDrawable) this.mKA).getBitmap();
        }
        if (this.mKW == null) {
            this.mKW = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mKW = a.g(this.mKW, this.mKx);
        }
        this.mKX = a.f(this.mKW, 90);
        this.mLa = (1.0f * this.mKt) / 2.0f;
        this.mKr.setTextSize(this.mKJ);
        this.mKr.setColor(this.mKK);
        setIsBarcode(this.mKG);
    }

    public void dEm() {
        this.mKr.setColor(this.mKK);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mKo != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dEn();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mKo.top, this.mPaint);
            canvas.drawRect(0.0f, this.mKo.top, this.mKo.left, this.mKo.bottom + 1, this.mPaint);
            canvas.drawRect(this.mKo.right + 1, this.mKo.top, width, this.mKo.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mKo.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mKC > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mKC);
            canvas.drawRect(this.mKo, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mKi, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mKj, getMainFrameRight() - this.mKi.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mKk, getMainFrameLeft(), getMainFrameBottom() - this.mKi.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mKl, getMainFrameRight() - this.mKi.getWidth(), getMainFrameBottom() - this.mKi.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mKo.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mKo.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mKo.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mKo.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mKC / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mKG) {
            if (this.mKT != null) {
                RectF rectF = new RectF(this.mKo.left + this.mLa + 0.5f, this.mKo.top + this.mLa + this.mKy, this.mKV, (this.mKo.bottom - this.mLa) - this.mKy);
                Rect rect = new Rect((int) (this.mKT.getWidth() - rectF.width()), 0, this.mKT.getWidth(), this.mKT.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mKT, rect, rectF, this.mPaint);
            } else if (this.mKB != null) {
                canvas.drawBitmap(this.mKB, (Rect) null, new RectF(this.mKq, this.mKo.top + this.mLa + this.mKy, this.mKq + this.mKB.getWidth(), (this.mKo.bottom - this.mLa) - this.mKy), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mKx);
                canvas.drawRect(this.mKq, this.mKy + this.mKo.top + this.mLa, this.mKw + this.mKq, (this.mKo.bottom - this.mLa) - this.mKy, this.mPaint);
            }
        } else if (this.mKT != null) {
            RectF rectF2 = new RectF(this.mKo.left + this.mLa + this.mKy, this.mKo.top + this.mLa + 0.5f, (this.mKo.right - this.mLa) - this.mKy, this.mKU);
            Rect rect2 = new Rect(0, (int) (this.mKT.getHeight() - rectF2.height()), this.mKT.getWidth(), this.mKT.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mLe);
            canvas.drawBitmap(this.mKT, rect2, rectF2, this.mPaint);
        } else if (this.mKB != null) {
            canvas.drawBitmap(this.mKB, (Rect) null, new RectF(this.mKo.left + this.mLa + this.mKy, this.mKp, (this.mKo.right - this.mLa) - this.mKy, this.mKp + this.mKB.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mKx);
            canvas.drawRect(this.mKy + this.mKo.left + this.mLa, this.mKp, (this.mKo.right - this.mLa) - this.mKy, this.mKw + this.mKp, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lmr) && this.mLb != null) {
            if (this.mKL) {
                if (this.mKP) {
                    this.mPaint.setColor(this.mKO);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mKN) {
                        Rect rect = new Rect();
                        this.mKr.getTextBounds(this.lmr, 0, this.lmr.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mLc;
                        canvas.drawRoundRect(new RectF(width, (this.mKo.bottom + this.mKM) - this.mLc, rect.width() + width + (this.mLc * 2), this.mKo.bottom + this.mKM + this.mLb.getHeight() + this.mLc), this.mLc, this.mLc, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mKo.left, (this.mKo.bottom + this.mKM) - this.mLc, this.mKo.right, this.mKo.bottom + this.mKM + this.mLb.getHeight() + this.mLc), this.mLc, this.mLc, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mKN) {
                    canvas.translate(0.0f, this.mKo.bottom + this.mKM);
                } else {
                    canvas.translate(this.mKo.left + this.mLc, this.mKo.bottom + this.mKM);
                }
                this.mLb.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mKP) {
                this.mPaint.setColor(this.mKO);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mKN) {
                    Rect rect2 = new Rect();
                    this.mKr.getTextBounds(this.lmr, 0, this.lmr.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mLc;
                    canvas.drawRoundRect(new RectF(width2, ((this.mKo.top - this.mKM) - this.mLb.getHeight()) - this.mLc, rect2.width() + width2 + (this.mLc * 2), (this.mKo.top - this.mKM) + this.mLc), this.mLc, this.mLc, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mKo.left, ((this.mKo.top - this.mKM) - this.mLb.getHeight()) - this.mLc, this.mKo.right, (this.mKo.top - this.mKM) + this.mLc), this.mLc, this.mLc, this.mPaint);
                }
            }
            canvas.save();
            if (this.mKN) {
                canvas.translate(0.0f, (this.mKo.top - this.mKM) - this.mLb.getHeight());
            } else {
                canvas.translate(this.mKo.left + this.mLc, (this.mKo.top - this.mKM) - this.mLb.getHeight());
            }
            this.mLb.draw(canvas);
            canvas.restore();
        }
    }

    private void dEn() {
        if (this.mKG) {
            if (this.mKT == null) {
                this.mKq += this.mKm;
                int i = this.mKw;
                if (this.mKB != null) {
                    i = this.mKB.getWidth();
                }
                if (this.mKQ) {
                    if (i + this.mKq > this.mKo.right - this.mLa || this.mKq < this.mKo.left + this.mLa) {
                        this.mKm = -this.mKm;
                    }
                } else {
                    if (i + this.mKq > this.mKo.right - this.mLa) {
                        this.mKq = this.mKo.left + this.mLa + 0.5f;
                    }
                }
            } else {
                this.mKV += this.mKm;
                if (this.mKV > this.mKo.right - this.mLa) {
                    this.mKV = this.mKo.left + this.mLa + 0.5f;
                }
            }
        } else if (this.mKT == null) {
            this.mKp += this.mKm;
            int i2 = this.mKw;
            if (this.mKB != null) {
                i2 = this.mKB.getHeight();
            }
            if (this.mKQ) {
                if (i2 + this.mKp > this.mKo.bottom - this.mLa || this.mKp < this.mKo.top + this.mLa) {
                    this.mKm = -this.mKm;
                }
            } else {
                if (i2 + this.mKp > this.mKo.bottom - this.mLa) {
                    this.mKp = this.mKo.top + this.mLa + 0.5f;
                }
            }
        } else {
            this.mKU += this.mKm;
            if (this.mKU > this.mKo.bottom - this.mLa) {
                this.mKU = this.mKo.top + this.mLa + 0.5f;
            }
        }
        postInvalidateDelayed(this.mKn, this.mKo.left, this.mKo.top, this.mKo.right, this.mKo.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dEo();
    }

    private void dEo() {
        int i;
        if (this.mKG) {
            i = this.mTopOffset + this.mKF;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cDJ) / 2;
        this.mKo = new Rect(width, i, this.cDJ + width, this.mKu + i);
        if (this.mKG) {
            float f = this.mKo.left + this.mLa + 0.5f;
            this.mKq = f;
            this.mKV = f;
            return;
        }
        float f2 = this.mKo.top + this.mLa + 0.5f;
        this.mKp = f2;
        this.mKU = f2;
    }

    public Rect IV(int i) {
        if (this.mLd) {
            Rect rect = new Rect(this.mKo);
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
        this.mKG = z;
        if (this.mKS != null || this.mKR) {
            if (this.mKG) {
                this.mKT = this.mKZ;
            } else {
                this.mKT = this.mKY;
            }
        } else if (this.mKA != null || this.mKz) {
            if (this.mKG) {
                this.mKB = this.mKX;
            } else {
                this.mKB = this.mKW;
            }
        }
        if (this.mKG) {
            this.lmr = this.mKI;
            this.mKu = this.mKv;
            this.mKn = (int) (((this.mKD * 1.0f) * this.mKm) / this.cDJ);
        } else {
            this.lmr = this.mKH;
            this.mKu = this.cDJ;
            this.mKn = (int) (((this.mKD * 1.0f) * this.mKm) / this.mKu);
        }
        if (!TextUtils.isEmpty(this.lmr)) {
            if (this.mKN) {
                this.mLb = new StaticLayout(this.lmr, this.mKr, a.gM(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mLb = new StaticLayout(this.lmr, this.mKr, this.cDJ - (this.mLc * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mKE) {
            int i = a.gM(getContext()).y;
            if (this.mKF == 0) {
                this.mTopOffset = (i - this.mKu) / 2;
            } else if (this.mKG) {
                this.mTopOffset = ((i - this.mKu) / 2) + (this.mKF / 2);
            } else {
                this.mTopOffset = (i - this.mKu) / 2;
            }
        }
        dEo();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mKG;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mKs;
    }

    public void setCornerLength(int i) {
        this.mKs = i;
    }

    public int getCornerSize() {
        return this.mKt;
    }

    public void setCornerSize(int i) {
        this.mKt = i;
    }

    public int getRectWidth() {
        return this.cDJ;
    }

    public void setRectWidth(int i) {
        this.cDJ = i;
    }

    public int getRectHeight() {
        return this.mKu;
    }

    public void setRectHeight(int i) {
        this.mKu = i;
    }

    public int getBarcodeRectHeight() {
        return this.mKv;
    }

    public void setBarcodeRectHeight(int i) {
        this.mKv = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mKw;
    }

    public void setScanLineSize(int i) {
        this.mKw = i;
    }

    public int getScanLineColor() {
        return this.mKx;
    }

    public void setScanLineColor(int i) {
        this.mKx = i;
    }

    public int getScanLineMargin() {
        return this.mKy;
    }

    public void setScanLineMargin(int i) {
        this.mKy = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mKz = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mKA;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mKA = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mKB;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mKB = bitmap;
    }

    public int getBorderSize() {
        return this.mKC;
    }

    public void setBorderSize(int i) {
        this.mKC = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mKD;
    }

    public void setAnimTime(int i) {
        this.mKD = i;
    }

    public void setCenterVertical(boolean z) {
        this.mKE = z;
    }

    public int getToolbarHeight() {
        return this.mKF;
    }

    public void setToolbarHeight(int i) {
        this.mKF = i;
    }

    public String getQRCodeTipText() {
        return this.mKH;
    }

    public void setQRCodeTipText(String str) {
        this.mKH = str;
    }

    public String getBarCodeTipText() {
        return this.mKI;
    }

    public void setBarCodeTipText(String str) {
        this.mKI = str;
    }

    public String getTipText() {
        return this.lmr;
    }

    public void setTipText(String str) {
        this.lmr = str;
    }

    public int getTipTextColor() {
        return this.mKK;
    }

    public void setTipTextColor(int i) {
        this.mKK = i;
    }

    public int getTipTextSize() {
        return this.mKJ;
    }

    public void setTipTextSize(int i) {
        this.mKJ = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mKL = z;
    }

    public int getTipTextMargin() {
        return this.mKM;
    }

    public void setTipTextMargin(int i) {
        this.mKM = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mKN = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mKP = z;
    }

    public int getTipBackgroundColor() {
        return this.mKO;
    }

    public void setTipBackgroundColor(int i) {
        this.mKO = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mKQ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mKR = z;
    }

    public float getHalfCornerSize() {
        return this.mLa;
    }

    public void setHalfCornerSize(float f) {
        this.mLa = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mLb;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mLb = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mLc;
    }

    public void setTipBackgroundRadius(int i) {
        this.mLc = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mLd = z;
    }
}
