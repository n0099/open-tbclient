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
/* loaded from: classes23.dex */
public class ScanBoxView extends View {
    private int cnI;
    private String kNj;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;
    private TextPaint mkA;
    private int mkB;
    private int mkC;
    private int mkD;
    private int mkE;
    private int mkF;
    private int mkG;
    private int mkH;
    private boolean mkI;
    private Drawable mkJ;
    private Bitmap mkK;
    private int mkL;
    private int mkM;
    private boolean mkN;
    private int mkO;
    private boolean mkP;
    private String mkQ;
    private String mkR;
    private int mkS;
    private int mkT;
    private boolean mkU;
    private int mkV;
    private boolean mkW;
    private int mkX;
    private boolean mkY;
    private boolean mkZ;
    private Bitmap mkr;
    private Bitmap mks;
    private Bitmap mkt;
    private Bitmap mku;
    private int mkv;
    private int mkw;
    private Rect mkx;
    private float mky;
    private float mkz;
    private boolean mla;
    private Drawable mlb;
    private Bitmap mlc;
    private float mld;
    private float mle;
    private Bitmap mlf;
    private Bitmap mlg;
    private Bitmap mlh;
    private Bitmap mli;
    private float mlj;
    private StaticLayout mlk;
    private int mll;
    private boolean mlm;
    private ColorMatrixColorFilter mln;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.mkB = a.dp2px(context, 20.0f);
        this.mkC = a.dp2px(context, 3.0f);
        this.mkF = a.dp2px(context, 1.0f);
        this.mkG = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.cnI = a.dp2px(context, 200.0f);
        this.mkE = a.dp2px(context, 140.0f);
        this.mkH = 0;
        this.mkI = false;
        this.mkJ = null;
        this.mkK = null;
        this.mkL = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.mkM = 1000;
        this.mkN = false;
        this.mkO = 0;
        this.mkP = false;
        this.mkv = a.dp2px(context, 2.0f);
        this.kNj = null;
        this.mkS = a.h(context, 14.0f);
        this.mkT = -1;
        this.mkU = false;
        this.mkV = a.dp2px(context, 20.0f);
        this.mkW = false;
        this.mkX = Color.parseColor("#22000000");
        this.mkY = false;
        this.mkZ = false;
        this.mla = false;
        this.mkA = new TextPaint();
        this.mkA.setAntiAlias(true);
        this.mll = a.dp2px(context, 4.0f);
        this.mlm = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.mln = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        dxb();
        dxa();
    }

    private void dxa() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.mkB;
        options.outHeight = this.mkB;
        this.mkr = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.mks = Bitmap.createBitmap(this.mkr, 0, 0, this.mkr.getWidth(), this.mkr.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.mkt = Bitmap.createBitmap(this.mkr, 0, 0, this.mkr.getWidth(), this.mkr.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.mku = Bitmap.createBitmap(this.mkr, 0, 0, this.mkr.getWidth(), this.mkr.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == R.styleable.QRCodeView_qrcv_topOffset) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerSize) {
            this.mkC = typedArray.getDimensionPixelSize(i, this.mkC);
        } else if (i == R.styleable.QRCodeView_qrcv_cornerLength) {
            this.mkB = typedArray.getDimensionPixelSize(i, this.mkB);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineSize) {
            this.mkF = typedArray.getDimensionPixelSize(i, this.mkF);
        } else if (i == R.styleable.QRCodeView_qrcv_rectWidth) {
            this.cnI = typedArray.getDimensionPixelSize(i, this.cnI);
        } else if (i == R.styleable.QRCodeView_qrcv_maskColor) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineColor) {
            this.mkG = typedArray.getColor(i, this.mkG);
        } else if (i == R.styleable.QRCodeView_qrcv_scanLineMargin) {
            this.mkH = typedArray.getDimensionPixelSize(i, this.mkH);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultScanLineDrawable) {
            this.mkI = typedArray.getBoolean(i, this.mkI);
        } else if (i == R.styleable.QRCodeView_qrcv_customScanLineDrawable) {
            this.mkJ = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_borderSize) {
            this.mkL = typedArray.getDimensionPixelSize(i, this.mkL);
        } else if (i == R.styleable.QRCodeView_qrcv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == R.styleable.QRCodeView_qrcv_animTime) {
            this.mkM = typedArray.getInteger(i, this.mkM);
        } else if (i == R.styleable.QRCodeView_qrcv_isCenterVertical) {
            this.mkN = typedArray.getBoolean(i, this.mkN);
        } else if (i == R.styleable.QRCodeView_qrcv_toolbarHeight) {
            this.mkO = typedArray.getDimensionPixelSize(i, this.mkO);
        } else if (i == R.styleable.QRCodeView_qrcv_barcodeRectHeight) {
            this.mkE = typedArray.getDimensionPixelSize(i, this.mkE);
        } else if (i == R.styleable.QRCodeView_qrcv_isBarcode) {
            this.mkP = typedArray.getBoolean(i, this.mkP);
        } else if (i == R.styleable.QRCodeView_qrcv_barCodeTipText) {
            this.mkR = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_qrCodeTipText) {
            this.mkQ = typedArray.getString(i);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextSize) {
            this.mkS = typedArray.getDimensionPixelSize(i, this.mkS);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextColor) {
            this.mkT = typedArray.getColor(i, this.mkT);
        } else if (i == R.styleable.QRCodeView_qrcv_isTipTextBelowRect) {
            this.mkU = typedArray.getBoolean(i, this.mkU);
        } else if (i == R.styleable.QRCodeView_qrcv_tipTextMargin) {
            this.mkV = typedArray.getDimensionPixelSize(i, this.mkV);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipTextAsSingleLine) {
            this.mkW = typedArray.getBoolean(i, this.mkW);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowTipBackground) {
            this.mkY = typedArray.getBoolean(i, this.mkY);
        } else if (i == R.styleable.QRCodeView_qrcv_tipBackgroundColor) {
            this.mkX = typedArray.getColor(i, this.mkX);
        } else if (i == R.styleable.QRCodeView_qrcv_isScanLineReverse) {
            this.mkZ = typedArray.getBoolean(i, this.mkZ);
        } else if (i == R.styleable.QRCodeView_qrcv_isShowDefaultGridScanLineDrawable) {
            this.mla = typedArray.getBoolean(i, this.mla);
        } else if (i == R.styleable.QRCodeView_qrcv_customGridScanLineDrawable) {
            this.mlb = typedArray.getDrawable(i);
        } else if (i == R.styleable.QRCodeView_qrcv_isOnlyDecodeScanBoxArea) {
            this.mlm = typedArray.getBoolean(i, this.mlm);
        }
    }

    private void dxb() {
        if (this.mlb != null) {
            this.mlh = ((BitmapDrawable) this.mlb).getBitmap();
        }
        if (this.mlh == null) {
            this.mlh = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mlh = a.g(this.mlh, this.mkG);
        }
        this.mli = a.f(this.mlh, 90);
        this.mli = a.f(this.mli, 90);
        this.mli = a.f(this.mli, 90);
        if (this.mkJ != null) {
            this.mlf = ((BitmapDrawable) this.mkJ).getBitmap();
        }
        if (this.mlf == null) {
            this.mlf = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.mlf = a.g(this.mlf, this.mkG);
        }
        this.mlg = a.f(this.mlf, 90);
        this.mlj = (1.0f * this.mkC) / 2.0f;
        this.mkA.setTextSize(this.mkS);
        this.mkA.setColor(this.mkT);
        setIsBarcode(this.mkP);
    }

    public void dxc() {
        this.mkA.setColor(this.mkT);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mkx != null) {
            af(canvas);
            ag(canvas);
            ai(canvas);
            aj(canvas);
            ah(canvas);
            dxd();
        }
    }

    private void af(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.mkx.top, this.mPaint);
            canvas.drawRect(0.0f, this.mkx.top, this.mkx.left, this.mkx.bottom + 1, this.mPaint);
            canvas.drawRect(this.mkx.right + 1, this.mkx.top, width, this.mkx.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.mkx.bottom + 1, width, height, this.mPaint);
        }
    }

    private void ag(Canvas canvas) {
        if (this.mkL > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.mkL);
            canvas.drawRect(this.mkx, this.mPaint);
        }
    }

    private void ah(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.mkr, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mks, getMainFrameRight() - this.mkr.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.mkt, getMainFrameLeft(), getMainFrameBottom() - this.mkr.getHeight(), this.mPaint);
        canvas.drawBitmap(this.mku, getMainFrameRight() - this.mkr.getWidth(), getMainFrameBottom() - this.mkr.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.mkx.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.mkx.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.mkx.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.mkx.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.mkL / 2;
    }

    private void ai(Canvas canvas) {
        if (this.mkP) {
            if (this.mlc != null) {
                RectF rectF = new RectF(this.mkx.left + this.mlj + 0.5f, this.mkx.top + this.mlj + this.mkH, this.mle, (this.mkx.bottom - this.mlj) - this.mkH);
                Rect rect = new Rect((int) (this.mlc.getWidth() - rectF.width()), 0, this.mlc.getWidth(), this.mlc.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.mlc, rect, rectF, this.mPaint);
            } else if (this.mkK != null) {
                canvas.drawBitmap(this.mkK, (Rect) null, new RectF(this.mkz, this.mkx.top + this.mlj + this.mkH, this.mkz + this.mkK.getWidth(), (this.mkx.bottom - this.mlj) - this.mkH), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.mkG);
                canvas.drawRect(this.mkz, this.mkH + this.mkx.top + this.mlj, this.mkF + this.mkz, (this.mkx.bottom - this.mlj) - this.mkH, this.mPaint);
            }
        } else if (this.mlc != null) {
            RectF rectF2 = new RectF(this.mkx.left + this.mlj + this.mkH, this.mkx.top + this.mlj + 0.5f, (this.mkx.right - this.mlj) - this.mkH, this.mld);
            Rect rect2 = new Rect(0, (int) (this.mlc.getHeight() - rectF2.height()), this.mlc.getWidth(), this.mlc.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.mln);
            canvas.drawBitmap(this.mlc, rect2, rectF2, this.mPaint);
        } else if (this.mkK != null) {
            canvas.drawBitmap(this.mkK, (Rect) null, new RectF(this.mkx.left + this.mlj + this.mkH, this.mky, (this.mkx.right - this.mlj) - this.mkH, this.mky + this.mkK.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mkG);
            canvas.drawRect(this.mkH + this.mkx.left + this.mlj, this.mky, (this.mkx.right - this.mlj) - this.mkH, this.mkF + this.mky, this.mPaint);
        }
    }

    private void aj(Canvas canvas) {
        if (!TextUtils.isEmpty(this.kNj) && this.mlk != null) {
            if (this.mkU) {
                if (this.mkY) {
                    this.mPaint.setColor(this.mkX);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.mkW) {
                        Rect rect = new Rect();
                        this.mkA.getTextBounds(this.kNj, 0, this.kNj.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.mll;
                        canvas.drawRoundRect(new RectF(width, (this.mkx.bottom + this.mkV) - this.mll, rect.width() + width + (this.mll * 2), this.mkx.bottom + this.mkV + this.mlk.getHeight() + this.mll), this.mll, this.mll, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.mkx.left, (this.mkx.bottom + this.mkV) - this.mll, this.mkx.right, this.mkx.bottom + this.mkV + this.mlk.getHeight() + this.mll), this.mll, this.mll, this.mPaint);
                    }
                }
                canvas.save();
                if (this.mkW) {
                    canvas.translate(0.0f, this.mkx.bottom + this.mkV);
                } else {
                    canvas.translate(this.mkx.left + this.mll, this.mkx.bottom + this.mkV);
                }
                this.mlk.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.mkY) {
                this.mPaint.setColor(this.mkX);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.mkW) {
                    Rect rect2 = new Rect();
                    this.mkA.getTextBounds(this.kNj, 0, this.kNj.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.mll;
                    canvas.drawRoundRect(new RectF(width2, ((this.mkx.top - this.mkV) - this.mlk.getHeight()) - this.mll, rect2.width() + width2 + (this.mll * 2), (this.mkx.top - this.mkV) + this.mll), this.mll, this.mll, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.mkx.left, ((this.mkx.top - this.mkV) - this.mlk.getHeight()) - this.mll, this.mkx.right, (this.mkx.top - this.mkV) + this.mll), this.mll, this.mll, this.mPaint);
                }
            }
            canvas.save();
            if (this.mkW) {
                canvas.translate(0.0f, (this.mkx.top - this.mkV) - this.mlk.getHeight());
            } else {
                canvas.translate(this.mkx.left + this.mll, (this.mkx.top - this.mkV) - this.mlk.getHeight());
            }
            this.mlk.draw(canvas);
            canvas.restore();
        }
    }

    private void dxd() {
        if (this.mkP) {
            if (this.mlc == null) {
                this.mkz += this.mkv;
                int i = this.mkF;
                if (this.mkK != null) {
                    i = this.mkK.getWidth();
                }
                if (this.mkZ) {
                    if (i + this.mkz > this.mkx.right - this.mlj || this.mkz < this.mkx.left + this.mlj) {
                        this.mkv = -this.mkv;
                    }
                } else {
                    if (i + this.mkz > this.mkx.right - this.mlj) {
                        this.mkz = this.mkx.left + this.mlj + 0.5f;
                    }
                }
            } else {
                this.mle += this.mkv;
                if (this.mle > this.mkx.right - this.mlj) {
                    this.mle = this.mkx.left + this.mlj + 0.5f;
                }
            }
        } else if (this.mlc == null) {
            this.mky += this.mkv;
            int i2 = this.mkF;
            if (this.mkK != null) {
                i2 = this.mkK.getHeight();
            }
            if (this.mkZ) {
                if (i2 + this.mky > this.mkx.bottom - this.mlj || this.mky < this.mkx.top + this.mlj) {
                    this.mkv = -this.mkv;
                }
            } else {
                if (i2 + this.mky > this.mkx.bottom - this.mlj) {
                    this.mky = this.mkx.top + this.mlj + 0.5f;
                }
            }
        } else {
            this.mld += this.mkv;
            if (this.mld > this.mkx.bottom - this.mlj) {
                this.mld = this.mkx.top + this.mlj + 0.5f;
            }
        }
        postInvalidateDelayed(this.mkw, this.mkx.left, this.mkx.top, this.mkx.right, this.mkx.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dxe();
    }

    private void dxe() {
        int i;
        if (this.mkP) {
            i = this.mTopOffset + this.mkO;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.cnI) / 2;
        this.mkx = new Rect(width, i, this.cnI + width, this.mkD + i);
        if (this.mkP) {
            float f = this.mkx.left + this.mlj + 0.5f;
            this.mkz = f;
            this.mle = f;
            return;
        }
        float f2 = this.mkx.top + this.mlj + 0.5f;
        this.mky = f2;
        this.mld = f2;
    }

    public Rect Hz(int i) {
        if (this.mlm) {
            Rect rect = new Rect(this.mkx);
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
        this.mkP = z;
        if (this.mlb != null || this.mla) {
            if (this.mkP) {
                this.mlc = this.mli;
            } else {
                this.mlc = this.mlh;
            }
        } else if (this.mkJ != null || this.mkI) {
            if (this.mkP) {
                this.mkK = this.mlg;
            } else {
                this.mkK = this.mlf;
            }
        }
        if (this.mkP) {
            this.kNj = this.mkR;
            this.mkD = this.mkE;
            this.mkw = (int) (((this.mkM * 1.0f) * this.mkv) / this.cnI);
        } else {
            this.kNj = this.mkQ;
            this.mkD = this.cnI;
            this.mkw = (int) (((this.mkM * 1.0f) * this.mkv) / this.mkD);
        }
        if (!TextUtils.isEmpty(this.kNj)) {
            if (this.mkW) {
                this.mlk = new StaticLayout(this.kNj, this.mkA, a.fL(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.mlk = new StaticLayout(this.kNj, this.mkA, this.cnI - (this.mll * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.mkN) {
            int i = a.fL(getContext()).y;
            if (this.mkO == 0) {
                this.mTopOffset = (i - this.mkD) / 2;
            } else if (this.mkP) {
                this.mTopOffset = ((i - this.mkD) / 2) + (this.mkO / 2);
            } else {
                this.mTopOffset = (i - this.mkD) / 2;
            }
        }
        dxe();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.mkP;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.mkB;
    }

    public void setCornerLength(int i) {
        this.mkB = i;
    }

    public int getCornerSize() {
        return this.mkC;
    }

    public void setCornerSize(int i) {
        this.mkC = i;
    }

    public int getRectWidth() {
        return this.cnI;
    }

    public void setRectWidth(int i) {
        this.cnI = i;
    }

    public int getRectHeight() {
        return this.mkD;
    }

    public void setRectHeight(int i) {
        this.mkD = i;
    }

    public int getBarcodeRectHeight() {
        return this.mkE;
    }

    public void setBarcodeRectHeight(int i) {
        this.mkE = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.mkF;
    }

    public void setScanLineSize(int i) {
        this.mkF = i;
    }

    public int getScanLineColor() {
        return this.mkG;
    }

    public void setScanLineColor(int i) {
        this.mkG = i;
    }

    public int getScanLineMargin() {
        return this.mkH;
    }

    public void setScanLineMargin(int i) {
        this.mkH = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.mkI = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.mkJ;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.mkJ = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.mkK;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.mkK = bitmap;
    }

    public int getBorderSize() {
        return this.mkL;
    }

    public void setBorderSize(int i) {
        this.mkL = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.mkM;
    }

    public void setAnimTime(int i) {
        this.mkM = i;
    }

    public void setCenterVertical(boolean z) {
        this.mkN = z;
    }

    public int getToolbarHeight() {
        return this.mkO;
    }

    public void setToolbarHeight(int i) {
        this.mkO = i;
    }

    public String getQRCodeTipText() {
        return this.mkQ;
    }

    public void setQRCodeTipText(String str) {
        this.mkQ = str;
    }

    public String getBarCodeTipText() {
        return this.mkR;
    }

    public void setBarCodeTipText(String str) {
        this.mkR = str;
    }

    public String getTipText() {
        return this.kNj;
    }

    public void setTipText(String str) {
        this.kNj = str;
    }

    public int getTipTextColor() {
        return this.mkT;
    }

    public void setTipTextColor(int i) {
        this.mkT = i;
    }

    public int getTipTextSize() {
        return this.mkS;
    }

    public void setTipTextSize(int i) {
        this.mkS = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.mkU = z;
    }

    public int getTipTextMargin() {
        return this.mkV;
    }

    public void setTipTextMargin(int i) {
        this.mkV = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.mkW = z;
    }

    public void setShowTipBackground(boolean z) {
        this.mkY = z;
    }

    public int getTipBackgroundColor() {
        return this.mkX;
    }

    public void setTipBackgroundColor(int i) {
        this.mkX = i;
    }

    public void setScanLineReverse(boolean z) {
        this.mkZ = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.mla = z;
    }

    public float getHalfCornerSize() {
        return this.mlj;
    }

    public void setHalfCornerSize(float f) {
        this.mlj = f;
    }

    public StaticLayout getTipTextSl() {
        return this.mlk;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.mlk = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.mll;
    }

    public void setTipBackgroundRadius(int i) {
        this.mll = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.mlm = z;
    }
}
