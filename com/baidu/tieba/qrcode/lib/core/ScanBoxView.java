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
    private int bXd;
    private int cCD;
    private String hlb;
    private Bitmap iwU;
    private Bitmap iwV;
    private Bitmap iwW;
    private Bitmap iwX;
    private int iwY;
    private int iwZ;
    private boolean ixA;
    private int ixB;
    private boolean ixC;
    private boolean ixD;
    private boolean ixE;
    private Drawable ixF;
    private Bitmap ixG;
    private float ixH;
    private float ixI;
    private Bitmap ixJ;
    private Bitmap ixK;
    private Bitmap ixL;
    private Bitmap ixM;
    private float ixN;
    private StaticLayout ixO;
    private int ixP;
    private boolean ixQ;
    private ColorMatrixColorFilter ixR;
    private Rect ixa;
    private float ixb;
    private float ixc;
    private TextPaint ixd;
    private int ixe;
    private int ixf;
    private int ixg;
    private int ixh;
    private int ixi;
    private int ixj;
    private int ixk;
    private int ixl;
    private boolean ixm;
    private Drawable ixn;
    private Bitmap ixo;
    private int ixp;
    private int ixq;
    private boolean ixr;
    private int ixs;
    private boolean ixt;
    private String ixu;
    private String ixv;
    private int ixw;
    private int ixx;
    private boolean ixy;
    private int ixz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bXd = Color.parseColor("#33FFFFFF");
        this.ixe = a.e(context, 20.0f);
        this.ixf = a.e(context, 3.0f);
        this.ixj = a.e(context, 1.0f);
        this.ixk = -1;
        this.cCD = a.e(context, 90.0f);
        this.ixg = a.e(context, 200.0f);
        this.ixi = a.e(context, 140.0f);
        this.ixl = 0;
        this.ixm = false;
        this.ixn = null;
        this.ixo = null;
        this.ixp = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ixq = 1000;
        this.ixr = false;
        this.ixs = 0;
        this.ixt = false;
        this.iwY = a.e(context, 2.0f);
        this.hlb = null;
        this.ixw = a.sp2px(context, 14.0f);
        this.ixx = -1;
        this.ixy = false;
        this.ixz = a.e(context, 20.0f);
        this.ixA = false;
        this.ixB = Color.parseColor("#22000000");
        this.ixC = false;
        this.ixD = false;
        this.ixE = false;
        this.ixd = new TextPaint();
        this.ixd.setAntiAlias(true);
        this.ixP = a.e(context, 4.0f);
        this.ixQ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ixR = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cef();
        cee();
    }

    private void cee() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ixe;
        options.outHeight = this.ixe;
        this.iwU = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iwV = Bitmap.createBitmap(this.iwU, 0, 0, this.iwU.getWidth(), this.iwU.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iwW = Bitmap.createBitmap(this.iwU, 0, 0, this.iwU.getWidth(), this.iwU.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iwX = Bitmap.createBitmap(this.iwU, 0, 0, this.iwU.getWidth(), this.iwU.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cCD = typedArray.getDimensionPixelSize(i, this.cCD);
        } else if (i == 1) {
            this.ixf = typedArray.getDimensionPixelSize(i, this.ixf);
        } else if (i == 2) {
            this.ixe = typedArray.getDimensionPixelSize(i, this.ixe);
        } else if (i == 6) {
            this.ixj = typedArray.getDimensionPixelSize(i, this.ixj);
        } else if (i == 3) {
            this.ixg = typedArray.getDimensionPixelSize(i, this.ixg);
        } else if (i == 5) {
            this.bXd = typedArray.getColor(i, this.bXd);
        } else if (i == 7) {
            this.ixk = typedArray.getColor(i, this.ixk);
        } else if (i == 8) {
            this.ixl = typedArray.getDimensionPixelSize(i, this.ixl);
        } else if (i == 9) {
            this.ixm = typedArray.getBoolean(i, this.ixm);
        } else if (i == 10) {
            this.ixn = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.ixp = typedArray.getDimensionPixelSize(i, this.ixp);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.ixq = typedArray.getInteger(i, this.ixq);
        } else if (i == 14) {
            this.ixr = typedArray.getBoolean(i, this.ixr);
        } else if (i == 15) {
            this.ixs = typedArray.getDimensionPixelSize(i, this.ixs);
        } else if (i == 4) {
            this.ixi = typedArray.getDimensionPixelSize(i, this.ixi);
        } else if (i == 16) {
            this.ixt = typedArray.getBoolean(i, this.ixt);
        } else if (i == 18) {
            this.ixv = typedArray.getString(i);
        } else if (i == 17) {
            this.ixu = typedArray.getString(i);
        } else if (i == 19) {
            this.ixw = typedArray.getDimensionPixelSize(i, this.ixw);
        } else if (i == 20) {
            this.ixx = typedArray.getColor(i, this.ixx);
        } else if (i == 21) {
            this.ixy = typedArray.getBoolean(i, this.ixy);
        } else if (i == 22) {
            this.ixz = typedArray.getDimensionPixelSize(i, this.ixz);
        } else if (i == 23) {
            this.ixA = typedArray.getBoolean(i, this.ixA);
        } else if (i == 24) {
            this.ixC = typedArray.getBoolean(i, this.ixC);
        } else if (i == 25) {
            this.ixB = typedArray.getColor(i, this.ixB);
        } else if (i == 26) {
            this.ixD = typedArray.getBoolean(i, this.ixD);
        } else if (i == 27) {
            this.ixE = typedArray.getBoolean(i, this.ixE);
        } else if (i == 28) {
            this.ixF = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.ixQ = typedArray.getBoolean(i, this.ixQ);
        }
    }

    private void cef() {
        if (this.ixF != null) {
            this.ixL = ((BitmapDrawable) this.ixF).getBitmap();
        }
        if (this.ixL == null) {
            this.ixL = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixL = a.e(this.ixL, this.ixk);
        }
        this.ixM = a.adjustPhotoRotation(this.ixL, 90);
        this.ixM = a.adjustPhotoRotation(this.ixM, 90);
        this.ixM = a.adjustPhotoRotation(this.ixM, 90);
        if (this.ixn != null) {
            this.ixJ = ((BitmapDrawable) this.ixn).getBitmap();
        }
        if (this.ixJ == null) {
            this.ixJ = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixJ = a.e(this.ixJ, this.ixk);
        }
        this.ixK = a.adjustPhotoRotation(this.ixJ, 90);
        this.ixN = (1.0f * this.ixf) / 2.0f;
        this.ixd.setTextSize(this.ixw);
        this.ixd.setColor(this.ixx);
        setIsBarcode(this.ixt);
    }

    public void ceg() {
        this.ixd.setColor(this.ixx);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ixa != null) {
            U(canvas);
            V(canvas);
            X(canvas);
            Y(canvas);
            W(canvas);
            ceh();
        }
    }

    private void U(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bXd != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bXd);
            canvas.drawRect(0.0f, 0.0f, width, this.ixa.top, this.mPaint);
            canvas.drawRect(0.0f, this.ixa.top, this.ixa.left, this.ixa.bottom + 1, this.mPaint);
            canvas.drawRect(this.ixa.right + 1, this.ixa.top, width, this.ixa.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ixa.bottom + 1, width, height, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (this.ixp > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ixp);
            canvas.drawRect(this.ixa, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iwU, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iwV, getMainFrameRight() - this.iwU.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iwW, getMainFrameLeft(), getMainFrameBottom() - this.iwU.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iwX, getMainFrameRight() - this.iwU.getWidth(), getMainFrameBottom() - this.iwU.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ixa.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ixa.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ixa.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ixa.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ixp / 2;
    }

    private void X(Canvas canvas) {
        if (this.ixt) {
            if (this.ixG != null) {
                RectF rectF = new RectF(this.ixa.left + this.ixN + 0.5f, this.ixa.top + this.ixN + this.ixl, this.ixI, (this.ixa.bottom - this.ixN) - this.ixl);
                Rect rect = new Rect((int) (this.ixG.getWidth() - rectF.width()), 0, this.ixG.getWidth(), this.ixG.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ixG, rect, rectF, this.mPaint);
            } else if (this.ixo != null) {
                canvas.drawBitmap(this.ixo, (Rect) null, new RectF(this.ixc, this.ixa.top + this.ixN + this.ixl, this.ixc + this.ixo.getWidth(), (this.ixa.bottom - this.ixN) - this.ixl), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ixk);
                canvas.drawRect(this.ixc, this.ixl + this.ixa.top + this.ixN, this.ixj + this.ixc, (this.ixa.bottom - this.ixN) - this.ixl, this.mPaint);
            }
        } else if (this.ixG != null) {
            RectF rectF2 = new RectF(this.ixa.left + this.ixN + this.ixl, this.ixa.top + this.ixN + 0.5f, (this.ixa.right - this.ixN) - this.ixl, this.ixH);
            Rect rect2 = new Rect(0, (int) (this.ixG.getHeight() - rectF2.height()), this.ixG.getWidth(), this.ixG.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ixR);
            canvas.drawBitmap(this.ixG, rect2, rectF2, this.mPaint);
        } else if (this.ixo != null) {
            canvas.drawBitmap(this.ixo, (Rect) null, new RectF(this.ixa.left + this.ixN + this.ixl, this.ixb, (this.ixa.right - this.ixN) - this.ixl, this.ixb + this.ixo.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ixk);
            canvas.drawRect(this.ixl + this.ixa.left + this.ixN, this.ixb, (this.ixa.right - this.ixN) - this.ixl, this.ixj + this.ixb, this.mPaint);
        }
    }

    private void Y(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hlb) && this.ixO != null) {
            if (this.ixy) {
                if (this.ixC) {
                    this.mPaint.setColor(this.ixB);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ixA) {
                        Rect rect = new Rect();
                        this.ixd.getTextBounds(this.hlb, 0, this.hlb.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ixP;
                        canvas.drawRoundRect(new RectF(width, (this.ixa.bottom + this.ixz) - this.ixP, rect.width() + width + (this.ixP * 2), this.ixa.bottom + this.ixz + this.ixO.getHeight() + this.ixP), this.ixP, this.ixP, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ixa.left, (this.ixa.bottom + this.ixz) - this.ixP, this.ixa.right, this.ixa.bottom + this.ixz + this.ixO.getHeight() + this.ixP), this.ixP, this.ixP, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ixA) {
                    canvas.translate(0.0f, this.ixa.bottom + this.ixz);
                } else {
                    canvas.translate(this.ixa.left + this.ixP, this.ixa.bottom + this.ixz);
                }
                this.ixO.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ixC) {
                this.mPaint.setColor(this.ixB);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ixA) {
                    Rect rect2 = new Rect();
                    this.ixd.getTextBounds(this.hlb, 0, this.hlb.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ixP;
                    canvas.drawRoundRect(new RectF(width2, ((this.ixa.top - this.ixz) - this.ixO.getHeight()) - this.ixP, rect2.width() + width2 + (this.ixP * 2), (this.ixa.top - this.ixz) + this.ixP), this.ixP, this.ixP, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ixa.left, ((this.ixa.top - this.ixz) - this.ixO.getHeight()) - this.ixP, this.ixa.right, (this.ixa.top - this.ixz) + this.ixP), this.ixP, this.ixP, this.mPaint);
                }
            }
            canvas.save();
            if (this.ixA) {
                canvas.translate(0.0f, (this.ixa.top - this.ixz) - this.ixO.getHeight());
            } else {
                canvas.translate(this.ixa.left + this.ixP, (this.ixa.top - this.ixz) - this.ixO.getHeight());
            }
            this.ixO.draw(canvas);
            canvas.restore();
        }
    }

    private void ceh() {
        if (this.ixt) {
            if (this.ixG == null) {
                this.ixc += this.iwY;
                int i = this.ixj;
                if (this.ixo != null) {
                    i = this.ixo.getWidth();
                }
                if (this.ixD) {
                    if (i + this.ixc > this.ixa.right - this.ixN || this.ixc < this.ixa.left + this.ixN) {
                        this.iwY = -this.iwY;
                    }
                } else {
                    if (i + this.ixc > this.ixa.right - this.ixN) {
                        this.ixc = this.ixa.left + this.ixN + 0.5f;
                    }
                }
            } else {
                this.ixI += this.iwY;
                if (this.ixI > this.ixa.right - this.ixN) {
                    this.ixI = this.ixa.left + this.ixN + 0.5f;
                }
            }
        } else if (this.ixG == null) {
            this.ixb += this.iwY;
            int i2 = this.ixj;
            if (this.ixo != null) {
                i2 = this.ixo.getHeight();
            }
            if (this.ixD) {
                if (i2 + this.ixb > this.ixa.bottom - this.ixN || this.ixb < this.ixa.top + this.ixN) {
                    this.iwY = -this.iwY;
                }
            } else {
                if (i2 + this.ixb > this.ixa.bottom - this.ixN) {
                    this.ixb = this.ixa.top + this.ixN + 0.5f;
                }
            }
        } else {
            this.ixH += this.iwY;
            if (this.ixH > this.ixa.bottom - this.ixN) {
                this.ixH = this.ixa.top + this.ixN + 0.5f;
            }
        }
        postInvalidateDelayed(this.iwZ, this.ixa.left, this.ixa.top, this.ixa.right, this.ixa.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cei();
    }

    private void cei() {
        int i;
        if (this.ixt) {
            i = this.cCD + this.ixs;
        } else {
            i = this.cCD;
        }
        int width = (getWidth() - this.ixg) / 2;
        this.ixa = new Rect(width, i, this.ixg + width, this.ixh + i);
        if (this.ixt) {
            float f = this.ixa.left + this.ixN + 0.5f;
            this.ixc = f;
            this.ixI = f;
            return;
        }
        float f2 = this.ixa.top + this.ixN + 0.5f;
        this.ixb = f2;
        this.ixH = f2;
    }

    public Rect yO(int i) {
        if (this.ixQ) {
            Rect rect = new Rect(this.ixa);
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
        this.ixt = z;
        if (this.ixF != null || this.ixE) {
            if (this.ixt) {
                this.ixG = this.ixM;
            } else {
                this.ixG = this.ixL;
            }
        } else if (this.ixn != null || this.ixm) {
            if (this.ixt) {
                this.ixo = this.ixK;
            } else {
                this.ixo = this.ixJ;
            }
        }
        if (this.ixt) {
            this.hlb = this.ixv;
            this.ixh = this.ixi;
            this.iwZ = (int) (((this.ixq * 1.0f) * this.iwY) / this.ixg);
        } else {
            this.hlb = this.ixu;
            this.ixh = this.ixg;
            this.iwZ = (int) (((this.ixq * 1.0f) * this.iwY) / this.ixh);
        }
        if (!TextUtils.isEmpty(this.hlb)) {
            if (this.ixA) {
                this.ixO = new StaticLayout(this.hlb, this.ixd, a.ef(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ixO = new StaticLayout(this.hlb, this.ixd, this.ixg - (this.ixP * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ixr) {
            int i = a.ef(getContext()).y;
            if (this.ixs == 0) {
                this.cCD = (i - this.ixh) / 2;
            } else if (this.ixt) {
                this.cCD = ((i - this.ixh) / 2) + (this.ixs / 2);
            } else {
                this.cCD = (i - this.ixh) / 2;
            }
        }
        cei();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ixt;
    }

    public int getMaskColor() {
        return this.bXd;
    }

    public void setMaskColor(int i) {
        this.bXd = i;
    }

    public int getCornerLength() {
        return this.ixe;
    }

    public void setCornerLength(int i) {
        this.ixe = i;
    }

    public int getCornerSize() {
        return this.ixf;
    }

    public void setCornerSize(int i) {
        this.ixf = i;
    }

    public int getRectWidth() {
        return this.ixg;
    }

    public void setRectWidth(int i) {
        this.ixg = i;
    }

    public int getRectHeight() {
        return this.ixh;
    }

    public void setRectHeight(int i) {
        this.ixh = i;
    }

    public int getBarcodeRectHeight() {
        return this.ixi;
    }

    public void setBarcodeRectHeight(int i) {
        this.ixi = i;
    }

    public int getTopOffset() {
        return this.cCD;
    }

    public void setTopOffset(int i) {
        this.cCD = i;
    }

    public int getScanLineSize() {
        return this.ixj;
    }

    public void setScanLineSize(int i) {
        this.ixj = i;
    }

    public int getScanLineColor() {
        return this.ixk;
    }

    public void setScanLineColor(int i) {
        this.ixk = i;
    }

    public int getScanLineMargin() {
        return this.ixl;
    }

    public void setScanLineMargin(int i) {
        this.ixl = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ixm = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ixn;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ixn = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ixo;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ixo = bitmap;
    }

    public int getBorderSize() {
        return this.ixp;
    }

    public void setBorderSize(int i) {
        this.ixp = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ixq;
    }

    public void setAnimTime(int i) {
        this.ixq = i;
    }

    public void setCenterVertical(boolean z) {
        this.ixr = z;
    }

    public int getToolbarHeight() {
        return this.ixs;
    }

    public void setToolbarHeight(int i) {
        this.ixs = i;
    }

    public String getQRCodeTipText() {
        return this.ixu;
    }

    public void setQRCodeTipText(String str) {
        this.ixu = str;
    }

    public String getBarCodeTipText() {
        return this.ixv;
    }

    public void setBarCodeTipText(String str) {
        this.ixv = str;
    }

    public String getTipText() {
        return this.hlb;
    }

    public void setTipText(String str) {
        this.hlb = str;
    }

    public int getTipTextColor() {
        return this.ixx;
    }

    public void setTipTextColor(int i) {
        this.ixx = i;
    }

    public int getTipTextSize() {
        return this.ixw;
    }

    public void setTipTextSize(int i) {
        this.ixw = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ixy = z;
    }

    public int getTipTextMargin() {
        return this.ixz;
    }

    public void setTipTextMargin(int i) {
        this.ixz = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ixA = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ixC = z;
    }

    public int getTipBackgroundColor() {
        return this.ixB;
    }

    public void setTipBackgroundColor(int i) {
        this.ixB = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ixD = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ixE = z;
    }

    public float getHalfCornerSize() {
        return this.ixN;
    }

    public void setHalfCornerSize(float f) {
        this.ixN = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ixO;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ixO = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ixP;
    }

    public void setTipBackgroundRadius(int i) {
        this.ixP = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ixQ = z;
    }
}
