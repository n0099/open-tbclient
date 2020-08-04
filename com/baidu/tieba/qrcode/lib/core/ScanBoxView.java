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
    private int bLv;
    private String jNA;
    private Drawable ljA;
    private Bitmap ljB;
    private int ljC;
    private int ljD;
    private boolean ljE;
    private int ljF;
    private boolean ljG;
    private String ljH;
    private String ljI;
    private int ljJ;
    private int ljK;
    private boolean ljL;
    private int ljM;
    private boolean ljN;
    private int ljO;
    private boolean ljP;
    private boolean ljQ;
    private boolean ljR;
    private Drawable ljS;
    private Bitmap ljT;
    private float ljU;
    private float ljV;
    private Bitmap ljW;
    private Bitmap ljX;
    private Bitmap ljY;
    private Bitmap ljZ;
    private Bitmap lji;
    private Bitmap ljj;
    private Bitmap ljk;
    private Bitmap ljl;
    private int ljm;
    private int ljn;
    private Rect ljo;
    private float ljp;
    private float ljq;
    private TextPaint ljr;
    private int ljs;
    private int ljt;
    private int lju;
    private int ljv;
    private int ljw;
    private int ljx;
    private int ljy;
    private boolean ljz;
    private float lka;
    private StaticLayout lkb;
    private int lkc;
    private boolean lkd;
    private ColorMatrixColorFilter lke;
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
        this.ljs = a.dp2px(context, 20.0f);
        this.ljt = a.dp2px(context, 3.0f);
        this.ljw = a.dp2px(context, 1.0f);
        this.ljx = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bLv = a.dp2px(context, 200.0f);
        this.ljv = a.dp2px(context, 140.0f);
        this.ljy = 0;
        this.ljz = false;
        this.ljA = null;
        this.ljB = null;
        this.ljC = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.ljD = 1000;
        this.ljE = false;
        this.ljF = 0;
        this.ljG = false;
        this.ljm = a.dp2px(context, 2.0f);
        this.jNA = null;
        this.ljJ = a.h(context, 14.0f);
        this.ljK = -1;
        this.ljL = false;
        this.ljM = a.dp2px(context, 20.0f);
        this.ljN = false;
        this.ljO = Color.parseColor("#22000000");
        this.ljP = false;
        this.ljQ = false;
        this.ljR = false;
        this.ljr = new TextPaint();
        this.ljr.setAntiAlias(true);
        this.lkc = a.dp2px(context, 4.0f);
        this.lkd = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lke = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dbv();
        dbu();
    }

    private void dbu() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ljs;
        options.outHeight = this.ljs;
        this.lji = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.ljj = Bitmap.createBitmap(this.lji, 0, 0, this.lji.getWidth(), this.lji.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.ljk = Bitmap.createBitmap(this.lji, 0, 0, this.lji.getWidth(), this.lji.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ljl = Bitmap.createBitmap(this.lji, 0, 0, this.lji.getWidth(), this.lji.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.ljt = typedArray.getDimensionPixelSize(i, this.ljt);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.ljs = typedArray.getDimensionPixelSize(i, this.ljs);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.ljw = typedArray.getDimensionPixelSize(i, this.ljw);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.bLv = typedArray.getDimensionPixelSize(i, this.bLv);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.ljx = typedArray.getColor(i, this.ljx);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.ljy = typedArray.getDimensionPixelSize(i, this.ljy);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ljz = typedArray.getBoolean(i, this.ljz);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.ljA = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.ljC = typedArray.getDimensionPixelSize(i, this.ljC);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.ljD = typedArray.getInteger(i, this.ljD);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.ljE = typedArray.getBoolean(i, this.ljE);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.ljF = typedArray.getDimensionPixelSize(i, this.ljF);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.ljv = typedArray.getDimensionPixelSize(i, this.ljv);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.ljG = typedArray.getBoolean(i, this.ljG);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.ljI = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.ljH = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.ljJ = typedArray.getDimensionPixelSize(i, this.ljJ);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.ljK = typedArray.getColor(i, this.ljK);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ljL = typedArray.getBoolean(i, this.ljL);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.ljM = typedArray.getDimensionPixelSize(i, this.ljM);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ljN = typedArray.getBoolean(i, this.ljN);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.ljP = typedArray.getBoolean(i, this.ljP);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.ljO = typedArray.getColor(i, this.ljO);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.ljQ = typedArray.getBoolean(i, this.ljQ);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ljR = typedArray.getBoolean(i, this.ljR);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ljS = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lkd = typedArray.getBoolean(i, this.lkd);
        }
    }

    private void dbv() {
        if (this.ljS != null) {
            this.ljY = ((BitmapDrawable) this.ljS).getBitmap();
        }
        if (this.ljY == null) {
            this.ljY = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ljY = a.f(this.ljY, this.ljx);
        }
        this.ljZ = a.e(this.ljY, 90);
        this.ljZ = a.e(this.ljZ, 90);
        this.ljZ = a.e(this.ljZ, 90);
        if (this.ljA != null) {
            this.ljW = ((BitmapDrawable) this.ljA).getBitmap();
        }
        if (this.ljW == null) {
            this.ljW = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ljW = a.f(this.ljW, this.ljx);
        }
        this.ljX = a.e(this.ljW, 90);
        this.lka = (1.0f * this.ljt) / 2.0f;
        this.ljr.setTextSize(this.ljJ);
        this.ljr.setColor(this.ljK);
        setIsBarcode(this.ljG);
    }

    public void dbw() {
        this.ljr.setColor(this.ljK);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ljo != null) {
            Y(canvas);
            Z(canvas);
            ab(canvas);
            ac(canvas);
            aa(canvas);
            dbx();
        }
    }

    private void Y(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.ljo.top, this.mPaint);
            canvas.drawRect(0.0f, this.ljo.top, this.ljo.left, this.ljo.bottom + 1, this.mPaint);
            canvas.drawRect(this.ljo.right + 1, this.ljo.top, width, this.ljo.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ljo.bottom + 1, width, height, this.mPaint);
        }
    }

    private void Z(Canvas canvas) {
        if (this.ljC > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ljC);
            canvas.drawRect(this.ljo, this.mPaint);
        }
    }

    private void aa(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lji, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ljj, getMainFrameRight() - this.lji.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ljk, getMainFrameLeft(), getMainFrameBottom() - this.lji.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ljl, getMainFrameRight() - this.lji.getWidth(), getMainFrameBottom() - this.lji.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ljo.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ljo.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ljo.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ljo.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ljC / 2;
    }

    private void ab(Canvas canvas) {
        if (this.ljG) {
            if (this.ljT != null) {
                RectF rectF = new RectF(this.ljo.left + this.lka + 0.5f, this.ljo.top + this.lka + this.ljy, this.ljV, (this.ljo.bottom - this.lka) - this.ljy);
                Rect rect = new Rect((int) (this.ljT.getWidth() - rectF.width()), 0, this.ljT.getWidth(), this.ljT.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ljT, rect, rectF, this.mPaint);
            } else if (this.ljB != null) {
                canvas.drawBitmap(this.ljB, (Rect) null, new RectF(this.ljq, this.ljo.top + this.lka + this.ljy, this.ljq + this.ljB.getWidth(), (this.ljo.bottom - this.lka) - this.ljy), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ljx);
                canvas.drawRect(this.ljq, this.ljy + this.ljo.top + this.lka, this.ljw + this.ljq, (this.ljo.bottom - this.lka) - this.ljy, this.mPaint);
            }
        } else if (this.ljT != null) {
            RectF rectF2 = new RectF(this.ljo.left + this.lka + this.ljy, this.ljo.top + this.lka + 0.5f, (this.ljo.right - this.lka) - this.ljy, this.ljU);
            Rect rect2 = new Rect(0, (int) (this.ljT.getHeight() - rectF2.height()), this.ljT.getWidth(), this.ljT.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lke);
            canvas.drawBitmap(this.ljT, rect2, rectF2, this.mPaint);
        } else if (this.ljB != null) {
            canvas.drawBitmap(this.ljB, (Rect) null, new RectF(this.ljo.left + this.lka + this.ljy, this.ljp, (this.ljo.right - this.lka) - this.ljy, this.ljp + this.ljB.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ljx);
            canvas.drawRect(this.ljy + this.ljo.left + this.lka, this.ljp, (this.ljo.right - this.lka) - this.ljy, this.ljw + this.ljp, this.mPaint);
        }
    }

    private void ac(Canvas canvas) {
        if (!TextUtils.isEmpty(this.jNA) && this.lkb != null) {
            if (this.ljL) {
                if (this.ljP) {
                    this.mPaint.setColor(this.ljO);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ljN) {
                        Rect rect = new Rect();
                        this.ljr.getTextBounds(this.jNA, 0, this.jNA.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lkc;
                        canvas.drawRoundRect(new RectF(width, (this.ljo.bottom + this.ljM) - this.lkc, rect.width() + width + (this.lkc * 2), this.ljo.bottom + this.ljM + this.lkb.getHeight() + this.lkc), this.lkc, this.lkc, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ljo.left, (this.ljo.bottom + this.ljM) - this.lkc, this.ljo.right, this.ljo.bottom + this.ljM + this.lkb.getHeight() + this.lkc), this.lkc, this.lkc, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ljN) {
                    canvas.translate(0.0f, this.ljo.bottom + this.ljM);
                } else {
                    canvas.translate(this.ljo.left + this.lkc, this.ljo.bottom + this.ljM);
                }
                this.lkb.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ljP) {
                this.mPaint.setColor(this.ljO);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ljN) {
                    Rect rect2 = new Rect();
                    this.ljr.getTextBounds(this.jNA, 0, this.jNA.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lkc;
                    canvas.drawRoundRect(new RectF(width2, ((this.ljo.top - this.ljM) - this.lkb.getHeight()) - this.lkc, rect2.width() + width2 + (this.lkc * 2), (this.ljo.top - this.ljM) + this.lkc), this.lkc, this.lkc, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ljo.left, ((this.ljo.top - this.ljM) - this.lkb.getHeight()) - this.lkc, this.ljo.right, (this.ljo.top - this.ljM) + this.lkc), this.lkc, this.lkc, this.mPaint);
                }
            }
            canvas.save();
            if (this.ljN) {
                canvas.translate(0.0f, (this.ljo.top - this.ljM) - this.lkb.getHeight());
            } else {
                canvas.translate(this.ljo.left + this.lkc, (this.ljo.top - this.ljM) - this.lkb.getHeight());
            }
            this.lkb.draw(canvas);
            canvas.restore();
        }
    }

    private void dbx() {
        if (this.ljG) {
            if (this.ljT == null) {
                this.ljq += this.ljm;
                int i = this.ljw;
                if (this.ljB != null) {
                    i = this.ljB.getWidth();
                }
                if (this.ljQ) {
                    if (i + this.ljq > this.ljo.right - this.lka || this.ljq < this.ljo.left + this.lka) {
                        this.ljm = -this.ljm;
                    }
                } else {
                    if (i + this.ljq > this.ljo.right - this.lka) {
                        this.ljq = this.ljo.left + this.lka + 0.5f;
                    }
                }
            } else {
                this.ljV += this.ljm;
                if (this.ljV > this.ljo.right - this.lka) {
                    this.ljV = this.ljo.left + this.lka + 0.5f;
                }
            }
        } else if (this.ljT == null) {
            this.ljp += this.ljm;
            int i2 = this.ljw;
            if (this.ljB != null) {
                i2 = this.ljB.getHeight();
            }
            if (this.ljQ) {
                if (i2 + this.ljp > this.ljo.bottom - this.lka || this.ljp < this.ljo.top + this.lka) {
                    this.ljm = -this.ljm;
                }
            } else {
                if (i2 + this.ljp > this.ljo.bottom - this.lka) {
                    this.ljp = this.ljo.top + this.lka + 0.5f;
                }
            }
        } else {
            this.ljU += this.ljm;
            if (this.ljU > this.ljo.bottom - this.lka) {
                this.ljU = this.ljo.top + this.lka + 0.5f;
            }
        }
        postInvalidateDelayed(this.ljn, this.ljo.left, this.ljo.top, this.ljo.right, this.ljo.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dby();
    }

    private void dby() {
        int i;
        if (this.ljG) {
            i = this.mTopOffset + this.ljF;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bLv) / 2;
        this.ljo = new Rect(width, i, this.bLv + width, this.lju + i);
        if (this.ljG) {
            float f = this.ljo.left + this.lka + 0.5f;
            this.ljq = f;
            this.ljV = f;
            return;
        }
        float f2 = this.ljo.top + this.lka + 0.5f;
        this.ljp = f2;
        this.ljU = f2;
    }

    public Rect DE(int i) {
        if (this.lkd) {
            Rect rect = new Rect(this.ljo);
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
        this.ljG = z;
        if (this.ljS != null || this.ljR) {
            if (this.ljG) {
                this.ljT = this.ljZ;
            } else {
                this.ljT = this.ljY;
            }
        } else if (this.ljA != null || this.ljz) {
            if (this.ljG) {
                this.ljB = this.ljX;
            } else {
                this.ljB = this.ljW;
            }
        }
        if (this.ljG) {
            this.jNA = this.ljI;
            this.lju = this.ljv;
            this.ljn = (int) (((this.ljD * 1.0f) * this.ljm) / this.bLv);
        } else {
            this.jNA = this.ljH;
            this.lju = this.bLv;
            this.ljn = (int) (((this.ljD * 1.0f) * this.ljm) / this.lju);
        }
        if (!TextUtils.isEmpty(this.jNA)) {
            if (this.ljN) {
                this.lkb = new StaticLayout(this.jNA, this.ljr, a.fk(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lkb = new StaticLayout(this.jNA, this.ljr, this.bLv - (this.lkc * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ljE) {
            int i = a.fk(getContext()).y;
            if (this.ljF == 0) {
                this.mTopOffset = (i - this.lju) / 2;
            } else if (this.ljG) {
                this.mTopOffset = ((i - this.lju) / 2) + (this.ljF / 2);
            } else {
                this.mTopOffset = (i - this.lju) / 2;
            }
        }
        dby();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ljG;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.ljs;
    }

    public void setCornerLength(int i) {
        this.ljs = i;
    }

    public int getCornerSize() {
        return this.ljt;
    }

    public void setCornerSize(int i) {
        this.ljt = i;
    }

    public int getRectWidth() {
        return this.bLv;
    }

    public void setRectWidth(int i) {
        this.bLv = i;
    }

    public int getRectHeight() {
        return this.lju;
    }

    public void setRectHeight(int i) {
        this.lju = i;
    }

    public int getBarcodeRectHeight() {
        return this.ljv;
    }

    public void setBarcodeRectHeight(int i) {
        this.ljv = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.ljw;
    }

    public void setScanLineSize(int i) {
        this.ljw = i;
    }

    public int getScanLineColor() {
        return this.ljx;
    }

    public void setScanLineColor(int i) {
        this.ljx = i;
    }

    public int getScanLineMargin() {
        return this.ljy;
    }

    public void setScanLineMargin(int i) {
        this.ljy = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ljz = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ljA;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ljA = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ljB;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ljB = bitmap;
    }

    public int getBorderSize() {
        return this.ljC;
    }

    public void setBorderSize(int i) {
        this.ljC = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ljD;
    }

    public void setAnimTime(int i) {
        this.ljD = i;
    }

    public void setCenterVertical(boolean z) {
        this.ljE = z;
    }

    public int getToolbarHeight() {
        return this.ljF;
    }

    public void setToolbarHeight(int i) {
        this.ljF = i;
    }

    public String getQRCodeTipText() {
        return this.ljH;
    }

    public void setQRCodeTipText(String str) {
        this.ljH = str;
    }

    public String getBarCodeTipText() {
        return this.ljI;
    }

    public void setBarCodeTipText(String str) {
        this.ljI = str;
    }

    public String getTipText() {
        return this.jNA;
    }

    public void setTipText(String str) {
        this.jNA = str;
    }

    public int getTipTextColor() {
        return this.ljK;
    }

    public void setTipTextColor(int i) {
        this.ljK = i;
    }

    public int getTipTextSize() {
        return this.ljJ;
    }

    public void setTipTextSize(int i) {
        this.ljJ = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ljL = z;
    }

    public int getTipTextMargin() {
        return this.ljM;
    }

    public void setTipTextMargin(int i) {
        this.ljM = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ljN = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ljP = z;
    }

    public int getTipBackgroundColor() {
        return this.ljO;
    }

    public void setTipBackgroundColor(int i) {
        this.ljO = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ljQ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ljR = z;
    }

    public float getHalfCornerSize() {
        return this.lka;
    }

    public void setHalfCornerSize(float f) {
        this.lka = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lkb;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lkb = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lkc;
    }

    public void setTipBackgroundRadius(int i) {
        this.lkc = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lkd = z;
    }
}
