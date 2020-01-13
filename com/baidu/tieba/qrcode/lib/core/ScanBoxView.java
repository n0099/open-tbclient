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
    private int aVB;
    private String ijL;
    private int jCA;
    private int jCB;
    private int jCC;
    private boolean jCD;
    private Drawable jCE;
    private Bitmap jCF;
    private int jCG;
    private int jCH;
    private boolean jCI;
    private int jCJ;
    private boolean jCK;
    private String jCL;
    private String jCM;
    private int jCN;
    private int jCO;
    private boolean jCP;
    private int jCQ;
    private boolean jCR;
    private int jCS;
    private boolean jCT;
    private boolean jCU;
    private boolean jCV;
    private Drawable jCW;
    private Bitmap jCX;
    private float jCY;
    private float jCZ;
    private Bitmap jCm;
    private Bitmap jCn;
    private Bitmap jCo;
    private Bitmap jCp;
    private int jCq;
    private int jCr;
    private Rect jCs;
    private float jCt;
    private float jCu;
    private TextPaint jCv;
    private int jCw;
    private int jCx;
    private int jCy;
    private int jCz;
    private Bitmap jDa;
    private Bitmap jDb;
    private Bitmap jDc;
    private Bitmap jDd;
    private float jDe;
    private StaticLayout jDf;
    private int jDg;
    private boolean jDh;
    private ColorMatrixColorFilter jDi;
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
        this.jCw = a.dp2px(context, 20.0f);
        this.jCx = a.dp2px(context, 3.0f);
        this.jCA = a.dp2px(context, 1.0f);
        this.jCB = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aVB = a.dp2px(context, 200.0f);
        this.jCz = a.dp2px(context, 140.0f);
        this.jCC = 0;
        this.jCD = false;
        this.jCE = null;
        this.jCF = null;
        this.jCG = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jCH = 1000;
        this.jCI = false;
        this.jCJ = 0;
        this.jCK = false;
        this.jCq = a.dp2px(context, 2.0f);
        this.ijL = null;
        this.jCN = a.h(context, 14.0f);
        this.jCO = -1;
        this.jCP = false;
        this.jCQ = a.dp2px(context, 20.0f);
        this.jCR = false;
        this.jCS = Color.parseColor("#22000000");
        this.jCT = false;
        this.jCU = false;
        this.jCV = false;
        this.jCv = new TextPaint();
        this.jCv.setAntiAlias(true);
        this.jDg = a.dp2px(context, 4.0f);
        this.jDh = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jDi = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cAq();
        cAp();
    }

    private void cAp() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jCw;
        options.outHeight = this.jCw;
        this.jCm = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jCn = Bitmap.createBitmap(this.jCm, 0, 0, this.jCm.getWidth(), this.jCm.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jCo = Bitmap.createBitmap(this.jCm, 0, 0, this.jCm.getWidth(), this.jCm.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jCp = Bitmap.createBitmap(this.jCm, 0, 0, this.jCm.getWidth(), this.jCm.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jCx = typedArray.getDimensionPixelSize(i, this.jCx);
        } else if (i == 2) {
            this.jCw = typedArray.getDimensionPixelSize(i, this.jCw);
        } else if (i == 6) {
            this.jCA = typedArray.getDimensionPixelSize(i, this.jCA);
        } else if (i == 3) {
            this.aVB = typedArray.getDimensionPixelSize(i, this.aVB);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jCB = typedArray.getColor(i, this.jCB);
        } else if (i == 8) {
            this.jCC = typedArray.getDimensionPixelSize(i, this.jCC);
        } else if (i == 9) {
            this.jCD = typedArray.getBoolean(i, this.jCD);
        } else if (i == 10) {
            this.jCE = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jCG = typedArray.getDimensionPixelSize(i, this.jCG);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jCH = typedArray.getInteger(i, this.jCH);
        } else if (i == 14) {
            this.jCI = typedArray.getBoolean(i, this.jCI);
        } else if (i == 15) {
            this.jCJ = typedArray.getDimensionPixelSize(i, this.jCJ);
        } else if (i == 4) {
            this.jCz = typedArray.getDimensionPixelSize(i, this.jCz);
        } else if (i == 16) {
            this.jCK = typedArray.getBoolean(i, this.jCK);
        } else if (i == 18) {
            this.jCM = typedArray.getString(i);
        } else if (i == 17) {
            this.jCL = typedArray.getString(i);
        } else if (i == 19) {
            this.jCN = typedArray.getDimensionPixelSize(i, this.jCN);
        } else if (i == 20) {
            this.jCO = typedArray.getColor(i, this.jCO);
        } else if (i == 21) {
            this.jCP = typedArray.getBoolean(i, this.jCP);
        } else if (i == 22) {
            this.jCQ = typedArray.getDimensionPixelSize(i, this.jCQ);
        } else if (i == 23) {
            this.jCR = typedArray.getBoolean(i, this.jCR);
        } else if (i == 24) {
            this.jCT = typedArray.getBoolean(i, this.jCT);
        } else if (i == 25) {
            this.jCS = typedArray.getColor(i, this.jCS);
        } else if (i == 26) {
            this.jCU = typedArray.getBoolean(i, this.jCU);
        } else if (i == 27) {
            this.jCV = typedArray.getBoolean(i, this.jCV);
        } else if (i == 28) {
            this.jCW = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jDh = typedArray.getBoolean(i, this.jDh);
        }
    }

    private void cAq() {
        if (this.jCW != null) {
            this.jDc = ((BitmapDrawable) this.jCW).getBitmap();
        }
        if (this.jDc == null) {
            this.jDc = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDc = a.e(this.jDc, this.jCB);
        }
        this.jDd = a.adjustPhotoRotation(this.jDc, 90);
        this.jDd = a.adjustPhotoRotation(this.jDd, 90);
        this.jDd = a.adjustPhotoRotation(this.jDd, 90);
        if (this.jCE != null) {
            this.jDa = ((BitmapDrawable) this.jCE).getBitmap();
        }
        if (this.jDa == null) {
            this.jDa = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDa = a.e(this.jDa, this.jCB);
        }
        this.jDb = a.adjustPhotoRotation(this.jDa, 90);
        this.jDe = (1.0f * this.jCx) / 2.0f;
        this.jCv.setTextSize(this.jCN);
        this.jCv.setColor(this.jCO);
        setIsBarcode(this.jCK);
    }

    public void cAr() {
        this.jCv.setColor(this.jCO);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jCs != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            cAs();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jCs.top, this.mPaint);
            canvas.drawRect(0.0f, this.jCs.top, this.jCs.left, this.jCs.bottom + 1, this.mPaint);
            canvas.drawRect(this.jCs.right + 1, this.jCs.top, width, this.jCs.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jCs.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jCG > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jCG);
            canvas.drawRect(this.jCs, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jCm, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jCn, getMainFrameRight() - this.jCm.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jCo, getMainFrameLeft(), getMainFrameBottom() - this.jCm.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jCp, getMainFrameRight() - this.jCm.getWidth(), getMainFrameBottom() - this.jCm.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jCs.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jCs.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jCs.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jCs.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jCG / 2;
    }

    private void T(Canvas canvas) {
        if (this.jCK) {
            if (this.jCX != null) {
                RectF rectF = new RectF(this.jCs.left + this.jDe + 0.5f, this.jCs.top + this.jDe + this.jCC, this.jCZ, (this.jCs.bottom - this.jDe) - this.jCC);
                Rect rect = new Rect((int) (this.jCX.getWidth() - rectF.width()), 0, this.jCX.getWidth(), this.jCX.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jCX, rect, rectF, this.mPaint);
            } else if (this.jCF != null) {
                canvas.drawBitmap(this.jCF, (Rect) null, new RectF(this.jCu, this.jCs.top + this.jDe + this.jCC, this.jCu + this.jCF.getWidth(), (this.jCs.bottom - this.jDe) - this.jCC), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jCB);
                canvas.drawRect(this.jCu, this.jCC + this.jCs.top + this.jDe, this.jCA + this.jCu, (this.jCs.bottom - this.jDe) - this.jCC, this.mPaint);
            }
        } else if (this.jCX != null) {
            RectF rectF2 = new RectF(this.jCs.left + this.jDe + this.jCC, this.jCs.top + this.jDe + 0.5f, (this.jCs.right - this.jDe) - this.jCC, this.jCY);
            Rect rect2 = new Rect(0, (int) (this.jCX.getHeight() - rectF2.height()), this.jCX.getWidth(), this.jCX.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jDi);
            canvas.drawBitmap(this.jCX, rect2, rectF2, this.mPaint);
        } else if (this.jCF != null) {
            canvas.drawBitmap(this.jCF, (Rect) null, new RectF(this.jCs.left + this.jDe + this.jCC, this.jCt, (this.jCs.right - this.jDe) - this.jCC, this.jCt + this.jCF.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jCB);
            canvas.drawRect(this.jCC + this.jCs.left + this.jDe, this.jCt, (this.jCs.right - this.jDe) - this.jCC, this.jCA + this.jCt, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.ijL) && this.jDf != null) {
            if (this.jCP) {
                if (this.jCT) {
                    this.mPaint.setColor(this.jCS);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jCR) {
                        Rect rect = new Rect();
                        this.jCv.getTextBounds(this.ijL, 0, this.ijL.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jDg;
                        canvas.drawRoundRect(new RectF(width, (this.jCs.bottom + this.jCQ) - this.jDg, rect.width() + width + (this.jDg * 2), this.jCs.bottom + this.jCQ + this.jDf.getHeight() + this.jDg), this.jDg, this.jDg, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jCs.left, (this.jCs.bottom + this.jCQ) - this.jDg, this.jCs.right, this.jCs.bottom + this.jCQ + this.jDf.getHeight() + this.jDg), this.jDg, this.jDg, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jCR) {
                    canvas.translate(0.0f, this.jCs.bottom + this.jCQ);
                } else {
                    canvas.translate(this.jCs.left + this.jDg, this.jCs.bottom + this.jCQ);
                }
                this.jDf.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jCT) {
                this.mPaint.setColor(this.jCS);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jCR) {
                    Rect rect2 = new Rect();
                    this.jCv.getTextBounds(this.ijL, 0, this.ijL.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jDg;
                    canvas.drawRoundRect(new RectF(width2, ((this.jCs.top - this.jCQ) - this.jDf.getHeight()) - this.jDg, rect2.width() + width2 + (this.jDg * 2), (this.jCs.top - this.jCQ) + this.jDg), this.jDg, this.jDg, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jCs.left, ((this.jCs.top - this.jCQ) - this.jDf.getHeight()) - this.jDg, this.jCs.right, (this.jCs.top - this.jCQ) + this.jDg), this.jDg, this.jDg, this.mPaint);
                }
            }
            canvas.save();
            if (this.jCR) {
                canvas.translate(0.0f, (this.jCs.top - this.jCQ) - this.jDf.getHeight());
            } else {
                canvas.translate(this.jCs.left + this.jDg, (this.jCs.top - this.jCQ) - this.jDf.getHeight());
            }
            this.jDf.draw(canvas);
            canvas.restore();
        }
    }

    private void cAs() {
        if (this.jCK) {
            if (this.jCX == null) {
                this.jCu += this.jCq;
                int i = this.jCA;
                if (this.jCF != null) {
                    i = this.jCF.getWidth();
                }
                if (this.jCU) {
                    if (i + this.jCu > this.jCs.right - this.jDe || this.jCu < this.jCs.left + this.jDe) {
                        this.jCq = -this.jCq;
                    }
                } else {
                    if (i + this.jCu > this.jCs.right - this.jDe) {
                        this.jCu = this.jCs.left + this.jDe + 0.5f;
                    }
                }
            } else {
                this.jCZ += this.jCq;
                if (this.jCZ > this.jCs.right - this.jDe) {
                    this.jCZ = this.jCs.left + this.jDe + 0.5f;
                }
            }
        } else if (this.jCX == null) {
            this.jCt += this.jCq;
            int i2 = this.jCA;
            if (this.jCF != null) {
                i2 = this.jCF.getHeight();
            }
            if (this.jCU) {
                if (i2 + this.jCt > this.jCs.bottom - this.jDe || this.jCt < this.jCs.top + this.jDe) {
                    this.jCq = -this.jCq;
                }
            } else {
                if (i2 + this.jCt > this.jCs.bottom - this.jDe) {
                    this.jCt = this.jCs.top + this.jDe + 0.5f;
                }
            }
        } else {
            this.jCY += this.jCq;
            if (this.jCY > this.jCs.bottom - this.jDe) {
                this.jCY = this.jCs.top + this.jDe + 0.5f;
            }
        }
        postInvalidateDelayed(this.jCr, this.jCs.left, this.jCs.top, this.jCs.right, this.jCs.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cAt();
    }

    private void cAt() {
        int i;
        if (this.jCK) {
            i = this.mTopOffset + this.jCJ;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aVB) / 2;
        this.jCs = new Rect(width, i, this.aVB + width, this.jCy + i);
        if (this.jCK) {
            float f = this.jCs.left + this.jDe + 0.5f;
            this.jCu = f;
            this.jCZ = f;
            return;
        }
        float f2 = this.jCs.top + this.jDe + 0.5f;
        this.jCt = f2;
        this.jCY = f2;
    }

    public Rect AD(int i) {
        if (this.jDh) {
            Rect rect = new Rect(this.jCs);
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
        this.jCK = z;
        if (this.jCW != null || this.jCV) {
            if (this.jCK) {
                this.jCX = this.jDd;
            } else {
                this.jCX = this.jDc;
            }
        } else if (this.jCE != null || this.jCD) {
            if (this.jCK) {
                this.jCF = this.jDb;
            } else {
                this.jCF = this.jDa;
            }
        }
        if (this.jCK) {
            this.ijL = this.jCM;
            this.jCy = this.jCz;
            this.jCr = (int) (((this.jCH * 1.0f) * this.jCq) / this.aVB);
        } else {
            this.ijL = this.jCL;
            this.jCy = this.aVB;
            this.jCr = (int) (((this.jCH * 1.0f) * this.jCq) / this.jCy);
        }
        if (!TextUtils.isEmpty(this.ijL)) {
            if (this.jCR) {
                this.jDf = new StaticLayout(this.ijL, this.jCv, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jDf = new StaticLayout(this.ijL, this.jCv, this.aVB - (this.jDg * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jCI) {
            int i = a.fm(getContext()).y;
            if (this.jCJ == 0) {
                this.mTopOffset = (i - this.jCy) / 2;
            } else if (this.jCK) {
                this.mTopOffset = ((i - this.jCy) / 2) + (this.jCJ / 2);
            } else {
                this.mTopOffset = (i - this.jCy) / 2;
            }
        }
        cAt();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jCK;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jCw;
    }

    public void setCornerLength(int i) {
        this.jCw = i;
    }

    public int getCornerSize() {
        return this.jCx;
    }

    public void setCornerSize(int i) {
        this.jCx = i;
    }

    public int getRectWidth() {
        return this.aVB;
    }

    public void setRectWidth(int i) {
        this.aVB = i;
    }

    public int getRectHeight() {
        return this.jCy;
    }

    public void setRectHeight(int i) {
        this.jCy = i;
    }

    public int getBarcodeRectHeight() {
        return this.jCz;
    }

    public void setBarcodeRectHeight(int i) {
        this.jCz = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jCA;
    }

    public void setScanLineSize(int i) {
        this.jCA = i;
    }

    public int getScanLineColor() {
        return this.jCB;
    }

    public void setScanLineColor(int i) {
        this.jCB = i;
    }

    public int getScanLineMargin() {
        return this.jCC;
    }

    public void setScanLineMargin(int i) {
        this.jCC = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jCD = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jCE;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jCE = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jCF;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jCF = bitmap;
    }

    public int getBorderSize() {
        return this.jCG;
    }

    public void setBorderSize(int i) {
        this.jCG = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jCH;
    }

    public void setAnimTime(int i) {
        this.jCH = i;
    }

    public void setCenterVertical(boolean z) {
        this.jCI = z;
    }

    public int getToolbarHeight() {
        return this.jCJ;
    }

    public void setToolbarHeight(int i) {
        this.jCJ = i;
    }

    public String getQRCodeTipText() {
        return this.jCL;
    }

    public void setQRCodeTipText(String str) {
        this.jCL = str;
    }

    public String getBarCodeTipText() {
        return this.jCM;
    }

    public void setBarCodeTipText(String str) {
        this.jCM = str;
    }

    public String getTipText() {
        return this.ijL;
    }

    public void setTipText(String str) {
        this.ijL = str;
    }

    public int getTipTextColor() {
        return this.jCO;
    }

    public void setTipTextColor(int i) {
        this.jCO = i;
    }

    public int getTipTextSize() {
        return this.jCN;
    }

    public void setTipTextSize(int i) {
        this.jCN = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jCP = z;
    }

    public int getTipTextMargin() {
        return this.jCQ;
    }

    public void setTipTextMargin(int i) {
        this.jCQ = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jCR = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jCT = z;
    }

    public int getTipBackgroundColor() {
        return this.jCS;
    }

    public void setTipBackgroundColor(int i) {
        this.jCS = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jCU = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jCV = z;
    }

    public float getHalfCornerSize() {
        return this.jDe;
    }

    public void setHalfCornerSize(float f) {
        this.jDe = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jDf;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jDf = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jDg;
    }

    public void setTipBackgroundRadius(int i) {
        this.jDg = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jDh = z;
    }
}
