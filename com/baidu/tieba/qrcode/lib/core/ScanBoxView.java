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
    private int aZN;
    private String ilL;
    private Drawable jDA;
    private Bitmap jDB;
    private int jDC;
    private int jDD;
    private boolean jDE;
    private int jDF;
    private boolean jDG;
    private String jDH;
    private String jDI;
    private int jDJ;
    private int jDK;
    private boolean jDL;
    private int jDM;
    private boolean jDN;
    private int jDO;
    private boolean jDP;
    private boolean jDQ;
    private boolean jDR;
    private Drawable jDS;
    private Bitmap jDT;
    private float jDU;
    private float jDV;
    private Bitmap jDW;
    private Bitmap jDX;
    private Bitmap jDY;
    private Bitmap jDZ;
    private Bitmap jDi;
    private Bitmap jDj;
    private Bitmap jDk;
    private Bitmap jDl;
    private int jDm;
    private int jDn;
    private Rect jDo;
    private float jDp;
    private float jDq;
    private TextPaint jDr;
    private int jDs;
    private int jDt;
    private int jDu;
    private int jDv;
    private int jDw;
    private int jDx;
    private int jDy;
    private boolean jDz;
    private float jEa;
    private StaticLayout jEb;
    private int jEc;
    private boolean jEd;
    private ColorMatrixColorFilter jEe;
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
        this.jDs = a.dp2px(context, 20.0f);
        this.jDt = a.dp2px(context, 3.0f);
        this.jDw = a.dp2px(context, 1.0f);
        this.jDx = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aZN = a.dp2px(context, 200.0f);
        this.jDv = a.dp2px(context, 140.0f);
        this.jDy = 0;
        this.jDz = false;
        this.jDA = null;
        this.jDB = null;
        this.jDC = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jDD = 1000;
        this.jDE = false;
        this.jDF = 0;
        this.jDG = false;
        this.jDm = a.dp2px(context, 2.0f);
        this.ilL = null;
        this.jDJ = a.h(context, 14.0f);
        this.jDK = -1;
        this.jDL = false;
        this.jDM = a.dp2px(context, 20.0f);
        this.jDN = false;
        this.jDO = Color.parseColor("#22000000");
        this.jDP = false;
        this.jDQ = false;
        this.jDR = false;
        this.jDr = new TextPaint();
        this.jDr.setAntiAlias(true);
        this.jEc = a.dp2px(context, 4.0f);
        this.jEd = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jEe = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cBN();
        cBM();
    }

    private void cBM() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jDs;
        options.outHeight = this.jDs;
        this.jDi = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jDj = Bitmap.createBitmap(this.jDi, 0, 0, this.jDi.getWidth(), this.jDi.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jDk = Bitmap.createBitmap(this.jDi, 0, 0, this.jDi.getWidth(), this.jDi.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jDl = Bitmap.createBitmap(this.jDi, 0, 0, this.jDi.getWidth(), this.jDi.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jDt = typedArray.getDimensionPixelSize(i, this.jDt);
        } else if (i == 2) {
            this.jDs = typedArray.getDimensionPixelSize(i, this.jDs);
        } else if (i == 6) {
            this.jDw = typedArray.getDimensionPixelSize(i, this.jDw);
        } else if (i == 3) {
            this.aZN = typedArray.getDimensionPixelSize(i, this.aZN);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jDx = typedArray.getColor(i, this.jDx);
        } else if (i == 8) {
            this.jDy = typedArray.getDimensionPixelSize(i, this.jDy);
        } else if (i == 9) {
            this.jDz = typedArray.getBoolean(i, this.jDz);
        } else if (i == 10) {
            this.jDA = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jDC = typedArray.getDimensionPixelSize(i, this.jDC);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jDD = typedArray.getInteger(i, this.jDD);
        } else if (i == 14) {
            this.jDE = typedArray.getBoolean(i, this.jDE);
        } else if (i == 15) {
            this.jDF = typedArray.getDimensionPixelSize(i, this.jDF);
        } else if (i == 4) {
            this.jDv = typedArray.getDimensionPixelSize(i, this.jDv);
        } else if (i == 16) {
            this.jDG = typedArray.getBoolean(i, this.jDG);
        } else if (i == 18) {
            this.jDI = typedArray.getString(i);
        } else if (i == 17) {
            this.jDH = typedArray.getString(i);
        } else if (i == 19) {
            this.jDJ = typedArray.getDimensionPixelSize(i, this.jDJ);
        } else if (i == 20) {
            this.jDK = typedArray.getColor(i, this.jDK);
        } else if (i == 21) {
            this.jDL = typedArray.getBoolean(i, this.jDL);
        } else if (i == 22) {
            this.jDM = typedArray.getDimensionPixelSize(i, this.jDM);
        } else if (i == 23) {
            this.jDN = typedArray.getBoolean(i, this.jDN);
        } else if (i == 24) {
            this.jDP = typedArray.getBoolean(i, this.jDP);
        } else if (i == 25) {
            this.jDO = typedArray.getColor(i, this.jDO);
        } else if (i == 26) {
            this.jDQ = typedArray.getBoolean(i, this.jDQ);
        } else if (i == 27) {
            this.jDR = typedArray.getBoolean(i, this.jDR);
        } else if (i == 28) {
            this.jDS = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jEd = typedArray.getBoolean(i, this.jEd);
        }
    }

    private void cBN() {
        if (this.jDS != null) {
            this.jDY = ((BitmapDrawable) this.jDS).getBitmap();
        }
        if (this.jDY == null) {
            this.jDY = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDY = a.e(this.jDY, this.jDx);
        }
        this.jDZ = a.adjustPhotoRotation(this.jDY, 90);
        this.jDZ = a.adjustPhotoRotation(this.jDZ, 90);
        this.jDZ = a.adjustPhotoRotation(this.jDZ, 90);
        if (this.jDA != null) {
            this.jDW = ((BitmapDrawable) this.jDA).getBitmap();
        }
        if (this.jDW == null) {
            this.jDW = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jDW = a.e(this.jDW, this.jDx);
        }
        this.jDX = a.adjustPhotoRotation(this.jDW, 90);
        this.jEa = (1.0f * this.jDt) / 2.0f;
        this.jDr.setTextSize(this.jDJ);
        this.jDr.setColor(this.jDK);
        setIsBarcode(this.jDG);
    }

    public void cBO() {
        this.jDr.setColor(this.jDK);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jDo != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            cBP();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jDo.top, this.mPaint);
            canvas.drawRect(0.0f, this.jDo.top, this.jDo.left, this.jDo.bottom + 1, this.mPaint);
            canvas.drawRect(this.jDo.right + 1, this.jDo.top, width, this.jDo.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jDo.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jDC > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jDC);
            canvas.drawRect(this.jDo, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jDi, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDj, getMainFrameRight() - this.jDi.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jDk, getMainFrameLeft(), getMainFrameBottom() - this.jDi.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jDl, getMainFrameRight() - this.jDi.getWidth(), getMainFrameBottom() - this.jDi.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jDo.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jDo.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jDo.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jDo.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jDC / 2;
    }

    private void T(Canvas canvas) {
        if (this.jDG) {
            if (this.jDT != null) {
                RectF rectF = new RectF(this.jDo.left + this.jEa + 0.5f, this.jDo.top + this.jEa + this.jDy, this.jDV, (this.jDo.bottom - this.jEa) - this.jDy);
                Rect rect = new Rect((int) (this.jDT.getWidth() - rectF.width()), 0, this.jDT.getWidth(), this.jDT.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jDT, rect, rectF, this.mPaint);
            } else if (this.jDB != null) {
                canvas.drawBitmap(this.jDB, (Rect) null, new RectF(this.jDq, this.jDo.top + this.jEa + this.jDy, this.jDq + this.jDB.getWidth(), (this.jDo.bottom - this.jEa) - this.jDy), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jDx);
                canvas.drawRect(this.jDq, this.jDy + this.jDo.top + this.jEa, this.jDw + this.jDq, (this.jDo.bottom - this.jEa) - this.jDy, this.mPaint);
            }
        } else if (this.jDT != null) {
            RectF rectF2 = new RectF(this.jDo.left + this.jEa + this.jDy, this.jDo.top + this.jEa + 0.5f, (this.jDo.right - this.jEa) - this.jDy, this.jDU);
            Rect rect2 = new Rect(0, (int) (this.jDT.getHeight() - rectF2.height()), this.jDT.getWidth(), this.jDT.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jEe);
            canvas.drawBitmap(this.jDT, rect2, rectF2, this.mPaint);
        } else if (this.jDB != null) {
            canvas.drawBitmap(this.jDB, (Rect) null, new RectF(this.jDo.left + this.jEa + this.jDy, this.jDp, (this.jDo.right - this.jEa) - this.jDy, this.jDp + this.jDB.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jDx);
            canvas.drawRect(this.jDy + this.jDo.left + this.jEa, this.jDp, (this.jDo.right - this.jEa) - this.jDy, this.jDw + this.jDp, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.ilL) && this.jEb != null) {
            if (this.jDL) {
                if (this.jDP) {
                    this.mPaint.setColor(this.jDO);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jDN) {
                        Rect rect = new Rect();
                        this.jDr.getTextBounds(this.ilL, 0, this.ilL.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jEc;
                        canvas.drawRoundRect(new RectF(width, (this.jDo.bottom + this.jDM) - this.jEc, rect.width() + width + (this.jEc * 2), this.jDo.bottom + this.jDM + this.jEb.getHeight() + this.jEc), this.jEc, this.jEc, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jDo.left, (this.jDo.bottom + this.jDM) - this.jEc, this.jDo.right, this.jDo.bottom + this.jDM + this.jEb.getHeight() + this.jEc), this.jEc, this.jEc, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jDN) {
                    canvas.translate(0.0f, this.jDo.bottom + this.jDM);
                } else {
                    canvas.translate(this.jDo.left + this.jEc, this.jDo.bottom + this.jDM);
                }
                this.jEb.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jDP) {
                this.mPaint.setColor(this.jDO);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jDN) {
                    Rect rect2 = new Rect();
                    this.jDr.getTextBounds(this.ilL, 0, this.ilL.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jEc;
                    canvas.drawRoundRect(new RectF(width2, ((this.jDo.top - this.jDM) - this.jEb.getHeight()) - this.jEc, rect2.width() + width2 + (this.jEc * 2), (this.jDo.top - this.jDM) + this.jEc), this.jEc, this.jEc, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jDo.left, ((this.jDo.top - this.jDM) - this.jEb.getHeight()) - this.jEc, this.jDo.right, (this.jDo.top - this.jDM) + this.jEc), this.jEc, this.jEc, this.mPaint);
                }
            }
            canvas.save();
            if (this.jDN) {
                canvas.translate(0.0f, (this.jDo.top - this.jDM) - this.jEb.getHeight());
            } else {
                canvas.translate(this.jDo.left + this.jEc, (this.jDo.top - this.jDM) - this.jEb.getHeight());
            }
            this.jEb.draw(canvas);
            canvas.restore();
        }
    }

    private void cBP() {
        if (this.jDG) {
            if (this.jDT == null) {
                this.jDq += this.jDm;
                int i = this.jDw;
                if (this.jDB != null) {
                    i = this.jDB.getWidth();
                }
                if (this.jDQ) {
                    if (i + this.jDq > this.jDo.right - this.jEa || this.jDq < this.jDo.left + this.jEa) {
                        this.jDm = -this.jDm;
                    }
                } else {
                    if (i + this.jDq > this.jDo.right - this.jEa) {
                        this.jDq = this.jDo.left + this.jEa + 0.5f;
                    }
                }
            } else {
                this.jDV += this.jDm;
                if (this.jDV > this.jDo.right - this.jEa) {
                    this.jDV = this.jDo.left + this.jEa + 0.5f;
                }
            }
        } else if (this.jDT == null) {
            this.jDp += this.jDm;
            int i2 = this.jDw;
            if (this.jDB != null) {
                i2 = this.jDB.getHeight();
            }
            if (this.jDQ) {
                if (i2 + this.jDp > this.jDo.bottom - this.jEa || this.jDp < this.jDo.top + this.jEa) {
                    this.jDm = -this.jDm;
                }
            } else {
                if (i2 + this.jDp > this.jDo.bottom - this.jEa) {
                    this.jDp = this.jDo.top + this.jEa + 0.5f;
                }
            }
        } else {
            this.jDU += this.jDm;
            if (this.jDU > this.jDo.bottom - this.jEa) {
                this.jDU = this.jDo.top + this.jEa + 0.5f;
            }
        }
        postInvalidateDelayed(this.jDn, this.jDo.left, this.jDo.top, this.jDo.right, this.jDo.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cBQ();
    }

    private void cBQ() {
        int i;
        if (this.jDG) {
            i = this.mTopOffset + this.jDF;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aZN) / 2;
        this.jDo = new Rect(width, i, this.aZN + width, this.jDu + i);
        if (this.jDG) {
            float f = this.jDo.left + this.jEa + 0.5f;
            this.jDq = f;
            this.jDV = f;
            return;
        }
        float f2 = this.jDo.top + this.jEa + 0.5f;
        this.jDp = f2;
        this.jDU = f2;
    }

    public Rect AM(int i) {
        if (this.jEd) {
            Rect rect = new Rect(this.jDo);
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
        this.jDG = z;
        if (this.jDS != null || this.jDR) {
            if (this.jDG) {
                this.jDT = this.jDZ;
            } else {
                this.jDT = this.jDY;
            }
        } else if (this.jDA != null || this.jDz) {
            if (this.jDG) {
                this.jDB = this.jDX;
            } else {
                this.jDB = this.jDW;
            }
        }
        if (this.jDG) {
            this.ilL = this.jDI;
            this.jDu = this.jDv;
            this.jDn = (int) (((this.jDD * 1.0f) * this.jDm) / this.aZN);
        } else {
            this.ilL = this.jDH;
            this.jDu = this.aZN;
            this.jDn = (int) (((this.jDD * 1.0f) * this.jDm) / this.jDu);
        }
        if (!TextUtils.isEmpty(this.ilL)) {
            if (this.jDN) {
                this.jEb = new StaticLayout(this.ilL, this.jDr, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jEb = new StaticLayout(this.ilL, this.jDr, this.aZN - (this.jEc * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jDE) {
            int i = a.fm(getContext()).y;
            if (this.jDF == 0) {
                this.mTopOffset = (i - this.jDu) / 2;
            } else if (this.jDG) {
                this.mTopOffset = ((i - this.jDu) / 2) + (this.jDF / 2);
            } else {
                this.mTopOffset = (i - this.jDu) / 2;
            }
        }
        cBQ();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jDG;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jDs;
    }

    public void setCornerLength(int i) {
        this.jDs = i;
    }

    public int getCornerSize() {
        return this.jDt;
    }

    public void setCornerSize(int i) {
        this.jDt = i;
    }

    public int getRectWidth() {
        return this.aZN;
    }

    public void setRectWidth(int i) {
        this.aZN = i;
    }

    public int getRectHeight() {
        return this.jDu;
    }

    public void setRectHeight(int i) {
        this.jDu = i;
    }

    public int getBarcodeRectHeight() {
        return this.jDv;
    }

    public void setBarcodeRectHeight(int i) {
        this.jDv = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jDw;
    }

    public void setScanLineSize(int i) {
        this.jDw = i;
    }

    public int getScanLineColor() {
        return this.jDx;
    }

    public void setScanLineColor(int i) {
        this.jDx = i;
    }

    public int getScanLineMargin() {
        return this.jDy;
    }

    public void setScanLineMargin(int i) {
        this.jDy = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jDz = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jDA;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jDA = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jDB;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jDB = bitmap;
    }

    public int getBorderSize() {
        return this.jDC;
    }

    public void setBorderSize(int i) {
        this.jDC = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jDD;
    }

    public void setAnimTime(int i) {
        this.jDD = i;
    }

    public void setCenterVertical(boolean z) {
        this.jDE = z;
    }

    public int getToolbarHeight() {
        return this.jDF;
    }

    public void setToolbarHeight(int i) {
        this.jDF = i;
    }

    public String getQRCodeTipText() {
        return this.jDH;
    }

    public void setQRCodeTipText(String str) {
        this.jDH = str;
    }

    public String getBarCodeTipText() {
        return this.jDI;
    }

    public void setBarCodeTipText(String str) {
        this.jDI = str;
    }

    public String getTipText() {
        return this.ilL;
    }

    public void setTipText(String str) {
        this.ilL = str;
    }

    public int getTipTextColor() {
        return this.jDK;
    }

    public void setTipTextColor(int i) {
        this.jDK = i;
    }

    public int getTipTextSize() {
        return this.jDJ;
    }

    public void setTipTextSize(int i) {
        this.jDJ = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jDL = z;
    }

    public int getTipTextMargin() {
        return this.jDM;
    }

    public void setTipTextMargin(int i) {
        this.jDM = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jDN = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jDP = z;
    }

    public int getTipBackgroundColor() {
        return this.jDO;
    }

    public void setTipBackgroundColor(int i) {
        this.jDO = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jDQ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jDR = z;
    }

    public float getHalfCornerSize() {
        return this.jEa;
    }

    public void setHalfCornerSize(float f) {
        this.jEa = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jEb;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jEb = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jEc;
    }

    public void setTipBackgroundRadius(int i) {
        this.jEc = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jEd = z;
    }
}
