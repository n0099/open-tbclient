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
/* loaded from: classes22.dex */
public class ScanBoxView extends View {
    private int crU;
    private String kTs;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;
    private Bitmap mqI;
    private Bitmap mqJ;
    private Bitmap mqK;
    private Bitmap mqL;
    private int mqM;
    private int mqN;
    private Rect mqO;
    private float mqP;
    private float mqQ;
    private TextPaint mqR;
    private int mqS;
    private int mqT;
    private int mqU;
    private int mqV;
    private int mqW;
    private int mqX;
    private int mqY;
    private boolean mqZ;
    private float mrA;
    private StaticLayout mrB;
    private int mrC;
    private boolean mrD;
    private ColorMatrixColorFilter mrE;
    private Drawable mra;
    private Bitmap mrb;
    private int mrc;
    private int mrd;
    private boolean mre;
    private int mrf;
    private boolean mrg;
    private String mrh;
    private String mri;
    private int mrj;
    private int mrk;
    private boolean mrl;
    private int mrm;
    private boolean mrn;
    private int mro;
    private boolean mrp;
    private boolean mrq;
    private boolean mrr;
    private Drawable mrs;
    private Bitmap mrt;
    private float mru;
    private float mrv;
    private Bitmap mrw;
    private Bitmap mrx;
    private Bitmap mry;
    private Bitmap mrz;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mqS = a.dp2px(context, 20.0f);
        this.mqT = a.dp2px(context, 3.0f);
        this.mqW = a.dp2px(context, 1.0f);
        this.mqX = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.crU = a.dp2px(context, 200.0f);
        this.mqV = a.dp2px(context, 140.0f);
        this.mqY = 0;
        this.mqZ = false;
        this.mra = null;
        this.mrb = null;
        this.mrc = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mrd = 1000;
        this.mre = false;
        this.mrf = 0;
        this.mrg = false;
        this.mqM = a.dp2px(context, 2.0f);
        this.kTs = null;
        this.mrj = a.h(context, 14.0f);
        this.mrk = -1;
        this.mrl = false;
        this.mrm = a.dp2px(context, 20.0f);
        this.mrn = false;
        this.mro = Color.parseColor("#22000000");
        this.mrp = false;
        this.mrq = false;
        this.mrr = false;
        this.mqR = new TextPaint();
        this.mqR.setAntiAlias(true);
        this.mrC = a.dp2px(context, 4.0f);
        this.mrD = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mrE = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dzd();
        dzc();
    }

    private void dzc() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mqS;
        options.outHeight = this.mqS;
        this.mqI = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mqJ = Bitmap.createBitmap(this.mqI, 0, 0, this.mqI.getWidth(), this.mqI.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mqK = Bitmap.createBitmap(this.mqI, 0, 0, this.mqI.getWidth(), this.mqI.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mqL = Bitmap.createBitmap(this.mqI, 0, 0, this.mqI.getWidth(), this.mqI.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mqT = typedArray.getDimensionPixelSize(i, this.mqT);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mqS = typedArray.getDimensionPixelSize(i, this.mqS);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mqW = typedArray.getDimensionPixelSize(i, this.mqW);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.crU = typedArray.getDimensionPixelSize(i, this.crU);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mqX = typedArray.getColor(i, this.mqX);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mqY = typedArray.getDimensionPixelSize(i, this.mqY);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mqZ = typedArray.getBoolean(i, this.mqZ);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mra = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mrc = typedArray.getDimensionPixelSize(i, this.mrc);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mrd = typedArray.getInteger(i, this.mrd);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mre = typedArray.getBoolean(i, this.mre);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mrf = typedArray.getDimensionPixelSize(i, this.mrf);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mqV = typedArray.getDimensionPixelSize(i, this.mqV);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mrg = typedArray.getBoolean(i, this.mrg);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mri = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mrh = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mrj = typedArray.getDimensionPixelSize(i, this.mrj);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mrk = typedArray.getColor(i, this.mrk);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mrl = typedArray.getBoolean(i, this.mrl);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mrm = typedArray.getDimensionPixelSize(i, this.mrm);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mrn = typedArray.getBoolean(i, this.mrn);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mrp = typedArray.getBoolean(i, this.mrp);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mro = typedArray.getColor(i, this.mro);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mrq = typedArray.getBoolean(i, this.mrq);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mrr = typedArray.getBoolean(i, this.mrr);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mrs = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mrD = typedArray.getBoolean(i, this.mrD);
        }
    }

    private void dzd() {
        if (this.mrs != null) {
            this.mry = ((BitmapDrawable) this.mrs).getBitmap();
        }
        if (this.mry == null) {
            this.mry = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mry = a.g(this.mry, this.mqX);
        }
        this.mrz = a.f(this.mry, 90);
        this.mrz = a.f(this.mrz, 90);
        this.mrz = a.f(this.mrz, 90);
        if (this.mra != null) {
            this.mrw = ((BitmapDrawable) this.mra).getBitmap();
        }
        if (this.mrw == null) {
            this.mrw = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mrw = a.g(this.mrw, this.mqX);
        }
        this.mrx = a.f(this.mrw, 90);
        this.mrA = (1.0f * this.mqT) / 2.0f;
        this.mqR.setTextSize(this.mrj);
        this.mqR.setColor(this.mrk);
        setIsBarcode(this.mrg);
    }

    public void dze() {
        this.mqR.setColor(this.mrk);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mqO != null) {
            ai(canvas);
            aj(canvas);
            al(canvas);
            am(canvas);
            ak(canvas);
            dzf();
        }
    }

    private void ai(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mqO.top, this.mPaint);
            canvas.drawRect(0.0f, this.mqO.top, this.mqO.left, this.mqO.bottom + 1, this.mPaint);
            canvas.drawRect(this.mqO.right + 1, this.mqO.top, width, this.mqO.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mqO.bottom + 1, width, height, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (this.mrc > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mrc);
            canvas.drawRect(this.mqO, this.mPaint);
        }
    }

    private void ak(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mqI, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mqJ, getMainFrameRight() - this.mqI.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mqK, getMainFrameLeft(), getMainFrameBottom() - this.mqI.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mqL, getMainFrameRight() - this.mqI.getWidth(), getMainFrameBottom() - this.mqI.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mqO.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mqO.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mqO.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mqO.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mrc / 2;
    }

    private void al(Canvas canvas) {
        if (this.mrg) {
            if (this.mrt != null) {
                RectF rectF = new RectF(this.mqO.left + this.mrA + 0.5f, this.mqO.top + this.mrA + this.mqY, this.mrv, (this.mqO.bottom - this.mrA) - this.mqY);
                Rect rect = new Rect((int) (this.mrt.getWidth() - rectF.width()), 0, this.mrt.getWidth(), this.mrt.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mrt, rect, rectF, this.mPaint);
            } else if (this.mrb != null) {
                canvas.drawBitmap(this.mrb, (Rect) null, new RectF(this.mqQ, this.mqO.top + this.mrA + this.mqY, this.mqQ + this.mrb.getWidth(), (this.mqO.bottom - this.mrA) - this.mqY), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mqX);
                canvas.drawRect(this.mqQ, this.mqY + this.mqO.top + this.mrA, this.mqW + this.mqQ, (this.mqO.bottom - this.mrA) - this.mqY, this.mPaint);
            }
        } else if (this.mrt != null) {
            RectF rectF2 = new RectF(this.mqO.left + this.mrA + this.mqY, this.mqO.top + this.mrA + 0.5f, (this.mqO.right - this.mrA) - this.mqY, this.mru);
            Rect rect2 = new Rect(0, (int) (this.mrt.getHeight() - rectF2.height()), this.mrt.getWidth(), this.mrt.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mrE);
            canvas.drawBitmap(this.mrt, rect2, rectF2, this.mPaint);
        } else if (this.mrb != null) {
            canvas.drawBitmap(this.mrb, (Rect) null, new RectF(this.mqO.left + this.mrA + this.mqY, this.mqP, (this.mqO.right - this.mrA) - this.mqY, this.mqP + this.mrb.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mqX);
            canvas.drawRect(this.mqY + this.mqO.left + this.mrA, this.mqP, (this.mqO.right - this.mrA) - this.mqY, this.mqW + this.mqP, this.mPaint);
        }
    }

    private void am(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kTs) && this.mrB != null) {
            if (this.mrl) {
                if (this.mrp) {
                    this.mPaint.setColor(this.mro);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mrn) {
                        Rect rect = new Rect();
                        this.mqR.getTextBounds(this.kTs, 0, this.kTs.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mrC;
                        canvas.drawRoundRect(new RectF(width, (this.mqO.bottom + this.mrm) - this.mrC, rect.width() + width + (this.mrC * 2), this.mqO.bottom + this.mrm + this.mrB.getHeight() + this.mrC), this.mrC, this.mrC, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mqO.left, (this.mqO.bottom + this.mrm) - this.mrC, this.mqO.right, this.mqO.bottom + this.mrm + this.mrB.getHeight() + this.mrC), this.mrC, this.mrC, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mrn) {
                    canvas.translate(0.0f, this.mqO.bottom + this.mrm);
                } else {
                    canvas.translate(this.mqO.left + this.mrC, this.mqO.bottom + this.mrm);
                }
                this.mrB.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mrp) {
                this.mPaint.setColor(this.mro);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mrn) {
                    Rect rect2 = new Rect();
                    this.mqR.getTextBounds(this.kTs, 0, this.kTs.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mrC;
                    canvas.drawRoundRect(new RectF(width2, ((this.mqO.top - this.mrm) - this.mrB.getHeight()) - this.mrC, rect2.width() + width2 + (this.mrC * 2), (this.mqO.top - this.mrm) + this.mrC), this.mrC, this.mrC, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mqO.left, ((this.mqO.top - this.mrm) - this.mrB.getHeight()) - this.mrC, this.mqO.right, (this.mqO.top - this.mrm) + this.mrC), this.mrC, this.mrC, this.mPaint);
                }
            }
            canvas.save();
            if (this.mrn) {
                canvas.translate(0.0f, (this.mqO.top - this.mrm) - this.mrB.getHeight());
            } else {
                canvas.translate(this.mqO.left + this.mrC, (this.mqO.top - this.mrm) - this.mrB.getHeight());
            }
            this.mrB.draw(canvas);
            canvas.restore();
        }
    }

    private void dzf() {
        if (this.mrg) {
            if (this.mrt == null) {
                this.mqQ += this.mqM;
                int i = this.mqW;
                if (this.mrb != null) {
                    i = this.mrb.getWidth();
                }
                if (this.mrq) {
                    if (i + this.mqQ > this.mqO.right - this.mrA || this.mqQ < this.mqO.left + this.mrA) {
                        this.mqM = -this.mqM;
                    }
                } else {
                    if (i + this.mqQ > this.mqO.right - this.mrA) {
                        this.mqQ = this.mqO.left + this.mrA + 0.5f;
                    }
                }
            } else {
                this.mrv += this.mqM;
                if (this.mrv > this.mqO.right - this.mrA) {
                    this.mrv = this.mqO.left + this.mrA + 0.5f;
                }
            }
        } else if (this.mrt == null) {
            this.mqP += this.mqM;
            int i2 = this.mqW;
            if (this.mrb != null) {
                i2 = this.mrb.getHeight();
            }
            if (this.mrq) {
                if (i2 + this.mqP > this.mqO.bottom - this.mrA || this.mqP < this.mqO.top + this.mrA) {
                    this.mqM = -this.mqM;
                }
            } else {
                if (i2 + this.mqP > this.mqO.bottom - this.mrA) {
                    this.mqP = this.mqO.top + this.mrA + 0.5f;
                }
            }
        } else {
            this.mru += this.mqM;
            if (this.mru > this.mqO.bottom - this.mrA) {
                this.mru = this.mqO.top + this.mrA + 0.5f;
            }
        }
        postInvalidateDelayed(this.mqN, this.mqO.left, this.mqO.top, this.mqO.right, this.mqO.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dzg();
    }

    private void dzg() {
        int i;
        if (this.mrg) {
            i = this.mTopOffset + this.mrf;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.crU) / 2;
        this.mqO = new Rect(width, i, this.crU + width, this.mqU + i);
        if (this.mrg) {
            float f = this.mqO.left + this.mrA + 0.5f;
            this.mqQ = f;
            this.mrv = f;
            return;
        }
        float f2 = this.mqO.top + this.mrA + 0.5f;
        this.mqP = f2;
        this.mru = f2;
    }

    public Rect Ik(int i) {
        if (this.mrD) {
            Rect rect = new Rect(this.mqO);
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
        this.mrg = z;
        if (this.mrs != null || this.mrr) {
            if (this.mrg) {
                this.mrt = this.mrz;
            } else {
                this.mrt = this.mry;
            }
        } else if (this.mra != null || this.mqZ) {
            if (this.mrg) {
                this.mrb = this.mrx;
            } else {
                this.mrb = this.mrw;
            }
        }
        if (this.mrg) {
            this.kTs = this.mri;
            this.mqU = this.mqV;
            this.mqN = (int) (((this.mrd * 1.0f) * this.mqM) / this.crU);
        } else {
            this.kTs = this.mrh;
            this.mqU = this.crU;
            this.mqN = (int) (((this.mrd * 1.0f) * this.mqM) / this.mqU);
        }
        if (!TextUtils.isEmpty(this.kTs)) {
            if (this.mrn) {
                this.mrB = new StaticLayout(this.kTs, this.mqR, a.fK(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mrB = new StaticLayout(this.kTs, this.mqR, this.crU - (this.mrC * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mre) {
            int i = a.fK(getContext()).y;
            if (this.mrf == 0) {
                this.mTopOffset = (i - this.mqU) / 2;
            } else if (this.mrg) {
                this.mTopOffset = ((i - this.mqU) / 2) + (this.mrf / 2);
            } else {
                this.mTopOffset = (i - this.mqU) / 2;
            }
        }
        dzg();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mrg;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mqS;
    }

    public void setCornerLength(int i) {
        this.mqS = i;
    }

    public int getCornerSize() {
        return this.mqT;
    }

    public void setCornerSize(int i) {
        this.mqT = i;
    }

    public int getRectWidth() {
        return this.crU;
    }

    public void setRectWidth(int i) {
        this.crU = i;
    }

    public int getRectHeight() {
        return this.mqU;
    }

    public void setRectHeight(int i) {
        this.mqU = i;
    }

    public int getBarcodeRectHeight() {
        return this.mqV;
    }

    public void setBarcodeRectHeight(int i) {
        this.mqV = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mqW;
    }

    public void setScanLineSize(int i) {
        this.mqW = i;
    }

    public int getScanLineColor() {
        return this.mqX;
    }

    public void setScanLineColor(int i) {
        this.mqX = i;
    }

    public int getScanLineMargin() {
        return this.mqY;
    }

    public void setScanLineMargin(int i) {
        this.mqY = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mqZ = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mra;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mra = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mrb;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mrb = bitmap;
    }

    public int getBorderSize() {
        return this.mrc;
    }

    public void setBorderSize(int i) {
        this.mrc = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mrd;
    }

    public void setAnimTime(int i) {
        this.mrd = i;
    }

    public void setCenterVertical(boolean z) {
        this.mre = z;
    }

    public int getToolbarHeight() {
        return this.mrf;
    }

    public void setToolbarHeight(int i) {
        this.mrf = i;
    }

    public String getQRCodeTipText() {
        return this.mrh;
    }

    public void setQRCodeTipText(String str) {
        this.mrh = str;
    }

    public String getBarCodeTipText() {
        return this.mri;
    }

    public void setBarCodeTipText(String str) {
        this.mri = str;
    }

    public String getTipText() {
        return this.kTs;
    }

    public void setTipText(String str) {
        this.kTs = str;
    }

    public int getTipTextColor() {
        return this.mrk;
    }

    public void setTipTextColor(int i) {
        this.mrk = i;
    }

    public int getTipTextSize() {
        return this.mrj;
    }

    public void setTipTextSize(int i) {
        this.mrj = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mrl = z;
    }

    public int getTipTextMargin() {
        return this.mrm;
    }

    public void setTipTextMargin(int i) {
        this.mrm = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mrn = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mrp = z;
    }

    public int getTipBackgroundColor() {
        return this.mro;
    }

    public void setTipBackgroundColor(int i) {
        this.mro = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mrq = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mrr = z;
    }

    public float getHalfCornerSize() {
        return this.mrA;
    }

    public void setHalfCornerSize(float f) {
        this.mrA = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mrB;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mrB = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mrC;
    }

    public void setTipBackgroundRadius(int i) {
        this.mrC = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mrD = z;
    }
}
