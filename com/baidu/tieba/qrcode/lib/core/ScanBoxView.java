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
/* loaded from: classes10.dex */
public class ScanBoxView extends View {
    private int aZP;
    private String ilZ;
    private int jDA;
    private int jDB;
    private Rect jDC;
    private float jDD;
    private float jDE;
    private TextPaint jDF;
    private int jDG;
    private int jDH;
    private int jDI;
    private int jDJ;
    private int jDK;
    private int jDL;
    private int jDM;
    private boolean jDN;
    private Drawable jDO;
    private Bitmap jDP;
    private int jDQ;
    private int jDR;
    private boolean jDS;
    private int jDT;
    private boolean jDU;
    private String jDV;
    private String jDW;
    private int jDX;
    private int jDY;
    private boolean jDZ;
    private Bitmap jDw;
    private Bitmap jDx;
    private Bitmap jDy;
    private Bitmap jDz;
    private int jEa;
    private boolean jEb;
    private int jEc;
    private boolean jEd;
    private boolean jEe;
    private boolean jEf;
    private Drawable jEg;
    private Bitmap jEh;
    private float jEi;
    private float jEj;
    private Bitmap jEk;
    private Bitmap jEl;
    private Bitmap jEm;
    private Bitmap jEn;
    private float jEo;
    private StaticLayout jEp;
    private int jEq;
    private boolean jEr;
    private ColorMatrixColorFilter jEs;
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
        this.jDG = a.dp2px(context, 20.0f);
        this.jDH = a.dp2px(context, 3.0f);
        this.jDK = a.dp2px(context, 1.0f);
        this.jDL = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aZP = a.dp2px(context, 200.0f);
        this.jDJ = a.dp2px(context, 140.0f);
        this.jDM = 0;
        this.jDN = false;
        this.jDO = null;
        this.jDP = null;
        this.jDQ = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jDR = 1000;
        this.jDS = false;
        this.jDT = 0;
        this.jDU = false;
        this.jDA = a.dp2px(context, 2.0f);
        this.ilZ = null;
        this.jDX = a.h(context, 14.0f);
        this.jDY = -1;
        this.jDZ = false;
        this.jEa = a.dp2px(context, 20.0f);
        this.jEb = false;
        this.jEc = Color.parseColor("#22000000");
        this.jEd = false;
        this.jEe = false;
        this.jEf = false;
        this.jDF = new TextPaint();
        this.jDF.setAntiAlias(true);
        this.jEq = a.dp2px(context, 4.0f);
        this.jEr = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jEs = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cBQ();
        cBP();
    }

    private void cBP() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jDG;
        options.outHeight = this.jDG;
        this.jDw = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jDx = Bitmap.createBitmap(this.jDw, 0, 0, this.jDw.getWidth(), this.jDw.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jDy = Bitmap.createBitmap(this.jDw, 0, 0, this.jDw.getWidth(), this.jDw.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jDz = Bitmap.createBitmap(this.jDw, 0, 0, this.jDw.getWidth(), this.jDw.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jDH = typedArray.getDimensionPixelSize(i, this.jDH);
        } else if (i == 2) {
            this.jDG = typedArray.getDimensionPixelSize(i, this.jDG);
        } else if (i == 6) {
            this.jDK = typedArray.getDimensionPixelSize(i, this.jDK);
        } else if (i == 3) {
            this.aZP = typedArray.getDimensionPixelSize(i, this.aZP);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jDL = typedArray.getColor(i, this.jDL);
        } else if (i == 8) {
            this.jDM = typedArray.getDimensionPixelSize(i, this.jDM);
        } else if (i == 9) {
            this.jDN = typedArray.getBoolean(i, this.jDN);
        } else if (i == 10) {
            this.jDO = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jDQ = typedArray.getDimensionPixelSize(i, this.jDQ);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jDR = typedArray.getInteger(i, this.jDR);
        } else if (i == 14) {
            this.jDS = typedArray.getBoolean(i, this.jDS);
        } else if (i == 15) {
            this.jDT = typedArray.getDimensionPixelSize(i, this.jDT);
        } else if (i == 4) {
            this.jDJ = typedArray.getDimensionPixelSize(i, this.jDJ);
        } else if (i == 16) {
            this.jDU = typedArray.getBoolean(i, this.jDU);
        } else if (i == 18) {
            this.jDW = typedArray.getString(i);
        } else if (i == 17) {
            this.jDV = typedArray.getString(i);
        } else if (i == 19) {
            this.jDX = typedArray.getDimensionPixelSize(i, this.jDX);
        } else if (i == 20) {
            this.jDY = typedArray.getColor(i, this.jDY);
        } else if (i == 21) {
            this.jDZ = typedArray.getBoolean(i, this.jDZ);
        } else if (i == 22) {
            this.jEa = typedArray.getDimensionPixelSize(i, this.jEa);
        } else if (i == 23) {
            this.jEb = typedArray.getBoolean(i, this.jEb);
        } else if (i == 24) {
            this.jEd = typedArray.getBoolean(i, this.jEd);
        } else if (i == 25) {
            this.jEc = typedArray.getColor(i, this.jEc);
        } else if (i == 26) {
            this.jEe = typedArray.getBoolean(i, this.jEe);
        } else if (i == 27) {
            this.jEf = typedArray.getBoolean(i, this.jEf);
        } else if (i == 28) {
            this.jEg = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jEr = typedArray.getBoolean(i, this.jEr);
        }
    }

    private void cBQ() {
        if (this.jEg != null) {
            this.jEm = ((BitmapDrawable) this.jEg).getBitmap();
        }
        if (this.jEm == null) {
            this.jEm = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jEm = a.e(this.jEm, this.jDL);
        }
        this.jEn = a.adjustPhotoRotation(this.jEm, 90);
        this.jEn = a.adjustPhotoRotation(this.jEn, 90);
        this.jEn = a.adjustPhotoRotation(this.jEn, 90);
        if (this.jDO != null) {
            this.jEk = ((BitmapDrawable) this.jDO).getBitmap();
        }
        if (this.jEk == null) {
            this.jEk = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jEk = a.e(this.jEk, this.jDL);
        }
        this.jEl = a.adjustPhotoRotation(this.jEk, 90);
        this.jEo = (1.0f * this.jDH) / 2.0f;
        this.jDF.setTextSize(this.jDX);
        this.jDF.setColor(this.jDY);
        setIsBarcode(this.jDU);
    }

    public void cBR() {
        this.jDF.setColor(this.jDY);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jDC != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            cBS();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jDC.top, this.mPaint);
            canvas.drawRect(0.0f, this.jDC.top, this.jDC.left, this.jDC.bottom + 1, this.mPaint);
            canvas.drawRect(this.jDC.right + 1, this.jDC.top, width, this.jDC.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jDC.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jDQ > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jDQ);
            canvas.drawRect(this.jDC, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jDw, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDx, getMainFrameRight() - this.jDw.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDy, getMainFrameLeft(), getMainFrameBottom() - this.jDw.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jDz, getMainFrameRight() - this.jDw.getWidth(), getMainFrameBottom() - this.jDw.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jDC.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jDC.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jDC.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jDC.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jDQ / 2;
    }

    private void T(Canvas canvas) {
        if (this.jDU) {
            if (this.jEh != null) {
                RectF rectF = new RectF(this.jDC.left + this.jEo + 0.5f, this.jDC.top + this.jEo + this.jDM, this.jEj, (this.jDC.bottom - this.jEo) - this.jDM);
                Rect rect = new Rect((int) (this.jEh.getWidth() - rectF.width()), 0, this.jEh.getWidth(), this.jEh.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jEh, rect, rectF, this.mPaint);
            } else if (this.jDP != null) {
                canvas.drawBitmap(this.jDP, (Rect) null, new RectF(this.jDE, this.jDC.top + this.jEo + this.jDM, this.jDE + this.jDP.getWidth(), (this.jDC.bottom - this.jEo) - this.jDM), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jDL);
                canvas.drawRect(this.jDE, this.jDM + this.jDC.top + this.jEo, this.jDK + this.jDE, (this.jDC.bottom - this.jEo) - this.jDM, this.mPaint);
            }
        } else if (this.jEh != null) {
            RectF rectF2 = new RectF(this.jDC.left + this.jEo + this.jDM, this.jDC.top + this.jEo + 0.5f, (this.jDC.right - this.jEo) - this.jDM, this.jEi);
            Rect rect2 = new Rect(0, (int) (this.jEh.getHeight() - rectF2.height()), this.jEh.getWidth(), this.jEh.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jEs);
            canvas.drawBitmap(this.jEh, rect2, rectF2, this.mPaint);
        } else if (this.jDP != null) {
            canvas.drawBitmap(this.jDP, (Rect) null, new RectF(this.jDC.left + this.jEo + this.jDM, this.jDD, (this.jDC.right - this.jEo) - this.jDM, this.jDD + this.jDP.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jDL);
            canvas.drawRect(this.jDM + this.jDC.left + this.jEo, this.jDD, (this.jDC.right - this.jEo) - this.jDM, this.jDK + this.jDD, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.ilZ) && this.jEp != null) {
            if (this.jDZ) {
                if (this.jEd) {
                    this.mPaint.setColor(this.jEc);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jEb) {
                        Rect rect = new Rect();
                        this.jDF.getTextBounds(this.ilZ, 0, this.ilZ.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jEq;
                        canvas.drawRoundRect(new RectF(width, (this.jDC.bottom + this.jEa) - this.jEq, rect.width() + width + (this.jEq * 2), this.jDC.bottom + this.jEa + this.jEp.getHeight() + this.jEq), this.jEq, this.jEq, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jDC.left, (this.jDC.bottom + this.jEa) - this.jEq, this.jDC.right, this.jDC.bottom + this.jEa + this.jEp.getHeight() + this.jEq), this.jEq, this.jEq, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jEb) {
                    canvas.translate(0.0f, this.jDC.bottom + this.jEa);
                } else {
                    canvas.translate(this.jDC.left + this.jEq, this.jDC.bottom + this.jEa);
                }
                this.jEp.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jEd) {
                this.mPaint.setColor(this.jEc);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jEb) {
                    Rect rect2 = new Rect();
                    this.jDF.getTextBounds(this.ilZ, 0, this.ilZ.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jEq;
                    canvas.drawRoundRect(new RectF(width2, ((this.jDC.top - this.jEa) - this.jEp.getHeight()) - this.jEq, rect2.width() + width2 + (this.jEq * 2), (this.jDC.top - this.jEa) + this.jEq), this.jEq, this.jEq, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jDC.left, ((this.jDC.top - this.jEa) - this.jEp.getHeight()) - this.jEq, this.jDC.right, (this.jDC.top - this.jEa) + this.jEq), this.jEq, this.jEq, this.mPaint);
                }
            }
            canvas.save();
            if (this.jEb) {
                canvas.translate(0.0f, (this.jDC.top - this.jEa) - this.jEp.getHeight());
            } else {
                canvas.translate(this.jDC.left + this.jEq, (this.jDC.top - this.jEa) - this.jEp.getHeight());
            }
            this.jEp.draw(canvas);
            canvas.restore();
        }
    }

    private void cBS() {
        if (this.jDU) {
            if (this.jEh == null) {
                this.jDE += this.jDA;
                int i = this.jDK;
                if (this.jDP != null) {
                    i = this.jDP.getWidth();
                }
                if (this.jEe) {
                    if (i + this.jDE > this.jDC.right - this.jEo || this.jDE < this.jDC.left + this.jEo) {
                        this.jDA = -this.jDA;
                    }
                } else {
                    if (i + this.jDE > this.jDC.right - this.jEo) {
                        this.jDE = this.jDC.left + this.jEo + 0.5f;
                    }
                }
            } else {
                this.jEj += this.jDA;
                if (this.jEj > this.jDC.right - this.jEo) {
                    this.jEj = this.jDC.left + this.jEo + 0.5f;
                }
            }
        } else if (this.jEh == null) {
            this.jDD += this.jDA;
            int i2 = this.jDK;
            if (this.jDP != null) {
                i2 = this.jDP.getHeight();
            }
            if (this.jEe) {
                if (i2 + this.jDD > this.jDC.bottom - this.jEo || this.jDD < this.jDC.top + this.jEo) {
                    this.jDA = -this.jDA;
                }
            } else {
                if (i2 + this.jDD > this.jDC.bottom - this.jEo) {
                    this.jDD = this.jDC.top + this.jEo + 0.5f;
                }
            }
        } else {
            this.jEi += this.jDA;
            if (this.jEi > this.jDC.bottom - this.jEo) {
                this.jEi = this.jDC.top + this.jEo + 0.5f;
            }
        }
        postInvalidateDelayed(this.jDB, this.jDC.left, this.jDC.top, this.jDC.right, this.jDC.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cBT();
    }

    private void cBT() {
        int i;
        if (this.jDU) {
            i = this.mTopOffset + this.jDT;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aZP) / 2;
        this.jDC = new Rect(width, i, this.aZP + width, this.jDI + i);
        if (this.jDU) {
            float f = this.jDC.left + this.jEo + 0.5f;
            this.jDE = f;
            this.jEj = f;
            return;
        }
        float f2 = this.jDC.top + this.jEo + 0.5f;
        this.jDD = f2;
        this.jEi = f2;
    }

    public Rect AM(int i) {
        if (this.jEr) {
            Rect rect = new Rect(this.jDC);
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
        this.jDU = z;
        if (this.jEg != null || this.jEf) {
            if (this.jDU) {
                this.jEh = this.jEn;
            } else {
                this.jEh = this.jEm;
            }
        } else if (this.jDO != null || this.jDN) {
            if (this.jDU) {
                this.jDP = this.jEl;
            } else {
                this.jDP = this.jEk;
            }
        }
        if (this.jDU) {
            this.ilZ = this.jDW;
            this.jDI = this.jDJ;
            this.jDB = (int) (((this.jDR * 1.0f) * this.jDA) / this.aZP);
        } else {
            this.ilZ = this.jDV;
            this.jDI = this.aZP;
            this.jDB = (int) (((this.jDR * 1.0f) * this.jDA) / this.jDI);
        }
        if (!TextUtils.isEmpty(this.ilZ)) {
            if (this.jEb) {
                this.jEp = new StaticLayout(this.ilZ, this.jDF, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jEp = new StaticLayout(this.ilZ, this.jDF, this.aZP - (this.jEq * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jDS) {
            int i = a.fm(getContext()).y;
            if (this.jDT == 0) {
                this.mTopOffset = (i - this.jDI) / 2;
            } else if (this.jDU) {
                this.mTopOffset = ((i - this.jDI) / 2) + (this.jDT / 2);
            } else {
                this.mTopOffset = (i - this.jDI) / 2;
            }
        }
        cBT();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jDU;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jDG;
    }

    public void setCornerLength(int i) {
        this.jDG = i;
    }

    public int getCornerSize() {
        return this.jDH;
    }

    public void setCornerSize(int i) {
        this.jDH = i;
    }

    public int getRectWidth() {
        return this.aZP;
    }

    public void setRectWidth(int i) {
        this.aZP = i;
    }

    public int getRectHeight() {
        return this.jDI;
    }

    public void setRectHeight(int i) {
        this.jDI = i;
    }

    public int getBarcodeRectHeight() {
        return this.jDJ;
    }

    public void setBarcodeRectHeight(int i) {
        this.jDJ = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jDK;
    }

    public void setScanLineSize(int i) {
        this.jDK = i;
    }

    public int getScanLineColor() {
        return this.jDL;
    }

    public void setScanLineColor(int i) {
        this.jDL = i;
    }

    public int getScanLineMargin() {
        return this.jDM;
    }

    public void setScanLineMargin(int i) {
        this.jDM = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jDN = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jDO;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jDO = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jDP;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jDP = bitmap;
    }

    public int getBorderSize() {
        return this.jDQ;
    }

    public void setBorderSize(int i) {
        this.jDQ = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jDR;
    }

    public void setAnimTime(int i) {
        this.jDR = i;
    }

    public void setCenterVertical(boolean z) {
        this.jDS = z;
    }

    public int getToolbarHeight() {
        return this.jDT;
    }

    public void setToolbarHeight(int i) {
        this.jDT = i;
    }

    public String getQRCodeTipText() {
        return this.jDV;
    }

    public void setQRCodeTipText(String str) {
        this.jDV = str;
    }

    public String getBarCodeTipText() {
        return this.jDW;
    }

    public void setBarCodeTipText(String str) {
        this.jDW = str;
    }

    public String getTipText() {
        return this.ilZ;
    }

    public void setTipText(String str) {
        this.ilZ = str;
    }

    public int getTipTextColor() {
        return this.jDY;
    }

    public void setTipTextColor(int i) {
        this.jDY = i;
    }

    public int getTipTextSize() {
        return this.jDX;
    }

    public void setTipTextSize(int i) {
        this.jDX = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jDZ = z;
    }

    public int getTipTextMargin() {
        return this.jEa;
    }

    public void setTipTextMargin(int i) {
        this.jEa = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jEb = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jEd = z;
    }

    public int getTipBackgroundColor() {
        return this.jEc;
    }

    public void setTipBackgroundColor(int i) {
        this.jEc = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jEe = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jEf = z;
    }

    public float getHalfCornerSize() {
        return this.jEo;
    }

    public void setHalfCornerSize(float f) {
        this.jEo = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jEp;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jEp = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jEq;
    }

    public void setTipBackgroundRadius(int i) {
        this.jEq = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jEr = z;
    }
}
