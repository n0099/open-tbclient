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
    private int aXi;
    private int auK;
    private String fcF;
    private Bitmap gkF;
    private Bitmap gkG;
    private Bitmap gkH;
    private Bitmap gkI;
    private int gkJ;
    private int gkK;
    private Rect gkL;
    private float gkM;
    private float gkN;
    private TextPaint gkO;
    private int gkP;
    private int gkQ;
    private int gkR;
    private int gkS;
    private int gkT;
    private int gkU;
    private int gkV;
    private int gkW;
    private boolean gkX;
    private Drawable gkY;
    private Bitmap gkZ;
    private int glA;
    private boolean glB;
    private ColorMatrixColorFilter glC;
    private int gla;
    private int glb;
    private boolean glc;
    private int gld;
    private boolean gle;
    private String glf;
    private String glg;
    private int glh;
    private int gli;
    private boolean glj;
    private int glk;
    private boolean gll;
    private int glm;
    private boolean gln;
    private boolean glo;
    private boolean glp;
    private Drawable glq;
    private Bitmap glr;
    private float gls;
    private float glt;
    private Bitmap glu;
    private Bitmap glv;
    private Bitmap glw;
    private Bitmap glx;
    private float gly;
    private StaticLayout glz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.auK = Color.parseColor("#33FFFFFF");
        this.gkP = a.f(context, 20.0f);
        this.gkQ = a.f(context, 3.0f);
        this.gkU = a.f(context, 1.0f);
        this.gkV = -1;
        this.aXi = a.f(context, 90.0f);
        this.gkR = a.f(context, 200.0f);
        this.gkT = a.f(context, 140.0f);
        this.gkW = 0;
        this.gkX = false;
        this.gkY = null;
        this.gkZ = null;
        this.gla = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.glb = 1000;
        this.glc = false;
        this.gld = 0;
        this.gle = false;
        this.gkJ = a.f(context, 2.0f);
        this.fcF = null;
        this.glh = a.e(context, 14.0f);
        this.gli = -1;
        this.glj = false;
        this.glk = a.f(context, 20.0f);
        this.gll = false;
        this.glm = Color.parseColor("#22000000");
        this.gln = false;
        this.glo = false;
        this.glp = false;
        this.gkO = new TextPaint();
        this.gkO.setAntiAlias(true);
        this.glA = a.f(context, 4.0f);
        this.glB = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.glC = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bog();
        bof();
    }

    private void bof() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gkP;
        options.outHeight = this.gkP;
        this.gkF = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gkG = Bitmap.createBitmap(this.gkF, 0, 0, this.gkF.getWidth(), this.gkF.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gkH = Bitmap.createBitmap(this.gkF, 0, 0, this.gkF.getWidth(), this.gkF.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gkI = Bitmap.createBitmap(this.gkF, 0, 0, this.gkF.getWidth(), this.gkF.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.m.QRCodeView_qrcv_topOffset) {
            this.aXi = typedArray.getDimensionPixelSize(i, this.aXi);
        } else if (i == d.m.QRCodeView_qrcv_cornerSize) {
            this.gkQ = typedArray.getDimensionPixelSize(i, this.gkQ);
        } else if (i == d.m.QRCodeView_qrcv_cornerLength) {
            this.gkP = typedArray.getDimensionPixelSize(i, this.gkP);
        } else if (i == d.m.QRCodeView_qrcv_scanLineSize) {
            this.gkU = typedArray.getDimensionPixelSize(i, this.gkU);
        } else if (i == d.m.QRCodeView_qrcv_rectWidth) {
            this.gkR = typedArray.getDimensionPixelSize(i, this.gkR);
        } else if (i == d.m.QRCodeView_qrcv_maskColor) {
            this.auK = typedArray.getColor(i, this.auK);
        } else if (i == d.m.QRCodeView_qrcv_scanLineColor) {
            this.gkV = typedArray.getColor(i, this.gkV);
        } else if (i == d.m.QRCodeView_qrcv_scanLineMargin) {
            this.gkW = typedArray.getDimensionPixelSize(i, this.gkW);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gkX = typedArray.getBoolean(i, this.gkX);
        } else if (i == d.m.QRCodeView_qrcv_customScanLineDrawable) {
            this.gkY = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_borderSize) {
            this.gla = typedArray.getDimensionPixelSize(i, this.gla);
        } else if (i == d.m.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.m.QRCodeView_qrcv_animTime) {
            this.glb = typedArray.getInteger(i, this.glb);
        } else if (i == d.m.QRCodeView_qrcv_isCenterVertical) {
            this.glc = typedArray.getBoolean(i, this.glc);
        } else if (i == d.m.QRCodeView_qrcv_toolbarHeight) {
            this.gld = typedArray.getDimensionPixelSize(i, this.gld);
        } else if (i == d.m.QRCodeView_qrcv_barcodeRectHeight) {
            this.gkT = typedArray.getDimensionPixelSize(i, this.gkT);
        } else if (i == d.m.QRCodeView_qrcv_isBarcode) {
            this.gle = typedArray.getBoolean(i, this.gle);
        } else if (i == d.m.QRCodeView_qrcv_barCodeTipText) {
            this.glg = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_qrCodeTipText) {
            this.glf = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_tipTextSize) {
            this.glh = typedArray.getDimensionPixelSize(i, this.glh);
        } else if (i == d.m.QRCodeView_qrcv_tipTextColor) {
            this.gli = typedArray.getColor(i, this.gli);
        } else if (i == d.m.QRCodeView_qrcv_isTipTextBelowRect) {
            this.glj = typedArray.getBoolean(i, this.glj);
        } else if (i == d.m.QRCodeView_qrcv_tipTextMargin) {
            this.glk = typedArray.getDimensionPixelSize(i, this.glk);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gll = typedArray.getBoolean(i, this.gll);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipBackground) {
            this.gln = typedArray.getBoolean(i, this.gln);
        } else if (i == d.m.QRCodeView_qrcv_tipBackgroundColor) {
            this.glm = typedArray.getColor(i, this.glm);
        } else if (i == d.m.QRCodeView_qrcv_isScanLineReverse) {
            this.glo = typedArray.getBoolean(i, this.glo);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.glp = typedArray.getBoolean(i, this.glp);
        } else if (i == d.m.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.glq = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.glB = typedArray.getBoolean(i, this.glB);
        }
    }

    private void bog() {
        if (this.glq != null) {
            this.glw = ((BitmapDrawable) this.glq).getBitmap();
        }
        if (this.glw == null) {
            this.glw = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.glw = a.d(this.glw, this.gkV);
        }
        this.glx = a.c(this.glw, 90);
        this.glx = a.c(this.glx, 90);
        this.glx = a.c(this.glx, 90);
        if (this.gkY != null) {
            this.glu = ((BitmapDrawable) this.gkY).getBitmap();
        }
        if (this.glu == null) {
            this.glu = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.glu = a.d(this.glu, this.gkV);
        }
        this.glv = a.c(this.glu, 90);
        this.gly = (1.0f * this.gkQ) / 2.0f;
        this.gkO.setTextSize(this.glh);
        this.gkO.setColor(this.gli);
        setIsBarcode(this.gle);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gkL != null) {
            C(canvas);
            D(canvas);
            F(canvas);
            G(canvas);
            E(canvas);
            boh();
        }
    }

    private void C(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.auK != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.auK);
            canvas.drawRect(0.0f, 0.0f, width, this.gkL.top, this.mPaint);
            canvas.drawRect(0.0f, this.gkL.top, this.gkL.left, this.gkL.bottom + 1, this.mPaint);
            canvas.drawRect(this.gkL.right + 1, this.gkL.top, width, this.gkL.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gkL.bottom + 1, width, height, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (this.gla > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gla);
            canvas.drawRect(this.gkL, this.mPaint);
        }
    }

    private void E(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gkF, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gkG, getMainFrameRight() - this.gkF.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gkH, getMainFrameLeft(), getMainFrameBottom() - this.gkF.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gkI, getMainFrameRight() - this.gkF.getWidth(), getMainFrameBottom() - this.gkF.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gkL.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gkL.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gkL.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gkL.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gla / 2;
    }

    private void F(Canvas canvas) {
        if (this.gle) {
            if (this.glr != null) {
                RectF rectF = new RectF(this.gkL.left + this.gly + 0.5f, this.gkL.top + this.gly + this.gkW, this.glt, (this.gkL.bottom - this.gly) - this.gkW);
                Rect rect = new Rect((int) (this.glr.getWidth() - rectF.width()), 0, this.glr.getWidth(), this.glr.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.glr, rect, rectF, this.mPaint);
            } else if (this.gkZ != null) {
                canvas.drawBitmap(this.gkZ, (Rect) null, new RectF(this.gkN, this.gkL.top + this.gly + this.gkW, this.gkN + this.gkZ.getWidth(), (this.gkL.bottom - this.gly) - this.gkW), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gkV);
                canvas.drawRect(this.gkN, this.gkW + this.gkL.top + this.gly, this.gkU + this.gkN, (this.gkL.bottom - this.gly) - this.gkW, this.mPaint);
            }
        } else if (this.glr != null) {
            RectF rectF2 = new RectF(this.gkL.left + this.gly + this.gkW, this.gkL.top + this.gly + 0.5f, (this.gkL.right - this.gly) - this.gkW, this.gls);
            Rect rect2 = new Rect(0, (int) (this.glr.getHeight() - rectF2.height()), this.glr.getWidth(), this.glr.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.glC);
            canvas.drawBitmap(this.glr, rect2, rectF2, this.mPaint);
        } else if (this.gkZ != null) {
            canvas.drawBitmap(this.gkZ, (Rect) null, new RectF(this.gkL.left + this.gly + this.gkW, this.gkM, (this.gkL.right - this.gly) - this.gkW, this.gkM + this.gkZ.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gkV);
            canvas.drawRect(this.gkW + this.gkL.left + this.gly, this.gkM, (this.gkL.right - this.gly) - this.gkW, this.gkU + this.gkM, this.mPaint);
        }
    }

    private void G(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fcF) && this.glz != null) {
            if (this.glj) {
                if (this.gln) {
                    this.mPaint.setColor(this.glm);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gll) {
                        Rect rect = new Rect();
                        this.gkO.getTextBounds(this.fcF, 0, this.fcF.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.glA;
                        canvas.drawRoundRect(new RectF(width, (this.gkL.bottom + this.glk) - this.glA, rect.width() + width + (this.glA * 2), this.gkL.bottom + this.glk + this.glz.getHeight() + this.glA), this.glA, this.glA, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gkL.left, (this.gkL.bottom + this.glk) - this.glA, this.gkL.right, this.gkL.bottom + this.glk + this.glz.getHeight() + this.glA), this.glA, this.glA, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gll) {
                    canvas.translate(0.0f, this.gkL.bottom + this.glk);
                } else {
                    canvas.translate(this.gkL.left + this.glA, this.gkL.bottom + this.glk);
                }
                this.glz.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gln) {
                this.mPaint.setColor(this.glm);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gll) {
                    Rect rect2 = new Rect();
                    this.gkO.getTextBounds(this.fcF, 0, this.fcF.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.glA;
                    canvas.drawRoundRect(new RectF(width2, ((this.gkL.top - this.glk) - this.glz.getHeight()) - this.glA, rect2.width() + width2 + (this.glA * 2), (this.gkL.top - this.glk) + this.glA), this.glA, this.glA, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gkL.left, ((this.gkL.top - this.glk) - this.glz.getHeight()) - this.glA, this.gkL.right, (this.gkL.top - this.glk) + this.glA), this.glA, this.glA, this.mPaint);
                }
            }
            canvas.save();
            if (this.gll) {
                canvas.translate(0.0f, (this.gkL.top - this.glk) - this.glz.getHeight());
            } else {
                canvas.translate(this.gkL.left + this.glA, (this.gkL.top - this.glk) - this.glz.getHeight());
            }
            this.glz.draw(canvas);
            canvas.restore();
        }
    }

    private void boh() {
        if (this.gle) {
            if (this.glr == null) {
                this.gkN += this.gkJ;
                int i = this.gkU;
                if (this.gkZ != null) {
                    i = this.gkZ.getWidth();
                }
                if (this.glo) {
                    if (i + this.gkN > this.gkL.right - this.gly || this.gkN < this.gkL.left + this.gly) {
                        this.gkJ = -this.gkJ;
                    }
                } else {
                    if (i + this.gkN > this.gkL.right - this.gly) {
                        this.gkN = this.gkL.left + this.gly + 0.5f;
                    }
                }
            } else {
                this.glt += this.gkJ;
                if (this.glt > this.gkL.right - this.gly) {
                    this.glt = this.gkL.left + this.gly + 0.5f;
                }
            }
        } else if (this.glr == null) {
            this.gkM += this.gkJ;
            int i2 = this.gkU;
            if (this.gkZ != null) {
                i2 = this.gkZ.getHeight();
            }
            if (this.glo) {
                if (i2 + this.gkM > this.gkL.bottom - this.gly || this.gkM < this.gkL.top + this.gly) {
                    this.gkJ = -this.gkJ;
                }
            } else {
                if (i2 + this.gkM > this.gkL.bottom - this.gly) {
                    this.gkM = this.gkL.top + this.gly + 0.5f;
                }
            }
        } else {
            this.gls += this.gkJ;
            if (this.gls > this.gkL.bottom - this.gly) {
                this.gls = this.gkL.top + this.gly + 0.5f;
            }
        }
        postInvalidateDelayed(this.gkK, this.gkL.left, this.gkL.top, this.gkL.right, this.gkL.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        boi();
    }

    private void boi() {
        int i = this.aXi + this.gld;
        int width = (getWidth() - this.gkR) / 2;
        this.gkL = new Rect(width, i, this.gkR + width, this.gkS + i);
        if (this.gle) {
            float f = this.gkL.left + this.gly + 0.5f;
            this.gkN = f;
            this.glt = f;
            return;
        }
        float f2 = this.gkL.top + this.gly + 0.5f;
        this.gkM = f2;
        this.gls = f2;
    }

    public Rect sd(int i) {
        if (this.glB) {
            Rect rect = new Rect(this.gkL);
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
        this.gle = z;
        if (this.glq != null || this.glp) {
            if (this.gle) {
                this.glr = this.glx;
            } else {
                this.glr = this.glw;
            }
        } else if (this.gkY != null || this.gkX) {
            if (this.gle) {
                this.gkZ = this.glv;
            } else {
                this.gkZ = this.glu;
            }
        }
        if (this.gle) {
            this.fcF = this.glg;
            this.gkS = this.gkT;
            this.gkK = (int) (((this.glb * 1.0f) * this.gkJ) / this.gkR);
        } else {
            this.fcF = this.glf;
            this.gkS = this.gkR;
            this.gkK = (int) (((this.glb * 1.0f) * this.gkJ) / this.gkS);
        }
        if (!TextUtils.isEmpty(this.fcF)) {
            if (this.gll) {
                this.glz = new StaticLayout(this.fcF, this.gkO, a.cb(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.glz = new StaticLayout(this.fcF, this.gkO, this.gkR - (this.glA * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.glc) {
            int i = a.cb(getContext()).y;
            if (this.gld == 0) {
                this.aXi = (i - this.gkS) / 2;
            } else {
                this.aXi = ((i - this.gkS) / 2) + (this.gld / 2);
            }
        }
        boi();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gle;
    }

    public int getMaskColor() {
        return this.auK;
    }

    public void setMaskColor(int i) {
        this.auK = i;
    }

    public int getCornerLength() {
        return this.gkP;
    }

    public void setCornerLength(int i) {
        this.gkP = i;
    }

    public int getCornerSize() {
        return this.gkQ;
    }

    public void setCornerSize(int i) {
        this.gkQ = i;
    }

    public int getRectWidth() {
        return this.gkR;
    }

    public void setRectWidth(int i) {
        this.gkR = i;
    }

    public int getRectHeight() {
        return this.gkS;
    }

    public void setRectHeight(int i) {
        this.gkS = i;
    }

    public int getBarcodeRectHeight() {
        return this.gkT;
    }

    public void setBarcodeRectHeight(int i) {
        this.gkT = i;
    }

    public int getTopOffset() {
        return this.aXi;
    }

    public void setTopOffset(int i) {
        this.aXi = i;
    }

    public int getScanLineSize() {
        return this.gkU;
    }

    public void setScanLineSize(int i) {
        this.gkU = i;
    }

    public int getScanLineColor() {
        return this.gkV;
    }

    public void setScanLineColor(int i) {
        this.gkV = i;
    }

    public int getScanLineMargin() {
        return this.gkW;
    }

    public void setScanLineMargin(int i) {
        this.gkW = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gkX = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gkY;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gkY = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gkZ;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gkZ = bitmap;
    }

    public int getBorderSize() {
        return this.gla;
    }

    public void setBorderSize(int i) {
        this.gla = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.glb;
    }

    public void setAnimTime(int i) {
        this.glb = i;
    }

    public void setCenterVertical(boolean z) {
        this.glc = z;
    }

    public int getToolbarHeight() {
        return this.gld;
    }

    public void setToolbarHeight(int i) {
        this.gld = i;
    }

    public String getQRCodeTipText() {
        return this.glf;
    }

    public void setQRCodeTipText(String str) {
        this.glf = str;
    }

    public String getBarCodeTipText() {
        return this.glg;
    }

    public void setBarCodeTipText(String str) {
        this.glg = str;
    }

    public String getTipText() {
        return this.fcF;
    }

    public void setTipText(String str) {
        this.fcF = str;
    }

    public int getTipTextColor() {
        return this.gli;
    }

    public void setTipTextColor(int i) {
        this.gli = i;
    }

    public int getTipTextSize() {
        return this.glh;
    }

    public void setTipTextSize(int i) {
        this.glh = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.glj = z;
    }

    public int getTipTextMargin() {
        return this.glk;
    }

    public void setTipTextMargin(int i) {
        this.glk = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gll = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gln = z;
    }

    public int getTipBackgroundColor() {
        return this.glm;
    }

    public void setTipBackgroundColor(int i) {
        this.glm = i;
    }

    public void setScanLineReverse(boolean z) {
        this.glo = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.glp = z;
    }

    public float getHalfCornerSize() {
        return this.gly;
    }

    public void setHalfCornerSize(float f) {
        this.gly = f;
    }

    public StaticLayout getTipTextSl() {
        return this.glz;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.glz = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.glA;
    }

    public void setTipBackgroundRadius(int i) {
        this.glA = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.glB = z;
    }
}
