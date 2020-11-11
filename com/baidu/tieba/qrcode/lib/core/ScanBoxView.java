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
/* loaded from: classes23.dex */
public class ScanBoxView extends View {
    private int ctG;
    private String kTf;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;
    private int mqA;
    private int mqB;
    private int mqC;
    private int mqD;
    private int mqE;
    private boolean mqF;
    private Drawable mqG;
    private Bitmap mqH;
    private int mqI;
    private int mqJ;
    private boolean mqK;
    private int mqL;
    private boolean mqM;
    private String mqN;
    private String mqO;
    private int mqP;
    private int mqQ;
    private boolean mqR;
    private int mqS;
    private boolean mqT;
    private int mqU;
    private boolean mqV;
    private boolean mqW;
    private boolean mqX;
    private Drawable mqY;
    private Bitmap mqZ;
    private Bitmap mqo;
    private Bitmap mqp;
    private Bitmap mqq;
    private Bitmap mqr;
    private int mqs;
    private int mqt;
    private Rect mqu;
    private float mqv;
    private float mqw;
    private TextPaint mqx;
    private int mqy;
    private int mqz;
    private float mra;
    private float mrb;
    private Bitmap mrc;
    private Bitmap mrd;
    private Bitmap mre;
    private Bitmap mrf;
    private float mrg;
    private StaticLayout mrh;
    private int mri;
    private boolean mrj;
    private ColorMatrixColorFilter mrk;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mqy = a.dp2px(context, 20.0f);
        this.mqz = a.dp2px(context, 3.0f);
        this.mqC = a.dp2px(context, 1.0f);
        this.mqD = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.ctG = a.dp2px(context, 200.0f);
        this.mqB = a.dp2px(context, 140.0f);
        this.mqE = 0;
        this.mqF = false;
        this.mqG = null;
        this.mqH = null;
        this.mqI = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mqJ = 1000;
        this.mqK = false;
        this.mqL = 0;
        this.mqM = false;
        this.mqs = a.dp2px(context, 2.0f);
        this.kTf = null;
        this.mqP = a.h(context, 14.0f);
        this.mqQ = -1;
        this.mqR = false;
        this.mqS = a.dp2px(context, 20.0f);
        this.mqT = false;
        this.mqU = Color.parseColor("#22000000");
        this.mqV = false;
        this.mqW = false;
        this.mqX = false;
        this.mqx = new TextPaint();
        this.mqx.setAntiAlias(true);
        this.mri = a.dp2px(context, 4.0f);
        this.mrj = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mrk = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dzD();
        dzC();
    }

    private void dzC() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mqy;
        options.outHeight = this.mqy;
        this.mqo = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mqp = Bitmap.createBitmap(this.mqo, 0, 0, this.mqo.getWidth(), this.mqo.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mqq = Bitmap.createBitmap(this.mqo, 0, 0, this.mqo.getWidth(), this.mqo.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mqr = Bitmap.createBitmap(this.mqo, 0, 0, this.mqo.getWidth(), this.mqo.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mqz = typedArray.getDimensionPixelSize(i, this.mqz);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mqy = typedArray.getDimensionPixelSize(i, this.mqy);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mqC = typedArray.getDimensionPixelSize(i, this.mqC);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.ctG = typedArray.getDimensionPixelSize(i, this.ctG);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mqD = typedArray.getColor(i, this.mqD);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mqE = typedArray.getDimensionPixelSize(i, this.mqE);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mqF = typedArray.getBoolean(i, this.mqF);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mqG = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mqI = typedArray.getDimensionPixelSize(i, this.mqI);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mqJ = typedArray.getInteger(i, this.mqJ);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mqK = typedArray.getBoolean(i, this.mqK);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mqL = typedArray.getDimensionPixelSize(i, this.mqL);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mqB = typedArray.getDimensionPixelSize(i, this.mqB);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mqM = typedArray.getBoolean(i, this.mqM);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mqO = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mqN = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mqP = typedArray.getDimensionPixelSize(i, this.mqP);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mqQ = typedArray.getColor(i, this.mqQ);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mqR = typedArray.getBoolean(i, this.mqR);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mqS = typedArray.getDimensionPixelSize(i, this.mqS);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mqT = typedArray.getBoolean(i, this.mqT);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mqV = typedArray.getBoolean(i, this.mqV);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mqU = typedArray.getColor(i, this.mqU);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mqW = typedArray.getBoolean(i, this.mqW);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mqX = typedArray.getBoolean(i, this.mqX);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mqY = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mrj = typedArray.getBoolean(i, this.mrj);
        }
    }

    private void dzD() {
        if (this.mqY != null) {
            this.mre = ((BitmapDrawable) this.mqY).getBitmap();
        }
        if (this.mre == null) {
            this.mre = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mre = a.g(this.mre, this.mqD);
        }
        this.mrf = a.f(this.mre, 90);
        this.mrf = a.f(this.mrf, 90);
        this.mrf = a.f(this.mrf, 90);
        if (this.mqG != null) {
            this.mrc = ((BitmapDrawable) this.mqG).getBitmap();
        }
        if (this.mrc == null) {
            this.mrc = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mrc = a.g(this.mrc, this.mqD);
        }
        this.mrd = a.f(this.mrc, 90);
        this.mrg = (1.0f * this.mqz) / 2.0f;
        this.mqx.setTextSize(this.mqP);
        this.mqx.setColor(this.mqQ);
        setIsBarcode(this.mqM);
    }

    public void dzE() {
        this.mqx.setColor(this.mqQ);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mqu != null) {
            af(canvas);
            ag(canvas);
            ai(canvas);
            aj(canvas);
            ah(canvas);
            dzF();
        }
    }

    private void af(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mqu.top, this.mPaint);
            canvas.drawRect(0.0f, this.mqu.top, this.mqu.left, this.mqu.bottom + 1, this.mPaint);
            canvas.drawRect(this.mqu.right + 1, this.mqu.top, width, this.mqu.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mqu.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        if (this.mqI > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mqI);
            canvas.drawRect(this.mqu, this.mPaint);
        }
    }

    private void ah(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mqo, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mqp, getMainFrameRight() - this.mqo.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mqq, getMainFrameLeft(), getMainFrameBottom() - this.mqo.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mqr, getMainFrameRight() - this.mqo.getWidth(), getMainFrameBottom() - this.mqo.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mqu.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mqu.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mqu.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mqu.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mqI / 2;
    }

    private void ai(Canvas canvas) {
        if (this.mqM) {
            if (this.mqZ != null) {
                RectF rectF = new RectF(this.mqu.left + this.mrg + 0.5f, this.mqu.top + this.mrg + this.mqE, this.mrb, (this.mqu.bottom - this.mrg) - this.mqE);
                Rect rect = new Rect((int) (this.mqZ.getWidth() - rectF.width()), 0, this.mqZ.getWidth(), this.mqZ.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mqZ, rect, rectF, this.mPaint);
            } else if (this.mqH != null) {
                canvas.drawBitmap(this.mqH, (Rect) null, new RectF(this.mqw, this.mqu.top + this.mrg + this.mqE, this.mqw + this.mqH.getWidth(), (this.mqu.bottom - this.mrg) - this.mqE), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mqD);
                canvas.drawRect(this.mqw, this.mqE + this.mqu.top + this.mrg, this.mqC + this.mqw, (this.mqu.bottom - this.mrg) - this.mqE, this.mPaint);
            }
        } else if (this.mqZ != null) {
            RectF rectF2 = new RectF(this.mqu.left + this.mrg + this.mqE, this.mqu.top + this.mrg + 0.5f, (this.mqu.right - this.mrg) - this.mqE, this.mra);
            Rect rect2 = new Rect(0, (int) (this.mqZ.getHeight() - rectF2.height()), this.mqZ.getWidth(), this.mqZ.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mrk);
            canvas.drawBitmap(this.mqZ, rect2, rectF2, this.mPaint);
        } else if (this.mqH != null) {
            canvas.drawBitmap(this.mqH, (Rect) null, new RectF(this.mqu.left + this.mrg + this.mqE, this.mqv, (this.mqu.right - this.mrg) - this.mqE, this.mqv + this.mqH.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mqD);
            canvas.drawRect(this.mqE + this.mqu.left + this.mrg, this.mqv, (this.mqu.right - this.mrg) - this.mqE, this.mqC + this.mqv, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kTf) && this.mrh != null) {
            if (this.mqR) {
                if (this.mqV) {
                    this.mPaint.setColor(this.mqU);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mqT) {
                        Rect rect = new Rect();
                        this.mqx.getTextBounds(this.kTf, 0, this.kTf.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mri;
                        canvas.drawRoundRect(new RectF(width, (this.mqu.bottom + this.mqS) - this.mri, rect.width() + width + (this.mri * 2), this.mqu.bottom + this.mqS + this.mrh.getHeight() + this.mri), this.mri, this.mri, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mqu.left, (this.mqu.bottom + this.mqS) - this.mri, this.mqu.right, this.mqu.bottom + this.mqS + this.mrh.getHeight() + this.mri), this.mri, this.mri, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mqT) {
                    canvas.translate(0.0f, this.mqu.bottom + this.mqS);
                } else {
                    canvas.translate(this.mqu.left + this.mri, this.mqu.bottom + this.mqS);
                }
                this.mrh.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mqV) {
                this.mPaint.setColor(this.mqU);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mqT) {
                    Rect rect2 = new Rect();
                    this.mqx.getTextBounds(this.kTf, 0, this.kTf.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mri;
                    canvas.drawRoundRect(new RectF(width2, ((this.mqu.top - this.mqS) - this.mrh.getHeight()) - this.mri, rect2.width() + width2 + (this.mri * 2), (this.mqu.top - this.mqS) + this.mri), this.mri, this.mri, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mqu.left, ((this.mqu.top - this.mqS) - this.mrh.getHeight()) - this.mri, this.mqu.right, (this.mqu.top - this.mqS) + this.mri), this.mri, this.mri, this.mPaint);
                }
            }
            canvas.save();
            if (this.mqT) {
                canvas.translate(0.0f, (this.mqu.top - this.mqS) - this.mrh.getHeight());
            } else {
                canvas.translate(this.mqu.left + this.mri, (this.mqu.top - this.mqS) - this.mrh.getHeight());
            }
            this.mrh.draw(canvas);
            canvas.restore();
        }
    }

    private void dzF() {
        if (this.mqM) {
            if (this.mqZ == null) {
                this.mqw += this.mqs;
                int i = this.mqC;
                if (this.mqH != null) {
                    i = this.mqH.getWidth();
                }
                if (this.mqW) {
                    if (i + this.mqw > this.mqu.right - this.mrg || this.mqw < this.mqu.left + this.mrg) {
                        this.mqs = -this.mqs;
                    }
                } else {
                    if (i + this.mqw > this.mqu.right - this.mrg) {
                        this.mqw = this.mqu.left + this.mrg + 0.5f;
                    }
                }
            } else {
                this.mrb += this.mqs;
                if (this.mrb > this.mqu.right - this.mrg) {
                    this.mrb = this.mqu.left + this.mrg + 0.5f;
                }
            }
        } else if (this.mqZ == null) {
            this.mqv += this.mqs;
            int i2 = this.mqC;
            if (this.mqH != null) {
                i2 = this.mqH.getHeight();
            }
            if (this.mqW) {
                if (i2 + this.mqv > this.mqu.bottom - this.mrg || this.mqv < this.mqu.top + this.mrg) {
                    this.mqs = -this.mqs;
                }
            } else {
                if (i2 + this.mqv > this.mqu.bottom - this.mrg) {
                    this.mqv = this.mqu.top + this.mrg + 0.5f;
                }
            }
        } else {
            this.mra += this.mqs;
            if (this.mra > this.mqu.bottom - this.mrg) {
                this.mra = this.mqu.top + this.mrg + 0.5f;
            }
        }
        postInvalidateDelayed(this.mqt, this.mqu.left, this.mqu.top, this.mqu.right, this.mqu.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dzG();
    }

    private void dzG() {
        int i;
        if (this.mqM) {
            i = this.mTopOffset + this.mqL;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.ctG) / 2;
        this.mqu = new Rect(width, i, this.ctG + width, this.mqA + i);
        if (this.mqM) {
            float f = this.mqu.left + this.mrg + 0.5f;
            this.mqw = f;
            this.mrb = f;
            return;
        }
        float f2 = this.mqu.top + this.mrg + 0.5f;
        this.mqv = f2;
        this.mra = f2;
    }

    public Rect HM(int i) {
        if (this.mrj) {
            Rect rect = new Rect(this.mqu);
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
        this.mqM = z;
        if (this.mqY != null || this.mqX) {
            if (this.mqM) {
                this.mqZ = this.mrf;
            } else {
                this.mqZ = this.mre;
            }
        } else if (this.mqG != null || this.mqF) {
            if (this.mqM) {
                this.mqH = this.mrd;
            } else {
                this.mqH = this.mrc;
            }
        }
        if (this.mqM) {
            this.kTf = this.mqO;
            this.mqA = this.mqB;
            this.mqt = (int) (((this.mqJ * 1.0f) * this.mqs) / this.ctG);
        } else {
            this.kTf = this.mqN;
            this.mqA = this.ctG;
            this.mqt = (int) (((this.mqJ * 1.0f) * this.mqs) / this.mqA);
        }
        if (!TextUtils.isEmpty(this.kTf)) {
            if (this.mqT) {
                this.mrh = new StaticLayout(this.kTf, this.mqx, a.fL(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mrh = new StaticLayout(this.kTf, this.mqx, this.ctG - (this.mri * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mqK) {
            int i = a.fL(getContext()).y;
            if (this.mqL == 0) {
                this.mTopOffset = (i - this.mqA) / 2;
            } else if (this.mqM) {
                this.mTopOffset = ((i - this.mqA) / 2) + (this.mqL / 2);
            } else {
                this.mTopOffset = (i - this.mqA) / 2;
            }
        }
        dzG();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mqM;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mqy;
    }

    public void setCornerLength(int i) {
        this.mqy = i;
    }

    public int getCornerSize() {
        return this.mqz;
    }

    public void setCornerSize(int i) {
        this.mqz = i;
    }

    public int getRectWidth() {
        return this.ctG;
    }

    public void setRectWidth(int i) {
        this.ctG = i;
    }

    public int getRectHeight() {
        return this.mqA;
    }

    public void setRectHeight(int i) {
        this.mqA = i;
    }

    public int getBarcodeRectHeight() {
        return this.mqB;
    }

    public void setBarcodeRectHeight(int i) {
        this.mqB = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mqC;
    }

    public void setScanLineSize(int i) {
        this.mqC = i;
    }

    public int getScanLineColor() {
        return this.mqD;
    }

    public void setScanLineColor(int i) {
        this.mqD = i;
    }

    public int getScanLineMargin() {
        return this.mqE;
    }

    public void setScanLineMargin(int i) {
        this.mqE = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mqF = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mqG;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mqG = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mqH;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mqH = bitmap;
    }

    public int getBorderSize() {
        return this.mqI;
    }

    public void setBorderSize(int i) {
        this.mqI = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mqJ;
    }

    public void setAnimTime(int i) {
        this.mqJ = i;
    }

    public void setCenterVertical(boolean z) {
        this.mqK = z;
    }

    public int getToolbarHeight() {
        return this.mqL;
    }

    public void setToolbarHeight(int i) {
        this.mqL = i;
    }

    public String getQRCodeTipText() {
        return this.mqN;
    }

    public void setQRCodeTipText(String str) {
        this.mqN = str;
    }

    public String getBarCodeTipText() {
        return this.mqO;
    }

    public void setBarCodeTipText(String str) {
        this.mqO = str;
    }

    public String getTipText() {
        return this.kTf;
    }

    public void setTipText(String str) {
        this.kTf = str;
    }

    public int getTipTextColor() {
        return this.mqQ;
    }

    public void setTipTextColor(int i) {
        this.mqQ = i;
    }

    public int getTipTextSize() {
        return this.mqP;
    }

    public void setTipTextSize(int i) {
        this.mqP = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mqR = z;
    }

    public int getTipTextMargin() {
        return this.mqS;
    }

    public void setTipTextMargin(int i) {
        this.mqS = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mqT = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mqV = z;
    }

    public int getTipBackgroundColor() {
        return this.mqU;
    }

    public void setTipBackgroundColor(int i) {
        this.mqU = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mqW = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mqX = z;
    }

    public float getHalfCornerSize() {
        return this.mrg;
    }

    public void setHalfCornerSize(float f) {
        this.mrg = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mrh;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mrh = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mri;
    }

    public void setTipBackgroundRadius(int i) {
        this.mri = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mrj = z;
    }
}
