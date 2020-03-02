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
    private int aZO;
    private String ilN;
    private int jDA;
    private boolean jDB;
    private Drawable jDC;
    private Bitmap jDD;
    private int jDE;
    private int jDF;
    private boolean jDG;
    private int jDH;
    private boolean jDI;
    private String jDJ;
    private String jDK;
    private int jDL;
    private int jDM;
    private boolean jDN;
    private int jDO;
    private boolean jDP;
    private int jDQ;
    private boolean jDR;
    private boolean jDS;
    private boolean jDT;
    private Drawable jDU;
    private Bitmap jDV;
    private float jDW;
    private float jDX;
    private Bitmap jDY;
    private Bitmap jDZ;
    private Bitmap jDk;
    private Bitmap jDl;
    private Bitmap jDm;
    private Bitmap jDn;
    private int jDo;
    private int jDp;
    private Rect jDq;
    private float jDr;
    private float jDs;
    private TextPaint jDt;
    private int jDu;
    private int jDv;
    private int jDw;
    private int jDx;
    private int jDy;
    private int jDz;
    private Bitmap jEa;
    private Bitmap jEb;
    private float jEc;
    private StaticLayout jEd;
    private int jEe;
    private boolean jEf;
    private ColorMatrixColorFilter jEg;
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
        this.jDu = a.dp2px(context, 20.0f);
        this.jDv = a.dp2px(context, 3.0f);
        this.jDy = a.dp2px(context, 1.0f);
        this.jDz = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aZO = a.dp2px(context, 200.0f);
        this.jDx = a.dp2px(context, 140.0f);
        this.jDA = 0;
        this.jDB = false;
        this.jDC = null;
        this.jDD = null;
        this.jDE = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jDF = 1000;
        this.jDG = false;
        this.jDH = 0;
        this.jDI = false;
        this.jDo = a.dp2px(context, 2.0f);
        this.ilN = null;
        this.jDL = a.h(context, 14.0f);
        this.jDM = -1;
        this.jDN = false;
        this.jDO = a.dp2px(context, 20.0f);
        this.jDP = false;
        this.jDQ = Color.parseColor("#22000000");
        this.jDR = false;
        this.jDS = false;
        this.jDT = false;
        this.jDt = new TextPaint();
        this.jDt.setAntiAlias(true);
        this.jEe = a.dp2px(context, 4.0f);
        this.jEf = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jEg = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cBP();
        cBO();
    }

    private void cBO() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jDu;
        options.outHeight = this.jDu;
        this.jDk = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jDl = Bitmap.createBitmap(this.jDk, 0, 0, this.jDk.getWidth(), this.jDk.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jDm = Bitmap.createBitmap(this.jDk, 0, 0, this.jDk.getWidth(), this.jDk.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jDn = Bitmap.createBitmap(this.jDk, 0, 0, this.jDk.getWidth(), this.jDk.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jDv = typedArray.getDimensionPixelSize(i, this.jDv);
        } else if (i == 2) {
            this.jDu = typedArray.getDimensionPixelSize(i, this.jDu);
        } else if (i == 6) {
            this.jDy = typedArray.getDimensionPixelSize(i, this.jDy);
        } else if (i == 3) {
            this.aZO = typedArray.getDimensionPixelSize(i, this.aZO);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jDz = typedArray.getColor(i, this.jDz);
        } else if (i == 8) {
            this.jDA = typedArray.getDimensionPixelSize(i, this.jDA);
        } else if (i == 9) {
            this.jDB = typedArray.getBoolean(i, this.jDB);
        } else if (i == 10) {
            this.jDC = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jDE = typedArray.getDimensionPixelSize(i, this.jDE);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jDF = typedArray.getInteger(i, this.jDF);
        } else if (i == 14) {
            this.jDG = typedArray.getBoolean(i, this.jDG);
        } else if (i == 15) {
            this.jDH = typedArray.getDimensionPixelSize(i, this.jDH);
        } else if (i == 4) {
            this.jDx = typedArray.getDimensionPixelSize(i, this.jDx);
        } else if (i == 16) {
            this.jDI = typedArray.getBoolean(i, this.jDI);
        } else if (i == 18) {
            this.jDK = typedArray.getString(i);
        } else if (i == 17) {
            this.jDJ = typedArray.getString(i);
        } else if (i == 19) {
            this.jDL = typedArray.getDimensionPixelSize(i, this.jDL);
        } else if (i == 20) {
            this.jDM = typedArray.getColor(i, this.jDM);
        } else if (i == 21) {
            this.jDN = typedArray.getBoolean(i, this.jDN);
        } else if (i == 22) {
            this.jDO = typedArray.getDimensionPixelSize(i, this.jDO);
        } else if (i == 23) {
            this.jDP = typedArray.getBoolean(i, this.jDP);
        } else if (i == 24) {
            this.jDR = typedArray.getBoolean(i, this.jDR);
        } else if (i == 25) {
            this.jDQ = typedArray.getColor(i, this.jDQ);
        } else if (i == 26) {
            this.jDS = typedArray.getBoolean(i, this.jDS);
        } else if (i == 27) {
            this.jDT = typedArray.getBoolean(i, this.jDT);
        } else if (i == 28) {
            this.jDU = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jEf = typedArray.getBoolean(i, this.jEf);
        }
    }

    private void cBP() {
        if (this.jDU != null) {
            this.jEa = ((BitmapDrawable) this.jDU).getBitmap();
        }
        if (this.jEa == null) {
            this.jEa = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jEa = a.e(this.jEa, this.jDz);
        }
        this.jEb = a.adjustPhotoRotation(this.jEa, 90);
        this.jEb = a.adjustPhotoRotation(this.jEb, 90);
        this.jEb = a.adjustPhotoRotation(this.jEb, 90);
        if (this.jDC != null) {
            this.jDY = ((BitmapDrawable) this.jDC).getBitmap();
        }
        if (this.jDY == null) {
            this.jDY = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDY = a.e(this.jDY, this.jDz);
        }
        this.jDZ = a.adjustPhotoRotation(this.jDY, 90);
        this.jEc = (1.0f * this.jDv) / 2.0f;
        this.jDt.setTextSize(this.jDL);
        this.jDt.setColor(this.jDM);
        setIsBarcode(this.jDI);
    }

    public void cBQ() {
        this.jDt.setColor(this.jDM);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jDq != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            cBR();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jDq.top, this.mPaint);
            canvas.drawRect(0.0f, this.jDq.top, this.jDq.left, this.jDq.bottom + 1, this.mPaint);
            canvas.drawRect(this.jDq.right + 1, this.jDq.top, width, this.jDq.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jDq.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jDE > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jDE);
            canvas.drawRect(this.jDq, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jDk, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDl, getMainFrameRight() - this.jDk.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDm, getMainFrameLeft(), getMainFrameBottom() - this.jDk.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jDn, getMainFrameRight() - this.jDk.getWidth(), getMainFrameBottom() - this.jDk.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jDq.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jDq.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jDq.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jDq.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jDE / 2;
    }

    private void T(Canvas canvas) {
        if (this.jDI) {
            if (this.jDV != null) {
                RectF rectF = new RectF(this.jDq.left + this.jEc + 0.5f, this.jDq.top + this.jEc + this.jDA, this.jDX, (this.jDq.bottom - this.jEc) - this.jDA);
                Rect rect = new Rect((int) (this.jDV.getWidth() - rectF.width()), 0, this.jDV.getWidth(), this.jDV.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jDV, rect, rectF, this.mPaint);
            } else if (this.jDD != null) {
                canvas.drawBitmap(this.jDD, (Rect) null, new RectF(this.jDs, this.jDq.top + this.jEc + this.jDA, this.jDs + this.jDD.getWidth(), (this.jDq.bottom - this.jEc) - this.jDA), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jDz);
                canvas.drawRect(this.jDs, this.jDA + this.jDq.top + this.jEc, this.jDy + this.jDs, (this.jDq.bottom - this.jEc) - this.jDA, this.mPaint);
            }
        } else if (this.jDV != null) {
            RectF rectF2 = new RectF(this.jDq.left + this.jEc + this.jDA, this.jDq.top + this.jEc + 0.5f, (this.jDq.right - this.jEc) - this.jDA, this.jDW);
            Rect rect2 = new Rect(0, (int) (this.jDV.getHeight() - rectF2.height()), this.jDV.getWidth(), this.jDV.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jEg);
            canvas.drawBitmap(this.jDV, rect2, rectF2, this.mPaint);
        } else if (this.jDD != null) {
            canvas.drawBitmap(this.jDD, (Rect) null, new RectF(this.jDq.left + this.jEc + this.jDA, this.jDr, (this.jDq.right - this.jEc) - this.jDA, this.jDr + this.jDD.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jDz);
            canvas.drawRect(this.jDA + this.jDq.left + this.jEc, this.jDr, (this.jDq.right - this.jEc) - this.jDA, this.jDy + this.jDr, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.ilN) && this.jEd != null) {
            if (this.jDN) {
                if (this.jDR) {
                    this.mPaint.setColor(this.jDQ);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jDP) {
                        Rect rect = new Rect();
                        this.jDt.getTextBounds(this.ilN, 0, this.ilN.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jEe;
                        canvas.drawRoundRect(new RectF(width, (this.jDq.bottom + this.jDO) - this.jEe, rect.width() + width + (this.jEe * 2), this.jDq.bottom + this.jDO + this.jEd.getHeight() + this.jEe), this.jEe, this.jEe, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jDq.left, (this.jDq.bottom + this.jDO) - this.jEe, this.jDq.right, this.jDq.bottom + this.jDO + this.jEd.getHeight() + this.jEe), this.jEe, this.jEe, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jDP) {
                    canvas.translate(0.0f, this.jDq.bottom + this.jDO);
                } else {
                    canvas.translate(this.jDq.left + this.jEe, this.jDq.bottom + this.jDO);
                }
                this.jEd.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jDR) {
                this.mPaint.setColor(this.jDQ);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jDP) {
                    Rect rect2 = new Rect();
                    this.jDt.getTextBounds(this.ilN, 0, this.ilN.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jEe;
                    canvas.drawRoundRect(new RectF(width2, ((this.jDq.top - this.jDO) - this.jEd.getHeight()) - this.jEe, rect2.width() + width2 + (this.jEe * 2), (this.jDq.top - this.jDO) + this.jEe), this.jEe, this.jEe, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jDq.left, ((this.jDq.top - this.jDO) - this.jEd.getHeight()) - this.jEe, this.jDq.right, (this.jDq.top - this.jDO) + this.jEe), this.jEe, this.jEe, this.mPaint);
                }
            }
            canvas.save();
            if (this.jDP) {
                canvas.translate(0.0f, (this.jDq.top - this.jDO) - this.jEd.getHeight());
            } else {
                canvas.translate(this.jDq.left + this.jEe, (this.jDq.top - this.jDO) - this.jEd.getHeight());
            }
            this.jEd.draw(canvas);
            canvas.restore();
        }
    }

    private void cBR() {
        if (this.jDI) {
            if (this.jDV == null) {
                this.jDs += this.jDo;
                int i = this.jDy;
                if (this.jDD != null) {
                    i = this.jDD.getWidth();
                }
                if (this.jDS) {
                    if (i + this.jDs > this.jDq.right - this.jEc || this.jDs < this.jDq.left + this.jEc) {
                        this.jDo = -this.jDo;
                    }
                } else {
                    if (i + this.jDs > this.jDq.right - this.jEc) {
                        this.jDs = this.jDq.left + this.jEc + 0.5f;
                    }
                }
            } else {
                this.jDX += this.jDo;
                if (this.jDX > this.jDq.right - this.jEc) {
                    this.jDX = this.jDq.left + this.jEc + 0.5f;
                }
            }
        } else if (this.jDV == null) {
            this.jDr += this.jDo;
            int i2 = this.jDy;
            if (this.jDD != null) {
                i2 = this.jDD.getHeight();
            }
            if (this.jDS) {
                if (i2 + this.jDr > this.jDq.bottom - this.jEc || this.jDr < this.jDq.top + this.jEc) {
                    this.jDo = -this.jDo;
                }
            } else {
                if (i2 + this.jDr > this.jDq.bottom - this.jEc) {
                    this.jDr = this.jDq.top + this.jEc + 0.5f;
                }
            }
        } else {
            this.jDW += this.jDo;
            if (this.jDW > this.jDq.bottom - this.jEc) {
                this.jDW = this.jDq.top + this.jEc + 0.5f;
            }
        }
        postInvalidateDelayed(this.jDp, this.jDq.left, this.jDq.top, this.jDq.right, this.jDq.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cBS();
    }

    private void cBS() {
        int i;
        if (this.jDI) {
            i = this.mTopOffset + this.jDH;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aZO) / 2;
        this.jDq = new Rect(width, i, this.aZO + width, this.jDw + i);
        if (this.jDI) {
            float f = this.jDq.left + this.jEc + 0.5f;
            this.jDs = f;
            this.jDX = f;
            return;
        }
        float f2 = this.jDq.top + this.jEc + 0.5f;
        this.jDr = f2;
        this.jDW = f2;
    }

    public Rect AM(int i) {
        if (this.jEf) {
            Rect rect = new Rect(this.jDq);
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
        this.jDI = z;
        if (this.jDU != null || this.jDT) {
            if (this.jDI) {
                this.jDV = this.jEb;
            } else {
                this.jDV = this.jEa;
            }
        } else if (this.jDC != null || this.jDB) {
            if (this.jDI) {
                this.jDD = this.jDZ;
            } else {
                this.jDD = this.jDY;
            }
        }
        if (this.jDI) {
            this.ilN = this.jDK;
            this.jDw = this.jDx;
            this.jDp = (int) (((this.jDF * 1.0f) * this.jDo) / this.aZO);
        } else {
            this.ilN = this.jDJ;
            this.jDw = this.aZO;
            this.jDp = (int) (((this.jDF * 1.0f) * this.jDo) / this.jDw);
        }
        if (!TextUtils.isEmpty(this.ilN)) {
            if (this.jDP) {
                this.jEd = new StaticLayout(this.ilN, this.jDt, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jEd = new StaticLayout(this.ilN, this.jDt, this.aZO - (this.jEe * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jDG) {
            int i = a.fm(getContext()).y;
            if (this.jDH == 0) {
                this.mTopOffset = (i - this.jDw) / 2;
            } else if (this.jDI) {
                this.mTopOffset = ((i - this.jDw) / 2) + (this.jDH / 2);
            } else {
                this.mTopOffset = (i - this.jDw) / 2;
            }
        }
        cBS();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jDI;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jDu;
    }

    public void setCornerLength(int i) {
        this.jDu = i;
    }

    public int getCornerSize() {
        return this.jDv;
    }

    public void setCornerSize(int i) {
        this.jDv = i;
    }

    public int getRectWidth() {
        return this.aZO;
    }

    public void setRectWidth(int i) {
        this.aZO = i;
    }

    public int getRectHeight() {
        return this.jDw;
    }

    public void setRectHeight(int i) {
        this.jDw = i;
    }

    public int getBarcodeRectHeight() {
        return this.jDx;
    }

    public void setBarcodeRectHeight(int i) {
        this.jDx = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jDy;
    }

    public void setScanLineSize(int i) {
        this.jDy = i;
    }

    public int getScanLineColor() {
        return this.jDz;
    }

    public void setScanLineColor(int i) {
        this.jDz = i;
    }

    public int getScanLineMargin() {
        return this.jDA;
    }

    public void setScanLineMargin(int i) {
        this.jDA = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jDB = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jDC;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jDC = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jDD;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jDD = bitmap;
    }

    public int getBorderSize() {
        return this.jDE;
    }

    public void setBorderSize(int i) {
        this.jDE = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jDF;
    }

    public void setAnimTime(int i) {
        this.jDF = i;
    }

    public void setCenterVertical(boolean z) {
        this.jDG = z;
    }

    public int getToolbarHeight() {
        return this.jDH;
    }

    public void setToolbarHeight(int i) {
        this.jDH = i;
    }

    public String getQRCodeTipText() {
        return this.jDJ;
    }

    public void setQRCodeTipText(String str) {
        this.jDJ = str;
    }

    public String getBarCodeTipText() {
        return this.jDK;
    }

    public void setBarCodeTipText(String str) {
        this.jDK = str;
    }

    public String getTipText() {
        return this.ilN;
    }

    public void setTipText(String str) {
        this.ilN = str;
    }

    public int getTipTextColor() {
        return this.jDM;
    }

    public void setTipTextColor(int i) {
        this.jDM = i;
    }

    public int getTipTextSize() {
        return this.jDL;
    }

    public void setTipTextSize(int i) {
        this.jDL = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jDN = z;
    }

    public int getTipTextMargin() {
        return this.jDO;
    }

    public void setTipTextMargin(int i) {
        this.jDO = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jDP = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jDR = z;
    }

    public int getTipBackgroundColor() {
        return this.jDQ;
    }

    public void setTipBackgroundColor(int i) {
        this.jDQ = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jDS = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jDT = z;
    }

    public float getHalfCornerSize() {
        return this.jEc;
    }

    public void setHalfCornerSize(float f) {
        this.jEc = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jEd;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jEd = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jEe;
    }

    public void setTipBackgroundRadius(int i) {
        this.jEe = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jEf = z;
    }
}
