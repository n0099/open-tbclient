package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.live.sdk.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
/* loaded from: classes11.dex */
public class IndicatorSeekBar extends View {
    private int aZI;
    private float dxc;
    private float dxw;
    private boolean iSD;
    private Context mContext;
    private int mIndicatorColor;
    private float mKc;
    private int mMeasuredWidth;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private Paint oAB;
    private d oAC;
    private float oAD;
    private float oAE;
    private float oAF;
    private boolean oAG;
    private e oAH;
    private float oAI;
    private float oAJ;
    private float oAK;
    private float oAL;
    private boolean oAM;
    private int oAN;
    private boolean oAO;
    private boolean oAP;
    private boolean oAQ;
    private float[] oAR;
    private boolean oAS;
    private boolean oAT;
    private boolean oAU;
    private int oAV;
    private String[] oAW;
    private float[] oAX;
    private float[] oAY;
    private float oAZ;
    private int oAl;
    private RectF oBA;
    private int oBB;
    private int oBC;
    private int oBD;
    private int oBE;
    private int[] oBF;
    private boolean oBG;
    private float oBH;
    private Bitmap oBI;
    private int oBJ;
    private Bitmap oBK;
    private int oBL;
    private boolean oBM;
    private float oBN;
    private int oBO;
    private boolean oBP;
    private boolean oBQ;
    private int oBa;
    private Typeface oBb;
    private int oBc;
    private int oBd;
    private int oBe;
    private CharSequence[] oBf;
    private c oBg;
    private boolean oBh;
    private int oBi;
    private View oBj;
    private View oBk;
    private int oBl;
    private String oBm;
    private float[] oBn;
    private int oBo;
    private int oBp;
    private int oBq;
    private Bitmap oBr;
    private Bitmap oBs;
    private Drawable oBt;
    private int oBu;
    private boolean oBv;
    private boolean oBw;
    private int oBx;
    private boolean oBy;
    private RectF oBz;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oAF = -1.0f;
        this.mKc = -1.0f;
        this.oAN = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crE();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oAF = -1.0f;
        this.mKc = -1.0f;
        this.oAN = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crE();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.oAK = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.ozy);
        this.oAL = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.ozz);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.oAM = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.ozA);
        this.oAO = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.ozD);
        this.oAG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.ozF);
        this.oAP = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.ozE);
        this.oAQ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.ozB);
        this.oAS = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.ozC);
        this.oBB = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.ozM);
        this.oBC = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.ozO);
        this.oBD = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.ozN);
        this.oBE = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.ozP);
        this.oBy = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.ozQ);
        this.aZI = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.ozT);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.oBQ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.ozU);
        this.oBM = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.ozS);
        this.oBO = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.ozR);
        this.oBo = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.oAd);
        this.oBu = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.oAe);
        this.oBx = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.oAg);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.oAf);
        this.oBt = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.oBw = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.oAj);
        this.oBv = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.oAi);
        this.oAT = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.ozX);
        this.oBa = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.ozZ);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.ozY);
        this.oBf = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.oAb);
        this.oBl = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.ozG);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.ozH);
        this.oBi = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.ozJ);
        this.oAl = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.ozI);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.oBj = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.oBk = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void crE() {
        ebW();
        if (this.oBB > this.oBC) {
            this.oBB = this.oBC;
        }
        if (this.mThumbDrawable == null) {
            this.dxc = this.aZI / 2.0f;
            this.oBH = this.dxc * 1.2f;
        } else {
            this.dxc = Math.min(f.dp2px(this.mContext, 46.0f), this.aZI) / 2.0f;
            this.oBH = this.dxc;
        }
        if (this.oBt == null) {
            this.dxw = this.oBx / 2.0f;
        } else {
            this.dxw = Math.min(f.dp2px(this.mContext, 46.0f), this.oBx) / 2.0f;
        }
        this.oAD = Math.max(this.oBH, this.dxw) * 2.0f;
        ebX();
        ebY();
        this.oAE = this.mProgress;
        ebU();
        this.oBz = new RectF();
        this.oBA = new RectF();
        ebV();
        eci();
    }

    private void ebU() {
        if (this.oBo < 0 || this.oBo > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oBo);
        }
        if (this.oBo != 0) {
            this.oBn = new float[this.oBo];
            if (this.oAT) {
                this.oAY = new float[this.oBo];
                this.oAX = new float[this.oBo];
            }
            this.oAR = new float[this.oBo];
            for (int i = 0; i < this.oAR.length; i++) {
                this.oAR[i] = (((this.oAK - this.oAL) * i) / (this.oBo + (-1) > 0 ? this.oBo - 1 : 1)) + this.oAL;
            }
        }
    }

    private void ebV() {
        if (!this.oAG) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void ebW() {
        if (this.oAK < this.oAL) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.oAL) {
            this.mProgress = this.oAL;
        }
        if (this.mProgress > this.oAK) {
            this.mProgress = this.oAK;
        }
    }

    private void ebX() {
        if (this.oAB == null) {
            this.oAB = new Paint();
        }
        if (this.oBy) {
            this.oAB.setStrokeCap(Paint.Cap.ROUND);
        }
        this.oAB.setAntiAlias(true);
        if (this.oBB > this.oBC) {
            this.oBC = this.oBB;
        }
    }

    private void ebY() {
        if (ebZ()) {
            IB();
            this.mTextPaint.setTypeface(this.oBb);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oAV = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean ebZ() {
        return this.oBM || (this.oBo != 0 && this.oAT);
    }

    private void IB() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.oBa);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.oAD + getPaddingTop() + getPaddingBottom()) + this.oAV);
        eca();
        ecb();
    }

    private void eca() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.mPaddingLeft = getPaddingLeft();
            this.mPaddingRight = getPaddingRight();
        } else {
            this.mPaddingLeft = getPaddingStart();
            this.mPaddingRight = getPaddingEnd();
        }
        this.mPaddingTop = getPaddingTop();
        this.oAI = (this.mMeasuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        this.oAJ = this.oAI / (this.oBo + (-1) > 0 ? this.oBo - 1 : 1);
    }

    private void ecb() {
        ecd();
        if (ebZ()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oAZ = this.mPaddingTop + this.oAD + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.oBN = this.oAZ;
        }
        if (this.oBn != null) {
            ecc();
            if (this.oBo > 2) {
                this.mProgress = this.oAR[getClosestIndex()];
                this.oAE = this.mProgress;
            }
            bk(this.mProgress);
        }
    }

    private void ecc() {
        if (this.oBo != 0) {
            if (this.oAT) {
                this.oAW = new String[this.oBo];
            }
            for (int i = 0; i < this.oBn.length; i++) {
                if (this.oAT) {
                    this.oAW[i] = Mk(i);
                    this.mTextPaint.getTextBounds(this.oAW[i], 0, this.oAW[i].length(), this.mRect);
                    this.oAX[i] = this.mRect.width();
                    this.oAY[i] = this.mPaddingLeft + (this.oAJ * i);
                }
                this.oBn[i] = this.mPaddingLeft + (this.oAJ * i);
            }
        }
    }

    private void ecd() {
        if (this.oAS) {
            this.oBA.left = this.mPaddingLeft;
            this.oBA.top = this.mPaddingTop + this.oBH;
            this.oBA.right = this.mPaddingLeft + (this.oAI * (1.0f - ((this.mProgress - this.oAL) / getAmplitude())));
            this.oBA.bottom = this.oBA.top;
            this.oBz.left = this.oBA.right;
            this.oBz.top = this.oBA.top;
            this.oBz.right = this.mMeasuredWidth - this.mPaddingRight;
            this.oBz.bottom = this.oBA.bottom;
            return;
        }
        this.oBz.left = this.mPaddingLeft;
        this.oBz.top = this.mPaddingTop + this.oBH;
        this.oBz.right = (((this.mProgress - this.oAL) * this.oAI) / getAmplitude()) + this.mPaddingLeft;
        this.oBz.bottom = this.oBz.top;
        this.oBA.left = this.oBz.right;
        this.oBA.top = this.oBz.bottom;
        this.oBA.right = this.mMeasuredWidth - this.mPaddingRight;
        this.oBA.bottom = this.oBz.bottom;
    }

    private String Mk(int i) {
        if (this.oBf == null) {
            return bo(this.oAR[i]);
        }
        if (i < this.oBf.length) {
            return String.valueOf(this.oBf[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(float f) {
        if (this.oAS) {
            this.oBA.right = this.mPaddingLeft + (this.oAI * (1.0f - ((f - this.oAL) / getAmplitude())));
            this.oBz.left = this.oBA.right;
            return;
        }
        this.oBz.right = (((f - this.oAL) * this.oAI) / getAmplitude()) + this.mPaddingLeft;
        this.oBA.left = this.oBz.right;
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        ax(canvas);
        drawTickMarks(canvas);
        ay(canvas);
        az(canvas);
        aA(canvas);
    }

    private void ax(Canvas canvas) {
        if (this.oBG) {
            int i = this.oBo + (-1) > 0 ? this.oBo - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.oAS) {
                    this.oAB.setColor(this.oBF[(i - i2) - 1]);
                } else {
                    this.oAB.setColor(this.oBF[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.oAB.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.oBn[i2], this.oBz.top, thumbCenterX, this.oBz.bottom, this.oAB);
                    this.oAB.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.oBz.top, this.oBn[i2 + 1], this.oBz.bottom, this.oAB);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.oAB.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.oAB.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.oBn[i2], this.oBz.top, this.oBn[i2 + 1], this.oBz.bottom, this.oAB);
                }
            }
            return;
        }
        this.oAB.setColor(this.oBE);
        this.oAB.setStrokeWidth(this.oBC);
        canvas.drawLine(this.oBz.left, this.oBz.top, this.oBz.right, this.oBz.bottom, this.oAB);
        this.oAB.setColor(this.oBD);
        this.oAB.setStrokeWidth(this.oBB);
        canvas.drawLine(this.oBA.left, this.oBA.top, this.oBA.right, this.oBA.bottom, this.oAB);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.oBo != 0) {
            if (this.oBu != 0 || this.oBt != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.oBn.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.oBw || thumbCenterX < this.oBn[i2]) && ((!this.oBv || (i2 != 0 && i2 != this.oBn.length - 1)) && (i2 != getThumbPosOnTick() || this.oBo <= 2 || this.oAQ))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.oAB.setColor(getLeftSideTickColor());
                            } else {
                                this.oAB.setColor(getRightSideTickColor());
                            }
                            if (this.oBt != null) {
                                if (this.oBs == null || this.oBr == null) {
                                    ecf();
                                }
                                if (this.oBs == null || this.oBr == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.oBs, this.oBn[i2] - (this.oBr.getWidth() / 2.0f), this.oBz.top - (this.oBr.getHeight() / 2.0f), this.oAB);
                                } else {
                                    canvas.drawBitmap(this.oBr, this.oBn[i2] - (this.oBr.getWidth() / 2.0f), this.oBz.top - (this.oBr.getHeight() / 2.0f), this.oAB);
                                }
                            } else if (this.oBu == 1) {
                                canvas.drawCircle(this.oBn[i2], this.oBz.top, this.dxw, this.oAB);
                            } else if (this.oBu == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.oBn[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.oBn[i2] - dp2px, this.oBz.top - (rightSideTrackSize / 2.0f), dp2px + this.oBn[i2], this.oBz.top + (rightSideTrackSize / 2.0f), this.oAB);
                            } else if (this.oBu == 2) {
                                canvas.drawRect(this.oBn[i2] - (this.oBx / 2.0f), this.oBz.top - (this.oBx / 2.0f), (this.oBx / 2.0f) + this.oBn[i2], (this.oBx / 2.0f) + this.oBz.top, this.oAB);
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            }
        }
    }

    private void ay(Canvas canvas) {
        if (this.oAW != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.oAW.length; i++) {
                if (!this.oAU || i == 0 || i == this.oAW.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.oBe);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.oAS ? (this.oAW.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.oAW[length], (this.oAX[length] / 2.0f) + this.oAY[i], this.oAZ, this.mTextPaint);
                    } else if (i == this.oAW.length - 1) {
                        canvas.drawText(this.oAW[length], this.oAY[i] - (this.oAX[length] / 2.0f), this.oAZ, this.mTextPaint);
                    } else {
                        canvas.drawText(this.oAW[length], this.oAY[i], this.oAZ, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.oBP) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.oBI == null || this.oBK == null) {
                    ece();
                }
                if (this.oBI == null || this.oBK == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.oAB.setAlpha(255);
                if (this.iSD) {
                    canvas.drawBitmap(this.oBK, thumbCenterX - (this.oBK.getWidth() / 2.0f), this.oBz.top - (this.oBK.getHeight() / 2.0f), this.oAB);
                    return;
                } else {
                    canvas.drawBitmap(this.oBI, thumbCenterX - (this.oBI.getWidth() / 2.0f), this.oBz.top - (this.oBI.getHeight() / 2.0f), this.oAB);
                    return;
                }
            }
            if (this.iSD) {
                this.oAB.setColor(this.oBL);
            } else {
                this.oAB.setColor(this.oBJ);
            }
            canvas.drawCircle(thumbCenterX, this.oBz.top, this.iSD ? this.oBH : this.dxc, this.oAB);
        }
    }

    private void aA(Canvas canvas) {
        if (this.oBM) {
            if (!this.oAT || this.oBo <= 2) {
                this.mTextPaint.setColor(this.oBO);
                canvas.drawText(bo(this.mProgress), getThumbCenterX(), this.oBN, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.oAS ? this.oBA.right : this.oBz.right;
    }

    private int getLeftSideTickColor() {
        return this.oAS ? this.oBp : this.oBq;
    }

    private int getRightSideTickColor() {
        return this.oAS ? this.oBq : this.oBp;
    }

    private int getLeftSideTickTextsColor() {
        return this.oAS ? this.oBd : this.oBc;
    }

    private int getRightSideTickTextsColor() {
        return this.oAS ? this.oBc : this.oBd;
    }

    private int getLeftSideTrackSize() {
        return this.oAS ? this.oBB : this.oBC;
    }

    private int getRightSideTrackSize() {
        return this.oAS ? this.oBC : this.oBB;
    }

    private int getThumbPosOnTick() {
        if (this.oBo != 0) {
            return Math.round((getThumbCenterX() - this.mPaddingLeft) / this.oAJ);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.oBo != 0) {
            return (getThumbCenterX() - this.mPaddingLeft) / this.oAJ;
        }
        return 0.0f;
    }

    private int g(Drawable drawable, int i) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        return Math.round((drawable.getIntrinsicHeight() * (1.0f * i)) / intrinsicWidth);
    }

    private Bitmap b(Drawable drawable, boolean z) {
        int intrinsicHeight;
        int i;
        if (drawable == null) {
            return null;
        }
        int dp2px = f.dp2px(this.mContext, 46.0f);
        if (drawable.getIntrinsicWidth() > dp2px) {
            if (z) {
                i = this.aZI;
            } else {
                i = this.oBx;
            }
            intrinsicHeight = g(drawable, i);
            if (i > dp2px) {
                intrinsicHeight = g(drawable, dp2px);
            } else {
                dp2px = i;
            }
        } else {
            dp2px = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(dp2px, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private void a(ColorStateList colorStateList, int i) {
        int[] iArr = null;
        if (colorStateList == null) {
            this.oBJ = i;
            this.oBL = this.oBJ;
            return;
        }
        int[][] iArr2 = null;
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            int[][] iArr3 = iArr2;
            while (i2 < length) {
                Field field = declaredFields[i2];
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr3 = (int[][]) field.get(colorStateList);
                }
                i2++;
                iArr = "mColors".equals(field.getName()) ? (int[]) field.get(colorStateList) : iArr;
            }
            if (iArr3 != null && iArr != null) {
                if (iArr3.length == 1) {
                    this.oBJ = iArr[0];
                    this.oBL = this.oBJ;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oBL = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.oBJ = iArr[i3];
                                    break;
                                default:
                                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void b(ColorStateList colorStateList, int i) {
        int[] iArr = null;
        if (colorStateList == null) {
            this.oBq = i;
            this.oBp = this.oBq;
            return;
        }
        int[][] iArr2 = null;
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            int[][] iArr3 = iArr2;
            while (i2 < length) {
                Field field = declaredFields[i2];
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr3 = (int[][]) field.get(colorStateList);
                }
                i2++;
                iArr = "mColors".equals(field.getName()) ? (int[]) field.get(colorStateList) : iArr;
            }
            if (iArr3 != null && iArr != null) {
                if (iArr3.length == 1) {
                    this.oBq = iArr[0];
                    this.oBp = this.oBq;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oBp = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oBq = iArr[i3];
                                    break;
                                default:
                                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e.getMessage());
        }
    }

    private void c(ColorStateList colorStateList, int i) {
        int[] iArr = null;
        if (colorStateList == null) {
            this.oBd = i;
            this.oBc = this.oBd;
            this.oBe = this.oBd;
            return;
        }
        int[][] iArr2 = null;
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            int[][] iArr3 = iArr2;
            while (i2 < length) {
                Field field = declaredFields[i2];
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr3 = (int[][]) field.get(colorStateList);
                }
                i2++;
                iArr = "mColors".equals(field.getName()) ? (int[]) field.get(colorStateList) : iArr;
            }
            if (iArr3 != null && iArr != null) {
                if (iArr3.length == 1) {
                    this.oBd = iArr[0];
                    this.oBc = this.oBd;
                    this.oBe = this.oBd;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oBd = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oBc = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.oBe = iArr[i3];
                                    continue;
                                default:
                                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void a(int i, Typeface typeface) {
        switch (i) {
            case 0:
                this.oBb = Typeface.DEFAULT;
                return;
            case 1:
                this.oBb = Typeface.MONOSPACE;
                return;
            case 2:
                this.oBb = Typeface.SANS_SERIF;
                return;
            case 3:
                this.oBb = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.oBb = Typeface.DEFAULT;
                    return;
                } else {
                    this.oBb = typeface;
                    return;
                }
        }
    }

    private void ece() {
        if (this.mThumbDrawable != null) {
            if (this.mThumbDrawable instanceof StateListDrawable) {
                try {
                    StateListDrawable stateListDrawable = (StateListDrawable) this.mThumbDrawable;
                    Class<?> cls = stateListDrawable.getClass();
                    int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                    if (intValue == 2) {
                        Method method = cls.getMethod("getStateSet", Integer.TYPE);
                        Method method2 = cls.getMethod("getStateDrawable", Integer.TYPE);
                        for (int i = 0; i < intValue; i++) {
                            int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                            if (iArr.length > 0) {
                                if (iArr[0] == 16842919) {
                                    this.oBK = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.oBI = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.oBI = b(this.mThumbDrawable, true);
                    this.oBK = this.oBI;
                    return;
                }
            }
            this.oBI = b(this.mThumbDrawable, true);
            this.oBK = this.oBI;
        }
    }

    private void ecf() {
        if (this.oBt instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.oBt;
            try {
                Class<?> cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Method method = cls.getMethod("getStateSet", Integer.TYPE);
                    Method method2 = cls.getMethod("getStateDrawable", Integer.TYPE);
                    for (int i = 0; i < intValue; i++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i));
                        if (iArr.length > 0) {
                            if (iArr[0] == 16842913) {
                                this.oBs = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.oBr = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.oBr = b(this.oBt, false);
                this.oBs = this.oBr;
                return;
            }
        }
        this.oBr = b(this.oBt, false);
        this.oBs = this.oBr;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.oBh) {
                    this.oBj.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.oBh) {
                this.oBj.setAlpha(0.3f);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.1
            @Override // java.lang.Runnable
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                parent.requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                parent.requestDisallowInterceptTouchEvent(false);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.mProgress);
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setProgress(bundle.getFloat("isb_progress"));
            super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oAO && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (J(x, motionEvent.getY())) {
                        if (!this.oAP || bn(x)) {
                            this.iSD = true;
                            if (this.oAC != null) {
                                this.oAC.a(this);
                            }
                            ap(motionEvent);
                            return true;
                        }
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    this.iSD = false;
                    if (this.oAC != null) {
                        this.oAC.b(this);
                    }
                    if (!eck()) {
                        invalidate();
                    }
                    if (this.oBg != null) {
                        this.oBg.hide();
                        break;
                    }
                    break;
                case 2:
                    ap(motionEvent);
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    private void ap(MotionEvent motionEvent) {
        bk(bl(bm(aq(motionEvent))));
        setSeekListener(true);
        invalidate();
        ech();
    }

    private boolean ecg() {
        return this.oAM ? this.oAE != this.mProgress : Math.round(this.oAE) != Math.round(this.mProgress);
    }

    private float aq(MotionEvent motionEvent) {
        if (motionEvent.getX() < this.mPaddingLeft) {
            return this.mPaddingLeft;
        }
        if (motionEvent.getX() > this.mMeasuredWidth - this.mPaddingRight) {
            return this.mMeasuredWidth - this.mPaddingRight;
        }
        return motionEvent.getX();
    }

    private float bl(float f) {
        this.oAE = this.mProgress;
        this.mProgress = this.oAL + ((getAmplitude() * (f - this.mPaddingLeft)) / this.oAI);
        return this.mProgress;
    }

    private float bm(float f) {
        if (this.oBo > 2 && !this.oAQ) {
            f = (Math.round((f - this.mPaddingLeft) / this.oAJ) * this.oAJ) + this.mPaddingLeft;
        }
        if (this.oAS) {
            return (this.oAI - f) + (this.mPaddingLeft * 2);
        }
        return f;
    }

    private boolean J(float f, float f2) {
        if (this.oAF == -1.0f) {
            this.oAF = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.mPaddingLeft) - (this.oAF * 2.0f)) ? 1 : (f == (((float) this.mPaddingLeft) - (this.oAF * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oAF * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oAF * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.oBz.top - this.oBH) - this.oAF) ? 1 : (f2 == ((this.oBz.top - this.oBH) - this.oAF) ? 0 : -1)) >= 0 && (f2 > ((this.oBz.top + this.oBH) + this.oAF) ? 1 : (f2 == ((this.oBz.top + this.oBH) + this.oAF) ? 0 : -1)) <= 0);
    }

    private boolean bn(float f) {
        float f2;
        bk(this.mProgress);
        if (this.oAS) {
            f2 = this.oBA.right;
        } else {
            f2 = this.oBz.right;
        }
        return f2 - (((float) this.aZI) / 2.0f) <= f && f <= f2 + (((float) this.aZI) / 2.0f);
    }

    private void ech() {
        if (this.oBh) {
            ecj();
        } else if (this.oBg != null) {
            this.oBg.ebR();
            if (this.oBg.isShowing()) {
                this.oBg.bi(getThumbCenterX());
            } else {
                this.oBg.bj(getThumbCenterX());
            }
        }
    }

    private void eci() {
        if (this.oBl != 0 && this.oBg == null) {
            this.oBg = new c(this.mContext, this, this.mIndicatorColor, this.oBl, this.oBi, this.oAl, this.oBj, this.oBk);
            this.oBj = this.oBg.ebS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecj() {
        int thumbCenterX;
        int i;
        if (this.oBh && this.oBg != null) {
            this.oBg.VQ(getIndicatorTextString());
            this.oBj.measure(0, 0);
            int measuredWidth = this.oBj.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mKc == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mKc = displayMetrics.widthPixels;
                }
            }
            if ((measuredWidth / 2) + thumbCenterX2 > this.mMeasuredWidth) {
                int i2 = this.mMeasuredWidth - measuredWidth;
                i = (int) ((thumbCenterX2 - i2) - (measuredWidth / 2));
                thumbCenterX = i2;
            } else if (thumbCenterX2 - (measuredWidth / 2) < 0.0f) {
                i = -((int) ((measuredWidth / 2) - thumbCenterX2));
                thumbCenterX = 0;
            } else {
                thumbCenterX = (int) (getThumbCenterX() - (measuredWidth / 2));
                i = 0;
            }
            this.oBg.Mi(thumbCenterX);
            this.oBg.Mj(i);
        }
    }

    private boolean eck() {
        if (this.oBo >= 3 && this.oAQ && this.oBQ) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.oAR[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.oAE = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.oAR[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bk(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.oBg != null && IndicatorSeekBar.this.oBh) {
                        IndicatorSeekBar.this.oBg.ebT();
                        IndicatorSeekBar.this.ecj();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bo(float f) {
        return this.oAM ? b.b(f, this.oAN) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.oAK - this.oAL);
        int i = 0;
        int i2 = 0;
        while (i < this.oAR.length) {
            float abs2 = Math.abs(this.oAR[i] - this.mProgress);
            if (abs2 <= abs) {
                i2 = i;
            } else {
                abs2 = abs;
            }
            i++;
            abs = abs2;
        }
        return i2;
    }

    private float getAmplitude() {
        if (this.oAK - this.oAL > 0.0f) {
            return this.oAK - this.oAL;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.oAC != null && ecg()) {
            this.oAC.a(zY(z));
        }
    }

    private e zY(boolean z) {
        if (this.oAH == null) {
            this.oAH = new e(this);
        }
        this.oAH.progress = getProgress();
        this.oAH.oBV = getProgressFloat();
        this.oAH.oBW = z;
        if (this.oBo > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.oAT && this.oAW != null) {
                this.oAH.oBY = this.oAW[thumbPosOnTick];
            }
            if (this.oAS) {
                this.oAH.oBX = (this.oBo - thumbPosOnTick) - 1;
            } else {
                this.oAH.oBX = thumbPosOnTick;
            }
        }
        return this.oAH;
    }

    private void a(a aVar) {
        this.oAK = aVar.ozy;
        this.oAL = aVar.ozz;
        this.mProgress = aVar.progress;
        this.oAM = aVar.ozA;
        this.oBo = aVar.oAd;
        this.oAQ = aVar.ozB;
        this.oAS = aVar.ozC;
        this.oAO = aVar.ozD;
        this.oAG = aVar.ozF;
        this.oAP = aVar.ozE;
        this.oBl = aVar.ozG;
        this.mIndicatorColor = aVar.ozH;
        this.oAl = aVar.ozI;
        this.oBi = aVar.ozJ;
        this.oBj = aVar.ozK;
        this.oBk = aVar.ozL;
        this.oBB = aVar.ozM;
        this.oBD = aVar.ozN;
        this.oBC = aVar.ozO;
        this.oBE = aVar.ozP;
        this.oBy = aVar.ozQ;
        this.aZI = aVar.ozT;
        this.mThumbDrawable = aVar.ozW;
        this.oBO = aVar.ozR;
        a(aVar.ozV, aVar.ozU);
        this.oBM = aVar.ozS;
        this.oBu = aVar.oAe;
        this.oBx = aVar.oAg;
        this.oBt = aVar.oAh;
        this.oBv = aVar.oAi;
        this.oBw = aVar.oAj;
        b(aVar.oAk, aVar.oAf);
        this.oAT = aVar.ozX;
        this.oBa = aVar.ozZ;
        this.oBf = aVar.oAa;
        this.oBb = aVar.oAb;
        c(aVar.oAc, aVar.ozY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ecl() {
        this.oBj.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.oBj.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.ecj();
                IndicatorSeekBar.this.oBj.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.oBh = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.oBj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.oBm != null && this.oBm.contains("${TICK_TEXT}")) {
            if (this.oBo > 2 && this.oAW != null) {
                return this.oBm.replace("${TICK_TEXT}", this.oAW[getThumbPosOnTick()]);
            }
        } else if (this.oBm != null && this.oBm.contains("${PROGRESS}")) {
            return this.oBm.replace("${PROGRESS}", bo(this.mProgress));
        }
        return bo(this.mProgress);
    }

    public c getIndicator() {
        return this.oBg;
    }

    public int getTickCount() {
        return this.oBo;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.oAN, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.oAK;
    }

    public float getMin() {
        return this.oAL;
    }

    public d getOnSeekChangeListener() {
        return this.oAC;
    }

    public synchronized void setProgress(float f) {
        this.oAE = this.mProgress;
        if (f < this.oAL) {
            f = this.oAL;
        } else if (f > this.oAK) {
            f = this.oAK;
        }
        this.mProgress = f;
        if (!this.oAQ && this.oBo > 2) {
            this.mProgress = this.oAR[getClosestIndex()];
        }
        setSeekListener(false);
        bk(this.mProgress);
        postInvalidate();
        ecj();
    }

    public synchronized void setMax(float f) {
        this.oAK = Math.max(this.oAL, f);
        ebW();
        ebU();
        ecb();
        invalidate();
        ecj();
    }

    public synchronized void setMin(float f) {
        this.oAL = Math.min(this.oAK, f);
        ebW();
        ebU();
        ecb();
        invalidate();
        ecj();
    }

    public void setR2L(boolean z) {
        this.oAS = z;
        requestLayout();
        invalidate();
        ecj();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.oBI = null;
            this.oBK = null;
        } else {
            this.mThumbDrawable = drawable;
            this.dxc = Math.min(f.dp2px(this.mContext, 46.0f), this.aZI) / 2.0f;
            this.oBH = this.dxc;
            this.oAD = Math.max(this.oBH, this.dxw) * 2.0f;
            ece();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.oBt = null;
            this.oBr = null;
            this.oBs = null;
        } else {
            this.oBt = drawable;
            this.dxw = Math.min(f.dp2px(this.mContext, 46.0f), this.oBx) / 2.0f;
            this.oAD = Math.max(this.oBH, this.dxw) * 2.0f;
            ecf();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.oAN = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.oBm = str;
        ecc();
        ecj();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.oAC = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.oAO = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.oBo < 0 || this.oBo > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oBo);
        }
        this.oBo = i;
        ebU();
        ecc();
        eca();
        ecb();
        invalidate();
        ecj();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.oBQ = z;
    }
}
