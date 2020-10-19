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
    private int cfj;
    private String kAM;
    private Bitmap lXQ;
    private Bitmap lXR;
    private Bitmap lXS;
    private Bitmap lXT;
    private int lXU;
    private int lXV;
    private Rect lXW;
    private float lXX;
    private float lXY;
    private TextPaint lXZ;
    private Drawable lYA;
    private Bitmap lYB;
    private float lYC;
    private float lYD;
    private Bitmap lYE;
    private Bitmap lYF;
    private Bitmap lYG;
    private Bitmap lYH;
    private float lYI;
    private StaticLayout lYJ;
    private int lYK;
    private boolean lYL;
    private ColorMatrixColorFilter lYM;
    private int lYa;
    private int lYb;
    private int lYc;
    private int lYd;
    private int lYe;
    private int lYf;
    private int lYg;
    private boolean lYh;
    private Drawable lYi;
    private Bitmap lYj;
    private int lYk;
    private int lYl;
    private boolean lYm;
    private int lYn;
    private boolean lYo;
    private String lYp;
    private String lYq;
    private int lYr;
    private int lYs;
    private boolean lYt;
    private int lYu;
    private boolean lYv;
    private int lYw;
    private boolean lYx;
    private boolean lYy;
    private boolean lYz;
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
        this.lYa = a.dp2px(context, 20.0f);
        this.lYb = a.dp2px(context, 3.0f);
        this.lYe = a.dp2px(context, 1.0f);
        this.lYf = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cfj = a.dp2px(context, 200.0f);
        this.lYd = a.dp2px(context, 140.0f);
        this.lYg = 0;
        this.lYh = false;
        this.lYi = null;
        this.lYj = null;
        this.lYk = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.lYl = 1000;
        this.lYm = false;
        this.lYn = 0;
        this.lYo = false;
        this.lXU = a.dp2px(context, 2.0f);
        this.kAM = null;
        this.lYr = a.h(context, 14.0f);
        this.lYs = -1;
        this.lYt = false;
        this.lYu = a.dp2px(context, 20.0f);
        this.lYv = false;
        this.lYw = Color.parseColor("#22000000");
        this.lYx = false;
        this.lYy = false;
        this.lYz = false;
        this.lXZ = new TextPaint();
        this.lXZ.setAntiAlias(true);
        this.lYK = a.dp2px(context, 4.0f);
        this.lYL = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lYM = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dtU();
        dtT();
    }

    private void dtT() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.lYa;
        options.outHeight = this.lYa;
        this.lXQ = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.lXR = Bitmap.createBitmap(this.lXQ, 0, 0, this.lXQ.getWidth(), this.lXQ.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lXS = Bitmap.createBitmap(this.lXQ, 0, 0, this.lXQ.getWidth(), this.lXQ.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.lXT = Bitmap.createBitmap(this.lXQ, 0, 0, this.lXQ.getWidth(), this.lXQ.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.lYb = typedArray.getDimensionPixelSize(i, this.lYb);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.lYa = typedArray.getDimensionPixelSize(i, this.lYa);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.lYe = typedArray.getDimensionPixelSize(i, this.lYe);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cfj = typedArray.getDimensionPixelSize(i, this.cfj);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.lYf = typedArray.getColor(i, this.lYf);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.lYg = typedArray.getDimensionPixelSize(i, this.lYg);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.lYh = typedArray.getBoolean(i, this.lYh);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.lYi = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.lYk = typedArray.getDimensionPixelSize(i, this.lYk);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.lYl = typedArray.getInteger(i, this.lYl);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.lYm = typedArray.getBoolean(i, this.lYm);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.lYn = typedArray.getDimensionPixelSize(i, this.lYn);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.lYd = typedArray.getDimensionPixelSize(i, this.lYd);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.lYo = typedArray.getBoolean(i, this.lYo);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.lYq = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.lYp = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.lYr = typedArray.getDimensionPixelSize(i, this.lYr);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.lYs = typedArray.getColor(i, this.lYs);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.lYt = typedArray.getBoolean(i, this.lYt);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.lYu = typedArray.getDimensionPixelSize(i, this.lYu);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.lYv = typedArray.getBoolean(i, this.lYv);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.lYx = typedArray.getBoolean(i, this.lYx);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.lYw = typedArray.getColor(i, this.lYw);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.lYy = typedArray.getBoolean(i, this.lYy);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.lYz = typedArray.getBoolean(i, this.lYz);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.lYA = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lYL = typedArray.getBoolean(i, this.lYL);
        }
    }

    private void dtU() {
        if (this.lYA != null) {
            this.lYG = ((BitmapDrawable) this.lYA).getBitmap();
        }
        if (this.lYG == null) {
            this.lYG = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lYG = a.g(this.lYG, this.lYf);
        }
        this.lYH = a.f(this.lYG, 90);
        this.lYH = a.f(this.lYH, 90);
        this.lYH = a.f(this.lYH, 90);
        if (this.lYi != null) {
            this.lYE = ((BitmapDrawable) this.lYi).getBitmap();
        }
        if (this.lYE == null) {
            this.lYE = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lYE = a.g(this.lYE, this.lYf);
        }
        this.lYF = a.f(this.lYE, 90);
        this.lYI = (1.0f * this.lYb) / 2.0f;
        this.lXZ.setTextSize(this.lYr);
        this.lXZ.setColor(this.lYs);
        setIsBarcode(this.lYo);
    }

    public void dtV() {
        this.lXZ.setColor(this.lYs);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lXW != null) {
            af(canvas);
            ag(canvas);
            ai(canvas);
            aj(canvas);
            ah(canvas);
            dtW();
        }
    }

    private void af(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.lXW.top, this.mPaint);
            canvas.drawRect(0.0f, this.lXW.top, this.lXW.left, this.lXW.bottom + 1, this.mPaint);
            canvas.drawRect(this.lXW.right + 1, this.lXW.top, width, this.lXW.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.lXW.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        if (this.lYk > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.lYk);
            canvas.drawRect(this.lXW, this.mPaint);
        }
    }

    private void ah(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lXQ, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lXR, getMainFrameRight() - this.lXQ.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lXS, getMainFrameLeft(), getMainFrameBottom() - this.lXQ.getHeight(), this.mPaint);
        canvas.drawBitmap(this.lXT, getMainFrameRight() - this.lXQ.getWidth(), getMainFrameBottom() - this.lXQ.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.lXW.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.lXW.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.lXW.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.lXW.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.lYk / 2;
    }

    private void ai(Canvas canvas) {
        if (this.lYo) {
            if (this.lYB != null) {
                RectF rectF = new RectF(this.lXW.left + this.lYI + 0.5f, this.lXW.top + this.lYI + this.lYg, this.lYD, (this.lXW.bottom - this.lYI) - this.lYg);
                Rect rect = new Rect((int) (this.lYB.getWidth() - rectF.width()), 0, this.lYB.getWidth(), this.lYB.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.lYB, rect, rectF, this.mPaint);
            } else if (this.lYj != null) {
                canvas.drawBitmap(this.lYj, (Rect) null, new RectF(this.lXY, this.lXW.top + this.lYI + this.lYg, this.lXY + this.lYj.getWidth(), (this.lXW.bottom - this.lYI) - this.lYg), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lYf);
                canvas.drawRect(this.lXY, this.lYg + this.lXW.top + this.lYI, this.lYe + this.lXY, (this.lXW.bottom - this.lYI) - this.lYg, this.mPaint);
            }
        } else if (this.lYB != null) {
            RectF rectF2 = new RectF(this.lXW.left + this.lYI + this.lYg, this.lXW.top + this.lYI + 0.5f, (this.lXW.right - this.lYI) - this.lYg, this.lYC);
            Rect rect2 = new Rect(0, (int) (this.lYB.getHeight() - rectF2.height()), this.lYB.getWidth(), this.lYB.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lYM);
            canvas.drawBitmap(this.lYB, rect2, rectF2, this.mPaint);
        } else if (this.lYj != null) {
            canvas.drawBitmap(this.lYj, (Rect) null, new RectF(this.lXW.left + this.lYI + this.lYg, this.lXX, (this.lXW.right - this.lYI) - this.lYg, this.lXX + this.lYj.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.lYf);
            canvas.drawRect(this.lYg + this.lXW.left + this.lYI, this.lXX, (this.lXW.right - this.lYI) - this.lYg, this.lYe + this.lXX, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kAM) && this.lYJ != null) {
            if (this.lYt) {
                if (this.lYx) {
                    this.mPaint.setColor(this.lYw);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.lYv) {
                        Rect rect = new Rect();
                        this.lXZ.getTextBounds(this.kAM, 0, this.kAM.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lYK;
                        canvas.drawRoundRect(new RectF(width, (this.lXW.bottom + this.lYu) - this.lYK, rect.width() + width + (this.lYK * 2), this.lXW.bottom + this.lYu + this.lYJ.getHeight() + this.lYK), this.lYK, this.lYK, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.lXW.left, (this.lXW.bottom + this.lYu) - this.lYK, this.lXW.right, this.lXW.bottom + this.lYu + this.lYJ.getHeight() + this.lYK), this.lYK, this.lYK, this.mPaint);
                    }
                }
                canvas.save();
                if (this.lYv) {
                    canvas.translate(0.0f, this.lXW.bottom + this.lYu);
                } else {
                    canvas.translate(this.lXW.left + this.lYK, this.lXW.bottom + this.lYu);
                }
                this.lYJ.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.lYx) {
                this.mPaint.setColor(this.lYw);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.lYv) {
                    Rect rect2 = new Rect();
                    this.lXZ.getTextBounds(this.kAM, 0, this.kAM.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lYK;
                    canvas.drawRoundRect(new RectF(width2, ((this.lXW.top - this.lYu) - this.lYJ.getHeight()) - this.lYK, rect2.width() + width2 + (this.lYK * 2), (this.lXW.top - this.lYu) + this.lYK), this.lYK, this.lYK, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.lXW.left, ((this.lXW.top - this.lYu) - this.lYJ.getHeight()) - this.lYK, this.lXW.right, (this.lXW.top - this.lYu) + this.lYK), this.lYK, this.lYK, this.mPaint);
                }
            }
            canvas.save();
            if (this.lYv) {
                canvas.translate(0.0f, (this.lXW.top - this.lYu) - this.lYJ.getHeight());
            } else {
                canvas.translate(this.lXW.left + this.lYK, (this.lXW.top - this.lYu) - this.lYJ.getHeight());
            }
            this.lYJ.draw(canvas);
            canvas.restore();
        }
    }

    private void dtW() {
        if (this.lYo) {
            if (this.lYB == null) {
                this.lXY += this.lXU;
                int i = this.lYe;
                if (this.lYj != null) {
                    i = this.lYj.getWidth();
                }
                if (this.lYy) {
                    if (i + this.lXY > this.lXW.right - this.lYI || this.lXY < this.lXW.left + this.lYI) {
                        this.lXU = -this.lXU;
                    }
                } else {
                    if (i + this.lXY > this.lXW.right - this.lYI) {
                        this.lXY = this.lXW.left + this.lYI + 0.5f;
                    }
                }
            } else {
                this.lYD += this.lXU;
                if (this.lYD > this.lXW.right - this.lYI) {
                    this.lYD = this.lXW.left + this.lYI + 0.5f;
                }
            }
        } else if (this.lYB == null) {
            this.lXX += this.lXU;
            int i2 = this.lYe;
            if (this.lYj != null) {
                i2 = this.lYj.getHeight();
            }
            if (this.lYy) {
                if (i2 + this.lXX > this.lXW.bottom - this.lYI || this.lXX < this.lXW.top + this.lYI) {
                    this.lXU = -this.lXU;
                }
            } else {
                if (i2 + this.lXX > this.lXW.bottom - this.lYI) {
                    this.lXX = this.lXW.top + this.lYI + 0.5f;
                }
            }
        } else {
            this.lYC += this.lXU;
            if (this.lYC > this.lXW.bottom - this.lYI) {
                this.lYC = this.lXW.top + this.lYI + 0.5f;
            }
        }
        postInvalidateDelayed(this.lXV, this.lXW.left, this.lXW.top, this.lXW.right, this.lXW.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dtX();
    }

    private void dtX() {
        int i;
        if (this.lYo) {
            i = this.mTopOffset + this.lYn;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cfj) / 2;
        this.lXW = new Rect(width, i, this.cfj + width, this.lYc + i);
        if (this.lYo) {
            float f = this.lXW.left + this.lYI + 0.5f;
            this.lXY = f;
            this.lYD = f;
            return;
        }
        float f2 = this.lXW.top + this.lYI + 0.5f;
        this.lXX = f2;
        this.lYC = f2;
    }

    public Rect Hg(int i) {
        if (this.lYL) {
            Rect rect = new Rect(this.lXW);
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
        this.lYo = z;
        if (this.lYA != null || this.lYz) {
            if (this.lYo) {
                this.lYB = this.lYH;
            } else {
                this.lYB = this.lYG;
            }
        } else if (this.lYi != null || this.lYh) {
            if (this.lYo) {
                this.lYj = this.lYF;
            } else {
                this.lYj = this.lYE;
            }
        }
        if (this.lYo) {
            this.kAM = this.lYq;
            this.lYc = this.lYd;
            this.lXV = (int) (((this.lYl * 1.0f) * this.lXU) / this.cfj);
        } else {
            this.kAM = this.lYp;
            this.lYc = this.cfj;
            this.lXV = (int) (((this.lYl * 1.0f) * this.lXU) / this.lYc);
        }
        if (!TextUtils.isEmpty(this.kAM)) {
            if (this.lYv) {
                this.lYJ = new StaticLayout(this.kAM, this.lXZ, a.fK(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lYJ = new StaticLayout(this.kAM, this.lXZ, this.cfj - (this.lYK * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.lYm) {
            int i = a.fK(getContext()).y;
            if (this.lYn == 0) {
                this.mTopOffset = (i - this.lYc) / 2;
            } else if (this.lYo) {
                this.mTopOffset = ((i - this.lYc) / 2) + (this.lYn / 2);
            } else {
                this.mTopOffset = (i - this.lYc) / 2;
            }
        }
        dtX();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.lYo;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.lYa;
    }

    public void setCornerLength(int i) {
        this.lYa = i;
    }

    public int getCornerSize() {
        return this.lYb;
    }

    public void setCornerSize(int i) {
        this.lYb = i;
    }

    public int getRectWidth() {
        return this.cfj;
    }

    public void setRectWidth(int i) {
        this.cfj = i;
    }

    public int getRectHeight() {
        return this.lYc;
    }

    public void setRectHeight(int i) {
        this.lYc = i;
    }

    public int getBarcodeRectHeight() {
        return this.lYd;
    }

    public void setBarcodeRectHeight(int i) {
        this.lYd = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lYe;
    }

    public void setScanLineSize(int i) {
        this.lYe = i;
    }

    public int getScanLineColor() {
        return this.lYf;
    }

    public void setScanLineColor(int i) {
        this.lYf = i;
    }

    public int getScanLineMargin() {
        return this.lYg;
    }

    public void setScanLineMargin(int i) {
        this.lYg = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.lYh = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.lYi;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.lYi = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.lYj;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.lYj = bitmap;
    }

    public int getBorderSize() {
        return this.lYk;
    }

    public void setBorderSize(int i) {
        this.lYk = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.lYl;
    }

    public void setAnimTime(int i) {
        this.lYl = i;
    }

    public void setCenterVertical(boolean z) {
        this.lYm = z;
    }

    public int getToolbarHeight() {
        return this.lYn;
    }

    public void setToolbarHeight(int i) {
        this.lYn = i;
    }

    public String getQRCodeTipText() {
        return this.lYp;
    }

    public void setQRCodeTipText(String str) {
        this.lYp = str;
    }

    public String getBarCodeTipText() {
        return this.lYq;
    }

    public void setBarCodeTipText(String str) {
        this.lYq = str;
    }

    public String getTipText() {
        return this.kAM;
    }

    public void setTipText(String str) {
        this.kAM = str;
    }

    public int getTipTextColor() {
        return this.lYs;
    }

    public void setTipTextColor(int i) {
        this.lYs = i;
    }

    public int getTipTextSize() {
        return this.lYr;
    }

    public void setTipTextSize(int i) {
        this.lYr = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.lYt = z;
    }

    public int getTipTextMargin() {
        return this.lYu;
    }

    public void setTipTextMargin(int i) {
        this.lYu = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.lYv = z;
    }

    public void setShowTipBackground(boolean z) {
        this.lYx = z;
    }

    public int getTipBackgroundColor() {
        return this.lYw;
    }

    public void setTipBackgroundColor(int i) {
        this.lYw = i;
    }

    public void setScanLineReverse(boolean z) {
        this.lYy = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.lYz = z;
    }

    public float getHalfCornerSize() {
        return this.lYI;
    }

    public void setHalfCornerSize(float f) {
        this.lYI = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lYJ;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lYJ = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lYK;
    }

    public void setTipBackgroundRadius(int i) {
        this.lYK = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lYL = z;
    }
}
