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
    private Paint oqK;
    private d oqL;
    private float oqM;
    private float oqN;
    private float oqO;
    private boolean oqP;
    private e oqQ;
    private float oqR;
    private float oqS;
    private float oqT;
    private float oqU;
    private boolean oqV;
    private int oqW;
    private boolean oqX;
    private boolean oqY;
    private boolean oqZ;
    private int oqu;
    private int orA;
    private Bitmap orB;
    private Bitmap orC;
    private Drawable orD;
    private int orE;
    private boolean orF;
    private boolean orG;
    private int orH;
    private boolean orI;
    private RectF orJ;
    private RectF orK;
    private int orL;
    private int orM;
    private int orN;
    private int orO;
    private int[] orP;
    private boolean orQ;
    private float orR;
    private Bitmap orS;
    private int orT;
    private Bitmap orU;
    private int orV;
    private boolean orW;
    private float orX;
    private int orY;
    private boolean orZ;
    private float[] ora;
    private boolean orb;
    private boolean orc;
    private boolean ord;
    private int ore;
    private String[] orf;
    private float[] orh;
    private float[] ori;
    private float orj;
    private int ork;
    private Typeface orl;
    private int orm;
    private int orn;
    private int oro;
    private CharSequence[] orp;
    private c orq;
    private boolean orr;
    private int ors;
    private View ort;
    private View oru;
    private int orv;
    private String orw;
    private float[] orx;
    private int ory;
    private int orz;
    private boolean osa;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oqO = -1.0f;
        this.mAS = -1.0f;
        this.oqW = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cqu();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oqO = -1.0f;
        this.mAS = -1.0f;
        this.oqW = 1;
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
        this.oqT = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.opH);
        this.oqU = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.opI);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.oqV = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.opJ);
        this.oqX = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.opM);
        this.oqP = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.opO);
        this.oqY = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.opN);
        this.oqZ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.opK);
        this.orb = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.opL);
        this.orL = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.opV);
        this.orM = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.opX);
        this.orN = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.opW);
        this.orO = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.opY);
        this.orI = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.opZ);
        this.aWC = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.oqc);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.osa = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.oqd);
        this.orW = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.oqb);
        this.orY = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.oqa);
        this.ory = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.oqm);
        this.orE = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.oqn);
        this.orH = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.oqp);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.oqo);
        this.orD = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.orG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.oqs);
        this.orF = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.oqr);
        this.orc = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.oqg);
        this.ork = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.oqi);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.oqh);
        this.orp = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.oqk);
        this.orv = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.opP);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.opQ);
        this.ors = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.opS);
        this.oqu = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.opR);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.ort = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.oru = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void cqu() {
        dZJ();
        if (this.orL > this.orM) {
            this.orL = this.orM;
        }
        if (this.mThumbDrawable == null) {
            this.duU = this.aWC / 2.0f;
            this.orR = this.duU * 1.2f;
        } else {
            this.duU = Math.min(f.dp2px(this.mContext, 46.0f), this.aWC) / 2.0f;
            this.orR = this.duU;
        }
        if (this.orD == null) {
            this.dvp = this.orH / 2.0f;
        } else {
            this.dvp = Math.min(f.dp2px(this.mContext, 46.0f), this.orH) / 2.0f;
        }
        this.oqM = Math.max(this.orR, this.dvp) * 2.0f;
        dZK();
        dZL();
        this.oqN = this.mProgress;
        dZH();
        this.orJ = new RectF();
        this.orK = new RectF();
        dZI();
        dZV();
    }

    private void dZH() {
        if (this.ory < 0 || this.ory > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.ory);
        }
        if (this.ory != 0) {
            this.orx = new float[this.ory];
            if (this.orc) {
                this.ori = new float[this.ory];
                this.orh = new float[this.ory];
            }
            this.ora = new float[this.ory];
            for (int i = 0; i < this.ora.length; i++) {
                this.ora[i] = (((this.oqT - this.oqU) * i) / (this.ory + (-1) > 0 ? this.ory - 1 : 1)) + this.oqU;
            }
        }
    }

    private void dZI() {
        if (!this.oqP) {
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
        if (this.oqT < this.oqU) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.oqU) {
            this.mProgress = this.oqU;
        }
        if (this.mProgress > this.oqT) {
            this.mProgress = this.oqT;
        }
    }

    private void dZK() {
        if (this.oqK == null) {
            this.oqK = new Paint();
        }
        if (this.orI) {
            this.oqK.setStrokeCap(Paint.Cap.ROUND);
        }
        this.oqK.setAntiAlias(true);
        if (this.orL > this.orM) {
            this.orM = this.orL;
        }
    }

    private void dZL() {
        if (dZM()) {
            Hl();
            this.mTextPaint.setTypeface(this.orl);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ore = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean dZM() {
        return this.orW || (this.ory != 0 && this.orc);
    }

    private void Hl() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.ork);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.oqM + getPaddingTop() + getPaddingBottom()) + this.ore);
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
        this.oqR = (this.mMeasuredWidth - this.VU) - this.VT;
        this.oqS = this.oqR / (this.ory + (-1) > 0 ? this.ory - 1 : 1);
    }

    private void dZO() {
        dZQ();
        if (dZM()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.orj = this.adE + this.oqM + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.orX = this.orj;
        }
        if (this.orx != null) {
            dZP();
            if (this.ory > 2) {
                this.mProgress = this.ora[getClosestIndex()];
                this.oqN = this.mProgress;
            }
            bh(this.mProgress);
        }
    }

    private void dZP() {
        if (this.ory != 0) {
            if (this.orc) {
                this.orf = new String[this.ory];
            }
            for (int i = 0; i < this.orx.length; i++) {
                if (this.orc) {
                    this.orf[i] = LP(i);
                    this.mTextPaint.getTextBounds(this.orf[i], 0, this.orf[i].length(), this.mRect);
                    this.orh[i] = this.mRect.width();
                    this.ori[i] = this.VU + (this.oqS * i);
                }
                this.orx[i] = this.VU + (this.oqS * i);
            }
        }
    }

    private void dZQ() {
        if (this.orb) {
            this.orK.left = this.VU;
            this.orK.top = this.adE + this.orR;
            this.orK.right = this.VU + (this.oqR * (1.0f - ((this.mProgress - this.oqU) / getAmplitude())));
            this.orK.bottom = this.orK.top;
            this.orJ.left = this.orK.right;
            this.orJ.top = this.orK.top;
            this.orJ.right = this.mMeasuredWidth - this.VT;
            this.orJ.bottom = this.orK.bottom;
            return;
        }
        this.orJ.left = this.VU;
        this.orJ.top = this.adE + this.orR;
        this.orJ.right = (((this.mProgress - this.oqU) * this.oqR) / getAmplitude()) + this.VU;
        this.orJ.bottom = this.orJ.top;
        this.orK.left = this.orJ.right;
        this.orK.top = this.orJ.bottom;
        this.orK.right = this.mMeasuredWidth - this.VT;
        this.orK.bottom = this.orJ.bottom;
    }

    private String LP(int i) {
        if (this.orp == null) {
            return bl(this.ora[i]);
        }
        if (i < this.orp.length) {
            return String.valueOf(this.orp[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(float f) {
        if (this.orb) {
            this.orK.right = this.VU + (this.oqR * (1.0f - ((f - this.oqU) / getAmplitude())));
            this.orJ.left = this.orK.right;
            return;
        }
        this.orJ.right = (((f - this.oqU) * this.oqR) / getAmplitude()) + this.VU;
        this.orK.left = this.orJ.right;
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
        if (this.orQ) {
            int i = this.ory + (-1) > 0 ? this.ory - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.orb) {
                    this.oqK.setColor(this.orP[(i - i2) - 1]);
                } else {
                    this.oqK.setColor(this.orP[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.oqK.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.orx[i2], this.orJ.top, thumbCenterX, this.orJ.bottom, this.oqK);
                    this.oqK.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.orJ.top, this.orx[i2 + 1], this.orJ.bottom, this.oqK);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.oqK.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.oqK.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.orx[i2], this.orJ.top, this.orx[i2 + 1], this.orJ.bottom, this.oqK);
                }
            }
            return;
        }
        this.oqK.setColor(this.orO);
        this.oqK.setStrokeWidth(this.orM);
        canvas.drawLine(this.orJ.left, this.orJ.top, this.orJ.right, this.orJ.bottom, this.oqK);
        this.oqK.setColor(this.orN);
        this.oqK.setStrokeWidth(this.orL);
        canvas.drawLine(this.orK.left, this.orK.top, this.orK.right, this.orK.bottom, this.oqK);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.ory != 0) {
            if (this.orE != 0 || this.orD != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.orx.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.orG || thumbCenterX < this.orx[i2]) && ((!this.orF || (i2 != 0 && i2 != this.orx.length - 1)) && (i2 != getThumbPosOnTick() || this.ory <= 2 || this.oqZ))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.oqK.setColor(getLeftSideTickColor());
                            } else {
                                this.oqK.setColor(getRightSideTickColor());
                            }
                            if (this.orD != null) {
                                if (this.orC == null || this.orB == null) {
                                    dZS();
                                }
                                if (this.orC == null || this.orB == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.orC, this.orx[i2] - (this.orB.getWidth() / 2.0f), this.orJ.top - (this.orB.getHeight() / 2.0f), this.oqK);
                                } else {
                                    canvas.drawBitmap(this.orB, this.orx[i2] - (this.orB.getWidth() / 2.0f), this.orJ.top - (this.orB.getHeight() / 2.0f), this.oqK);
                                }
                            } else if (this.orE == 1) {
                                canvas.drawCircle(this.orx[i2], this.orJ.top, this.dvp, this.oqK);
                            } else if (this.orE == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.orx[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.orx[i2] - dp2px, this.orJ.top - (rightSideTrackSize / 2.0f), dp2px + this.orx[i2], this.orJ.top + (rightSideTrackSize / 2.0f), this.oqK);
                            } else if (this.orE == 2) {
                                canvas.drawRect(this.orx[i2] - (this.orH / 2.0f), this.orJ.top - (this.orH / 2.0f), (this.orH / 2.0f) + this.orx[i2], (this.orH / 2.0f) + this.orJ.top, this.oqK);
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
        if (this.orf != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.orf.length; i++) {
                if (!this.ord || i == 0 || i == this.orf.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.oro);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.orb ? (this.orf.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.orf[length], (this.orh[length] / 2.0f) + this.ori[i], this.orj, this.mTextPaint);
                    } else if (i == this.orf.length - 1) {
                        canvas.drawText(this.orf[length], this.ori[i] - (this.orh[length] / 2.0f), this.orj, this.mTextPaint);
                    } else {
                        canvas.drawText(this.orf[length], this.ori[i], this.orj, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.orZ) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.orS == null || this.orU == null) {
                    dZR();
                }
                if (this.orS == null || this.orU == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.oqK.setAlpha(255);
                if (this.iMW) {
                    canvas.drawBitmap(this.orU, thumbCenterX - (this.orU.getWidth() / 2.0f), this.orJ.top - (this.orU.getHeight() / 2.0f), this.oqK);
                    return;
                } else {
                    canvas.drawBitmap(this.orS, thumbCenterX - (this.orS.getWidth() / 2.0f), this.orJ.top - (this.orS.getHeight() / 2.0f), this.oqK);
                    return;
                }
            }
            if (this.iMW) {
                this.oqK.setColor(this.orV);
            } else {
                this.oqK.setColor(this.orT);
            }
            canvas.drawCircle(thumbCenterX, this.orJ.top, this.iMW ? this.orR : this.duU, this.oqK);
        }
    }

    private void aA(Canvas canvas) {
        if (this.orW) {
            if (!this.orc || this.ory <= 2) {
                this.mTextPaint.setColor(this.orY);
                canvas.drawText(bl(this.mProgress), getThumbCenterX(), this.orX, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.orb ? this.orK.right : this.orJ.right;
    }

    private int getLeftSideTickColor() {
        return this.orb ? this.orz : this.orA;
    }

    private int getRightSideTickColor() {
        return this.orb ? this.orA : this.orz;
    }

    private int getLeftSideTickTextsColor() {
        return this.orb ? this.orn : this.orm;
    }

    private int getRightSideTickTextsColor() {
        return this.orb ? this.orm : this.orn;
    }

    private int getLeftSideTrackSize() {
        return this.orb ? this.orL : this.orM;
    }

    private int getRightSideTrackSize() {
        return this.orb ? this.orM : this.orL;
    }

    private int getThumbPosOnTick() {
        if (this.ory != 0) {
            return Math.round((getThumbCenterX() - this.VU) / this.oqS);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.ory != 0) {
            return (getThumbCenterX() - this.VU) / this.oqS;
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
                i = this.orH;
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
            this.orT = i;
            this.orV = this.orT;
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
                    this.orT = iArr[0];
                    this.orV = this.orT;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.orV = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.orT = iArr[i3];
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
            this.orA = i;
            this.orz = this.orA;
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
                    this.orA = iArr[0];
                    this.orz = this.orA;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.orz = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.orA = iArr[i3];
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
            this.orn = i;
            this.orm = this.orn;
            this.oro = this.orn;
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
                    this.orn = iArr[0];
                    this.orm = this.orn;
                    this.oro = this.orn;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.orn = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.orm = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.oro = iArr[i3];
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
                this.orl = Typeface.DEFAULT;
                return;
            case 1:
                this.orl = Typeface.MONOSPACE;
                return;
            case 2:
                this.orl = Typeface.SANS_SERIF;
                return;
            case 3:
                this.orl = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.orl = Typeface.DEFAULT;
                    return;
                } else {
                    this.orl = typeface;
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
                                    this.orU = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.orS = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.orS = b(this.mThumbDrawable, true);
                    this.orU = this.orS;
                    return;
                }
            }
            this.orS = b(this.mThumbDrawable, true);
            this.orU = this.orS;
        }
    }

    private void dZS() {
        if (this.orD instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.orD;
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
                                this.orC = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.orB = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.orB = b(this.orD, false);
                this.orC = this.orB;
                return;
            }
        }
        this.orB = b(this.orD, false);
        this.orC = this.orB;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.orr) {
                    this.ort.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.orr) {
                this.ort.setAlpha(0.3f);
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
        if (this.oqX && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (J(x, motionEvent.getY())) {
                        if (!this.oqY || bk(x)) {
                            this.iMW = true;
                            if (this.oqL != null) {
                                this.oqL.a(this);
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
                    if (this.oqL != null) {
                        this.oqL.b(this);
                    }
                    if (!dZX()) {
                        invalidate();
                    }
                    if (this.orq != null) {
                        this.orq.hide();
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
        return this.oqV ? this.oqN != this.mProgress : Math.round(this.oqN) != Math.round(this.mProgress);
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
        this.oqN = this.mProgress;
        this.mProgress = this.oqU + ((getAmplitude() * (f - this.VU)) / this.oqR);
        return this.mProgress;
    }

    private float bj(float f) {
        if (this.ory > 2 && !this.oqZ) {
            f = (Math.round((f - this.VU) / this.oqS) * this.oqS) + this.VU;
        }
        if (this.orb) {
            return (this.oqR - f) + (this.VU * 2);
        }
        return f;
    }

    private boolean J(float f, float f2) {
        if (this.oqO == -1.0f) {
            this.oqO = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.VU) - (this.oqO * 2.0f)) ? 1 : (f == (((float) this.VU) - (this.oqO * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.VT)) + (this.oqO * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.VT)) + (this.oqO * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.orJ.top - this.orR) - this.oqO) ? 1 : (f2 == ((this.orJ.top - this.orR) - this.oqO) ? 0 : -1)) >= 0 && (f2 > ((this.orJ.top + this.orR) + this.oqO) ? 1 : (f2 == ((this.orJ.top + this.orR) + this.oqO) ? 0 : -1)) <= 0);
    }

    private boolean bk(float f) {
        float f2;
        bh(this.mProgress);
        if (this.orb) {
            f2 = this.orK.right;
        } else {
            f2 = this.orJ.right;
        }
        return f2 - (((float) this.aWC) / 2.0f) <= f && f <= f2 + (((float) this.aWC) / 2.0f);
    }

    private void dZU() {
        if (this.orr) {
            dZW();
        } else if (this.orq != null) {
            this.orq.dZE();
            if (this.orq.isShowing()) {
                this.orq.bf(getThumbCenterX());
            } else {
                this.orq.bg(getThumbCenterX());
            }
        }
    }

    private void dZV() {
        if (this.orv != 0 && this.orq == null) {
            this.orq = new c(this.mContext, this, this.mIndicatorColor, this.orv, this.ors, this.oqu, this.ort, this.oru);
            this.ort = this.orq.dZF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZW() {
        int thumbCenterX;
        int i;
        if (this.orr && this.orq != null) {
            this.orq.UR(getIndicatorTextString());
            this.ort.measure(0, 0);
            int measuredWidth = this.ort.getMeasuredWidth();
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
            this.orq.LN(thumbCenterX);
            this.orq.LO(i);
        }
    }

    private boolean dZX() {
        if (this.ory >= 3 && this.oqZ && this.osa) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.ora[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.oqN = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.ora[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bh(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.orq != null && IndicatorSeekBar.this.orr) {
                        IndicatorSeekBar.this.orq.dZG();
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
        return this.oqV ? b.b(f, this.oqW) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.oqT - this.oqU);
        int i = 0;
        int i2 = 0;
        while (i < this.ora.length) {
            float abs2 = Math.abs(this.ora[i] - this.mProgress);
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
        if (this.oqT - this.oqU > 0.0f) {
            return this.oqT - this.oqU;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.oqL != null && dZT()) {
            this.oqL.a(zC(z));
        }
    }

    private e zC(boolean z) {
        if (this.oqQ == null) {
            this.oqQ = new e(this);
        }
        this.oqQ.progress = getProgress();
        this.oqQ.osf = getProgressFloat();
        this.oqQ.osg = z;
        if (this.ory > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.orc && this.orf != null) {
                this.oqQ.osi = this.orf[thumbPosOnTick];
            }
            if (this.orb) {
                this.oqQ.osh = (this.ory - thumbPosOnTick) - 1;
            } else {
                this.oqQ.osh = thumbPosOnTick;
            }
        }
        return this.oqQ;
    }

    private void a(a aVar) {
        this.oqT = aVar.opH;
        this.oqU = aVar.opI;
        this.mProgress = aVar.progress;
        this.oqV = aVar.opJ;
        this.ory = aVar.oqm;
        this.oqZ = aVar.opK;
        this.orb = aVar.opL;
        this.oqX = aVar.opM;
        this.oqP = aVar.opO;
        this.oqY = aVar.opN;
        this.orv = aVar.opP;
        this.mIndicatorColor = aVar.opQ;
        this.oqu = aVar.opR;
        this.ors = aVar.opS;
        this.ort = aVar.opT;
        this.oru = aVar.opU;
        this.orL = aVar.opV;
        this.orN = aVar.opW;
        this.orM = aVar.opX;
        this.orO = aVar.opY;
        this.orI = aVar.opZ;
        this.aWC = aVar.oqc;
        this.mThumbDrawable = aVar.oqf;
        this.orY = aVar.oqa;
        a(aVar.oqe, aVar.oqd);
        this.orW = aVar.oqb;
        this.orE = aVar.oqn;
        this.orH = aVar.oqp;
        this.orD = aVar.oqq;
        this.orF = aVar.oqr;
        this.orG = aVar.oqs;
        b(aVar.oqt, aVar.oqo);
        this.orc = aVar.oqg;
        this.ork = aVar.oqi;
        this.orp = aVar.oqj;
        this.orl = aVar.oqk;
        c(aVar.oql, aVar.oqh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dZY() {
        this.ort.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.ort.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.dZW();
                IndicatorSeekBar.this.ort.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.orr = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.ort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.orw != null && this.orw.contains("${TICK_TEXT}")) {
            if (this.ory > 2 && this.orf != null) {
                return this.orw.replace("${TICK_TEXT}", this.orf[getThumbPosOnTick()]);
            }
        } else if (this.orw != null && this.orw.contains("${PROGRESS}")) {
            return this.orw.replace("${PROGRESS}", bl(this.mProgress));
        }
        return bl(this.mProgress);
    }

    public c getIndicator() {
        return this.orq;
    }

    public int getTickCount() {
        return this.ory;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.oqW, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.oqT;
    }

    public float getMin() {
        return this.oqU;
    }

    public d getOnSeekChangeListener() {
        return this.oqL;
    }

    public synchronized void setProgress(float f) {
        this.oqN = this.mProgress;
        if (f < this.oqU) {
            f = this.oqU;
        } else if (f > this.oqT) {
            f = this.oqT;
        }
        this.mProgress = f;
        if (!this.oqZ && this.ory > 2) {
            this.mProgress = this.ora[getClosestIndex()];
        }
        setSeekListener(false);
        bh(this.mProgress);
        postInvalidate();
        dZW();
    }

    public synchronized void setMax(float f) {
        this.oqT = Math.max(this.oqU, f);
        dZJ();
        dZH();
        dZO();
        invalidate();
        dZW();
    }

    public synchronized void setMin(float f) {
        this.oqU = Math.min(this.oqT, f);
        dZJ();
        dZH();
        dZO();
        invalidate();
        dZW();
    }

    public void setR2L(boolean z) {
        this.orb = z;
        requestLayout();
        invalidate();
        dZW();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.orS = null;
            this.orU = null;
        } else {
            this.mThumbDrawable = drawable;
            this.duU = Math.min(f.dp2px(this.mContext, 46.0f), this.aWC) / 2.0f;
            this.orR = this.duU;
            this.oqM = Math.max(this.orR, this.dvp) * 2.0f;
            dZR();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.orD = null;
            this.orB = null;
            this.orC = null;
        } else {
            this.orD = drawable;
            this.dvp = Math.min(f.dp2px(this.mContext, 46.0f), this.orH) / 2.0f;
            this.oqM = Math.max(this.orR, this.dvp) * 2.0f;
            dZS();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.oqW = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.orw = str;
        dZP();
        dZW();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.oqL = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.oqX = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.ory < 0 || this.ory > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.ory);
        }
        this.ory = i;
        dZH();
        dZP();
        dZN();
        dZO();
        invalidate();
        dZW();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.osa = z;
    }
}
