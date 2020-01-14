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
    private TextPaint jCA;
    private int jCB;
    private int jCC;
    private int jCD;
    private int jCE;
    private int jCF;
    private int jCG;
    private int jCH;
    private boolean jCI;
    private Drawable jCJ;
    private Bitmap jCK;
    private int jCL;
    private int jCM;
    private boolean jCN;
    private int jCO;
    private boolean jCP;
    private String jCQ;
    private String jCR;
    private int jCS;
    private int jCT;
    private boolean jCU;
    private int jCV;
    private boolean jCW;
    private int jCX;
    private boolean jCY;
    private boolean jCZ;
    private Bitmap jCr;
    private Bitmap jCs;
    private Bitmap jCt;
    private Bitmap jCu;
    private int jCv;
    private int jCw;
    private Rect jCx;
    private float jCy;
    private float jCz;
    private boolean jDa;
    private Drawable jDb;
    private Bitmap jDc;
    private float jDd;
    private float jDe;
    private Bitmap jDf;
    private Bitmap jDg;
    private Bitmap jDh;
    private Bitmap jDi;
    private float jDj;
    private StaticLayout jDk;
    private int jDl;
    private boolean jDm;
    private ColorMatrixColorFilter jDn;
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
        this.jCB = a.dp2px(context, 20.0f);
        this.jCC = a.dp2px(context, 3.0f);
        this.jCF = a.dp2px(context, 1.0f);
        this.jCG = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aVB = a.dp2px(context, 200.0f);
        this.jCE = a.dp2px(context, 140.0f);
        this.jCH = 0;
        this.jCI = false;
        this.jCJ = null;
        this.jCK = null;
        this.jCL = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jCM = 1000;
        this.jCN = false;
        this.jCO = 0;
        this.jCP = false;
        this.jCv = a.dp2px(context, 2.0f);
        this.ijL = null;
        this.jCS = a.h(context, 14.0f);
        this.jCT = -1;
        this.jCU = false;
        this.jCV = a.dp2px(context, 20.0f);
        this.jCW = false;
        this.jCX = Color.parseColor("#22000000");
        this.jCY = false;
        this.jCZ = false;
        this.jDa = false;
        this.jCA = new TextPaint();
        this.jCA.setAntiAlias(true);
        this.jDl = a.dp2px(context, 4.0f);
        this.jDm = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jDn = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cAs();
        cAr();
    }

    private void cAr() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jCB;
        options.outHeight = this.jCB;
        this.jCr = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jCs = Bitmap.createBitmap(this.jCr, 0, 0, this.jCr.getWidth(), this.jCr.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jCt = Bitmap.createBitmap(this.jCr, 0, 0, this.jCr.getWidth(), this.jCr.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jCu = Bitmap.createBitmap(this.jCr, 0, 0, this.jCr.getWidth(), this.jCr.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jCC = typedArray.getDimensionPixelSize(i, this.jCC);
        } else if (i == 2) {
            this.jCB = typedArray.getDimensionPixelSize(i, this.jCB);
        } else if (i == 6) {
            this.jCF = typedArray.getDimensionPixelSize(i, this.jCF);
        } else if (i == 3) {
            this.aVB = typedArray.getDimensionPixelSize(i, this.aVB);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jCG = typedArray.getColor(i, this.jCG);
        } else if (i == 8) {
            this.jCH = typedArray.getDimensionPixelSize(i, this.jCH);
        } else if (i == 9) {
            this.jCI = typedArray.getBoolean(i, this.jCI);
        } else if (i == 10) {
            this.jCJ = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jCL = typedArray.getDimensionPixelSize(i, this.jCL);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jCM = typedArray.getInteger(i, this.jCM);
        } else if (i == 14) {
            this.jCN = typedArray.getBoolean(i, this.jCN);
        } else if (i == 15) {
            this.jCO = typedArray.getDimensionPixelSize(i, this.jCO);
        } else if (i == 4) {
            this.jCE = typedArray.getDimensionPixelSize(i, this.jCE);
        } else if (i == 16) {
            this.jCP = typedArray.getBoolean(i, this.jCP);
        } else if (i == 18) {
            this.jCR = typedArray.getString(i);
        } else if (i == 17) {
            this.jCQ = typedArray.getString(i);
        } else if (i == 19) {
            this.jCS = typedArray.getDimensionPixelSize(i, this.jCS);
        } else if (i == 20) {
            this.jCT = typedArray.getColor(i, this.jCT);
        } else if (i == 21) {
            this.jCU = typedArray.getBoolean(i, this.jCU);
        } else if (i == 22) {
            this.jCV = typedArray.getDimensionPixelSize(i, this.jCV);
        } else if (i == 23) {
            this.jCW = typedArray.getBoolean(i, this.jCW);
        } else if (i == 24) {
            this.jCY = typedArray.getBoolean(i, this.jCY);
        } else if (i == 25) {
            this.jCX = typedArray.getColor(i, this.jCX);
        } else if (i == 26) {
            this.jCZ = typedArray.getBoolean(i, this.jCZ);
        } else if (i == 27) {
            this.jDa = typedArray.getBoolean(i, this.jDa);
        } else if (i == 28) {
            this.jDb = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jDm = typedArray.getBoolean(i, this.jDm);
        }
    }

    private void cAs() {
        if (this.jDb != null) {
            this.jDh = ((BitmapDrawable) this.jDb).getBitmap();
        }
        if (this.jDh == null) {
            this.jDh = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDh = a.e(this.jDh, this.jCG);
        }
        this.jDi = a.adjustPhotoRotation(this.jDh, 90);
        this.jDi = a.adjustPhotoRotation(this.jDi, 90);
        this.jDi = a.adjustPhotoRotation(this.jDi, 90);
        if (this.jCJ != null) {
            this.jDf = ((BitmapDrawable) this.jCJ).getBitmap();
        }
        if (this.jDf == null) {
            this.jDf = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDf = a.e(this.jDf, this.jCG);
        }
        this.jDg = a.adjustPhotoRotation(this.jDf, 90);
        this.jDj = (1.0f * this.jCC) / 2.0f;
        this.jCA.setTextSize(this.jCS);
        this.jCA.setColor(this.jCT);
        setIsBarcode(this.jCP);
    }

    public void cAt() {
        this.jCA.setColor(this.jCT);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jCx != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            cAu();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jCx.top, this.mPaint);
            canvas.drawRect(0.0f, this.jCx.top, this.jCx.left, this.jCx.bottom + 1, this.mPaint);
            canvas.drawRect(this.jCx.right + 1, this.jCx.top, width, this.jCx.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jCx.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jCL > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jCL);
            canvas.drawRect(this.jCx, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jCr, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jCs, getMainFrameRight() - this.jCr.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jCt, getMainFrameLeft(), getMainFrameBottom() - this.jCr.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jCu, getMainFrameRight() - this.jCr.getWidth(), getMainFrameBottom() - this.jCr.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jCx.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jCx.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jCx.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jCx.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jCL / 2;
    }

    private void T(Canvas canvas) {
        if (this.jCP) {
            if (this.jDc != null) {
                RectF rectF = new RectF(this.jCx.left + this.jDj + 0.5f, this.jCx.top + this.jDj + this.jCH, this.jDe, (this.jCx.bottom - this.jDj) - this.jCH);
                Rect rect = new Rect((int) (this.jDc.getWidth() - rectF.width()), 0, this.jDc.getWidth(), this.jDc.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jDc, rect, rectF, this.mPaint);
            } else if (this.jCK != null) {
                canvas.drawBitmap(this.jCK, (Rect) null, new RectF(this.jCz, this.jCx.top + this.jDj + this.jCH, this.jCz + this.jCK.getWidth(), (this.jCx.bottom - this.jDj) - this.jCH), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jCG);
                canvas.drawRect(this.jCz, this.jCH + this.jCx.top + this.jDj, this.jCF + this.jCz, (this.jCx.bottom - this.jDj) - this.jCH, this.mPaint);
            }
        } else if (this.jDc != null) {
            RectF rectF2 = new RectF(this.jCx.left + this.jDj + this.jCH, this.jCx.top + this.jDj + 0.5f, (this.jCx.right - this.jDj) - this.jCH, this.jDd);
            Rect rect2 = new Rect(0, (int) (this.jDc.getHeight() - rectF2.height()), this.jDc.getWidth(), this.jDc.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jDn);
            canvas.drawBitmap(this.jDc, rect2, rectF2, this.mPaint);
        } else if (this.jCK != null) {
            canvas.drawBitmap(this.jCK, (Rect) null, new RectF(this.jCx.left + this.jDj + this.jCH, this.jCy, (this.jCx.right - this.jDj) - this.jCH, this.jCy + this.jCK.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jCG);
            canvas.drawRect(this.jCH + this.jCx.left + this.jDj, this.jCy, (this.jCx.right - this.jDj) - this.jCH, this.jCF + this.jCy, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.ijL) && this.jDk != null) {
            if (this.jCU) {
                if (this.jCY) {
                    this.mPaint.setColor(this.jCX);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jCW) {
                        Rect rect = new Rect();
                        this.jCA.getTextBounds(this.ijL, 0, this.ijL.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jDl;
                        canvas.drawRoundRect(new RectF(width, (this.jCx.bottom + this.jCV) - this.jDl, rect.width() + width + (this.jDl * 2), this.jCx.bottom + this.jCV + this.jDk.getHeight() + this.jDl), this.jDl, this.jDl, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jCx.left, (this.jCx.bottom + this.jCV) - this.jDl, this.jCx.right, this.jCx.bottom + this.jCV + this.jDk.getHeight() + this.jDl), this.jDl, this.jDl, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jCW) {
                    canvas.translate(0.0f, this.jCx.bottom + this.jCV);
                } else {
                    canvas.translate(this.jCx.left + this.jDl, this.jCx.bottom + this.jCV);
                }
                this.jDk.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jCY) {
                this.mPaint.setColor(this.jCX);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jCW) {
                    Rect rect2 = new Rect();
                    this.jCA.getTextBounds(this.ijL, 0, this.ijL.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jDl;
                    canvas.drawRoundRect(new RectF(width2, ((this.jCx.top - this.jCV) - this.jDk.getHeight()) - this.jDl, rect2.width() + width2 + (this.jDl * 2), (this.jCx.top - this.jCV) + this.jDl), this.jDl, this.jDl, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jCx.left, ((this.jCx.top - this.jCV) - this.jDk.getHeight()) - this.jDl, this.jCx.right, (this.jCx.top - this.jCV) + this.jDl), this.jDl, this.jDl, this.mPaint);
                }
            }
            canvas.save();
            if (this.jCW) {
                canvas.translate(0.0f, (this.jCx.top - this.jCV) - this.jDk.getHeight());
            } else {
                canvas.translate(this.jCx.left + this.jDl, (this.jCx.top - this.jCV) - this.jDk.getHeight());
            }
            this.jDk.draw(canvas);
            canvas.restore();
        }
    }

    private void cAu() {
        if (this.jCP) {
            if (this.jDc == null) {
                this.jCz += this.jCv;
                int i = this.jCF;
                if (this.jCK != null) {
                    i = this.jCK.getWidth();
                }
                if (this.jCZ) {
                    if (i + this.jCz > this.jCx.right - this.jDj || this.jCz < this.jCx.left + this.jDj) {
                        this.jCv = -this.jCv;
                    }
                } else {
                    if (i + this.jCz > this.jCx.right - this.jDj) {
                        this.jCz = this.jCx.left + this.jDj + 0.5f;
                    }
                }
            } else {
                this.jDe += this.jCv;
                if (this.jDe > this.jCx.right - this.jDj) {
                    this.jDe = this.jCx.left + this.jDj + 0.5f;
                }
            }
        } else if (this.jDc == null) {
            this.jCy += this.jCv;
            int i2 = this.jCF;
            if (this.jCK != null) {
                i2 = this.jCK.getHeight();
            }
            if (this.jCZ) {
                if (i2 + this.jCy > this.jCx.bottom - this.jDj || this.jCy < this.jCx.top + this.jDj) {
                    this.jCv = -this.jCv;
                }
            } else {
                if (i2 + this.jCy > this.jCx.bottom - this.jDj) {
                    this.jCy = this.jCx.top + this.jDj + 0.5f;
                }
            }
        } else {
            this.jDd += this.jCv;
            if (this.jDd > this.jCx.bottom - this.jDj) {
                this.jDd = this.jCx.top + this.jDj + 0.5f;
            }
        }
        postInvalidateDelayed(this.jCw, this.jCx.left, this.jCx.top, this.jCx.right, this.jCx.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cAv();
    }

    private void cAv() {
        int i;
        if (this.jCP) {
            i = this.mTopOffset + this.jCO;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aVB) / 2;
        this.jCx = new Rect(width, i, this.aVB + width, this.jCD + i);
        if (this.jCP) {
            float f = this.jCx.left + this.jDj + 0.5f;
            this.jCz = f;
            this.jDe = f;
            return;
        }
        float f2 = this.jCx.top + this.jDj + 0.5f;
        this.jCy = f2;
        this.jDd = f2;
    }

    public Rect AD(int i) {
        if (this.jDm) {
            Rect rect = new Rect(this.jCx);
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
        this.jCP = z;
        if (this.jDb != null || this.jDa) {
            if (this.jCP) {
                this.jDc = this.jDi;
            } else {
                this.jDc = this.jDh;
            }
        } else if (this.jCJ != null || this.jCI) {
            if (this.jCP) {
                this.jCK = this.jDg;
            } else {
                this.jCK = this.jDf;
            }
        }
        if (this.jCP) {
            this.ijL = this.jCR;
            this.jCD = this.jCE;
            this.jCw = (int) (((this.jCM * 1.0f) * this.jCv) / this.aVB);
        } else {
            this.ijL = this.jCQ;
            this.jCD = this.aVB;
            this.jCw = (int) (((this.jCM * 1.0f) * this.jCv) / this.jCD);
        }
        if (!TextUtils.isEmpty(this.ijL)) {
            if (this.jCW) {
                this.jDk = new StaticLayout(this.ijL, this.jCA, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jDk = new StaticLayout(this.ijL, this.jCA, this.aVB - (this.jDl * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jCN) {
            int i = a.fm(getContext()).y;
            if (this.jCO == 0) {
                this.mTopOffset = (i - this.jCD) / 2;
            } else if (this.jCP) {
                this.mTopOffset = ((i - this.jCD) / 2) + (this.jCO / 2);
            } else {
                this.mTopOffset = (i - this.jCD) / 2;
            }
        }
        cAv();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jCP;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jCB;
    }

    public void setCornerLength(int i) {
        this.jCB = i;
    }

    public int getCornerSize() {
        return this.jCC;
    }

    public void setCornerSize(int i) {
        this.jCC = i;
    }

    public int getRectWidth() {
        return this.aVB;
    }

    public void setRectWidth(int i) {
        this.aVB = i;
    }

    public int getRectHeight() {
        return this.jCD;
    }

    public void setRectHeight(int i) {
        this.jCD = i;
    }

    public int getBarcodeRectHeight() {
        return this.jCE;
    }

    public void setBarcodeRectHeight(int i) {
        this.jCE = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jCF;
    }

    public void setScanLineSize(int i) {
        this.jCF = i;
    }

    public int getScanLineColor() {
        return this.jCG;
    }

    public void setScanLineColor(int i) {
        this.jCG = i;
    }

    public int getScanLineMargin() {
        return this.jCH;
    }

    public void setScanLineMargin(int i) {
        this.jCH = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jCI = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jCJ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jCJ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jCK;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jCK = bitmap;
    }

    public int getBorderSize() {
        return this.jCL;
    }

    public void setBorderSize(int i) {
        this.jCL = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jCM;
    }

    public void setAnimTime(int i) {
        this.jCM = i;
    }

    public void setCenterVertical(boolean z) {
        this.jCN = z;
    }

    public int getToolbarHeight() {
        return this.jCO;
    }

    public void setToolbarHeight(int i) {
        this.jCO = i;
    }

    public String getQRCodeTipText() {
        return this.jCQ;
    }

    public void setQRCodeTipText(String str) {
        this.jCQ = str;
    }

    public String getBarCodeTipText() {
        return this.jCR;
    }

    public void setBarCodeTipText(String str) {
        this.jCR = str;
    }

    public String getTipText() {
        return this.ijL;
    }

    public void setTipText(String str) {
        this.ijL = str;
    }

    public int getTipTextColor() {
        return this.jCT;
    }

    public void setTipTextColor(int i) {
        this.jCT = i;
    }

    public int getTipTextSize() {
        return this.jCS;
    }

    public void setTipTextSize(int i) {
        this.jCS = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jCU = z;
    }

    public int getTipTextMargin() {
        return this.jCV;
    }

    public void setTipTextMargin(int i) {
        this.jCV = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jCW = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jCY = z;
    }

    public int getTipBackgroundColor() {
        return this.jCX;
    }

    public void setTipBackgroundColor(int i) {
        this.jCX = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jCZ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jDa = z;
    }

    public float getHalfCornerSize() {
        return this.jDj;
    }

    public void setHalfCornerSize(float f) {
        this.jDj = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jDk;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jDk = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jDl;
    }

    public void setTipBackgroundRadius(int i) {
        this.jDl = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jDm = z;
    }
}
