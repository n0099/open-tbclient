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
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
    private int bPp;
    private int cuu;
    private String gTJ;
    private int ieA;
    private int ieB;
    private int ieC;
    private boolean ieD;
    private Drawable ieE;
    private Bitmap ieF;
    private int ieG;
    private int ieH;
    private boolean ieI;
    private int ieJ;
    private boolean ieK;
    private String ieL;
    private String ieM;
    private int ieN;
    private int ieO;
    private boolean ieP;
    private int ieQ;
    private boolean ieR;
    private int ieS;
    private boolean ieT;
    private boolean ieU;
    private boolean ieV;
    private Drawable ieW;
    private Bitmap ieX;
    private float ieY;
    private float ieZ;
    private Bitmap iel;
    private Bitmap iem;
    private Bitmap ien;
    private Bitmap ieo;
    private int iep;
    private int ieq;
    private Rect ier;
    private float ies;
    private float iet;
    private TextPaint ieu;
    private int iev;
    private int iew;
    private int iex;
    private int iey;
    private int iez;
    private Bitmap ifa;
    private Bitmap ifb;
    private Bitmap ifc;
    private Bitmap ifd;
    private float ife;
    private StaticLayout iff;
    private int ifg;
    private boolean ifh;
    private ColorMatrixColorFilter ifi;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bPp = Color.parseColor("#33FFFFFF");
        this.iev = a.e(context, 20.0f);
        this.iew = a.e(context, 3.0f);
        this.ieA = a.e(context, 1.0f);
        this.ieB = -1;
        this.cuu = a.e(context, 90.0f);
        this.iex = a.e(context, 200.0f);
        this.iez = a.e(context, 140.0f);
        this.ieC = 0;
        this.ieD = false;
        this.ieE = null;
        this.ieF = null;
        this.ieG = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ieH = 1000;
        this.ieI = false;
        this.ieJ = 0;
        this.ieK = false;
        this.iep = a.e(context, 2.0f);
        this.gTJ = null;
        this.ieN = a.sp2px(context, 14.0f);
        this.ieO = -1;
        this.ieP = false;
        this.ieQ = a.e(context, 20.0f);
        this.ieR = false;
        this.ieS = Color.parseColor("#22000000");
        this.ieT = false;
        this.ieU = false;
        this.ieV = false;
        this.ieu = new TextPaint();
        this.ieu.setAntiAlias(true);
        this.ifg = a.e(context, 4.0f);
        this.ifh = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ifi = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bWc();
        bWb();
    }

    private void bWb() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iev;
        options.outHeight = this.iev;
        this.iel = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iem = Bitmap.createBitmap(this.iel, 0, 0, this.iel.getWidth(), this.iel.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.ien = Bitmap.createBitmap(this.iel, 0, 0, this.iel.getWidth(), this.iel.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ieo = Bitmap.createBitmap(this.iel, 0, 0, this.iel.getWidth(), this.iel.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.cuu = typedArray.getDimensionPixelSize(i, this.cuu);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.iew = typedArray.getDimensionPixelSize(i, this.iew);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.iev = typedArray.getDimensionPixelSize(i, this.iev);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.ieA = typedArray.getDimensionPixelSize(i, this.ieA);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.iex = typedArray.getDimensionPixelSize(i, this.iex);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.bPp = typedArray.getColor(i, this.bPp);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.ieB = typedArray.getColor(i, this.ieB);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.ieC = typedArray.getDimensionPixelSize(i, this.ieC);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ieD = typedArray.getBoolean(i, this.ieD);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.ieE = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.ieG = typedArray.getDimensionPixelSize(i, this.ieG);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.ieH = typedArray.getInteger(i, this.ieH);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.ieI = typedArray.getBoolean(i, this.ieI);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.ieJ = typedArray.getDimensionPixelSize(i, this.ieJ);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.iez = typedArray.getDimensionPixelSize(i, this.iez);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.ieK = typedArray.getBoolean(i, this.ieK);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.ieM = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.ieL = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.ieN = typedArray.getDimensionPixelSize(i, this.ieN);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.ieO = typedArray.getColor(i, this.ieO);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ieP = typedArray.getBoolean(i, this.ieP);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.ieQ = typedArray.getDimensionPixelSize(i, this.ieQ);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ieR = typedArray.getBoolean(i, this.ieR);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.ieT = typedArray.getBoolean(i, this.ieT);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.ieS = typedArray.getColor(i, this.ieS);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.ieU = typedArray.getBoolean(i, this.ieU);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ieV = typedArray.getBoolean(i, this.ieV);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ieW = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.ifh = typedArray.getBoolean(i, this.ifh);
        }
    }

    private void bWc() {
        if (this.ieW != null) {
            this.ifc = ((BitmapDrawable) this.ieW).getBitmap();
        }
        if (this.ifc == null) {
            this.ifc = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ifc = a.d(this.ifc, this.ieB);
        }
        this.ifd = a.adjustPhotoRotation(this.ifc, 90);
        this.ifd = a.adjustPhotoRotation(this.ifd, 90);
        this.ifd = a.adjustPhotoRotation(this.ifd, 90);
        if (this.ieE != null) {
            this.ifa = ((BitmapDrawable) this.ieE).getBitmap();
        }
        if (this.ifa == null) {
            this.ifa = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ifa = a.d(this.ifa, this.ieB);
        }
        this.ifb = a.adjustPhotoRotation(this.ifa, 90);
        this.ife = (1.0f * this.iew) / 2.0f;
        this.ieu.setTextSize(this.ieN);
        this.ieu.setColor(this.ieO);
        setIsBarcode(this.ieK);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ier != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            bWd();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bPp != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bPp);
            canvas.drawRect(0.0f, 0.0f, width, this.ier.top, this.mPaint);
            canvas.drawRect(0.0f, this.ier.top, this.ier.left, this.ier.bottom + 1, this.mPaint);
            canvas.drawRect(this.ier.right + 1, this.ier.top, width, this.ier.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ier.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.ieG > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ieG);
            canvas.drawRect(this.ier, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iel, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iem, getMainFrameRight() - this.iel.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ien, getMainFrameLeft(), getMainFrameBottom() - this.iel.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ieo, getMainFrameRight() - this.iel.getWidth(), getMainFrameBottom() - this.iel.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ier.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ier.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ier.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ier.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ieG / 2;
    }

    private void W(Canvas canvas) {
        if (this.ieK) {
            if (this.ieX != null) {
                RectF rectF = new RectF(this.ier.left + this.ife + 0.5f, this.ier.top + this.ife + this.ieC, this.ieZ, (this.ier.bottom - this.ife) - this.ieC);
                Rect rect = new Rect((int) (this.ieX.getWidth() - rectF.width()), 0, this.ieX.getWidth(), this.ieX.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ieX, rect, rectF, this.mPaint);
            } else if (this.ieF != null) {
                canvas.drawBitmap(this.ieF, (Rect) null, new RectF(this.iet, this.ier.top + this.ife + this.ieC, this.iet + this.ieF.getWidth(), (this.ier.bottom - this.ife) - this.ieC), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ieB);
                canvas.drawRect(this.iet, this.ieC + this.ier.top + this.ife, this.ieA + this.iet, (this.ier.bottom - this.ife) - this.ieC, this.mPaint);
            }
        } else if (this.ieX != null) {
            RectF rectF2 = new RectF(this.ier.left + this.ife + this.ieC, this.ier.top + this.ife + 0.5f, (this.ier.right - this.ife) - this.ieC, this.ieY);
            Rect rect2 = new Rect(0, (int) (this.ieX.getHeight() - rectF2.height()), this.ieX.getWidth(), this.ieX.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ifi);
            canvas.drawBitmap(this.ieX, rect2, rectF2, this.mPaint);
        } else if (this.ieF != null) {
            canvas.drawBitmap(this.ieF, (Rect) null, new RectF(this.ier.left + this.ife + this.ieC, this.ies, (this.ier.right - this.ife) - this.ieC, this.ies + this.ieF.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ieB);
            canvas.drawRect(this.ieC + this.ier.left + this.ife, this.ies, (this.ier.right - this.ife) - this.ieC, this.ieA + this.ies, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.gTJ) && this.iff != null) {
            if (this.ieP) {
                if (this.ieT) {
                    this.mPaint.setColor(this.ieS);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ieR) {
                        Rect rect = new Rect();
                        this.ieu.getTextBounds(this.gTJ, 0, this.gTJ.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ifg;
                        canvas.drawRoundRect(new RectF(width, (this.ier.bottom + this.ieQ) - this.ifg, rect.width() + width + (this.ifg * 2), this.ier.bottom + this.ieQ + this.iff.getHeight() + this.ifg), this.ifg, this.ifg, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ier.left, (this.ier.bottom + this.ieQ) - this.ifg, this.ier.right, this.ier.bottom + this.ieQ + this.iff.getHeight() + this.ifg), this.ifg, this.ifg, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ieR) {
                    canvas.translate(0.0f, this.ier.bottom + this.ieQ);
                } else {
                    canvas.translate(this.ier.left + this.ifg, this.ier.bottom + this.ieQ);
                }
                this.iff.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ieT) {
                this.mPaint.setColor(this.ieS);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ieR) {
                    Rect rect2 = new Rect();
                    this.ieu.getTextBounds(this.gTJ, 0, this.gTJ.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ifg;
                    canvas.drawRoundRect(new RectF(width2, ((this.ier.top - this.ieQ) - this.iff.getHeight()) - this.ifg, rect2.width() + width2 + (this.ifg * 2), (this.ier.top - this.ieQ) + this.ifg), this.ifg, this.ifg, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ier.left, ((this.ier.top - this.ieQ) - this.iff.getHeight()) - this.ifg, this.ier.right, (this.ier.top - this.ieQ) + this.ifg), this.ifg, this.ifg, this.mPaint);
                }
            }
            canvas.save();
            if (this.ieR) {
                canvas.translate(0.0f, (this.ier.top - this.ieQ) - this.iff.getHeight());
            } else {
                canvas.translate(this.ier.left + this.ifg, (this.ier.top - this.ieQ) - this.iff.getHeight());
            }
            this.iff.draw(canvas);
            canvas.restore();
        }
    }

    private void bWd() {
        if (this.ieK) {
            if (this.ieX == null) {
                this.iet += this.iep;
                int i = this.ieA;
                if (this.ieF != null) {
                    i = this.ieF.getWidth();
                }
                if (this.ieU) {
                    if (i + this.iet > this.ier.right - this.ife || this.iet < this.ier.left + this.ife) {
                        this.iep = -this.iep;
                    }
                } else {
                    if (i + this.iet > this.ier.right - this.ife) {
                        this.iet = this.ier.left + this.ife + 0.5f;
                    }
                }
            } else {
                this.ieZ += this.iep;
                if (this.ieZ > this.ier.right - this.ife) {
                    this.ieZ = this.ier.left + this.ife + 0.5f;
                }
            }
        } else if (this.ieX == null) {
            this.ies += this.iep;
            int i2 = this.ieA;
            if (this.ieF != null) {
                i2 = this.ieF.getHeight();
            }
            if (this.ieU) {
                if (i2 + this.ies > this.ier.bottom - this.ife || this.ies < this.ier.top + this.ife) {
                    this.iep = -this.iep;
                }
            } else {
                if (i2 + this.ies > this.ier.bottom - this.ife) {
                    this.ies = this.ier.top + this.ife + 0.5f;
                }
            }
        } else {
            this.ieY += this.iep;
            if (this.ieY > this.ier.bottom - this.ife) {
                this.ieY = this.ier.top + this.ife + 0.5f;
            }
        }
        postInvalidateDelayed(this.ieq, this.ier.left, this.ier.top, this.ier.right, this.ier.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bWe();
    }

    private void bWe() {
        int i = this.cuu + this.ieJ;
        int width = (getWidth() - this.iex) / 2;
        this.ier = new Rect(width, i, this.iex + width, this.iey + i);
        if (this.ieK) {
            float f = this.ier.left + this.ife + 0.5f;
            this.iet = f;
            this.ieZ = f;
            return;
        }
        float f2 = this.ier.top + this.ife + 0.5f;
        this.ies = f2;
        this.ieY = f2;
    }

    public Rect xH(int i) {
        if (this.ifh) {
            Rect rect = new Rect(this.ier);
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
        this.ieK = z;
        if (this.ieW != null || this.ieV) {
            if (this.ieK) {
                this.ieX = this.ifd;
            } else {
                this.ieX = this.ifc;
            }
        } else if (this.ieE != null || this.ieD) {
            if (this.ieK) {
                this.ieF = this.ifb;
            } else {
                this.ieF = this.ifa;
            }
        }
        if (this.ieK) {
            this.gTJ = this.ieM;
            this.iey = this.iez;
            this.ieq = (int) (((this.ieH * 1.0f) * this.iep) / this.iex);
        } else {
            this.gTJ = this.ieL;
            this.iey = this.iex;
            this.ieq = (int) (((this.ieH * 1.0f) * this.iep) / this.iey);
        }
        if (!TextUtils.isEmpty(this.gTJ)) {
            if (this.ieR) {
                this.iff = new StaticLayout(this.gTJ, this.ieu, a.ep(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iff = new StaticLayout(this.gTJ, this.ieu, this.iex - (this.ifg * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ieI) {
            int i = a.ep(getContext()).y;
            if (this.ieJ == 0) {
                this.cuu = (i - this.iey) / 2;
            } else {
                this.cuu = ((i - this.iey) / 2) + (this.ieJ / 2);
            }
        }
        bWe();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ieK;
    }

    public int getMaskColor() {
        return this.bPp;
    }

    public void setMaskColor(int i) {
        this.bPp = i;
    }

    public int getCornerLength() {
        return this.iev;
    }

    public void setCornerLength(int i) {
        this.iev = i;
    }

    public int getCornerSize() {
        return this.iew;
    }

    public void setCornerSize(int i) {
        this.iew = i;
    }

    public int getRectWidth() {
        return this.iex;
    }

    public void setRectWidth(int i) {
        this.iex = i;
    }

    public int getRectHeight() {
        return this.iey;
    }

    public void setRectHeight(int i) {
        this.iey = i;
    }

    public int getBarcodeRectHeight() {
        return this.iez;
    }

    public void setBarcodeRectHeight(int i) {
        this.iez = i;
    }

    public int getTopOffset() {
        return this.cuu;
    }

    public void setTopOffset(int i) {
        this.cuu = i;
    }

    public int getScanLineSize() {
        return this.ieA;
    }

    public void setScanLineSize(int i) {
        this.ieA = i;
    }

    public int getScanLineColor() {
        return this.ieB;
    }

    public void setScanLineColor(int i) {
        this.ieB = i;
    }

    public int getScanLineMargin() {
        return this.ieC;
    }

    public void setScanLineMargin(int i) {
        this.ieC = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ieD = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ieE;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ieE = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ieF;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ieF = bitmap;
    }

    public int getBorderSize() {
        return this.ieG;
    }

    public void setBorderSize(int i) {
        this.ieG = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ieH;
    }

    public void setAnimTime(int i) {
        this.ieH = i;
    }

    public void setCenterVertical(boolean z) {
        this.ieI = z;
    }

    public int getToolbarHeight() {
        return this.ieJ;
    }

    public void setToolbarHeight(int i) {
        this.ieJ = i;
    }

    public String getQRCodeTipText() {
        return this.ieL;
    }

    public void setQRCodeTipText(String str) {
        this.ieL = str;
    }

    public String getBarCodeTipText() {
        return this.ieM;
    }

    public void setBarCodeTipText(String str) {
        this.ieM = str;
    }

    public String getTipText() {
        return this.gTJ;
    }

    public void setTipText(String str) {
        this.gTJ = str;
    }

    public int getTipTextColor() {
        return this.ieO;
    }

    public void setTipTextColor(int i) {
        this.ieO = i;
    }

    public int getTipTextSize() {
        return this.ieN;
    }

    public void setTipTextSize(int i) {
        this.ieN = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ieP = z;
    }

    public int getTipTextMargin() {
        return this.ieQ;
    }

    public void setTipTextMargin(int i) {
        this.ieQ = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ieR = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ieT = z;
    }

    public int getTipBackgroundColor() {
        return this.ieS;
    }

    public void setTipBackgroundColor(int i) {
        this.ieS = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ieU = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ieV = z;
    }

    public float getHalfCornerSize() {
        return this.ife;
    }

    public void setHalfCornerSize(float f) {
        this.ife = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iff;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iff = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ifg;
    }

    public void setTipBackgroundRadius(int i) {
        this.ifg = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ifh = z;
    }
}
