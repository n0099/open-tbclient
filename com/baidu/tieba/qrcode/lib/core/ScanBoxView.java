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
    private int aGA;
    private int bjt;
    private String fzX;
    private boolean gJA;
    private int gJB;
    private boolean gJC;
    private String gJD;
    private String gJE;
    private int gJF;
    private int gJG;
    private boolean gJH;
    private int gJI;
    private boolean gJJ;
    private int gJK;
    private boolean gJL;
    private boolean gJM;
    private boolean gJN;
    private Drawable gJO;
    private Bitmap gJP;
    private float gJQ;
    private float gJR;
    private Bitmap gJS;
    private Bitmap gJT;
    private Bitmap gJU;
    private Bitmap gJV;
    private float gJW;
    private StaticLayout gJX;
    private int gJY;
    private boolean gJZ;
    private Bitmap gJd;
    private Bitmap gJe;
    private Bitmap gJf;
    private Bitmap gJg;
    private int gJh;
    private int gJi;
    private Rect gJj;
    private float gJk;
    private float gJl;
    private TextPaint gJm;
    private int gJn;
    private int gJo;
    private int gJp;
    private int gJq;
    private int gJr;
    private int gJs;
    private int gJt;
    private int gJu;
    private boolean gJv;
    private Drawable gJw;
    private Bitmap gJx;
    private int gJy;
    private int gJz;
    private ColorMatrixColorFilter gKa;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aGA = Color.parseColor("#33FFFFFF");
        this.gJn = a.f(context, 20.0f);
        this.gJo = a.f(context, 3.0f);
        this.gJs = a.f(context, 1.0f);
        this.gJt = -1;
        this.bjt = a.f(context, 90.0f);
        this.gJp = a.f(context, 200.0f);
        this.gJr = a.f(context, 140.0f);
        this.gJu = 0;
        this.gJv = false;
        this.gJw = null;
        this.gJx = null;
        this.gJy = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.gJz = 1000;
        this.gJA = false;
        this.gJB = 0;
        this.gJC = false;
        this.gJh = a.f(context, 2.0f);
        this.fzX = null;
        this.gJF = a.e(context, 14.0f);
        this.gJG = -1;
        this.gJH = false;
        this.gJI = a.f(context, 20.0f);
        this.gJJ = false;
        this.gJK = Color.parseColor("#22000000");
        this.gJL = false;
        this.gJM = false;
        this.gJN = false;
        this.gJm = new TextPaint();
        this.gJm.setAntiAlias(true);
        this.gJY = a.f(context, 4.0f);
        this.gJZ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.gKa = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        btW();
        btV();
    }

    private void btV() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.gJn;
        options.outHeight = this.gJn;
        this.gJd = BitmapHelper.getResBitmap(this.mContext, e.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.gJe = Bitmap.createBitmap(this.gJd, 0, 0, this.gJd.getWidth(), this.gJd.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.gJf = Bitmap.createBitmap(this.gJd, 0, 0, this.gJd.getWidth(), this.gJd.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.gJg = Bitmap.createBitmap(this.gJd, 0, 0, this.gJd.getWidth(), this.gJd.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == e.l.QRCodeView_qrcv_topOffset) {
            this.bjt = typedArray.getDimensionPixelSize(i, this.bjt);
        } else if (i == e.l.QRCodeView_qrcv_cornerSize) {
            this.gJo = typedArray.getDimensionPixelSize(i, this.gJo);
        } else if (i == e.l.QRCodeView_qrcv_cornerLength) {
            this.gJn = typedArray.getDimensionPixelSize(i, this.gJn);
        } else if (i == e.l.QRCodeView_qrcv_scanLineSize) {
            this.gJs = typedArray.getDimensionPixelSize(i, this.gJs);
        } else if (i == e.l.QRCodeView_qrcv_rectWidth) {
            this.gJp = typedArray.getDimensionPixelSize(i, this.gJp);
        } else if (i == e.l.QRCodeView_qrcv_maskColor) {
            this.aGA = typedArray.getColor(i, this.aGA);
        } else if (i == e.l.QRCodeView_qrcv_scanLineColor) {
            this.gJt = typedArray.getColor(i, this.gJt);
        } else if (i == e.l.QRCodeView_qrcv_scanLineMargin) {
            this.gJu = typedArray.getDimensionPixelSize(i, this.gJu);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.gJv = typedArray.getBoolean(i, this.gJv);
        } else if (i == e.l.QRCodeView_qrcv_customScanLineDrawable) {
            this.gJw = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_borderSize) {
            this.gJy = typedArray.getDimensionPixelSize(i, this.gJy);
        } else if (i == e.l.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == e.l.QRCodeView_qrcv_animTime) {
            this.gJz = typedArray.getInteger(i, this.gJz);
        } else if (i == e.l.QRCodeView_qrcv_isCenterVertical) {
            this.gJA = typedArray.getBoolean(i, this.gJA);
        } else if (i == e.l.QRCodeView_qrcv_toolbarHeight) {
            this.gJB = typedArray.getDimensionPixelSize(i, this.gJB);
        } else if (i == e.l.QRCodeView_qrcv_barcodeRectHeight) {
            this.gJr = typedArray.getDimensionPixelSize(i, this.gJr);
        } else if (i == e.l.QRCodeView_qrcv_isBarcode) {
            this.gJC = typedArray.getBoolean(i, this.gJC);
        } else if (i == e.l.QRCodeView_qrcv_barCodeTipText) {
            this.gJE = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_qrCodeTipText) {
            this.gJD = typedArray.getString(i);
        } else if (i == e.l.QRCodeView_qrcv_tipTextSize) {
            this.gJF = typedArray.getDimensionPixelSize(i, this.gJF);
        } else if (i == e.l.QRCodeView_qrcv_tipTextColor) {
            this.gJG = typedArray.getColor(i, this.gJG);
        } else if (i == e.l.QRCodeView_qrcv_isTipTextBelowRect) {
            this.gJH = typedArray.getBoolean(i, this.gJH);
        } else if (i == e.l.QRCodeView_qrcv_tipTextMargin) {
            this.gJI = typedArray.getDimensionPixelSize(i, this.gJI);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.gJJ = typedArray.getBoolean(i, this.gJJ);
        } else if (i == e.l.QRCodeView_qrcv_isShowTipBackground) {
            this.gJL = typedArray.getBoolean(i, this.gJL);
        } else if (i == e.l.QRCodeView_qrcv_tipBackgroundColor) {
            this.gJK = typedArray.getColor(i, this.gJK);
        } else if (i == e.l.QRCodeView_qrcv_isScanLineReverse) {
            this.gJM = typedArray.getBoolean(i, this.gJM);
        } else if (i == e.l.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.gJN = typedArray.getBoolean(i, this.gJN);
        } else if (i == e.l.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.gJO = typedArray.getDrawable(i);
        } else if (i == e.l.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.gJZ = typedArray.getBoolean(i, this.gJZ);
        }
    }

    private void btW() {
        if (this.gJO != null) {
            this.gJU = ((BitmapDrawable) this.gJO).getBitmap();
        }
        if (this.gJU == null) {
            this.gJU = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gJU = a.c(this.gJU, this.gJt);
        }
        this.gJV = a.adjustPhotoRotation(this.gJU, 90);
        this.gJV = a.adjustPhotoRotation(this.gJV, 90);
        this.gJV = a.adjustPhotoRotation(this.gJV, 90);
        if (this.gJw != null) {
            this.gJS = ((BitmapDrawable) this.gJw).getBitmap();
        }
        if (this.gJS == null) {
            this.gJS = BitmapFactory.decodeResource(getResources(), e.f.pc_scan_line);
            this.gJS = a.c(this.gJS, this.gJt);
        }
        this.gJT = a.adjustPhotoRotation(this.gJS, 90);
        this.gJW = (1.0f * this.gJo) / 2.0f;
        this.gJm.setTextSize(this.gJF);
        this.gJm.setColor(this.gJG);
        setIsBarcode(this.gJC);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.gJj != null) {
            B(canvas);
            C(canvas);
            E(canvas);
            F(canvas);
            D(canvas);
            btX();
        }
    }

    private void B(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.aGA != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.aGA);
            canvas.drawRect(0.0f, 0.0f, width, this.gJj.top, this.mPaint);
            canvas.drawRect(0.0f, this.gJj.top, this.gJj.left, this.gJj.bottom + 1, this.mPaint);
            canvas.drawRect(this.gJj.right + 1, this.gJj.top, width, this.gJj.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.gJj.bottom + 1, width, height, this.mPaint);
        }
    }

    private void C(Canvas canvas) {
        if (this.gJy > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.gJy);
            canvas.drawRect(this.gJj, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.gJd, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gJe, getMainFrameRight() - this.gJd.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.gJf, getMainFrameLeft(), getMainFrameBottom() - this.gJd.getHeight(), this.mPaint);
        canvas.drawBitmap(this.gJg, getMainFrameRight() - this.gJd.getWidth(), getMainFrameBottom() - this.gJd.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.gJj.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.gJj.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.gJj.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.gJj.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.gJy / 2;
    }

    private void E(Canvas canvas) {
        if (this.gJC) {
            if (this.gJP != null) {
                RectF rectF = new RectF(this.gJj.left + this.gJW + 0.5f, this.gJj.top + this.gJW + this.gJu, this.gJR, (this.gJj.bottom - this.gJW) - this.gJu);
                Rect rect = new Rect((int) (this.gJP.getWidth() - rectF.width()), 0, this.gJP.getWidth(), this.gJP.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.gJP, rect, rectF, this.mPaint);
            } else if (this.gJx != null) {
                canvas.drawBitmap(this.gJx, (Rect) null, new RectF(this.gJl, this.gJj.top + this.gJW + this.gJu, this.gJl + this.gJx.getWidth(), (this.gJj.bottom - this.gJW) - this.gJu), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.gJt);
                canvas.drawRect(this.gJl, this.gJu + this.gJj.top + this.gJW, this.gJs + this.gJl, (this.gJj.bottom - this.gJW) - this.gJu, this.mPaint);
            }
        } else if (this.gJP != null) {
            RectF rectF2 = new RectF(this.gJj.left + this.gJW + this.gJu, this.gJj.top + this.gJW + 0.5f, (this.gJj.right - this.gJW) - this.gJu, this.gJQ);
            Rect rect2 = new Rect(0, (int) (this.gJP.getHeight() - rectF2.height()), this.gJP.getWidth(), this.gJP.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.gKa);
            canvas.drawBitmap(this.gJP, rect2, rectF2, this.mPaint);
        } else if (this.gJx != null) {
            canvas.drawBitmap(this.gJx, (Rect) null, new RectF(this.gJj.left + this.gJW + this.gJu, this.gJk, (this.gJj.right - this.gJW) - this.gJu, this.gJk + this.gJx.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.gJt);
            canvas.drawRect(this.gJu + this.gJj.left + this.gJW, this.gJk, (this.gJj.right - this.gJW) - this.gJu, this.gJs + this.gJk, this.mPaint);
        }
    }

    private void F(Canvas canvas) {
        if (!TextUtils.isEmpty(this.fzX) && this.gJX != null) {
            if (this.gJH) {
                if (this.gJL) {
                    this.mPaint.setColor(this.gJK);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.gJJ) {
                        Rect rect = new Rect();
                        this.gJm.getTextBounds(this.fzX, 0, this.fzX.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.gJY;
                        canvas.drawRoundRect(new RectF(width, (this.gJj.bottom + this.gJI) - this.gJY, rect.width() + width + (this.gJY * 2), this.gJj.bottom + this.gJI + this.gJX.getHeight() + this.gJY), this.gJY, this.gJY, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.gJj.left, (this.gJj.bottom + this.gJI) - this.gJY, this.gJj.right, this.gJj.bottom + this.gJI + this.gJX.getHeight() + this.gJY), this.gJY, this.gJY, this.mPaint);
                    }
                }
                canvas.save();
                if (this.gJJ) {
                    canvas.translate(0.0f, this.gJj.bottom + this.gJI);
                } else {
                    canvas.translate(this.gJj.left + this.gJY, this.gJj.bottom + this.gJI);
                }
                this.gJX.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.gJL) {
                this.mPaint.setColor(this.gJK);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.gJJ) {
                    Rect rect2 = new Rect();
                    this.gJm.getTextBounds(this.fzX, 0, this.fzX.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.gJY;
                    canvas.drawRoundRect(new RectF(width2, ((this.gJj.top - this.gJI) - this.gJX.getHeight()) - this.gJY, rect2.width() + width2 + (this.gJY * 2), (this.gJj.top - this.gJI) + this.gJY), this.gJY, this.gJY, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.gJj.left, ((this.gJj.top - this.gJI) - this.gJX.getHeight()) - this.gJY, this.gJj.right, (this.gJj.top - this.gJI) + this.gJY), this.gJY, this.gJY, this.mPaint);
                }
            }
            canvas.save();
            if (this.gJJ) {
                canvas.translate(0.0f, (this.gJj.top - this.gJI) - this.gJX.getHeight());
            } else {
                canvas.translate(this.gJj.left + this.gJY, (this.gJj.top - this.gJI) - this.gJX.getHeight());
            }
            this.gJX.draw(canvas);
            canvas.restore();
        }
    }

    private void btX() {
        if (this.gJC) {
            if (this.gJP == null) {
                this.gJl += this.gJh;
                int i = this.gJs;
                if (this.gJx != null) {
                    i = this.gJx.getWidth();
                }
                if (this.gJM) {
                    if (i + this.gJl > this.gJj.right - this.gJW || this.gJl < this.gJj.left + this.gJW) {
                        this.gJh = -this.gJh;
                    }
                } else {
                    if (i + this.gJl > this.gJj.right - this.gJW) {
                        this.gJl = this.gJj.left + this.gJW + 0.5f;
                    }
                }
            } else {
                this.gJR += this.gJh;
                if (this.gJR > this.gJj.right - this.gJW) {
                    this.gJR = this.gJj.left + this.gJW + 0.5f;
                }
            }
        } else if (this.gJP == null) {
            this.gJk += this.gJh;
            int i2 = this.gJs;
            if (this.gJx != null) {
                i2 = this.gJx.getHeight();
            }
            if (this.gJM) {
                if (i2 + this.gJk > this.gJj.bottom - this.gJW || this.gJk < this.gJj.top + this.gJW) {
                    this.gJh = -this.gJh;
                }
            } else {
                if (i2 + this.gJk > this.gJj.bottom - this.gJW) {
                    this.gJk = this.gJj.top + this.gJW + 0.5f;
                }
            }
        } else {
            this.gJQ += this.gJh;
            if (this.gJQ > this.gJj.bottom - this.gJW) {
                this.gJQ = this.gJj.top + this.gJW + 0.5f;
            }
        }
        postInvalidateDelayed(this.gJi, this.gJj.left, this.gJj.top, this.gJj.right, this.gJj.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        btY();
    }

    private void btY() {
        int i = this.bjt + this.gJB;
        int width = (getWidth() - this.gJp) / 2;
        this.gJj = new Rect(width, i, this.gJp + width, this.gJq + i);
        if (this.gJC) {
            float f = this.gJj.left + this.gJW + 0.5f;
            this.gJl = f;
            this.gJR = f;
            return;
        }
        float f2 = this.gJj.top + this.gJW + 0.5f;
        this.gJk = f2;
        this.gJQ = f2;
    }

    public Rect tH(int i) {
        if (this.gJZ) {
            Rect rect = new Rect(this.gJj);
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
        this.gJC = z;
        if (this.gJO != null || this.gJN) {
            if (this.gJC) {
                this.gJP = this.gJV;
            } else {
                this.gJP = this.gJU;
            }
        } else if (this.gJw != null || this.gJv) {
            if (this.gJC) {
                this.gJx = this.gJT;
            } else {
                this.gJx = this.gJS;
            }
        }
        if (this.gJC) {
            this.fzX = this.gJE;
            this.gJq = this.gJr;
            this.gJi = (int) (((this.gJz * 1.0f) * this.gJh) / this.gJp);
        } else {
            this.fzX = this.gJD;
            this.gJq = this.gJp;
            this.gJi = (int) (((this.gJz * 1.0f) * this.gJh) / this.gJq);
        }
        if (!TextUtils.isEmpty(this.fzX)) {
            if (this.gJJ) {
                this.gJX = new StaticLayout(this.fzX, this.gJm, a.cU(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.gJX = new StaticLayout(this.fzX, this.gJm, this.gJp - (this.gJY * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.gJA) {
            int i = a.cU(getContext()).y;
            if (this.gJB == 0) {
                this.bjt = (i - this.gJq) / 2;
            } else {
                this.bjt = ((i - this.gJq) / 2) + (this.gJB / 2);
            }
        }
        btY();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.gJC;
    }

    public int getMaskColor() {
        return this.aGA;
    }

    public void setMaskColor(int i) {
        this.aGA = i;
    }

    public int getCornerLength() {
        return this.gJn;
    }

    public void setCornerLength(int i) {
        this.gJn = i;
    }

    public int getCornerSize() {
        return this.gJo;
    }

    public void setCornerSize(int i) {
        this.gJo = i;
    }

    public int getRectWidth() {
        return this.gJp;
    }

    public void setRectWidth(int i) {
        this.gJp = i;
    }

    public int getRectHeight() {
        return this.gJq;
    }

    public void setRectHeight(int i) {
        this.gJq = i;
    }

    public int getBarcodeRectHeight() {
        return this.gJr;
    }

    public void setBarcodeRectHeight(int i) {
        this.gJr = i;
    }

    public int getTopOffset() {
        return this.bjt;
    }

    public void setTopOffset(int i) {
        this.bjt = i;
    }

    public int getScanLineSize() {
        return this.gJs;
    }

    public void setScanLineSize(int i) {
        this.gJs = i;
    }

    public int getScanLineColor() {
        return this.gJt;
    }

    public void setScanLineColor(int i) {
        this.gJt = i;
    }

    public int getScanLineMargin() {
        return this.gJu;
    }

    public void setScanLineMargin(int i) {
        this.gJu = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.gJv = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.gJw;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.gJw = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.gJx;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.gJx = bitmap;
    }

    public int getBorderSize() {
        return this.gJy;
    }

    public void setBorderSize(int i) {
        this.gJy = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.gJz;
    }

    public void setAnimTime(int i) {
        this.gJz = i;
    }

    public void setCenterVertical(boolean z) {
        this.gJA = z;
    }

    public int getToolbarHeight() {
        return this.gJB;
    }

    public void setToolbarHeight(int i) {
        this.gJB = i;
    }

    public String getQRCodeTipText() {
        return this.gJD;
    }

    public void setQRCodeTipText(String str) {
        this.gJD = str;
    }

    public String getBarCodeTipText() {
        return this.gJE;
    }

    public void setBarCodeTipText(String str) {
        this.gJE = str;
    }

    public String getTipText() {
        return this.fzX;
    }

    public void setTipText(String str) {
        this.fzX = str;
    }

    public int getTipTextColor() {
        return this.gJG;
    }

    public void setTipTextColor(int i) {
        this.gJG = i;
    }

    public int getTipTextSize() {
        return this.gJF;
    }

    public void setTipTextSize(int i) {
        this.gJF = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.gJH = z;
    }

    public int getTipTextMargin() {
        return this.gJI;
    }

    public void setTipTextMargin(int i) {
        this.gJI = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.gJJ = z;
    }

    public void setShowTipBackground(boolean z) {
        this.gJL = z;
    }

    public int getTipBackgroundColor() {
        return this.gJK;
    }

    public void setTipBackgroundColor(int i) {
        this.gJK = i;
    }

    public void setScanLineReverse(boolean z) {
        this.gJM = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.gJN = z;
    }

    public float getHalfCornerSize() {
        return this.gJW;
    }

    public void setHalfCornerSize(float f) {
        this.gJW = f;
    }

    public StaticLayout getTipTextSl() {
        return this.gJX;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.gJX = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.gJY;
    }

    public void setTipBackgroundRadius(int i) {
        this.gJY = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.gJZ = z;
    }
}
