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
    private int aOq;
    private int alS;
    private String eNv;
    private int fVA;
    private int fVB;
    private int fVC;
    private int fVD;
    private int fVE;
    private int fVF;
    private int fVG;
    private int fVH;
    private boolean fVI;
    private Drawable fVJ;
    private Bitmap fVK;
    private int fVL;
    private int fVM;
    private boolean fVN;
    private int fVO;
    private boolean fVP;
    private String fVQ;
    private String fVR;
    private int fVS;
    private int fVT;
    private boolean fVU;
    private int fVV;
    private boolean fVW;
    private int fVX;
    private boolean fVY;
    private boolean fVZ;
    private Bitmap fVq;
    private Bitmap fVr;
    private Bitmap fVs;
    private Bitmap fVt;
    private int fVu;
    private int fVv;
    private Rect fVw;
    private float fVx;
    private float fVy;
    private TextPaint fVz;
    private boolean fWa;
    private Drawable fWb;
    private Bitmap fWc;
    private float fWd;
    private float fWe;
    private Bitmap fWf;
    private Bitmap fWg;
    private Bitmap fWh;
    private Bitmap fWi;
    private float fWj;
    private StaticLayout fWk;
    private int fWl;
    private boolean fWm;
    private ColorMatrixColorFilter fWn;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.alS = Color.parseColor("#33FFFFFF");
        this.fVA = a.f(context, 20.0f);
        this.fVB = a.f(context, 3.0f);
        this.fVF = a.f(context, 1.0f);
        this.fVG = -1;
        this.aOq = a.f(context, 90.0f);
        this.fVC = a.f(context, 200.0f);
        this.fVE = a.f(context, 140.0f);
        this.fVH = 0;
        this.fVI = false;
        this.fVJ = null;
        this.fVK = null;
        this.fVL = a.f(context, 1.0f);
        this.mBorderColor = -1;
        this.fVM = 1000;
        this.fVN = false;
        this.fVO = 0;
        this.fVP = false;
        this.fVu = a.f(context, 2.0f);
        this.eNv = null;
        this.fVS = a.e(context, 14.0f);
        this.fVT = -1;
        this.fVU = false;
        this.fVV = a.f(context, 20.0f);
        this.fVW = false;
        this.fVX = Color.parseColor("#22000000");
        this.fVY = false;
        this.fVZ = false;
        this.fWa = false;
        this.fVz = new TextPaint();
        this.fVz.setAntiAlias(true);
        this.fWl = a.f(context, 4.0f);
        this.fWm = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.fWn = new ColorMatrixColorFilter(colorMatrix2);
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
        options.outWidth = this.fVA;
        options.outHeight = this.fVA;
        this.fVq = BitmapHelper.getResBitmap(this.mContext, d.f.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.fVr = Bitmap.createBitmap(this.fVq, 0, 0, this.fVq.getWidth(), this.fVq.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.fVs = Bitmap.createBitmap(this.fVq, 0, 0, this.fVq.getWidth(), this.fVq.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.fVt = Bitmap.createBitmap(this.fVq, 0, 0, this.fVq.getWidth(), this.fVq.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == d.m.QRCodeView_qrcv_topOffset) {
            this.aOq = typedArray.getDimensionPixelSize(i, this.aOq);
        } else if (i == d.m.QRCodeView_qrcv_cornerSize) {
            this.fVB = typedArray.getDimensionPixelSize(i, this.fVB);
        } else if (i == d.m.QRCodeView_qrcv_cornerLength) {
            this.fVA = typedArray.getDimensionPixelSize(i, this.fVA);
        } else if (i == d.m.QRCodeView_qrcv_scanLineSize) {
            this.fVF = typedArray.getDimensionPixelSize(i, this.fVF);
        } else if (i == d.m.QRCodeView_qrcv_rectWidth) {
            this.fVC = typedArray.getDimensionPixelSize(i, this.fVC);
        } else if (i == d.m.QRCodeView_qrcv_maskColor) {
            this.alS = typedArray.getColor(i, this.alS);
        } else if (i == d.m.QRCodeView_qrcv_scanLineColor) {
            this.fVG = typedArray.getColor(i, this.fVG);
        } else if (i == d.m.QRCodeView_qrcv_scanLineMargin) {
            this.fVH = typedArray.getDimensionPixelSize(i, this.fVH);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.fVI = typedArray.getBoolean(i, this.fVI);
        } else if (i == d.m.QRCodeView_qrcv_customScanLineDrawable) {
            this.fVJ = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_borderSize) {
            this.fVL = typedArray.getDimensionPixelSize(i, this.fVL);
        } else if (i == d.m.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == d.m.QRCodeView_qrcv_animTime) {
            this.fVM = typedArray.getInteger(i, this.fVM);
        } else if (i == d.m.QRCodeView_qrcv_isCenterVertical) {
            this.fVN = typedArray.getBoolean(i, this.fVN);
        } else if (i == d.m.QRCodeView_qrcv_toolbarHeight) {
            this.fVO = typedArray.getDimensionPixelSize(i, this.fVO);
        } else if (i == d.m.QRCodeView_qrcv_barcodeRectHeight) {
            this.fVE = typedArray.getDimensionPixelSize(i, this.fVE);
        } else if (i == d.m.QRCodeView_qrcv_isBarcode) {
            this.fVP = typedArray.getBoolean(i, this.fVP);
        } else if (i == d.m.QRCodeView_qrcv_barCodeTipText) {
            this.fVR = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_qrCodeTipText) {
            this.fVQ = typedArray.getString(i);
        } else if (i == d.m.QRCodeView_qrcv_tipTextSize) {
            this.fVS = typedArray.getDimensionPixelSize(i, this.fVS);
        } else if (i == d.m.QRCodeView_qrcv_tipTextColor) {
            this.fVT = typedArray.getColor(i, this.fVT);
        } else if (i == d.m.QRCodeView_qrcv_isTipTextBelowRect) {
            this.fVU = typedArray.getBoolean(i, this.fVU);
        } else if (i == d.m.QRCodeView_qrcv_tipTextMargin) {
            this.fVV = typedArray.getDimensionPixelSize(i, this.fVV);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.fVW = typedArray.getBoolean(i, this.fVW);
        } else if (i == d.m.QRCodeView_qrcv_isShowTipBackground) {
            this.fVY = typedArray.getBoolean(i, this.fVY);
        } else if (i == d.m.QRCodeView_qrcv_tipBackgroundColor) {
            this.fVX = typedArray.getColor(i, this.fVX);
        } else if (i == d.m.QRCodeView_qrcv_isScanLineReverse) {
            this.fVZ = typedArray.getBoolean(i, this.fVZ);
        } else if (i == d.m.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.fWa = typedArray.getBoolean(i, this.fWa);
        } else if (i == d.m.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.fWb = typedArray.getDrawable(i);
        } else if (i == d.m.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.fWm = typedArray.getBoolean(i, this.fWm);
        }
    }

    private void biE() {
        if (this.fWb != null) {
            this.fWh = ((BitmapDrawable) this.fWb).getBitmap();
        }
        if (this.fWh == null) {
            this.fWh = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fWh = a.d(this.fWh, this.fVG);
        }
        this.fWi = a.c(this.fWh, 90);
        this.fWi = a.c(this.fWi, 90);
        this.fWi = a.c(this.fWi, 90);
        if (this.fVJ != null) {
            this.fWf = ((BitmapDrawable) this.fVJ).getBitmap();
        }
        if (this.fWf == null) {
            this.fWf = BitmapFactory.decodeResource(getResources(), d.f.pc_scan_line);
            this.fWf = a.d(this.fWf, this.fVG);
        }
        this.fWg = a.c(this.fWf, 90);
        this.fWj = (1.0f * this.fVB) / 2.0f;
        this.fVz.setTextSize(this.fVS);
        this.fVz.setColor(this.fVT);
        setIsBarcode(this.fVP);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.fVw != null) {
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
            canvas.drawRect(0.0f, 0.0f, width, this.fVw.top, this.mPaint);
            canvas.drawRect(0.0f, this.fVw.top, this.fVw.left, this.fVw.bottom + 1, this.mPaint);
            canvas.drawRect(this.fVw.right + 1, this.fVw.top, width, this.fVw.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.fVw.bottom + 1, width, height, this.mPaint);
        }
    }

    private void A(Canvas canvas) {
        if (this.fVL > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.fVL);
            canvas.drawRect(this.fVw, this.mPaint);
        }
    }

    private void B(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.fVq, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fVr, getMainFrameRight() - this.fVq.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.fVs, getMainFrameLeft(), getMainFrameBottom() - this.fVq.getHeight(), this.mPaint);
        canvas.drawBitmap(this.fVt, getMainFrameRight() - this.fVq.getWidth(), getMainFrameBottom() - this.fVq.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.fVw.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.fVw.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.fVw.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.fVw.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.fVL / 2;
    }

    private void C(Canvas canvas) {
        if (this.fVP) {
            if (this.fWc != null) {
                RectF rectF = new RectF(this.fVw.left + this.fWj + 0.5f, this.fVw.top + this.fWj + this.fVH, this.fWe, (this.fVw.bottom - this.fWj) - this.fVH);
                Rect rect = new Rect((int) (this.fWc.getWidth() - rectF.width()), 0, this.fWc.getWidth(), this.fWc.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.fWc, rect, rectF, this.mPaint);
            } else if (this.fVK != null) {
                canvas.drawBitmap(this.fVK, (Rect) null, new RectF(this.fVy, this.fVw.top + this.fWj + this.fVH, this.fVy + this.fVK.getWidth(), (this.fVw.bottom - this.fWj) - this.fVH), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.fVG);
                canvas.drawRect(this.fVy, this.fVH + this.fVw.top + this.fWj, this.fVF + this.fVy, (this.fVw.bottom - this.fWj) - this.fVH, this.mPaint);
            }
        } else if (this.fWc != null) {
            RectF rectF2 = new RectF(this.fVw.left + this.fWj + this.fVH, this.fVw.top + this.fWj + 0.5f, (this.fVw.right - this.fWj) - this.fVH, this.fWd);
            Rect rect2 = new Rect(0, (int) (this.fWc.getHeight() - rectF2.height()), this.fWc.getWidth(), this.fWc.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.fWn);
            canvas.drawBitmap(this.fWc, rect2, rectF2, this.mPaint);
        } else if (this.fVK != null) {
            canvas.drawBitmap(this.fVK, (Rect) null, new RectF(this.fVw.left + this.fWj + this.fVH, this.fVx, (this.fVw.right - this.fWj) - this.fVH, this.fVx + this.fVK.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.fVG);
            canvas.drawRect(this.fVH + this.fVw.left + this.fWj, this.fVx, (this.fVw.right - this.fWj) - this.fVH, this.fVF + this.fVx, this.mPaint);
        }
    }

    private void D(Canvas canvas) {
        if (!TextUtils.isEmpty(this.eNv) && this.fWk != null) {
            if (this.fVU) {
                if (this.fVY) {
                    this.mPaint.setColor(this.fVX);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.fVW) {
                        Rect rect = new Rect();
                        this.fVz.getTextBounds(this.eNv, 0, this.eNv.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.fWl;
                        canvas.drawRoundRect(new RectF(width, (this.fVw.bottom + this.fVV) - this.fWl, rect.width() + width + (this.fWl * 2), this.fVw.bottom + this.fVV + this.fWk.getHeight() + this.fWl), this.fWl, this.fWl, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.fVw.left, (this.fVw.bottom + this.fVV) - this.fWl, this.fVw.right, this.fVw.bottom + this.fVV + this.fWk.getHeight() + this.fWl), this.fWl, this.fWl, this.mPaint);
                    }
                }
                canvas.save();
                if (this.fVW) {
                    canvas.translate(0.0f, this.fVw.bottom + this.fVV);
                } else {
                    canvas.translate(this.fVw.left + this.fWl, this.fVw.bottom + this.fVV);
                }
                this.fWk.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.fVY) {
                this.mPaint.setColor(this.fVX);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.fVW) {
                    Rect rect2 = new Rect();
                    this.fVz.getTextBounds(this.eNv, 0, this.eNv.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.fWl;
                    canvas.drawRoundRect(new RectF(width2, ((this.fVw.top - this.fVV) - this.fWk.getHeight()) - this.fWl, rect2.width() + width2 + (this.fWl * 2), (this.fVw.top - this.fVV) + this.fWl), this.fWl, this.fWl, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.fVw.left, ((this.fVw.top - this.fVV) - this.fWk.getHeight()) - this.fWl, this.fVw.right, (this.fVw.top - this.fVV) + this.fWl), this.fWl, this.fWl, this.mPaint);
                }
            }
            canvas.save();
            if (this.fVW) {
                canvas.translate(0.0f, (this.fVw.top - this.fVV) - this.fWk.getHeight());
            } else {
                canvas.translate(this.fVw.left + this.fWl, (this.fVw.top - this.fVV) - this.fWk.getHeight());
            }
            this.fWk.draw(canvas);
            canvas.restore();
        }
    }

    private void biF() {
        if (this.fVP) {
            if (this.fWc == null) {
                this.fVy += this.fVu;
                int i = this.fVF;
                if (this.fVK != null) {
                    i = this.fVK.getWidth();
                }
                if (this.fVZ) {
                    if (i + this.fVy > this.fVw.right - this.fWj || this.fVy < this.fVw.left + this.fWj) {
                        this.fVu = -this.fVu;
                    }
                } else {
                    if (i + this.fVy > this.fVw.right - this.fWj) {
                        this.fVy = this.fVw.left + this.fWj + 0.5f;
                    }
                }
            } else {
                this.fWe += this.fVu;
                if (this.fWe > this.fVw.right - this.fWj) {
                    this.fWe = this.fVw.left + this.fWj + 0.5f;
                }
            }
        } else if (this.fWc == null) {
            this.fVx += this.fVu;
            int i2 = this.fVF;
            if (this.fVK != null) {
                i2 = this.fVK.getHeight();
            }
            if (this.fVZ) {
                if (i2 + this.fVx > this.fVw.bottom - this.fWj || this.fVx < this.fVw.top + this.fWj) {
                    this.fVu = -this.fVu;
                }
            } else {
                if (i2 + this.fVx > this.fVw.bottom - this.fWj) {
                    this.fVx = this.fVw.top + this.fWj + 0.5f;
                }
            }
        } else {
            this.fWd += this.fVu;
            if (this.fWd > this.fVw.bottom - this.fWj) {
                this.fWd = this.fVw.top + this.fWj + 0.5f;
            }
        }
        postInvalidateDelayed(this.fVv, this.fVw.left, this.fVw.top, this.fVw.right, this.fVw.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        biG();
    }

    private void biG() {
        int i = this.aOq + this.fVO;
        int width = (getWidth() - this.fVC) / 2;
        this.fVw = new Rect(width, i, this.fVC + width, this.fVD + i);
        if (this.fVP) {
            float f = this.fVw.left + this.fWj + 0.5f;
            this.fVy = f;
            this.fWe = f;
            return;
        }
        float f2 = this.fVw.top + this.fWj + 0.5f;
        this.fVx = f2;
        this.fWd = f2;
    }

    public Rect rI(int i) {
        if (this.fWm) {
            Rect rect = new Rect(this.fVw);
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
        this.fVP = z;
        if (this.fWb != null || this.fWa) {
            if (this.fVP) {
                this.fWc = this.fWi;
            } else {
                this.fWc = this.fWh;
            }
        } else if (this.fVJ != null || this.fVI) {
            if (this.fVP) {
                this.fVK = this.fWg;
            } else {
                this.fVK = this.fWf;
            }
        }
        if (this.fVP) {
            this.eNv = this.fVR;
            this.fVD = this.fVE;
            this.fVv = (int) (((this.fVM * 1.0f) * this.fVu) / this.fVC);
        } else {
            this.eNv = this.fVQ;
            this.fVD = this.fVC;
            this.fVv = (int) (((this.fVM * 1.0f) * this.fVu) / this.fVD);
        }
        if (!TextUtils.isEmpty(this.eNv)) {
            if (this.fVW) {
                this.fWk = new StaticLayout(this.eNv, this.fVz, a.bR(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.fWk = new StaticLayout(this.eNv, this.fVz, this.fVC - (this.fWl * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.fVN) {
            int i = a.bR(getContext()).y;
            if (this.fVO == 0) {
                this.aOq = (i - this.fVD) / 2;
            } else {
                this.aOq = ((i - this.fVD) / 2) + (this.fVO / 2);
            }
        }
        biG();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.fVP;
    }

    public int getMaskColor() {
        return this.alS;
    }

    public void setMaskColor(int i) {
        this.alS = i;
    }

    public int getCornerLength() {
        return this.fVA;
    }

    public void setCornerLength(int i) {
        this.fVA = i;
    }

    public int getCornerSize() {
        return this.fVB;
    }

    public void setCornerSize(int i) {
        this.fVB = i;
    }

    public int getRectWidth() {
        return this.fVC;
    }

    public void setRectWidth(int i) {
        this.fVC = i;
    }

    public int getRectHeight() {
        return this.fVD;
    }

    public void setRectHeight(int i) {
        this.fVD = i;
    }

    public int getBarcodeRectHeight() {
        return this.fVE;
    }

    public void setBarcodeRectHeight(int i) {
        this.fVE = i;
    }

    public int getTopOffset() {
        return this.aOq;
    }

    public void setTopOffset(int i) {
        this.aOq = i;
    }

    public int getScanLineSize() {
        return this.fVF;
    }

    public void setScanLineSize(int i) {
        this.fVF = i;
    }

    public int getScanLineColor() {
        return this.fVG;
    }

    public void setScanLineColor(int i) {
        this.fVG = i;
    }

    public int getScanLineMargin() {
        return this.fVH;
    }

    public void setScanLineMargin(int i) {
        this.fVH = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.fVI = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.fVJ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.fVJ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.fVK;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.fVK = bitmap;
    }

    public int getBorderSize() {
        return this.fVL;
    }

    public void setBorderSize(int i) {
        this.fVL = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.fVM;
    }

    public void setAnimTime(int i) {
        this.fVM = i;
    }

    public void setCenterVertical(boolean z) {
        this.fVN = z;
    }

    public int getToolbarHeight() {
        return this.fVO;
    }

    public void setToolbarHeight(int i) {
        this.fVO = i;
    }

    public String getQRCodeTipText() {
        return this.fVQ;
    }

    public void setQRCodeTipText(String str) {
        this.fVQ = str;
    }

    public String getBarCodeTipText() {
        return this.fVR;
    }

    public void setBarCodeTipText(String str) {
        this.fVR = str;
    }

    public String getTipText() {
        return this.eNv;
    }

    public void setTipText(String str) {
        this.eNv = str;
    }

    public int getTipTextColor() {
        return this.fVT;
    }

    public void setTipTextColor(int i) {
        this.fVT = i;
    }

    public int getTipTextSize() {
        return this.fVS;
    }

    public void setTipTextSize(int i) {
        this.fVS = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.fVU = z;
    }

    public int getTipTextMargin() {
        return this.fVV;
    }

    public void setTipTextMargin(int i) {
        this.fVV = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.fVW = z;
    }

    public void setShowTipBackground(boolean z) {
        this.fVY = z;
    }

    public int getTipBackgroundColor() {
        return this.fVX;
    }

    public void setTipBackgroundColor(int i) {
        this.fVX = i;
    }

    public void setScanLineReverse(boolean z) {
        this.fVZ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.fWa = z;
    }

    public float getHalfCornerSize() {
        return this.fWj;
    }

    public void setHalfCornerSize(float f) {
        this.fWj = f;
    }

    public StaticLayout getTipTextSl() {
        return this.fWk;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.fWk = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.fWl;
    }

    public void setTipBackgroundRadius(int i) {
        this.fWl = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.fWm = z;
    }
}
