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
    private int bSV;
    private String klA;
    private Bitmap lIC;
    private Bitmap lID;
    private Bitmap lIE;
    private Bitmap lIF;
    private int lIG;
    private int lIH;
    private Rect lII;
    private float lIJ;
    private float lIK;
    private TextPaint lIL;
    private int lIM;
    private int lIN;
    private int lIO;
    private int lIP;
    private int lIQ;
    private int lIR;
    private int lIS;
    private boolean lIT;
    private Drawable lIU;
    private Bitmap lIV;
    private int lIW;
    private int lIX;
    private boolean lIY;
    private int lIZ;
    private boolean lJa;
    private String lJb;
    private String lJc;
    private int lJd;
    private int lJe;
    private boolean lJf;
    private int lJg;
    private boolean lJh;
    private int lJi;
    private boolean lJj;
    private boolean lJk;
    private boolean lJl;
    private Drawable lJm;
    private Bitmap lJn;
    private float lJo;
    private float lJp;
    private Bitmap lJq;
    private Bitmap lJr;
    private Bitmap lJs;
    private Bitmap lJt;
    private float lJu;
    private StaticLayout lJv;
    private int lJw;
    private boolean lJx;
    private ColorMatrixColorFilter lJy;
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
        this.lIM = a.dp2px(context, 20.0f);
        this.lIN = a.dp2px(context, 3.0f);
        this.lIQ = a.dp2px(context, 1.0f);
        this.lIR = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bSV = a.dp2px(context, 200.0f);
        this.lIP = a.dp2px(context, 140.0f);
        this.lIS = 0;
        this.lIT = false;
        this.lIU = null;
        this.lIV = null;
        this.lIW = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.lIX = 1000;
        this.lIY = false;
        this.lIZ = 0;
        this.lJa = false;
        this.lIG = a.dp2px(context, 2.0f);
        this.klA = null;
        this.lJd = a.h(context, 14.0f);
        this.lJe = -1;
        this.lJf = false;
        this.lJg = a.dp2px(context, 20.0f);
        this.lJh = false;
        this.lJi = Color.parseColor("#22000000");
        this.lJj = false;
        this.lJk = false;
        this.lJl = false;
        this.lIL = new TextPaint();
        this.lIL.setAntiAlias(true);
        this.lJw = a.dp2px(context, 4.0f);
        this.lJx = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lJy = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dqj();
        dqi();
    }

    private void dqi() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.lIM;
        options.outHeight = this.lIM;
        this.lIC = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.lID = Bitmap.createBitmap(this.lIC, 0, 0, this.lIC.getWidth(), this.lIC.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lIE = Bitmap.createBitmap(this.lIC, 0, 0, this.lIC.getWidth(), this.lIC.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.lIF = Bitmap.createBitmap(this.lIC, 0, 0, this.lIC.getWidth(), this.lIC.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.lIN = typedArray.getDimensionPixelSize(i, this.lIN);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.lIM = typedArray.getDimensionPixelSize(i, this.lIM);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.lIQ = typedArray.getDimensionPixelSize(i, this.lIQ);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.bSV = typedArray.getDimensionPixelSize(i, this.bSV);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.lIR = typedArray.getColor(i, this.lIR);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.lIS = typedArray.getDimensionPixelSize(i, this.lIS);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.lIT = typedArray.getBoolean(i, this.lIT);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.lIU = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.lIW = typedArray.getDimensionPixelSize(i, this.lIW);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.lIX = typedArray.getInteger(i, this.lIX);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.lIY = typedArray.getBoolean(i, this.lIY);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.lIZ = typedArray.getDimensionPixelSize(i, this.lIZ);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.lIP = typedArray.getDimensionPixelSize(i, this.lIP);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.lJa = typedArray.getBoolean(i, this.lJa);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.lJc = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.lJb = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.lJd = typedArray.getDimensionPixelSize(i, this.lJd);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.lJe = typedArray.getColor(i, this.lJe);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.lJf = typedArray.getBoolean(i, this.lJf);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.lJg = typedArray.getDimensionPixelSize(i, this.lJg);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.lJh = typedArray.getBoolean(i, this.lJh);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.lJj = typedArray.getBoolean(i, this.lJj);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.lJi = typedArray.getColor(i, this.lJi);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.lJk = typedArray.getBoolean(i, this.lJk);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.lJl = typedArray.getBoolean(i, this.lJl);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.lJm = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.lJx = typedArray.getBoolean(i, this.lJx);
        }
    }

    private void dqj() {
        if (this.lJm != null) {
            this.lJs = ((BitmapDrawable) this.lJm).getBitmap();
        }
        if (this.lJs == null) {
            this.lJs = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lJs = a.g(this.lJs, this.lIR);
        }
        this.lJt = a.f(this.lJs, 90);
        this.lJt = a.f(this.lJt, 90);
        this.lJt = a.f(this.lJt, 90);
        if (this.lIU != null) {
            this.lJq = ((BitmapDrawable) this.lIU).getBitmap();
        }
        if (this.lJq == null) {
            this.lJq = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lJq = a.g(this.lJq, this.lIR);
        }
        this.lJr = a.f(this.lJq, 90);
        this.lJu = (1.0f * this.lIN) / 2.0f;
        this.lIL.setTextSize(this.lJd);
        this.lIL.setColor(this.lJe);
        setIsBarcode(this.lJa);
    }

    public void dqk() {
        this.lIL.setColor(this.lJe);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lII != null) {
            ae(canvas);
            af(canvas);
            ah(canvas);
            ai(canvas);
            ag(canvas);
            dql();
        }
    }

    private void ae(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.lII.top, this.mPaint);
            canvas.drawRect(0.0f, this.lII.top, this.lII.left, this.lII.bottom + 1, this.mPaint);
            canvas.drawRect(this.lII.right + 1, this.lII.top, width, this.lII.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.lII.bottom + 1, width, height, this.mPaint);
        }
    }

    private void af(Canvas canvas) {
        if (this.lIW > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.lIW);
            canvas.drawRect(this.lII, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lIC, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lID, getMainFrameRight() - this.lIC.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lIE, getMainFrameLeft(), getMainFrameBottom() - this.lIC.getHeight(), this.mPaint);
        canvas.drawBitmap(this.lIF, getMainFrameRight() - this.lIC.getWidth(), getMainFrameBottom() - this.lIC.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.lII.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.lII.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.lII.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.lII.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.lIW / 2;
    }

    private void ah(Canvas canvas) {
        if (this.lJa) {
            if (this.lJn != null) {
                RectF rectF = new RectF(this.lII.left + this.lJu + 0.5f, this.lII.top + this.lJu + this.lIS, this.lJp, (this.lII.bottom - this.lJu) - this.lIS);
                Rect rect = new Rect((int) (this.lJn.getWidth() - rectF.width()), 0, this.lJn.getWidth(), this.lJn.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.lJn, rect, rectF, this.mPaint);
            } else if (this.lIV != null) {
                canvas.drawBitmap(this.lIV, (Rect) null, new RectF(this.lIK, this.lII.top + this.lJu + this.lIS, this.lIK + this.lIV.getWidth(), (this.lII.bottom - this.lJu) - this.lIS), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lIR);
                canvas.drawRect(this.lIK, this.lIS + this.lII.top + this.lJu, this.lIQ + this.lIK, (this.lII.bottom - this.lJu) - this.lIS, this.mPaint);
            }
        } else if (this.lJn != null) {
            RectF rectF2 = new RectF(this.lII.left + this.lJu + this.lIS, this.lII.top + this.lJu + 0.5f, (this.lII.right - this.lJu) - this.lIS, this.lJo);
            Rect rect2 = new Rect(0, (int) (this.lJn.getHeight() - rectF2.height()), this.lJn.getWidth(), this.lJn.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lJy);
            canvas.drawBitmap(this.lJn, rect2, rectF2, this.mPaint);
        } else if (this.lIV != null) {
            canvas.drawBitmap(this.lIV, (Rect) null, new RectF(this.lII.left + this.lJu + this.lIS, this.lIJ, (this.lII.right - this.lJu) - this.lIS, this.lIJ + this.lIV.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.lIR);
            canvas.drawRect(this.lIS + this.lII.left + this.lJu, this.lIJ, (this.lII.right - this.lJu) - this.lIS, this.lIQ + this.lIJ, this.mPaint);
        }
    }

    private void ai(Canvas canvas) {
        if (!TextUtils.isEmpty(this.klA) && this.lJv != null) {
            if (this.lJf) {
                if (this.lJj) {
                    this.mPaint.setColor(this.lJi);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.lJh) {
                        Rect rect = new Rect();
                        this.lIL.getTextBounds(this.klA, 0, this.klA.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lJw;
                        canvas.drawRoundRect(new RectF(width, (this.lII.bottom + this.lJg) - this.lJw, rect.width() + width + (this.lJw * 2), this.lII.bottom + this.lJg + this.lJv.getHeight() + this.lJw), this.lJw, this.lJw, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.lII.left, (this.lII.bottom + this.lJg) - this.lJw, this.lII.right, this.lII.bottom + this.lJg + this.lJv.getHeight() + this.lJw), this.lJw, this.lJw, this.mPaint);
                    }
                }
                canvas.save();
                if (this.lJh) {
                    canvas.translate(0.0f, this.lII.bottom + this.lJg);
                } else {
                    canvas.translate(this.lII.left + this.lJw, this.lII.bottom + this.lJg);
                }
                this.lJv.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.lJj) {
                this.mPaint.setColor(this.lJi);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.lJh) {
                    Rect rect2 = new Rect();
                    this.lIL.getTextBounds(this.klA, 0, this.klA.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lJw;
                    canvas.drawRoundRect(new RectF(width2, ((this.lII.top - this.lJg) - this.lJv.getHeight()) - this.lJw, rect2.width() + width2 + (this.lJw * 2), (this.lII.top - this.lJg) + this.lJw), this.lJw, this.lJw, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.lII.left, ((this.lII.top - this.lJg) - this.lJv.getHeight()) - this.lJw, this.lII.right, (this.lII.top - this.lJg) + this.lJw), this.lJw, this.lJw, this.mPaint);
                }
            }
            canvas.save();
            if (this.lJh) {
                canvas.translate(0.0f, (this.lII.top - this.lJg) - this.lJv.getHeight());
            } else {
                canvas.translate(this.lII.left + this.lJw, (this.lII.top - this.lJg) - this.lJv.getHeight());
            }
            this.lJv.draw(canvas);
            canvas.restore();
        }
    }

    private void dql() {
        if (this.lJa) {
            if (this.lJn == null) {
                this.lIK += this.lIG;
                int i = this.lIQ;
                if (this.lIV != null) {
                    i = this.lIV.getWidth();
                }
                if (this.lJk) {
                    if (i + this.lIK > this.lII.right - this.lJu || this.lIK < this.lII.left + this.lJu) {
                        this.lIG = -this.lIG;
                    }
                } else {
                    if (i + this.lIK > this.lII.right - this.lJu) {
                        this.lIK = this.lII.left + this.lJu + 0.5f;
                    }
                }
            } else {
                this.lJp += this.lIG;
                if (this.lJp > this.lII.right - this.lJu) {
                    this.lJp = this.lII.left + this.lJu + 0.5f;
                }
            }
        } else if (this.lJn == null) {
            this.lIJ += this.lIG;
            int i2 = this.lIQ;
            if (this.lIV != null) {
                i2 = this.lIV.getHeight();
            }
            if (this.lJk) {
                if (i2 + this.lIJ > this.lII.bottom - this.lJu || this.lIJ < this.lII.top + this.lJu) {
                    this.lIG = -this.lIG;
                }
            } else {
                if (i2 + this.lIJ > this.lII.bottom - this.lJu) {
                    this.lIJ = this.lII.top + this.lJu + 0.5f;
                }
            }
        } else {
            this.lJo += this.lIG;
            if (this.lJo > this.lII.bottom - this.lJu) {
                this.lJo = this.lII.top + this.lJu + 0.5f;
            }
        }
        postInvalidateDelayed(this.lIH, this.lII.left, this.lII.top, this.lII.right, this.lII.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dqm();
    }

    private void dqm() {
        int i;
        if (this.lJa) {
            i = this.mTopOffset + this.lIZ;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bSV) / 2;
        this.lII = new Rect(width, i, this.bSV + width, this.lIO + i);
        if (this.lJa) {
            float f = this.lII.left + this.lJu + 0.5f;
            this.lIK = f;
            this.lJp = f;
            return;
        }
        float f2 = this.lII.top + this.lJu + 0.5f;
        this.lIJ = f2;
        this.lJo = f2;
    }

    public Rect GA(int i) {
        if (this.lJx) {
            Rect rect = new Rect(this.lII);
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
        this.lJa = z;
        if (this.lJm != null || this.lJl) {
            if (this.lJa) {
                this.lJn = this.lJt;
            } else {
                this.lJn = this.lJs;
            }
        } else if (this.lIU != null || this.lIT) {
            if (this.lJa) {
                this.lIV = this.lJr;
            } else {
                this.lIV = this.lJq;
            }
        }
        if (this.lJa) {
            this.klA = this.lJc;
            this.lIO = this.lIP;
            this.lIH = (int) (((this.lIX * 1.0f) * this.lIG) / this.bSV);
        } else {
            this.klA = this.lJb;
            this.lIO = this.bSV;
            this.lIH = (int) (((this.lIX * 1.0f) * this.lIG) / this.lIO);
        }
        if (!TextUtils.isEmpty(this.klA)) {
            if (this.lJh) {
                this.lJv = new StaticLayout(this.klA, this.lIL, a.fD(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lJv = new StaticLayout(this.klA, this.lIL, this.bSV - (this.lJw * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.lIY) {
            int i = a.fD(getContext()).y;
            if (this.lIZ == 0) {
                this.mTopOffset = (i - this.lIO) / 2;
            } else if (this.lJa) {
                this.mTopOffset = ((i - this.lIO) / 2) + (this.lIZ / 2);
            } else {
                this.mTopOffset = (i - this.lIO) / 2;
            }
        }
        dqm();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.lJa;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.lIM;
    }

    public void setCornerLength(int i) {
        this.lIM = i;
    }

    public int getCornerSize() {
        return this.lIN;
    }

    public void setCornerSize(int i) {
        this.lIN = i;
    }

    public int getRectWidth() {
        return this.bSV;
    }

    public void setRectWidth(int i) {
        this.bSV = i;
    }

    public int getRectHeight() {
        return this.lIO;
    }

    public void setRectHeight(int i) {
        this.lIO = i;
    }

    public int getBarcodeRectHeight() {
        return this.lIP;
    }

    public void setBarcodeRectHeight(int i) {
        this.lIP = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lIQ;
    }

    public void setScanLineSize(int i) {
        this.lIQ = i;
    }

    public int getScanLineColor() {
        return this.lIR;
    }

    public void setScanLineColor(int i) {
        this.lIR = i;
    }

    public int getScanLineMargin() {
        return this.lIS;
    }

    public void setScanLineMargin(int i) {
        this.lIS = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.lIT = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.lIU;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.lIU = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.lIV;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.lIV = bitmap;
    }

    public int getBorderSize() {
        return this.lIW;
    }

    public void setBorderSize(int i) {
        this.lIW = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.lIX;
    }

    public void setAnimTime(int i) {
        this.lIX = i;
    }

    public void setCenterVertical(boolean z) {
        this.lIY = z;
    }

    public int getToolbarHeight() {
        return this.lIZ;
    }

    public void setToolbarHeight(int i) {
        this.lIZ = i;
    }

    public String getQRCodeTipText() {
        return this.lJb;
    }

    public void setQRCodeTipText(String str) {
        this.lJb = str;
    }

    public String getBarCodeTipText() {
        return this.lJc;
    }

    public void setBarCodeTipText(String str) {
        this.lJc = str;
    }

    public String getTipText() {
        return this.klA;
    }

    public void setTipText(String str) {
        this.klA = str;
    }

    public int getTipTextColor() {
        return this.lJe;
    }

    public void setTipTextColor(int i) {
        this.lJe = i;
    }

    public int getTipTextSize() {
        return this.lJd;
    }

    public void setTipTextSize(int i) {
        this.lJd = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.lJf = z;
    }

    public int getTipTextMargin() {
        return this.lJg;
    }

    public void setTipTextMargin(int i) {
        this.lJg = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.lJh = z;
    }

    public void setShowTipBackground(boolean z) {
        this.lJj = z;
    }

    public int getTipBackgroundColor() {
        return this.lJi;
    }

    public void setTipBackgroundColor(int i) {
        this.lJi = i;
    }

    public void setScanLineReverse(boolean z) {
        this.lJk = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.lJl = z;
    }

    public float getHalfCornerSize() {
        return this.lJu;
    }

    public void setHalfCornerSize(float f) {
        this.lJu = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lJv;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lJv = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lJw;
    }

    public void setTipBackgroundRadius(int i) {
        this.lJw = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lJx = z;
    }
}
