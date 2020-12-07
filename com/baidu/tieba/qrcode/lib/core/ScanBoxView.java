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
    private int cyQ;
    private String lgL;
    private int mBorderColor;
    private Context mContext;
    private Bitmap mEP;
    private Bitmap mEQ;
    private Bitmap mER;
    private Bitmap mES;
    private int mET;
    private int mEU;
    private Rect mEV;
    private float mEW;
    private float mEX;
    private TextPaint mEY;
    private int mEZ;
    private Bitmap mFA;
    private float mFB;
    private float mFC;
    private Bitmap mFD;
    private Bitmap mFE;
    private Bitmap mFF;
    private Bitmap mFG;
    private float mFH;
    private StaticLayout mFI;
    private int mFJ;
    private boolean mFK;
    private ColorMatrixColorFilter mFL;
    private int mFa;
    private int mFb;
    private int mFc;
    private int mFd;
    private int mFe;
    private int mFf;
    private boolean mFg;
    private Drawable mFh;
    private Bitmap mFi;
    private int mFj;
    private int mFk;
    private boolean mFl;
    private int mFm;
    private boolean mFn;
    private String mFo;
    private String mFp;
    private int mFq;
    private int mFr;
    private boolean mFs;
    private int mFt;
    private boolean mFu;
    private int mFv;
    private boolean mFw;
    private boolean mFx;
    private boolean mFy;
    private Drawable mFz;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mEZ = a.dp2px(context, 20.0f);
        this.mFa = a.dp2px(context, 3.0f);
        this.mFd = a.dp2px(context, 1.0f);
        this.mFe = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cyQ = a.dp2px(context, 200.0f);
        this.mFc = a.dp2px(context, 140.0f);
        this.mFf = 0;
        this.mFg = false;
        this.mFh = null;
        this.mFi = null;
        this.mFj = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mFk = 1000;
        this.mFl = false;
        this.mFm = 0;
        this.mFn = false;
        this.mET = a.dp2px(context, 2.0f);
        this.lgL = null;
        this.mFq = a.h(context, 14.0f);
        this.mFr = -1;
        this.mFs = false;
        this.mFt = a.dp2px(context, 20.0f);
        this.mFu = false;
        this.mFv = Color.parseColor("#22000000");
        this.mFw = false;
        this.mFx = false;
        this.mFy = false;
        this.mEY = new TextPaint();
        this.mEY.setAntiAlias(true);
        this.mFJ = a.dp2px(context, 4.0f);
        this.mFK = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mFL = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dEu();
        dEt();
    }

    private void dEt() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mEZ;
        options.outHeight = this.mEZ;
        this.mEP = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mEQ = Bitmap.createBitmap(this.mEP, 0, 0, this.mEP.getWidth(), this.mEP.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mER = Bitmap.createBitmap(this.mEP, 0, 0, this.mEP.getWidth(), this.mEP.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mES = Bitmap.createBitmap(this.mEP, 0, 0, this.mEP.getWidth(), this.mEP.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mFa = typedArray.getDimensionPixelSize(i, this.mFa);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mEZ = typedArray.getDimensionPixelSize(i, this.mEZ);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mFd = typedArray.getDimensionPixelSize(i, this.mFd);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cyQ = typedArray.getDimensionPixelSize(i, this.cyQ);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mFe = typedArray.getColor(i, this.mFe);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mFf = typedArray.getDimensionPixelSize(i, this.mFf);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mFg = typedArray.getBoolean(i, this.mFg);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mFh = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mFj = typedArray.getDimensionPixelSize(i, this.mFj);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mFk = typedArray.getInteger(i, this.mFk);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mFl = typedArray.getBoolean(i, this.mFl);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mFm = typedArray.getDimensionPixelSize(i, this.mFm);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mFc = typedArray.getDimensionPixelSize(i, this.mFc);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mFn = typedArray.getBoolean(i, this.mFn);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mFp = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mFo = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mFq = typedArray.getDimensionPixelSize(i, this.mFq);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mFr = typedArray.getColor(i, this.mFr);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mFs = typedArray.getBoolean(i, this.mFs);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mFt = typedArray.getDimensionPixelSize(i, this.mFt);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mFu = typedArray.getBoolean(i, this.mFu);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mFw = typedArray.getBoolean(i, this.mFw);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mFv = typedArray.getColor(i, this.mFv);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mFx = typedArray.getBoolean(i, this.mFx);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mFy = typedArray.getBoolean(i, this.mFy);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mFz = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mFK = typedArray.getBoolean(i, this.mFK);
        }
    }

    private void dEu() {
        if (this.mFz != null) {
            this.mFF = ((BitmapDrawable) this.mFz).getBitmap();
        }
        if (this.mFF == null) {
            this.mFF = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mFF = a.g(this.mFF, this.mFe);
        }
        this.mFG = a.f(this.mFF, 90);
        this.mFG = a.f(this.mFG, 90);
        this.mFG = a.f(this.mFG, 90);
        if (this.mFh != null) {
            this.mFD = ((BitmapDrawable) this.mFh).getBitmap();
        }
        if (this.mFD == null) {
            this.mFD = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mFD = a.g(this.mFD, this.mFe);
        }
        this.mFE = a.f(this.mFD, 90);
        this.mFH = (1.0f * this.mFa) / 2.0f;
        this.mEY.setTextSize(this.mFq);
        this.mEY.setColor(this.mFr);
        setIsBarcode(this.mFn);
    }

    public void dEv() {
        this.mEY.setColor(this.mFr);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mEV != null) {
            ai(canvas);
            aj(canvas);
            al(canvas);
            am(canvas);
            ak(canvas);
            dEw();
        }
    }

    private void ai(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mEV.top, this.mPaint);
            canvas.drawRect(0.0f, this.mEV.top, this.mEV.left, this.mEV.bottom + 1, this.mPaint);
            canvas.drawRect(this.mEV.right + 1, this.mEV.top, width, this.mEV.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mEV.bottom + 1, width, height, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (this.mFj > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mFj);
            canvas.drawRect(this.mEV, this.mPaint);
        }
    }

    private void ak(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mEP, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mEQ, getMainFrameRight() - this.mEP.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mER, getMainFrameLeft(), getMainFrameBottom() - this.mEP.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mES, getMainFrameRight() - this.mEP.getWidth(), getMainFrameBottom() - this.mEP.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mEV.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mEV.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mEV.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mEV.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mFj / 2;
    }

    private void al(Canvas canvas) {
        if (this.mFn) {
            if (this.mFA != null) {
                RectF rectF = new RectF(this.mEV.left + this.mFH + 0.5f, this.mEV.top + this.mFH + this.mFf, this.mFC, (this.mEV.bottom - this.mFH) - this.mFf);
                Rect rect = new Rect((int) (this.mFA.getWidth() - rectF.width()), 0, this.mFA.getWidth(), this.mFA.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mFA, rect, rectF, this.mPaint);
            } else if (this.mFi != null) {
                canvas.drawBitmap(this.mFi, (Rect) null, new RectF(this.mEX, this.mEV.top + this.mFH + this.mFf, this.mEX + this.mFi.getWidth(), (this.mEV.bottom - this.mFH) - this.mFf), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mFe);
                canvas.drawRect(this.mEX, this.mFf + this.mEV.top + this.mFH, this.mFd + this.mEX, (this.mEV.bottom - this.mFH) - this.mFf, this.mPaint);
            }
        } else if (this.mFA != null) {
            RectF rectF2 = new RectF(this.mEV.left + this.mFH + this.mFf, this.mEV.top + this.mFH + 0.5f, (this.mEV.right - this.mFH) - this.mFf, this.mFB);
            Rect rect2 = new Rect(0, (int) (this.mFA.getHeight() - rectF2.height()), this.mFA.getWidth(), this.mFA.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mFL);
            canvas.drawBitmap(this.mFA, rect2, rectF2, this.mPaint);
        } else if (this.mFi != null) {
            canvas.drawBitmap(this.mFi, (Rect) null, new RectF(this.mEV.left + this.mFH + this.mFf, this.mEW, (this.mEV.right - this.mFH) - this.mFf, this.mEW + this.mFi.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mFe);
            canvas.drawRect(this.mFf + this.mEV.left + this.mFH, this.mEW, (this.mEV.right - this.mFH) - this.mFf, this.mFd + this.mEW, this.mPaint);
        }
    }

    private void am(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lgL) && this.mFI != null) {
            if (this.mFs) {
                if (this.mFw) {
                    this.mPaint.setColor(this.mFv);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mFu) {
                        Rect rect = new Rect();
                        this.mEY.getTextBounds(this.lgL, 0, this.lgL.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mFJ;
                        canvas.drawRoundRect(new RectF(width, (this.mEV.bottom + this.mFt) - this.mFJ, rect.width() + width + (this.mFJ * 2), this.mEV.bottom + this.mFt + this.mFI.getHeight() + this.mFJ), this.mFJ, this.mFJ, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mEV.left, (this.mEV.bottom + this.mFt) - this.mFJ, this.mEV.right, this.mEV.bottom + this.mFt + this.mFI.getHeight() + this.mFJ), this.mFJ, this.mFJ, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mFu) {
                    canvas.translate(0.0f, this.mEV.bottom + this.mFt);
                } else {
                    canvas.translate(this.mEV.left + this.mFJ, this.mEV.bottom + this.mFt);
                }
                this.mFI.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mFw) {
                this.mPaint.setColor(this.mFv);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mFu) {
                    Rect rect2 = new Rect();
                    this.mEY.getTextBounds(this.lgL, 0, this.lgL.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mFJ;
                    canvas.drawRoundRect(new RectF(width2, ((this.mEV.top - this.mFt) - this.mFI.getHeight()) - this.mFJ, rect2.width() + width2 + (this.mFJ * 2), (this.mEV.top - this.mFt) + this.mFJ), this.mFJ, this.mFJ, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mEV.left, ((this.mEV.top - this.mFt) - this.mFI.getHeight()) - this.mFJ, this.mEV.right, (this.mEV.top - this.mFt) + this.mFJ), this.mFJ, this.mFJ, this.mPaint);
                }
            }
            canvas.save();
            if (this.mFu) {
                canvas.translate(0.0f, (this.mEV.top - this.mFt) - this.mFI.getHeight());
            } else {
                canvas.translate(this.mEV.left + this.mFJ, (this.mEV.top - this.mFt) - this.mFI.getHeight());
            }
            this.mFI.draw(canvas);
            canvas.restore();
        }
    }

    private void dEw() {
        if (this.mFn) {
            if (this.mFA == null) {
                this.mEX += this.mET;
                int i = this.mFd;
                if (this.mFi != null) {
                    i = this.mFi.getWidth();
                }
                if (this.mFx) {
                    if (i + this.mEX > this.mEV.right - this.mFH || this.mEX < this.mEV.left + this.mFH) {
                        this.mET = -this.mET;
                    }
                } else {
                    if (i + this.mEX > this.mEV.right - this.mFH) {
                        this.mEX = this.mEV.left + this.mFH + 0.5f;
                    }
                }
            } else {
                this.mFC += this.mET;
                if (this.mFC > this.mEV.right - this.mFH) {
                    this.mFC = this.mEV.left + this.mFH + 0.5f;
                }
            }
        } else if (this.mFA == null) {
            this.mEW += this.mET;
            int i2 = this.mFd;
            if (this.mFi != null) {
                i2 = this.mFi.getHeight();
            }
            if (this.mFx) {
                if (i2 + this.mEW > this.mEV.bottom - this.mFH || this.mEW < this.mEV.top + this.mFH) {
                    this.mET = -this.mET;
                }
            } else {
                if (i2 + this.mEW > this.mEV.bottom - this.mFH) {
                    this.mEW = this.mEV.top + this.mFH + 0.5f;
                }
            }
        } else {
            this.mFB += this.mET;
            if (this.mFB > this.mEV.bottom - this.mFH) {
                this.mFB = this.mEV.top + this.mFH + 0.5f;
            }
        }
        postInvalidateDelayed(this.mEU, this.mEV.left, this.mEV.top, this.mEV.right, this.mEV.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dEx();
    }

    private void dEx() {
        int i;
        if (this.mFn) {
            i = this.mTopOffset + this.mFm;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cyQ) / 2;
        this.mEV = new Rect(width, i, this.cyQ + width, this.mFb + i);
        if (this.mFn) {
            float f = this.mEV.left + this.mFH + 0.5f;
            this.mEX = f;
            this.mFC = f;
            return;
        }
        float f2 = this.mEV.top + this.mFH + 0.5f;
        this.mEW = f2;
        this.mFB = f2;
    }

    public Rect Jb(int i) {
        if (this.mFK) {
            Rect rect = new Rect(this.mEV);
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
        this.mFn = z;
        if (this.mFz != null || this.mFy) {
            if (this.mFn) {
                this.mFA = this.mFG;
            } else {
                this.mFA = this.mFF;
            }
        } else if (this.mFh != null || this.mFg) {
            if (this.mFn) {
                this.mFi = this.mFE;
            } else {
                this.mFi = this.mFD;
            }
        }
        if (this.mFn) {
            this.lgL = this.mFp;
            this.mFb = this.mFc;
            this.mEU = (int) (((this.mFk * 1.0f) * this.mET) / this.cyQ);
        } else {
            this.lgL = this.mFo;
            this.mFb = this.cyQ;
            this.mEU = (int) (((this.mFk * 1.0f) * this.mET) / this.mFb);
        }
        if (!TextUtils.isEmpty(this.lgL)) {
            if (this.mFu) {
                this.mFI = new StaticLayout(this.lgL, this.mEY, a.gt(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mFI = new StaticLayout(this.lgL, this.mEY, this.cyQ - (this.mFJ * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mFl) {
            int i = a.gt(getContext()).y;
            if (this.mFm == 0) {
                this.mTopOffset = (i - this.mFb) / 2;
            } else if (this.mFn) {
                this.mTopOffset = ((i - this.mFb) / 2) + (this.mFm / 2);
            } else {
                this.mTopOffset = (i - this.mFb) / 2;
            }
        }
        dEx();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mFn;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mEZ;
    }

    public void setCornerLength(int i) {
        this.mEZ = i;
    }

    public int getCornerSize() {
        return this.mFa;
    }

    public void setCornerSize(int i) {
        this.mFa = i;
    }

    public int getRectWidth() {
        return this.cyQ;
    }

    public void setRectWidth(int i) {
        this.cyQ = i;
    }

    public int getRectHeight() {
        return this.mFb;
    }

    public void setRectHeight(int i) {
        this.mFb = i;
    }

    public int getBarcodeRectHeight() {
        return this.mFc;
    }

    public void setBarcodeRectHeight(int i) {
        this.mFc = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mFd;
    }

    public void setScanLineSize(int i) {
        this.mFd = i;
    }

    public int getScanLineColor() {
        return this.mFe;
    }

    public void setScanLineColor(int i) {
        this.mFe = i;
    }

    public int getScanLineMargin() {
        return this.mFf;
    }

    public void setScanLineMargin(int i) {
        this.mFf = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mFg = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mFh;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mFh = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mFi;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mFi = bitmap;
    }

    public int getBorderSize() {
        return this.mFj;
    }

    public void setBorderSize(int i) {
        this.mFj = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mFk;
    }

    public void setAnimTime(int i) {
        this.mFk = i;
    }

    public void setCenterVertical(boolean z) {
        this.mFl = z;
    }

    public int getToolbarHeight() {
        return this.mFm;
    }

    public void setToolbarHeight(int i) {
        this.mFm = i;
    }

    public String getQRCodeTipText() {
        return this.mFo;
    }

    public void setQRCodeTipText(String str) {
        this.mFo = str;
    }

    public String getBarCodeTipText() {
        return this.mFp;
    }

    public void setBarCodeTipText(String str) {
        this.mFp = str;
    }

    public String getTipText() {
        return this.lgL;
    }

    public void setTipText(String str) {
        this.lgL = str;
    }

    public int getTipTextColor() {
        return this.mFr;
    }

    public void setTipTextColor(int i) {
        this.mFr = i;
    }

    public int getTipTextSize() {
        return this.mFq;
    }

    public void setTipTextSize(int i) {
        this.mFq = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mFs = z;
    }

    public int getTipTextMargin() {
        return this.mFt;
    }

    public void setTipTextMargin(int i) {
        this.mFt = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mFu = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mFw = z;
    }

    public int getTipBackgroundColor() {
        return this.mFv;
    }

    public void setTipBackgroundColor(int i) {
        this.mFv = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mFx = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mFy = z;
    }

    public float getHalfCornerSize() {
        return this.mFH;
    }

    public void setHalfCornerSize(float f) {
        this.mFH = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mFI;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mFI = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mFJ;
    }

    public void setTipBackgroundRadius(int i) {
        this.mFJ = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mFK = z;
    }
}
