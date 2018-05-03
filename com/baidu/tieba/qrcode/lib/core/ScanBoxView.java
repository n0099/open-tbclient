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
    private String eMo;
    private int fUA;
    private int fUB;
    private boolean fUC;
    private Drawable fUD;
    private Bitmap fUE;
    private int fUF;
    private int fUG;
    private boolean fUH;
    private int fUI;
    private boolean fUJ;
    private String fUK;
    private String fUL;
    private int fUM;
    private int fUN;
    private boolean fUO;
    private int fUP;
    private boolean fUQ;
    private int fUR;
    private boolean fUS;
    private boolean fUT;
    private boolean fUU;
    private Drawable fUV;
    private Bitmap fUW;
    private float fUX;
    private float fUY;
    private Bitmap fUZ;
    private Bitmap fUk;
    private Bitmap fUl;
    private Bitmap fUm;
    private Bitmap fUn;
    private int fUo;
    private int fUp;
    private Rect fUq;
    private float fUr;
    private float fUs;
    private TextPaint fUt;
    private int fUu;
    private int fUv;
    private int fUw;
    private int fUx;
    private int fUy;
    private int fUz;
    private Bitmap fVa;
    private Bitmap fVb;
    private Bitmap fVc;
    private float fVd;
    private StaticLayout fVe;
    private int fVf;
    private boolean fVg;
    private ColorMatrixColorFilter fVh;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.alS = Color.parseColor("#33FFFFFF");
        this.fUu = a.f(context, 20.0f);
        this.fUv = a.f(context, 3.0f);
        this.fUz = a.f(context, 1.0f);
        this.fUA = -1;
        this.aOp = a.f(context, 90.0f);
        this.fUw = a.f(context, 200.0f);
        this.fUy = a.f(context, 140.0f);
        this.fUB = 0;
        this.fUC = false;
        this.fUD = null;
        this.fUE = null;
        this.fUF = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.fUG = 1000;
        this.fUH = false;
        this.fUI = 0;
        this.fUJ = false;
        this.fUo = a.f(context, 2.0f);
        this.eMo = null;
        this.fUM = a.e(context, 14.0f);
        this.fUN = -1;
        this.fUO = false;
        this.fUP = a.f(context, 20.0f);
        this.fUQ = false;
        this.fUR = Color.parseColor("#22000000");
        this.fUS = false;
        this.fUT = false;
        this.fUU = false;
        this.fUt = new TextPaint();
        this.fUt.setAntiAlias(true);
        this.fVf = a.f(context, 4.0f);
        this.fVg = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.fVh = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.fUu;
        options.outHeight = this.fUu;
        this.fUk = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.fUl = Bitmap.createBitmap(this.fUk, 0, 0, this.fUk.getWidth(), this.fUk.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.fUm = Bitmap.createBitmap(this.fUk, 0, 0, this.fUk.getWidth(), this.fUk.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.fUn = Bitmap.createBitmap(this.fUk, 0, 0, this.fUk.getWidth(), this.fUk.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.m.QRCodeView_qrcv_topOffset) {
            this.aOp = typedArray.getDimensionPixelSize(i, this.aOp);
        } else if (i == d.m.QRCodeView_qrcv_cornerSize) {
            this.fUv = typedArray.getDimensionPixelSize(i, this.fUv);
        } else if (i == d.m.QRCodeView_qrcv_cornerLength) {
            this.fUu = typedArray.getDimensionPixelSize(i, this.fUu);
        } else if (i == d.m.QRCodeView_qrcv_scanLineSize) {
            this.fUz = typedArray.getDimensionPixelSize(i, this.fUz);
        } else if (i == d.m.QRCodeView_qrcv_rectWidth) {
            this.fUw = typedArray.getDimensionPixelSize(i, this.fUw);
        } else if (i == d.m.QRCodeView_qrcv_maskColor) {
            this.alS = typedArray.getColor(i, this.alS);
        } else if (i == d.m.QRCodeView_qrcv_scanLineColor) {
            this.fUA = typedArray.getColor(i, this.fUA);
        } else if (i == d.m.QRCodeView_qrcv_scanLineMargin) {
            this.fUB = typedArray.getDimensionPixelSize(i, this.fUB);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.fUC = typedArray.getBoolean(i, this.fUC);
        } else if (i == d.m.QRCodeView_qrcv_customScanLineDrawable) {
            this.fUD = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_borderSize) {
            this.fUF = typedArray.getDimensionPixelSize(i, this.fUF);
        } else if (i == d.m.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.m.QRCodeView_qrcv_animTime) {
            this.fUG = typedArray.getInteger(i, this.fUG);
        } else if (i == d.m.QRCodeView_qrcv_isCenterVertical) {
            this.fUH = typedArray.getBoolean(i, this.fUH);
        } else if (i == d.m.QRCodeView_qrcv_toolbarHeight) {
            this.fUI = typedArray.getDimensionPixelSize(i, this.fUI);
        } else if (i == d.m.QRCodeView_qrcv_barcodeRectHeight) {
            this.fUy = typedArray.getDimensionPixelSize(i, this.fUy);
        } else if (i == d.m.QRCodeView_qrcv_isBarcode) {
            this.fUJ = typedArray.getBoolean(i, this.fUJ);
        } else if (i == d.m.QRCodeView_qrcv_barCodeTipText) {
            this.fUL = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_qrCodeTipText) {
            this.fUK = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_tipTextSize) {
            this.fUM = typedArray.getDimensionPixelSize(i, this.fUM);
        } else if (i == d.m.QRCodeView_qrcv_tipTextColor) {
            this.fUN = typedArray.getColor(i, this.fUN);
        } else if (i == d.m.QRCodeView_qrcv_isTipTextBelowRect) {
            this.fUO = typedArray.getBoolean(i, this.fUO);
        } else if (i == d.m.QRCodeView_qrcv_tipTextMargin) {
            this.fUP = typedArray.getDimensionPixelSize(i, this.fUP);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.fUQ = typedArray.getBoolean(i, this.fUQ);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipBackground) {
            this.fUS = typedArray.getBoolean(i, this.fUS);
        } else if (i == d.m.QRCodeView_qrcv_tipBackgroundColor) {
            this.fUR = typedArray.getColor(i, this.fUR);
        } else if (i == d.m.QRCodeView_qrcv_isScanLineReverse) {
            this.fUT = typedArray.getBoolean(i, this.fUT);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.fUU = typedArray.getBoolean(i, this.fUU);
        } else if (i == d.m.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.fUV = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.fVg = typedArray.getBoolean(i, this.fVg);
        }
    }

    private void biE() {
        if (this.fUV != null) {
            this.fVb = ((BitmapDrawable) this.fUV).getBitmap();
        }
        if (this.fVb == null) {
            this.fVb = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fVb = a.d(this.fVb, this.fUA);
        }
        this.fVc = a.c(this.fVb, 90);
        this.fVc = a.c(this.fVc, 90);
        this.fVc = a.c(this.fVc, 90);
        if (this.fUD != null) {
            this.fUZ = ((BitmapDrawable) this.fUD).getBitmap();
        }
        if (this.fUZ == null) {
            this.fUZ = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fUZ = a.d(this.fUZ, this.fUA);
        }
        this.fVa = a.c(this.fUZ, 90);
        this.fVd = (1.0f * this.fUv) / 2.0f;
        this.fUt.setTextSize(this.fUM);
        this.fUt.setColor(this.fUN);
        setIsBarcode(this.fUJ);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.fUq != null) {
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
            canvas.drawRect(0.0f, 0.0f, width, this.fUq.top, this.mPaint);
            canvas.drawRect(0.0f, this.fUq.top, this.fUq.left, this.fUq.bottom + 1, this.mPaint);
            canvas.drawRect(this.fUq.right + 1, this.fUq.top, width, this.fUq.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.fUq.bottom + 1, width, height, this.mPaint);
        }
    }

    private void A(Canvas canvas) {
        if (this.fUF > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.fUF);
            canvas.drawRect(this.fUq, this.mPaint);
        }
    }

    private void B(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.fUk, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fUl, getMainFrameRight() - this.fUk.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fUm, getMainFrameLeft(), getMainFrameBottom() - this.fUk.getHeight(), this.mPaint);
        canvas.drawBitmap(this.fUn, getMainFrameRight() - this.fUk.getWidth(), getMainFrameBottom() - this.fUk.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.fUq.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.fUq.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.fUq.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.fUq.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.fUF / 2;
    }

    private void C(Canvas canvas) {
        if (this.fUJ) {
            if (this.fUW != null) {
                RectF rectF = new RectF(this.fUq.left + this.fVd + 0.5f, this.fUq.top + this.fVd + this.fUB, this.fUY, (this.fUq.bottom - this.fVd) - this.fUB);
                Rect rect = new Rect((int) (this.fUW.getWidth() - rectF.width()), 0, this.fUW.getWidth(), this.fUW.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.fUW, rect, rectF, this.mPaint);
            } else if (this.fUE != null) {
                canvas.drawBitmap(this.fUE, (Rect) null, new RectF(this.fUs, this.fUq.top + this.fVd + this.fUB, this.fUs + this.fUE.getWidth(), (this.fUq.bottom - this.fVd) - this.fUB), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.fUA);
                canvas.drawRect(this.fUs, this.fUB + this.fUq.top + this.fVd, this.fUz + this.fUs, (this.fUq.bottom - this.fVd) - this.fUB, this.mPaint);
            }
        } else if (this.fUW != null) {
            RectF rectF2 = new RectF(this.fUq.left + this.fVd + this.fUB, this.fUq.top + this.fVd + 0.5f, (this.fUq.right - this.fVd) - this.fUB, this.fUX);
            Rect rect2 = new Rect(0, (int) (this.fUW.getHeight() - rectF2.height()), this.fUW.getWidth(), this.fUW.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.fVh);
            canvas.drawBitmap(this.fUW, rect2, rectF2, this.mPaint);
        } else if (this.fUE != null) {
            canvas.drawBitmap(this.fUE, (Rect) null, new RectF(this.fUq.left + this.fVd + this.fUB, this.fUr, (this.fUq.right - this.fVd) - this.fUB, this.fUr + this.fUE.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.fUA);
            canvas.drawRect(this.fUB + this.fUq.left + this.fVd, this.fUr, (this.fUq.right - this.fVd) - this.fUB, this.fUz + this.fUr, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (!TextUtils.isEmpty(this.eMo) && this.fVe != null) {
            if (this.fUO) {
                if (this.fUS) {
                    this.mPaint.setColor(this.fUR);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.fUQ) {
                        Rect rect = new Rect();
                        this.fUt.getTextBounds(this.eMo, 0, this.eMo.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.fVf;
                        canvas.drawRoundRect(new RectF(width, (this.fUq.bottom + this.fUP) - this.fVf, rect.width() + width + (this.fVf * 2), this.fUq.bottom + this.fUP + this.fVe.getHeight() + this.fVf), this.fVf, this.fVf, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.fUq.left, (this.fUq.bottom + this.fUP) - this.fVf, this.fUq.right, this.fUq.bottom + this.fUP + this.fVe.getHeight() + this.fVf), this.fVf, this.fVf, this.mPaint);
                    }
                }
                canvas.save();
                if (this.fUQ) {
                    canvas.translate(0.0f, this.fUq.bottom + this.fUP);
                } else {
                    canvas.translate(this.fUq.left + this.fVf, this.fUq.bottom + this.fUP);
                }
                this.fVe.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.fUS) {
                this.mPaint.setColor(this.fUR);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.fUQ) {
                    Rect rect2 = new Rect();
                    this.fUt.getTextBounds(this.eMo, 0, this.eMo.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.fVf;
                    canvas.drawRoundRect(new RectF(width2, ((this.fUq.top - this.fUP) - this.fVe.getHeight()) - this.fVf, rect2.width() + width2 + (this.fVf * 2), (this.fUq.top - this.fUP) + this.fVf), this.fVf, this.fVf, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.fUq.left, ((this.fUq.top - this.fUP) - this.fVe.getHeight()) - this.fVf, this.fUq.right, (this.fUq.top - this.fUP) + this.fVf), this.fVf, this.fVf, this.mPaint);
                }
            }
            canvas.save();
            if (this.fUQ) {
                canvas.translate(0.0f, (this.fUq.top - this.fUP) - this.fVe.getHeight());
            } else {
                canvas.translate(this.fUq.left + this.fVf, (this.fUq.top - this.fUP) - this.fVe.getHeight());
            }
            this.fVe.draw(canvas);
            canvas.restore();
        }
    }

    private void biF() {
        if (this.fUJ) {
            if (this.fUW == null) {
                this.fUs += this.fUo;
                int i = this.fUz;
                if (this.fUE != null) {
                    i = this.fUE.getWidth();
                }
                if (this.fUT) {
                    if (i + this.fUs > this.fUq.right - this.fVd || this.fUs < this.fUq.left + this.fVd) {
                        this.fUo = -this.fUo;
                    }
                } else {
                    if (i + this.fUs > this.fUq.right - this.fVd) {
                        this.fUs = this.fUq.left + this.fVd + 0.5f;
                    }
                }
            } else {
                this.fUY += this.fUo;
                if (this.fUY > this.fUq.right - this.fVd) {
                    this.fUY = this.fUq.left + this.fVd + 0.5f;
                }
            }
        } else if (this.fUW == null) {
            this.fUr += this.fUo;
            int i2 = this.fUz;
            if (this.fUE != null) {
                i2 = this.fUE.getHeight();
            }
            if (this.fUT) {
                if (i2 + this.fUr > this.fUq.bottom - this.fVd || this.fUr < this.fUq.top + this.fVd) {
                    this.fUo = -this.fUo;
                }
            } else {
                if (i2 + this.fUr > this.fUq.bottom - this.fVd) {
                    this.fUr = this.fUq.top + this.fVd + 0.5f;
                }
            }
        } else {
            this.fUX += this.fUo;
            if (this.fUX > this.fUq.bottom - this.fVd) {
                this.fUX = this.fUq.top + this.fVd + 0.5f;
            }
        }
        postInvalidateDelayed(this.fUp, this.fUq.left, this.fUq.top, this.fUq.right, this.fUq.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        biG();
    }

    private void biG() {
        int i = this.aOp + this.fUI;
        int width = (getWidth() - this.fUw) / 2;
        this.fUq = new Rect(width, i, this.fUw + width, this.fUx + i);
        if (this.fUJ) {
            float f = this.fUq.left + this.fVd + 0.5f;
            this.fUs = f;
            this.fUY = f;
            return;
        }
        float f2 = this.fUq.top + this.fVd + 0.5f;
        this.fUr = f2;
        this.fUX = f2;
    }

    public Rect rJ(int i) {
        if (this.fVg) {
            Rect rect = new Rect(this.fUq);
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
        this.fUJ = z;
        if (this.fUV != null || this.fUU) {
            if (this.fUJ) {
                this.fUW = this.fVc;
            } else {
                this.fUW = this.fVb;
            }
        } else if (this.fUD != null || this.fUC) {
            if (this.fUJ) {
                this.fUE = this.fVa;
            } else {
                this.fUE = this.fUZ;
            }
        }
        if (this.fUJ) {
            this.eMo = this.fUL;
            this.fUx = this.fUy;
            this.fUp = (int) (((this.fUG * 1.0f) * this.fUo) / this.fUw);
        } else {
            this.eMo = this.fUK;
            this.fUx = this.fUw;
            this.fUp = (int) (((this.fUG * 1.0f) * this.fUo) / this.fUx);
        }
        if (!TextUtils.isEmpty(this.eMo)) {
            if (this.fUQ) {
                this.fVe = new StaticLayout(this.eMo, this.fUt, a.bR(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.fVe = new StaticLayout(this.eMo, this.fUt, this.fUw - (this.fVf * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.fUH) {
            int i = a.bR(getContext()).y;
            if (this.fUI == 0) {
                this.aOp = (i - this.fUx) / 2;
            } else {
                this.aOp = ((i - this.fUx) / 2) + (this.fUI / 2);
            }
        }
        biG();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.fUJ;
    }

    public int getMaskColor() {
        return this.alS;
    }

    public void setMaskColor(int i) {
        this.alS = i;
    }

    public int getCornerLength() {
        return this.fUu;
    }

    public void setCornerLength(int i) {
        this.fUu = i;
    }

    public int getCornerSize() {
        return this.fUv;
    }

    public void setCornerSize(int i) {
        this.fUv = i;
    }

    public int getRectWidth() {
        return this.fUw;
    }

    public void setRectWidth(int i) {
        this.fUw = i;
    }

    public int getRectHeight() {
        return this.fUx;
    }

    public void setRectHeight(int i) {
        this.fUx = i;
    }

    public int getBarcodeRectHeight() {
        return this.fUy;
    }

    public void setBarcodeRectHeight(int i) {
        this.fUy = i;
    }

    public int getTopOffset() {
        return this.aOp;
    }

    public void setTopOffset(int i) {
        this.aOp = i;
    }

    public int getScanLineSize() {
        return this.fUz;
    }

    public void setScanLineSize(int i) {
        this.fUz = i;
    }

    public int getScanLineColor() {
        return this.fUA;
    }

    public void setScanLineColor(int i) {
        this.fUA = i;
    }

    public int getScanLineMargin() {
        return this.fUB;
    }

    public void setScanLineMargin(int i) {
        this.fUB = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.fUC = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.fUD;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.fUD = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.fUE;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.fUE = bitmap;
    }

    public int getBorderSize() {
        return this.fUF;
    }

    public void setBorderSize(int i) {
        this.fUF = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.fUG;
    }

    public void setAnimTime(int i) {
        this.fUG = i;
    }

    public void setCenterVertical(boolean z) {
        this.fUH = z;
    }

    public int getToolbarHeight() {
        return this.fUI;
    }

    public void setToolbarHeight(int i) {
        this.fUI = i;
    }

    public String getQRCodeTipText() {
        return this.fUK;
    }

    public void setQRCodeTipText(String str) {
        this.fUK = str;
    }

    public String getBarCodeTipText() {
        return this.fUL;
    }

    public void setBarCodeTipText(String str) {
        this.fUL = str;
    }

    public String getTipText() {
        return this.eMo;
    }

    public void setTipText(String str) {
        this.eMo = str;
    }

    public int getTipTextColor() {
        return this.fUN;
    }

    public void setTipTextColor(int i) {
        this.fUN = i;
    }

    public int getTipTextSize() {
        return this.fUM;
    }

    public void setTipTextSize(int i) {
        this.fUM = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.fUO = z;
    }

    public int getTipTextMargin() {
        return this.fUP;
    }

    public void setTipTextMargin(int i) {
        this.fUP = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.fUQ = z;
    }

    public void setShowTipBackground(boolean z) {
        this.fUS = z;
    }

    public int getTipBackgroundColor() {
        return this.fUR;
    }

    public void setTipBackgroundColor(int i) {
        this.fUR = i;
    }

    public void setScanLineReverse(boolean z) {
        this.fUT = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.fUU = z;
    }

    public float getHalfCornerSize() {
        return this.fVd;
    }

    public void setHalfCornerSize(float f) {
        this.fVd = f;
    }

    public StaticLayout getTipTextSl() {
        return this.fVe;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.fVe = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.fVf;
    }

    public void setTipBackgroundRadius(int i) {
        this.fVf = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.fVg = z;
    }
}
