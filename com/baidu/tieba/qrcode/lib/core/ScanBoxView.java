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
    private int bQV;
    private String kcZ;
    private Bitmap lAA;
    private Bitmap lAB;
    private Bitmap lAC;
    private Bitmap lAD;
    private float lAE;
    private StaticLayout lAF;
    private int lAG;
    private boolean lAH;
    private ColorMatrixColorFilter lAI;
    private int lAa;
    private int lAb;
    private int lAc;
    private boolean lAd;
    private Drawable lAe;
    private Bitmap lAf;
    private int lAg;
    private int lAh;
    private boolean lAi;
    private int lAj;
    private boolean lAk;
    private String lAl;
    private String lAm;
    private int lAn;
    private int lAo;
    private boolean lAp;
    private int lAq;
    private boolean lAr;
    private int lAs;
    private boolean lAt;
    private boolean lAu;
    private boolean lAv;
    private Drawable lAw;
    private Bitmap lAx;
    private float lAy;
    private float lAz;
    private Bitmap lzM;
    private Bitmap lzN;
    private Bitmap lzO;
    private Bitmap lzP;
    private int lzQ;
    private int lzR;
    private Rect lzS;
    private float lzT;
    private float lzU;
    private TextPaint lzV;
    private int lzW;
    private int lzX;
    private int lzY;
    private int lzZ;
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
        this.lzW = a.dp2px(context, 20.0f);
        this.lzX = a.dp2px(context, 3.0f);
        this.lAa = a.dp2px(context, 1.0f);
        this.lAb = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bQV = a.dp2px(context, 200.0f);
        this.lzZ = a.dp2px(context, 140.0f);
        this.lAc = 0;
        this.lAd = false;
        this.lAe = null;
        this.lAf = null;
        this.lAg = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.lAh = 1000;
        this.lAi = false;
        this.lAj = 0;
        this.lAk = false;
        this.lzQ = a.dp2px(context, 2.0f);
        this.kcZ = null;
        this.lAn = a.h(context, 14.0f);
        this.lAo = -1;
        this.lAp = false;
        this.lAq = a.dp2px(context, 20.0f);
        this.lAr = false;
        this.lAs = Color.parseColor("#22000000");
        this.lAt = false;
        this.lAu = false;
        this.lAv = false;
        this.lzV = new TextPaint();
        this.lzV.setAntiAlias(true);
        this.lAG = a.dp2px(context, 4.0f);
        this.lAH = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lAI = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dmC();
        dmB();
    }

    private void dmB() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.lzW;
        options.outHeight = this.lzW;
        this.lzM = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.lzN = Bitmap.createBitmap(this.lzM, 0, 0, this.lzM.getWidth(), this.lzM.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lzO = Bitmap.createBitmap(this.lzM, 0, 0, this.lzM.getWidth(), this.lzM.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.lzP = Bitmap.createBitmap(this.lzM, 0, 0, this.lzM.getWidth(), this.lzM.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.lzX = typedArray.getDimensionPixelSize(i, this.lzX);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.lzW = typedArray.getDimensionPixelSize(i, this.lzW);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.lAa = typedArray.getDimensionPixelSize(i, this.lAa);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.bQV = typedArray.getDimensionPixelSize(i, this.bQV);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.lAb = typedArray.getColor(i, this.lAb);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.lAc = typedArray.getDimensionPixelSize(i, this.lAc);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.lAd = typedArray.getBoolean(i, this.lAd);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.lAe = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.lAg = typedArray.getDimensionPixelSize(i, this.lAg);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.lAh = typedArray.getInteger(i, this.lAh);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.lAi = typedArray.getBoolean(i, this.lAi);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.lAj = typedArray.getDimensionPixelSize(i, this.lAj);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.lzZ = typedArray.getDimensionPixelSize(i, this.lzZ);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.lAk = typedArray.getBoolean(i, this.lAk);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.lAm = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.lAl = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.lAn = typedArray.getDimensionPixelSize(i, this.lAn);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.lAo = typedArray.getColor(i, this.lAo);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.lAp = typedArray.getBoolean(i, this.lAp);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.lAq = typedArray.getDimensionPixelSize(i, this.lAq);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.lAr = typedArray.getBoolean(i, this.lAr);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.lAt = typedArray.getBoolean(i, this.lAt);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.lAs = typedArray.getColor(i, this.lAs);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.lAu = typedArray.getBoolean(i, this.lAu);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.lAv = typedArray.getBoolean(i, this.lAv);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.lAw = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lAH = typedArray.getBoolean(i, this.lAH);
        }
    }

    private void dmC() {
        if (this.lAw != null) {
            this.lAC = ((BitmapDrawable) this.lAw).getBitmap();
        }
        if (this.lAC == null) {
            this.lAC = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lAC = a.g(this.lAC, this.lAb);
        }
        this.lAD = a.f(this.lAC, 90);
        this.lAD = a.f(this.lAD, 90);
        this.lAD = a.f(this.lAD, 90);
        if (this.lAe != null) {
            this.lAA = ((BitmapDrawable) this.lAe).getBitmap();
        }
        if (this.lAA == null) {
            this.lAA = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lAA = a.g(this.lAA, this.lAb);
        }
        this.lAB = a.f(this.lAA, 90);
        this.lAE = (1.0f * this.lzX) / 2.0f;
        this.lzV.setTextSize(this.lAn);
        this.lzV.setColor(this.lAo);
        setIsBarcode(this.lAk);
    }

    public void dmD() {
        this.lzV.setColor(this.lAo);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lzS != null) {
            ae(canvas);
            af(canvas);
            ah(canvas);
            ai(canvas);
            ag(canvas);
            dmE();
        }
    }

    private void ae(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.lzS.top, this.mPaint);
            canvas.drawRect(0.0f, this.lzS.top, this.lzS.left, this.lzS.bottom + 1, this.mPaint);
            canvas.drawRect(this.lzS.right + 1, this.lzS.top, width, this.lzS.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.lzS.bottom + 1, width, height, this.mPaint);
        }
    }

    private void af(Canvas canvas) {
        if (this.lAg > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.lAg);
            canvas.drawRect(this.lzS, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lzM, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lzN, getMainFrameRight() - this.lzM.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lzO, getMainFrameLeft(), getMainFrameBottom() - this.lzM.getHeight(), this.mPaint);
        canvas.drawBitmap(this.lzP, getMainFrameRight() - this.lzM.getWidth(), getMainFrameBottom() - this.lzM.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.lzS.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.lzS.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.lzS.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.lzS.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.lAg / 2;
    }

    private void ah(Canvas canvas) {
        if (this.lAk) {
            if (this.lAx != null) {
                RectF rectF = new RectF(this.lzS.left + this.lAE + 0.5f, this.lzS.top + this.lAE + this.lAc, this.lAz, (this.lzS.bottom - this.lAE) - this.lAc);
                Rect rect = new Rect((int) (this.lAx.getWidth() - rectF.width()), 0, this.lAx.getWidth(), this.lAx.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.lAx, rect, rectF, this.mPaint);
            } else if (this.lAf != null) {
                canvas.drawBitmap(this.lAf, (Rect) null, new RectF(this.lzU, this.lzS.top + this.lAE + this.lAc, this.lzU + this.lAf.getWidth(), (this.lzS.bottom - this.lAE) - this.lAc), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lAb);
                canvas.drawRect(this.lzU, this.lAc + this.lzS.top + this.lAE, this.lAa + this.lzU, (this.lzS.bottom - this.lAE) - this.lAc, this.mPaint);
            }
        } else if (this.lAx != null) {
            RectF rectF2 = new RectF(this.lzS.left + this.lAE + this.lAc, this.lzS.top + this.lAE + 0.5f, (this.lzS.right - this.lAE) - this.lAc, this.lAy);
            Rect rect2 = new Rect(0, (int) (this.lAx.getHeight() - rectF2.height()), this.lAx.getWidth(), this.lAx.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lAI);
            canvas.drawBitmap(this.lAx, rect2, rectF2, this.mPaint);
        } else if (this.lAf != null) {
            canvas.drawBitmap(this.lAf, (Rect) null, new RectF(this.lzS.left + this.lAE + this.lAc, this.lzT, (this.lzS.right - this.lAE) - this.lAc, this.lzT + this.lAf.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.lAb);
            canvas.drawRect(this.lAc + this.lzS.left + this.lAE, this.lzT, (this.lzS.right - this.lAE) - this.lAc, this.lAa + this.lzT, this.mPaint);
        }
    }

    private void ai(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kcZ) && this.lAF != null) {
            if (this.lAp) {
                if (this.lAt) {
                    this.mPaint.setColor(this.lAs);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.lAr) {
                        Rect rect = new Rect();
                        this.lzV.getTextBounds(this.kcZ, 0, this.kcZ.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lAG;
                        canvas.drawRoundRect(new RectF(width, (this.lzS.bottom + this.lAq) - this.lAG, rect.width() + width + (this.lAG * 2), this.lzS.bottom + this.lAq + this.lAF.getHeight() + this.lAG), this.lAG, this.lAG, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.lzS.left, (this.lzS.bottom + this.lAq) - this.lAG, this.lzS.right, this.lzS.bottom + this.lAq + this.lAF.getHeight() + this.lAG), this.lAG, this.lAG, this.mPaint);
                    }
                }
                canvas.save();
                if (this.lAr) {
                    canvas.translate(0.0f, this.lzS.bottom + this.lAq);
                } else {
                    canvas.translate(this.lzS.left + this.lAG, this.lzS.bottom + this.lAq);
                }
                this.lAF.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.lAt) {
                this.mPaint.setColor(this.lAs);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.lAr) {
                    Rect rect2 = new Rect();
                    this.lzV.getTextBounds(this.kcZ, 0, this.kcZ.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lAG;
                    canvas.drawRoundRect(new RectF(width2, ((this.lzS.top - this.lAq) - this.lAF.getHeight()) - this.lAG, rect2.width() + width2 + (this.lAG * 2), (this.lzS.top - this.lAq) + this.lAG), this.lAG, this.lAG, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.lzS.left, ((this.lzS.top - this.lAq) - this.lAF.getHeight()) - this.lAG, this.lzS.right, (this.lzS.top - this.lAq) + this.lAG), this.lAG, this.lAG, this.mPaint);
                }
            }
            canvas.save();
            if (this.lAr) {
                canvas.translate(0.0f, (this.lzS.top - this.lAq) - this.lAF.getHeight());
            } else {
                canvas.translate(this.lzS.left + this.lAG, (this.lzS.top - this.lAq) - this.lAF.getHeight());
            }
            this.lAF.draw(canvas);
            canvas.restore();
        }
    }

    private void dmE() {
        if (this.lAk) {
            if (this.lAx == null) {
                this.lzU += this.lzQ;
                int i = this.lAa;
                if (this.lAf != null) {
                    i = this.lAf.getWidth();
                }
                if (this.lAu) {
                    if (i + this.lzU > this.lzS.right - this.lAE || this.lzU < this.lzS.left + this.lAE) {
                        this.lzQ = -this.lzQ;
                    }
                } else {
                    if (i + this.lzU > this.lzS.right - this.lAE) {
                        this.lzU = this.lzS.left + this.lAE + 0.5f;
                    }
                }
            } else {
                this.lAz += this.lzQ;
                if (this.lAz > this.lzS.right - this.lAE) {
                    this.lAz = this.lzS.left + this.lAE + 0.5f;
                }
            }
        } else if (this.lAx == null) {
            this.lzT += this.lzQ;
            int i2 = this.lAa;
            if (this.lAf != null) {
                i2 = this.lAf.getHeight();
            }
            if (this.lAu) {
                if (i2 + this.lzT > this.lzS.bottom - this.lAE || this.lzT < this.lzS.top + this.lAE) {
                    this.lzQ = -this.lzQ;
                }
            } else {
                if (i2 + this.lzT > this.lzS.bottom - this.lAE) {
                    this.lzT = this.lzS.top + this.lAE + 0.5f;
                }
            }
        } else {
            this.lAy += this.lzQ;
            if (this.lAy > this.lzS.bottom - this.lAE) {
                this.lAy = this.lzS.top + this.lAE + 0.5f;
            }
        }
        postInvalidateDelayed(this.lzR, this.lzS.left, this.lzS.top, this.lzS.right, this.lzS.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dmF();
    }

    private void dmF() {
        int i;
        if (this.lAk) {
            i = this.mTopOffset + this.lAj;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bQV) / 2;
        this.lzS = new Rect(width, i, this.bQV + width, this.lzY + i);
        if (this.lAk) {
            float f = this.lzS.left + this.lAE + 0.5f;
            this.lzU = f;
            this.lAz = f;
            return;
        }
        float f2 = this.lzS.top + this.lAE + 0.5f;
        this.lzT = f2;
        this.lAy = f2;
    }

    public Rect FZ(int i) {
        if (this.lAH) {
            Rect rect = new Rect(this.lzS);
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
        this.lAk = z;
        if (this.lAw != null || this.lAv) {
            if (this.lAk) {
                this.lAx = this.lAD;
            } else {
                this.lAx = this.lAC;
            }
        } else if (this.lAe != null || this.lAd) {
            if (this.lAk) {
                this.lAf = this.lAB;
            } else {
                this.lAf = this.lAA;
            }
        }
        if (this.lAk) {
            this.kcZ = this.lAm;
            this.lzY = this.lzZ;
            this.lzR = (int) (((this.lAh * 1.0f) * this.lzQ) / this.bQV);
        } else {
            this.kcZ = this.lAl;
            this.lzY = this.bQV;
            this.lzR = (int) (((this.lAh * 1.0f) * this.lzQ) / this.lzY);
        }
        if (!TextUtils.isEmpty(this.kcZ)) {
            if (this.lAr) {
                this.lAF = new StaticLayout(this.kcZ, this.lzV, a.fx(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lAF = new StaticLayout(this.kcZ, this.lzV, this.bQV - (this.lAG * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.lAi) {
            int i = a.fx(getContext()).y;
            if (this.lAj == 0) {
                this.mTopOffset = (i - this.lzY) / 2;
            } else if (this.lAk) {
                this.mTopOffset = ((i - this.lzY) / 2) + (this.lAj / 2);
            } else {
                this.mTopOffset = (i - this.lzY) / 2;
            }
        }
        dmF();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.lAk;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.lzW;
    }

    public void setCornerLength(int i) {
        this.lzW = i;
    }

    public int getCornerSize() {
        return this.lzX;
    }

    public void setCornerSize(int i) {
        this.lzX = i;
    }

    public int getRectWidth() {
        return this.bQV;
    }

    public void setRectWidth(int i) {
        this.bQV = i;
    }

    public int getRectHeight() {
        return this.lzY;
    }

    public void setRectHeight(int i) {
        this.lzY = i;
    }

    public int getBarcodeRectHeight() {
        return this.lzZ;
    }

    public void setBarcodeRectHeight(int i) {
        this.lzZ = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lAa;
    }

    public void setScanLineSize(int i) {
        this.lAa = i;
    }

    public int getScanLineColor() {
        return this.lAb;
    }

    public void setScanLineColor(int i) {
        this.lAb = i;
    }

    public int getScanLineMargin() {
        return this.lAc;
    }

    public void setScanLineMargin(int i) {
        this.lAc = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.lAd = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.lAe;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.lAe = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.lAf;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.lAf = bitmap;
    }

    public int getBorderSize() {
        return this.lAg;
    }

    public void setBorderSize(int i) {
        this.lAg = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.lAh;
    }

    public void setAnimTime(int i) {
        this.lAh = i;
    }

    public void setCenterVertical(boolean z) {
        this.lAi = z;
    }

    public int getToolbarHeight() {
        return this.lAj;
    }

    public void setToolbarHeight(int i) {
        this.lAj = i;
    }

    public String getQRCodeTipText() {
        return this.lAl;
    }

    public void setQRCodeTipText(String str) {
        this.lAl = str;
    }

    public String getBarCodeTipText() {
        return this.lAm;
    }

    public void setBarCodeTipText(String str) {
        this.lAm = str;
    }

    public String getTipText() {
        return this.kcZ;
    }

    public void setTipText(String str) {
        this.kcZ = str;
    }

    public int getTipTextColor() {
        return this.lAo;
    }

    public void setTipTextColor(int i) {
        this.lAo = i;
    }

    public int getTipTextSize() {
        return this.lAn;
    }

    public void setTipTextSize(int i) {
        this.lAn = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.lAp = z;
    }

    public int getTipTextMargin() {
        return this.lAq;
    }

    public void setTipTextMargin(int i) {
        this.lAq = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.lAr = z;
    }

    public void setShowTipBackground(boolean z) {
        this.lAt = z;
    }

    public int getTipBackgroundColor() {
        return this.lAs;
    }

    public void setTipBackgroundColor(int i) {
        this.lAs = i;
    }

    public void setScanLineReverse(boolean z) {
        this.lAu = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.lAv = z;
    }

    public float getHalfCornerSize() {
        return this.lAE;
    }

    public void setHalfCornerSize(float f) {
        this.lAE = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lAF;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lAF = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lAG;
    }

    public void setTipBackgroundRadius(int i) {
        this.lAG = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lAH = z;
    }
}
