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
    private int bYm;
    private int cEc;
    private String hsk;
    private Rect iEA;
    private float iEB;
    private float iEC;
    private TextPaint iED;
    private int iEE;
    private int iEF;
    private int iEG;
    private int iEH;
    private int iEI;
    private int iEJ;
    private int iEK;
    private int iEL;
    private boolean iEM;
    private Drawable iEN;
    private Bitmap iEO;
    private int iEP;
    private int iEQ;
    private boolean iER;
    private int iES;
    private boolean iET;
    private String iEU;
    private String iEV;
    private int iEW;
    private int iEX;
    private boolean iEY;
    private int iEZ;
    private Bitmap iEu;
    private Bitmap iEv;
    private Bitmap iEw;
    private Bitmap iEx;
    private int iEy;
    private int iEz;
    private boolean iFa;
    private int iFb;
    private boolean iFc;
    private boolean iFd;
    private boolean iFe;
    private Drawable iFf;
    private Bitmap iFg;
    private float iFh;
    private float iFi;
    private Bitmap iFj;
    private Bitmap iFk;
    private Bitmap iFl;
    private Bitmap iFm;
    private float iFn;
    private StaticLayout iFo;
    private int iFp;
    private boolean iFq;
    private ColorMatrixColorFilter iFr;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bYm = Color.parseColor("#33FFFFFF");
        this.iEE = a.e(context, 20.0f);
        this.iEF = a.e(context, 3.0f);
        this.iEJ = a.e(context, 1.0f);
        this.iEK = -1;
        this.cEc = a.e(context, 90.0f);
        this.iEG = a.e(context, 200.0f);
        this.iEI = a.e(context, 140.0f);
        this.iEL = 0;
        this.iEM = false;
        this.iEN = null;
        this.iEO = null;
        this.iEP = a.e(context, 1.0f);
        this.GW = -1;
        this.iEQ = 1000;
        this.iER = false;
        this.iES = 0;
        this.iET = false;
        this.iEy = a.e(context, 2.0f);
        this.hsk = null;
        this.iEW = a.sp2px(context, 14.0f);
        this.iEX = -1;
        this.iEY = false;
        this.iEZ = a.e(context, 20.0f);
        this.iFa = false;
        this.iFb = Color.parseColor("#22000000");
        this.iFc = false;
        this.iFd = false;
        this.iFe = false;
        this.iED = new TextPaint();
        this.iED.setAntiAlias(true);
        this.iFp = a.e(context, 4.0f);
        this.iFq = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.iFr = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        chs();
        chr();
    }

    private void chr() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iEE;
        options.outHeight = this.iEE;
        this.iEu = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iEv = Bitmap.createBitmap(this.iEu, 0, 0, this.iEu.getWidth(), this.iEu.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iEw = Bitmap.createBitmap(this.iEu, 0, 0, this.iEu.getWidth(), this.iEu.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iEx = Bitmap.createBitmap(this.iEu, 0, 0, this.iEu.getWidth(), this.iEu.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cEc = typedArray.getDimensionPixelSize(i, this.cEc);
        } else if (i == 1) {
            this.iEF = typedArray.getDimensionPixelSize(i, this.iEF);
        } else if (i == 2) {
            this.iEE = typedArray.getDimensionPixelSize(i, this.iEE);
        } else if (i == 6) {
            this.iEJ = typedArray.getDimensionPixelSize(i, this.iEJ);
        } else if (i == 3) {
            this.iEG = typedArray.getDimensionPixelSize(i, this.iEG);
        } else if (i == 5) {
            this.bYm = typedArray.getColor(i, this.bYm);
        } else if (i == 7) {
            this.iEK = typedArray.getColor(i, this.iEK);
        } else if (i == 8) {
            this.iEL = typedArray.getDimensionPixelSize(i, this.iEL);
        } else if (i == 9) {
            this.iEM = typedArray.getBoolean(i, this.iEM);
        } else if (i == 10) {
            this.iEN = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.iEP = typedArray.getDimensionPixelSize(i, this.iEP);
        } else if (i == 12) {
            this.GW = typedArray.getColor(i, this.GW);
        } else if (i == 13) {
            this.iEQ = typedArray.getInteger(i, this.iEQ);
        } else if (i == 14) {
            this.iER = typedArray.getBoolean(i, this.iER);
        } else if (i == 15) {
            this.iES = typedArray.getDimensionPixelSize(i, this.iES);
        } else if (i == 4) {
            this.iEI = typedArray.getDimensionPixelSize(i, this.iEI);
        } else if (i == 16) {
            this.iET = typedArray.getBoolean(i, this.iET);
        } else if (i == 18) {
            this.iEV = typedArray.getString(i);
        } else if (i == 17) {
            this.iEU = typedArray.getString(i);
        } else if (i == 19) {
            this.iEW = typedArray.getDimensionPixelSize(i, this.iEW);
        } else if (i == 20) {
            this.iEX = typedArray.getColor(i, this.iEX);
        } else if (i == 21) {
            this.iEY = typedArray.getBoolean(i, this.iEY);
        } else if (i == 22) {
            this.iEZ = typedArray.getDimensionPixelSize(i, this.iEZ);
        } else if (i == 23) {
            this.iFa = typedArray.getBoolean(i, this.iFa);
        } else if (i == 24) {
            this.iFc = typedArray.getBoolean(i, this.iFc);
        } else if (i == 25) {
            this.iFb = typedArray.getColor(i, this.iFb);
        } else if (i == 26) {
            this.iFd = typedArray.getBoolean(i, this.iFd);
        } else if (i == 27) {
            this.iFe = typedArray.getBoolean(i, this.iFe);
        } else if (i == 28) {
            this.iFf = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.iFq = typedArray.getBoolean(i, this.iFq);
        }
    }

    private void chs() {
        if (this.iFf != null) {
            this.iFl = ((BitmapDrawable) this.iFf).getBitmap();
        }
        if (this.iFl == null) {
            this.iFl = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFl = a.e(this.iFl, this.iEK);
        }
        this.iFm = a.adjustPhotoRotation(this.iFl, 90);
        this.iFm = a.adjustPhotoRotation(this.iFm, 90);
        this.iFm = a.adjustPhotoRotation(this.iFm, 90);
        if (this.iEN != null) {
            this.iFj = ((BitmapDrawable) this.iEN).getBitmap();
        }
        if (this.iFj == null) {
            this.iFj = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFj = a.e(this.iFj, this.iEK);
        }
        this.iFk = a.adjustPhotoRotation(this.iFj, 90);
        this.iFn = (1.0f * this.iEF) / 2.0f;
        this.iED.setTextSize(this.iEW);
        this.iED.setColor(this.iEX);
        setIsBarcode(this.iET);
    }

    public void cht() {
        this.iED.setColor(this.iEX);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.iEA != null) {
            U(canvas);
            V(canvas);
            X(canvas);
            Y(canvas);
            W(canvas);
            chu();
        }
    }

    private void U(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bYm != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bYm);
            canvas.drawRect(0.0f, 0.0f, width, this.iEA.top, this.mPaint);
            canvas.drawRect(0.0f, this.iEA.top, this.iEA.left, this.iEA.bottom + 1, this.mPaint);
            canvas.drawRect(this.iEA.right + 1, this.iEA.top, width, this.iEA.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.iEA.bottom + 1, width, height, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (this.iEP > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.GW);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.iEP);
            canvas.drawRect(this.iEA, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iEu, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iEv, getMainFrameRight() - this.iEu.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iEw, getMainFrameLeft(), getMainFrameBottom() - this.iEu.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iEx, getMainFrameRight() - this.iEu.getWidth(), getMainFrameBottom() - this.iEu.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.iEA.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.iEA.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.iEA.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.iEA.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.iEP / 2;
    }

    private void X(Canvas canvas) {
        if (this.iET) {
            if (this.iFg != null) {
                RectF rectF = new RectF(this.iEA.left + this.iFn + 0.5f, this.iEA.top + this.iFn + this.iEL, this.iFi, (this.iEA.bottom - this.iFn) - this.iEL);
                Rect rect = new Rect((int) (this.iFg.getWidth() - rectF.width()), 0, this.iFg.getWidth(), this.iFg.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.iFg, rect, rectF, this.mPaint);
            } else if (this.iEO != null) {
                canvas.drawBitmap(this.iEO, (Rect) null, new RectF(this.iEC, this.iEA.top + this.iFn + this.iEL, this.iEC + this.iEO.getWidth(), (this.iEA.bottom - this.iFn) - this.iEL), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.iEK);
                canvas.drawRect(this.iEC, this.iEL + this.iEA.top + this.iFn, this.iEJ + this.iEC, (this.iEA.bottom - this.iFn) - this.iEL, this.mPaint);
            }
        } else if (this.iFg != null) {
            RectF rectF2 = new RectF(this.iEA.left + this.iFn + this.iEL, this.iEA.top + this.iFn + 0.5f, (this.iEA.right - this.iFn) - this.iEL, this.iFh);
            Rect rect2 = new Rect(0, (int) (this.iFg.getHeight() - rectF2.height()), this.iFg.getWidth(), this.iFg.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.iFr);
            canvas.drawBitmap(this.iFg, rect2, rectF2, this.mPaint);
        } else if (this.iEO != null) {
            canvas.drawBitmap(this.iEO, (Rect) null, new RectF(this.iEA.left + this.iFn + this.iEL, this.iEB, (this.iEA.right - this.iFn) - this.iEL, this.iEB + this.iEO.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.iEK);
            canvas.drawRect(this.iEL + this.iEA.left + this.iFn, this.iEB, (this.iEA.right - this.iFn) - this.iEL, this.iEJ + this.iEB, this.mPaint);
        }
    }

    private void Y(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hsk) && this.iFo != null) {
            if (this.iEY) {
                if (this.iFc) {
                    this.mPaint.setColor(this.iFb);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.iFa) {
                        Rect rect = new Rect();
                        this.iED.getTextBounds(this.hsk, 0, this.hsk.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iFp;
                        canvas.drawRoundRect(new RectF(width, (this.iEA.bottom + this.iEZ) - this.iFp, rect.width() + width + (this.iFp * 2), this.iEA.bottom + this.iEZ + this.iFo.getHeight() + this.iFp), this.iFp, this.iFp, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.iEA.left, (this.iEA.bottom + this.iEZ) - this.iFp, this.iEA.right, this.iEA.bottom + this.iEZ + this.iFo.getHeight() + this.iFp), this.iFp, this.iFp, this.mPaint);
                    }
                }
                canvas.save();
                if (this.iFa) {
                    canvas.translate(0.0f, this.iEA.bottom + this.iEZ);
                } else {
                    canvas.translate(this.iEA.left + this.iFp, this.iEA.bottom + this.iEZ);
                }
                this.iFo.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.iFc) {
                this.mPaint.setColor(this.iFb);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.iFa) {
                    Rect rect2 = new Rect();
                    this.iED.getTextBounds(this.hsk, 0, this.hsk.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iFp;
                    canvas.drawRoundRect(new RectF(width2, ((this.iEA.top - this.iEZ) - this.iFo.getHeight()) - this.iFp, rect2.width() + width2 + (this.iFp * 2), (this.iEA.top - this.iEZ) + this.iFp), this.iFp, this.iFp, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.iEA.left, ((this.iEA.top - this.iEZ) - this.iFo.getHeight()) - this.iFp, this.iEA.right, (this.iEA.top - this.iEZ) + this.iFp), this.iFp, this.iFp, this.mPaint);
                }
            }
            canvas.save();
            if (this.iFa) {
                canvas.translate(0.0f, (this.iEA.top - this.iEZ) - this.iFo.getHeight());
            } else {
                canvas.translate(this.iEA.left + this.iFp, (this.iEA.top - this.iEZ) - this.iFo.getHeight());
            }
            this.iFo.draw(canvas);
            canvas.restore();
        }
    }

    private void chu() {
        if (this.iET) {
            if (this.iFg == null) {
                this.iEC += this.iEy;
                int i = this.iEJ;
                if (this.iEO != null) {
                    i = this.iEO.getWidth();
                }
                if (this.iFd) {
                    if (i + this.iEC > this.iEA.right - this.iFn || this.iEC < this.iEA.left + this.iFn) {
                        this.iEy = -this.iEy;
                    }
                } else {
                    if (i + this.iEC > this.iEA.right - this.iFn) {
                        this.iEC = this.iEA.left + this.iFn + 0.5f;
                    }
                }
            } else {
                this.iFi += this.iEy;
                if (this.iFi > this.iEA.right - this.iFn) {
                    this.iFi = this.iEA.left + this.iFn + 0.5f;
                }
            }
        } else if (this.iFg == null) {
            this.iEB += this.iEy;
            int i2 = this.iEJ;
            if (this.iEO != null) {
                i2 = this.iEO.getHeight();
            }
            if (this.iFd) {
                if (i2 + this.iEB > this.iEA.bottom - this.iFn || this.iEB < this.iEA.top + this.iFn) {
                    this.iEy = -this.iEy;
                }
            } else {
                if (i2 + this.iEB > this.iEA.bottom - this.iFn) {
                    this.iEB = this.iEA.top + this.iFn + 0.5f;
                }
            }
        } else {
            this.iFh += this.iEy;
            if (this.iFh > this.iEA.bottom - this.iFn) {
                this.iFh = this.iEA.top + this.iFn + 0.5f;
            }
        }
        postInvalidateDelayed(this.iEz, this.iEA.left, this.iEA.top, this.iEA.right, this.iEA.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        chv();
    }

    private void chv() {
        int i;
        if (this.iET) {
            i = this.cEc + this.iES;
        } else {
            i = this.cEc;
        }
        int width = (getWidth() - this.iEG) / 2;
        this.iEA = new Rect(width, i, this.iEG + width, this.iEH + i);
        if (this.iET) {
            float f = this.iEA.left + this.iFn + 0.5f;
            this.iEC = f;
            this.iFi = f;
            return;
        }
        float f2 = this.iEA.top + this.iFn + 0.5f;
        this.iEB = f2;
        this.iFh = f2;
    }

    public Rect zv(int i) {
        if (this.iFq) {
            Rect rect = new Rect(this.iEA);
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
        this.iET = z;
        if (this.iFf != null || this.iFe) {
            if (this.iET) {
                this.iFg = this.iFm;
            } else {
                this.iFg = this.iFl;
            }
        } else if (this.iEN != null || this.iEM) {
            if (this.iET) {
                this.iEO = this.iFk;
            } else {
                this.iEO = this.iFj;
            }
        }
        if (this.iET) {
            this.hsk = this.iEV;
            this.iEH = this.iEI;
            this.iEz = (int) (((this.iEQ * 1.0f) * this.iEy) / this.iEG);
        } else {
            this.hsk = this.iEU;
            this.iEH = this.iEG;
            this.iEz = (int) (((this.iEQ * 1.0f) * this.iEy) / this.iEH);
        }
        if (!TextUtils.isEmpty(this.hsk)) {
            if (this.iFa) {
                this.iFo = new StaticLayout(this.hsk, this.iED, a.eh(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iFo = new StaticLayout(this.hsk, this.iED, this.iEG - (this.iFp * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.iER) {
            int i = a.eh(getContext()).y;
            if (this.iES == 0) {
                this.cEc = (i - this.iEH) / 2;
            } else if (this.iET) {
                this.cEc = ((i - this.iEH) / 2) + (this.iES / 2);
            } else {
                this.cEc = (i - this.iEH) / 2;
            }
        }
        chv();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.iET;
    }

    public int getMaskColor() {
        return this.bYm;
    }

    public void setMaskColor(int i) {
        this.bYm = i;
    }

    public int getCornerLength() {
        return this.iEE;
    }

    public void setCornerLength(int i) {
        this.iEE = i;
    }

    public int getCornerSize() {
        return this.iEF;
    }

    public void setCornerSize(int i) {
        this.iEF = i;
    }

    public int getRectWidth() {
        return this.iEG;
    }

    public void setRectWidth(int i) {
        this.iEG = i;
    }

    public int getRectHeight() {
        return this.iEH;
    }

    public void setRectHeight(int i) {
        this.iEH = i;
    }

    public int getBarcodeRectHeight() {
        return this.iEI;
    }

    public void setBarcodeRectHeight(int i) {
        this.iEI = i;
    }

    public int getTopOffset() {
        return this.cEc;
    }

    public void setTopOffset(int i) {
        this.cEc = i;
    }

    public int getScanLineSize() {
        return this.iEJ;
    }

    public void setScanLineSize(int i) {
        this.iEJ = i;
    }

    public int getScanLineColor() {
        return this.iEK;
    }

    public void setScanLineColor(int i) {
        this.iEK = i;
    }

    public int getScanLineMargin() {
        return this.iEL;
    }

    public void setScanLineMargin(int i) {
        this.iEL = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.iEM = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.iEN;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.iEN = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.iEO;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.iEO = bitmap;
    }

    public int getBorderSize() {
        return this.iEP;
    }

    public void setBorderSize(int i) {
        this.iEP = i;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public void setBorderColor(int i) {
        this.GW = i;
    }

    public int getAnimTime() {
        return this.iEQ;
    }

    public void setAnimTime(int i) {
        this.iEQ = i;
    }

    public void setCenterVertical(boolean z) {
        this.iER = z;
    }

    public int getToolbarHeight() {
        return this.iES;
    }

    public void setToolbarHeight(int i) {
        this.iES = i;
    }

    public String getQRCodeTipText() {
        return this.iEU;
    }

    public void setQRCodeTipText(String str) {
        this.iEU = str;
    }

    public String getBarCodeTipText() {
        return this.iEV;
    }

    public void setBarCodeTipText(String str) {
        this.iEV = str;
    }

    public String getTipText() {
        return this.hsk;
    }

    public void setTipText(String str) {
        this.hsk = str;
    }

    public int getTipTextColor() {
        return this.iEX;
    }

    public void setTipTextColor(int i) {
        this.iEX = i;
    }

    public int getTipTextSize() {
        return this.iEW;
    }

    public void setTipTextSize(int i) {
        this.iEW = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.iEY = z;
    }

    public int getTipTextMargin() {
        return this.iEZ;
    }

    public void setTipTextMargin(int i) {
        this.iEZ = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.iFa = z;
    }

    public void setShowTipBackground(boolean z) {
        this.iFc = z;
    }

    public int getTipBackgroundColor() {
        return this.iFb;
    }

    public void setTipBackgroundColor(int i) {
        this.iFb = i;
    }

    public void setScanLineReverse(boolean z) {
        this.iFd = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.iFe = z;
    }

    public float getHalfCornerSize() {
        return this.iFn;
    }

    public void setHalfCornerSize(float f) {
        this.iFn = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iFo;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iFo = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iFp;
    }

    public void setTipBackgroundRadius(int i) {
        this.iFp = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.iFq = z;
    }
}
