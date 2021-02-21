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
/* loaded from: classes8.dex */
public class ScanBoxView extends View {
    private int cBt;
    private String lqh;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Bitmap mOR;
    private Bitmap mOS;
    private Bitmap mOT;
    private Bitmap mOU;
    private int mOV;
    private int mOW;
    private Rect mOX;
    private float mOY;
    private float mOZ;
    private boolean mPA;
    private boolean mPB;
    private boolean mPC;
    private Drawable mPD;
    private Bitmap mPE;
    private float mPF;
    private float mPG;
    private Bitmap mPH;
    private Bitmap mPI;
    private Bitmap mPJ;
    private Bitmap mPK;
    private float mPL;
    private StaticLayout mPM;
    private int mPN;
    private boolean mPO;
    private ColorMatrixColorFilter mPP;
    private TextPaint mPa;
    private Paint mPaint;
    private int mPb;
    private int mPc;
    private int mPd;
    private int mPe;
    private int mPf;
    private int mPg;
    private int mPh;
    private boolean mPi;
    private Drawable mPj;
    private Bitmap mPk;
    private int mPl;
    private int mPo;
    private boolean mPp;
    private int mPq;
    private boolean mPr;
    private String mPs;
    private String mPt;
    private int mPu;
    private int mPv;
    private boolean mPw;
    private int mPx;
    private boolean mPy;
    private int mPz;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mPb = a.dp2px(context, 20.0f);
        this.mPc = a.dp2px(context, 3.0f);
        this.mPf = a.dp2px(context, 1.0f);
        this.mPg = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cBt = a.dp2px(context, 200.0f);
        this.mPe = a.dp2px(context, 140.0f);
        this.mPh = 0;
        this.mPi = false;
        this.mPj = null;
        this.mPk = null;
        this.mPl = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mPo = 1000;
        this.mPp = false;
        this.mPq = 0;
        this.mPr = false;
        this.mOV = a.dp2px(context, 2.0f);
        this.lqh = null;
        this.mPu = a.h(context, 14.0f);
        this.mPv = -1;
        this.mPw = false;
        this.mPx = a.dp2px(context, 20.0f);
        this.mPy = false;
        this.mPz = Color.parseColor("#22000000");
        this.mPA = false;
        this.mPB = false;
        this.mPC = false;
        this.mPa = new TextPaint();
        this.mPa.setAntiAlias(true);
        this.mPN = a.dp2px(context, 4.0f);
        this.mPO = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mPP = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dCK();
        dCJ();
    }

    private void dCJ() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mPb;
        options.outHeight = this.mPb;
        this.mOR = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mOS = Bitmap.createBitmap(this.mOR, 0, 0, this.mOR.getWidth(), this.mOR.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mOT = Bitmap.createBitmap(this.mOR, 0, 0, this.mOR.getWidth(), this.mOR.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mOU = Bitmap.createBitmap(this.mOR, 0, 0, this.mOR.getWidth(), this.mOR.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mPc = typedArray.getDimensionPixelSize(i, this.mPc);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mPb = typedArray.getDimensionPixelSize(i, this.mPb);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mPf = typedArray.getDimensionPixelSize(i, this.mPf);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cBt = typedArray.getDimensionPixelSize(i, this.cBt);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mPg = typedArray.getColor(i, this.mPg);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mPh = typedArray.getDimensionPixelSize(i, this.mPh);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mPi = typedArray.getBoolean(i, this.mPi);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mPj = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mPl = typedArray.getDimensionPixelSize(i, this.mPl);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mPo = typedArray.getInteger(i, this.mPo);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mPp = typedArray.getBoolean(i, this.mPp);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mPq = typedArray.getDimensionPixelSize(i, this.mPq);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mPe = typedArray.getDimensionPixelSize(i, this.mPe);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mPr = typedArray.getBoolean(i, this.mPr);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mPt = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mPs = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mPu = typedArray.getDimensionPixelSize(i, this.mPu);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mPv = typedArray.getColor(i, this.mPv);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mPw = typedArray.getBoolean(i, this.mPw);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mPx = typedArray.getDimensionPixelSize(i, this.mPx);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mPy = typedArray.getBoolean(i, this.mPy);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mPA = typedArray.getBoolean(i, this.mPA);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mPz = typedArray.getColor(i, this.mPz);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mPB = typedArray.getBoolean(i, this.mPB);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mPC = typedArray.getBoolean(i, this.mPC);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mPD = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mPO = typedArray.getBoolean(i, this.mPO);
        }
    }

    private void dCK() {
        if (this.mPD != null) {
            this.mPJ = ((BitmapDrawable) this.mPD).getBitmap();
        }
        if (this.mPJ == null) {
            this.mPJ = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mPJ = a.g(this.mPJ, this.mPg);
        }
        this.mPK = a.f(this.mPJ, 90);
        this.mPK = a.f(this.mPK, 90);
        this.mPK = a.f(this.mPK, 90);
        if (this.mPj != null) {
            this.mPH = ((BitmapDrawable) this.mPj).getBitmap();
        }
        if (this.mPH == null) {
            this.mPH = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mPH = a.g(this.mPH, this.mPg);
        }
        this.mPI = a.f(this.mPH, 90);
        this.mPL = (1.0f * this.mPc) / 2.0f;
        this.mPa.setTextSize(this.mPu);
        this.mPa.setColor(this.mPv);
        setIsBarcode(this.mPr);
    }

    public void dCL() {
        this.mPa.setColor(this.mPv);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mOX != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dCM();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mOX.top, this.mPaint);
            canvas.drawRect(0.0f, this.mOX.top, this.mOX.left, this.mOX.bottom + 1, this.mPaint);
            canvas.drawRect(this.mOX.right + 1, this.mOX.top, width, this.mOX.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mOX.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mPl > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mPl);
            canvas.drawRect(this.mOX, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mOR, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mOS, getMainFrameRight() - this.mOR.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mOT, getMainFrameLeft(), getMainFrameBottom() - this.mOR.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mOU, getMainFrameRight() - this.mOR.getWidth(), getMainFrameBottom() - this.mOR.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mOX.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mOX.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mOX.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mOX.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mPl / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mPr) {
            if (this.mPE != null) {
                RectF rectF = new RectF(this.mOX.left + this.mPL + 0.5f, this.mOX.top + this.mPL + this.mPh, this.mPG, (this.mOX.bottom - this.mPL) - this.mPh);
                Rect rect = new Rect((int) (this.mPE.getWidth() - rectF.width()), 0, this.mPE.getWidth(), this.mPE.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mPE, rect, rectF, this.mPaint);
            } else if (this.mPk != null) {
                canvas.drawBitmap(this.mPk, (Rect) null, new RectF(this.mOZ, this.mOX.top + this.mPL + this.mPh, this.mOZ + this.mPk.getWidth(), (this.mOX.bottom - this.mPL) - this.mPh), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mPg);
                canvas.drawRect(this.mOZ, this.mPh + this.mOX.top + this.mPL, this.mPf + this.mOZ, (this.mOX.bottom - this.mPL) - this.mPh, this.mPaint);
            }
        } else if (this.mPE != null) {
            RectF rectF2 = new RectF(this.mOX.left + this.mPL + this.mPh, this.mOX.top + this.mPL + 0.5f, (this.mOX.right - this.mPL) - this.mPh, this.mPF);
            Rect rect2 = new Rect(0, (int) (this.mPE.getHeight() - rectF2.height()), this.mPE.getWidth(), this.mPE.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mPP);
            canvas.drawBitmap(this.mPE, rect2, rectF2, this.mPaint);
        } else if (this.mPk != null) {
            canvas.drawBitmap(this.mPk, (Rect) null, new RectF(this.mOX.left + this.mPL + this.mPh, this.mOY, (this.mOX.right - this.mPL) - this.mPh, this.mOY + this.mPk.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mPg);
            canvas.drawRect(this.mPh + this.mOX.left + this.mPL, this.mOY, (this.mOX.right - this.mPL) - this.mPh, this.mPf + this.mOY, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lqh) && this.mPM != null) {
            if (this.mPw) {
                if (this.mPA) {
                    this.mPaint.setColor(this.mPz);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mPy) {
                        Rect rect = new Rect();
                        this.mPa.getTextBounds(this.lqh, 0, this.lqh.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mPN;
                        canvas.drawRoundRect(new RectF(width, (this.mOX.bottom + this.mPx) - this.mPN, rect.width() + width + (this.mPN * 2), this.mOX.bottom + this.mPx + this.mPM.getHeight() + this.mPN), this.mPN, this.mPN, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mOX.left, (this.mOX.bottom + this.mPx) - this.mPN, this.mOX.right, this.mOX.bottom + this.mPx + this.mPM.getHeight() + this.mPN), this.mPN, this.mPN, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mPy) {
                    canvas.translate(0.0f, this.mOX.bottom + this.mPx);
                } else {
                    canvas.translate(this.mOX.left + this.mPN, this.mOX.bottom + this.mPx);
                }
                this.mPM.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mPA) {
                this.mPaint.setColor(this.mPz);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mPy) {
                    Rect rect2 = new Rect();
                    this.mPa.getTextBounds(this.lqh, 0, this.lqh.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mPN;
                    canvas.drawRoundRect(new RectF(width2, ((this.mOX.top - this.mPx) - this.mPM.getHeight()) - this.mPN, rect2.width() + width2 + (this.mPN * 2), (this.mOX.top - this.mPx) + this.mPN), this.mPN, this.mPN, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mOX.left, ((this.mOX.top - this.mPx) - this.mPM.getHeight()) - this.mPN, this.mOX.right, (this.mOX.top - this.mPx) + this.mPN), this.mPN, this.mPN, this.mPaint);
                }
            }
            canvas.save();
            if (this.mPy) {
                canvas.translate(0.0f, (this.mOX.top - this.mPx) - this.mPM.getHeight());
            } else {
                canvas.translate(this.mOX.left + this.mPN, (this.mOX.top - this.mPx) - this.mPM.getHeight());
            }
            this.mPM.draw(canvas);
            canvas.restore();
        }
    }

    private void dCM() {
        if (this.mPr) {
            if (this.mPE == null) {
                this.mOZ += this.mOV;
                int i = this.mPf;
                if (this.mPk != null) {
                    i = this.mPk.getWidth();
                }
                if (this.mPB) {
                    if (i + this.mOZ > this.mOX.right - this.mPL || this.mOZ < this.mOX.left + this.mPL) {
                        this.mOV = -this.mOV;
                    }
                } else {
                    if (i + this.mOZ > this.mOX.right - this.mPL) {
                        this.mOZ = this.mOX.left + this.mPL + 0.5f;
                    }
                }
            } else {
                this.mPG += this.mOV;
                if (this.mPG > this.mOX.right - this.mPL) {
                    this.mPG = this.mOX.left + this.mPL + 0.5f;
                }
            }
        } else if (this.mPE == null) {
            this.mOY += this.mOV;
            int i2 = this.mPf;
            if (this.mPk != null) {
                i2 = this.mPk.getHeight();
            }
            if (this.mPB) {
                if (i2 + this.mOY > this.mOX.bottom - this.mPL || this.mOY < this.mOX.top + this.mPL) {
                    this.mOV = -this.mOV;
                }
            } else {
                if (i2 + this.mOY > this.mOX.bottom - this.mPL) {
                    this.mOY = this.mOX.top + this.mPL + 0.5f;
                }
            }
        } else {
            this.mPF += this.mOV;
            if (this.mPF > this.mOX.bottom - this.mPL) {
                this.mPF = this.mOX.top + this.mPL + 0.5f;
            }
        }
        postInvalidateDelayed(this.mOW, this.mOX.left, this.mOX.top, this.mOX.right, this.mOX.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dCN();
    }

    private void dCN() {
        int i;
        if (this.mPr) {
            i = this.mTopOffset + this.mPq;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cBt) / 2;
        this.mOX = new Rect(width, i, this.cBt + width, this.mPd + i);
        if (this.mPr) {
            float f = this.mOX.left + this.mPL + 0.5f;
            this.mOZ = f;
            this.mPG = f;
            return;
        }
        float f2 = this.mOX.top + this.mPL + 0.5f;
        this.mOY = f2;
        this.mPF = f2;
    }

    public Rect HG(int i) {
        if (this.mPO) {
            Rect rect = new Rect(this.mOX);
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
        this.mPr = z;
        if (this.mPD != null || this.mPC) {
            if (this.mPr) {
                this.mPE = this.mPK;
            } else {
                this.mPE = this.mPJ;
            }
        } else if (this.mPj != null || this.mPi) {
            if (this.mPr) {
                this.mPk = this.mPI;
            } else {
                this.mPk = this.mPH;
            }
        }
        if (this.mPr) {
            this.lqh = this.mPt;
            this.mPd = this.mPe;
            this.mOW = (int) (((this.mPo * 1.0f) * this.mOV) / this.cBt);
        } else {
            this.lqh = this.mPs;
            this.mPd = this.cBt;
            this.mOW = (int) (((this.mPo * 1.0f) * this.mOV) / this.mPd);
        }
        if (!TextUtils.isEmpty(this.lqh)) {
            if (this.mPy) {
                this.mPM = new StaticLayout(this.lqh, this.mPa, a.gN(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mPM = new StaticLayout(this.lqh, this.mPa, this.cBt - (this.mPN * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mPp) {
            int i = a.gN(getContext()).y;
            if (this.mPq == 0) {
                this.mTopOffset = (i - this.mPd) / 2;
            } else if (this.mPr) {
                this.mTopOffset = ((i - this.mPd) / 2) + (this.mPq / 2);
            } else {
                this.mTopOffset = (i - this.mPd) / 2;
            }
        }
        dCN();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mPr;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mPb;
    }

    public void setCornerLength(int i) {
        this.mPb = i;
    }

    public int getCornerSize() {
        return this.mPc;
    }

    public void setCornerSize(int i) {
        this.mPc = i;
    }

    public int getRectWidth() {
        return this.cBt;
    }

    public void setRectWidth(int i) {
        this.cBt = i;
    }

    public int getRectHeight() {
        return this.mPd;
    }

    public void setRectHeight(int i) {
        this.mPd = i;
    }

    public int getBarcodeRectHeight() {
        return this.mPe;
    }

    public void setBarcodeRectHeight(int i) {
        this.mPe = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mPf;
    }

    public void setScanLineSize(int i) {
        this.mPf = i;
    }

    public int getScanLineColor() {
        return this.mPg;
    }

    public void setScanLineColor(int i) {
        this.mPg = i;
    }

    public int getScanLineMargin() {
        return this.mPh;
    }

    public void setScanLineMargin(int i) {
        this.mPh = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mPi = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mPj;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mPj = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mPk;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mPk = bitmap;
    }

    public int getBorderSize() {
        return this.mPl;
    }

    public void setBorderSize(int i) {
        this.mPl = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mPo;
    }

    public void setAnimTime(int i) {
        this.mPo = i;
    }

    public void setCenterVertical(boolean z) {
        this.mPp = z;
    }

    public int getToolbarHeight() {
        return this.mPq;
    }

    public void setToolbarHeight(int i) {
        this.mPq = i;
    }

    public String getQRCodeTipText() {
        return this.mPs;
    }

    public void setQRCodeTipText(String str) {
        this.mPs = str;
    }

    public String getBarCodeTipText() {
        return this.mPt;
    }

    public void setBarCodeTipText(String str) {
        this.mPt = str;
    }

    public String getTipText() {
        return this.lqh;
    }

    public void setTipText(String str) {
        this.lqh = str;
    }

    public int getTipTextColor() {
        return this.mPv;
    }

    public void setTipTextColor(int i) {
        this.mPv = i;
    }

    public int getTipTextSize() {
        return this.mPu;
    }

    public void setTipTextSize(int i) {
        this.mPu = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mPw = z;
    }

    public int getTipTextMargin() {
        return this.mPx;
    }

    public void setTipTextMargin(int i) {
        this.mPx = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mPy = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mPA = z;
    }

    public int getTipBackgroundColor() {
        return this.mPz;
    }

    public void setTipBackgroundColor(int i) {
        this.mPz = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mPB = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mPC = z;
    }

    public float getHalfCornerSize() {
        return this.mPL;
    }

    public void setHalfCornerSize(float f) {
        this.mPL = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mPM;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mPM = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mPN;
    }

    public void setTipBackgroundRadius(int i) {
        this.mPN = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mPO = z;
    }
}
