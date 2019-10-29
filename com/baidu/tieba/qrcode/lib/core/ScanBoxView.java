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
    private String hsU;
    private Drawable iFA;
    private Bitmap iFB;
    private int iFC;
    private int iFD;
    private boolean iFE;
    private int iFF;
    private boolean iFG;
    private String iFH;
    private String iFI;
    private int iFJ;
    private int iFK;
    private boolean iFL;
    private int iFM;
    private boolean iFN;
    private int iFO;
    private boolean iFP;
    private boolean iFQ;
    private boolean iFR;
    private Drawable iFS;
    private Bitmap iFT;
    private float iFU;
    private float iFV;
    private Bitmap iFW;
    private Bitmap iFX;
    private Bitmap iFY;
    private Bitmap iFZ;
    private Bitmap iFh;
    private Bitmap iFi;
    private Bitmap iFj;
    private Bitmap iFk;
    private int iFl;
    private int iFm;
    private Rect iFn;
    private float iFo;
    private float iFp;
    private TextPaint iFq;
    private int iFr;
    private int iFs;
    private int iFt;
    private int iFu;
    private int iFv;
    private int iFw;
    private int iFx;
    private int iFy;
    private boolean iFz;
    private float iGa;
    private StaticLayout iGb;
    private int iGc;
    private boolean iGd;
    private ColorMatrixColorFilter iGe;
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
        this.iFr = a.h(context, 20.0f);
        this.iFs = a.h(context, 3.0f);
        this.iFw = a.h(context, 1.0f);
        this.iFx = -1;
        this.mTopOffset = a.h(context, 90.0f);
        this.iFt = a.h(context, 200.0f);
        this.iFv = a.h(context, 140.0f);
        this.iFy = 0;
        this.iFz = false;
        this.iFA = null;
        this.iFB = null;
        this.iFC = a.h(context, 1.0f);
        this.mBorderColor = -1;
        this.iFD = 1000;
        this.iFE = false;
        this.iFF = 0;
        this.iFG = false;
        this.iFl = a.h(context, 2.0f);
        this.hsU = null;
        this.iFJ = a.g(context, 14.0f);
        this.iFK = -1;
        this.iFL = false;
        this.iFM = a.h(context, 20.0f);
        this.iFN = false;
        this.iFO = Color.parseColor("#22000000");
        this.iFP = false;
        this.iFQ = false;
        this.iFR = false;
        this.iFq = new TextPaint();
        this.iFq.setAntiAlias(true);
        this.iGc = a.h(context, 4.0f);
        this.iGd = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.iGe = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cff();
        cfe();
    }

    private void cfe() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iFr;
        options.outHeight = this.iFr;
        this.iFh = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iFi = Bitmap.createBitmap(this.iFh, 0, 0, this.iFh.getWidth(), this.iFh.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iFj = Bitmap.createBitmap(this.iFh, 0, 0, this.iFh.getWidth(), this.iFh.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iFk = Bitmap.createBitmap(this.iFh, 0, 0, this.iFh.getWidth(), this.iFh.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.iFs = typedArray.getDimensionPixelSize(i, this.iFs);
        } else if (i == 2) {
            this.iFr = typedArray.getDimensionPixelSize(i, this.iFr);
        } else if (i == 6) {
            this.iFw = typedArray.getDimensionPixelSize(i, this.iFw);
        } else if (i == 3) {
            this.iFt = typedArray.getDimensionPixelSize(i, this.iFt);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.iFx = typedArray.getColor(i, this.iFx);
        } else if (i == 8) {
            this.iFy = typedArray.getDimensionPixelSize(i, this.iFy);
        } else if (i == 9) {
            this.iFz = typedArray.getBoolean(i, this.iFz);
        } else if (i == 10) {
            this.iFA = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.iFC = typedArray.getDimensionPixelSize(i, this.iFC);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.iFD = typedArray.getInteger(i, this.iFD);
        } else if (i == 14) {
            this.iFE = typedArray.getBoolean(i, this.iFE);
        } else if (i == 15) {
            this.iFF = typedArray.getDimensionPixelSize(i, this.iFF);
        } else if (i == 4) {
            this.iFv = typedArray.getDimensionPixelSize(i, this.iFv);
        } else if (i == 16) {
            this.iFG = typedArray.getBoolean(i, this.iFG);
        } else if (i == 18) {
            this.iFI = typedArray.getString(i);
        } else if (i == 17) {
            this.iFH = typedArray.getString(i);
        } else if (i == 19) {
            this.iFJ = typedArray.getDimensionPixelSize(i, this.iFJ);
        } else if (i == 20) {
            this.iFK = typedArray.getColor(i, this.iFK);
        } else if (i == 21) {
            this.iFL = typedArray.getBoolean(i, this.iFL);
        } else if (i == 22) {
            this.iFM = typedArray.getDimensionPixelSize(i, this.iFM);
        } else if (i == 23) {
            this.iFN = typedArray.getBoolean(i, this.iFN);
        } else if (i == 24) {
            this.iFP = typedArray.getBoolean(i, this.iFP);
        } else if (i == 25) {
            this.iFO = typedArray.getColor(i, this.iFO);
        } else if (i == 26) {
            this.iFQ = typedArray.getBoolean(i, this.iFQ);
        } else if (i == 27) {
            this.iFR = typedArray.getBoolean(i, this.iFR);
        } else if (i == 28) {
            this.iFS = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.iGd = typedArray.getBoolean(i, this.iGd);
        }
    }

    private void cff() {
        if (this.iFS != null) {
            this.iFY = ((BitmapDrawable) this.iFS).getBitmap();
        }
        if (this.iFY == null) {
            this.iFY = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFY = a.d(this.iFY, this.iFx);
        }
        this.iFZ = a.adjustPhotoRotation(this.iFY, 90);
        this.iFZ = a.adjustPhotoRotation(this.iFZ, 90);
        this.iFZ = a.adjustPhotoRotation(this.iFZ, 90);
        if (this.iFA != null) {
            this.iFW = ((BitmapDrawable) this.iFA).getBitmap();
        }
        if (this.iFW == null) {
            this.iFW = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iFW = a.d(this.iFW, this.iFx);
        }
        this.iFX = a.adjustPhotoRotation(this.iFW, 90);
        this.iGa = (1.0f * this.iFs) / 2.0f;
        this.iFq.setTextSize(this.iFJ);
        this.iFq.setColor(this.iFK);
        setIsBarcode(this.iFG);
    }

    public void cfg() {
        this.iFq.setColor(this.iFK);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.iFn != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            cfh();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.iFn.top, this.mPaint);
            canvas.drawRect(0.0f, this.iFn.top, this.iFn.left, this.iFn.bottom + 1, this.mPaint);
            canvas.drawRect(this.iFn.right + 1, this.iFn.top, width, this.iFn.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.iFn.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.iFC > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.iFC);
            canvas.drawRect(this.iFn, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iFh, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iFi, getMainFrameRight() - this.iFh.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iFj, getMainFrameLeft(), getMainFrameBottom() - this.iFh.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iFk, getMainFrameRight() - this.iFh.getWidth(), getMainFrameBottom() - this.iFh.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.iFn.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.iFn.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.iFn.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.iFn.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.iFC / 2;
    }

    private void W(Canvas canvas) {
        if (this.iFG) {
            if (this.iFT != null) {
                RectF rectF = new RectF(this.iFn.left + this.iGa + 0.5f, this.iFn.top + this.iGa + this.iFy, this.iFV, (this.iFn.bottom - this.iGa) - this.iFy);
                Rect rect = new Rect((int) (this.iFT.getWidth() - rectF.width()), 0, this.iFT.getWidth(), this.iFT.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.iFT, rect, rectF, this.mPaint);
            } else if (this.iFB != null) {
                canvas.drawBitmap(this.iFB, (Rect) null, new RectF(this.iFp, this.iFn.top + this.iGa + this.iFy, this.iFp + this.iFB.getWidth(), (this.iFn.bottom - this.iGa) - this.iFy), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.iFx);
                canvas.drawRect(this.iFp, this.iFy + this.iFn.top + this.iGa, this.iFw + this.iFp, (this.iFn.bottom - this.iGa) - this.iFy, this.mPaint);
            }
        } else if (this.iFT != null) {
            RectF rectF2 = new RectF(this.iFn.left + this.iGa + this.iFy, this.iFn.top + this.iGa + 0.5f, (this.iFn.right - this.iGa) - this.iFy, this.iFU);
            Rect rect2 = new Rect(0, (int) (this.iFT.getHeight() - rectF2.height()), this.iFT.getWidth(), this.iFT.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.iGe);
            canvas.drawBitmap(this.iFT, rect2, rectF2, this.mPaint);
        } else if (this.iFB != null) {
            canvas.drawBitmap(this.iFB, (Rect) null, new RectF(this.iFn.left + this.iGa + this.iFy, this.iFo, (this.iFn.right - this.iGa) - this.iFy, this.iFo + this.iFB.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.iFx);
            canvas.drawRect(this.iFy + this.iFn.left + this.iGa, this.iFo, (this.iFn.right - this.iGa) - this.iFy, this.iFw + this.iFo, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hsU) && this.iGb != null) {
            if (this.iFL) {
                if (this.iFP) {
                    this.mPaint.setColor(this.iFO);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.iFN) {
                        Rect rect = new Rect();
                        this.iFq.getTextBounds(this.hsU, 0, this.hsU.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iGc;
                        canvas.drawRoundRect(new RectF(width, (this.iFn.bottom + this.iFM) - this.iGc, rect.width() + width + (this.iGc * 2), this.iFn.bottom + this.iFM + this.iGb.getHeight() + this.iGc), this.iGc, this.iGc, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.iFn.left, (this.iFn.bottom + this.iFM) - this.iGc, this.iFn.right, this.iFn.bottom + this.iFM + this.iGb.getHeight() + this.iGc), this.iGc, this.iGc, this.mPaint);
                    }
                }
                canvas.save();
                if (this.iFN) {
                    canvas.translate(0.0f, this.iFn.bottom + this.iFM);
                } else {
                    canvas.translate(this.iFn.left + this.iGc, this.iFn.bottom + this.iFM);
                }
                this.iGb.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.iFP) {
                this.mPaint.setColor(this.iFO);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.iFN) {
                    Rect rect2 = new Rect();
                    this.iFq.getTextBounds(this.hsU, 0, this.hsU.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iGc;
                    canvas.drawRoundRect(new RectF(width2, ((this.iFn.top - this.iFM) - this.iGb.getHeight()) - this.iGc, rect2.width() + width2 + (this.iGc * 2), (this.iFn.top - this.iFM) + this.iGc), this.iGc, this.iGc, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.iFn.left, ((this.iFn.top - this.iFM) - this.iGb.getHeight()) - this.iGc, this.iFn.right, (this.iFn.top - this.iFM) + this.iGc), this.iGc, this.iGc, this.mPaint);
                }
            }
            canvas.save();
            if (this.iFN) {
                canvas.translate(0.0f, (this.iFn.top - this.iFM) - this.iGb.getHeight());
            } else {
                canvas.translate(this.iFn.left + this.iGc, (this.iFn.top - this.iFM) - this.iGb.getHeight());
            }
            this.iGb.draw(canvas);
            canvas.restore();
        }
    }

    private void cfh() {
        if (this.iFG) {
            if (this.iFT == null) {
                this.iFp += this.iFl;
                int i = this.iFw;
                if (this.iFB != null) {
                    i = this.iFB.getWidth();
                }
                if (this.iFQ) {
                    if (i + this.iFp > this.iFn.right - this.iGa || this.iFp < this.iFn.left + this.iGa) {
                        this.iFl = -this.iFl;
                    }
                } else {
                    if (i + this.iFp > this.iFn.right - this.iGa) {
                        this.iFp = this.iFn.left + this.iGa + 0.5f;
                    }
                }
            } else {
                this.iFV += this.iFl;
                if (this.iFV > this.iFn.right - this.iGa) {
                    this.iFV = this.iFn.left + this.iGa + 0.5f;
                }
            }
        } else if (this.iFT == null) {
            this.iFo += this.iFl;
            int i2 = this.iFw;
            if (this.iFB != null) {
                i2 = this.iFB.getHeight();
            }
            if (this.iFQ) {
                if (i2 + this.iFo > this.iFn.bottom - this.iGa || this.iFo < this.iFn.top + this.iGa) {
                    this.iFl = -this.iFl;
                }
            } else {
                if (i2 + this.iFo > this.iFn.bottom - this.iGa) {
                    this.iFo = this.iFn.top + this.iGa + 0.5f;
                }
            }
        } else {
            this.iFU += this.iFl;
            if (this.iFU > this.iFn.bottom - this.iGa) {
                this.iFU = this.iFn.top + this.iGa + 0.5f;
            }
        }
        postInvalidateDelayed(this.iFm, this.iFn.left, this.iFn.top, this.iFn.right, this.iFn.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cfi();
    }

    private void cfi() {
        int i;
        if (this.iFG) {
            i = this.mTopOffset + this.iFF;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.iFt) / 2;
        this.iFn = new Rect(width, i, this.iFt + width, this.iFu + i);
        if (this.iFG) {
            float f = this.iFn.left + this.iGa + 0.5f;
            this.iFp = f;
            this.iFV = f;
            return;
        }
        float f2 = this.iFn.top + this.iGa + 0.5f;
        this.iFo = f2;
        this.iFU = f2;
    }

    public Rect yd(int i) {
        if (this.iGd) {
            Rect rect = new Rect(this.iFn);
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
        this.iFG = z;
        if (this.iFS != null || this.iFR) {
            if (this.iFG) {
                this.iFT = this.iFZ;
            } else {
                this.iFT = this.iFY;
            }
        } else if (this.iFA != null || this.iFz) {
            if (this.iFG) {
                this.iFB = this.iFX;
            } else {
                this.iFB = this.iFW;
            }
        }
        if (this.iFG) {
            this.hsU = this.iFI;
            this.iFu = this.iFv;
            this.iFm = (int) (((this.iFD * 1.0f) * this.iFl) / this.iFt);
        } else {
            this.hsU = this.iFH;
            this.iFu = this.iFt;
            this.iFm = (int) (((this.iFD * 1.0f) * this.iFl) / this.iFu);
        }
        if (!TextUtils.isEmpty(this.hsU)) {
            if (this.iFN) {
                this.iGb = new StaticLayout(this.hsU, this.iFq, a.dU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iGb = new StaticLayout(this.hsU, this.iFq, this.iFt - (this.iGc * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.iFE) {
            int i = a.dU(getContext()).y;
            if (this.iFF == 0) {
                this.mTopOffset = (i - this.iFu) / 2;
            } else if (this.iFG) {
                this.mTopOffset = ((i - this.iFu) / 2) + (this.iFF / 2);
            } else {
                this.mTopOffset = (i - this.iFu) / 2;
            }
        }
        cfi();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.iFG;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.iFr;
    }

    public void setCornerLength(int i) {
        this.iFr = i;
    }

    public int getCornerSize() {
        return this.iFs;
    }

    public void setCornerSize(int i) {
        this.iFs = i;
    }

    public int getRectWidth() {
        return this.iFt;
    }

    public void setRectWidth(int i) {
        this.iFt = i;
    }

    public int getRectHeight() {
        return this.iFu;
    }

    public void setRectHeight(int i) {
        this.iFu = i;
    }

    public int getBarcodeRectHeight() {
        return this.iFv;
    }

    public void setBarcodeRectHeight(int i) {
        this.iFv = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.iFw;
    }

    public void setScanLineSize(int i) {
        this.iFw = i;
    }

    public int getScanLineColor() {
        return this.iFx;
    }

    public void setScanLineColor(int i) {
        this.iFx = i;
    }

    public int getScanLineMargin() {
        return this.iFy;
    }

    public void setScanLineMargin(int i) {
        this.iFy = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.iFz = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.iFA;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.iFA = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.iFB;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.iFB = bitmap;
    }

    public int getBorderSize() {
        return this.iFC;
    }

    public void setBorderSize(int i) {
        this.iFC = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.iFD;
    }

    public void setAnimTime(int i) {
        this.iFD = i;
    }

    public void setCenterVertical(boolean z) {
        this.iFE = z;
    }

    public int getToolbarHeight() {
        return this.iFF;
    }

    public void setToolbarHeight(int i) {
        this.iFF = i;
    }

    public String getQRCodeTipText() {
        return this.iFH;
    }

    public void setQRCodeTipText(String str) {
        this.iFH = str;
    }

    public String getBarCodeTipText() {
        return this.iFI;
    }

    public void setBarCodeTipText(String str) {
        this.iFI = str;
    }

    public String getTipText() {
        return this.hsU;
    }

    public void setTipText(String str) {
        this.hsU = str;
    }

    public int getTipTextColor() {
        return this.iFK;
    }

    public void setTipTextColor(int i) {
        this.iFK = i;
    }

    public int getTipTextSize() {
        return this.iFJ;
    }

    public void setTipTextSize(int i) {
        this.iFJ = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.iFL = z;
    }

    public int getTipTextMargin() {
        return this.iFM;
    }

    public void setTipTextMargin(int i) {
        this.iFM = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.iFN = z;
    }

    public void setShowTipBackground(boolean z) {
        this.iFP = z;
    }

    public int getTipBackgroundColor() {
        return this.iFO;
    }

    public void setTipBackgroundColor(int i) {
        this.iFO = i;
    }

    public void setScanLineReverse(boolean z) {
        this.iFQ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.iFR = z;
    }

    public float getHalfCornerSize() {
        return this.iGa;
    }

    public void setHalfCornerSize(float f) {
        this.iGa = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iGb;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iGb = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iGc;
    }

    public void setTipBackgroundRadius(int i) {
        this.iGc = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.iGd = z;
    }
}
