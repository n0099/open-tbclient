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
    private boolean iSR;
    private Context mContext;
    private int mIndicatorColor;
    private float mKr;
    private int mMeasuredWidth;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private int oAL;
    private int oBA;
    private Typeface oBB;
    private int oBC;
    private int oBD;
    private int oBE;
    private CharSequence[] oBF;
    private c oBG;
    private boolean oBH;
    private int oBI;
    private View oBJ;
    private View oBK;
    private int oBL;
    private String oBM;
    private float[] oBN;
    private int oBO;
    private int oBP;
    private int oBQ;
    private Bitmap oBR;
    private Bitmap oBS;
    private Drawable oBT;
    private int oBU;
    private boolean oBV;
    private boolean oBW;
    private int oBX;
    private boolean oBY;
    private RectF oBZ;
    private Paint oBb;
    private d oBc;
    private float oBd;
    private float oBe;
    private float oBf;
    private boolean oBg;
    private e oBh;
    private float oBi;
    private float oBj;
    private float oBk;
    private float oBl;
    private boolean oBm;
    private int oBn;
    private boolean oBo;
    private boolean oBp;
    private boolean oBq;
    private float[] oBr;
    private boolean oBs;
    private boolean oBt;
    private boolean oBu;
    private int oBv;
    private String[] oBw;
    private float[] oBx;
    private float[] oBy;
    private float oBz;
    private RectF oCa;
    private int oCb;
    private int oCc;
    private int oCd;
    private int oCe;
    private int[] oCf;
    private boolean oCg;
    private float oCh;
    private Bitmap oCi;
    private int oCj;
    private Bitmap oCk;
    private int oCl;
    private boolean oCm;
    private float oCn;
    private int oCo;
    private boolean oCp;
    private boolean oCq;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oBf = -1.0f;
        this.mKr = -1.0f;
        this.oBn = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crL();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oBf = -1.0f;
        this.mKr = -1.0f;
        this.oBn = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crL();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.oBk = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.ozY);
        this.oBl = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.ozZ);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.oBm = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.oAa);
        this.oBo = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.oAd);
        this.oBg = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.oAf);
        this.oBp = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.oAe);
        this.oBq = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.oAb);
        this.oBs = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.oAc);
        this.oCb = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.oAm);
        this.oCc = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.oAo);
        this.oCd = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.oAn);
        this.oCe = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.oAp);
        this.oBY = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.oAq);
        this.aZI = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.oAt);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.oCq = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.oAu);
        this.oCm = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.oAs);
        this.oCo = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.oAr);
        this.oBO = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.oAD);
        this.oBU = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.oAE);
        this.oBX = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.oAG);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.oAF);
        this.oBT = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.oBW = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.oAJ);
        this.oBV = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.oAI);
        this.oBt = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.oAx);
        this.oBA = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.oAz);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.oAy);
        this.oBF = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.oAB);
        this.oBL = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.oAg);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.oAh);
        this.oBI = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.oAj);
        this.oAL = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.oAi);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.oBJ = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.oBK = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void crL() {
        ece();
        if (this.oCb > this.oCc) {
            this.oCb = this.oCc;
        }
        if (this.mThumbDrawable == null) {
            this.dxc = this.aZI / 2.0f;
            this.oCh = this.dxc * 1.2f;
        } else {
            this.dxc = Math.min(f.dp2px(this.mContext, 46.0f), this.aZI) / 2.0f;
            this.oCh = this.dxc;
        }
        if (this.oBT == null) {
            this.dxw = this.oBX / 2.0f;
        } else {
            this.dxw = Math.min(f.dp2px(this.mContext, 46.0f), this.oBX) / 2.0f;
        }
        this.oBd = Math.max(this.oCh, this.dxw) * 2.0f;
        ecf();
        ecg();
        this.oBe = this.mProgress;
        ecc();
        this.oBZ = new RectF();
        this.oCa = new RectF();
        ecd();
        ecq();
    }

    private void ecc() {
        if (this.oBO < 0 || this.oBO > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oBO);
        }
        if (this.oBO != 0) {
            this.oBN = new float[this.oBO];
            if (this.oBt) {
                this.oBy = new float[this.oBO];
                this.oBx = new float[this.oBO];
            }
            this.oBr = new float[this.oBO];
            for (int i = 0; i < this.oBr.length; i++) {
                this.oBr[i] = (((this.oBk - this.oBl) * i) / (this.oBO + (-1) > 0 ? this.oBO - 1 : 1)) + this.oBl;
            }
        }
    }

    private void ecd() {
        if (!this.oBg) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void ece() {
        if (this.oBk < this.oBl) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.oBl) {
            this.mProgress = this.oBl;
        }
        if (this.mProgress > this.oBk) {
            this.mProgress = this.oBk;
        }
    }

    private void ecf() {
        if (this.oBb == null) {
            this.oBb = new Paint();
        }
        if (this.oBY) {
            this.oBb.setStrokeCap(Paint.Cap.ROUND);
        }
        this.oBb.setAntiAlias(true);
        if (this.oCb > this.oCc) {
            this.oCc = this.oCb;
        }
    }

    private void ecg() {
        if (ech()) {
            IB();
            this.mTextPaint.setTypeface(this.oBB);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oBv = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean ech() {
        return this.oCm || (this.oBO != 0 && this.oBt);
    }

    private void IB() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.oBA);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.oBd + getPaddingTop() + getPaddingBottom()) + this.oBv);
        eci();
        ecj();
    }

    private void eci() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.mPaddingLeft = getPaddingLeft();
            this.mPaddingRight = getPaddingRight();
        } else {
            this.mPaddingLeft = getPaddingStart();
            this.mPaddingRight = getPaddingEnd();
        }
        this.mPaddingTop = getPaddingTop();
        this.oBi = (this.mMeasuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        this.oBj = this.oBi / (this.oBO + (-1) > 0 ? this.oBO - 1 : 1);
    }

    private void ecj() {
        ecl();
        if (ech()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oBz = this.mPaddingTop + this.oBd + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.oCn = this.oBz;
        }
        if (this.oBN != null) {
            eck();
            if (this.oBO > 2) {
                this.mProgress = this.oBr[getClosestIndex()];
                this.oBe = this.mProgress;
            }
            bk(this.mProgress);
        }
    }

    private void eck() {
        if (this.oBO != 0) {
            if (this.oBt) {
                this.oBw = new String[this.oBO];
            }
            for (int i = 0; i < this.oBN.length; i++) {
                if (this.oBt) {
                    this.oBw[i] = Ml(i);
                    this.mTextPaint.getTextBounds(this.oBw[i], 0, this.oBw[i].length(), this.mRect);
                    this.oBx[i] = this.mRect.width();
                    this.oBy[i] = this.mPaddingLeft + (this.oBj * i);
                }
                this.oBN[i] = this.mPaddingLeft + (this.oBj * i);
            }
        }
    }

    private void ecl() {
        if (this.oBs) {
            this.oCa.left = this.mPaddingLeft;
            this.oCa.top = this.mPaddingTop + this.oCh;
            this.oCa.right = this.mPaddingLeft + (this.oBi * (1.0f - ((this.mProgress - this.oBl) / getAmplitude())));
            this.oCa.bottom = this.oCa.top;
            this.oBZ.left = this.oCa.right;
            this.oBZ.top = this.oCa.top;
            this.oBZ.right = this.mMeasuredWidth - this.mPaddingRight;
            this.oBZ.bottom = this.oCa.bottom;
            return;
        }
        this.oBZ.left = this.mPaddingLeft;
        this.oBZ.top = this.mPaddingTop + this.oCh;
        this.oBZ.right = (((this.mProgress - this.oBl) * this.oBi) / getAmplitude()) + this.mPaddingLeft;
        this.oBZ.bottom = this.oBZ.top;
        this.oCa.left = this.oBZ.right;
        this.oCa.top = this.oBZ.bottom;
        this.oCa.right = this.mMeasuredWidth - this.mPaddingRight;
        this.oCa.bottom = this.oBZ.bottom;
    }

    private String Ml(int i) {
        if (this.oBF == null) {
            return bo(this.oBr[i]);
        }
        if (i < this.oBF.length) {
            return String.valueOf(this.oBF[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(float f) {
        if (this.oBs) {
            this.oCa.right = this.mPaddingLeft + (this.oBi * (1.0f - ((f - this.oBl) / getAmplitude())));
            this.oBZ.left = this.oCa.right;
            return;
        }
        this.oBZ.right = (((f - this.oBl) * this.oBi) / getAmplitude()) + this.mPaddingLeft;
        this.oCa.left = this.oBZ.right;
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
        if (this.oCg) {
            int i = this.oBO + (-1) > 0 ? this.oBO - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.oBs) {
                    this.oBb.setColor(this.oCf[(i - i2) - 1]);
                } else {
                    this.oBb.setColor(this.oCf[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.oBb.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.oBN[i2], this.oBZ.top, thumbCenterX, this.oBZ.bottom, this.oBb);
                    this.oBb.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.oBZ.top, this.oBN[i2 + 1], this.oBZ.bottom, this.oBb);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.oBb.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.oBb.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.oBN[i2], this.oBZ.top, this.oBN[i2 + 1], this.oBZ.bottom, this.oBb);
                }
            }
            return;
        }
        this.oBb.setColor(this.oCe);
        this.oBb.setStrokeWidth(this.oCc);
        canvas.drawLine(this.oBZ.left, this.oBZ.top, this.oBZ.right, this.oBZ.bottom, this.oBb);
        this.oBb.setColor(this.oCd);
        this.oBb.setStrokeWidth(this.oCb);
        canvas.drawLine(this.oCa.left, this.oCa.top, this.oCa.right, this.oCa.bottom, this.oBb);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.oBO != 0) {
            if (this.oBU != 0 || this.oBT != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.oBN.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.oBW || thumbCenterX < this.oBN[i2]) && ((!this.oBV || (i2 != 0 && i2 != this.oBN.length - 1)) && (i2 != getThumbPosOnTick() || this.oBO <= 2 || this.oBq))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.oBb.setColor(getLeftSideTickColor());
                            } else {
                                this.oBb.setColor(getRightSideTickColor());
                            }
                            if (this.oBT != null) {
                                if (this.oBS == null || this.oBR == null) {
                                    ecn();
                                }
                                if (this.oBS == null || this.oBR == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.oBS, this.oBN[i2] - (this.oBR.getWidth() / 2.0f), this.oBZ.top - (this.oBR.getHeight() / 2.0f), this.oBb);
                                } else {
                                    canvas.drawBitmap(this.oBR, this.oBN[i2] - (this.oBR.getWidth() / 2.0f), this.oBZ.top - (this.oBR.getHeight() / 2.0f), this.oBb);
                                }
                            } else if (this.oBU == 1) {
                                canvas.drawCircle(this.oBN[i2], this.oBZ.top, this.dxw, this.oBb);
                            } else if (this.oBU == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.oBN[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.oBN[i2] - dp2px, this.oBZ.top - (rightSideTrackSize / 2.0f), dp2px + this.oBN[i2], this.oBZ.top + (rightSideTrackSize / 2.0f), this.oBb);
                            } else if (this.oBU == 2) {
                                canvas.drawRect(this.oBN[i2] - (this.oBX / 2.0f), this.oBZ.top - (this.oBX / 2.0f), (this.oBX / 2.0f) + this.oBN[i2], (this.oBX / 2.0f) + this.oBZ.top, this.oBb);
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
        if (this.oBw != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.oBw.length; i++) {
                if (!this.oBu || i == 0 || i == this.oBw.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.oBE);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.oBs ? (this.oBw.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.oBw[length], (this.oBx[length] / 2.0f) + this.oBy[i], this.oBz, this.mTextPaint);
                    } else if (i == this.oBw.length - 1) {
                        canvas.drawText(this.oBw[length], this.oBy[i] - (this.oBx[length] / 2.0f), this.oBz, this.mTextPaint);
                    } else {
                        canvas.drawText(this.oBw[length], this.oBy[i], this.oBz, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.oCp) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.oCi == null || this.oCk == null) {
                    ecm();
                }
                if (this.oCi == null || this.oCk == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.oBb.setAlpha(255);
                if (this.iSR) {
                    canvas.drawBitmap(this.oCk, thumbCenterX - (this.oCk.getWidth() / 2.0f), this.oBZ.top - (this.oCk.getHeight() / 2.0f), this.oBb);
                    return;
                } else {
                    canvas.drawBitmap(this.oCi, thumbCenterX - (this.oCi.getWidth() / 2.0f), this.oBZ.top - (this.oCi.getHeight() / 2.0f), this.oBb);
                    return;
                }
            }
            if (this.iSR) {
                this.oBb.setColor(this.oCl);
            } else {
                this.oBb.setColor(this.oCj);
            }
            canvas.drawCircle(thumbCenterX, this.oBZ.top, this.iSR ? this.oCh : this.dxc, this.oBb);
        }
    }

    private void aA(Canvas canvas) {
        if (this.oCm) {
            if (!this.oBt || this.oBO <= 2) {
                this.mTextPaint.setColor(this.oCo);
                canvas.drawText(bo(this.mProgress), getThumbCenterX(), this.oCn, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.oBs ? this.oCa.right : this.oBZ.right;
    }

    private int getLeftSideTickColor() {
        return this.oBs ? this.oBP : this.oBQ;
    }

    private int getRightSideTickColor() {
        return this.oBs ? this.oBQ : this.oBP;
    }

    private int getLeftSideTickTextsColor() {
        return this.oBs ? this.oBD : this.oBC;
    }

    private int getRightSideTickTextsColor() {
        return this.oBs ? this.oBC : this.oBD;
    }

    private int getLeftSideTrackSize() {
        return this.oBs ? this.oCb : this.oCc;
    }

    private int getRightSideTrackSize() {
        return this.oBs ? this.oCc : this.oCb;
    }

    private int getThumbPosOnTick() {
        if (this.oBO != 0) {
            return Math.round((getThumbCenterX() - this.mPaddingLeft) / this.oBj);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.oBO != 0) {
            return (getThumbCenterX() - this.mPaddingLeft) / this.oBj;
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
                i = this.oBX;
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
            this.oCj = i;
            this.oCl = this.oCj;
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
                    this.oCj = iArr[0];
                    this.oCl = this.oCj;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oCl = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.oCj = iArr[i3];
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
            this.oBQ = i;
            this.oBP = this.oBQ;
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
                    this.oBQ = iArr[0];
                    this.oBP = this.oBQ;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oBP = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oBQ = iArr[i3];
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
            this.oBD = i;
            this.oBC = this.oBD;
            this.oBE = this.oBD;
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
                    this.oBD = iArr[0];
                    this.oBC = this.oBD;
                    this.oBE = this.oBD;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oBD = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oBC = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.oBE = iArr[i3];
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
                this.oBB = Typeface.DEFAULT;
                return;
            case 1:
                this.oBB = Typeface.MONOSPACE;
                return;
            case 2:
                this.oBB = Typeface.SANS_SERIF;
                return;
            case 3:
                this.oBB = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.oBB = Typeface.DEFAULT;
                    return;
                } else {
                    this.oBB = typeface;
                    return;
                }
        }
    }

    private void ecm() {
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
                                    this.oCk = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.oCi = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.oCi = b(this.mThumbDrawable, true);
                    this.oCk = this.oCi;
                    return;
                }
            }
            this.oCi = b(this.mThumbDrawable, true);
            this.oCk = this.oCi;
        }
    }

    private void ecn() {
        if (this.oBT instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.oBT;
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
                                this.oBS = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.oBR = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.oBR = b(this.oBT, false);
                this.oBS = this.oBR;
                return;
            }
        }
        this.oBR = b(this.oBT, false);
        this.oBS = this.oBR;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.oBH) {
                    this.oBJ.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.oBH) {
                this.oBJ.setAlpha(0.3f);
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
        if (this.oBo && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (J(x, motionEvent.getY())) {
                        if (!this.oBp || bn(x)) {
                            this.iSR = true;
                            if (this.oBc != null) {
                                this.oBc.a(this);
                            }
                            ap(motionEvent);
                            return true;
                        }
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    this.iSR = false;
                    if (this.oBc != null) {
                        this.oBc.b(this);
                    }
                    if (!ecs()) {
                        invalidate();
                    }
                    if (this.oBG != null) {
                        this.oBG.hide();
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
        ecp();
    }

    private boolean eco() {
        return this.oBm ? this.oBe != this.mProgress : Math.round(this.oBe) != Math.round(this.mProgress);
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
        this.oBe = this.mProgress;
        this.mProgress = this.oBl + ((getAmplitude() * (f - this.mPaddingLeft)) / this.oBi);
        return this.mProgress;
    }

    private float bm(float f) {
        if (this.oBO > 2 && !this.oBq) {
            f = (Math.round((f - this.mPaddingLeft) / this.oBj) * this.oBj) + this.mPaddingLeft;
        }
        if (this.oBs) {
            return (this.oBi - f) + (this.mPaddingLeft * 2);
        }
        return f;
    }

    private boolean J(float f, float f2) {
        if (this.oBf == -1.0f) {
            this.oBf = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.mPaddingLeft) - (this.oBf * 2.0f)) ? 1 : (f == (((float) this.mPaddingLeft) - (this.oBf * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oBf * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oBf * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.oBZ.top - this.oCh) - this.oBf) ? 1 : (f2 == ((this.oBZ.top - this.oCh) - this.oBf) ? 0 : -1)) >= 0 && (f2 > ((this.oBZ.top + this.oCh) + this.oBf) ? 1 : (f2 == ((this.oBZ.top + this.oCh) + this.oBf) ? 0 : -1)) <= 0);
    }

    private boolean bn(float f) {
        float f2;
        bk(this.mProgress);
        if (this.oBs) {
            f2 = this.oCa.right;
        } else {
            f2 = this.oBZ.right;
        }
        return f2 - (((float) this.aZI) / 2.0f) <= f && f <= f2 + (((float) this.aZI) / 2.0f);
    }

    private void ecp() {
        if (this.oBH) {
            ecr();
        } else if (this.oBG != null) {
            this.oBG.ebZ();
            if (this.oBG.isShowing()) {
                this.oBG.bi(getThumbCenterX());
            } else {
                this.oBG.bj(getThumbCenterX());
            }
        }
    }

    private void ecq() {
        if (this.oBL != 0 && this.oBG == null) {
            this.oBG = new c(this.mContext, this, this.mIndicatorColor, this.oBL, this.oBI, this.oAL, this.oBJ, this.oBK);
            this.oBJ = this.oBG.eca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecr() {
        int thumbCenterX;
        int i;
        if (this.oBH && this.oBG != null) {
            this.oBG.Wc(getIndicatorTextString());
            this.oBJ.measure(0, 0);
            int measuredWidth = this.oBJ.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mKr == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mKr = displayMetrics.widthPixels;
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
            this.oBG.Mj(thumbCenterX);
            this.oBG.Mk(i);
        }
    }

    private boolean ecs() {
        if (this.oBO >= 3 && this.oBq && this.oCq) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.oBr[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.oBe = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.oBr[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bk(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.oBG != null && IndicatorSeekBar.this.oBH) {
                        IndicatorSeekBar.this.oBG.ecb();
                        IndicatorSeekBar.this.ecr();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bo(float f) {
        return this.oBm ? b.b(f, this.oBn) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.oBk - this.oBl);
        int i = 0;
        int i2 = 0;
        while (i < this.oBr.length) {
            float abs2 = Math.abs(this.oBr[i] - this.mProgress);
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
        if (this.oBk - this.oBl > 0.0f) {
            return this.oBk - this.oBl;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.oBc != null && eco()) {
            this.oBc.a(zY(z));
        }
    }

    private e zY(boolean z) {
        if (this.oBh == null) {
            this.oBh = new e(this);
        }
        this.oBh.progress = getProgress();
        this.oBh.oCv = getProgressFloat();
        this.oBh.oCw = z;
        if (this.oBO > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.oBt && this.oBw != null) {
                this.oBh.oCy = this.oBw[thumbPosOnTick];
            }
            if (this.oBs) {
                this.oBh.oCx = (this.oBO - thumbPosOnTick) - 1;
            } else {
                this.oBh.oCx = thumbPosOnTick;
            }
        }
        return this.oBh;
    }

    private void a(a aVar) {
        this.oBk = aVar.ozY;
        this.oBl = aVar.ozZ;
        this.mProgress = aVar.progress;
        this.oBm = aVar.oAa;
        this.oBO = aVar.oAD;
        this.oBq = aVar.oAb;
        this.oBs = aVar.oAc;
        this.oBo = aVar.oAd;
        this.oBg = aVar.oAf;
        this.oBp = aVar.oAe;
        this.oBL = aVar.oAg;
        this.mIndicatorColor = aVar.oAh;
        this.oAL = aVar.oAi;
        this.oBI = aVar.oAj;
        this.oBJ = aVar.oAk;
        this.oBK = aVar.oAl;
        this.oCb = aVar.oAm;
        this.oCd = aVar.oAn;
        this.oCc = aVar.oAo;
        this.oCe = aVar.oAp;
        this.oBY = aVar.oAq;
        this.aZI = aVar.oAt;
        this.mThumbDrawable = aVar.oAw;
        this.oCo = aVar.oAr;
        a(aVar.oAv, aVar.oAu);
        this.oCm = aVar.oAs;
        this.oBU = aVar.oAE;
        this.oBX = aVar.oAG;
        this.oBT = aVar.oAH;
        this.oBV = aVar.oAI;
        this.oBW = aVar.oAJ;
        b(aVar.oAK, aVar.oAF);
        this.oBt = aVar.oAx;
        this.oBA = aVar.oAz;
        this.oBF = aVar.oAA;
        this.oBB = aVar.oAB;
        c(aVar.oAC, aVar.oAy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ect() {
        this.oBJ.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.oBJ.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.ecr();
                IndicatorSeekBar.this.oBJ.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.oBH = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.oBJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.oBM != null && this.oBM.contains("${TICK_TEXT}")) {
            if (this.oBO > 2 && this.oBw != null) {
                return this.oBM.replace("${TICK_TEXT}", this.oBw[getThumbPosOnTick()]);
            }
        } else if (this.oBM != null && this.oBM.contains("${PROGRESS}")) {
            return this.oBM.replace("${PROGRESS}", bo(this.mProgress));
        }
        return bo(this.mProgress);
    }

    public c getIndicator() {
        return this.oBG;
    }

    public int getTickCount() {
        return this.oBO;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.oBn, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.oBk;
    }

    public float getMin() {
        return this.oBl;
    }

    public d getOnSeekChangeListener() {
        return this.oBc;
    }

    public synchronized void setProgress(float f) {
        this.oBe = this.mProgress;
        if (f < this.oBl) {
            f = this.oBl;
        } else if (f > this.oBk) {
            f = this.oBk;
        }
        this.mProgress = f;
        if (!this.oBq && this.oBO > 2) {
            this.mProgress = this.oBr[getClosestIndex()];
        }
        setSeekListener(false);
        bk(this.mProgress);
        postInvalidate();
        ecr();
    }

    public synchronized void setMax(float f) {
        this.oBk = Math.max(this.oBl, f);
        ece();
        ecc();
        ecj();
        invalidate();
        ecr();
    }

    public synchronized void setMin(float f) {
        this.oBl = Math.min(this.oBk, f);
        ece();
        ecc();
        ecj();
        invalidate();
        ecr();
    }

    public void setR2L(boolean z) {
        this.oBs = z;
        requestLayout();
        invalidate();
        ecr();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.oCi = null;
            this.oCk = null;
        } else {
            this.mThumbDrawable = drawable;
            this.dxc = Math.min(f.dp2px(this.mContext, 46.0f), this.aZI) / 2.0f;
            this.oCh = this.dxc;
            this.oBd = Math.max(this.oCh, this.dxw) * 2.0f;
            ecm();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.oBT = null;
            this.oBR = null;
            this.oBS = null;
        } else {
            this.oBT = drawable;
            this.dxw = Math.min(f.dp2px(this.mContext, 46.0f), this.oBX) / 2.0f;
            this.oBd = Math.max(this.oCh, this.dxw) * 2.0f;
            ecn();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.oBn = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.oBM = str;
        eck();
        ecr();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.oBc = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.oBo = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.oBO < 0 || this.oBO > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oBO);
        }
        this.oBO = i;
        ecc();
        eck();
        eci();
        ecj();
        invalidate();
        ecr();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.oCq = z;
    }
}
