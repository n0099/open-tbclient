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
    private int bbj;
    private float dyD;
    private float dyX;
    private boolean iUA;
    private Context mContext;
    private int mIndicatorColor;
    private int mMeasuredWidth;
    private float mMt;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private float mProgress;
    private Rect mRect;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private int oCQ;
    private int oDA;
    private String[] oDB;
    private float[] oDC;
    private float[] oDD;
    private float oDE;
    private int oDF;
    private Typeface oDG;
    private int oDH;
    private int oDI;
    private int oDJ;
    private CharSequence[] oDK;
    private c oDL;
    private boolean oDM;
    private int oDN;
    private View oDO;
    private View oDP;
    private int oDQ;
    private String oDR;
    private float[] oDS;
    private int oDT;
    private int oDU;
    private int oDV;
    private Bitmap oDW;
    private Bitmap oDX;
    private Drawable oDY;
    private int oDZ;
    private Paint oDg;
    private d oDh;
    private float oDi;
    private float oDj;
    private float oDk;
    private boolean oDl;
    private e oDm;
    private float oDn;
    private float oDo;
    private float oDp;
    private float oDq;
    private boolean oDr;
    private int oDs;
    private boolean oDt;
    private boolean oDu;
    private boolean oDv;
    private float[] oDw;
    private boolean oDx;
    private boolean oDy;
    private boolean oDz;
    private boolean oEa;
    private boolean oEb;
    private int oEc;
    private boolean oEd;
    private RectF oEe;
    private RectF oEf;
    private int oEg;
    private int oEh;
    private int oEi;
    private int oEj;
    private int[] oEk;
    private boolean oEl;
    private float oEm;
    private Bitmap oEn;
    private int oEo;
    private Bitmap oEp;
    private int oEq;
    private boolean oEr;
    private float oEs;
    private int oEt;
    private boolean oEu;
    private boolean oEv;

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oDk = -1.0f;
        this.mMt = -1.0f;
        this.oDs = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crR();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oDk = -1.0f;
        this.mMt = -1.0f;
        this.oDs = 1;
        this.mContext = context;
        c(this.mContext, attributeSet);
        crR();
    }

    private void c(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.IndicatorSeekBar);
        this.oDp = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_max, aVar.oCd);
        this.oDq = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_min, aVar.oCe);
        this.mProgress = obtainStyledAttributes.getFloat(a.j.IndicatorSeekBar_isb_progress, aVar.progress);
        this.oDr = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_progress_value_float, aVar.oCf);
        this.oDt = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_user_seekable, aVar.oCi);
        this.oDl = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_clear_default_padding, aVar.oCk);
        this.oDu = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_only_thumb_draggable, aVar.oCj);
        this.oDv = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_seek_smoothly, aVar.oCg);
        this.oDx = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_r2l, aVar.oCh);
        this.oEg = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_background_size, aVar.oCr);
        this.oEh = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_track_progress_size, aVar.oCt);
        this.oEi = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_background_color, aVar.oCs);
        this.oEj = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_track_progress_color, aVar.oCu);
        this.oEd = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_track_rounded_corners, aVar.oCv);
        this.bbj = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_thumb_size, aVar.oCy);
        this.mThumbDrawable = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_thumb_drawable);
        this.oEv = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        a(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_thumb_color), aVar.oCz);
        this.oEr = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_thumb_text, aVar.oCx);
        this.oEt = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_thumb_text_color, aVar.oCw);
        this.oDT = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_ticks_count, aVar.oCI);
        this.oDZ = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_tick_marks_type, aVar.oCJ);
        this.oEc = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_marks_size, aVar.oCL);
        b(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_marks_color), aVar.oCK);
        this.oDY = obtainStyledAttributes.getDrawable(a.j.IndicatorSeekBar_isb_tick_marks_drawable);
        this.oEb = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_swept_hide, aVar.oCO);
        this.oEa = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_tick_marks_ends_hide, aVar.oCN);
        this.oDy = obtainStyledAttributes.getBoolean(a.j.IndicatorSeekBar_isb_show_tick_texts, aVar.oCC);
        this.oDF = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_tick_texts_size, aVar.oCE);
        c(obtainStyledAttributes.getColorStateList(a.j.IndicatorSeekBar_isb_tick_texts_color), aVar.oCD);
        this.oDK = obtainStyledAttributes.getTextArray(a.j.IndicatorSeekBar_isb_tick_texts_array);
        a(obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_tick_texts_typeface, -1), aVar.oCG);
        this.oDQ = obtainStyledAttributes.getInt(a.j.IndicatorSeekBar_isb_show_indicator, aVar.oCl);
        this.mIndicatorColor = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_color, aVar.oCm);
        this.oDN = obtainStyledAttributes.getDimensionPixelSize(a.j.IndicatorSeekBar_isb_indicator_text_size, aVar.oCo);
        this.oCQ = obtainStyledAttributes.getColor(a.j.IndicatorSeekBar_isb_indicator_text_color, aVar.oCn);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.oDO = View.inflate(this.mContext, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.oDP = View.inflate(this.mContext, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    private void crR() {
        ecm();
        if (this.oEg > this.oEh) {
            this.oEg = this.oEh;
        }
        if (this.mThumbDrawable == null) {
            this.dyD = this.bbj / 2.0f;
            this.oEm = this.dyD * 1.2f;
        } else {
            this.dyD = Math.min(f.dp2px(this.mContext, 46.0f), this.bbj) / 2.0f;
            this.oEm = this.dyD;
        }
        if (this.oDY == null) {
            this.dyX = this.oEc / 2.0f;
        } else {
            this.dyX = Math.min(f.dp2px(this.mContext, 46.0f), this.oEc) / 2.0f;
        }
        this.oDi = Math.max(this.oEm, this.dyX) * 2.0f;
        ecn();
        eco();
        this.oDj = this.mProgress;
        eck();
        this.oEe = new RectF();
        this.oEf = new RectF();
        ecl();
        ecy();
    }

    private void eck() {
        if (this.oDT < 0 || this.oDT > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oDT);
        }
        if (this.oDT != 0) {
            this.oDS = new float[this.oDT];
            if (this.oDy) {
                this.oDD = new float[this.oDT];
                this.oDC = new float[this.oDT];
            }
            this.oDw = new float[this.oDT];
            for (int i = 0; i < this.oDw.length; i++) {
                this.oDw[i] = (((this.oDp - this.oDq) * i) / (this.oDT + (-1) > 0 ? this.oDT - 1 : 1)) + this.oDq;
            }
        }
    }

    private void ecl() {
        if (!this.oDl) {
            int dp2px = f.dp2px(this.mContext, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
    }

    private void ecm() {
        if (this.oDp < this.oDq) {
            throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
        }
        if (this.mProgress < this.oDq) {
            this.mProgress = this.oDq;
        }
        if (this.mProgress > this.oDp) {
            this.mProgress = this.oDp;
        }
    }

    private void ecn() {
        if (this.oDg == null) {
            this.oDg = new Paint();
        }
        if (this.oEd) {
            this.oDg.setStrokeCap(Paint.Cap.ROUND);
        }
        this.oDg.setAntiAlias(true);
        if (this.oEg > this.oEh) {
            this.oEh = this.oEg;
        }
    }

    private void eco() {
        if (ecp()) {
            IE();
            this.mTextPaint.setTypeface(this.oDG);
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oDA = this.mRect.height() + f.dp2px(this.mContext, 3.0f);
        }
    }

    private boolean ecp() {
        return this.oEr || (this.oDT != 0 && this.oDy);
    }

    private void IE() {
        if (this.mTextPaint == null) {
            this.mTextPaint = new TextPaint();
            this.mTextPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setTextSize(this.oDF);
        }
        if (this.mRect == null) {
            this.mRect = new Rect();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(resolveSize(f.dp2px(this.mContext, 170.0f), i), Math.round(this.oDi + getPaddingTop() + getPaddingBottom()) + this.oDA);
        ecq();
        ecr();
    }

    private void ecq() {
        this.mMeasuredWidth = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.mPaddingLeft = getPaddingLeft();
            this.mPaddingRight = getPaddingRight();
        } else {
            this.mPaddingLeft = getPaddingStart();
            this.mPaddingRight = getPaddingEnd();
        }
        this.mPaddingTop = getPaddingTop();
        this.oDn = (this.mMeasuredWidth - this.mPaddingLeft) - this.mPaddingRight;
        this.oDo = this.oDn / (this.oDT + (-1) > 0 ? this.oDT - 1 : 1);
    }

    private void ecr() {
        ect();
        if (ecp()) {
            this.mTextPaint.getTextBounds("j", 0, 1, this.mRect);
            this.oDE = this.mPaddingTop + this.oDi + Math.round(this.mRect.height() - this.mTextPaint.descent()) + f.dp2px(this.mContext, 3.0f);
            this.oEs = this.oDE;
        }
        if (this.oDS != null) {
            ecs();
            if (this.oDT > 2) {
                this.mProgress = this.oDw[getClosestIndex()];
                this.oDj = this.mProgress;
            }
            bo(this.mProgress);
        }
    }

    private void ecs() {
        if (this.oDT != 0) {
            if (this.oDy) {
                this.oDB = new String[this.oDT];
            }
            for (int i = 0; i < this.oDS.length; i++) {
                if (this.oDy) {
                    this.oDB[i] = Mp(i);
                    this.mTextPaint.getTextBounds(this.oDB[i], 0, this.oDB[i].length(), this.mRect);
                    this.oDC[i] = this.mRect.width();
                    this.oDD[i] = this.mPaddingLeft + (this.oDo * i);
                }
                this.oDS[i] = this.mPaddingLeft + (this.oDo * i);
            }
        }
    }

    private void ect() {
        if (this.oDx) {
            this.oEf.left = this.mPaddingLeft;
            this.oEf.top = this.mPaddingTop + this.oEm;
            this.oEf.right = this.mPaddingLeft + (this.oDn * (1.0f - ((this.mProgress - this.oDq) / getAmplitude())));
            this.oEf.bottom = this.oEf.top;
            this.oEe.left = this.oEf.right;
            this.oEe.top = this.oEf.top;
            this.oEe.right = this.mMeasuredWidth - this.mPaddingRight;
            this.oEe.bottom = this.oEf.bottom;
            return;
        }
        this.oEe.left = this.mPaddingLeft;
        this.oEe.top = this.mPaddingTop + this.oEm;
        this.oEe.right = (((this.mProgress - this.oDq) * this.oDn) / getAmplitude()) + this.mPaddingLeft;
        this.oEe.bottom = this.oEe.top;
        this.oEf.left = this.oEe.right;
        this.oEf.top = this.oEe.bottom;
        this.oEf.right = this.mMeasuredWidth - this.mPaddingRight;
        this.oEf.bottom = this.oEe.bottom;
    }

    private String Mp(int i) {
        if (this.oDK == null) {
            return bs(this.oDw[i]);
        }
        if (i < this.oDK.length) {
            return String.valueOf(this.oDK[i]);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(float f) {
        if (this.oDx) {
            this.oEf.right = this.mPaddingLeft + (this.oDn * (1.0f - ((f - this.oDq) / getAmplitude())));
            this.oEe.left = this.oEf.right;
            return;
        }
        this.oEe.right = (((f - this.oDq) * this.oDn) / getAmplitude()) + this.mPaddingLeft;
        this.oEf.left = this.oEe.right;
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
        if (this.oEl) {
            int i = this.oDT + (-1) > 0 ? this.oDT - 1 : 1;
            for (int i2 = 0; i2 < i; i2++) {
                if (this.oDx) {
                    this.oDg.setColor(this.oEk[(i - i2) - 1]);
                } else {
                    this.oDg.setColor(this.oEk[i2]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if (i2 < thumbPosOnTickFloat && thumbPosOnTickFloat < i2 + 1) {
                    float thumbCenterX = getThumbCenterX();
                    this.oDg.setStrokeWidth(getLeftSideTrackSize());
                    canvas.drawLine(this.oDS[i2], this.oEe.top, thumbCenterX, this.oEe.bottom, this.oDg);
                    this.oDg.setStrokeWidth(getRightSideTrackSize());
                    canvas.drawLine(thumbCenterX, this.oEe.top, this.oDS[i2 + 1], this.oEe.bottom, this.oDg);
                } else {
                    if (i2 < thumbPosOnTickFloat) {
                        this.oDg.setStrokeWidth(getLeftSideTrackSize());
                    } else {
                        this.oDg.setStrokeWidth(getRightSideTrackSize());
                    }
                    canvas.drawLine(this.oDS[i2], this.oEe.top, this.oDS[i2 + 1], this.oEe.bottom, this.oDg);
                }
            }
            return;
        }
        this.oDg.setColor(this.oEj);
        this.oDg.setStrokeWidth(this.oEh);
        canvas.drawLine(this.oEe.left, this.oEe.top, this.oEe.right, this.oEe.bottom, this.oDg);
        this.oDg.setColor(this.oEi);
        this.oDg.setStrokeWidth(this.oEg);
        canvas.drawLine(this.oEf.left, this.oEf.top, this.oEf.right, this.oEf.bottom, this.oDg);
    }

    private void drawTickMarks(Canvas canvas) {
        float rightSideTrackSize;
        if (this.oDT != 0) {
            if (this.oDZ != 0 || this.oDY != null) {
                float thumbCenterX = getThumbCenterX();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.oDS.length) {
                        float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                        if ((!this.oEb || thumbCenterX < this.oDS[i2]) && ((!this.oEa || (i2 != 0 && i2 != this.oDS.length - 1)) && (i2 != getThumbPosOnTick() || this.oDT <= 2 || this.oDv))) {
                            if (i2 <= thumbPosOnTickFloat) {
                                this.oDg.setColor(getLeftSideTickColor());
                            } else {
                                this.oDg.setColor(getRightSideTickColor());
                            }
                            if (this.oDY != null) {
                                if (this.oDX == null || this.oDW == null) {
                                    ecv();
                                }
                                if (this.oDX == null || this.oDW == null) {
                                    break;
                                } else if (i2 <= thumbPosOnTickFloat) {
                                    canvas.drawBitmap(this.oDX, this.oDS[i2] - (this.oDW.getWidth() / 2.0f), this.oEe.top - (this.oDW.getHeight() / 2.0f), this.oDg);
                                } else {
                                    canvas.drawBitmap(this.oDW, this.oDS[i2] - (this.oDW.getWidth() / 2.0f), this.oEe.top - (this.oDW.getHeight() / 2.0f), this.oDg);
                                }
                            } else if (this.oDZ == 1) {
                                canvas.drawCircle(this.oDS[i2], this.oEe.top, this.dyX, this.oDg);
                            } else if (this.oDZ == 3) {
                                int dp2px = f.dp2px(this.mContext, 1.0f);
                                if (thumbCenterX >= this.oDS[i2]) {
                                    rightSideTrackSize = getLeftSideTrackSize();
                                } else {
                                    rightSideTrackSize = getRightSideTrackSize();
                                }
                                canvas.drawRect(this.oDS[i2] - dp2px, this.oEe.top - (rightSideTrackSize / 2.0f), dp2px + this.oDS[i2], this.oEe.top + (rightSideTrackSize / 2.0f), this.oDg);
                            } else if (this.oDZ == 2) {
                                canvas.drawRect(this.oDS[i2] - (this.oEc / 2.0f), this.oEe.top - (this.oEc / 2.0f), (this.oEc / 2.0f) + this.oDS[i2], (this.oEc / 2.0f) + this.oEe.top, this.oDg);
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
        if (this.oDB != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            for (int i = 0; i < this.oDB.length; i++) {
                if (!this.oDz || i == 0 || i == this.oDB.length - 1) {
                    if (i == getThumbPosOnTick() && i == thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(this.oDJ);
                    } else if (i < thumbPosOnTickFloat) {
                        this.mTextPaint.setColor(getLeftSideTickTextsColor());
                    } else {
                        this.mTextPaint.setColor(getRightSideTickTextsColor());
                    }
                    int length = this.oDx ? (this.oDB.length - i) - 1 : i;
                    if (i == 0) {
                        canvas.drawText(this.oDB[length], (this.oDC[length] / 2.0f) + this.oDD[i], this.oDE, this.mTextPaint);
                    } else if (i == this.oDB.length - 1) {
                        canvas.drawText(this.oDB[length], this.oDD[i] - (this.oDC[length] / 2.0f), this.oDE, this.mTextPaint);
                    } else {
                        canvas.drawText(this.oDB[length], this.oDD[i], this.oDE, this.mTextPaint);
                    }
                }
            }
        }
    }

    private void az(Canvas canvas) {
        if (!this.oEu) {
            float thumbCenterX = getThumbCenterX();
            if (this.mThumbDrawable != null) {
                if (this.oEn == null || this.oEp == null) {
                    ecu();
                }
                if (this.oEn == null || this.oEp == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.oDg.setAlpha(255);
                if (this.iUA) {
                    canvas.drawBitmap(this.oEp, thumbCenterX - (this.oEp.getWidth() / 2.0f), this.oEe.top - (this.oEp.getHeight() / 2.0f), this.oDg);
                    return;
                } else {
                    canvas.drawBitmap(this.oEn, thumbCenterX - (this.oEn.getWidth() / 2.0f), this.oEe.top - (this.oEn.getHeight() / 2.0f), this.oDg);
                    return;
                }
            }
            if (this.iUA) {
                this.oDg.setColor(this.oEq);
            } else {
                this.oDg.setColor(this.oEo);
            }
            canvas.drawCircle(thumbCenterX, this.oEe.top, this.iUA ? this.oEm : this.dyD, this.oDg);
        }
    }

    private void aA(Canvas canvas) {
        if (this.oEr) {
            if (!this.oDy || this.oDT <= 2) {
                this.mTextPaint.setColor(this.oEt);
                canvas.drawText(bs(this.mProgress), getThumbCenterX(), this.oEs, this.mTextPaint);
            }
        }
    }

    private float getThumbCenterX() {
        return this.oDx ? this.oEf.right : this.oEe.right;
    }

    private int getLeftSideTickColor() {
        return this.oDx ? this.oDU : this.oDV;
    }

    private int getRightSideTickColor() {
        return this.oDx ? this.oDV : this.oDU;
    }

    private int getLeftSideTickTextsColor() {
        return this.oDx ? this.oDI : this.oDH;
    }

    private int getRightSideTickTextsColor() {
        return this.oDx ? this.oDH : this.oDI;
    }

    private int getLeftSideTrackSize() {
        return this.oDx ? this.oEg : this.oEh;
    }

    private int getRightSideTrackSize() {
        return this.oDx ? this.oEh : this.oEg;
    }

    private int getThumbPosOnTick() {
        if (this.oDT != 0) {
            return Math.round((getThumbCenterX() - this.mPaddingLeft) / this.oDo);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.oDT != 0) {
            return (getThumbCenterX() - this.mPaddingLeft) / this.oDo;
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
                i = this.bbj;
            } else {
                i = this.oEc;
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
            this.oEo = i;
            this.oEq = this.oEo;
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
                    this.oEo = iArr[0];
                    this.oEq = this.oEo;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oEq = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842919:
                                    this.oEo = iArr[i3];
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
            this.oDV = i;
            this.oDU = this.oDV;
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
                    this.oDV = iArr[0];
                    this.oDU = this.oDV;
                } else if (iArr3.length == 2) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oDU = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oDV = iArr[i3];
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
            this.oDI = i;
            this.oDH = this.oDI;
            this.oDJ = this.oDI;
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
                    this.oDI = iArr[0];
                    this.oDH = this.oDI;
                    this.oDJ = this.oDI;
                } else if (iArr3.length == 3) {
                    for (int i3 = 0; i3 < iArr3.length; i3++) {
                        int[] iArr4 = iArr3[i3];
                        if (iArr4.length == 0) {
                            this.oDI = iArr[i3];
                        } else {
                            switch (iArr4[0]) {
                                case 16842913:
                                    this.oDH = iArr[i3];
                                    continue;
                                case 16843623:
                                    this.oDJ = iArr[i3];
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
                this.oDG = Typeface.DEFAULT;
                return;
            case 1:
                this.oDG = Typeface.MONOSPACE;
                return;
            case 2:
                this.oDG = Typeface.SANS_SERIF;
                return;
            case 3:
                this.oDG = Typeface.SERIF;
                return;
            default:
                if (typeface == null) {
                    this.oDG = Typeface.DEFAULT;
                    return;
                } else {
                    this.oDG = typeface;
                    return;
                }
        }
    }

    private void ecu() {
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
                                    this.oEp = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                                } else {
                                    throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                                }
                            } else {
                                this.oEn = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), true);
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception e) {
                    this.oEn = b(this.mThumbDrawable, true);
                    this.oEp = this.oEn;
                    return;
                }
            }
            this.oEn = b(this.mThumbDrawable, true);
            this.oEp = this.oEn;
        }
    }

    private void ecv() {
        if (this.oDY instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) this.oDY;
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
                                this.oDX = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                            } else {
                                throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                            }
                        } else {
                            this.oDW = b((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i)), false);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception e) {
                this.oDW = b(this.oDY, false);
                this.oDX = this.oDW;
                return;
            }
        }
        this.oDW = b(this.oDY, false);
        this.oDX = this.oDW;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (z != isEnabled()) {
            super.setEnabled(z);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.oDM) {
                    this.oDO.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.oDM) {
                this.oDO.setAlpha(0.3f);
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
        if (this.oDt && isEnabled()) {
            switch (motionEvent.getAction()) {
                case 0:
                    performClick();
                    float x = motionEvent.getX();
                    if (J(x, motionEvent.getY())) {
                        if (!this.oDu || br(x)) {
                            this.iUA = true;
                            if (this.oDh != null) {
                                this.oDh.a(this);
                            }
                            ap(motionEvent);
                            return true;
                        }
                        return false;
                    }
                    break;
                case 1:
                case 3:
                    this.iUA = false;
                    if (this.oDh != null) {
                        this.oDh.b(this);
                    }
                    if (!ecA()) {
                        invalidate();
                    }
                    if (this.oDL != null) {
                        this.oDL.hide();
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
        bo(bp(bq(aq(motionEvent))));
        setSeekListener(true);
        invalidate();
        ecx();
    }

    private boolean ecw() {
        return this.oDr ? this.oDj != this.mProgress : Math.round(this.oDj) != Math.round(this.mProgress);
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

    private float bp(float f) {
        this.oDj = this.mProgress;
        this.mProgress = this.oDq + ((getAmplitude() * (f - this.mPaddingLeft)) / this.oDn);
        return this.mProgress;
    }

    private float bq(float f) {
        if (this.oDT > 2 && !this.oDv) {
            f = (Math.round((f - this.mPaddingLeft) / this.oDo) * this.oDo) + this.mPaddingLeft;
        }
        if (this.oDx) {
            return (this.oDn - f) + (this.mPaddingLeft * 2);
        }
        return f;
    }

    private boolean J(float f, float f2) {
        if (this.oDk == -1.0f) {
            this.oDk = f.dp2px(this.mContext, 5.0f);
        }
        return ((f > (((float) this.mPaddingLeft) - (this.oDk * 2.0f)) ? 1 : (f == (((float) this.mPaddingLeft) - (this.oDk * 2.0f)) ? 0 : -1)) >= 0 && (f > (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oDk * 2.0f)) ? 1 : (f == (((float) (this.mMeasuredWidth - this.mPaddingRight)) + (this.oDk * 2.0f)) ? 0 : -1)) <= 0) && ((f2 > ((this.oEe.top - this.oEm) - this.oDk) ? 1 : (f2 == ((this.oEe.top - this.oEm) - this.oDk) ? 0 : -1)) >= 0 && (f2 > ((this.oEe.top + this.oEm) + this.oDk) ? 1 : (f2 == ((this.oEe.top + this.oEm) + this.oDk) ? 0 : -1)) <= 0);
    }

    private boolean br(float f) {
        float f2;
        bo(this.mProgress);
        if (this.oDx) {
            f2 = this.oEf.right;
        } else {
            f2 = this.oEe.right;
        }
        return f2 - (((float) this.bbj) / 2.0f) <= f && f <= f2 + (((float) this.bbj) / 2.0f);
    }

    private void ecx() {
        if (this.oDM) {
            ecz();
        } else if (this.oDL != null) {
            this.oDL.ech();
            if (this.oDL.isShowing()) {
                this.oDL.bm(getThumbCenterX());
            } else {
                this.oDL.bn(getThumbCenterX());
            }
        }
    }

    private void ecy() {
        if (this.oDQ != 0 && this.oDL == null) {
            this.oDL = new c(this.mContext, this, this.mIndicatorColor, this.oDQ, this.oDN, this.oCQ, this.oDO, this.oDP);
            this.oDO = this.oDL.eci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecz() {
        int thumbCenterX;
        int i;
        if (this.oDM && this.oDL != null) {
            this.oDL.Wj(getIndicatorTextString());
            this.oDO.measure(0, 0);
            int measuredWidth = this.oDO.getMeasuredWidth();
            float thumbCenterX2 = getThumbCenterX();
            if (this.mMt == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.mMt = displayMetrics.widthPixels;
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
            this.oDL.Mn(thumbCenterX);
            this.oDL.Mo(i);
        }
    }

    private boolean ecA() {
        if (this.oDT >= 3 && this.oDv && this.oEv) {
            final int closestIndex = getClosestIndex();
            final float f = this.mProgress;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, Math.abs(f - this.oDw[closestIndex]));
            ofFloat.start();
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IndicatorSeekBar.this.oDj = IndicatorSeekBar.this.mProgress;
                    if (f - IndicatorSeekBar.this.oDw[closestIndex] > 0.0f) {
                        IndicatorSeekBar.this.mProgress = f - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    } else {
                        IndicatorSeekBar.this.mProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f;
                    }
                    IndicatorSeekBar.this.bo(IndicatorSeekBar.this.mProgress);
                    IndicatorSeekBar.this.setSeekListener(false);
                    if (IndicatorSeekBar.this.oDL != null && IndicatorSeekBar.this.oDM) {
                        IndicatorSeekBar.this.oDL.ecj();
                        IndicatorSeekBar.this.ecz();
                    }
                    IndicatorSeekBar.this.invalidate();
                }
            });
            return true;
        }
        return false;
    }

    private String bs(float f) {
        return this.oDr ? b.a(f, this.oDs) : String.valueOf(Math.round(f));
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.oDp - this.oDq);
        int i = 0;
        int i2 = 0;
        while (i < this.oDw.length) {
            float abs2 = Math.abs(this.oDw[i] - this.mProgress);
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
        if (this.oDp - this.oDq > 0.0f) {
            return this.oDp - this.oDq;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSeekListener(boolean z) {
        if (this.oDh != null && ecw()) {
            this.oDh.a(zX(z));
        }
    }

    private e zX(boolean z) {
        if (this.oDm == null) {
            this.oDm = new e(this);
        }
        this.oDm.progress = getProgress();
        this.oDm.oEA = getProgressFloat();
        this.oDm.oEB = z;
        if (this.oDT > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.oDy && this.oDB != null) {
                this.oDm.oED = this.oDB[thumbPosOnTick];
            }
            if (this.oDx) {
                this.oDm.oEC = (this.oDT - thumbPosOnTick) - 1;
            } else {
                this.oDm.oEC = thumbPosOnTick;
            }
        }
        return this.oDm;
    }

    private void a(a aVar) {
        this.oDp = aVar.oCd;
        this.oDq = aVar.oCe;
        this.mProgress = aVar.progress;
        this.oDr = aVar.oCf;
        this.oDT = aVar.oCI;
        this.oDv = aVar.oCg;
        this.oDx = aVar.oCh;
        this.oDt = aVar.oCi;
        this.oDl = aVar.oCk;
        this.oDu = aVar.oCj;
        this.oDQ = aVar.oCl;
        this.mIndicatorColor = aVar.oCm;
        this.oCQ = aVar.oCn;
        this.oDN = aVar.oCo;
        this.oDO = aVar.oCp;
        this.oDP = aVar.oCq;
        this.oEg = aVar.oCr;
        this.oEi = aVar.oCs;
        this.oEh = aVar.oCt;
        this.oEj = aVar.oCu;
        this.oEd = aVar.oCv;
        this.bbj = aVar.oCy;
        this.mThumbDrawable = aVar.oCB;
        this.oEt = aVar.oCw;
        a(aVar.oCA, aVar.oCz);
        this.oEr = aVar.oCx;
        this.oDZ = aVar.oCJ;
        this.oEc = aVar.oCL;
        this.oDY = aVar.oCM;
        this.oEa = aVar.oCN;
        this.oEb = aVar.oCO;
        b(aVar.oCP, aVar.oCK);
        this.oDy = aVar.oCC;
        this.oDF = aVar.oCE;
        this.oDK = aVar.oCF;
        this.oDG = aVar.oCG;
        c(aVar.oCH, aVar.oCD);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ecB() {
        this.oDO.setVisibility(4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar.IndicatorSeekBar.3
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180L);
                IndicatorSeekBar.this.oDO.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.ecz();
                IndicatorSeekBar.this.oDO.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z) {
        this.oDM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.oDO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        if (this.oDR != null && this.oDR.contains("${TICK_TEXT}")) {
            if (this.oDT > 2 && this.oDB != null) {
                return this.oDR.replace("${TICK_TEXT}", this.oDB[getThumbPosOnTick()]);
            }
        } else if (this.oDR != null && this.oDR.contains("${PROGRESS}")) {
            return this.oDR.replace("${PROGRESS}", bs(this.mProgress));
        }
        return bs(this.mProgress);
    }

    public c getIndicator() {
        return this.oDL;
    }

    public int getTickCount() {
        return this.oDT;
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf(this.mProgress).setScale(this.oDs, 4).floatValue();
    }

    public int getProgress() {
        return Math.round(this.mProgress);
    }

    public float getMax() {
        return this.oDp;
    }

    public float getMin() {
        return this.oDq;
    }

    public d getOnSeekChangeListener() {
        return this.oDh;
    }

    public synchronized void setProgress(float f) {
        this.oDj = this.mProgress;
        if (f < this.oDq) {
            f = this.oDq;
        } else if (f > this.oDp) {
            f = this.oDp;
        }
        this.mProgress = f;
        if (!this.oDv && this.oDT > 2) {
            this.mProgress = this.oDw[getClosestIndex()];
        }
        setSeekListener(false);
        bo(this.mProgress);
        postInvalidate();
        ecz();
    }

    public synchronized void setMax(float f) {
        this.oDp = Math.max(this.oDq, f);
        ecm();
        eck();
        ecr();
        invalidate();
        ecz();
    }

    public synchronized void setMin(float f) {
        this.oDq = Math.min(this.oDp, f);
        ecm();
        eck();
        ecr();
        invalidate();
        ecz();
    }

    public void setR2L(boolean z) {
        this.oDx = z;
        requestLayout();
        invalidate();
        ecz();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mThumbDrawable = null;
            this.oEn = null;
            this.oEp = null;
        } else {
            this.mThumbDrawable = drawable;
            this.dyD = Math.min(f.dp2px(this.mContext, 46.0f), this.bbj) / 2.0f;
            this.oEm = this.dyD;
            this.oDi = Math.max(this.oEm, this.dyX) * 2.0f;
            ecu();
        }
        requestLayout();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.oDY = null;
            this.oDW = null;
            this.oDX = null;
        } else {
            this.oDY = drawable;
            this.dyX = Math.min(f.dp2px(this.mContext, 46.0f), this.oEc) / 2.0f;
            this.oDi = Math.max(this.oEm, this.dyX) * 2.0f;
            ecv();
        }
        invalidate();
    }

    public void setDecimalScale(int i) {
        this.oDs = i;
    }

    public void setIndicatorTextFormat(String str) {
        this.oDR = str;
        ecs();
        ecz();
    }

    public void setOnSeekChangeListener(@NonNull d dVar) {
        this.oDh = dVar;
    }

    public void setUserSeekAble(boolean z) {
        this.oDt = z;
    }

    public synchronized void setTickCount(int i) {
        if (this.oDT < 0 || this.oDT > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.oDT);
        }
        this.oDT = i;
        eck();
        ecs();
        ecq();
        ecr();
        invalidate();
        ecz();
    }

    public void setThumbAdjustAuto(boolean z) {
        this.oEv = z;
    }
}
