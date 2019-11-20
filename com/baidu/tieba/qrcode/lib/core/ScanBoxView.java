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
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
    private String hsd;
    private int iEA;
    private int iEB;
    private int iEC;
    private int iED;
    private int iEE;
    private int iEF;
    private int iEG;
    private int iEH;
    private boolean iEI;
    private Drawable iEJ;
    private Bitmap iEK;
    private int iEL;
    private int iEM;
    private boolean iEN;
    private int iEO;
    private boolean iEP;
    private String iEQ;
    private String iER;
    private int iES;
    private int iET;
    private boolean iEU;
    private int iEV;
    private boolean iEW;
    private int iEX;
    private boolean iEY;
    private boolean iEZ;
    private Bitmap iEq;
    private Bitmap iEr;
    private Bitmap iEs;
    private Bitmap iEt;
    private int iEu;
    private int iEv;
    private Rect iEw;
    private float iEx;
    private float iEy;
    private TextPaint iEz;
    private boolean iFa;
    private Drawable iFb;
    private Bitmap iFc;
    private float iFd;
    private float iFe;
    private Bitmap iFf;
    private Bitmap iFg;
    private Bitmap iFh;
    private Bitmap iFi;
    private float iFj;
    private StaticLayout iFk;
    private int iFl;
    private boolean iFm;
    private ColorMatrixColorFilter iFn;
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
        this.iEA = a.h(context, 20.0f);
        this.iEB = a.h(context, 3.0f);
        this.iEF = a.h(context, 1.0f);
        this.iEG = -1;
        this.mTopOffset = a.h(context, 90.0f);
        this.iEC = a.h(context, 200.0f);
        this.iEE = a.h(context, 140.0f);
        this.iEH = 0;
        this.iEI = false;
        this.iEJ = null;
        this.iEK = null;
        this.iEL = a.h(context, 1.0f);
        this.mBorderColor = -1;
        this.iEM = 1000;
        this.iEN = false;
        this.iEO = 0;
        this.iEP = false;
        this.iEu = a.h(context, 2.0f);
        this.hsd = null;
        this.iES = a.g(context, 14.0f);
        this.iET = -1;
        this.iEU = false;
        this.iEV = a.h(context, 20.0f);
        this.iEW = false;
        this.iEX = Color.parseColor("#22000000");
        this.iEY = false;
        this.iEZ = false;
        this.iFa = false;
        this.iEz = new TextPaint();
        this.iEz.setAntiAlias(true);
        this.iFl = a.h(context, 4.0f);
        this.iFm = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.iFn = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cfd();
        cfc();
    }

    private void cfc() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iEA;
        options.outHeight = this.iEA;
        this.iEq = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iEr = Bitmap.createBitmap(this.iEq, 0, 0, this.iEq.getWidth(), this.iEq.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iEs = Bitmap.createBitmap(this.iEq, 0, 0, this.iEq.getWidth(), this.iEq.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iEt = Bitmap.createBitmap(this.iEq, 0, 0, this.iEq.getWidth(), this.iEq.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.iEB = typedArray.getDimensionPixelSize(i, this.iEB);
        } else if (i == 2) {
            this.iEA = typedArray.getDimensionPixelSize(i, this.iEA);
        } else if (i == 6) {
            this.iEF = typedArray.getDimensionPixelSize(i, this.iEF);
        } else if (i == 3) {
            this.iEC = typedArray.getDimensionPixelSize(i, this.iEC);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.iEG = typedArray.getColor(i, this.iEG);
        } else if (i == 8) {
            this.iEH = typedArray.getDimensionPixelSize(i, this.iEH);
        } else if (i == 9) {
            this.iEI = typedArray.getBoolean(i, this.iEI);
        } else if (i == 10) {
            this.iEJ = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.iEL = typedArray.getDimensionPixelSize(i, this.iEL);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.iEM = typedArray.getInteger(i, this.iEM);
        } else if (i == 14) {
            this.iEN = typedArray.getBoolean(i, this.iEN);
        } else if (i == 15) {
            this.iEO = typedArray.getDimensionPixelSize(i, this.iEO);
        } else if (i == 4) {
            this.iEE = typedArray.getDimensionPixelSize(i, this.iEE);
        } else if (i == 16) {
            this.iEP = typedArray.getBoolean(i, this.iEP);
        } else if (i == 18) {
            this.iER = typedArray.getString(i);
        } else if (i == 17) {
            this.iEQ = typedArray.getString(i);
        } else if (i == 19) {
            this.iES = typedArray.getDimensionPixelSize(i, this.iES);
        } else if (i == 20) {
            this.iET = typedArray.getColor(i, this.iET);
        } else if (i == 21) {
            this.iEU = typedArray.getBoolean(i, this.iEU);
        } else if (i == 22) {
            this.iEV = typedArray.getDimensionPixelSize(i, this.iEV);
        } else if (i == 23) {
            this.iEW = typedArray.getBoolean(i, this.iEW);
        } else if (i == 24) {
            this.iEY = typedArray.getBoolean(i, this.iEY);
        } else if (i == 25) {
            this.iEX = typedArray.getColor(i, this.iEX);
        } else if (i == 26) {
            this.iEZ = typedArray.getBoolean(i, this.iEZ);
        } else if (i == 27) {
            this.iFa = typedArray.getBoolean(i, this.iFa);
        } else if (i == 28) {
            this.iFb = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.iFm = typedArray.getBoolean(i, this.iFm);
        }
    }

    private void cfd() {
        if (this.iFb != null) {
            this.iFh = ((BitmapDrawable) this.iFb).getBitmap();
        }
        if (this.iFh == null) {
            this.iFh = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFh = a.d(this.iFh, this.iEG);
        }
        this.iFi = a.adjustPhotoRotation(this.iFh, 90);
        this.iFi = a.adjustPhotoRotation(this.iFi, 90);
        this.iFi = a.adjustPhotoRotation(this.iFi, 90);
        if (this.iEJ != null) {
            this.iFf = ((BitmapDrawable) this.iEJ).getBitmap();
        }
        if (this.iFf == null) {
            this.iFf = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFf = a.d(this.iFf, this.iEG);
        }
        this.iFg = a.adjustPhotoRotation(this.iFf, 90);
        this.iFj = (1.0f * this.iEB) / 2.0f;
        this.iEz.setTextSize(this.iES);
        this.iEz.setColor(this.iET);
        setIsBarcode(this.iEP);
    }

    public void cfe() {
        this.iEz.setColor(this.iET);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.iEw != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            cff();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.iEw.top, this.mPaint);
            canvas.drawRect(0.0f, this.iEw.top, this.iEw.left, this.iEw.bottom + 1, this.mPaint);
            canvas.drawRect(this.iEw.right + 1, this.iEw.top, width, this.iEw.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.iEw.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.iEL > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.iEL);
            canvas.drawRect(this.iEw, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iEq, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iEr, getMainFrameRight() - this.iEq.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iEs, getMainFrameLeft(), getMainFrameBottom() - this.iEq.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iEt, getMainFrameRight() - this.iEq.getWidth(), getMainFrameBottom() - this.iEq.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.iEw.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.iEw.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.iEw.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.iEw.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.iEL / 2;
    }

    private void W(Canvas canvas) {
        if (this.iEP) {
            if (this.iFc != null) {
                RectF rectF = new RectF(this.iEw.left + this.iFj + 0.5f, this.iEw.top + this.iFj + this.iEH, this.iFe, (this.iEw.bottom - this.iFj) - this.iEH);
                Rect rect = new Rect((int) (this.iFc.getWidth() - rectF.width()), 0, this.iFc.getWidth(), this.iFc.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.iFc, rect, rectF, this.mPaint);
            } else if (this.iEK != null) {
                canvas.drawBitmap(this.iEK, (Rect) null, new RectF(this.iEy, this.iEw.top + this.iFj + this.iEH, this.iEy + this.iEK.getWidth(), (this.iEw.bottom - this.iFj) - this.iEH), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.iEG);
                canvas.drawRect(this.iEy, this.iEH + this.iEw.top + this.iFj, this.iEF + this.iEy, (this.iEw.bottom - this.iFj) - this.iEH, this.mPaint);
            }
        } else if (this.iFc != null) {
            RectF rectF2 = new RectF(this.iEw.left + this.iFj + this.iEH, this.iEw.top + this.iFj + 0.5f, (this.iEw.right - this.iFj) - this.iEH, this.iFd);
            Rect rect2 = new Rect(0, (int) (this.iFc.getHeight() - rectF2.height()), this.iFc.getWidth(), this.iFc.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.iFn);
            canvas.drawBitmap(this.iFc, rect2, rectF2, this.mPaint);
        } else if (this.iEK != null) {
            canvas.drawBitmap(this.iEK, (Rect) null, new RectF(this.iEw.left + this.iFj + this.iEH, this.iEx, (this.iEw.right - this.iFj) - this.iEH, this.iEx + this.iEK.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.iEG);
            canvas.drawRect(this.iEH + this.iEw.left + this.iFj, this.iEx, (this.iEw.right - this.iFj) - this.iEH, this.iEF + this.iEx, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hsd) && this.iFk != null) {
            if (this.iEU) {
                if (this.iEY) {
                    this.mPaint.setColor(this.iEX);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.iEW) {
                        Rect rect = new Rect();
                        this.iEz.getTextBounds(this.hsd, 0, this.hsd.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iFl;
                        canvas.drawRoundRect(new RectF(width, (this.iEw.bottom + this.iEV) - this.iFl, rect.width() + width + (this.iFl * 2), this.iEw.bottom + this.iEV + this.iFk.getHeight() + this.iFl), this.iFl, this.iFl, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.iEw.left, (this.iEw.bottom + this.iEV) - this.iFl, this.iEw.right, this.iEw.bottom + this.iEV + this.iFk.getHeight() + this.iFl), this.iFl, this.iFl, this.mPaint);
                    }
                }
                canvas.save();
                if (this.iEW) {
                    canvas.translate(0.0f, this.iEw.bottom + this.iEV);
                } else {
                    canvas.translate(this.iEw.left + this.iFl, this.iEw.bottom + this.iEV);
                }
                this.iFk.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.iEY) {
                this.mPaint.setColor(this.iEX);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.iEW) {
                    Rect rect2 = new Rect();
                    this.iEz.getTextBounds(this.hsd, 0, this.hsd.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iFl;
                    canvas.drawRoundRect(new RectF(width2, ((this.iEw.top - this.iEV) - this.iFk.getHeight()) - this.iFl, rect2.width() + width2 + (this.iFl * 2), (this.iEw.top - this.iEV) + this.iFl), this.iFl, this.iFl, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.iEw.left, ((this.iEw.top - this.iEV) - this.iFk.getHeight()) - this.iFl, this.iEw.right, (this.iEw.top - this.iEV) + this.iFl), this.iFl, this.iFl, this.mPaint);
                }
            }
            canvas.save();
            if (this.iEW) {
                canvas.translate(0.0f, (this.iEw.top - this.iEV) - this.iFk.getHeight());
            } else {
                canvas.translate(this.iEw.left + this.iFl, (this.iEw.top - this.iEV) - this.iFk.getHeight());
            }
            this.iFk.draw(canvas);
            canvas.restore();
        }
    }

    private void cff() {
        if (this.iEP) {
            if (this.iFc == null) {
                this.iEy += this.iEu;
                int i = this.iEF;
                if (this.iEK != null) {
                    i = this.iEK.getWidth();
                }
                if (this.iEZ) {
                    if (i + this.iEy > this.iEw.right - this.iFj || this.iEy < this.iEw.left + this.iFj) {
                        this.iEu = -this.iEu;
                    }
                } else {
                    if (i + this.iEy > this.iEw.right - this.iFj) {
                        this.iEy = this.iEw.left + this.iFj + 0.5f;
                    }
                }
            } else {
                this.iFe += this.iEu;
                if (this.iFe > this.iEw.right - this.iFj) {
                    this.iFe = this.iEw.left + this.iFj + 0.5f;
                }
            }
        } else if (this.iFc == null) {
            this.iEx += this.iEu;
            int i2 = this.iEF;
            if (this.iEK != null) {
                i2 = this.iEK.getHeight();
            }
            if (this.iEZ) {
                if (i2 + this.iEx > this.iEw.bottom - this.iFj || this.iEx < this.iEw.top + this.iFj) {
                    this.iEu = -this.iEu;
                }
            } else {
                if (i2 + this.iEx > this.iEw.bottom - this.iFj) {
                    this.iEx = this.iEw.top + this.iFj + 0.5f;
                }
            }
        } else {
            this.iFd += this.iEu;
            if (this.iFd > this.iEw.bottom - this.iFj) {
                this.iFd = this.iEw.top + this.iFj + 0.5f;
            }
        }
        postInvalidateDelayed(this.iEv, this.iEw.left, this.iEw.top, this.iEw.right, this.iEw.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cfg();
    }

    private void cfg() {
        int i;
        if (this.iEP) {
            i = this.mTopOffset + this.iEO;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.iEC) / 2;
        this.iEw = new Rect(width, i, this.iEC + width, this.iED + i);
        if (this.iEP) {
            float f = this.iEw.left + this.iFj + 0.5f;
            this.iEy = f;
            this.iFe = f;
            return;
        }
        float f2 = this.iEw.top + this.iFj + 0.5f;
        this.iEx = f2;
        this.iFd = f2;
    }

    public Rect yc(int i) {
        if (this.iFm) {
            Rect rect = new Rect(this.iEw);
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
        this.iEP = z;
        if (this.iFb != null || this.iFa) {
            if (this.iEP) {
                this.iFc = this.iFi;
            } else {
                this.iFc = this.iFh;
            }
        } else if (this.iEJ != null || this.iEI) {
            if (this.iEP) {
                this.iEK = this.iFg;
            } else {
                this.iEK = this.iFf;
            }
        }
        if (this.iEP) {
            this.hsd = this.iER;
            this.iED = this.iEE;
            this.iEv = (int) (((this.iEM * 1.0f) * this.iEu) / this.iEC);
        } else {
            this.hsd = this.iEQ;
            this.iED = this.iEC;
            this.iEv = (int) (((this.iEM * 1.0f) * this.iEu) / this.iED);
        }
        if (!TextUtils.isEmpty(this.hsd)) {
            if (this.iEW) {
                this.iFk = new StaticLayout(this.hsd, this.iEz, a.dU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iFk = new StaticLayout(this.hsd, this.iEz, this.iEC - (this.iFl * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.iEN) {
            int i = a.dU(getContext()).y;
            if (this.iEO == 0) {
                this.mTopOffset = (i - this.iED) / 2;
            } else if (this.iEP) {
                this.mTopOffset = ((i - this.iED) / 2) + (this.iEO / 2);
            } else {
                this.mTopOffset = (i - this.iED) / 2;
            }
        }
        cfg();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.iEP;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.iEA;
    }

    public void setCornerLength(int i) {
        this.iEA = i;
    }

    public int getCornerSize() {
        return this.iEB;
    }

    public void setCornerSize(int i) {
        this.iEB = i;
    }

    public int getRectWidth() {
        return this.iEC;
    }

    public void setRectWidth(int i) {
        this.iEC = i;
    }

    public int getRectHeight() {
        return this.iED;
    }

    public void setRectHeight(int i) {
        this.iED = i;
    }

    public int getBarcodeRectHeight() {
        return this.iEE;
    }

    public void setBarcodeRectHeight(int i) {
        this.iEE = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.iEF;
    }

    public void setScanLineSize(int i) {
        this.iEF = i;
    }

    public int getScanLineColor() {
        return this.iEG;
    }

    public void setScanLineColor(int i) {
        this.iEG = i;
    }

    public int getScanLineMargin() {
        return this.iEH;
    }

    public void setScanLineMargin(int i) {
        this.iEH = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.iEI = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.iEJ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.iEJ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.iEK;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.iEK = bitmap;
    }

    public int getBorderSize() {
        return this.iEL;
    }

    public void setBorderSize(int i) {
        this.iEL = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.iEM;
    }

    public void setAnimTime(int i) {
        this.iEM = i;
    }

    public void setCenterVertical(boolean z) {
        this.iEN = z;
    }

    public int getToolbarHeight() {
        return this.iEO;
    }

    public void setToolbarHeight(int i) {
        this.iEO = i;
    }

    public String getQRCodeTipText() {
        return this.iEQ;
    }

    public void setQRCodeTipText(String str) {
        this.iEQ = str;
    }

    public String getBarCodeTipText() {
        return this.iER;
    }

    public void setBarCodeTipText(String str) {
        this.iER = str;
    }

    public String getTipText() {
        return this.hsd;
    }

    public void setTipText(String str) {
        this.hsd = str;
    }

    public int getTipTextColor() {
        return this.iET;
    }

    public void setTipTextColor(int i) {
        this.iET = i;
    }

    public int getTipTextSize() {
        return this.iES;
    }

    public void setTipTextSize(int i) {
        this.iES = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.iEU = z;
    }

    public int getTipTextMargin() {
        return this.iEV;
    }

    public void setTipTextMargin(int i) {
        this.iEV = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.iEW = z;
    }

    public void setShowTipBackground(boolean z) {
        this.iEY = z;
    }

    public int getTipBackgroundColor() {
        return this.iEX;
    }

    public void setTipBackgroundColor(int i) {
        this.iEX = i;
    }

    public void setScanLineReverse(boolean z) {
        this.iEZ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.iFa = z;
    }

    public float getHalfCornerSize() {
        return this.iFj;
    }

    public void setHalfCornerSize(float f) {
        this.iFj = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iFk;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iFk = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iFl;
    }

    public void setTipBackgroundRadius(int i) {
        this.iFl = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.iFm = z;
    }
}
