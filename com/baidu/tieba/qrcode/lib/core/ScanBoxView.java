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
    private int bac;
    private String inB;
    private Bitmap jEV;
    private Bitmap jEW;
    private Bitmap jEX;
    private Bitmap jEY;
    private int jEZ;
    private boolean jFA;
    private int jFB;
    private boolean jFC;
    private boolean jFD;
    private boolean jFE;
    private Drawable jFF;
    private Bitmap jFG;
    private float jFH;
    private float jFI;
    private Bitmap jFJ;
    private Bitmap jFK;
    private Bitmap jFL;
    private Bitmap jFM;
    private float jFN;
    private StaticLayout jFO;
    private int jFP;
    private boolean jFQ;
    private ColorMatrixColorFilter jFR;
    private int jFa;
    private Rect jFb;
    private float jFc;
    private float jFd;
    private TextPaint jFe;
    private int jFf;
    private int jFg;
    private int jFh;
    private int jFi;
    private int jFj;
    private int jFk;
    private int jFl;
    private boolean jFm;
    private Drawable jFn;
    private Bitmap jFo;
    private int jFp;
    private int jFq;
    private boolean jFr;
    private int jFs;
    private boolean jFt;
    private String jFu;
    private String jFv;
    private int jFw;
    private int jFx;
    private boolean jFy;
    private int jFz;
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
        this.jFf = a.dp2px(context, 20.0f);
        this.jFg = a.dp2px(context, 3.0f);
        this.jFj = a.dp2px(context, 1.0f);
        this.jFk = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bac = a.dp2px(context, 200.0f);
        this.jFi = a.dp2px(context, 140.0f);
        this.jFl = 0;
        this.jFm = false;
        this.jFn = null;
        this.jFo = null;
        this.jFp = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jFq = 1000;
        this.jFr = false;
        this.jFs = 0;
        this.jFt = false;
        this.jEZ = a.dp2px(context, 2.0f);
        this.inB = null;
        this.jFw = a.h(context, 14.0f);
        this.jFx = -1;
        this.jFy = false;
        this.jFz = a.dp2px(context, 20.0f);
        this.jFA = false;
        this.jFB = Color.parseColor("#22000000");
        this.jFC = false;
        this.jFD = false;
        this.jFE = false;
        this.jFe = new TextPaint();
        this.jFe.setAntiAlias(true);
        this.jFP = a.dp2px(context, 4.0f);
        this.jFQ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jFR = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cCk();
        cCj();
    }

    private void cCj() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jFf;
        options.outHeight = this.jFf;
        this.jEV = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jEW = Bitmap.createBitmap(this.jEV, 0, 0, this.jEV.getWidth(), this.jEV.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jEX = Bitmap.createBitmap(this.jEV, 0, 0, this.jEV.getWidth(), this.jEV.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jEY = Bitmap.createBitmap(this.jEV, 0, 0, this.jEV.getWidth(), this.jEV.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jFg = typedArray.getDimensionPixelSize(i, this.jFg);
        } else if (i == 2) {
            this.jFf = typedArray.getDimensionPixelSize(i, this.jFf);
        } else if (i == 6) {
            this.jFj = typedArray.getDimensionPixelSize(i, this.jFj);
        } else if (i == 3) {
            this.bac = typedArray.getDimensionPixelSize(i, this.bac);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jFk = typedArray.getColor(i, this.jFk);
        } else if (i == 8) {
            this.jFl = typedArray.getDimensionPixelSize(i, this.jFl);
        } else if (i == 9) {
            this.jFm = typedArray.getBoolean(i, this.jFm);
        } else if (i == 10) {
            this.jFn = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jFp = typedArray.getDimensionPixelSize(i, this.jFp);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jFq = typedArray.getInteger(i, this.jFq);
        } else if (i == 14) {
            this.jFr = typedArray.getBoolean(i, this.jFr);
        } else if (i == 15) {
            this.jFs = typedArray.getDimensionPixelSize(i, this.jFs);
        } else if (i == 4) {
            this.jFi = typedArray.getDimensionPixelSize(i, this.jFi);
        } else if (i == 16) {
            this.jFt = typedArray.getBoolean(i, this.jFt);
        } else if (i == 18) {
            this.jFv = typedArray.getString(i);
        } else if (i == 17) {
            this.jFu = typedArray.getString(i);
        } else if (i == 19) {
            this.jFw = typedArray.getDimensionPixelSize(i, this.jFw);
        } else if (i == 20) {
            this.jFx = typedArray.getColor(i, this.jFx);
        } else if (i == 21) {
            this.jFy = typedArray.getBoolean(i, this.jFy);
        } else if (i == 22) {
            this.jFz = typedArray.getDimensionPixelSize(i, this.jFz);
        } else if (i == 23) {
            this.jFA = typedArray.getBoolean(i, this.jFA);
        } else if (i == 24) {
            this.jFC = typedArray.getBoolean(i, this.jFC);
        } else if (i == 25) {
            this.jFB = typedArray.getColor(i, this.jFB);
        } else if (i == 26) {
            this.jFD = typedArray.getBoolean(i, this.jFD);
        } else if (i == 27) {
            this.jFE = typedArray.getBoolean(i, this.jFE);
        } else if (i == 28) {
            this.jFF = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jFQ = typedArray.getBoolean(i, this.jFQ);
        }
    }

    private void cCk() {
        if (this.jFF != null) {
            this.jFL = ((BitmapDrawable) this.jFF).getBitmap();
        }
        if (this.jFL == null) {
            this.jFL = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jFL = a.e(this.jFL, this.jFk);
        }
        this.jFM = a.adjustPhotoRotation(this.jFL, 90);
        this.jFM = a.adjustPhotoRotation(this.jFM, 90);
        this.jFM = a.adjustPhotoRotation(this.jFM, 90);
        if (this.jFn != null) {
            this.jFJ = ((BitmapDrawable) this.jFn).getBitmap();
        }
        if (this.jFJ == null) {
            this.jFJ = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jFJ = a.e(this.jFJ, this.jFk);
        }
        this.jFK = a.adjustPhotoRotation(this.jFJ, 90);
        this.jFN = (1.0f * this.jFg) / 2.0f;
        this.jFe.setTextSize(this.jFw);
        this.jFe.setColor(this.jFx);
        setIsBarcode(this.jFt);
    }

    public void cCl() {
        this.jFe.setColor(this.jFx);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jFb != null) {
            R(canvas);
            S(canvas);
            U(canvas);
            V(canvas);
            T(canvas);
            cCm();
        }
    }

    private void R(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jFb.top, this.mPaint);
            canvas.drawRect(0.0f, this.jFb.top, this.jFb.left, this.jFb.bottom + 1, this.mPaint);
            canvas.drawRect(this.jFb.right + 1, this.jFb.top, width, this.jFb.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jFb.bottom + 1, width, height, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        if (this.jFp > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jFp);
            canvas.drawRect(this.jFb, this.mPaint);
        }
    }

    private void T(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jEV, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jEW, getMainFrameRight() - this.jEV.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jEX, getMainFrameLeft(), getMainFrameBottom() - this.jEV.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jEY, getMainFrameRight() - this.jEV.getWidth(), getMainFrameBottom() - this.jEV.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jFb.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jFb.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jFb.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jFb.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jFp / 2;
    }

    private void U(Canvas canvas) {
        if (this.jFt) {
            if (this.jFG != null) {
                RectF rectF = new RectF(this.jFb.left + this.jFN + 0.5f, this.jFb.top + this.jFN + this.jFl, this.jFI, (this.jFb.bottom - this.jFN) - this.jFl);
                Rect rect = new Rect((int) (this.jFG.getWidth() - rectF.width()), 0, this.jFG.getWidth(), this.jFG.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jFG, rect, rectF, this.mPaint);
            } else if (this.jFo != null) {
                canvas.drawBitmap(this.jFo, (Rect) null, new RectF(this.jFd, this.jFb.top + this.jFN + this.jFl, this.jFd + this.jFo.getWidth(), (this.jFb.bottom - this.jFN) - this.jFl), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jFk);
                canvas.drawRect(this.jFd, this.jFl + this.jFb.top + this.jFN, this.jFj + this.jFd, (this.jFb.bottom - this.jFN) - this.jFl, this.mPaint);
            }
        } else if (this.jFG != null) {
            RectF rectF2 = new RectF(this.jFb.left + this.jFN + this.jFl, this.jFb.top + this.jFN + 0.5f, (this.jFb.right - this.jFN) - this.jFl, this.jFH);
            Rect rect2 = new Rect(0, (int) (this.jFG.getHeight() - rectF2.height()), this.jFG.getWidth(), this.jFG.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jFR);
            canvas.drawBitmap(this.jFG, rect2, rectF2, this.mPaint);
        } else if (this.jFo != null) {
            canvas.drawBitmap(this.jFo, (Rect) null, new RectF(this.jFb.left + this.jFN + this.jFl, this.jFc, (this.jFb.right - this.jFN) - this.jFl, this.jFc + this.jFo.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jFk);
            canvas.drawRect(this.jFl + this.jFb.left + this.jFN, this.jFc, (this.jFb.right - this.jFN) - this.jFl, this.jFj + this.jFc, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (!TextUtils.isEmpty(this.inB) && this.jFO != null) {
            if (this.jFy) {
                if (this.jFC) {
                    this.mPaint.setColor(this.jFB);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jFA) {
                        Rect rect = new Rect();
                        this.jFe.getTextBounds(this.inB, 0, this.inB.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jFP;
                        canvas.drawRoundRect(new RectF(width, (this.jFb.bottom + this.jFz) - this.jFP, rect.width() + width + (this.jFP * 2), this.jFb.bottom + this.jFz + this.jFO.getHeight() + this.jFP), this.jFP, this.jFP, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jFb.left, (this.jFb.bottom + this.jFz) - this.jFP, this.jFb.right, this.jFb.bottom + this.jFz + this.jFO.getHeight() + this.jFP), this.jFP, this.jFP, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jFA) {
                    canvas.translate(0.0f, this.jFb.bottom + this.jFz);
                } else {
                    canvas.translate(this.jFb.left + this.jFP, this.jFb.bottom + this.jFz);
                }
                this.jFO.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jFC) {
                this.mPaint.setColor(this.jFB);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jFA) {
                    Rect rect2 = new Rect();
                    this.jFe.getTextBounds(this.inB, 0, this.inB.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jFP;
                    canvas.drawRoundRect(new RectF(width2, ((this.jFb.top - this.jFz) - this.jFO.getHeight()) - this.jFP, rect2.width() + width2 + (this.jFP * 2), (this.jFb.top - this.jFz) + this.jFP), this.jFP, this.jFP, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jFb.left, ((this.jFb.top - this.jFz) - this.jFO.getHeight()) - this.jFP, this.jFb.right, (this.jFb.top - this.jFz) + this.jFP), this.jFP, this.jFP, this.mPaint);
                }
            }
            canvas.save();
            if (this.jFA) {
                canvas.translate(0.0f, (this.jFb.top - this.jFz) - this.jFO.getHeight());
            } else {
                canvas.translate(this.jFb.left + this.jFP, (this.jFb.top - this.jFz) - this.jFO.getHeight());
            }
            this.jFO.draw(canvas);
            canvas.restore();
        }
    }

    private void cCm() {
        if (this.jFt) {
            if (this.jFG == null) {
                this.jFd += this.jEZ;
                int i = this.jFj;
                if (this.jFo != null) {
                    i = this.jFo.getWidth();
                }
                if (this.jFD) {
                    if (i + this.jFd > this.jFb.right - this.jFN || this.jFd < this.jFb.left + this.jFN) {
                        this.jEZ = -this.jEZ;
                    }
                } else {
                    if (i + this.jFd > this.jFb.right - this.jFN) {
                        this.jFd = this.jFb.left + this.jFN + 0.5f;
                    }
                }
            } else {
                this.jFI += this.jEZ;
                if (this.jFI > this.jFb.right - this.jFN) {
                    this.jFI = this.jFb.left + this.jFN + 0.5f;
                }
            }
        } else if (this.jFG == null) {
            this.jFc += this.jEZ;
            int i2 = this.jFj;
            if (this.jFo != null) {
                i2 = this.jFo.getHeight();
            }
            if (this.jFD) {
                if (i2 + this.jFc > this.jFb.bottom - this.jFN || this.jFc < this.jFb.top + this.jFN) {
                    this.jEZ = -this.jEZ;
                }
            } else {
                if (i2 + this.jFc > this.jFb.bottom - this.jFN) {
                    this.jFc = this.jFb.top + this.jFN + 0.5f;
                }
            }
        } else {
            this.jFH += this.jEZ;
            if (this.jFH > this.jFb.bottom - this.jFN) {
                this.jFH = this.jFb.top + this.jFN + 0.5f;
            }
        }
        postInvalidateDelayed(this.jFa, this.jFb.left, this.jFb.top, this.jFb.right, this.jFb.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cCn();
    }

    private void cCn() {
        int i;
        if (this.jFt) {
            i = this.mTopOffset + this.jFs;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bac) / 2;
        this.jFb = new Rect(width, i, this.bac + width, this.jFh + i);
        if (this.jFt) {
            float f = this.jFb.left + this.jFN + 0.5f;
            this.jFd = f;
            this.jFI = f;
            return;
        }
        float f2 = this.jFb.top + this.jFN + 0.5f;
        this.jFc = f2;
        this.jFH = f2;
    }

    public Rect AU(int i) {
        if (this.jFQ) {
            Rect rect = new Rect(this.jFb);
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
        this.jFt = z;
        if (this.jFF != null || this.jFE) {
            if (this.jFt) {
                this.jFG = this.jFM;
            } else {
                this.jFG = this.jFL;
            }
        } else if (this.jFn != null || this.jFm) {
            if (this.jFt) {
                this.jFo = this.jFK;
            } else {
                this.jFo = this.jFJ;
            }
        }
        if (this.jFt) {
            this.inB = this.jFv;
            this.jFh = this.jFi;
            this.jFa = (int) (((this.jFq * 1.0f) * this.jEZ) / this.bac);
        } else {
            this.inB = this.jFu;
            this.jFh = this.bac;
            this.jFa = (int) (((this.jFq * 1.0f) * this.jEZ) / this.jFh);
        }
        if (!TextUtils.isEmpty(this.inB)) {
            if (this.jFA) {
                this.jFO = new StaticLayout(this.inB, this.jFe, a.fl(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jFO = new StaticLayout(this.inB, this.jFe, this.bac - (this.jFP * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jFr) {
            int i = a.fl(getContext()).y;
            if (this.jFs == 0) {
                this.mTopOffset = (i - this.jFh) / 2;
            } else if (this.jFt) {
                this.mTopOffset = ((i - this.jFh) / 2) + (this.jFs / 2);
            } else {
                this.mTopOffset = (i - this.jFh) / 2;
            }
        }
        cCn();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jFt;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jFf;
    }

    public void setCornerLength(int i) {
        this.jFf = i;
    }

    public int getCornerSize() {
        return this.jFg;
    }

    public void setCornerSize(int i) {
        this.jFg = i;
    }

    public int getRectWidth() {
        return this.bac;
    }

    public void setRectWidth(int i) {
        this.bac = i;
    }

    public int getRectHeight() {
        return this.jFh;
    }

    public void setRectHeight(int i) {
        this.jFh = i;
    }

    public int getBarcodeRectHeight() {
        return this.jFi;
    }

    public void setBarcodeRectHeight(int i) {
        this.jFi = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jFj;
    }

    public void setScanLineSize(int i) {
        this.jFj = i;
    }

    public int getScanLineColor() {
        return this.jFk;
    }

    public void setScanLineColor(int i) {
        this.jFk = i;
    }

    public int getScanLineMargin() {
        return this.jFl;
    }

    public void setScanLineMargin(int i) {
        this.jFl = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jFm = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jFn;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jFn = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jFo;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jFo = bitmap;
    }

    public int getBorderSize() {
        return this.jFp;
    }

    public void setBorderSize(int i) {
        this.jFp = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jFq;
    }

    public void setAnimTime(int i) {
        this.jFq = i;
    }

    public void setCenterVertical(boolean z) {
        this.jFr = z;
    }

    public int getToolbarHeight() {
        return this.jFs;
    }

    public void setToolbarHeight(int i) {
        this.jFs = i;
    }

    public String getQRCodeTipText() {
        return this.jFu;
    }

    public void setQRCodeTipText(String str) {
        this.jFu = str;
    }

    public String getBarCodeTipText() {
        return this.jFv;
    }

    public void setBarCodeTipText(String str) {
        this.jFv = str;
    }

    public String getTipText() {
        return this.inB;
    }

    public void setTipText(String str) {
        this.inB = str;
    }

    public int getTipTextColor() {
        return this.jFx;
    }

    public void setTipTextColor(int i) {
        this.jFx = i;
    }

    public int getTipTextSize() {
        return this.jFw;
    }

    public void setTipTextSize(int i) {
        this.jFw = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jFy = z;
    }

    public int getTipTextMargin() {
        return this.jFz;
    }

    public void setTipTextMargin(int i) {
        this.jFz = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jFA = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jFC = z;
    }

    public int getTipBackgroundColor() {
        return this.jFB;
    }

    public void setTipBackgroundColor(int i) {
        this.jFB = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jFD = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jFE = z;
    }

    public float getHalfCornerSize() {
        return this.jFN;
    }

    public void setHalfCornerSize(float f) {
        this.jFN = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jFO;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jFO = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jFP;
    }

    public void setTipBackgroundRadius(int i) {
        this.jFP = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jFQ = z;
    }
}
