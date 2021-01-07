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
    private int VV;
    private int VW;
    private int adG;
    private int bbq;
    private float dAb;
    private float dzG;
    private boolean iRD;
    private Context mContext;
    private float mFB;
    private int mIndicatorColor;
    private int mMeasuredWidth;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private float ovA;
    private float ovB;
    private boolean ovC;
    private int ovD;
    private boolean ovE;
    private boolean ovF;
    private boolean ovG;
    private float[] ovH;
    private boolean ovI;
    private boolean ovJ;
    private boolean ovK;
    private int ovL;
    private String[] ovM;
    private float[] ovN;
    private float[] ovO;
    private float ovP;
    private int ovQ;
    private Typeface ovR;
    private int ovS;
    private int ovT;
    private int ovU;
    private CharSequence[] ovV;
    private c ovW;
    private boolean ovX;
    private int ovY;
    private View ovZ;
    private int ovb;
    private Paint ovr;
    private d ovs;
    private float ovt;
    private float ovu;
    private float ovv;
    private boolean ovw;
    private e ovx;
    private float ovy;
    private float ovz;
    private Bitmap owA;
    private int owB;
    private boolean owC;
    private float owD;
    private int owE;
    private boolean owF;
    private boolean owG;
    private View owa;
    private int owb;
    private String owc;
    private float[] owd;
    private int owe;
    private int owf;
    private int owg;
    private Bitmap owh;
    private Bitmap owi;
    private Drawable owj;
    private int owk;
    private boolean owl;
    private boolean owm;
    private int own;
    private boolean owo;
    private RectF owp;
    private RectF owq;
    private int owr;
    private int ows;
    private int owt;
    private int owu;
    private int[] owv;
    private boolean oww;
    private float owx;
    private Bitmap owy;
    private int owz;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ovv = -1.0f;
        this.mFB = -1.0f;
        this.ovD = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cum();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ovv = -1.0f;
        this.mFB = -1.0f;
        this.ovD = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cum();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.ovA = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.oun);
        this.ovB = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.ouo);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.ovC = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.oup);
        this.ovE = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.ous);
        this.ovw = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.ouv);
        this.ovF = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.ouu);
        this.ovG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.ouq);
        this.ovI = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.our);
        this.owr = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.ouC);
        this.ows = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.ouE);
        this.owt = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.ouD);
        this.owu = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.ouF);
        this.owo = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.ouG);
        this.bbq = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.ouJ);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.owG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.ouK);
        this.owC = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.ouI);
        this.owE = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.ouH);
        this.owe = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.ouT);
        this.owk = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.ouU);
        this.own = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.ouW);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.ouV);
        this.owj = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.owm = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.ouZ);
        this.owl = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.ouY);
        this.ovJ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.ouN);
        this.ovQ = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.ouP);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.ouO);
        this.ovV = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.ouR);
        this.owb = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.ouw);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.oux);
        this.ovY = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.ouz);
        this.ovb = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.ouy);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.ovZ = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.owa = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void cum() {
        edB();
        if (this.owr > this.ows) {
            this.owr = this.ows;
        }
        if (this.mThumbDrawable == null) {
            this.dzG = this.bbq / 2.0f;
            this.owx = this.dzG * 1.2f;
        } else {
            this.dzG = Math.min(f.dp2px(this.mContext, 46.0f), this.bbq) / 2.0f;
            this.owx = this.dzG;
        }
        if (this.owj == null) {
            this.dAb = this.own / 2.0f;
        } else {
            this.dAb = Math.min(f.dp2px(this.mContext, 46.0f), this.own) / 2.0f;
        }
        this.ovt = Math.max(this.owx, this.dAb) * 2.0f;
        edC();
        edD();
        this.ovu = this.mProgress;
        edz();
        this.owp = new RectF();
        this.owq = new RectF();
        edA();
        edN();
    }

    private void edz() {
        if (this.owe < 0 || this.owe > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.owe);
        }
        if (this.owe != 0) {
            this.owd = new float[this.owe];
            if (this.ovJ) {
                this.ovO = new float[this.owe];
                this.ovN = new float[this.owe];
            }
            this.ovH = new float[this.owe];
            for (int i = 0; i < this.ovH.length; i++) {
                this.ovH[i] = (((this.ovA - this.ovB) * i) / (this.owe + (-1) > 0 ? this.owe - 1 : 1)) + this.ovB;
            }
        }
    }

    private void edA() {
        if (!this.ovw) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void edB() {
        if (this.ovA < this.ovB) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.ovB) {
            this.mProgress = this.ovB;
        }
        if (this.mProgress > this.ovA) {
            this.mProgress = this.ovA;
        }
    }

    private void edC() {
        if (this.ovr == null) {
            this.ovr = new Paint();
        }
        if (this.owo) {
            this.ovr.setStrokeCap(Paint.Cap.ROUND);
        }
        this.ovr.setAntiAlias(true);
        if (this.owr > this.ows) {
            this.ows = this.owr;
        }
    }

    private void edD() {
        if (edE()) {
            Lg();
            this.mTextPaint.setTypeface(this.ovR);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ovL = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean edE() {
        return this.owC || (this.owe != 0 && this.ovJ);
    }

    private void Lg() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.ovQ);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.ovt + getPaddingTop() + getPaddingBottom()) + this.ovL);
        edF();
        edG();
    }

    private void edF() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.VW = getPaddingLeft();
            this.VV = getPaddingRight();
        } else {
            this.VW = getPaddingStart();
            this.VV = getPaddingEnd();
        }
        this.adG = getPaddingTop();
        this.ovy = (this.mMeasuredWidth - this.VW) - this.VV;
        this.ovz = this.ovy / (this.owe + (-1) > 0 ? this.owe - 1 : 1);
    }

    private void edG() {
        edI();
        if (edE()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ovP = this.adG + this.ovt + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.owD = this.ovP;
        }
        if (this.owd != null) {
            edH();
            if (this.owe > 2) {
                this.mProgress = this.ovH[getClosestIndex()];
                this.ovu = this.mProgress;
            }
            bh(this.mProgress);
        }
    }

    private void edH() {
        if (this.owe != 0) {
            if (this.ovJ) {
                this.ovM = new String[this.owe];
            }
            for (int i = 0; i < this.owd.length; i++) {
                if (this.ovJ) {
                    this.ovM[i] = Nw(i);
                    this.mTextPaint.getTextBounds(this.ovM[i], 0, this.ovM[i].length(), this.mRect);
                    this.ovN[i] = this.mRect.width();
                    this.ovO[i] = this.VW + (this.ovz * i);
                }
                this.owd[i] = this.VW + (this.ovz * i);
            }
        }
    }

    private void edI() {
        if (this.ovI) {
            this.owq.left = this.VW;
            this.owq.top = this.adG + this.owx;
            this.owq.right = this.VW + (this.ovy * (1.0f - ((this.mProgress - this.ovB) / getAmplitude())));
            this.owq.bottom = this.owq.top;
            this.owp.left = this.owq.right;
            this.owp.top = this.owq.top;
            this.owp.right = this.mMeasuredWidth - this.VV;
            this.owp.bottom = this.owq.bottom;
            return;
        }
        this.owp.left = this.VW;
        this.owp.top = this.adG + this.owx;
        this.owp.right = (((this.mProgress - this.ovB) * this.ovy) / getAmplitude()) + this.VW;
        this.owp.bottom = this.owp.top;
        this.owq.left = this.owp.right;
        this.owq.top = this.owp.bottom;
        this.owq.right = this.mMeasuredWidth - this.VV;
        this.owq.bottom = this.owp.bottom;
    }

    private String Nw(int i) {
        if (this.ovV == null) {
            return bl(this.ovH[i]);
        }
        if (i < this.ovV.length) {
            return String.valueOf(this.ovV[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(float f) {
        if (this.ovI) {
            this.owq.right = this.VW + (this.ovy * (1.0f - ((f - this.ovB) / getAmplitude())));
            this.owp.left = this.owq.right;
            return;
        }
        this.owp.right = (((f - this.ovB) * this.ovy) / getAmplitude()) + this.VW;
        this.owq.left = this.owp.right;
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
        if (this.oww) {
            int i = this.owe + (-1) > 0 ? this.owe - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.ovI) {
                    this.ovr.setColor(this.owv[(i - i2) - 1]);
                } else {
                    this.ovr.setColor(this.owv[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.ovr.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.owd[i2], this.owp.top, thumbCenterX, this.owp.bottom, this.ovr);
                    this.ovr.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.owp.top, this.owd[i2 + 1], this.owp.bottom, this.ovr);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.ovr.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.ovr.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.owd[i2], this.owp.top, this.owd[i2 + 1], this.owp.bottom, this.ovr);
                }
            }
            return;
        }
        this.ovr.setColor(this.owu);
        this.ovr.setStrokeWidth(this.ows);
        canvas.drawLine(this.owp.left, this.owp.top, this.owp.right, this.owp.bottom, this.ovr);
        this.ovr.setColor(this.owt);
        this.ovr.setStrokeWidth(this.owr);
        canvas.drawLine(this.owq.left, this.owq.top, this.owq.right, this.owq.bottom, this.ovr);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.owe != 0) {
            if (this.owk != 0 || this.owj != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.owd.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.owm || thumbCenterX < this.owd[i2]) && ((!this.owl || (i2 != 0 && i2 != this.owd.length - 1)) && (i2 != getThumbPosOnTick() || this.owe <= 2 || this.ovG))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.ovr.setColor(getLeftSideTickColor());
                            } else {
                                this.ovr.setColor(getRightSideTickColor());
                            }
                            if (this.owj != null) {
                                if (this.owi == null || this.owh == null) {
                                    edK();
                                }
                                if (this.owi == null || this.owh == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.owi, this.owd[i2] - (this.owh.getWidth() / 2.0f), this.owp.top - (this.owh.getHeight() / 2.0f), this.ovr);
                                } else {
                                    canvas.drawBitmap(this.owh, this.owd[i2] - (this.owh.getWidth() / 2.0f), this.owp.top - (this.owh.getHeight() / 2.0f), this.ovr);
                                }
                            } else if (this.owk == 1) {
                                canvas.drawCircle(this.owd[i2], this.owp.top, this.dAb, this.ovr);
                            } else if (this.owk == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.owd[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.owd[i2] - dp2px, this.owp.top - (rightSideTrackSize / 2.0f), dp2px + this.owd[i2], this.owp.top + (rightSideTrackSize / 2.0f), this.ovr);
                            } else if (this.owk == 2) {
                                canvas.drawRect(this.owd[i2] - (this.own / 2.0f), this.owp.top - (this.own / 2.0f), (this.own / 2.0f) + this.owd[i2], (this.own / 2.0f) + this.owp.top, this.ovr);
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
        if (this.ovM != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.ovM.length; i++) {
                if (!this.ovK || i == 0 || i == this.ovM.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.ovU);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.ovI ? (this.ovM.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.ovM[length], (this.ovN[length] / 2.0f) + this.ovO[i], this.ovP, this.mTextPaint);
                    } else if (i == this.ovM.length - 1) {
                        canvas.drawText(this.ovM[length], this.ovO[i] - (this.ovN[length] / 2.0f), this.ovP, this.mTextPaint);
                    } else {
                        canvas.drawText(this.ovM[length], this.ovO[i], this.ovP, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.owF) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.owy == null || this.owA == null) {
                    edJ();
                }
                if (this.owy == null || this.owA == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.ovr.setAlpha(255);
                if (this.iRD) {
                    canvas.drawBitmap(this.owA, thumbCenterX - (this.owA.getWidth() / 2.0f), this.owp.top - (this.owA.getHeight() / 2.0f), this.ovr);
                    return;
                } else {
                    canvas.drawBitmap(this.owy, thumbCenterX - (this.owy.getWidth() / 2.0f), this.owp.top - (this.owy.getHeight() / 2.0f), this.ovr);
                    return;
                }
            }
            if (this.iRD) {
                this.ovr.setColor(this.owB);
            } else {
                this.ovr.setColor(this.owz);
            }
            canvas.drawCircle(thumbCenterX, this.owp.top, this.iRD ? this.owx : this.dzG, this.ovr);
        }
    }

    private void aA(Canvas canvas) {
        if (this.owC) {
            if (!this.ovJ || this.owe <= 2) {
                this.mTextPaint.setColor(this.owE);
                canvas.drawText(bl(this.mProgress), getThumbCenterX(), this.owD, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.ovI ? this.owq.right : this.owp.right;
    }

    private int getLeftSideTickColor() {
        return this.ovI ? this.owf : this.owg;
    }

    private int getRightSideTickColor() {
        return this.ovI ? this.owg : this.owf;
    }

    private int getLeftSideTickTextsColor() {
        return this.ovI ? this.ovT : this.ovS;
    }

    private int getRightSideTickTextsColor() {
        return this.ovI ? this.ovS : this.ovT;
    }

    private int getLeftSideTrackSize() {
        return this.ovI ? this.owr : this.ows;
    }

    private int getRightSideTrackSize() {
        return this.ovI ? this.ows : this.owr;
    }

    private int getThumbPosOnTick() {
        if (this.owe != 0) {
            return Math.round((getThumbCenterX() - this.VW) / this.ovz);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.owe != 0) {
            return (getThumbCenterX() - this.VW) / this.ovz;
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
                i = this.bbq;
            } else {
                i = this.own;
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
            this.owz = i;
            this.owB = this.owz;
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
                    this.owz = iArr[0];
                    this.owB = this.owz;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.owB = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.owz = iArr[i3];
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
            this.owg = i;
            this.owf = this.owg;
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
                    this.owg = iArr[0];
                    this.owf = this.owg;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.owf = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.owg = iArr[i3];
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
            this.ovT = i;
            this.ovS = this.ovT;
            this.ovU = this.ovT;
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
                    this.ovT = iArr[0];
                    this.ovS = this.ovT;
                    this.ovU = this.ovT;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.ovT = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.ovS = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.ovU = iArr[i3];
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
                this.ovR = Typeface.DEFAULT;
                return;
            case 1:
                this.ovR = Typeface.MONOSPACE;
                return;
            case 2:
                this.ovR = Typeface.SANS_SERIF;
                return;
            case 3:
                this.ovR = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.ovR = Typeface.DEFAULT;
                    return;
                } else {
                    this.ovR = typeface;
                    return;
                }
        }
    }

    private void edJ() {
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
                                    this.owA = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.owy = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.owy = b(this.mThumbDrawable, true);
                    this.owA = this.owy;
                    return;
                }
            }
            this.owy = b(this.mThumbDrawable, true);
            this.owA = this.owy;
        }
    }

    private void edK() {
        if (this.owj instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.owj;
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
                                this.owi = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.owh = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.owh = b(this.owj, false);
                this.owi = this.owh;
                return;
            }
        }
        this.owh = b(this.owj, false);
        this.owi = this.owh;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.ovX) {
                    this.ovZ.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.ovX) {
                this.ovZ.setAlpha(0.3f);
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
        if (this.ovE && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (I(x, motionEvent.getY())) {
                        if (!this.ovF || bk(x)) {
                            this.iRD = true;
                            if (this.ovs != null) {
                                this.ovs.a(this);
                            }
                            ap(motionEvent);
                            return true;
                        }
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    this.iRD = false;
                    if (this.ovs != null) {
                        this.ovs.b(this);
                    }
                    if (!edP()) {
                        invalidate();
                    }
                    if (this.ovW != null) {
                        this.ovW.hide();
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
        bh(bi(bj(aq(motionEvent))));
        setSeekListener(true);
        invalidate();
        edM();
    }

    private boolean edL() {
        return this.ovC ? this.ovu != this.mProgress : Math.round(this.ovu) != Math.round(this.mProgress);
    }

    private float aq(MotionEvent motionEvent) {
        if (motionEvent.getX() < this.VW) {
            return this.VW;
        }
        if (motionEvent.getX() > this.mMeasuredWidth - this.VV) {
            return this.mMeasuredWidth - this.VV;
        }
        return motionEvent.getX();
    }

    private float bi(float f) {
        this.ovu = this.mProgress;
        this.mProgress = this.ovB + ((getAmplitude() * (f - this.VW)) / this.ovy);
        return this.mProgress;
    }

    private float bj(float f) {
        if (this.owe > 2 && !this.ovG) {
            f = (Math.round((f - this.VW) / this.ovz) * this.ovz) + this.VW;
        }
        if (this.ovI) {
            return (this.ovy - f) + (this.VW * 2);
        }
        return f;
    }

    private boolean I(float f, float f2) {
        if (this.ovv == -1.0f) {
            this.ovv = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.VW) - (this.ovv * 2.0f)) ? 1 : (f == (((float) this.VW) - (this.ovv * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.VV)) + (this.ovv * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.VV)) + (this.ovv * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.owp.top - this.owx) - this.ovv) ? 1 : (f2 == ((this.owp.top - this.owx) - this.ovv) ? 0 : -1)) >= 0 && (f2 > ((this.owp.top + this.owx) + this.ovv) ? 1 : (f2 == ((this.owp.top + this.owx) + this.ovv) ? 0 : -1)) <= 0);
    }

    private boolean bk(float f) {
        float f2;
        bh(this.mProgress);
        if (this.ovI) {
            f2 = this.owq.right;
        } else {
            f2 = this.owp.right;
        }
        return f2 - (((float) this.bbq) / 2.0f) <= f && f <= f2 + (((float) this.bbq) / 2.0f);
    }

    private void edM() {
        if (this.ovX) {
            edO();
        } else if (this.ovW != null) {
            this.ovW.edw();
            if (this.ovW.isShowing()) {
                this.ovW.bf(getThumbCenterX());
            } else {
                this.ovW.bg(getThumbCenterX());
            }
        }
    }

    private void edN() {
        if (this.owb != 0 && this.ovW == null) {
            this.ovW = new c(this.mContext, this, this.mIndicatorColor, this.owb, this.ovY, this.ovb, this.ovZ, this.owa);
            this.ovZ = this.ovW.edx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edO() {
        int thumbCenterX;
        int i;
        if (this.ovX && this.ovW != null) {
            this.ovW.VZ(getIndicatorTextString());
            this.ovZ.measure(0, 0);
            int measuredWidth = this.ovZ.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mFB == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mFB = displayMetrics.widthPixels;
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
            this.ovW.Nu(thumbCenterX);
            this.ovW.Nv(i);
        }
    }

    private boolean edP() {
        if (this.owe >= 3 && this.ovG && this.owG) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.ovH[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.ovu = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.ovH[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bh(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.ovW != null && IndicatorSeekBar.this.ovX) {
                        IndicatorSeekBar.this.ovW.edy();
                        IndicatorSeekBar.this.edO();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bl(float f) {
        return this.ovC ? b.b(f, this.ovD) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.ovA - this.ovB);
        int i = 0;
        int i2 = 0;
        while (i < this.ovH.length) {
            float abs2 = Math.abs(this.ovH[i] - this.mProgress);
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
        if (this.ovA - this.ovB > 0.0f) {
            return this.ovA - this.ovB;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.ovs != null && edL()) {
            this.ovs.a(zG(z));
        }
    }

    private e zG(boolean z) {
        if (this.ovx == null) {
            this.ovx = new e(this);
        }
        this.ovx.progress = getProgress();
        this.ovx.owL = getProgressFloat();
        this.ovx.owM = z;
        if (this.owe > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.ovJ && this.ovM != null) {
                this.ovx.owO = this.ovM[thumbPosOnTick];
            }
            if (this.ovI) {
                this.ovx.owN = (this.owe - thumbPosOnTick) - 1;
            } else {
                this.ovx.owN = thumbPosOnTick;
            }
        }
        return this.ovx;
    }

    private void a(a aVar) {
        this.ovA = aVar.oun;
        this.ovB = aVar.ouo;
        this.mProgress = aVar.progress;
        this.ovC = aVar.oup;
        this.owe = aVar.ouT;
        this.ovG = aVar.ouq;
        this.ovI = aVar.our;
        this.ovE = aVar.ous;
        this.ovw = aVar.ouv;
        this.ovF = aVar.ouu;
        this.owb = aVar.ouw;
        this.mIndicatorColor = aVar.oux;
        this.ovb = aVar.ouy;
        this.ovY = aVar.ouz;
        this.ovZ = aVar.ouA;
        this.owa = aVar.ouB;
        this.owr = aVar.ouC;
        this.owt = aVar.ouD;
        this.ows = aVar.ouE;
        this.owu = aVar.ouF;
        this.owo = aVar.ouG;
        this.bbq = aVar.ouJ;
        this.mThumbDrawable = aVar.ouM;
        this.owE = aVar.ouH;
        a(aVar.ouL, aVar.ouK);
        this.owC = aVar.ouI;
        this.owk = aVar.ouU;
        this.own = aVar.ouW;
        this.owj = aVar.ouX;
        this.owl = aVar.ouY;
        this.owm = aVar.ouZ;
        b(aVar.ova, aVar.ouV);
        this.ovJ = aVar.ouN;
        this.ovQ = aVar.ouP;
        this.ovV = aVar.ouQ;
        this.ovR = aVar.ouR;
        c(aVar.ouS, aVar.ouO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void edQ() {
        this.ovZ.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.ovZ.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.edO();
                IndicatorSeekBar.this.ovZ.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.ovX = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.ovZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.owc != null && this.owc.contains("${TICK_TEXT}")) {
            if (this.owe > 2 && this.ovM != null) {
                return this.owc.replace("${TICK_TEXT}", this.ovM[getThumbPosOnTick()]);
            }
        } else if (this.owc != null && this.owc.contains("${PROGRESS}")) {
            return this.owc.replace("${PROGRESS}", bl(this.mProgress));
        }
        return bl(this.mProgress);
    }

    public c getIndicator() {
        return this.ovW;
    }

    public int getTickCount() {
        return this.owe;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.ovD, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.ovA;
    }

    public float getMin() {
        return this.ovB;
    }

    public d getOnSeekChangeListener() {
        return this.ovs;
    }

    public synchronized void setProgress(float f) {
        this.ovu = this.mProgress;
        if (f < this.ovB) {
            f = this.ovB;
        } else if (f > this.ovA) {
            f = this.ovA;
        }
        this.mProgress = f;
        if (!this.ovG && this.owe > 2) {
            this.mProgress = this.ovH[getClosestIndex()];
        }
        setSeekListener(false);
        bh(this.mProgress);
        postInvalidate();
        edO();
    }

    public synchronized void setMax(float f) {
        this.ovA = Math.max(this.ovB, f);
        edB();
        edz();
        edG();
        invalidate();
        edO();
    }

    public synchronized void setMin(float f) {
        this.ovB = Math.min(this.ovA, f);
        edB();
        edz();
        edG();
        invalidate();
        edO();
    }

    public void setR2L(boolean z) {
        this.ovI = z;
        requestLayout();
        invalidate();
        edO();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.owy = null;
            this.owA = null;
        } else {
            this.mThumbDrawable = drawable;
            this.dzG = Math.min(f.dp2px(this.mContext, 46.0f), this.bbq) / 2.0f;
            this.owx = this.dzG;
            this.ovt = Math.max(this.owx, this.dAb) * 2.0f;
            edJ();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.owj = null;
            this.owh = null;
            this.owi = null;
        } else {
            this.owj = drawable;
            this.dAb = Math.min(f.dp2px(this.mContext, 46.0f), this.own) / 2.0f;
            this.ovt = Math.max(this.owx, this.dAb) * 2.0f;
            edK();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.ovD = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.owc = str;
        edH();
        edO();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.ovs = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.ovE = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.owe < 0 || this.owe > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.owe);
        }
        this.owe = i;
        edz();
        edH();
        edF();
        edG();
        invalidate();
        edO();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.owG = z;
    }
}
