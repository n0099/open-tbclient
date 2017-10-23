package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean amP;
    private long ccS;
    private float gzA;
    private float gzB;
    private LinkedList<Integer> gzC;
    private float gzD;
    private volatile State gzE;
    private float gzF;
    private float gzG;
    private float gzH;
    private long gzI;
    private long gzJ;
    private long gzK;
    private a gzu;
    private Paint gzv;
    private Paint gzw;
    private Paint gzx;
    private Paint gzy;
    private Paint gzz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uD(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gzC = new LinkedList<>();
        this.gzD = 0.0f;
        this.gzE = State.PAUSE;
        this.amP = true;
        this.gzF = 0.0f;
        this.gzG = 0.0f;
        this.gzH = 0.0f;
        this.gzI = 0L;
        this.lastStartTime = 0L;
        this.gzJ = 0L;
        this.gzK = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzC = new LinkedList<>();
        this.gzD = 0.0f;
        this.gzE = State.PAUSE;
        this.amP = true;
        this.gzF = 0.0f;
        this.gzG = 0.0f;
        this.gzH = 0.0f;
        this.gzI = 0L;
        this.lastStartTime = 0L;
        this.gzJ = 0L;
        this.gzK = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzC = new LinkedList<>();
        this.gzD = 0.0f;
        this.gzE = State.PAUSE;
        this.amP = true;
        this.gzF = 0.0f;
        this.gzG = 0.0f;
        this.gzH = 0.0f;
        this.gzI = 0L;
        this.lastStartTime = 0L;
        this.gzJ = 0L;
        this.gzK = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gzv = new Paint();
        this.gzw = new Paint();
        this.gzx = new Paint();
        this.gzz = new Paint();
        this.gzy = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gzv.setStyle(Paint.Style.FILL);
        this.gzv.setColor(Color.parseColor("#33aaff"));
        this.gzw.setStyle(Paint.Style.FILL);
        this.gzw.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gzx.setStyle(Paint.Style.FILL);
        this.gzx.setColor(Color.parseColor("#FFFFFF"));
        this.gzz.setStyle(Paint.Style.FILL);
        this.gzz.setColor(Color.parseColor("#e53917"));
        this.gzy.setStyle(Paint.Style.FILL);
        this.gzy.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gzD = displayMetrics.widthPixels / 15000.0f;
        this.gzH = this.gzD;
    }

    public void setListener(a aVar) {
        this.gzu = aVar;
    }

    /* loaded from: classes2.dex */
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
        if (this.ccS == 0) {
            this.ccS = System.currentTimeMillis();
        }
        if (this.gzK == 0) {
            this.gzK = getHeight();
        }
        this.gzA = (float) this.gzK;
        this.gzB = (float) ((this.gzK * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gzF = 0.0f;
        if (!this.gzC.isEmpty()) {
            Iterator<Integer> it = this.gzC.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gzJ = intValue;
                float f = this.gzF;
                this.gzF += ((float) (intValue - j)) * this.gzD;
                float f2 = this.gzF - this.gzB;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gzK - 1), this.gzv);
                canvas.drawRect(f2, 0.0f, this.gzF, (float) (this.gzK - 1), this.gzx);
                j = intValue;
            }
            if (this.gzC.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gzD, 0.0f, this.gzA + (this.gzD * 3000.0f), (float) (this.gzK - 1), this.gzw);
            }
        } else {
            canvas.drawRect(3000.0f * this.gzD, 0.0f, this.gzA + (this.gzD * 3000.0f), (float) (this.gzK - 1), this.gzw);
        }
        if (this.gzE == State.ROLLBACK) {
            canvas.drawRect(this.gzF - (((float) (this.gzJ - this.lastStartTime)) * this.gzD), 0.0f, this.gzF, (float) this.gzK, this.gzz);
        }
        if (this.gzE == State.START) {
            this.gzG += this.gzH * ((float) (currentTimeMillis - this.ccS));
            float f3 = this.gzF + this.gzG;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gzF, 0.0f, this.gzG + this.gzF, (float) (this.gzK - 1), this.gzv);
            } else {
                canvas.drawRect(this.gzF, 0.0f, getMeasuredWidth(), (float) (this.gzK - 1), this.gzv);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gzK) + (f3 - 5.0f), (float) (this.gzK - 1), this.gzy);
            if (this.gzu != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gzu.uD(this.mProgress);
                }
            }
        } else {
            if (this.gzu != null) {
                int measuredWidth2 = (int) ((this.gzF / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gzu.uD(this.mProgress);
                }
            }
            if (this.gzI == 0 || currentTimeMillis - this.gzI >= 800) {
                this.amP = !this.amP;
                this.gzI = System.currentTimeMillis();
            }
            if (this.amP) {
                canvas.drawRect(this.gzF - 5.0f, 0.0f, ((float) this.gzK) + (this.gzF - 5.0f), (float) (this.gzK - 1), this.gzy);
            }
        }
        this.ccS = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gzE = state;
        if (state != State.START) {
            this.gzG = this.gzH;
        }
        if (state == State.DELETE && this.gzC != null && !this.gzC.isEmpty()) {
            this.gzC.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gzE;
    }

    public void uC(int i) {
        this.gzC.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gzC == null || this.gzC.isEmpty()) {
            return 0;
        }
        return this.gzC.getLast().intValue();
    }

    public boolean bxh() {
        return this.gzC.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gzC;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gzC = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gzK = i;
    }

    public void reset() {
        this.gzC.clear();
        this.gzE = State.PAUSE;
        this.gzC.clear();
        this.gzF = 0.0f;
        this.ccS = 0L;
        this.lastStartTime = 0L;
        this.gzJ = 0L;
        this.mProgress = 0;
        this.gzI = 0L;
    }
}
