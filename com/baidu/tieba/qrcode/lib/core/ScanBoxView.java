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
    private int bPo;
    private int cut;
    private String gTI;
    private int ieA;
    private int ieB;
    private boolean ieC;
    private Drawable ieD;
    private Bitmap ieE;
    private int ieF;
    private int ieG;
    private boolean ieH;
    private int ieI;
    private boolean ieJ;
    private String ieK;
    private String ieL;
    private int ieM;
    private int ieN;
    private boolean ieO;
    private int ieP;
    private boolean ieQ;
    private int ieR;
    private boolean ieS;
    private boolean ieT;
    private boolean ieU;
    private Drawable ieV;
    private Bitmap ieW;
    private float ieX;
    private float ieY;
    private Bitmap ieZ;
    private Bitmap iek;
    private Bitmap iel;
    private Bitmap iem;
    private Bitmap ien;
    private int ieo;
    private int iep;
    private Rect ieq;
    private float ier;
    private float ies;
    private TextPaint iet;
    private int ieu;
    private int iev;
    private int iew;
    private int iex;
    private int iey;
    private int iez;
    private Bitmap ifa;
    private Bitmap ifb;
    private Bitmap ifc;
    private float ifd;
    private StaticLayout ife;
    private int iff;
    private boolean ifg;
    private ColorMatrixColorFilter ifh;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bPo = Color.parseColor("#33FFFFFF");
        this.ieu = a.e(context, 20.0f);
        this.iev = a.e(context, 3.0f);
        this.iez = a.e(context, 1.0f);
        this.ieA = -1;
        this.cut = a.e(context, 90.0f);
        this.iew = a.e(context, 200.0f);
        this.iey = a.e(context, 140.0f);
        this.ieB = 0;
        this.ieC = false;
        this.ieD = null;
        this.ieE = null;
        this.ieF = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ieG = 1000;
        this.ieH = false;
        this.ieI = 0;
        this.ieJ = false;
        this.ieo = a.e(context, 2.0f);
        this.gTI = null;
        this.ieM = a.sp2px(context, 14.0f);
        this.ieN = -1;
        this.ieO = false;
        this.ieP = a.e(context, 20.0f);
        this.ieQ = false;
        this.ieR = Color.parseColor("#22000000");
        this.ieS = false;
        this.ieT = false;
        this.ieU = false;
        this.iet = new TextPaint();
        this.iet.setAntiAlias(true);
        this.iff = a.e(context, 4.0f);
        this.ifg = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ifh = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.ieu;
        options.outHeight = this.ieu;
        this.iek = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iel = Bitmap.createBitmap(this.iek, 0, 0, this.iek.getWidth(), this.iek.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iem = Bitmap.createBitmap(this.iek, 0, 0, this.iek.getWidth(), this.iek.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ien = Bitmap.createBitmap(this.iek, 0, 0, this.iek.getWidth(), this.iek.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.cut = typedArray.getDimensionPixelSize(i, this.cut);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.iev = typedArray.getDimensionPixelSize(i, this.iev);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.ieu = typedArray.getDimensionPixelSize(i, this.ieu);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.iez = typedArray.getDimensionPixelSize(i, this.iez);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.iew = typedArray.getDimensionPixelSize(i, this.iew);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.bPo = typedArray.getColor(i, this.bPo);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.ieA = typedArray.getColor(i, this.ieA);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.ieB = typedArray.getDimensionPixelSize(i, this.ieB);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ieC = typedArray.getBoolean(i, this.ieC);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.ieD = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.ieF = typedArray.getDimensionPixelSize(i, this.ieF);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.ieG = typedArray.getInteger(i, this.ieG);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.ieH = typedArray.getBoolean(i, this.ieH);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.ieI = typedArray.getDimensionPixelSize(i, this.ieI);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.iey = typedArray.getDimensionPixelSize(i, this.iey);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.ieJ = typedArray.getBoolean(i, this.ieJ);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.ieL = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.ieK = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.ieM = typedArray.getDimensionPixelSize(i, this.ieM);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.ieN = typedArray.getColor(i, this.ieN);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ieO = typedArray.getBoolean(i, this.ieO);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.ieP = typedArray.getDimensionPixelSize(i, this.ieP);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ieQ = typedArray.getBoolean(i, this.ieQ);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.ieS = typedArray.getBoolean(i, this.ieS);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.ieR = typedArray.getColor(i, this.ieR);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.ieT = typedArray.getBoolean(i, this.ieT);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ieU = typedArray.getBoolean(i, this.ieU);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ieV = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.ifg = typedArray.getBoolean(i, this.ifg);
        }
    }

    private void bWc() {
        if (this.ieV != null) {
            this.ifb = ((BitmapDrawable) this.ieV).getBitmap();
        }
        if (this.ifb == null) {
            this.ifb = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ifb = a.d(this.ifb, this.ieA);
        }
        this.ifc = a.adjustPhotoRotation(this.ifb, 90);
        this.ifc = a.adjustPhotoRotation(this.ifc, 90);
        this.ifc = a.adjustPhotoRotation(this.ifc, 90);
        if (this.ieD != null) {
            this.ieZ = ((BitmapDrawable) this.ieD).getBitmap();
        }
        if (this.ieZ == null) {
            this.ieZ = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ieZ = a.d(this.ieZ, this.ieA);
        }
        this.ifa = a.adjustPhotoRotation(this.ieZ, 90);
        this.ifd = (1.0f * this.iev) / 2.0f;
        this.iet.setTextSize(this.ieM);
        this.iet.setColor(this.ieN);
        setIsBarcode(this.ieJ);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ieq != null) {
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
        if (this.bPo != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bPo);
            canvas.drawRect(0.0f, 0.0f, width, this.ieq.top, this.mPaint);
            canvas.drawRect(0.0f, this.ieq.top, this.ieq.left, this.ieq.bottom + 1, this.mPaint);
            canvas.drawRect(this.ieq.right + 1, this.ieq.top, width, this.ieq.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ieq.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.ieF > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ieF);
            canvas.drawRect(this.ieq, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iek, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iel, getMainFrameRight() - this.iek.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iem, getMainFrameLeft(), getMainFrameBottom() - this.iek.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ien, getMainFrameRight() - this.iek.getWidth(), getMainFrameBottom() - this.iek.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ieq.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ieq.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ieq.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ieq.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ieF / 2;
    }

    private void W(Canvas canvas) {
        if (this.ieJ) {
            if (this.ieW != null) {
                RectF rectF = new RectF(this.ieq.left + this.ifd + 0.5f, this.ieq.top + this.ifd + this.ieB, this.ieY, (this.ieq.bottom - this.ifd) - this.ieB);
                Rect rect = new Rect((int) (this.ieW.getWidth() - rectF.width()), 0, this.ieW.getWidth(), this.ieW.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ieW, rect, rectF, this.mPaint);
            } else if (this.ieE != null) {
                canvas.drawBitmap(this.ieE, (Rect) null, new RectF(this.ies, this.ieq.top + this.ifd + this.ieB, this.ies + this.ieE.getWidth(), (this.ieq.bottom - this.ifd) - this.ieB), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ieA);
                canvas.drawRect(this.ies, this.ieB + this.ieq.top + this.ifd, this.iez + this.ies, (this.ieq.bottom - this.ifd) - this.ieB, this.mPaint);
            }
        } else if (this.ieW != null) {
            RectF rectF2 = new RectF(this.ieq.left + this.ifd + this.ieB, this.ieq.top + this.ifd + 0.5f, (this.ieq.right - this.ifd) - this.ieB, this.ieX);
            Rect rect2 = new Rect(0, (int) (this.ieW.getHeight() - rectF2.height()), this.ieW.getWidth(), this.ieW.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ifh);
            canvas.drawBitmap(this.ieW, rect2, rectF2, this.mPaint);
        } else if (this.ieE != null) {
            canvas.drawBitmap(this.ieE, (Rect) null, new RectF(this.ieq.left + this.ifd + this.ieB, this.ier, (this.ieq.right - this.ifd) - this.ieB, this.ier + this.ieE.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ieA);
            canvas.drawRect(this.ieB + this.ieq.left + this.ifd, this.ier, (this.ieq.right - this.ifd) - this.ieB, this.iez + this.ier, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.gTI) && this.ife != null) {
            if (this.ieO) {
                if (this.ieS) {
                    this.mPaint.setColor(this.ieR);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ieQ) {
                        Rect rect = new Rect();
                        this.iet.getTextBounds(this.gTI, 0, this.gTI.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iff;
                        canvas.drawRoundRect(new RectF(width, (this.ieq.bottom + this.ieP) - this.iff, rect.width() + width + (this.iff * 2), this.ieq.bottom + this.ieP + this.ife.getHeight() + this.iff), this.iff, this.iff, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ieq.left, (this.ieq.bottom + this.ieP) - this.iff, this.ieq.right, this.ieq.bottom + this.ieP + this.ife.getHeight() + this.iff), this.iff, this.iff, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ieQ) {
                    canvas.translate(0.0f, this.ieq.bottom + this.ieP);
                } else {
                    canvas.translate(this.ieq.left + this.iff, this.ieq.bottom + this.ieP);
                }
                this.ife.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ieS) {
                this.mPaint.setColor(this.ieR);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ieQ) {
                    Rect rect2 = new Rect();
                    this.iet.getTextBounds(this.gTI, 0, this.gTI.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iff;
                    canvas.drawRoundRect(new RectF(width2, ((this.ieq.top - this.ieP) - this.ife.getHeight()) - this.iff, rect2.width() + width2 + (this.iff * 2), (this.ieq.top - this.ieP) + this.iff), this.iff, this.iff, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ieq.left, ((this.ieq.top - this.ieP) - this.ife.getHeight()) - this.iff, this.ieq.right, (this.ieq.top - this.ieP) + this.iff), this.iff, this.iff, this.mPaint);
                }
            }
            canvas.save();
            if (this.ieQ) {
                canvas.translate(0.0f, (this.ieq.top - this.ieP) - this.ife.getHeight());
            } else {
                canvas.translate(this.ieq.left + this.iff, (this.ieq.top - this.ieP) - this.ife.getHeight());
            }
            this.ife.draw(canvas);
            canvas.restore();
        }
    }

    private void bWd() {
        if (this.ieJ) {
            if (this.ieW == null) {
                this.ies += this.ieo;
                int i = this.iez;
                if (this.ieE != null) {
                    i = this.ieE.getWidth();
                }
                if (this.ieT) {
                    if (i + this.ies > this.ieq.right - this.ifd || this.ies < this.ieq.left + this.ifd) {
                        this.ieo = -this.ieo;
                    }
                } else {
                    if (i + this.ies > this.ieq.right - this.ifd) {
                        this.ies = this.ieq.left + this.ifd + 0.5f;
                    }
                }
            } else {
                this.ieY += this.ieo;
                if (this.ieY > this.ieq.right - this.ifd) {
                    this.ieY = this.ieq.left + this.ifd + 0.5f;
                }
            }
        } else if (this.ieW == null) {
            this.ier += this.ieo;
            int i2 = this.iez;
            if (this.ieE != null) {
                i2 = this.ieE.getHeight();
            }
            if (this.ieT) {
                if (i2 + this.ier > this.ieq.bottom - this.ifd || this.ier < this.ieq.top + this.ifd) {
                    this.ieo = -this.ieo;
                }
            } else {
                if (i2 + this.ier > this.ieq.bottom - this.ifd) {
                    this.ier = this.ieq.top + this.ifd + 0.5f;
                }
            }
        } else {
            this.ieX += this.ieo;
            if (this.ieX > this.ieq.bottom - this.ifd) {
                this.ieX = this.ieq.top + this.ifd + 0.5f;
            }
        }
        postInvalidateDelayed(this.iep, this.ieq.left, this.ieq.top, this.ieq.right, this.ieq.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bWe();
    }

    private void bWe() {
        int i = this.cut + this.ieI;
        int width = (getWidth() - this.iew) / 2;
        this.ieq = new Rect(width, i, this.iew + width, this.iex + i);
        if (this.ieJ) {
            float f = this.ieq.left + this.ifd + 0.5f;
            this.ies = f;
            this.ieY = f;
            return;
        }
        float f2 = this.ieq.top + this.ifd + 0.5f;
        this.ier = f2;
        this.ieX = f2;
    }

    public Rect xH(int i) {
        if (this.ifg) {
            Rect rect = new Rect(this.ieq);
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
        this.ieJ = z;
        if (this.ieV != null || this.ieU) {
            if (this.ieJ) {
                this.ieW = this.ifc;
            } else {
                this.ieW = this.ifb;
            }
        } else if (this.ieD != null || this.ieC) {
            if (this.ieJ) {
                this.ieE = this.ifa;
            } else {
                this.ieE = this.ieZ;
            }
        }
        if (this.ieJ) {
            this.gTI = this.ieL;
            this.iex = this.iey;
            this.iep = (int) (((this.ieG * 1.0f) * this.ieo) / this.iew);
        } else {
            this.gTI = this.ieK;
            this.iex = this.iew;
            this.iep = (int) (((this.ieG * 1.0f) * this.ieo) / this.iex);
        }
        if (!TextUtils.isEmpty(this.gTI)) {
            if (this.ieQ) {
                this.ife = new StaticLayout(this.gTI, this.iet, a.ep(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ife = new StaticLayout(this.gTI, this.iet, this.iew - (this.iff * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ieH) {
            int i = a.ep(getContext()).y;
            if (this.ieI == 0) {
                this.cut = (i - this.iex) / 2;
            } else {
                this.cut = ((i - this.iex) / 2) + (this.ieI / 2);
            }
        }
        bWe();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ieJ;
    }

    public int getMaskColor() {
        return this.bPo;
    }

    public void setMaskColor(int i) {
        this.bPo = i;
    }

    public int getCornerLength() {
        return this.ieu;
    }

    public void setCornerLength(int i) {
        this.ieu = i;
    }

    public int getCornerSize() {
        return this.iev;
    }

    public void setCornerSize(int i) {
        this.iev = i;
    }

    public int getRectWidth() {
        return this.iew;
    }

    public void setRectWidth(int i) {
        this.iew = i;
    }

    public int getRectHeight() {
        return this.iex;
    }

    public void setRectHeight(int i) {
        this.iex = i;
    }

    public int getBarcodeRectHeight() {
        return this.iey;
    }

    public void setBarcodeRectHeight(int i) {
        this.iey = i;
    }

    public int getTopOffset() {
        return this.cut;
    }

    public void setTopOffset(int i) {
        this.cut = i;
    }

    public int getScanLineSize() {
        return this.iez;
    }

    public void setScanLineSize(int i) {
        this.iez = i;
    }

    public int getScanLineColor() {
        return this.ieA;
    }

    public void setScanLineColor(int i) {
        this.ieA = i;
    }

    public int getScanLineMargin() {
        return this.ieB;
    }

    public void setScanLineMargin(int i) {
        this.ieB = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ieC = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ieD;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ieD = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ieE;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ieE = bitmap;
    }

    public int getBorderSize() {
        return this.ieF;
    }

    public void setBorderSize(int i) {
        this.ieF = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ieG;
    }

    public void setAnimTime(int i) {
        this.ieG = i;
    }

    public void setCenterVertical(boolean z) {
        this.ieH = z;
    }

    public int getToolbarHeight() {
        return this.ieI;
    }

    public void setToolbarHeight(int i) {
        this.ieI = i;
    }

    public String getQRCodeTipText() {
        return this.ieK;
    }

    public void setQRCodeTipText(String str) {
        this.ieK = str;
    }

    public String getBarCodeTipText() {
        return this.ieL;
    }

    public void setBarCodeTipText(String str) {
        this.ieL = str;
    }

    public String getTipText() {
        return this.gTI;
    }

    public void setTipText(String str) {
        this.gTI = str;
    }

    public int getTipTextColor() {
        return this.ieN;
    }

    public void setTipTextColor(int i) {
        this.ieN = i;
    }

    public int getTipTextSize() {
        return this.ieM;
    }

    public void setTipTextSize(int i) {
        this.ieM = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ieO = z;
    }

    public int getTipTextMargin() {
        return this.ieP;
    }

    public void setTipTextMargin(int i) {
        this.ieP = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ieQ = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ieS = z;
    }

    public int getTipBackgroundColor() {
        return this.ieR;
    }

    public void setTipBackgroundColor(int i) {
        this.ieR = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ieT = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ieU = z;
    }

    public float getHalfCornerSize() {
        return this.ifd;
    }

    public void setHalfCornerSize(float f) {
        this.ifd = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ife;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ife = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iff;
    }

    public void setTipBackgroundRadius(int i) {
        this.iff = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ifg = z;
    }
}
