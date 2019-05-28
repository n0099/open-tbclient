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
import com.baidu.tieba.c;
/* loaded from: classes5.dex */
public class ScanBoxView extends View {
    private int bXd;
    private int cCD;
    private String hle;
    private Bitmap iwX;
    private Bitmap iwY;
    private Bitmap iwZ;
    private int ixA;
    private boolean ixB;
    private int ixC;
    private boolean ixD;
    private int ixE;
    private boolean ixF;
    private boolean ixG;
    private boolean ixH;
    private Drawable ixI;
    private Bitmap ixJ;
    private float ixK;
    private float ixL;
    private Bitmap ixM;
    private Bitmap ixN;
    private Bitmap ixO;
    private Bitmap ixP;
    private float ixQ;
    private StaticLayout ixR;
    private int ixS;
    private boolean ixT;
    private ColorMatrixColorFilter ixU;
    private Bitmap ixa;
    private int ixb;
    private int ixc;
    private Rect ixd;
    private float ixe;
    private float ixf;
    private TextPaint ixg;
    private int ixh;
    private int ixi;
    private int ixj;
    private int ixk;
    private int ixl;
    private int ixm;
    private int ixn;
    private int ixo;
    private boolean ixp;
    private Drawable ixq;
    private Bitmap ixr;
    private int ixs;
    private int ixt;
    private boolean ixu;
    private int ixv;
    private boolean ixw;
    private String ixx;
    private String ixy;
    private int ixz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bXd = Color.parseColor("#33FFFFFF");
        this.ixh = a.e(context, 20.0f);
        this.ixi = a.e(context, 3.0f);
        this.ixm = a.e(context, 1.0f);
        this.ixn = -1;
        this.cCD = a.e(context, 90.0f);
        this.ixj = a.e(context, 200.0f);
        this.ixl = a.e(context, 140.0f);
        this.ixo = 0;
        this.ixp = false;
        this.ixq = null;
        this.ixr = null;
        this.ixs = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ixt = 1000;
        this.ixu = false;
        this.ixv = 0;
        this.ixw = false;
        this.ixb = a.e(context, 2.0f);
        this.hle = null;
        this.ixz = a.sp2px(context, 14.0f);
        this.ixA = -1;
        this.ixB = false;
        this.ixC = a.e(context, 20.0f);
        this.ixD = false;
        this.ixE = Color.parseColor("#22000000");
        this.ixF = false;
        this.ixG = false;
        this.ixH = false;
        this.ixg = new TextPaint();
        this.ixg.setAntiAlias(true);
        this.ixS = a.e(context, 4.0f);
        this.ixT = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ixU = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cei();
        ceh();
    }

    private void ceh() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ixh;
        options.outHeight = this.ixh;
        this.iwX = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iwY = Bitmap.createBitmap(this.iwX, 0, 0, this.iwX.getWidth(), this.iwX.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.iwZ = Bitmap.createBitmap(this.iwX, 0, 0, this.iwX.getWidth(), this.iwX.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ixa = Bitmap.createBitmap(this.iwX, 0, 0, this.iwX.getWidth(), this.iwX.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cCD = typedArray.getDimensionPixelSize(i, this.cCD);
        } else if (i == 1) {
            this.ixi = typedArray.getDimensionPixelSize(i, this.ixi);
        } else if (i == 2) {
            this.ixh = typedArray.getDimensionPixelSize(i, this.ixh);
        } else if (i == 6) {
            this.ixm = typedArray.getDimensionPixelSize(i, this.ixm);
        } else if (i == 3) {
            this.ixj = typedArray.getDimensionPixelSize(i, this.ixj);
        } else if (i == 5) {
            this.bXd = typedArray.getColor(i, this.bXd);
        } else if (i == 7) {
            this.ixn = typedArray.getColor(i, this.ixn);
        } else if (i == 8) {
            this.ixo = typedArray.getDimensionPixelSize(i, this.ixo);
        } else if (i == 9) {
            this.ixp = typedArray.getBoolean(i, this.ixp);
        } else if (i == 10) {
            this.ixq = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.ixs = typedArray.getDimensionPixelSize(i, this.ixs);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.ixt = typedArray.getInteger(i, this.ixt);
        } else if (i == 14) {
            this.ixu = typedArray.getBoolean(i, this.ixu);
        } else if (i == 15) {
            this.ixv = typedArray.getDimensionPixelSize(i, this.ixv);
        } else if (i == 4) {
            this.ixl = typedArray.getDimensionPixelSize(i, this.ixl);
        } else if (i == 16) {
            this.ixw = typedArray.getBoolean(i, this.ixw);
        } else if (i == 18) {
            this.ixy = typedArray.getString(i);
        } else if (i == 17) {
            this.ixx = typedArray.getString(i);
        } else if (i == 19) {
            this.ixz = typedArray.getDimensionPixelSize(i, this.ixz);
        } else if (i == 20) {
            this.ixA = typedArray.getColor(i, this.ixA);
        } else if (i == 21) {
            this.ixB = typedArray.getBoolean(i, this.ixB);
        } else if (i == 22) {
            this.ixC = typedArray.getDimensionPixelSize(i, this.ixC);
        } else if (i == 23) {
            this.ixD = typedArray.getBoolean(i, this.ixD);
        } else if (i == 24) {
            this.ixF = typedArray.getBoolean(i, this.ixF);
        } else if (i == 25) {
            this.ixE = typedArray.getColor(i, this.ixE);
        } else if (i == 26) {
            this.ixG = typedArray.getBoolean(i, this.ixG);
        } else if (i == 27) {
            this.ixH = typedArray.getBoolean(i, this.ixH);
        } else if (i == 28) {
            this.ixI = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.ixT = typedArray.getBoolean(i, this.ixT);
        }
    }

    private void cei() {
        if (this.ixI != null) {
            this.ixO = ((BitmapDrawable) this.ixI).getBitmap();
        }
        if (this.ixO == null) {
            this.ixO = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixO = a.e(this.ixO, this.ixn);
        }
        this.ixP = a.adjustPhotoRotation(this.ixO, 90);
        this.ixP = a.adjustPhotoRotation(this.ixP, 90);
        this.ixP = a.adjustPhotoRotation(this.ixP, 90);
        if (this.ixq != null) {
            this.ixM = ((BitmapDrawable) this.ixq).getBitmap();
        }
        if (this.ixM == null) {
            this.ixM = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixM = a.e(this.ixM, this.ixn);
        }
        this.ixN = a.adjustPhotoRotation(this.ixM, 90);
        this.ixQ = (1.0f * this.ixi) / 2.0f;
        this.ixg.setTextSize(this.ixz);
        this.ixg.setColor(this.ixA);
        setIsBarcode(this.ixw);
    }

    public void cej() {
        this.ixg.setColor(this.ixA);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ixd != null) {
            U(canvas);
            V(canvas);
            X(canvas);
            Y(canvas);
            W(canvas);
            cek();
        }
    }

    private void U(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bXd != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bXd);
            canvas.drawRect(0.0f, 0.0f, width, this.ixd.top, this.mPaint);
            canvas.drawRect(0.0f, this.ixd.top, this.ixd.left, this.ixd.bottom + 1, this.mPaint);
            canvas.drawRect(this.ixd.right + 1, this.ixd.top, width, this.ixd.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ixd.bottom + 1, width, height, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (this.ixs > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ixs);
            canvas.drawRect(this.ixd, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iwX, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iwY, getMainFrameRight() - this.iwX.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iwZ, getMainFrameLeft(), getMainFrameBottom() - this.iwX.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ixa, getMainFrameRight() - this.iwX.getWidth(), getMainFrameBottom() - this.iwX.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ixd.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ixd.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ixd.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ixd.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ixs / 2;
    }

    private void X(Canvas canvas) {
        if (this.ixw) {
            if (this.ixJ != null) {
                RectF rectF = new RectF(this.ixd.left + this.ixQ + 0.5f, this.ixd.top + this.ixQ + this.ixo, this.ixL, (this.ixd.bottom - this.ixQ) - this.ixo);
                Rect rect = new Rect((int) (this.ixJ.getWidth() - rectF.width()), 0, this.ixJ.getWidth(), this.ixJ.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ixJ, rect, rectF, this.mPaint);
            } else if (this.ixr != null) {
                canvas.drawBitmap(this.ixr, (Rect) null, new RectF(this.ixf, this.ixd.top + this.ixQ + this.ixo, this.ixf + this.ixr.getWidth(), (this.ixd.bottom - this.ixQ) - this.ixo), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ixn);
                canvas.drawRect(this.ixf, this.ixo + this.ixd.top + this.ixQ, this.ixm + this.ixf, (this.ixd.bottom - this.ixQ) - this.ixo, this.mPaint);
            }
        } else if (this.ixJ != null) {
            RectF rectF2 = new RectF(this.ixd.left + this.ixQ + this.ixo, this.ixd.top + this.ixQ + 0.5f, (this.ixd.right - this.ixQ) - this.ixo, this.ixK);
            Rect rect2 = new Rect(0, (int) (this.ixJ.getHeight() - rectF2.height()), this.ixJ.getWidth(), this.ixJ.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ixU);
            canvas.drawBitmap(this.ixJ, rect2, rectF2, this.mPaint);
        } else if (this.ixr != null) {
            canvas.drawBitmap(this.ixr, (Rect) null, new RectF(this.ixd.left + this.ixQ + this.ixo, this.ixe, (this.ixd.right - this.ixQ) - this.ixo, this.ixe + this.ixr.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ixn);
            canvas.drawRect(this.ixo + this.ixd.left + this.ixQ, this.ixe, (this.ixd.right - this.ixQ) - this.ixo, this.ixm + this.ixe, this.mPaint);
        }
    }

    private void Y(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hle) && this.ixR != null) {
            if (this.ixB) {
                if (this.ixF) {
                    this.mPaint.setColor(this.ixE);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ixD) {
                        Rect rect = new Rect();
                        this.ixg.getTextBounds(this.hle, 0, this.hle.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ixS;
                        canvas.drawRoundRect(new RectF(width, (this.ixd.bottom + this.ixC) - this.ixS, rect.width() + width + (this.ixS * 2), this.ixd.bottom + this.ixC + this.ixR.getHeight() + this.ixS), this.ixS, this.ixS, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ixd.left, (this.ixd.bottom + this.ixC) - this.ixS, this.ixd.right, this.ixd.bottom + this.ixC + this.ixR.getHeight() + this.ixS), this.ixS, this.ixS, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ixD) {
                    canvas.translate(0.0f, this.ixd.bottom + this.ixC);
                } else {
                    canvas.translate(this.ixd.left + this.ixS, this.ixd.bottom + this.ixC);
                }
                this.ixR.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ixF) {
                this.mPaint.setColor(this.ixE);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ixD) {
                    Rect rect2 = new Rect();
                    this.ixg.getTextBounds(this.hle, 0, this.hle.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ixS;
                    canvas.drawRoundRect(new RectF(width2, ((this.ixd.top - this.ixC) - this.ixR.getHeight()) - this.ixS, rect2.width() + width2 + (this.ixS * 2), (this.ixd.top - this.ixC) + this.ixS), this.ixS, this.ixS, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ixd.left, ((this.ixd.top - this.ixC) - this.ixR.getHeight()) - this.ixS, this.ixd.right, (this.ixd.top - this.ixC) + this.ixS), this.ixS, this.ixS, this.mPaint);
                }
            }
            canvas.save();
            if (this.ixD) {
                canvas.translate(0.0f, (this.ixd.top - this.ixC) - this.ixR.getHeight());
            } else {
                canvas.translate(this.ixd.left + this.ixS, (this.ixd.top - this.ixC) - this.ixR.getHeight());
            }
            this.ixR.draw(canvas);
            canvas.restore();
        }
    }

    private void cek() {
        if (this.ixw) {
            if (this.ixJ == null) {
                this.ixf += this.ixb;
                int i = this.ixm;
                if (this.ixr != null) {
                    i = this.ixr.getWidth();
                }
                if (this.ixG) {
                    if (i + this.ixf > this.ixd.right - this.ixQ || this.ixf < this.ixd.left + this.ixQ) {
                        this.ixb = -this.ixb;
                    }
                } else {
                    if (i + this.ixf > this.ixd.right - this.ixQ) {
                        this.ixf = this.ixd.left + this.ixQ + 0.5f;
                    }
                }
            } else {
                this.ixL += this.ixb;
                if (this.ixL > this.ixd.right - this.ixQ) {
                    this.ixL = this.ixd.left + this.ixQ + 0.5f;
                }
            }
        } else if (this.ixJ == null) {
            this.ixe += this.ixb;
            int i2 = this.ixm;
            if (this.ixr != null) {
                i2 = this.ixr.getHeight();
            }
            if (this.ixG) {
                if (i2 + this.ixe > this.ixd.bottom - this.ixQ || this.ixe < this.ixd.top + this.ixQ) {
                    this.ixb = -this.ixb;
                }
            } else {
                if (i2 + this.ixe > this.ixd.bottom - this.ixQ) {
                    this.ixe = this.ixd.top + this.ixQ + 0.5f;
                }
            }
        } else {
            this.ixK += this.ixb;
            if (this.ixK > this.ixd.bottom - this.ixQ) {
                this.ixK = this.ixd.top + this.ixQ + 0.5f;
            }
        }
        postInvalidateDelayed(this.ixc, this.ixd.left, this.ixd.top, this.ixd.right, this.ixd.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cel();
    }

    private void cel() {
        int i;
        if (this.ixw) {
            i = this.cCD + this.ixv;
        } else {
            i = this.cCD;
        }
        int width = (getWidth() - this.ixj) / 2;
        this.ixd = new Rect(width, i, this.ixj + width, this.ixk + i);
        if (this.ixw) {
            float f = this.ixd.left + this.ixQ + 0.5f;
            this.ixf = f;
            this.ixL = f;
            return;
        }
        float f2 = this.ixd.top + this.ixQ + 0.5f;
        this.ixe = f2;
        this.ixK = f2;
    }

    public Rect yO(int i) {
        if (this.ixT) {
            Rect rect = new Rect(this.ixd);
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
        this.ixw = z;
        if (this.ixI != null || this.ixH) {
            if (this.ixw) {
                this.ixJ = this.ixP;
            } else {
                this.ixJ = this.ixO;
            }
        } else if (this.ixq != null || this.ixp) {
            if (this.ixw) {
                this.ixr = this.ixN;
            } else {
                this.ixr = this.ixM;
            }
        }
        if (this.ixw) {
            this.hle = this.ixy;
            this.ixk = this.ixl;
            this.ixc = (int) (((this.ixt * 1.0f) * this.ixb) / this.ixj);
        } else {
            this.hle = this.ixx;
            this.ixk = this.ixj;
            this.ixc = (int) (((this.ixt * 1.0f) * this.ixb) / this.ixk);
        }
        if (!TextUtils.isEmpty(this.hle)) {
            if (this.ixD) {
                this.ixR = new StaticLayout(this.hle, this.ixg, a.ef(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ixR = new StaticLayout(this.hle, this.ixg, this.ixj - (this.ixS * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ixu) {
            int i = a.ef(getContext()).y;
            if (this.ixv == 0) {
                this.cCD = (i - this.ixk) / 2;
            } else if (this.ixw) {
                this.cCD = ((i - this.ixk) / 2) + (this.ixv / 2);
            } else {
                this.cCD = (i - this.ixk) / 2;
            }
        }
        cel();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ixw;
    }

    public int getMaskColor() {
        return this.bXd;
    }

    public void setMaskColor(int i) {
        this.bXd = i;
    }

    public int getCornerLength() {
        return this.ixh;
    }

    public void setCornerLength(int i) {
        this.ixh = i;
    }

    public int getCornerSize() {
        return this.ixi;
    }

    public void setCornerSize(int i) {
        this.ixi = i;
    }

    public int getRectWidth() {
        return this.ixj;
    }

    public void setRectWidth(int i) {
        this.ixj = i;
    }

    public int getRectHeight() {
        return this.ixk;
    }

    public void setRectHeight(int i) {
        this.ixk = i;
    }

    public int getBarcodeRectHeight() {
        return this.ixl;
    }

    public void setBarcodeRectHeight(int i) {
        this.ixl = i;
    }

    public int getTopOffset() {
        return this.cCD;
    }

    public void setTopOffset(int i) {
        this.cCD = i;
    }

    public int getScanLineSize() {
        return this.ixm;
    }

    public void setScanLineSize(int i) {
        this.ixm = i;
    }

    public int getScanLineColor() {
        return this.ixn;
    }

    public void setScanLineColor(int i) {
        this.ixn = i;
    }

    public int getScanLineMargin() {
        return this.ixo;
    }

    public void setScanLineMargin(int i) {
        this.ixo = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ixp = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ixq;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ixq = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ixr;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ixr = bitmap;
    }

    public int getBorderSize() {
        return this.ixs;
    }

    public void setBorderSize(int i) {
        this.ixs = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ixt;
    }

    public void setAnimTime(int i) {
        this.ixt = i;
    }

    public void setCenterVertical(boolean z) {
        this.ixu = z;
    }

    public int getToolbarHeight() {
        return this.ixv;
    }

    public void setToolbarHeight(int i) {
        this.ixv = i;
    }

    public String getQRCodeTipText() {
        return this.ixx;
    }

    public void setQRCodeTipText(String str) {
        this.ixx = str;
    }

    public String getBarCodeTipText() {
        return this.ixy;
    }

    public void setBarCodeTipText(String str) {
        this.ixy = str;
    }

    public String getTipText() {
        return this.hle;
    }

    public void setTipText(String str) {
        this.hle = str;
    }

    public int getTipTextColor() {
        return this.ixA;
    }

    public void setTipTextColor(int i) {
        this.ixA = i;
    }

    public int getTipTextSize() {
        return this.ixz;
    }

    public void setTipTextSize(int i) {
        this.ixz = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ixB = z;
    }

    public int getTipTextMargin() {
        return this.ixC;
    }

    public void setTipTextMargin(int i) {
        this.ixC = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ixD = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ixF = z;
    }

    public int getTipBackgroundColor() {
        return this.ixE;
    }

    public void setTipBackgroundColor(int i) {
        this.ixE = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ixG = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ixH = z;
    }

    public float getHalfCornerSize() {
        return this.ixQ;
    }

    public void setHalfCornerSize(float f) {
        this.ixQ = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ixR;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ixR = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ixS;
    }

    public void setTipBackgroundRadius(int i) {
        this.ixS = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ixT = z;
    }
}
