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
/* loaded from: classes7.dex */
public class ScanBoxView extends View {
    private int aUJ;
    private String igh;
    private Bitmap jyK;
    private Bitmap jyL;
    private Bitmap jyM;
    private Bitmap jyN;
    private int jyO;
    private int jyP;
    private Rect jyQ;
    private float jyR;
    private float jyS;
    private TextPaint jyT;
    private int jyU;
    private int jyV;
    private int jyW;
    private int jyX;
    private int jyY;
    private int jyZ;
    private Bitmap jzA;
    private Bitmap jzB;
    private float jzC;
    private StaticLayout jzD;
    private int jzE;
    private boolean jzF;
    private ColorMatrixColorFilter jzG;
    private int jza;
    private boolean jzb;
    private Drawable jzc;
    private Bitmap jzd;
    private int jze;
    private int jzf;
    private boolean jzg;
    private int jzh;
    private boolean jzi;
    private String jzj;
    private String jzk;
    private int jzl;
    private int jzm;
    private boolean jzn;
    private int jzo;
    private boolean jzp;
    private int jzq;
    private boolean jzr;
    private boolean jzs;
    private boolean jzt;
    private Drawable jzu;
    private Bitmap jzv;
    private float jzw;
    private float jzx;
    private Bitmap jzy;
    private Bitmap jzz;
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
        this.jyU = a.dp2px(context, 20.0f);
        this.jyV = a.dp2px(context, 3.0f);
        this.jyY = a.dp2px(context, 1.0f);
        this.jyZ = -1;
        this.mTopOffset = a.dp2px(context, 90.0f);
        this.aUJ = a.dp2px(context, 200.0f);
        this.jyX = a.dp2px(context, 140.0f);
        this.jza = 0;
        this.jzb = false;
        this.jzc = null;
        this.jzd = null;
        this.jze = a.dp2px(context, 1.0f);
        this.mBorderColor = -1;
        this.jzf = 1000;
        this.jzg = false;
        this.jzh = 0;
        this.jzi = false;
        this.jyO = a.dp2px(context, 2.0f);
        this.igh = null;
        this.jzl = a.h(context, 14.0f);
        this.jzm = -1;
        this.jzn = false;
        this.jzo = a.dp2px(context, 20.0f);
        this.jzp = false;
        this.jzq = Color.parseColor("#22000000");
        this.jzr = false;
        this.jzs = false;
        this.jzt = false;
        this.jyT = new TextPaint();
        this.jyT.setAntiAlias(true);
        this.jzE = a.dp2px(context, 4.0f);
        this.jzF = false;
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.5f, 1.5f, 1.5f, 1.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.postConcat(colorMatrix);
        this.jzG = new ColorMatrixColorFilter(colorMatrix2);
    }

    public void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QRCodeView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            a(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
        czj();
        czi();
    }

    private void czi() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = this.jyU;
        options.outHeight = this.jyU;
        this.jyK = BitmapHelper.getResBitmap(this.mContext, R.drawable.icon_scan_upperleft, options);
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        this.jyL = Bitmap.createBitmap(this.jyK, 0, 0, this.jyK.getWidth(), this.jyK.getHeight(), matrix, false);
        matrix.postRotate(180.0f);
        this.jyM = Bitmap.createBitmap(this.jyK, 0, 0, this.jyK.getWidth(), this.jyK.getHeight(), matrix, false);
        matrix.postRotate(270.0f);
        this.jyN = Bitmap.createBitmap(this.jyK, 0, 0, this.jyK.getWidth(), this.jyK.getHeight(), matrix, false);
    }

    private void a(int i, TypedArray typedArray) {
        if (i == 0) {
            this.mTopOffset = typedArray.getDimensionPixelSize(i, this.mTopOffset);
        } else if (i == 1) {
            this.jyV = typedArray.getDimensionPixelSize(i, this.jyV);
        } else if (i == 2) {
            this.jyU = typedArray.getDimensionPixelSize(i, this.jyU);
        } else if (i == 6) {
            this.jyY = typedArray.getDimensionPixelSize(i, this.jyY);
        } else if (i == 3) {
            this.aUJ = typedArray.getDimensionPixelSize(i, this.aUJ);
        } else if (i == 5) {
            this.mMaskColor = typedArray.getColor(i, this.mMaskColor);
        } else if (i == 7) {
            this.jyZ = typedArray.getColor(i, this.jyZ);
        } else if (i == 8) {
            this.jza = typedArray.getDimensionPixelSize(i, this.jza);
        } else if (i == 9) {
            this.jzb = typedArray.getBoolean(i, this.jzb);
        } else if (i == 10) {
            this.jzc = typedArray.getDrawable(i);
        } else if (i == 11) {
            this.jze = typedArray.getDimensionPixelSize(i, this.jze);
        } else if (i == 12) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        } else if (i == 13) {
            this.jzf = typedArray.getInteger(i, this.jzf);
        } else if (i == 14) {
            this.jzg = typedArray.getBoolean(i, this.jzg);
        } else if (i == 15) {
            this.jzh = typedArray.getDimensionPixelSize(i, this.jzh);
        } else if (i == 4) {
            this.jyX = typedArray.getDimensionPixelSize(i, this.jyX);
        } else if (i == 16) {
            this.jzi = typedArray.getBoolean(i, this.jzi);
        } else if (i == 18) {
            this.jzk = typedArray.getString(i);
        } else if (i == 17) {
            this.jzj = typedArray.getString(i);
        } else if (i == 19) {
            this.jzl = typedArray.getDimensionPixelSize(i, this.jzl);
        } else if (i == 20) {
            this.jzm = typedArray.getColor(i, this.jzm);
        } else if (i == 21) {
            this.jzn = typedArray.getBoolean(i, this.jzn);
        } else if (i == 22) {
            this.jzo = typedArray.getDimensionPixelSize(i, this.jzo);
        } else if (i == 23) {
            this.jzp = typedArray.getBoolean(i, this.jzp);
        } else if (i == 24) {
            this.jzr = typedArray.getBoolean(i, this.jzr);
        } else if (i == 25) {
            this.jzq = typedArray.getColor(i, this.jzq);
        } else if (i == 26) {
            this.jzs = typedArray.getBoolean(i, this.jzs);
        } else if (i == 27) {
            this.jzt = typedArray.getBoolean(i, this.jzt);
        } else if (i == 28) {
            this.jzu = typedArray.getDrawable(i);
        } else if (i == 29) {
            this.jzF = typedArray.getBoolean(i, this.jzF);
        }
    }

    private void czj() {
        if (this.jzu != null) {
            this.jzA = ((BitmapDrawable) this.jzu).getBitmap();
        }
        if (this.jzA == null) {
            this.jzA = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jzA = a.e(this.jzA, this.jyZ);
        }
        this.jzB = a.adjustPhotoRotation(this.jzA, 90);
        this.jzB = a.adjustPhotoRotation(this.jzB, 90);
        this.jzB = a.adjustPhotoRotation(this.jzB, 90);
        if (this.jzc != null) {
            this.jzy = ((BitmapDrawable) this.jzc).getBitmap();
        }
        if (this.jzy == null) {
            this.jzy = BitmapFactory.decodeResource(getResources(), R.drawable.pc_scan_line);
            this.jzy = a.e(this.jzy, this.jyZ);
        }
        this.jzz = a.adjustPhotoRotation(this.jzy, 90);
        this.jzC = (1.0f * this.jyV) / 2.0f;
        this.jyT.setTextSize(this.jzl);
        this.jyT.setColor(this.jzm);
        setIsBarcode(this.jzi);
    }

    public void czk() {
        this.jyT.setColor(this.jzm);
        setIsBarcode(false);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.jyQ != null) {
            Q(canvas);
            R(canvas);
            T(canvas);
            U(canvas);
            S(canvas);
            czl();
        }
    }

    private void Q(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mMaskColor != 0) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.mMaskColor);
            canvas.drawRect(0.0f, 0.0f, width, this.jyQ.top, this.mPaint);
            canvas.drawRect(0.0f, this.jyQ.top, this.jyQ.left, this.jyQ.bottom + 1, this.mPaint);
            canvas.drawRect(this.jyQ.right + 1, this.jyQ.top, width, this.jyQ.bottom + 1, this.mPaint);
            canvas.drawRect(0.0f, this.jyQ.bottom + 1, width, height, this.mPaint);
        }
    }

    private void R(Canvas canvas) {
        if (this.jze > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setAntiAlias(false);
            this.mPaint.setStrokeWidth(this.jze);
            canvas.drawRect(this.jyQ, this.mPaint);
        }
    }

    private void S(Canvas canvas) {
        this.mPaint.reset();
        this.mPaint.setAntiAlias(false);
        canvas.drawBitmap(this.jyK, getMainFrameLeft(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jyL, getMainFrameRight() - this.jyK.getWidth(), getMainFrameTop(), this.mPaint);
        canvas.drawBitmap(this.jyM, getMainFrameLeft(), getMainFrameBottom() - this.jyK.getHeight(), this.mPaint);
        canvas.drawBitmap(this.jyN, getMainFrameRight() - this.jyK.getWidth(), getMainFrameBottom() - this.jyK.getHeight(), this.mPaint);
    }

    private int getMainFrameLeft() {
        return (this.jyQ.left - getBitmapOffset()) - 1;
    }

    private int getMainFrameRight() {
        return this.jyQ.right + getBitmapOffset();
    }

    private int getMainFrameTop() {
        return (this.jyQ.top - getBitmapOffset()) - 1;
    }

    private int getMainFrameBottom() {
        return this.jyQ.bottom + getBitmapOffset();
    }

    private int getBitmapOffset() {
        return this.jze / 2;
    }

    private void T(Canvas canvas) {
        if (this.jzi) {
            if (this.jzv != null) {
                RectF rectF = new RectF(this.jyQ.left + this.jzC + 0.5f, this.jyQ.top + this.jzC + this.jza, this.jzx, (this.jyQ.bottom - this.jzC) - this.jza);
                Rect rect = new Rect((int) (this.jzv.getWidth() - rectF.width()), 0, this.jzv.getWidth(), this.jzv.getHeight());
                if (rect.left < 0) {
                    rect.left = 0;
                    rectF.left = rectF.right - rect.width();
                }
                canvas.drawBitmap(this.jzv, rect, rectF, this.mPaint);
            } else if (this.jzd != null) {
                canvas.drawBitmap(this.jzd, (Rect) null, new RectF(this.jyS, this.jyQ.top + this.jzC + this.jza, this.jyS + this.jzd.getWidth(), (this.jyQ.bottom - this.jzC) - this.jza), this.mPaint);
            } else {
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setColor(this.jyZ);
                canvas.drawRect(this.jyS, this.jza + this.jyQ.top + this.jzC, this.jyY + this.jyS, (this.jyQ.bottom - this.jzC) - this.jza, this.mPaint);
            }
        } else if (this.jzv != null) {
            RectF rectF2 = new RectF(this.jyQ.left + this.jzC + this.jza, this.jyQ.top + this.jzC + 0.5f, (this.jyQ.right - this.jzC) - this.jza, this.jzw);
            Rect rect2 = new Rect(0, (int) (this.jzv.getHeight() - rectF2.height()), this.jzv.getWidth(), this.jzv.getHeight());
            if (rect2.top < 0) {
                rect2.top = 0;
                rectF2.top = rectF2.bottom - rect2.height();
            }
            this.mPaint.setColorFilter(this.jzG);
            canvas.drawBitmap(this.jzv, rect2, rectF2, this.mPaint);
        } else if (this.jzd != null) {
            canvas.drawBitmap(this.jzd, (Rect) null, new RectF(this.jyQ.left + this.jzC + this.jza, this.jyR, (this.jyQ.right - this.jzC) - this.jza, this.jyR + this.jzd.getHeight()), this.mPaint);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(this.jyZ);
            canvas.drawRect(this.jza + this.jyQ.left + this.jzC, this.jyR, (this.jyQ.right - this.jzC) - this.jza, this.jyY + this.jyR, this.mPaint);
        }
    }

    private void U(Canvas canvas) {
        if (!TextUtils.isEmpty(this.igh) && this.jzD != null) {
            if (this.jzn) {
                if (this.jzr) {
                    this.mPaint.setColor(this.jzq);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    if (this.jzp) {
                        Rect rect = new Rect();
                        this.jyT.getTextBounds(this.igh, 0, this.igh.length(), rect);
                        float width = ((canvas.getWidth() - rect.width()) / 2) - this.jzE;
                        canvas.drawRoundRect(new RectF(width, (this.jyQ.bottom + this.jzo) - this.jzE, rect.width() + width + (this.jzE * 2), this.jyQ.bottom + this.jzo + this.jzD.getHeight() + this.jzE), this.jzE, this.jzE, this.mPaint);
                    } else {
                        canvas.drawRoundRect(new RectF(this.jyQ.left, (this.jyQ.bottom + this.jzo) - this.jzE, this.jyQ.right, this.jyQ.bottom + this.jzo + this.jzD.getHeight() + this.jzE), this.jzE, this.jzE, this.mPaint);
                    }
                }
                canvas.save();
                if (this.jzp) {
                    canvas.translate(0.0f, this.jyQ.bottom + this.jzo);
                } else {
                    canvas.translate(this.jyQ.left + this.jzE, this.jyQ.bottom + this.jzo);
                }
                this.jzD.draw(canvas);
                canvas.restore();
                return;
            }
            if (this.jzr) {
                this.mPaint.setColor(this.jzq);
                this.mPaint.setStyle(Paint.Style.FILL);
                if (this.jzp) {
                    Rect rect2 = new Rect();
                    this.jyT.getTextBounds(this.igh, 0, this.igh.length(), rect2);
                    float width2 = ((canvas.getWidth() - rect2.width()) / 2) - this.jzE;
                    canvas.drawRoundRect(new RectF(width2, ((this.jyQ.top - this.jzo) - this.jzD.getHeight()) - this.jzE, rect2.width() + width2 + (this.jzE * 2), (this.jyQ.top - this.jzo) + this.jzE), this.jzE, this.jzE, this.mPaint);
                } else {
                    canvas.drawRoundRect(new RectF(this.jyQ.left, ((this.jyQ.top - this.jzo) - this.jzD.getHeight()) - this.jzE, this.jyQ.right, (this.jyQ.top - this.jzo) + this.jzE), this.jzE, this.jzE, this.mPaint);
                }
            }
            canvas.save();
            if (this.jzp) {
                canvas.translate(0.0f, (this.jyQ.top - this.jzo) - this.jzD.getHeight());
            } else {
                canvas.translate(this.jyQ.left + this.jzE, (this.jyQ.top - this.jzo) - this.jzD.getHeight());
            }
            this.jzD.draw(canvas);
            canvas.restore();
        }
    }

    private void czl() {
        if (this.jzi) {
            if (this.jzv == null) {
                this.jyS += this.jyO;
                int i = this.jyY;
                if (this.jzd != null) {
                    i = this.jzd.getWidth();
                }
                if (this.jzs) {
                    if (i + this.jyS > this.jyQ.right - this.jzC || this.jyS < this.jyQ.left + this.jzC) {
                        this.jyO = -this.jyO;
                    }
                } else {
                    if (i + this.jyS > this.jyQ.right - this.jzC) {
                        this.jyS = this.jyQ.left + this.jzC + 0.5f;
                    }
                }
            } else {
                this.jzx += this.jyO;
                if (this.jzx > this.jyQ.right - this.jzC) {
                    this.jzx = this.jyQ.left + this.jzC + 0.5f;
                }
            }
        } else if (this.jzv == null) {
            this.jyR += this.jyO;
            int i2 = this.jyY;
            if (this.jzd != null) {
                i2 = this.jzd.getHeight();
            }
            if (this.jzs) {
                if (i2 + this.jyR > this.jyQ.bottom - this.jzC || this.jyR < this.jyQ.top + this.jzC) {
                    this.jyO = -this.jyO;
                }
            } else {
                if (i2 + this.jyR > this.jyQ.bottom - this.jzC) {
                    this.jyR = this.jyQ.top + this.jzC + 0.5f;
                }
            }
        } else {
            this.jzw += this.jyO;
            if (this.jzw > this.jyQ.bottom - this.jzC) {
                this.jzw = this.jyQ.top + this.jzC + 0.5f;
            }
        }
        postInvalidateDelayed(this.jyP, this.jyQ.left, this.jyQ.top, this.jyQ.right, this.jyQ.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        czm();
    }

    private void czm() {
        int i;
        if (this.jzi) {
            i = this.mTopOffset + this.jzh;
        } else {
            i = this.mTopOffset;
        }
        int width = (getWidth() - this.aUJ) / 2;
        this.jyQ = new Rect(width, i, this.aUJ + width, this.jyW + i);
        if (this.jzi) {
            float f = this.jyQ.left + this.jzC + 0.5f;
            this.jyS = f;
            this.jzx = f;
            return;
        }
        float f2 = this.jyQ.top + this.jzC + 0.5f;
        this.jyR = f2;
        this.jzw = f2;
    }

    public Rect Ay(int i) {
        if (this.jzF) {
            Rect rect = new Rect(this.jyQ);
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
        this.jzi = z;
        if (this.jzu != null || this.jzt) {
            if (this.jzi) {
                this.jzv = this.jzB;
            } else {
                this.jzv = this.jzA;
            }
        } else if (this.jzc != null || this.jzb) {
            if (this.jzi) {
                this.jzd = this.jzz;
            } else {
                this.jzd = this.jzy;
            }
        }
        if (this.jzi) {
            this.igh = this.jzk;
            this.jyW = this.jyX;
            this.jyP = (int) (((this.jzf * 1.0f) * this.jyO) / this.aUJ);
        } else {
            this.igh = this.jzj;
            this.jyW = this.aUJ;
            this.jyP = (int) (((this.jzf * 1.0f) * this.jyO) / this.jyW);
        }
        if (!TextUtils.isEmpty(this.igh)) {
            if (this.jzp) {
                this.jzD = new StaticLayout(this.igh, this.jyT, a.fm(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            } else {
                this.jzD = new StaticLayout(this.igh, this.jyT, this.aUJ - (this.jzE * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            }
        }
        if (this.jzg) {
            int i = a.fm(getContext()).y;
            if (this.jzh == 0) {
                this.mTopOffset = (i - this.jyW) / 2;
            } else if (this.jzi) {
                this.mTopOffset = ((i - this.jyW) / 2) + (this.jzh / 2);
            } else {
                this.mTopOffset = (i - this.jyW) / 2;
            }
        }
        czm();
        postInvalidate();
    }

    public boolean getIsBarcode() {
        return this.jzi;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public int getCornerLength() {
        return this.jyU;
    }

    public void setCornerLength(int i) {
        this.jyU = i;
    }

    public int getCornerSize() {
        return this.jyV;
    }

    public void setCornerSize(int i) {
        this.jyV = i;
    }

    public int getRectWidth() {
        return this.aUJ;
    }

    public void setRectWidth(int i) {
        this.aUJ = i;
    }

    public int getRectHeight() {
        return this.jyW;
    }

    public void setRectHeight(int i) {
        this.jyW = i;
    }

    public int getBarcodeRectHeight() {
        return this.jyX;
    }

    public void setBarcodeRectHeight(int i) {
        this.jyX = i;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public void setTopOffset(int i) {
        this.mTopOffset = i;
    }

    public int getScanLineSize() {
        return this.jyY;
    }

    public void setScanLineSize(int i) {
        this.jyY = i;
    }

    public int getScanLineColor() {
        return this.jyZ;
    }

    public void setScanLineColor(int i) {
        this.jyZ = i;
    }

    public int getScanLineMargin() {
        return this.jza;
    }

    public void setScanLineMargin(int i) {
        this.jza = i;
    }

    public void setShowDefaultScanLineDrawable(boolean z) {
        this.jzb = z;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.jzc;
    }

    public void setCustomScanLineDrawable(Drawable drawable) {
        this.jzc = drawable;
    }

    public Bitmap getScanLineBitmap() {
        return this.jzd;
    }

    public void setScanLineBitmap(Bitmap bitmap) {
        this.jzd = bitmap;
    }

    public int getBorderSize() {
        return this.jze;
    }

    public void setBorderSize(int i) {
        this.jze = i;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        this.mBorderColor = i;
    }

    public int getAnimTime() {
        return this.jzf;
    }

    public void setAnimTime(int i) {
        this.jzf = i;
    }

    public void setCenterVertical(boolean z) {
        this.jzg = z;
    }

    public int getToolbarHeight() {
        return this.jzh;
    }

    public void setToolbarHeight(int i) {
        this.jzh = i;
    }

    public String getQRCodeTipText() {
        return this.jzj;
    }

    public void setQRCodeTipText(String str) {
        this.jzj = str;
    }

    public String getBarCodeTipText() {
        return this.jzk;
    }

    public void setBarCodeTipText(String str) {
        this.jzk = str;
    }

    public String getTipText() {
        return this.igh;
    }

    public void setTipText(String str) {
        this.igh = str;
    }

    public int getTipTextColor() {
        return this.jzm;
    }

    public void setTipTextColor(int i) {
        this.jzm = i;
    }

    public int getTipTextSize() {
        return this.jzl;
    }

    public void setTipTextSize(int i) {
        this.jzl = i;
    }

    public void setTipTextBelowRect(boolean z) {
        this.jzn = z;
    }

    public int getTipTextMargin() {
        return this.jzo;
    }

    public void setTipTextMargin(int i) {
        this.jzo = i;
    }

    public void setShowTipTextAsSingleLine(boolean z) {
        this.jzp = z;
    }

    public void setShowTipBackground(boolean z) {
        this.jzr = z;
    }

    public int getTipBackgroundColor() {
        return this.jzq;
    }

    public void setTipBackgroundColor(int i) {
        this.jzq = i;
    }

    public void setScanLineReverse(boolean z) {
        this.jzs = z;
    }

    public void setShowDefaultGridScanLineDrawable(boolean z) {
        this.jzt = z;
    }

    public float getHalfCornerSize() {
        return this.jzC;
    }

    public void setHalfCornerSize(float f) {
        this.jzC = f;
    }

    public StaticLayout getTipTextSl() {
        return this.jzD;
    }

    public void setTipTextSl(StaticLayout staticLayout) {
        this.jzD = staticLayout;
    }

    public int getTipBackgroundRadius() {
        return this.jzE;
    }

    public void setTipBackgroundRadius(int i) {
        this.jzE = i;
    }

    public void setOnlyDecodeScanBoxArea(boolean z) {
        this.jzF = z;
    }
}
