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
    private String jmI;
    private Bitmap kGN;
    private Bitmap kGO;
    private Bitmap kGP;
    private Bitmap kGQ;
    private int kGR;
    private int kGS;
    private Rect kGT;
    private float kGU;
    private float kGV;
    private TextPaint kGW;
    private int kGX;
    private int kGY;
    private int kGZ;
    private float kHA;
    private Bitmap kHB;
    private Bitmap kHC;
    private Bitmap kHD;
    private Bitmap kHE;
    private float kHF;
    private StaticLayout kHG;
    private int kHH;
    private boolean kHI;
    private ColorMatrixColorFilter kHJ;
    private int kHa;
    private int kHb;
    private int kHc;
    private int kHd;
    private boolean kHe;
    private Drawable kHf;
    private Bitmap kHg;
    private int kHh;
    private int kHi;
    private boolean kHj;
    private int kHk;
    private boolean kHl;
    private String kHm;
    private String kHn;
    private int kHo;
    private int kHp;
    private boolean kHq;
    private int kHr;
    private boolean kHs;
    private int kHt;
    private boolean kHu;
    private boolean kHv;
    private boolean kHw;
    private Drawable kHx;
    private Bitmap kHy;
    private float kHz;
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
        this.kGX = a.dp2px(context, 20.0f);
        this.kGY = a.dp2px(context, 3.0f);
        this.kHb = a.dp2px(context, 1.0f);
        this.kHc = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.bGl = a.dp2px(context, 200.0f);
        this.kHa = a.dp2px(context, 140.0f);
        this.kHd = 0;
        this.kHe = false;
        this.kHf = null;
        this.kHg = null;
        this.kHh = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.kHi = 1000;
        this.kHj = false;
        this.kHk = 0;
        this.kHl = false;
        this.kGR = a.dp2px(context, 2.0f);
        this.jmI = null;
        this.kHo = a.h(context, 14.0f);
        this.kHp = -1;
        this.kHq = false;
        this.kHr = a.dp2px(context, 20.0f);
        this.kHs = false;
        this.kHt = Color.parseColor("#22000000");
        this.kHu = false;
        this.kHv = false;
        this.kHw = false;
        this.kGW = new TextPaint();
        this.kGW.setAntiAlias(true);
        this.kHH = a.dp2px(context, 4.0f);
        this.kHI = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.kHJ = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cTH();
        cTG();
    }

    private void cTG() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.kGX;
        options.outHeight = this.kGX;
        this.kGN = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.kGO = Bitmap.createBitmap(this.kGN, 0, 0, this.kGN.getWidth(), this.kGN.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.kGP = Bitmap.createBitmap(this.kGN, 0, 0, this.kGN.getWidth(), this.kGN.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.kGQ = Bitmap.createBitmap(this.kGN, 0, 0, this.kGN.getWidth(), this.kGN.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.kGY = typedArray.getDimensionPixelSize(i, this.kGY);
        } else if (i == 2) {
            this.kGX = typedArray.getDimensionPixelSize(i, this.kGX);
        } else if (i == 6) {
            this.kHb = typedArray.getDimensionPixelSize(i, this.kHb);
        } else if (i == 3) {
            this.bGl = typedArray.getDimensionPixelSize(i, this.bGl);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.kHc = typedArray.getColor(i, this.kHc);
        } else if (i == 8) {
            this.kHd = typedArray.getDimensionPixelSize(i, this.kHd);
        } else if (i == 9) {
            this.kHe = typedArray.getBoolean(i, this.kHe);
        } else if (i == 10) {
            this.kHf = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.kHh = typedArray.getDimensionPixelSize(i, this.kHh);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.kHi = typedArray.getInteger(i, this.kHi);
        } else if (i == 14) {
            this.kHj = typedArray.getBoolean(i, this.kHj);
        } else if (i == 15) {
            this.kHk = typedArray.getDimensionPixelSize(i, this.kHk);
        } else if (i == 4) {
            this.kHa = typedArray.getDimensionPixelSize(i, this.kHa);
        } else if (i == 16) {
            this.kHl = typedArray.getBoolean(i, this.kHl);
        } else if (i == 18) {
            this.kHn = typedArray.getString(i);
        } else if (i == 17) {
            this.kHm = typedArray.getString(i);
        } else if (i == 19) {
            this.kHo = typedArray.getDimensionPixelSize(i, this.kHo);
        } else if (i == 20) {
            this.kHp = typedArray.getColor(i, this.kHp);
        } else if (i == 21) {
            this.kHq = typedArray.getBoolean(i, this.kHq);
        } else if (i == 22) {
            this.kHr = typedArray.getDimensionPixelSize(i, this.kHr);
        } else if (i == 23) {
            this.kHs = typedArray.getBoolean(i, this.kHs);
        } else if (i == 24) {
            this.kHu = typedArray.getBoolean(i, this.kHu);
        } else if (i == 25) {
            this.kHt = typedArray.getColor(i, this.kHt);
        } else if (i == 26) {
            this.kHv = typedArray.getBoolean(i, this.kHv);
        } else if (i == 27) {
            this.kHw = typedArray.getBoolean(i, this.kHw);
        } else if (i == 28) {
            this.kHx = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.kHI = typedArray.getBoolean(i, this.kHI);
        }
    }

    private void cTH() {
        if (this.kHx != null) {
            this.kHD = ((BitmapDrawable) this.kHx).getBitmap();
        }
        if (this.kHD == null) {
            this.kHD = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kHD = a.f(this.kHD, this.kHc);
        }
        this.kHE = a.e(this.kHD, 90);
        this.kHE = a.e(this.kHE, 90);
        this.kHE = a.e(this.kHE, 90);
        if (this.kHf != null) {
            this.kHB = ((BitmapDrawable) this.kHf).getBitmap();
        }
        if (this.kHB == null) {
            this.kHB = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kHB = a.f(this.kHB, this.kHc);
        }
        this.kHC = a.e(this.kHB, 90);
        this.kHF = (1.0f * this.kGY) / 2.0f;
        this.kGW.setTextSize(this.kHo);
        this.kGW.setColor(this.kHp);
        setIsBarcode(this.kHl);
    }

    public void cTI() {
        this.kGW.setColor(this.kHp);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.kGT != null) {
            T(canvas);
            U(canvas);
            W(canvas);
            X(canvas);
            V(canvas);
            cTJ();
        }
    }

    private void T(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.kGT.top, this.mPaint);
            canvas.drawRect(0.0f, this.kGT.top, this.kGT.left, this.kGT.bottom + 1, this.mPaint);
            canvas.drawRect(this.kGT.right + 1, this.kGT.top, width, this.kGT.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.kGT.bottom + 1, width, height, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (this.kHh > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.kHh);
            canvas.drawRect(this.kGT, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.kGN, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.kGO, getMainFrameRight() - this.kGN.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.kGP, getMainFrameLeft(), getMainFrameBottom() - this.kGN.getHeight(), this.mPaint);
        canvas.drawBitmap(this.kGQ, getMainFrameRight() - this.kGN.getWidth(), getMainFrameBottom() - this.kGN.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.kGT.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.kGT.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.kGT.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.kGT.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.kHh / 2;
    }

    private void W(Canvas canvas) {
        if (this.kHl) {
            if (this.kHy != null) {
                RectF rectF = new RectF(this.kGT.left + this.kHF + 0.5f, this.kGT.top + this.kHF + this.kHd, this.kHA, (this.kGT.bottom - this.kHF) - this.kHd);
                Rect rect = new Rect((int) (this.kHy.getWidth() - rectF.width()), 0, this.kHy.getWidth(), this.kHy.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.kHy, rect, rectF, this.mPaint);
            } else if (this.kHg != null) {
                canvas.drawBitmap(this.kHg, (Rect) null, new RectF(this.kGV, this.kGT.top + this.kHF + this.kHd, this.kGV + this.kHg.getWidth(), (this.kGT.bottom - this.kHF) - this.kHd), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.kHc);
                canvas.drawRect(this.kGV, this.kHd + this.kGT.top + this.kHF, this.kHb + this.kGV, (this.kGT.bottom - this.kHF) - this.kHd, this.mPaint);
            }
        } else if (this.kHy != null) {
            RectF rectF2 = new RectF(this.kGT.left + this.kHF + this.kHd, this.kGT.top + this.kHF + 0.5f, (this.kGT.right - this.kHF) - this.kHd, this.kHz);
            Rect rect2 = new Rect(0, (int) (this.kHy.getHeight() - rectF2.height()), this.kHy.getWidth(), this.kHy.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.kHJ);
            canvas.drawBitmap(this.kHy, rect2, rectF2, this.mPaint);
        } else if (this.kHg != null) {
            canvas.drawBitmap(this.kHg, (Rect) null, new RectF(this.kGT.left + this.kHF + this.kHd, this.kGU, (this.kGT.right - this.kHF) - this.kHd, this.kGU + this.kHg.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.kHc);
            canvas.drawRect(this.kHd + this.kGT.left + this.kHF, this.kGU, (this.kGT.right - this.kHF) - this.kHd, this.kHb + this.kGU, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        if (!TextUtils.isEmpty(this.jmI) && this.kHG != null) {
            if (this.kHq) {
                if (this.kHu) {
                    this.mPaint.setColor(this.kHt);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.kHs) {
                        Rect rect = new Rect();
                        this.kGW.getTextBounds(this.jmI, 0, this.jmI.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.kHH;
                        canvas.drawRoundRect(new RectF(width, (this.kGT.bottom + this.kHr) - this.kHH, rect.width() + width + (this.kHH * 2), this.kGT.bottom + this.kHr + this.kHG.getHeight() + this.kHH), this.kHH, this.kHH, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.kGT.left, (this.kGT.bottom + this.kHr) - this.kHH, this.kGT.right, this.kGT.bottom + this.kHr + this.kHG.getHeight() + this.kHH), this.kHH, this.kHH, this.mPaint);
                    }
                }
                canvas.save();
                if (this.kHs) {
                    canvas.translate(0.0f, this.kGT.bottom + this.kHr);
                } else {
                    canvas.translate(this.kGT.left + this.kHH, this.kGT.bottom + this.kHr);
                }
                this.kHG.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.kHu) {
                this.mPaint.setColor(this.kHt);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.kHs) {
                    Rect rect2 = new Rect();
                    this.kGW.getTextBounds(this.jmI, 0, this.jmI.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.kHH;
                    canvas.drawRoundRect(new RectF(width2, ((this.kGT.top - this.kHr) - this.kHG.getHeight()) - this.kHH, rect2.width() + width2 + (this.kHH * 2), (this.kGT.top - this.kHr) + this.kHH), this.kHH, this.kHH, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.kGT.left, ((this.kGT.top - this.kHr) - this.kHG.getHeight()) - this.kHH, this.kGT.right, (this.kGT.top - this.kHr) + this.kHH), this.kHH, this.kHH, this.mPaint);
                }
            }
            canvas.save();
            if (this.kHs) {
                canvas.translate(0.0f, (this.kGT.top - this.kHr) - this.kHG.getHeight());
            } else {
                canvas.translate(this.kGT.left + this.kHH, (this.kGT.top - this.kHr) - this.kHG.getHeight());
            }
            this.kHG.draw(canvas);
            canvas.restore();
        }
    }

    private void cTJ() {
        if (this.kHl) {
            if (this.kHy == null) {
                this.kGV += this.kGR;
                int i = this.kHb;
                if (this.kHg != null) {
                    i = this.kHg.getWidth();
                }
                if (this.kHv) {
                    if (i + this.kGV > this.kGT.right - this.kHF || this.kGV < this.kGT.left + this.kHF) {
                        this.kGR = -this.kGR;
                    }
                } else {
                    if (i + this.kGV > this.kGT.right - this.kHF) {
                        this.kGV = this.kGT.left + this.kHF + 0.5f;
                    }
                }
            } else {
                this.kHA += this.kGR;
                if (this.kHA > this.kGT.right - this.kHF) {
                    this.kHA = this.kGT.left + this.kHF + 0.5f;
                }
            }
        } else if (this.kHy == null) {
            this.kGU += this.kGR;
            int i2 = this.kHb;
            if (this.kHg != null) {
                i2 = this.kHg.getHeight();
            }
            if (this.kHv) {
                if (i2 + this.kGU > this.kGT.bottom - this.kHF || this.kGU < this.kGT.top + this.kHF) {
                    this.kGR = -this.kGR;
                }
            } else {
                if (i2 + this.kGU > this.kGT.bottom - this.kHF) {
                    this.kGU = this.kGT.top + this.kHF + 0.5f;
                }
            }
        } else {
            this.kHz += this.kGR;
            if (this.kHz > this.kGT.bottom - this.kHF) {
                this.kHz = this.kGT.top + this.kHF + 0.5f;
            }
        }
        postInvalidateDelayed(this.kGS, this.kGT.left, this.kGT.top, this.kGT.right, this.kGT.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cTK();
    }

    private void cTK() {
        int i;
        if (this.kHl) {
            i = this.mTopOffset + this.kHk;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.bGl) / 2;
        this.kGT = new Rect(width, i, this.bGl + width, this.kGZ + i);
        if (this.kHl) {
            float f = this.kGT.left + this.kHF + 0.5f;
            this.kGV = f;
            this.kHA = f;
            return;
        }
        float f2 = this.kGT.top + this.kHF + 0.5f;
        this.kGU = f2;
        this.kHz = f2;
    }

    public Rect Ce(int i) {
        if (this.kHI) {
            Rect rect = new Rect(this.kGT);
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
        this.kHl = z;
        if (this.kHx != null || this.kHw) {
            if (this.kHl) {
                this.kHy = this.kHE;
            } else {
                this.kHy = this.kHD;
            }
        } else if (this.kHf != null || this.kHe) {
            if (this.kHl) {
                this.kHg = this.kHC;
            } else {
                this.kHg = this.kHB;
            }
        }
        if (this.kHl) {
            this.jmI = this.kHn;
            this.kGZ = this.kHa;
            this.kGS = (int) (((this.kHi * 1.0f) * this.kGR) / this.bGl);
        } else {
            this.jmI = this.kHm;
            this.kGZ = this.bGl;
            this.kGS = (int) (((this.kHi * 1.0f) * this.kGR) / this.kGZ);
        }
        if (!TextUtils.isEmpty(this.jmI)) {
            if (this.kHs) {
                this.kHG = new StaticLayout(this.jmI, this.kGW, a.fg(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.kHG = new StaticLayout(this.jmI, this.kGW, this.bGl - (this.kHH * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.kHj) {
            int i = a.fg(getContext()).y;
            if (this.kHk == 0) {
                this.mTopOffset = (i - this.kGZ) / 2;
            } else if (this.kHl) {
                this.mTopOffset = ((i - this.kGZ) / 2) + (this.kHk / 2);
            } else {
                this.mTopOffset = (i - this.kGZ) / 2;
            }
        }
        cTK();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.kHl;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.kGX;
    }

    public void setCornerLength(int i) {
        this.kGX = i;
    }

    public int getCornerSize() {
        return this.kGY;
    }

    public void setCornerSize(int i) {
        this.kGY = i;
    }

    public int getRectWidth() {
        return this.bGl;
    }

    public void setRectWidth(int i) {
        this.bGl = i;
    }

    public int getRectHeight() {
        return this.kGZ;
    }

    public void setRectHeight(int i) {
        this.kGZ = i;
    }

    public int getBarcodeRectHeight() {
        return this.kHa;
    }

    public void setBarcodeRectHeight(int i) {
        this.kHa = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.kHb;
    }

    public void setScanLineSize(int i) {
        this.kHb = i;
    }

    public int getScanLineColor() {
        return this.kHc;
    }

    public void setScanLineColor(int i) {
        this.kHc = i;
    }

    public int getScanLineMargin() {
        return this.kHd;
    }

    public void setScanLineMargin(int i) {
        this.kHd = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.kHe = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.kHf;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.kHf = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.kHg;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.kHg = bitmap;
    }

    public int getBorderSize() {
        return this.kHh;
    }

    public void setBorderSize(int i) {
        this.kHh = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.kHi;
    }

    public void setAnimTime(int i) {
        this.kHi = i;
    }

    public void setCenterVertical(boolean z) {
        this.kHj = z;
    }

    public int getToolbarHeight() {
        return this.kHk;
    }

    public void setToolbarHeight(int i) {
        this.kHk = i;
    }

    public String getQRCodeTipText() {
        return this.kHm;
    }

    public void setQRCodeTipText(String str) {
        this.kHm = str;
    }

    public String getBarCodeTipText() {
        return this.kHn;
    }

    public void setBarCodeTipText(String str) {
        this.kHn = str;
    }

    public String getTipText() {
        return this.jmI;
    }

    public void setTipText(String str) {
        this.jmI = str;
    }

    public int getTipTextColor() {
        return this.kHp;
    }

    public void setTipTextColor(int i) {
        this.kHp = i;
    }

    public int getTipTextSize() {
        return this.kHo;
    }

    public void setTipTextSize(int i) {
        this.kHo = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.kHq = z;
    }

    public int getTipTextMargin() {
        return this.kHr;
    }

    public void setTipTextMargin(int i) {
        this.kHr = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.kHs = z;
    }

    public void setShowTipBackground(boolean z) {
        this.kHu = z;
    }

    public int getTipBackgroundColor() {
        return this.kHt;
    }

    public void setTipBackgroundColor(int i) {
        this.kHt = i;
    }

    public void setScanLineReverse(boolean z) {
        this.kHv = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.kHw = z;
    }

    public float getHalfCornerSize() {
        return this.kHF;
    }

    public void setHalfCornerSize(float f) {
        this.kHF = f;
    }

    public StaticLayout getTipTextSl() {
        return this.kHG;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.kHG = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.kHH;
    }

    public void setTipBackgroundRadius(int i) {
        this.kHH = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.kHI = z;
    }
}
