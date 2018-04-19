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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ScanBoxView extends View {
    private int aOp;
    private int alS;
    private String eMr;
    private int fUA;
    private int fUB;
    private int fUC;
    private int fUD;
    private int fUE;
    private boolean fUF;
    private Drawable fUG;
    private Bitmap fUH;
    private int fUI;
    private int fUJ;
    private boolean fUK;
    private int fUL;
    private boolean fUM;
    private String fUN;
    private String fUO;
    private int fUP;
    private int fUQ;
    private boolean fUR;
    private int fUS;
    private boolean fUT;
    private int fUU;
    private boolean fUV;
    private boolean fUW;
    private boolean fUX;
    private Drawable fUY;
    private Bitmap fUZ;
    private Bitmap fUn;
    private Bitmap fUo;
    private Bitmap fUp;
    private Bitmap fUq;
    private int fUr;
    private int fUs;
    private Rect fUt;
    private float fUu;
    private float fUv;
    private TextPaint fUw;
    private int fUx;
    private int fUy;
    private int fUz;
    private float fVa;
    private float fVb;
    private Bitmap fVc;
    private Bitmap fVd;
    private Bitmap fVe;
    private Bitmap fVf;
    private float fVg;
    private StaticLayout fVh;
    private int fVi;
    private boolean fVj;
    private ColorMatrixColorFilter fVk;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.alS = Color.parseColor("#33FFFFFF");
        this.fUx = a.f(context, 20.0f);
        this.fUy = a.f(context, 3.0f);
        this.fUC = a.f(context, 1.0f);
        this.fUD = -1;
        this.aOp = a.f(context, 90.0f);
        this.fUz = a.f(context, 200.0f);
        this.fUB = a.f(context, 140.0f);
        this.fUE = 0;
        this.fUF = false;
        this.fUG = null;
        this.fUH = null;
        this.fUI = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.fUJ = 1000;
        this.fUK = false;
        this.fUL = 0;
        this.fUM = false;
        this.fUr = a.f(context, 2.0f);
        this.eMr = null;
        this.fUP = a.e(context, 14.0f);
        this.fUQ = -1;
        this.fUR = false;
        this.fUS = a.f(context, 20.0f);
        this.fUT = false;
        this.fUU = Color.parseColor("#22000000");
        this.fUV = false;
        this.fUW = false;
        this.fUX = false;
        this.fUw = new TextPaint();
        this.fUw.setAntiAlias(true);
        this.fVi = a.f(context, 4.0f);
        this.fVj = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.fVk = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        biE();
        biD();
    }

    private void biD() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.fUx;
        options.outHeight = this.fUx;
        this.fUn = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.fUo = Bitmap.createBitmap(this.fUn, 0, 0, this.fUn.getWidth(), this.fUn.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.fUp = Bitmap.createBitmap(this.fUn, 0, 0, this.fUn.getWidth(), this.fUn.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.fUq = Bitmap.createBitmap(this.fUn, 0, 0, this.fUn.getWidth(), this.fUn.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.m.QRCodeView_qrcv_topOffset) {
            this.aOp = typedArray.getDimensionPixelSize(i, this.aOp);
        } else if (i == d.m.QRCodeView_qrcv_cornerSize) {
            this.fUy = typedArray.getDimensionPixelSize(i, this.fUy);
        } else if (i == d.m.QRCodeView_qrcv_cornerLength) {
            this.fUx = typedArray.getDimensionPixelSize(i, this.fUx);
        } else if (i == d.m.QRCodeView_qrcv_scanLineSize) {
            this.fUC = typedArray.getDimensionPixelSize(i, this.fUC);
        } else if (i == d.m.QRCodeView_qrcv_rectWidth) {
            this.fUz = typedArray.getDimensionPixelSize(i, this.fUz);
        } else if (i == d.m.QRCodeView_qrcv_maskColor) {
            this.alS = typedArray.getColor(i, this.alS);
        } else if (i == d.m.QRCodeView_qrcv_scanLineColor) {
            this.fUD = typedArray.getColor(i, this.fUD);
        } else if (i == d.m.QRCodeView_qrcv_scanLineMargin) {
            this.fUE = typedArray.getDimensionPixelSize(i, this.fUE);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.fUF = typedArray.getBoolean(i, this.fUF);
        } else if (i == d.m.QRCodeView_qrcv_customScanLineDrawable) {
            this.fUG = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_borderSize) {
            this.fUI = typedArray.getDimensionPixelSize(i, this.fUI);
        } else if (i == d.m.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.m.QRCodeView_qrcv_animTime) {
            this.fUJ = typedArray.getInteger(i, this.fUJ);
        } else if (i == d.m.QRCodeView_qrcv_isCenterVertical) {
            this.fUK = typedArray.getBoolean(i, this.fUK);
        } else if (i == d.m.QRCodeView_qrcv_toolbarHeight) {
            this.fUL = typedArray.getDimensionPixelSize(i, this.fUL);
        } else if (i == d.m.QRCodeView_qrcv_barcodeRectHeight) {
            this.fUB = typedArray.getDimensionPixelSize(i, this.fUB);
        } else if (i == d.m.QRCodeView_qrcv_isBarcode) {
            this.fUM = typedArray.getBoolean(i, this.fUM);
        } else if (i == d.m.QRCodeView_qrcv_barCodeTipText) {
            this.fUO = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_qrCodeTipText) {
            this.fUN = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_tipTextSize) {
            this.fUP = typedArray.getDimensionPixelSize(i, this.fUP);
        } else if (i == d.m.QRCodeView_qrcv_tipTextColor) {
            this.fUQ = typedArray.getColor(i, this.fUQ);
        } else if (i == d.m.QRCodeView_qrcv_isTipTextBelowRect) {
            this.fUR = typedArray.getBoolean(i, this.fUR);
        } else if (i == d.m.QRCodeView_qrcv_tipTextMargin) {
            this.fUS = typedArray.getDimensionPixelSize(i, this.fUS);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.fUT = typedArray.getBoolean(i, this.fUT);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipBackground) {
            this.fUV = typedArray.getBoolean(i, this.fUV);
        } else if (i == d.m.QRCodeView_qrcv_tipBackgroundColor) {
            this.fUU = typedArray.getColor(i, this.fUU);
        } else if (i == d.m.QRCodeView_qrcv_isScanLineReverse) {
            this.fUW = typedArray.getBoolean(i, this.fUW);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.fUX = typedArray.getBoolean(i, this.fUX);
        } else if (i == d.m.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.fUY = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.fVj = typedArray.getBoolean(i, this.fVj);
        }
    }

    private void biE() {
        if (this.fUY != null) {
            this.fVe = ((BitmapDrawable) this.fUY).getBitmap();
        }
        if (this.fVe == null) {
            this.fVe = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fVe = a.d(this.fVe, this.fUD);
        }
        this.fVf = a.c(this.fVe, 90);
        this.fVf = a.c(this.fVf, 90);
        this.fVf = a.c(this.fVf, 90);
        if (this.fUG != null) {
            this.fVc = ((BitmapDrawable) this.fUG).getBitmap();
        }
        if (this.fVc == null) {
            this.fVc = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fVc = a.d(this.fVc, this.fUD);
        }
        this.fVd = a.c(this.fVc, 90);
        this.fVg = (1.0f * this.fUy) / 2.0f;
        this.fUw.setTextSize(this.fUP);
        this.fUw.setColor(this.fUQ);
        setIsBarcode(this.fUM);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.fUt != null) {
            z(canvas);
            A(canvas);
            C(canvas);
            D(canvas);
            B(canvas);
            biF();
        }
    }

    private void z(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.alS != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.alS);
            canvas.drawRect(0.0f, 0.0f, width, this.fUt.top, this.mPaint);
            canvas.drawRect(0.0f, this.fUt.top, this.fUt.left, this.fUt.bottom + 1, this.mPaint);
            canvas.drawRect(this.fUt.right + 1, this.fUt.top, width, this.fUt.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.fUt.bottom + 1, width, height, this.mPaint);
        }
    }

    private void A(Canvas canvas) {
        if (this.fUI > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.fUI);
            canvas.drawRect(this.fUt, this.mPaint);
        }
    }

    private void B(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.fUn, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fUo, getMainFrameRight() - this.fUn.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fUp, getMainFrameLeft(), getMainFrameBottom() - this.fUn.getHeight(), this.mPaint);
        canvas.drawBitmap(this.fUq, getMainFrameRight() - this.fUn.getWidth(), getMainFrameBottom() - this.fUn.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.fUt.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.fUt.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.fUt.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.fUt.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.fUI / 2;
    }

    private void C(Canvas canvas) {
        if (this.fUM) {
            if (this.fUZ != null) {
                RectF rectF = new RectF(this.fUt.left + this.fVg + 0.5f, this.fUt.top + this.fVg + this.fUE, this.fVb, (this.fUt.bottom - this.fVg) - this.fUE);
                Rect rect = new Rect((int) (this.fUZ.getWidth() - rectF.width()), 0, this.fUZ.getWidth(), this.fUZ.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.fUZ, rect, rectF, this.mPaint);
            } else if (this.fUH != null) {
                canvas.drawBitmap(this.fUH, (Rect) null, new RectF(this.fUv, this.fUt.top + this.fVg + this.fUE, this.fUv + this.fUH.getWidth(), (this.fUt.bottom - this.fVg) - this.fUE), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.fUD);
                canvas.drawRect(this.fUv, this.fUE + this.fUt.top + this.fVg, this.fUC + this.fUv, (this.fUt.bottom - this.fVg) - this.fUE, this.mPaint);
            }
        } else if (this.fUZ != null) {
            RectF rectF2 = new RectF(this.fUt.left + this.fVg + this.fUE, this.fUt.top + this.fVg + 0.5f, (this.fUt.right - this.fVg) - this.fUE, this.fVa);
            Rect rect2 = new Rect(0, (int) (this.fUZ.getHeight() - rectF2.height()), this.fUZ.getWidth(), this.fUZ.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.fVk);
            canvas.drawBitmap(this.fUZ, rect2, rectF2, this.mPaint);
        } else if (this.fUH != null) {
            canvas.drawBitmap(this.fUH, (Rect) null, new RectF(this.fUt.left + this.fVg + this.fUE, this.fUu, (this.fUt.right - this.fVg) - this.fUE, this.fUu + this.fUH.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.fUD);
            canvas.drawRect(this.fUE + this.fUt.left + this.fVg, this.fUu, (this.fUt.right - this.fVg) - this.fUE, this.fUC + this.fUu, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (!TextUtils.isEmpty(this.eMr) && this.fVh != null) {
            if (this.fUR) {
                if (this.fUV) {
                    this.mPaint.setColor(this.fUU);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.fUT) {
                        Rect rect = new Rect();
                        this.fUw.getTextBounds(this.eMr, 0, this.eMr.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.fVi;
                        canvas.drawRoundRect(new RectF(width, (this.fUt.bottom + this.fUS) - this.fVi, rect.width() + width + (this.fVi * 2), this.fUt.bottom + this.fUS + this.fVh.getHeight() + this.fVi), this.fVi, this.fVi, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.fUt.left, (this.fUt.bottom + this.fUS) - this.fVi, this.fUt.right, this.fUt.bottom + this.fUS + this.fVh.getHeight() + this.fVi), this.fVi, this.fVi, this.mPaint);
                    }
                }
                canvas.save();
                if (this.fUT) {
                    canvas.translate(0.0f, this.fUt.bottom + this.fUS);
                } else {
                    canvas.translate(this.fUt.left + this.fVi, this.fUt.bottom + this.fUS);
                }
                this.fVh.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.fUV) {
                this.mPaint.setColor(this.fUU);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.fUT) {
                    Rect rect2 = new Rect();
                    this.fUw.getTextBounds(this.eMr, 0, this.eMr.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.fVi;
                    canvas.drawRoundRect(new RectF(width2, ((this.fUt.top - this.fUS) - this.fVh.getHeight()) - this.fVi, rect2.width() + width2 + (this.fVi * 2), (this.fUt.top - this.fUS) + this.fVi), this.fVi, this.fVi, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.fUt.left, ((this.fUt.top - this.fUS) - this.fVh.getHeight()) - this.fVi, this.fUt.right, (this.fUt.top - this.fUS) + this.fVi), this.fVi, this.fVi, this.mPaint);
                }
            }
            canvas.save();
            if (this.fUT) {
                canvas.translate(0.0f, (this.fUt.top - this.fUS) - this.fVh.getHeight());
            } else {
                canvas.translate(this.fUt.left + this.fVi, (this.fUt.top - this.fUS) - this.fVh.getHeight());
            }
            this.fVh.draw(canvas);
            canvas.restore();
        }
    }

    private void biF() {
        if (this.fUM) {
            if (this.fUZ == null) {
                this.fUv += this.fUr;
                int i = this.fUC;
                if (this.fUH != null) {
                    i = this.fUH.getWidth();
                }
                if (this.fUW) {
                    if (i + this.fUv > this.fUt.right - this.fVg || this.fUv < this.fUt.left + this.fVg) {
                        this.fUr = -this.fUr;
                    }
                } else {
                    if (i + this.fUv > this.fUt.right - this.fVg) {
                        this.fUv = this.fUt.left + this.fVg + 0.5f;
                    }
                }
            } else {
                this.fVb += this.fUr;
                if (this.fVb > this.fUt.right - this.fVg) {
                    this.fVb = this.fUt.left + this.fVg + 0.5f;
                }
            }
        } else if (this.fUZ == null) {
            this.fUu += this.fUr;
            int i2 = this.fUC;
            if (this.fUH != null) {
                i2 = this.fUH.getHeight();
            }
            if (this.fUW) {
                if (i2 + this.fUu > this.fUt.bottom - this.fVg || this.fUu < this.fUt.top + this.fVg) {
                    this.fUr = -this.fUr;
                }
            } else {
                if (i2 + this.fUu > this.fUt.bottom - this.fVg) {
                    this.fUu = this.fUt.top + this.fVg + 0.5f;
                }
            }
        } else {
            this.fVa += this.fUr;
            if (this.fVa > this.fUt.bottom - this.fVg) {
                this.fVa = this.fUt.top + this.fVg + 0.5f;
            }
        }
        postInvalidateDelayed(this.fUs, this.fUt.left, this.fUt.top, this.fUt.right, this.fUt.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        biG();
    }

    private void biG() {
        int i = this.aOp + this.fUL;
        int width = (getWidth() - this.fUz) / 2;
        this.fUt = new Rect(width, i, this.fUz + width, this.fUA + i);
        if (this.fUM) {
            float f = this.fUt.left + this.fVg + 0.5f;
            this.fUv = f;
            this.fVb = f;
            return;
        }
        float f2 = this.fUt.top + this.fVg + 0.5f;
        this.fUu = f2;
        this.fVa = f2;
    }

    public Rect rJ(int i) {
        if (this.fVj) {
            Rect rect = new Rect(this.fUt);
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
        this.fUM = z;
        if (this.fUY != null || this.fUX) {
            if (this.fUM) {
                this.fUZ = this.fVf;
            } else {
                this.fUZ = this.fVe;
            }
        } else if (this.fUG != null || this.fUF) {
            if (this.fUM) {
                this.fUH = this.fVd;
            } else {
                this.fUH = this.fVc;
            }
        }
        if (this.fUM) {
            this.eMr = this.fUO;
            this.fUA = this.fUB;
            this.fUs = (int) (((this.fUJ * 1.0f) * this.fUr) / this.fUz);
        } else {
            this.eMr = this.fUN;
            this.fUA = this.fUz;
            this.fUs = (int) (((this.fUJ * 1.0f) * this.fUr) / this.fUA);
        }
        if (!TextUtils.isEmpty(this.eMr)) {
            if (this.fUT) {
                this.fVh = new StaticLayout(this.eMr, this.fUw, a.bR(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.fVh = new StaticLayout(this.eMr, this.fUw, this.fUz - (this.fVi * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.fUK) {
            int i = a.bR(getContext()).y;
            if (this.fUL == 0) {
                this.aOp = (i - this.fUA) / 2;
            } else {
                this.aOp = ((i - this.fUA) / 2) + (this.fUL / 2);
            }
        }
        biG();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.fUM;
    }

    public int getMaskColor() {
        return this.alS;
    }

    public void setMaskColor(int i) {
        this.alS = i;
    }

    public int getCornerLength() {
        return this.fUx;
    }

    public void setCornerLength(int i) {
        this.fUx = i;
    }

    public int getCornerSize() {
        return this.fUy;
    }

    public void setCornerSize(int i) {
        this.fUy = i;
    }

    public int getRectWidth() {
        return this.fUz;
    }

    public void setRectWidth(int i) {
        this.fUz = i;
    }

    public int getRectHeight() {
        return this.fUA;
    }

    public void setRectHeight(int i) {
        this.fUA = i;
    }

    public int getBarcodeRectHeight() {
        return this.fUB;
    }

    public void setBarcodeRectHeight(int i) {
        this.fUB = i;
    }

    public int getTopOffset() {
        return this.aOp;
    }

    public void setTopOffset(int i) {
        this.aOp = i;
    }

    public int getScanLineSize() {
        return this.fUC;
    }

    public void setScanLineSize(int i) {
        this.fUC = i;
    }

    public int getScanLineColor() {
        return this.fUD;
    }

    public void setScanLineColor(int i) {
        this.fUD = i;
    }

    public int getScanLineMargin() {
        return this.fUE;
    }

    public void setScanLineMargin(int i) {
        this.fUE = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.fUF = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.fUG;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.fUG = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.fUH;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.fUH = bitmap;
    }

    public int getBorderSize() {
        return this.fUI;
    }

    public void setBorderSize(int i) {
        this.fUI = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.fUJ;
    }

    public void setAnimTime(int i) {
        this.fUJ = i;
    }

    public void setCenterVertical(boolean z) {
        this.fUK = z;
    }

    public int getToolbarHeight() {
        return this.fUL;
    }

    public void setToolbarHeight(int i) {
        this.fUL = i;
    }

    public String getQRCodeTipText() {
        return this.fUN;
    }

    public void setQRCodeTipText(String str) {
        this.fUN = str;
    }

    public String getBarCodeTipText() {
        return this.fUO;
    }

    public void setBarCodeTipText(String str) {
        this.fUO = str;
    }

    public String getTipText() {
        return this.eMr;
    }

    public void setTipText(String str) {
        this.eMr = str;
    }

    public int getTipTextColor() {
        return this.fUQ;
    }

    public void setTipTextColor(int i) {
        this.fUQ = i;
    }

    public int getTipTextSize() {
        return this.fUP;
    }

    public void setTipTextSize(int i) {
        this.fUP = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.fUR = z;
    }

    public int getTipTextMargin() {
        return this.fUS;
    }

    public void setTipTextMargin(int i) {
        this.fUS = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.fUT = z;
    }

    public void setShowTipBackground(boolean z) {
        this.fUV = z;
    }

    public int getTipBackgroundColor() {
        return this.fUU;
    }

    public void setTipBackgroundColor(int i) {
        this.fUU = i;
    }

    public void setScanLineReverse(boolean z) {
        this.fUW = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.fUX = z;
    }

    public float getHalfCornerSize() {
        return this.fVg;
    }

    public void setHalfCornerSize(float f) {
        this.fVg = f;
    }

    public StaticLayout getTipTextSl() {
        return this.fVh;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.fVh = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.fVi;
    }

    public void setTipBackgroundRadius(int i) {
        this.fVi = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.fVj = z;
    }
}
