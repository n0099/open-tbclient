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
    private int byD;
    private String iXB;
    private Bitmap koO;
    private Bitmap koP;
    private Bitmap koQ;
    private Bitmap koR;
    private int koS;
    private int koT;
    private Rect koU;
    private float koV;
    private float koW;
    private TextPaint koX;
    private int koY;
    private int koZ;
    private float kpA;
    private float kpB;
    private Bitmap kpC;
    private Bitmap kpD;
    private Bitmap kpE;
    private Bitmap kpF;
    private float kpG;
    private StaticLayout kpH;
    private int kpI;
    private boolean kpJ;
    private ColorMatrixColorFilter kpK;
    private int kpa;
    private int kpb;
    private int kpc;
    private int kpd;
    private int kpe;
    private boolean kpf;
    private Drawable kpg;
    private Bitmap kph;
    private int kpi;
    private int kpj;
    private boolean kpk;
    private int kpl;
    private boolean kpm;
    private String kpn;
    private String kpo;
    private int kpp;
    private int kpq;
    private boolean kpr;
    private int kps;
    private boolean kpt;
    private int kpu;
    private boolean kpv;
    private boolean kpw;
    private boolean kpx;
    private Drawable kpy;
    private Bitmap kpz;
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
        this.koY = a.dp2px(context, 20.0f);
        this.koZ = a.dp2px(context, 3.0f);
        this.kpc = a.dp2px(context, 1.0f);
        this.kpd = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.byD = a.dp2px(context, 200.0f);
        this.kpb = a.dp2px(context, 140.0f);
        this.kpe = 0;
        this.kpf = false;
        this.kpg = null;
        this.kph = null;
        this.kpi = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.kpj = 1000;
        this.kpk = false;
        this.kpl = 0;
        this.kpm = false;
        this.koS = a.dp2px(context, 2.0f);
        this.iXB = null;
        this.kpp = a.h(context, 14.0f);
        this.kpq = -1;
        this.kpr = false;
        this.kps = a.dp2px(context, 20.0f);
        this.kpt = false;
        this.kpu = Color.parseColor("#22000000");
        this.kpv = false;
        this.kpw = false;
        this.kpx = false;
        this.koX = new TextPaint();
        this.koX.setAntiAlias(true);
        this.kpI = a.dp2px(context, 4.0f);
        this.kpJ = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.kpK = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cMJ();
        cMI();
    }

    private void cMI() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.koY;
        options.outHeight = this.koY;
        this.koO = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.koP = Bitmap.createBitmap(this.koO, 0, 0, this.koO.getWidth(), this.koO.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.koQ = Bitmap.createBitmap(this.koO, 0, 0, this.koO.getWidth(), this.koO.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.koR = Bitmap.createBitmap(this.koO, 0, 0, this.koO.getWidth(), this.koO.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.koZ = typedArray.getDimensionPixelSize(i, this.koZ);
        } else if (i == 2) {
            this.koY = typedArray.getDimensionPixelSize(i, this.koY);
        } else if (i == 6) {
            this.kpc = typedArray.getDimensionPixelSize(i, this.kpc);
        } else if (i == 3) {
            this.byD = typedArray.getDimensionPixelSize(i, this.byD);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.kpd = typedArray.getColor(i, this.kpd);
        } else if (i == 8) {
            this.kpe = typedArray.getDimensionPixelSize(i, this.kpe);
        } else if (i == 9) {
            this.kpf = typedArray.getBoolean(i, this.kpf);
        } else if (i == 10) {
            this.kpg = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.kpi = typedArray.getDimensionPixelSize(i, this.kpi);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.kpj = typedArray.getInteger(i, this.kpj);
        } else if (i == 14) {
            this.kpk = typedArray.getBoolean(i, this.kpk);
        } else if (i == 15) {
            this.kpl = typedArray.getDimensionPixelSize(i, this.kpl);
        } else if (i == 4) {
            this.kpb = typedArray.getDimensionPixelSize(i, this.kpb);
        } else if (i == 16) {
            this.kpm = typedArray.getBoolean(i, this.kpm);
        } else if (i == 18) {
            this.kpo = typedArray.getString(i);
        } else if (i == 17) {
            this.kpn = typedArray.getString(i);
        } else if (i == 19) {
            this.kpp = typedArray.getDimensionPixelSize(i, this.kpp);
        } else if (i == 20) {
            this.kpq = typedArray.getColor(i, this.kpq);
        } else if (i == 21) {
            this.kpr = typedArray.getBoolean(i, this.kpr);
        } else if (i == 22) {
            this.kps = typedArray.getDimensionPixelSize(i, this.kps);
        } else if (i == 23) {
            this.kpt = typedArray.getBoolean(i, this.kpt);
        } else if (i == 24) {
            this.kpv = typedArray.getBoolean(i, this.kpv);
        } else if (i == 25) {
            this.kpu = typedArray.getColor(i, this.kpu);
        } else if (i == 26) {
            this.kpw = typedArray.getBoolean(i, this.kpw);
        } else if (i == 27) {
            this.kpx = typedArray.getBoolean(i, this.kpx);
        } else if (i == 28) {
            this.kpy = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.kpJ = typedArray.getBoolean(i, this.kpJ);
        }
    }

    private void cMJ() {
        if (this.kpy != null) {
            this.kpE = ((BitmapDrawable) this.kpy).getBitmap();
        }
        if (this.kpE == null) {
            this.kpE = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kpE = a.e(this.kpE, this.kpd);
        }
        this.kpF = a.adjustPhotoRotation(this.kpE, 90);
        this.kpF = a.adjustPhotoRotation(this.kpF, 90);
        this.kpF = a.adjustPhotoRotation(this.kpF, 90);
        if (this.kpg != null) {
            this.kpC = ((BitmapDrawable) this.kpg).getBitmap();
        }
        if (this.kpC == null) {
            this.kpC = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.kpC = a.e(this.kpC, this.kpd);
        }
        this.kpD = a.adjustPhotoRotation(this.kpC, 90);
        this.kpG = (1.0f * this.koZ) / 2.0f;
        this.koX.setTextSize(this.kpp);
        this.koX.setColor(this.kpq);
        setIsBarcode(this.kpm);
    }

    public void cMK() {
        this.koX.setColor(this.kpq);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.koU != null) {
            S(canvas);
            T(canvas);
            V(canvas);
            W(canvas);
            U(canvas);
            cML();
        }
    }

    private void S(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.koU.top, this.mPaint);
            canvas.drawRect(0.0f, this.koU.top, this.koU.left, this.koU.bottom + 1, this.mPaint);
            canvas.drawRect(this.koU.right + 1, this.koU.top, width, this.koU.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.koU.bottom + 1, width, height, this.mPaint);
        }
    }

    private void T(Canvas canvas) {
        if (this.kpi > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.kpi);
            canvas.drawRect(this.koU, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.koO, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.koP, getMainFrameRight() - this.koO.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.koQ, getMainFrameLeft(), getMainFrameBottom() - this.koO.getHeight(), this.mPaint);
        canvas.drawBitmap(this.koR, getMainFrameRight() - this.koO.getWidth(), getMainFrameBottom() - this.koO.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.koU.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.koU.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.koU.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.koU.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.kpi / 2;
    }

    private void V(Canvas canvas) {
        if (this.kpm) {
            if (this.kpz != null) {
                RectF rectF = new RectF(this.koU.left + this.kpG + 0.5f, this.koU.top + this.kpG + this.kpe, this.kpB, (this.koU.bottom - this.kpG) - this.kpe);
                Rect rect = new Rect((int) (this.kpz.getWidth() - rectF.width()), 0, this.kpz.getWidth(), this.kpz.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.kpz, rect, rectF, this.mPaint);
            } else if (this.kph != null) {
                canvas.drawBitmap(this.kph, (Rect) null, new RectF(this.koW, this.koU.top + this.kpG + this.kpe, this.koW + this.kph.getWidth(), (this.koU.bottom - this.kpG) - this.kpe), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.kpd);
                canvas.drawRect(this.koW, this.kpe + this.koU.top + this.kpG, this.kpc + this.koW, (this.koU.bottom - this.kpG) - this.kpe, this.mPaint);
            }
        } else if (this.kpz != null) {
            RectF rectF2 = new RectF(this.koU.left + this.kpG + this.kpe, this.koU.top + this.kpG + 0.5f, (this.koU.right - this.kpG) - this.kpe, this.kpA);
            Rect rect2 = new Rect(0, (int) (this.kpz.getHeight() - rectF2.height()), this.kpz.getWidth(), this.kpz.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.kpK);
            canvas.drawBitmap(this.kpz, rect2, rectF2, this.mPaint);
        } else if (this.kph != null) {
            canvas.drawBitmap(this.kph, (Rect) null, new RectF(this.koU.left + this.kpG + this.kpe, this.koV, (this.koU.right - this.kpG) - this.kpe, this.koV + this.kph.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.kpd);
            canvas.drawRect(this.kpe + this.koU.left + this.kpG, this.koV, (this.koU.right - this.kpG) - this.kpe, this.kpc + this.koV, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        if (!TextUtils.isEmpty(this.iXB) && this.kpH != null) {
            if (this.kpr) {
                if (this.kpv) {
                    this.mPaint.setColor(this.kpu);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.kpt) {
                        Rect rect = new Rect();
                        this.koX.getTextBounds(this.iXB, 0, this.iXB.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.kpI;
                        canvas.drawRoundRect(new RectF(width, (this.koU.bottom + this.kps) - this.kpI, rect.width() + width + (this.kpI * 2), this.koU.bottom + this.kps + this.kpH.getHeight() + this.kpI), this.kpI, this.kpI, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.koU.left, (this.koU.bottom + this.kps) - this.kpI, this.koU.right, this.koU.bottom + this.kps + this.kpH.getHeight() + this.kpI), this.kpI, this.kpI, this.mPaint);
                    }
                }
                canvas.save();
                if (this.kpt) {
                    canvas.translate(0.0f, this.koU.bottom + this.kps);
                } else {
                    canvas.translate(this.koU.left + this.kpI, this.koU.bottom + this.kps);
                }
                this.kpH.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.kpv) {
                this.mPaint.setColor(this.kpu);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.kpt) {
                    Rect rect2 = new Rect();
                    this.koX.getTextBounds(this.iXB, 0, this.iXB.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.kpI;
                    canvas.drawRoundRect(new RectF(width2, ((this.koU.top - this.kps) - this.kpH.getHeight()) - this.kpI, rect2.width() + width2 + (this.kpI * 2), (this.koU.top - this.kps) + this.kpI), this.kpI, this.kpI, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.koU.left, ((this.koU.top - this.kps) - this.kpH.getHeight()) - this.kpI, this.koU.right, (this.koU.top - this.kps) + this.kpI), this.kpI, this.kpI, this.mPaint);
                }
            }
            canvas.save();
            if (this.kpt) {
                canvas.translate(0.0f, (this.koU.top - this.kps) - this.kpH.getHeight());
            } else {
                canvas.translate(this.koU.left + this.kpI, (this.koU.top - this.kps) - this.kpH.getHeight());
            }
            this.kpH.draw(canvas);
            canvas.restore();
        }
    }

    private void cML() {
        if (this.kpm) {
            if (this.kpz == null) {
                this.koW += this.koS;
                int i = this.kpc;
                if (this.kph != null) {
                    i = this.kph.getWidth();
                }
                if (this.kpw) {
                    if (i + this.koW > this.koU.right - this.kpG || this.koW < this.koU.left + this.kpG) {
                        this.koS = -this.koS;
                    }
                } else {
                    if (i + this.koW > this.koU.right - this.kpG) {
                        this.koW = this.koU.left + this.kpG + 0.5f;
                    }
                }
            } else {
                this.kpB += this.koS;
                if (this.kpB > this.koU.right - this.kpG) {
                    this.kpB = this.koU.left + this.kpG + 0.5f;
                }
            }
        } else if (this.kpz == null) {
            this.koV += this.koS;
            int i2 = this.kpc;
            if (this.kph != null) {
                i2 = this.kph.getHeight();
            }
            if (this.kpw) {
                if (i2 + this.koV > this.koU.bottom - this.kpG || this.koV < this.koU.top + this.kpG) {
                    this.koS = -this.koS;
                }
            } else {
                if (i2 + this.koV > this.koU.bottom - this.kpG) {
                    this.koV = this.koU.top + this.kpG + 0.5f;
                }
            }
        } else {
            this.kpA += this.koS;
            if (this.kpA > this.koU.bottom - this.kpG) {
                this.kpA = this.koU.top + this.kpG + 0.5f;
            }
        }
        postInvalidateDelayed(this.koT, this.koU.left, this.koU.top, this.koU.right, this.koU.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cMM();
    }

    private void cMM() {
        int i;
        if (this.kpm) {
            i = this.mTopOffset + this.kpl;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.byD) / 2;
        this.koU = new Rect(width, i, this.byD + width, this.kpa + i);
        if (this.kpm) {
            float f = this.koU.left + this.kpG + 0.5f;
            this.koW = f;
            this.kpB = f;
            return;
        }
        float f2 = this.koU.top + this.kpG + 0.5f;
        this.koV = f2;
        this.kpA = f2;
    }

    public Rect Bu(int i) {
        if (this.kpJ) {
            Rect rect = new Rect(this.koU);
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
        this.kpm = z;
        if (this.kpy != null || this.kpx) {
            if (this.kpm) {
                this.kpz = this.kpF;
            } else {
                this.kpz = this.kpE;
            }
        } else if (this.kpg != null || this.kpf) {
            if (this.kpm) {
                this.kph = this.kpD;
            } else {
                this.kph = this.kpC;
            }
        }
        if (this.kpm) {
            this.iXB = this.kpo;
            this.kpa = this.kpb;
            this.koT = (int) (((this.kpj * 1.0f) * this.koS) / this.byD);
        } else {
            this.iXB = this.kpn;
            this.kpa = this.byD;
            this.koT = (int) (((this.kpj * 1.0f) * this.koS) / this.kpa);
        }
        if (!TextUtils.isEmpty(this.iXB)) {
            if (this.kpt) {
                this.kpH = new StaticLayout(this.iXB, this.koX, a.fd(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.kpH = new StaticLayout(this.iXB, this.koX, this.byD - (this.kpI * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.kpk) {
            int i = a.fd(getContext()).y;
            if (this.kpl == 0) {
                this.mTopOffset = (i - this.kpa) / 2;
            } else if (this.kpm) {
                this.mTopOffset = ((i - this.kpa) / 2) + (this.kpl / 2);
            } else {
                this.mTopOffset = (i - this.kpa) / 2;
            }
        }
        cMM();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.kpm;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.koY;
    }

    public void setCornerLength(int i) {
        this.koY = i;
    }

    public int getCornerSize() {
        return this.koZ;
    }

    public void setCornerSize(int i) {
        this.koZ = i;
    }

    public int getRectWidth() {
        return this.byD;
    }

    public void setRectWidth(int i) {
        this.byD = i;
    }

    public int getRectHeight() {
        return this.kpa;
    }

    public void setRectHeight(int i) {
        this.kpa = i;
    }

    public int getBarcodeRectHeight() {
        return this.kpb;
    }

    public void setBarcodeRectHeight(int i) {
        this.kpb = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.kpc;
    }

    public void setScanLineSize(int i) {
        this.kpc = i;
    }

    public int getScanLineColor() {
        return this.kpd;
    }

    public void setScanLineColor(int i) {
        this.kpd = i;
    }

    public int getScanLineMargin() {
        return this.kpe;
    }

    public void setScanLineMargin(int i) {
        this.kpe = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.kpf = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.kpg;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.kpg = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.kph;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.kph = bitmap;
    }

    public int getBorderSize() {
        return this.kpi;
    }

    public void setBorderSize(int i) {
        this.kpi = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.kpj;
    }

    public void setAnimTime(int i) {
        this.kpj = i;
    }

    public void setCenterVertical(boolean z) {
        this.kpk = z;
    }

    public int getToolbarHeight() {
        return this.kpl;
    }

    public void setToolbarHeight(int i) {
        this.kpl = i;
    }

    public String getQRCodeTipText() {
        return this.kpn;
    }

    public void setQRCodeTipText(String str) {
        this.kpn = str;
    }

    public String getBarCodeTipText() {
        return this.kpo;
    }

    public void setBarCodeTipText(String str) {
        this.kpo = str;
    }

    public String getTipText() {
        return this.iXB;
    }

    public void setTipText(String str) {
        this.iXB = str;
    }

    public int getTipTextColor() {
        return this.kpq;
    }

    public void setTipTextColor(int i) {
        this.kpq = i;
    }

    public int getTipTextSize() {
        return this.kpp;
    }

    public void setTipTextSize(int i) {
        this.kpp = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.kpr = z;
    }

    public int getTipTextMargin() {
        return this.kps;
    }

    public void setTipTextMargin(int i) {
        this.kps = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.kpt = z;
    }

    public void setShowTipBackground(boolean z) {
        this.kpv = z;
    }

    public int getTipBackgroundColor() {
        return this.kpu;
    }

    public void setTipBackgroundColor(int i) {
        this.kpu = i;
    }

    public void setScanLineReverse(boolean z) {
        this.kpw = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.kpx = z;
    }

    public float getHalfCornerSize() {
        return this.kpG;
    }

    public void setHalfCornerSize(float f) {
        this.kpG = f;
    }

    public StaticLayout getTipTextSl() {
        return this.kpH;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.kpH = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.kpI;
    }

    public void setTipBackgroundRadius(int i) {
        this.kpI = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.kpJ = z;
    }
}
