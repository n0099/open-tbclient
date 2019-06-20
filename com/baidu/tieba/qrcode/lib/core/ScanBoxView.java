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
    private int bXe;
    private int cCE;
    private String hlf;
    private Bitmap iwY;
    private Bitmap iwZ;
    private int ixA;
    private int ixB;
    private boolean ixC;
    private int ixD;
    private boolean ixE;
    private int ixF;
    private boolean ixG;
    private boolean ixH;
    private boolean ixI;
    private Drawable ixJ;
    private Bitmap ixK;
    private float ixL;
    private float ixM;
    private Bitmap ixN;
    private Bitmap ixO;
    private Bitmap ixP;
    private Bitmap ixQ;
    private float ixR;
    private StaticLayout ixS;
    private int ixT;
    private boolean ixU;
    private ColorMatrixColorFilter ixV;
    private Bitmap ixa;
    private Bitmap ixb;
    private int ixc;
    private int ixd;
    private Rect ixe;
    private float ixf;
    private float ixg;
    private TextPaint ixh;
    private int ixi;
    private int ixj;
    private int ixk;
    private int ixl;
    private int ixm;
    private int ixn;
    private int ixo;
    private int ixp;
    private boolean ixq;
    private Drawable ixr;
    private Bitmap ixs;
    private int ixt;
    private int ixu;
    private boolean ixv;
    private int ixw;
    private boolean ixx;
    private String ixy;
    private String ixz;
    private int mBorderColor;
    private Context mContext;
    private Paint mPaint;

    public ScanBoxView(Context context) {
        super(context);
        this.mContext = context;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bXe = Color.parseColor("#33FFFFFF");
        this.ixi = a.e(context, 20.0f);
        this.ixj = a.e(context, 3.0f);
        this.ixn = a.e(context, 1.0f);
        this.ixo = -1;
        this.cCE = a.e(context, 90.0f);
        this.ixk = a.e(context, 200.0f);
        this.ixm = a.e(context, 140.0f);
        this.ixp = 0;
        this.ixq = false;
        this.ixr = null;
        this.ixs = null;
        this.ixt = a.e(context, 1.0f);
        this.mBorderColor = -1;
        this.ixu = 1000;
        this.ixv = false;
        this.ixw = 0;
        this.ixx = false;
        this.ixc = a.e(context, 2.0f);
        this.hlf = null;
        this.ixA = a.sp2px(context, 14.0f);
        this.ixB = -1;
        this.ixC = false;
        this.ixD = a.e(context, 20.0f);
        this.ixE = false;
        this.ixF = Color.parseColor("#22000000");
        this.ixG = false;
        this.ixH = false;
        this.ixI = false;
        this.ixh = new TextPaint();
        this.ixh.setAntiAlias(true);
        this.ixT = a.e(context, 4.0f);
        this.ixU = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.ixV = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        cej();
        cei();
    }

    private void cei() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.ixi;
        options.outHeight = this.ixi;
        this.iwY = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.iwZ = Bitmap.createBitmap(this.iwY, 0, 0, this.iwY.getWidth(), this.iwY.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.ixa = Bitmap.createBitmap(this.iwY, 0, 0, this.iwY.getWidth(), this.iwY.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.ixb = Bitmap.createBitmap(this.iwY, 0, 0, this.iwY.getWidth(), this.iwY.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.cCE = typedArray.getDimensionPixelSize(i, this.cCE);
        } else if (i == 1) {
            this.ixj = typedArray.getDimensionPixelSize(i, this.ixj);
        } else if (i == 2) {
            this.ixi = typedArray.getDimensionPixelSize(i, this.ixi);
        } else if (i == 6) {
            this.ixn = typedArray.getDimensionPixelSize(i, this.ixn);
        } else if (i == 3) {
            this.ixk = typedArray.getDimensionPixelSize(i, this.ixk);
        } else if (i == 5) {
            this.bXe = typedArray.getColor(i, this.bXe);
        } else if (i == 7) {
            this.ixo = typedArray.getColor(i, this.ixo);
        } else if (i == 8) {
            this.ixp = typedArray.getDimensionPixelSize(i, this.ixp);
        } else if (i == 9) {
            this.ixq = typedArray.getBoolean(i, this.ixq);
        } else if (i == 10) {
            this.ixr = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.ixt = typedArray.getDimensionPixelSize(i, this.ixt);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.ixu = typedArray.getInteger(i, this.ixu);
        } else if (i == 14) {
            this.ixv = typedArray.getBoolean(i, this.ixv);
        } else if (i == 15) {
            this.ixw = typedArray.getDimensionPixelSize(i, this.ixw);
        } else if (i == 4) {
            this.ixm = typedArray.getDimensionPixelSize(i, this.ixm);
        } else if (i == 16) {
            this.ixx = typedArray.getBoolean(i, this.ixx);
        } else if (i == 18) {
            this.ixz = typedArray.getString(i);
        } else if (i == 17) {
            this.ixy = typedArray.getString(i);
        } else if (i == 19) {
            this.ixA = typedArray.getDimensionPixelSize(i, this.ixA);
        } else if (i == 20) {
            this.ixB = typedArray.getColor(i, this.ixB);
        } else if (i == 21) {
            this.ixC = typedArray.getBoolean(i, this.ixC);
        } else if (i == 22) {
            this.ixD = typedArray.getDimensionPixelSize(i, this.ixD);
        } else if (i == 23) {
            this.ixE = typedArray.getBoolean(i, this.ixE);
        } else if (i == 24) {
            this.ixG = typedArray.getBoolean(i, this.ixG);
        } else if (i == 25) {
            this.ixF = typedArray.getColor(i, this.ixF);
        } else if (i == 26) {
            this.ixH = typedArray.getBoolean(i, this.ixH);
        } else if (i == 27) {
            this.ixI = typedArray.getBoolean(i, this.ixI);
        } else if (i == 28) {
            this.ixJ = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.ixU = typedArray.getBoolean(i, this.ixU);
        }
    }

    private void cej() {
        if (this.ixJ != null) {
            this.ixP = ((BitmapDrawable) this.ixJ).getBitmap();
        }
        if (this.ixP == null) {
            this.ixP = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixP = a.e(this.ixP, this.ixo);
        }
        this.ixQ = a.adjustPhotoRotation(this.ixP, 90);
        this.ixQ = a.adjustPhotoRotation(this.ixQ, 90);
        this.ixQ = a.adjustPhotoRotation(this.ixQ, 90);
        if (this.ixr != null) {
            this.ixN = ((BitmapDrawable) this.ixr).getBitmap();
        }
        if (this.ixN == null) {
            this.ixN = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.ixN = a.e(this.ixN, this.ixo);
        }
        this.ixO = a.adjustPhotoRotation(this.ixN, 90);
        this.ixR = (1.0f * this.ixj) / 2.0f;
        this.ixh.setTextSize(this.ixA);
        this.ixh.setColor(this.ixB);
        setIsBarcode(this.ixx);
    }

    public void cek() {
        this.ixh.setColor(this.ixB);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ixe != null) {
            U(canvas);
            V(canvas);
            X(canvas);
            Y(canvas);
            W(canvas);
            cel();
        }
    }

    private void U(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.bXe != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.bXe);
            canvas.drawRect(0.0f, 0.0f, width, this.ixe.top, this.mPaint);
            canvas.drawRect(0.0f, this.ixe.top, this.ixe.left, this.ixe.bottom + 1, this.mPaint);
            canvas.drawRect(this.ixe.right + 1, this.ixe.top, width, this.ixe.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.ixe.bottom + 1, width, height, this.mPaint);
        }
    }

    private void V(Canvas canvas) {
        if (this.ixt > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.ixt);
            canvas.drawRect(this.ixe, this.mPaint);
        }
    }

    private void W(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.iwY, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.iwZ, getMainFrameRight() - this.iwY.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.ixa, getMainFrameLeft(), getMainFrameBottom() - this.iwY.getHeight(), this.mPaint);
        canvas.drawBitmap(this.ixb, getMainFrameRight() - this.iwY.getWidth(), getMainFrameBottom() - this.iwY.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.ixe.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.ixe.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.ixe.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.ixe.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.ixt / 2;
    }

    private void X(Canvas canvas) {
        if (this.ixx) {
            if (this.ixK != null) {
                RectF rectF = new RectF(this.ixe.left + this.ixR + 0.5f, this.ixe.top + this.ixR + this.ixp, this.ixM, (this.ixe.bottom - this.ixR) - this.ixp);
                Rect rect = new Rect((int) (this.ixK.getWidth() - rectF.width()), 0, this.ixK.getWidth(), this.ixK.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.ixK, rect, rectF, this.mPaint);
            } else if (this.ixs != null) {
                canvas.drawBitmap(this.ixs, (Rect) null, new RectF(this.ixg, this.ixe.top + this.ixR + this.ixp, this.ixg + this.ixs.getWidth(), (this.ixe.bottom - this.ixR) - this.ixp), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.ixo);
                canvas.drawRect(this.ixg, this.ixp + this.ixe.top + this.ixR, this.ixn + this.ixg, (this.ixe.bottom - this.ixR) - this.ixp, this.mPaint);
            }
        } else if (this.ixK != null) {
            RectF rectF2 = new RectF(this.ixe.left + this.ixR + this.ixp, this.ixe.top + this.ixR + 0.5f, (this.ixe.right - this.ixR) - this.ixp, this.ixL);
            Rect rect2 = new Rect(0, (int) (this.ixK.getHeight() - rectF2.height()), this.ixK.getWidth(), this.ixK.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.ixV);
            canvas.drawBitmap(this.ixK, rect2, rectF2, this.mPaint);
        } else if (this.ixs != null) {
            canvas.drawBitmap(this.ixs, (Rect) null, new RectF(this.ixe.left + this.ixR + this.ixp, this.ixf, (this.ixe.right - this.ixR) - this.ixp, this.ixf + this.ixs.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.ixo);
            canvas.drawRect(this.ixp + this.ixe.left + this.ixR, this.ixf, (this.ixe.right - this.ixR) - this.ixp, this.ixn + this.ixf, this.mPaint);
        }
    }

    private void Y(Canvas canvas) {
        if (!TextUtils.isEmpty(this.hlf) && this.ixS != null) {
            if (this.ixC) {
                if (this.ixG) {
                    this.mPaint.setColor(this.ixF);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.ixE) {
                        Rect rect = new Rect();
                        this.ixh.getTextBounds(this.hlf, 0, this.hlf.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.ixT;
                        canvas.drawRoundRect(new RectF(width, (this.ixe.bottom + this.ixD) - this.ixT, rect.width() + width + (this.ixT * 2), this.ixe.bottom + this.ixD + this.ixS.getHeight() + this.ixT), this.ixT, this.ixT, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.ixe.left, (this.ixe.bottom + this.ixD) - this.ixT, this.ixe.right, this.ixe.bottom + this.ixD + this.ixS.getHeight() + this.ixT), this.ixT, this.ixT, this.mPaint);
                    }
                }
                canvas.save();
                if (this.ixE) {
                    canvas.translate(0.0f, this.ixe.bottom + this.ixD);
                } else {
                    canvas.translate(this.ixe.left + this.ixT, this.ixe.bottom + this.ixD);
                }
                this.ixS.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.ixG) {
                this.mPaint.setColor(this.ixF);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.ixE) {
                    Rect rect2 = new Rect();
                    this.ixh.getTextBounds(this.hlf, 0, this.hlf.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.ixT;
                    canvas.drawRoundRect(new RectF(width2, ((this.ixe.top - this.ixD) - this.ixS.getHeight()) - this.ixT, rect2.width() + width2 + (this.ixT * 2), (this.ixe.top - this.ixD) + this.ixT), this.ixT, this.ixT, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.ixe.left, ((this.ixe.top - this.ixD) - this.ixS.getHeight()) - this.ixT, this.ixe.right, (this.ixe.top - this.ixD) + this.ixT), this.ixT, this.ixT, this.mPaint);
                }
            }
            canvas.save();
            if (this.ixE) {
                canvas.translate(0.0f, (this.ixe.top - this.ixD) - this.ixS.getHeight());
            } else {
                canvas.translate(this.ixe.left + this.ixT, (this.ixe.top - this.ixD) - this.ixS.getHeight());
            }
            this.ixS.draw(canvas);
            canvas.restore();
        }
    }

    private void cel() {
        if (this.ixx) {
            if (this.ixK == null) {
                this.ixg += this.ixc;
                int i = this.ixn;
                if (this.ixs != null) {
                    i = this.ixs.getWidth();
                }
                if (this.ixH) {
                    if (i + this.ixg > this.ixe.right - this.ixR || this.ixg < this.ixe.left + this.ixR) {
                        this.ixc = -this.ixc;
                    }
                } else {
                    if (i + this.ixg > this.ixe.right - this.ixR) {
                        this.ixg = this.ixe.left + this.ixR + 0.5f;
                    }
                }
            } else {
                this.ixM += this.ixc;
                if (this.ixM > this.ixe.right - this.ixR) {
                    this.ixM = this.ixe.left + this.ixR + 0.5f;
                }
            }
        } else if (this.ixK == null) {
            this.ixf += this.ixc;
            int i2 = this.ixn;
            if (this.ixs != null) {
                i2 = this.ixs.getHeight();
            }
            if (this.ixH) {
                if (i2 + this.ixf > this.ixe.bottom - this.ixR || this.ixf < this.ixe.top + this.ixR) {
                    this.ixc = -this.ixc;
                }
            } else {
                if (i2 + this.ixf > this.ixe.bottom - this.ixR) {
                    this.ixf = this.ixe.top + this.ixR + 0.5f;
                }
            }
        } else {
            this.ixL += this.ixc;
            if (this.ixL > this.ixe.bottom - this.ixR) {
                this.ixL = this.ixe.top + this.ixR + 0.5f;
            }
        }
        postInvalidateDelayed(this.ixd, this.ixe.left, this.ixe.top, this.ixe.right, this.ixe.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cem();
    }

    private void cem() {
        int i;
        if (this.ixx) {
            i = this.cCE + this.ixw;
        } else {
            i = this.cCE;
        }
        int width = (getWidth() - this.ixk) / 2;
        this.ixe = new Rect(width, i, this.ixk + width, this.ixl + i);
        if (this.ixx) {
            float f = this.ixe.left + this.ixR + 0.5f;
            this.ixg = f;
            this.ixM = f;
            return;
        }
        float f2 = this.ixe.top + this.ixR + 0.5f;
        this.ixf = f2;
        this.ixL = f2;
    }

    public Rect yO(int i) {
        if (this.ixU) {
            Rect rect = new Rect(this.ixe);
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
        this.ixx = z;
        if (this.ixJ != null || this.ixI) {
            if (this.ixx) {
                this.ixK = this.ixQ;
            } else {
                this.ixK = this.ixP;
            }
        } else if (this.ixr != null || this.ixq) {
            if (this.ixx) {
                this.ixs = this.ixO;
            } else {
                this.ixs = this.ixN;
            }
        }
        if (this.ixx) {
            this.hlf = this.ixz;
            this.ixl = this.ixm;
            this.ixd = (int) (((this.ixu * 1.0f) * this.ixc) / this.ixk);
        } else {
            this.hlf = this.ixy;
            this.ixl = this.ixk;
            this.ixd = (int) (((this.ixu * 1.0f) * this.ixc) / this.ixl);
        }
        if (!TextUtils.isEmpty(this.hlf)) {
            if (this.ixE) {
                this.ixS = new StaticLayout(this.hlf, this.ixh, a.ef(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.ixS = new StaticLayout(this.hlf, this.ixh, this.ixk - (this.ixT * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.ixv) {
            int i = a.ef(getContext()).y;
            if (this.ixw == 0) {
                this.cCE = (i - this.ixl) / 2;
            } else if (this.ixx) {
                this.cCE = ((i - this.ixl) / 2) + (this.ixw / 2);
            } else {
                this.cCE = (i - this.ixl) / 2;
            }
        }
        cem();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.ixx;
    }

    public int getMaskColor() {
        return this.bXe;
    }

    public void setMaskColor(int i) {
        this.bXe = i;
    }

    public int getCornerLength() {
        return this.ixi;
    }

    public void setCornerLength(int i) {
        this.ixi = i;
    }

    public int getCornerSize() {
        return this.ixj;
    }

    public void setCornerSize(int i) {
        this.ixj = i;
    }

    public int getRectWidth() {
        return this.ixk;
    }

    public void setRectWidth(int i) {
        this.ixk = i;
    }

    public int getRectHeight() {
        return this.ixl;
    }

    public void setRectHeight(int i) {
        this.ixl = i;
    }

    public int getBarcodeRectHeight() {
        return this.ixm;
    }

    public void setBarcodeRectHeight(int i) {
        this.ixm = i;
    }

    public int getTopOffset() {
        return this.cCE;
    }

    public void setTopOffset(int i) {
        this.cCE = i;
    }

    public int getScanLineSize() {
        return this.ixn;
    }

    public void setScanLineSize(int i) {
        this.ixn = i;
    }

    public int getScanLineColor() {
        return this.ixo;
    }

    public void setScanLineColor(int i) {
        this.ixo = i;
    }

    public int getScanLineMargin() {
        return this.ixp;
    }

    public void setScanLineMargin(int i) {
        this.ixp = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.ixq = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.ixr;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.ixr = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.ixs;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.ixs = bitmap;
    }

    public int getBorderSize() {
        return this.ixt;
    }

    public void setBorderSize(int i) {
        this.ixt = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.ixu;
    }

    public void setAnimTime(int i) {
        this.ixu = i;
    }

    public void setCenterVertical(boolean z) {
        this.ixv = z;
    }

    public int getToolbarHeight() {
        return this.ixw;
    }

    public void setToolbarHeight(int i) {
        this.ixw = i;
    }

    public String getQRCodeTipText() {
        return this.ixy;
    }

    public void setQRCodeTipText(String str) {
        this.ixy = str;
    }

    public String getBarCodeTipText() {
        return this.ixz;
    }

    public void setBarCodeTipText(String str) {
        this.ixz = str;
    }

    public String getTipText() {
        return this.hlf;
    }

    public void setTipText(String str) {
        this.hlf = str;
    }

    public int getTipTextColor() {
        return this.ixB;
    }

    public void setTipTextColor(int i) {
        this.ixB = i;
    }

    public int getTipTextSize() {
        return this.ixA;
    }

    public void setTipTextSize(int i) {
        this.ixA = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.ixC = z;
    }

    public int getTipTextMargin() {
        return this.ixD;
    }

    public void setTipTextMargin(int i) {
        this.ixD = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.ixE = z;
    }

    public void setShowTipBackground(boolean z) {
        this.ixG = z;
    }

    public int getTipBackgroundColor() {
        return this.ixF;
    }

    public void setTipBackgroundColor(int i) {
        this.ixF = i;
    }

    public void setScanLineReverse(boolean z) {
        this.ixH = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.ixI = z;
    }

    public float getHalfCornerSize() {
        return this.ixR;
    }

    public void setHalfCornerSize(float f) {
        this.ixR = f;
    }

    public StaticLayout getTipTextSl() {
        return this.ixS;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.ixS = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.ixT;
    }

    public void setTipBackgroundRadius(int i) {
        this.ixT = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.ixU = z;
    }
}
