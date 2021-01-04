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
    private float mFC;
    private int mIndicatorColor;
    private int mMeasuredWidth;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private float ovA;
    private float ovB;
    private float ovC;
    private boolean ovD;
    private int ovE;
    private boolean ovF;
    private boolean ovG;
    private boolean ovH;
    private float[] ovI;
    private boolean ovJ;
    private boolean ovK;
    private boolean ovL;
    private int ovM;
    private String[] ovN;
    private float[] ovO;
    private float[] ovP;
    private float ovQ;
    private int ovR;
    private Typeface ovS;
    private int ovT;
    private int ovU;
    private int ovV;
    private CharSequence[] ovW;
    private c ovX;
    private boolean ovY;
    private int ovZ;
    private int ovc;
    private Paint ovs;
    private d ovt;
    private float ovu;
    private float ovv;
    private float ovw;
    private boolean ovx;
    private e ovy;
    private float ovz;
    private int owA;
    private Bitmap owB;
    private int owC;
    private boolean owD;
    private float owE;
    private int owF;
    private boolean owG;
    private boolean owH;
    private View owa;
    private View owb;
    private int owc;
    private String owd;
    private float[] owe;
    private int owf;
    private int owg;
    private int owh;
    private Bitmap owi;
    private Bitmap owj;
    private Drawable owk;
    private int owl;
    private boolean owm;
    private boolean own;
    private int owo;
    private boolean owp;
    private RectF owq;
    private RectF owr;
    private int ows;
    private int owt;
    private int owu;
    private int owv;
    private int[] oww;
    private boolean owx;
    private float owy;
    private Bitmap owz;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ovw = -1.0f;
        this.mFC = -1.0f;
        this.ovE = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cul();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ovw = -1.0f;
        this.mFC = -1.0f;
        this.ovE = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        cul();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.ovB = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.ouo);
        this.ovC = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.oup);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.ovD = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.ouq);
        this.ovF = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.ouu);
        this.ovx = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.ouw);
        this.ovG = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.ouv);
        this.ovH = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.our);
        this.ovJ = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.ous);
        this.ows = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.ouD);
        this.owt = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.ouF);
        this.owu = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.ouE);
        this.owv = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.ouG);
        this.owp = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.ouH);
        this.bbq = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.ouK);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.owH = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.ouL);
        this.owD = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.ouJ);
        this.owF = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.ouI);
        this.owf = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.ouU);
        this.owl = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.ouV);
        this.owo = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.ouX);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.ouW);
        this.owk = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.own = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.ova);
        this.owm = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.ouZ);
        this.ovK = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.ouO);
        this.ovR = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.ouQ);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.ouP);
        this.ovW = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.ouS);
        this.owc = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.oux);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.ouy);
        this.ovZ = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.ouA);
        this.ovc = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.ouz);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.owa = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.owb = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void cul() {
        edA();
        if (this.ows > this.owt) {
            this.ows = this.owt;
        }
        if (this.mThumbDrawable == null) {
            this.dzG = this.bbq / 2.0f;
            this.owy = this.dzG * 1.2f;
        } else {
            this.dzG = Math.min(f.dp2px(this.mContext, 46.0f), this.bbq) / 2.0f;
            this.owy = this.dzG;
        }
        if (this.owk == null) {
            this.dAb = this.owo / 2.0f;
        } else {
            this.dAb = Math.min(f.dp2px(this.mContext, 46.0f), this.owo) / 2.0f;
        }
        this.ovu = Math.max(this.owy, this.dAb) * 2.0f;
        edB();
        edC();
        this.ovv = this.mProgress;
        edy();
        this.owq = new RectF();
        this.owr = new RectF();
        edz();
        edM();
    }

    private void edy() {
        if (this.owf < 0 || this.owf > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.owf);
        }
        if (this.owf != 0) {
            this.owe = new float[this.owf];
            if (this.ovK) {
                this.ovP = new float[this.owf];
                this.ovO = new float[this.owf];
            }
            this.ovI = new float[this.owf];
            for (int i = 0; i < this.ovI.length; i++) {
                this.ovI[i] = (((this.ovB - this.ovC) * i) / (this.owf + (-1) > 0 ? this.owf - 1 : 1)) + this.ovC;
            }
        }
    }

    private void edz() {
        if (!this.ovx) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void edA() {
        if (this.ovB < this.ovC) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.ovC) {
            this.mProgress = this.ovC;
        }
        if (this.mProgress > this.ovB) {
            this.mProgress = this.ovB;
        }
    }

    private void edB() {
        if (this.ovs == null) {
            this.ovs = new Paint();
        }
        if (this.owp) {
            this.ovs.setStrokeCap(Paint.Cap.ROUND);
        }
        this.ovs.setAntiAlias(true);
        if (this.ows > this.owt) {
            this.owt = this.ows;
        }
    }

    private void edC() {
        if (edD()) {
            Lg();
            this.mTextPaint.setTypeface(this.ovS);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ovM = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean edD() {
        return this.owD || (this.owf != 0 && this.ovK);
    }

    private void Lg() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.ovR);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.ovu + getPaddingTop() + getPaddingBottom()) + this.ovM);
        edE();
        edF();
    }

    private void edE() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.VW = getPaddingLeft();
            this.VV = getPaddingRight();
        } else {
            this.VW = getPaddingStart();
            this.VV = getPaddingEnd();
        }
        this.adG = getPaddingTop();
        this.ovz = (this.mMeasuredWidth - this.VW) - this.VV;
        this.ovA = this.ovz / (this.owf + (-1) > 0 ? this.owf - 1 : 1);
    }

    private void edF() {
        edH();
        if (edD()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.ovQ = this.adG + this.ovu + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.owE = this.ovQ;
        }
        if (this.owe != null) {
            edG();
            if (this.owf > 2) {
                this.mProgress = this.ovI[getClosestIndex()];
                this.ovv = this.mProgress;
            }
            bh(this.mProgress);
        }
    }

    private void edG() {
        if (this.owf != 0) {
            if (this.ovK) {
                this.ovN = new String[this.owf];
            }
            for (int i = 0; i < this.owe.length; i++) {
                if (this.ovK) {
                    this.ovN[i] = Nw(i);
                    this.mTextPaint.getTextBounds(this.ovN[i], 0, this.ovN[i].length(), this.mRect);
                    this.ovO[i] = this.mRect.width();
                    this.ovP[i] = this.VW + (this.ovA * i);
                }
                this.owe[i] = this.VW + (this.ovA * i);
            }
        }
    }

    private void edH() {
        if (this.ovJ) {
            this.owr.left = this.VW;
            this.owr.top = this.adG + this.owy;
            this.owr.right = this.VW + (this.ovz * (1.0f - ((this.mProgress - this.ovC) / getAmplitude())));
            this.owr.bottom = this.owr.top;
            this.owq.left = this.owr.right;
            this.owq.top = this.owr.top;
            this.owq.right = this.mMeasuredWidth - this.VV;
            this.owq.bottom = this.owr.bottom;
            return;
        }
        this.owq.left = this.VW;
        this.owq.top = this.adG + this.owy;
        this.owq.right = (((this.mProgress - this.ovC) * this.ovz) / getAmplitude()) + this.VW;
        this.owq.bottom = this.owq.top;
        this.owr.left = this.owq.right;
        this.owr.top = this.owq.bottom;
        this.owr.right = this.mMeasuredWidth - this.VV;
        this.owr.bottom = this.owq.bottom;
    }

    private String Nw(int i) {
        if (this.ovW == null) {
            return bl(this.ovI[i]);
        }
        if (i < this.ovW.length) {
            return String.valueOf(this.ovW[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(float f) {
        if (this.ovJ) {
            this.owr.right = this.VW + (this.ovz * (1.0f - ((f - this.ovC) / getAmplitude())));
            this.owq.left = this.owr.right;
            return;
        }
        this.owq.right = (((f - this.ovC) * this.ovz) / getAmplitude()) + this.VW;
        this.owr.left = this.owq.right;
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
        if (this.owx) {
            int i = this.owf + (-1) > 0 ? this.owf - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.ovJ) {
                    this.ovs.setColor(this.oww[(i - i2) - 1]);
                } else {
                    this.ovs.setColor(this.oww[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.ovs.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.owe[i2], this.owq.top, thumbCenterX, this.owq.bottom, this.ovs);
                    this.ovs.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.owq.top, this.owe[i2 + 1], this.owq.bottom, this.ovs);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.ovs.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.ovs.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.owe[i2], this.owq.top, this.owe[i2 + 1], this.owq.bottom, this.ovs);
                }
            }
            return;
        }
        this.ovs.setColor(this.owv);
        this.ovs.setStrokeWidth(this.owt);
        canvas.drawLine(this.owq.left, this.owq.top, this.owq.right, this.owq.bottom, this.ovs);
        this.ovs.setColor(this.owu);
        this.ovs.setStrokeWidth(this.ows);
        canvas.drawLine(this.owr.left, this.owr.top, this.owr.right, this.owr.bottom, this.ovs);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.owf != 0) {
            if (this.owl != 0 || this.owk != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.owe.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.own || thumbCenterX < this.owe[i2]) && ((!this.owm || (i2 != 0 && i2 != this.owe.length - 1)) && (i2 != getThumbPosOnTick() || this.owf <= 2 || this.ovH))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.ovs.setColor(getLeftSideTickColor());
                            } else {
                                this.ovs.setColor(getRightSideTickColor());
                            }
                            if (this.owk != null) {
                                if (this.owj == null || this.owi == null) {
                                    edJ();
                                }
                                if (this.owj == null || this.owi == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.owj, this.owe[i2] - (this.owi.getWidth() / 2.0f), this.owq.top - (this.owi.getHeight() / 2.0f), this.ovs);
                                } else {
                                    canvas.drawBitmap(this.owi, this.owe[i2] - (this.owi.getWidth() / 2.0f), this.owq.top - (this.owi.getHeight() / 2.0f), this.ovs);
                                }
                            } else if (this.owl == 1) {
                                canvas.drawCircle(this.owe[i2], this.owq.top, this.dAb, this.ovs);
                            } else if (this.owl == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.owe[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.owe[i2] - dp2px, this.owq.top - (rightSideTrackSize / 2.0f), dp2px + this.owe[i2], this.owq.top + (rightSideTrackSize / 2.0f), this.ovs);
                            } else if (this.owl == 2) {
                                canvas.drawRect(this.owe[i2] - (this.owo / 2.0f), this.owq.top - (this.owo / 2.0f), (this.owo / 2.0f) + this.owe[i2], (this.owo / 2.0f) + this.owq.top, this.ovs);
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
        if (this.ovN != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.ovN.length; i++) {
                if (!this.ovL || i == 0 || i == this.ovN.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.ovV);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.ovJ ? (this.ovN.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.ovN[length], (this.ovO[length] / 2.0f) + this.ovP[i], this.ovQ, this.mTextPaint);
                    } else if (i == this.ovN.length - 1) {
                        canvas.drawText(this.ovN[length], this.ovP[i] - (this.ovO[length] / 2.0f), this.ovQ, this.mTextPaint);
                    } else {
                        canvas.drawText(this.ovN[length], this.ovP[i], this.ovQ, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.owG) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.owz == null || this.owB == null) {
                    edI();
                }
                if (this.owz == null || this.owB == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.ovs.setAlpha(255);
                if (this.iRD) {
                    canvas.drawBitmap(this.owB, thumbCenterX - (this.owB.getWidth() / 2.0f), this.owq.top - (this.owB.getHeight() / 2.0f), this.ovs);
                    return;
                } else {
                    canvas.drawBitmap(this.owz, thumbCenterX - (this.owz.getWidth() / 2.0f), this.owq.top - (this.owz.getHeight() / 2.0f), this.ovs);
                    return;
                }
            }
            if (this.iRD) {
                this.ovs.setColor(this.owC);
            } else {
                this.ovs.setColor(this.owA);
            }
            canvas.drawCircle(thumbCenterX, this.owq.top, this.iRD ? this.owy : this.dzG, this.ovs);
        }
    }

    private void aA(Canvas canvas) {
        if (this.owD) {
            if (!this.ovK || this.owf <= 2) {
                this.mTextPaint.setColor(this.owF);
                canvas.drawText(bl(this.mProgress), getThumbCenterX(), this.owE, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.ovJ ? this.owr.right : this.owq.right;
    }

    private int getLeftSideTickColor() {
        return this.ovJ ? this.owg : this.owh;
    }

    private int getRightSideTickColor() {
        return this.ovJ ? this.owh : this.owg;
    }

    private int getLeftSideTickTextsColor() {
        return this.ovJ ? this.ovU : this.ovT;
    }

    private int getRightSideTickTextsColor() {
        return this.ovJ ? this.ovT : this.ovU;
    }

    private int getLeftSideTrackSize() {
        return this.ovJ ? this.ows : this.owt;
    }

    private int getRightSideTrackSize() {
        return this.ovJ ? this.owt : this.ows;
    }

    private int getThumbPosOnTick() {
        if (this.owf != 0) {
            return Math.round((getThumbCenterX() - this.VW) / this.ovA);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.owf != 0) {
            return (getThumbCenterX() - this.VW) / this.ovA;
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
                i = this.owo;
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
            this.owA = i;
            this.owC = this.owA;
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
                    this.owA = iArr[0];
                    this.owC = this.owA;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.owC = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.owA = iArr[i3];
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
            this.owh = i;
            this.owg = this.owh;
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
                    this.owh = iArr[0];
                    this.owg = this.owh;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.owg = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.owh = iArr[i3];
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
            this.ovU = i;
            this.ovT = this.ovU;
            this.ovV = this.ovU;
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
                    this.ovU = iArr[0];
                    this.ovT = this.ovU;
                    this.ovV = this.ovU;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.ovU = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.ovT = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.ovV = iArr[i3];
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
                this.ovS = Typeface.DEFAULT;
                return;
            case 1:
                this.ovS = Typeface.MONOSPACE;
                return;
            case 2:
                this.ovS = Typeface.SANS_SERIF;
                return;
            case 3:
                this.ovS = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.ovS = Typeface.DEFAULT;
                    return;
                } else {
                    this.ovS = typeface;
                    return;
                }
        }
    }

    private void edI() {
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
                                    this.owB = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.owz = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.owz = b(this.mThumbDrawable, true);
                    this.owB = this.owz;
                    return;
                }
            }
            this.owz = b(this.mThumbDrawable, true);
            this.owB = this.owz;
        }
    }

    private void edJ() {
        if (this.owk instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.owk;
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
                                this.owj = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.owi = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.owi = b(this.owk, false);
                this.owj = this.owi;
                return;
            }
        }
        this.owi = b(this.owk, false);
        this.owj = this.owi;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.ovY) {
                    this.owa.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.ovY) {
                this.owa.setAlpha(0.3f);
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
        if (this.ovF && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (I(x, motionEvent.getY())) {
                        if (!this.ovG || bk(x)) {
                            this.iRD = true;
                            if (this.ovt != null) {
                                this.ovt.a(this);
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
                    if (this.ovt != null) {
                        this.ovt.b(this);
                    }
                    if (!edO()) {
                        invalidate();
                    }
                    if (this.ovX != null) {
                        this.ovX.hide();
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
        edL();
    }

    private boolean edK() {
        return this.ovD ? this.ovv != this.mProgress : Math.round(this.ovv) != Math.round(this.mProgress);
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
        this.ovv = this.mProgress;
        this.mProgress = this.ovC + ((getAmplitude() * (f - this.VW)) / this.ovz);
        return this.mProgress;
    }

    private float bj(float f) {
        if (this.owf > 2 && !this.ovH) {
            f = (Math.round((f - this.VW) / this.ovA) * this.ovA) + this.VW;
        }
        if (this.ovJ) {
            return (this.ovz - f) + (this.VW * 2);
        }
        return f;
    }

    private boolean I(float f, float f2) {
        if (this.ovw == -1.0f) {
            this.ovw = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.VW) - (this.ovw * 2.0f)) ? 1 : (f == (((float) this.VW) - (this.ovw * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.VV)) + (this.ovw * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.VV)) + (this.ovw * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.owq.top - this.owy) - this.ovw) ? 1 : (f2 == ((this.owq.top - this.owy) - this.ovw) ? 0 : -1)) >= 0 && (f2 > ((this.owq.top + this.owy) + this.ovw) ? 1 : (f2 == ((this.owq.top + this.owy) + this.ovw) ? 0 : -1)) <= 0);
    }

    private boolean bk(float f) {
        float f2;
        bh(this.mProgress);
        if (this.ovJ) {
            f2 = this.owr.right;
        } else {
            f2 = this.owq.right;
        }
        return f2 - (((float) this.bbq) / 2.0f) <= f && f <= f2 + (((float) this.bbq) / 2.0f);
    }

    private void edL() {
        if (this.ovY) {
            edN();
        } else if (this.ovX != null) {
            this.ovX.edv();
            if (this.ovX.isShowing()) {
                this.ovX.bf(getThumbCenterX());
            } else {
                this.ovX.bg(getThumbCenterX());
            }
        }
    }

    private void edM() {
        if (this.owc != 0 && this.ovX == null) {
            this.ovX = new c(this.mContext, this, this.mIndicatorColor, this.owc, this.ovZ, this.ovc, this.owa, this.owb);
            this.owa = this.ovX.edw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edN() {
        int thumbCenterX;
        int i;
        if (this.ovY && this.ovX != null) {
            this.ovX.Wa(getIndicatorTextString());
            this.owa.measure(0, 0);
            int measuredWidth = this.owa.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mFC == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mFC = displayMetrics.widthPixels;
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
            this.ovX.Nu(thumbCenterX);
            this.ovX.Nv(i);
        }
    }

    private boolean edO() {
        if (this.owf >= 3 && this.ovH && this.owH) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.ovI[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.ovv = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.ovI[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bh(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.ovX != null && IndicatorSeekBar.this.ovY) {
                        IndicatorSeekBar.this.ovX.edx();
                        IndicatorSeekBar.this.edN();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bl(float f) {
        return this.ovD ? b.b(f, this.ovE) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.ovB - this.ovC);
        int i = 0;
        int i2 = 0;
        while (i < this.ovI.length) {
            float abs2 = Math.abs(this.ovI[i] - this.mProgress);
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
        if (this.ovB - this.ovC > 0.0f) {
            return this.ovB - this.ovC;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.ovt != null && edK()) {
            this.ovt.a(zG(z));
        }
    }

    private e zG(boolean z) {
        if (this.ovy == null) {
            this.ovy = new e(this);
        }
        this.ovy.progress = getProgress();
        this.ovy.owM = getProgressFloat();
        this.ovy.owN = z;
        if (this.owf > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.ovK && this.ovN != null) {
                this.ovy.owP = this.ovN[thumbPosOnTick];
            }
            if (this.ovJ) {
                this.ovy.owO = (this.owf - thumbPosOnTick) - 1;
            } else {
                this.ovy.owO = thumbPosOnTick;
            }
        }
        return this.ovy;
    }

    private void a(a aVar) {
        this.ovB = aVar.ouo;
        this.ovC = aVar.oup;
        this.mProgress = aVar.progress;
        this.ovD = aVar.ouq;
        this.owf = aVar.ouU;
        this.ovH = aVar.our;
        this.ovJ = aVar.ous;
        this.ovF = aVar.ouu;
        this.ovx = aVar.ouw;
        this.ovG = aVar.ouv;
        this.owc = aVar.oux;
        this.mIndicatorColor = aVar.ouy;
        this.ovc = aVar.ouz;
        this.ovZ = aVar.ouA;
        this.owa = aVar.ouB;
        this.owb = aVar.ouC;
        this.ows = aVar.ouD;
        this.owu = aVar.ouE;
        this.owt = aVar.ouF;
        this.owv = aVar.ouG;
        this.owp = aVar.ouH;
        this.bbq = aVar.ouK;
        this.mThumbDrawable = aVar.ouN;
        this.owF = aVar.ouI;
        a(aVar.ouM, aVar.ouL);
        this.owD = aVar.ouJ;
        this.owl = aVar.ouV;
        this.owo = aVar.ouX;
        this.owk = aVar.ouY;
        this.owm = aVar.ouZ;
        this.own = aVar.ova;
        b(aVar.ovb, aVar.ouW);
        this.ovK = aVar.ouO;
        this.ovR = aVar.ouQ;
        this.ovW = aVar.ouR;
        this.ovS = aVar.ouS;
        c(aVar.ouT, aVar.ouP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void edP() {
        this.owa.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.owa.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.edN();
                IndicatorSeekBar.this.owa.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.ovY = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.owa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.owd != null && this.owd.contains("${TICK_TEXT}")) {
            if (this.owf > 2 && this.ovN != null) {
                return this.owd.replace("${TICK_TEXT}", this.ovN[getThumbPosOnTick()]);
            }
        } else if (this.owd != null && this.owd.contains("${PROGRESS}")) {
            return this.owd.replace("${PROGRESS}", bl(this.mProgress));
        }
        return bl(this.mProgress);
    }

    public c getIndicator() {
        return this.ovX;
    }

    public int getTickCount() {
        return this.owf;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.ovE, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.ovB;
    }

    public float getMin() {
        return this.ovC;
    }

    public d getOnSeekChangeListener() {
        return this.ovt;
    }

    public synchronized void setProgress(float f) {
        this.ovv = this.mProgress;
        if (f < this.ovC) {
            f = this.ovC;
        } else if (f > this.ovB) {
            f = this.ovB;
        }
        this.mProgress = f;
        if (!this.ovH && this.owf > 2) {
            this.mProgress = this.ovI[getClosestIndex()];
        }
        setSeekListener(false);
        bh(this.mProgress);
        postInvalidate();
        edN();
    }

    public synchronized void setMax(float f) {
        this.ovB = Math.max(this.ovC, f);
        edA();
        edy();
        edF();
        invalidate();
        edN();
    }

    public synchronized void setMin(float f) {
        this.ovC = Math.min(this.ovB, f);
        edA();
        edy();
        edF();
        invalidate();
        edN();
    }

    public void setR2L(boolean z) {
        this.ovJ = z;
        requestLayout();
        invalidate();
        edN();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.owz = null;
            this.owB = null;
        } else {
            this.mThumbDrawable = drawable;
            this.dzG = Math.min(f.dp2px(this.mContext, 46.0f), this.bbq) / 2.0f;
            this.owy = this.dzG;
            this.ovu = Math.max(this.owy, this.dAb) * 2.0f;
            edI();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.owk = null;
            this.owi = null;
            this.owj = null;
        } else {
            this.owk = drawable;
            this.dAb = Math.min(f.dp2px(this.mContext, 46.0f), this.owo) / 2.0f;
            this.ovu = Math.max(this.owy, this.dAb) * 2.0f;
            edJ();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.ovE = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.owd = str;
        edG();
        edN();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.ovt = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.ovF = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.owf < 0 || this.owf > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.owf);
        }
        this.owf = i;
        edy();
        edG();
        edE();
        edF();
        invalidate();
        edN();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.owH = z;
    }
}
