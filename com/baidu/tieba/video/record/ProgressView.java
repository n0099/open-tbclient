package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes22.dex */
public class ProgressView extends View {
    private boolean evS;
    private long hCy;
    private long lastStartTime;
    private a mKX;
    private Paint mKY;
    private Paint mKZ;
    private Paint mLa;
    private Paint mLb;
    private Paint mLc;
    private float mLd;
    private float mLe;
    private LinkedList<Integer> mLf;
    private float mLg;
    private volatile State mLh;
    private float mLi;
    private float mLj;
    private float mLk;
    private long mLl;
    private long mLm;
    private long mLn;
    private int mProgress;

    /* loaded from: classes22.dex */
    public interface a {
        void JF(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mLf = new LinkedList<>();
        this.mLg = 0.0f;
        this.mLh = State.PAUSE;
        this.evS = true;
        this.mLi = 0.0f;
        this.mLj = 0.0f;
        this.mLk = 0.0f;
        this.mLl = 0L;
        this.lastStartTime = 0L;
        this.mLm = 0L;
        this.mLn = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLf = new LinkedList<>();
        this.mLg = 0.0f;
        this.mLh = State.PAUSE;
        this.evS = true;
        this.mLi = 0.0f;
        this.mLj = 0.0f;
        this.mLk = 0.0f;
        this.mLl = 0L;
        this.lastStartTime = 0L;
        this.mLm = 0L;
        this.mLn = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLf = new LinkedList<>();
        this.mLg = 0.0f;
        this.mLh = State.PAUSE;
        this.evS = true;
        this.mLi = 0.0f;
        this.mLj = 0.0f;
        this.mLk = 0.0f;
        this.mLl = 0L;
        this.lastStartTime = 0L;
        this.mLm = 0L;
        this.mLn = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mKY = new Paint();
        this.mKZ = new Paint();
        this.mLa = new Paint();
        this.mLc = new Paint();
        this.mLb = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mKY.setStyle(Paint.Style.FILL);
        this.mKY.setColor(Color.parseColor("#33aaff"));
        this.mKZ.setStyle(Paint.Style.FILL);
        this.mKZ.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mLa.setStyle(Paint.Style.FILL);
        this.mLa.setColor(Color.parseColor("#FFFFFF"));
        this.mLc.setStyle(Paint.Style.FILL);
        this.mLc.setColor(Color.parseColor("#e53917"));
        this.mLb.setStyle(Paint.Style.FILL);
        this.mLb.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mLg = displayMetrics.widthPixels / 15000.0f;
        this.mLk = this.mLg;
    }

    public void setListener(a aVar) {
        this.mKX = aVar;
    }

    /* loaded from: classes22.dex */
    public enum State {
        START(1),
        PAUSE(2),
        ROLLBACK(3),
        DELETE(4);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return PAUSE;
        }

        State(int i) {
            this.mIntValue = i;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hCy == 0) {
            this.hCy = System.currentTimeMillis();
        }
        if (this.mLn == 0) {
            this.mLn = getHeight();
        }
        this.mLd = (float) this.mLn;
        this.mLe = (float) ((this.mLn * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mLi = 0.0f;
        if (!this.mLf.isEmpty()) {
            Iterator<Integer> it = this.mLf.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mLm = intValue;
                float f = this.mLi;
                this.mLi += ((float) (intValue - j)) * this.mLg;
                float f2 = this.mLi - this.mLe;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mLn - 1), this.mKY);
                canvas.drawRect(f2, 0.0f, this.mLi, (float) (this.mLn - 1), this.mLa);
                j = intValue;
            }
            if (this.mLf.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mLg, 0.0f, this.mLd + (this.mLg * 3000.0f), (float) (this.mLn - 1), this.mKZ);
            }
        } else {
            canvas.drawRect(3000.0f * this.mLg, 0.0f, this.mLd + (this.mLg * 3000.0f), (float) (this.mLn - 1), this.mKZ);
        }
        if (this.mLh == State.ROLLBACK) {
            canvas.drawRect(this.mLi - (((float) (this.mLm - this.lastStartTime)) * this.mLg), 0.0f, this.mLi, (float) this.mLn, this.mLc);
        }
        if (this.mLh == State.START) {
            this.mLj += this.mLk * ((float) (currentTimeMillis - this.hCy));
            float f3 = this.mLi + this.mLj;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mLi, 0.0f, this.mLj + this.mLi, (float) (this.mLn - 1), this.mKY);
            } else {
                canvas.drawRect(this.mLi, 0.0f, getMeasuredWidth(), (float) (this.mLn - 1), this.mKY);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mLn) + (f3 - 5.0f), (float) (this.mLn - 1), this.mLb);
            if (this.mKX != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mKX.JF(this.mProgress);
                }
            }
        } else {
            if (this.mKX != null) {
                int measuredWidth2 = (int) ((this.mLi / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mKX.JF(this.mProgress);
                }
            }
            if (this.mLl == 0 || currentTimeMillis - this.mLl >= 800) {
                this.evS = !this.evS;
                this.mLl = System.currentTimeMillis();
            }
            if (this.evS) {
                canvas.drawRect(this.mLi - 5.0f, 0.0f, ((float) this.mLn) + (this.mLi - 5.0f), (float) (this.mLn - 1), this.mLb);
            }
        }
        this.hCy = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mLh = state;
        if (state != State.START) {
            this.mLj = this.mLk;
        }
        if (state == State.DELETE && this.mLf != null && !this.mLf.isEmpty()) {
            this.mLf.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mLh;
    }

    public void JE(int i) {
        this.mLf.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mLf == null || this.mLf.isEmpty()) {
            return 0;
        }
        return this.mLf.getLast().intValue();
    }

    public boolean dHs() {
        return this.mLf.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mLf;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mLf = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mLn = i;
    }

    public void reset() {
        this.mLf.clear();
        this.mLh = State.PAUSE;
        this.mLf.clear();
        this.mLi = 0.0f;
        this.hCy = 0L;
        this.lastStartTime = 0L;
        this.mLm = 0L;
        this.mProgress = 0;
        this.mLl = 0L;
    }
}
