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
    private String jNy;
    private int ljA;
    private int ljB;
    private boolean ljC;
    private int ljD;
    private boolean ljE;
    private String ljF;
    private String ljG;
    private int ljH;
    private int ljI;
    private boolean ljJ;
    private int ljK;
    private boolean ljL;
    private int ljM;
    private boolean ljN;
    private boolean ljO;
    private boolean ljP;
    private Drawable ljQ;
    private Bitmap ljR;
    private float ljS;
    private float ljT;
    private Bitmap ljU;
    private Bitmap ljV;
    private Bitmap ljW;
    private Bitmap ljX;
    private float ljY;
    private StaticLayout ljZ;
    private Bitmap ljg;
    private Bitmap ljh;
    private Bitmap lji;
    private Bitmap ljj;
    private int ljk;
    private int ljl;
    private Rect ljm;
    private float ljn;
    private float ljo;
    private TextPaint ljp;
    private int ljq;
    private int ljr;
    private int ljs;
    private int ljt;
    private int lju;
    private int ljv;
    private int ljw;
    private boolean ljx;
    private Drawable ljy;
    private Bitmap ljz;
    private int lka;
    private boolean lkb;
    private ColorMatrixColorFilter lkc;
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
        this.ljq = a.dp2px(context, 20.0f);
        this.ljr = a.dp2px(context, 3.0f);
        this.lju = a.dp2px(context, 1.0f);
        this.ljv = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bLv = a.dp2px(context, 200.0f);
        this.ljt = a.dp2px(context, 140.0f);
        this.ljw = 0;
        this.ljx = false;
        this.ljy = null;
        this.ljz = null;
        this.ljA = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.ljB = 1000;
        this.ljC = false;
        this.ljD = 0;
        this.ljE = false;
        this.ljk = a.dp2px(context, 2.0f);
        this.jNy = null;
        this.ljH = a.h(context, 14.0f);
        this.ljI = -1;
        this.ljJ = false;
        this.ljK = a.dp2px(context, 20.0f);
        this.ljL = false;
        this.ljM = Color.parseColor("#22000000");
        this.ljN = false;
        this.ljO = false;
        this.ljP = false;
        this.ljp = new TextPaint();
        this.ljp.setAntiAlias(true);
        this.lka = a.dp2px(context, 4.0f);
        this.lkb = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lkc = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.ljq;
        options.outHeight = this.ljq;
        this.ljg = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.ljh = Bitmap.createBitmap(this.ljg, 0, 0, this.ljg.getWidth(), this.ljg.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lji = Bitmap.createBitmap(this.ljg, 0, 0, this.ljg.getWidth(), this.ljg.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ljj = Bitmap.createBitmap(this.ljg, 0, 0, this.ljg.getWidth(), this.ljg.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.ljr = typedArray.getDimensionPixelSize(i, this.ljr);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.ljq = typedArray.getDimensionPixelSize(i, this.ljq);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.lju = typedArray.getDimensionPixelSize(i, this.lju);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.bLv = typedArray.getDimensionPixelSize(i, this.bLv);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.ljv = typedArray.getColor(i, this.ljv);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.ljw = typedArray.getDimensionPixelSize(i, this.ljw);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ljx = typedArray.getBoolean(i, this.ljx);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.ljy = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.ljA = typedArray.getDimensionPixelSize(i, this.ljA);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.ljB = typedArray.getInteger(i, this.ljB);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.ljC = typedArray.getBoolean(i, this.ljC);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.ljD = typedArray.getDimensionPixelSize(i, this.ljD);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.ljt = typedArray.getDimensionPixelSize(i, this.ljt);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.ljE = typedArray.getBoolean(i, this.ljE);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.ljG = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.ljF = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.ljH = typedArray.getDimensionPixelSize(i, this.ljH);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.ljI = typedArray.getColor(i, this.ljI);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ljJ = typedArray.getBoolean(i, this.ljJ);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.ljK = typedArray.getDimensionPixelSize(i, this.ljK);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ljL = typedArray.getBoolean(i, this.ljL);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.ljN = typedArray.getBoolean(i, this.ljN);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.ljM = typedArray.getColor(i, this.ljM);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.ljO = typedArray.getBoolean(i, this.ljO);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ljP = typedArray.getBoolean(i, this.ljP);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ljQ = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lkb = typedArray.getBoolean(i, this.lkb);
        }
    }

    private void dbv() {
        if (this.ljQ != null) {
            this.ljW = ((BitmapDrawable) this.ljQ).getBitmap();
        }
        if (this.ljW == null) {
            this.ljW = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ljW = a.f(this.ljW, this.ljv);
        }
        this.ljX = a.e(this.ljW, 90);
        this.ljX = a.e(this.ljX, 90);
        this.ljX = a.e(this.ljX, 90);
        if (this.ljy != null) {
            this.ljU = ((BitmapDrawable) this.ljy).getBitmap();
        }
        if (this.ljU == null) {
            this.ljU = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ljU = a.f(this.ljU, this.ljv);
        }
        this.ljV = a.e(this.ljU, 90);
        this.ljY = (1.0f * this.ljr) / 2.0f;
        this.ljp.setTextSize(this.ljH);
        this.ljp.setColor(this.ljI);
        setIsBarcode(this.ljE);
    }

    public void dbw() {
        this.ljp.setColor(this.ljI);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ljm != null) {
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
            canvas.drawRect(0.0f, 0.0f, width, this.ljm.top, this.mPaint);
            canvas.drawRect(0.0f, this.ljm.top, this.ljm.left, this.ljm.bottom + 1, this.mPaint);
            canvas.drawRect(this.ljm.right + 1, this.ljm.top, width, this.ljm.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ljm.bottom + 1, width, height, this.mPaint);
        }
    }

    private void Z(Canvas canvas) {
        if (this.ljA > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ljA);
            canvas.drawRect(this.ljm, this.mPaint);
        }
    }

    private void aa(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.ljg, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ljh, getMainFrameRight() - this.ljg.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lji, getMainFrameLeft(), getMainFrameBottom() - this.ljg.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ljj, getMainFrameRight() - this.ljg.getWidth(), getMainFrameBottom() - this.ljg.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ljm.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ljm.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ljm.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ljm.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ljA / 2;
    }

    private void ab(Canvas canvas) {
        if (this.ljE) {
            if (this.ljR != null) {
                RectF rectF = new RectF(this.ljm.left + this.ljY + 0.5f, this.ljm.top + this.ljY + this.ljw, this.ljT, (this.ljm.bottom - this.ljY) - this.ljw);
                Rect rect = new Rect((int) (this.ljR.getWidth() - rectF.width()), 0, this.ljR.getWidth(), this.ljR.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ljR, rect, rectF, this.mPaint);
            } else if (this.ljz != null) {
                canvas.drawBitmap(this.ljz, (Rect) null, new RectF(this.ljo, this.ljm.top + this.ljY + this.ljw, this.ljo + this.ljz.getWidth(), (this.ljm.bottom - this.ljY) - this.ljw), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ljv);
                canvas.drawRect(this.ljo, this.ljw + this.ljm.top + this.ljY, this.lju + this.ljo, (this.ljm.bottom - this.ljY) - this.ljw, this.mPaint);
            }
        } else if (this.ljR != null) {
            RectF rectF2 = new RectF(this.ljm.left + this.ljY + this.ljw, this.ljm.top + this.ljY + 0.5f, (this.ljm.right - this.ljY) - this.ljw, this.ljS);
            Rect rect2 = new Rect(0, (int) (this.ljR.getHeight() - rectF2.height()), this.ljR.getWidth(), this.ljR.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lkc);
            canvas.drawBitmap(this.ljR, rect2, rectF2, this.mPaint);
        } else if (this.ljz != null) {
            canvas.drawBitmap(this.ljz, (Rect) null, new RectF(this.ljm.left + this.ljY + this.ljw, this.ljn, (this.ljm.right - this.ljY) - this.ljw, this.ljn + this.ljz.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ljv);
            canvas.drawRect(this.ljw + this.ljm.left + this.ljY, this.ljn, (this.ljm.right - this.ljY) - this.ljw, this.lju + this.ljn, this.mPaint);
        }
    }

    private void ac(Canvas canvas) {
        if (!TextUtils.isEmpty(this.jNy) && this.ljZ != null) {
            if (this.ljJ) {
                if (this.ljN) {
                    this.mPaint.setColor(this.ljM);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ljL) {
                        Rect rect = new Rect();
                        this.ljp.getTextBounds(this.jNy, 0, this.jNy.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lka;
                        canvas.drawRoundRect(new RectF(width, (this.ljm.bottom + this.ljK) - this.lka, rect.width() + width + (this.lka * 2), this.ljm.bottom + this.ljK + this.ljZ.getHeight() + this.lka), this.lka, this.lka, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ljm.left, (this.ljm.bottom + this.ljK) - this.lka, this.ljm.right, this.ljm.bottom + this.ljK + this.ljZ.getHeight() + this.lka), this.lka, this.lka, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ljL) {
                    canvas.translate(0.0f, this.ljm.bottom + this.ljK);
                } else {
                    canvas.translate(this.ljm.left + this.lka, this.ljm.bottom + this.ljK);
                }
                this.ljZ.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ljN) {
                this.mPaint.setColor(this.ljM);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ljL) {
                    Rect rect2 = new Rect();
                    this.ljp.getTextBounds(this.jNy, 0, this.jNy.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lka;
                    canvas.drawRoundRect(new RectF(width2, ((this.ljm.top - this.ljK) - this.ljZ.getHeight()) - this.lka, rect2.width() + width2 + (this.lka * 2), (this.ljm.top - this.ljK) + this.lka), this.lka, this.lka, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ljm.left, ((this.ljm.top - this.ljK) - this.ljZ.getHeight()) - this.lka, this.ljm.right, (this.ljm.top - this.ljK) + this.lka), this.lka, this.lka, this.mPaint);
                }
            }
            canvas.save();
            if (this.ljL) {
                canvas.translate(0.0f, (this.ljm.top - this.ljK) - this.ljZ.getHeight());
            } else {
                canvas.translate(this.ljm.left + this.lka, (this.ljm.top - this.ljK) - this.ljZ.getHeight());
            }
            this.ljZ.draw(canvas);
            canvas.restore();
        }
    }

    private void dbx() {
        if (this.ljE) {
            if (this.ljR == null) {
                this.ljo += this.ljk;
                int i = this.lju;
                if (this.ljz != null) {
                    i = this.ljz.getWidth();
                }
                if (this.ljO) {
                    if (i + this.ljo > this.ljm.right - this.ljY || this.ljo < this.ljm.left + this.ljY) {
                        this.ljk = -this.ljk;
                    }
                } else {
                    if (i + this.ljo > this.ljm.right - this.ljY) {
                        this.ljo = this.ljm.left + this.ljY + 0.5f;
                    }
                }
            } else {
                this.ljT += this.ljk;
                if (this.ljT > this.ljm.right - this.ljY) {
                    this.ljT = this.ljm.left + this.ljY + 0.5f;
                }
            }
        } else if (this.ljR == null) {
            this.ljn += this.ljk;
            int i2 = this.lju;
            if (this.ljz != null) {
                i2 = this.ljz.getHeight();
            }
            if (this.ljO) {
                if (i2 + this.ljn > this.ljm.bottom - this.ljY || this.ljn < this.ljm.top + this.ljY) {
                    this.ljk = -this.ljk;
                }
            } else {
                if (i2 + this.ljn > this.ljm.bottom - this.ljY) {
                    this.ljn = this.ljm.top + this.ljY + 0.5f;
                }
            }
        } else {
            this.ljS += this.ljk;
            if (this.ljS > this.ljm.bottom - this.ljY) {
                this.ljS = this.ljm.top + this.ljY + 0.5f;
            }
        }
        postInvalidateDelayed(this.ljl, this.ljm.left, this.ljm.top, this.ljm.right, this.ljm.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dby();
    }

    private void dby() {
        int i;
        if (this.ljE) {
            i = this.mTopOffset + this.ljD;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bLv) / 2;
        this.ljm = new Rect(width, i, this.bLv + width, this.ljs + i);
        if (this.ljE) {
            float f = this.ljm.left + this.ljY + 0.5f;
            this.ljo = f;
            this.ljT = f;
            return;
        }
        float f2 = this.ljm.top + this.ljY + 0.5f;
        this.ljn = f2;
        this.ljS = f2;
    }

    public Rect DE(int i) {
        if (this.lkb) {
            Rect rect = new Rect(this.ljm);
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
        this.ljE = z;
        if (this.ljQ != null || this.ljP) {
            if (this.ljE) {
                this.ljR = this.ljX;
            } else {
                this.ljR = this.ljW;
            }
        } else if (this.ljy != null || this.ljx) {
            if (this.ljE) {
                this.ljz = this.ljV;
            } else {
                this.ljz = this.ljU;
            }
        }
        if (this.ljE) {
            this.jNy = this.ljG;
            this.ljs = this.ljt;
            this.ljl = (int) (((this.ljB * 1.0f) * this.ljk) / this.bLv);
        } else {
            this.jNy = this.ljF;
            this.ljs = this.bLv;
            this.ljl = (int) (((this.ljB * 1.0f) * this.ljk) / this.ljs);
        }
        if (!TextUtils.isEmpty(this.jNy)) {
            if (this.ljL) {
                this.ljZ = new StaticLayout(this.jNy, this.ljp, a.fk(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ljZ = new StaticLayout(this.jNy, this.ljp, this.bLv - (this.lka * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ljC) {
            int i = a.fk(getContext()).y;
            if (this.ljD == 0) {
                this.mTopOffset = (i - this.ljs) / 2;
            } else if (this.ljE) {
                this.mTopOffset = ((i - this.ljs) / 2) + (this.ljD / 2);
            } else {
                this.mTopOffset = (i - this.ljs) / 2;
            }
        }
        dby();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ljE;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.ljq;
    }

    public void setCornerLength(int i) {
        this.ljq = i;
    }

    public int getCornerSize() {
        return this.ljr;
    }

    public void setCornerSize(int i) {
        this.ljr = i;
    }

    public int getRectWidth() {
        return this.bLv;
    }

    public void setRectWidth(int i) {
        this.bLv = i;
    }

    public int getRectHeight() {
        return this.ljs;
    }

    public void setRectHeight(int i) {
        this.ljs = i;
    }

    public int getBarcodeRectHeight() {
        return this.ljt;
    }

    public void setBarcodeRectHeight(int i) {
        this.ljt = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lju;
    }

    public void setScanLineSize(int i) {
        this.lju = i;
    }

    public int getScanLineColor() {
        return this.ljv;
    }

    public void setScanLineColor(int i) {
        this.ljv = i;
    }

    public int getScanLineMargin() {
        return this.ljw;
    }

    public void setScanLineMargin(int i) {
        this.ljw = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ljx = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ljy;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ljy = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ljz;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ljz = bitmap;
    }

    public int getBorderSize() {
        return this.ljA;
    }

    public void setBorderSize(int i) {
        this.ljA = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ljB;
    }

    public void setAnimTime(int i) {
        this.ljB = i;
    }

    public void setCenterVertical(boolean z) {
        this.ljC = z;
    }

    public int getToolbarHeight() {
        return this.ljD;
    }

    public void setToolbarHeight(int i) {
        this.ljD = i;
    }

    public String getQRCodeTipText() {
        return this.ljF;
    }

    public void setQRCodeTipText(String str) {
        this.ljF = str;
    }

    public String getBarCodeTipText() {
        return this.ljG;
    }

    public void setBarCodeTipText(String str) {
        this.ljG = str;
    }

    public String getTipText() {
        return this.jNy;
    }

    public void setTipText(String str) {
        this.jNy = str;
    }

    public int getTipTextColor() {
        return this.ljI;
    }

    public void setTipTextColor(int i) {
        this.ljI = i;
    }

    public int getTipTextSize() {
        return this.ljH;
    }

    public void setTipTextSize(int i) {
        this.ljH = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ljJ = z;
    }

    public int getTipTextMargin() {
        return this.ljK;
    }

    public void setTipTextMargin(int i) {
        this.ljK = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ljL = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ljN = z;
    }

    public int getTipBackgroundColor() {
        return this.ljM;
    }

    public void setTipBackgroundColor(int i) {
        this.ljM = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ljO = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ljP = z;
    }

    public float getHalfCornerSize() {
        return this.ljY;
    }

    public void setHalfCornerSize(float f) {
        this.ljY = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ljZ;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ljZ = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lka;
    }

    public void setTipBackgroundRadius(int i) {
        this.lka = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lkb = z;
    }
}
