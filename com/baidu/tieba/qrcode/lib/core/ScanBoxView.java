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
    private String lgN;
    private int mBorderColor;
    private Context mContext;
    private Bitmap mER;
    private Bitmap mES;
    private Bitmap mET;
    private Bitmap mEU;
    private int mEV;
    private int mEW;
    private Rect mEX;
    private float mEY;
    private float mEZ;
    private boolean mFA;
    private Drawable mFB;
    private Bitmap mFC;
    private float mFD;
    private float mFE;
    private Bitmap mFF;
    private Bitmap mFG;
    private Bitmap mFH;
    private Bitmap mFI;
    private float mFJ;
    private StaticLayout mFK;
    private int mFL;
    private boolean mFM;
    private ColorMatrixColorFilter mFN;
    private TextPaint mFa;
    private int mFb;
    private int mFc;
    private int mFd;
    private int mFe;
    private int mFf;
    private int mFg;
    private int mFh;
    private boolean mFi;
    private Drawable mFj;
    private Bitmap mFk;
    private int mFl;
    private int mFm;
    private boolean mFn;
    private int mFo;
    private boolean mFp;
    private String mFq;
    private String mFr;
    private int mFs;
    private int mFt;
    private boolean mFu;
    private int mFv;
    private boolean mFw;
    private int mFx;
    private boolean mFy;
    private boolean mFz;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mFb = a.dp2px(context, 20.0f);
        this.mFc = a.dp2px(context, 3.0f);
        this.mFf = a.dp2px(context, 1.0f);
        this.mFg = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cyQ = a.dp2px(context, 200.0f);
        this.mFe = a.dp2px(context, 140.0f);
        this.mFh = 0;
        this.mFi = false;
        this.mFj = null;
        this.mFk = null;
        this.mFl = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mFm = 1000;
        this.mFn = false;
        this.mFo = 0;
        this.mFp = false;
        this.mEV = a.dp2px(context, 2.0f);
        this.lgN = null;
        this.mFs = a.h(context, 14.0f);
        this.mFt = -1;
        this.mFu = false;
        this.mFv = a.dp2px(context, 20.0f);
        this.mFw = false;
        this.mFx = Color.parseColor("#22000000");
        this.mFy = false;
        this.mFz = false;
        this.mFA = false;
        this.mFa = new TextPaint();
        this.mFa.setAntiAlias(true);
        this.mFL = a.dp2px(context, 4.0f);
        this.mFM = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mFN = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dEv();
        dEu();
    }

    private void dEu() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mFb;
        options.outHeight = this.mFb;
        this.mER = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mES = Bitmap.createBitmap(this.mER, 0, 0, this.mER.getWidth(), this.mER.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mET = Bitmap.createBitmap(this.mER, 0, 0, this.mER.getWidth(), this.mER.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mEU = Bitmap.createBitmap(this.mER, 0, 0, this.mER.getWidth(), this.mER.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mFc = typedArray.getDimensionPixelSize(i, this.mFc);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mFb = typedArray.getDimensionPixelSize(i, this.mFb);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mFf = typedArray.getDimensionPixelSize(i, this.mFf);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cyQ = typedArray.getDimensionPixelSize(i, this.cyQ);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mFg = typedArray.getColor(i, this.mFg);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mFh = typedArray.getDimensionPixelSize(i, this.mFh);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mFi = typedArray.getBoolean(i, this.mFi);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mFj = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mFl = typedArray.getDimensionPixelSize(i, this.mFl);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mFm = typedArray.getInteger(i, this.mFm);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mFn = typedArray.getBoolean(i, this.mFn);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mFo = typedArray.getDimensionPixelSize(i, this.mFo);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mFe = typedArray.getDimensionPixelSize(i, this.mFe);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mFp = typedArray.getBoolean(i, this.mFp);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mFr = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mFq = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mFs = typedArray.getDimensionPixelSize(i, this.mFs);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mFt = typedArray.getColor(i, this.mFt);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mFu = typedArray.getBoolean(i, this.mFu);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mFv = typedArray.getDimensionPixelSize(i, this.mFv);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mFw = typedArray.getBoolean(i, this.mFw);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mFy = typedArray.getBoolean(i, this.mFy);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mFx = typedArray.getColor(i, this.mFx);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mFz = typedArray.getBoolean(i, this.mFz);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mFA = typedArray.getBoolean(i, this.mFA);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mFB = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mFM = typedArray.getBoolean(i, this.mFM);
        }
    }

    private void dEv() {
        if (this.mFB != null) {
            this.mFH = ((BitmapDrawable) this.mFB).getBitmap();
        }
        if (this.mFH == null) {
            this.mFH = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mFH = a.g(this.mFH, this.mFg);
        }
        this.mFI = a.f(this.mFH, 90);
        this.mFI = a.f(this.mFI, 90);
        this.mFI = a.f(this.mFI, 90);
        if (this.mFj != null) {
            this.mFF = ((BitmapDrawable) this.mFj).getBitmap();
        }
        if (this.mFF == null) {
            this.mFF = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mFF = a.g(this.mFF, this.mFg);
        }
        this.mFG = a.f(this.mFF, 90);
        this.mFJ = (1.0f * this.mFc) / 2.0f;
        this.mFa.setTextSize(this.mFs);
        this.mFa.setColor(this.mFt);
        setIsBarcode(this.mFp);
    }

    public void dEw() {
        this.mFa.setColor(this.mFt);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mEX != null) {
            ai(canvas);
            aj(canvas);
            al(canvas);
            am(canvas);
            ak(canvas);
            dEx();
        }
    }

    private void ai(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mEX.top, this.mPaint);
            canvas.drawRect(0.0f, this.mEX.top, this.mEX.left, this.mEX.bottom + 1, this.mPaint);
            canvas.drawRect(this.mEX.right + 1, this.mEX.top, width, this.mEX.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mEX.bottom + 1, width, height, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (this.mFl > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mFl);
            canvas.drawRect(this.mEX, this.mPaint);
        }
    }

    private void ak(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mER, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mES, getMainFrameRight() - this.mER.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mET, getMainFrameLeft(), getMainFrameBottom() - this.mER.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mEU, getMainFrameRight() - this.mER.getWidth(), getMainFrameBottom() - this.mER.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mEX.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mEX.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mEX.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mEX.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mFl / 2;
    }

    private void al(Canvas canvas) {
        if (this.mFp) {
            if (this.mFC != null) {
                RectF rectF = new RectF(this.mEX.left + this.mFJ + 0.5f, this.mEX.top + this.mFJ + this.mFh, this.mFE, (this.mEX.bottom - this.mFJ) - this.mFh);
                Rect rect = new Rect((int) (this.mFC.getWidth() - rectF.width()), 0, this.mFC.getWidth(), this.mFC.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mFC, rect, rectF, this.mPaint);
            } else if (this.mFk != null) {
                canvas.drawBitmap(this.mFk, (Rect) null, new RectF(this.mEZ, this.mEX.top + this.mFJ + this.mFh, this.mEZ + this.mFk.getWidth(), (this.mEX.bottom - this.mFJ) - this.mFh), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mFg);
                canvas.drawRect(this.mEZ, this.mFh + this.mEX.top + this.mFJ, this.mFf + this.mEZ, (this.mEX.bottom - this.mFJ) - this.mFh, this.mPaint);
            }
        } else if (this.mFC != null) {
            RectF rectF2 = new RectF(this.mEX.left + this.mFJ + this.mFh, this.mEX.top + this.mFJ + 0.5f, (this.mEX.right - this.mFJ) - this.mFh, this.mFD);
            Rect rect2 = new Rect(0, (int) (this.mFC.getHeight() - rectF2.height()), this.mFC.getWidth(), this.mFC.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mFN);
            canvas.drawBitmap(this.mFC, rect2, rectF2, this.mPaint);
        } else if (this.mFk != null) {
            canvas.drawBitmap(this.mFk, (Rect) null, new RectF(this.mEX.left + this.mFJ + this.mFh, this.mEY, (this.mEX.right - this.mFJ) - this.mFh, this.mEY + this.mFk.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mFg);
            canvas.drawRect(this.mFh + this.mEX.left + this.mFJ, this.mEY, (this.mEX.right - this.mFJ) - this.mFh, this.mFf + this.mEY, this.mPaint);
        }
    }

    private void am(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lgN) && this.mFK != null) {
            if (this.mFu) {
                if (this.mFy) {
                    this.mPaint.setColor(this.mFx);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mFw) {
                        Rect rect = new Rect();
                        this.mFa.getTextBounds(this.lgN, 0, this.lgN.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mFL;
                        canvas.drawRoundRect(new RectF(width, (this.mEX.bottom + this.mFv) - this.mFL, rect.width() + width + (this.mFL * 2), this.mEX.bottom + this.mFv + this.mFK.getHeight() + this.mFL), this.mFL, this.mFL, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mEX.left, (this.mEX.bottom + this.mFv) - this.mFL, this.mEX.right, this.mEX.bottom + this.mFv + this.mFK.getHeight() + this.mFL), this.mFL, this.mFL, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mFw) {
                    canvas.translate(0.0f, this.mEX.bottom + this.mFv);
                } else {
                    canvas.translate(this.mEX.left + this.mFL, this.mEX.bottom + this.mFv);
                }
                this.mFK.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mFy) {
                this.mPaint.setColor(this.mFx);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mFw) {
                    Rect rect2 = new Rect();
                    this.mFa.getTextBounds(this.lgN, 0, this.lgN.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mFL;
                    canvas.drawRoundRect(new RectF(width2, ((this.mEX.top - this.mFv) - this.mFK.getHeight()) - this.mFL, rect2.width() + width2 + (this.mFL * 2), (this.mEX.top - this.mFv) + this.mFL), this.mFL, this.mFL, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mEX.left, ((this.mEX.top - this.mFv) - this.mFK.getHeight()) - this.mFL, this.mEX.right, (this.mEX.top - this.mFv) + this.mFL), this.mFL, this.mFL, this.mPaint);
                }
            }
            canvas.save();
            if (this.mFw) {
                canvas.translate(0.0f, (this.mEX.top - this.mFv) - this.mFK.getHeight());
            } else {
                canvas.translate(this.mEX.left + this.mFL, (this.mEX.top - this.mFv) - this.mFK.getHeight());
            }
            this.mFK.draw(canvas);
            canvas.restore();
        }
    }

    private void dEx() {
        if (this.mFp) {
            if (this.mFC == null) {
                this.mEZ += this.mEV;
                int i = this.mFf;
                if (this.mFk != null) {
                    i = this.mFk.getWidth();
                }
                if (this.mFz) {
                    if (i + this.mEZ > this.mEX.right - this.mFJ || this.mEZ < this.mEX.left + this.mFJ) {
                        this.mEV = -this.mEV;
                    }
                } else {
                    if (i + this.mEZ > this.mEX.right - this.mFJ) {
                        this.mEZ = this.mEX.left + this.mFJ + 0.5f;
                    }
                }
            } else {
                this.mFE += this.mEV;
                if (this.mFE > this.mEX.right - this.mFJ) {
                    this.mFE = this.mEX.left + this.mFJ + 0.5f;
                }
            }
        } else if (this.mFC == null) {
            this.mEY += this.mEV;
            int i2 = this.mFf;
            if (this.mFk != null) {
                i2 = this.mFk.getHeight();
            }
            if (this.mFz) {
                if (i2 + this.mEY > this.mEX.bottom - this.mFJ || this.mEY < this.mEX.top + this.mFJ) {
                    this.mEV = -this.mEV;
                }
            } else {
                if (i2 + this.mEY > this.mEX.bottom - this.mFJ) {
                    this.mEY = this.mEX.top + this.mFJ + 0.5f;
                }
            }
        } else {
            this.mFD += this.mEV;
            if (this.mFD > this.mEX.bottom - this.mFJ) {
                this.mFD = this.mEX.top + this.mFJ + 0.5f;
            }
        }
        postInvalidateDelayed(this.mEW, this.mEX.left, this.mEX.top, this.mEX.right, this.mEX.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dEy();
    }

    private void dEy() {
        int i;
        if (this.mFp) {
            i = this.mTopOffset + this.mFo;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cyQ) / 2;
        this.mEX = new Rect(width, i, this.cyQ + width, this.mFd + i);
        if (this.mFp) {
            float f = this.mEX.left + this.mFJ + 0.5f;
            this.mEZ = f;
            this.mFE = f;
            return;
        }
        float f2 = this.mEX.top + this.mFJ + 0.5f;
        this.mEY = f2;
        this.mFD = f2;
    }

    public Rect Jb(int i) {
        if (this.mFM) {
            Rect rect = new Rect(this.mEX);
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
        this.mFp = z;
        if (this.mFB != null || this.mFA) {
            if (this.mFp) {
                this.mFC = this.mFI;
            } else {
                this.mFC = this.mFH;
            }
        } else if (this.mFj != null || this.mFi) {
            if (this.mFp) {
                this.mFk = this.mFG;
            } else {
                this.mFk = this.mFF;
            }
        }
        if (this.mFp) {
            this.lgN = this.mFr;
            this.mFd = this.mFe;
            this.mEW = (int) (((this.mFm * 1.0f) * this.mEV) / this.cyQ);
        } else {
            this.lgN = this.mFq;
            this.mFd = this.cyQ;
            this.mEW = (int) (((this.mFm * 1.0f) * this.mEV) / this.mFd);
        }
        if (!TextUtils.isEmpty(this.lgN)) {
            if (this.mFw) {
                this.mFK = new StaticLayout(this.lgN, this.mFa, a.gt(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mFK = new StaticLayout(this.lgN, this.mFa, this.cyQ - (this.mFL * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mFn) {
            int i = a.gt(getContext()).y;
            if (this.mFo == 0) {
                this.mTopOffset = (i - this.mFd) / 2;
            } else if (this.mFp) {
                this.mTopOffset = ((i - this.mFd) / 2) + (this.mFo / 2);
            } else {
                this.mTopOffset = (i - this.mFd) / 2;
            }
        }
        dEy();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mFp;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mFb;
    }

    public void setCornerLength(int i) {
        this.mFb = i;
    }

    public int getCornerSize() {
        return this.mFc;
    }

    public void setCornerSize(int i) {
        this.mFc = i;
    }

    public int getRectWidth() {
        return this.cyQ;
    }

    public void setRectWidth(int i) {
        this.cyQ = i;
    }

    public int getRectHeight() {
        return this.mFd;
    }

    public void setRectHeight(int i) {
        this.mFd = i;
    }

    public int getBarcodeRectHeight() {
        return this.mFe;
    }

    public void setBarcodeRectHeight(int i) {
        this.mFe = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mFf;
    }

    public void setScanLineSize(int i) {
        this.mFf = i;
    }

    public int getScanLineColor() {
        return this.mFg;
    }

    public void setScanLineColor(int i) {
        this.mFg = i;
    }

    public int getScanLineMargin() {
        return this.mFh;
    }

    public void setScanLineMargin(int i) {
        this.mFh = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mFi = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mFj;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mFj = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mFk;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mFk = bitmap;
    }

    public int getBorderSize() {
        return this.mFl;
    }

    public void setBorderSize(int i) {
        this.mFl = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mFm;
    }

    public void setAnimTime(int i) {
        this.mFm = i;
    }

    public void setCenterVertical(boolean z) {
        this.mFn = z;
    }

    public int getToolbarHeight() {
        return this.mFo;
    }

    public void setToolbarHeight(int i) {
        this.mFo = i;
    }

    public String getQRCodeTipText() {
        return this.mFq;
    }

    public void setQRCodeTipText(String str) {
        this.mFq = str;
    }

    public String getBarCodeTipText() {
        return this.mFr;
    }

    public void setBarCodeTipText(String str) {
        this.mFr = str;
    }

    public String getTipText() {
        return this.lgN;
    }

    public void setTipText(String str) {
        this.lgN = str;
    }

    public int getTipTextColor() {
        return this.mFt;
    }

    public void setTipTextColor(int i) {
        this.mFt = i;
    }

    public int getTipTextSize() {
        return this.mFs;
    }

    public void setTipTextSize(int i) {
        this.mFs = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mFu = z;
    }

    public int getTipTextMargin() {
        return this.mFv;
    }

    public void setTipTextMargin(int i) {
        this.mFv = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mFw = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mFy = z;
    }

    public int getTipBackgroundColor() {
        return this.mFx;
    }

    public void setTipBackgroundColor(int i) {
        this.mFx = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mFz = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mFA = z;
    }

    public float getHalfCornerSize() {
        return this.mFJ;
    }

    public void setHalfCornerSize(float f) {
        this.mFJ = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mFK;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mFK = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mFL;
    }

    public void setTipBackgroundRadius(int i) {
        this.mFL = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mFM = z;
    }
}
