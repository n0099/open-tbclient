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
import com.baidu.tieba.c;
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
    private int GW;
    private int bYg;
    private int cDV;
    private String hrs;
    private int iDA;
    private int iDB;
    private int iDC;
    private int iDD;
    private int iDE;
    private int iDF;
    private int iDG;
    private int iDH;
    private boolean iDI;
    private Drawable iDJ;
    private Bitmap iDK;
    private int iDL;
    private int iDM;
    private boolean iDN;
    private int iDO;
    private boolean iDP;
    private String iDQ;
    private String iDR;
    private int iDS;
    private int iDT;
    private boolean iDU;
    private int iDV;
    private boolean iDW;
    private int iDX;
    private boolean iDY;
    private boolean iDZ;
    private Bitmap iDq;
    private Bitmap iDr;
    private Bitmap iDs;
    private Bitmap iDt;
    private int iDu;
    private int iDv;
    private Rect iDw;
    private float iDx;
    private float iDy;
    private TextPaint iDz;
    private boolean iEa;
    private Drawable iEb;
    private Bitmap iEc;
    private float iEd;
    private float iEe;
    private Bitmap iEf;
    private Bitmap iEg;
    private Bitmap iEh;
    private Bitmap iEi;
    private float iEj;
    private StaticLayout iEk;
    private int iEl;
    private boolean iEm;
    private ColorMatrixColorFilter iEn;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bYg = Color.parseColor("#33FFFFFF");
        this.iDA = a.e(context, 20.0f);
        this.iDB = a.e(context, 3.0f);
        this.iDF = a.e(context, 1.0f);
        this.iDG = -1;
        this.cDV = a.e(context, 90.0f);
        this.iDC = a.e(context, 200.0f);
        this.iDE = a.e(context, 140.0f);
        this.iDH = 0;
        this.iDI = false;
        this.iDJ = null;
        this.iDK = null;
        this.iDL = a.e(context, 1.0f);
        this.GW = -1;
        this.iDM = 1000;
        this.iDN = false;
        this.iDO = 0;
        this.iDP = false;
        this.iDu = a.e(context, 2.0f);
        this.hrs = null;
        this.iDS = a.sp2px(context, 14.0f);
        this.iDT = -1;
        this.iDU = false;
        this.iDV = a.e(context, 20.0f);
        this.iDW = false;
        this.iDX = Color.parseColor("#22000000");
        this.iDY = false;
        this.iDZ = false;
        this.iEa = false;
        this.iDz = new TextPaint();
        this.iDz.setAntiAlias(true);
        this.iEl = a.e(context, 4.0f);
        this.iEm = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.iEn = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cha();
        cgZ();
    }

    private void cgZ() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iDA;
        options.outHeight = this.iDA;
        this.iDq = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iDr = Bitmap.createBitmap(this.iDq, 0, 0, this.iDq.getWidth(), this.iDq.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iDs = Bitmap.createBitmap(this.iDq, 0, 0, this.iDq.getWidth(), this.iDq.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iDt = Bitmap.createBitmap(this.iDq, 0, 0, this.iDq.getWidth(), this.iDq.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cDV = typedArray.getDimensionPixelSize(i, this.cDV);
        } else if (i == 1) {
            this.iDB = typedArray.getDimensionPixelSize(i, this.iDB);
        } else if (i == 2) {
            this.iDA = typedArray.getDimensionPixelSize(i, this.iDA);
        } else if (i == 6) {
            this.iDF = typedArray.getDimensionPixelSize(i, this.iDF);
        } else if (i == 3) {
            this.iDC = typedArray.getDimensionPixelSize(i, this.iDC);
        } else if (i == 5) {
            this.bYg = typedArray.getColor(i, this.bYg);
        } else if (i == 7) {
            this.iDG = typedArray.getColor(i, this.iDG);
        } else if (i == 8) {
            this.iDH = typedArray.getDimensionPixelSize(i, this.iDH);
        } else if (i == 9) {
            this.iDI = typedArray.getBoolean(i, this.iDI);
        } else if (i == 10) {
            this.iDJ = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.iDL = typedArray.getDimensionPixelSize(i, this.iDL);
        } else if (i == 12) {
            this.GW = typedArray.getColor(i, this.GW);
        } else if (i == 13) {
            this.iDM = typedArray.getInteger(i, this.iDM);
        } else if (i == 14) {
            this.iDN = typedArray.getBoolean(i, this.iDN);
        } else if (i == 15) {
            this.iDO = typedArray.getDimensionPixelSize(i, this.iDO);
        } else if (i == 4) {
            this.iDE = typedArray.getDimensionPixelSize(i, this.iDE);
        } else if (i == 16) {
            this.iDP = typedArray.getBoolean(i, this.iDP);
        } else if (i == 18) {
            this.iDR = typedArray.getString(i);
        } else if (i == 17) {
            this.iDQ = typedArray.getString(i);
        } else if (i == 19) {
            this.iDS = typedArray.getDimensionPixelSize(i, this.iDS);
        } else if (i == 20) {
            this.iDT = typedArray.getColor(i, this.iDT);
        } else if (i == 21) {
            this.iDU = typedArray.getBoolean(i, this.iDU);
        } else if (i == 22) {
            this.iDV = typedArray.getDimensionPixelSize(i, this.iDV);
        } else if (i == 23) {
            this.iDW = typedArray.getBoolean(i, this.iDW);
        } else if (i == 24) {
            this.iDY = typedArray.getBoolean(i, this.iDY);
        } else if (i == 25) {
            this.iDX = typedArray.getColor(i, this.iDX);
        } else if (i == 26) {
            this.iDZ = typedArray.getBoolean(i, this.iDZ);
        } else if (i == 27) {
            this.iEa = typedArray.getBoolean(i, this.iEa);
        } else if (i == 28) {
            this.iEb = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.iEm = typedArray.getBoolean(i, this.iEm);
        }
    }

    private void cha() {
        if (this.iEb != null) {
            this.iEh = ((BitmapDrawable) this.iEb).getBitmap();
        }
        if (this.iEh == null) {
            this.iEh = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iEh = a.e(this.iEh, this.iDG);
        }
        this.iEi = a.adjustPhotoRotation(this.iEh, 90);
        this.iEi = a.adjustPhotoRotation(this.iEi, 90);
        this.iEi = a.adjustPhotoRotation(this.iEi, 90);
        if (this.iDJ != null) {
            this.iEf = ((BitmapDrawable) this.iDJ).getBitmap();
        }
        if (this.iEf == null) {
            this.iEf = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iEf = a.e(this.iEf, this.iDG);
        }
        this.iEg = a.adjustPhotoRotation(this.iEf, 90);
        this.iEj = (1.0f * this.iDB) / 2.0f;
        this.iDz.setTextSize(this.iDS);
        this.iDz.setColor(this.iDT);
        setIsBarcode(this.iDP);
    }

    public void chb() {
        this.iDz.setColor(this.iDT);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.iDw != null) {
            U(canvas);
            V(canvas);
            X(canvas);
            Y(canvas);
            W(canvas);
            chc();
        }
    }

    private void U(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bYg != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bYg);
            canvas.drawRect(0.0f, 0.0f, width, this.iDw.top, this.mPaint);
            canvas.drawRect(0.0f, this.iDw.top, this.iDw.left, this.iDw.bottom + 1, this.mPaint);
            canvas.drawRect(this.iDw.right + 1, this.iDw.top, width, this.iDw.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.iDw.bottom + 1, width, height, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (this.iDL > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.GW);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.iDL);
            canvas.drawRect(this.iDw, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iDq, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iDr, getMainFrameRight() - this.iDq.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iDs, getMainFrameLeft(), getMainFrameBottom() - this.iDq.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iDt, getMainFrameRight() - this.iDq.getWidth(), getMainFrameBottom() - this.iDq.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.iDw.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.iDw.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.iDw.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.iDw.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.iDL / 2;
    }

    private void X(Canvas canvas) {
        if (this.iDP) {
            if (this.iEc != null) {
                RectF rectF = new RectF(this.iDw.left + this.iEj + 0.5f, this.iDw.top + this.iEj + this.iDH, this.iEe, (this.iDw.bottom - this.iEj) - this.iDH);
                Rect rect = new Rect((int) (this.iEc.getWidth() - rectF.width()), 0, this.iEc.getWidth(), this.iEc.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.iEc, rect, rectF, this.mPaint);
            } else if (this.iDK != null) {
                canvas.drawBitmap(this.iDK, (Rect) null, new RectF(this.iDy, this.iDw.top + this.iEj + this.iDH, this.iDy + this.iDK.getWidth(), (this.iDw.bottom - this.iEj) - this.iDH), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.iDG);
                canvas.drawRect(this.iDy, this.iDH + this.iDw.top + this.iEj, this.iDF + this.iDy, (this.iDw.bottom - this.iEj) - this.iDH, this.mPaint);
            }
        } else if (this.iEc != null) {
            RectF rectF2 = new RectF(this.iDw.left + this.iEj + this.iDH, this.iDw.top + this.iEj + 0.5f, (this.iDw.right - this.iEj) - this.iDH, this.iEd);
            Rect rect2 = new Rect(0, (int) (this.iEc.getHeight() - rectF2.height()), this.iEc.getWidth(), this.iEc.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.iEn);
            canvas.drawBitmap(this.iEc, rect2, rectF2, this.mPaint);
        } else if (this.iDK != null) {
            canvas.drawBitmap(this.iDK, (Rect) null, new RectF(this.iDw.left + this.iEj + this.iDH, this.iDx, (this.iDw.right - this.iEj) - this.iDH, this.iDx + this.iDK.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.iDG);
            canvas.drawRect(this.iDH + this.iDw.left + this.iEj, this.iDx, (this.iDw.right - this.iEj) - this.iDH, this.iDF + this.iDx, this.mPaint);
        }
    }

    private void Y(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hrs) && this.iEk != null) {
            if (this.iDU) {
                if (this.iDY) {
                    this.mPaint.setColor(this.iDX);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.iDW) {
                        Rect rect = new Rect();
                        this.iDz.getTextBounds(this.hrs, 0, this.hrs.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iEl;
                        canvas.drawRoundRect(new RectF(width, (this.iDw.bottom + this.iDV) - this.iEl, rect.width() + width + (this.iEl * 2), this.iDw.bottom + this.iDV + this.iEk.getHeight() + this.iEl), this.iEl, this.iEl, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.iDw.left, (this.iDw.bottom + this.iDV) - this.iEl, this.iDw.right, this.iDw.bottom + this.iDV + this.iEk.getHeight() + this.iEl), this.iEl, this.iEl, this.mPaint);
                    }
                }
                canvas.save();
                if (this.iDW) {
                    canvas.translate(0.0f, this.iDw.bottom + this.iDV);
                } else {
                    canvas.translate(this.iDw.left + this.iEl, this.iDw.bottom + this.iDV);
                }
                this.iEk.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.iDY) {
                this.mPaint.setColor(this.iDX);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.iDW) {
                    Rect rect2 = new Rect();
                    this.iDz.getTextBounds(this.hrs, 0, this.hrs.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iEl;
                    canvas.drawRoundRect(new RectF(width2, ((this.iDw.top - this.iDV) - this.iEk.getHeight()) - this.iEl, rect2.width() + width2 + (this.iEl * 2), (this.iDw.top - this.iDV) + this.iEl), this.iEl, this.iEl, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.iDw.left, ((this.iDw.top - this.iDV) - this.iEk.getHeight()) - this.iEl, this.iDw.right, (this.iDw.top - this.iDV) + this.iEl), this.iEl, this.iEl, this.mPaint);
                }
            }
            canvas.save();
            if (this.iDW) {
                canvas.translate(0.0f, (this.iDw.top - this.iDV) - this.iEk.getHeight());
            } else {
                canvas.translate(this.iDw.left + this.iEl, (this.iDw.top - this.iDV) - this.iEk.getHeight());
            }
            this.iEk.draw(canvas);
            canvas.restore();
        }
    }

    private void chc() {
        if (this.iDP) {
            if (this.iEc == null) {
                this.iDy += this.iDu;
                int i = this.iDF;
                if (this.iDK != null) {
                    i = this.iDK.getWidth();
                }
                if (this.iDZ) {
                    if (i + this.iDy > this.iDw.right - this.iEj || this.iDy < this.iDw.left + this.iEj) {
                        this.iDu = -this.iDu;
                    }
                } else {
                    if (i + this.iDy > this.iDw.right - this.iEj) {
                        this.iDy = this.iDw.left + this.iEj + 0.5f;
                    }
                }
            } else {
                this.iEe += this.iDu;
                if (this.iEe > this.iDw.right - this.iEj) {
                    this.iEe = this.iDw.left + this.iEj + 0.5f;
                }
            }
        } else if (this.iEc == null) {
            this.iDx += this.iDu;
            int i2 = this.iDF;
            if (this.iDK != null) {
                i2 = this.iDK.getHeight();
            }
            if (this.iDZ) {
                if (i2 + this.iDx > this.iDw.bottom - this.iEj || this.iDx < this.iDw.top + this.iEj) {
                    this.iDu = -this.iDu;
                }
            } else {
                if (i2 + this.iDx > this.iDw.bottom - this.iEj) {
                    this.iDx = this.iDw.top + this.iEj + 0.5f;
                }
            }
        } else {
            this.iEd += this.iDu;
            if (this.iEd > this.iDw.bottom - this.iEj) {
                this.iEd = this.iDw.top + this.iEj + 0.5f;
            }
        }
        postInvalidateDelayed(this.iDv, this.iDw.left, this.iDw.top, this.iDw.right, this.iDw.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        chd();
    }

    private void chd() {
        int i;
        if (this.iDP) {
            i = this.cDV + this.iDO;
        } else {
            i = this.cDV;
        }
        int width = (getWidth() - this.iDC) / 2;
        this.iDw = new Rect(width, i, this.iDC + width, this.iDD + i);
        if (this.iDP) {
            float f = this.iDw.left + this.iEj + 0.5f;
            this.iDy = f;
            this.iEe = f;
            return;
        }
        float f2 = this.iDw.top + this.iEj + 0.5f;
        this.iDx = f2;
        this.iEd = f2;
    }

    public Rect zt(int i) {
        if (this.iEm) {
            Rect rect = new Rect(this.iDw);
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
        this.iDP = z;
        if (this.iEb != null || this.iEa) {
            if (this.iDP) {
                this.iEc = this.iEi;
            } else {
                this.iEc = this.iEh;
            }
        } else if (this.iDJ != null || this.iDI) {
            if (this.iDP) {
                this.iDK = this.iEg;
            } else {
                this.iDK = this.iEf;
            }
        }
        if (this.iDP) {
            this.hrs = this.iDR;
            this.iDD = this.iDE;
            this.iDv = (int) (((this.iDM * 1.0f) * this.iDu) / this.iDC);
        } else {
            this.hrs = this.iDQ;
            this.iDD = this.iDC;
            this.iDv = (int) (((this.iDM * 1.0f) * this.iDu) / this.iDD);
        }
        if (!TextUtils.isEmpty(this.hrs)) {
            if (this.iDW) {
                this.iEk = new StaticLayout(this.hrs, this.iDz, a.eg(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iEk = new StaticLayout(this.hrs, this.iDz, this.iDC - (this.iEl * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.iDN) {
            int i = a.eg(getContext()).y;
            if (this.iDO == 0) {
                this.cDV = (i - this.iDD) / 2;
            } else if (this.iDP) {
                this.cDV = ((i - this.iDD) / 2) + (this.iDO / 2);
            } else {
                this.cDV = (i - this.iDD) / 2;
            }
        }
        chd();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.iDP;
    }

    public int getMaskColor() {
        return this.bYg;
    }

    public void setMaskColor(int i) {
        this.bYg = i;
    }

    public int getCornerLength() {
        return this.iDA;
    }

    public void setCornerLength(int i) {
        this.iDA = i;
    }

    public int getCornerSize() {
        return this.iDB;
    }

    public void setCornerSize(int i) {
        this.iDB = i;
    }

    public int getRectWidth() {
        return this.iDC;
    }

    public void setRectWidth(int i) {
        this.iDC = i;
    }

    public int getRectHeight() {
        return this.iDD;
    }

    public void setRectHeight(int i) {
        this.iDD = i;
    }

    public int getBarcodeRectHeight() {
        return this.iDE;
    }

    public void setBarcodeRectHeight(int i) {
        this.iDE = i;
    }

    public int getTopOffset() {
        return this.cDV;
    }

    public void setTopOffset(int i) {
        this.cDV = i;
    }

    public int getScanLineSize() {
        return this.iDF;
    }

    public void setScanLineSize(int i) {
        this.iDF = i;
    }

    public int getScanLineColor() {
        return this.iDG;
    }

    public void setScanLineColor(int i) {
        this.iDG = i;
    }

    public int getScanLineMargin() {
        return this.iDH;
    }

    public void setScanLineMargin(int i) {
        this.iDH = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.iDI = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.iDJ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.iDJ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.iDK;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.iDK = bitmap;
    }

    public int getBorderSize() {
        return this.iDL;
    }

    public void setBorderSize(int i) {
        this.iDL = i;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public void setBorderColor(int i) {
        this.GW = i;
    }

    public int getAnimTime() {
        return this.iDM;
    }

    public void setAnimTime(int i) {
        this.iDM = i;
    }

    public void setCenterVertical(boolean z) {
        this.iDN = z;
    }

    public int getToolbarHeight() {
        return this.iDO;
    }

    public void setToolbarHeight(int i) {
        this.iDO = i;
    }

    public String getQRCodeTipText() {
        return this.iDQ;
    }

    public void setQRCodeTipText(String str) {
        this.iDQ = str;
    }

    public String getBarCodeTipText() {
        return this.iDR;
    }

    public void setBarCodeTipText(String str) {
        this.iDR = str;
    }

    public String getTipText() {
        return this.hrs;
    }

    public void setTipText(String str) {
        this.hrs = str;
    }

    public int getTipTextColor() {
        return this.iDT;
    }

    public void setTipTextColor(int i) {
        this.iDT = i;
    }

    public int getTipTextSize() {
        return this.iDS;
    }

    public void setTipTextSize(int i) {
        this.iDS = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.iDU = z;
    }

    public int getTipTextMargin() {
        return this.iDV;
    }

    public void setTipTextMargin(int i) {
        this.iDV = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.iDW = z;
    }

    public void setShowTipBackground(boolean z) {
        this.iDY = z;
    }

    public int getTipBackgroundColor() {
        return this.iDX;
    }

    public void setTipBackgroundColor(int i) {
        this.iDX = i;
    }

    public void setScanLineReverse(boolean z) {
        this.iDZ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.iEa = z;
    }

    public float getHalfCornerSize() {
        return this.iEj;
    }

    public void setHalfCornerSize(float f) {
        this.iEj = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iEk;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iEk = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iEl;
    }

    public void setTipBackgroundRadius(int i) {
        this.iEl = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.iEm = z;
    }
}
