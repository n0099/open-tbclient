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
    private boolean mKA;
    private Drawable mKB;
    private Bitmap mKC;
    private int mKD;
    private int mKE;
    private boolean mKF;
    private int mKG;
    private boolean mKH;
    private String mKI;
    private String mKJ;
    private int mKK;
    private int mKL;
    private boolean mKM;
    private int mKN;
    private boolean mKO;
    private int mKP;
    private boolean mKQ;
    private boolean mKR;
    private boolean mKS;
    private Drawable mKT;
    private Bitmap mKU;
    private float mKV;
    private float mKW;
    private Bitmap mKX;
    private Bitmap mKY;
    private Bitmap mKZ;
    private Bitmap mKj;
    private Bitmap mKk;
    private Bitmap mKl;
    private Bitmap mKm;
    private int mKn;
    private int mKo;
    private Rect mKp;
    private float mKq;
    private float mKr;
    private TextPaint mKs;
    private int mKt;
    private int mKu;
    private int mKv;
    private int mKw;
    private int mKx;
    private int mKy;
    private int mKz;
    private Bitmap mLa;
    private float mLb;
    private StaticLayout mLc;
    private int mLd;
    private boolean mLe;
    private ColorMatrixColorFilter mLf;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mKt = a.dp2px(context, 20.0f);
        this.mKu = a.dp2px(context, 3.0f);
        this.mKx = a.dp2px(context, 1.0f);
        this.mKy = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cDJ = a.dp2px(context, 200.0f);
        this.mKw = a.dp2px(context, 140.0f);
        this.mKz = 0;
        this.mKA = false;
        this.mKB = null;
        this.mKC = null;
        this.mKD = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mKE = 1000;
        this.mKF = false;
        this.mKG = 0;
        this.mKH = false;
        this.mKn = a.dp2px(context, 2.0f);
        this.lmr = null;
        this.mKK = a.h(context, 14.0f);
        this.mKL = -1;
        this.mKM = false;
        this.mKN = a.dp2px(context, 20.0f);
        this.mKO = false;
        this.mKP = Color.parseColor("#22000000");
        this.mKQ = false;
        this.mKR = false;
        this.mKS = false;
        this.mKs = new TextPaint();
        this.mKs.setAntiAlias(true);
        this.mLd = a.dp2px(context, 4.0f);
        this.mLe = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mLf = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dEk();
        dEj();
    }

    private void dEj() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mKt;
        options.outHeight = this.mKt;
        this.mKj = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mKk = Bitmap.createBitmap(this.mKj, 0, 0, this.mKj.getWidth(), this.mKj.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mKl = Bitmap.createBitmap(this.mKj, 0, 0, this.mKj.getWidth(), this.mKj.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mKm = Bitmap.createBitmap(this.mKj, 0, 0, this.mKj.getWidth(), this.mKj.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mKu = typedArray.getDimensionPixelSize(i, this.mKu);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mKt = typedArray.getDimensionPixelSize(i, this.mKt);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mKx = typedArray.getDimensionPixelSize(i, this.mKx);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cDJ = typedArray.getDimensionPixelSize(i, this.cDJ);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mKy = typedArray.getColor(i, this.mKy);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mKz = typedArray.getDimensionPixelSize(i, this.mKz);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mKA = typedArray.getBoolean(i, this.mKA);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mKB = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mKD = typedArray.getDimensionPixelSize(i, this.mKD);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mKE = typedArray.getInteger(i, this.mKE);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mKF = typedArray.getBoolean(i, this.mKF);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mKG = typedArray.getDimensionPixelSize(i, this.mKG);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mKw = typedArray.getDimensionPixelSize(i, this.mKw);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mKH = typedArray.getBoolean(i, this.mKH);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mKJ = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mKI = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mKK = typedArray.getDimensionPixelSize(i, this.mKK);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mKL = typedArray.getColor(i, this.mKL);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mKM = typedArray.getBoolean(i, this.mKM);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mKN = typedArray.getDimensionPixelSize(i, this.mKN);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mKO = typedArray.getBoolean(i, this.mKO);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mKQ = typedArray.getBoolean(i, this.mKQ);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mKP = typedArray.getColor(i, this.mKP);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mKR = typedArray.getBoolean(i, this.mKR);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mKS = typedArray.getBoolean(i, this.mKS);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mKT = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mLe = typedArray.getBoolean(i, this.mLe);
        }
    }

    private void dEk() {
        if (this.mKT != null) {
            this.mKZ = ((BitmapDrawable) this.mKT).getBitmap();
        }
        if (this.mKZ == null) {
            this.mKZ = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mKZ = a.g(this.mKZ, this.mKy);
        }
        this.mLa = a.f(this.mKZ, 90);
        this.mLa = a.f(this.mLa, 90);
        this.mLa = a.f(this.mLa, 90);
        if (this.mKB != null) {
            this.mKX = ((BitmapDrawable) this.mKB).getBitmap();
        }
        if (this.mKX == null) {
            this.mKX = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mKX = a.g(this.mKX, this.mKy);
        }
        this.mKY = a.f(this.mKX, 90);
        this.mLb = (1.0f * this.mKu) / 2.0f;
        this.mKs.setTextSize(this.mKK);
        this.mKs.setColor(this.mKL);
        setIsBarcode(this.mKH);
    }

    public void dEl() {
        this.mKs.setColor(this.mKL);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mKp != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dEm();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mKp.top, this.mPaint);
            canvas.drawRect(0.0f, this.mKp.top, this.mKp.left, this.mKp.bottom + 1, this.mPaint);
            canvas.drawRect(this.mKp.right + 1, this.mKp.top, width, this.mKp.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mKp.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mKD > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mKD);
            canvas.drawRect(this.mKp, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mKj, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mKk, getMainFrameRight() - this.mKj.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mKl, getMainFrameLeft(), getMainFrameBottom() - this.mKj.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mKm, getMainFrameRight() - this.mKj.getWidth(), getMainFrameBottom() - this.mKj.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mKp.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mKp.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mKp.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mKp.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mKD / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mKH) {
            if (this.mKU != null) {
                RectF rectF = new RectF(this.mKp.left + this.mLb + 0.5f, this.mKp.top + this.mLb + this.mKz, this.mKW, (this.mKp.bottom - this.mLb) - this.mKz);
                Rect rect = new Rect((int) (this.mKU.getWidth() - rectF.width()), 0, this.mKU.getWidth(), this.mKU.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mKU, rect, rectF, this.mPaint);
            } else if (this.mKC != null) {
                canvas.drawBitmap(this.mKC, (Rect) null, new RectF(this.mKr, this.mKp.top + this.mLb + this.mKz, this.mKr + this.mKC.getWidth(), (this.mKp.bottom - this.mLb) - this.mKz), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mKy);
                canvas.drawRect(this.mKr, this.mKz + this.mKp.top + this.mLb, this.mKx + this.mKr, (this.mKp.bottom - this.mLb) - this.mKz, this.mPaint);
            }
        } else if (this.mKU != null) {
            RectF rectF2 = new RectF(this.mKp.left + this.mLb + this.mKz, this.mKp.top + this.mLb + 0.5f, (this.mKp.right - this.mLb) - this.mKz, this.mKV);
            Rect rect2 = new Rect(0, (int) (this.mKU.getHeight() - rectF2.height()), this.mKU.getWidth(), this.mKU.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mLf);
            canvas.drawBitmap(this.mKU, rect2, rectF2, this.mPaint);
        } else if (this.mKC != null) {
            canvas.drawBitmap(this.mKC, (Rect) null, new RectF(this.mKp.left + this.mLb + this.mKz, this.mKq, (this.mKp.right - this.mLb) - this.mKz, this.mKq + this.mKC.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mKy);
            canvas.drawRect(this.mKz + this.mKp.left + this.mLb, this.mKq, (this.mKp.right - this.mLb) - this.mKz, this.mKx + this.mKq, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lmr) && this.mLc != null) {
            if (this.mKM) {
                if (this.mKQ) {
                    this.mPaint.setColor(this.mKP);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mKO) {
                        Rect rect = new Rect();
                        this.mKs.getTextBounds(this.lmr, 0, this.lmr.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mLd;
                        canvas.drawRoundRect(new RectF(width, (this.mKp.bottom + this.mKN) - this.mLd, rect.width() + width + (this.mLd * 2), this.mKp.bottom + this.mKN + this.mLc.getHeight() + this.mLd), this.mLd, this.mLd, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mKp.left, (this.mKp.bottom + this.mKN) - this.mLd, this.mKp.right, this.mKp.bottom + this.mKN + this.mLc.getHeight() + this.mLd), this.mLd, this.mLd, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mKO) {
                    canvas.translate(0.0f, this.mKp.bottom + this.mKN);
                } else {
                    canvas.translate(this.mKp.left + this.mLd, this.mKp.bottom + this.mKN);
                }
                this.mLc.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mKQ) {
                this.mPaint.setColor(this.mKP);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mKO) {
                    Rect rect2 = new Rect();
                    this.mKs.getTextBounds(this.lmr, 0, this.lmr.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mLd;
                    canvas.drawRoundRect(new RectF(width2, ((this.mKp.top - this.mKN) - this.mLc.getHeight()) - this.mLd, rect2.width() + width2 + (this.mLd * 2), (this.mKp.top - this.mKN) + this.mLd), this.mLd, this.mLd, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mKp.left, ((this.mKp.top - this.mKN) - this.mLc.getHeight()) - this.mLd, this.mKp.right, (this.mKp.top - this.mKN) + this.mLd), this.mLd, this.mLd, this.mPaint);
                }
            }
            canvas.save();
            if (this.mKO) {
                canvas.translate(0.0f, (this.mKp.top - this.mKN) - this.mLc.getHeight());
            } else {
                canvas.translate(this.mKp.left + this.mLd, (this.mKp.top - this.mKN) - this.mLc.getHeight());
            }
            this.mLc.draw(canvas);
            canvas.restore();
        }
    }

    private void dEm() {
        if (this.mKH) {
            if (this.mKU == null) {
                this.mKr += this.mKn;
                int i = this.mKx;
                if (this.mKC != null) {
                    i = this.mKC.getWidth();
                }
                if (this.mKR) {
                    if (i + this.mKr > this.mKp.right - this.mLb || this.mKr < this.mKp.left + this.mLb) {
                        this.mKn = -this.mKn;
                    }
                } else {
                    if (i + this.mKr > this.mKp.right - this.mLb) {
                        this.mKr = this.mKp.left + this.mLb + 0.5f;
                    }
                }
            } else {
                this.mKW += this.mKn;
                if (this.mKW > this.mKp.right - this.mLb) {
                    this.mKW = this.mKp.left + this.mLb + 0.5f;
                }
            }
        } else if (this.mKU == null) {
            this.mKq += this.mKn;
            int i2 = this.mKx;
            if (this.mKC != null) {
                i2 = this.mKC.getHeight();
            }
            if (this.mKR) {
                if (i2 + this.mKq > this.mKp.bottom - this.mLb || this.mKq < this.mKp.top + this.mLb) {
                    this.mKn = -this.mKn;
                }
            } else {
                if (i2 + this.mKq > this.mKp.bottom - this.mLb) {
                    this.mKq = this.mKp.top + this.mLb + 0.5f;
                }
            }
        } else {
            this.mKV += this.mKn;
            if (this.mKV > this.mKp.bottom - this.mLb) {
                this.mKV = this.mKp.top + this.mLb + 0.5f;
            }
        }
        postInvalidateDelayed(this.mKo, this.mKp.left, this.mKp.top, this.mKp.right, this.mKp.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dEn();
    }

    private void dEn() {
        int i;
        if (this.mKH) {
            i = this.mTopOffset + this.mKG;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cDJ) / 2;
        this.mKp = new Rect(width, i, this.cDJ + width, this.mKv + i);
        if (this.mKH) {
            float f = this.mKp.left + this.mLb + 0.5f;
            this.mKr = f;
            this.mKW = f;
            return;
        }
        float f2 = this.mKp.top + this.mLb + 0.5f;
        this.mKq = f2;
        this.mKV = f2;
    }

    public Rect IV(int i) {
        if (this.mLe) {
            Rect rect = new Rect(this.mKp);
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
        this.mKH = z;
        if (this.mKT != null || this.mKS) {
            if (this.mKH) {
                this.mKU = this.mLa;
            } else {
                this.mKU = this.mKZ;
            }
        } else if (this.mKB != null || this.mKA) {
            if (this.mKH) {
                this.mKC = this.mKY;
            } else {
                this.mKC = this.mKX;
            }
        }
        if (this.mKH) {
            this.lmr = this.mKJ;
            this.mKv = this.mKw;
            this.mKo = (int) (((this.mKE * 1.0f) * this.mKn) / this.cDJ);
        } else {
            this.lmr = this.mKI;
            this.mKv = this.cDJ;
            this.mKo = (int) (((this.mKE * 1.0f) * this.mKn) / this.mKv);
        }
        if (!TextUtils.isEmpty(this.lmr)) {
            if (this.mKO) {
                this.mLc = new StaticLayout(this.lmr, this.mKs, a.gM(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mLc = new StaticLayout(this.lmr, this.mKs, this.cDJ - (this.mLd * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mKF) {
            int i = a.gM(getContext()).y;
            if (this.mKG == 0) {
                this.mTopOffset = (i - this.mKv) / 2;
            } else if (this.mKH) {
                this.mTopOffset = ((i - this.mKv) / 2) + (this.mKG / 2);
            } else {
                this.mTopOffset = (i - this.mKv) / 2;
            }
        }
        dEn();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mKH;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mKt;
    }

    public void setCornerLength(int i) {
        this.mKt = i;
    }

    public int getCornerSize() {
        return this.mKu;
    }

    public void setCornerSize(int i) {
        this.mKu = i;
    }

    public int getRectWidth() {
        return this.cDJ;
    }

    public void setRectWidth(int i) {
        this.cDJ = i;
    }

    public int getRectHeight() {
        return this.mKv;
    }

    public void setRectHeight(int i) {
        this.mKv = i;
    }

    public int getBarcodeRectHeight() {
        return this.mKw;
    }

    public void setBarcodeRectHeight(int i) {
        this.mKw = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mKx;
    }

    public void setScanLineSize(int i) {
        this.mKx = i;
    }

    public int getScanLineColor() {
        return this.mKy;
    }

    public void setScanLineColor(int i) {
        this.mKy = i;
    }

    public int getScanLineMargin() {
        return this.mKz;
    }

    public void setScanLineMargin(int i) {
        this.mKz = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mKA = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mKB;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mKB = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mKC;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mKC = bitmap;
    }

    public int getBorderSize() {
        return this.mKD;
    }

    public void setBorderSize(int i) {
        this.mKD = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mKE;
    }

    public void setAnimTime(int i) {
        this.mKE = i;
    }

    public void setCenterVertical(boolean z) {
        this.mKF = z;
    }

    public int getToolbarHeight() {
        return this.mKG;
    }

    public void setToolbarHeight(int i) {
        this.mKG = i;
    }

    public String getQRCodeTipText() {
        return this.mKI;
    }

    public void setQRCodeTipText(String str) {
        this.mKI = str;
    }

    public String getBarCodeTipText() {
        return this.mKJ;
    }

    public void setBarCodeTipText(String str) {
        this.mKJ = str;
    }

    public String getTipText() {
        return this.lmr;
    }

    public void setTipText(String str) {
        this.lmr = str;
    }

    public int getTipTextColor() {
        return this.mKL;
    }

    public void setTipTextColor(int i) {
        this.mKL = i;
    }

    public int getTipTextSize() {
        return this.mKK;
    }

    public void setTipTextSize(int i) {
        this.mKK = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mKM = z;
    }

    public int getTipTextMargin() {
        return this.mKN;
    }

    public void setTipTextMargin(int i) {
        this.mKN = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mKO = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mKQ = z;
    }

    public int getTipBackgroundColor() {
        return this.mKP;
    }

    public void setTipBackgroundColor(int i) {
        this.mKP = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mKR = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mKS = z;
    }

    public float getHalfCornerSize() {
        return this.mLb;
    }

    public void setHalfCornerSize(float f) {
        this.mLb = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mLc;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mLc = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mLd;
    }

    public void setTipBackgroundRadius(int i) {
        this.mLd = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mLe = z;
    }
}
