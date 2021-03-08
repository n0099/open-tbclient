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
/* loaded from: classes7.dex */
public class ScanBoxView extends View {
    private int cCT;
    private String lsj;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private Bitmap mQW;
    private Bitmap mQX;
    private Bitmap mQY;
    private Bitmap mQZ;
    private int mRA;
    private boolean mRB;
    private int mRC;
    private boolean mRD;
    private boolean mRE;
    private boolean mRF;
    private Drawable mRG;
    private Bitmap mRH;
    private float mRI;
    private float mRJ;
    private Bitmap mRK;
    private Bitmap mRL;
    private Bitmap mRM;
    private Bitmap mRN;
    private float mRO;
    private StaticLayout mRP;
    private int mRQ;
    private boolean mRR;
    private ColorMatrixColorFilter mRS;
    private int mRa;
    private int mRb;
    private Rect mRc;
    private float mRd;
    private float mRe;
    private TextPaint mRf;
    private int mRg;
    private int mRh;
    private int mRi;
    private int mRj;
    private int mRk;
    private int mRl;
    private int mRm;
    private boolean mRn;
    private Drawable mRo;
    private Bitmap mRp;
    private int mRq;
    private int mRr;
    private boolean mRs;
    private int mRt;
    private boolean mRu;
    private String mRv;
    private String mRw;
    private int mRx;
    private int mRy;
    private boolean mRz;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mRg = a.dp2px(context, 20.0f);
        this.mRh = a.dp2px(context, 3.0f);
        this.mRk = a.dp2px(context, 1.0f);
        this.mRl = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cCT = a.dp2px(context, 200.0f);
        this.mRj = a.dp2px(context, 140.0f);
        this.mRm = 0;
        this.mRn = false;
        this.mRo = null;
        this.mRp = null;
        this.mRq = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mRr = 1000;
        this.mRs = false;
        this.mRt = 0;
        this.mRu = false;
        this.mRa = a.dp2px(context, 2.0f);
        this.lsj = null;
        this.mRx = a.h(context, 14.0f);
        this.mRy = -1;
        this.mRz = false;
        this.mRA = a.dp2px(context, 20.0f);
        this.mRB = false;
        this.mRC = Color.parseColor("#22000000");
        this.mRD = false;
        this.mRE = false;
        this.mRF = false;
        this.mRf = new TextPaint();
        this.mRf.setAntiAlias(true);
        this.mRQ = a.dp2px(context, 4.0f);
        this.mRR = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mRS = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dCS();
        dCR();
    }

    private void dCR() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mRg;
        options.outHeight = this.mRg;
        this.mQW = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mQX = Bitmap.createBitmap(this.mQW, 0, 0, this.mQW.getWidth(), this.mQW.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mQY = Bitmap.createBitmap(this.mQW, 0, 0, this.mQW.getWidth(), this.mQW.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mQZ = Bitmap.createBitmap(this.mQW, 0, 0, this.mQW.getWidth(), this.mQW.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mRh = typedArray.getDimensionPixelSize(i, this.mRh);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mRg = typedArray.getDimensionPixelSize(i, this.mRg);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mRk = typedArray.getDimensionPixelSize(i, this.mRk);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cCT = typedArray.getDimensionPixelSize(i, this.cCT);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mRl = typedArray.getColor(i, this.mRl);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mRm = typedArray.getDimensionPixelSize(i, this.mRm);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mRn = typedArray.getBoolean(i, this.mRn);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mRo = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mRq = typedArray.getDimensionPixelSize(i, this.mRq);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mRr = typedArray.getInteger(i, this.mRr);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mRs = typedArray.getBoolean(i, this.mRs);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mRt = typedArray.getDimensionPixelSize(i, this.mRt);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mRj = typedArray.getDimensionPixelSize(i, this.mRj);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mRu = typedArray.getBoolean(i, this.mRu);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mRw = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mRv = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mRx = typedArray.getDimensionPixelSize(i, this.mRx);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mRy = typedArray.getColor(i, this.mRy);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mRz = typedArray.getBoolean(i, this.mRz);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mRA = typedArray.getDimensionPixelSize(i, this.mRA);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mRB = typedArray.getBoolean(i, this.mRB);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mRD = typedArray.getBoolean(i, this.mRD);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mRC = typedArray.getColor(i, this.mRC);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mRE = typedArray.getBoolean(i, this.mRE);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mRF = typedArray.getBoolean(i, this.mRF);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mRG = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mRR = typedArray.getBoolean(i, this.mRR);
        }
    }

    private void dCS() {
        if (this.mRG != null) {
            this.mRM = ((BitmapDrawable) this.mRG).getBitmap();
        }
        if (this.mRM == null) {
            this.mRM = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mRM = a.g(this.mRM, this.mRl);
        }
        this.mRN = a.f(this.mRM, 90);
        this.mRN = a.f(this.mRN, 90);
        this.mRN = a.f(this.mRN, 90);
        if (this.mRo != null) {
            this.mRK = ((BitmapDrawable) this.mRo).getBitmap();
        }
        if (this.mRK == null) {
            this.mRK = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mRK = a.g(this.mRK, this.mRl);
        }
        this.mRL = a.f(this.mRK, 90);
        this.mRO = (1.0f * this.mRh) / 2.0f;
        this.mRf.setTextSize(this.mRx);
        this.mRf.setColor(this.mRy);
        setIsBarcode(this.mRu);
    }

    public void dCT() {
        this.mRf.setColor(this.mRy);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mRc != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dCU();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mRc.top, this.mPaint);
            canvas.drawRect(0.0f, this.mRc.top, this.mRc.left, this.mRc.bottom + 1, this.mPaint);
            canvas.drawRect(this.mRc.right + 1, this.mRc.top, width, this.mRc.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mRc.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mRq > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mRq);
            canvas.drawRect(this.mRc, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mQW, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mQX, getMainFrameRight() - this.mQW.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mQY, getMainFrameLeft(), getMainFrameBottom() - this.mQW.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mQZ, getMainFrameRight() - this.mQW.getWidth(), getMainFrameBottom() - this.mQW.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mRc.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mRc.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mRc.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mRc.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mRq / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mRu) {
            if (this.mRH != null) {
                RectF rectF = new RectF(this.mRc.left + this.mRO + 0.5f, this.mRc.top + this.mRO + this.mRm, this.mRJ, (this.mRc.bottom - this.mRO) - this.mRm);
                Rect rect = new Rect((int) (this.mRH.getWidth() - rectF.width()), 0, this.mRH.getWidth(), this.mRH.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mRH, rect, rectF, this.mPaint);
            } else if (this.mRp != null) {
                canvas.drawBitmap(this.mRp, (Rect) null, new RectF(this.mRe, this.mRc.top + this.mRO + this.mRm, this.mRe + this.mRp.getWidth(), (this.mRc.bottom - this.mRO) - this.mRm), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mRl);
                canvas.drawRect(this.mRe, this.mRm + this.mRc.top + this.mRO, this.mRk + this.mRe, (this.mRc.bottom - this.mRO) - this.mRm, this.mPaint);
            }
        } else if (this.mRH != null) {
            RectF rectF2 = new RectF(this.mRc.left + this.mRO + this.mRm, this.mRc.top + this.mRO + 0.5f, (this.mRc.right - this.mRO) - this.mRm, this.mRI);
            Rect rect2 = new Rect(0, (int) (this.mRH.getHeight() - rectF2.height()), this.mRH.getWidth(), this.mRH.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mRS);
            canvas.drawBitmap(this.mRH, rect2, rectF2, this.mPaint);
        } else if (this.mRp != null) {
            canvas.drawBitmap(this.mRp, (Rect) null, new RectF(this.mRc.left + this.mRO + this.mRm, this.mRd, (this.mRc.right - this.mRO) - this.mRm, this.mRd + this.mRp.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mRl);
            canvas.drawRect(this.mRm + this.mRc.left + this.mRO, this.mRd, (this.mRc.right - this.mRO) - this.mRm, this.mRk + this.mRd, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lsj) && this.mRP != null) {
            if (this.mRz) {
                if (this.mRD) {
                    this.mPaint.setColor(this.mRC);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mRB) {
                        Rect rect = new Rect();
                        this.mRf.getTextBounds(this.lsj, 0, this.lsj.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mRQ;
                        canvas.drawRoundRect(new RectF(width, (this.mRc.bottom + this.mRA) - this.mRQ, rect.width() + width + (this.mRQ * 2), this.mRc.bottom + this.mRA + this.mRP.getHeight() + this.mRQ), this.mRQ, this.mRQ, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mRc.left, (this.mRc.bottom + this.mRA) - this.mRQ, this.mRc.right, this.mRc.bottom + this.mRA + this.mRP.getHeight() + this.mRQ), this.mRQ, this.mRQ, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mRB) {
                    canvas.translate(0.0f, this.mRc.bottom + this.mRA);
                } else {
                    canvas.translate(this.mRc.left + this.mRQ, this.mRc.bottom + this.mRA);
                }
                this.mRP.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mRD) {
                this.mPaint.setColor(this.mRC);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mRB) {
                    Rect rect2 = new Rect();
                    this.mRf.getTextBounds(this.lsj, 0, this.lsj.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mRQ;
                    canvas.drawRoundRect(new RectF(width2, ((this.mRc.top - this.mRA) - this.mRP.getHeight()) - this.mRQ, rect2.width() + width2 + (this.mRQ * 2), (this.mRc.top - this.mRA) + this.mRQ), this.mRQ, this.mRQ, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mRc.left, ((this.mRc.top - this.mRA) - this.mRP.getHeight()) - this.mRQ, this.mRc.right, (this.mRc.top - this.mRA) + this.mRQ), this.mRQ, this.mRQ, this.mPaint);
                }
            }
            canvas.save();
            if (this.mRB) {
                canvas.translate(0.0f, (this.mRc.top - this.mRA) - this.mRP.getHeight());
            } else {
                canvas.translate(this.mRc.left + this.mRQ, (this.mRc.top - this.mRA) - this.mRP.getHeight());
            }
            this.mRP.draw(canvas);
            canvas.restore();
        }
    }

    private void dCU() {
        if (this.mRu) {
            if (this.mRH == null) {
                this.mRe += this.mRa;
                int i = this.mRk;
                if (this.mRp != null) {
                    i = this.mRp.getWidth();
                }
                if (this.mRE) {
                    if (i + this.mRe > this.mRc.right - this.mRO || this.mRe < this.mRc.left + this.mRO) {
                        this.mRa = -this.mRa;
                    }
                } else {
                    if (i + this.mRe > this.mRc.right - this.mRO) {
                        this.mRe = this.mRc.left + this.mRO + 0.5f;
                    }
                }
            } else {
                this.mRJ += this.mRa;
                if (this.mRJ > this.mRc.right - this.mRO) {
                    this.mRJ = this.mRc.left + this.mRO + 0.5f;
                }
            }
        } else if (this.mRH == null) {
            this.mRd += this.mRa;
            int i2 = this.mRk;
            if (this.mRp != null) {
                i2 = this.mRp.getHeight();
            }
            if (this.mRE) {
                if (i2 + this.mRd > this.mRc.bottom - this.mRO || this.mRd < this.mRc.top + this.mRO) {
                    this.mRa = -this.mRa;
                }
            } else {
                if (i2 + this.mRd > this.mRc.bottom - this.mRO) {
                    this.mRd = this.mRc.top + this.mRO + 0.5f;
                }
            }
        } else {
            this.mRI += this.mRa;
            if (this.mRI > this.mRc.bottom - this.mRO) {
                this.mRI = this.mRc.top + this.mRO + 0.5f;
            }
        }
        postInvalidateDelayed(this.mRb, this.mRc.left, this.mRc.top, this.mRc.right, this.mRc.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dCV();
    }

    private void dCV() {
        int i;
        if (this.mRu) {
            i = this.mTopOffset + this.mRt;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cCT) / 2;
        this.mRc = new Rect(width, i, this.cCT + width, this.mRi + i);
        if (this.mRu) {
            float f = this.mRc.left + this.mRO + 0.5f;
            this.mRe = f;
            this.mRJ = f;
            return;
        }
        float f2 = this.mRc.top + this.mRO + 0.5f;
        this.mRd = f2;
        this.mRI = f2;
    }

    public Rect HJ(int i) {
        if (this.mRR) {
            Rect rect = new Rect(this.mRc);
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
        this.mRu = z;
        if (this.mRG != null || this.mRF) {
            if (this.mRu) {
                this.mRH = this.mRN;
            } else {
                this.mRH = this.mRM;
            }
        } else if (this.mRo != null || this.mRn) {
            if (this.mRu) {
                this.mRp = this.mRL;
            } else {
                this.mRp = this.mRK;
            }
        }
        if (this.mRu) {
            this.lsj = this.mRw;
            this.mRi = this.mRj;
            this.mRb = (int) (((this.mRr * 1.0f) * this.mRa) / this.cCT);
        } else {
            this.lsj = this.mRv;
            this.mRi = this.cCT;
            this.mRb = (int) (((this.mRr * 1.0f) * this.mRa) / this.mRi);
        }
        if (!TextUtils.isEmpty(this.lsj)) {
            if (this.mRB) {
                this.mRP = new StaticLayout(this.lsj, this.mRf, a.gM(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mRP = new StaticLayout(this.lsj, this.mRf, this.cCT - (this.mRQ * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mRs) {
            int i = a.gM(getContext()).y;
            if (this.mRt == 0) {
                this.mTopOffset = (i - this.mRi) / 2;
            } else if (this.mRu) {
                this.mTopOffset = ((i - this.mRi) / 2) + (this.mRt / 2);
            } else {
                this.mTopOffset = (i - this.mRi) / 2;
            }
        }
        dCV();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mRu;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mRg;
    }

    public void setCornerLength(int i) {
        this.mRg = i;
    }

    public int getCornerSize() {
        return this.mRh;
    }

    public void setCornerSize(int i) {
        this.mRh = i;
    }

    public int getRectWidth() {
        return this.cCT;
    }

    public void setRectWidth(int i) {
        this.cCT = i;
    }

    public int getRectHeight() {
        return this.mRi;
    }

    public void setRectHeight(int i) {
        this.mRi = i;
    }

    public int getBarcodeRectHeight() {
        return this.mRj;
    }

    public void setBarcodeRectHeight(int i) {
        this.mRj = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mRk;
    }

    public void setScanLineSize(int i) {
        this.mRk = i;
    }

    public int getScanLineColor() {
        return this.mRl;
    }

    public void setScanLineColor(int i) {
        this.mRl = i;
    }

    public int getScanLineMargin() {
        return this.mRm;
    }

    public void setScanLineMargin(int i) {
        this.mRm = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mRn = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mRo;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mRo = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mRp;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mRp = bitmap;
    }

    public int getBorderSize() {
        return this.mRq;
    }

    public void setBorderSize(int i) {
        this.mRq = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mRr;
    }

    public void setAnimTime(int i) {
        this.mRr = i;
    }

    public void setCenterVertical(boolean z) {
        this.mRs = z;
    }

    public int getToolbarHeight() {
        return this.mRt;
    }

    public void setToolbarHeight(int i) {
        this.mRt = i;
    }

    public String getQRCodeTipText() {
        return this.mRv;
    }

    public void setQRCodeTipText(String str) {
        this.mRv = str;
    }

    public String getBarCodeTipText() {
        return this.mRw;
    }

    public void setBarCodeTipText(String str) {
        this.mRw = str;
    }

    public String getTipText() {
        return this.lsj;
    }

    public void setTipText(String str) {
        this.lsj = str;
    }

    public int getTipTextColor() {
        return this.mRy;
    }

    public void setTipTextColor(int i) {
        this.mRy = i;
    }

    public int getTipTextSize() {
        return this.mRx;
    }

    public void setTipTextSize(int i) {
        this.mRx = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mRz = z;
    }

    public int getTipTextMargin() {
        return this.mRA;
    }

    public void setTipTextMargin(int i) {
        this.mRA = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mRB = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mRD = z;
    }

    public int getTipBackgroundColor() {
        return this.mRC;
    }

    public void setTipBackgroundColor(int i) {
        this.mRC = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mRE = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mRF = z;
    }

    public float getHalfCornerSize() {
        return this.mRO;
    }

    public void setHalfCornerSize(float f) {
        this.mRO = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mRP;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mRP = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mRQ;
    }

    public void setTipBackgroundRadius(int i) {
        this.mRQ = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mRR = z;
    }
}
