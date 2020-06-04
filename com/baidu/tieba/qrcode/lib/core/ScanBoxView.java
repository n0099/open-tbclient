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
    private int bGl;
    private String jnO;
    private Bitmap kHV;
    private Bitmap kHW;
    private Bitmap kHX;
    private Bitmap kHY;
    private int kHZ;
    private boolean kIA;
    private int kIB;
    private boolean kIC;
    private boolean kID;
    private boolean kIE;
    private Drawable kIF;
    private Bitmap kIG;
    private float kIH;
    private float kII;
    private Bitmap kIJ;
    private Bitmap kIK;
    private Bitmap kIL;
    private Bitmap kIM;
    private float kIN;
    private StaticLayout kIO;
    private int kIP;
    private boolean kIQ;
    private ColorMatrixColorFilter kIR;
    private int kIa;
    private Rect kIb;
    private float kIc;
    private float kId;
    private TextPaint kIe;
    private int kIf;
    private int kIg;
    private int kIh;
    private int kIi;
    private int kIj;
    private int kIk;
    private int kIl;
    private boolean kIm;
    private Drawable kIn;
    private Bitmap kIo;
    private int kIp;
    private int kIq;
    private boolean kIr;
    private int kIs;
    private boolean kIt;
    private String kIu;
    private String kIv;
    private int kIw;
    private int kIx;
    private boolean kIy;
    private int kIz;
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
        this.kIf = a.dp2px(context, 20.0f);
        this.kIg = a.dp2px(context, 3.0f);
        this.kIj = a.dp2px(context, 1.0f);
        this.kIk = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bGl = a.dp2px(context, 200.0f);
        this.kIi = a.dp2px(context, 140.0f);
        this.kIl = 0;
        this.kIm = false;
        this.kIn = null;
        this.kIo = null;
        this.kIp = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.kIq = 1000;
        this.kIr = false;
        this.kIs = 0;
        this.kIt = false;
        this.kHZ = a.dp2px(context, 2.0f);
        this.jnO = null;
        this.kIw = a.h(context, 14.0f);
        this.kIx = -1;
        this.kIy = false;
        this.kIz = a.dp2px(context, 20.0f);
        this.kIA = false;
        this.kIB = Color.parseColor("#22000000");
        this.kIC = false;
        this.kID = false;
        this.kIE = false;
        this.kIe = new TextPaint();
        this.kIe.setAntiAlias(true);
        this.kIP = a.dp2px(context, 4.0f);
        this.kIQ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.kIR = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cTX();
        cTW();
    }

    private void cTW() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.kIf;
        options.outHeight = this.kIf;
        this.kHV = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.kHW = Bitmap.createBitmap(this.kHV, 0, 0, this.kHV.getWidth(), this.kHV.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.kHX = Bitmap.createBitmap(this.kHV, 0, 0, this.kHV.getWidth(), this.kHV.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.kHY = Bitmap.createBitmap(this.kHV, 0, 0, this.kHV.getWidth(), this.kHV.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.kIg = typedArray.getDimensionPixelSize(i, this.kIg);
        } else if (i == 2) {
            this.kIf = typedArray.getDimensionPixelSize(i, this.kIf);
        } else if (i == 6) {
            this.kIj = typedArray.getDimensionPixelSize(i, this.kIj);
        } else if (i == 3) {
            this.bGl = typedArray.getDimensionPixelSize(i, this.bGl);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.kIk = typedArray.getColor(i, this.kIk);
        } else if (i == 8) {
            this.kIl = typedArray.getDimensionPixelSize(i, this.kIl);
        } else if (i == 9) {
            this.kIm = typedArray.getBoolean(i, this.kIm);
        } else if (i == 10) {
            this.kIn = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.kIp = typedArray.getDimensionPixelSize(i, this.kIp);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.kIq = typedArray.getInteger(i, this.kIq);
        } else if (i == 14) {
            this.kIr = typedArray.getBoolean(i, this.kIr);
        } else if (i == 15) {
            this.kIs = typedArray.getDimensionPixelSize(i, this.kIs);
        } else if (i == 4) {
            this.kIi = typedArray.getDimensionPixelSize(i, this.kIi);
        } else if (i == 16) {
            this.kIt = typedArray.getBoolean(i, this.kIt);
        } else if (i == 18) {
            this.kIv = typedArray.getString(i);
        } else if (i == 17) {
            this.kIu = typedArray.getString(i);
        } else if (i == 19) {
            this.kIw = typedArray.getDimensionPixelSize(i, this.kIw);
        } else if (i == 20) {
            this.kIx = typedArray.getColor(i, this.kIx);
        } else if (i == 21) {
            this.kIy = typedArray.getBoolean(i, this.kIy);
        } else if (i == 22) {
            this.kIz = typedArray.getDimensionPixelSize(i, this.kIz);
        } else if (i == 23) {
            this.kIA = typedArray.getBoolean(i, this.kIA);
        } else if (i == 24) {
            this.kIC = typedArray.getBoolean(i, this.kIC);
        } else if (i == 25) {
            this.kIB = typedArray.getColor(i, this.kIB);
        } else if (i == 26) {
            this.kID = typedArray.getBoolean(i, this.kID);
        } else if (i == 27) {
            this.kIE = typedArray.getBoolean(i, this.kIE);
        } else if (i == 28) {
            this.kIF = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.kIQ = typedArray.getBoolean(i, this.kIQ);
        }
    }

    private void cTX() {
        if (this.kIF != null) {
            this.kIL = ((BitmapDrawable) this.kIF).getBitmap();
        }
        if (this.kIL == null) {
            this.kIL = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kIL = a.f(this.kIL, this.kIk);
        }
        this.kIM = a.e(this.kIL, 90);
        this.kIM = a.e(this.kIM, 90);
        this.kIM = a.e(this.kIM, 90);
        if (this.kIn != null) {
            this.kIJ = ((BitmapDrawable) this.kIn).getBitmap();
        }
        if (this.kIJ == null) {
            this.kIJ = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kIJ = a.f(this.kIJ, this.kIk);
        }
        this.kIK = a.e(this.kIJ, 90);
        this.kIN = (1.0f * this.kIg) / 2.0f;
        this.kIe.setTextSize(this.kIw);
        this.kIe.setColor(this.kIx);
        setIsBarcode(this.kIt);
    }

    public void cTY() {
        this.kIe.setColor(this.kIx);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.kIb != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            cTZ();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.kIb.top, this.mPaint);
            canvas.drawRect(0.0f, this.kIb.top, this.kIb.left, this.kIb.bottom + 1, this.mPaint);
            canvas.drawRect(this.kIb.right + 1, this.kIb.top, width, this.kIb.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.kIb.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.kIp > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.kIp);
            canvas.drawRect(this.kIb, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.kHV, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.kHW, getMainFrameRight() - this.kHV.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.kHX, getMainFrameLeft(), getMainFrameBottom() - this.kHV.getHeight(), this.mPaint);
        canvas.drawBitmap(this.kHY, getMainFrameRight() - this.kHV.getWidth(), getMainFrameBottom() - this.kHV.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.kIb.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.kIb.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.kIb.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.kIb.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.kIp / 2;
    }

    private void W(Canvas canvas) {
        if (this.kIt) {
            if (this.kIG != null) {
                RectF rectF = new RectF(this.kIb.left + this.kIN + 0.5f, this.kIb.top + this.kIN + this.kIl, this.kII, (this.kIb.bottom - this.kIN) - this.kIl);
                Rect rect = new Rect((int) (this.kIG.getWidth() - rectF.width()), 0, this.kIG.getWidth(), this.kIG.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.kIG, rect, rectF, this.mPaint);
            } else if (this.kIo != null) {
                canvas.drawBitmap(this.kIo, (Rect) null, new RectF(this.kId, this.kIb.top + this.kIN + this.kIl, this.kId + this.kIo.getWidth(), (this.kIb.bottom - this.kIN) - this.kIl), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.kIk);
                canvas.drawRect(this.kId, this.kIl + this.kIb.top + this.kIN, this.kIj + this.kId, (this.kIb.bottom - this.kIN) - this.kIl, this.mPaint);
            }
        } else if (this.kIG != null) {
            RectF rectF2 = new RectF(this.kIb.left + this.kIN + this.kIl, this.kIb.top + this.kIN + 0.5f, (this.kIb.right - this.kIN) - this.kIl, this.kIH);
            Rect rect2 = new Rect(0, (int) (this.kIG.getHeight() - rectF2.height()), this.kIG.getWidth(), this.kIG.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.kIR);
            canvas.drawBitmap(this.kIG, rect2, rectF2, this.mPaint);
        } else if (this.kIo != null) {
            canvas.drawBitmap(this.kIo, (Rect) null, new RectF(this.kIb.left + this.kIN + this.kIl, this.kIc, (this.kIb.right - this.kIN) - this.kIl, this.kIc + this.kIo.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.kIk);
            canvas.drawRect(this.kIl + this.kIb.left + this.kIN, this.kIc, (this.kIb.right - this.kIN) - this.kIl, this.kIj + this.kIc, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.jnO) && this.kIO != null) {
            if (this.kIy) {
                if (this.kIC) {
                    this.mPaint.setColor(this.kIB);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.kIA) {
                        Rect rect = new Rect();
                        this.kIe.getTextBounds(this.jnO, 0, this.jnO.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.kIP;
                        canvas.drawRoundRect(new RectF(width, (this.kIb.bottom + this.kIz) - this.kIP, rect.width() + width + (this.kIP * 2), this.kIb.bottom + this.kIz + this.kIO.getHeight() + this.kIP), this.kIP, this.kIP, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.kIb.left, (this.kIb.bottom + this.kIz) - this.kIP, this.kIb.right, this.kIb.bottom + this.kIz + this.kIO.getHeight() + this.kIP), this.kIP, this.kIP, this.mPaint);
                    }
                }
                canvas.save();
                if (this.kIA) {
                    canvas.translate(0.0f, this.kIb.bottom + this.kIz);
                } else {
                    canvas.translate(this.kIb.left + this.kIP, this.kIb.bottom + this.kIz);
                }
                this.kIO.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.kIC) {
                this.mPaint.setColor(this.kIB);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.kIA) {
                    Rect rect2 = new Rect();
                    this.kIe.getTextBounds(this.jnO, 0, this.jnO.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.kIP;
                    canvas.drawRoundRect(new RectF(width2, ((this.kIb.top - this.kIz) - this.kIO.getHeight()) - this.kIP, rect2.width() + width2 + (this.kIP * 2), (this.kIb.top - this.kIz) + this.kIP), this.kIP, this.kIP, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.kIb.left, ((this.kIb.top - this.kIz) - this.kIO.getHeight()) - this.kIP, this.kIb.right, (this.kIb.top - this.kIz) + this.kIP), this.kIP, this.kIP, this.mPaint);
                }
            }
            canvas.save();
            if (this.kIA) {
                canvas.translate(0.0f, (this.kIb.top - this.kIz) - this.kIO.getHeight());
            } else {
                canvas.translate(this.kIb.left + this.kIP, (this.kIb.top - this.kIz) - this.kIO.getHeight());
            }
            this.kIO.draw(canvas);
            canvas.restore();
        }
    }

    private void cTZ() {
        if (this.kIt) {
            if (this.kIG == null) {
                this.kId += this.kHZ;
                int i = this.kIj;
                if (this.kIo != null) {
                    i = this.kIo.getWidth();
                }
                if (this.kID) {
                    if (i + this.kId > this.kIb.right - this.kIN || this.kId < this.kIb.left + this.kIN) {
                        this.kHZ = -this.kHZ;
                    }
                } else {
                    if (i + this.kId > this.kIb.right - this.kIN) {
                        this.kId = this.kIb.left + this.kIN + 0.5f;
                    }
                }
            } else {
                this.kII += this.kHZ;
                if (this.kII > this.kIb.right - this.kIN) {
                    this.kII = this.kIb.left + this.kIN + 0.5f;
                }
            }
        } else if (this.kIG == null) {
            this.kIc += this.kHZ;
            int i2 = this.kIj;
            if (this.kIo != null) {
                i2 = this.kIo.getHeight();
            }
            if (this.kID) {
                if (i2 + this.kIc > this.kIb.bottom - this.kIN || this.kIc < this.kIb.top + this.kIN) {
                    this.kHZ = -this.kHZ;
                }
            } else {
                if (i2 + this.kIc > this.kIb.bottom - this.kIN) {
                    this.kIc = this.kIb.top + this.kIN + 0.5f;
                }
            }
        } else {
            this.kIH += this.kHZ;
            if (this.kIH > this.kIb.bottom - this.kIN) {
                this.kIH = this.kIb.top + this.kIN + 0.5f;
            }
        }
        postInvalidateDelayed(this.kIa, this.kIb.left, this.kIb.top, this.kIb.right, this.kIb.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cUa();
    }

    private void cUa() {
        int i;
        if (this.kIt) {
            i = this.mTopOffset + this.kIs;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bGl) / 2;
        this.kIb = new Rect(width, i, this.bGl + width, this.kIh + i);
        if (this.kIt) {
            float f = this.kIb.left + this.kIN + 0.5f;
            this.kId = f;
            this.kII = f;
            return;
        }
        float f2 = this.kIb.top + this.kIN + 0.5f;
        this.kIc = f2;
        this.kIH = f2;
    }

    public Rect Cg(int i) {
        if (this.kIQ) {
            Rect rect = new Rect(this.kIb);
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
        this.kIt = z;
        if (this.kIF != null || this.kIE) {
            if (this.kIt) {
                this.kIG = this.kIM;
            } else {
                this.kIG = this.kIL;
            }
        } else if (this.kIn != null || this.kIm) {
            if (this.kIt) {
                this.kIo = this.kIK;
            } else {
                this.kIo = this.kIJ;
            }
        }
        if (this.kIt) {
            this.jnO = this.kIv;
            this.kIh = this.kIi;
            this.kIa = (int) (((this.kIq * 1.0f) * this.kHZ) / this.bGl);
        } else {
            this.jnO = this.kIu;
            this.kIh = this.bGl;
            this.kIa = (int) (((this.kIq * 1.0f) * this.kHZ) / this.kIh);
        }
        if (!TextUtils.isEmpty(this.jnO)) {
            if (this.kIA) {
                this.kIO = new StaticLayout(this.jnO, this.kIe, a.fg(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.kIO = new StaticLayout(this.jnO, this.kIe, this.bGl - (this.kIP * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.kIr) {
            int i = a.fg(getContext()).y;
            if (this.kIs == 0) {
                this.mTopOffset = (i - this.kIh) / 2;
            } else if (this.kIt) {
                this.mTopOffset = ((i - this.kIh) / 2) + (this.kIs / 2);
            } else {
                this.mTopOffset = (i - this.kIh) / 2;
            }
        }
        cUa();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.kIt;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.kIf;
    }

    public void setCornerLength(int i) {
        this.kIf = i;
    }

    public int getCornerSize() {
        return this.kIg;
    }

    public void setCornerSize(int i) {
        this.kIg = i;
    }

    public int getRectWidth() {
        return this.bGl;
    }

    public void setRectWidth(int i) {
        this.bGl = i;
    }

    public int getRectHeight() {
        return this.kIh;
    }

    public void setRectHeight(int i) {
        this.kIh = i;
    }

    public int getBarcodeRectHeight() {
        return this.kIi;
    }

    public void setBarcodeRectHeight(int i) {
        this.kIi = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.kIj;
    }

    public void setScanLineSize(int i) {
        this.kIj = i;
    }

    public int getScanLineColor() {
        return this.kIk;
    }

    public void setScanLineColor(int i) {
        this.kIk = i;
    }

    public int getScanLineMargin() {
        return this.kIl;
    }

    public void setScanLineMargin(int i) {
        this.kIl = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.kIm = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.kIn;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.kIn = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.kIo;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.kIo = bitmap;
    }

    public int getBorderSize() {
        return this.kIp;
    }

    public void setBorderSize(int i) {
        this.kIp = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.kIq;
    }

    public void setAnimTime(int i) {
        this.kIq = i;
    }

    public void setCenterVertical(boolean z) {
        this.kIr = z;
    }

    public int getToolbarHeight() {
        return this.kIs;
    }

    public void setToolbarHeight(int i) {
        this.kIs = i;
    }

    public String getQRCodeTipText() {
        return this.kIu;
    }

    public void setQRCodeTipText(String str) {
        this.kIu = str;
    }

    public String getBarCodeTipText() {
        return this.kIv;
    }

    public void setBarCodeTipText(String str) {
        this.kIv = str;
    }

    public String getTipText() {
        return this.jnO;
    }

    public void setTipText(String str) {
        this.jnO = str;
    }

    public int getTipTextColor() {
        return this.kIx;
    }

    public void setTipTextColor(int i) {
        this.kIx = i;
    }

    public int getTipTextSize() {
        return this.kIw;
    }

    public void setTipTextSize(int i) {
        this.kIw = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.kIy = z;
    }

    public int getTipTextMargin() {
        return this.kIz;
    }

    public void setTipTextMargin(int i) {
        this.kIz = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.kIA = z;
    }

    public void setShowTipBackground(boolean z) {
        this.kIC = z;
    }

    public int getTipBackgroundColor() {
        return this.kIB;
    }

    public void setTipBackgroundColor(int i) {
        this.kIB = i;
    }

    public void setScanLineReverse(boolean z) {
        this.kID = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.kIE = z;
    }

    public float getHalfCornerSize() {
        return this.kIN;
    }

    public void setHalfCornerSize(float f) {
        this.kIN = f;
    }

    public StaticLayout getTipTextSl() {
        return this.kIO;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.kIO = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.kIP;
    }

    public void setTipBackgroundRadius(int i) {
        this.kIP = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.kIQ = z;
    }
}
