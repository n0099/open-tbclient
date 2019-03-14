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
    private int bPm;
    private int cuq;
    private String gTV;
    private Bitmap ieA;
    private Bitmap ieB;
    private int ieC;
    private int ieD;
    private Rect ieE;
    private float ieF;
    private float ieG;
    private TextPaint ieH;
    private int ieI;
    private int ieJ;
    private int ieK;
    private int ieL;
    private int ieM;
    private int ieN;
    private int ieO;
    private int ieP;
    private boolean ieQ;
    private Drawable ieR;
    private Bitmap ieS;
    private int ieT;
    private int ieU;
    private boolean ieV;
    private int ieW;
    private boolean ieX;
    private String ieY;
    private String ieZ;
    private Bitmap iey;
    private Bitmap iez;
    private int ifa;
    private int ifb;
    private boolean ifc;
    private int ifd;
    private boolean ife;
    private int iff;
    private boolean ifg;
    private boolean ifh;
    private boolean ifi;
    private Drawable ifj;
    private Bitmap ifk;
    private float ifl;
    private float ifm;
    private Bitmap ifn;
    private Bitmap ifo;
    private Bitmap ifp;
    private Bitmap ifq;
    private float ifr;
    private StaticLayout ifs;
    private int ift;
    private boolean ifu;
    private ColorMatrixColorFilter ifv;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bPm = Color.parseColor("#33FFFFFF");
        this.ieI = a.e(context, 20.0f);
        this.ieJ = a.e(context, 3.0f);
        this.ieN = a.e(context, 1.0f);
        this.ieO = -1;
        this.cuq = a.e(context, 90.0f);
        this.ieK = a.e(context, 200.0f);
        this.ieM = a.e(context, 140.0f);
        this.ieP = 0;
        this.ieQ = false;
        this.ieR = null;
        this.ieS = null;
        this.ieT = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ieU = 1000;
        this.ieV = false;
        this.ieW = 0;
        this.ieX = false;
        this.ieC = a.e(context, 2.0f);
        this.gTV = null;
        this.ifa = a.sp2px(context, 14.0f);
        this.ifb = -1;
        this.ifc = false;
        this.ifd = a.e(context, 20.0f);
        this.ife = false;
        this.iff = Color.parseColor("#22000000");
        this.ifg = false;
        this.ifh = false;
        this.ifi = false;
        this.ieH = new TextPaint();
        this.ieH.setAntiAlias(true);
        this.ift = a.e(context, 4.0f);
        this.ifu = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ifv = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        bWg();
        bWf();
    }

    private void bWf() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ieI;
        options.outHeight = this.ieI;
        this.iey = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iez = Bitmap.createBitmap(this.iey, 0, 0, this.iey.getWidth(), this.iey.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.ieA = Bitmap.createBitmap(this.iey, 0, 0, this.iey.getWidth(), this.iey.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ieB = Bitmap.createBitmap(this.iey, 0, 0, this.iey.getWidth(), this.iey.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.l.QRCodeView_qrcv_topOffset) {
            this.cuq = typedArray.getDimensionPixelSize(i, this.cuq);
        } else if (i == d.l.QRCodeView_qrcv_cornerSize) {
            this.ieJ = typedArray.getDimensionPixelSize(i, this.ieJ);
        } else if (i == d.l.QRCodeView_qrcv_cornerLength) {
            this.ieI = typedArray.getDimensionPixelSize(i, this.ieI);
        } else if (i == d.l.QRCodeView_qrcv_scanLineSize) {
            this.ieN = typedArray.getDimensionPixelSize(i, this.ieN);
        } else if (i == d.l.QRCodeView_qrcv_rectWidth) {
            this.ieK = typedArray.getDimensionPixelSize(i, this.ieK);
        } else if (i == d.l.QRCodeView_qrcv_maskColor) {
            this.bPm = typedArray.getColor(i, this.bPm);
        } else if (i == d.l.QRCodeView_qrcv_scanLineColor) {
            this.ieO = typedArray.getColor(i, this.ieO);
        } else if (i == d.l.QRCodeView_qrcv_scanLineMargin) {
            this.ieP = typedArray.getDimensionPixelSize(i, this.ieP);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.ieQ = typedArray.getBoolean(i, this.ieQ);
        } else if (i == d.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.ieR = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_borderSize) {
            this.ieT = typedArray.getDimensionPixelSize(i, this.ieT);
        } else if (i == d.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.l.QRCodeView_qrcv_animTime) {
            this.ieU = typedArray.getInteger(i, this.ieU);
        } else if (i == d.l.QRCodeView_qrcv_isCenterVertical) {
            this.ieV = typedArray.getBoolean(i, this.ieV);
        } else if (i == d.l.QRCodeView_qrcv_toolbarHeight) {
            this.ieW = typedArray.getDimensionPixelSize(i, this.ieW);
        } else if (i == d.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.ieM = typedArray.getDimensionPixelSize(i, this.ieM);
        } else if (i == d.l.QRCodeView_qrcv_isBarcode) {
            this.ieX = typedArray.getBoolean(i, this.ieX);
        } else if (i == d.l.QRCodeView_qrcv_barCodeTipText) {
            this.ieZ = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_qrCodeTipText) {
            this.ieY = typedArray.getString(i);
        } else if (i == d.l.QRCodeView_qrcv_tipTextSize) {
            this.ifa = typedArray.getDimensionPixelSize(i, this.ifa);
        } else if (i == d.l.QRCodeView_qrcv_tipTextColor) {
            this.ifb = typedArray.getColor(i, this.ifb);
        } else if (i == d.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.ifc = typedArray.getBoolean(i, this.ifc);
        } else if (i == d.l.QRCodeView_qrcv_tipTextMargin) {
            this.ifd = typedArray.getDimensionPixelSize(i, this.ifd);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.ife = typedArray.getBoolean(i, this.ife);
        } else if (i == d.l.QRCodeView_qrcv_isShowTipBackground) {
            this.ifg = typedArray.getBoolean(i, this.ifg);
        } else if (i == d.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.iff = typedArray.getColor(i, this.iff);
        } else if (i == d.l.QRCodeView_qrcv_isScanLineReverse) {
            this.ifh = typedArray.getBoolean(i, this.ifh);
        } else if (i == d.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.ifi = typedArray.getBoolean(i, this.ifi);
        } else if (i == d.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.ifj = typedArray.getDrawable(i);
        } else if (i == d.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.ifu = typedArray.getBoolean(i, this.ifu);
        }
    }

    private void bWg() {
        if (this.ifj != null) {
            this.ifp = ((BitmapDrawable) this.ifj).getBitmap();
        }
        if (this.ifp == null) {
            this.ifp = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ifp = a.d(this.ifp, this.ieO);
        }
        this.ifq = a.adjustPhotoRotation(this.ifp, 90);
        this.ifq = a.adjustPhotoRotation(this.ifq, 90);
        this.ifq = a.adjustPhotoRotation(this.ifq, 90);
        if (this.ieR != null) {
            this.ifn = ((BitmapDrawable) this.ieR).getBitmap();
        }
        if (this.ifn == null) {
            this.ifn = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.ifn = a.d(this.ifn, this.ieO);
        }
        this.ifo = a.adjustPhotoRotation(this.ifn, 90);
        this.ifr = (1.0f * this.ieJ) / 2.0f;
        this.ieH.setTextSize(this.ifa);
        this.ieH.setColor(this.ifb);
        setIsBarcode(this.ieX);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ieE != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            bWh();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bPm != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bPm);
            canvas.drawRect(0.0f, 0.0f, width, this.ieE.top, this.mPaint);
            canvas.drawRect(0.0f, this.ieE.top, this.ieE.left, this.ieE.bottom + 1, this.mPaint);
            canvas.drawRect(this.ieE.right + 1, this.ieE.top, width, this.ieE.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ieE.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.ieT > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ieT);
            canvas.drawRect(this.ieE, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iey, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iez, getMainFrameRight() - this.iey.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ieA, getMainFrameLeft(), getMainFrameBottom() - this.iey.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ieB, getMainFrameRight() - this.iey.getWidth(), getMainFrameBottom() - this.iey.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ieE.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ieE.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ieE.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ieE.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ieT / 2;
    }

    private void W(Canvas canvas) {
        if (this.ieX) {
            if (this.ifk != null) {
                RectF rectF = new RectF(this.ieE.left + this.ifr + 0.5f, this.ieE.top + this.ifr + this.ieP, this.ifm, (this.ieE.bottom - this.ifr) - this.ieP);
                Rect rect = new Rect((int) (this.ifk.getWidth() - rectF.width()), 0, this.ifk.getWidth(), this.ifk.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ifk, rect, rectF, this.mPaint);
            } else if (this.ieS != null) {
                canvas.drawBitmap(this.ieS, (Rect) null, new RectF(this.ieG, this.ieE.top + this.ifr + this.ieP, this.ieG + this.ieS.getWidth(), (this.ieE.bottom - this.ifr) - this.ieP), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ieO);
                canvas.drawRect(this.ieG, this.ieP + this.ieE.top + this.ifr, this.ieN + this.ieG, (this.ieE.bottom - this.ifr) - this.ieP, this.mPaint);
            }
        } else if (this.ifk != null) {
            RectF rectF2 = new RectF(this.ieE.left + this.ifr + this.ieP, this.ieE.top + this.ifr + 0.5f, (this.ieE.right - this.ifr) - this.ieP, this.ifl);
            Rect rect2 = new Rect(0, (int) (this.ifk.getHeight() - rectF2.height()), this.ifk.getWidth(), this.ifk.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ifv);
            canvas.drawBitmap(this.ifk, rect2, rectF2, this.mPaint);
        } else if (this.ieS != null) {
            canvas.drawBitmap(this.ieS, (Rect) null, new RectF(this.ieE.left + this.ifr + this.ieP, this.ieF, (this.ieE.right - this.ifr) - this.ieP, this.ieF + this.ieS.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ieO);
            canvas.drawRect(this.ieP + this.ieE.left + this.ifr, this.ieF, (this.ieE.right - this.ifr) - this.ieP, this.ieN + this.ieF, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.gTV) && this.ifs != null) {
            if (this.ifc) {
                if (this.ifg) {
                    this.mPaint.setColor(this.iff);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ife) {
                        Rect rect = new Rect();
                        this.ieH.getTextBounds(this.gTV, 0, this.gTV.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ift;
                        canvas.drawRoundRect(new RectF(width, (this.ieE.bottom + this.ifd) - this.ift, rect.width() + width + (this.ift * 2), this.ieE.bottom + this.ifd + this.ifs.getHeight() + this.ift), this.ift, this.ift, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ieE.left, (this.ieE.bottom + this.ifd) - this.ift, this.ieE.right, this.ieE.bottom + this.ifd + this.ifs.getHeight() + this.ift), this.ift, this.ift, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ife) {
                    canvas.translate(0.0f, this.ieE.bottom + this.ifd);
                } else {
                    canvas.translate(this.ieE.left + this.ift, this.ieE.bottom + this.ifd);
                }
                this.ifs.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ifg) {
                this.mPaint.setColor(this.iff);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ife) {
                    Rect rect2 = new Rect();
                    this.ieH.getTextBounds(this.gTV, 0, this.gTV.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ift;
                    canvas.drawRoundRect(new RectF(width2, ((this.ieE.top - this.ifd) - this.ifs.getHeight()) - this.ift, rect2.width() + width2 + (this.ift * 2), (this.ieE.top - this.ifd) + this.ift), this.ift, this.ift, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ieE.left, ((this.ieE.top - this.ifd) - this.ifs.getHeight()) - this.ift, this.ieE.right, (this.ieE.top - this.ifd) + this.ift), this.ift, this.ift, this.mPaint);
                }
            }
            canvas.save();
            if (this.ife) {
                canvas.translate(0.0f, (this.ieE.top - this.ifd) - this.ifs.getHeight());
            } else {
                canvas.translate(this.ieE.left + this.ift, (this.ieE.top - this.ifd) - this.ifs.getHeight());
            }
            this.ifs.draw(canvas);
            canvas.restore();
        }
    }

    private void bWh() {
        if (this.ieX) {
            if (this.ifk == null) {
                this.ieG += this.ieC;
                int i = this.ieN;
                if (this.ieS != null) {
                    i = this.ieS.getWidth();
                }
                if (this.ifh) {
                    if (i + this.ieG > this.ieE.right - this.ifr || this.ieG < this.ieE.left + this.ifr) {
                        this.ieC = -this.ieC;
                    }
                } else {
                    if (i + this.ieG > this.ieE.right - this.ifr) {
                        this.ieG = this.ieE.left + this.ifr + 0.5f;
                    }
                }
            } else {
                this.ifm += this.ieC;
                if (this.ifm > this.ieE.right - this.ifr) {
                    this.ifm = this.ieE.left + this.ifr + 0.5f;
                }
            }
        } else if (this.ifk == null) {
            this.ieF += this.ieC;
            int i2 = this.ieN;
            if (this.ieS != null) {
                i2 = this.ieS.getHeight();
            }
            if (this.ifh) {
                if (i2 + this.ieF > this.ieE.bottom - this.ifr || this.ieF < this.ieE.top + this.ifr) {
                    this.ieC = -this.ieC;
                }
            } else {
                if (i2 + this.ieF > this.ieE.bottom - this.ifr) {
                    this.ieF = this.ieE.top + this.ifr + 0.5f;
                }
            }
        } else {
            this.ifl += this.ieC;
            if (this.ifl > this.ieE.bottom - this.ifr) {
                this.ifl = this.ieE.top + this.ifr + 0.5f;
            }
        }
        postInvalidateDelayed(this.ieD, this.ieE.left, this.ieE.top, this.ieE.right, this.ieE.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bWi();
    }

    private void bWi() {
        int i = this.cuq + this.ieW;
        int width = (getWidth() - this.ieK) / 2;
        this.ieE = new Rect(width, i, this.ieK + width, this.ieL + i);
        if (this.ieX) {
            float f = this.ieE.left + this.ifr + 0.5f;
            this.ieG = f;
            this.ifm = f;
            return;
        }
        float f2 = this.ieE.top + this.ifr + 0.5f;
        this.ieF = f2;
        this.ifl = f2;
    }

    public Rect xL(int i) {
        if (this.ifu) {
            Rect rect = new Rect(this.ieE);
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
        this.ieX = z;
        if (this.ifj != null || this.ifi) {
            if (this.ieX) {
                this.ifk = this.ifq;
            } else {
                this.ifk = this.ifp;
            }
        } else if (this.ieR != null || this.ieQ) {
            if (this.ieX) {
                this.ieS = this.ifo;
            } else {
                this.ieS = this.ifn;
            }
        }
        if (this.ieX) {
            this.gTV = this.ieZ;
            this.ieL = this.ieM;
            this.ieD = (int) (((this.ieU * 1.0f) * this.ieC) / this.ieK);
        } else {
            this.gTV = this.ieY;
            this.ieL = this.ieK;
            this.ieD = (int) (((this.ieU * 1.0f) * this.ieC) / this.ieL);
        }
        if (!TextUtils.isEmpty(this.gTV)) {
            if (this.ife) {
                this.ifs = new StaticLayout(this.gTV, this.ieH, a.ep(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ifs = new StaticLayout(this.gTV, this.ieH, this.ieK - (this.ift * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ieV) {
            int i = a.ep(getContext()).y;
            if (this.ieW == 0) {
                this.cuq = (i - this.ieL) / 2;
            } else {
                this.cuq = ((i - this.ieL) / 2) + (this.ieW / 2);
            }
        }
        bWi();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ieX;
    }

    public int getMaskColor() {
        return this.bPm;
    }

    public void setMaskColor(int i) {
        this.bPm = i;
    }

    public int getCornerLength() {
        return this.ieI;
    }

    public void setCornerLength(int i) {
        this.ieI = i;
    }

    public int getCornerSize() {
        return this.ieJ;
    }

    public void setCornerSize(int i) {
        this.ieJ = i;
    }

    public int getRectWidth() {
        return this.ieK;
    }

    public void setRectWidth(int i) {
        this.ieK = i;
    }

    public int getRectHeight() {
        return this.ieL;
    }

    public void setRectHeight(int i) {
        this.ieL = i;
    }

    public int getBarcodeRectHeight() {
        return this.ieM;
    }

    public void setBarcodeRectHeight(int i) {
        this.ieM = i;
    }

    public int getTopOffset() {
        return this.cuq;
    }

    public void setTopOffset(int i) {
        this.cuq = i;
    }

    public int getScanLineSize() {
        return this.ieN;
    }

    public void setScanLineSize(int i) {
        this.ieN = i;
    }

    public int getScanLineColor() {
        return this.ieO;
    }

    public void setScanLineColor(int i) {
        this.ieO = i;
    }

    public int getScanLineMargin() {
        return this.ieP;
    }

    public void setScanLineMargin(int i) {
        this.ieP = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ieQ = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ieR;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ieR = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ieS;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ieS = bitmap;
    }

    public int getBorderSize() {
        return this.ieT;
    }

    public void setBorderSize(int i) {
        this.ieT = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ieU;
    }

    public void setAnimTime(int i) {
        this.ieU = i;
    }

    public void setCenterVertical(boolean z) {
        this.ieV = z;
    }

    public int getToolbarHeight() {
        return this.ieW;
    }

    public void setToolbarHeight(int i) {
        this.ieW = i;
    }

    public String getQRCodeTipText() {
        return this.ieY;
    }

    public void setQRCodeTipText(String str) {
        this.ieY = str;
    }

    public String getBarCodeTipText() {
        return this.ieZ;
    }

    public void setBarCodeTipText(String str) {
        this.ieZ = str;
    }

    public String getTipText() {
        return this.gTV;
    }

    public void setTipText(String str) {
        this.gTV = str;
    }

    public int getTipTextColor() {
        return this.ifb;
    }

    public void setTipTextColor(int i) {
        this.ifb = i;
    }

    public int getTipTextSize() {
        return this.ifa;
    }

    public void setTipTextSize(int i) {
        this.ifa = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ifc = z;
    }

    public int getTipTextMargin() {
        return this.ifd;
    }

    public void setTipTextMargin(int i) {
        this.ifd = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ife = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ifg = z;
    }

    public int getTipBackgroundColor() {
        return this.iff;
    }

    public void setTipBackgroundColor(int i) {
        this.iff = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ifh = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ifi = z;
    }

    public float getHalfCornerSize() {
        return this.ifr;
    }

    public void setHalfCornerSize(float f) {
        this.ifr = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ifs;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ifs = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ift;
    }

    public void setTipBackgroundRadius(int i) {
        this.ift = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ifu = z;
    }
}
