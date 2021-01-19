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
/* loaded from: classes7.dex */
public class ProgressView extends View {
    private Paint heA;
    private long iDg;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nGY;
    private Paint nGZ;
    private Paint nHa;
    private Paint nHb;
    private Paint nHc;
    private float nHd;
    private float nHe;
    private LinkedList<Integer> nHf;
    private float nHg;
    private volatile State nHh;
    private float nHi;
    private float nHj;
    private float nHk;
    private long nHl;
    private long nHm;
    private long nHn;

    /* loaded from: classes7.dex */
    public interface a {
        void Kr(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nHf = new LinkedList<>();
        this.nHg = 0.0f;
        this.nHh = State.PAUSE;
        this.isVisible = true;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0.0f;
        this.nHl = 0L;
        this.lastStartTime = 0L;
        this.nHm = 0L;
        this.nHn = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nHf = new LinkedList<>();
        this.nHg = 0.0f;
        this.nHh = State.PAUSE;
        this.isVisible = true;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0.0f;
        this.nHl = 0L;
        this.lastStartTime = 0L;
        this.nHm = 0L;
        this.nHn = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nHf = new LinkedList<>();
        this.nHg = 0.0f;
        this.nHh = State.PAUSE;
        this.isVisible = true;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0.0f;
        this.nHl = 0L;
        this.lastStartTime = 0L;
        this.nHm = 0L;
        this.nHn = 0L;
        init(context);
    }

    private void init(Context context) {
        this.heA = new Paint();
        this.nGZ = new Paint();
        this.nHa = new Paint();
        this.nHc = new Paint();
        this.nHb = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.heA.setStyle(Paint.Style.FILL);
        this.heA.setColor(Color.parseColor("#33aaff"));
        this.nGZ.setStyle(Paint.Style.FILL);
        this.nGZ.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nHa.setStyle(Paint.Style.FILL);
        this.nHa.setColor(Color.parseColor("#FFFFFF"));
        this.nHc.setStyle(Paint.Style.FILL);
        this.nHc.setColor(Color.parseColor("#e53917"));
        this.nHb.setStyle(Paint.Style.FILL);
        this.nHb.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nHg = displayMetrics.widthPixels / 15000.0f;
        this.nHk = this.nHg;
    }

    public void setListener(a aVar) {
        this.nGY = aVar;
    }

    /* loaded from: classes7.dex */
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
        if (this.iDg == 0) {
            this.iDg = System.currentTimeMillis();
        }
        if (this.nHn == 0) {
            this.nHn = getHeight();
        }
        this.nHd = (float) this.nHn;
        this.nHe = (float) ((this.nHn * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nHi = 0.0f;
        if (!this.nHf.isEmpty()) {
            Iterator<Integer> it = this.nHf.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nHm = intValue;
                float f = this.nHi;
                this.nHi += ((float) (intValue - j)) * this.nHg;
                float f2 = this.nHi - this.nHe;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nHn - 1), this.heA);
                canvas.drawRect(f2, 0.0f, this.nHi, (float) (this.nHn - 1), this.nHa);
                j = intValue;
            }
            if (this.nHf.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nHg, 0.0f, this.nHd + (this.nHg * 3000.0f), (float) (this.nHn - 1), this.nGZ);
            }
        } else {
            canvas.drawRect(3000.0f * this.nHg, 0.0f, this.nHd + (this.nHg * 3000.0f), (float) (this.nHn - 1), this.nGZ);
        }
        if (this.nHh == State.ROLLBACK) {
            canvas.drawRect(this.nHi - (((float) (this.nHm - this.lastStartTime)) * this.nHg), 0.0f, this.nHi, (float) this.nHn, this.nHc);
        }
        if (this.nHh == State.START) {
            this.nHj += this.nHk * ((float) (currentTimeMillis - this.iDg));
            float f3 = this.nHi + this.nHj;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nHi, 0.0f, this.nHj + this.nHi, (float) (this.nHn - 1), this.heA);
            } else {
                canvas.drawRect(this.nHi, 0.0f, getMeasuredWidth(), (float) (this.nHn - 1), this.heA);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nHn) + (f3 - 5.0f), (float) (this.nHn - 1), this.nHb);
            if (this.nGY != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nGY.Kr(this.mProgress);
                }
            }
        } else {
            if (this.nGY != null) {
                int measuredWidth2 = (int) ((this.nHi / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nGY.Kr(this.mProgress);
                }
            }
            if (this.nHl == 0 || currentTimeMillis - this.nHl >= 800) {
                this.isVisible = !this.isVisible;
                this.nHl = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nHi - 5.0f, 0.0f, ((float) this.nHn) + (this.nHi - 5.0f), (float) (this.nHn - 1), this.nHb);
            }
        }
        this.iDg = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nHh = state;
        if (state != State.START) {
            this.nHj = this.nHk;
        }
        if (state == State.DELETE && this.nHf != null && !this.nHf.isEmpty()) {
            this.nHf.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nHh;
    }

    public void Kq(int i) {
        this.nHf.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nHf == null || this.nHf.isEmpty()) {
            return 0;
        }
        return this.nHf.getLast().intValue();
    }

    public boolean dRT() {
        return this.nHf.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nHf;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nHf = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nHn = i;
    }

    public void reset() {
        this.nHf.clear();
        this.nHh = State.PAUSE;
        this.nHf.clear();
        this.nHi = 0.0f;
        this.iDg = 0L;
        this.lastStartTime = 0L;
        this.nHm = 0L;
        this.mProgress = 0;
        this.nHl = 0L;
    }
}
