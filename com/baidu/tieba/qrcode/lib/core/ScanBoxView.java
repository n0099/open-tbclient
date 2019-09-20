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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
    private int GW;
    private int bZf;
    private int cET;
    private String hue;
    private Bitmap iGL;
    private Bitmap iGM;
    private Bitmap iGN;
    private Bitmap iGO;
    private int iGP;
    private int iGQ;
    private Rect iGR;
    private float iGS;
    private float iGT;
    private TextPaint iGU;
    private int iGV;
    private int iGW;
    private int iGX;
    private int iGY;
    private int iGZ;
    private Bitmap iHA;
    private Bitmap iHB;
    private Bitmap iHC;
    private Bitmap iHD;
    private float iHE;
    private StaticLayout iHF;
    private int iHG;
    private boolean iHH;
    private ColorMatrixColorFilter iHI;
    private int iHa;
    private int iHb;
    private int iHc;
    private boolean iHd;
    private Drawable iHe;
    private Bitmap iHf;
    private int iHg;
    private int iHh;
    private boolean iHi;
    private int iHj;
    private boolean iHk;
    private String iHl;
    private String iHm;
    private int iHn;
    private int iHo;
    private boolean iHp;
    private int iHq;
    private boolean iHr;
    private int iHs;
    private boolean iHt;
    private boolean iHu;
    private boolean iHv;
    private Drawable iHw;
    private Bitmap iHx;
    private float iHy;
    private float iHz;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bZf = Color.parseColor("#33FFFFFF");
        this.iGV = a.f(context, 20.0f);
        this.iGW = a.f(context, 3.0f);
        this.iHa = a.f(context, 1.0f);
        this.iHb = -1;
        this.cET = a.f(context, 90.0f);
        this.iGX = a.f(context, 200.0f);
        this.iGZ = a.f(context, 140.0f);
        this.iHc = 0;
        this.iHd = false;
        this.iHe = null;
        this.iHf = null;
        this.iHg = a.f(context, 1.0f);
        this.GW = -1;
        this.iHh = 1000;
        this.iHi = false;
        this.iHj = 0;
        this.iHk = false;
        this.iGP = a.f(context, 2.0f);
        this.hue = null;
        this.iHn = a.e(context, 14.0f);
        this.iHo = -1;
        this.iHp = false;
        this.iHq = a.f(context, 20.0f);
        this.iHr = false;
        this.iHs = Color.parseColor("#22000000");
        this.iHt = false;
        this.iHu = false;
        this.iHv = false;
        this.iGU = new TextPaint();
        this.iGU.setAntiAlias(true);
        this.iHG = a.f(context, 4.0f);
        this.iHH = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.iHI = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cig();
        cif();
    }

    private void cif() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.iGV;
        options.outHeight = this.iGV;
        this.iGL = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iGM = Bitmap.createBitmap(this.iGL, 0, 0, this.iGL.getWidth(), this.iGL.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iGN = Bitmap.createBitmap(this.iGL, 0, 0, this.iGL.getWidth(), this.iGL.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.iGO = Bitmap.createBitmap(this.iGL, 0, 0, this.iGL.getWidth(), this.iGL.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cET = typedArray.getDimensionPixelSize(i, this.cET);
        } else if (i == 1) {
            this.iGW = typedArray.getDimensionPixelSize(i, this.iGW);
        } else if (i == 2) {
            this.iGV = typedArray.getDimensionPixelSize(i, this.iGV);
        } else if (i == 6) {
            this.iHa = typedArray.getDimensionPixelSize(i, this.iHa);
        } else if (i == 3) {
            this.iGX = typedArray.getDimensionPixelSize(i, this.iGX);
        } else if (i == 5) {
            this.bZf = typedArray.getColor(i, this.bZf);
        } else if (i == 7) {
            this.iHb = typedArray.getColor(i, this.iHb);
        } else if (i == 8) {
            this.iHc = typedArray.getDimensionPixelSize(i, this.iHc);
        } else if (i == 9) {
            this.iHd = typedArray.getBoolean(i, this.iHd);
        } else if (i == 10) {
            this.iHe = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.iHg = typedArray.getDimensionPixelSize(i, this.iHg);
        } else if (i == 12) {
            this.GW = typedArray.getColor(i, this.GW);
        } else if (i == 13) {
            this.iHh = typedArray.getInteger(i, this.iHh);
        } else if (i == 14) {
            this.iHi = typedArray.getBoolean(i, this.iHi);
        } else if (i == 15) {
            this.iHj = typedArray.getDimensionPixelSize(i, this.iHj);
        } else if (i == 4) {
            this.iGZ = typedArray.getDimensionPixelSize(i, this.iGZ);
        } else if (i == 16) {
            this.iHk = typedArray.getBoolean(i, this.iHk);
        } else if (i == 18) {
            this.iHm = typedArray.getString(i);
        } else if (i == 17) {
            this.iHl = typedArray.getString(i);
        } else if (i == 19) {
            this.iHn = typedArray.getDimensionPixelSize(i, this.iHn);
        } else if (i == 20) {
            this.iHo = typedArray.getColor(i, this.iHo);
        } else if (i == 21) {
            this.iHp = typedArray.getBoolean(i, this.iHp);
        } else if (i == 22) {
            this.iHq = typedArray.getDimensionPixelSize(i, this.iHq);
        } else if (i == 23) {
            this.iHr = typedArray.getBoolean(i, this.iHr);
        } else if (i == 24) {
            this.iHt = typedArray.getBoolean(i, this.iHt);
        } else if (i == 25) {
            this.iHs = typedArray.getColor(i, this.iHs);
        } else if (i == 26) {
            this.iHu = typedArray.getBoolean(i, this.iHu);
        } else if (i == 27) {
            this.iHv = typedArray.getBoolean(i, this.iHv);
        } else if (i == 28) {
            this.iHw = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.iHH = typedArray.getBoolean(i, this.iHH);
        }
    }

    private void cig() {
        if (this.iHw != null) {
            this.iHC = ((BitmapDrawable) this.iHw).getBitmap();
        }
        if (this.iHC == null) {
            this.iHC = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iHC = a.e(this.iHC, this.iHb);
        }
        this.iHD = a.adjustPhotoRotation(this.iHC, 90);
        this.iHD = a.adjustPhotoRotation(this.iHD, 90);
        this.iHD = a.adjustPhotoRotation(this.iHD, 90);
        if (this.iHe != null) {
            this.iHA = ((BitmapDrawable) this.iHe).getBitmap();
        }
        if (this.iHA == null) {
            this.iHA = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.iHA = a.e(this.iHA, this.iHb);
        }
        this.iHB = a.adjustPhotoRotation(this.iHA, 90);
        this.iHE = (1.0f * this.iGW) / 2.0f;
        this.iGU.setTextSize(this.iHn);
        this.iGU.setColor(this.iHo);
        setIsBarcode(this.iHk);
    }

    public void cih() {
        this.iGU.setColor(this.iHo);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.iGR != null) {
            V(canvas);
            W(canvas);
            Y(canvas);
            Z(canvas);
            X(canvas);
            cii();
        }
    }

    private void V(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bZf != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bZf);
            canvas.drawRect(0.0f, 0.0f, width, this.iGR.top, this.mPaint);
            canvas.drawRect(0.0f, this.iGR.top, this.iGR.left, this.iGR.bottom + 1, this.mPaint);
            canvas.drawRect(this.iGR.right + 1, this.iGR.top, width, this.iGR.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.iGR.bottom + 1, width, height, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        if (this.iHg > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.GW);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.iHg);
            canvas.drawRect(this.iGR, this.mPaint);
        }
    }

    private void X(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iGL, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iGM, getMainFrameRight() - this.iGL.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iGN, getMainFrameLeft(), getMainFrameBottom() - this.iGL.getHeight(), this.mPaint);
        canvas.drawBitmap(this.iGO, getMainFrameRight() - this.iGL.getWidth(), getMainFrameBottom() - this.iGL.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.iGR.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.iGR.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.iGR.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.iGR.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.iHg / 2;
    }

    private void Y(Canvas canvas) {
        if (this.iHk) {
            if (this.iHx != null) {
                RectF rectF = new RectF(this.iGR.left + this.iHE + 0.5f, this.iGR.top + this.iHE + this.iHc, this.iHz, (this.iGR.bottom - this.iHE) - this.iHc);
                Rect rect = new Rect((int) (this.iHx.getWidth() - rectF.width()), 0, this.iHx.getWidth(), this.iHx.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.iHx, rect, rectF, this.mPaint);
            } else if (this.iHf != null) {
                canvas.drawBitmap(this.iHf, (Rect) null, new RectF(this.iGT, this.iGR.top + this.iHE + this.iHc, this.iGT + this.iHf.getWidth(), (this.iGR.bottom - this.iHE) - this.iHc), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.iHb);
                canvas.drawRect(this.iGT, this.iHc + this.iGR.top + this.iHE, this.iHa + this.iGT, (this.iGR.bottom - this.iHE) - this.iHc, this.mPaint);
            }
        } else if (this.iHx != null) {
            RectF rectF2 = new RectF(this.iGR.left + this.iHE + this.iHc, this.iGR.top + this.iHE + 0.5f, (this.iGR.right - this.iHE) - this.iHc, this.iHy);
            Rect rect2 = new Rect(0, (int) (this.iHx.getHeight() - rectF2.height()), this.iHx.getWidth(), this.iHx.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.iHI);
            canvas.drawBitmap(this.iHx, rect2, rectF2, this.mPaint);
        } else if (this.iHf != null) {
            canvas.drawBitmap(this.iHf, (Rect) null, new RectF(this.iGR.left + this.iHE + this.iHc, this.iGS, (this.iGR.right - this.iHE) - this.iHc, this.iGS + this.iHf.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.iHb);
            canvas.drawRect(this.iHc + this.iGR.left + this.iHE, this.iGS, (this.iGR.right - this.iHE) - this.iHc, this.iHa + this.iGS, this.mPaint);
        }
    }

    private void Z(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hue) && this.iHF != null) {
            if (this.iHp) {
                if (this.iHt) {
                    this.mPaint.setColor(this.iHs);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.iHr) {
                        Rect rect = new Rect();
                        this.iGU.getTextBounds(this.hue, 0, this.hue.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.iHG;
                        canvas.drawRoundRect(new RectF(width, (this.iGR.bottom + this.iHq) - this.iHG, rect.width() + width + (this.iHG * 2), this.iGR.bottom + this.iHq + this.iHF.getHeight() + this.iHG), this.iHG, this.iHG, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.iGR.left, (this.iGR.bottom + this.iHq) - this.iHG, this.iGR.right, this.iGR.bottom + this.iHq + this.iHF.getHeight() + this.iHG), this.iHG, this.iHG, this.mPaint);
                    }
                }
                canvas.save();
                if (this.iHr) {
                    canvas.translate(0.0f, this.iGR.bottom + this.iHq);
                } else {
                    canvas.translate(this.iGR.left + this.iHG, this.iGR.bottom + this.iHq);
                }
                this.iHF.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.iHt) {
                this.mPaint.setColor(this.iHs);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.iHr) {
                    Rect rect2 = new Rect();
                    this.iGU.getTextBounds(this.hue, 0, this.hue.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.iHG;
                    canvas.drawRoundRect(new RectF(width2, ((this.iGR.top - this.iHq) - this.iHF.getHeight()) - this.iHG, rect2.width() + width2 + (this.iHG * 2), (this.iGR.top - this.iHq) + this.iHG), this.iHG, this.iHG, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.iGR.left, ((this.iGR.top - this.iHq) - this.iHF.getHeight()) - this.iHG, this.iGR.right, (this.iGR.top - this.iHq) + this.iHG), this.iHG, this.iHG, this.mPaint);
                }
            }
            canvas.save();
            if (this.iHr) {
                canvas.translate(0.0f, (this.iGR.top - this.iHq) - this.iHF.getHeight());
            } else {
                canvas.translate(this.iGR.left + this.iHG, (this.iGR.top - this.iHq) - this.iHF.getHeight());
            }
            this.iHF.draw(canvas);
            canvas.restore();
        }
    }

    private void cii() {
        if (this.iHk) {
            if (this.iHx == null) {
                this.iGT += this.iGP;
                int i = this.iHa;
                if (this.iHf != null) {
                    i = this.iHf.getWidth();
                }
                if (this.iHu) {
                    if (i + this.iGT > this.iGR.right - this.iHE || this.iGT < this.iGR.left + this.iHE) {
                        this.iGP = -this.iGP;
                    }
                } else {
                    if (i + this.iGT > this.iGR.right - this.iHE) {
                        this.iGT = this.iGR.left + this.iHE + 0.5f;
                    }
                }
            } else {
                this.iHz += this.iGP;
                if (this.iHz > this.iGR.right - this.iHE) {
                    this.iHz = this.iGR.left + this.iHE + 0.5f;
                }
            }
        } else if (this.iHx == null) {
            this.iGS += this.iGP;
            int i2 = this.iHa;
            if (this.iHf != null) {
                i2 = this.iHf.getHeight();
            }
            if (this.iHu) {
                if (i2 + this.iGS > this.iGR.bottom - this.iHE || this.iGS < this.iGR.top + this.iHE) {
                    this.iGP = -this.iGP;
                }
            } else {
                if (i2 + this.iGS > this.iGR.bottom - this.iHE) {
                    this.iGS = this.iGR.top + this.iHE + 0.5f;
                }
            }
        } else {
            this.iHy += this.iGP;
            if (this.iHy > this.iGR.bottom - this.iHE) {
                this.iHy = this.iGR.top + this.iHE + 0.5f;
            }
        }
        postInvalidateDelayed(this.iGQ, this.iGR.left, this.iGR.top, this.iGR.right, this.iGR.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cij();
    }

    private void cij() {
        int i;
        if (this.iHk) {
            i = this.cET + this.iHj;
        } else {
            i = this.cET;
        }
        int width = (getWidth() - this.iGX) / 2;
        this.iGR = new Rect(width, i, this.iGX + width, this.iGY + i);
        if (this.iHk) {
            float f = this.iGR.left + this.iHE + 0.5f;
            this.iGT = f;
            this.iHz = f;
            return;
        }
        float f2 = this.iGR.top + this.iHE + 0.5f;
        this.iGS = f2;
        this.iHy = f2;
    }

    public Rect zy(int i) {
        if (this.iHH) {
            Rect rect = new Rect(this.iGR);
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
        this.iHk = z;
        if (this.iHw != null || this.iHv) {
            if (this.iHk) {
                this.iHx = this.iHD;
            } else {
                this.iHx = this.iHC;
            }
        } else if (this.iHe != null || this.iHd) {
            if (this.iHk) {
                this.iHf = this.iHB;
            } else {
                this.iHf = this.iHA;
            }
        }
        if (this.iHk) {
            this.hue = this.iHm;
            this.iGY = this.iGZ;
            this.iGQ = (int) (((this.iHh * 1.0f) * this.iGP) / this.iGX);
        } else {
            this.hue = this.iHl;
            this.iGY = this.iGX;
            this.iGQ = (int) (((this.iHh * 1.0f) * this.iGP) / this.iGY);
        }
        if (!TextUtils.isEmpty(this.hue)) {
            if (this.iHr) {
                this.iHF = new StaticLayout(this.hue, this.iGU, a.ei(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.iHF = new StaticLayout(this.hue, this.iGU, this.iGX - (this.iHG * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.iHi) {
            int i = a.ei(getContext()).y;
            if (this.iHj == 0) {
                this.cET = (i - this.iGY) / 2;
            } else if (this.iHk) {
                this.cET = ((i - this.iGY) / 2) + (this.iHj / 2);
            } else {
                this.cET = (i - this.iGY) / 2;
            }
        }
        cij();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.iHk;
    }

    public int getMaskColor() {
        return this.bZf;
    }

    public void setMaskColor(int i) {
        this.bZf = i;
    }

    public int getCornerLength() {
        return this.iGV;
    }

    public void setCornerLength(int i) {
        this.iGV = i;
    }

    public int getCornerSize() {
        return this.iGW;
    }

    public void setCornerSize(int i) {
        this.iGW = i;
    }

    public int getRectWidth() {
        return this.iGX;
    }

    public void setRectWidth(int i) {
        this.iGX = i;
    }

    public int getRectHeight() {
        return this.iGY;
    }

    public void setRectHeight(int i) {
        this.iGY = i;
    }

    public int getBarcodeRectHeight() {
        return this.iGZ;
    }

    public void setBarcodeRectHeight(int i) {
        this.iGZ = i;
    }

    public int getTopOffset() {
        return this.cET;
    }

    public void setTopOffset(int i) {
        this.cET = i;
    }

    public int getScanLineSize() {
        return this.iHa;
    }

    public void setScanLineSize(int i) {
        this.iHa = i;
    }

    public int getScanLineColor() {
        return this.iHb;
    }

    public void setScanLineColor(int i) {
        this.iHb = i;
    }

    public int getScanLineMargin() {
        return this.iHc;
    }

    public void setScanLineMargin(int i) {
        this.iHc = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.iHd = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.iHe;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.iHe = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.iHf;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.iHf = bitmap;
    }

    public int getBorderSize() {
        return this.iHg;
    }

    public void setBorderSize(int i) {
        this.iHg = i;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public void setBorderColor(int i) {
        this.GW = i;
    }

    public int getAnimTime() {
        return this.iHh;
    }

    public void setAnimTime(int i) {
        this.iHh = i;
    }

    public void setCenterVertical(boolean z) {
        this.iHi = z;
    }

    public int getToolbarHeight() {
        return this.iHj;
    }

    public void setToolbarHeight(int i) {
        this.iHj = i;
    }

    public String getQRCodeTipText() {
        return this.iHl;
    }

    public void setQRCodeTipText(String str) {
        this.iHl = str;
    }

    public String getBarCodeTipText() {
        return this.iHm;
    }

    public void setBarCodeTipText(String str) {
        this.iHm = str;
    }

    public String getTipText() {
        return this.hue;
    }

    public void setTipText(String str) {
        this.hue = str;
    }

    public int getTipTextColor() {
        return this.iHo;
    }

    public void setTipTextColor(int i) {
        this.iHo = i;
    }

    public int getTipTextSize() {
        return this.iHn;
    }

    public void setTipTextSize(int i) {
        this.iHn = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.iHp = z;
    }

    public int getTipTextMargin() {
        return this.iHq;
    }

    public void setTipTextMargin(int i) {
        this.iHq = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.iHr = z;
    }

    public void setShowTipBackground(boolean z) {
        this.iHt = z;
    }

    public int getTipBackgroundColor() {
        return this.iHs;
    }

    public void setTipBackgroundColor(int i) {
        this.iHs = i;
    }

    public void setScanLineReverse(boolean z) {
        this.iHu = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.iHv = z;
    }

    public float getHalfCornerSize() {
        return this.iHE;
    }

    public void setHalfCornerSize(float f) {
        this.iHE = f;
    }

    public StaticLayout getTipTextSl() {
        return this.iHF;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.iHF = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.iHG;
    }

    public void setTipBackgroundRadius(int i) {
        this.iHG = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.iHH = z;
    }
}
