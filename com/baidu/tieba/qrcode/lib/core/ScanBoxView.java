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
    private int cyX;
    private String lhM;
    private int mBorderColor;
    private Context mContext;
    private Bitmap mFA;
    private Bitmap mFB;
    private int mFC;
    private int mFD;
    private Rect mFE;
    private float mFF;
    private float mFG;
    private TextPaint mFH;
    private int mFI;
    private int mFJ;
    private int mFK;
    private int mFL;
    private int mFM;
    private int mFN;
    private int mFO;
    private boolean mFP;
    private Drawable mFQ;
    private Bitmap mFR;
    private int mFS;
    private int mFT;
    private boolean mFU;
    private int mFV;
    private boolean mFW;
    private String mFX;
    private String mFY;
    private int mFZ;
    private Bitmap mFy;
    private Bitmap mFz;
    private int mGa;
    private boolean mGb;
    private int mGc;
    private boolean mGd;
    private int mGe;
    private boolean mGf;
    private boolean mGg;
    private boolean mGh;
    private Drawable mGi;
    private Bitmap mGj;
    private float mGk;
    private float mGm;
    private Bitmap mGn;
    private Bitmap mGo;
    private Bitmap mGp;
    private Bitmap mGq;
    private float mGr;
    private StaticLayout mGs;
    private int mGt;
    private boolean mGu;
    private ColorMatrixColorFilter mGv;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mFI = a.dp2px(context, 20.0f);
        this.mFJ = a.dp2px(context, 3.0f);
        this.mFM = a.dp2px(context, 1.0f);
        this.mFN = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cyX = a.dp2px(context, 200.0f);
        this.mFL = a.dp2px(context, 140.0f);
        this.mFO = 0;
        this.mFP = false;
        this.mFQ = null;
        this.mFR = null;
        this.mFS = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mFT = 1000;
        this.mFU = false;
        this.mFV = 0;
        this.mFW = false;
        this.mFC = a.dp2px(context, 2.0f);
        this.lhM = null;
        this.mFZ = a.h(context, 14.0f);
        this.mGa = -1;
        this.mGb = false;
        this.mGc = a.dp2px(context, 20.0f);
        this.mGd = false;
        this.mGe = Color.parseColor("#22000000");
        this.mGf = false;
        this.mGg = false;
        this.mGh = false;
        this.mFH = new TextPaint();
        this.mFH.setAntiAlias(true);
        this.mGt = a.dp2px(context, 4.0f);
        this.mGu = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mGv = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dAt();
        dAs();
    }

    private void dAs() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mFI;
        options.outHeight = this.mFI;
        this.mFy = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mFz = Bitmap.createBitmap(this.mFy, 0, 0, this.mFy.getWidth(), this.mFy.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mFA = Bitmap.createBitmap(this.mFy, 0, 0, this.mFy.getWidth(), this.mFy.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mFB = Bitmap.createBitmap(this.mFy, 0, 0, this.mFy.getWidth(), this.mFy.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mFJ = typedArray.getDimensionPixelSize(i, this.mFJ);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mFI = typedArray.getDimensionPixelSize(i, this.mFI);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mFM = typedArray.getDimensionPixelSize(i, this.mFM);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cyX = typedArray.getDimensionPixelSize(i, this.cyX);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mFN = typedArray.getColor(i, this.mFN);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mFO = typedArray.getDimensionPixelSize(i, this.mFO);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mFP = typedArray.getBoolean(i, this.mFP);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mFQ = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mFS = typedArray.getDimensionPixelSize(i, this.mFS);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mFT = typedArray.getInteger(i, this.mFT);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mFU = typedArray.getBoolean(i, this.mFU);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mFV = typedArray.getDimensionPixelSize(i, this.mFV);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mFL = typedArray.getDimensionPixelSize(i, this.mFL);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mFW = typedArray.getBoolean(i, this.mFW);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mFY = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mFX = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mFZ = typedArray.getDimensionPixelSize(i, this.mFZ);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mGa = typedArray.getColor(i, this.mGa);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mGb = typedArray.getBoolean(i, this.mGb);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mGc = typedArray.getDimensionPixelSize(i, this.mGc);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mGd = typedArray.getBoolean(i, this.mGd);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mGf = typedArray.getBoolean(i, this.mGf);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mGe = typedArray.getColor(i, this.mGe);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mGg = typedArray.getBoolean(i, this.mGg);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mGh = typedArray.getBoolean(i, this.mGh);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mGi = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mGu = typedArray.getBoolean(i, this.mGu);
        }
    }

    private void dAt() {
        if (this.mGi != null) {
            this.mGp = ((BitmapDrawable) this.mGi).getBitmap();
        }
        if (this.mGp == null) {
            this.mGp = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mGp = a.g(this.mGp, this.mFN);
        }
        this.mGq = a.f(this.mGp, 90);
        this.mGq = a.f(this.mGq, 90);
        this.mGq = a.f(this.mGq, 90);
        if (this.mFQ != null) {
            this.mGn = ((BitmapDrawable) this.mFQ).getBitmap();
        }
        if (this.mGn == null) {
            this.mGn = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mGn = a.g(this.mGn, this.mFN);
        }
        this.mGo = a.f(this.mGn, 90);
        this.mGr = (1.0f * this.mFJ) / 2.0f;
        this.mFH.setTextSize(this.mFZ);
        this.mFH.setColor(this.mGa);
        setIsBarcode(this.mFW);
    }

    public void dAu() {
        this.mFH.setColor(this.mGa);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mFE != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dAv();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mFE.top, this.mPaint);
            canvas.drawRect(0.0f, this.mFE.top, this.mFE.left, this.mFE.bottom + 1, this.mPaint);
            canvas.drawRect(this.mFE.right + 1, this.mFE.top, width, this.mFE.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mFE.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mFS > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mFS);
            canvas.drawRect(this.mFE, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mFy, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mFz, getMainFrameRight() - this.mFy.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mFA, getMainFrameLeft(), getMainFrameBottom() - this.mFy.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mFB, getMainFrameRight() - this.mFy.getWidth(), getMainFrameBottom() - this.mFy.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mFE.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mFE.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mFE.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mFE.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mFS / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mFW) {
            if (this.mGj != null) {
                RectF rectF = new RectF(this.mFE.left + this.mGr + 0.5f, this.mFE.top + this.mGr + this.mFO, this.mGm, (this.mFE.bottom - this.mGr) - this.mFO);
                Rect rect = new Rect((int) (this.mGj.getWidth() - rectF.width()), 0, this.mGj.getWidth(), this.mGj.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mGj, rect, rectF, this.mPaint);
            } else if (this.mFR != null) {
                canvas.drawBitmap(this.mFR, (Rect) null, new RectF(this.mFG, this.mFE.top + this.mGr + this.mFO, this.mFG + this.mFR.getWidth(), (this.mFE.bottom - this.mGr) - this.mFO), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mFN);
                canvas.drawRect(this.mFG, this.mFO + this.mFE.top + this.mGr, this.mFM + this.mFG, (this.mFE.bottom - this.mGr) - this.mFO, this.mPaint);
            }
        } else if (this.mGj != null) {
            RectF rectF2 = new RectF(this.mFE.left + this.mGr + this.mFO, this.mFE.top + this.mGr + 0.5f, (this.mFE.right - this.mGr) - this.mFO, this.mGk);
            Rect rect2 = new Rect(0, (int) (this.mGj.getHeight() - rectF2.height()), this.mGj.getWidth(), this.mGj.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mGv);
            canvas.drawBitmap(this.mGj, rect2, rectF2, this.mPaint);
        } else if (this.mFR != null) {
            canvas.drawBitmap(this.mFR, (Rect) null, new RectF(this.mFE.left + this.mGr + this.mFO, this.mFF, (this.mFE.right - this.mGr) - this.mFO, this.mFF + this.mFR.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mFN);
            canvas.drawRect(this.mFO + this.mFE.left + this.mGr, this.mFF, (this.mFE.right - this.mGr) - this.mFO, this.mFM + this.mFF, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lhM) && this.mGs != null) {
            if (this.mGb) {
                if (this.mGf) {
                    this.mPaint.setColor(this.mGe);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mGd) {
                        Rect rect = new Rect();
                        this.mFH.getTextBounds(this.lhM, 0, this.lhM.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mGt;
                        canvas.drawRoundRect(new RectF(width, (this.mFE.bottom + this.mGc) - this.mGt, rect.width() + width + (this.mGt * 2), this.mFE.bottom + this.mGc + this.mGs.getHeight() + this.mGt), this.mGt, this.mGt, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mFE.left, (this.mFE.bottom + this.mGc) - this.mGt, this.mFE.right, this.mFE.bottom + this.mGc + this.mGs.getHeight() + this.mGt), this.mGt, this.mGt, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mGd) {
                    canvas.translate(0.0f, this.mFE.bottom + this.mGc);
                } else {
                    canvas.translate(this.mFE.left + this.mGt, this.mFE.bottom + this.mGc);
                }
                this.mGs.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mGf) {
                this.mPaint.setColor(this.mGe);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mGd) {
                    Rect rect2 = new Rect();
                    this.mFH.getTextBounds(this.lhM, 0, this.lhM.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mGt;
                    canvas.drawRoundRect(new RectF(width2, ((this.mFE.top - this.mGc) - this.mGs.getHeight()) - this.mGt, rect2.width() + width2 + (this.mGt * 2), (this.mFE.top - this.mGc) + this.mGt), this.mGt, this.mGt, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mFE.left, ((this.mFE.top - this.mGc) - this.mGs.getHeight()) - this.mGt, this.mFE.right, (this.mFE.top - this.mGc) + this.mGt), this.mGt, this.mGt, this.mPaint);
                }
            }
            canvas.save();
            if (this.mGd) {
                canvas.translate(0.0f, (this.mFE.top - this.mGc) - this.mGs.getHeight());
            } else {
                canvas.translate(this.mFE.left + this.mGt, (this.mFE.top - this.mGc) - this.mGs.getHeight());
            }
            this.mGs.draw(canvas);
            canvas.restore();
        }
    }

    private void dAv() {
        if (this.mFW) {
            if (this.mGj == null) {
                this.mFG += this.mFC;
                int i = this.mFM;
                if (this.mFR != null) {
                    i = this.mFR.getWidth();
                }
                if (this.mGg) {
                    if (i + this.mFG > this.mFE.right - this.mGr || this.mFG < this.mFE.left + this.mGr) {
                        this.mFC = -this.mFC;
                    }
                } else {
                    if (i + this.mFG > this.mFE.right - this.mGr) {
                        this.mFG = this.mFE.left + this.mGr + 0.5f;
                    }
                }
            } else {
                this.mGm += this.mFC;
                if (this.mGm > this.mFE.right - this.mGr) {
                    this.mGm = this.mFE.left + this.mGr + 0.5f;
                }
            }
        } else if (this.mGj == null) {
            this.mFF += this.mFC;
            int i2 = this.mFM;
            if (this.mFR != null) {
                i2 = this.mFR.getHeight();
            }
            if (this.mGg) {
                if (i2 + this.mFF > this.mFE.bottom - this.mGr || this.mFF < this.mFE.top + this.mGr) {
                    this.mFC = -this.mFC;
                }
            } else {
                if (i2 + this.mFF > this.mFE.bottom - this.mGr) {
                    this.mFF = this.mFE.top + this.mGr + 0.5f;
                }
            }
        } else {
            this.mGk += this.mFC;
            if (this.mGk > this.mFE.bottom - this.mGr) {
                this.mGk = this.mFE.top + this.mGr + 0.5f;
            }
        }
        postInvalidateDelayed(this.mFD, this.mFE.left, this.mFE.top, this.mFE.right, this.mFE.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dAw();
    }

    private void dAw() {
        int i;
        if (this.mFW) {
            i = this.mTopOffset + this.mFV;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cyX) / 2;
        this.mFE = new Rect(width, i, this.cyX + width, this.mFK + i);
        if (this.mFW) {
            float f = this.mFE.left + this.mGr + 0.5f;
            this.mFG = f;
            this.mGm = f;
            return;
        }
        float f2 = this.mFE.top + this.mGr + 0.5f;
        this.mFF = f2;
        this.mGk = f2;
    }

    public Rect Ho(int i) {
        if (this.mGu) {
            Rect rect = new Rect(this.mFE);
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
        this.mFW = z;
        if (this.mGi != null || this.mGh) {
            if (this.mFW) {
                this.mGj = this.mGq;
            } else {
                this.mGj = this.mGp;
            }
        } else if (this.mFQ != null || this.mFP) {
            if (this.mFW) {
                this.mFR = this.mGo;
            } else {
                this.mFR = this.mGn;
            }
        }
        if (this.mFW) {
            this.lhM = this.mFY;
            this.mFK = this.mFL;
            this.mFD = (int) (((this.mFT * 1.0f) * this.mFC) / this.cyX);
        } else {
            this.lhM = this.mFX;
            this.mFK = this.cyX;
            this.mFD = (int) (((this.mFT * 1.0f) * this.mFC) / this.mFK);
        }
        if (!TextUtils.isEmpty(this.lhM)) {
            if (this.mGd) {
                this.mGs = new StaticLayout(this.lhM, this.mFH, a.gK(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mGs = new StaticLayout(this.lhM, this.mFH, this.cyX - (this.mGt * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mFU) {
            int i = a.gK(getContext()).y;
            if (this.mFV == 0) {
                this.mTopOffset = (i - this.mFK) / 2;
            } else if (this.mFW) {
                this.mTopOffset = ((i - this.mFK) / 2) + (this.mFV / 2);
            } else {
                this.mTopOffset = (i - this.mFK) / 2;
            }
        }
        dAw();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mFW;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mFI;
    }

    public void setCornerLength(int i) {
        this.mFI = i;
    }

    public int getCornerSize() {
        return this.mFJ;
    }

    public void setCornerSize(int i) {
        this.mFJ = i;
    }

    public int getRectWidth() {
        return this.cyX;
    }

    public void setRectWidth(int i) {
        this.cyX = i;
    }

    public int getRectHeight() {
        return this.mFK;
    }

    public void setRectHeight(int i) {
        this.mFK = i;
    }

    public int getBarcodeRectHeight() {
        return this.mFL;
    }

    public void setBarcodeRectHeight(int i) {
        this.mFL = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mFM;
    }

    public void setScanLineSize(int i) {
        this.mFM = i;
    }

    public int getScanLineColor() {
        return this.mFN;
    }

    public void setScanLineColor(int i) {
        this.mFN = i;
    }

    public int getScanLineMargin() {
        return this.mFO;
    }

    public void setScanLineMargin(int i) {
        this.mFO = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mFP = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mFQ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mFQ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mFR;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mFR = bitmap;
    }

    public int getBorderSize() {
        return this.mFS;
    }

    public void setBorderSize(int i) {
        this.mFS = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mFT;
    }

    public void setAnimTime(int i) {
        this.mFT = i;
    }

    public void setCenterVertical(boolean z) {
        this.mFU = z;
    }

    public int getToolbarHeight() {
        return this.mFV;
    }

    public void setToolbarHeight(int i) {
        this.mFV = i;
    }

    public String getQRCodeTipText() {
        return this.mFX;
    }

    public void setQRCodeTipText(String str) {
        this.mFX = str;
    }

    public String getBarCodeTipText() {
        return this.mFY;
    }

    public void setBarCodeTipText(String str) {
        this.mFY = str;
    }

    public String getTipText() {
        return this.lhM;
    }

    public void setTipText(String str) {
        this.lhM = str;
    }

    public int getTipTextColor() {
        return this.mGa;
    }

    public void setTipTextColor(int i) {
        this.mGa = i;
    }

    public int getTipTextSize() {
        return this.mFZ;
    }

    public void setTipTextSize(int i) {
        this.mFZ = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mGb = z;
    }

    public int getTipTextMargin() {
        return this.mGc;
    }

    public void setTipTextMargin(int i) {
        this.mGc = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mGd = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mGf = z;
    }

    public int getTipBackgroundColor() {
        return this.mGe;
    }

    public void setTipBackgroundColor(int i) {
        this.mGe = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mGg = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mGh = z;
    }

    public float getHalfCornerSize() {
        return this.mGr;
    }

    public void setHalfCornerSize(float f) {
        this.mGr = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mGs;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mGs = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mGt;
    }

    public void setTipBackgroundRadius(int i) {
        this.mGt = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mGu = z;
    }
}
