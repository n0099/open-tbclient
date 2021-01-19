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
/* loaded from: classes10.dex */
public class IndicatorSeekBar extends View {
    private int VT;
    private int VU;
    private int aWC;
    private int adE;
    private float duU;
    private float dvp;
    private boolean iMW;
    private float mAS;
    private Context mContext;
    private int mIndicatorColor;
    private int mMeasuredWidth;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private Paint oqL;
    private d oqM;
    private float oqN;
    private float oqO;
    private float oqP;
    private boolean oqQ;
    private e oqR;
    private float oqS;
    private float oqT;
    private float oqU;
    private float oqV;
    private boolean oqW;
    private int oqX;
    private boolean oqY;
    private boolean oqZ;
    private int oqv;
    private int orA;
    private int orB;
    private Bitmap orC;
    private Bitmap orD;
    private Drawable orE;
    private int orF;
    private boolean orG;
    private boolean orH;
    private int orI;
    private boolean orJ;
    private RectF orK;
    private RectF orL;
    private int orM;
    private int orN;
    private int orO;
    private int orP;
    private int[] orQ;
    private boolean orR;
    private float orS;
    private Bitmap orT;
    private int orU;
    private Bitmap orV;
    private int orW;
    private boolean orX;
    private float orY;
    private int orZ;
    private boolean ora;
    private float[] orb;
    private boolean orc;
    private boolean ord;
    private boolean ore;
    private int orf;
    private String[] orh;
    private float[] ori;
    private float[] orj;
    private float ork;
    private int orl;
    private Typeface orm;
    private int orn;
    private int oro;
    private int orp;
    private CharSequence[] orq;
    private c orr;
    private boolean ors;
    private int ort;
    private View oru;
    private View orv;
    private int orw;
    private String orx;
    private float[] ory;
    private int orz;
    private boolean osa;
    private boolean osb;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oqP = -1.0f;
        this.mAS = -1.0f;
        this.oqX = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cqu();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oqP = -1.0f;
        this.mAS = -1.0f;
        this.oqX = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cqu();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.oqU = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.opI);
        this.oqV = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.opJ);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.oqW = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.opK);
        this.oqY = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.opN);
        this.oqQ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.opP);
        this.oqZ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.opO);
        this.ora = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.opL);
        this.orc = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.opM);
        this.orM = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.opW);
        this.orN = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.opY);
        this.orO = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.opX);
        this.orP = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.opZ);
        this.orJ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.oqa);
        this.aWC = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.oqd);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.osb = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.oqe);
        this.orX = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.oqc);
        this.orZ = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.oqb);
        this.orz = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.oqn);
        this.orF = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.oqo);
        this.orI = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.oqq);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.oqp);
        this.orE = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.orH = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.oqt);
        this.orG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.oqs);
        this.ord = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.oqh);
        this.orl = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.oqj);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.oqi);
        this.orq = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.oql);
        this.orw = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.opQ);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.opR);
        this.ort = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.opT);
        this.oqv = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.opS);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.oru = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.orv = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void cqu() {
        dZJ();
        if (this.orM > this.orN) {
            this.orM = this.orN;
        }
        if (this.mThumbDrawable == null) {
            this.duU = this.aWC / 2.0f;
            this.orS = this.duU * 1.2f;
        } else {
            this.duU = Math.min(f.dp2px(this.mContext, 46.0f), this.aWC) / 2.0f;
            this.orS = this.duU;
        }
        if (this.orE == null) {
            this.dvp = this.orI / 2.0f;
        } else {
            this.dvp = Math.min(f.dp2px(this.mContext, 46.0f), this.orI) / 2.0f;
        }
        this.oqN = Math.max(this.orS, this.dvp) * 2.0f;
        dZK();
        dZL();
        this.oqO = this.mProgress;
        dZH();
        this.orK = new RectF();
        this.orL = new RectF();
        dZI();
        dZV();
    }

    private void dZH() {
        if (this.orz < 0 || this.orz > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.orz);
        }
        if (this.orz != 0) {
            this.ory = new float[this.orz];
            if (this.ord) {
                this.orj = new float[this.orz];
                this.ori = new float[this.orz];
            }
            this.orb = new float[this.orz];
            for (int i = 0; i < this.orb.length; i++) {
                this.orb[i] = (((this.oqU - this.oqV) * i) / (this.orz + (-1) > 0 ? this.orz - 1 : 1)) + this.oqV;
            }
        }
    }

    private void dZI() {
        if (!this.oqQ) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void dZJ() {
        if (this.oqU < this.oqV) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.oqV) {
            this.mProgress = this.oqV;
        }
        if (this.mProgress > this.oqU) {
            this.mProgress = this.oqU;
        }
    }

    private void dZK() {
        if (this.oqL == null) {
            this.oqL = new Paint();
        }
        if (this.orJ) {
            this.oqL.setStrokeCap(Paint.Cap.ROUND);
        }
        this.oqL.setAntiAlias(true);
        if (this.orM > this.orN) {
            this.orN = this.orM;
        }
    }

    private void dZL() {
        if (dZM()) {
            Hl();
            this.mTextPaint.setTypeface(this.orm);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.orf = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean dZM() {
        return this.orX || (this.orz != 0 && this.ord);
    }

    private void Hl() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.orl);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.oqN + getPaddingTop() + getPaddingBottom()) + this.orf);
        dZN();
        dZO();
    }

    private void dZN() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.VU = getPaddingLeft();
            this.VT = getPaddingRight();
        } else {
            this.VU = getPaddingStart();
            this.VT = getPaddingEnd();
        }
        this.adE = getPaddingTop();
        this.oqS = (this.mMeasuredWidth - this.VU) - this.VT;
        this.oqT = this.oqS / (this.orz + (-1) > 0 ? this.orz - 1 : 1);
    }

    private void dZO() {
        dZQ();
        if (dZM()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ork = this.adE + this.oqN + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.orY = this.ork;
        }
        if (this.ory != null) {
            dZP();
            if (this.orz > 2) {
                this.mProgress = this.orb[getClosestIndex()];
                this.oqO = this.mProgress;
            }
            bh(this.mProgress);
        }
    }

    private void dZP() {
        if (this.orz != 0) {
            if (this.ord) {
                this.orh = new String[this.orz];
            }
            for (int i = 0; i < this.ory.length; i++) {
                if (this.ord) {
                    this.orh[i] = LP(i);
                    this.mTextPaint.getTextBounds(this.orh[i], 0, this.orh[i].length(), this.mRect);
                    this.ori[i] = this.mRect.width();
                    this.orj[i] = this.VU + (this.oqT * i);
                }
                this.ory[i] = this.VU + (this.oqT * i);
            }
        }
    }

    private void dZQ() {
        if (this.orc) {
            this.orL.left = this.VU;
            this.orL.top = this.adE + this.orS;
            this.orL.right = this.VU + (this.oqS * (1.0f - ((this.mProgress - this.oqV) / getAmplitude())));
            this.orL.bottom = this.orL.top;
            this.orK.left = this.orL.right;
            this.orK.top = this.orL.top;
            this.orK.right = this.mMeasuredWidth - this.VT;
            this.orK.bottom = this.orL.bottom;
            return;
        }
        this.orK.left = this.VU;
        this.orK.top = this.adE + this.orS;
        this.orK.right = (((this.mProgress - this.oqV) * this.oqS) / getAmplitude()) + this.VU;
        this.orK.bottom = this.orK.top;
        this.orL.left = this.orK.right;
        this.orL.top = this.orK.bottom;
        this.orL.right = this.mMeasuredWidth - this.VT;
        this.orL.bottom = this.orK.bottom;
    }

    private String LP(int i) {
        if (this.orq == null) {
            return bl(this.orb[i]);
        }
        if (i < this.orq.length) {
            return String.valueOf(this.orq[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(float f) {
        if (this.orc) {
            this.orL.right = this.VU + (this.oqS * (1.0f - ((f - this.oqV) / getAmplitude())));
            this.orK.left = this.orL.right;
            return;
        }
        this.orK.right = (((f - this.oqV) * this.oqS) / getAmplitude()) + this.VU;
        this.orL.left = this.orK.right;
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
        if (this.orR) {
            int i = this.orz + (-1) > 0 ? this.orz - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.orc) {
                    this.oqL.setColor(this.orQ[(i - i2) - 1]);
                } else {
                    this.oqL.setColor(this.orQ[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.oqL.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.ory[i2], this.orK.top, thumbCenterX, this.orK.bottom, this.oqL);
                    this.oqL.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.orK.top, this.ory[i2 + 1], this.orK.bottom, this.oqL);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.oqL.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.oqL.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.ory[i2], this.orK.top, this.ory[i2 + 1], this.orK.bottom, this.oqL);
                }
            }
            return;
        }
        this.oqL.setColor(this.orP);
        this.oqL.setStrokeWidth(this.orN);
        canvas.drawLine(this.orK.left, this.orK.top, this.orK.right, this.orK.bottom, this.oqL);
        this.oqL.setColor(this.orO);
        this.oqL.setStrokeWidth(this.orM);
        canvas.drawLine(this.orL.left, this.orL.top, this.orL.right, this.orL.bottom, this.oqL);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.orz != 0) {
            if (this.orF != 0 || this.orE != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.ory.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.orH || thumbCenterX < this.ory[i2]) && ((!this.orG || (i2 != 0 && i2 != this.ory.length - 1)) && (i2 != getThumbPosOnTick() || this.orz <= 2 || this.ora))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.oqL.setColor(getLeftSideTickColor());
                            } else {
                                this.oqL.setColor(getRightSideTickColor());
                            }
                            if (this.orE != null) {
                                if (this.orD == null || this.orC == null) {
                                    dZS();
                                }
                                if (this.orD == null || this.orC == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.orD, this.ory[i2] - (this.orC.getWidth() / 2.0f), this.orK.top - (this.orC.getHeight() / 2.0f), this.oqL);
                                } else {
                                    canvas.drawBitmap(this.orC, this.ory[i2] - (this.orC.getWidth() / 2.0f), this.orK.top - (this.orC.getHeight() / 2.0f), this.oqL);
                                }
                            } else if (this.orF == 1) {
                                canvas.drawCircle(this.ory[i2], this.orK.top, this.dvp, this.oqL);
                            } else if (this.orF == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.ory[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.ory[i2] - dp2px, this.orK.top - (rightSideTrackSize / 2.0f), dp2px + this.ory[i2], this.orK.top + (rightSideTrackSize / 2.0f), this.oqL);
                            } else if (this.orF == 2) {
                                canvas.drawRect(this.ory[i2] - (this.orI / 2.0f), this.orK.top - (this.orI / 2.0f), (this.orI / 2.0f) + this.ory[i2], (this.orI / 2.0f) + this.orK.top, this.oqL);
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
        if (this.orh != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.orh.length; i++) {
                if (!this.ore || i == 0 || i == this.orh.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.orp);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.orc ? (this.orh.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.orh[length], (this.ori[length] / 2.0f) + this.orj[i], this.ork, this.mTextPaint);
                    } else if (i == this.orh.length - 1) {
                        canvas.drawText(this.orh[length], this.orj[i] - (this.ori[length] / 2.0f), this.ork, this.mTextPaint);
                    } else {
                        canvas.drawText(this.orh[length], this.orj[i], this.ork, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.osa) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.orT == null || this.orV == null) {
                    dZR();
                }
                if (this.orT == null || this.orV == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.oqL.setAlpha(255);
                if (this.iMW) {
                    canvas.drawBitmap(this.orV, thumbCenterX - (this.orV.getWidth() / 2.0f), this.orK.top - (this.orV.getHeight() / 2.0f), this.oqL);
                    return;
                } else {
                    canvas.drawBitmap(this.orT, thumbCenterX - (this.orT.getWidth() / 2.0f), this.orK.top - (this.orT.getHeight() / 2.0f), this.oqL);
                    return;
                }
            }
            if (this.iMW) {
                this.oqL.setColor(this.orW);
            } else {
                this.oqL.setColor(this.orU);
            }
            canvas.drawCircle(thumbCenterX, this.orK.top, this.iMW ? this.orS : this.duU, this.oqL);
        }
    }

    private void aA(Canvas canvas) {
        if (this.orX) {
            if (!this.ord || this.orz <= 2) {
                this.mTextPaint.setColor(this.orZ);
                canvas.drawText(bl(this.mProgress), getThumbCenterX(), this.orY, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.orc ? this.orL.right : this.orK.right;
    }

    private int getLeftSideTickColor() {
        return this.orc ? this.orA : this.orB;
    }

    private int getRightSideTickColor() {
        return this.orc ? this.orB : this.orA;
    }

    private int getLeftSideTickTextsColor() {
        return this.orc ? this.oro : this.orn;
    }

    private int getRightSideTickTextsColor() {
        return this.orc ? this.orn : this.oro;
    }

    private int getLeftSideTrackSize() {
        return this.orc ? this.orM : this.orN;
    }

    private int getRightSideTrackSize() {
        return this.orc ? this.orN : this.orM;
    }

    private int getThumbPosOnTick() {
        if (this.orz != 0) {
            return Math.round((getThumbCenterX() - this.VU) / this.oqT);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.orz != 0) {
            return (getThumbCenterX() - this.VU) / this.oqT;
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
                i = this.aWC;
            } else {
                i = this.orI;
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
            this.orU = i;
            this.orW = this.orU;
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
                    this.orU = iArr[0];
                    this.orW = this.orU;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.orW = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.orU = iArr[i3];
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
            this.orB = i;
            this.orA = this.orB;
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
                    this.orB = iArr[0];
                    this.orA = this.orB;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.orA = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.orB = iArr[i3];
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
            this.oro = i;
            this.orn = this.oro;
            this.orp = this.oro;
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
                    this.oro = iArr[0];
                    this.orn = this.oro;
                    this.orp = this.oro;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oro = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.orn = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.orp = iArr[i3];
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
                this.orm = Typeface.DEFAULT;
                return;
            case 1:
                this.orm = Typeface.MONOSPACE;
                return;
            case 2:
                this.orm = Typeface.SANS_SERIF;
                return;
            case 3:
                this.orm = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.orm = Typeface.DEFAULT;
                    return;
                } else {
                    this.orm = typeface;
                    return;
                }
        }
    }

    private void dZR() {
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
                                    this.orV = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.orT = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.orT = b(this.mThumbDrawable, true);
                    this.orV = this.orT;
                    return;
                }
            }
            this.orT = b(this.mThumbDrawable, true);
            this.orV = this.orT;
        }
    }

    private void dZS() {
        if (this.orE instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.orE;
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
                                this.orD = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.orC = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.orC = b(this.orE, false);
                this.orD = this.orC;
                return;
            }
        }
        this.orC = b(this.orE, false);
        this.orD = this.orC;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.ors) {
                    this.oru.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.ors) {
                this.oru.setAlpha(0.3f);
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
        if (this.oqY && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (J(x, motionEvent.getY())) {
                        if (!this.oqZ || bk(x)) {
                            this.iMW = true;
                            if (this.oqM != null) {
                                this.oqM.a(this);
                            }
                            ap(motionEvent);
                            return true;
                        }
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    this.iMW = false;
                    if (this.oqM != null) {
                        this.oqM.b(this);
                    }
                    if (!dZX()) {
                        invalidate();
                    }
                    if (this.orr != null) {
                        this.orr.hide();
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
        dZU();
    }

    private boolean dZT() {
        return this.oqW ? this.oqO != this.mProgress : Math.round(this.oqO) != Math.round(this.mProgress);
    }

    private float aq(MotionEvent motionEvent) {
        if (motionEvent.getX() < this.VU) {
            return this.VU;
        }
        if (motionEvent.getX() > this.mMeasuredWidth - this.VT) {
            return this.mMeasuredWidth - this.VT;
        }
        return motionEvent.getX();
    }

    private float bi(float f) {
        this.oqO = this.mProgress;
        this.mProgress = this.oqV + ((getAmplitude() * (f - this.VU)) / this.oqS);
        return this.mProgress;
    }

    private float bj(float f) {
        if (this.orz > 2 && !this.ora) {
            f = (Math.round((f - this.VU) / this.oqT) * this.oqT) + this.VU;
        }
        if (this.orc) {
            return (this.oqS - f) + (this.VU * 2);
        }
        return f;
    }

    private boolean J(float f, float f2) {
        if (this.oqP == -1.0f) {
            this.oqP = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.VU) - (this.oqP * 2.0f)) ? 1 : (f == (((float) this.VU) - (this.oqP * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.VT)) + (this.oqP * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.VT)) + (this.oqP * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.orK.top - this.orS) - this.oqP) ? 1 : (f2 == ((this.orK.top - this.orS) - this.oqP) ? 0 : -1)) >= 0 && (f2 > ((this.orK.top + this.orS) + this.oqP) ? 1 : (f2 == ((this.orK.top + this.orS) + this.oqP) ? 0 : -1)) <= 0);
    }

    private boolean bk(float f) {
        float f2;
        bh(this.mProgress);
        if (this.orc) {
            f2 = this.orL.right;
        } else {
            f2 = this.orK.right;
        }
        return f2 - (((float) this.aWC) / 2.0f) <= f && f <= f2 + (((float) this.aWC) / 2.0f);
    }

    private void dZU() {
        if (this.ors) {
            dZW();
        } else if (this.orr != null) {
            this.orr.dZE();
            if (this.orr.isShowing()) {
                this.orr.bf(getThumbCenterX());
            } else {
                this.orr.bg(getThumbCenterX());
            }
        }
    }

    private void dZV() {
        if (this.orw != 0 && this.orr == null) {
            this.orr = new c(this.mContext, this, this.mIndicatorColor, this.orw, this.ort, this.oqv, this.oru, this.orv);
            this.oru = this.orr.dZF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZW() {
        int thumbCenterX;
        int i;
        if (this.ors && this.orr != null) {
            this.orr.US(getIndicatorTextString());
            this.oru.measure(0, 0);
            int measuredWidth = this.oru.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mAS == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mAS = displayMetrics.widthPixels;
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
            this.orr.LN(thumbCenterX);
            this.orr.LO(i);
        }
    }

    private boolean dZX() {
        if (this.orz >= 3 && this.ora && this.osb) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.orb[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.oqO = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.orb[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bh(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.orr != null && IndicatorSeekBar.this.ors) {
                        IndicatorSeekBar.this.orr.dZG();
                        IndicatorSeekBar.this.dZW();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bl(float f) {
        return this.oqW ? b.b(f, this.oqX) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.oqU - this.oqV);
        int i = 0;
        int i2 = 0;
        while (i < this.orb.length) {
            float abs2 = Math.abs(this.orb[i] - this.mProgress);
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
        if (this.oqU - this.oqV > 0.0f) {
            return this.oqU - this.oqV;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.oqM != null && dZT()) {
            this.oqM.a(zC(z));
        }
    }

    private e zC(boolean z) {
        if (this.oqR == null) {
            this.oqR = new e(this);
        }
        this.oqR.progress = getProgress();
        this.oqR.osg = getProgressFloat();
        this.oqR.osh = z;
        if (this.orz > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.ord && this.orh != null) {
                this.oqR.osj = this.orh[thumbPosOnTick];
            }
            if (this.orc) {
                this.oqR.osi = (this.orz - thumbPosOnTick) - 1;
            } else {
                this.oqR.osi = thumbPosOnTick;
            }
        }
        return this.oqR;
    }

    private void a(a aVar) {
        this.oqU = aVar.opI;
        this.oqV = aVar.opJ;
        this.mProgress = aVar.progress;
        this.oqW = aVar.opK;
        this.orz = aVar.oqn;
        this.ora = aVar.opL;
        this.orc = aVar.opM;
        this.oqY = aVar.opN;
        this.oqQ = aVar.opP;
        this.oqZ = aVar.opO;
        this.orw = aVar.opQ;
        this.mIndicatorColor = aVar.opR;
        this.oqv = aVar.opS;
        this.ort = aVar.opT;
        this.oru = aVar.opU;
        this.orv = aVar.opV;
        this.orM = aVar.opW;
        this.orO = aVar.opX;
        this.orN = aVar.opY;
        this.orP = aVar.opZ;
        this.orJ = aVar.oqa;
        this.aWC = aVar.oqd;
        this.mThumbDrawable = aVar.oqg;
        this.orZ = aVar.oqb;
        a(aVar.oqf, aVar.oqe);
        this.orX = aVar.oqc;
        this.orF = aVar.oqo;
        this.orI = aVar.oqq;
        this.orE = aVar.oqr;
        this.orG = aVar.oqs;
        this.orH = aVar.oqt;
        b(aVar.oqu, aVar.oqp);
        this.ord = aVar.oqh;
        this.orl = aVar.oqj;
        this.orq = aVar.oqk;
        this.orm = aVar.oql;
        c(aVar.oqm, aVar.oqi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZY() {
        this.oru.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.oru.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.dZW();
                IndicatorSeekBar.this.oru.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.ors = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.oru;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.orx != null && this.orx.contains("${TICK_TEXT}")) {
            if (this.orz > 2 && this.orh != null) {
                return this.orx.replace("${TICK_TEXT}", this.orh[getThumbPosOnTick()]);
            }
        } else if (this.orx != null && this.orx.contains("${PROGRESS}")) {
            return this.orx.replace("${PROGRESS}", bl(this.mProgress));
        }
        return bl(this.mProgress);
    }

    public c getIndicator() {
        return this.orr;
    }

    public int getTickCount() {
        return this.orz;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.oqX, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.oqU;
    }

    public float getMin() {
        return this.oqV;
    }

    public d getOnSeekChangeListener() {
        return this.oqM;
    }

    public synchronized void setProgress(float f) {
        this.oqO = this.mProgress;
        if (f < this.oqV) {
            f = this.oqV;
        } else if (f > this.oqU) {
            f = this.oqU;
        }
        this.mProgress = f;
        if (!this.ora && this.orz > 2) {
            this.mProgress = this.orb[getClosestIndex()];
        }
        setSeekListener(false);
        bh(this.mProgress);
        postInvalidate();
        dZW();
    }

    public synchronized void setMax(float f) {
        this.oqU = Math.max(this.oqV, f);
        dZJ();
        dZH();
        dZO();
        invalidate();
        dZW();
    }

    public synchronized void setMin(float f) {
        this.oqV = Math.min(this.oqU, f);
        dZJ();
        dZH();
        dZO();
        invalidate();
        dZW();
    }

    public void setR2L(boolean z) {
        this.orc = z;
        requestLayout();
        invalidate();
        dZW();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.orT = null;
            this.orV = null;
        } else {
            this.mThumbDrawable = drawable;
            this.duU = Math.min(f.dp2px(this.mContext, 46.0f), this.aWC) / 2.0f;
            this.orS = this.duU;
            this.oqN = Math.max(this.orS, this.dvp) * 2.0f;
            dZR();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.orE = null;
            this.orC = null;
            this.orD = null;
        } else {
            this.orE = drawable;
            this.dvp = Math.min(f.dp2px(this.mContext, 46.0f), this.orI) / 2.0f;
            this.oqN = Math.max(this.orS, this.dvp) * 2.0f;
            dZS();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.oqX = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.orx = str;
        dZP();
        dZW();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.oqM = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.oqY = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.orz < 0 || this.orz > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.orz);
        }
        this.orz = i;
        dZH();
        dZP();
        dZN();
        dZO();
        invalidate();
        dZW();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.osb = z;
    }
}
