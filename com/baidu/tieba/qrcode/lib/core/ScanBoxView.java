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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ScanBoxView extends View {
    private int axD;
    private int baF;
    private String fki;
    private int gtA;
    private int gtB;
    private boolean gtC;
    private Drawable gtD;
    private Bitmap gtE;
    private int gtF;
    private int gtG;
    private boolean gtH;
    private int gtI;
    private boolean gtJ;
    private String gtK;
    private String gtL;
    private int gtM;
    private int gtN;
    private boolean gtO;
    private int gtP;
    private boolean gtQ;
    private int gtR;
    private boolean gtS;
    private boolean gtT;
    private boolean gtU;
    private Drawable gtV;
    private Bitmap gtW;
    private float gtX;
    private float gtY;
    private Bitmap gtZ;
    private Bitmap gtk;
    private Bitmap gtl;
    private Bitmap gtm;
    private Bitmap gtn;
    private int gto;
    private int gtp;
    private Rect gtq;
    private float gtr;
    private float gts;
    private TextPaint gtt;
    private int gtu;
    private int gtv;
    private int gtw;
    private int gtx;
    private int gty;
    private int gtz;
    private Bitmap gua;
    private Bitmap gub;
    private Bitmap guc;
    private float gud;
    private StaticLayout gue;
    private int guf;
    private boolean gug;
    private ColorMatrixColorFilter guh;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.axD = Color.parseColor("#33FFFFFF");
        this.gtu = a.f(context, 20.0f);
        this.gtv = a.f(context, 3.0f);
        this.gtz = a.f(context, 1.0f);
        this.gtA = -1;
        this.baF = a.f(context, 90.0f);
        this.gtw = a.f(context, 200.0f);
        this.gty = a.f(context, 140.0f);
        this.gtB = 0;
        this.gtC = false;
        this.gtD = null;
        this.gtE = null;
        this.gtF = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gtG = 1000;
        this.gtH = false;
        this.gtI = 0;
        this.gtJ = false;
        this.gto = a.f(context, 2.0f);
        this.fki = null;
        this.gtM = a.e(context, 14.0f);
        this.gtN = -1;
        this.gtO = false;
        this.gtP = a.f(context, 20.0f);
        this.gtQ = false;
        this.gtR = Color.parseColor("#22000000");
        this.gtS = false;
        this.gtT = false;
        this.gtU = false;
        this.gtt = new TextPaint();
        this.gtt.setAntiAlias(true);
        this.guf = a.f(context, 4.0f);
        this.gug = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.guh = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bps();
        bpr();
    }

    private void bpr() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gtu;
        options.outHeight = this.gtu;
        this.gtk = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gtl = Bitmap.createBitmap(this.gtk, 0, 0, this.gtk.getWidth(), this.gtk.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gtm = Bitmap.createBitmap(this.gtk, 0, 0, this.gtk.getWidth(), this.gtk.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gtn = Bitmap.createBitmap(this.gtk, 0, 0, this.gtk.getWidth(), this.gtk.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.baF = typedArray.getDimensionPixelSize(i, this.baF);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gtv = typedArray.getDimensionPixelSize(i, this.gtv);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gtu = typedArray.getDimensionPixelSize(i, this.gtu);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gtz = typedArray.getDimensionPixelSize(i, this.gtz);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gtw = typedArray.getDimensionPixelSize(i, this.gtw);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.axD = typedArray.getColor(i, this.axD);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gtA = typedArray.getColor(i, this.gtA);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gtB = typedArray.getDimensionPixelSize(i, this.gtB);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gtC = typedArray.getBoolean(i, this.gtC);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gtD = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gtF = typedArray.getDimensionPixelSize(i, this.gtF);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gtG = typedArray.getInteger(i, this.gtG);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gtH = typedArray.getBoolean(i, this.gtH);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gtI = typedArray.getDimensionPixelSize(i, this.gtI);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gty = typedArray.getDimensionPixelSize(i, this.gty);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gtJ = typedArray.getBoolean(i, this.gtJ);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gtL = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gtK = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gtM = typedArray.getDimensionPixelSize(i, this.gtM);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gtN = typedArray.getColor(i, this.gtN);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gtO = typedArray.getBoolean(i, this.gtO);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gtP = typedArray.getDimensionPixelSize(i, this.gtP);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gtQ = typedArray.getBoolean(i, this.gtQ);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gtS = typedArray.getBoolean(i, this.gtS);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gtR = typedArray.getColor(i, this.gtR);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gtT = typedArray.getBoolean(i, this.gtT);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gtU = typedArray.getBoolean(i, this.gtU);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gtV = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gug = typedArray.getBoolean(i, this.gug);
        }
    }

    private void bps() {
        if (this.gtV != null) {
            this.gub = ((BitmapDrawable) this.gtV).getBitmap();
        }
        if (this.gub == null) {
            this.gub = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gub = a.c(this.gub, this.gtA);
        }
        this.guc = a.adjustPhotoRotation(this.gub, 90);
        this.guc = a.adjustPhotoRotation(this.guc, 90);
        this.guc = a.adjustPhotoRotation(this.guc, 90);
        if (this.gtD != null) {
            this.gtZ = ((BitmapDrawable) this.gtD).getBitmap();
        }
        if (this.gtZ == null) {
            this.gtZ = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gtZ = a.c(this.gtZ, this.gtA);
        }
        this.gua = a.adjustPhotoRotation(this.gtZ, 90);
        this.gud = (1.0f * this.gtv) / 2.0f;
        this.gtt.setTextSize(this.gtM);
        this.gtt.setColor(this.gtN);
        setIsBarcode(this.gtJ);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gtq != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            bpt();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.axD != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.axD);
            canvas.drawRect(0.0f, 0.0f, width, this.gtq.top, this.mPaint);
            canvas.drawRect(0.0f, this.gtq.top, this.gtq.left, this.gtq.bottom + 1, this.mPaint);
            canvas.drawRect(this.gtq.right + 1, this.gtq.top, width, this.gtq.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gtq.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gtF > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gtF);
            canvas.drawRect(this.gtq, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gtk, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gtl, getMainFrameRight() - this.gtk.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gtm, getMainFrameLeft(), getMainFrameBottom() - this.gtk.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gtn, getMainFrameRight() - this.gtk.getWidth(), getMainFrameBottom() - this.gtk.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gtq.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gtq.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gtq.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gtq.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gtF / 2;
    }

    private void E(Canvas canvas) {
        if (this.gtJ) {
            if (this.gtW != null) {
                RectF rectF = new RectF(this.gtq.left + this.gud + 0.5f, this.gtq.top + this.gud + this.gtB, this.gtY, (this.gtq.bottom - this.gud) - this.gtB);
                Rect rect = new Rect((int) (this.gtW.getWidth() - rectF.width()), 0, this.gtW.getWidth(), this.gtW.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gtW, rect, rectF, this.mPaint);
            } else if (this.gtE != null) {
                canvas.drawBitmap(this.gtE, (Rect) null, new RectF(this.gts, this.gtq.top + this.gud + this.gtB, this.gts + this.gtE.getWidth(), (this.gtq.bottom - this.gud) - this.gtB), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gtA);
                canvas.drawRect(this.gts, this.gtB + this.gtq.top + this.gud, this.gtz + this.gts, (this.gtq.bottom - this.gud) - this.gtB, this.mPaint);
            }
        } else if (this.gtW != null) {
            RectF rectF2 = new RectF(this.gtq.left + this.gud + this.gtB, this.gtq.top + this.gud + 0.5f, (this.gtq.right - this.gud) - this.gtB, this.gtX);
            Rect rect2 = new Rect(0, (int) (this.gtW.getHeight() - rectF2.height()), this.gtW.getWidth(), this.gtW.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.guh);
            canvas.drawBitmap(this.gtW, rect2, rectF2, this.mPaint);
        } else if (this.gtE != null) {
            canvas.drawBitmap(this.gtE, (Rect) null, new RectF(this.gtq.left + this.gud + this.gtB, this.gtr, (this.gtq.right - this.gud) - this.gtB, this.gtr + this.gtE.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gtA);
            canvas.drawRect(this.gtB + this.gtq.left + this.gud, this.gtr, (this.gtq.right - this.gud) - this.gtB, this.gtz + this.gtr, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fki) && this.gue != null) {
            if (this.gtO) {
                if (this.gtS) {
                    this.mPaint.setColor(this.gtR);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gtQ) {
                        Rect rect = new Rect();
                        this.gtt.getTextBounds(this.fki, 0, this.fki.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.guf;
                        canvas.drawRoundRect(new RectF(width, (this.gtq.bottom + this.gtP) - this.guf, rect.width() + width + (this.guf * 2), this.gtq.bottom + this.gtP + this.gue.getHeight() + this.guf), this.guf, this.guf, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gtq.left, (this.gtq.bottom + this.gtP) - this.guf, this.gtq.right, this.gtq.bottom + this.gtP + this.gue.getHeight() + this.guf), this.guf, this.guf, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gtQ) {
                    canvas.translate(0.0f, this.gtq.bottom + this.gtP);
                } else {
                    canvas.translate(this.gtq.left + this.guf, this.gtq.bottom + this.gtP);
                }
                this.gue.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gtS) {
                this.mPaint.setColor(this.gtR);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gtQ) {
                    Rect rect2 = new Rect();
                    this.gtt.getTextBounds(this.fki, 0, this.fki.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.guf;
                    canvas.drawRoundRect(new RectF(width2, ((this.gtq.top - this.gtP) - this.gue.getHeight()) - this.guf, rect2.width() + width2 + (this.guf * 2), (this.gtq.top - this.gtP) + this.guf), this.guf, this.guf, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gtq.left, ((this.gtq.top - this.gtP) - this.gue.getHeight()) - this.guf, this.gtq.right, (this.gtq.top - this.gtP) + this.guf), this.guf, this.guf, this.mPaint);
                }
            }
            canvas.save();
            if (this.gtQ) {
                canvas.translate(0.0f, (this.gtq.top - this.gtP) - this.gue.getHeight());
            } else {
                canvas.translate(this.gtq.left + this.guf, (this.gtq.top - this.gtP) - this.gue.getHeight());
            }
            this.gue.draw(canvas);
            canvas.restore();
        }
    }

    private void bpt() {
        if (this.gtJ) {
            if (this.gtW == null) {
                this.gts += this.gto;
                int i = this.gtz;
                if (this.gtE != null) {
                    i = this.gtE.getWidth();
                }
                if (this.gtT) {
                    if (i + this.gts > this.gtq.right - this.gud || this.gts < this.gtq.left + this.gud) {
                        this.gto = -this.gto;
                    }
                } else {
                    if (i + this.gts > this.gtq.right - this.gud) {
                        this.gts = this.gtq.left + this.gud + 0.5f;
                    }
                }
            } else {
                this.gtY += this.gto;
                if (this.gtY > this.gtq.right - this.gud) {
                    this.gtY = this.gtq.left + this.gud + 0.5f;
                }
            }
        } else if (this.gtW == null) {
            this.gtr += this.gto;
            int i2 = this.gtz;
            if (this.gtE != null) {
                i2 = this.gtE.getHeight();
            }
            if (this.gtT) {
                if (i2 + this.gtr > this.gtq.bottom - this.gud || this.gtr < this.gtq.top + this.gud) {
                    this.gto = -this.gto;
                }
            } else {
                if (i2 + this.gtr > this.gtq.bottom - this.gud) {
                    this.gtr = this.gtq.top + this.gud + 0.5f;
                }
            }
        } else {
            this.gtX += this.gto;
            if (this.gtX > this.gtq.bottom - this.gud) {
                this.gtX = this.gtq.top + this.gud + 0.5f;
            }
        }
        postInvalidateDelayed(this.gtp, this.gtq.left, this.gtq.top, this.gtq.right, this.gtq.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bpu();
    }

    private void bpu() {
        int i = this.baF + this.gtI;
        int width = (getWidth() - this.gtw) / 2;
        this.gtq = new Rect(width, i, this.gtw + width, this.gtx + i);
        if (this.gtJ) {
            float f = this.gtq.left + this.gud + 0.5f;
            this.gts = f;
            this.gtY = f;
            return;
        }
        float f2 = this.gtq.top + this.gud + 0.5f;
        this.gtr = f2;
        this.gtX = f2;
    }

    public Rect sx(int i) {
        if (this.gug) {
            Rect rect = new Rect(this.gtq);
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
        this.gtJ = z;
        if (this.gtV != null || this.gtU) {
            if (this.gtJ) {
                this.gtW = this.guc;
            } else {
                this.gtW = this.gub;
            }
        } else if (this.gtD != null || this.gtC) {
            if (this.gtJ) {
                this.gtE = this.gua;
            } else {
                this.gtE = this.gtZ;
            }
        }
        if (this.gtJ) {
            this.fki = this.gtL;
            this.gtx = this.gty;
            this.gtp = (int) (((this.gtG * 1.0f) * this.gto) / this.gtw);
        } else {
            this.fki = this.gtK;
            this.gtx = this.gtw;
            this.gtp = (int) (((this.gtG * 1.0f) * this.gto) / this.gtx);
        }
        if (!TextUtils.isEmpty(this.fki)) {
            if (this.gtQ) {
                this.gue = new StaticLayout(this.fki, this.gtt, a.cI(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gue = new StaticLayout(this.fki, this.gtt, this.gtw - (this.guf * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gtH) {
            int i = a.cI(getContext()).y;
            if (this.gtI == 0) {
                this.baF = (i - this.gtx) / 2;
            } else {
                this.baF = ((i - this.gtx) / 2) + (this.gtI / 2);
            }
        }
        bpu();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gtJ;
    }

    public int getMaskColor() {
        return this.axD;
    }

    public void setMaskColor(int i) {
        this.axD = i;
    }

    public int getCornerLength() {
        return this.gtu;
    }

    public void setCornerLength(int i) {
        this.gtu = i;
    }

    public int getCornerSize() {
        return this.gtv;
    }

    public void setCornerSize(int i) {
        this.gtv = i;
    }

    public int getRectWidth() {
        return this.gtw;
    }

    public void setRectWidth(int i) {
        this.gtw = i;
    }

    public int getRectHeight() {
        return this.gtx;
    }

    public void setRectHeight(int i) {
        this.gtx = i;
    }

    public int getBarcodeRectHeight() {
        return this.gty;
    }

    public void setBarcodeRectHeight(int i) {
        this.gty = i;
    }

    public int getTopOffset() {
        return this.baF;
    }

    public void setTopOffset(int i) {
        this.baF = i;
    }

    public int getScanLineSize() {
        return this.gtz;
    }

    public void setScanLineSize(int i) {
        this.gtz = i;
    }

    public int getScanLineColor() {
        return this.gtA;
    }

    public void setScanLineColor(int i) {
        this.gtA = i;
    }

    public int getScanLineMargin() {
        return this.gtB;
    }

    public void setScanLineMargin(int i) {
        this.gtB = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gtC = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gtD;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gtD = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gtE;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gtE = bitmap;
    }

    public int getBorderSize() {
        return this.gtF;
    }

    public void setBorderSize(int i) {
        this.gtF = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gtG;
    }

    public void setAnimTime(int i) {
        this.gtG = i;
    }

    public void setCenterVertical(boolean z) {
        this.gtH = z;
    }

    public int getToolbarHeight() {
        return this.gtI;
    }

    public void setToolbarHeight(int i) {
        this.gtI = i;
    }

    public String getQRCodeTipText() {
        return this.gtK;
    }

    public void setQRCodeTipText(String str) {
        this.gtK = str;
    }

    public String getBarCodeTipText() {
        return this.gtL;
    }

    public void setBarCodeTipText(String str) {
        this.gtL = str;
    }

    public String getTipText() {
        return this.fki;
    }

    public void setTipText(String str) {
        this.fki = str;
    }

    public int getTipTextColor() {
        return this.gtN;
    }

    public void setTipTextColor(int i) {
        this.gtN = i;
    }

    public int getTipTextSize() {
        return this.gtM;
    }

    public void setTipTextSize(int i) {
        this.gtM = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gtO = z;
    }

    public int getTipTextMargin() {
        return this.gtP;
    }

    public void setTipTextMargin(int i) {
        this.gtP = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gtQ = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gtS = z;
    }

    public int getTipBackgroundColor() {
        return this.gtR;
    }

    public void setTipBackgroundColor(int i) {
        this.gtR = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gtT = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gtU = z;
    }

    public float getHalfCornerSize() {
        return this.gud;
    }

    public void setHalfCornerSize(float f) {
        this.gud = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gue;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gue = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.guf;
    }

    public void setTipBackgroundRadius(int i) {
        this.guf = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gug = z;
    }
}
