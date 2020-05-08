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
    private int byI;
    private String iXF;
    private Bitmap koS;
    private Bitmap koT;
    private Bitmap koU;
    private Bitmap koV;
    private int koW;
    private int koX;
    private Rect koY;
    private float koZ;
    private boolean kpA;
    private boolean kpB;
    private Drawable kpC;
    private Bitmap kpD;
    private float kpE;
    private float kpF;
    private Bitmap kpG;
    private Bitmap kpH;
    private Bitmap kpI;
    private Bitmap kpJ;
    private float kpK;
    private StaticLayout kpL;
    private int kpM;
    private boolean kpN;
    private ColorMatrixColorFilter kpO;
    private float kpa;
    private TextPaint kpb;
    private int kpc;
    private int kpd;
    private int kpe;
    private int kpf;
    private int kpg;
    private int kph;
    private int kpi;
    private boolean kpj;
    private Drawable kpk;
    private Bitmap kpl;
    private int kpm;
    private int kpn;
    private boolean kpo;
    private int kpp;
    private boolean kpq;
    private String kpr;
    private String kps;
    private int kpt;
    private int kpu;
    private boolean kpv;
    private int kpw;
    private boolean kpx;
    private int kpy;
    private boolean kpz;
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
        this.kpc = a.dp2px(context, 20.0f);
        this.kpd = a.dp2px(context, 3.0f);
        this.kpg = a.dp2px(context, 1.0f);
        this.kph = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.byI = a.dp2px(context, 200.0f);
        this.kpf = a.dp2px(context, 140.0f);
        this.kpi = 0;
        this.kpj = false;
        this.kpk = null;
        this.kpl = null;
        this.kpm = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.kpn = 1000;
        this.kpo = false;
        this.kpp = 0;
        this.kpq = false;
        this.koW = a.dp2px(context, 2.0f);
        this.iXF = null;
        this.kpt = a.h(context, 14.0f);
        this.kpu = -1;
        this.kpv = false;
        this.kpw = a.dp2px(context, 20.0f);
        this.kpx = false;
        this.kpy = Color.parseColor("#22000000");
        this.kpz = false;
        this.kpA = false;
        this.kpB = false;
        this.kpb = new TextPaint();
        this.kpb.setAntiAlias(true);
        this.kpM = a.dp2px(context, 4.0f);
        this.kpN = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.kpO = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cMG();
        cMF();
    }

    private void cMF() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.kpc;
        options.outHeight = this.kpc;
        this.koS = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.koT = Bitmap.createBitmap(this.koS, 0, 0, this.koS.getWidth(), this.koS.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.koU = Bitmap.createBitmap(this.koS, 0, 0, this.koS.getWidth(), this.koS.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.koV = Bitmap.createBitmap(this.koS, 0, 0, this.koS.getWidth(), this.koS.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.kpd = typedArray.getDimensionPixelSize(i, this.kpd);
        } else if (i == 2) {
            this.kpc = typedArray.getDimensionPixelSize(i, this.kpc);
        } else if (i == 6) {
            this.kpg = typedArray.getDimensionPixelSize(i, this.kpg);
        } else if (i == 3) {
            this.byI = typedArray.getDimensionPixelSize(i, this.byI);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.kph = typedArray.getColor(i, this.kph);
        } else if (i == 8) {
            this.kpi = typedArray.getDimensionPixelSize(i, this.kpi);
        } else if (i == 9) {
            this.kpj = typedArray.getBoolean(i, this.kpj);
        } else if (i == 10) {
            this.kpk = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.kpm = typedArray.getDimensionPixelSize(i, this.kpm);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.kpn = typedArray.getInteger(i, this.kpn);
        } else if (i == 14) {
            this.kpo = typedArray.getBoolean(i, this.kpo);
        } else if (i == 15) {
            this.kpp = typedArray.getDimensionPixelSize(i, this.kpp);
        } else if (i == 4) {
            this.kpf = typedArray.getDimensionPixelSize(i, this.kpf);
        } else if (i == 16) {
            this.kpq = typedArray.getBoolean(i, this.kpq);
        } else if (i == 18) {
            this.kps = typedArray.getString(i);
        } else if (i == 17) {
            this.kpr = typedArray.getString(i);
        } else if (i == 19) {
            this.kpt = typedArray.getDimensionPixelSize(i, this.kpt);
        } else if (i == 20) {
            this.kpu = typedArray.getColor(i, this.kpu);
        } else if (i == 21) {
            this.kpv = typedArray.getBoolean(i, this.kpv);
        } else if (i == 22) {
            this.kpw = typedArray.getDimensionPixelSize(i, this.kpw);
        } else if (i == 23) {
            this.kpx = typedArray.getBoolean(i, this.kpx);
        } else if (i == 24) {
            this.kpz = typedArray.getBoolean(i, this.kpz);
        } else if (i == 25) {
            this.kpy = typedArray.getColor(i, this.kpy);
        } else if (i == 26) {
            this.kpA = typedArray.getBoolean(i, this.kpA);
        } else if (i == 27) {
            this.kpB = typedArray.getBoolean(i, this.kpB);
        } else if (i == 28) {
            this.kpC = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.kpN = typedArray.getBoolean(i, this.kpN);
        }
    }

    private void cMG() {
        if (this.kpC != null) {
            this.kpI = ((BitmapDrawable) this.kpC).getBitmap();
        }
        if (this.kpI == null) {
            this.kpI = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kpI = a.e(this.kpI, this.kph);
        }
        this.kpJ = a.adjustPhotoRotation(this.kpI, 90);
        this.kpJ = a.adjustPhotoRotation(this.kpJ, 90);
        this.kpJ = a.adjustPhotoRotation(this.kpJ, 90);
        if (this.kpk != null) {
            this.kpG = ((BitmapDrawable) this.kpk).getBitmap();
        }
        if (this.kpG == null) {
            this.kpG = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kpG = a.e(this.kpG, this.kph);
        }
        this.kpH = a.adjustPhotoRotation(this.kpG, 90);
        this.kpK = (1.0f * this.kpd) / 2.0f;
        this.kpb.setTextSize(this.kpt);
        this.kpb.setColor(this.kpu);
        setIsBarcode(this.kpq);
    }

    public void cMH() {
        this.kpb.setColor(this.kpu);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.koY != null) {
            S(canvas);
            T(canvas);
            V(canvas);
            W(canvas);
            U(canvas);
            cMI();
        }
    }

    private void S(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.koY.top, this.mPaint);
            canvas.drawRect(0.0f, this.koY.top, this.koY.left, this.koY.bottom + 1, this.mPaint);
            canvas.drawRect(this.koY.right + 1, this.koY.top, width, this.koY.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.koY.bottom + 1, width, height, this.mPaint);
        }
    }

    private void T(Canvas canvas) {
        if (this.kpm > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.kpm);
            canvas.drawRect(this.koY, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.koS, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.koT, getMainFrameRight() - this.koS.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.koU, getMainFrameLeft(), getMainFrameBottom() - this.koS.getHeight(), this.mPaint);
        canvas.drawBitmap(this.koV, getMainFrameRight() - this.koS.getWidth(), getMainFrameBottom() - this.koS.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.koY.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.koY.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.koY.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.koY.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.kpm / 2;
    }

    private void V(Canvas canvas) {
        if (this.kpq) {
            if (this.kpD != null) {
                RectF rectF = new RectF(this.koY.left + this.kpK + 0.5f, this.koY.top + this.kpK + this.kpi, this.kpF, (this.koY.bottom - this.kpK) - this.kpi);
                Rect rect = new Rect((int) (this.kpD.getWidth() - rectF.width()), 0, this.kpD.getWidth(), this.kpD.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.kpD, rect, rectF, this.mPaint);
            } else if (this.kpl != null) {
                canvas.drawBitmap(this.kpl, (Rect) null, new RectF(this.kpa, this.koY.top + this.kpK + this.kpi, this.kpa + this.kpl.getWidth(), (this.koY.bottom - this.kpK) - this.kpi), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.kph);
                canvas.drawRect(this.kpa, this.kpi + this.koY.top + this.kpK, this.kpg + this.kpa, (this.koY.bottom - this.kpK) - this.kpi, this.mPaint);
            }
        } else if (this.kpD != null) {
            RectF rectF2 = new RectF(this.koY.left + this.kpK + this.kpi, this.koY.top + this.kpK + 0.5f, (this.koY.right - this.kpK) - this.kpi, this.kpE);
            Rect rect2 = new Rect(0, (int) (this.kpD.getHeight() - rectF2.height()), this.kpD.getWidth(), this.kpD.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.kpO);
            canvas.drawBitmap(this.kpD, rect2, rectF2, this.mPaint);
        } else if (this.kpl != null) {
            canvas.drawBitmap(this.kpl, (Rect) null, new RectF(this.koY.left + this.kpK + this.kpi, this.koZ, (this.koY.right - this.kpK) - this.kpi, this.koZ + this.kpl.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.kph);
            canvas.drawRect(this.kpi + this.koY.left + this.kpK, this.koZ, (this.koY.right - this.kpK) - this.kpi, this.kpg + this.koZ, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        if (!TextUtils.isEmpty(this.iXF) && this.kpL != null) {
            if (this.kpv) {
                if (this.kpz) {
                    this.mPaint.setColor(this.kpy);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.kpx) {
                        Rect rect = new Rect();
                        this.kpb.getTextBounds(this.iXF, 0, this.iXF.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.kpM;
                        canvas.drawRoundRect(new RectF(width, (this.koY.bottom + this.kpw) - this.kpM, rect.width() + width + (this.kpM * 2), this.koY.bottom + this.kpw + this.kpL.getHeight() + this.kpM), this.kpM, this.kpM, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.koY.left, (this.koY.bottom + this.kpw) - this.kpM, this.koY.right, this.koY.bottom + this.kpw + this.kpL.getHeight() + this.kpM), this.kpM, this.kpM, this.mPaint);
                    }
                }
                canvas.save();
                if (this.kpx) {
                    canvas.translate(0.0f, this.koY.bottom + this.kpw);
                } else {
                    canvas.translate(this.koY.left + this.kpM, this.koY.bottom + this.kpw);
                }
                this.kpL.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.kpz) {
                this.mPaint.setColor(this.kpy);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.kpx) {
                    Rect rect2 = new Rect();
                    this.kpb.getTextBounds(this.iXF, 0, this.iXF.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.kpM;
                    canvas.drawRoundRect(new RectF(width2, ((this.koY.top - this.kpw) - this.kpL.getHeight()) - this.kpM, rect2.width() + width2 + (this.kpM * 2), (this.koY.top - this.kpw) + this.kpM), this.kpM, this.kpM, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.koY.left, ((this.koY.top - this.kpw) - this.kpL.getHeight()) - this.kpM, this.koY.right, (this.koY.top - this.kpw) + this.kpM), this.kpM, this.kpM, this.mPaint);
                }
            }
            canvas.save();
            if (this.kpx) {
                canvas.translate(0.0f, (this.koY.top - this.kpw) - this.kpL.getHeight());
            } else {
                canvas.translate(this.koY.left + this.kpM, (this.koY.top - this.kpw) - this.kpL.getHeight());
            }
            this.kpL.draw(canvas);
            canvas.restore();
        }
    }

    private void cMI() {
        if (this.kpq) {
            if (this.kpD == null) {
                this.kpa += this.koW;
                int i = this.kpg;
                if (this.kpl != null) {
                    i = this.kpl.getWidth();
                }
                if (this.kpA) {
                    if (i + this.kpa > this.koY.right - this.kpK || this.kpa < this.koY.left + this.kpK) {
                        this.koW = -this.koW;
                    }
                } else {
                    if (i + this.kpa > this.koY.right - this.kpK) {
                        this.kpa = this.koY.left + this.kpK + 0.5f;
                    }
                }
            } else {
                this.kpF += this.koW;
                if (this.kpF > this.koY.right - this.kpK) {
                    this.kpF = this.koY.left + this.kpK + 0.5f;
                }
            }
        } else if (this.kpD == null) {
            this.koZ += this.koW;
            int i2 = this.kpg;
            if (this.kpl != null) {
                i2 = this.kpl.getHeight();
            }
            if (this.kpA) {
                if (i2 + this.koZ > this.koY.bottom - this.kpK || this.koZ < this.koY.top + this.kpK) {
                    this.koW = -this.koW;
                }
            } else {
                if (i2 + this.koZ > this.koY.bottom - this.kpK) {
                    this.koZ = this.koY.top + this.kpK + 0.5f;
                }
            }
        } else {
            this.kpE += this.koW;
            if (this.kpE > this.koY.bottom - this.kpK) {
                this.kpE = this.koY.top + this.kpK + 0.5f;
            }
        }
        postInvalidateDelayed(this.koX, this.koY.left, this.koY.top, this.koY.right, this.koY.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cMJ();
    }

    private void cMJ() {
        int i;
        if (this.kpq) {
            i = this.mTopOffset + this.kpp;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.byI) / 2;
        this.koY = new Rect(width, i, this.byI + width, this.kpe + i);
        if (this.kpq) {
            float f = this.koY.left + this.kpK + 0.5f;
            this.kpa = f;
            this.kpF = f;
            return;
        }
        float f2 = this.koY.top + this.kpK + 0.5f;
        this.koZ = f2;
        this.kpE = f2;
    }

    public Rect Bu(int i) {
        if (this.kpN) {
            Rect rect = new Rect(this.koY);
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
        this.kpq = z;
        if (this.kpC != null || this.kpB) {
            if (this.kpq) {
                this.kpD = this.kpJ;
            } else {
                this.kpD = this.kpI;
            }
        } else if (this.kpk != null || this.kpj) {
            if (this.kpq) {
                this.kpl = this.kpH;
            } else {
                this.kpl = this.kpG;
            }
        }
        if (this.kpq) {
            this.iXF = this.kps;
            this.kpe = this.kpf;
            this.koX = (int) (((this.kpn * 1.0f) * this.koW) / this.byI);
        } else {
            this.iXF = this.kpr;
            this.kpe = this.byI;
            this.koX = (int) (((this.kpn * 1.0f) * this.koW) / this.kpe);
        }
        if (!TextUtils.isEmpty(this.iXF)) {
            if (this.kpx) {
                this.kpL = new StaticLayout(this.iXF, this.kpb, a.eR(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.kpL = new StaticLayout(this.iXF, this.kpb, this.byI - (this.kpM * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.kpo) {
            int i = a.eR(getContext()).y;
            if (this.kpp == 0) {
                this.mTopOffset = (i - this.kpe) / 2;
            } else if (this.kpq) {
                this.mTopOffset = ((i - this.kpe) / 2) + (this.kpp / 2);
            } else {
                this.mTopOffset = (i - this.kpe) / 2;
            }
        }
        cMJ();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.kpq;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.kpc;
    }

    public void setCornerLength(int i) {
        this.kpc = i;
    }

    public int getCornerSize() {
        return this.kpd;
    }

    public void setCornerSize(int i) {
        this.kpd = i;
    }

    public int getRectWidth() {
        return this.byI;
    }

    public void setRectWidth(int i) {
        this.byI = i;
    }

    public int getRectHeight() {
        return this.kpe;
    }

    public void setRectHeight(int i) {
        this.kpe = i;
    }

    public int getBarcodeRectHeight() {
        return this.kpf;
    }

    public void setBarcodeRectHeight(int i) {
        this.kpf = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.kpg;
    }

    public void setScanLineSize(int i) {
        this.kpg = i;
    }

    public int getScanLineColor() {
        return this.kph;
    }

    public void setScanLineColor(int i) {
        this.kph = i;
    }

    public int getScanLineMargin() {
        return this.kpi;
    }

    public void setScanLineMargin(int i) {
        this.kpi = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.kpj = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.kpk;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.kpk = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.kpl;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.kpl = bitmap;
    }

    public int getBorderSize() {
        return this.kpm;
    }

    public void setBorderSize(int i) {
        this.kpm = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.kpn;
    }

    public void setAnimTime(int i) {
        this.kpn = i;
    }

    public void setCenterVertical(boolean z) {
        this.kpo = z;
    }

    public int getToolbarHeight() {
        return this.kpp;
    }

    public void setToolbarHeight(int i) {
        this.kpp = i;
    }

    public String getQRCodeTipText() {
        return this.kpr;
    }

    public void setQRCodeTipText(String str) {
        this.kpr = str;
    }

    public String getBarCodeTipText() {
        return this.kps;
    }

    public void setBarCodeTipText(String str) {
        this.kps = str;
    }

    public String getTipText() {
        return this.iXF;
    }

    public void setTipText(String str) {
        this.iXF = str;
    }

    public int getTipTextColor() {
        return this.kpu;
    }

    public void setTipTextColor(int i) {
        this.kpu = i;
    }

    public int getTipTextSize() {
        return this.kpt;
    }

    public void setTipTextSize(int i) {
        this.kpt = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.kpv = z;
    }

    public int getTipTextMargin() {
        return this.kpw;
    }

    public void setTipTextMargin(int i) {
        this.kpw = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.kpx = z;
    }

    public void setShowTipBackground(boolean z) {
        this.kpz = z;
    }

    public int getTipBackgroundColor() {
        return this.kpy;
    }

    public void setTipBackgroundColor(int i) {
        this.kpy = i;
    }

    public void setScanLineReverse(boolean z) {
        this.kpA = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.kpB = z;
    }

    public float getHalfCornerSize() {
        return this.kpK;
    }

    public void setHalfCornerSize(float f) {
        this.kpK = f;
    }

    public StaticLayout getTipTextSl() {
        return this.kpL;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.kpL = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.kpM;
    }

    public void setTipBackgroundRadius(int i) {
        this.kpM = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.kpN = z;
    }
}
