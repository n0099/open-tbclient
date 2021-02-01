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
    private String lpT;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Bitmap mOC;
    private Bitmap mOD;
    private Bitmap mOE;
    private Bitmap mOF;
    private int mOG;
    private int mOH;
    private Rect mOI;
    private float mOJ;
    private float mOK;
    private TextPaint mOL;
    private int mOM;
    private int mON;
    private int mOO;
    private int mOP;
    private int mOQ;
    private int mOR;
    private int mOS;
    private boolean mOT;
    private Drawable mOU;
    private Bitmap mOV;
    private int mOW;
    private int mOX;
    private boolean mOY;
    private int mOZ;
    private ColorMatrixColorFilter mPA;
    private boolean mPa;
    private Paint mPaint;
    private String mPb;
    private String mPc;
    private int mPd;
    private int mPe;
    private boolean mPf;
    private int mPg;
    private boolean mPh;
    private int mPi;
    private boolean mPj;
    private boolean mPk;
    private boolean mPl;
    private Drawable mPo;
    private Bitmap mPp;
    private float mPq;
    private float mPr;
    private Bitmap mPs;
    private Bitmap mPt;
    private Bitmap mPu;
    private Bitmap mPv;
    private float mPw;
    private StaticLayout mPx;
    private int mPy;
    private boolean mPz;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mOM = a.dp2px(context, 20.0f);
        this.mON = a.dp2px(context, 3.0f);
        this.mOQ = a.dp2px(context, 1.0f);
        this.mOR = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cBt = a.dp2px(context, 200.0f);
        this.mOP = a.dp2px(context, 140.0f);
        this.mOS = 0;
        this.mOT = false;
        this.mOU = null;
        this.mOV = null;
        this.mOW = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mOX = 1000;
        this.mOY = false;
        this.mOZ = 0;
        this.mPa = false;
        this.mOG = a.dp2px(context, 2.0f);
        this.lpT = null;
        this.mPd = a.h(context, 14.0f);
        this.mPe = -1;
        this.mPf = false;
        this.mPg = a.dp2px(context, 20.0f);
        this.mPh = false;
        this.mPi = Color.parseColor("#22000000");
        this.mPj = false;
        this.mPk = false;
        this.mPl = false;
        this.mOL = new TextPaint();
        this.mOL.setAntiAlias(true);
        this.mPy = a.dp2px(context, 4.0f);
        this.mPz = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mPA = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dCD();
        dCC();
    }

    private void dCC() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mOM;
        options.outHeight = this.mOM;
        this.mOC = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mOD = Bitmap.createBitmap(this.mOC, 0, 0, this.mOC.getWidth(), this.mOC.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mOE = Bitmap.createBitmap(this.mOC, 0, 0, this.mOC.getWidth(), this.mOC.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mOF = Bitmap.createBitmap(this.mOC, 0, 0, this.mOC.getWidth(), this.mOC.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mON = typedArray.getDimensionPixelSize(i, this.mON);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mOM = typedArray.getDimensionPixelSize(i, this.mOM);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mOQ = typedArray.getDimensionPixelSize(i, this.mOQ);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cBt = typedArray.getDimensionPixelSize(i, this.cBt);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mOR = typedArray.getColor(i, this.mOR);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mOS = typedArray.getDimensionPixelSize(i, this.mOS);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mOT = typedArray.getBoolean(i, this.mOT);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mOU = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mOW = typedArray.getDimensionPixelSize(i, this.mOW);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mOX = typedArray.getInteger(i, this.mOX);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mOY = typedArray.getBoolean(i, this.mOY);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mOZ = typedArray.getDimensionPixelSize(i, this.mOZ);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mOP = typedArray.getDimensionPixelSize(i, this.mOP);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mPa = typedArray.getBoolean(i, this.mPa);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mPc = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mPb = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mPd = typedArray.getDimensionPixelSize(i, this.mPd);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mPe = typedArray.getColor(i, this.mPe);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mPf = typedArray.getBoolean(i, this.mPf);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mPg = typedArray.getDimensionPixelSize(i, this.mPg);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mPh = typedArray.getBoolean(i, this.mPh);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mPj = typedArray.getBoolean(i, this.mPj);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mPi = typedArray.getColor(i, this.mPi);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mPk = typedArray.getBoolean(i, this.mPk);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mPl = typedArray.getBoolean(i, this.mPl);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mPo = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mPz = typedArray.getBoolean(i, this.mPz);
        }
    }

    private void dCD() {
        if (this.mPo != null) {
            this.mPu = ((BitmapDrawable) this.mPo).getBitmap();
        }
        if (this.mPu == null) {
            this.mPu = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mPu = a.g(this.mPu, this.mOR);
        }
        this.mPv = a.f(this.mPu, 90);
        this.mPv = a.f(this.mPv, 90);
        this.mPv = a.f(this.mPv, 90);
        if (this.mOU != null) {
            this.mPs = ((BitmapDrawable) this.mOU).getBitmap();
        }
        if (this.mPs == null) {
            this.mPs = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mPs = a.g(this.mPs, this.mOR);
        }
        this.mPt = a.f(this.mPs, 90);
        this.mPw = (1.0f * this.mON) / 2.0f;
        this.mOL.setTextSize(this.mPd);
        this.mOL.setColor(this.mPe);
        setIsBarcode(this.mPa);
    }

    public void dCE() {
        this.mOL.setColor(this.mPe);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mOI != null) {
            ao(canvas);
            ap(canvas);
            ar(canvas);
            as(canvas);
            aq(canvas);
            dCF();
        }
    }

    private void ao(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mOI.top, this.mPaint);
            canvas.drawRect(0.0f, this.mOI.top, this.mOI.left, this.mOI.bottom + 1, this.mPaint);
            canvas.drawRect(this.mOI.right + 1, this.mOI.top, width, this.mOI.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mOI.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ap(Canvas canvas) {
        if (this.mOW > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mOW);
            canvas.drawRect(this.mOI, this.mPaint);
        }
    }

    private void aq(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mOC, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mOD, getMainFrameRight() - this.mOC.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mOE, getMainFrameLeft(), getMainFrameBottom() - this.mOC.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mOF, getMainFrameRight() - this.mOC.getWidth(), getMainFrameBottom() - this.mOC.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mOI.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mOI.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mOI.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mOI.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mOW / 2;
    }

    private void ar(Canvas canvas) {
        if (this.mPa) {
            if (this.mPp != null) {
                RectF rectF = new RectF(this.mOI.left + this.mPw + 0.5f, this.mOI.top + this.mPw + this.mOS, this.mPr, (this.mOI.bottom - this.mPw) - this.mOS);
                Rect rect = new Rect((int) (this.mPp.getWidth() - rectF.width()), 0, this.mPp.getWidth(), this.mPp.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mPp, rect, rectF, this.mPaint);
            } else if (this.mOV != null) {
                canvas.drawBitmap(this.mOV, (Rect) null, new RectF(this.mOK, this.mOI.top + this.mPw + this.mOS, this.mOK + this.mOV.getWidth(), (this.mOI.bottom - this.mPw) - this.mOS), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mOR);
                canvas.drawRect(this.mOK, this.mOS + this.mOI.top + this.mPw, this.mOQ + this.mOK, (this.mOI.bottom - this.mPw) - this.mOS, this.mPaint);
            }
        } else if (this.mPp != null) {
            RectF rectF2 = new RectF(this.mOI.left + this.mPw + this.mOS, this.mOI.top + this.mPw + 0.5f, (this.mOI.right - this.mPw) - this.mOS, this.mPq);
            Rect rect2 = new Rect(0, (int) (this.mPp.getHeight() - rectF2.height()), this.mPp.getWidth(), this.mPp.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mPA);
            canvas.drawBitmap(this.mPp, rect2, rectF2, this.mPaint);
        } else if (this.mOV != null) {
            canvas.drawBitmap(this.mOV, (Rect) null, new RectF(this.mOI.left + this.mPw + this.mOS, this.mOJ, (this.mOI.right - this.mPw) - this.mOS, this.mOJ + this.mOV.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mOR);
            canvas.drawRect(this.mOS + this.mOI.left + this.mPw, this.mOJ, (this.mOI.right - this.mPw) - this.mOS, this.mOQ + this.mOJ, this.mPaint);
        }
    }

    private void as(Canvas canvas) {
        if (!TextUtils.isEmpty(this.lpT) && this.mPx != null) {
            if (this.mPf) {
                if (this.mPj) {
                    this.mPaint.setColor(this.mPi);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mPh) {
                        Rect rect = new Rect();
                        this.mOL.getTextBounds(this.lpT, 0, this.lpT.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mPy;
                        canvas.drawRoundRect(new RectF(width, (this.mOI.bottom + this.mPg) - this.mPy, rect.width() + width + (this.mPy * 2), this.mOI.bottom + this.mPg + this.mPx.getHeight() + this.mPy), this.mPy, this.mPy, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mOI.left, (this.mOI.bottom + this.mPg) - this.mPy, this.mOI.right, this.mOI.bottom + this.mPg + this.mPx.getHeight() + this.mPy), this.mPy, this.mPy, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mPh) {
                    canvas.translate(0.0f, this.mOI.bottom + this.mPg);
                } else {
                    canvas.translate(this.mOI.left + this.mPy, this.mOI.bottom + this.mPg);
                }
                this.mPx.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mPj) {
                this.mPaint.setColor(this.mPi);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mPh) {
                    Rect rect2 = new Rect();
                    this.mOL.getTextBounds(this.lpT, 0, this.lpT.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mPy;
                    canvas.drawRoundRect(new RectF(width2, ((this.mOI.top - this.mPg) - this.mPx.getHeight()) - this.mPy, rect2.width() + width2 + (this.mPy * 2), (this.mOI.top - this.mPg) + this.mPy), this.mPy, this.mPy, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mOI.left, ((this.mOI.top - this.mPg) - this.mPx.getHeight()) - this.mPy, this.mOI.right, (this.mOI.top - this.mPg) + this.mPy), this.mPy, this.mPy, this.mPaint);
                }
            }
            canvas.save();
            if (this.mPh) {
                canvas.translate(0.0f, (this.mOI.top - this.mPg) - this.mPx.getHeight());
            } else {
                canvas.translate(this.mOI.left + this.mPy, (this.mOI.top - this.mPg) - this.mPx.getHeight());
            }
            this.mPx.draw(canvas);
            canvas.restore();
        }
    }

    private void dCF() {
        if (this.mPa) {
            if (this.mPp == null) {
                this.mOK += this.mOG;
                int i = this.mOQ;
                if (this.mOV != null) {
                    i = this.mOV.getWidth();
                }
                if (this.mPk) {
                    if (i + this.mOK > this.mOI.right - this.mPw || this.mOK < this.mOI.left + this.mPw) {
                        this.mOG = -this.mOG;
                    }
                } else {
                    if (i + this.mOK > this.mOI.right - this.mPw) {
                        this.mOK = this.mOI.left + this.mPw + 0.5f;
                    }
                }
            } else {
                this.mPr += this.mOG;
                if (this.mPr > this.mOI.right - this.mPw) {
                    this.mPr = this.mOI.left + this.mPw + 0.5f;
                }
            }
        } else if (this.mPp == null) {
            this.mOJ += this.mOG;
            int i2 = this.mOQ;
            if (this.mOV != null) {
                i2 = this.mOV.getHeight();
            }
            if (this.mPk) {
                if (i2 + this.mOJ > this.mOI.bottom - this.mPw || this.mOJ < this.mOI.top + this.mPw) {
                    this.mOG = -this.mOG;
                }
            } else {
                if (i2 + this.mOJ > this.mOI.bottom - this.mPw) {
                    this.mOJ = this.mOI.top + this.mPw + 0.5f;
                }
            }
        } else {
            this.mPq += this.mOG;
            if (this.mPq > this.mOI.bottom - this.mPw) {
                this.mPq = this.mOI.top + this.mPw + 0.5f;
            }
        }
        postInvalidateDelayed(this.mOH, this.mOI.left, this.mOI.top, this.mOI.right, this.mOI.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dCG();
    }

    private void dCG() {
        int i;
        if (this.mPa) {
            i = this.mTopOffset + this.mOZ;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cBt) / 2;
        this.mOI = new Rect(width, i, this.cBt + width, this.mOO + i);
        if (this.mPa) {
            float f = this.mOI.left + this.mPw + 0.5f;
            this.mOK = f;
            this.mPr = f;
            return;
        }
        float f2 = this.mOI.top + this.mPw + 0.5f;
        this.mOJ = f2;
        this.mPq = f2;
    }

    public Rect HG(int i) {
        if (this.mPz) {
            Rect rect = new Rect(this.mOI);
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
        this.mPa = z;
        if (this.mPo != null || this.mPl) {
            if (this.mPa) {
                this.mPp = this.mPv;
            } else {
                this.mPp = this.mPu;
            }
        } else if (this.mOU != null || this.mOT) {
            if (this.mPa) {
                this.mOV = this.mPt;
            } else {
                this.mOV = this.mPs;
            }
        }
        if (this.mPa) {
            this.lpT = this.mPc;
            this.mOO = this.mOP;
            this.mOH = (int) (((this.mOX * 1.0f) * this.mOG) / this.cBt);
        } else {
            this.lpT = this.mPb;
            this.mOO = this.cBt;
            this.mOH = (int) (((this.mOX * 1.0f) * this.mOG) / this.mOO);
        }
        if (!TextUtils.isEmpty(this.lpT)) {
            if (this.mPh) {
                this.mPx = new StaticLayout(this.lpT, this.mOL, a.gN(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mPx = new StaticLayout(this.lpT, this.mOL, this.cBt - (this.mPy * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mOY) {
            int i = a.gN(getContext()).y;
            if (this.mOZ == 0) {
                this.mTopOffset = (i - this.mOO) / 2;
            } else if (this.mPa) {
                this.mTopOffset = ((i - this.mOO) / 2) + (this.mOZ / 2);
            } else {
                this.mTopOffset = (i - this.mOO) / 2;
            }
        }
        dCG();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mPa;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mOM;
    }

    public void setCornerLength(int i) {
        this.mOM = i;
    }

    public int getCornerSize() {
        return this.mON;
    }

    public void setCornerSize(int i) {
        this.mON = i;
    }

    public int getRectWidth() {
        return this.cBt;
    }

    public void setRectWidth(int i) {
        this.cBt = i;
    }

    public int getRectHeight() {
        return this.mOO;
    }

    public void setRectHeight(int i) {
        this.mOO = i;
    }

    public int getBarcodeRectHeight() {
        return this.mOP;
    }

    public void setBarcodeRectHeight(int i) {
        this.mOP = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mOQ;
    }

    public void setScanLineSize(int i) {
        this.mOQ = i;
    }

    public int getScanLineColor() {
        return this.mOR;
    }

    public void setScanLineColor(int i) {
        this.mOR = i;
    }

    public int getScanLineMargin() {
        return this.mOS;
    }

    public void setScanLineMargin(int i) {
        this.mOS = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mOT = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mOU;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mOU = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mOV;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mOV = bitmap;
    }

    public int getBorderSize() {
        return this.mOW;
    }

    public void setBorderSize(int i) {
        this.mOW = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mOX;
    }

    public void setAnimTime(int i) {
        this.mOX = i;
    }

    public void setCenterVertical(boolean z) {
        this.mOY = z;
    }

    public int getToolbarHeight() {
        return this.mOZ;
    }

    public void setToolbarHeight(int i) {
        this.mOZ = i;
    }

    public String getQRCodeTipText() {
        return this.mPb;
    }

    public void setQRCodeTipText(String str) {
        this.mPb = str;
    }

    public String getBarCodeTipText() {
        return this.mPc;
    }

    public void setBarCodeTipText(String str) {
        this.mPc = str;
    }

    public String getTipText() {
        return this.lpT;
    }

    public void setTipText(String str) {
        this.lpT = str;
    }

    public int getTipTextColor() {
        return this.mPe;
    }

    public void setTipTextColor(int i) {
        this.mPe = i;
    }

    public int getTipTextSize() {
        return this.mPd;
    }

    public void setTipTextSize(int i) {
        this.mPd = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mPf = z;
    }

    public int getTipTextMargin() {
        return this.mPg;
    }

    public void setTipTextMargin(int i) {
        this.mPg = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mPh = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mPj = z;
    }

    public int getTipBackgroundColor() {
        return this.mPi;
    }

    public void setTipBackgroundColor(int i) {
        this.mPi = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mPk = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mPl = z;
    }

    public float getHalfCornerSize() {
        return this.mPw;
    }

    public void setHalfCornerSize(float f) {
        this.mPw = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mPx;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mPx = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mPy;
    }

    public void setTipBackgroundRadius(int i) {
        this.mPy = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mPz = z;
    }
}
