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
/* loaded from: classes10.dex */
public class ScanBoxView extends View {
    private int bKZ;
    private String jEU;
    private Bitmap lbR;
    private Bitmap lbS;
    private Bitmap lbT;
    private Bitmap lbU;
    private int lbV;
    private int lbW;
    private Rect lbX;
    private float lbY;
    private float lbZ;
    private boolean lcA;
    private Drawable lcB;
    private Bitmap lcC;
    private float lcD;
    private float lcE;
    private Bitmap lcF;
    private Bitmap lcG;
    private Bitmap lcH;
    private Bitmap lcI;
    private float lcJ;
    private StaticLayout lcK;
    private int lcL;
    private boolean lcM;
    private ColorMatrixColorFilter lcN;
    private TextPaint lca;
    private int lcb;
    private int lcc;
    private int lcd;
    private int lce;
    private int lcf;
    private int lcg;
    private int lch;
    private boolean lci;
    private Drawable lcj;
    private Bitmap lck;
    private int lcl;
    private int lcm;
    private boolean lcn;
    private int lco;
    private boolean lcp;
    private String lcq;
    private String lcr;
    private int lcs;
    private int lct;
    private boolean lcu;
    private int lcv;
    private boolean lcw;
    private int lcx;
    private boolean lcy;
    private boolean lcz;
    private int mBorderColor;
    private Context mContext;
    private int mMaskColor;
    private Paint mPaint;
    private int mTopOffset;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mMaskColor = Color.parseColor("#33FFFFFF");
        this.lcb = a.dp2px(context, 20.0f);
        this.lcc = a.dp2px(context, 3.0f);
        this.lcf = a.dp2px(context, 1.0f);
        this.lcg = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bKZ = a.dp2px(context, 200.0f);
        this.lce = a.dp2px(context, 140.0f);
        this.lch = 0;
        this.lci = false;
        this.lcj = null;
        this.lck = null;
        this.lcl = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.lcm = 1000;
        this.lcn = false;
        this.lco = 0;
        this.lcp = false;
        this.lbV = a.dp2px(context, 2.0f);
        this.jEU = null;
        this.lcs = a.h(context, 14.0f);
        this.lct = -1;
        this.lcu = false;
        this.lcv = a.dp2px(context, 20.0f);
        this.lcw = false;
        this.lcx = Color.parseColor("#22000000");
        this.lcy = false;
        this.lcz = false;
        this.lcA = false;
        this.lca = new TextPaint();
        this.lca.setAntiAlias(true);
        this.lcL = a.dp2px(context, 4.0f);
        this.lcM = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.lcN = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cYn();
        cYm();
    }

    private void cYm() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.lcb;
        options.outHeight = this.lcb;
        this.lbR = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.lbS = Bitmap.createBitmap(this.lbR, 0, 0, this.lbR.getWidth(), this.lbR.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.lbT = Bitmap.createBitmap(this.lbR, 0, 0, this.lbR.getWidth(), this.lbR.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.lbU = Bitmap.createBitmap(this.lbR, 0, 0, this.lbR.getWidth(), this.lbR.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.lcc = typedArray.getDimensionPixelSize(i, this.lcc);
        } else if (i == 2) {
            this.lcb = typedArray.getDimensionPixelSize(i, this.lcb);
        } else if (i == 6) {
            this.lcf = typedArray.getDimensionPixelSize(i, this.lcf);
        } else if (i == 3) {
            this.bKZ = typedArray.getDimensionPixelSize(i, this.bKZ);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.lcg = typedArray.getColor(i, this.lcg);
        } else if (i == 8) {
            this.lch = typedArray.getDimensionPixelSize(i, this.lch);
        } else if (i == 9) {
            this.lci = typedArray.getBoolean(i, this.lci);
        } else if (i == 10) {
            this.lcj = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.lcl = typedArray.getDimensionPixelSize(i, this.lcl);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.lcm = typedArray.getInteger(i, this.lcm);
        } else if (i == 14) {
            this.lcn = typedArray.getBoolean(i, this.lcn);
        } else if (i == 15) {
            this.lco = typedArray.getDimensionPixelSize(i, this.lco);
        } else if (i == 4) {
            this.lce = typedArray.getDimensionPixelSize(i, this.lce);
        } else if (i == 16) {
            this.lcp = typedArray.getBoolean(i, this.lcp);
        } else if (i == 18) {
            this.lcr = typedArray.getString(i);
        } else if (i == 17) {
            this.lcq = typedArray.getString(i);
        } else if (i == 19) {
            this.lcs = typedArray.getDimensionPixelSize(i, this.lcs);
        } else if (i == 20) {
            this.lct = typedArray.getColor(i, this.lct);
        } else if (i == 21) {
            this.lcu = typedArray.getBoolean(i, this.lcu);
        } else if (i == 22) {
            this.lcv = typedArray.getDimensionPixelSize(i, this.lcv);
        } else if (i == 23) {
            this.lcw = typedArray.getBoolean(i, this.lcw);
        } else if (i == 24) {
            this.lcy = typedArray.getBoolean(i, this.lcy);
        } else if (i == 25) {
            this.lcx = typedArray.getColor(i, this.lcx);
        } else if (i == 26) {
            this.lcz = typedArray.getBoolean(i, this.lcz);
        } else if (i == 27) {
            this.lcA = typedArray.getBoolean(i, this.lcA);
        } else if (i == 28) {
            this.lcB = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.lcM = typedArray.getBoolean(i, this.lcM);
        }
    }

    private void cYn() {
        if (this.lcB != null) {
            this.lcH = ((BitmapDrawable) this.lcB).getBitmap();
        }
        if (this.lcH == null) {
            this.lcH = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lcH = a.f(this.lcH, this.lcg);
        }
        this.lcI = a.e(this.lcH, 90);
        this.lcI = a.e(this.lcI, 90);
        this.lcI = a.e(this.lcI, 90);
        if (this.lcj != null) {
            this.lcF = ((BitmapDrawable) this.lcj).getBitmap();
        }
        if (this.lcF == null) {
            this.lcF = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.lcF = a.f(this.lcF, this.lcg);
        }
        this.lcG = a.e(this.lcF, 90);
        this.lcJ = (1.0f * this.lcc) / 2.0f;
        this.lca.setTextSize(this.lcs);
        this.lca.setColor(this.lct);
        setIsBarcode(this.lcp);
    }

    public void cYo() {
        this.lca.setColor(this.lct);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lbX != null) {
            Y(canvas);
            Z(canvas);
            ab(canvas);
            ac(canvas);
            aa(canvas);
            cYp();
        }
    }

    private void Y(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.lbX.top, this.mPaint);
            canvas.drawRect(0.0f, this.lbX.top, this.lbX.left, this.lbX.bottom + 1, this.mPaint);
            canvas.drawRect(this.lbX.right + 1, this.lbX.top, width, this.lbX.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.lbX.bottom + 1, width, height, this.mPaint);
        }
    }

    private void Z(Canvas canvas) {
        if (this.lcl > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.lcl);
            canvas.drawRect(this.lbX, this.mPaint);
        }
    }

    private void aa(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.lbR, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lbS, getMainFrameRight() - this.lbR.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.lbT, getMainFrameLeft(), getMainFrameBottom() - this.lbR.getHeight(), this.mPaint);
        canvas.drawBitmap(this.lbU, getMainFrameRight() - this.lbR.getWidth(), getMainFrameBottom() - this.lbR.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.lbX.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.lbX.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.lbX.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.lbX.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.lcl / 2;
    }

    private void ab(Canvas canvas) {
        if (this.lcp) {
            if (this.lcC != null) {
                RectF rectF = new RectF(this.lbX.left + this.lcJ + 0.5f, this.lbX.top + this.lcJ + this.lch, this.lcE, (this.lbX.bottom - this.lcJ) - this.lch);
                Rect rect = new Rect((int) (this.lcC.getWidth() - rectF.width()), 0, this.lcC.getWidth(), this.lcC.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.lcC, rect, rectF, this.mPaint);
            } else if (this.lck != null) {
                canvas.drawBitmap(this.lck, (Rect) null, new RectF(this.lbZ, this.lbX.top + this.lcJ + this.lch, this.lbZ + this.lck.getWidth(), (this.lbX.bottom - this.lcJ) - this.lch), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.lcg);
                canvas.drawRect(this.lbZ, this.lch + this.lbX.top + this.lcJ, this.lcf + this.lbZ, (this.lbX.bottom - this.lcJ) - this.lch, this.mPaint);
            }
        } else if (this.lcC != null) {
            RectF rectF2 = new RectF(this.lbX.left + this.lcJ + this.lch, this.lbX.top + this.lcJ + 0.5f, (this.lbX.right - this.lcJ) - this.lch, this.lcD);
            Rect rect2 = new Rect(0, (int) (this.lcC.getHeight() - rectF2.height()), this.lcC.getWidth(), this.lcC.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.lcN);
            canvas.drawBitmap(this.lcC, rect2, rectF2, this.mPaint);
        } else if (this.lck != null) {
            canvas.drawBitmap(this.lck, (Rect) null, new RectF(this.lbX.left + this.lcJ + this.lch, this.lbY, (this.lbX.right - this.lcJ) - this.lch, this.lbY + this.lck.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.lcg);
            canvas.drawRect(this.lch + this.lbX.left + this.lcJ, this.lbY, (this.lbX.right - this.lcJ) - this.lch, this.lcf + this.lbY, this.mPaint);
        }
    }

    private void ac(Canvas canvas) {
        if (!TextUtils.isEmpty(this.jEU) && this.lcK != null) {
            if (this.lcu) {
                if (this.lcy) {
                    this.mPaint.setColor(this.lcx);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.lcw) {
                        Rect rect = new Rect();
                        this.lca.getTextBounds(this.jEU, 0, this.jEU.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.lcL;
                        canvas.drawRoundRect(new RectF(width, (this.lbX.bottom + this.lcv) - this.lcL, rect.width() + width + (this.lcL * 2), this.lbX.bottom + this.lcv + this.lcK.getHeight() + this.lcL), this.lcL, this.lcL, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.lbX.left, (this.lbX.bottom + this.lcv) - this.lcL, this.lbX.right, this.lbX.bottom + this.lcv + this.lcK.getHeight() + this.lcL), this.lcL, this.lcL, this.mPaint);
                    }
                }
                canvas.save();
                if (this.lcw) {
                    canvas.translate(0.0f, this.lbX.bottom + this.lcv);
                } else {
                    canvas.translate(this.lbX.left + this.lcL, this.lbX.bottom + this.lcv);
                }
                this.lcK.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.lcy) {
                this.mPaint.setColor(this.lcx);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.lcw) {
                    Rect rect2 = new Rect();
                    this.lca.getTextBounds(this.jEU, 0, this.jEU.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.lcL;
                    canvas.drawRoundRect(new RectF(width2, ((this.lbX.top - this.lcv) - this.lcK.getHeight()) - this.lcL, rect2.width() + width2 + (this.lcL * 2), (this.lbX.top - this.lcv) + this.lcL), this.lcL, this.lcL, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.lbX.left, ((this.lbX.top - this.lcv) - this.lcK.getHeight()) - this.lcL, this.lbX.right, (this.lbX.top - this.lcv) + this.lcL), this.lcL, this.lcL, this.mPaint);
                }
            }
            canvas.save();
            if (this.lcw) {
                canvas.translate(0.0f, (this.lbX.top - this.lcv) - this.lcK.getHeight());
            } else {
                canvas.translate(this.lbX.left + this.lcL, (this.lbX.top - this.lcv) - this.lcK.getHeight());
            }
            this.lcK.draw(canvas);
            canvas.restore();
        }
    }

    private void cYp() {
        if (this.lcp) {
            if (this.lcC == null) {
                this.lbZ += this.lbV;
                int i = this.lcf;
                if (this.lck != null) {
                    i = this.lck.getWidth();
                }
                if (this.lcz) {
                    if (i + this.lbZ > this.lbX.right - this.lcJ || this.lbZ < this.lbX.left + this.lcJ) {
                        this.lbV = -this.lbV;
                    }
                } else {
                    if (i + this.lbZ > this.lbX.right - this.lcJ) {
                        this.lbZ = this.lbX.left + this.lcJ + 0.5f;
                    }
                }
            } else {
                this.lcE += this.lbV;
                if (this.lcE > this.lbX.right - this.lcJ) {
                    this.lcE = this.lbX.left + this.lcJ + 0.5f;
                }
            }
        } else if (this.lcC == null) {
            this.lbY += this.lbV;
            int i2 = this.lcf;
            if (this.lck != null) {
                i2 = this.lck.getHeight();
            }
            if (this.lcz) {
                if (i2 + this.lbY > this.lbX.bottom - this.lcJ || this.lbY < this.lbX.top + this.lcJ) {
                    this.lbV = -this.lbV;
                }
            } else {
                if (i2 + this.lbY > this.lbX.bottom - this.lcJ) {
                    this.lbY = this.lbX.top + this.lcJ + 0.5f;
                }
            }
        } else {
            this.lcD += this.lbV;
            if (this.lcD > this.lbX.bottom - this.lcJ) {
                this.lcD = this.lbX.top + this.lcJ + 0.5f;
            }
        }
        postInvalidateDelayed(this.lbW, this.lbX.left, this.lbX.top, this.lbX.right, this.lbX.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cYq();
    }

    private void cYq() {
        int i;
        if (this.lcp) {
            i = this.mTopOffset + this.lco;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bKZ) / 2;
        this.lbX = new Rect(width, i, this.bKZ + width, this.lcd + i);
        if (this.lcp) {
            float f = this.lbX.left + this.lcJ + 0.5f;
            this.lbZ = f;
            this.lcE = f;
            return;
        }
        float f2 = this.lbX.top + this.lcJ + 0.5f;
        this.lbY = f2;
        this.lcD = f2;
    }

    public Rect Di(int i) {
        if (this.lcM) {
            Rect rect = new Rect(this.lbX);
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
        this.lcp = z;
        if (this.lcB != null || this.lcA) {
            if (this.lcp) {
                this.lcC = this.lcI;
            } else {
                this.lcC = this.lcH;
            }
        } else if (this.lcj != null || this.lci) {
            if (this.lcp) {
                this.lck = this.lcG;
            } else {
                this.lck = this.lcF;
            }
        }
        if (this.lcp) {
            this.jEU = this.lcr;
            this.lcd = this.lce;
            this.lbW = (int) (((this.lcm * 1.0f) * this.lbV) / this.bKZ);
        } else {
            this.jEU = this.lcq;
            this.lcd = this.bKZ;
            this.lbW = (int) (((this.lcm * 1.0f) * this.lbV) / this.lcd);
        }
        if (!TextUtils.isEmpty(this.jEU)) {
            if (this.lcw) {
                this.lcK = new StaticLayout(this.jEU, this.lca, a.fg(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.lcK = new StaticLayout(this.jEU, this.lca, this.bKZ - (this.lcL * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.lcn) {
            int i = a.fg(getContext()).y;
            if (this.lco == 0) {
                this.mTopOffset = (i - this.lcd) / 2;
            } else if (this.lcp) {
                this.mTopOffset = ((i - this.lcd) / 2) + (this.lco / 2);
            } else {
                this.mTopOffset = (i - this.lcd) / 2;
            }
        }
        cYq();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.lcp;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.lcb;
    }

    public void setCornerLength(int i) {
        this.lcb = i;
    }

    public int getCornerSize() {
        return this.lcc;
    }

    public void setCornerSize(int i) {
        this.lcc = i;
    }

    public int getRectWidth() {
        return this.bKZ;
    }

    public void setRectWidth(int i) {
        this.bKZ = i;
    }

    public int getRectHeight() {
        return this.lcd;
    }

    public void setRectHeight(int i) {
        this.lcd = i;
    }

    public int getBarcodeRectHeight() {
        return this.lce;
    }

    public void setBarcodeRectHeight(int i) {
        this.lce = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.lcf;
    }

    public void setScanLineSize(int i) {
        this.lcf = i;
    }

    public int getScanLineColor() {
        return this.lcg;
    }

    public void setScanLineColor(int i) {
        this.lcg = i;
    }

    public int getScanLineMargin() {
        return this.lch;
    }

    public void setScanLineMargin(int i) {
        this.lch = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.lci = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.lcj;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.lcj = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.lck;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.lck = bitmap;
    }

    public int getBorderSize() {
        return this.lcl;
    }

    public void setBorderSize(int i) {
        this.lcl = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.lcm;
    }

    public void setAnimTime(int i) {
        this.lcm = i;
    }

    public void setCenterVertical(boolean z) {
        this.lcn = z;
    }

    public int getToolbarHeight() {
        return this.lco;
    }

    public void setToolbarHeight(int i) {
        this.lco = i;
    }

    public String getQRCodeTipText() {
        return this.lcq;
    }

    public void setQRCodeTipText(String str) {
        this.lcq = str;
    }

    public String getBarCodeTipText() {
        return this.lcr;
    }

    public void setBarCodeTipText(String str) {
        this.lcr = str;
    }

    public String getTipText() {
        return this.jEU;
    }

    public void setTipText(String str) {
        this.jEU = str;
    }

    public int getTipTextColor() {
        return this.lct;
    }

    public void setTipTextColor(int i) {
        this.lct = i;
    }

    public int getTipTextSize() {
        return this.lcs;
    }

    public void setTipTextSize(int i) {
        this.lcs = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.lcu = z;
    }

    public int getTipTextMargin() {
        return this.lcv;
    }

    public void setTipTextMargin(int i) {
        this.lcv = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.lcw = z;
    }

    public void setShowTipBackground(boolean z) {
        this.lcy = z;
    }

    public int getTipBackgroundColor() {
        return this.lcx;
    }

    public void setTipBackgroundColor(int i) {
        this.lcx = i;
    }

    public void setScanLineReverse(boolean z) {
        this.lcz = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.lcA = z;
    }

    public float getHalfCornerSize() {
        return this.lcJ;
    }

    public void setHalfCornerSize(float f) {
        this.lcJ = f;
    }

    public StaticLayout getTipTextSl() {
        return this.lcK;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.lcK = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.lcL;
    }

    public void setTipBackgroundRadius(int i) {
        this.lcL = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.lcM = z;
    }
}
